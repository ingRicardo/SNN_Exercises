/**
 * 
 */
package testing;

import java.util.Random;

/**
 * @author TIJUANA
 *
 */
public class Receptive_Fields_Encoding {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		double[][] input = 
				{{(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
				(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
				(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
				(-100 + (100 - (-100)) * r.nextDouble())},
					{(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
					(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
					(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
					(-100 + (100 - (-100)) * r.nextDouble())}	};
		
		int rf =4;
		double maxd =10;
		double [] sigma = new double[rf];
		double f_cut =0.9;
		double rho =0.1;
		
		for (int i =0; i < rf; i++) {
			sigma[i] = 1/(1.5*(i-2));
		}
		
		receptive_fields(input[0], rf, maxd, sigma, f_cut, rho, 0);
	}

	public static double [][] receptive_fields(double [] input, int rf, double maxd, double[] sigma, double f_cut, double rho, int typ) {
		System.out.println("\n---- receptive fields ----\n");
		double [] centers = new double[rf];
		double [] normData = NormalDataLinearEncoding.normalize(input);
		double cent_dist = 0;		
		for (int i =0; i < centers.length; i++) {
			if (typ ==1) {								
				if(i == 0)
					cent_dist = 0.5;
				else
					cent_dist = (1/i);
				
				centers[i] = (i-0.5)*cent_dist;								
			}else if (typ == 0) {
				if(i == 2)
					cent_dist = 0.5;				
				else
					cent_dist = (1/(i-2));
				
				centers[i] = (i-1.5)*cent_dist;
			}
			
			System.out.println(centers[i] + " : "+ sigma[i]);
		}
		double aux=0;
		double [][] delays = new double[normData.length][centers.length];
		System.out.println("-----");
		for (int i =0 ; i < normData.length; i ++) {
				System.out.println("");
				for (int k =0 ; k <  centers.length; k++) {
					aux = maxd -maxd * Math.exp(-1* Math.pow((normData[i]-centers[k]), 2)/(2*Math.pow(sigma[k], 2)));
					
					if (aux>(maxd*f_cut))// firing
						aux=-1;
					
					delays[i][k]=aux;
					System.out.print(" "+delays[i][k]+ ", ");
				}
		
		}
		
		return delays;
	}
}
