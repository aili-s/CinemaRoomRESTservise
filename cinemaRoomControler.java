package cinema.controler;

import cinema.model.CinemaRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class cinemaRoomControler {

    @Autowired
    CinemaRoom cinemaRoom;

    @GetMapping("/seats")
    public CinemaRoom seats() {
        return cinemaRoom;
    }
}