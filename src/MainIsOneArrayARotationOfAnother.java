
public class MainIsOneArrayARotationOfAnother {
	public static void main(String[] args) {
		int a[] = { 0, 1, 2, 3, 4 };
		int b[] = { 3, 4, 0, 1, 2 };
		boolean result = isRotation(a, b);
		System.out.println(result);
	}

	public static boolean isRotation(int[] a, int[] b) {
		// arrays with different sizes can't be rotation of each other
		if (a.length != b.length) 
			return false;
		
		int offset = -1;
		// find how many offset positions   
		for (int i = 0; i < b.length; i++) {
			if (a[0] == b[i]) {
				offset = i;
				break;
			}
		}
		if (offset == -1)
			return false;
		
		// loop array a with b+offset and check if they're equal
		for (int i = 0; i < a.length; i++) {
			int indexB = (i + offset) % b.length;
			if (a[i] != b[indexB]) {
				return false;
			}
		}
		return true;
	}

}
