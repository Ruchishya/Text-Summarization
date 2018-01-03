package project;
import java.io.*;
import java.util.StringTokenizer;

public class Stopwords
{

   String stwd[];
   public Stopwords ()
    {
        int sz=0;char bt[]=null;
       try {
         File fp=new File("D:/stopwords.txt");
         FileReader fis=new FileReader(fp);
         sz=(int)fp.length();
         bt=new  char [sz];
         fis.read(bt);
         fis.close();
          }
      catch(IOException ex) {}
      stwd=getTokens(new String(bt));
   }

public void display ()
 {
            for (int i=0;i<stwd.length;i++)
	System.out.println(stwd[i]);
   }

 public boolean  isStopword( String word)
  {
         boolean flag=false;
          for (int i =0;i<stwd.length;i++)  {
             if(stwd[i].equalsIgnoreCase(word) ) {
	  flag=true;
	   break;
               }
            }
          return flag;
   }

  public String[]  getTokens(String sen)
      {
	 int sz=0,cnt=0;String words[]=null;
	StringTokenizer  stk=new StringTokenizer(sen) ;
	sz=stk.countTokens();
     	 words=new String[sz];
     	 while ( stk.hasMoreTokens())
	{
           	words[cnt]=new String(stk.nextToken());
           	cnt++;
       	}
	return words;
    }

  public String remove(String sen)
  {
     String  dsen="";
     String  words[]=getTokens(sen);
      for (int j=0;j<words.length; j++)
          {
               if ( ! isStopword(words[j] )  )
	dsen = dsen +words[j] +" ";
          }
         return dsen;
    }

  public static void main(String str[])
   {
	Stopword sp=new Stopword();
        System.out.println(sp.remove("hai my name is ruchishya.While trying to learn the American manual alphabet I discovered a computer method to read text as if it were being finger spelled. All one needs is a Windows word-processor (or something equivalent) and a sign-language fontm quite happy with the result and think it will interest any persons who are learning the American manual alphabet themselves. The method should also work for other manual alphabets (such as the two-handed alphabet used in the UK) should fonts ever be made for them."));
   }

}