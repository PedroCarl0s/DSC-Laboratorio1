package com.dsc.socialnetwork.models;

public class Discipline {
    private int id;
    private String name;
    private double note;

    public Discipline(int id, String name, double note) {
        this.id = id;
        this.name = name;
        this.note = note;
    }

    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Discipline other = (Discipline) obj;
        if (id != other.id)
            return false;
        return true;
    }    
    
}