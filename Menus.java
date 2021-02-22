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
                System.out.println("5. Salir");
                System.out.println("---------------------------------------------");
                item = scanner.nextInt();
                if (item < 1 || item > 5) { System.out.println("Opción inválida");}
            } while (item < 1 || item > 5);
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
                    System.out.println("SESION FINALIZADA");
                    System.exit(0);}
        }catch (Exception ex){
            System.out.println("verifique la entrada de su teclado");
            Menu();
        }
    }


}
