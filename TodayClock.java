import java.time.Clock;
public class TodayClock {
    public static void main(String[] args) {
        
        Clock clock=Clock.systemUTC();
        System.out.println("Clock :"+clock);//Clock :SystemClock[Z]
        
        Clock defaultClock=Clock.systemDefaultZone();
        System.out.println("Clock :"+defaultClock);//Clock :SystemClock[Asia/Calcutta]
    }
}