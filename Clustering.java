/**
 * 
 */
package testing;

import java.util.Random;

/**
 * @author TIJUANA
 *
 */
public class Clustering {

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
		
		int output =5;
		double rho =0.1;
		int tau = 3;
		int rf =8;
		double [] sigma = new double[rf];
		
		for (int i =0; i < rf; i++) {
			sigma[i] = 1/(1.5*(i-2));
			System.out.print(sigma[i]+", ");
		}
		double f_cut=0.9;
		int maxd=10;
		
		System.out.println("");
		int[] d = new int[13];
		int ssin = d.length; 
		for (int i = 0; i< d.length; i++) {
			d[i] = i;
			System.out.print(" "+d[i]+ ", ");
		}
		
		int w_max=1, w_min=0; 
		int max_epoch=3; 
		int t_max=30; // max training time
		double eta=0.35; 
		double beta=0.2; 
		double nu=5.0; 
		double dx=2.3; 
		
		double kapa = 1 - Math.pow(nu, 2) / ( 2*Math.log(beta/(beta+1)) );
		int teta = 12;
		//rf
		//output
		double [][] w = iniweights(rf, output, ssin, w_max, w_min); // initialize weights 
		System.out.println("");
		double[][] InputnormData =Receptive_Fields_Encoding.receptive_fields(input[0], rf, maxd, sigma, f_cut, rho, 0);// encoding inputs 
		
		double [] delta_t = new double[ssin];
		
		calculate_firing(InputnormData[0], t_max, w, d, tau, rho, teta, 0);
	}
	
	public static double [][] iniweights(int rf, int output, int ssin, int w_max, int w_min) {
		Random r = new Random();
		double [][] w = new double[rf][output];
		for (int i =0; i < rf; i++) {
			System.out.println("");
			for (int j =0; j < output; j++) {
				w[i][j] = w_min + (1 + (ssin - (1)) * r.nextDouble()) * (w_max-w_min);
				System.out.println(w[i][j]);
			}
		}
		return w;
	}
	
	public static void calculate_firing(double[] input, int t_max, double[][] w, int[] d, int tau, double rho, int teta, int typ ) {
		//outputs  w-col  5
		// number of values input- col  8
		// sub-synapses d-length 13
		
		System.out.println("\n\nsizes - > "+ w[0].length + ":"+ input.length +":"+d.length);
		
		double t =0;
		double dt =0,dtt=0, sai=0;
		
		double [] output = new double[w[0].length];
		
		for (int i =0; i < w[0].length; i++) {
			System.out.println("");
			for (int j =0; j < input.length; j++) {
				System.out.println("  ");
				
				if (input[j] != -1)
					dt = t - input[j];
				
				for (int k =0; k < d.length; k++) {
				//	System.out.print(d[k]+", ");
					
					dtt= (dt-d[k])/tau;
					sai = w[j][i]*dtt*Math.exp(1-dtt);
					
					if (sai <0)
						sai =0;
					
					System.out.print(sai+", ");
					
				}
			}
		}
		
	}

}
