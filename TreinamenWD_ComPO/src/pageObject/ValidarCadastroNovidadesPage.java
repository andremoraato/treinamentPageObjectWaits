package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import inicializar.PaginaBase;

public class ValidarCadastroNovidadesPage extends PaginaBase {
	
	public ValidarCadastroNovidadesPage(WebDriver driver) {
		super(driver);
	}
	
	public void insereValor(String nome, String email) {
		getDriver().findElement(By.xpath("//input[@class='wpcf7-form-control wpcf7-text wpcf7-validates-as-required']")).sendKeys(nome);
		getDriver().findElement(By.xpath("//input[@class='wpcf7-form-control wpcf7-text wpcf7-email wpcf7-validates-as-required wpcf7-validates-as-email']")).sendKeys(email);		
		getDriver().findElement(By.xpath("//input[@class='wpcf7-form-control wpcf7-submit']")).click();
	}
	
	public void waitElements (String xpath){
		WebDriverWait wait = new WebDriverWait(getDriver(), 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void assertMessage (String text){
		Assert.assertEquals(text, getDriver().findElement(By.xpath("//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ok']")).getText());
	}


}
