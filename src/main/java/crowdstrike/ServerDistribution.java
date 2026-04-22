package crowdstrike;

import java.util.Arrays;

public class ServerDistribution {

    public static int[] distribute(int nodes, int servers){
        if(nodes <= 0)
            throw new IllegalArgumentException("No of Nodes must be greater than 0");
        if(servers < 0)
            throw new IllegalArgumentException("No of Servers must be greater or equalto zero");

        int[] distributions = new int[nodes];
        int base = servers / nodes; //every nodes gets these number
        int remainder = servers / nodes; // this many nodes get an extra

        for(int i=0; i<nodes; i++){
            distributions[i] = ( i < remainder) ? base+1 : base;
        }
        return distributions;

    }

    public static void main(String[] args) {
        // Example 1: n=10, m=3  → [4, 3, 3]
        System.out.println(Arrays.toString(distribute(10, 3)));

        // Example 2: n=7,  m=7  → [1, 1, 1, 1, 1, 1, 1]
        System.out.println(Arrays.toString(distribute(7, 7)));

        // Example 3: n=5,  m=8  → [1, 1, 1, 1, 1, 0, 0, 0]
        System.out.println(Arrays.toString(distribute(5, 8)));

        // Example 4: n=0,  m=3  → [0, 0, 0]
        System.out.println(Arrays.toString(distribute(0, 3)));
    }
}
