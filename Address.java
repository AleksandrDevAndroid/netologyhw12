import java.util.Objects;

public class Address {
    private String country;
    private String city;
    private int price;

    Address(String country, String city, int price) {
        this.country = country;
        this.city = city;
        this.price = price;
    }

    public Address(String country) {
        this.country = country;
    }

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public Address(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country);
    }

    @Override
    public boolean equals(Object obj) {
        Address address = (Address) obj;
        return country.equals(address.country) && city.equals(address.city);
    }
}
