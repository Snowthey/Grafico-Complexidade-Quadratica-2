import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Grafico objGrafico;
        XYSeries series = new XYSeries("Complexidade Quadratica");
        XYSeries seriesBubble = new XYSeries("Bubble Sort");
        XYSeries seriesSelection = new XYSeries("Selection Sort");
        XYSeries seriesInsertion = new XYSeries("Insertion Sort");
        XYSeries seriesQuick = new XYSeries("Quick Sort");

        for (int size = 100; size <= 1000; size += 100) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = (int) (Math.random() * 1000); // gera valores aleatórios entre 0 e 1000
            }

            long startTime, endTime, elapsedTime;

            int[] arrBubble = arr.clone();
            startTime = System.nanoTime();
            Operacoes.bubbleSort(arrBubble);
            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            seriesBubble.add(size, elapsedTime);

            int[] arrSelection = arr.clone();
            startTime = System.nanoTime();
            Operacoes.selectionSort(arrSelection);
            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            seriesSelection.add(size, elapsedTime);

            int[] arrInsertion = arr.clone();
            startTime = System.nanoTime();
            Operacoes.insertionSort(arrInsertion);
            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            seriesInsertion.add(size, elapsedTime);

            int[] arrQuick = arr.clone();
            startTime = System.nanoTime();
            Operacoes.quickSort(arrQuick, 0, arrQuick.length - 1);
            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            seriesQuick.add(size, elapsedTime);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        dataset.addSeries(seriesBubble);
        dataset.addSeries(seriesSelection);
        dataset.addSeries(seriesInsertion);
        dataset.addSeries(seriesQuick);

        objGrafico = new Grafico(dataset);
    }
}
