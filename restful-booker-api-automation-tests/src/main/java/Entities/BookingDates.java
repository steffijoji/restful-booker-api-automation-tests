package Entities;

import java.util.Date;

public class BookingDates {
    private Date checkin;
    private Date checkout;

    public BookingDates(Date checkin, Date checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Date getcheckin() {
        return checkin;
    }

    public void setcheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getcheckout() {
        return checkout;
    }

    public void setcheckout(Date checkout) {
        this.checkout = checkout;
    }
}
