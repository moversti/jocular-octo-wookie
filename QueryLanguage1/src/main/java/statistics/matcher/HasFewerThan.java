package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;

public class HasFewerThan implements Matcher {

    private final int value;
    private final String fieldName;
    private final String origCategoryParameter;

    public HasFewerThan(int value, String category) {
        this.value = value;
        origCategoryParameter = category;
        fieldName = "get" + Character.toUpperCase(category.charAt(0)) + category.substring(1, category.length());
    }

    @Override
    public boolean matches(Player p) {
        try {
            Method method = p.getClass().getMethod(fieldName);
            int playersValue = (Integer) method.invoke(p);
            return playersValue < value;
        } catch (Exception ex) {
            throw new IllegalStateException("Player does not have field " + origCategoryParameter);
        }
    }

}
