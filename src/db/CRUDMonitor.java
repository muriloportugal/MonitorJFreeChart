/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entidade.Monitor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author murilo.portugal
 */
public class CRUDMonitor {
    
    private ArrayList<Monitor> monitorList;
    private Connection sqlConnection;
    private PreparedStatement pstmt;
    private ResultSet result;
    
    public ArrayList<Monitor> getAllMonitor(boolean groupByPathFile){
        this.sqlConnection = new ConexaoSqlite().conectar();
        String sqlSelect;
        if (groupByPathFile) {
            sqlSelect = "SELECT *, (DirectorySize /1073741824) as DirectorySizeGB " +
                                    "FROM monitor WHERE DirectorySizeGB > 5 " +
                                    "group by Pathfile " +
                                    "order by DirectorySizeGB;";
        }else{
            sqlSelect = "SELECT *, (DirectorySize /1073741824) as DirectorySizeGB " +
                                    "FROM monitor WHERE DirectorySizeGB > 5 " +
                                    "order by Pathfile, datacriacao;";
        }
        try {
            this.pstmt = this.sqlConnection.prepareStatement(sqlSelect);
            result = this.pstmt.executeQuery();
            this.monitorList = new ArrayList<>();
            while (result.next()) {
                Monitor monitor = new Monitor();
                monitor.setId_monitor(result.getInt("id_monitor"));
                monitor.setPathFile(result.getString("PathFile"));
                monitor.setCurrentFileCount(result.getInt("CurrentFileCount"));
                monitor.setCurrentFileSize(result.getInt("CurrentFileSize"));
                monitor.setFileCount(result.getInt("FileCount"));
                monitor.setDirectoryCount(result.getInt("DirectoryCount"));
                monitor.setDirectorySize(result.getInt("DirectorySize"));
                monitor.setDirectorySizeOnDisk(result.getInt("DirectorySizeOnDisk"));
                monitor.setDirectorySizeGB(result.getInt("DirectorySizeGB"));
                monitor.setDataCriacao(result.getString("DataCriacao"));
                monitorList.add(monitor);
            }
            
            this.sqlConnection.close();
            this.result.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDMonitor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.monitorList;
    }
    
    public List<Monitor> getMonitor(String PathFile){
        this.sqlConnection = new ConexaoSqlite().conectar();
        String sqlSelect = "SELECT *, (DirectorySize /1073741824) as DirectorySizeGB " +
                                    "FROM monitor where Pathfile = ?" +
                                    "order by Pathfile, datacriacao;";
        
        try {
            this.pstmt = this.sqlConnection.prepareStatement(sqlSelect);
            this.pstmt.setString(1, PathFile);
            result = this.pstmt.executeQuery();
            this.monitorList = new ArrayList<>();
            while (result.next()) {
                Monitor monitor = new Monitor();
                monitor.setId_monitor(result.getInt("id_monitor"));
                monitor.setPathFile(result.getString("PathFile"));
                monitor.setCurrentFileCount(result.getInt("CurrentFileCount"));
                monitor.setCurrentFileSize(result.getInt("CurrentFileSize"));
                monitor.setFileCount(result.getInt("FileCount"));
                monitor.setDirectoryCount(result.getInt("DirectoryCount"));
                monitor.setDirectorySize(result.getInt("DirectorySize"));
                monitor.setDirectorySizeOnDisk(result.getInt("DirectorySizeOnDisk"));
                monitor.setDirectorySizeGB(result.getInt("DirectorySizeGB"));
                monitor.setDataCriacao(result.getString("DataCriacao"));
                monitorList.add(monitor);
            }
            
            this.sqlConnection.close();
            this.result.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDMonitor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.monitorList;
    }
    
    
}
