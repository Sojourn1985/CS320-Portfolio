/**
 * Author: Stephen Pinkerton
 * Course: CS320
 * Assignment: 3-2 Milestone – Contact Service
 * Date: 5-31-2026 (Added Author into header info per feedback)
 *
 * Description:
 *   The Contact class represents a single contact record in the system.
 *   Each contact contains:
 *     - A unique, non-updatable contact ID (max 10 characters)
 *     - A first name (required, max 10 characters)
 *     - A last name (required, max 10 characters)
 *     - A phone number (required, exactly 10 digits)
 *     - An address (required, max 30 characters)
 *
 *   All fields are validated to ensure data integrity. Any invalid input
 *   results in an IllegalArgumentException being thrown.
 */
public class Contact {

    // -----------------------------
    // Fields
    // -----------------------------

    /** Unique identifier for the contact. Cannot be changed once set. */
    private final String contactId;

    /** Contact's first name (updatable). */
    private String firstName;

    /** Contact's last name (updatable). */
    private String lastName;

    /** Contact's phone number (updatable, must be exactly 10 digits). */
    private String phone;

    /** Contact's address (updatable, max 30 characters). */
    private String address;


    // -----------------------------
    // Constructor
    // -----------------------------

    /**
     * Creates a new Contact object with full validation on all fields.
     *
     * @param contactId Unique ID for the contact (required, max 10 chars)
     * @param firstName First name (required, max 10 chars)
     * @param lastName  Last name (required, max 10 chars)
     * @param phone     Phone number (required, exactly 10 digits)
     * @param address   Address (required, max 30 chars)
     */
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {

        // Validate contactId
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }

        // Validate firstName
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }

        // Validate lastName
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }

        // Validate phone (must be exactly 10 digits)
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        // Validate address
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        // Assign validated values
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }


    // -----------------------------
    // Getters
    // -----------------------------

    /** @return The unique contact ID (not updatable). */
    public String getContactId() {
        return contactId;
    }

    /** @return The contact's first name. */
    public String getFirstName() {
        return firstName;
    }

    /** @return The contact's last name. */
    public String getLastName() {
        return lastName;
    }

    /** @return The contact's phone number. */
    public String getPhone() {
        return phone;
    }

    /** @return The contact's address. */
    public String getAddress() {
        return address;
    }


    // -----------------------------
    // Setters (Updatable Fields)
    // -----------------------------

    /**
     * Updates the contact's first name.
     * @param firstName New first name (required, max 10 chars)
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    /**
     * Updates the contact's last name.
     * @param lastName New last name (required, max 10 chars)
     */
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    /**
     * Updates the contact's phone number.
     * @param phone New phone number (required, exactly 10 digits)
     */
    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    /**
     * Updates the contact's address.
     * @param address New address (required, max 30 chars)
     */
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}
