package kata4.view;

import java.awt.Dimension;
import javax.swing.JPanel;
import kata4.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
        
public class HistogramDisplay extends ApplicationFrame {
    private final Histogram <String> histogram;

    public HistogramDisplay(Histogram <String> histogram) {
        super("HISTOGRAMA");
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }

    private JPanel createPanel() {
        ChartPanel chartpanel = new ChartPanel(createChart(createDataSet()));
        chartpanel.setPreferredSize(new Dimension(800,600));
        return chartpanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart chart = ChartFactory.createBarChart("Histograma JFreeChart",
                                                        "Dominios emails",
                                                        "Nº de emails",
                                                        dataSet,
                                                        PlotOrientation.VERTICAL,
                                                        false,
                                                        false,
                                                        rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataSet(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for(String key : histogram.keySet()){
            dataSet.addValue(histogram.get(key), "", key);
        }
        /**
        dataSet.addValue(300, "", "ulpgc.es");
        dataSet.addValue(100, "", "dis.ulpgc.es");
        dataSet.addValue(500, "", "gmail.com");
        */
        return dataSet;
    }
    
    public void execute(){
        setVisible(true);
    }
}
