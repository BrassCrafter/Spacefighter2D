import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class Clock {
    int hours, minutes, seconds, milliseconds;
    int sHours, sMinutes, sSeconds, sMilliseconds;
    int cMilliseconds;
    int stopWatch_DeltaSeconds, timeBasedScore;
    boolean firstTime_stopWatch = true, coolDownOver = false;

    private void updateTime() {
        hours = LocalTime.now().getHour();
        minutes = LocalTime.now().getMinute();
        seconds = LocalTime.now().getSecond();
        milliseconds = LocalTime.now().get(ChronoField.MILLI_OF_SECOND);
    }

    public void stopWatch(boolean pStop, boolean pRestart) {
        this.updateTime();
        if (firstTime_stopWatch) {
            stopWatch_DeltaSeconds = seconds;
            firstTime_stopWatch = false;
        }
        if (!pStop) {
            if (seconds - stopWatch_DeltaSeconds == 1 || seconds - stopWatch_DeltaSeconds == -59) {
                sSeconds++;
                timeBasedScore++;
            }

            if (sSeconds == 60) {
                sMinutes++;
                sSeconds = 0;
            }
            if (sMinutes == 60) {
                sHours++;
                sMinutes = 0;
            }
            stopWatch_DeltaSeconds = seconds;
            sMilliseconds = milliseconds;
        } else {
            stopWatch_DeltaSeconds = seconds;
            milliseconds = sMilliseconds;
        }
        if (pRestart) {
            stopWatch_DeltaSeconds = seconds;
            sHours = 0;
            sMinutes = 0;
            sSeconds = 0;
            sMilliseconds = 0;

        }
    }

    public String stopWatchToString(boolean pStop, boolean pRestart) {
        this.stopWatch(pStop, pRestart);
        return sHours + " : " + sMinutes + " : " + sSeconds + " : " + sMilliseconds;
    }

    public void resetCoolDown(int pMs) {
        cMilliseconds = pMs;
    }

    public void coolDown() {
        if (cMilliseconds > 0) {
            cMilliseconds = cMilliseconds - 2;
            coolDownOver = false;
        } else {
            coolDownOver = true;
        }
    }

    public boolean coolDownOver() {
        return coolDownOver;
    }
    public int getTimeBasedScore(){
        return timeBasedScore;
    }
}
