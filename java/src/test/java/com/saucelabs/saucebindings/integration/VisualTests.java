package com.saucelabs.saucebindings.integration;

import com.saucelabs.saucebindings.SauceOptions;
import com.saucelabs.saucebindings.SauceSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class VisualTests {
    private RemoteWebDriver webDriver;
    private SauceSession session;
    private String projectName = "SauceBindingsTests";
    private SauceOptions sauceOptions;

    @After
    public void cleanUp() {
        session.stop(true);
    }

    @Before
    public void setUp() {
        sauceOptions = new SauceOptions().visual(projectName);
    }

    @Test
    public void defaultStart() {
        session = new SauceSession(sauceOptions);
        session.start();
        assertNotNull(session.getDriver());
    }

    //TODO I don't like the fact that our tests will need to throw
    //specific visual exceptions
    @Test
    public void settingCommonOptions() {
        sauceOptions.setName("testName");

        session = new SauceSession(sauceOptions);
        webDriver = session.start();
        assertNotNull(session.getDriver());
    }

    @Test
    public void settingUniqueOptions() {
        //my biggest problem here is that these errors will only be caught at run time
        // if someone tries to use them without setting .visual();
        sauceOptions.setViewportSize("1280x1024");

        //weird one
        //sauceOptions.setBranch("testBranch");

        Map<String, Object> diffOptions = new HashMap<>();
        diffOptions.put("structure", true);
        diffOptions.put("layout", true);
        diffOptions.put("style", true);
        diffOptions.put("content", true);
        diffOptions.put("minLayoutPosition", 4);
        diffOptions.put("minLayoutDimension", 10);

        sauceOptions.setDiffOptions(diffOptions);

        List<String> elementsToIgnore = new ArrayList<>();
        elementsToIgnore.add("#foo");
        elementsToIgnore.add(".bar");

        sauceOptions.selectorsToIgnore(elementsToIgnore);
        sauceOptions.failOnNewStates(true);
        sauceOptions.alwaysAcceptBaseBranch(true);
        //sauceOptions.disableBranchBaseline(true);
        sauceOptions.scrollAndStitchScreenshots(true);
        sauceOptions.disableCORS(true);

        session = new SauceSession(sauceOptions);
        webDriver = session.start();
        webDriver.get("https://www.saucedemo.com/");
        session.takeSnapshot("Snapshot name");
        assertNotNull(session.getDriver());
    }
}
