package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static org.junit.Assert.assertNotEquals;


/**
 * 
 * @author Sarah Heckman
 *
 * Extended by Mike Whalen
 *
 * Unit tests for CoffeeMaker class.
 */

public class CoffeeMakerTest extends TestCase {
	
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;
	private Recipe r5;
	private CoffeeMaker cm;
	private RecipeBook recipeBookStub;
	private Recipe [] stubRecipies; 
	
	protected void setUp() throws Exception {
		
		cm = new CoffeeMaker();
		
		//Set up for r1
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setAmtChocolate("0");
		r1.setAmtCoffee("3");
		r1.setAmtMilk("1");
		r1.setAmtSugar("1");
		r1.setPrice("50");
		
		//Set up for r2
		r2 = new Recipe();
		r2.setName("Mocha");
		r2.setAmtChocolate("20");
		r2.setAmtCoffee("3");
		r2.setAmtMilk("1");
		r2.setAmtSugar("1");
		r2.setPrice("75");
		
		//Set up for r3
		r3 = new Recipe();
		r3.setName("Latte");
		r3.setAmtChocolate("0");
		r3.setAmtCoffee("3");
		r3.setAmtMilk("3");
		r3.setAmtSugar("1");
		r3.setPrice("100");
		
		//Set up for r4
		r4 = new Recipe();
		r4.setName("Hot Chocolate");
		r4.setAmtChocolate("4");
		r4.setAmtCoffee("0");
		r4.setAmtMilk("1");
		r4.setAmtSugar("1");
		r4.setPrice("65");
		
		//Set up for r5 (added by MWW)
		r5 = new Recipe();
		r5.setName("Super Hot Chocolate");
		r5.setAmtChocolate("6");
		r5.setAmtCoffee("0");
		r5.setAmtMilk("1");
		r5.setAmtSugar("1");
		r5.setPrice("100");

		stubRecipies = new Recipe [] {r1, r2, r3};
		
		super.setUp();
	}
	
	
	// put your tests here!

	@Test
	public void testAddInventory() throws InventoryException {
		cm.addInventory("4", "7", "0", "9");
	}

	@Test
	public void testMakeCoffee(){
		cm.addRecipe(r1);
		assertEquals(25, cm.makeCoffee(0, 75));
	}

	@Test
	public void testMakeFakeCoffee(){
		String startInventory =	cm.checkInventory();
		cm.addRecipe(r1);
		cm.makeCoffee(1, 50);
		assertEquals(startInventory, cm.checkInventory());
	}

	@Test
	public void testMakeCoffeeButProblemsWithIngredients() throws InventoryException, RecipeException {
		Recipe recipeExtremeCheap = r1;
		recipeExtremeCheap.setAmtCoffee("1000000");
		recipeExtremeCheap.setPrice("2");
		recipeExtremeCheap.setAmtMilk("1000000");
		recipeExtremeCheap.setAmtChocolate("1000000");
		recipeExtremeCheap.setAmtSugar("100000");

		cm.addRecipe(recipeExtremeCheap);

		assertEquals(700, cm.makeCoffee(0, 700));
	}

	@Test
	public void testMakeCoffeeButNotEnoughMoney() throws InventoryException, RecipeException {
		cm.addRecipe(r1);
		assertEquals(7, cm.makeCoffee(0, 7));
	}

	@Test
	public void testAddRecipe1(){
		cm.addRecipe(r1);
		String recipeName = r1.getName();
		assertTrue(Arrays.stream(cm.getRecipes()).filter(Objects::nonNull).anyMatch(recipe -> recipe.getName().equals(recipeName)));
	}

	@Test
	public void testDeleteRecipe1(){
		try{
			cm.deleteRecipe(5);
		}
		catch(ArrayIndexOutOfBoundsException ex){
			assertTrue(true);
		}

	}

	@Test public void testDeleteRealRecipe(){
		cm.addRecipe(r1);
		String recipeName = r1.getName();
		cm.addRecipe(r2);
		cm.deleteRecipe(0);
		assertFalse(Arrays.stream(cm.getRecipes()).filter(Objects::nonNull).anyMatch(recipe -> recipe.getName().equals(recipeName)));
		assertTrue(Arrays.stream(cm.getRecipes()).filter(Objects::nonNull).anyMatch(recipe -> recipe.getName().equals(r2.getName())));
	}

	@Test
	public void testAddInventoryException() throws InventoryException {
		try{
			cm.addInventory("4", "-1", "asdf", "3");
		}
		catch(InventoryException ex){
			assertTrue(true);
		}
	}

	@Test
	public void testEditRecipe1(){
		cm.addRecipe(r1);
		try{
			cm.editRecipe(5, r1);
		}
		catch (ArrayIndexOutOfBoundsException ex){
			assertTrue(true);
		}
	}

	@Test
	public void testEditRealRecipe() throws RecipeException {
		cm.addRecipe(r1);
		Recipe recipe = r1;
		recipe.setAmtChocolate("40");
		cm.editRecipe(0, recipe);
		assertEquals(cm.getRecipes()[0].getAmtChocolate(), recipe.getAmtChocolate());
	}

