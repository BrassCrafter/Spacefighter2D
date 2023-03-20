import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class Clock {
    int hours, minutes, seconds, milliseconds;
    int tHours, tMinutes, tSeconds, tMilliseconds;
    int deltaSeconds;
    boolean firstTime = true;
    private void updateTime(){
        hours = java.time.LocalTime.now().getHour();
        minutes = java.time.LocalTime.now().getMinute();
        seconds = java.time.LocalTime.now().getSecond();
        milliseconds = java.time.LocalTime.now().get(ChronoField.MILLI_OF_SECOND);
    }

    public void timer(boolean pStop, boolean pRestart){
        this.updateTime();
        if(firstTime){
            deltaSeconds = seconds;
            firstTime = false;
        }
        System.out.println(seconds - deltaSeconds);
        if(!pStop){
            if(seconds - deltaSeconds == 1 || seconds - deltaSeconds == -59){
                tSeconds++;
            }

            if(tSeconds == 60){
                tMinutes++;
                tSeconds = 0;
            }
            if(tMinutes == 60){
                tHours++;
                tMinutes = 0;
            }
            deltaSeconds = seconds;
        }
    }
    public String timerToString(boolean pStop, boolean pRestart){
        this.timer(pStop, pRestart);
        return tHours + " : " + tMinutes + " : " + tSeconds + " : " + milliseconds;
    }
}
