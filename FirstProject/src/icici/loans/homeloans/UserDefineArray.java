package icici.loans.homeloans;

public class UserDefineArray 
{
	int sno;
	String sname;
	
	public UserDefineArray(int sno, String sname) 
	{
		super();
		this.sno = sno;
		this.sname = sname;
	}
	

	@Override
	public String toString() 
	{
		return "UserDefineArray [sno=" + sno + ", sname=" + sname + "]";
	}

	public static void main(String[] args) 
	{
		UserDefineArray obj = new UserDefineArray(1744, "sai");
		//System.out.println(obj.sno);
		//System.out.println(obj.sname);
		
		System.out.println(obj);
		
		
		UserDefineArray s1 = new UserDefineArray(1744, "sai1");
		UserDefineArray s2 = new UserDefineArray(1745, "sai2");
		UserDefineArray s3 = new UserDefineArray(1746, "sai3");
		UserDefineArray s4 = new UserDefineArray(1747, "sai4");
		
		/*System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);*/
		
		
		UserDefineArray[] a = new UserDefineArray[4];
		a[0]=s1;
		a[1]=s2;
		a[2]=s3;
		a[3]=s4;
		
		for(UserDefineArray i:a)
		{
			System.out.println(i);
		}
	}

}
