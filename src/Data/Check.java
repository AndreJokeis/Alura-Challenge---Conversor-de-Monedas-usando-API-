package Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Check {
    Scanner read = new Scanner(System.in);
    String codes = """
            1) Dolar (USD)
            2) Pesos mexicanos (MXN)
            3) Pesos argentinos (ARS)
            4) Pesos colombianos (COP)
            5) Reales brasileños (BRL)
            6) Euro (EUR)
            7) Yen japonés (JPY)
            8) Libra esterlina (GBP)
            9) Yuan chino (CNY)
            10) Franco Suizo (CHF)
            11) Dolar canadiense (CAD)
            12) Dolar australiano (AUD)
            """;

    List<Conversion> list = new ArrayList<>();
    API api = null;
    Conversion conversion = null;

    String base_code, target_code;
    float base_amount;

    /**
     * Este método se encarga de iniciar la aplicación, solo se tiene que mandar llamar.
     */
    public void start(){
        System.out.print("""
                
                 - Elija la base a convertir:
                
                """ + codes + """
                
                Opcion a elegir:\s""");

        int base_option = isOption(read.nextLine());
        base_code = selectCode(base_option);

        System.out.print("Elija la el monto de la base a convertir: $");
        base_amount = isNum(read.nextLine());

        System.out.print("""
                
                 - Elija el objetivo a convertir (excepto el numero\s""" + base_option + """
                ):
                
                """ + codes + """
                
                Opcion a elegir:\s""");
        int target_option = isOption(read.nextLine());

        while(target_option == base_option){
            System.out.print("""
                    El tipo de cambio debe de ser diferente a la base!
                    Elija otra opción:\s""");
            target_option = isOption(read.nextLine());
        }

        target_code = selectCode(target_option);

        System.out.println("\nEspere un momento...");

        api = new API(base_code, target_code);
        conversion = new Conversion(api.createConversion(), base_amount);

        list.add(conversion);

        System.out.println(conversion);
    }

    /**
     * Recibe un entero indicando la opción elegida por el usuario correspondiente al código
     * de la divisa.
     *
     * @param option Recibe un {@code int} correspondiente al código.
     * @return Regresa un {@code String} el cual corresponde al código de la divisa .
     */
    private String selectCode(int option){
        return switch (option){
            case 1 -> "USD";
            case 2 -> "MXN";
            case 3 -> "ARS";
            case 4 -> "COP";
            case 5 -> "BRL";
            case 6 -> "EUR";
            case 7 -> "JPY";
            case 8 -> "GBP";
            case 9 -> "CNY";
            case 10 -> "CHF";
            case 11 -> "CAD";
            case 12 -> "AUD";
            default -> "";
        };
    }

    /**
     * Muestra una lista de todas las conversiones realizadas
     */
    public void showHistory(){
        if(list.isEmpty()){
            System.out.println("""
                    
                    Por el momento no hay conversiones para mostrar.
                    Pero puedes comenzar a hacer una!
                    """); return;
        }

        System.out.println(" --- Historial de conversiones -----\n");

        Conversion conversionList;

        for(int i=0; i<list.size();){
            conversionList = list.get(i);
            System.out.print(++i + ". " + conversionList);
        }
        System.out.println();
    }

    /**
     * El método recibe una cadena para tratar de prevenir errores, dicha cadena se convierte a número y lo devuelve.
     * En caso de no recibir un número entre 1 y 5 válido, se vuelve a ejecutar pidiendo otro número.
     *
     * @param s Recibe una cadena a convertir en número.
     * @return Regresa un {@code int} el cual corresponde a la opcion elegida en el menú.
     * La propia función hace una validación para numeros entre 1 y 12.
     */
    private int isOption(String s){
        try{
            int num = Integer.parseInt(s);

            if(num < 1 || num > 12){
                System.out.print("Ingrese una opción entre 1 y 12: ");
                return isOption(read.nextLine());
            }

            return num;
        } catch (NumberFormatException e){
            System.out.print("Ingrese una opción válida: ");
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
                System.out.print("Ingrese una cantidad mayor a $0: $");
                return isNum(read.nextLine());
            }

            return num;
        } catch (NumberFormatException e){
            System.out.print("Ingrese un monto válido: $");
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

            if(num <1 || num > 3){
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
