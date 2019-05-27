/**
 * 
 */
package testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author Ricardo Alfredo Macias Olvera
 * SIMPLE CLUSTER 
 * SRM - MODEL 
 */
public class SimpleCluster {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		double[][] data = {
				{ (-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()) },
				{ (-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()) },
				{ (-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()) },
				{ (-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()) } };

		double[] input = new double[data[0].length];
		
		List<double[]> delay_centers = new ArrayList<double[]>();			
		double[][] delay_cent_mat = null;//delay centers matrix	
		double[] w = null;
		double[][] WeigthIni = { { 1.0, 1.0 }, { 1.0, 1.0 }, { 1.0, 1.0 }, { 1.0, 1.0 } };
		double[] winput = new double[WeigthIni[0].length];
		double rho = 0.5;
		int maxd = 10;
		int training = 4;
		int output = 2;
		int trb = (input.length / 2) + training;
		List<double[]> weights = new ArrayList<double[]>();
				
		int sizeData = 0;	
		
		
		double[][] testingData = {
				{ (-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()) },
				{ (-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()) },
				{ (-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()) },
				{ (-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()),
						(-100 + (100 - (-100)) * r.nextDouble()), (-100 + (100 - (-100)) * r.nextDouble()) } };

		sizeData = testingData[0].length * testingData.length;
		System.out.println("sizeData -> " + sizeData);
						
		double[][] weight_mat = null;//weight matrix
		
		for (int i = 0; i < data.length; i++) { // inputs
			for (int j = 0; j < data[0].length; j++) { // values
				input[j] = data[i][j];
			}
			// ------training----
			delay_centers.add(delaysCenters(output, training, trb, NormalDataLinearEncoding.DelaysOutput(input, rho, maxd), maxd, rho)); //calculate delay centers
			// ----initializing weights
			for (int j = 0; j < WeigthIni[0].length; j++) {
				winput[j] = WeigthIni[i][j];
			}

			w = weights(winput);
			weights.add(w);
		}
				
		delay_centers.add(Delay_Center_ref(delay_centers.get(0).length, maxd)); // --ADD delay reference data
		

		System.out.println("-----testing------");

		weights.add(weights(weightRef( WeigthIni[0].length, maxd))); // --weight reference data
						
		delay_cent_mat = delay_center_matrix(delay_centers); // delay centers matrix , Save Trained delay centers in a matrix

		weight_mat = weight_matrix(weights, w);// weight matrix, Save weights in a matrix

		int tmax = 15;
		double t = 0, dt = 0, tau = 1.84, sai = 0, acu = 0, teta = 2.04, max = 0;
		System.out.println("");
		double[] out = null;
		int[] values = null;
		List<Object> allData = null;
		double[][] delay_mat = delay_matrix(delayAugmented(data[0].length, testingData, rho, maxd));// , testing  delays matrix data
		
		
		//classification of data in two groups
		
		while (t <= tmax) {
			allData = new ArrayList<Object>();
			for (int i = 0; i < delay_mat.length; i++) {// inputs
				// System.out.println("");
				acu = 0;
				out = new double[weight_mat[0].length];
				values = new int[delay_mat[0].length];
				for (int j = 0; j < delay_mat[0].length; j++) {// values

					dt = (t - delay_mat[i][j]); // calculate DELTA_T

					for (int k = 0; k < weight_mat[0].length; k++) { // output

						sai = weight_mat[i][k] * PostSynapticPotential(dt, delay_cent_mat[i][k], tau);  //Weghts * PSP  

						if (sai < 0)
							sai = 0;

						acu += sai;
						out[k] = acu;
					}

					max = NormalDataLinearEncoding.mayData(out);
					// System.out.println("");
					for (int y = 0; y < out.length; y++) {
						// System.out.println(jj+" --> "+out[jj]);
						if ((max >= teta) && (max == out[y])) { 

							values[i] = y; //firing 
						}
					}

					allData.add(values[i]);
				}

			}
			t += rho;
		}
					
