/**
 * 
 */
package testing;

import java.util.HashMap;
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
					(-100 + (100 - (-100)) * r.nextDouble())},
					{(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble())}};
		
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
		double teta = 12;
		//rf
		//output
		double [][] w = iniweights(rf, output, ssin, w_max, w_min); // initialize weights 
		System.out.println("");
		double[][] InputnormData =Receptive_Fields_Encoding.receptive_fields(input[0], rf, maxd, sigma, f_cut, rho, 0);// encoding inputs 
		
		
		//training
		double [] delta_t = new double[ssin];
		HashMap<Object, Object> neuTime = null;
		int ctr =0;
	while(ctr <= max_epoch)	{
		for (int i=0; i < InputnormData.length; i++) {//8
			
			System.out.println("");
			 neuTime = calculate_firing(InputnormData[i], t_max, w, d, tau, rho, teta, 0);
			 System.out.println("\nfiring Size -> "+neuTime.size());
			 			
			for (int j = 0; j < InputnormData[j].length; j++) { // 8
				if (InputnormData[i][j] == -1.0) {

					for (int x = 0; x < w.length; x++) {//8 					
						// System.out.println("");
						for (int y = 0; y < w[0].length; y++) {//5
							if (i == x && j == y && neuTime.containsKey(j)) { // modify j 
								System.out.println("weight -> "+ w[x][y] + ", " + InputnormData[i][j] + ", ");
								w[x][y] = w[x][y]-eta;
								System.out.println("newWeight -> "+ w[x][y]);
							}
						}
					} // x
				} // -1
				else {
					
					for (int x = 0; x < w.length; x++) {//8 					
						// System.out.println("");
						for (int y = 0; y < w[0].length; y++) {//5
							if (i == x && j == y && neuTime.containsKey(j)) { // modify j 
								System.out.println("weight -> "+ w[x][y] + ", " + InputnormData[i][j] + ", ");
								

								for (int id =0; id < d.length; id ++) {
									delta_t[id] = InputnormData[i][j] + d[i] - (double) neuTime.get(j);
									w[x][y] = w[x][y]+eta  * ((1+beta)*Math.exp(-1*( Math.pow(delta_t[id]+2.3, 2)/(2*kapa-2) ))-beta);
									
								}
								System.out.println("else -> newWeight -> "+ w[x][y]);
							}
					
						}
					} // x
					
				}//end else
				
				for (int x = 0; x < w.length; x++) {//8 					
					// System.out.println("");
					for (int y = 0; y < w[0].length; y++) {//5
						if (i == x && j == y && neuTime.containsKey(j)) { // modify j 
							if (w[x][y]<w_min) {
								w[x][y] = w_min;
								System.out.println("less than "+w_min+" weigth updated");
							}
							
							if (w[x][y]>w_max) {
								w[x][y] = w_max;
								System.out.println("more than "+w_max+" weigth updated");
							}
							
						}
					}
				}
				
			}
		
		}
		ctr+=1;
		teta = teta +(0.3*teta)/max_epoch;
	}
	
	/*System.out.println("new weights --> ");
		for (int x = 0; x < w.length; x++) {//8 					
			System.out.println("");
			for (int y = 0; y < w[0].length; y++) {//5
				System.out.println(w[x][y]);
			}
		}
	*/
		//calculate_firing(InputnormData[0], t_max, w, d, tau, rho, teta, 0);
	}
	
	public static double [][] iniweights(int rf, int output, int ssin, int w_max, int w_min) {//5 X 8
		Random r = new Random();
		double [][] w = new double[rf][output];
		for (int i =0; i < rf; i++) {
			System.out.println("");
			for (int j =0; j < output; j++) {
				//(-100 + (100 - (-100)) * r.nextDouble())
				w[i][j] = w_min + ( (w_max - (w_min)) * r.nextDouble()) * (w_max-w_min);
				System.out.println(w[i][j]);
			}
		}
		return w;
	}
	
	public static HashMap<Object, Object> calculate_firing(double[] input, int t_max, double[][] w, int[] d, int tau, double rho, double teta, int typ ) {
		//outputs  w-col  5
		// number of values input- col  8
		// sub-synapses d-length 13
		
	//	System.out.println("\n\nsizes - > "+ w[0].length + ":"+ input.length +":"+d.length);
		
		double t =0;
		double dt =0,dtt=0, sai=0;
		int n =0;
		double [] output = new double[w[0].length];
		double acu =0;
		double max=0;
		HashMap<Object, Object> neuTime = new HashMap<>();
		while (t <= t_max) {									//30
			output = new double[w[0].length];
			
			for (int i = 0; i < w[0].length; i++) {				//5
			//	System.out.println("");
				acu =0;
				for (int j = 0; j < input.length; j++) {		//8
				//	System.out.println("  ");

					if (input[j] != -1)
						dt = t - input[j];

					for (int k = 0; k < d.length; k++) {		//13
						// System.out.print(d[k]+", ");

						dtt = (dt - d[k]) / tau;
						sai = w[j][i] * dtt * Math.exp(1 - dtt);

						if (sai < 0)
							sai = 0;

						acu += sai;
					//	System.out.print(sai + ", ");
					
					}
					
				}
				output[i] = acu;
			//	System.out.println( acu + ", ");
				
			}
	//	System.out.println("");
		max = NormalDataLinearEncoding.mayData(output); 
		if (max>teta) {
		
			for(int i=0; i < output.length; i++) {
			//	System.out.print(i+":"+output[i]+", ");
				if(output[i] == max) {
				//	System.out.print(i+":::::::"+output[i]+", "+t);
				
				
					neuTime.put(i, t);
				}
			}
		}
			t+=rho;
		} // while
		
		return neuTime;
	}

}
