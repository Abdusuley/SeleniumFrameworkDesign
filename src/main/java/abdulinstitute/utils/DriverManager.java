package abdulinstitute.utils;


import org.openqa.selenium.WebDriver;

/**
 * Thread-safe WebDriver manager.
 * 
 * Responsibilities:
 *  - Store WebDriver per thread
 *  - Provide access to the current thread's driver
 *  - Clean up after test execution
 *
 * Designed for:
 *  - Parallel TestNG execution
 *  - Jenkins CI
 *  - Selenium 4
 */
public final class DriverManager {

    // Prevent instantiation
    private DriverManager() {}

    // ThreadLocal ensures one WebDriver per thread
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Returns the WebDriver instance for the current thread.
     *
     * @return WebDriver for current test thread
     */
    public static WebDriver getDriver() {
        return driver.get();
    }

    /**
     * Stores the WebDriver instance for the current thread.
     *
     * @param webDriver the WebDriver to associate with this thread
     */
    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    /**
     * Removes the WebDriver instance for the current thread.
     * Must be called after driver.quit() to prevent memory leaks.
     */
    public static void unload() {
        driver.remove();
    }
}
