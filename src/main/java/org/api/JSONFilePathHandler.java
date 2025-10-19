package org.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.JsonPathException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JSONFilePathHandler extends XMLFilePathHandler {
    ObjectMapper mapper;
    InputStream inputStream;

    //Reads the json file and return its content
    public String jsonFileReader(String jsonfilepath) {
        try {
            String jsoncontent = new String(Files.readAllBytes(Paths.get(jsonfilepath)), StandardCharsets.UTF_8);
            return jsoncontent;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Reads the json file based on the json path
    public String readJsonPath(String jsonfilecontent, String jsonpath) {
        try {
            String content = JsonPath.read(jsonfilecontent, jsonpath);
            return content;
        } catch (JsonPathException jsonPathException) {
            jsonPathException.printStackTrace();
            return null;
        }
    }

    //Reads the json file based on the jsonpath and returns the Object list
    public List<Object> readJsonPathUsingDocument(String jsonfilecontent, String jsonpath) {
        try {
            Object document = Configuration.defaultConfiguration().jsonProvider().parse(jsonfilecontent);
            List<Object> listcontent = JsonPath.read(document, jsonpath);
            return listcontent;
        } catch (JsonPathException jsonPathException) {
            jsonPathException.printStackTrace();
            return null;
        }
    }
}

