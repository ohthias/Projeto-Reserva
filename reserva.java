/**Classe para reserva de passagens de voos
 * @author Matheus Gabriel
 *         Emilly Dantas
 *         Gabrielly de Moraes
 * @version 1.3
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Reserva {
    private String nomePassageiro;
    private String destino;
    private String hora;
    private String data;

    Scanner sc = new Scanner(System.in);

    /* Método construtor da classe */
    public Reserva(String nomePassageiro, String destino, String hora, String data) {
        setNomePassageiro(nomePassageiro);
        setDestino(destino);
        setHora(hora);
        setData(data);
    }

    /* Método de invocação geral da classe */
    public void iniciar() {
        if (loginUsuario() == true) {
            menu();
        } else {
            System.out.println("Cadastro inválido");
        }
    }

    /* Método de espera de processos, ou pausas rápidas entre ações */
    public void carregando(int time) {
        System.out.println("Carregando... \n");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    /** Método de acesso inicial ao sistema da classe
     * @return boolean - loginUsuario*/
    public boolean loginUsuario() {
        System.out.print("=== Seja bem-vindo ao Reserva de Voos ===\n" +
                "- Digite o seu nome\n");
        String nomeUsuario = sc.nextLine();
        System.out.println("- Digite sua senha: ");
        double senhaUsuario = sc.nextDouble();

        System.out.println("Seja bem vindo " + nomeUsuario);
        carregando(1000);

        return true;
    }

    /* Método de exibição do menu principal */
    public void menuExibir() {
        System.out.println("\t === RESERVA  DE VOOS ===\n" +
                "\r 1) Comprar Passagem \n" +
                "\r 2) Exibir Passagem \n" +
                "\r 3) Sair \n");
    }

    /* Método de exibição do menu de aeroportos para escolha no método aeroporto() */
    public void exbirMenuAeroportos() {
        System.out.println("\t === AEROPORTOS ===\n" +
                "\r 1) Guarulhos \n" +
                "\r 2) Congonhas \n" +
                "\r 3) Campinas \n");

    }

    /** Método de invocação do menu principal */
    public void menu() {
        boolean continuar = true;
        /* Valor usado no laço de repetição */
        do {
            menuExibir();
            int opcMenu = sc.nextInt();
            /* Escolha de opção do menu que redireciona para uma outra ação*/

            carregando(1000);
            switch (opcMenu) {
                case 1:
                    comprarPassagem();
                    break;

                case 2:
                    exibirInformacoes();
                    break;

                case 3:
                    System.out.println("Obrigado por comprar conosco\n");
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

    /** Método de exibição das informações da reserva feita*/
    public void exibirInformacoes() {
        Random idReserva = new Random();
        int reserva = idReserva.nextInt(9000) + 1000;
        /* Número gerado aleatórimente de 4 digítos utilizado para mostrar o id da reserva que foi gerado */

        /* Enquanto não houver um passageiro para um voo, ou um destino, não é exibido a reserva feito. */
        if (getNomePassageiro() == null || getDestino() == null) {
            System.out.println("Não existe nenhum voo reservado. tente reservar algum voo.");
        } else {
            System.out.println("\t === RESERVA ===\n" +
                    "\r ID de reserva: " + reserva + "\n" +
                    "\r Nome: " + getNomePassageiro() + "\n" +
                    "\r Destino: " + getDestino() + "\n" +
                    "\r Hora: " + getHora() + "\n" +
                    "\r Data: " + getData() + "\n");
        }
    }

    /** Método de escolha de aeroporto
     * @param opcAeroporto int - aeroporto escolhido para fazer o embarque*/
    public void exibirAeroportos(int opcAeroporto) {
        String escolhaAeroporto = " ";
        if (opcAeroporto == 1) {
            escolhaAeroporto = "Guarulhos";
            carregando(1000);
            aeroporto(escolhaAeroporto, "GRU");
        } else if (opcAeroporto == 2) {
            escolhaAeroporto = "Congonhas";
            carregando(1000);
            aeroporto(escolhaAeroporto, "CON");
        } else if (opcAeroporto == 3) {
            escolhaAeroporto = "Campinas";
            carregando(1000);
            aeroporto(escolhaAeroporto, "CAM");
        }
    }

    /** Método de criação de escolha de um destino que não tem em mente, 
     * juntamente com um aeroporto que deseja embarcar
     * @param escolhido String - Escolha do aeroporto selecionado
     * @param sigla String - Sigla do aeroporto usada no Arraylist e na exibição do destino*/
    public void aeroporto(String escolhido, String sigla) {
        String[] voos = { sigla + "-> Penha/SC", sigla + "-> Fortaleza", sigla + "-> RJ", sigla + "-> Gramado" };
        ArrayList<String> vooReserva = new ArrayList<String>(Arrays.asList(voos));

        System.out.println("Temos a seguinte opções para o aeroporto de " + escolhido);
        /* Geração da lista de voos disponiveis no aeroporto escolhido pelo terminal */
        for (int i = 0; i < vooReserva.size(); i++) {
            System.out.println((i + 1) + ") " + vooReserva.get(i));
        }

        System.out.println("\nDigite o voo escolhido");
        int escVoo = sc.nextInt();

        if (escVoo == 1) {
            setDestino(sigla + "-> Penha/SC");
            carregando(500);
            infoCompraPassagem();
        } else if (escVoo == 2) {
            setDestino(sigla + "-> Fortaleza");
            carregando(500);
            infoCompraPassagem();
        } else if (escVoo == 3) {
            setDestino(sigla + "-> RJ");
            carregando(500);
            infoCompraPassagem();
        } else if (escVoo == 4) {
            setDestino(sigla + "-> Gramado");
            carregando(500);
            infoCompraPassagem();
        } else {
            System.out.println("Destino não informado. Encerrando processo de compra.");
        }
    }

    /** Método de compra de passagens*/
    public void comprarPassagem() {
        System.out.println("Comprando passagem... \n"
                + "Tem algum destino em mente? \n"
                + "1) Sim \n"
                + "2) Não \n");
        int respostaCompra = sc.nextInt();

        if (respostaCompra == 1) {
            System.out.println("Qual o destino em mente?");
            String destino = sc.next();

            Random aeroportoRandom = new Random();
            int aeroportoSorteado = aeroportoRandom.nextInt(3);
            /* Aeroporto sorteado para o embarque do voo que está fazendo a reserva */
            if (aeroportoSorteado == 1 || aeroportoSorteado == 0) {
                String destinoSintaxe = ("GRU -> " + destino);
                setDestino(destinoSintaxe);
                infoCompraPassagem();
            } else if (aeroportoSorteado == 2) {
                String destinoSintaxe = ("CON -> " + destino);
                setDestino(destinoSintaxe);
                infoCompraPassagem();
            } else if (aeroportoSorteado == 3) {
                String destinoSintaxe = ("CAM -> " + destino);
                setDestino(destinoSintaxe);
                infoCompraPassagem();
            } else {
                infoCompraPassagem();
            }
        } else if (respostaCompra == 2) {
            carregando(1000);
            exbirMenuAeroportos();
            System.out.println("Escolha um aeroporto: ");
            int opcAeroporto = sc.nextInt();
            exibirAeroportos(opcAeroporto);
        } else {
            System.out.println("Destino não informado. Encerrando processo de compra.");
        }
    }

    /** Método de informações da compra de passagem */
    public void infoCompraPassagem() {
        System.out.println("Digite o nome do passageiro: ");
        String nome = sc.next();
        setNomePassageiro(nome);
        carregando(1500);

        Random idData = new Random();
        int dataRandom = idData.nextInt(12);
        Random idHora = new Random();
        int horaRandom = idHora.nextInt(24);
        String newData = (((dataRandom + 1 < 10) ? "0" + (dataRandom + 1) : (dataRandom + 1)) + "/"
                + ((dataRandom < 10) ? "0" + (dataRandom) : (dataRandom)) + "/2024");

        String newHorario = (((horaRandom + 1 < 10) ? "0" + (horaRandom + 1) : (horaRandom + 1)) + ":"
                + ((horaRandom < 10) ? "0" + horaRandom : horaRandom));
        System.out.println("A data de sua viagem é " + newData + " às " + newHorario);
        setData(newData);
        setHora(newHorario);

        carregando(1500);
        exibirInformacoes();
        carregando(1500);
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