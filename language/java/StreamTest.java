package language.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,2,3);

        arr.stream().filter(integer -> integer==3).map(integer -> integer * 6).reduce((i,j)-> i);

        
    }
}
