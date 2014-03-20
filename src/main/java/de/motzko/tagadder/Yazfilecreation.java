package de.motzko.tagadder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Yazfilecreation

/**
 * This is a experimental class, which isn't runnable at this moment. It should create a input.xml file with
 * the yaz-client.exe automatically. Here the commandlist which has to be implemented:
 */

//how tot call yaz
//  yaz-client.exe -m C:\path\to\file\file.txt

//commands in yaz Client
//  open z3950.loc.gov:7090/voyager
//  find "Steve Jobs"
//  format xml
//  s 1+<Ergebnismenge>

{

    public File createLogfile() {
        File inputfile = null;
        try {
            inputfile = new File("inputfile.xml");
            String param1 = "-m";
            String param2 = inputfile.getAbsolutePath();

            System.out.println(inputfile.getAbsolutePath());
            Process process =
                new ProcessBuilder("C:\\Program Files (x86)\\YAZ\\bin\\yaz-client.exe", param1, param2)
                    .start();
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ( (line = br.readLine()) != null ) {
                System.out.println(line);
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        return inputfile;
    }

//    private File renameLogfile(File file) {
//
//        return file;
//    }

}
