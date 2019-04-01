package task2.csp;

import java.util.HashMap;
import java.util.Map;

public class AssigmentFactory {
    private static final Map<Integer, Map<Variable, Assigment>> assigmentsCached = new HashMap<>();

    public static Assigment createAssigment(Integer value, Variable variable) {
        if (assigmentsCached.containsKey(value)) {
            Map<Variable, Assigment> nestedVariableMap = assigmentsCached.get(value);

            if (nestedVariableMap.containsKey(variable)) {
                return nestedVariableMap.get(variable);
            }
        }

        return assigmentsCached
                .computeIfAbsent(value, v -> new HashMap<>())
                .computeIfAbsent(variable, v -> new Assigment(value, variable));

    }
}
