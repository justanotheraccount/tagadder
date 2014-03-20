package de.motzko.tagadder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class DatastoreTest
{

    @Test
    public void testGetFilesviaStringlist() {
        File testFile1 = new File("testFile1.txt");
        File testFile2 = new File("testFile2.txt");

        List<File> expectedFileList = new ArrayList<File>();
        expectedFileList.add(testFile1);
        expectedFileList.add(testFile2);

        List<String> myStringList = new ArrayList<String>();
        myStringList.add(testFile1.getPath().toString());
        myStringList.add(testFile2.getPath().toString());

        Datastore myDatastore = new Datastore();

        List<File> actualFileList = myDatastore.getFiles(myStringList);

        Assert.assertEquals(expectedFileList, actualFileList);
        Assert.assertEquals(testFile1.getPath(), actualFileList.get(0).getPath());
        Assert.assertEquals(testFile2.getPath(), actualFileList.get(1).getPath());
    }

    @Test
    public void testGetFilesviaFile() {
        //fail("Not yet implemented");
        String neueZeile = "neue Zeile zum Testen für github";
        String neueZeile2 = "neue Zeile zum Testen für github";
        String neueZeile3 = "neueZeile3";

        System.out.println(neueZeile);
        System.out.println(neueZeile2);
        System.out.println(neueZeile3);
        System.out.println("Bla: " + neueZeile3);
    }

    @Test
    public void testGetStrings() {
        //fail("Not yet implemented");
    }

}
