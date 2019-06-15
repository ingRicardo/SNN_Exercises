/**
 * 
 */
package testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Ricardo Alfredo Macias Olvera
 * SRM -Cluster
 * Multiple synapses
 * Five Outputs
 */
public class Clustering {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Random r = new Random();
/*		double[][] input ={	{ 84 ,  152 ,  100 ,    52 ,   95 , 186,   169,   106 ,   37  , 186  , 140  , 202  ,  99  , 105  ,  88  , 114  ,  55  , 186  ,  78 ,  152  , 155 ,   69 ,  190  ,  65  , 214 ,  116  ,  75  ,  55  , 123   , 65  , 154  , 177      },            
				              
				              
				 {  74 ,    49,    70 ,  136 ,   76 ,  172 ,  184 ,   78,    62 ,   35 ,  164 ,  108 ,  189 ,  155 ,   89 ,  136 ,  183 ,  127 ,   62,    78 ,  145 ,  223,    35 ,  179 ,   67,   103 ,  116 ,  117 ,   61  , 177 ,   48 ,  205    },              
				 {  73 ,    48,    70 ,  139 ,   75 ,  173 ,  184 ,   77,    64 ,   35 ,  165 ,  110 ,  191 ,  156 ,   91 ,  139 ,  182 ,  124 ,   66,    74 ,  144 ,  221,    35 ,  178 ,   65,   105 ,  116 ,  118 ,   61  , 175 ,   49 ,  208    },              
				 {  70 ,    49,    69 ,  141 ,   81 ,  172 ,  186 ,   79,    61 ,   32 ,  163 ,  110 ,  188 ,  153 ,   91 ,  140 ,  179 ,  121 ,   66,    74 ,  145 ,  218,    34 ,  174 ,   69,   111 ,  112 ,  119 ,   58  , 171 ,   48 ,  207    },              
				 {  73 ,    48,    70 ,  139 ,   75 ,  173 ,  184 ,   77,    64 ,   35 ,  165 ,  110 ,  192 ,  156 ,   91 ,  139 ,  181 ,  124 ,   66,    74 ,  144 ,  221,    34 ,  179 ,   65,   105 ,  116 ,  118 ,   61  , 175 ,   49 ,  208    },              
				 {  70 ,    49,    69 ,  138 ,   74 ,  170 ,  185 ,   79,    69 ,   32 ,  164 ,  108 ,  193 ,  154 ,   90 ,  138 ,  183 ,  123 ,   69,    78 ,  137 ,  219,    37 ,  182 ,   65,   104 ,  118 ,  116 ,   52  , 175 ,   48 ,  208    },              
				 {  72 ,    56,    67 ,  142 ,   78 ,  168 ,  182 ,   74,    60 ,   39 ,  166 ,  113 ,  197 ,  155 ,   93 ,  136 ,  179 ,  124 ,   64,    77 ,  143 ,  224,    34 ,  176 ,   60,    97 ,  115 ,  109 ,   57  , 181 ,   53 ,  204    },              
				 {  72 ,    48,    71 ,  139 ,   75 ,  173 ,  185 ,   77,    63 ,   34 ,  166 ,  110 ,  191 ,  158 ,   92 ,  138 ,  180 ,  124 ,   66,    72 ,  143 ,  221,    34 ,  179 ,   65,   106 ,  115 ,  117 ,   60  , 176 ,   50 ,  209    },              
				 {  75 ,    46,    65 ,  141 ,   81 ,  173 ,  185 ,   78,    60 ,   34 ,  167 ,  114 ,  191 ,  157 ,   92 ,  135 ,  189 ,  129 ,   64,    73 ,  145 ,  219,    36 ,  179 ,   65,   104 ,  116 ,  124 ,   61  , 180 ,   48 ,  210    },              
				 {  71 ,    40,    75 ,  144 ,   75 ,  177 ,  172 ,   85,    74 ,   46 ,  173 ,  114 ,  188 ,  164 ,   94 ,  135 ,  185 ,  119 ,   70,    78 ,  140 ,  226,    38 ,  180 ,   68,   104 ,  110 ,  118 ,   65  , 165 ,   45 ,  210    },              
				 {  73 ,    51,    75 ,  139 ,   73 ,  173 ,  183 ,   81,    66 ,   32 ,  168 ,  115 ,  191 ,  156 ,   91 ,  137 ,  190 ,  125 ,   65,    72 ,  144 ,  222,    31 ,  176 ,   68,   105 ,  113 ,  111 ,   59  , 175 ,   53 ,  209    },              
				 {  73 ,    45,    71 ,  138 ,   75 ,  174 ,  181 ,   75,    64 ,   34 ,  166 ,  106 ,  194 ,  156 ,   92 ,  139 ,  183 ,  125 ,   65,    75 ,  142 ,  221,    33 ,  178 ,   66,   106 ,  118 ,  117 ,   62  , 175 ,   49 ,  208    },              
				 {  70 ,    45,    71 ,  137 ,   77 ,  173 ,  184 ,   81,    64 ,   36 ,  166 ,  110 ,  194 ,  157 ,   93 ,  140 ,  178 ,  122 ,   66,    72 ,  142 ,  220,    35 ,  178 ,   65,   107 ,  112 ,  115 ,   58  , 176 ,   51 ,  206    },              
				 {  76 ,    45,    69 ,  137 ,   77 ,  174 ,  183 ,   79,    66 ,   35 ,  164 ,  111 ,  191 ,  150 ,   92 ,  139 ,  186 ,  124 ,   68,    74 ,  143 ,  222,    34 ,  177 ,   61,   104 ,  114 ,  116 ,   60  , 176 ,   48 ,  203    },              
				 {  70 ,    49,    72 ,  142 ,   74 ,  172 ,  183 ,   74,    63 ,   34 ,  167 ,  112 ,  191 ,  159 ,   91 ,  141 ,  184 ,  122 ,   66,    75 ,  143 ,  221,    35 ,  177 ,   65,   103 ,  119 ,  120 ,   64  , 177 ,   50 ,  208    },              
				 {  73 ,    48,    70 ,  139 ,   75 ,  173 ,  184 ,   77,    64 ,   35 ,  165 ,  111 ,  191 ,  156 ,   91 ,  139 ,  182 ,  124 ,   66,    75 ,  144 ,  221,    35 ,  178 ,   65,   105 ,  116 ,  117 ,   61  , 175 ,   49 ,  208    },              
				 { 105 ,    53,   168 ,   76 ,  187 ,  142 ,  155 ,  181,   128 ,   63 ,  215 ,  129 ,   95 ,   62 ,   94 ,  162 ,  216 ,  116 ,   92,   123 ,  194 ,   67,   196 ,  193 ,  114,   101 ,   58 ,   78 ,   80  , 132 ,   97 ,   76    },              
				 { 106 ,    53,   170 ,   75 ,  187 ,  148 ,  153 ,  184,   130 ,   61 ,  217 ,  126 ,   96 ,   60 ,   97 ,  161 ,  216 ,  117 ,   89,   122 ,  190 ,   67,   198 ,  192 ,  118,    99 ,   59 ,   82 ,   78  , 131 ,   96 ,   76    },              
				 { 106 ,    53,   169 ,   77 ,  187 ,  141 ,  155 ,  181,   127 ,   63 ,  215 ,  129 ,   95 ,   61 ,   95 ,  161 ,  215 ,  116 ,   92,   123 ,  193 ,   68,   197 ,  193 ,  114,   103 ,   59 ,   78 ,   80  , 132 ,   97 ,   74    },              
				 { 105 ,    53,   168 ,   77 ,  188 ,  143 ,  155 ,  181,   128 ,   63 ,  216 ,  129 ,   94 ,   62 ,   94 ,  161 ,  216 ,  116 ,   91,   123 ,  193 ,   68,   196 ,  193 ,  114,   103 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
				 { 103 ,    52,   169 ,   76 ,  188 ,  145 ,  154 ,  183,   129 ,   61 ,  216 ,  132 ,   96 ,   61 ,   96 ,  161 ,  214 ,  120 ,   90,   126 ,  194 ,   70,   198 ,  190 ,  110,   100 ,   57 ,   77 ,   84  , 129 ,   97 ,   73    },              
				 { 105 ,    58,   175 ,   72 ,  194 ,  146 ,  157 ,  178,   132 ,   63 ,  213 ,  128 ,   91 ,   60 ,   90 ,  160 ,  219 ,  115 ,   91,   122 ,  201 ,   70,   199 ,  189 ,  113,   104 ,   55 ,   78 ,   82  , 134 ,   96 ,   74    },              
				 { 105 ,    54,   174 ,   81 ,  186 ,  156 ,  153 ,  187,   133 ,   59 ,  212 ,  133 ,   91 ,   60 ,   88 ,  154 ,  209 ,  112 ,   81,   111 ,  195 ,   72,   191 ,  186 ,  113,    97 ,   60 ,   78 ,   81  , 140 ,   99 ,   72    },              
				 { 105 ,    53,   169 ,   77 ,  188 ,  142 ,  155 ,  181,   128 ,   63 ,  215 ,  129 ,   95 ,   62 ,   94 ,  161 ,  216 ,  116 ,   91,   122 ,  194 ,   67,   196 ,  192 ,  114,   102 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
				 { 105 ,    53,   168 ,   77 ,  187 ,  142 ,  155 ,  181,   128 ,   63 ,  215 ,  129 ,   95 ,   62 ,   94 ,  161 ,  216 ,  116 ,   91,   123 ,  194 ,   68,   196 ,  193 ,  113,   102 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
				 { 104 ,    55,   166 ,   77 ,  188 ,  142 ,  154 ,  186,   128 ,   65 ,  215 ,  126 ,   92 ,   60 ,   94 ,  163 ,  214 ,  116 ,   91,   124 ,  193 ,   69,   194 ,  193 ,  116,   101 ,   59 ,   76 ,   82  , 132 ,   99 ,   74    },              
				 { 106 ,    53,   168 ,   77 ,  187 ,  144 ,  156 ,  182,   128 ,   62 ,  215 ,  129 ,   94 ,   62 ,   93 ,  160 ,  216 ,  116 ,   90,   124 ,  194 ,   68,   195 ,  192 ,  113,   102 ,   56 ,   78 ,   79  , 132 ,   98 ,   74    },              
				 { 104 ,    53,   169 ,   77 ,  188 ,  142 ,  155 ,  181,   128 ,   62 ,  215 ,  128 ,   95 ,   62 ,   94 ,  161 ,  215 ,  116 ,   91,   122 ,  193 ,   68,   195 ,  193 ,  114,   103 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
				 { 105 ,    52,   168 ,   76 ,  187 ,  143 ,  155 ,  182,   127 ,   62 ,  215 ,  128 ,   94 ,   63 ,   93 ,  162 ,  214 ,  116 ,   92,   123 ,  193 ,   68,   196 ,  194 ,  114,   103 ,   59 ,   77 ,   80  , 131 ,   96 ,   75    },              
				 { 105 ,    53,   169 ,   77 ,  187 ,  142 ,  155 ,  181,   128 ,   63 ,  215 ,  129 ,   95 ,   62 ,   94 ,  161 ,  216 ,  116 ,   91,   123 ,  194 ,   67,   196 ,  192 ,  114,   102 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
				 { 105 ,    53,   169 ,   77 ,  188 ,  142 ,  155 ,  181,   128 ,   63 ,  215 ,  129 ,   95 ,   62 ,   94 ,  161 ,  216 ,  116 ,   91,   123 ,  194 ,   68,   196 ,  193 ,  114,   102 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
				 { 104 ,    50,   170 ,   82 ,  189 ,  143 ,  153 ,  182,   132 ,   63 ,  211 ,  122 ,   96 ,   65 ,   94 ,  162 ,  218 ,  113 ,   92,   124 ,  192 ,   68,   197 ,  189 ,  109,   103 ,   58 ,   74 ,   80  , 133 ,  102 ,   75    },              
				 { 105 ,    53,   168 ,   77 ,  188 ,  142 ,  155 ,  182,   127 ,   63 ,  215 ,  129 ,   95 ,   62 ,   94 ,  161 ,  216 ,  116 ,   91,   122 ,  194 ,   68,   195 ,  192 ,  114,   102 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
				 { 109 ,    50,   169 ,   75 ,  186 ,  143 ,  151 ,  183,   130 ,   60 ,  218 ,  124 ,   91 ,   58 ,   95 ,  156 ,  222 ,  116 ,   94,   121 ,  196 ,   70,   198 ,  196 ,  112,   101 ,   59 ,   73 ,   81  , 133 ,   98 ,   74    },              
				 { 104 ,    53,   169 ,   78 ,  187 ,  142 ,  156 ,  182,   128 ,   63 ,  215 ,  129 ,   95 ,   62 ,   94 ,  162 ,  216 ,  115 ,   92,   123 ,  194 ,   67,   196 ,  192 ,  114,   103 ,   59 ,   78 ,   80  , 132 ,   98 ,   74    },              
				 { 105 ,    53,   169 ,   77 ,  188 ,  142 ,  155 ,  181,   128 ,   63 ,  215 ,  129 ,   95 ,   62 ,   94 ,  161 ,  216 ,  116 ,   91,   122 ,  193 ,   68,   196 ,  192 ,  114,   102 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
				 { 103 ,    56,   169 ,   78 ,  188 ,  142 ,  152 ,  181,   130 ,   65 ,  216 ,  130 ,   93 ,   62 ,   95 ,  160 ,  218 ,  119 ,   91,   124 ,  192 ,   67,   196 ,  195 ,  114,   101 ,   55 ,   77 ,   80  , 136 ,   97 ,   77    },              
				 { 105 ,    53,   168 ,   77 ,  187 ,  143 ,  155 ,  181,   128 ,   63 ,  215 ,  129 ,   95 ,   62 ,   95 ,  161 ,  215 ,  116 ,   91,   123 ,  194 ,   68,   196 ,  193 ,  113,   103 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
				 { 105 ,    53,   168 ,   76 ,  188 ,  142 ,  155 ,  181,   128 ,   63 ,  215 ,  129 ,   94 ,   62 ,   94 ,  162 ,  215 ,  116 ,   92,   123 ,  194 ,   67,   195 ,  192 ,  114,   102 ,   59 ,   78 ,   80  , 132 ,   98 ,   75    },              
				 {  99 ,    52,   169 ,   79 ,  188 ,  148 ,  154 ,  172,   121 ,   62 ,  210 ,  122 ,   91 ,   65 ,   90 ,  165 ,  216 ,  116 ,   86,   128 ,  197 ,   68,   203 ,  198 ,  109,   100 ,   47 ,   86 ,   78  , 126 ,   97 ,   80    },              
				 { 105 ,    53,   168 ,   77 ,  188 ,  142 ,  155 ,  181,   128 ,   63 ,  215 ,  129 ,   95 ,   62 ,   94 ,  161 ,  216 ,  116 ,   91,   122 ,  194 ,   68,   196 ,  192 ,  114,   103 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
				 { 108 ,    53,   168 ,   78 ,  186 ,  142 ,  156 ,  181,   128 ,   64 ,  216 ,  130 ,   95 ,   63 ,   96 ,  163 ,  215 ,  120 ,   93,   122 ,  193 ,   67,   192 ,  193 ,  116,   101 ,   59 ,   79 ,   82  , 133 ,   99 ,   73    },              
				 { 105 ,    54,   168 ,   77 ,  187 ,  142 ,  155 ,  182,   128 ,   62 ,  216 ,  129 ,   95 ,   61 ,   95 ,  162 ,  215 ,  116 ,   91,   122 ,  194 ,   68,   196 ,  192 ,  114,   102 ,   58 ,   78 ,   80  , 132 ,   98 ,   75    },              
				 { 103 ,    53,   168 ,   78 ,  187 ,  142 ,  153 ,  180,   129 ,   62 ,  217 ,  128 ,   96 ,   62 ,   92 ,  163 ,  217 ,  119 ,   91,   122 ,  195 ,   68,   195 ,  193 ,  114,   103 ,   60 ,   78 ,   81  , 132 ,   97 ,   74    },              
				 { 106 ,    51,   168 ,   76 ,  184 ,  141 ,  155 ,  181,   130 ,   59 ,  217 ,  129 ,   95 ,   61 ,   97 ,  161 ,  214 ,  115 ,   92,   123 ,  194 ,   67,   196 ,  191 ,  117,   101 ,   61 ,   76 ,   78  , 132 ,   96 ,   75    },              
				 { 101 ,    52,   170 ,   82 ,  185 ,  142 ,  154 ,  183,   129 ,   63 ,  217 ,  126 ,   96 ,   62 ,   93 ,  155 ,  222 ,  115 ,   92,   124 ,  195 ,   64,   193 ,  189 ,  113,   104 ,   61 ,   78 ,   83  , 130 ,   95 ,   75    },              
				 { 105 ,    53,   169 ,   77 ,  187 ,  142 ,  156 ,  181,   129 ,   62 ,  216 ,  129 ,   94 ,   62 ,   94 ,  161 ,  216 ,  116 ,   91,   122 ,  193 ,   67,   196 ,  192 ,  114,   103 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
				 { 106 ,    50,   165 ,   77 ,  185 ,  142 ,  156 ,  183,   128 ,   63 ,  213 ,  126 ,   94 ,   60 ,   96 ,  159 ,  218 ,  117 ,   94,   123 ,  195 ,   67,   199 ,  196 ,  113,   102 ,   59 ,   76 ,   80  , 131 ,   97 ,   71    },              
				 { 105 ,    53,   168 ,   77 ,  188 ,  142 ,  155 ,  181,   128 ,   63 ,  215 ,  129 ,   95 ,   62 ,   94 ,  161 ,  216 ,  116 ,   91,   123 ,  194 ,   68,   196 ,  192 ,  114,   102 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
				 { 104 ,    52,   170 ,   76 ,  189 ,  141 ,  156 ,  183,   127 ,   64 ,  216 ,  129 ,   96 ,   62 ,   97 ,  162 ,  215 ,  117 ,   90,   121 ,  191 ,   68,   196 ,  192 ,  114,   101 ,   58 ,   80 ,   81  , 132 ,   99 ,   75    },              
				 { 105 ,    53,   169 ,   77 ,  187 ,  143 ,  155 ,  181,   129 ,   63 ,  215 ,  129 ,   95 ,   62 ,   94 ,  161 ,  216 ,  116 ,   91,   122 ,  193 ,   67,   196 ,  192 ,  114,   103 ,   58 ,   77 ,   80  , 132 ,   97 ,   74    },              
				 { 104 ,    54,   170 ,   79 ,  188 ,  144 ,  156 ,  181,   127 ,   63 ,  213 ,  130 ,   95 ,   61 ,   96 ,  161 ,  215 ,  116 ,   92,   122 ,  194 ,   67,   197 ,  192 ,  114,   103 ,   59 ,   77 ,   80  , 131 ,   95 ,   76    },              
				 { 104 ,    60,   165 ,   71 ,  192 ,  140 ,  155 ,  176,   128 ,   65 ,  212 ,  136 ,   97 ,   56 ,   95 ,  165 ,  220 ,  118 ,   85,   121 ,  192 ,   61,   201 ,  188 ,  108,   106 ,   61 ,   77 ,   82  , 132 ,  102 ,   75    },              
				 { 104 ,    53,   169 ,   77 ,  187 ,  142 ,  155 ,  181,   128 ,   63 ,  215 ,  129 ,   95 ,   62 ,   94 ,  161 ,  216 ,  116 ,   92,   122 ,  193 ,   68,   196 ,  193 ,  114,   103 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
				 { 105 ,    51,   168 ,   75 ,  187 ,  140 ,  154 ,  180,   127 ,   66 ,  213 ,  128 ,   96 ,   63 ,   94 ,  159 ,  216 ,  115 ,   91,   121 ,  196 ,   66,   194 ,  193 ,  115,   102 ,   60 ,   75 ,   79  , 131 ,   99 ,   75    },              
				 { 105 ,    52,   167 ,   77 ,  188 ,  143 ,  155 ,  181,   128 ,   64 ,  215 ,  129 ,   95 ,   62 ,   95 ,  161 ,  216 ,  116 ,   92,   122 ,  193 ,   66,   196 ,  192 ,  114,   103 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
				 { 104 ,    53,   167 ,   77 ,  188 ,  142 ,  155 ,  181,   128 ,   62 ,  216 ,  129 ,   94 ,   62 ,   95 ,  161 ,  216 ,  116 ,   90,   123 ,  193 ,   68,   195 ,  192 ,  114,   103 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
				 { 105 ,    53,   168 ,   77 ,  188 ,  142 ,  155 ,  182,   128 ,   63 ,  215 ,  128 ,   95 ,   62 ,   94 ,  161 ,  216 ,  117 ,   91,   122 ,  194 ,   68,   195 ,  193 ,  114,   102 ,   58 ,   78 ,   79  , 132 ,   97 ,   75    }              
             };
*/
		// // read KeyWestTemp.txt

