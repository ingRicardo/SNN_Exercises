/**
 * 
 */
package testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Ricardo Alfredo Macias Olvera
 *
 */
public class SimpleCluster {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		double[][] data = {{75.0,-21.0,-11.0,95.0,55.0,33.0,-54.2,92.5,5.2,8.6},
						   {-25.0,81.0,61.0,-65.7,35.8,-43.5,94.2,52.5,-3.9,6.2},
						   {(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble())},
				   		   {(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble())}
						   };
		
		double [] input = new double[data[0].length];
		 
		double [] delays = null;
		double[] dc = null;
		double[] w = null;
		double[][] WeigthIni = {{1.0,1.0},
									 {1.0,1.0},
									 {1.0,1.0},
									 {1.0,1.0}};
		double [] winput = new double[WeigthIni[0].length];
		
		double rho=0.1;
		int maxd=10;
		int tra =4;
		int output=2;
		int trb = (input.length/2) + tra;
		List<double []> weights = new ArrayList<double []>();
		List<double []> delcent = new ArrayList<double []>();
		System.out.println("input length -> "+ input.length);
		System.out.println("data inputs -> "+data.length);
		System.out.println("data size values -> " +data[0].length);
			for (int i=0; i< data.length; i++) { //inputs
				for (int j=0; j< data[0].length; j++) { //values
					input[j] = data[i][j];
				}
				 delays = NormalDataLinearEncoding.DelaysOutput(input, rho, maxd);
					//------training----
				 dc = delaysCenters(output,tra, trb, delays, maxd, rho);
				 delcent.add(dc);
				 for (int j=0; j< WeigthIni[0].length; j++) {
					 winput[j]=WeigthIni[i][j];
				 }
				 
				 w = weights( winput);
				 weights.add(w);
			}
		
			double [] deldaycen = new double[dc.length];
			for (int i=0; i<deldaycen.length; i++) {
				deldaycen[i] =1;
			}
			 delcent.add(deldaycen);
			 
			 
			 double randomValue = (-100 + (100 - (-100)) * r.nextDouble());
			 System.out.println("random --> "+randomValue);
			 
			//double[][] testingData = {{-25.0,-41.0,-81.0,10.3,35.0,53.0,-34.2,12.5,8.2,6.6},
				//	   					{45.0,71.0,-61.0,75.8,-55.5,23.5,84.2,-72.5,5.9,-66.2}};
			
			
			double[][] testingData = {{(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble())},
									  {(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble())},
									  {(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble())},
									  {(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble())}};
			
			int fsize = testingData[0].length*testingData.length;
			System.out.println("fsize -> "+ fsize);
			System.out.println("-----testing------");
			List<double []> delaysAug = new ArrayList<double []>();
			for (int i=0; i< testingData.length; i++) { //inputs
				for (int j=0; j< testingData[0].length; j++) { //values
					input[j] = testingData[i][j];
				}
				 delays = NormalDataLinearEncoding.DelaysOutput(input, rho, maxd);
				
				 delaysAug.add(delays);
			}
			double [] ones = new double[data[0].length];
			for (int i=0; i<ones.length; i++) {
				ones[i] =1;
			}
			delaysAug.add(ones);
			

			double [] wones = new double[w.length];
			for (int i=0; i<w.length; i++) {
				wones[i] =1;
			}
			
 			double [] onesw = new double[WeigthIni[0].length];
			//for (int i = 0; i < WeigthIni.length; i++)
				for(int j =0; j < WeigthIni[0].length;j++)
					onesw[j] = 1;
			
				weights.add(weights(onesw));
			
			
			System.out.println("\ndelaysAug -> "+ delaysAug);
			System.out.println("\nweightsg -> "+ weights);
			
			double [][] fdelays = new double[delaysAug.size()][data[0].length];
			for (int i =0; i < delaysAug.size(); i++) {
				
				if (delaysAug.get(i) instanceof double[]) {
					double [] delaysi = delaysAug.get(i); 
					int c =0;
					for (double d : delaysi) {
						fdelays[i][c] = d;
						c++;
					}
					
				}
				
			}
			System.out.println("");
			System.out.println("\ndelays");
			for (int i =0; i < fdelays.length; i++) {
				System.out.println("");
				for (int j =0; j < fdelays[0].length; j++) {
					
							System.out.print(" "+fdelays[i][j] );
				}
			}
			System.out.println("\nweights");
			double [][] fweights = new double[weights.size()][w.length];
			for (int i =0; i < weights.size(); i++) {
				if (weights.get(i) instanceof double[]) {
					double [] weightsi = weights.get(i); 
					int c =0;
					for (double we : weightsi) {
						fweights[i][c] = we;
						c++;
					}
					
				}
			}
			for (int i =0; i < fweights.length; i++) {
				System.out.println("");
				for (int j =0; j < fweights[0].length; j++) {
					
							System.out.print(" "+fweights[i][j] );
				}
			}
			
