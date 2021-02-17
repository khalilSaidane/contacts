import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Contact {
    private int id;
    private String name;
    private String LastName;
    private List<Contact> contacts = new ArrayList<>();

}
