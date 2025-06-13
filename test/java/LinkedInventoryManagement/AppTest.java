/*
 * Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import LinkedInventoryManagement.Common.*;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test

    public void GetFirstTest()
    {
    	String[] elementTest =  {"First","Second","Third"};
    	InventoryLinkedList<String> list = new InventoryLinkedList<String>(elementTest);
    	String expectedResult = "First";
    	if(!list.GetFirst().equals(expectedResult))
    	{
    		assertTrue("The expected value does not match the actual value", false);
    	}
    	assertTrue(true);
    }

    public void GetLastTest()
    {
    	String[] elementTest =  {"First","Second","Third"};
    	InventoryLinkedList<String> list = new InventoryLinkedList<String>(elementTest);
    	String expectedResult = "Third";
    	if(!list.GetLast().equals(expectedResult))
    	{
    		assertTrue("The expected value does not match the actual value", false);
    	}
    }
       
    public void InsertTest()
    {
    	String[] elementTest =  {"First","Third","Fourth"};
    	InventoryLinkedList<String> list = new InventoryLinkedList<String>(elementTest);
    	list.Insert(1, "Second");
    	String expectedResult = "Second";
    	if(!list.GetElement(1).equals(expectedResult))
    	{
    		assertTrue("The expected value does not match the actual value", false);
    	}
    }
    public void RemoveTest()
    {
    	String[] elementTest =  {"First","Third","Fourth"};
    	InventoryLinkedList<String> list = new InventoryLinkedList<String>(elementTest);
    	list.Remove(1);
    	String expectedResult = "Third";
    	if(!list.GetElement(1).equals(expectedResult))
    	{
    		assertTrue("The expected value does not match the actual value", false);
    	}
    }
    public void toStringTest()
    {
    	String[] elementTest =  {"First","Second","Third"};
    	InventoryLinkedList<String> list = new InventoryLinkedList<String>(elementTest);
    	String expectedResult = "[First, Second, Third]";
    	if(!list.toString().equals(expectedResult))
    	{
    		assertTrue("The expected value does not match the actual value", false);
    	}
    }
    public void ContainsTest()
    {
    	String[] elementTest =  {"First","Second","Third"};
    	InventoryLinkedList<String> list = new InventoryLinkedList<String>(elementTest);
    	boolean expectedResult = true;
    	if(list.Contains("Second") != (expectedResult))
    	{
    		assertTrue("The expected value does not match the actual value", false);
    	}
    }

    public void SetElementTest()
    {
    	String[] elementTest =  {"First","Second","Third"};
    	InventoryLinkedList<String> list = new InventoryLinkedList<String>(elementTest);
    	list.SetElement(2, "Fourth");
    	String expectedResult = "Fourth";
    	if(!list.GetElement(2).equals(expectedResult))
    	{
    		assertTrue("The expected value does not match the actual value", false);
    	}
    }
    public void GetElementTest()
    {
    	String[] elementTest =  {"First","Second","Third"};
    	InventoryLinkedList<String> list = new InventoryLinkedList<String>(elementTest);
    	String expectedResult = "Second";
    	if(!list.GetElement(1).equals(expectedResult))
    	{
    		assertTrue("The expected value does not match the actual value", false);
    	}
    }

    public void GetLengthTest()
    {
    	String[] elementTest =  {"First","Second","Third"};
    	InventoryLinkedList<String> list = new InventoryLinkedList<String>(elementTest);
    	int expectedResult = 3;
    	if(list.GetLength() != expectedResult)
    	{
    		assertTrue("The expected value does not match the actual value", false);
    	}
    }
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
