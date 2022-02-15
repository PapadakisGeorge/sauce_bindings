package com.saucelabs.saucebindings;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class CITools {
    private static String buildName = "Default Build Name";
    private static String buildNumber = String.valueOf(System.currentTimeMillis());
    private static Boolean knownCI = false;

    public static Map<String, String> knownTools = ImmutableMap.of(
            "Jenkins", "BUILD_TAG",
            "Bamboo", "bamboo_agentId",
            "Travis", "TRAVIS_JOB_ID",
            "Circle", "CIRCLE_JOB",
            "GitLab", "CI",
            "TeamCity", "TEAMCITY_PROJECT_NAME");

    public static Map<String, ImmutableList<String>> buildValues = ImmutableMap.of(
            "Jenkins", ImmutableList.of("BUILD_NAME", "BUILD_NUMBER"),
            "Bamboo", ImmutableList.of("bamboo_shortJobName", "bamboo_buildNumber"),
            "Travis", ImmutableList.of("TRAVIS_JOB_NAME", "TRAVIS_JOB_NUMBER"),
            "Circle", ImmutableList.of("CIRCLE_JOB", "CIRCLE_BUILD_NUM"),
            "GitLab", ImmutableList.of("CI_JOB_NAME", "CI_JOB_ID"),
            "TeamCity", ImmutableList.of("TEAMCITY_PROJECT_NAME", "BUILD_NUMBER"));

    private static void setBuildInfo() {
        if (knownCI) {
            return;
        }

        for (Map.Entry<String, String> tool : knownTools.entrySet()) {
            if (SystemManager.get(tool.getValue()) != null) {
                buildName = buildValues.get(tool.getKey()).get(0);
                buildNumber = buildValues.get(tool.getKey()).get(1);
                knownCI = true;
                break;
            }
        }
    }

    public static String getBuildName() {
        setBuildInfo();
        return buildName;
    }

    public static String getBuildNumber() {
        setBuildInfo();
        return buildNumber;
    }

    public static boolean isKnownCI() {
        setBuildInfo();
        return knownCI;
    }
}
