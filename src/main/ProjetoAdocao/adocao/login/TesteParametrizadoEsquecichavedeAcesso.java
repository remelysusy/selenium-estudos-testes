package adocao.login;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



@RunWith(Parameterized.class)
public class TesteParametrizadoEsquecichavedeAcesso {
	private WebDriver driver;
	private TeladeLoginpage page;

	@Parameter
	public String CpfRecuperar;
	@Parameter(value = 1)
	public String mensagem;
    @Parameter(value = 2)
	public boolean verificaTituloDaPagina;
	
	
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		page = new TeladeLoginpage(driver);
		// driver.get("http://adocao.tjmt.jus.br");
		driver.get(" http://adocao-teste.tjmt.jus.br");
	}
	
	

	@After
	public void finaliza() {
		driver.quit();
	}
	
	

	@Parameters
	public static Collection<Object[]> getCollection() {

		return Arrays.asList(new Object[][] { 
			{"61616991178", "Enviamos-lhe um email com a sua chave de acesso ao sistema", true}, 
			{"61616991177", "CPF Inválido", false},

		});
	}

	/*******************************
	 * ESQUECI MINHA CHAVE DE ACESSO - CPF VALIDO  e CPF INVALIDO
	 *************************************/

	
	@Test
	public void EsqueciMinhaChaveAcesso() throws InterruptedException {

		page.linkEsqueciSenha();

		Thread.sleep(2000);

		page.digitarCpfRecuperarSenha(CpfRecuperar);

		page.BotaoEnviarRecuperarSenha();

		Thread.sleep(2000);

		
		if (verificaTituloDaPagina== false)
			
		      Assert.assertTrue(page.obterMensagemDeEnvioDeSenha().contains(mensagem));
		else
		      Assert.assertTrue(page.obterMensagemDeCpfErrado().contains(mensagem));
	}

}
