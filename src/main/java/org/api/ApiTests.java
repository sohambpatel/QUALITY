package org.api;

import model.ApiTestCase;
import reader.ExcelReader;
import runner.ApiTestRunner;

import java.time.LocalDateTime;
import java.util.List;

public class ApiTests {
    // This method is the starting point of the execution.
    public static void main(String[] args) {
        LocalDateTime testcaseexecutionstarttime = LocalDateTime.now();
        List<ApiTestCase> tests = ExcelReader.readTestCases("src/main/resources/api_test_data.xlsx");
        //List<ApiTestCase> tests = ExcelReader.readTestCases("src/main/resources/api_test_data_OauthSample.xlsx");
        System.out.println("Execution of the Test cases has been started..");
        System.out.println("Execution Start time: " + testcaseexecutionstarttime);
        for (ApiTestCase test : tests) {
            if (test.skip.equalsIgnoreCase("yes")) {
                System.out.println("skipping the test " + test.testName);
            } else {
                System.out.println("Currently Executing: " + test.testName);
                ApiTestRunner.run(test);
            }
        }
        System.out.println("Execution of the Test cases has been completed..");
        LocalDateTime testcaseexecutionstoptime = LocalDateTime.now();
        System.out.println("Execution Stop time: " + testcaseexecutionstoptime);
    }
}