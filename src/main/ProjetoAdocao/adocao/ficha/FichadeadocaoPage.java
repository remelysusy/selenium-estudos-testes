package adocao.ficha;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import Compartilhado.DSL;

public class FichadeadocaoPage {

	private DSL dsl;

	public FichadeadocaoPage(WebDriver driver) {
		dsl = new DSL(driver);

	}

	/***********************
	 * CODIGO DA TELA DE LOGIN
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

	/***********************
	 * CODIGO DA FICHA DE PRETENDENTE - DADOS PESSOAIS DO PRIMEIRO PRETENDENTE
	 **********************************/

	// BOTÃO COMEÇAR CADASTRO
	public void BotaoComecarCadastro() {

		dsl.ClicarBotao(By.xpath("//*[@id=\"home\"]/div[2]/div[3]/a"));

	}

	// AQUI REALIZA O ASSERT PARA SABER SE ESTÁ ABRINDO A TELA DO FORMULARIO
	public String obterTituloDaTelaFichaCadastroPretendente() {
		return dsl.obterConteudo(By.className("title-container"));

	}

	// CAMPO NOME COMPLETO - FORMULARIO
	public void setnomePretendente(String nomePretendente) {
		dsl.Escreve(By.xpath("//*[@id=\"nome\"]"), nomePretendente);

	}

	// CAMPO SELECIONAR SEXO - FORMULARIO

	public void setSexoMasculino() {
		dsl.ClicarRadioButton(By.id("sexo-primeiro-pretendente-masc"));
	}

	public void setSexoFeminino() {
		dsl.ClicarRadioButton(By.id("sexo-primeiro-pretendente-fem"));
	}

	// CAMPO SELECIONAR ESTADO CIVIL - FORMULARIO
	public void setEstadoCivildoPretendente(String Estadocivil) {
		dsl.selecionarCombo(By.id("estadoCivil"), Estadocivil);

	}

	// CAMPO SELECIONAR ETNIA - FORMULARIO

	public void setEtniaNegra() {
		dsl.ClicarRadioButton(By.id("etnia-pretendente-principal-1"));
	}

	public void setEtniaBranca() {
		dsl.ClicarRadioButton(By.id("etnia-pretendente-principal-2"));
	}

	public void setEtniaAmarela() {
		dsl.ClicarRadioButton(By.id("etnia-pretendente-principal-3"));
	}

	public void setEtniaIndigena() {
		dsl.ClicarRadioButton(By.id("etnia-pretendente-principal-4"));
	}

	public void setEtniaParda() {
		dsl.ClicarRadioButton(By.id("etnia-pretendente-principal-7"));
	}

	public void setEtniaIndefinida() {
		dsl.ClicarRadioButton(By.id("etnia-pretendente-principal-8"));
	}

	// CAMPO SELECIONAR RG DO PRETENDENTE - FORMULARIO
	public void setRgPretendente(String RgPretendente) {
		dsl.Escreve(By.id("RG"), RgPretendente);
	}

	// CAMPO SELECIONAR ORGAO EMISSOR - FORMULARIO
	public void setOrgaoEmissorPretendente(String OrgaoEmissorPretendente) {
		dsl.Escreve(By.id("RGOrgao"), OrgaoEmissorPretendente);
	}

	// CAMPO SELECIONAR NACIONALIDADE - FORMULARIO

	public void setComboNacionalidadePretendente(String naturalPretendente) {
		dsl.selecionarCombo(By.id("nacionalidade"), naturalPretendente);

	}

	// CAMPO SELECIONAR ESTADO DE ORIGEM - FORMULARIO

	public void selecionarsetComboEstadoOrigemPretendente(String EstadoOrigem) {
		dsl.selecionarComboPorValor(By.xpath("//*[@id=\"dados-pessoais-primeiro-pretendente\"]/div[6]/div[4]/select"),
				EstadoOrigem);
	}

	// CAMPO SELECIONAR CIDADE DE ORIGEM - FORMULARIO

	public void setcidadeOrigemPretendente(String cidadeOrigem) {
		dsl.selecionarComboPorValor(By.xpath("//*[@id=\"dados-pessoais-primeiro-pretendente\"]/div[6]/div[6]/select"),
				cidadeOrigem);

	}

	// CAMPO SELECIONAR DATA DE NASCIMENTO - FORMULARIO

	public void setDatadeNascimentoPretendente(String dataNascimento) {
		dsl.Escreve(By.xpath("//*[@id=\"dados-pessoais-primeiro-pretendente\"]/div[7]/div[2]/input"), dataNascimento);
	}
	// CAMPO SELECIONAR NOME DA MAE - FORMULARIO

