package com.epf.rentmanager.model;

import java.time.LocalDate;

public class Reservation {

    private long id;
    private long clientid;
    private long vehicleid;
    private LocalDate debut;
    private LocalDate fin;

    public Reservation  (long id, long clientid, long vehicleid, LocalDate debut, LocalDate fin) {
        this.id = id;
        this.clientid = clientid;
        this.vehicleid = vehicleid;
        this.debut = debut;
        this.fin = fin;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getClientid() {
        return clientid;
    }

    public long getVehicleid() {
        return vehicleid;
    }

    public LocalDate getDebut() {
        return debut;
    }

    public LocalDate getFin() {
        return fin;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public void setDebut(LocalDate debut) {
        this.debut = debut;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    public void setVehicleid(int vehicleid) {
        this.vehicleid = vehicleid;
    }
}
