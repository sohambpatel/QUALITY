
# QUALITY (Quick Unified Automation Leveraging Intelligent Test Yield)

From Excel Templates to Intelligent API Tests, No Code Required.

QUALITY is an intelligent no-code testing framework that transforms structured Excel templates into executable API unit and integration test cases. It bridges the gap between business-readable test logic and automated execution by parsing Excel sheets, generating API test payloads, assertions, and workflows, all without manual scripting.

## Prerequisites
1. Java 21.0.2
2. Maven apache-maven-3.9.6 

Rest of the libraries are handled as a part of maven dependancies.

## How to Run?
1. Clone this repository
https://github.com/sohambpatel/QUALITY.git

2. Download all the dependancies
mvn clean install -U

3. Running the main method src/main/java/org/api/ApiTests.java

4. Make sure to update the template path at         List<ApiTestCase> tests = ExcelReader.readTestCases("src/main/resources/api_test_data.xlsx");

5. Sample template with oauth given here 
src/main/resources/api_test_data_OauthSample.xlsx

6. Sample template without oauth given here
src/main/resources/api_test_data.xlsx

7. Make sure to update the framework properties accordingly
src/main/resources/framework.properties

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License

[APACHE](https://www.apache.org/licenses/LICENSE-2.0)