	public void setNomedaMaePretendente(String NomeMaedoPretendente) {
		dsl.Escreve(By.id("NomeMaePrimeiroPretendente"), NomeMaedoPretendente);
	}

	// CAMPO SELECIONAR NOME DA PAI - FORMULARIO

	public void setNomedaPaiPretendente(String NomePaidoPretendente) {
		dsl.Escreve(By.id("NomePaiPrimeiroPretendente"), NomePaidoPretendente);
	}
	// CAMPO SELECIONAR NOME DA ESCOLARIDADE - FORMULARIO

	public void setNivelEscolariedadePretendente(String NivelEscolariedadePretendente) {
		dsl.selecionarComboPorValor(By.xpath("//*[@id=\"dados-pessoais-primeiro-pretendente\"]/div[10]/div[2]/select"),
				NivelEscolariedadePretendente);
	}

	// CAMPO SELECIONAR NOME DA PROFISSAO PRINCIPAL - FORMULARIO
	public void setProfissaoPrincipalPretendente(String ProfissãoPrincipalPretendente) {
		dsl.selecionarComboPorValor(By.xpath("//*[@id=\"dados-pessoais-primeiro-pretendente\"]/div[10]/div[4]/select"),
				ProfissãoPrincipalPretendente);
	}

	// CAMPO SELECIONAR A FAIXA SALARIAL - FORMULARIO
	public void setFaixaSalarialPretendente(String FaixaSalarialPretendente) {
		dsl.selecionarComboPorValor(By.xpath("//*[@id=\"dados-pessoais-primeiro-pretendente\"]/div[11]/div[2]/select"),
				FaixaSalarialPretendente);
	}

	// CAMPO SELECIONAR POSSUI FILHOS BIOLOGICO - FORMULARIO
	public void setQuantidadeFilhosBiologicoSim() {
		dsl.ClicarRadioButton(By.id("checkbox-possui-filho-biologico-sim"));
	}

	public void setQuantidadeFilhosBiologicoNao() {
		dsl.ClicarRadioButton(By.id("checkbox-possui-filho-biologico-nao"));
	}

	// CAMPO SELECIONAR POSSUI FILHOS ADOTIVOS - FORMULARIO
	public void setSimFilhosAdotivos() {
		dsl.ClicarRadioButton(By.id("checkbox-possui-filho-adotivos-sim"));
	}

	public void setNaoFilhosAdotivos() {
		dsl.ClicarRadioButton(By.id("checkbox-possui-filho-adotivos-nao"));
	}

	// CAMPO QUE RECEBE O VALOR DA QUANTIDADE DE FILHOS ADOTIVOS

	public void setValordeQuantosFilhosAdotivos(String nomePretendente) {
		dsl.Escreve(By.xpath("/html/body/div[1]/div[2]/div[2]/div[4]/div[1]/div[2]/div[13]/div[4]/input"),
				nomePretendente);

	}

	// CAMPO SELECIONAR GRUPO DE ADOCAO - FORMULARIO
	public void setGrupodeAdocaoNao() {
		dsl.ClicarRadioButton(By.id("checkbox-existe-grupo-adocao-nao"));
	}

	public void setGrupodeAdocaoSim() {
		dsl.ClicarRadioButton(By.id("checkbox-existe-grupo-adocao-sim"));
	}

	// BOTÃO COMEÇAR SALVAR E CONTINUAR DA ABA 1

	public void BotaoSalvarContinuar1() {
		dsl.ClicarBotao(By.xpath("//*[@id=\"home\"]/div[2]/div/button[2]"));

	}

	/***********************
	 * CODIGO DA FICHA DE PRETENDENTE- ABA DADOS PESSOAIS DO CONJUGE
	 **********************************/

	// VALIDAÇÃO DO TITULO DA SEGUNDA ABA - DADOS PESSOAIS DO PRETENDENTE CONJUGE

	public boolean VerificarSeAbaDadosPessoaisdoPretendenteeConjugeEstaSelecionada() {
		return dsl.VerificaSeOElementoTemUmaDeterminadaClasse(
				By.xpath("/html/body/div[1]/div[2]/div[2]/div[3]/ul/li[2]"), "active");
	}

	// CAMPO CHECK HÁ CONJUGE? SEGUNDA ABA

	public void setHaconjugeNao() {
		dsl.ClicarRadioButton(By.id("existe-segundo-pretendente-nao"));

	}

	public void setHaconjugeSim() {
		dsl.ClicarRadioButton(By.id("existe-segundo-pretendente-sim"));
	}

	// CAMPOS PARA QUANDO TEM UM CONJUGE

