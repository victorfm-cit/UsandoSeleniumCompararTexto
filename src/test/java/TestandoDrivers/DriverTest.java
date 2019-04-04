package TestandoDrivers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;


public class DriverTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    /**
     * Está configurado que antes de cada teste é preciso iniciar o driver do navegador e
     * dizemos onde ele está, o wait diz quanto tempo eu espero por uma ação, o get
     * diz qual página da web estamos testando e depois maximizamos a janela do navegador.
     */

    @Before
    public void before() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://docs.seleniumhq.org/");
        driver.manage().window().maximize();
    }


    /**
     * Esta parte também é bem intuitiva. Após cada teste deverá fechar a janela do navegador.
     */
    @After
    public void after() {
        driver.quit();
    }

    /**
     * Aqui vamos apenas abrir o navegador,
     * um pequeno ato para a automação, mas um grande avanço para o automatizador!
     */

    @Test
    public void comecandoOTesteAutomatizado() {
        String valorEsperado = "What is Selenium?";
        String valorEncontrado = driver.findElement(By.cssSelector("#mainContent > h2:nth-child(1)")).getText();

        assertEquals("falhou", valorEncontrado, valorEsperado);

    }

}



