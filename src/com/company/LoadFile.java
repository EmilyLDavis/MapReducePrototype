package com.company;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LoadFile {
    private String file;


    public ArrayList<ArrayList> loadFile(String FileName, int size) {

        String line;
        ArrayList arrayList = new ArrayList();
       // int size;

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(FileName));
            while ((line = br.readLine()) != null ) {
             List List = Arrays.asList(line.split(","));
                 // arrayList.add(line);
                if(List.size() == size) {
                    arrayList.add(List);
                }

            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return arrayList;
    }

    public void printfile(String sb) {
        File file = new File("testoutput.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.write(sb);
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
