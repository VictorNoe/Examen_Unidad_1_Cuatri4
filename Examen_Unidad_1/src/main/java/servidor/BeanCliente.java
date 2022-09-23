package servidor;

import java.util.Date;

public class BeanCliente {
    public String Nombre;
    public String Apellido1;
    public String Apellido2;
    public String curp;
    public String dia;
    public String mes;
    public String ano;
    public String rfc;

    public BeanCliente() {
    }

    public BeanCliente(String nombre, String apellido1, String apellido2, String curp, String dia, String mes, String ano, String rfc) {
        Nombre = nombre;
        Apellido1 = apellido1;
        Apellido2 = apellido2;
        this.curp = curp;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.rfc = rfc;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String apellido1) {
        Apellido1 = apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String apellido2) {
        Apellido2 = apellido2;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
}
