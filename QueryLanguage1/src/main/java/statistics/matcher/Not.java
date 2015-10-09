package statistics.matcher;

import java.util.Arrays;
import java.util.LinkedList;
import statistics.Player;

public class Not implements Matcher {

    private final LinkedList<Matcher> m;

    public Not(Matcher... matchers) {
        m = new LinkedList<>();
        m.addAll(Arrays.asList(matchers));
    }

    @Override
    public boolean matches(Player p) {
        return m.stream().noneMatch(a -> a.matches(p));
    }

}
