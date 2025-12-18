package Data;

import java.util.Scanner;

public class Check {
    Scanner read = new Scanner(System.in);

    /**
     * Este método se encarga de iniciar la aplicación, solo se tiene que mandar llamar.
     */
    public void start(){
        String base_code, target_code;
        float base_amount;

        System.out.print("""
                
                 - Elija la base a convertir:
                
                1) Dolar (USD)
                2) Pesos mexicanos (MXN)
                3) Pesos argentinos (ARS)
                4) Pesos colombianos (COP)
                5) Reales brasileños (BRL)
                
                Opcion a elegir:\s""");

        int base_option = isOption(read.nextLine());
        base_code = switch (base_option){
            case 1 -> "USD";
            case 2 -> "MXN";
            case 3 -> "ARS";
            case 4 -> "COP";
            case 5 -> "BRL";
            default -> "";
        };

        System.out.print("Elija la el monto de la base a convertir: ");
        base_amount = isNum(read.nextLine());

        System.out.print("""
                
                 - Elija el objetivo a convertir (excepto el numero\s""" + base_option + """
                ):
                
                1) Dolar (USD)
                2) Pesos mexicanos (MXN)
                3) Pesos argentinos (ARS)
                4) Pesos colombianos (COP)
                5) Reales brasileños (BRL)
                
                Opcion a elegir:\s""");
        int target_option = isOption(read.nextLine());

        while(target_option == base_option){
            System.out.print("""
                    El tipo de cambio debe de ser diferente a la base!
                    Elija otra opción:\s
                    """);
            target_option = isOption(read.nextLine());
        }

        target_code = switch (target_option){
            case 1 -> "USD";
            case 2 -> "MXN";
            case 3 -> "ARS";
            case 4 -> "COP";
            case 5 -> "BRL";
            default -> "";
        };

        System.out.println("\nEspere un momento...");

        API api = new API(base_code, target_code, base_amount);

        System.out.println(api);
    }

    /**
     * El método recibe una cadena para tratar de prevenir errores, dicha cadena se convierte a número y lo devuelve.
     * En caso de no recibir un número entre 1 y 5 válido, se vuelve a ejecutar pidiendo otro número.
     *
     * @param s Recibe una cadena a convertir en número.
     * @return Regresa un {@code int} el cual corresponde a la opcion elegida en el menú.
     * La propia función hace una validación para numeros entre 1 y 5.
     */
    private int isOption(String s){
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
    private float isNum(String s){
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