	@Test
	public void testAddInventory1() throws InventoryException {
		try{
			cm.addInventory("4", "4", "-3", "2");
		}
		catch (InventoryException ex){
			assertTrue(true);
		}
	}

	@Test
	public void testPurchaseBeverage1() throws InventoryException {
		cm.addRecipe(r1);
		StringBuffer buf = new StringBuffer();
		buf.append("Coffee: ");
		buf.append("12");
		buf.append("\n");
		buf.append("Milk: ");
		buf.append("14");
		buf.append("\n");
		buf.append("Sugar: ");
		buf.append("14");
		buf.append("\n");
		buf.append("Chocolate: ");
		buf.append("15");
		buf.append("\n");
		String res = buf.toString();
		cm.makeCoffee(0, 50);
		assertNotSame(res, cm.checkInventory());
	}

	@Test
	public void testRecipeOperations() throws RecipeException {
		RecipeBook r = new RecipeBook();
		r.addRecipe(r1);
		r.addRecipe(r1);
		Recipe r1E = r1;
		r1E.setAmtChocolate("555");

		r.editRecipe(0,r1E);
		assertEquals(r1E, r.getRecipes()[0]);

		r.deleteRecipe(0);
		assertNotSame(r1E ,r.getRecipes()[0]);

		r.deleteRecipe(1);
		assertEquals(null ,r.getRecipes()[1]);

		r.editRecipe(1, r1E);
		assertEquals(null ,r.getRecipes()[1]);
	}

	@Test
	public void testIlegalValuesCoffee() throws InventoryException {
		Inventory inventory = new Inventory();
		try{
			inventory.addCoffee("-1");
		}
		catch (InventoryException ex){
			assertTrue(true);
		}
		try{
			inventory.addCoffee("asddd");
		}
		catch(InventoryException ex){
			assertTrue(true);
		}

		Recipe recipe = new Recipe();

		try{
			recipe.setAmtCoffee("-1");
		}
		catch (RecipeException ex){
			assertTrue(true);
		}
		try{
			recipe.setAmtCoffee("asddd");
		}
		catch(RecipeException ex){
			assertTrue(true);
		}


	}

	@Test
	public void testIlegalValuesMilk() throws InventoryException {
		Inventory inventory = new Inventory();
		try{
			inventory.addMilk("-1");
		}
		catch (InventoryException ex){
			assertTrue(true);
		}
		try{
			inventory.addMilk("asddd");
		}
		catch(InventoryException ex){
			assertTrue(true);
		}

		Recipe recipe = new Recipe();

		try{
			recipe.setAmtMilk("-1");
		}
		catch (RecipeException ex){
			assertTrue(true);
		}
		try{
			recipe.setAmtMilk("asddd");
		}
		catch(RecipeException ex){
			assertTrue(true);
		}
	}

	@Test
	public void testIlegalValuesChocolate() throws InventoryException {
		Inventory inventory = new Inventory();
		try{
			inventory.addChocolate("-1");
		}
		catch (InventoryException ex){
			assertTrue(true);
		}
		try{
			inventory.addChocolate("asddd");
		}
		catch(InventoryException ex){
			assertTrue(true);
		}

		Recipe recipe = new Recipe();

		try{
			recipe.setAmtChocolate("-1");
		}
		catch (RecipeException ex){
			assertTrue(true);
		}
		try{
			recipe.setAmtChocolate("asddd");
		}
		catch(RecipeException ex){
			assertTrue(true);
		}
	}

	@Test
	public void testIlegalValuesSugar() throws InventoryException {
		Inventory inventory = new Inventory();
		try{
			inventory.addSugar("1");
		}
		catch (InventoryException ex){
			assertTrue(true);
		}
		try{
			inventory.addSugar("asddd");
		}
		catch(InventoryException ex){
			assertTrue(true);
		}

		Recipe recipe = new Recipe();

		try{
			recipe.setAmtSugar("-1");
		}
		catch (RecipeException ex){
			assertTrue(true);
		}
		try{
			recipe.setAmtSugar("asddd");
		}
		catch(RecipeException ex){
			assertTrue(true);
		}


	}

	@Test
	public void testIlegalValuesPrice() throws InventoryException {

		Recipe recipe = new Recipe();

		try{
			recipe.setPrice("-1");
		}
		catch (RecipeException ex){
			assertTrue(true);
		}
		try{
			recipe.setPrice("asddd");
		}
		catch(RecipeException ex){
			assertTrue(true);
		}

	}

	@Test
	public void testEqualMethod() throws RecipeException {
		Recipe recipe1 = new Recipe();
		recipe1.setPrice("50000");
		Recipe recipe2 = new Recipe();
		Recipe recipe3 = new Recipe();
		recipe3.setName(null);

		assertEquals(recipe1.toString(), recipe2.toString());

		assertTrue(recipe2.equals(recipe2));

		assertEquals(recipe2, recipe1);

		recipe2.setName("unveli");

		assertNotEquals(recipe1, recipe2);

		assertNotEquals(recipe1.hashCode(), recipe2.hashCode());

		assertNotEquals(recipe2, new ArrayList<Integer>());

		recipe1.setName("helloja");
		assertFalse(recipe3.equals(recipe1));
	}




}
