package com.company;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LoadFile {
    private String file;


    public ArrayList<ArrayList> loadFile(){

       // Path path = Paths.get();
        String line;
        ArrayList arrayList = new ArrayList();
      //  ArrayList<ArrayList> arrList = new ArrayList();



        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\edavi\\Documents\\AComp_Passenger_data_no_error.csv"));
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



}
