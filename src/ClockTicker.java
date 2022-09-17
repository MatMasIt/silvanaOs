import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ClockTicker implements Runnable {

    private JLabel clock;
    private ArrayList<String> days, months;

    public ClockTicker(JLabel clock) {
        this.clock = clock;
    }

    public static ArrayList<String> getItalianDays(){
        ArrayList<String> days = new ArrayList<>();
        days.add("Domenica");
        days.add("Lunedì");
        days.add("Martedì");
        days.add("Mercoledì");
        days.add("Giovedì");
        days.add("Venerdì");
        days.add("Sabato");
        return days;
    }

    public static ArrayList<String> getItalianMonths(){
        ArrayList<String> months = new ArrayList<>();
        months.add("Gennaio");
        months.add("Febbraio");
        months.add("Marzo");
        months.add("Aprile");
        months.add("Maggio");
        months.add("Giugno");
        months.add("Luglio");
        months.add("Agosto");
        months.add("Settembre");
        months.add("Ottobre");
        months.add("Novembre");
        months.add("Dicembre");
        return months;
    }
    public void run() {
        while (true) {
            clock.setText(italianDatetime(new Date()));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static String italianDatetime(Calendar c){
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        int m = c.get(Calendar.DAY_OF_MONTH);
        int mo = c.get(Calendar.MONTH);
        int y = c.get(Calendar.YEAR);
        int h = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);
        int s = c.get(Calendar.SECOND);
        return getItalianDays().get(dayOfWeek-1) + " "+ m +" "+ getItalianMonths().get(mo-1) +" "+y+"    "+String.format("%02d", h)+":"+String.format("%02d", min)+":"+String.format("%02d", s);
    }
    public static String italianDatetime(Date d){

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return italianDatetime(c);
    }
}
