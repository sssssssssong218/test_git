package job;

import java.util.Arrays;
import java.util.Random;

public class exRandom {

	public exRandom() {
		 
	}//exRandom
	
	public int[] lotto() {    
		int[] lotto=new int[6];
		Random random=new Random();
		
		for(int i =0;i<lotto.length;i++) { 
			for(int j=0;j<i;j++) {
				if(lotto[j]==lotto[i]) {
					i--;
					break;
				}//end if
			}//end for
		}//end for
		
		return lotto;
		
	}
	
	public void printLotto() {
		int[]lotto=lotto();
		Arrays.sort(lotto);
		for(int num :lotto) {
			System.out.print(num + " ");
		} 
	}
	
	public static void main(String[] args) {
		exRandom ran=new exRandom();
		ran.printLotto();
	}

}
