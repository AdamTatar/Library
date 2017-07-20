package models;

public class Author {
	
	private Long id;
	private String name;
	private String born;
	private String skinColor;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBorn() {
		return born;
	}
	public void setBorn(String born) {
		this.born = born;
	}
	public String getSkinColor() {
		return skinColor;
	}
	public void setSkinColor(String skinColor) {
		this.skinColor = skinColor;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", born=" + born + ", skinColor=" + skinColor + "]";
	}
	public Author(Long id, String name, String born, String skinColor) {
		super();
		this.id = id;
		this.name = name;
		this.born = born;
		this.skinColor = skinColor;
	}
	public Author(String name, String born, String skinColor) {
		super();
		this.name = name;
		this.born = born;
		this.skinColor = skinColor;
	}
	
	

}
