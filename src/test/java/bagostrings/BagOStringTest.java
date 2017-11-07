package bagostrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class BagOStringTest {

	@Test
	public void test1() {
		BagOString boss = new BagOString();
		boss.add("frodo");
		assertTrue(boss.contains("frodo"));
		assertEquals(7, boss.weight());
	}

	@Test
	public void test2() {
		BagOString boss = new BagOString(new String[] { "frodo", "bilbo" });
		assertTrue(boss.contains("bilbo"));
		assertEquals(18, boss.weight());
	}

	@Test
	public void test3() {
		BagOString boss1 = new BagOString(new String[] { "for", "do" });
		BagOString boss2 = new BagOString(new String[] { "frodo" });
		assertTrue(boss1.equals(boss2));
	}

	@Test
	public void test4() {
		BagOString boss = new BagOString(new String[] { "frodo", "bilbo" });
		assertTrue(!boss.contains("sauron"));
	}

	@Test
	public void test5() {
		BagOString boss = new BagOString(new String[] { "potter" });
		boss.add("granger");
		boss.add("weasley");
		assertTrue(boss.contains("potter"));
		boss.remove("potter");
		assertTrue(!boss.contains("potter"));
	}

	@Test
	public void test6() {
		BagOString boss = new BagOString(new String[] { "potter" });
		boss.add("potter");
		assertEquals(2, boss.getCount("potter"));
	}

	@Test
	public void test7() {
		BagOString boss = new BagOString(new String[] { "potter" });
		boss.add("potter");
		boss.add("voldemort");
		assertEquals(5, boss.getCount('t'));
	}
}
