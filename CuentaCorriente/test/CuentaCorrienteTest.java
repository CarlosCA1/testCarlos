import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaCorrienteTest {

    @Test
    @DisplayName("Sacar dinero")
    void sacarDinero() {
        CuentaCorriente nuevaCuenta = new CuentaCorriente(2000,"Carlos", "1122", "35610495D");
        assertEquals(1000, nuevaCuenta.sacarDinero(nuevaCuenta.getSaldo(), 1000));
    }

    @Test
    @DisplayName("Ingresar dinero")
    void ingresarDinero(){
        CuentaCorriente nuevaCuenta = new CuentaCorriente(2000, "Carlos", "1122", "35610495D");
        assertEquals(3000, nuevaCuenta.ingresarDinero(nuevaCuenta.getSaldo(), 1000));
    }
}

