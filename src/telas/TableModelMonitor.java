/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import entidade.Monitor;
import entidade.MonitorModelo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author murilo.portugal
 */
public class TableModelMonitor extends AbstractTableModel{
    
    //Itens que estão sendo exibidos
    private ArrayList<MonitorModelo> monitores = new ArrayList<>();
    //Indices das colunas
    public static final int PATHFILE = 0;
    public static final int OCULTAR = 1;
    public static final int CAMINHOCOMPLETO = 2;
    //Nome das colunas
    private final String[] colunas = new String[]{"Pasta","Ocultar","Caminho Completo"};
    private MonitorModelo monitorModelo;
    public TableModelMonitor(ArrayList<Monitor> monitores) {
        
        this.monitores = new ArrayList<>();
            monitores.stream().forEach((Monitor monit)->{
            this.monitorModelo = new MonitorModelo();
            this.monitorModelo.setId_monitor(monit.getId_monitor());
            this.monitorModelo.setPathFile(monit.getPathFile());
            this.monitorModelo.setCurrentFileCount(monit.getCurrentFileCount());
            this.monitorModelo.setCurrentFileSize(monit.getCurrentFileSize());
            this.monitorModelo.setFileCount(monit.getFileCount());
            this.monitorModelo.setDirectoryCount(monit.getDirectoryCount());
            this.monitorModelo.setDirectorySize(monit.getDirectorySize());
            this.monitorModelo.setDirectorySizeOnDisk(monit.getDirectorySizeOnDisk());
            this.monitorModelo.setDirectorySizeGB(monit.getDirectorySizeGB());
            this.monitorModelo.setDataCriacao(monit.getDataCriacao());
            this.monitorModelo.setOculto(false);
            this.monitores.add(monitorModelo);
        });
    }
    
   
    
    
    
    @Override
    public int getRowCount() {
        return this.monitores.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MonitorModelo monitor = this.monitores.get(rowIndex);
        switch(columnIndex){
            case PATHFILE:
                return monitor.getPathFileClear();
            case OCULTAR:
                return monitor.isOculto();
            case CAMINHOCOMPLETO:
                return monitor.getPathFile();
            default:
                //não deve acontecer pois a tabela só tera 2 colunas
                throw new IndexOutOfBoundsException("Coluna ".concat(String.valueOf(columnIndex)).concat(" não existe"));
        }
    }
    
    public MonitorModelo getMonitorValueAt(int rowIndex){
        return this.monitores.get(rowIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        MonitorModelo monitor = this.monitores.get(rowIndex);
        switch(columnIndex){
            case OCULTAR:
                if(aValue instanceof Boolean){
                    monitor.setOculto((boolean)aValue);
                    this.monitores.set(rowIndex, monitor);
                }
                break;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == OCULTAR) {
            return true;
        }else{
            String objeto = (String) getValueAt(rowIndex, columnIndex);
            if (objeto == null) {
                return true;
            }else{
                return false;
            }
        }
    }
    
    //É aqui que esta o segredo para aparecer o checkbox
    //Você deve definir a classe da informação que deve ser
    //exibida para cada coluna, e para aparecer o checkbox deve ser Boolean.class
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case PATHFILE:
                return String.class;
            case OCULTAR:
                return Boolean.class;
            case CAMINHOCOMPLETO:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    public ArrayList<MonitorModelo> getMonitorOculto(){
        ArrayList<MonitorModelo> monitoresOculto = new ArrayList<>();
        //Retorna somente os monitores que não estão setados como oculto
        this.monitores.stream().filter(monit -> !monit.isOculto()).forEach((monit)->{
            monitoresOculto.add(monit);
        });
        
        return monitoresOculto;
    }
    
    
    
}
