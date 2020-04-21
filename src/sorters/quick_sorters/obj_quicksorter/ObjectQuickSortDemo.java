package sorters.quick_sorters.obj_quicksorter;

import java.util.Arrays;

public class ObjectQuickSortDemo {
    public static void main(String[] args) {

        String[] words = {"public", "assert", "false", "transient", "native",
                "boolean", "while", "break", "case", "char", "const",
                "continue", "default", "do", "implements", "double", "else", "enum",
                "extends",  "float", "goto", "for", "class", "static",
                "if", "import", "throw", "abstract", "instanceof", "int", "finally",
                "interface", "new", "package", "volatile", "synchronized",
                "protected", "byte", "final", "return", "short",
                "strictfp", "private", "super", "switch", "catch", "long",
                "this", "try", "void", "true", "null", "throws"};


        ObjectQuickSorter<String> stringQS = new ObjectQuickSorter<>();
        stringQS.quicksort(words);
        System.out.println(Arrays.toString(words));

        Integer[] integers = {19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        ObjectQuickSorter<Integer> integerQS = new ObjectQuickSorter<>();
        integerQS.quicksort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
