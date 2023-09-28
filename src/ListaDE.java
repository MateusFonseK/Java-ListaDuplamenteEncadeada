public class ListaDE {
    private No cabeca;
    private No cauda;
    private int tamanho;

    public ListaDE() {
        cabeca = null;
        cauda = null;
        tamanho = 0;
    }

    public boolean vazia() {
        if (tamanho == 0) return true;
        else return false;
    }

    public int tamanho() {
        return tamanho;
    }

    public int elemento(int pos) {
        No aux = cabeca;
        int cont = 1;
        if (vazia() || pos < 1 || pos > tamanho) return -1;
        while (cont < pos) {
            aux = aux.getProx();
            cont++;
        }
        return aux.getConteudo();
    }

    public int posicao(int conteudo) {
        No aux;
        int cont = 1;
        if (vazia()) return -1;
        aux = cabeca;

        while (aux != null) {
            if (aux.getConteudo() == conteudo) return cont;
            aux = aux.getProx();
            cont++;
        }
        return -1;
    }

    public boolean insere(int pos, int conteudo) {
        if (vazia() && pos != 1) return false;

        if (pos == 1) {
            return insereInicioLista(conteudo);
        }
        if (pos == tamanho + 1) {
            return insereFimLista(conteudo);
        } else {
            return insereMeioLista(pos, conteudo);
        }
    }

    private boolean insereInicioLista(int conteudo) {
        No novoNo = new No();
        novoNo.setConteudo(conteudo);
        novoNo.setProx(cabeca);
        novoNo.setAnt(null);

        if (vazia()) cauda = novoNo;
        else cabeca.setAnt(novoNo);

        cabeca = novoNo;
        tamanho++;
        return true;
    }

    private boolean insereFimLista(int conteudo) {
        No novoNo = new No();
        novoNo.setConteudo(conteudo);

        novoNo.setProx(null);
        novoNo.setAnt(cauda);
        cauda.setProx(novoNo);
        cauda = novoNo;
        tamanho++;
        return true;
    }

    private boolean insereMeioLista(int pos, int conteudo) {
        No novoNo = new No();
        No aux = cabeca;
        int cont = 1;
        novoNo.setConteudo(conteudo);

        while (cont < pos - 1 && aux != null) {
            aux = aux.getProx();
            cont++;
        }
        if (aux == null) return false;
        else {
            novoNo.setAnt(aux);
            novoNo.setProx(aux.getProx());
            aux.getProx().setAnt(novoNo);
            aux.setProx(novoNo);
            tamanho++;
            return true;
        }

    }

    public int remove(int pos) {
        if (vazia()) return -1;
        if (pos < 1 && pos > tamanho) return -1;
        if (pos == 1) return removeInicioLista();
        if (pos == tamanho && pos!=1) return removeFimLista();
        else return removeMeioLista(pos);
    }

    private int removeInicioLista() {
        if (tamanho == 1) {
            int conteudo = cabeca.getConteudo();
            cabeca=null;
            cauda=null;
            tamanho--;
            return conteudo;
        }
        else {
            int conteudo = cabeca.getConteudo();
            cabeca = cabeca.getProx();
            cabeca.setAnt(null);
            tamanho--;
            return conteudo;
        }
    }

    private int removeFimLista() {
        No aux = cauda;
        int conteudo = cauda.getConteudo();

        cauda = aux.getAnt();
        aux.getAnt().setProx(null);
        tamanho--;
        aux=null;
        return conteudo;
    }

    private int removeMeioLista(int pos) {
        No aux = cabeca;
        int cont = 1;

        while (cont<pos && aux!=null){
            aux=aux.getProx();
            cont++;
        }
        if (aux==null)return -1;

        int conteudo = aux.getConteudo();

        aux.getAnt().setProx(aux.getProx());
        aux.getProx().setAnt(aux.getAnt());
        aux = null;
        tamanho--;
        return conteudo;
    }

}
