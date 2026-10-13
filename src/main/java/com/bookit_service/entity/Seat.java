package com.bookit_service.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "seats",
        uniqueConstraints = @UniqueConstraint(
                name="uk_show_seat",
                columnNames = {"show_id","seat_number"}
        )
)

public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private  Long id;

    @Column(name ="show_id", nullable = false)
    private Long showId;

    @Column(name = "seat_number", nullable = false)
    private  String  seatNumer;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

}
