package br.com.techlead.agendacontato.utils;

public enum UserTypeEnum {
    DOCTOR("Doctor"),
    NURSE("Nurse");

    private String name;

    UserTypeEnum(String name) {
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
