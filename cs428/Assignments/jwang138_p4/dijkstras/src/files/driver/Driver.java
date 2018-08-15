package files.driver;

import files.algorithm.Dijkstra;

public class Driver {
	public static void main (String[] args) {
		Dijkstra alg1 = new Dijkstra(6);
        Dijkstra alg2 = new Dijkstra(7);    
                                                            //   u v w x y z
        int graphA[][] = new int[][]{{0, 2, 5, 1, 0, 0},    // u - 2 5 1 - -
                                    {2, 0, 3, 2, 0, 0},     // v 2 - 3 2 - -
                                    {5, 3, 0, 3, 1, 5},     // w 5 3 - 3 1 5
                                    {1, 2, 3, 0, 1, 0},     // x 1 2 3 - 1 -
                                    {0, 0, 1, 1, 0, 2},     // y - - 1 1 - 2
                                    {0, 0, 5, 0, 2, 0}      // z - - 5 - 2 - 
                                    };

        int src = 0; // Source node
        alg1.process(graphA, src);

                                    							//   t u v w x y z
		int graphB[][] = new int[][]{{0, 2, 4, 0, 0, 7, 0},		// t - 2 4 - - 7 -
                                    {2, 0, 3, 3, 0, 0, 0},		// u 2 - 3 3 - - -
                                    {4, 3, 0, 4, 3, 8, 0},		// v 4 3 - 4 3 8 -
                                    {0, 3, 4, 0, 6, 0, 0},		// w - 3 4 - 6 - -
                                    {0, 0, 3, 6, 0, 6, 8},		// x - - 3 6 - 6 8
                                    {7, 0, 8, 0, 6, 0, 12},		// y 7 - 8 - 6 - 12
                                    {0, 0, 0, 0, 8, 12, 0}		// z - - - - 8 12 -
                                   };
        
		alg2.process(graphB, src);

                                                            //   u v w x y z
        int graphC[][] = new int[][]{{0, 2, 7, 9, 0, 0},    // u - 2 7 9 - -
                                    {2, 0, 5, 1, 0, 0},     // v 2 - 5 1 - - 
                                    {7, 5, 0, 4, 7, 5},     // w 7 5 - 4 7 5
                                    {9, 1, 4, 0, 8, 0},     // x 9 1 4 - 8 -
                                    {0, 0, 7, 8, 0, 1},     // y - - 7 8 - 1
                                    {0, 0, 5, 0, 1, 0}      // z - - 5 - 1 -                                         
                                    };

        alg1.process(graphC, src);                 
	}
}