	// BOTÃO SALVAR CONTINUAR DA ABA 2

	public void BotaoSalvarContinuar2() {
		dsl.ClicarBotao(By.xpath("//*[@id=\"home\"]/div[2]/div/button[2]"));

	}

	/***********************
	 * CODIGO DA FICHA DE PRETENDENTE- ABA ENDEREÇO
	 **********************************/

	public boolean VerificarSeAbaEnderecoEstaSelecionada() {
		return dsl.VerificaSeOElementoTemUmaDeterminadaClasse(By.xpath("//*[@id=\"formulario-ceja\"]/div[3]/ul/li[3]"),
				"active disabled");
	}

	// CAMPO CEP RESIDENCIAL DO PRETENDENTE E CONJUGE

	public void setEnderecoDoPretendenteConjuge(String CepEnderecoDoConjuge) {
		dsl.Escreve(By.xpath("/html/body/div[1]/div[2]/div[2]/div[4]/div[1]/div[4]/div[1]/div[2]/div/span[2]/input"), CepEnderecoDoConjuge);
	}

	// CAMPO CIDADE DO PRETENDENTE E CONJUGE
	public void setSelecionaCidadeDoConjuge(String EnderecoDoConjugeDoPretendente) {
		dsl.selecionarComboPorValor(By.id("Cidade"), EnderecoDoConjugeDoPretendente);
	}

	// CAMPO LOGRADOURO DO PRETENDENTE E CONJUGE
	public void setLogradouroEndereco(String LougradouroDoPretendente) {
		dsl.Escreve(By.xpath("/html/body/div[1]/div[2]/div[2]/div[4]/div[1]/div[4]/div[1]/section/div[1]/span[2]/input"),
				LougradouroDoPretendente);
	}

	
	// CAMPO BAIRRO DO PRETENDENTE E CONJUGE
	public void setBairroEndereco(String BairroDoPretendente) {
		dsl.Escreve(By.xpath("/html/body/div[1]/div[2]/div[2]/div[4]/div[1]/div[4]/div[1]/section/div[2]/span[2]/input"), BairroDoPretendente);
	}
	
	//  CAMPO ENDEREÇO PROFISSIONAL
	public void seteEnderecoProfissionalNao() {
		dsl.ClicarBotao(By.id("has-endereco-profissional-nao"));

	}

	public void setEnderecoProfissionalSim() {
		dsl.ClicarBotao(By.id("has-endereco-profissional-sim"));
	}
	
   //  CAMPO NOME DA EMPRESA QUE TRABALHA O PRETENDENTE 
	public void setNomeDaEmpressaqueTrabalhaPretendente (String EnderecoProfissional) {
		dsl.Escreve(By.xpath("//*[@id=\"dados-endereco\"]/div[2]/div[2]/div[2]/div/span[2]/input"), EnderecoProfissional);
	}
	
	
   //  CAMPO CEP DA EMPRESA 
	public void setCepDaEmpressaqueTrabalhaPretendente(String CepEnderecoProfissional){
		dsl.Escreve(By.xpath("//*[@id=\"dados-endereco\"]/div[2]/div[2]/div[3]/div/span[2]/input"), CepEnderecoProfissional);
	}
	
	
   // CAMPO CIDADE ONDE FICA A EMPRESA
	public void setSelecionarCidadedaEmpresa(String CidadeEmpresaProfissionalEndereco){
		dsl.selecionarComboPorValor(By.id("Cidade"), CidadeEmpresaProfissionalEndereco);
	}
	
   //CAMPO LOGRADOURO DA EMPRESA
	public void setLougradourodoenderecoProfissional(String LougradourodoenderecoProfissional) {
		dsl.Escreve(By.xpath("//*[@id=\"dados-endereco\"]/div[2]/div[2]/div[5]/div[1]/span[2]/input"), LougradourodoenderecoProfissional);
	}
	
  //CAMPO BAIRRO ONDE A EMPRESA ESTA LOCALIZADA
	public void setSelecionarBairroDaEmpresa(String BairroEnderecoEmpresa) {
		dsl.Escreve(By.xpath("//*[@id=\"dados-endereco\"]/div[2]/div[2]/div[5]/div[2]/span[2]/input"), BairroEnderecoEmpresa);
	}
	
  //VALIDAÇAO DO TITULO A ABA CONTATO
	public boolean VerificarSeAbaContatoEstaSelecionada() {
		return dsl.VerificaSeOElementoTemUmaDeterminadaClasse(By.xpath("//*[@id=\"formulario-ceja\"]/div[3]/ul/li[4]"),
				"active disabled");
	}
	
}
