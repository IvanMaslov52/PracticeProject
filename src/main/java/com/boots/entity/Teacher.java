package com.boots.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String fio;
    @Column
    private String borndate;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_subjects",
            joinColumns = { @JoinColumn(name = "teacher_id") },
            inverseJoinColumns = { @JoinColumn(name = "subjects_id") })
    private Set<Subject> subjects = new HashSet<Subject>();
    @Column
    private String speciality;

    public Teacher(String fio, String borndate, Set<Subject> subjects, String speciality) {
        this.fio = fio;
        this.borndate = borndate;
        this.subjects = subjects;
        this.speciality = speciality;
    }
    public Teacher()
    {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getBorndate() {
        return borndate;
    }

    public void setBorndate(String borndate) {
        this.borndate = borndate;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", borndate='" + borndate + '\'' +
                ", subjects=" + subjects +
                ", speciality='" + speciality + '\'' +
                '}';
    }
    public String parseIntoString()
    {
        String str = new String();
        for(Subject subject : this.getSubjects())
        {
            str += subject.getId();
            str+=" ";
        }
        str=str.substring(0,str.length()-1);
        return str;
    }
}
