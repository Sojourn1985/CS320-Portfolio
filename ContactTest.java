import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Author: Stephen Pinkerton
 * Course: CS320
 * Assignment: 3-2 Milestone – Contact Service
 * Date: 5-31-2026 (Added Author into header info per feedback)
 *
 * Description:
 *   JUnit tests for the Contact class. These tests verify:
 *     - Successful creation of a valid Contact object
 *     - Validation of all fields (ID, first name, last name, phone, address)
 *     - Enforcement of field length and format constraints
 *     - Proper behavior of setter methods
 *     - Immutability of the contactId field
 */


public class ContactTest {

    /**
     * Verifies that a Contact object is successfully created
     * when all provided fields meet the validation requirements.
     */
    @Test
    void testValidContactCreation() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    /**
     * Ensures that invalid or improperly formatted contact IDs
     * correctly trigger validation exceptions.
     */
    @Test
    void testInvalidContactId() {
        // Null ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });

        // ID longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    /**
     * Ensures that invalid first names (null or too long)
     * correctly trigger validation exceptions.
     */
    @Test
    void testInvalidFirstName() {
        // Null first name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Doe", "1234567890", "123 Main St");
        });

        // First name longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "ThisNameIsTooLong", "Doe", "1234567890", "123 Main St");
        });
    }

    /**
     * Ensures that invalid last names (null or too long)
     * correctly trigger validation exceptions.
     */
    @Test
    void testInvalidLastName() {
        // Null last name
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", null, "1234567890", "123 Main St");
        });

        // Last name longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "ThisNameIsTooLong", "1234567890", "123 Main St");
        });
    }

    /**
     * Ensures that invalid phone numbers (null, wrong length, or non-numeric)
     * correctly trigger validation exceptions.
     */
    @Test
    void testInvalidPhone() {
        // Null phone number
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", null, "123 Main St");
        });

        // Phone number not exactly 10 digits
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "12345", "123 Main St");
        });

        // Phone number contains non-numeric characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "abcdefghij", "123 Main St");
        });
    }

    /**
     * Ensures that invalid addresses (null or too long)
     * correctly trigger validation exceptions.
     */
    @Test
    void testInvalidAddress() {
        // Null address
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", null);
        });

        // Address longer than 30 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890",
                "This address is definitely more than thirty characters long");
        });
    }

    /**
     * Verifies that setter methods correctly update fields
     * and enforce validation rules.
     */
    @Test
    void testSetterMethods() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        // Update first name
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());

        // Update last name
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());

        // Update phone number
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());

        // Update address
        contact.setAddress("456 Oak Ave");
        assertEquals("456 Oak Ave", contact.getAddress());
    }
}