	    // create token1
	    String token1 = "";

	    // for-each loop for calculating heat index of May - October

	    // create Scanner inFile1
	    Scanner inFile1 = new Scanner(new File("/home/alfredo/stsProjects/JavaExersices/src/testing/dataseNUmbComma.txt")).useDelimiter(",\\s*");

	    // Original answer used LinkedList, but probably preferable to use ArrayList in most cases
	    // List<String> temps = new LinkedList<String>();
	    List<String> temps = new ArrayList<String>();

	    // while loop
	    while (inFile1.hasNext()) {
	      // find next line
	      token1 = inFile1.next();
	      temps.add(token1);
	    }
	    inFile1.close();

	    String[] tempsArray = temps.toArray(new String[0]);

	    for (String s : tempsArray) {
	      System.out.println(s);
	    }
	    
	    
	    
	    double[][] input = new double[temps.size()][tempsArray.length];
	    
	    for(int s = 0; s< temps.size(); s++) {
	    	for (int u =0; u < tempsArray.length; u++)
	    	input[s][u] = Double.parseDouble(tempsArray[u]) ;
	    	
	    }
	  
		
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
		
	
	
	/*double[][] inputTesting = 
		{				 { 104 ,    53,   168 ,   77 ,  187 ,  143 ,  155 ,  181,   127 ,   63 ,  215 ,  128 ,   94 ,   62 ,   94 ,  160 ,  216 ,  116 ,   92,   123 ,  194 ,   67,   195 ,  192 ,  115,   102 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
			 { 104 ,    51,   167 ,   78 ,  188 ,  146 ,  155 ,  177,   127 ,   66 ,  216 ,  126 ,   95 ,   65 ,   94 ,  161 ,  217 ,  113 ,   92,   125 ,  197 ,   69,   195 ,  191 ,  112,   100 ,   59 ,   79 ,   80  , 134 ,  103 ,   75    },              
			 { 105 ,    53,   168 ,   77 ,  187 ,  142 ,  154 ,  181,   128 ,   63 ,  215 ,  129 ,   94 ,   61 ,   95 ,  161 ,  216 ,  116 ,   91,   123 ,  194 ,   67,   195 ,  192 ,  114,   103 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
			 { 100 ,    59,   168 ,   82 ,  187 ,  139 ,  150 ,  178,   128 ,   67 ,  207 ,  124 ,   90 ,   65 ,   97 ,  161 ,  218 ,  123 ,   86,   122 ,  190 ,   55,   193 ,  193 ,  123,   104 ,   60 ,   73 ,   74  , 149 ,   89 ,   80    },              
			 { 104 ,    52,   168 ,   78 ,  188 ,  143 ,  155 ,  182,   129 ,   62 ,  217 ,  128 ,   95 ,   62 ,   95 ,  162 ,  215 ,  116 ,   92,   122 ,  192 ,   68,   194 ,  191 ,  114,   102 ,   58 ,   78 ,   78  , 133 ,   95 ,   77    },              
			 { 105 ,    53,   168 ,   77 ,  187 ,  143 ,  155 ,  181,   127 ,   63 ,  215 ,  129 ,   95 ,   62 ,   94 ,  161 ,  215 ,  116 ,   92,   122 ,  194 ,   67,   196 ,  193 ,  114,   102 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
			 { 107 ,    51,   169 ,   74 ,  186 ,  144 ,  155 ,  181,   128 ,   66 ,  217 ,  128 ,   96 ,   62 ,   92 ,  161 ,  213 ,  114 ,   89,   122 ,  194 ,   71,   192 ,  192 ,  114,    99 ,   56 ,   79 ,   81  , 131 ,   98 ,   75    },              
			 { 107 ,    57,   168 ,   75 ,  194 ,  141 ,  154 ,  181,   133 ,   72 ,  214 ,  129 ,   99 ,   60 ,   96 ,  171 ,  216 ,  116 ,   91,   119 ,  190 ,   64,   192 ,  190 ,  108,   103 ,   60 ,   78 ,   79  , 130 ,   91 ,   77    },              
			 { 104 ,    50,   161 ,   84 ,  177 ,  136 ,  146 ,  188,   127 ,   61 ,  221 ,  124 ,   99 ,   59 ,   97 ,  150 ,  213 ,  118 ,   91,   118 ,  185 ,   62,   192 ,  198 ,  114,   113 ,   50 ,   74 ,   85  , 132 ,   99 ,   80    },              
			 { 104 ,    54,   169 ,   78 ,  187 ,  142 ,  155 ,  182,   129 ,   63 ,  215 ,  129 ,   95 ,   61 ,   95 ,  162 ,  216 ,  117 ,   91,   121 ,  193 ,   68,   196 ,  193 ,  112,   103 ,   60 ,   76 ,   79  , 132 ,   97 ,   76    },              
			 { 104 ,    53,   169 ,   77 ,  187 ,  143 ,  154 ,  181,   128 ,   63 ,  215 ,  129 ,   94 ,   62 ,   95 ,  161 ,  216 ,  116 ,   91,   123 ,  194 ,   68,   196 ,  193 ,  114,   103 ,   58 ,   78 ,   79  , 132 ,   97 ,   75    },              
			 { 105 ,    52,   168 ,   77 ,  188 ,  142 ,  156 ,  182,   128 ,   63 ,  215 ,  129 ,   94 ,   62 ,   94 ,  161 ,  216 ,  116 ,   91,   123 ,  193 ,   68,   196 ,  193 ,  114,   103 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
			 { 104 ,    53,   167 ,   78 ,  185 ,  145 ,  152 ,  183,   129 ,   65 ,  218 ,  132 ,   90 ,   63 ,   97 ,  165 ,  216 ,  107 ,   89,   126 ,  190 ,   69,   199 ,  191 ,  118,    98 ,   54 ,   75 ,   79  , 134 ,   94 ,   71    },              
			 { 104 ,    53,   169 ,   77 ,  188 ,  142 ,  155 ,  182,   129 ,   63 ,  215 ,  129 ,   94 ,   62 ,   95 ,  161 ,  216 ,  117 ,   92,   121 ,  193 ,   68,   196 ,  192 ,  114,   103 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
			 { 106 ,    53,   168 ,   76 ,  189 ,  142 ,  155 ,  181,   128 ,   62 ,  216 ,  127 ,   95 ,   63 ,   95 ,  162 ,  215 ,  114 ,   93,   123 ,  193 ,   67,   196 ,  194 ,  114,   102 ,   58 ,   78 ,   79  , 131 ,   97 ,   75    },              
			 { 105 ,    53,   168 ,   77 ,  188 ,  142 ,  155 ,  181,   128 ,   63 ,  215 ,  129 ,   95 ,   62 ,   94 ,  161 ,  216 ,  116 ,   91,   123 ,  194 ,   68,   196 ,  192 ,  114,   103 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
			 { 105 ,    54,   169 ,   77 ,  187 ,  142 ,  156 ,  182,   128 ,   64 ,  216 ,  128 ,   95 ,   61 ,   94 ,  161 ,  216 ,  117 ,   91,   123 ,  194 ,   68,   196 ,  192 ,  113,   102 ,   59 ,   79 ,   80  , 132 ,   98 ,   75    },              
			 { 105 ,    53,   168 ,   77 ,  187 ,  142 ,  155 ,  181,   128 ,   62 ,  215 ,  129 ,   95 ,   62 ,   95 ,  161 ,  215 ,  116 ,   91,   123 ,  193 ,   67,   197 ,  193 ,  114,   102 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
			 { 104 ,    53,   169 ,   77 ,  187 ,  142 ,  155 ,  182,   128 ,   63 ,  215 ,  129 ,   95 ,   63 ,   94 ,  161 ,  216 ,  116 ,   91,   123 ,  193 ,   68,   196 ,  192 ,  113,   102 ,   58 ,   78 ,   80  , 132 ,   97 ,   75    },              
			 { 101 ,    52,   171 ,   78 ,  190 ,  141 ,  153 ,  180,   130 ,   63 ,  216 ,  128 ,   93 ,   63 ,   95 ,  163 ,  217 ,  116 ,   93,   123 ,  191 ,   67,   194 ,  191 ,  114,   102 ,   57 ,   78 ,   83  , 132 ,   98 ,   73    },              
			 { 106 ,    59,   165 ,   74 ,  186 ,  143 ,  151 ,  180,   125 ,   66 ,  217 ,  131 ,   90 ,   63 ,   95 ,  162 ,  217 ,  116 ,   93,   123 ,  190 ,   68,   195 ,  193 ,  115,   102 ,   55 ,   76 ,   81  , 131 ,   98 ,   73    },              
			 { 105 ,    53,   168 ,   77 ,  187 ,  142 ,  155 ,  182,   127 ,   63 ,  215 ,  128 ,   95 ,   62 ,   94 ,  161 ,  215 ,  117 ,   92,   122 ,  194 ,   67,   196 ,  192 ,  114,   103 ,   57 ,   77 ,   80  , 132 ,   98 ,   75    }};
	
		*/
	
	 // create token1
    token1 = "";

    // for-each loop for calculating heat index of May - October

    // create Scanner inFile1
     inFile1 = new Scanner(new File("/home/alfredo/stsProjects/JavaExersices/src/testing/dataseNUmbCommaTest.txt")).useDelimiter(",\\s*");

    // Original answer used LinkedList, but probably preferable to use ArrayList in most cases
    // List<String> temps = new LinkedList<String>();
     temps = new ArrayList<String>();

    // while loop
    while (inFile1.hasNext()) {
      // find next line
      token1 = inFile1.next();
      temps.add(token1);
    }
    inFile1.close();

     tempsArray = temps.toArray(new String[0]);

    for (String s : tempsArray) {
      System.out.println(s);
    }
    
    
    
    double[][] inputTesting = new double[temps.size()][tempsArray.length];
    
    for(int s = 0; s< temps.size(); s++) {
    	for (int u =0; u < tempsArray.length; u++)
    	input[s][u] = Double.parseDouble(tempsArray[u]) ;
    	
    }
  
	
	
	
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
