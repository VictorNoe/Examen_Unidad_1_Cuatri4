package servidor;

public class Methods {
    public String savePersona (String name, String apellido1, String apellido2, String curp, String dia, String mes, String ano, String rfc){
        DaoCliente daoCliente = new DaoCliente();
        boolean result = daoCliente.savePersona(name, apellido1, apellido2, curp, dia, mes, ano, rfc);
        return rfc;
    }

    public String mostrarUsuario (String curp) {
        DaoCliente daoCliente = new DaoCliente();
        BeanCliente ressult = daoCliente.mostrarUsuario(curp);
        return "---Datos Usuario---\n"+ressult;
    }

    public String eliminarPersona (String curp) {
        DaoCliente daoCliente = new DaoCliente();
        daoCliente.eliminarPersona(curp);
        return "---Persona eliminada correcatamente---";
    }

    public String modificar (String curp){
        return "Proceso de Modificacion";
    }
}
