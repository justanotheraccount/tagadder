package de.motzko.tagadder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

public class Datastore implements IAccessData
{

    /**
     * This class is the class, that gives the data to the XML Adder. It uses Methods of the Interface
     * IConfig.java. So if a method in Xmladder wants the file<List>, but only got a properties-File, the
     * getFiles method returns it.
     */

    File datastore_inputfile = null;
    File datastore_outputfile = null;

    //--fromargs
    public List<File> getFiles(List<String> stringlist) {
        this.datastore_inputfile = new File(stringlist.get(0));
        this.datastore_outputfile = new File(stringlist.get(1));

        ArrayList<File> locFileList = new ArrayList<File>();
        locFileList.add(this.datastore_inputfile);
        locFileList.add(this.datastore_outputfile);
        return locFileList;
    }

    //--fromjavaproperties--
    public List<String> getStrings(File file) {
        List<String> locStringList2 = new ArrayList<String>();
        Properties myprops = new Properties();
        FileInputStream myFileinputstream = null;
        try {
            myFileinputstream = new FileInputStream(file);
            myprops.load(myFileinputstream);
            locStringList2.add(myprops.getProperty("header_string1v2"));
            locStringList2.add(myprops.getProperty("header_string2v2"));
            locStringList2.add(myprops.getProperty("footer_string"));

        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(myFileinputstream);
        }
        return locStringList2;
    }

// My Filearray reads the two filenames from the properties-File 
    public List<File> getFiles(File file) {

        File inputfile = null;
        File outputfile = null;
        String inputfilepath = null;
        String outputfilepath = null;
        Properties myprops = new Properties();
        FileInputStream myFileinputstream = null;
        List<File> locFileList = new ArrayList<File>();

        try {
            myFileinputstream = new FileInputStream(file);
            myprops.load(myFileinputstream);
            inputfilepath = myprops.getProperty("inputfile");
            outputfilepath = myprops.getProperty("outputfile");
            inputfile = new File(inputfilepath);
            outputfile = new File(outputfilepath);
            locFileList.add(inputfile);
            locFileList.add(outputfile);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(myFileinputstream);
        }

        return locFileList;
    }

}