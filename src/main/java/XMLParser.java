import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class XMLParser {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler();
            Scanner scanner = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter path");
            String path = scanner.next();
            saxParser.parse(
                        new File(path),
                        handler
                );


            //Get Contact list
            List<Contact> contactList = handler.getContactList();
            //print contact information
            for (Contact cont : contactList)
                System.out.println(cont);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
