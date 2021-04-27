/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import company.Tools;
import javax.swing.JTable;

/**
 *
 * @author toshiba
 */
public class Project implements mainData {
    private int projectNo;
    private String projectName;
    private String Location;
    private int deptNo;

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public void add() {
    String strInsert= "insert into Project values("
            +projectNo+", "
            +"'"+projectName+"',"
            +"'"+Location+"',"
            +deptNo+")";
    boolean isAdd=db.go.runNonQuery(strInsert);
    if(isAdd){
    Tools.MsgBox("Project is Added...");
    }       
    }

    @Override
    public void update() {
    String strUpdate="update project set "
            +"projectName='"+projectName+"',"
            +"Location='"+Location+"',"
            +"deptNo="+deptNo
            +" where projectNo="+projectNo;
    boolean isUpdate=db.go.runNonQuery(strUpdate);
    if(isUpdate){
    Tools.MsgBox("Project is Updated...");
    }
    }

    @Override
    public void delete() {
    String strDelete="delete from project "
            +"where projectNo="+projectNo;
    boolean isDelete=db.go.runNonQuery(strDelete);
    if(isDelete){
    Tools.MsgBox("Project is Deleted");
    }
    }

    @Override
    public String getAutoNumber() {
   return db.go.getAutoNumber("project", "projectNo");
    }

    @Override
    public void getAllRows(JTable table) {
    db.go.fillToJTable("project_data", table);
    }

    @Override
    public void getOneRow(JTable table) {
    String strSelect="select * from project_data "
            +"where project_No="+projectNo;
    db.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
    db.go.fillToJTable(statement, table);
    }

    @Override
    public String getValueByName(String name) {
    String strSelect="select projectNo from project "
            +"where projectName='"+projectName+"'";
    String strVal= (String)db.go.getDataTable(strSelect).Items[0][0];
    return strVal;
    }

    @Override
    public String getNameByValue(String value) {
   String strSelect="select projectName from project "
           +"where prjectNo="+projectNo;
    String strName=(String)db.go.getDataTable(strSelect).Items[0][0];
    return strName;
    }
    
    
    
    
}
