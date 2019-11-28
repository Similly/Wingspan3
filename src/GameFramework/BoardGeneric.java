package GameFramework;

import java.util.Objects;

public class BoardGeneric {
	
	protected int width; 
	protected int height; 
	private String name;
	
	public BoardGeneric() {
		width=0;
		height=0;
		name="";
	}
	
	public BoardGeneric(int w, int h, String n) {
		this.height=h; 
		this.width=w;
		this.name=n;		
		
	}
	
	public int getWidth() {
        return width;
    }

    public void setWidth(int w) {
        this.width=w;
    }
    
    public int getHeight() {
        return height;
    }

    public void setHeight(int h) {
        this.height=h;
    }
    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name=n;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardGeneric board = (BoardGeneric) o;
        return name == board.name &&
                height == board.height &&
                width == board.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, name);
    }

    @Override
    public String toString() {
        return "Board{" +
                "width=" + width +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
