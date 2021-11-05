package adocao.login;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TeladeLogin {

	private WebDriver driver;
	private TeladeLoginpage page;

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

	/***********************
	 * PRIMEIRO LOGIN - TELA SOU CADASTRADO
	 **********************************/

	@Test
	public void SouCadastrado() throws InterruptedException {

		page.SetCpfLogin("36712650003");
		page.SetChaveAcesso("sdads22");
		page.BotaoParaEntrarLogin();

		Thread.sleep(5000);
		Assert.assertTrue(page.obterTituloDaTelaInicial().contains("ACOMPANHAMENTO DE CADASTRO"));
	}

	/***********************
	 * LOGIN PARA VALIDACAO DOS CAMPOS DA TELA - DADOS ERRADOS
	 **********************************/

	@Test
	public void ValidarDadosInseridosNoLogin() throws InterruptedException {

		page.SetCpfLogin("36712650003");
		page.SetChaveAcesso("vbgf0418");
		page.BotaoParaEntrarLogin();

		Thread.sleep(5000);
		Assert.assertTrue(page.obterAlertaDeDadosErrado().contains("Dados informados est�o incorretos"));
	}

	/*******************************
	 * ESQUECI MINHA CHAVE DE ACESSO - CPF VALIDO
	 *************************************/

	@Test
	public void EsqueciMinhaChaveAcesso() throws InterruptedException {

		page.linkEsqueciSenha();

		Thread.sleep(2000);
		
		page.digitarCpfRecuperarSenha("36712650003");
		
	    page.BotaoEnviarRecuperarSenha();
	    
		Thread.sleep(2000);

		Assert.assertTrue(page.obterMensagemDeEnvioDeSenha().contains("Enviamos-lhe um email com a sua chave de acesso ao sistema."));

	}
	
	
	/*******************************
	 * ESQUECI MINHA CHAVE DE ACESSO - CPF INVALIDO
	 *************************************/

	@Test
	public void EsqueciMinhaChaveAcessoCpfInvalid() throws InterruptedException {

		page.linkEsqueciSenha();

		Thread.sleep(2000);
		
		page.digitarCpfRecuperarSenha("36712650003");
		
	    page.BotaoEnviarRecuperarSenha();
	    
		Thread.sleep(2000);

		Assert.assertTrue(page.obterMensagemDeCpfErrado().contains("CPF Inv�lido"));

	}


}
