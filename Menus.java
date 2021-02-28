import java.util.Scanner;

public class Menus {
    public static void Menu() {

        try {
            Scanner scanner = new Scanner(System.in);
            int item;

            do {
                System.out.println("----------------MENU DE USUARIO------------- ");
                System.out.println("1. Agregar ");
                System.out.println("2. Eliminar ");
                System.out.println("3. Actualizar ");
                System.out.println("4. Mostrar");
                System.out.println("5. Empleado con mayor salario");
                System.out.println("6. Empleado con menor salario");
                System.out.println("7. Empleados por nombre");
                System.out.println("8. Suma de los salarios de todos los empleados cuyo salario es mayor a $700.000");
                System.out.println("9. Número total de empleados cuyo apellido comienza por la letra ‘A’ o ‘a");
                System.out.println("10. 5 primeros empleados con el mayor salario.");
                System.out.println("11. Salir");
                System.out.println("--------------------------------------------- ");
                item = scanner.nextInt();
                if (item < 1 || item > 11) {
                    System.out.println("Opción inválida");
                }
            } while (item < 1 || item > 11);
            switch (item) {
                case 1:
                    Opciones.agregar();
                    break;
                case 2:
                    Opciones.eliminar();
                    break;
                case 3:
                    Opciones.actualizar();
                    break;
                case 4:
                    Opciones.mostrar();
                    break;
                case 5:
                    Opciones.mostrarEmpleadoConMayorSalario();
                    break;
                case 6:
                    Opciones.mostrarEmpleadoConMenorSalario();
                    break;
                case 7:
                    Opciones.mostrarOrdenadoPorNombre();
                    break;
                case 8:
                    Opciones.sumarSalarios();
                    break;
                case 9:
                    Opciones.sumarEmpleados();
                    break;
                case 10:
                    Opciones.mostrarEmpleadosConMayorSalario();
                    break;
                case 11:
                    System.out.println("SESION FINALIZADA");
                    System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println("verifique la entrada de su teclado");
            Menu();
        }
    }
}
