public class Empleado {

    private int Id;
    private String Nombre;
    private String Apellido;
    private int Salario;

    public Empleado(int id, String nombre, String apellido, int salario) {
        Id = id;
        Nombre = nombre;
        Apellido = apellido;
        Salario = salario;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getSalario() {
        return Salario;
    }

    public void setSalario(int salario) {
        Salario = salario;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + " Nombre: " + getNombre() + " Apellido: " + getApellido() + " Salario: "
                + getSalario();
    }
}
