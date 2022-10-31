package com.boots.entity;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Party party;
    @Column
    private String fio;
    @Column
    private Long sticket;
    @Column
    private String borndata;

    public String getBorndata() {
        return borndata;
    }

    public void setBorndata(String borndata) {
        this.borndata = borndata;
    }

    public Student(Party party, String fio, Long sticket, String borndata) {
        this.party = party;
        this.fio = fio;
        this.sticket = sticket;
        this.borndata = borndata;
    }
    public Student()
    {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Long getSticket() {
        return sticket;
    }

    public void setSticket(Long sticket) {
        this.sticket = sticket;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", party=" + party +
                ", fio='" + fio + '\'' +
                ", sticket=" + sticket +
                ", borndata='" + borndata + '\'' +
                '}';
    }
}
