// This is a Java Implementation of Unbounded Knapsack problem (Repetition of objects is not allowed).
public class UnboundedKnapsack {
	
	public static int CalculateKnapsack(int[] weight, int[] price, int knapsack){
		int[] arr_price = new int[knapsack+1];
		int len = weight.length;
		for(int i=0; i<len; i++){
			for(int j = 1; j<knapsack+1; j++){
				if(weight[i]<=j){
					arr_price[j] = Math.max(arr_price[j], arr_price[j-weight[i]]+price[i]);
				}
			}
		}
		return arr_price[knapsack];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] weight = {1, 3, 4, 5};
		int[] price = {10, 40, 50, 70};
		int knapsack = 8;
		System.out.println(CalculateKnapsack(weight, price, knapsack));
	}

}
