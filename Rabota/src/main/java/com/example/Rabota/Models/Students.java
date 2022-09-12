package com.example.Rabota.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
@NotEmpty(message = "Заполните поле")
@Size(min = 2, max = 50,message = "Размер данного поля должен быть в диапазоне от 2 до 50")
    private String lastname,name,middlename;
    @NotEmpty(message = "Заполните поле")
private String birthday;

   @NotNull
   @Min(value = 0,message = "Минимальное 1")
    private int groupp;

    public long getId() {return id;}

    public void setId(long id) {
        this.id = id;}

    public String getLastname() {return lastname;}

    public void setLastname(String lastname) {this.lastname = lastname;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getMiddlename() {return middlename;}

    public void setMiddlename(String middlename) {this.middlename = middlename;}

    public String getBirthday() {return birthday;}

    public void setBirthday(String birthday) {this.birthday = birthday;}

    public int getGroupp() {return groupp;}

    public void setGroupp(int groupp) {this.groupp = groupp;}

    public Students() {}

    public Students(String lastname, String name, String middlename, String birthday, int groupp) {
        this.lastname = lastname;
        this.name = name;
        this.middlename = middlename;
        this.birthday = birthday;
        this.groupp = groupp;
    }


}

