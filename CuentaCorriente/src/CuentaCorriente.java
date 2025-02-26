public class CuentaCorriente {
    private double saldo;
    private String nombreTitular;
    private String numeroCuenta;
    private String nif;
    private static int contadorCuentas = 0;


    public CuentaCorriente (double saldo, String nombreTitular, String numeroCuenta, String nif) {
        setSaldo(saldo);
        this.nombreTitular=nombreTitular;
        this.numeroCuenta=numeroCuenta;
        setNif(nif);
        contadorCuentas++;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo>=0) this.saldo = saldo;
        else{
            this.saldo=0.0;
            System.out.println("El saldo no es válido");
        }

    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        char letraNif[] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};

        if (nif.length() == 9) {
            String numeros = nif.substring(0, 8);
            char letra = Character.toUpperCase(nif.charAt(8));
            int num = Integer.parseInt(numeros);
            char letraCalculada = letraNif[num % 23];

            if (letra == letraCalculada) {
                this.nif = nif;
                return;
            }
        }

        this.nif = "00000000T";
        System.out.println("El NIF es incorrecto");
    }

    public double sacarDinero(double cantidadARetirar) {
        if (cantidadARetirar <= saldo) {
            saldo -= cantidadARetirar;
        } else {
            System.out.println("Saldo insuficiente");
        }
        return saldo;
    }

    public double ingresarDinero(double cantidadAIngresar) {
        if (cantidadAIngresar > 0) {
            saldo += cantidadAIngresar;
        } else {
            System.out.println("Cantidad a ingresar no válida");
        }
        return saldo;
    }

    public String mostrarInformacion(){
        return "Saldo: " + saldo +"\n Nombre del titular: " + nombreTitular + "\n Número de cuenta: " + numeroCuenta + "\n NIF: " + nif;
    }
}