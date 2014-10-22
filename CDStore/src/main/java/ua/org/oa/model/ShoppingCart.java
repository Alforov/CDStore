package ua.org.oa.model;

import java.util.HashSet;
import java.util.Set;

public class ShoppingCart {

	public Set<Disc> listDisc = new HashSet<Disc>();

	public void addDisc(Disc disc) {
		listDisc.add(disc);
	}

	public Set<Disc> getListDisc() {
		return listDisc;
	}

	public void setListDisc(Set<Disc> listDisc) {
		this.listDisc = listDisc;
	}

}
