package cinema.controler;

import cinema.exception.BusinessLogicException;
import cinema.model.CinemaRoom;
import cinema.model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class cinemaRoomControler {

    @Autowired
    CinemaRoom cinemaRoom;

    @GetMapping("/seats")
    public CinemaRoom seats() {
        return cinemaRoom;
    }

    @PostMapping("/purchase")
    public Seat purchase(@RequestBody Seat seat){
        try {
            cinemaRoom.sell(seat);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return seat;
    }

    @ExceptionHandler(BusinessLogicException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Map<String, String> errorHandLer(Exception e){
        return Map.of("error", e.getMessage())
    }
}