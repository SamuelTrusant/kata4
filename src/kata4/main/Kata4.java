package kata4.main;

import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

public class Kata4 {

    public static void main(String[] args) {
        String fileName = "email.txt";
        control(fileName);
    }

    private static List<Mail> mailList;
    private static Histogram histograma;
    private static HistogramDisplay histogram;
    
    private static void control(String fileName){
        input(fileName);
        process();
        output();
    }

    private static void input(String fileName) {
       mailList = MailListReader.read(fileName);
    }

    private static void process(){
        histograma = MailHistogramBuilder.build(mailList);
    }

    private static void output() {
        histogram = new HistogramDisplay(histograma);
        histogram.execute();
    }
}
