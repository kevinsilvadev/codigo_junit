package teste;

public class MyClass {
    public int quotient(int x, int y) throws IllegalAccessException {
            if(y==0) {
                throw new IllegalAccessException("Y cannoy be zero");
            }
            return  x/y;
    }
}
