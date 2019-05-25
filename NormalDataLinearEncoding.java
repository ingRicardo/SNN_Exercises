/**
 * 
 */
package testing;

import java.text.DecimalFormat;

/**
 * @author Ricardo Alfredo Macias Olvera
 *
 */
public class NormalDataLinearEncoding {

	/**
	 * @param args
	 * vector normalization [0,1]
	 * Linear encoding
	 */
	 private static DecimalFormat df2 = new DecimalFormat("#.###");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double [] v = new double[] {75.0,-21.0,-11.0,95.0,55.0,33.0,-54.2,92.5,5.2,8.6};
		double rho=0.1;
		int maxd=10;	
		DelaysOutput(v, rho, maxd);
		
	}
	
	public static double [] DelaysOutput(double [] input, double rho, int maxd ) {
		System.out.print("\ninput -> ");
		for (int j=0; j < input.length; j++) {
			System.out.print(input[j]+",");
		}
		System.out.println("");
		double[] normdata = normalize(input);		
	
		System.out.println("Output normal -> ");				
		for (int j=0; j < normdata.length; j++) {
			System.out.print(normdata[j]+",");												
		}
		double [] delays = delays ( normdata,  rho,  maxd);		
		System.out.println("\nOutput delays -> ");
		for (int j=0; j < delays.length; j++) {
			System.out.print(delays[j]+",");												
		}
		return delays;
	}
	
	public static double [] delays (double [] normal, double rho, int maxd) {
		double [] delays = new double[normal.length];
		double d =0.0;	
		for (int j=0; j < normal.length; j++) {
			d = ((normal[j]*maxd)/rho)*rho;
			delays[j] =  Double.parseDouble(df2.format(d));			
		}
		return delays;
	}
	
	public static double [] normalize(double [] v) {
		double max = mayData(v);
		double min = minData(v);
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
