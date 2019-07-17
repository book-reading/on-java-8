// functional/LambdaExpressions.java

package functional;

interface Description {
    String brief();
}

interface Body {
    String detailed(String head);
}

interface Multi {
    String twoArg(String head, Double d);
}

/**
 * LambdaExpressions
 */
public class LambdaExpressions {
    static Body body = h -> h + " No Parens!";
    static Body body2 = h -> h + " More details";
    static Description desc = () -> "Short info";
    static Multi multi = (h, n) -> h + n;
    static Description moreLines = () -> {
        System.out.println("moreLines()");
        return "from moreLines";
    };

    public static void main(String[] args) {
        System.out.println(body.detailed("Oh!"));
        System.out.println(body2.detailed("Hi!"));
        System.out.println(desc.brief());
        System.out.println(multi.twoArg("Pi! ", 3.14159));
        System.out.println(moreLines.brief());
    }
}
