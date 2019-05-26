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
 *
 */
public class SimpleCluster {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		double[][] data = {{(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble())},
						   {(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble()),(-100 + (100 - (-100)) * r.nextDouble())},
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
		
		double rho=0.5;
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
				deldaycen[i] =10;
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
				ones[i] =10;
			}
			delaysAug.add(ones);
			

 			double [] onesw = new double[WeigthIni[0].length];

				for(int j =0; j < WeigthIni[0].length;j++)
					onesw[j] = 10;
			
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
			
			System.out.println("fweights --> XXXX "+ fweights.length +":"+ fweights[0].length);
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
			
			int tmax =15;
			double t=0;
			double dt=0;
			double tau=1.84;
			double sai =0;
			System.out.println("");
			double [] out = new double[fweights[0].length];
			double acu =0;
			double teta=2.04;		
			int [] tmp = new int[fdelays[0].length];
			List<Object> arrn = new ArrayList<Object>();			

				while (t <= tmax) {
				
					
					arrn = new ArrayList<Object>();
					for (int i = 0; i < fdelays.length; i++) {// inputs
					//	System.out.println("");
						acu = 0;
						out = new double[fweights[0].length];
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
							//System.out.println("");
							for (int jj = 0; jj < out.length; jj++) {
						//		System.out.println(jj+" --> "+out[jj]);
								if ( (max >= teta) && (max == out[jj])) {

										 tmp[i] = jj;
								}
							}

							arrn.add(tmp[i]);
						}

					}
					t += rho;
				}
				System.out.println("arrn "+ arrn);

					List<Double> list = null;
					int y;
					HashMap<Object, Object> hasmap =  new HashMap<>();
					for (int out1 = 0; out1< output; out1++) {
						y=0;
						list = new ArrayList<Double>();
						for (int x = 0; x < testingData.length; x++) { // inputs
							for (int x1 = 0; x1 < testingData[0].length; x1++) { // values
								y++;
								
								if ((int) arrn.get(y) == out1) {
									list.add(testingData[x][x1]);
								}
								
								if(y>fsize )
									break;
								
							}
						}
						hasmap.put(out1, list);
					}
					System.out.println("\n -- final values by classes ---");
					for (int out1 = 0; out1< output; out1++) {
						System.out.println(out1+" : "+hasmap.get(out1));
						
					}
					
						
						
						
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
