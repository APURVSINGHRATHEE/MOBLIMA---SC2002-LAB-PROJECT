package Model.KickOff;

import Helpful.Body;;

/**
 * Class that represents a ticket
 */
public class Tickets extends Body {
    
    private static final long serialVersionUID = 12324134119L;
    
    private SeatBooking seatBooked;
    private TicketType ticketType;
    private KickOff showTimeBooked;
    
    public Tickets(SeatBooking seatBooked, TicketType ticketType,
        KickOff showTimeBooked) {
        this.seatBooked = seatBooked;
        this.ticketType = ticketType;
        this.showTimeBooked = showTimeBooked;
    }
    
    
}
