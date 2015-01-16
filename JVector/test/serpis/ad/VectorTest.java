package serpis.ad;

import static org.junit.Assert.*;

import org.junit.Test;

public class VectorTest 
{
	@Test
	public void testMin() 
	{
//		int[]vector = new int[] {33,16,12,15,19};
//		int minValue = Vector.min(vector);
//		assertEquals(12,minValue);
		//comprobamos la mitad
		assertEquals(12,Vector.min(new int[] {33,16,12,15,19}));
		//comprobamos el principio
		assertEquals(7,Vector.min(new int[] {7,16,12,15,19}));
		//comprobamos el final
		assertEquals(11,Vector.min(new int[] {33,16,12,15,11}));
	}
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testMinEmpty()
	{
		Vector.min(new int[]{});
	}
}
