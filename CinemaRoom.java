package cinema.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class CinemaRoom {
    private int totalRows;
    private int totalColumns;
    private List<Seat> availableSeats;

    public CinemaRoom(int totalColumns, int totalRows){
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        availableSeats = new ArrayList<>();
        for (int row = 0; row <= totalRows; row++){
            for (int col = 0; col <= totalColumns; col++){
                availableSeats.add(new Seat(row, col));
            }
        }
    }

    public int getTotal_rows() {

        return totalRows;
    }

    public void setTotalRows(int totalRows) {

        this.totalRows = totalRows;
    }

    public int getTotalColumns() {

        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {

        this.totalColumns = totalColumns;
    }

    public List<Seat> getAvailableSeats() {

        return availableSeats;
    }

    public void setAvailableSeats(List<Seat> availableSeats) {

        this.availableSeats = availableSeats;
    }


}
