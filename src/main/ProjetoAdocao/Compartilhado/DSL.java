package Compartilhado;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {

    private WebDriver driver;

    /** CONSTRUTOR **/

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    /** TextField e TextArea **/
    public void Escreve(By by, String nome) {
        driver.findElement(by).clear(); /* METODO LIMPA O CAMPO E PERMITE RESCREVER NOVAMENTE SOBRE O CAMPO */
        driver.findElement(by).sendKeys(nome);
    }

    public String obterConteudo(By by) {
        return driver.findElement(by).getText();
    }

    public String obterValorCampo(By by) {
        return driver.findElement(by).getAttribute("value");
    }

    /** COMBO **/
    public void selecionarCombo(By by, String valor) {
        Select combo = new Select(driver.findElement(by));
        combo.selectByVisibleText(valor);

    }
    
    
    /** COMBO VALOR**/
    public void selecionarComboPorValor(By by, String valor) {
        Select combo = new Select(driver.findElement(by));
        combo.selectByValue(valor);

    }
    
    /** COMBO - LISTA **/
    public List<WebElement> obterValorCombo(By by) {
        Select combo = new Select(driver.findElement(by));
        return combo.getOptions();
    }

    /** BOTAO **/
    public void ClicarBotao(By by) {
        driver.findElement(by).click();
    }

    /** TITULO **/
    public String pegarTitulo() {
        return driver.getTitle();

    }
    
    
    /**RADIOBUTTON**/
    
    public void ClicarRadioButton(By by) {
        driver.findElement(by).click();
    }
    
    
   /**ASSERT DO RADIOBUTTON**/
    public boolean isRadioMarcado(String id) {
        return driver.findElement(By.id(id)).isSelected();
    }
    
    /**ASSERT PARA TIPO DE CLASSES DISABLE E ACTIVE**/
    public boolean VerificaSeOElementoTemUmaDeterminadaClasse(By by, String valor) {
    	WebElement elemento = driver.findElement(by);   
    	String classes = elemento.getAttribute("class");
    	return (classes.indexOf(valor) > -1);
    }
}