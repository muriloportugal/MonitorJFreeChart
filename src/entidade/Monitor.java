/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author murilo.portugal
 */
public class Monitor {
    
    private int id_monitor;
    private String pathFile;
    private int currentFileCount;
    private int currentFileSize;
    private int fileCount;
    private int directoryCount;
    private int directorySize;
    private int directorySizeOnDisk;
    private int directorySizeGB;
    private String dataCriacao;

    public Monitor() {
    }

    public int getId_monitor() {
        return id_monitor;
    }

    public void setId_monitor(int id_monitor) {
        this.id_monitor = id_monitor;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public int getCurrentFileCount() {
        return currentFileCount;
    }

    public void setCurrentFileCount(int currentFileCount) {
        this.currentFileCount = currentFileCount;
    }

    public int getCurrentFileSize() {
        return currentFileSize;
    }

    public void setCurrentFileSize(int currentFileSize) {
        this.currentFileSize = currentFileSize;
    }

    public int getFileCount() {
        return fileCount;
    }

    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }

    public int getDirectoryCount() {
        return directoryCount;
    }

    public void setDirectoryCount(int directoryCount) {
        this.directoryCount = directoryCount;
    }
    
    public int getDirectorySize() {
        return directorySize;
    }

    public void setDirectorySize(int directorySize) {
        this.directorySize = directorySize;
    }
    
    public int getDirectorySizeOnDisk() {
        return directorySizeOnDisk;
    }

    public void setDirectorySizeOnDisk(int directorySizeOnDisk) {
        this.directorySizeOnDisk = directorySizeOnDisk;
    }
    
    public int getDirectorySizeGB() {
        return directorySizeGB;
    }

    public void setDirectorySizeGB(int directorySizeGB) {
        this.directorySizeGB = directorySizeGB;
    }
    
    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        String monitorString = this.getPathFile().substring(this.getPathFile().lastIndexOf("\\")+1, this.getPathFile().length());
        return monitorString;
    }
    
    public String stringfyMonitor(){
        String stringfyMonitor = this.getPathFile().concat(" ")
                .concat(String.valueOf(this.getDirectorySizeGB())).concat(" ")
                .concat(this.getDataCriacao());
        return stringfyMonitor;
    }
    
   public String getPathFileClear(){
       String nomePasta;
       if (this.getPathFile().equals("d:\\")) {
           nomePasta = "D:\\";
       }else{
           nomePasta = this.getPathFile().substring(this.getPathFile().lastIndexOf("\\")+1, this.getPathFile().length());
       }
       return nomePasta;
   }
       
}