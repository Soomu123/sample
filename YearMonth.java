import java.time.YearMonth; 
public class YearMonth {
    public static void main(String[] args) {
        YearMonth today=YearMonth.now();
        
        System.out.printf("The current %s : %d \t %n",today,today.getMonthValue());
        
        YearMonth creditExpiry=YearMonth.of(2020, Month.OCTOBER);
        System.out.println("Your Creadit Card Expiry is :"+creditExpiry);
    }
}
