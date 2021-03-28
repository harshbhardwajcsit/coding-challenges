package com.dunzo.interview.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestUtility {
    public static String getFileAsString(String path) throws IOException {
        try {
            final BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            final List<String> content = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.add(line);
            }
            return String.join("\n", content);
        } catch (FileNotFoundException e) {
            throw e;
        }
    }
}
