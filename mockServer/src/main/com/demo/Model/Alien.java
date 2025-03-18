package main.com.demo.Model;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Alien {
    int aid;
    private String aname;
    private String tech;

    @JsonGetter("id")
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @JsonGetter("name")
    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @JsonGetter("tech")
    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }
}
