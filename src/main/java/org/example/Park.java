package org.example;

import java.util.List;
/*
3. Создать класс Park с внутренним классом,
с помощью объектов которого можно хранить информацию об аттракционах, времени их работы и стоимости.
 */
/**
 * Class for Park
 */
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
public class Park {

    private String parkName;
    //ну тип атракционы которые относятся к этому конкретному парку
    private List<Attraction> attractions;
    public Park() {
    }

    public Park(String parkName) {
        this.parkName = parkName;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public List<Attraction> getAttractions(){
        return this.attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    @Override
    public String toString() {
        return "Park{" +
                "parkName='" + parkName + '\'' +
                ", attractions=" + attractions +
                '}';
    }

    /**
     * Class for Attraction
     */
    //@AllArgsConstructor
    //@Getter
    //@ToString
    public class Attraction {

        private String attractionName;
        private double ticketPrice;
        private String workTime;

        public Attraction() {
        }

        public Attraction(String attractionName, double ticketPrice, String workTime) {
            this.attractionName = attractionName;
            this.ticketPrice = ticketPrice;
            this.workTime = workTime;
        }

        public String getAttractionName() {
            return attractionName;
        }

        public void setAttractionName(String attractionName) {
            this.attractionName = attractionName;
        }

        public double getTicketPrice() {
            return ticketPrice;
        }

        public void setTicketPrice(double ticketPrice) {
            this.ticketPrice = ticketPrice;
        }

        public String getWorkTime() {
            return workTime;
        }

        public void setWorkTime(String workTime) {
            this.workTime = workTime;
        }

        @Override
        public String toString() {
            return "Attraction{" +
                    "attractionName='" + attractionName + '\'' +
                    ", ticketPrice=" + ticketPrice +
                    ", workTime='" + workTime + '\'' +
                    '}';
        }
    }
}
