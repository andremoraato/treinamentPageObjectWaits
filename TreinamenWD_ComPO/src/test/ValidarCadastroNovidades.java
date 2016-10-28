package test;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import inicializar.PaginaBase;
import pageObject.ValidarCadastroNovidadesPage;

public class ValidarCadastroNovidades 
{
	protected PaginaBase paginaBase;
	protected ValidarCadastroNovidadesPage valida;
	WebDriver driver;
	
	public ValidarCadastroNovidades () {
		this.paginaBase = new PaginaBase();
		this.driver = this.paginaBase.getDriver();
		this.valida = new ValidarCadastroNovidadesPage(driver);
	}
	
	@Before
	 public void setUp()
	 {
	  paginaBase.navegateTo("http://www.taketest.com.br/");
	 }
	

	@Test 
	public void validarCadastroSucces() 
	{
		// Preencher Valores
		valida.insereValor("teste", "teste@teste.com");
		valida.waitElements("//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ok']");// Tempo para espera da mensagem de validação
			
		//Validar mensagem de sucesso
		valida.assertMessage("Sua mensagem foi enviada com sucesso. Obrigado.");
	}
		
	@After
	public void fecharPagina()
	{
		paginaBase.closeNavegator();
	}
}
