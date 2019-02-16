import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

/**
	HashTable is a class that stores hashValues in a hash map using four different hash functions

	@author Tumelo Lephadi
	@version 1 May 2017
*/
public class HashTable
{
	ArrayList<Integer> intArray; 
	Scanner scanner, scanner1;
	String fullName;
	int tableSize;
	int position;


	public HashTable()
	{
		intArray = new ArrayList<Integer>();
		scanner1 = new Scanner(System.in);
		scanner = null;
		fullName = "";
		tableSize = 20011;
		position = 0;
	}

	/**
		hash1 uses one hashValue for all keys.
		@param key key to determine hash value of 
		@return the hash value.
	*/
	public int hash1(String key)
	{
		return 1;
	}

	/**
		hash2 uses unicode values to store items in hash table. 
		@param key the String to hash.
		@return the hash value.
	*/
	public int hash2 (String key)
	{
		int hashVal = 0;
		for( int i = 0; i < key.length(); i++ )
			hashVal += key.charAt(i);
		return hashVal % tableSize;
	}

	/**
		hash3 uses shifted unicode values to store items in hash table. 
		@param key the String to hash.
		@return the hash value.
	*/
	public int hash3 (String key)
	{
		int hashVal = 0;
		for( int i = 0; i < key.length(); i++ )
			hashVal = (37 * hashVal) + key.charAt(i);
		hashVal = hashVal % tableSize;
		if( hashVal < 0 )
			hashVal += tableSize;
		return hashVal;
	}

	/**
		hash4 uses shifted unicode values to store items but with a larger scaling value (128).
		@param key the String to hash.
		@return the hash value.
	*/
	public int hash4(String key)
	{
		int hashVal = 0;
		for( int i = 0; i < key.length( ); i++ )
			hashVal = ( hashVal * 128 + key.charAt( i ) ) % tableSize;
		return hashVal;
	}

	/**
		open phone directory is a method that opens the yellowpages
	*/
	public void openPhoneDirectory()
	{
		try
		{
			scanner = new Scanner(new FileInputStream("yellowpages"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
	}

	/**
		insert is a method which puts values into an array
		@param hashVal is the number returned by a hash function
	*/
	public void insert(int hashVal)
	{
		intArray.add(hashVal);
	}

	public String setFullName(String value)
	{
		return value.substring(value.lastIndexOf("|") + 1);
	}

	/**
		set hash function allows the user to use the hash function that they wish to implement in the hash table
	*/
	public void setHash()
	{
		System.out.println("Select the hash function that you want to implement:");
		System.out.println("1. The worst case hash function:");
		System.out.println("2. The hash function that uses unicode values to store items in hash table:");
		System.out.println("3. The hash function that uses shifted unicode values to store items in hash table:");
		System.out.println("4. The hash function that uses shifted unicode values to store items but with a larger scaling value (128):");

		int hashFunction = scanner1.nextInt();

		openPhoneDirectory();
				
		switch(hashFunction)
		{
			case 1:
					while(scanner.hasNext())
					{
						insert(hash1(setFullName(scanner.nextLine())));
						position++;
					}
					break;
			case 2:
					while(scanner.hasNext())
					{
						insert(hash2(setFullName(scanner.nextLine())));
						position++;
					}
					break;
			case 3:
					while(scanner.hasNext())
					{
						insert(hash3(setFullName(scanner.nextLine())));
						position++;
					}
					break;
			case 4:
					while(scanner.hasNext())
					{
						insert(hash4(setFullName(scanner.nextLine())));
						position++;
					}
					break;
			default:
					System.out.println("Hash function not found.");
					break;
		}
	}
/**
 write prints out all the hash values in the array
*/
	public void write()
	{
		for(int hashValue: intArray)
			System.out.println(hashValue);
	}
}