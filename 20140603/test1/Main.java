package test1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double n = 900000;
		double n1 = n;
		double n2 = 25000;
		int k = 0;
		for(int i = 1; n1 >= n2; i++){
			n1 = n1 / 1.15;
			k = i;
		}

		System.out.println(k);
		System.out.println(n1);
	}

}