		printData(allData, output, testingData, sizeData);	
						
	}
	
	public static HashMap<Object, Object> printData (List<Object> allData, int output, double[][] testingData, int sizeData){
		HashMap<Object, Object> hasmap = new HashMap<>();
		System.out.println("\nallData " + allData);

		List<Double> list = null;
		int y;
	
		for (int out1 = 0; out1 < output; out1++) {
			y = 0;
			list = new ArrayList<Double>();
			for (int x = 0; x < testingData.length; x++) { // inputs
				for (int x1 = 0; x1 < testingData[0].length; x1++) { // values
					y++;

					if ((int) allData.get(y) == out1) {
						list.add(testingData[x][x1]);
					}

					if (y > sizeData)
						break;

				}
			}
			hasmap.put(out1, list);
		}
		System.out.println("\n -- final values by classes ---");
		for (int out1 = 0; out1 < output; out1++) {
			System.out.println(out1 + " : " + hasmap.get(out1));

		}
			
		
		return hasmap;
		
	}
	
	public static double PostSynapticPotential(double dt, double delay, double tau) {
		
		return  ((dt - delay) / tau) * Math.exp(1 - ((dt - delay) / tau));
	}
	
	public static double[][]  weight_matrix(List<double[]> weights, double[] w ) {
		double[][] weight_mat = new double[weights.size()][w.length];//weight matrix
		
		
		System.out.println("\nweightsg -> " + weights);

		System.out.println("\nweights");
		
		int c=0;
		for (int i = 0; i < weights.size(); i++) {
			if (weights.get(i) instanceof double[]) {
				double[] weightsi = weights.get(i);
				c = 0;
				for (double we : weightsi) {
					weight_mat[i][c] = we;
					c++;
				}

			}
		}
		for (int i = 0; i < weight_mat.length; i++) {
			System.out.println("");
			for (int j = 0; j < weight_mat[0].length; j++) {
				System.out.print(" " + weight_mat[i][j]);
			}
		}

		
		
		return weight_mat;
	}
	
	public static double[] weightRef(int size, double value) {
		
		double[] onesw = new double[size];//ones weight vector	

		for (int j = 0; j < size; j++)
			onesw[j] = 10;
		
		return onesw;
	}
	
	public static double[][] delay_center_matrix(List<double[]> delay_centers) {
		double[][] delay_cent_mat = new double[delay_centers.size()][delay_centers.get(0).length];
		
		int c=0;
		double[] delcenti = null;
		for (int i = 0; i < delay_centers.size(); i++) {
			if (delay_centers.get(i) instanceof double[]) {
				delcenti = delay_centers.get(i);
				c = 0;
				for (double delce : delcenti) {
					delay_cent_mat[i][c] = delce;
					c++;
				}

			}
		}
		System.out.println("\n -----delay centers---");
		for (int i = 0; i < delay_cent_mat.length; i++) {
			System.out.println("");
			for (int j = 0; j < delay_cent_mat[0].length; j++) {

				System.out.print(" " + delay_cent_mat[i][j]);
			}
		}
		
		return delay_cent_mat;
	}
	
	public static List<double[]> delayAugmented(int size,double[][] testingData, double rho, int maxd) {
		
		List<double[]> delay_Augmented = new ArrayList<double[]>();
		double[] input = new double[size];		
		for (int i = 0; i < testingData.length; i++) { // inputs
			for (int j = 0; j < testingData[0].length; j++) { // values
				input[j] = testingData[i][j];
			}
			delay_Augmented.add(NormalDataLinearEncoding.DelaysOutput(input, rho, maxd));
		}

		delay_Augmented.add(delaysRef(delay_Augmented.get(0).length, maxd)); // --delay reference data
		
		
		return delay_Augmented;
	}
	
	public static double[] delaysRef (int size, double value) {
		double[] delay_ones = null;
		delay_ones = new double[size];
		for (int i = 0; i < delay_ones.length; i++) {
			delay_ones[i] = value;
		}
		
		
		return delay_ones;
	}
	
	public static double[][] delay_matrix(List<double[]> delay_Augmented){
		double[][] delay_mat = null;//delays matrix
		
		delay_mat = new double[delay_Augmented.size()][delay_Augmented.get(0).length];
		double[] delaysi = null;
		int c = 0;
		
		for (int i = 0; i < delay_Augmented.size(); i++) {

			if (delay_Augmented.get(i) instanceof double[]) {
				delaysi = delay_Augmented.get(i);
				c = 0;
				for (double d : delaysi) {
					delay_mat[i][c] = d;
					c++;
				}

			}

		}
		System.out.println("");
		System.out.println("\ndelays");
		for (int i = 0; i < delay_mat.length; i++) {
			System.out.println("");
			for (int j = 0; j < delay_mat[0].length; j++) {

				System.out.print(" " + delay_mat[i][j]);
			}
		}
		
		return delay_mat;
	}
	
	public static double[] Delay_Center_ref(int size, double value) {
		double[] delay_cen_ref = null;
		
		delay_cen_ref = new double[size];
		for (int i = 0; i < delay_cen_ref.length; i++) {
			delay_cen_ref[i] = value; // --delay reference data
		}
		
		return delay_cen_ref;
	}
	
	public static double[]  delaysCenters(int size,int tra,int trb,double [] delays, int maxd, double rho) {
		System.out.println("\n\n---delaysCenters---");

		double[] dc = new double[size];
		System.out.println("training data -> " + tra);
		System.out.println("trb -> "+ trb);
		

		int sumX=0,mX=0;
		for(int i=0; i< dc.length; i++) {
			
			for (int j = 0; j < tra; j++) {
				sumX+=delays[j];	
			}
			mX = (int) (((sumX / tra) / rho) * rho);
			
			dc[i] = maxd-mX;
			System.out.println("DELAY CENTER X -> "+ dc[i]);
		}
	
		return dc;
	}
	
	public static double[]  weights(double[] val) {
		System.out.println("-----weights-----");
		double [] w = new double[val.length];
		
		for(int i=0; i< val.length;i++) {
			w[i] = val[i];
			System.out.println("weight X -> " + w[i]);
		}
			 
		return w;
		
	}
}
