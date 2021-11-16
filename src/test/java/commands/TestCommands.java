package commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import environment.Environment;
import exceptions.AttachmentException;
import exceptions.EnvironmentException;
import exceptions.WeaponException;
import gameUI.GameUI;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.MockGenericWeapon;
import weapon.Pistol;
import weapon.PowerBooster;

public class TestCommands {

	@Test
	public void testAttackWest() throws WeaponException, EnvironmentException, AttachmentException {
		Environment environment = Environment.getEnvironment(10, 10);
		LifeForm lf = new MockLifeForm("Bob", 20);
		LifeForm lf2 = new MockLifeForm("John", 40);
		LifeForm lf3 = new MockLifeForm("bobby", 40);
		environment.addLifeForm(lf, 1, 2);
		environment.addLifeForm(lf2, 1, 3);
		environment.addLifeForm(lf3, 1, 4);
		Pistol gun = new Pistol();
		lf.pickUpWeapon(gun);
		environment.addWeapon(gun, 1, 2);
		lf.setDirection(1);
		environment.changeSelectedCell(1, 2);
		AttackCommand a = new AttackCommand(environment);
		a.execute();
		assertEquals(29, lf2.getCurrentLifePoints());
		assertEquals(40, lf3.getCurrentLifePoints());
	}

	@Test
	public void testAttackNorth() throws WeaponException, EnvironmentException, AttachmentException {
		Environment environment = Environment.getEnvironment(10, 10);
		LifeForm lf = new MockLifeForm("Bob", 20);
		LifeForm lf2 = new MockLifeForm("John", 40);
		LifeForm lf3 = new MockLifeForm("bobby", 40);
		environment.addLifeForm(lf, 4, 2);
		environment.addLifeForm(lf2, 3, 2);
		environment.addLifeForm(lf3, 1, 4);
		Pistol gun = new Pistol();
		lf.pickUpWeapon(gun);
		environment.addWeapon(gun, 4, 2);
		lf.setDirection(0);
		environment.changeSelectedCell(4, 2);
		AttackCommand a = new AttackCommand(environment);
		a.execute();
		assertEquals(29, lf2.getCurrentLifePoints());
		assertEquals(40, lf3.getCurrentLifePoints());
	}

	@Test
	public void testAttackSouth() throws WeaponException, EnvironmentException, AttachmentException {
		Environment environment = Environment.getEnvironment(10, 10);
		LifeForm lf = new MockLifeForm("Bob", 20);
		LifeForm lf2 = new MockLifeForm("John", 40);
		LifeForm lf3 = new MockLifeForm("bobby", 40);
		environment.addLifeForm(lf, 1, 7);
		environment.addLifeForm(lf2, 4, 7);
		environment.addLifeForm(lf3, 1, 4);
		Pistol gun = new Pistol();
		lf.pickUpWeapon(gun);
		environment.addWeapon(gun, 1, 7);
		lf.setDirection(2);
		environment.changeSelectedCell(1, 7);
		AttackCommand a = new AttackCommand(environment);
		a.execute();
		assertEquals(31, lf2.getCurrentLifePoints());
		assertEquals(40, lf3.getCurrentLifePoints());

		// good
	}

	@Test
	public void testAttackEast() throws WeaponException, EnvironmentException, AttachmentException {
		Environment environment = Environment.getEnvironment(10, 10);
		LifeForm lf = new MockLifeForm("Bob", 20);
		LifeForm lf2 = new MockLifeForm("John", 40);
		LifeForm lf3 = new MockLifeForm("bobby", 40);
		environment.addLifeForm(lf, 6, 2);
		environment.addLifeForm(lf2, 6, 4);
		environment.addLifeForm(lf3, 1, 4);
		Pistol gun = new Pistol();
		lf.pickUpWeapon(gun);
		environment.addWeapon(gun, 6, 2);
		lf.setDirection(1);
		environment.changeSelectedCell(6, 2);
		AttackCommand a = new AttackCommand(environment);
		a.execute();
		assertEquals(30, lf2.getCurrentLifePoints());
		assertEquals(40, lf3.getCurrentLifePoints());

		// good
	}

	@Test
	public void testReload() throws WeaponException, EnvironmentException {
		Environment environment = Environment.getEnvironment(10, 10);
		LifeForm lf = new MockLifeForm("Bob", 20);
		LifeForm lf2 = new MockLifeForm("John", 40);
		LifeForm lf3 = new MockLifeForm("bobby", 40);
		environment.addLifeForm(lf, 6, 2);
		environment.addLifeForm(lf2, 6, 4);
		environment.addLifeForm(lf3, 1, 4);
		Pistol gun = new Pistol();
		lf.pickUpWeapon(gun);
		environment.addWeapon(gun, 6, 2);
		lf.setDirection(1);
		environment.changeSelectedCell(6, 2);
		AttackCommand a = new AttackCommand(environment);
		a.execute();
		assertEquals(8, environment.getCell(6, 2).getWeapon1().getCurrentAmmo());
		ReloadCommand r = new ReloadCommand(environment);
		r.execute();
		assertEquals(10, environment.getCell(6, 2).getWeapon1().getCurrentAmmo());
	}

	@Test
	public void testNorthDir() {
		Environment environment = Environment.getEnvironment(10, 10);
		LifeForm lf4 = new MockLifeForm("Bob", 20);
		environment.addLifeForm(lf4, 1, 1);
		lf4.setDirection(0);
		assertEquals(0, lf4.getDirection());
	}
	
	@Test
	public void testSouthDir() {
		Environment environment = Environment.getEnvironment(10, 10);
		LifeForm lf4 = new MockLifeForm("Bob", 20);
		environment.addLifeForm(lf4, 1, 1);
		lf4.setDirection(2);
		assertEquals(2, lf4.getDirection());
	}
	
	@Test
	public void testEastDir() {
		Environment environment = Environment.getEnvironment(10, 10);
		LifeForm lf4 = new MockLifeForm("Bob", 20);
		environment.addLifeForm(lf4, 1, 1);
		lf4.setDirection(1);
		assertEquals(1, lf4.getDirection());
	}
	
	@Test
	public void testWestDir() {
		Environment environment = Environment.getEnvironment(10, 10);
		LifeForm lf4 = new MockLifeForm("Bob", 20);
		environment.addLifeForm(lf4, 1, 1);
		lf4.setDirection(3);
		assertEquals(3, lf4.getDirection());
	}
	
//	@Test
//	public void testDropWithSpace() {
//		Environment environment = Environment.getEnvironment(10, 10);
//		LifeForm lf4 = new MockLifeForm("Bob", 20);
//		environment.addLifeForm(lf4, 1, 1);
//		Pistol gun = new Pistol();
//		lf4.pickUpWeapon(gun);
//		assertEquals(true, lf4.hasWeapon());
//		DropCommand d = new DropCommand(environment);
//		d.execute();
//		assertEquals(false, lf4.hasWeapon());
//	}

}
