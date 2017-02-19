package com.grouk;

import java.io.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        String path = ClassLoader.getSystemResource("data.txt").getPath();
        readFile(path);
    }

    private static void readFile(String name) {
        try(BufferedReader br = new BufferedReader(new FileReader(new File(name)))) {
            String line;
            for(; (line = br.readLine()) != null; ) {
                processLine(line);
            }
            Thread.sleep(1000000);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    private static void processLine(String line) {
        for (int i = 0; i < line.length(); i = i + 4) {
            list.add(line.substring(i, i + 3).intern());
        }
    }
}
