package kata4.view;

import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;

public class MailHistogramBuilder {

    public static Histogram build(List<Mail> mailList) {
        Histogram<String> histograma = new Histogram<>();
        for (Mail mail : mailList) {
            histograma.increment(mail.getDomain());
        }
        return histograma;  
    }
    
}
