import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CuentaCorrienteTest {

    @Test
    @DisplayName("Sacar dinero")
    void sacarDinero() {
        CuentaCorriente nuevaCuenta = new CuentaCorriente(2000, "Carlos", "1122", "35610495D");
        nuevaCuenta.sacarDinero(1000);
        assertEquals(1000, nuevaCuenta.getSaldo());
    }

    @ParameterizedTest
    @CsvSource({
            "2000, 1000, 1000",
            "1500, 500, 1000",
            "1000, 1000, 0",
            "500, 600, 500",
            "0, 100, 0"
    })
    void testSacarDinero(double saldoInicial, double cantidadARetirar, double saldoEsperado) {
        CuentaCorriente cuenta = new CuentaCorriente(saldoInicial, "Carlos", "1122", "35610495D");
        cuenta.sacarDinero(cantidadARetirar);
        assertEquals(saldoEsperado, cuenta.getSaldo());
    }

    @Test
    @DisplayName("Ingresar dinero")
    void ingresarDinero() {
        CuentaCorriente nuevaCuenta = new CuentaCorriente(2000, "Carlos", "1122", "35610495D");
        nuevaCuenta.ingresarDinero(1000);
        assertEquals(3000, nuevaCuenta.getSaldo());
    }

    @ParameterizedTest
    @CsvSource({
            "2000, 1000, 3000",
            "1500, 500, 2000",
            "1000, 1000, 2000",
            "500, 600, 1100",
            "0, 100, 100"
    })
    void testIngresarDinero(double saldoInicial, double cantidadAIngresar, double saldoEsperado) {
        CuentaCorriente cuenta = new CuentaCorriente(saldoInicial, "Carlos", "1122", "35610495D");
        cuenta.ingresarDinero(cantidadAIngresar);
        assertEquals(saldoEsperado, cuenta.getSaldo());
    }
}


