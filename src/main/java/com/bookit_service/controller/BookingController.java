package com.bookit_service.controller;


import com.bookit_service.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/seats")
    public ResponseEntity<String> bookSeat(@RequestParam Long showId, @RequestParam String seatNumber){
        bookingService.bookSeat(showId, seatNumber);

        return ResponseEntity.ok("Seat booked successfully..!!!");
    }
}
