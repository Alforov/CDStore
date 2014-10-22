package ua.org.oa.model;

import javax.persistence.*;


@Entity
@Table(name = "genre")
public class Genre {
	@Id
	@GeneratedValue
	private int id;

	private String genreName;

	@ManyToOne
	private Type type;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	@Override
	public String toString() {
		return "Genre [genreName=" + genreName + "]";
	}

}
