import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Activity1 {

static ArrayList<String> list;

	@BeforeAll
	static void setUp () throws Exception{
	list = new ArrayList<String>();
	list.add("alpha");
	list.add("beta");
	}
	
	@Test
	public void ainsertTest() {
		assertEquals(2, list.size(), "Wrong size");
		list.add(2, "gamma");
		assertEquals(3, list.size(), "Wrong size");
		//checking each value:
		assertEquals("alpha", list.get(0), "Wrong element");
		assertEquals("beta", list.get(1), "Wrong element");
		assertEquals("gamma", list.get(2), "Wrong element");
	}
	
	@Test
	public void replaceTest() {
		list.set(1, "delta");
		assertEquals("alpha", list.get(0), "Wrong element");
		assertEquals("delta", list.get(1), "Wrong element");
		assertEquals("gamma", list.get(2), "Wrong element");
	}

}
