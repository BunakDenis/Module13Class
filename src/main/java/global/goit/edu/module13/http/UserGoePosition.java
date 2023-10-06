package global.goit.edu.module13.http;

public class UserGoePosition {

    private double lat;
    private double lng;

    public UserGoePosition(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "UserGoePosition{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
