import java.util.ArrayList;

public class Set {
	
	private ArrayList<String> elements;
	
	public Set() {
		elements = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		String s= ""+ elements;
		s=s.replace("{", "");
		s=s.replace("}", "");
		s="{ "+s+" }";
		s=s.replace("[", "");
		s=s.replace("]", "");
		return s;
	}
	
	public String toStringNotComp(){
		String s= ""+ elements;
		s=s.replace("{", "");
		s=s.replace("}", "");
		s="{ "+s;
		s=s.replace("[", "");
		s=s.replace("]", "");
		return s;
	}

	public ArrayList<String> getElements() {
		return elements;
	}

	public void clearSet() {
		this.elements.clear();
	}
	public void AddElemet(String x) {
		if (!elements.contains(x))
			elements.add(x);
	}

	public Set getIntesectionWith(Set x) {
		Set intersection = new Set();
		for (int i = 0; i < x.getElements().size(); i++) {
			for (int j = 0; j < elements.size(); j++) {
				if (x.getElements().get(i).equals(elements.get(j))) {
					intersection.AddElemet(elements.get(j));
				}
			}

		}
		return intersection;
	}

	public Set getUnionWith(Set x) {
		Set union = new Set();
		for (int i = 0; i < elements.size(); i++) {
			union.AddElemet(elements.get(i));
		}
		for (int i = 0; i < x.getElements().size(); i++) {
			boolean intersection = false;
			for (int j = 0; j < elements.size(); j++) {
				if (x.getElements().get(i).equals(elements.get(j))) {
					intersection = true;
					break;
				}
			}
			if (!intersection)
				union.AddElemet(x.getElements().get(i));
		}
		return union;
	}

	public Set getComplementWith(Set x) {
		Set comp = new Set();
		for (int i = 0; i < x.getElements().size(); i++) {
			boolean BS=true;
			for (int j = 0; j < elements.size(); j++) {
				if (x.getElements().get(i).equals(elements.get(j))) {
					BS=false;
					break;
				}

			}
			if (BS){
				comp.AddElemet(x.getElements().get(i));
			}

		}
		return comp;
	}

}
