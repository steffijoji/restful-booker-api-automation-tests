package Entities;

public class Booking {
    private String firstname;
    private String lastname;
    private float totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public Booking(String firstname, String lastname, float totalprice, boolean depositpaid, BookingDates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    public String getfirstname() {
        return firstname;
    }

    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getlastname() {
        return lastname;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
    }

    public float gettotalprice() {
        return totalprice;
    }

    public void settotalprice(float totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isdepositpaid() {
        return depositpaid;
    }

    public void setdepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDates getbookingdates() {
        return bookingdates;
    }

    public void setbookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getadditionalneeds() {
        return additionalneeds;
    }

    public void setadditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}
