package net.balsoftware.attendance;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "test.txt";
        URL url = Main.class.getResource(fileName);
        System.out.println(url);
        Path icsFilePath = Paths.get(url.getFile());
        System.out.println("path:" + icsFilePath);
        BufferedReader br = Files.newBufferedReader(icsFilePath);
        List<String> lines = br.lines().collect(Collectors.toList());
    }
}
