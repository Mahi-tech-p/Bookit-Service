package com.bookit_service.service;

import com.bookit_service.entity.Seat;
import com.bookit_service.entity.SeatStatus;
import com.bookit_service.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@RequiredArgsConstructor
public class BookingService {
    private final SeatRepository seatRepository;

    @Transactional
    public void bookSeat(Long showId, String seatNumber) {

        Seat seat = seatRepository
                .findSeatForUpdate(showId, seatNumber)
                .orElseThrow(
                        () -> new RuntimeException("Seat not Found")
                );
        if (seat.getStatus() != SeatStatus.AVAILABLE) {
            throw new RuntimeException("Set is Already booked");
        }

        seat.setStatus(SeatStatus.BOOKED);

    }
}