			double [][] fdelcent= new double[delcent.size()][dc.length];
			for (int i =0; i < delcent.size(); i++) {
				if (delcent.get(i) instanceof double[]) {
					double [] delcenti = delcent.get(i); 
					int c =0;
					for (double delce : delcenti) {
						fdelcent[i][c] = delce;
						c++;
					}
					
				}
			}
			System.out.println("\n -----delay centers---");
			for (int i =0; i < fdelcent.length; i++) {
				System.out.println("");
				for (int j =0; j < fdelcent[0].length; j++) {
					
							System.out.print(" "+fdelcent[i][j] );
				}
			}
			
			int tmax =12;
			double t=0;
			double dt=0;
			double tau=1.44;
			double sai =0;
			System.out.println("");
			double [] out = new double[fweights[0].length];
			double acu =0;
			double teta=2.04;		
			int n=0;
			int [] tmp = new int[fdelays[0].length];
			List<Object> arrn = new ArrayList<Object>();			

				while (t <= tmax) {
					acu = 0;
					out = new double[fweights[0].length];
					arrn = new ArrayList<Object>();
					for (int i = 0; i < fdelays.length; i++) {// inputs
					//	System.out.println("");
						tmp = new int[fdelays[0].length];
						for (int j = 0; j < fdelays[0].length; j++) {// values

							dt = (t - fdelays[i][j]);

							for (int k = 0; k < fweights[0].length; k++) { // output
								sai = fweights[i][k] * ((dt - fdelcent[i][k]) / tau)
										* Math.exp(1 - ((dt - fdelcent[i][k]) / tau));

								if (sai < 0)
									sai = 0;

								acu += sai;
								out[k] = acu;
							}

							double max = NormalDataLinearEncoding.mayData(out);

							for (int jj = 0; jj < out.length; jj++) {

								if ( (max >= teta) && (max == out[jj])) {

									if (out[0] == out[1]) {
										if (jj == 1) {
											n = 0;
											 tmp[i] = n;
										}
									} else {
										n = jj;
										 tmp[i] = n;
									}

								}
							}

						//	System.out.println(" "+ tmp[i]);
							arrn.add(tmp[i]);
						}

					}
					t += rho;
				}
				System.out.println("arrn "+ arrn);

				List<Double> classZero = new ArrayList<Double>();
				List<Double> classOne = new ArrayList<Double>();
					int y =0;
					for (int x = 0; x < testingData.length; x++) { // inputs
						for (int x1 = 0; x1 < testingData[0].length; x1++) { // values
							System.out.println(testingData[x][x1] +" -> "+ arrn.get(y));
							y++;
							if ((int) arrn.get(y) == 0)
								classZero.add(testingData[x][x1]);
								else if ((int) arrn.get(y) == 1)
								classOne.add(testingData[x][x1]);
							
							if(y>fsize )
								break;
						}
					}
					
					
					System.out.println("\n class Zero values ");
					
					for (Double double1 : classZero) {
						System.out.println(double1);
					}
					
					
					System.out.println("\n class One values ");
					
					for (Double double1 : classOne) {
						System.out.println(double1);
					}
	}
	
	public static double[]  delaysCenters(int size,int tra,int trb,double [] delays, int maxd, double rho) {
		System.out.println("\n\n---delaysCenters---");
	//	int m1 = 0, sum = 0, m2 = 0, sum2 = 0;
		double[] dc = new double[size];
		System.out.println("training data -> " + tra);
		System.out.println("trb -> "+ trb);
		
		/*for (int i = 0; i < tra; i++)
			sum += delays[i];

		for (int i = tra; i < trb; i++)
			sum2 += delays[i];

		m1 = (int) (((sum / tra) / rho) * rho);
		m2 = (int) (((sum2 / tra) / rho) * rho);

		System.out.println("center 1 -> " + m1);
		System.out.println("center 2 -> " + m2);
		
		dc[0] = maxd - m1;
		dc[1] = maxd - m2;
		System.out.println("delay center m1 -> " + dc[0]);
		System.out.println("delay center m2 -> " + dc[1]);
		*/
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
			 
		/*w[0] = w1;
		w[1] = w2;	
		System.out.println("weight 1 -> " + w[0]);
		System.out.println("weight 2 -> " + w[1]);
		*/
		return w;
		
	}
}
