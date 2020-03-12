

package rocks.zipcode;

import java.util.Comparator;

public class Address implements Comparable<Address> {
    private String street;
    private String town;
    protected String postCode;
    private String country;

    /**
     * Construct an Address without country
     */
    public Address(String street, String town, String postCode) {
        this(street, town, postCode, "");
    }

    /**
     * Construct an Address with full details
     */
    public Address(String street, String town, String postCode, String country) {
        this.street = street;
        this.town = town;
        this.postCode = postCode;
        this.country = country;
    }

    /**
     * Return a string representation of this object.
     */
    public String toString() {
        return street + "\n" + town + " " + postCode + "\n" + country ;
    }

    public int compareTo(Address address) {
        int comparePostal = this.postCode.compareTo(address.postCode);
        if (comparePostal != 0)
            return comparePostal;
        return this.country.compareTo(address.country);
    }

}
