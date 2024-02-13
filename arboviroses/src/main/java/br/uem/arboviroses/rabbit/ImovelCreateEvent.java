package br.uem.arboviroses.rabbit;

public class ImovelCreateEvent {
    private Integer id;
    private String query;

    public ImovelCreateEvent() {
    }

    public ImovelCreateEvent(Integer id, String query) {
        this.id = id;
        this.query = query;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
