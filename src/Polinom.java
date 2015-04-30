

public class Polinom {
	
	public int[] polinom; //variabila coeficient
	
	int n; //gradul polinomului
	
	public Polinom(int n)
	{
		polinom=new int[n+1];
		this.n=n;
		for (int i=0;i<=n;i++) polinom[i]=0; //initializam cu 0 polinomul
	}
		
		public void adunare(Polinom a,Polinom c)
		{
			int[] v; //un vector in care memoram temporar valorile care rezulta dupa adunare
			if (n<a.n)   //verificam care polinom are gradu mai mare si creem vectorul temporar in functie de acesta
				{
				 v=new int[a.n+1];				
				for (int i=0;i<=n;i++)      
					v[i]=polinom[i]+a.polinom[i]; //parcurcem polinoamele pana la gradul cel mai are a polinomului cu gradul cel mai mic
				for (int i=(n+1);i<=a.n;i++)  //dupa care adaugam si gradele din polinomul care este mai mare.
					v[i]=a.polinom[i];
				}
			else
			{
				 v=new int[n+1];		  //aceasi situatie doar ca e pentru cazul in care celalalt polinom este de grad mai mare		
				for (int i=0;i<=a.n;i++)
					v[i]=polinom[i]+a.polinom[i];
				for (int i=(a.n+1);i<=n;i++)
					v[i]=polinom[i];				
			}
			
						
			c.polinom=v;  //memoram valorile in polinomul c.
			
		}
		
		public void scadere(Polinom b, Polinom c)
		{
			//int x;
			int[] v;
			if (n<b.n)     //situatia este exact la fel ca si la adunare 
				{
				v=new int[b.n+1];				
				for (int i=0;i<n;i++)
					v[i]=polinom[i]-b.polinom[i];   //dar in loc sa adunam scadem, ideea este la fel
				for (int i=(n+1);i<b.n;i++)
					v[i]=0-b.polinom[i];
				}
			else
			{
				v=new int[n+1];				
				for (int i=0;i<b.n;i++)
					v[i]=polinom[i]-b.polinom[i];
				for (int i=(b.n+1);i<n;i++)
					v[i]=0-polinom[i];				
			}
			c.polinom=v;
		}
		
		public void inmultire(Polinom b, Polinom c) //polinomul c este trimis ca parametru si lungimea lui este deja stiuta
		{											//gradul cel mai mare este= cu gradul cel mai mare din a + gradul
		for (int i=0;i<=n;i++)						//cel mai mare din b
			for(int j=0;j<=b.n;j++)
				c.polinom[j+i]+=polinom[i]*b.polinom[j];  //inmultim coeficientii si ii memoram pe pozidia i+j
		}									//care reprezinda gradele adunate
		
		public void impartire(Polinom b, Polinom rez)
		{
			int k;
	        Polinom x = new Polinom(n);
	        Polinom y = new Polinom(n);
	        Polinom aux = new Polinom(n);
	        	        
	        x.polinom=polinom;
	        k=0;
	        //rez.n=x.n-b.n;//aflam grad rez
	        while(x.n>b.n || x.n!=0)
	        {
	            
	            rez.polinom[rez.n-k]=x.polinom[x.n] / b.polinom[b.n];
	            insub(b,rez.polinom[rez.n-k],y,rez.n-k);
	            y.inmulutirescalar(-1);
	            x.adunare(y, aux);
	            aux.getgrad();
	            x=aux;
	            k++;
			
	        }
		}
		public void getgrad()
	    {
	        int i,newgrad;
	        newgrad=0;
	        for(i=0;i<n;i++)
	            if(polinom[i]!=0)
	                newgrad=i;
	        
	        n=newgrad;
	                   
	    }
		
		public void inmulutirescalar(int k) //folosim aceasta metoda pentru a inmulti polinomul din clasa curenta cu un scalar dat
	    {
	        int i;
	        
	        for(i=0;i<=n;i++)
	            polinom[i]=polinom[i]*k;
	        
	    }
		
		public void insub(Polinom a,int sub,Polinom rez,int gradd)
	    {
	        
	        Polinom aux=new Polinom(gradd);
	        aux.polinom[gradd]=sub;
	        a.inmultire(aux,rez);
	        
	    }
		public boolean eq(Polinom b) {
	        Polinom a = this;
	        if (a.n != b.n) return false;
	        for (int i = a.n; i >= 0; i--)
	            if (a.polinom[i] != b.polinom[i]) return false;
	        return true;
	    }
		  // Horner intr-un punct x
	    public int evaluare(int x) {
	        int p = 0;
	        for (int i = n; i >= 0; i--)
	            p = polinom[i] + (x * p);
	        return p;
	    }
		 // derivata
	    public Polinom derivata() {
	        if (n == 0) return new Polinom(0);
	        Polinom c = new Polinom(n- 1);
	        c.n = n- 1;
	        for (int i = 0; i < n; i++)
	            c.polinom[i] = (i + 1) * polinom[i + 1];
	        return c;
	    }
	 // convertire in string
	    public String afisPoli() {
	        if (n ==  0) return "" + polinom[0];
	        if (n ==  1) return polinom[1] + "x + " + polinom[0];
	        String s = polinom[n] + "X^" + n;
	        for (int i = n-1; i >= 0; i--) {
	            if      (polinom[i] == 0) continue;
	            else if (polinom[i]  > 0) s = s + " + " + ( polinom[i]);
	            else if (polinom[i]  < 0) s = s + " - " + (-polinom[i]);
	            if      (i == 1) s = s + "x";
	            else if (i >  1) s = s + "x^" + i;
	        }
	        return s;
	    }
}
