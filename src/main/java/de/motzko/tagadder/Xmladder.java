package de.motzko.tagadder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

public class Xmladder
{
    /**
     * This xmladder uses the Datastore methods to get Lists for the File or String Type. XMLadders main goal
     * is it to build a new string, which will be written to a new outputfile. Because of the different usage,
     * the string is build different when you use a properties or not.
     */

    private final String default_header_string1v2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
    private final String default_header_string2v2 = "<collection xmlns=\"http://www.loc.gov/MARC21/slim\">\n";
    private final String default_footer_string = "\n</collection>";

    private List<String> stringlist = null;
    private File propertiesfile;

    IAccessData myDatastore = new Datastore();

    public Xmladder(List<String> mainstringlist) {
        this.stringlist = mainstringlist;
        CreateNewXMLString(this.stringlist);
    }

    public Xmladder(File mainpropertiesfile) {
        this.propertiesfile = mainpropertiesfile;
        createNewXMLString(this.propertiesfile);
    }

    //    public Xmladder(IAccessData datastore) {
//        this.myDatastore = datastore;
//    }
//

    public IAccessData iniDatastoreProp() {
        IAccessData myDatastoreProp = new Datastore();
        return myDatastoreProp;
    }

    //properties-file-method
    public String createNewXMLString(File receivedPropertiesFile) {
        this.propertiesfile = receivedPropertiesFile;
        List<File> filelist = this.myDatastore.getFiles(receivedPropertiesFile);
        String newXMLString = null;
        Properties myprops = new Properties();
        StringBuilder headbodyfooter = new StringBuilder(10000000);
        try {
            myprops.load(new FileInputStream("xmladderdata.properties"));
            newXMLString =
                headbodyfooter.append(
                    createHead(this.propertiesfile)
                        + createBody(filelist.get(0))
                        + createFooter(this.propertiesfile)).toString();

            FileWriter outputFileWriter = null;
            outputFileWriter = new FileWriter(filelist.get(1));
            BufferedWriter outputBufferedWriter = new BufferedWriter(outputFileWriter);

            outputBufferedWriter.write(newXMLString);
            outputBufferedWriter.close();
            outputFileWriter.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        return newXMLString;
    }

    public String createHead(File file) {
        List<String> stringList = this.myDatastore.getStrings(this.propertiesfile);
        StringBuilder sbHeader = new StringBuilder(1500000);
        for ( int i = 0; i < stringList.size() - 1; i++ ) {
            String temp = stringList.get(i);
            sbHeader.append(temp);
        }
        return sbHeader.toString();
    }

    public String createFooter(File file) {
        List<String> stringList = this.myDatastore.getStrings(this.propertiesfile);
        return stringList.get(stringList.size() - 1);
    }

    //args-Method
    public String CreateNewXMLString(List<String> receivedArgsList) {
        this.stringlist = receivedArgsList;
        List<File> filelist = this.myDatastore.getFiles(this.stringlist);

        String newXMLString = null;
        FileWriter outputFileWriter = null;
        BufferedWriter outputBufferedWriter = null;
        StringBuilder headbodyfooter = new StringBuilder(10000000);
        try {
            newXMLString =
                headbodyfooter.append(
                    this.default_header_string1v2
                        + this.default_header_string2v2
                        + createBody(filelist.get(0))
                        + this.default_footer_string).toString();

            outputFileWriter = new FileWriter(filelist.get(1));
            outputBufferedWriter = new BufferedWriter(outputFileWriter);

            outputBufferedWriter.write(newXMLString);
            outputBufferedWriter.close();
            outputFileWriter.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(outputFileWriter);
            IOUtils.closeQuietly(outputBufferedWriter);
        }
        return newXMLString;
    }

    public String createBody(File inputFile) {
        String readline = null;
        StringBuilder sb = new StringBuilder(1500000);

        int filelines = 0;
        filelines = count_lines(inputFile);

        //Variante mit BufferedReader + newline
        FileReader inputFileReader = null;
        BufferedReader inputBufferedReader = null;
        try {
            inputFileReader = new FileReader(inputFile);
            inputBufferedReader = new BufferedReader(inputFileReader);

            while ( (readline = inputBufferedReader.readLine()) != null ) {
                sb.append(readline);

                if ( filelines > 1 ) {
                    sb.append("\n");
                } else {
                    //last line, no new-Line-Seperator
                }
                filelines--;
            }
        } catch ( FileNotFoundException e ) {
            System.out.println();
        } catch ( IOException e ) {
            System.out.println();
        } finally {
            IOUtils.closeQuietly(inputBufferedReader);
            IOUtils.closeQuietly(inputFileReader);
        }
        return sb.toString();

    }

    public int count_lines(File file) {
        int countlines = 0;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            while ( (br.readLine()) != null ) {
                countlines = countlines + 1;
            }

        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
            System.out.println("Fehler: " + e);
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(fr);
        }
        return countlines;
    }

    public File startyazgetinputfile() {
        Yazfilecreation myyaz = new Yazfilecreation();
        File inputfile = myyaz.createLogfile();
        return inputfile;
    }

}
