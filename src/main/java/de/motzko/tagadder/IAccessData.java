package de.motzko.tagadder;

import java.io.File;
import java.util.List;

public interface IAccessData
{

    /**
     * This is the interface the getFiles and getStrings methods. The Datastore class uses it to convert Lists
     * for other classes.
     */

    public List<File> getFiles(List<String> stringlist);

    public List<String> getStrings(File file);

    public List<File> getFiles(File file);
}
