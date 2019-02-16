import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.Writer;

/**
	HashValuesGenerator is a class that prints onto a text file the hash values of every name in an electronic phone directory

	@author Tumelo Lephadi
	@version 1 May 2017
*/
public class HashValuesGenerator
{
	HashTable hashTable = new HashTable();
	/**
		Writes onto a text file the Hash values generated from the names in the electronic phone directory.
	*/
	public void writeToHashValues()
	{
		hashTable.setHash();
		try
		{
			FileOutputStream fileOutputStream = new FileOutputStream("HashValues");
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
			Writer writer = new BufferedWriter(outputStreamWriter);
			for(int hashValue: hashTable.intArray)
			{
				writer.write(hashValue + "\n");
			}
			writer.close();
		}
		catch(IOException ioe)
		{
			System.out.println(ioe);
		}
  	}
  	/**
  		main method that drives the entire program
  		@param args args in the main method
  	*/
	public static void main(String[] args)
	{
		HashValuesGenerator hashValuesGenerator = new HashValuesGenerator();
		hashValuesGenerator.writeToHashValues();
	}
}