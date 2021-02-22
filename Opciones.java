

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Opciones {
    static List<Empleado> listEmpleado = new ArrayList<>();

    public static void agregar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite el Id del empleado ");
        try{
            int id = Integer.parseInt(scanner.nextLine());
            if(validarIdEmpleado(id)){
                System.out.println("El empleado con el id: "+id+" ya existe");
            }
            else{
                System.out.println("Digite el nombre del empleado");
                String nombre = scanner.nextLine();

                System.out.println("Digite el apellido del empleado");
                String apellido = scanner.nextLine();

                System.out.println("Digite el Salario del Empleado");
                int salario = scanner.nextInt();

                listEmpleado.add(new Empleado(id,nombre,apellido, salario));
                System.out.println("el empleado a sido creado satisfactoriamente");
            }
        }catch (NumberFormatException ex){
            System.out.println("verifique la entrada de su teclado" );
            agregar();
        }
        Menus ob1=new Menus();
        ob1.Menu();

    }
    public static void eliminar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite el Id del empleado a eliminar");
        int id = scanner.nextInt();
        if (validarIdEmpleado(id)) {
            for (Empleado empleado : listEmpleado){
                if(empleado.getId() == id){
                    listEmpleado.remove(empleado);
                    System.out.println("El empleado con el id: "+id+" se ha eliminado exitosamente");
                }
            }
        }else {
            System.out.println("No existe un empleado con el id: "+id);
            eliminar();
        }
        Menus ob1=new Menus();
        ob1.Menu();

    }
    public static void actualizar (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite el Id del empleado a actualizar");
        int id = Integer.parseInt(scanner.nextLine());

        if(validarIdEmpleado(id)){
            for (Empleado empleado : listEmpleado) {
                if (empleado.getId() == id) {
                    System.out.println("Digite el Nombre");
                    String nombres = scanner.nextLine();
                    System.out.println("Digite el Apellido");
                    String apellido = scanner.nextLine();
                    System.out.println("Digite el Salario");
                    int salario = scanner.nextInt();
                    empleado.setId(id);
                    empleado.setNombre(nombres);
                    empleado.setApellido(apellido);
                    empleado.setSalario(salario);
                    System.out.println("El empleado con el id: "+id+" la informacion ha sido modificada");
                }
            }
        }else{
            System.out.println("verifique el id del empleado: "+id);
            actualizar();
        }
        Menus ob1=new Menus();
        ob1.Menu();

    }
    public static void mostrar(){
        for(Empleado empleado : listEmpleado){
            System.out.println(empleado);
        }
        Menus ob1=new Menus();
        ob1.Menu();

    }
    private static boolean validarIdEmpleado (int id){
        for(Empleado empleado : listEmpleado){
            if(empleado.getId() == id){
                return true;
            }
        }
        return false;
    }
}
