public class Moof implements Comparable{//Se agrego la interface para el TreeSet.

	private int moofValue;

	Moof(int val) {
		moofValue = val;
	}

	public int getMoofValue() {
		return moofValue;
	}

	public String toString(){
		return new String(Integer.toString(moofValue));
	}

	public boolean equals(Object obj){//Sobreescritura del metodo equals para HashSet, Tree y SetLinkedHashSet.
		if(obj instanceof Moof){
			Moof var=(Moof) obj;
			if(this.moofValue==var.moofValue){
				return true;
			}
		}
		return false;
	}

	public int hashCode(){//Sobreescritura del metodo equals para HashSet, TreeSet y LinkedHashSet.
		return moofValue*2;
	}

	public int compareTo(Object obj){//Sobreescritura del metodo equals para HashSet y TreeSet (Requiere interface Comparable).
		if(obj instanceof Moof){
			Moof val=(Moof)obj;
			if (val.moofValue>this.moofValue) {
				return 1;
			}else if(val.moofValue<this.moofValue){
				return -1;
			}
			else if (val.moofValue==this.moofValue){
				return 0;
			}
		}
		return 69;
	}
}