import java.math.BigDecimal;

import model.Conta;

public class App {
    public static void main(String[] args) throws Exception {
        Conta c1 = new Conta("123A");
        c1.sacar(new BigDecimal("100"));
    }
}
