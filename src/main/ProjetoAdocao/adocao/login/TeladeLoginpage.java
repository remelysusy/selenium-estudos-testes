package adocao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Compartilhado.DSL;



public class TeladeLoginpage {

	private DSL dsl;

	public TeladeLoginpage(WebDriver driver) {
		dsl = new DSL(driver);

	}

	/***********************
	 * PRIMEIRO LOGIN - TELA SOU CADASTRADO
	 **********************************/


	public void SetCpfLogin(String cpf) {
		dsl.Escreve(By.xpath("//*[@id=\"formLogin\"]/div[1]/input"), cpf);

	}

	public void SetChaveAcesso(String chaveAcesso) {
		dsl.Escreve(By.xpath("/html/body/div[1]/div/div[2]/div[3]/section/form/div[2]/input"), chaveAcesso);

	}

	public void BotaoParaEntrarLogin() {

		dsl.ClicarBotao(By.xpath("/html/body/div[1]/div/div[2]/div[3]/section/form/div[4]/button"));

	}

	public String obterTituloDaTelaInicial() {
		return dsl.obterConteudo(By.className("topo-container"));

	}

	/**** AssertqueRetornaValidacaodosDadosInseridosNoLogin ****/

	public String obterAlertaDeDadosErrado() {
		return dsl.obterConteudo(By.xpath("//*[@id=\"modal-2\"]/div/div"));
	}

	/**** EsqueciMinhaChaveAcesso ****/

	public void linkEsqueciSenha(){
		dsl.ClicarBotao(By.xpath("//*[@id=\"formLogin\"]/div[3]/a"));

	}

	public void digitarCpfRecuperarSenha(String CPfEnviarSenha) {

		dsl.Escreve(By.xpath("//*[@id=\"modal-recuperar-chave-acesso\"]/div/form/div/div[2]/div[1]/input"),CPfEnviarSenha);
	}
	
	public void BotaoEnviarRecuperarSenha(){
		dsl.ClicarBotao(By.xpath("//*[@id=\"modal-recuperar-chave-acesso\"]/div/form/div/div[3]/button"));
	}
	
	public String obterMensagemDeEnvioDeSenha() {
		return dsl.obterConteudo(By.xpath("//*[@id=\"modal-container\"]"));

	}
	
	
	/**** EsqueciMinhaChaveAcesso - CPF INVALID ****/
	
	public String obterMensagemDeCpfErrado() {
		return dsl.obterConteudo(By.xpath("//*[@id=\"modal-container\"]"));

	}
}
	
	


