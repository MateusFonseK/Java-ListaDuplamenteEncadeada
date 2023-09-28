public class Main {
    public static void main(String[] args) {
        ListaDE lista = new ListaDE();

        System.out.println("Lista Vazia: " + lista.vazia());
        System.out.println("Tamanho da Lista: " + lista.tamanho());

        lista.insere(1, 1);
        lista.insere(2, 2);
        lista.insere(3, 3);

        System.out.println("\nElemento na posição 2: " + lista.elemento(2));
        System.out.println("Posição do elemento 1: " + lista.posicao(1));

        lista.insere(2, 25);
        lista.remove(1);

        System.out.println("\nElemento na posição 1: " + lista.elemento(1));
        System.out.println("Tamanho da Lista: " + lista.tamanho());


        System.out.println("\nElementos da Lista:");
        for (int i = 1; i <= lista.tamanho(); i++) {
            System.out.print(lista.elemento(i) + " ");
        }
        System.out.println();
    }
}