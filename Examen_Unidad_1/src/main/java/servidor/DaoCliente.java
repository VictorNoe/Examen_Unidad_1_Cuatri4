package servidor;

import MySQL.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoCliente {
    public boolean savePersona(String nombre, String apellido1, String apellido2, String curp, String dia, String mes, String ano, String rfc) {
        boolean result = false;
        try
                (Connection con = MySQLConnection.getConnection();
                 PreparedStatement pstm = con.prepareStatement("insert into persons (nombre,apellido1,apellido2,curp,dia,mes,ano,rfc) values (?,?,?,?,?,?,?,?);");
                ){
            pstm.setString(1,nombre);
            pstm.setString(2,apellido1);
            pstm.setString(3,apellido2);
            pstm.setString(4,curp);
            pstm.setString(5,dia);
            pstm.setString(6,mes);
            pstm.setString(7,ano);
            pstm.setString(8,rfc);
            result = pstm.executeUpdate() == 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    public BeanCliente mostrarUsuario(String curp) {
        BeanCliente cliente = new BeanCliente();
        try (
                Connection con = MySQLConnection.getConnection();
                PreparedStatement pstm = con.prepareStatement("select * from persons where curp = ?;");
        ){
            pstm.setString(1,curp);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido1(rs.getString("apellido1"));
                cliente.setApellido2(rs.getString("apellido2"));
                cliente.setCurp(rs.getString("curp"));
                cliente.setDia(rs.getString("dia"));
                cliente.setMes(rs.getString("mes"));
                cliente.setAno(rs.getString("ano"));
                cliente.setRfc(rs.getString("rfc"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }return cliente;
    }

    public boolean eliminarPersona(String curp) {
        boolean result = false;
        try(
                Connection con = MySQLConnection.getConnection();
                PreparedStatement pstm = con.prepareStatement("delete from persons where curp=?;");
        ){
            pstm.setString(1,curp);
            result = pstm.executeUpdate()==1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public boolean updateperson(BeanCliente persona_act) {
        boolean result = false;
        try (
                Connection con = MySQLConnection.getConnection();
                PreparedStatement pstm = con.prepareStatement("update persons set nombre=?,apellido1=?,apellido2=?,curp=?,dia=?,mes=?,ano=?,rfc=? where curp = ?");
        ){
            pstm.setString(1, persona_act.getNombre());
            pstm.setString(2, persona_act.getApellido1());
            pstm.setString(3, persona_act.getApellido2());
            pstm.setString(4, persona_act.getCurp());
            pstm.setString(5, persona_act.getDia());
            pstm.setString(6, persona_act.getMes());
            pstm.setString(7, persona_act.getAno());
            pstm.setString(8, persona_act.getRfc());
            result = pstm.executeUpdate()==1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
