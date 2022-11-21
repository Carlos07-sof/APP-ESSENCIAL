package com.example.proyectofinal;


import java.sql.Connection;
import java.sql.DriverManager;

public class Conecction {
    Connection conexion = null;
    public Connection conexionBD(){
        try{
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection("jdbc:postgresql://unach.cxn75w1he2hg.us-east-1.rds.amazonaws.com:5432/prueba1","postgres","ILikeIt2001");
            System.out.println("CONEXION "+conexion);
        }catch(Exception er){
            System.out.println("Conexion "+ conexion);
            System.out.println("ERROR DE CONEXION: "+er.getMessage());

        }
        return conexion;
    }
    protected void cerrarconexion(Connection conn) throws Exception{
        conn.close();
    }
}
