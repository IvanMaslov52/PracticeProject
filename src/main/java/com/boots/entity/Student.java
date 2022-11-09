package com.boots.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    @NotNull
    private Party party;
    @Column
    @Size(min = 3 , max = 100)
    private String fio;
    @Column
    @Max(99999999)
    @Min(0)
    @NotNull
    private Long sticket;
    @Column
    @Size(min = 6 , max = 20)
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
