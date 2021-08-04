package it.giacomo.javarefresh8;

public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        int[] indices = new int[2];
        indices[0] = -1;
        indices[1] = -1;
    	int i,j;
    	int found = 0;
        for(i=0; i<list.length; i++) {
        	for(j=i; j<list.length-1; j++) {
        		if( (list[i] + list[++j]) == sum) {
        			indices[0] = i;
        			indices[1] = j;
        			found = 1;
        			break;
        		}        		
        	}
        	if (found == 1) break;
        }
     if (indices[0] == -1 || indices[1] == -1) {
    	 return null;
     }
     return indices;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}