import java.util.*;
import java.io.*;
public class Anagram{
	public static Vector<String> comb;
	public static Vector<String> comb2;
	static int cou = 0;
	public static String remove(String par, String off){
		int x = off.length();
		for(int i=0;i<x;i++){
		    String a = "";
		    int c=0;
			for(int j=0;j<par.length();j++){
			    if(par.charAt(j)!=off.charAt(i)){
			        a = a+par.charAt(j);
			    }
			    else{
			        if(c==0){
			            c++;
			        }
			        else{
			            a = a+ par.charAt(j);
			        }
			    }
			}
			par = a;
		}
		return par;
	}
	public static String sortString(String inputString)
    {
  	    char temp[] = inputString.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }
    public static void getComb(String s, int n, int r){//r s small n is large
    	comb = new Vector<String>(); 
		char[] data = new char[r];
		s = sortString(s);
		combinationUtil(s, data, 0, n-1, 0, r);
    }
    public static void combinationUtil(String s, char data[], int start, int end,int index, int r){
    	if (index == r){
    		String sak = "";
        	for (int j=0; j<r; j++){
        		sak = sak + data[j];
        	}
            comb.add(sak);
        	return;
    	}
    	int i;
    	int min;
    	if(end <= end+1-r+index){
        	min = end;
    	}
    	else{
        	min = end+1-r+index;
    	}
    	for (i=start; i<=min; i++)
    	{
        	if(i<min){
        		data[index] = s.charAt(i);
        		combinationUtil(s, data, i+1, end, index+1, r);
        		while (s.charAt(i) == s.charAt(i+1)){
            		i++;
            		if(i==min){
        				break;
            		}
            	}
        	}
        	else{
            	data[index] = s.charAt(i);
        		combinationUtil(s, data, i+1, end, index+1, r);
        	}
    	}
    }
    public static void getComb2(String s, int n, int r){//r s small n is large
    	comb2 = new Vector<String>(); 
		char[] data = new char[r];
		s = sortString(s);
		combinationUtil2(s, data, 0, n-1, 0, r);
    }
    public static void combinationUtil2(String s, char data[], int start, int end,int index, int r){
    	if (index == r){
    		String sak = "";
        	for (int j=0; j<r; j++){
        		sak = sak + data[j];
        	}
            comb2.add(sak);
        	return;
    	}
    	int i;
    	int min;
    	if(end <= end+1-r+index){
        	min = end;
    	}
    	else{
        	min = end+1-r+index;
    	}
    	for (i=start; i<=min; i++)
    	{
        	if(i<min){
        		data[index] = s.charAt(i);
        		combinationUtil2(s, data, i+1, end, index+1, r);
        		while (s.charAt(i) == s.charAt(i+1)){
            		i++;
            		if(i==min){
        				break;
            		}
            	}
        	}
        	else{
            	data[index] = s.charAt(i);
        		combinationUtil2(s, data, i+1, end, index+1, r);
        	}
    	}
    }
	public static int val(char ch){
		switch(ch){
			case 'a':
				return 1;
			case 'b':
				return 13;
			case 'c':
				return 169;
			case 'd':
				return 2197;
			case 'e':
				return 8561;
			case 'f':
				return 1293;
			case 'g':
				return 6809;
			case 'h':
				return 8517;
			case 'i':
				return 721;
			case 'j':
				return 9373;
			case 'k':
				return 1849;
			case 'l':
				return 4037;
			case 'm':
				return 2481;
			case 'n':
				return 2253;
			case 'o':
				return 9289;
			case 'p':
				return 757;
			case 'q':
				return 9841;
			case 'r':
				return 7933;
			case 's':
				return 3129;
			case 't':
				return 677;
			case 'u':
				return 8801;
			case 'v':
				return 4413;
			case 'w':
				return 7369;
			case 'x':
				return 5797;
			case 'y':
				return 5361;
			case 'z':
				return 9693;
			case '1':
				return 6009;
			case '2':
				return 8117;
			case '3':
				return 5521;
			case '4':
				return 1773;
			case '5':
				return 3049;
			case '6':
				return 9637;
			case '7':
				return 5281;
			case '8':
				return 8653;
			case '9':
				return 2489;
			case '0':
				return 2357;
			default :
				return 641;
		}
	}
	public static int hash(String voca){
		int sum=0;
		for(int i=0;i<voca.length();i++){
			sum = (sum + val(voca.charAt(i)))%(10000);
		}
		return sum;
	}
	public static void print(Vector<String> ans){
		Collections.sort(ans);
		for(int t=0;t<ans.size();t++){
			System.out.println(ans.get(t));
			cou++;
		}
		System.out.println("-1");
	}
	public static void nospa(Vector<String> v, String word, Vector<String> ans){
		for(int k =0;k<(v.size());k++){
			String temp1 = "";
			temp1 = temp1 + word;
			String temp2 = "";
			temp2 = temp2 + v.get(k);
			temp2 = sortString(temp2);
			temp1 = sortString(temp1);
			if(temp1.compareTo(temp2)==0){
				ans.add(v.get(k));
			}
		}
	}
	public static void onspa(Vector<String>[] v,Vector<String> comb,String word,boolean taa,Vector<String> ans){
		for(int t=0;t<comb.size();t++){
			Vector<String> ans1 = new Vector<String>();
			Vector<String> ans2 = new Vector<String>();
			String ax = comb.get(t);
			String bx = remove(word,ax);
			int a1 = hash(ax);
			nospa(v[a1],ax,ans1);
			int a2 = hash(bx);
			nospa(v[a2],bx,ans2);
			for(int l=0;l<ans1.size();l++){
				for(int po=0;po<ans2.size();po++){
					String sa = ans1.get(l) + " " + ans2.get(po);
					ans.add(sa);
					if(taa==false){
						String sb = ans2.get(po) + " " + ans1.get(l);
						ans.add(sb);
					}
				}
			}
		}
	}
	public static void tospa(Vector<String>[] v,Vector<String> comb,String word,int p1,int p2,int p3,Vector<String> ans){
		for(int t=0;t<comb.size();t++){
			Vector<String> ans1 = new Vector<String>();
			String ax = comb.get(t);
			int a1 = hash(ax);
			String temp = remove(word,ax);
			int n= temp.length();
			getComb2(temp,n,p2);
			nospa(v[a1],ax,ans1);
			for(int l=0;l<comb2.size();l++){
				Vector<String> ans2 = new Vector<String>();
				Vector<String> ans3 = new Vector<String>();
				String bx = comb2.get(l);
				String cx = remove(temp,bx);
				int b1 = hash(bx);
				nospa(v[b1],bx,ans2);
				int c1 = hash(cx);
				nospa(v[c1],cx,ans3);
				for(int x=0;x<ans1.size();x++){
					for(int y=0;y<ans2.size();y++){
						for(int z=0;z<ans3.size();z++){
							if(p1==p2 && p2==p3 && p2==p3){
								String sa = ans1.get(x) + " " + ans2.get(y) + " " + ans3.get(z);
								ans.add(sa);
							}
							else{
								if(p1==p2&&p2!=p3 && p1!=p3){
									String sa = ans1.get(x) + " " + ans2.get(y) + " " + ans3.get(z);
									ans.add(sa);
									String ba = ans1.get(x) + " " + ans3.get(z) + " " + ans2.get(y);
									ans.add(ba);
									String za = ans3.get(z) + " " + ans2.get(y) + " " + ans1.get(x);
									ans.add(za);
								}
								else if(p1!=p2 && p2==p3 && p1!=p3){
									String sa = ans1.get(x) + " " + ans2.get(y) + " " + ans3.get(z);
									ans.add(sa);
									String ba = ans2.get(y) + " " + ans1.get(x) + " " + ans3.get(z);
									ans.add(ba);
									String za = ans3.get(z) + " " + ans2.get(y) + " " + ans1.get(x);
									ans.add(za);
								}
								else if(p1==p3&&p2!=p3 && p2!=p1){
									String sa = ans1.get(x) + " " + ans2.get(y) + " " + ans3.get(z);
									ans.add(sa);
									String ba = ans1.get(x) + " " + ans3.get(z) + " " + ans2.get(y);
									ans.add(ba);
									String za = ans2.get(y) + " " + ans1.get(x) + " " + ans3.get(z);
									ans.add(za);
								}
								else if(p1!=p2 && p2!=p3 && p3!=p1){
									String sa = ans1.get(x) + " " + ans2.get(y) + " " + ans3.get(z);
									ans.add(sa);
									String ba = ans1.get(x) + " " + ans3.get(z) + " " + ans2.get(y);
									ans.add(ba);
									String za = ans2.get(y) + " " + ans1.get(x) + " " + ans3.get(z);
									ans.add(za);
									String qa = ans3.get(z) + " " + ans2.get(y) + " " + ans1.get(x);
									ans.add(qa);
									String ha = ans3.get(z) + " " + ans1.get(x) + " " + ans2.get(y);
									ans.add(ha);
									String ma = ans2.get(y) + " " + ans3.get(z) + " " + ans1.get(x);
									ans.add(ma);
								}
							}
						}
					}
				}
			}
		}
	}
	public static void main(String[] args){
		long startTime=System.currentTimeMillis();
		if(args.length !=2){
			return;
		}
		try{
			Scanner s = new Scanner(new File(args[0]));
			int siz = s.nextInt();
			int haval;
			Vector<String>[] v = (Vector<String>[]) new Vector[10000];
			for(int i = 0; i < v.length; i++){
   				v[i] = new Vector<String>();
			}
			for(int i=0;i<siz;i++){
				String voca = s.next();
				haval = hash(voca);
				v[haval].add(voca); 
			}
			Scanner r = new Scanner(new File(args[1]));
			int num = r.nextInt();
			for(int j=0;j<num;j++){
				String word = r.next();
				int ab = hash(word);
				int x = word.length();
				Vector<String> ans = new Vector<String>();
				if(x<=2 && x>=0){
					System.out.println("-1");
				}
				else if(x>=3 && x<=5){
					nospa(v[ab],word,ans);
					print(ans);	
				}
				else if(x==6){
					nospa(v[ab],word,ans);
					getComb(word,x,3);
					onspa(v,comb,word,true,ans);
					print(ans);
				}
				else if(x==7){
					nospa(v[ab],word,ans);
					getComb(word,x,3);
					onspa(v,comb,word,false,ans);
					print(ans);
				}
				else if(x==8){
					nospa(v[ab],word,ans);
					getComb(word,x,3);
					onspa(v,comb,word,false,ans);
					getComb(word,x,4);
					onspa(v,comb,word,true,ans);
					print(ans);
				}
				else if(x==9){
					nospa(v[ab],word,ans);
					getComb(word,x,3);
					onspa(v,comb,word,false,ans);
					tospa(v,comb,word,3,3,3,ans);
					getComb(word,x,4);
					onspa(v,comb,word,false,ans);
					print(ans);
				}
				else if(x==10){
					nospa(v[ab],word,ans);
					getComb(word,x,3);
					onspa(v,comb,word,false,ans);
					tospa(v,comb,word,3,3,4,ans);
					getComb(word,x,4);
					onspa(v,comb,word,false,ans);
					getComb(word,x,5);
					onspa(v,comb,word,true,ans);
					print(ans);
				}
				else if(x==11){
					nospa(v[ab],word,ans);
					getComb(word,x,3);
					onspa(v,comb,word,false,ans);
					tospa(v,comb,word,3,3,5,ans);
					tospa(v,comb,word,3,4,4,ans);
					getComb(word,x,4);
					onspa(v,comb,word,false,ans);
					getComb(word,x,5);
					onspa(v,comb,word,false,ans);
					print(ans);
				}
				else if(x==12){
					nospa(v[ab],word,ans);
					getComb(word,x,3);
					onspa(v,comb,word,false,ans);
					tospa(v,comb,word,3,3,6,ans);
					tospa(v,comb,word,3,4,5,ans);
					getComb(word,x,4);
					onspa(v,comb,word,false,ans);
					tospa(v,comb,word,4,4,4,ans);
					getComb(word,x,5);
					onspa(v,comb,word,false,ans);
					getComb(word,x,6);
					onspa(v,comb,word,true,ans);
					print(ans);
				}
			}
		System.out.println(cou);
		long time=System.currentTimeMillis()-startTime;
        //System.out.println(graph);
        System.out.println("time: "+time+" millis");
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
}