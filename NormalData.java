/**
 * 
 */
package testing;

import java.text.DecimalFormat;

/**
 * @author Ricardo Alfredo Macias Olvera
 *
 */
public class NormalData {

	/**
	 * @param args
	 * vector normalizarion [0,1]
	 */
	 private static DecimalFormat df2 = new DecimalFormat("#.###");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double [] v = new double[] {75.0,-21.0,-11.0,95.0,55.0,33.0,-54.2,92.5,5.2,8.6};
		System.out.print("input -> ");
		for (int j=0; j < v.length; j++) {
			System.out.print(v[j]+",");
		}
		System.out.println("");
	//	minData(v);
	
		double[] normdata = normalize(v);
		System.out.println("Output -> ");
		for (int j=0; j < normdata.length; j++) {
			System.out.print(normdata[j]+",");
		}
		
	}
	
	public static double [] normalize(double [] v) {
		double max = mayData(v);
	//	System.out.println("may "+max);
		double min = minData(v);
	//	System.out.println("min "+min);	
		double [] normv = new double[v.length];
		double n =0.0;
		for (int j=0; j < v.length; j++) {
			n = ((v[j]-min)/(max-min));
			normv[j] = Double.parseDouble(df2.format(n));
		}
		return normv;
	}
	
	public static double mayData(double [] v) {
		double may=0, tmp=0;		
			may = v[0];
			for (int j=1; j < v.length; j++) {
				tmp = v[j];			
				if (tmp > may) 
					may = tmp;												
			}
		return may;
	}
	public static double minData(double [] v) {
		double min=0, tmp=0;		
		 min = v[0];
			for (int j=1; j < v.length; j++) {
				tmp = v[j];			
				if (tmp < min) 
					min = tmp;												
			}
		return min;
	}

}
