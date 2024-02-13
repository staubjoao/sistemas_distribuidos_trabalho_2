package br.uem.arboviroses.rabbit;

public class GeolocalizacaoCreateEvent {
    private Integer id;
    private String lat;
    private String lon;

    public GeolocalizacaoCreateEvent() {
    }

    public GeolocalizacaoCreateEvent(Integer id, String lat, String lon) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "GeolocalizacaoCreateEvent{" +
                "id=" + id +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }
}
