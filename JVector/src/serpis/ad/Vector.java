package serpis.ad;

public class Vector 
{
	public static void main(String[] args) 
	{
		int v[] = new int[]{2,4,1,6,8};
		min(v);
	}
	public static int min(int[] v)
	{
		int minValue = v[0];
//		for (int i = 1;i<v.length;i++)
//		{
//			if (v[i]<minValue)
//				minValue = v[i];
//		}
		for (int item : v)
			if (item<minValue)
				minValue = item;
		return minValue;
//		int aux = 0 ;
//		for (int i=0; i<v.length;i++)
//		{
//			for (int j=0; j<v.length;j++)
//			{
//				if (v[i]<v[j])
//				{
//					aux = v[i];
//				}
//				else
//					aux = v[j];
//			} 
//		}
//		System.out.println("El menor núm del vector es: "+aux);
//		return 0;
	}
}
