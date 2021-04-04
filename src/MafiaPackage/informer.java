package MafiaPackage;
import java.util.Random;

public class informer extends person{
	public informer(String name) {
		this.name=name;
	}
	
	public void inform(mafia[] mafias,int count) {
		Random rand = new Random();
		int random = rand.nextInt(count);
		System.out.println("There is a mafia who’s name starts with "+mafias[random].name.charAt(0));
	}
	public void inform(int count) {
		System.out.println("Number of alive mafia : "+count);
	}
	
	public void inform(Joker joker) {
		System.out.println("There is a joker who’s name starts with "+joker.name.charAt(0));
	}
}
