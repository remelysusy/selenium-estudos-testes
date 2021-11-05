package adocao.cadastro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Compartilhado.DSL;



public class CadastroAdocaopage {

	private DSL dsl;

	public CadastroAdocaopage(WebDriver driver) {
		dsl = new DSL(driver);

	}

	/**************
	 * PRIMEIRO LOGIN PELA TELA "NÃO SOU CADASTRADO"
	 *******************************/

	public void SetCpfCadastro(String cpf) {
		dsl.Escreve(By.id("cpfNaoCadastrado"), cpf);

	}

	public void SetEmailGerado(String EmailGerado) {
		dsl.Escreve(By.id("emailNaoCadastrado"), EmailGerado);
	}

	public void BotaoCadastrar() {
		dsl.ClicarBotao(By.xpath("//*[@id=\"form-cadastrar\"]/div[3]/button"));
	}

	public String obterTituloInicial() {
		return dsl.obterConteudo(By.className("title-container"));
	}

	/**************
	 * ESTE ALERTA APARECE NA TELA DE CADASTRO, QUANDO O PRETENDENTE JÁ ESTÁ
	 * CADASTRADO
	 *******************/

	public String AlertaModalJaCadastrado() {
		return dsl.obterConteudo(By.id("modal-container"));
	}
}
