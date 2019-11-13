package Model;

public enum Habitats {
    Forrest(0),
    Grasslands(1),
    Wetlands(2);

    private int value;

    Habitats(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
