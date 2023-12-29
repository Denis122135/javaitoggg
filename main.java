import java.util.*;

public class PhoneBook {
    private HashMap<String, HashSet<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        HashSet<String> phoneNumbers = contacts.getOrDefault(name, new HashSet<>());
        phoneNumbers.add(phoneNumber);
        contacts.put(name, phoneNumbers);
    }

    public void removeContact(String name) {
        contacts.remove(name);
    }

    public void removePhoneNumber(String name, String phoneNumber) {
        if (contacts.containsKey(name)) {
            HashSet<String> phoneNumbers = contacts.get(name);
            phoneNumbers.remove(phoneNumber);
            if (phoneNumbers.size() == 0) {
                contacts.remove(name);
            }
        }
    }

    public void printContacts() {
       
        List<Map.Entry<String, HashSet<String>>> sortedContacts = new ArrayList<>(contacts.entrySet());
        
     
        sortedContacts.sort(new Comparator<Map.Entry<String, HashSet<String>>>() {
            @Override
            public int compare(Map.Entry<String, HashSet<String>> contact1, Map.Entry<String, HashSet<String>> contact2) {
                return Integer.compare(contact2.getValue().size(), contact1.getValue().size());
            }
        });
        
      
        for (Map.Entry<String, HashSet<String>> contact : sortedContacts) {
            System.out.println(contact.getKey() + ": " + contact.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("Alice", "123456789");
        phoneBook.addContact("Bob", "987654321");
        phoneBook.addContact("Alice", "987654321");
        phoneBook.addContact("Charlie", "555555555");

        phoneBook.printContacts();
    }
}