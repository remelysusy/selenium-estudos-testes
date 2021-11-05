package adocao.ficha;

//import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Fichadeadocao {

	private WebDriver driver;
	private FichadeadocaoPage page;

	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		page = new FichadeadocaoPage (driver);
		driver.get("http://adocao.tjmt.jus.br");
		//driver.get(" http://adocao-teste.tjmt.jus.br");
	}

// @After
//  public void finaliza() {
//       driver.quit();
//    }

	@Test
	public void PedidodeAdocao() throws InterruptedException {

		
		/***********************
		 * CODIGO DA TELA INICIAL
		 **********************************/
		page.SetCpfLogin("61616991178");
		page.SetChaveAcesso("ipyy0418");
		page.BotaoParaEntrarLogin();
		
		// VALIDACAO DA TELA INICIAL

		Thread.sleep(5000);
		Assert.assertTrue(page.obterTituloDaTelaInicial().contains("ACOMPANHAMENTO DE CADASTRO"));
		
		
		/***********************
		 * CODIGO DA FICHA DE PRETENDENTES 
		 **********************************/
		// VALIDACAO DO NOME DA TELA DO CADASTRO DO PRETENDENTE
		
		page.BotaoComecarCadastro();
		Thread.sleep(6000);
		Assert.assertTrue(page.obterTituloDaTelaFichaCadastroPretendente().contains("CADASTRO DE PRETENDENTES"));

		
		
		/***********************
		 * CODIGO DA FICHA DE PRETENDENTE- ABA DADOS PESSOAIS DO CONJUGE
		 **********************************/
		//VALIDACAO DA ABA DADOS PESSOAIS DO PRIMEIRO PRETENDENTE
		
		Thread.sleep(2000);
		page.setnomePretendente("Aline Coimbra De vagas");
	    page.setSexoFeminino();
	    Thread.sleep(2000);
	    
		page.setEstadoCivildoPretendente("Casado(a)");
		page.setEtniaParda();
		page.setRgPretendente ("316164951");
		page.setOrgaoEmissorPretendente("SSP/MT");
		page.setComboNacionalidadePretendente("Brasileiro(a)");
		page.selecionarsetComboEstadoOrigemPretendente("MT");
		page.setcidadeOrigemPretendente("1");// ACORIZAL
		page.setDatadeNascimentoPretendente("20121989");
		page.setNomedaMaePretendente("Valentina Isabel Manuela");
		page.setNomedaPaiPretendente("joaquim Geraldo Ferreira");
		page.setNivelEscolariedadePretendente("3");//ENSINO FUNDAMENTAL COMPLETO
		page.setProfissaoPrincipalPretendente("1");//EMPREGADO DE EMPRESA DO SETOR PRIVADO
		page.setFaixaSalarialPretendente("3");//AT� 1 2 A 1 DE SALARIO MINIMO
		page.setQuantidadeFilhosBiologicoNao();// OPCAO NAO
		page.setSimFilhosAdotivos();// OPCAO SIM
		Thread.sleep(2000);
		
		page.setValordeQuantosFilhosAdotivos("2");
		page.setGrupodeAdocaoNao();// OPCAO NAO
	    page.BotaoSalvarContinuar1();// BOTAO SALVAR E CONTINUAR PARA ABA DADOS PESSOAIS DO CONJUGE
	   
	    
	    /***********************
		 * CODIGO DA FICHA DE PRETENDENTE- ABA DADOS PESSOAIS DO CONJUGE
		 **********************************/
		//VALIDACAO DO TITULO DA ABA DADOS PESSOAIS DO PRETENDENTE/ CONJUGE
		
	    
	    Thread.sleep(3000);
		Assert.assertTrue(page.VerificarSeAbaDadosPessoaisdoPretendenteeConjugeEstaSelecionada());
		
		//VALIDACAO DOS CAMPOS HA CONJUGE? MAIS APENAS EM RELACAO A OP�AO NAO
		page.setHaconjugeNao();
		page.BotaoSalvarContinuar1();//BOT�O SALVAR E CONTINUAR PARA ABA ENDERE�O
		
		
		
		
		/***********************
		 * CODIGO DA FICHA DE PRETENDENTE- ABA ENDERE�O
		 **********************************/
		//VALIDACAO DO TITULO DA ABA ENDERE�O
		
		
		Thread.sleep(3000);
		Assert.assertTrue(page.VerificarSeAbaEnderecoEstaSelecionada());
		
		//VALIDACAO DOS CAMPOS  DA ABA ENDERE�O
		
		// CAMPO CEP RESIDENCIAL DO PRETENDENTE E CONJUGE
		page.setEnderecoDoPretendenteConjuge("78050-532");
		
		//CIDADE - CAMPO � PREENCHIDO AUTOM�TICAMENTE PELO CEP.
		
		Thread.sleep(4000);
		
		// CAMPO LOGRADOURO DO PRETENDENTE E CONJUGE
    	page.setLogradouroEndereco(" Rua 5 N 509 ");
    	
    	// CAMPO BAIRRO DO PRETENDENTE E CONJUGE
		page.setBairroEndereco("Coxip�");
		
		//VALIDACAO DOS CAMPOS DO ENDERE�O PROFISSIONAL
		page.setEnderecoProfissionalSim();
		
	    // CAMPO NOME DA EMPRESA QUE TRABALHA O PRETENDENTE 
		page.setNomeDaEmpressaqueTrabalhaPretendente("Dibox");
		
		//  CAMPO CEP DA EMPRESA 
		page.setCepDaEmpressaqueTrabalhaPretendente("78050-532");
		
		Thread.sleep(3000);
		
		// CAMPO CIDADE ONDE FICA A EMPRESA
		page.setSelecionarCidadedaEmpresa("1325");
		
		//CAMPO LOGRADOURO DA EMPRESA
		page.setLougradourodoenderecoProfissional("Rua Monsenhor Andr� Elias Kirche");
		
		//CAMPO BAIRRO ONDE A EMPRESA ESTA LOCALIZADA
		page.setSelecionarBairroDaEmpresa("CPA");
		
		//BOT�O SALVAR E SEGUIR PARA ABA CONTATO
		page.BotaoSalvarContinuar1();
		
	   //VALIDA�AO DO TITULO A ABA CONTATO
		Thread.sleep(3000);
		Assert.assertTrue(page.VerificarSeAbaContatoEstaSelecionada());
	}

	
}
