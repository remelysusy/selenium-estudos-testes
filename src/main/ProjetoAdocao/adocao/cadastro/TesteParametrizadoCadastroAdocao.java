package adocao.cadastro;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

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
public class TesteParametrizadoCadastroAdocao {
	private WebDriver driver;
	private CadastroAdocaopage page;

	@Parameter
	public String cpf;
	@Parameter(value = 1)
	public String email;
	@Parameter(value = 2)
	public String mensagem;
	@Parameter(value = 3)
	public boolean verificaTituloDaPagina;

	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		page = new CadastroAdocaopage(driver);
		// driver.get("http://adocao.tjmt.jus.br");
		driver.get(" http://adocao-teste.tjmt.jus.br");
	}

	@After
	public void finaliza() {
		driver.quit();
	}

	@Parameters
	public static Collection<Object[]> getCollection() {

		Random numeroRandomico = new Random();

		return Arrays.asList(new Object[][] {

				{ "36712650003", "remelysusy@hotmail.com", "Este CPF j� est� cadastrado, fa�a login no sistema para continuar!",
						false },
				// 01
				{ "08080809809", "teste@teste.com", "CPF Inv�lido", false },
				// 02
				{ "00635622190", "emailteste_" + Math.abs(numeroRandomico.nextInt()) + "@gmail.com",
						"ACOMPANHAMENTO DE CADASTRO", true },
				// 03
				{ "80091310083", "emailteste_" + Math.abs(numeroRandomico.nextInt()) + "@hotmail.com",
						"ACOMPANHAMENTO DE CADASTRO", true },
				// 04
				{ "67405060005", "emailteste_" + Math.abs(numeroRandomico.nextInt()) + "@tjmt.jus.br",
						"ACOMPANHAMENTO DE CADASTRO", true },
				// 05
				{ "54963547066", "emailteste_" + Math.abs(numeroRandomico.nextInt()) + "@terra.com.br",
						"ACOMPANHAMENTO DE CADASTRO", true },
				// 06
		});
	}

	@Test
	public void ValidarRegra() throws InterruptedException {
		page.SetCpfCadastro(cpf);
		page.SetEmailGerado(email);

		page.BotaoCadastrar();
		Thread.sleep(5000);

		if (verificaTituloDaPagina == false)
			Assert.assertTrue(page.AlertaModalJaCadastrado().contains(mensagem));
		else
			Assert.assertTrue(page.obterTituloInicial().contains(mensagem));
	}

}
