import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {

    // List to hold Contact objects
    private List<Contact> contactList = null;
    private Contact contact = null;
    private StringBuilder data = null;

    // getter method for contact list
    public List<Contact> getContactList() {
        return contactList;
    }
    boolean isName = false;
    boolean isLastName = false;
    boolean isContact = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
       if (qName.equalsIgnoreCase("Contact")) {
            // create a new Contact
            String id = attributes.getValue("id");
            // initialize Employee object and set id attribute
            contact = new Contact();
            contact.setId(Integer.parseInt(id));
            // initialize list
            if (contactList == null)
                contactList = new ArrayList<>();
            isContact = true;
        } else if (qName.equalsIgnoreCase("name")) {
            // set boolean values for fields, will be used in setting Employee variables
            isName = true;
        } else if (qName.equalsIgnoreCase("lastname")) {
            isLastName = true;
        }
        // create the data container
        data = new StringBuilder();

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println("Element ended");
        if (isName) {
            // age element, set Employee age
            contact.setName(data.toString());
            isName = false;
        } else if (isLastName) {
            contact.setLastName(data.toString());
            isLastName = false;
        }

        if (qName.equalsIgnoreCase("contact")) {
            // add Employee object to list
            contactList.add(contact);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}