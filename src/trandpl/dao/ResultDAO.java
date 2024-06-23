/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trandpl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trandpl.dbutil.DBconnection;
import trandpl.pojo.ParticipantJobPojo;
import trandpl.pojo.ParticipantResultPojo;
import trandpl.pojo.ResultsPojo;

/**
 *
 * @author aadarsh jain
 */
public class ResultDAO {
    public static boolean applyForJob(ResultsPojo result) throws SQLException{
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from sys.results where participantid=? and jobsid=?");
        ps.setString(1, result.getpId());
        ps.setString(2, result.getJobId());
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            return false;
        }
        ps=conn.prepareStatement("insert into sys.results values(?,?,?,?)");
         ps.setString(1, result.getpId());
        ps.setString(2, result.getJobId());
         ps.setDouble(3, result.getPercentage());
        ps.setString(4, result.getSelectedByHr());
        return 1==ps.executeUpdate();
    }
    
    public static List<ParticipantJobPojo> getAllAppliedJobs(String participantId) throws SQLException{
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select sys.jobs.jobid ,sys.jobs.jobtitle,companyname , tags from sys.jobs,sys.results,sys.Hr where sys.jobs.jobid=sys.results.jobsid and sys.jobs.hid=sys.Hr.hrid and participantid=? and percentage = -1");
        ps.setString(1, participantId);
        List<ParticipantJobPojo> allAppliedJobsList=new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            ParticipantJobPojo pj=new ParticipantJobPojo();
            pj.setJobId(rs.getString(1));
            pj.setJobTitle(rs.getString(2));
            pj.setCompanyName(rs.getString(3));
            pj.setTags(rs.getString(4));
            allAppliedJobsList.add(pj);
        }
        return allAppliedJobsList;
    }
    
    public static boolean setResult(ResultsPojo result)throws SQLException{
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update sys.results set percentage = ? where participantid=? and jobsid=?");
        ps.setDouble(1, result.getPercentage());
        ps.setString(2, result.getpId());
        ps.setString(3, result.getJobId());
        return 1==ps.executeUpdate();
    }
    
    public static List<ParticipantResultPojo> getAllCompletedJobs(String participantId) throws SQLException{
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select sys.jobs.jobid,sys.jobs.jobtitle,sys.Hr.companyname,sys.jobs.tags,sys.results.percentage from sys.jobs,sys.Hr,sys.results where sys.jobs.jobid=sys.results.jobsid and sys.jobs.hid=sys.Hr.hrid and sys.results.percentage != -1 and sys.results.participantid=?");
        ps.setString(1, participantId);
        ResultSet rs=ps.executeQuery();
        List<ParticipantResultPojo> allResultList=new ArrayList<>();
        while(rs.next()){
            ParticipantResultPojo result=new ParticipantResultPojo();
            result.setJobId(rs.getString(1));
            result.setJobTitle(rs.getString(2));
            result.setCompanyName(rs.getString(3));
            result.setTags(rs.getString(4));
            result.setPercentage(rs.getDouble(5));
            allResultList.add(result);
        }
        return allResultList;
    }
    public static boolean participantSelected(ResultsPojo result) throws SQLException{
        Connection conn=DBconnection.getConnection();
        //update sys.participants set resume=? where pid=?
        PreparedStatement ps = conn.prepareStatement("update sys.results set selectedbyhr = ? where participantid=?");
         ps.setString(1, result.getSelectedByHr());
        ps.setString(2, result.getpId());
         
        return 1==ps.executeUpdate();
    }
}
