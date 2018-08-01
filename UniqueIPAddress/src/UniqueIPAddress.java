//John Chung King Sow
//Extra Credit Assignment Number 2: Creating randomized and unique IP Addresses which are then sorted
//Professor Abbas Moghtanei 
//CS211S Fall 2017

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class UniqueIPAddress implements Comparable<UniqueIPAddress>
{
String IPAddress;

public UniqueIPAddress()
{
	IPAddress = randomize() + "." + randomize() + "." + randomize() + "." + randomize();
}

private int randomize()
{
	Random random = new Random();
	int value = random.nextInt(256);
	return value;
}

public static void main (String[] args)
{
	HashSet<String>set = new HashSet<String>();
	UniqueIPAddress[] addresses = new UniqueIPAddress[10000];
	int count=0;
	while (count < 10000)
	{
		UniqueIPAddress IPAddress = new UniqueIPAddress();
		if (!set.contains(IPAddress.toString()))
		{
			addresses [count] = IPAddress;
			count++;
			set.add(IPAddress.toString());
		}
	}
	
	Arrays.sort(addresses);
	for (int i=0; i<10; i++)
	{
		System.out.println(addresses[i]);
	}
	for (int i=9999; i >=9990; i--)
	{
		System.out.println(addresses[i]);
	}
	
	UniqueIPAddress IPAddress = new UniqueIPAddress(); 
	System.out.println(IPAddress);
}

	@Override
	public String toString()
	{
		return ("Unique IP Address: " + IPAddress);
	}
	
	@Override
	public int compareTo (UniqueIPAddress arg0)
	{
		return IPAddress.compareTo(arg0.IPAddress);
	}
}
