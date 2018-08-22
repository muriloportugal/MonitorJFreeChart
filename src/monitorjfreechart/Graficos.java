/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitorjfreechart;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DefaultXYItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author murilo.portugal
 */
public class Graficos {
    
    private JFreeChart jfChart;
    private ChartPanel chartPanel;
    
    
    public ChartPanel getGraficoPizza(DefaultPieDataset pizzaDataset,String graficoTitulo){    
        this.jfChart = ChartFactory.createPieChart(graficoTitulo, pizzaDataset, true, true, false);
        //Altera a exibição da legenda do gráfico
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0}: ({1}GB,{2})");
        PiePlot plot = (PiePlot) this.jfChart.getPlot();
        plot.setLabelGenerator(labelGenerator);
        
        this.chartPanel = new ChartPanel(jfChart);
        return this.chartPanel;
    }
    
    public ChartPanel getGraficoColunas(DefaultCategoryDataset dcd,String titulo,String legendaEixoX,String legendaEixoY){
        //Cria o grafico
        this.jfChart = ChartFactory.createBarChart3D(titulo, legendaEixoX, legendaEixoY, dcd,PlotOrientation.VERTICAL,true,true,false);
        //Adiciona o grafico a este panel para que possa ser exibido.
        this.chartPanel = new ChartPanel(this.jfChart);
        return this.chartPanel;
    }
    
    public ChartPanel getGraficoSeriesTempo(XYDataset dataset,String titulo, String legendaEixoX,String legendaEixoY){
        
        this.jfChart = ChartFactory.createTimeSeriesChart(titulo, legendaEixoX,legendaEixoY,dataset,true,true,false);
        DefaultXYItemRenderer renderer = new DefaultXYItemRenderer();
        renderer.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(false);
        renderer.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
        StandardXYToolTipGenerator xyTooltipGenerator = new StandardXYToolTipGenerator("{0} {1} = {2}GB", new SimpleDateFormat("dd/MM/yyyy"), new DecimalFormat("0"));
        renderer.setBaseToolTipGenerator(xyTooltipGenerator);
        
        XYPlot plot = this.jfChart.getXYPlot();
        plot.setRenderer(renderer);
         
        //plot.setWeight(300);
        //plot.setBackgroundPaint(Color.lightGray);
        //plot.setDomainGridlinePaint(Color.white);
        //plot.setRangeGridlinePaint(Color.white);
        
        //this.jfChart.getXYPlot().setRenderer(new XYSplineRenderer());
        this.chartPanel = new ChartPanel(this.jfChart);
        return this.chartPanel;
    }
}
