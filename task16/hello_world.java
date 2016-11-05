public class Main {
	
	public static float abs(float a) {
		if (a<0){
		return -a;
		}
		else{
			return a;
		}
	}

	public static float sqrt(float a) {
		return B_sqrt(a, a);
		}
	
	public static float B_sqrt(float a, float p) {
		if (abs(a-p*p)>0.00000000001) {
		return B_sqrt(a,(p+a/p)/2);
		}
		else {
		return p;
		}
		}

	public static float geron(float a, float b, float c) {
		float p = (a+b+c)/2;
		return sqrt((p*(p-a)*(p-b)*(p-c)));
		}
		
	public static void main(String[] args) {
		System.out.println(geron(3,4,5));
	}
}
