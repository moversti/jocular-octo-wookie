package statistics.matcher;

import java.util.Arrays;
import java.util.LinkedList;
import statistics.Player;

public class Or implements Matcher {

    private final LinkedList<Matcher> m;

    public Or(Matcher... matchers) {
        m = new LinkedList<>();
        m.addAll(Arrays.asList(matchers));
    }

    @Override
    public boolean matches(final Player p) {
        return m.stream().anyMatch(a -> a.matches(p));
    }

}
