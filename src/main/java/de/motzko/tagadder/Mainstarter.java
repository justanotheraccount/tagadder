package de.motzko.tagadder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Mainstarter
{
    /**
     * This is the Mainclass to start the whole project and to give some Info-Output to the screen. There
     * three ways to use the xmladder. With no, one or two arguments. With no argument a error will popup,
     * with one argument you have choosen to use a properties file and with two arguments you give the
     * xmladder the input- and outputfile in form of a list and you use the default_Strings.
     */

    public static void main(String[] args) {

//        //Generate inputfile
//        Xmladder myxmladder = new Xmladder();
//        File inputfile = Xmladder.startyazgetinputfile();

        String info1 =
            "[Info] Welcome, XMLadder transforms your compatible-xml-recordfile into an injection-ready-XML File! Please use the progam like this:     xmladder.jar inputfile.xml outputfile.xml.";
        String info2 =
            "[Info] No args found. Please set args1 for an input- and args2 for an outputfile. Program will exit now!";
        String info3a = "[Info] Found one Argument(arg)! Creating outputfile.";
        String info3b = "[Info] Found two Arguments(arg)! Creating outputfile.";
        String info4a =
            "[Info] Outputfile as defined in the properties-File. Please check the Files in your Texteditor!: Propertiesfile:";
        String info4b = "[Info] Please check the Files in your Texteditor! Inputfile + Generated Outputfile:";

        File propertiesFile = null;
        List<String> argsList = null;
        System.out.println(info1);

        //case 1 - args = 1 -> 1arg (args[0] is the properties-file-path!)
        if ( args.length == 1 ) {
            System.out.println(info3a);

            propertiesFile = new File(args[0]);

            new Xmladder(propertiesFile);
            System.out.println(info4a + args[0]);
        }

        //case 2 - args = 2 or higher -> 2args (inputfile, outputfile)
        else if ( args.length == 2 ) {
            System.out.println(info3b);

            argsList = new ArrayList<String>();
            argsList.add(args[0]);
            argsList.add(args[1]);

            new Xmladder(argsList);
            System.out.println(info4b + args[0] + args[1]);
        }

        //case 3 - no args -> exit
        else if ( args.length != 1 && args.length != 2 ) {
            System.out.println(info2);
            System.exit(1);
        }

        System.out.println("[Info] Programm terminated");
    }
}