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
 * SRM -Cluster
 * Multiple synapses
 * Five Outputs
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
						(-100 + (100 - (-100)) * r.nextDouble())},
					{(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
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
									(-100 + (100 - (-100)) * r.nextDouble())},{(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
										(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
										(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
										(-100 + (100 - (-100)) * r.nextDouble())},
					{(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
											(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
											(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
											(-100 + (100 - (-100)) * r.nextDouble())},{(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
												(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
												(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
												(-100 + (100 - (-100)) * r.nextDouble())},{(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
													(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
													(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
													(-100 + (100 - (-100)) * r.nextDouble())}};
		
		int output =5;
		double rho =0.1;
		int tau = 3;
		int rf =8;
		double [] sigma = new double[rf];
		
		//initialize sigma
		for (int i =0; i < rf; i++) {
			sigma[i] = 1/(1.5*(i-2));			
		}
		double f_cut=0.9;
		int maxd=10;
		
		System.out.println("-- inputs --");
		printMatrix(input);
		
		
		System.out.println("");
		System.out.println("----sub-synapses delays---\n");
		double[] d = new double[13];
		int ssin = d.length; 
		for (int i = 0; i< d.length; i++) {
			d[i] = 0 + ( (1 - (0)) * r.nextDouble()) ;
			System.out.print(" "+d[i]+ ", ");
		}
		
		int w_max=1, w_min=0; 
		int max_epoch=3; 
		int t_max=30; // max training time
		double eta=0.35; 
		double beta=0.2; 
		double nu=5.0;  
		
		double kapa = 1 - Math.pow(nu, 2) / ( 2*Math.log(beta/(beta+1)) );
		double teta = 12;

		System.out.println("\n\n--weights initialization--");
		double [][] w = iniweights(rf, output, ssin, w_max, w_min); // initialize weights 
		System.out.println("");
		double[][] InputnormData =null; 
		
		List<Object>  normDatalst = new ArrayList<>();
		for (int i =0; i < input.length; i++) {
			System.out.println("\n\nInput -> "+ i);
			InputnormData =Receptive_Fields_Encoding.receptive_fields(input[i], rf, maxd, sigma, f_cut, rho, 0);// encoding inputs
			normDatalst.add(InputnormData);
		}
		
	
		
		System.out.println("\n ........................ training ...........................\n");
		//training
		double [] delta_t = new double[ssin];
		HashMap<Object, Object> neuTime = null;
		int ctr =0;
		while (ctr <= max_epoch) {

			for (int fin = 0; fin < normDatalst.size(); fin++) {

				InputnormData = (double[][]) normDatalst.get(fin);

				for (int i = 0; i < InputnormData.length; i++) {// 8

					System.out.println("");
					neuTime = calculate_firing(InputnormData[i], t_max, w, d, tau, rho, teta, 0);
					System.out.println("firing Size -> " + neuTime.size());

					for (int j = 0; j < InputnormData[0].length; j++) { // 8
						if (InputnormData[i][j] == -1.0) {

							for (int x = 0; x < w.length; x++) {// 8
								for (int y = 0; y < w[0].length; y++) {// 5
									if (i == x && j == y && neuTime.containsKey(j)) { // modify j
										System.out.println(
												"weight -> " + w[x][y] + ", data -> " + InputnormData[i][j] + ", ");
										w[x][y] = w[x][y] - eta;
										System.out.println("newWeight -> " + w[x][y]);
									}
								}
							} // x
						} else {

							for (int x = 0; x < w.length; x++) {// 8

								for (int y = 0; y < w[0].length; y++) {// 5
									if (i == x && j == y && neuTime.containsKey(j)) { // modify j
										System.out.println(
												"weight -> " + w[x][y] + ", data -> " + InputnormData[i][j] + ", ");

										for (int id = 0; id < d.length; id++) {
											delta_t[id] = InputnormData[i][j] + d[i] - (double) neuTime.get(j);
											w[x][y] = w[x][y] + eta * ((1 + beta)
													* Math.exp(-1 * (Math.pow(delta_t[id] + 2.3, 2) / (2 * kapa - 2)))
													- beta);

										}
										System.out.println("newWeight -> " + w[x][y]);
									}

								}
							} // x

						} // end else

						for (int x = 0; x < w.length; x++) {// 8

							for (int y = 0; y < w[0].length; y++) {// 5
								if (i == x && j == y && neuTime.containsKey(j)) { // modify j
									if (w[x][y] < w_min) {
										w[x][y] = w_min;
										System.out.println("less than " + w_min + " weight updated");
									}

									if (w[x][y] > w_max) {
										w[x][y] = w_max;
										System.out.println("more than " + w_max + " weight updated");
									}

								}
							}
						} // weigth range validation [0,1]

					} // data

				} // rows

			} // array all data
			ctr += 1;
			teta = teta + (0.3 * teta) / max_epoch;
		}//epochs
		System.out.println("----- new weights ----");
		for (int x = 0; x < w.length; x++) {// 8
			 System.out.println("");
			for (int y = 0; y < w[0].length; y++) {// 5
				System.out.print(w[x][y]+", ");
			}
		}
		
	
	
	double[][] inputTesting = 
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
					(-100 + (100 - (-100)) * r.nextDouble())},
				{(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
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
								(-100 + (100 - (-100)) * r.nextDouble())},{(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
									(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
									(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
									(-100 + (100 - (-100)) * r.nextDouble())},
				{(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
										(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
										(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
										(-100 + (100 - (-100)) * r.nextDouble())},{(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
											(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
											(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
											(-100 + (100 - (-100)) * r.nextDouble())},{(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
												(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
												(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),
												(-100 + (100 - (-100)) * r.nextDouble())}};
	
		
	
		System.out.println("\n\n-- Testing inputs --");
		printMatrix(inputTesting);
	
		testing(inputTesting, output, rf, maxd, sigma, f_cut, t_max, w, delta_t, tau, rho, teta, 0);
	}
	
	
	public static void testing(double[][] inputTesting,int output, int rf, int maxd, double[] sigma, double f_cut, int t_max, double[][] w, double[] d, int tau, double rho, double teta,  int type) {
		System.out.println("\n\n---------------------------------------- testing ------------------------------------------");
		HashMap<Object, Object> neuTime = null;
		double[][] InputnormDataTest =null;
		List<Object>  normDataTest = new ArrayList<>();
		for (int i =0; i < inputTesting.length; i++) {
			
			InputnormDataTest =Receptive_Fields_Encoding.receptive_fields(inputTesting[i], rf, maxd, sigma, f_cut, rho, type);// encoding inputs
			normDataTest.add(InputnormDataTest);
		}
		
			int k = 0;
			HashMap<Object, Object> mapData= new HashMap<>();
			System.out.println("\nclass --- data");
			List<Object> classes = new ArrayList<Object>();
			for (int fin = 0; fin < normDataTest.size(); fin++) {// 3
				InputnormDataTest = (double[][]) normDataTest.get(fin);
			//	System.out.println("");
				for (int i = 0; i < InputnormDataTest.length; i++) {// 10

					neuTime = calculate_firing(InputnormDataTest[i], t_max, w, d, tau, rho, teta, 0);

					for (Object key : neuTime.keySet()) {
						k = (int) key;	
						
					//	System.out.println("k->>"+neuTime.keySet());
					}
					classes.add(k);

				}
				mapData.put(inputTesting[fin], classes.get(fin));
			}


		for (int x = 0; x < output; x++) {
			for (int i = 0; i < inputTesting.length; i++) {// 3
				
				if (x == (int) mapData.get(inputTesting[i])) {
					System.out.println("\n"+x);
					for (int j = 0; j < inputTesting[0].length; j++) {// 3

						System.out.print( inputTesting[i][j] +", ");

					}
				}
			}

		}

		
	}
	
	public static void printMatrix(double [][] mat) {
		for(int i=0; i< mat.length; i++) {
			System.out.println(" ");
			for(int j=0; j< mat[0].length; j++) {
				System.out.print( mat[i][j] + ", ");
				
			}
			
			
		}
		
		
	}
	
	public static double [][] iniweights(int rf, int output, int ssin, int w_max, int w_min) {//5 X 8
		Random r = new Random();
		double [][] w = new double[rf][output];
		for (int i =0; i < rf; i++) {
			System.out.println("");
			for (int j =0; j < output; j++) {
				//(-100 + (100 - (-100)) * r.nextDouble())
				w[i][j] = w_min + ( (w_max - (w_min)) * r.nextDouble()) * (w_max-w_min);
				System.out.print(w[i][j]+", ");
			}
		}
		return w;
	}
	
	public static HashMap<Object, Object> calculate_firing(double[] input, int t_max, double[][] w, double[] d, int tau, double rho, double teta, int typ ) {
		//outputs  w-col  5
		// number of values input- col  8
		// sub-synapses d-length 13		
	//	System.out.println("\n\nsizes - > "+ w[0].length + ":"+ input.length +":"+d.length);
		
		double t =0;
		double dt =0,dtt=0, sai=0;	
		double [] output = new double[w[0].length];
		double acu =0;
		double max=0;
		HashMap<Object, Object> neuTime = new HashMap<>();
		while (t <= t_max) { // 30
			output = new double[w[0].length];

			for (int i = 0; i < w[0].length; i++) { // 5

			//	acu = 0;
				for (int j = 0; j < input.length; j++) { // 8

					if (input[j] != -1)
						dt = t - input[j];

					for (int k = 0; k < d.length; k++) { // 13

						dtt = (dt - d[k]) / tau;
						sai = w[j][i] * dtt * Math.exp(1 - dtt);

						if (sai < 0)
							sai = 0;

						output[i] += sai;

					}

				}
				//output[i] = acu;
			}

			max = NormalDataLinearEncoding.mayData(output);
			if (max > teta) {

				for (int i = 0; i < output.length; i++) {
					if (output[i] == max) {

						neuTime.put(i, t);
					}
				}
			}
			t += rho;
		} // while
		
		return neuTime;
	}

}
