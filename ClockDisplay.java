
/**
 * 24 hr Internal Clock.
 * 
 * Edited original source code to satisfy book exercise 3.39.
 * 
 * Out of 3.38, and 3.39, this was the easiest to deal program due to most internal values staying stagnant.
 * Where as in 3.38, there was more abstraction involved revolving '0' and '12'.
 * 
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * Edited by Franco Acosta on 09/29/2025
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private Boolean amPM = true; // new field to decide AM/PM. 'amPM = true' means it's in the AM, 'false' means PM.
    private String displayString;    // simulates the actual display
    
        /**
         * Constructor for ClockDisplay objects. This constructor 
         * creates a new clock set at 00:00.
         */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
            if ( ((hours.getValue() / 12 ) % 2) == 0 ){
            amPM = true;
            }
            else {
            amPM = false; 
            }
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        if ( ((hour / 12 ) % 2) == 0 ){
            amPM = true;
        }
        else {
            amPM = false; 
        }
        hours.setValue(hour%12);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        if ( amPM == true ){
           displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + " AM.";
        }
        else {
            displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + " PM.";
        }
    }
}//end of code.
