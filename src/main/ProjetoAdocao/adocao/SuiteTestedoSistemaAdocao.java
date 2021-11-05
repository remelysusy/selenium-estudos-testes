

package adocao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import adocao.cadastro.TesteParametrizadoCadastroAdocao;
import adocao.login.TesteParametrizadoEsquecichavedeAcesso;
import adocao.login.TesteParametrizadoLoginSouCadastrado;

@RunWith(Suite.class)
@SuiteClasses({ TesteParametrizadoLoginSouCadastrado.class,TesteParametrizadoEsquecichavedeAcesso.class, TesteParametrizadoCadastroAdocao.class,  })


public class SuiteTestedoSistemaAdocao {

}

/***************************************************/

//1- Teste do login para cadastro
//2- Validacao do alerta de dados errado


/***************************************************
TesteParametrizadoEsquecichavedeAcesso

***************************************************/

//3- Esqueci minha chave - caminho feliz
//4- Esqueci minha chave - caminho infeliz



/***************************************************
* 
* TesteParametrizadoCadastroAdocao:

***************************************************/
//1- teste do cadastro e ao mesmo tempo do primeiro login ao sistema.
//2- Teste do alerta que aparece quando o usuario já está cadastrado



