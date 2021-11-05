package adocao.cadastro;

import java.util.Random;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CadastroAdocao {

	private WebDriver driver;
	private CadastroAdocaopage page;

	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.get("http://adocao.tjmt.jus.br");
		page = new CadastroAdocaopage(driver);
		// driver.get(" http://adocao-teste.tjmt.jus.br");
	}

	@After
	public void finaliza() {
		driver.quit();
	}

	/**************
	 * CADASTRO E PRIMEIRO LOGIN
	 *******************************/

	@Test
	public void CadastroUsuario() throws InterruptedException {

		Random numeroAleatorio = new Random();
		page.SetCpfCadastro("36712650003");
		page.SetEmailGerado("emailteste_" +  Math.abs(numeroAleatorio.nextInt()) + "@gmail.com");
		page.BotaoCadastrar();

		Thread.sleep(5000);

		Assert.assertTrue(page.obterTituloInicial().contains("ACOMPANHAMENTO DE CADASTRO"));
	}

	/**************
	 * ESTE ALERTA APARECE NA TELA DE CADASTRO.
	 * O PRETENDENTE J� EST� CADASTRADO.
	 *******************/

	@Test
	public void MensagemUsuarioJ�Cadastrado() throws InterruptedException {

		page.SetCpfCadastro("36712650003");
		page.SetEmailGerado("remelysusy@hotmail.com");
		page.BotaoCadastrar();
		
		Thread.sleep(5000);

		Assert.assertTrue(page.AlertaModalJaCadastrado().contains("Este email j� est� cadastrado, por favor utilize outro!"));

	}

}
