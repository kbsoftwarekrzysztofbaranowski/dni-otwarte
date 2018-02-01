import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.ie.InternetExplorerDriver

def driverInstance

driver = {

    switch (System.getProperty("geb.browser")) {
        case "chrome":
            Map<String, Object> prefs = new HashMap<String, Object>();

            prefs.put("profile.default_content_setting_values.notifications",  2)
            prefs.put("profile.default_content_settings.popups", 0)
            prefs.put("download.prompt_for_download", false)

            ChromeOptions options = new ChromeOptions()
            options.setExperimentalOption("prefs", prefs)
            options.addArguments("--disable-notifications")
            options.addArguments("--disable-extensions")
            options.addArguments("--disable-print-preview")
//                options.addArguments("--window-size=1280,800")
//                options.addArguments("--start-fullscreen")

            System.setProperty('webdriver.chrome.driver', 'src/binary/Chrome/chromedriver.exe')
            driverInstance = new ChromeDriver(options)
            break
        case "firefox":
            FirefoxOptions options = new FirefoxOptions()
            options.addArguments()
            System.setProperty('webdriver.gecko.driver', 'src/binary/Firefox/geckodriver.exe')
            driverInstance = new FirefoxDriver()
            break
        case "ie":
            System.setProperty('webdriver.ie.driver', 'src/binary/IE/IEDriverServer.exe')
            driverInstance = new InternetExplorerDriver()
            break

    }
    driverInstance.manage().window().maximize()
    driverInstance
}

waiting {
    timeout = 10
}