package Hw2;

import java.util.Scanner;

/**
 * 
 * Gibt die von dem benutzer angegebene Ahnzahl an Primzahlen in txt datei aus  
*/

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Insert an integer");
		
		Scanner _scanner = new Scanner(System.in);
		int _numbers = _scanner.nextInt(); 
		int[] _primeNumbers = PrimeNumber.isPrime(_numbers); 
		

		System.out.println("Do you want to set a filename? Please press y for yes and n for no. ");
		
		String _input = _scanner.next(); 
		String _fileName = "Primenumbers"; 
		switch(_input) {
			case "y": 
				System.out.println("Insert a filename");
				_fileName = _scanner.next(); 
				extendFile.makeFile(_primeNumbers, _fileName);
				break; 
		
			case "n":
				extendFile.makeFile(_primeNumbers, _fileName);
				break; 
				
			default:
				break; 
		}

		_scanner.close();
	}
}
