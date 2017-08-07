/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cme.mBeans.settings.transactions;


//import com.jcraft.jsch.;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServlet;
//import org.apache.commons.codec.binary.Base64;
/**
 *
 * @author admin
 */
@ManagedBean(name = "dashBoard")
@SessionScoped

public class dashBoardBean extends HttpServlet {

  private FacesContext ctx = FacesContext.getCurrentInstance();
  private int numbOfConnections = 0;
  private String[] runnerFile = null;
  private String[] bindFile = null;
  private String[] startSystemScript = null;
  private String[] stopSystemScript = null;
  private String VpnStatusFile  = ctx.getExternalContext().getInitParameter("VPNStatus");
  private boolean VpnStatus ;
        
    private boolean[] smscBind = null; 
    private boolean[] systemUp = null;
    private String[] systemName = null;
    private Date[] runDate;
    private String[] systemID, processID, actionMessage;
    private List<DashboardStatus> dashboardStatus = new ArrayList<DashboardStatus>();
          
        public dashBoardBean()
        {
            numbOfConnections = Integer.parseInt(ctx.getExternalContext().getInitParameter("connectionNumber"));
            if (numbOfConnections > 0){
                runnerFile = new String[numbOfConnections];
                bindFile = new String[numbOfConnections];
                startSystemScript = new String[numbOfConnections];
                stopSystemScript = new String[numbOfConnections];
                smscBind = new boolean[numbOfConnections];
                systemUp = new boolean[numbOfConnections];
                systemName = new String[numbOfConnections];
                runDate = new Date[numbOfConnections];
                systemID = new String[numbOfConnections];
                processID = new String[numbOfConnections];
                actionMessage = new String[numbOfConnections];
                
                for(int i=0;i<numbOfConnections;i++){
                    runnerFile[i] = ctx.getExternalContext().getInitParameter("runnerPath"+i);
                    bindFile[i] = ctx.getExternalContext().getInitParameter("binderPath"+i);
                    startSystemScript[i] = ctx.getExternalContext().getInitParameter("starter"+i);
                    stopSystemScript[i] = ctx.getExternalContext().getInitParameter("stopper"+i);
                    systemName[i] = ctx.getExternalContext().getInitParameter("systemName"+i);
                }
      
            }
    
            
        }

    public List<DashboardStatus> getDashboardStatus() {
        return dashboardStatus;
    }

    public String getActionMessage(int i)
    {
        return actionMessage[i];
    }
    public String[] getRunnerFile() {
        return runnerFile;
    }

    public void setRunnerFile(String[] runnerFile) {
        this.runnerFile = runnerFile;
    }

    public String[] getBindFile() {
        return bindFile;
    }

    public void setBindFile(String[] bindFile) {
        this.bindFile = bindFile;
    }

    public boolean isSmscBind(int i) {
        return smscBind[i];
    }

    public void setSmscBind(boolean smscBind, int i) {
        this.smscBind[i] = smscBind;
    }

    public boolean isSystemUp(int i) {
        return systemUp[i];
    }

    public void setSystemUp(boolean systemUp, int i) {
        this.systemUp[i] = systemUp;
    }

    public String getVpnStatusFile() {
        return VpnStatusFile;
    }

    public void setVpnStatusFile(String VpnStatusFile) {
        this.VpnStatusFile = VpnStatusFile;
    }

    public boolean isVpnStatus() {
        return VpnStatus;
    }

    public void setVpnStatus(boolean VpnStatus) {
        this.VpnStatus = VpnStatus;
    }
    
    public Date getRunDate(int i) {
        return runDate[i];
    }

    public void setRunDate(Date runDate, int i) {
        this.runDate[i] = runDate;
    }

    public String getSystemID(int i) {
        return systemID[i];
    }

    public void setSystemID(String systemID,int i) {
        this.systemID[i] = systemID;
    }

    public String getProcessID(int i) {
        return processID[i];
    }

