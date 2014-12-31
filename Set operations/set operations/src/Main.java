import java.util.*;

public class Main {

	static Set universe;
	static ArrayList<Set> setsArray;

	public static void printMainMenu() {
		System.out.println("");
		System.out
				.println("1- Enter new univers press                         [1]");
		System.out
				.println("2- Add a set press                                 [2]");
		System.out
				.println("3- Find the intersection between two sets press    [3]");
		System.out
				.println("4- Find the union between two sets press           [4]");
		System.out
				.println("5- Find the complement of a set press              [5]");
		System.out
				.println("6- Exit                                            [6]");

		System.out.println("Universe = " + universe.toString());
		for (int i = 0; i < setsArray.size(); i++) {
			System.out.println("Set " + (i) + " = " + setsArray.get(i));
		}

	}

	public static void main(String[] args) {

		setsArray = new ArrayList<>();
		universe = new Set();

		Scanner in = new Scanner(System.in);

		System.out.println("");
		System.out
				.println("                 welcome to the set operations program");
		System.out
				.println("                 -------------------------------------");
		System.out.println("");
		System.out.println("Main menu");
		System.out.println("----------");
		
		System.out.println("Please follow the instruction written to use the porgram easily");
		System.out.println("----------------------------------------------------------------");

		while (true) {
			printMainMenu();
			int x = 0;
			try {
				x = in.nextInt();
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("invalid input");
			}

			if (x == 1) // entring a new univrese and new sets
			{

				setsArray.clear(); // deleting all old sets
				universe.clearSet();

				System.out.println("Enter an element or type \'}\' to close the set :");
				System.out.println("--------------------------------------------------");

				String element = in.nextLine();
				while (true) {
					
					element = in.nextLine();

					if (element.compareTo("}") == 0) {
						System.out.println(universe);
						break;
					}
					universe.AddElemet(element);
					// printing the set
					System.out.println(universe.toStringNotComp());
				}

			}
			if (x == 2) { // input a new set by choosing from the universe
				Set newSet = new Set();
				if (universe.getElements().isEmpty()) {
					System.out.println("there is no universe");
				} else {
					System.out.println("choose elements form the unvierse type the number beside the element :");
					System.out.println("-----------------------------------------------------------------------");

					System.out.print("{ ");
					System.out.print(universe.getElements().get(0) + " [" + 0
							+ "] ");
					for (int i = 1; i < universe.getElements().size(); i++) {
						System.out.print(" , " + universe.getElements().get(i)
								+ " [" + i + "] ");
					}
					System.out.println(" }");
					System.out.println("");
					System.out.println("Enter the number of set elements : ");
					System.out.println("------------------------------------");

					int y = in.nextInt();
					System.out.println("Enter the indecies of the element in the universe");
					System.out.println("-----------------------------------------------");

					while (y-- > 0) {
						int s = in.nextInt();
						if (s >= universe.getElements().size()) {
							y++;
							System.out.println("Out of bound");
							continue;
						}
						newSet.AddElemet(universe.getElements().get(s));
						System.out.println(newSet.toStringNotComp());
					}
					System.out.println(newSet.toString());
					setsArray.add(newSet);

				}

			}
			if (x == 3) { // get the intesection between 2 sets and add the set
							// to the sets array
				if (setsArray.size() < 2) {
					System.out.println("there are not enaugh sets");
				} else {
					System.out.println("type the name of the two sets :");
					System.out.println("--------------------------------");
					System.out.println("Set 1 number = ");
					int s1 = in.nextInt();
					System.out.println("Set 2 number = ");
					int s2 = in.nextInt();
					if (s1 < setsArray.size() && s2 < setsArray.size()) {
						Set newSet = setsArray.get(s1).getIntesectionWith(
								setsArray.get(s2));
						setsArray.add(newSet);
						System.out.println("Intersection = " + newSet);
					} else {
						System.out.println("out of bound");
					}

				}
			}
			if (x == 4) {// get the union between 2 sets and add the set to the
							// sets array
				if (setsArray.size() < 2) {
					System.out.println("there are not enaugh sets");
				} else {
					System.out.println("type the name of the two sets :");
					System.out.println("-------------------------------");

					System.out.println("Set 1 number = ");
					int s1 = in.nextInt();
					System.out.println("Set 2 number = ");
					int s2 = in.nextInt();
					if (s1 < setsArray.size() && s2 < setsArray.size()) {
						Set newSet = setsArray.get(s1).getUnionWith(
								setsArray.get(s2));
						setsArray.add(newSet);
						System.out.println("Union = " + newSet);
					} else {
						System.out.println("out of bound");
					}

				}

			}
			if (x == 5) {// get the complement of the set add it to the sets
							// array
				if (setsArray.size() < 1) {
					System.out.println("there are not enaugh sets");
				} else {
					System.out.println("type the set");
					System.out.println("The set number = ");
					int s1 = in.nextInt();
					if (s1 < setsArray.size()) {
						Set newSet = setsArray.get(s1).getComplementWith(
								universe);
						setsArray.add(newSet);
						System.out.println("Complement = " + newSet);
					} else {
						System.out.println("out of bound");
					}
				}
			}
			if (x == 6) { // exit the program
				return;
			}

		}
	}
}
