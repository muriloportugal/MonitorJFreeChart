/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author murilo.portugal
 */
public class ConexaoSqlite {
    private Connection conexao = null;

    public ConexaoSqlite() {
    }
    
    public Connection conectar(){
        /**
         * Conecta ao banco de dados ou o cria caso ele nao exista
         */
        try {
            String url = "jdbc:sqlite:D:/Bibliotecas/Desktop/monitordb";
            this.conexao = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return this.conexao;
    }
    
//    public boolean desconectar(){
//        try {
//            if(this.conexao.isClosed() == false){
//                this.conexao.close();
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
//        return true;
//    }
}
