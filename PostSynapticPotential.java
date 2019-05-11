/**
 * 
 */
package nnets;

/**
 * @author Ricardo Alfredo Macias Olvera
 *		The Postsynaptic Potential – PSP
 */
public class PostSynapticPotential {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double t=1; //Actual time
		
		double ti = .04; //presynaptic firing time
		double deltaAxij =.06; //axonal transmission delay
		double tau = .04; //time constant
		
		double eij=0; //Generic Post Synaptic Potential
		
		eij = eij(t, ti, deltaAxij, tau);
		
		System.out.println(eij);
		
	}
	
	
	public static double eij(double t, double ti, double deltaAxij, double tau ) {
		double eij =0 ;
			
		eij = ((t-ti-deltaAxij)/tau) * 
					Math.exp(1-((t-ti-deltaAxij)/tau)) * HeavySideStep(t,ti,deltaAxij);
			
		return eij;
	}
	//HeavySide Step Function
	public static double HeavySideStep(double t, double ti, double deltaAxij) {
		double res = t-ti-deltaAxij;
		
			if (res > 0)
				res = 1;
			else
				res =0;
		
		
		return res;
	}

}
