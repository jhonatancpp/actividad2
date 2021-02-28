
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Comparator;


public class Opciones {
    static List<Empleado> listEmpleado = new ArrayList<>();

    public static void agregar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite el Id del empleado ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            if (validarIdEmpleado(id)) {
                System.out.println("El empleado con el id: " + id + " ya existe");
            } else {
                System.out.println("Digite el nombre del empleado");
                String nombre = scanner.nextLine();

                System.out.println("Digite el apellido del empleado");
                String apellido = scanner.nextLine();

                System.out.println("Digite el Salario del Empleado");
                int salario = scanner.nextInt();

                listEmpleado.add(new Empleado(id, nombre, apellido, salario));
                System.out.println("el empleado a sido creado satisfactoriamente");
            }
        } catch (NumberFormatException ex) {
            System.out.println("verifique la entrada de su teclado");
            agregar();
        }
        Menus ob1=new Menus();
        ob1.Menu();
    }

    public static void eliminar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite el Id del empleado a eliminar");
        int id = scanner.nextInt();
        if (validarIdEmpleado(id)) {
            for (Empleado empleado : listEmpleado) {
                if (empleado.getId() == id) {
                    listEmpleado.remove(empleado);
                    System.out.println("El empleado con el id: " + id + " se ha eliminado exitosamente");
                }
            }
        } else {
            System.out.println("No existe un empleado con el id: " + id);
            eliminar();
        }
        Menus ob1=new Menus();
        ob1.Menu();
    }

    public static void actualizar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite el Id del empleado a actualizar");
        int id = Integer.parseInt(scanner.nextLine());

        if (validarIdEmpleado(id)) {
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
                    System.out.println("El empleado con el id: " + id + " la informacion ha sido modificada");
                }
            }
        } else {
            System.out.println("verifique el id del empleado: " + id);
            actualizar();
        }
        Menus ob1=new Menus();
        ob1.Menu();
    }

    public static void mostrar() {
        for (Empleado empleado : listEmpleado) {
            System.out.println(empleado);
        }
        Menus ob1=new Menus();
        ob1.Menu();
    }

    private static boolean validarIdEmpleado(int id) {
        for (Empleado empleado : listEmpleado) {
            if (empleado.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static void mostrarEmpleadoConMayorSalario() {
        Empleado empleado = listEmpleado.stream().max(Comparator.comparing(Empleado::getSalario)).get();
        System.out.println("Empleado con mayor salario -> " + empleado);
        Menus ob1=new Menus();
        ob1.Menu();
    }

    public static void mostrarEmpleadoConMenorSalario() {
        Empleado empleado = listEmpleado.stream().min(Comparator.comparing(Empleado::getSalario)).get();
        System.out.println("Empleado con menor salario -> " + empleado);
        Menus ob1=new Menus();
        ob1.Menu();
    }

    public static void mostrarOrdenadoPorNombre() {
        System.out.println("Lista ordenada por nombre");
        listEmpleado.stream().sorted(Comparator.comparing(Empleado::getNombre)).forEach(System.out::println);
        Menus ob1=new Menus();
        ob1.Menu();
    }

    public static void sumarSalarios() {
        Integer sumaSalario = listEmpleado.stream().filter(empleado -> empleado.getSalario() > 7000)
                .map(Empleado::getSalario).reduce(0, (acumulador, valor) -> acumulador + valor);

        System.out.println(
                "suma de los salarios de todos los empleados cuyo salario es mayor a 700000 \nTotal = " + sumaSalario);

        Menus ob1=new Menus();
        ob1.Menu();
    }

    public static void sumarEmpleados() {
        long sumaEmpleado = listEmpleado.stream()
                .filter(empleado -> empleado.getApellido().toLowerCase().charAt(0) == 'a').count();
        System.out.println(
                "número total de empleados cuyo apellido comienza por la letra ‘A’ o ‘a’\nTotal = " + sumaEmpleado);
        Menus ob1=new Menus();
        ob1.Menu();
    }

    public static void mostrarEmpleadosConMayorSalario() {
        System.out.println("5 primeros empleados con el mayor salario");
        listEmpleado.stream().sorted(Comparator.comparing(Empleado::getSalario).reversed()).limit(5).forEach(System.out::println);
        Menus ob1=new Menus();
        ob1.Menu();
    }
}
