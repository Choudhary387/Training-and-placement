/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trandpl.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import trandpl.dbutil.DBconnection;
import trandpl.pojo.ParticipantResultPojo;
import trandpl.pojo.ParticipantsPojo;


public class ParticipantsDAO {
   public static int getNewParticipantId() throws SQLException{
        Connection conn=DBconnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(pid) from sys.participants");
        int pId=101;
        rs.next();
            String strid=rs.getString(1);
            if(strid!=null){
            String id=strid.substring(2);
            pId=Integer.parseInt(id)+1;
            }
        return pId;
    }
    
    public static int addNewParicipant(ParticipantsPojo pt)throws SQLException,FileNotFoundException{
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select userid from sys.USERS where userid=?");
        ps.setString(1, pt.getUserId().toUpperCase().trim());    
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            return -1;
        }
        ps=conn.prepareStatement("insert into sys.USERS values(?,?,?,?,?,?)");
        ps.setString(1, pt.getUserId());
        ps.setString(2, pt.getId());
        ps.setString(3, pt.getName());
        ps.setString(4, pt.getPassword());
        ps.setString(5, pt.getType());
        ps.setString(6, "Y");
        int x=ps.executeUpdate();
        
        int y=0;
        if(x==1){
            ps=conn.prepareStatement("insert into sys.participants values(?,?,?,?,?)");
            ps.setString(1, pt.getId());
            ps.setString(2, pt.getPhone());
            ps.setString(3, pt.getSkills());
            ps.setString(4, pt.getQualifications());
            File f=pt.getResume();
            InputStream fin=new FileInputStream(f.getPath());
            ps.setBlob(5, fin);
            y=ps.executeUpdate();
        }
        return y;
    }

    public static ParticipantsPojo getParticipantById(String id) throws SQLException{
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select name , userid,phone from sys.USERS , sys.participants where sys.USERS.id=sys.participants.pid and pid=?");
        ps.setString(1, id);    
        ResultSet rs=ps.executeQuery();
        rs.next();
        ParticipantsPojo pt=new ParticipantsPojo();
        pt.setName(rs.getString(1));
        pt.setUserId(rs.getString(2));
        pt.setPhone(rs.getString(3));
        return pt;
    }
    
    public static boolean updateResume(String pId,File resume) throws SQLException,FileNotFoundException{
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update sys.participants set resume=? where pid=?");
        FileInputStream fobj = new FileInputStream(resume);
        ps.setBlob(1, fobj);
        ps.setString(2, pId);
        
        return ps.executeUpdate()==1;
    }
    
   public static List<ParticipantsPojo> getStudents() throws SQLException{
   Connection conn=DBconnection.getConnection();
   Statement st=conn.createStatement();
   ResultSet rs=st.executeQuery("select pid , sys.USERS.name,qualification,skills,phone "
   + "from sys.participants,sys.USERS where sys.participants.pid=sys.USERS.id order by sys.participants.pid");
    
      List<ParticipantsPojo> allStudentsList = new ArrayList();
        while(rs.next()){
            ParticipantsPojo obj=new ParticipantsPojo();
            obj.setId(rs.getString(1));
            obj.setName(rs.getString(2));
            obj.setQualifications(rs.getString(3));
            obj.setSkills(rs.getString(4));
            obj.setPhone(rs.getString(5));
            allStudentsList.add(obj);
        }
        return allStudentsList;   
   }
   
   public static List<ParticipantResultPojo> getAllParticipant()throws SQLException{
    Connection conn=DBconnection.getConnection();
   Statement st=conn.createStatement();
   ResultSet rs=st.executeQuery("select participantid , sys.USERS.name,sys.Hr.companyname,sys.jobs.jobtitle,percentage "
   + "from sys.results,sys.USERS,sys.Hr,sys.jobs where sys.Hr.hrid=sys.jobs.hid and sys.jobs.jobid=sys.results.jobsid and sys.USERS.id=sys.results.participantid order by sys.results.participantid");
         List<ParticipantResultPojo> allParticipantList = new ArrayList();
        while(rs.next()){
            ParticipantResultPojo obj=new ParticipantResultPojo();
            obj.setPid(rs.getString(1));
            obj.setPname(rs.getString(2));
            obj.setCompanyName(rs.getString(3));
            obj.setJobTitle(rs.getString(4));
            obj.setPercentage(rs.getDouble(5));
            allParticipantList.add(obj);
        }
        return allParticipantList;   
   }
   
   public static ParticipantsPojo getParticipantDetails(String pid)throws SQLException{
       Connection conn=DBconnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("select pid,sys.USERS.name,phone ,sys.USERS.userid,skills,qualification from sys.USERS,sys.participants where sys.participants.pid=? and sys.participants.pid=sys.USERS.id");
       ps.setString(1, pid);
       ResultSet rs=ps.executeQuery();
       rs.next();
            ParticipantsPojo participant=new ParticipantsPojo();
            participant.setId(rs.getString(1));
            participant.setName(rs.getString(2));
            participant.setPhone(rs.getString(3));
            participant.setUserId(rs.getString(4));
            participant.setSkills(rs.getString(5));
            participant.setQualifications(rs.getString(6));

        return participant;
   }
   
   public static Blob getParticipantsResume(String pid) throws SQLException{
       Connection conn=DBconnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("select resume from sys.participants where pid=?");
       ps.setString(1, pid);
       ResultSet rs=ps.executeQuery();
       if(rs.next())
           return rs.getBlob(1);
       else
           return null;
   }
   
    public static List<ParticipantsPojo> getSelectedStudents() throws SQLException{
   Connection conn=DBconnection.getConnection();
   Statement st=conn.createStatement();
   ResultSet rs=st.executeQuery("select distinct pid ,  sys.USERS.name,  qualification,skills,phone \n" +
"   from sys.results, sys.participants ,sys.USERS where sys.participants.pid=sys.USERS.id and sys.results.selectedbyhr = 'Yes' order by sys.participants.pid ");
    
      List<ParticipantsPojo> allStudentsList = new ArrayList();
        while(rs.next()){
            ParticipantsPojo obj=new ParticipantsPojo();
            obj.setId(rs.getString(1));
            obj.setName(rs.getString(2));
            obj.setQualifications(rs.getString(3));
            obj.setSkills(rs.getString(4));
            obj.setPhone(rs.getString(5));
            allStudentsList.add(obj);
        }
        return allStudentsList;   
   }
    public static String getParticipantUserId(String pid) throws SQLException{
         Connection conn=DBconnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("select userId from sys.USERS where id=?");
       ps.setString(1, pid);
       ResultSet rs=ps.executeQuery();
       rs.next();
           return rs.getString(1);
    }
}