    public void setProcessID(String processID,int i) {
        this.processID[i] = processID;
    }
    
    
private void checkVpnStatus()
{
     BufferedReader br = null;
        File file = null;
        try {
            file = new File (VpnStatusFile);
            br = new BufferedReader(new FileReader(file));
            String st;
            while((st=br.readLine()) != null){
                System.out.println(st);
            }
            if (!st.isEmpty() && ! st.equals("")){
                if(st.startsWith("VPNC is already running")){
                    setVpnStatus(true);
            
}
                else {
                    setVpnStatus(false);
                }
                
}
            else {
                 setVpnStatus(false);
            }
  
        }  catch (FileNotFoundException ex) {
          Logger.getLogger(dashBoardBean.class.getName()).log(Level.SEVERE, null, ex);
  
              } catch (IOException ex) {
          Logger.getLogger(dashBoardBean.class.getName()).log(Level.SEVERE, null, ex);
      }
        
}
private void checkSystemState(int connectionId){

        BufferedReader br = null;
        File file = null;
        
        try {
            file = new File(runnerFile[connectionId]);
            br = new BufferedReader(new FileReader(file));
            String st, line="", dateString = "";
            String startTerm = "Start & Running on:";
            String processTerm = "Process ID:";
            DateFormat df = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy");
            while((st=br.readLine()) != null){
//                System.out.println("String in line: "+st);
                line = st;
            }
             if (!line.isEmpty() && ! line.equals("")){
                if(line.startsWith("#"+startTerm) || line.startsWith(startTerm)){
                    setSystemUp(true,connectionId);
                    dateString = line.substring(line.lastIndexOf(startTerm) + startTerm.length(),line.indexOf(processTerm)).trim();
//                    System.out.println("PARAM1: "+dateString);
//                    System.out.println("PARAM2: "+line.substring(line.lastIndexOf(processTerm) + processTerm.length()).trim());
                    runDate[connectionId] = df.parse(dateString);
                    processID[connectionId] = line.substring(line.lastIndexOf(processTerm) + processTerm.length()).trim();
                }
                else
                {
                    setSystemUp(false,connectionId);
                    runDate[connectionId] = null;
                    processID[connectionId] = "";
                }
            }
            else
            {
                setSystemUp(false,connectionId);
                runDate[connectionId] = null;
                processID[connectionId] = "";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(dashBoardBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(dashBoardBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(dashBoardBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                Logger.getLogger(dashBoardBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    
    public void checkBindStatus(int connectionId){
        BufferedReader br = null;
        File file = null;
        try {

//             System.out.println("CHECK THE BINDING.....");
            file = new File(bindFile[connectionId]);
           
//            System.out.println(file);
            br = new BufferedReader(new   FileReader(file));
            String st, line = "";
            String connectTerm = "CONNECTED and BIND";
            String smscTerm = "SMSC_SYSTEM_ID:";
//             System.out.println("File READ........");
            while((st=br.readLine()) != null){
//                System.out.println(st);
                line = st;
            }
            if (!line.isEmpty() && ! line.equals("")){
                if(line.startsWith(connectTerm)){
                    setSmscBind(true,connectionId);
                    setSystemID(line.substring(line.lastIndexOf(smscTerm)+smscTerm.length()).trim(),connectionId);
                }
                else
                {
                    setSmscBind(false,connectionId);
                    setSystemID("",connectionId);
                }
                
            }
            else
            {
                setSmscBind(false,connectionId);
                setSystemID("",connectionId);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(dashBoardBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(dashBoardBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(br != null)
                    br.close();
            } catch (IOException ex) {
                Logger.getLogger(dashBoardBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
    public String retrieveStatus( boolean s)  {
        DashboardStatus status;
        dashboardStatus.clear();
        for(int i=0;i<numbOfConnections;i++)
        {
            checkSystemState(i);
            checkBindStatus(i);
//            actionMessage[i] = "";
            status = new DashboardStatus(systemUp[i],smscBind[i],runDate[i],processID[i],systemID[i],systemName[i]);
            dashboardStatus.add(status);
        }

     
        return "";
    }
    
    public void stopVpn() throws FileNotFoundException, IOException 
    {
     
    }
     public void startVpn() throws FileNotFoundException, IOException 
    {
     
    }
    
       public void startSystem(int i) throws IOException
    {
      Process executer =  new ProcessBuilder(startSystemScript[i]).start();
    }
       
       
    public void stopSystem(int i) throws IOException
    {
        BufferedReader br = null;
        File file = null;
        long modifiedOn, temp, timer = 0;
        
        file = new File(runnerFile[i]);
        modifiedOn = file.lastModified();
        //Change the systemUp status to be false, progressStatus to true
        System.out.println("Stop no: "+i);
        System.out.println("Execute file: "+stopSystemScript[i]);
        Process executer =  new ProcessBuilder(stopSystemScript[i],runnerFile[i]).start();
        System.out.println("Executer: "+executer.toString() +" Live: "+executer.isAlive());
        
        //To check the status of execution result, it is worked or not
        // if it works, I will keep systemUp status to false, progressStatus to false
        // if it doesn't work, then systemUp status to it is original status "true", progress to false, and display any message
        
        
        try {
            while((temp = file.lastModified()) == modifiedOn )
            {
                timer = timer + 500;
                if(timer >= 5000)
                    break;
                Thread.sleep(timer);
            }
            br = new BufferedReader(new FileReader(file));
            
            String st, line="", dateString = "";
            String startTerm = "Start & Running on:";
            String processTerm = "Process ID:";
            DateFormat df = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy");
            while((st=br.readLine()) != null){
//                System.out.println("String in line: "+st);
                line = st;
            }
             if (!line.isEmpty() && ! line.equals("")){
                if(line.startsWith("#"+startTerm) || line.startsWith(startTerm)){
                    //Still running
                    
                    actionMessage[i] = "Failed to stop system, please try again...";
                    
                }
                else
                {
                    //Stop successfully
                    actionMessage[i] = "System stopped successfully...";
                    retrieveStatus(false);
                    Thread.sleep(1000);
                    
                }
            }
            else
            {
                //line is empty So please check the system manually (Contact your administrator)
                actionMessage[i] = "Failed to stop system, please contact your administrator...";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(dashBoardBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(dashBoardBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
          Logger.getLogger(dashBoardBean.class.getName()).log(Level.SEVERE, null, ex);
      }  finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                Logger.getLogger(dashBoardBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public class DashboardStatus {
        private boolean systemUp;
        private boolean connectionBind;
        private Date runOnDate;
        private String pId, sysId,systemName;
        
        public DashboardStatus(){
            systemUp = false;
            connectionBind = false;
            runOnDate = null;
            pId = "";
            sysId = "";
            systemName = "";
        }
        
        public DashboardStatus(boolean sysUp,boolean connBind, Date runOn, String pid,String sysid, String sysName){
            systemUp = sysUp;
            connectionBind = connBind;
            runOnDate = runOn;
            pId = pid;
            sysId = sysid;
            systemName = sysName;
        }

        public boolean isSystemUp() {
            return systemUp;
        }

        public boolean isConnectionBind() {
            return connectionBind;
        }

        public Date getRunOnDate() {
            return runOnDate;
        }

        

        public String getSysId() {
            return sysId;
        }

        public String getSystemName() {
            return systemName;
        }

        public void setSystemUp(boolean systemUp) {
            this.systemUp = systemUp;
        }

        public void setConnectionBind(boolean connectionBind) {
            this.connectionBind = connectionBind;
        }

        public void setRunOnDate(Date runOnDate) {
            this.runOnDate = runOnDate;
        }

        public String getPId() {
            return pId;
        }

        public void setPId(String pId) {
            this.pId = pId;
        }

       

        public void setSysId(String sysId) {
            this.sysId = sysId;
        }

        public void setSystemName(String systemName) {
            this.systemName = systemName;
        }
        
        
        
        
    }
    
    
    }
    

        
        
    

  

    
    
    

