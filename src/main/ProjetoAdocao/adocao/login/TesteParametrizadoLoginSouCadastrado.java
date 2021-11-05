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
public class TesteParametrizadoLoginSouCadastrado {
	private WebDriver driver;
	private TeladeLoginpage page;

	@Parameter
	public String cpf;
	@Parameter(value = 1)
	public String ChaveAcesso;
	@Parameter(value = 2)
	public String mensagem;
	@Parameter(value = 3)
	public boolean verificaTituloDaPagina;

	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		page = new TeladeLoginpage(driver);
		//driver.get("http://adocao.tjmt.jus.br");
		driver.get(" http://adocao-teste.tjmt.jus.br");
	}

	@After
	public void finaliza() {
		driver.quit();
	}

	@Parameters
	public static Collection<Object[]> getCollection(){

		return Arrays.asList(new Object[][] { 
			{"61616991178", "ipyy0418", "ACOMPANHAMENTO DE CADASTRO", true },
			{"36712650003 ","vbgf0418", "ACOMPANHAMENTO DE CADASTRO", true },
			{"61616991175", "ipyy0419", "Dados informados est�o incorretos",false},
			
		});
	}
	
	
	
	@Test
	public void SouCadastrado() throws InterruptedException {

		page.SetCpfLogin(cpf);
		page.SetChaveAcesso(ChaveAcesso);
		page.BotaoParaEntrarLogin();

		Thread.sleep(5000);
		
		if (verificaTituloDaPagina == false)
			Assert.assertTrue(page.obterAlertaDeDadosErrado().contains(mensagem));
		else
			Assert.assertTrue(page.obterTituloDaTelaInicial().contains(mensagem));
	}

}