import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import javax.swing.*;
import java.awt.*;

public class Grafico extends JFrame {
    public Grafico(XYSeriesCollection dataset) {
        super("Complexidade do Algoritmo");

        JFreeChart chart = ChartFactory.createXYLineChart("Gráfico de Complexidade", "Tamanho do Vetor", "Tempo de Execução (ns)", dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
