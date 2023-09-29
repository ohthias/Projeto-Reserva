package Airplane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class reserva {
    private String nomePassageiro;
    private String destino;
    private String hora;
    private String data;

    String[] voosGru = { "GRU -> Penha/SC", "GRU -> Fortaleza", "GRU -> RJ", "GRU -> Gramado" };
    ArrayList<String> vooGru = new ArrayList<String>(Arrays.asList(voosGru));

    Random idReserva = new Random();
    int reserva = idReserva.nextInt(9999);
    Scanner sc = new Scanner(System.in);

    Random idData = new Random();
    int dataRandom = idData.nextInt(12);
    Random idHora = new Random();
    int horaRandom = idHora.nextInt(24);

    public reserva(String nomePassageiro, String destino, String hora, String data) {
        setNomePassageiro(nomePassageiro);
        setDestino(destino);
        setHora(hora);
        setData(data);
    }

    public void iniciar() {
        if (loginUsuario() == true) {
            menu();
        } else {
            System.out.println("Cadastro inválido");
        }
    }

    // Login
    public boolean loginUsuario() {
        System.out.print("=== Seja bem-vindo ao Reserva de Voos ===\n" +
                "- Digite o seu nome\n");
        String nomeUsuario = sc.nextLine();
        System.out.println("- Digite sua senha: ");
        double senhaUsuario = sc.nextDouble();

        System.out.println("Seja bem vindo " + nomeUsuario +
                "\n Aguarde... \n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        return true;
    }

    // Menu Principal
    public void menuExibir() {
        System.out.println("\t === RESERVA  DE VOOS ===\n" +
                "\r 1) Comprar Passagem \n" +
                "\r 2) Exibir Passagem \n" +
                "\r 3) Sair \n");
    }

    // Menu principal
    public void menu() {
        boolean continuar = true;
        do {
            menuExibir();
            int opcMenu = sc.nextInt();
            System.out.println("Carregando...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            switch (opcMenu) {
                case 1:
                    comprarPassagem();
                    break;

                case 2:
                    exibirInformacoes();
                    break;

                case 3:
                    System.out.println("Obrigado por comprar conosco");
                    continuar = false;
                    break;

                default:
                    try {
                        Thread.sleep(1000);
                        System.out.println("Está opção não é valida\n");
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                    break;
            }

        } while (continuar);
    }

    // Exibir Informações
    public void exibirInformacoes() {
        if (getNomePassageiro() == null) {
            System.out.println("Não existe nenhum voo agendado");
        } else {
            System.out.println("\t === RESERVA ===\n" +
                    "\r ID de reserva: " + reserva + "\n" +
                    "\r Nome: " + getNomePassageiro() + "\n" +
                    "\r Destino: " + getDestino() + "\n" +
                    "\r Hora: " + getHora() + "\n" +
                    "\r Data: " + getData() + "\n");
        }
    }

    // Comprar Passagem
    public void comprarPassagem() {
        System.out.println("Comprando passagem... \n"
                + "Tem algum destino em mente? \n"
                + "1) Sim \n"
                + "2) Não \n");
        int respostaCompra = sc.nextInt();

        if (respostaCompra == 1) {
            System.out.println("Digite seu nome do passageiro: ");
            String nome = sc.next();
            setNomePassageiro(nome);

            System.out.println("Digite seu destino: ");
            String destino = sc.next();
            setDestino(destino);

            String newData = (((dataRandom + 1 < 10) ? "0" + (dataRandom + 1) : (dataRandom + 1)) + "/"
                    + ((dataRandom < 10) ? "0" + (dataRandom) : (dataRandom)) + "/2024");

            String newHorario = (((horaRandom + 1 < 10) ? "0" + (horaRandom + 1) : (horaRandom + 1)) + ":"
                    + ((horaRandom < 10) ? "0" + horaRandom : horaRandom));
            System.out.println("A data de sua viagem é " + newData + " às " + newHorario);
            setData(newData);
            setHora(newHorario);

            System.out.println("Aguarde...");

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            exibirInformacoes();
        } else if (respostaCompra == 2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            System.out.println("Temos a seguinte opções para o aeroporto de Guarulhos");
            for (int i = 0; i < vooGru.size(); i++) {
                System.out.println((i + 1) + ") " + vooGru.get(i));
            }

            System.out.println("\nDigite o voo escolhido");
            int escVoo = sc.nextInt();

            if (escVoo == 1) {
                setDestino("GRU -> Penha/SC");
                infoCompraPassagem();
            } else if (escVoo == 2) {
                setDestino("GRU -> Fortaleza");
                infoCompraPassagem();
            } else if (escVoo == 3) {
                setDestino("GRU -> RJ");
                infoCompraPassagem();
            } else if (escVoo == 4) {
                setDestino("GRU -> Gramado");
                infoCompraPassagem();
            } else {
                System.out.println("Destino não informado. Encerrando processo de compra.");
            }
        } else {
            System.out.println("Destino não informado. Encerrando processo de compra.");
        }
    }

    // Informações de compra de passagem
    public void infoCompraPassagem() {
        System.out.println("Digite Seu Nome: ");
        String nome = sc.next();
        setNomePassageiro(nome);

        String newData = (((dataRandom + 1 < 10) ? "0" + (dataRandom + 1) : (dataRandom + 1)) + "/"
                + ((dataRandom < 10) ? "0" + (dataRandom) : (dataRandom)) + "/2024");

        String newHorario = (((horaRandom + 1 < 10) ? "0" + (horaRandom + 1) : (horaRandom + 1)) + ":"
                + ((horaRandom < 10) ? "0" + horaRandom : horaRandom));
        System.out.println("A data de sua viagem é " + newData + " às " + newHorario);
        setData(newData);
        setHora(newHorario);

        System.out.println("Aguarde...");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        exibirInformacoes();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }

    // Get & Sets
    public String getNomePassageiro() {
        return nomePassageiro;
    }

    public void setNomePassageiro(String nomePassageiro) {
        this.nomePassageiro = nomePassageiro;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}