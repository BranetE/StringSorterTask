package sample;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 *
 * Implement in single class.
 */
public class StringSorter {
    /**
     * The StringSorter class defines the contract for sorting strings based on
     * alphabetical order while skipping words that start with a specific prefix.
     *
     * Example:
     *  Input: ["apple", "banana", "grape", "avocado", "cherry"], Exception prefix: "a"
     *  Output: ["banana", "cherry", "grape", "avocado", "apple"]
     *
     *  Here, "banana", "cherry", and "grape" are sorted in alphabetical order
     *  whereas "avocado" and "apple" (that start with 'a') are sorted in reverse alphabetical order
     *  at the end of the list.
     */
    public List<String> sortStrings(List<String> unsortedStrings, String exceptionChar) {
        // your solution here
        if(exceptionChar.isBlank()){
            return unsortedStrings.stream()
                .sorted()
                .collect(Collectors.toList());
        }

        List<String> result = new ArrayList<>();
        List<String> withoutExceptionPrefix = unsortedStrings.stream()
                .filter(e -> (!e.startsWith(exceptionChar)))
                .sorted()
                .collect(Collectors.toList());
        List<String> withExceptionPrefix = unsortedStrings.stream()
                .filter(e -> (e.startsWith(exceptionChar)))
                .sorted((a, b) -> (b.compareTo(a)))
                .collect(Collectors.toList());

        result.addAll(withoutExceptionPrefix);
        result.addAll(withExceptionPrefix);

        return result;
    }
}
