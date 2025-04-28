public class Address {
    private String country;
    private String city;
    private int price;

    public Address(String country, String city,int price) {
        this.country = country;
        this.city = city;
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

}
