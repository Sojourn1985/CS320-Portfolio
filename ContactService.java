import java.util.HashMap;
import java.util.Map;

/**
 * Author: Stephen Pinkerton
 * Course: CS320
 * Assignment: 3-2 Milestone – Contact Service
 * Date: 5-31-2026 (Added Author into header info per feedback)
 *
 * Description:
 *   The ContactService class manages a collection of Contact objects.
 *   Responsibilities include:
 *     - Storing contacts using a unique contact ID as the key
 *     - Adding new contacts (preventing duplicate IDs)
 *     - Deleting existing contacts by ID
 *     - Updating individual fields of a contact (first name, last name, phone, address)
 *
 *   All update operations rely on the Contact class's built-in validation.
 *   Any invalid operation results in an IllegalArgumentException.
 */
public class ContactService {

    /** 
     * Internal storage for contacts, keyed by their unique contact ID.
     * HashMap provides O(1) average lookup, insert, and delete operations.
     */
    private final Map<String, Contact> contacts = new HashMap<>();


    // ------------------------------------------------------------
    // Add Contact
    // ------------------------------------------------------------

    /**
     * Adds a new Contact to the service.
     *
     * @param contact The Contact object to add (must not be null)
     * @throws IllegalArgumentException if:
     *         - The contact is null
     *         - A contact with the same ID already exists
     */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        String contactId = contact.getContactId();

        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID already exists");
        }

        contacts.put(contactId, contact);
    }


    // ------------------------------------------------------------
    // Delete Contact
    // ------------------------------------------------------------

    /**
     * Deletes a contact from the service using its unique ID.
     *
     * @param contactId The ID of the contact to delete
     * @throws IllegalArgumentException if the ID does not exist
     */
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        contacts.remove(contactId);
    }


    // ------------------------------------------------------------
    // Update Contact Fields
    // ------------------------------------------------------------

    /**
     * Updates the first name of the contact with the given ID.
     *
     * @param contactId     The ID of the contact to update
     * @param newFirstName  The new first name (validated by Contact class)
     */
    public void updateFirstName(String contactId, String newFirstName) {
        Contact contact = getContact(contactId);
        contact.setFirstName(newFirstName);
    }

    /**
     * Updates the last name of the contact with the given ID.
     *
     * @param contactId    The ID of the contact to update
     * @param newLastName  The new last name (validated by Contact class)
     */
    public void updateLastName(String contactId, String newLastName) {
        Contact contact = getContact(contactId);
        contact.setLastName(newLastName);
    }

    /**
     * Updates the phone number of the contact with the given ID.
     *
     * @param contactId  The ID of the contact to update
     * @param newPhone   The new phone number (validated by Contact class)
     */
    public void updatePhone(String contactId, String newPhone) {
        Contact contact = getContact(contactId);
        contact.setPhone(newPhone);
    }

    /**
     * Updates the address of the contact with the given ID.
     *
     * @param contactId    The ID of the contact to update
     * @param newAddress   The new address (validated by Contact class)
     */
    public void updateAddress(String contactId, String newAddress) {
        Contact contact = getContact(contactId);
        contact.setAddress(newAddress);
    }


    // ------------------------------------------------------------
    // Helper Method
    // ------------------------------------------------------------

    /**
     * Retrieves a contact by ID or throws an exception if not found.
     *
     * @param contactId The ID of the contact to retrieve
     * @return The Contact object associated with the ID
     * @throws IllegalArgumentException if the ID does not exist
     */
    private Contact getContact(String contactId) {
        Contact contact = contacts.get(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        return contact;
    }
}
