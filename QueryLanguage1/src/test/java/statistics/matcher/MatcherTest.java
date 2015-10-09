package statistics.matcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import statistics.Player;
import statistics.PlayerReader;
import statistics.Statistics;

public class MatcherTest {

    protected PlayerReader pr;
    protected Statistics stats;

    public MatcherTest() {
    }

    @Test
    public void testOr() {
        List<Player> matches = stats.matches(new Or(new PlaysIn("BBB"), new PlaysIn("CCC")));
        List<String> names = new ArrayList<>();
        matches.forEach((Player p) -> names.add(p.getName()));
        String[] toArray = names.toArray(new String[names.size()]);
        Arrays.sort(toArray);
        String[] expected = {"Eve", "Fred", "George"};
        assertEquals(expected.length, toArray.length);
        for (int i = 0; i < toArray.length; i++) {
            assertTrue(toArray[i].equals(expected[i]));
        }
    }

    @Test
    public void testHasFewerThan() {
        List<Player> matches = stats.matches(new HasFewerThan(30, "goals"));
        List<String> names = new ArrayList<>();
        matches.forEach((Player p) -> names.add(p.getName()));
        String[] toArray = names.toArray(new String[names.size()]);
        Arrays.sort(toArray);
        String[] expected = {"Charlie", "Dave", "George"};
        assertEquals(expected.length, toArray.length);
        for (int i = 0; i < toArray.length; i++) {
            assertTrue(toArray[i].equals(expected[i]));
        }
    }

    @Test
    public void testNot() {
        List<Player> matches = stats.matches(new Not(new PlaysIn("AAA"), new PlaysIn("CCC")));
        List<String> names = new ArrayList<>();
        matches.forEach((Player p) -> names.add(p.getName()));
        String[] toArray = names.toArray(new String[names.size()]);
        Arrays.sort(toArray);
        String[] expected = {"Eve", "Fred"};
        assertEquals(expected.length, toArray.length);
        for (int i = 0; i < toArray.length; i++) {
            assertTrue(toArray[i].equals(expected[i]));
        }
    }

    @Before
    public void setUp() {
        pr = new MockPlayerReader();
        stats = new Statistics(pr);
    }

    @After
    public void tearDown() {
    }

    protected class MockPlayerReader implements PlayerReader {

        private final List<Player> players;

        MockPlayerReader() {
            players = new ArrayList<>(7);
            players.add(new Player("Adam", "AAA", 100, 200));
            players.add(new Player("Bob", "AAA", 70, 140));
            players.add(new Player("Charlie", "AAA", 20, 40));
            players.add(new Player("Dave", "AAA", 10, 20));
            players.add(new Player("Eve", "BBB", 120, 240));
            players.add(new Player("Fred", "BBB", 40, 80));
            players.add(new Player("George", "CCC", 2, 4));
        }

        @Override
        public List<Player> getPlayers() {
            return players;
        }
    }

}
