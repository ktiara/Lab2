import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        // 1. Расчет через double
        double priceWithoutVat = 9.99;
        double priceWithVat = priceWithoutVat * 1.23;
        double valueWithVat = priceWithVat * 10000;
        double valueWithoutVat = valueWithVat / 1.23;

        System.out.println("Price without VAT: " + priceWithoutVat);
        System.out.println("Price with VAT " + priceWithVat);
        System.out.println("Value with VAT: " + valueWithVat);
        System.out.println("Value without VAT: " + valueWithoutVat);

        System.out.println("\nSame thing after using Big Decimal:");

        // 2. Расчет через BigDecimal
        BigDecimal dbPriceWithoutVat = new BigDecimal("9.99");
        BigDecimal dbPriceWithVat = dbPriceWithoutVat.multiply(new BigDecimal("1.23"));

        dbPriceWithVat = dbPriceWithVat.setScale(2, RoundingMode.HALF_EVEN);

        System.out.println("Price without VAT: " + dbPriceWithoutVat);
        System.out.println("Price with VAT rounded: " + dbPriceWithVat);

        BigDecimal dbValueWithVat = dbPriceWithVat.multiply(new BigDecimal(10000));
        System.out.println("Value with VAT: " + dbValueWithVat);

        BigDecimal dbPriceWithoutVat2 = dbValueWithVat.divide(new BigDecimal("1.23"), RoundingMode.HALF_EVEN);
        System.out.println("Value without VAT: " + dbPriceWithoutVat2);
    }
}