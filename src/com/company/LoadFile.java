package com.company;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LoadFile {
    private String file;


    public ArrayList<ArrayList> loadFile(String FileName) {

        String line;
        ArrayList arrayList = new ArrayList();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(FileName));
            while ((line = br.readLine()) != null) {

                // arrayList.add(line);
                arrayList.add(Arrays.asList(line.split(",")));


            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return arrayList;
    }

    public void printfile(StringBuilder sb) {
        File file = new File("testoutput.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace(); // I'd rather declare method with throws IOException and omit this catch.
        } finally {
            if (writer != null) try {
                writer.close();
            } catch (IOException ignore) {
            }
        }
    }

}
