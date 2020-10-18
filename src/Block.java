import java.awt.*;
import java.util.Arrays;

public class Block {
    private String name;
    private Color color;
    private String description;
    private Block[][] time; // Every time array is 7 by 23. 7 days a week by 24 hours intervals a day

    Block(String name, Color color, String description, Block[][] time) {
        this.name = name;
        this.color = color;
        this.description = description;
        this.time = time;
    }

    public boolean equals(Object o) {
        if (this == null || o == null) {
            return false;
        }
        if (!(o instanceof Block)) {
            return false;
        } else {
            Block a = (Block) o;
            return name.equals(a.getName()) && color.equals(a.getColor()) && description.equals(a.getDescription())
            && Arrays.equals(time,a.getTime());
        }
    }


    public Block[][] getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Color getColor() {
        return color;
    }
}
