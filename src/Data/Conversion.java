package Data;

import java.time.LocalDate;

public class Conversion {
    private final String base_code;
    private final String target_code;
    private final String result;
    private final float base_amount;
    private final float target_amount;
    private final LocalDate date;

    public Conversion(ConversionEX conversionEX, float base_amount) {
        this.base_code = conversionEX.base_code();
        this.target_code = conversionEX.target_code();
        this.result = conversionEX.result();
        this.base_amount = base_amount;
        this.target_amount = ( base_amount * Float.parseFloat(conversionEX.conversion_rate()) );
        this.date = LocalDate.now();
    }

    @Override
    public String toString() {
        if(result.equalsIgnoreCase("success")){
            return """
            
            -----------------------------------------------------
            Cambiaste $""" + base_amount + """
             (""" + base_code + """
            ) a $""" + target_amount + """
             (""" + target_code + """
            ). El dia\s""" + date + """
            
            -----------------------------------------------------
            """;
        }

        return """
                
                -----------------------------------------------------
                Ocurrió un error durante la ejecución.
                -----------------------------------------------------
                
                """;
    }
}
