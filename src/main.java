import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class main {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kater\\Desktop\\Automation\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Welcome to Duotify!";
        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement signup = driver.findElement(By.id("hideLogin"));
        signup.click();
        Thread.sleep(1000);

        WebElement userName = driver.findElement(By.id("username"));
        String uName=userNameRandom();
        userName.sendKeys(uName);

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Jane");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Smith");

        WebElement email = driver.findElement(By.id("email"));
        String emailConfirmEmail=emailRandom();
        email.sendKeys(emailConfirmEmail);

        WebElement confirmEmail = driver.findElement(By.id("email2"));
        confirmEmail.sendKeys(emailConfirmEmail);

        WebElement password = driver.findElement(By.id("password"));
        String pass="Jana123456";
        password.sendKeys(pass);

        WebElement confirmPassword = driver.findElement(By.id("password2"));
        confirmPassword.sendKeys(pass);
        Thread.sleep(1000);

        WebElement registerButton = driver.findElement(By.name("registerButton"));
        registerButton.click();
        Thread.sleep(1000);

        String url=driver.getCurrentUrl();
        String expectedUrl="http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?";
        Assert.assertEquals(url,expectedUrl);
        Thread.sleep(1000);

        WebElement firstAndLastName = driver.findElement(By.id("nameFirstAndLast"));
        firstAndLastName.click();
        Assert.assertEquals(firstAndLastName.getText(),"Jane Smith");
        Thread.sleep(1000);

        WebElement userInfo=driver.findElement(By.className("userInfo"));
        Assert.assertEquals(userInfo.getText(),"Jane Smith");
        Thread.sleep(1000);

        WebElement logOut= driver.findElement(By.id("rafael"));
        logOut.click();
        Thread.sleep(1000);

        String logOutUrlActual=driver.getCurrentUrl();
        String logOutUlrExpected="http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php";
        Assert.assertEquals(logOutUrlActual,logOutUlrExpected);
        Thread.sleep(1000);

        WebElement loginUserName=driver.findElement(By.id("loginUsername"));
        loginUserName.sendKeys(uName);
        Thread.sleep(1000);

        WebElement loginPassword=driver.findElement(By.id("loginPassword"));
        loginPassword.sendKeys(pass);
        Thread.sleep(1000);

        WebElement logIn=driver.findElement(By.name("loginButton"));
        logIn.click();
        Thread.sleep(1000);

        WebElement pageHead=driver.findElement(By.className("pageHeadingBig"));
        String pageHeadActual=pageHead.getText();
        String pageHeadExpected="You Might Also Like";
        Assert.assertEquals(pageHeadActual,pageHeadExpected);

        WebElement nameFirstAndLast=driver.findElement(By.id("nameFirstAndLast"));
        nameFirstAndLast.click();
        Thread.sleep(1000);
        WebElement out= driver.findElement(By.id("rafael"));
        out.click();

        driver.quit();


    }
        public static String userNameRandom(){
        int i=8;
            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
            StringBuilder sb = new StringBuilder(i);

            for (int j = 0; j < i; j++) {
                int index = (int) (AlphaNumericString.length() * Math.random());
                sb.append(AlphaNumericString.charAt(index));
            }
                return sb.toString();
        }
    public static String emailRandom(){
        int i=5;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(i);

        for (int j = 0; j < i; j++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString()+"@gmail.com";
    }




}
