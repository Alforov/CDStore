package ua.org.oa.model;

import javax.persistence.*;

@Entity
@Table(name = "disc")
public class Disc {
	@Id
	@GeneratedValue
	private int id;

	private String name;
	@ManyToOne
	private Type type;

	@ManyToOne
	private Genre genre;

	@Lob
	@Column(name = "BOOK_IMAGE", nullable = true, columnDefinition = "mediumblob")
	private byte[] image;

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disc other = (Disc) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disk [id=" + id + ", name=" + name + ", type=" + type
				+ ", genre=" + genre + "]";
	}

}
