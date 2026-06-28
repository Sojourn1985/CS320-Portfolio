import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Author: Stephen Pinkerton
 * Course: CS320
 * Assignment: 3-2 Milestone – Contact Service
 * Date: 5-31-2026 (Added Author info into header per feedback)
 *
 * Description:
 *   JUnit tests for the ContactService class. These tests verify:
 *     - Adding contacts (including prevention of duplicate IDs)
 *     - Deleting contacts by ID
 *     - Updating individual fields of a contact
 *     - Proper exception handling when invalid operations occur
 *
 *   All update operations rely on the Contact class's validation rules.
 */
public class ContactServiceTest {

    /**
     * Verifies that a contact can be added successfully,
     * and that adding a duplicate ID results in an exception.
     */
    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        // Add the contact successfully
        service.addContact(contact);

        // Attempt to add a duplicate ID
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact);
        });
    }

    /**
     * Verifies that a contact can be deleted successfully,
     * and that deleting a non-existent ID results in an exception.
     */
    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        service.deleteContact("1");

        // Attempt to delete again should fail
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("1");
        });
    }

    /**
     * Verifies that the first name of a contact can be updated successfully.
     */
    @Test
    void testUpdateFirstName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        service.updateFirstName("1", "Jane");

        assertEquals("Jane", contact.getFirstName());
    }

    /**
     * Verifies that the last name of a contact can be updated successfully.
     */
    @Test
    void testUpdateLastName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        service.updateLastName("1", "Smith");

        assertEquals("Smith", contact.getLastName());
    }

    /**
     * Verifies that the phone number of a contact can be updated successfully.
     */
    @Test
    void testUpdatePhone() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        service.updatePhone("1", "0987654321");

        assertEquals("0987654321", contact.getPhone());
    }

    /**
     * Verifies that the address of a contact can be updated successfully.
     */
    @Test
    void testUpdateAddress() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        service.updateAddress("1", "456 Oak Ave");

        assertEquals("456 Oak Ave", contact.getAddress());
    }
}
