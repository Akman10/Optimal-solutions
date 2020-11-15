/*
https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff49/000000000043b0c6

Ron read a book about boring numbers. According to the book,
a positive number is called boring if all of the digits at even positions in the number are even and all of the digits at odd positions
are odd. The digits are enumerated from left to right starting from 1. 
For example, the number 1478 is boring as the odd positions include the digits {1, 7} which are odd and even positions include the 
digits {4, 8} which are even.

Given two numbers L and R, Ron wants to count how many numbers in the range [L, R] (L and R inclusive) are boring. 
Ron is unable to solve the problem, hence he needs your help. 

1 ≤ L ≤ R ≤ 1018.
*/


import java.io.*;
import java.util.*;

public class Boring_numbers
{
	public static void main(String[] args)throws Exception{ new Boring_numbers().run();} 
	long mod=1000000000+7;
	long dp[];
	void solve() throws Exception
	{
		dp=new long[20];
		for(int i=1;i<20;i++)
		{
			dp[i]=dp[i-1]+(long)Math.pow(5,i);
		}
		int test=ni();
		for(int ii=1;ii<=test;ii++)
		{
			long l=nl();
			long r=nl();
			
			out.println("Case #"+ii+": "+ (get(r+1)-get(l)) );
		}
	}
	long get(long r)
	{
		String s=r+"";
		long ans=dp[s.length()-1];
		int ch=0;
		for(int i=0;i<s.length();i++)
		{
			long x=s.charAt(i)-'0';
			int cnt=0;
			for(int j=((i+1)&1);j<x;j=j+2)
				cnt++;
			ans+= cnt*(Math.pow(5, s.length()-i-1 ));

			if( ( (i+1)%2==1&&x%2==0 ) || ((i+1)%2==0&&x%2==1) )  
				break;
		}
		return ans;
	}
	/*IMPLEMENTATION BY AMAN KOTIYAL, FAST INPUT OUTPUT & METHODS BELOW*/
	
	private byte[] buf=new byte[1024];
	private int index;
	private InputStream in;
	private int total;
	private SpaceCharFilter filter;
	PrintWriter out;
	
	int gcd(int a, int b) 
	{ 
		if (a == 0) 
			return b; 
		return gcd(b%a, a); 
	} 
	long gcd(long a, long b) 
	{ 
		if (a == 0) 
			return b; 
		return gcd(b%a, a); 
	}
	/* for (1/a)%mod = ( a^(mod-2) )%mod  ----> use expo to calc -->(a^(mod-2)) */
	long expo(long p,long q)  /*  (p^q)%mod   */
	{
		long z = 1;
		while (q>0) {
			if (q%2 == 1) {
				z = (z * p)%mod;
			}
			p = (p*p)%mod;
			q >>= 1;
		}
		return z;
	}
	void run()throws Exception
	{
		in=System.in; out = new PrintWriter(System.out);
		solve();
		out.flush();
	}
	private int scan()throws IOException
	{
		if(total<0)
			throw new InputMismatchException();
		if(index>=total)
		{
			index=0;
			total=in.read(buf);
			if(total<=0)
				return -1;
		}
		return buf[index++];
	}
	private int ni() throws IOException 
	{
		int c = scan();
		while (isSpaceChar(c))
			c = scan();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = scan();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = scan();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
	private long nl() throws IOException 
	{
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = scan()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = scan();
		}
		
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = scan();
		}
	}
	private double nd() throws IOException{
		return Double.parseDouble(ns());
	}
	private String ns() throws IOException {
		int c = scan();
		while (isSpaceChar(c))
			c = scan();
		StringBuilder res = new StringBuilder();
		do {
			if (Character.isValidCodePoint(c))
				res.appendCodePoint(c);
			c = scan();
		} while (!isSpaceChar(c));
		return res.toString();
	}
	private String nss() throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}
	private char nc() throws IOException 
	{
		int c = scan();
		while (isSpaceChar(c))
			c = scan();
		return (char) c;
	}
	private boolean isWhiteSpace(int n)
	{
		if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
			return true;
		return false;
	}
	private boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return isWhiteSpace(c);
	}
	private interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}
