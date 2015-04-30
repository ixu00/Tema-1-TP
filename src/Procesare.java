import java.util.*;

public class Procesare {
	Polinom a,b,c; 
	int optiune=1;
	public static Scanner inp = new Scanner (System.in) ;
Procesare(){	
CitirePolinom();
meniu();

while (optiune!=0) {
	System.out.println("Ce operatie doriti sa efectuati?");
	optiune=inp.nextInt();	
	if (optiune==1){
		cls();
		CitirePolinom();
		meniu();
		}
	if (optiune==2){
		if(a.n<b.n) c=new Polinom(b.n);
		else
			c=new Polinom(a.n);
		b.adunare(a,c);
		System.out.print("Suma celor doua polinoame este: "+c.afisPoli());
		System.out.println(); 
		}
	else if (optiune==3){
			if(a.n<b.n) c=new Polinom(b.n);
			else
				c=new Polinom(a.n);
			b.scadere(a,c);
			System.out.print("Diferenta celor doua polinoame este: "+c.afisPoli());	
			System.out.println();
	}
	else if (optiune==4){
		System.out.println("Introduceti valoarea cu care vreti sa inmultiti polinomul: ");
		int s=inp.nextInt();
		System.out.println("Alegeti polinomul care vreti sa il inmultiti cu un scalar: ");
		int pol=inp.nextInt();
		if (pol==1){
		a.inmulutirescalar(s);
		System.out.print("Polinomul rezultat este: "+a.afisPoli());
		}
		else if (pol==2){
		b.inmulutirescalar(s);
		System.out.print("Polinomul rezultat este: "+b.afisPoli());
		}
		else 
			System.out.println("Acest polinom nu exista! ");
		System.out.println();
	}
	else if (optiune==5){
		c=new Polinom(a.n+b.n);
		b.inmultire(a,c);
		System.out.print("Produsul polinoamelor este: "+c.afisPoli());
		System.out.println();
}	
	else if (optiune==6){
		/*if(a.n<b.n){
		c=new Polinom(b.n-a.n);
		b.impartire(a,c);
		System.out.print("Catul polinoamelor este: "+c.afisPoli());
		}
		else 
		{c=new Polinom(a.n-b.n);	
		a.impartire(b,c);
		System.out.print("Catul polinoamelor este: "+c.afisPoli());
		}
		*/
	}
	else if (optiune==7){
		System.out.println("Alegeti polinomul care vreti sa il derivati: ");
		int pol=inp.nextInt();
		if (pol==1){
			System.out.println("Derivata polinomuli A este: "+ a.derivata());
			
		}
		else if (pol==2){	
			System.out.println("Derivata polinomului B este: " + b.derivata());	
			
			}
		else 
			System.out.println("Acest polinom nu exista! ");
		System.out.println();
	}
	else if (optiune==8){
	
	 boolean aux = a.eq(b);
		if (aux==true)
	System.out.println("Polinoamele sunt egale");
		else
			System.out.println("Polinoamele nu sunt egale");
		}
	else if (optiune==9){
		
		System.out.println("Alegeti polinomul care vreti sa il calculati: ");
		int pol=inp.nextInt();
		if (pol==1){
			System.out.println("In ce punct vreti sa calculati polinomul? ");
			int k=inp.nextInt();
			System.out.println("Valoare polinomuli A in acest punct este: "+ a.evaluare(k));
			
		}
		else if (pol==2){	
			System.out.println("In ce punct vreti sa calculati polinomul? ");
			int k=inp.nextInt();
			System.out.println("Valoare polinomuli B in acest punct este: "+ b.evaluare(k));	
			
			}
		else 
			System.out.println("Acest polinom nu exista! ");
		System.out.println();
		 
			}
	}
	}
private void CitirePolinom() {
	System.out.println("Pentru a incepe va rugam introduceti urmatoarele date:");
    System.out.println("Nota - Coeficientii polinoamelor trebie sa fie numere intregi! ");
    System.out.println();
	System.out.println("Introduceti gradul polinomuli A:");
	int n = inp.nextInt();
	a = new Polinom(n);
	System.out.println("Introduceti coeficientii polinomuli:");
	for (int i=0;i<n;i++)
	a.polinom[i]=inp.nextInt();
	 	System.out.println();
		System.out.println("Introduceti gradul polinomuli B:");
		int k = inp.nextInt();
		b = new Polinom(k);
		System.out.println("Introduceti coeficientii polinomuli:");
		for (int i=0;i<k;i++)
			b.polinom[i]=inp.nextInt();
	cls();
	System.out.print("Ploinomul A este: "+ a.afisPoli());
	System.out.println();
	System.out.print("Ploinomul B este: "+ b.afisPoli());
	System.out.println();
	System.out.println();
	}
private void meniu(){
	System.out.println("Meniul operatiilor :");
	System.out.println();
	System.out.println("1. Reintroducere polinoame");
	System.out.println("2. Adunarea a doua polinoame");
	System.out.println("3. Scaderea a doua polinoame");
	System.out.println("4. Inmultirea cu un scalar");
	System.out.println("5. Inmultirea a doua polinoame");
	System.out.println("6. Impartire a doua polinoame"); 
	System.out.println("7. Calculul derivatei");
	System.out.println("8. Verifica daca polinoamele sunt egale");
	System.out.println("9. Calculeaza polinomul intr-un punct dat");
	System.out.println("0. Parasirea aplicatiei");
	System.out.println();
}
	
private void cls() {
	for(int clear = 0; clear < 1000; clear++)
	  {
	     System.out.println("\n") ;
	  }
	
}

		}

