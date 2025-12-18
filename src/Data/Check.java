package Data;

import java.util.Scanner;

public class Check {
    Scanner read = new Scanner(System.in);

    /**
     * El método recibe una cadena para tratar de prevenir errores, dicha cadena se convierte a número y lo devuelve.
     * En caso de no recibir un número entre 1 y 5 válido, se vuelve a ejecutar pidiendo otro número.
     *
     * @param s Recibe una cadena a convertir en número.
     * @return Regresa un {@code int} el cual corresponde a la opcion elegida en el menú.
     * La propia función hace una validación para numeros entre 1 y 5.
     */
    public int isOption(String s){
        try{
            int num = Integer.parseInt(s);

            if(num < 1 || num > 5){
                System.out.println("Ingrese un número entre 1 y 5");
                return isOption(read.nextLine());
            }

            return num;
        } catch (NumberFormatException e){
            System.out.print("Ingrese un número válido: ");
            return isOption(read.nextLine());
        }
    }

    /**
     * El método recibe una cadena para tratar de prevenir errores, dicha cadena se convierte a número y lo devuelve.
     * En caso de no recibir un número positivo mayor a 0, se vuelve a ejecutar pidiendo otro número.
     *
     * @param s Recibe una cadena a convertir en número.
     * @return Regresa un {@code float} el cual representa la cantidad de dinero a convertir.
     * La propia función hace una validación para numeros positivos mayores a 0.
     */
    public float isNum(String s){
        try{
            float num = Float.parseFloat(s);

            if(num < 1){
                System.out.print("Ingrese una cantidad mayor a 0: ");
                return isNum(read.nextLine());
            }

            return num;
        } catch (NumberFormatException e){
            System.out.print("Ingrese un número válido: ");
            return isNum(read.nextLine());
        }
    }

    /**
     * El método recibe una cadena para tratar de prevenir errores, dicha cadena se convierte a número y lo devuelve.
     * En caso de no recibir un número positivo mayor a 0, se vuelve a ejecutar pidiendo otro número.
     *
     * @param s Recibe una cadena a convertir en número.
     * @return Regresa un {@code byte} el cual representa una opción del menú inicial.
     * La propia función hace una validación para numeros que sean opciones en el menú.
     */
    public byte option(String s){
        try{
            byte num = Byte.parseByte(s);

            if(!(num == 1 || num == 2)){
                System.out.print("Elija una opción válida: ");
                return option(read.nextLine());
            }

            return num;
        } catch (NumberFormatException e){
            System.out.print("Ingrese un número válido: ");
            return option(read.nextLine());
        }
    }
}
