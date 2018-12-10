package br.com.techlead.agendacontato.utils;

public enum GenderEnum {
    FEMALE("Female"),
    MALE("Male");

    private String name;

    GenderEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
