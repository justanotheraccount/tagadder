package de.motzko.tagadder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class XmladderTest
{
    Xmladder myFileXmladder = null;
    Xmladder myStringXmladder = null;

    File propertiesFile = null;
    List<String> stringList = null;

    File expectedInputFile = null;
    String expectedString = null;
    String expectedString2 = null;
    String expectedHeaderString = "nullnull";
    String expectedFooterString = null;
    String actualString = null;
    List<String> expectedList = new ArrayList<String>();

//    @Before
//    public void setup() {
//        this.myFileXmladder = new Xmladder(this.propertiesFile);
//        this.myStringXmladder = new Xmladder(this.stringList);
//        this.expectedInputFile = new File("testfile.txt");
//        this.expectedString = "testinhalt";
//        this.expectedString2 = "testinhalt";
//
//        this.expectedList.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
//        this.expectedList.add("<collection xmlns=\"http://www.loc.gov/MARC21/slim\">\n");
//        this.expectedList.add("\n</collection>");
//
//        StringBuilder sb = new StringBuilder(10000);
//        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
//        sb.append("<collection xmlns=\"http://www.loc.gov/MARC21/slim\">\n");
//        sb.append("\n</collection>");
//
//        this.expectedString = sb.toString();
//
//        try {
//            BufferedWriter bf = new BufferedWriter(new FileWriter(this.expectedInputFile));
//            bf.write(this.expectedString);
//            bf.close();
//        } catch ( IOException e ) {
//            e.printStackTrace();
//            System.out.println("Fehler: " + e);
//        }
//    }

    @Test
    public void testCreatenewXMLDataviaProp() {
//        try {
//            this.actualString = this.myFileXmladder.CreateNewXMLString(this.propertiesFile);
//            Assert.assertEquals(this.expectedString, this.actualString);
//        } catch ( NullPointerException e ) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void testCreatenewXMLDataviaList() {
//        this.actualString = this.myXmladder.createnewXMLData(this.expectedList);
//        Assert.assertEquals(this.expectedString, this.actualString);
    }

    @Test
    public void testCreateHead() {
//        this.actualString = this.myFileXmladder.createHead(this.expectedInputFile);
//        Assert.assertEquals(this.expectedHeaderString, this.actualString);
    }

    @Test
    public void testCreateFooter() {
//        this.actualString = this.myFileXmladder.createFooter(this.expectedInputFile);
//        Assert.assertEquals(this.expectedFooterString, this.actualString);
    }

    @Test
    public void testCreateBody() {
//        this.actualString = this.myFileXmladder.createBody(this.expectedInputFile);
//        Assert.assertEquals(this.expectedString, this.actualString);
    }

    @Test
    public void testcount_lines() {
//        //1. Setup
//        Xmladder myXmladder = new Xmladder();
//        File inputFile = new File("input.xml");
//        String testString = "testinhalt";
//        int expectedInt = 1;
//        int actualInt = 0;
//
//        try {
//            BufferedWriter bf = new BufferedWriter(new FileWriter(inputFile));
//            bf.write(testString);
//            bf.close();
//        } catch ( IOException e ) {
//            e.printStackTrace();
//        }
//
//        //2. test the method of the class
//        actualInt = myXmladder.count_lines(inputFile);
//
//        //3. Assert and verify
//        Assert.assertEquals(expectedInt, actualInt);
    }

}
