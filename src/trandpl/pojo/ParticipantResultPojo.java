/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trandpl.pojo;

/**
 *
 * @author aadarsh jain
 */
public class ParticipantResultPojo extends ParticipantJobPojo {

    public String getPname() {
        return Pname;
    }

    public void setPname(String Pname) {
        this.Pname = Pname;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    private double percentage;
    private String Pname;
    private String pid;
}
