package managedBean;

 
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

import dao.MaintenanceDao;
 
@ManagedBean
public class MBStat implements Serializable {
 
    private BarChartModel animatedModel2;
 
    @PostConstruct
    public void init() {
        createAnimatedModels();
    }
 
   private String mat;
   public String getMat() {return mat;}
   public void setMat(String m) {mat=m;}
 
    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }
 
    private void createAnimatedModels() {
        
      
        animatedModel2 = initBarModel();
        animatedModel2.setTitle("Maintenance");
        animatedModel2.setAnimate(true);
   
        animatedModel2.setLegendPosition("ne");
        Axis  yAxis = animatedModel2.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(40);
    }
     
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        int year = Calendar.getInstance().get(Calendar.YEAR);

        ChartSeries main = new ChartSeries();
        MaintenanceDao dao =new MaintenanceDao();
        main.setLabel("Maintenance");
        main.set(year+"", dao.stat(mat, year));
        main.set(year-1+"", dao.stat(mat, year-1));
        main.set(year-2+"", dao.stat(mat, year-2));
        main.set(year-3+"", dao.stat(mat, year-3));
        main.set(year-4+"", dao.stat(mat, year-4));
        main.set(year-5+"", dao.stat(mat, year-5));
        main.set(year-6+"", dao.stat(mat, year-6));
        main.set(year-7+"", dao.stat(mat, year-7));
        main.set(year-8+"", dao.stat(mat, year-8));
        main.set(year-9+"", dao.stat(mat, year-9));
        main.set(year-10+"", dao.stat(mat, year-10));
 
        model.addSeries(main);
          
        return model;
    }
     
 
    
}