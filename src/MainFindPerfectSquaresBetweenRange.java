
public class MainFindPerfectSquaresBetweenRange {
	
	static Integer start = 2;
	static Integer end = 27; 
	
	public static void main(String[] args) {
		double startSquare = Math.sqrt(start);
		double endSquare = Math.sqrt(end);
		System.out.println("Start Square:" + startSquare);
		System.out.println("End Square:" + endSquare);
		
		//ceil of start and floor of end
		double startSquareCeil = Math.ceil(startSquare);
		double endSquareFloor = Math.floor(endSquare);
		System.out.println("Start Square Ceil:" + startSquareCeil);
		System.out.println("End Square Floor:" + endSquareFloor);
		//2, 3, 4 and 5 are actually 4, 9, 16, 25
		
		System.out.println("Number of Perfect Squares between " + start + " and " + end + " is: " 
			+ (endSquareFloor - startSquareCeil + 1));
	}
}
