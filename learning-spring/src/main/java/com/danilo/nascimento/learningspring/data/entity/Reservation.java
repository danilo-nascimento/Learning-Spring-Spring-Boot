package com.danilo.nascimento.learningspring.data.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @Column(name = "RESERVATION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reservationId;

    @Column(name = "ROOM_ID")
    private long roomid;

    @Column(name = "GUEST_ID")
    private long guestId;

    @Column(name = "RES_DATE")
    private Date resDate;

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public long getRoomId() {
        return roomid;
    }

    public void setRoomId(long roomid) {
        this.roomid = roomid;
    }

    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public Date getResDate() {
        return resDate;
    }

    public void setResDate(Date resDate) {
        this.resDate = resDate;
    }
}
