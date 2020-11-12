package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.descriptor.FileSystemSource;

import Hw2.PrimeNumber;
import Hw2.extendFile;

class Hw2Test {

	@Test
	void testFindingPrimes() {
		int[] arr = PrimeNumber.isPrime(10);
		assertEquals(10, arr.length);
		boolean check = true;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] <= 1) {
				check = false;
				break;
				
			} else {
				for(int j = 2; j <= arr[i] / 2; j++) {
					if((arr[i] % i) == 0) {
						check = false;
						break;
					}
				}
			}
		} assertEquals(true, check);
	
	int[] checkArr = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
	assertArrayEquals(checkArr, arr);	
}

@Test
void testCreateFile() {
	File file = extendFile.createFile("test");
	assertEquals(true, file.exists());
	
	String path = "test.txt";
	assertEquals(path, file.getPath());
	
	String name = "test.txt";
	assertEquals(name, file.getName());
	
	File nameNumbers = extendFile.createFile("132465");
	File nameSigns = extendFile.createFile("!?=");
	
	assertEquals(true, nameNumbers.exists());
	assertEquals(false, nameSigns.exists());
	        
}
@Test
void testWrite() {
	File writeInto = extendFile.createFile("writeInto");
	
	int[] checkArr = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
	String checkString = "2 3 5 7 11 13 17 19 23 29 ";
	extendFile.writeInFile(writeInto, checkArr);
	
	try {
		assertEquals (checkString, Files.readString(Paths.get(writeInto.getPath())));
	}catch(IOException e) {
		e.printStackTrace();
	}
}
}
