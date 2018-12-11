package br.com.techlead.agendacontato.utils;

public enum StatusEnum {
    NORMAL(1, "NORMAL"),
    STABLE(2, "STABLE"),
    UNSTABLE(3, "UNSTABLE"),
    CRITICAL(4, "CRITICAL");

    private int id;
    private String name;

    StatusEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}
