package com.vz.rsync.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessBuilderUtils {
    public static void main(String[] args) {
        File f =  new File("/Users/badigan/git/src/main/resources/script.sh");
        f.setExecutable(true);
        String[] command = {"/Users/badigan/git/src/main/resources/script.sh","anand","test"};
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        try {
            processBuilder.redirectErrorStream(true);
            Process p2 = processBuilder.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p2.getInputStream()));
            String line;
            System.out.println("Output of running " + command + " is: ");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
