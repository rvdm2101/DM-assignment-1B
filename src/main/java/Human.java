import java.util.ArrayList;
import java.util.List;

public class Human implements Sentient {
    List<Sentient> likeList = new ArrayList<>();
    String identity;

    public Human(String identity) {
        this.identity = identity;
    }

    @Override
    public boolean likes(Sentient other) {
        return likeList.contains(other);
    }

    @Override
    public void setLikes(Sentient other) {
        // If other isn't in the like list, add it
        if (!this.likes(other)) {
            likeList.add(other);
        }
    }

    @Override
    public String getIdentity() {
        return identity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;

        Human human = (Human) o;

        return getIdentity().equals(human.getIdentity());
    }

    @Override
    public int hashCode() {
        return getIdentity().hashCode();
    }
}
