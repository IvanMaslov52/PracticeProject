package com.boots.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    @NotNull
    private Party party;
    @Column
    @Size(min = 2,max = 50)
    private String name;
    @Column
    @NotNull
    @Min(10)
    @Max(250)
    private Long studyingtime;

    public Subject(Party party, String name, Long studyingtime) {
        this.party = party;
        this.name = name;
        this.studyingtime = studyingtime;
    }
    public Subject()
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStudyingtime() {
        return studyingtime;
    }

    public void setStudyingtime(Long studyingtime) {
        this.studyingtime = studyingtime;
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "id=" + id +
                ", party=" + party +
                ", name='" + name + '\'' +
                ", studyingtime=" + studyingtime +
                '}';
    }
}
