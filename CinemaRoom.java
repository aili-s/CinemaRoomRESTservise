package cinema.model;

import cinema.exception.AlreadySoldException;
import cinema.exception.OutOfBoundsException;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CinemaRoom {
    private int totalRows;
    private int totalColumns;
    private List<Seat> availableSeats;
    private Set<Seat> soldSeats = new HashSet<>();

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
    public void sell(Seat seat){
        if (seat.getRow() < 1 || totalRows< seat.getRow() ||
                seat.getColumn() < 1 || totalColumns< seat.getColumn()){
            throw new OutOfBoundsException();
        }
        synchronized (this) {
            if (soldSeats.contains(seat)){
                throw new AlreadySoldException();
            }
            soldSeats.add(seat);
            availableSeats.remove(seat);
        }

    }

}
