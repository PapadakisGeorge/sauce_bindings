package com.saucelabs.saucebindings;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceSession {
    @Getter @Setter private DataCenter dataCenter = DataCenter.US_WEST;
    @Getter private final SauceOptions sauceOptions;
    @Setter private URL sauceUrl;

    @Getter private RemoteWebDriver driver;

    public SauceSession() {
        this(new SauceOptions());
    }

    public SauceSession(SauceOptions options) {
        sauceOptions = options;
    }

    public RemoteWebDriver start() {
        if(sauceOptions.visual() != null){
            driver = createRemoteWebDriver(getScreenerUrl(), sauceOptions.toCapabilities());
            getDriver().executeScript(
                    "/*@visual.init*/", sauceOptions.getName());
            return driver;
        }
        driver = createRemoteWebDriver(getSauceUrl(), sauceOptions.toCapabilities());
        return driver;
	}

    public URL getSauceUrl() {
        if (sauceUrl != null) {
            return sauceUrl;
        } else {
            try {
                return new URL(dataCenter.getValue());
            } catch (MalformedURLException e) {
                throw new InvalidArgumentException("Invalid URL");
            }
        }
    }
    public URL getScreenerUrl() {
        try {
            setSauceUrl(new URL("https://hub.screener.io/wd/hub"));
            return sauceUrl;
        } catch (MalformedURLException e) {
            throw new InvalidArgumentException("Invalid URL");
        }
}

    protected RemoteWebDriver createRemoteWebDriver(URL url, MutableCapabilities capabilities) {
        return new RemoteWebDriver(url, capabilities);
    }

    public void stop(Boolean passed) {
        String result = passed ? "passed" : "failed";
        stop(result);
    }

    public void stop(String result) {
        if(sauceOptions.visual() != null){
            updateVisualResult();
        }
        else{
            updateSauceResult(result);
        }
        stop();
    }

    private void updateVisualResult() {
        getDriver().executeScript("/*@visual.end*/");
    }

    private void updateSauceResult(String result) {
        getDriver().executeScript("sauce:job-result=" + result);
        // Add output for the Sauce OnDemand Jenkins plugin
        // The first print statement will automatically populate links on Jenkins to Sauce
        // The second print statement will output the job link to logging/console
        if (this.driver != null) {
            String sauceReporter = String.format("SauceOnDemandSessionID=%s job-name=%s", this.driver.getSessionId(), this.sauceOptions.getName());
            String sauceTestLink = String.format("Test Job Link: https://app.saucelabs.com/tests/%s", this.driver.getSessionId());
            System.out.print(sauceReporter + "\n" + sauceTestLink + "\n");
        }
    }

    private void stop() {
        if(driver !=null) {
            driver.quit();
        }
    }

    public void takeSnapshot(String snapshotName) {
        getDriver().executeScript("/*@visual.snapshot*/", snapshotName);
    }
}
