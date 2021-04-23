
/*
 * 
 * Mafia mini project by Ali Nour ..
 *  ( Github repository link >>> https://github.com/ali3ds/mafia-mini-project )
 */


package MafiaPackage;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class game {

	public static Scanner input = new Scanner(System.in);
	public static int playersCount;
	public static String roles = "Joker villager detective doctor bulletproof mafia godfather silencer informer ";

	static villager[] villagers = new villager[500];
	static int villagers_count;
	static mafia[] mafias = new mafia[500];
	static int mafias_count;
	static Joker joker;
	static int joker_count;
	static detective[] detectives = new detective[500];
	static int detectives_count;
	static doctor[] doctors = new doctor[500];
	static int doctors_count;
	static bulletproof[] bulletproofs = new bulletproof[500];
	static int bulletproofs_count;
	static godfather[] godfathers = new godfather[500];
	static int godfathers_count;
	static silencer[] silencers = new silencer[500];
	static int silencers_count;
	
	static informer Informer;
	static int informers_count;

	static boolean EveryOneHasRole = false;

	static boolean gameOn = false;

	static int DayNum = 1;

	public static int getCount(person[] p, int c) {
		int a = 0;
		for (int i = 0; i < c; i++) {
			if (p[i].isAlive)
				a++;
		}
		return a;
	}

	public static void createRole(String name, String role) {
		switch (role) {
		case "Joker":
			joker = new Joker(name);
			joker_count++;
			break;

		case "villager":
			villagers[villagers_count] = new villager(name);
			villagers_count++;
			break;

		case "detective":
			detectives[detectives_count] = new detective(name);
			detectives_count++;
			break;

		case "doctor":
			doctors[doctors_count] = new doctor(name);
			doctors_count++;
			break;

		case "bullerproof":
			bulletproofs[bulletproofs_count] = new bulletproof(name);
			bulletproofs_count++;
			break;

		case "mafia":
			mafias[mafias_count] = new mafia(name);
			mafias_count++;
			break;

		case "godfather":
			godfathers[godfathers_count] = new godfather(name);
			godfathers_count++;
			break;

		case "silencer":
			silencers[silencers_count] = new silencer(name);
			silencers_count++;
			break;

		case "informer":
			Informer = new informer(name);
			informers_count++;
			break;

		}
	}

	static String names;

	public static void new_game() {
		names = input.nextLine() + " ";
		String[] splited = names.trim().split("\\s+");
		playersCount = splited.length;
		int i = 0;
		while (i < splited.length) {
			if (input.next().equals("assign_role") == false)
				continue;
			String n = input.next();
			if (names.contains(n + " ")) {
				String r = input.next();
				if (roles.contains(r + " ")) {
					createRole(n, r);
					i++;

				} else {
					System.out.println("role not found");
				}

			} else {
				System.out.println("user not found");
			}

		}

		if (i == splited.length) {
			EveryOneHasRole = true;
		}

	}

	public static void showList() {
		if (!EveryOneHasRole)
			System.out.println("one or more player do not have a role");
		else {
			for (int i = 0; i < villagers_count; i++)
				System.out.println(villagers[i].name + ": " + "villager");
			for (int i = 0; i < detectives_count; i++)
				System.out.println(detectives[i].name + ": " + "detective");
			for (int i = 0; i < doctors_count; i++)
				System.out.println(doctors[i].name + ": " + "doctor");
			for (int i = 0; i < bulletproofs_count; i++)
				System.out.println(bulletproofs[i].name + ": " + "bulletproof");
			for (int i = 0; i < joker_count; i++)
				System.out.println(joker.name + ": " + "Joker");
			for (int i = 0; i < informers_count; i++)
				System.out.println(Informer.name + ": " + "informer");
			for (int i = 0; i < mafias_count; i++)
				System.out.println(mafias[i].name + ": " + "mafia");
			for (int i = 0; i < godfathers_count; i++)
				System.out.println(godfathers[i].name + ": " + "godfather");
			for (int i = 0; i < silencers_count; i++)
				System.out.println(silencers[i].name + ": " + "silencer");
		}
	}

	public static boolean PlayerIsSilenced(String name) {
		for (int i = 0; i < villagers_count; i++)
			if (villagers[i].name.equals(name)) {
				if (villagers[i].isSilenced)
					return true;
				else {
					return false;
				}
			}

		for (int i = 0; i < detectives_count; i++)
			if (detectives[i].name.equals(name)) {
				if (detectives[i].isSilenced)
					return true;
				else {
					return false;
				}
			}

		for (int i = 0; i < doctors_count; i++)
			if (doctors[i].name.equals(name)) {
				if (doctors[i].isSilenced)
					return true;
				else {
					return false;
				}
			}

		for (int i = 0; i < bulletproofs_count; i++)
			if (bulletproofs[i].name.equals(name)) {
				if (bulletproofs[i].isSilenced)
					return true;
				else {
					return false;
				}
			}

		for (int i = 0; i < joker_count; i++)
			if (joker.name.equals(name)) {
				if (joker.isSilenced)
					return true;
				else {
					return false;
				}
			}

		for (int i = 0; i < informers_count; i++)
			if (Informer.name.equals(name)) {
				if (Informer.isSilenced)
					return true;
				else {
					return false;
				}
			}

		for (int i = 0; i < mafias_count; i++)
			if (mafias[i].name.equals(name)) {
				if (mafias[i].isSilenced)
					return true;
				else {
					return false;
				}
			}

		for (int i = 0; i < godfathers_count; i++)
			if (godfathers[i].name.equals(name)) {
				if (godfathers[i].isSilenced)
					return true;
				else {
					return false;
				}
			}

		return false;

	}

	public static boolean PlayerIsAlive(String name) {
		for (int i = 0; i < villagers_count; i++)
			if (villagers[i].name.equals(name)) {
				if (villagers[i].isAlive)
					return true;
				else {
					return false;
				}
			}

		for (int i = 0; i < detectives_count; i++)
			if (detectives[i].name.equals(name)) {
				if (detectives[i].isAlive)
					return true;
				else {
					return false;
				}
			}

		for (int i = 0; i < doctors_count; i++)
			if (doctors[i].name.equals(name)) {
				if (doctors[i].isAlive)
					return true;
				else {
					return false;
				}
			}

		for (int i = 0; i < bulletproofs_count; i++)
			if (bulletproofs[i].name.equals(name)) {
				if (bulletproofs[i].isAlive)
					return true;
				else {
					return false;
				}
			}

		for (int i = 0; i < joker_count; i++)
			if (joker.name.equals(name)) {
				if (joker.isAlive)
					return true;
				else {
					return false;
				}
			}

		for (int i = 0; i < informers_count; i++)
			if (Informer.name.equals(name)) {
				if (Informer.isAlive)
					return true;
				else {
					return false;
				}
			}

		for (int i = 0; i < mafias_count; i++)
			if (mafias[i].name.equals(name)) {
				if (mafias[i].isAlive)
					return true;
				else {
					return false;
				}
			}

		for (int i = 0; i < godfathers_count; i++)
			if (godfathers[i].name.equals(name)) {
				if (godfathers[i].isAlive)
					return true;
				else {
					return false;
				}
			}

		for (int i = 0; i < silencers_count; i++)
			if (silencers[i].name.equals(name)) {
				if (silencers[i].isAlive)
					return true;
				else {
					return false;
				}
			}

		return false;

	}

	public static person findPlayer(String name) {
		for (int i = 0; i < villagers_count; i++)
			if (villagers[i].name.equals(name)) {
				return villagers[i];
			}

		for (int i = 0; i < detectives_count; i++)
			if (detectives[i].name.equals(name)) {
				return detectives[i];
			}

		for (int i = 0; i < doctors_count; i++)
			if (doctors[i].name.equals(name)) {
				return doctors[i];
			}

		for (int i = 0; i < bulletproofs_count; i++)
			if (bulletproofs[i].name.equals(name)) {
				return bulletproofs[i];

			}

		for (int i = 0; i < joker_count; i++)
			if (joker.name.equals(name)) {
				return joker;
			}

		for (int i = 0; i < informers_count; i++)
			if (Informer.name.equals(name)) {
				return Informer;
			}

		for (int i = 0; i < mafias_count; i++)
			if (mafias[i].name.equals(name)) {
				return mafias[i];

			}

		for (int i = 0; i < godfathers_count; i++)
			if (godfathers[i].name.equals(name)) {
				return godfathers[i];

			}

		for (int i = 0; i < silencers_count; i++)
			if (silencers[i].name.equals(name)) {
				return silencers[i];

			}
		return null;
	}

	public static void resetVotes() {
		for (int i = 0; i < villagers_count; i++)
			villagers[i].resetVotes();
		for (int i = 0; i < detectives_count; i++)
			detectives[i].resetVotes();
		for (int i = 0; i < doctors_count; i++)
			doctors[i].resetVotes();
		for (int i = 0; i < bulletproofs_count; i++)
			bulletproofs[i].resetVotes();
		for (int i = 0; i < joker_count; i++)
			joker.resetVotes();
		for (int i = 0; i < mafias_count; i++)
			mafias[i].resetVotes();
		for (int i = 0; i < godfathers_count; i++)
			godfathers[i].resetVotes();
		for (int i = 0; i < silencers_count; i++)
			silencers[i].resetVotes();
		for (int i = 0; i < informers_count; i++)
			Informer.resetVotes();

	}

	public static void showWakeUps() {
		for (int i = 0; i < detectives_count; i++)
			if (detectives[i].hasToWakeUp && detectives[i].isAlive == true)
				System.out.println(detectives[i].name + ": " + "detective");
		for (int i = 0; i < doctors_count; i++)
			if (doctors[i].hasToWakeUp && doctors[i].isAlive == true)
				System.out.println(doctors[i].name + ": " + "doctor");
		for (int i = 0; i < bulletproofs_count; i++)
			if (bulletproofs[i].hasToWakeUp && bulletproofs[i].isAlive == true)
				System.out.println(bulletproofs[i].name + ": " + "bulletproof");
		for (int i = 0; i < joker_count; i++)
			if (joker.hasToWakeUp && joker.isAlive == true)
				System.out.println(joker.name + ": " + "Joker");
		for (int i = 0; i < mafias_count; i++)
			if (mafias[i].hasToWakeUp && mafias[i].isAlive == true)
				System.out.println(mafias[i].name + ": " + "mafia");
		for (int i = 0; i < godfathers_count; i++)
			if (godfathers[i].hasToWakeUp && godfathers[i].isAlive == true)
				System.out.println(godfathers[i].name + ": " + "godfather");
		for (int i = 0; i < silencers_count; i++)
			if (silencers[i].hasToWakeUp && silencers[i].isAlive == true)
				System.out.println(silencers[i].name + ": " + "silencer");
	}

	public static String doctors_target;

	public static void silence(String name) {
		for (int i = 0; i < villagers_count; i++)
			if (villagers[i].name.equals(name)) {
				villagers[i].isSilenced = true;
				return;
			}

		for (int i = 0; i < detectives_count; i++)
			if (detectives[i].name.equals(name)) {
				detectives[i].isSilenced = true;
				return;
			}

		for (int i = 0; i < doctors_count; i++)
			if (doctors[i].name.equals(name)) {
				doctors[i].isSilenced = true;
				return;
			}

		for (int i = 0; i < bulletproofs_count; i++)
			if (bulletproofs[i].name.equals(name)) {
				bulletproofs[i].isSilenced = true;
				return;

			}

		for (int i = 0; i < joker_count; i++)
			if (joker.name.equals(name)) {
				joker.isSilenced = true;
				return;
			}

		for (int i = 0; i < informers_count; i++)
			if (Informer.name.equals(name)) {
				Informer.isSilenced = true;
				return;
			}

		for (int i = 0; i < mafias_count; i++)
			if (mafias[i].name.equals(name)) {
				mafias[i].isSilenced = true;
				return;

			}

		for (int i = 0; i < godfathers_count; i++)
			if (godfathers[i].name.equals(name)) {
				godfathers[i].isSilenced = true;
				return;

			}

		for (int i = 0; i < silencers_count; i++)
			if (silencers[i].name.equals(name)) {
				silencers[i].isSilenced = true;
				return;

			}
	}

	public static boolean detective_has_asked = false;

	public static boolean silenced = false;
	public static String silencedName;
	
	public static void FunctionNight(String name, String person2) {

		for (int i = 0; i < villagers_count; i++)
			if (villagers[i].name.equals(name)) {
				System.out.println("user can not wake up during night");
				return;
			}
		for (int i = 0; i < bulletproofs_count; i++)
			if (bulletproofs[i].name.equals(name)) {
				System.out.println("user can not wake up during night");
				return;
			}

		for (int i = 0; i < joker_count; i++)
			if (joker.name.equals(name)) {
				System.out.println("user can not wake up during night");
				return;
			}

		for (int i = 0; i < detectives_count; i++)
			if (detectives[i].name.equals(name)) {
				if (detective_has_asked) {
					System.out.println("detective has already asked");
					return;
				} else {

					for (int j = 0; j < mafias_count; j++)
						if (mafias[i].name.equals(person2)) {
							System.out.println("YES");
							detective_has_asked=true;
							return;
						}
					for (int j = 0; j < silencers_count; j++)
						if (silencers[i].name.equals(person2)) {
							System.out.println("YES");
							detective_has_asked=true;
							return;
						}
					System.out.println("NO");
					detective_has_asked=true;
					return;
				}

			}

		for (int i = 0; i < doctors_count; i++)
			if (doctors[i].name.equals(name)) {
				doctors_target = person2;
				return;
			}

		for (int i = 0; i < mafias_count; i++)
			if (mafias[i].name.equals(name)) {
				voteNight(person2);
				return;
			}

		for (int i = 0; i < godfathers_count; i++)
			if (godfathers[i].name.equals(name)) {
				voteNight(person2);
				return;
			}

		for (int i = 0; i < silencers_count; i++)
			if (silencers[i].name.equals(name)) {
				if(!silenced) {
					silence(person2);
					silenced = true;
					silencedName = person2;
				}else {
					voteNight(person2);
				}
				return;
			}
	}

	public static void resultNight(String name) {
		for (int i = 0; i < villagers_count; i++)
			if (villagers[i].name.equals(name)) {

				System.out.println("mafia tried to kill " + name);
				if (!doctors_target.equals(name)) {
					villagers[i].isAlive = false;
					System.out.println(villagers[i].name + " was killed");
					return;
				}

			}

		for (int i = 0; i < detectives_count; i++)
			if (detectives[i].name.equals(name)) {
				System.out.println("mafia tried to kill " + name);
				if (!doctors_target.equals(name)) {
					detectives[i].isAlive = false;
					System.out.println(detectives[i].name + " was killed");
					return;
				}
			}

		for (int i = 0; i < doctors_count; i++)
			if (doctors[i].name.equals(name)) {
				System.out.println("mafia tried to kill " + name);
				if (!doctors_target.equals(name)) {
					doctors[i].isAlive = false;
					System.out.println(doctors[i].name + " was killed");
					return;
				}
			}

		for (int i = 0; i < bulletproofs_count; i++)
			if (bulletproofs[i].name.equals(name)) {
				System.out.println("mafia tried to kill " + name);
				if (!doctors_target.equals(name)) {
					
					if(bulletproofs[i].extraHealth) {
						bulletproofs[i].extraHealth=false;return;
					}else {
						villagers[i].isAlive = false;
						System.out.println(bulletproofs[i].name + " was killed");
						return;
					}
					
				}
			}

		for (int i = 0; i < joker_count; i++)
			if (joker.name.equals(name)) {
				System.out.println("mafia tried to kill " + name);
				if (!doctors_target.equals(name)) {
					joker.isAlive = false;
					System.out.println(joker.name + " was killed");
					return;
				}
			}
		for (int i = 0; i < informers_count; i++)
			if (Informer.name.equals(name)) {
				System.out.println("mafia tried to kill " + name);
				if (!doctors_target.equals(name)) {
					Informer.isAlive = false;
					System.out.println(Informer.name + " was killed");
					inform();
					return;
				}
			}

	}

	public static void inform() {
		Random rand = new Random();
		
		while(true) {
			int random = rand.nextInt(3);
			if(random==0) {
				Informer.inform(mafias,mafias_count);break;}
				else if(random==1) {
				Informer.inform(getCount(mafias,mafias_count));break;}
				else {
				if(joker_count<1) {
					continue;
					}else {
				Informer.inform(joker);break;}
				}
		}
	}

	public static void checkIfGameEnds() {
		int v=getCount(villagers,villagers_count)+getCount(doctors,doctors_count)+getCount(detectives,detectives_count)+getCount(bulletproofs,bulletproofs_count);
		if(informers_count>0)v++;
		//if(joker_count>0)v++;
		 int m = getCount(mafias,mafias_count)+getCount(godfathers,godfathers_count)+getCount(silencers,silencers_count);
		 
		 if(m>=v) {
			 System.out.println("Mafia won!");
			 System.exit(0);
		 }else if(m==0) {
			 System.out.println("Villager won!");
			 System.exit(0);
		 }
	}

	public static void Night() {
		resetVotes();
		System.out.println("Night " + DayNum);
		silenced = false;
		detective_has_asked = false;
		doctors_target = "";
		showWakeUps();

		checkIfGameEnds();
		
		while (true) {

			String person1 = input.next();

			if (person1.equals("end_night")) {
				break;
			}
			if(person1.equals("get_game_state")) {get_game_state();continue;}
			String person2 = input.next();

			FunctionNight(person1, person2);

		}
		DayNum++;

		checkIfGameEnds();

		Day();
	}

	public static int mostVote = 0;
	public static String[] mostVoteName = new String[500];
	public static int mostVoteSame = 1;

	public static void vote(String name) {
		for (int i = 0; i < villagers_count; i++)
			if (villagers[i].name.equals(name)) {
				if (!villagers[i].isAlive) {
					System.out.println("votee already dead");
					return;
				}
				villagers[i].votes++;
				if (villagers[i].votes > mostVote) {
					mostVoteSame = 1;
					mostVote = villagers[i].votes;
					mostVoteName[0] = villagers[i].name;
				} else if (villagers[i].votes == mostVote) {
					mostVoteName[mostVoteSame] = villagers[i].name;
					mostVoteSame++;
				}
			}

		for (int i = 0; i < detectives_count; i++)
			if (detectives[i].name.equals(name)) {
				if (!detectives[i].isAlive) {
					System.out.println("votee already dead");
					return;
				}
				detectives[i].votes++;
				if (detectives[i].votes > mostVote) {
					mostVoteSame = 1;
					mostVote = detectives[i].votes;
					mostVoteName[0] = detectives[i].name;
				} else if (detectives[i].votes == mostVote) {
					mostVoteName[mostVoteSame] = detectives[i].name;
					mostVoteSame++;
				}
			}

		for (int i = 0; i < doctors_count; i++)
			if (doctors[i].name.equals(name)) {
				if (!doctors[i].isAlive) {
					System.out.println("votee already dead");
					return;
				}
				doctors[i].votes++;
				if (doctors[i].votes > mostVote) {
					mostVoteSame = 1;
					mostVote = doctors[i].votes;
					mostVoteName[0] = doctors[i].name;
				} else if (doctors[i].votes == mostVote) {
					mostVoteName[mostVoteSame] = doctors[i].name;
					mostVoteSame++;
				}
			}

		for (int i = 0; i < bulletproofs_count; i++)
			if (bulletproofs[i].name.equals(name)) {
				if (!bulletproofs[i].isAlive) {
					System.out.println("votee already dead");
					return;
				}
				bulletproofs[i].votes++;
				if (bulletproofs[i].votes > mostVote) {
					mostVoteSame = 1;
					mostVote = bulletproofs[i].votes;
					mostVoteName[0] = bulletproofs[i].name;
				} else if (bulletproofs[i].votes == mostVote) {
					mostVoteName[mostVoteSame] = bulletproofs[i].name;
					mostVoteSame++;
				}
			}

		for (int i = 0; i < joker_count; i++)
			if (joker.name.equals(name)) {
				if (!joker.isAlive) {
					System.out.println("votee already dead");
					return;
				}
				joker.votes++;
				if (joker.votes > mostVote) {
					mostVoteSame = 1;
					mostVote = joker.votes;
					mostVoteName[0] = joker.name;
				} else if (joker.votes == mostVote) {
					mostVoteName[mostVoteSame] = joker.name;
					mostVoteSame++;
				}
			}

		for (int i = 0; i < informers_count; i++)
			if (Informer.name.equals(name)) {
				if (!Informer.isAlive) {
					System.out.println("votee already dead");
					return;
				}
				Informer.votes++;
				if (Informer.votes > mostVote) {
					mostVoteSame = 1;
					mostVote = Informer.votes;
					mostVoteName[0] = Informer.name;
				} else if (Informer.votes == mostVote) {
					mostVoteName[mostVoteSame] = Informer.name;
					mostVoteSame++;
				}
			}

		for (int i = 0; i < mafias_count; i++)
			if (mafias[i].name.equals(name)) {
				if (!mafias[i].isAlive) {
					System.out.println("votee already dead");
					return;
				}
				mafias[i].votes++;
				if (mafias[i].votes > mostVote) {
					mostVoteSame = 1;
					mostVote = mafias[i].votes;
					mostVoteName[0] = mafias[i].name;
				} else if (mafias[i].votes == mostVote) {
					mostVoteName[mostVoteSame] = mafias[i].name;
					mostVoteSame++;
				}
			}

		for (int i = 0; i < godfathers_count; i++)
			if (godfathers[i].name.equals(name)) {
				if (!godfathers[i].isAlive) {
					System.out.println("votee already dead");
					return;
				}
				godfathers[i].votes++;
				if (godfathers[i].votes > mostVote) {
					mostVoteSame = 1;
					mostVote = godfathers[i].votes;
					mostVoteName[0] = godfathers[i].name;
				} else if (godfathers[i].votes == mostVote) {
					mostVoteName[mostVoteSame] = godfathers[i].name;
					mostVoteSame++;
				}
			}

		for (int i = 0; i < silencers_count; i++)
			if (silencers[i].name.equals(name)) {
				if (!silencers[i].isAlive) {
					System.out.println("votee already dead");
					return;
				}
				silencers[i].votes++;
				if (silencers[i].votes > mostVote) {
					mostVoteSame = 1;
					mostVote = silencers[i].votes;
					mostVoteName[0] = silencers[i].name;
				} else if (silencers[i].votes == mostVote) {
					mostVoteName[mostVoteSame] = silencers[i].name;
					mostVoteSame++;
				}
			}
	}

	public static void voteNight(String name) {

		for (int i = 0; i < villagers_count; i++)
			if (villagers[i].name.equals(name)) {

				if (!villagers[i].isAlive) {
					System.out.println("votee already dead");
					return;
				}

				villagers[i].votes++;
				if (villagers[i].votes > mostVote) {
					mostVoteSame = 1;
					mostVote = villagers[i].votes;
					mostVoteName[0] = villagers[i].name;
				} else if (villagers[i].votes == mostVote) {
					mostVoteName[mostVoteSame] = villagers[i].name;
					mostVoteSame++;
				}
				return;
			}

		for (int i = 0; i < detectives_count; i++)
			if (detectives[i].name.equals(name)) {

				if (!detectives[i].isAlive) {
					System.out.println("votee already dead");
					return;
				}

				detectives[i].votes++;
				if (detectives[i].votes > mostVote) {
					mostVoteSame = 1;
					mostVote = detectives[i].votes;
					mostVoteName[0] = detectives[i].name;
				} else if (detectives[i].votes == mostVote) {
					mostVoteName[mostVoteSame] = detectives[i].name;
					mostVoteSame++;
				}
				return;
			}

		for (int i = 0; i < doctors_count; i++)
			if (doctors[i].name.equals(name)) {
				if (!doctors[i].isAlive) {
					System.out.println("votee already dead");
					return;
				}
				doctors[i].votes++;
				if (doctors[i].votes > mostVote) {
					mostVoteSame = 1;
					mostVote = doctors[i].votes;
					mostVoteName[0] = doctors[i].name;
				} else if (doctors[i].votes == mostVote) {
					mostVoteName[mostVoteSame] = doctors[i].name;
					mostVoteSame++;
				}
				return;
			}

		for (int i = 0; i < bulletproofs_count; i++)
			if (bulletproofs[i].name.equals(name)) {
				if (!bulletproofs[i].isAlive) {
					System.out.println("votee already dead");
					return;
				}
				bulletproofs[i].votes++;
				if (bulletproofs[i].votes > mostVote) {
					mostVoteSame = 1;
					mostVote = bulletproofs[i].votes;
					mostVoteName[0] = bulletproofs[i].name;
				} else if (bulletproofs[i].votes == mostVote) {
					mostVoteName[mostVoteSame] = bulletproofs[i].name;
					mostVoteSame++;
				}
				return;
			}

		for (int i = 0; i < joker_count; i++)
			if (joker.name.equals(name)) {
				if (!joker.isAlive) {
					System.out.println("votee already dead");
					return;
				}
				joker.votes++;
				if (joker.votes > mostVote) {
					mostVoteSame = 1;
					mostVote = joker.votes;
					mostVoteName[0] = joker.name;
				} else if (joker.votes == mostVote) {
					mostVoteName[mostVoteSame] = joker.name;
					mostVoteSame++;
				}
				return;
			}

		for (int i = 0; i < informers_count; i++)
			if (Informer.name.equals(name)) {
				if (!Informer.isAlive) {
					System.out.println("votee already dead");
					return;
				}
				Informer.votes++;
				if (Informer.votes > mostVote) {
					mostVoteSame = 1;
					mostVote = Informer.votes;
					mostVoteName[0] = Informer.name;
				} else if (Informer.votes == mostVote) {
					mostVoteName[mostVoteSame] = Informer.name;
					mostVoteSame++;
				}
				return;
			}
		
		System.out.println("user not joined");

	}

	public static void result(String name) {
		for (int i = 0; i < villagers_count; i++)
			if (villagers[i].name.equals(name)) {
				villagers[i].isAlive = false;
				System.out.println(villagers[i].name + " died");
				return;
			}

		for (int i = 0; i < detectives_count; i++)
			if (detectives[i].name.equals(name)) {
				detectives[i].isAlive = false;
				System.out.println(detectives[i].name + " died");
				return;
			}

		for (int i = 0; i < doctors_count; i++)
			if (doctors[i].name.equals(name)) {
				doctors[i].isAlive = false;
				System.out.println(doctors[i].name + " died");
				return;
			}

		for (int i = 0; i < bulletproofs_count; i++)
			if (bulletproofs[i].name.equals(name)) {
				bulletproofs[i].isAlive = false;
				System.out.println(bulletproofs[i].name + " died");
				return;
			}

		for (int i = 0; i < joker_count; i++)
			if (joker.name.equals(name)) {
				System.out.println("Joker won!");
				System.exit(0);
			}

		for (int i = 0; i < mafias_count; i++)
			if (mafias[i].name.equals(name)) {
				mafias[i].isAlive = false;
				System.out.println(mafias[i].name + " died");
				return;
			}

		for (int i = 0; i < godfathers_count; i++)
			if (godfathers[i].name.equals(name)) {
				godfathers[i].isAlive = false;
				System.out.println(godfathers[i].name + " died");
				return;
			}

		for (int i = 0; i < silencers_count; i++)
			if (silencers[i].name.equals(name)) {
				silencers[i].isAlive = false;
				System.out.println(silencers[i].name + " died");
				return;
			}
		for (int i = 0; i < informers_count; i++)
			if (Informer.name.equals(name)) {
				Informer.isAlive = false;
				System.out.println(Informer.name + " died");
				inform();
				return;
			}
	}

	public static void Day() {
		resetVotes();
		System.out.println("Day " + DayNum);
		if (DayNum > 1) {
			if (mostVoteSame > 1) {
				System.out.println("nobody died");
			} else {
				resultNight(mostVoteName[0]);
			}
			if (silenced) {
				System.out.println("silenced " + silencedName);
			}

			mostVoteName = new String[500];
			mostVote = 0;
			mostVoteSame = 1;
		}

	//	checkIfGameEnds();
		
		while(true) {

			String voter = input.next();
			
			if(voter.equals("end_vote")) {break;}
			if(voter.equals("get_game_state")) {get_game_state();continue;}
			
			String votee = input.next();

			if (!names.contains(voter + " ") || !names.contains(votee + " ")) {
				System.out.println("user not found");
				continue;
			}
			if (PlayerIsSilenced(voter)) {
				System.out.println("voter is silenced");
				continue;
			}
			if (!PlayerIsAlive(voter)) {
				System.out.println("voter already dead");
				continue;
			}
			vote(votee);
		}

		
			if (mostVoteSame > 1) {
				System.out.println("nobody died");
			} else {
				result(mostVoteName[0]);
			}
		
		mostVoteName = new String[500];
		mostVote = 0;
		mostVoteSame = 1;
		
		checkIfGameEnds();
		
		Night();

	}

	public static void StartGame() {
		gameOn = true;
		showList();
		System.out.println("\nReady? Set! Go.\n");
		Day();
	}

	public static void main(String[] args) {
		String in = "";
		
		while(!in.equals("create_game")) {

			in = input.next();
			if (in.equals("create_game")) {
				new_game();
				break;
			} 
			System.out.println("No game created");
		}

		while (true) {

			String s = input.next();
			switch (s) {
			case "start_game":
				if (!gameOn) {
					gameOn = true;
					showList();
					System.out.println("\nReady? Set! Go.\n");
					Day();
				} else {
					System.out.println("game has already started");
				}
				break;

			case "get_game_state":
				get_game_state();
				break;
			}
		}
	}

	private static void get_game_state() {				
		if(villagers_count>0)
		System.out.println("Villager = "+getCount(villagers, villagers_count));			
		if(mafias_count>0)
			System.out.println("Mafia = "+getCount(mafias,mafias_count));
		if(detectives_count>0)
			System.out.println("Detective = "+getCount(detectives,detectives_count));
		if(bulletproofs_count>0)
			System.out.println("Bulletproof = "+getCount(bulletproofs,bulletproofs_count));
		if(doctors_count>0)
			System.out.println("Doctor = "+getCount(doctors,doctors_count));
		if(joker_count>0)
			System.out.println("Joker = 1");
		if(godfathers_count>0)
			System.out.println("Godfather = "+getCount(godfathers,godfathers_count));
		if(silencers_count>0)
			System.out.println("Silencers = "+getCount(silencers,silencers_count));
		
	}
}

// Github repository link: 
// https://github.com/ali3ds/mafia-mini-project
