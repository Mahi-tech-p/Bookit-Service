
package com.bookit_service.repository;

import com.bookit_service.entity.Seat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface SeatRepository extends JpaRepository<Seat, UUID> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("""
        SELECT s FROM Seat s
        WHERE s.showId = :showId
        AND s.seatNumber = :seatNumber
    """)
    Optional<Seat> findSeatForUpdate(
            @Param("showId") Long showId,
            @Param("seatNumber") String seatNumber
    );
}
