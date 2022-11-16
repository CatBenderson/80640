package mx.uv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO {
    public static Conexion c = new Conexion();

    public static List<Usuario> dameUsuarios(){
        Statement stm=null;
        ResultSet rs = null;
        List<Usuario> resultado = new ArrayList<>();
        Connection cc =null;

        cc = c.getConnection();
        try {
            String sql = "select * from usuarios";
            stm = (Statement) cc.createStatement();
            rs = ((java.sql.Statement) stm).executeQuery(sql);
            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("id"),
                 rs.getString("nombre"), rs.getString("password"));
                 resultado.add(u);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // vamos a liberar en este bloque todos los recursos empleando
            // se hace en orden inverso a su creación
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
                rs = null;
            }

            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
                stm = null;
            }
            try {
                cc.close();
                System.out.println("Closed  connection!");
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }
        
        return resultado;
    }

    public static String crearUsuario(Usuario u){
        PreparedStatement stm =null;
        Connection cc=null;
        String message = "";

        cc = c.getConnection();

        try {
            String sql = "insert into usuarios(id,nombre, password) values (?,?,?)";
            stm=cc.prepareStatement(sql);
            stm.setString(1, u.getId());
            stm.setString(2, u.getNombre());
            stm.setString(3, u.getPassword());

            if (stm.executeUpdate()>0){
                message = "el usuario se agregó";
            }else{
                message="el usuario no se agregó";
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
                stm = null;
            }
            try {
                cc.close();
                System.out.println("Closed  connection!");
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }
        
        return message;
    }
}