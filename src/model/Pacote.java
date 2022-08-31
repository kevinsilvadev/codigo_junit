package model;

public class Pacote {

    //constantes
    //pre�os minimo e unitario
    final double PRECO_MIN_FIXO = 6.0d, PRECO_UNITARIO_A = 2.0d, PRECO_UNITARIO_B = 3.0d;

    //parametros de calculo (em kilos, para peso pacote)
    final double PARAM_PRECO_MIN = 2.0d, PARAM_LIMITE_UNITARIO_A_B = 20.d;

    //codigos de erros de dados de entrada
    final double COD_ERRO_PESO = -1, COD_ERRO_DESTINO = -2, COD_ERRO_TIPO_TRANSPORTE = -3, COD_ERRO_TIPO_ENTREGA = 4;

    char  destino, tipoTransporte, tipoEntrega;
    double peso;
    double valorFrete;

    //construtores
    public Pacote() {
    }

    public Pacote(char destino, char tipoTransporte, char tipoEntrega, double peso) {
        super();
        this.setDestino(destino);
        this.setTipoEntrega(tipoEntrega);
        this.setTipoTransporte(tipoTransporte);
        this.peso = peso;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public char getDestino() {
        return destino;
    }
    public void setDestino(char destino) {
        String aux = String.valueOf(destino);
        this.destino = aux.toUpperCase().charAt(0);
    }
    public char getTipoTransporte() {
        return tipoTransporte;
    }
    public void setTipoTransporte(char tipoTransporte) {
        String aux = String.valueOf(tipoTransporte);
        this.tipoTransporte = aux.toUpperCase().charAt(0);
    }
    public char getTipoEntrega() {
        return tipoEntrega;
    }
    public void setTipoEntrega(char tipoEntrega) {
        String aux = String.valueOf(tipoEntrega);
        this.tipoEntrega = aux.toUpperCase().charAt(0);
    }
    public double getValorFrete() {
        return valorFrete;
    }

    //m�todo que calcula o frete
    public double calcularFrete() {

        //verifica conssistencia dos dados de calculos e gera cod erro

        if (this.peso < 0)
            return this.COD_ERRO_PESO;

        if (this.tipoTransporte!='A' && this.tipoTransporte!='S')
            return this.COD_ERRO_TIPO_TRANSPORTE;

        if (this.tipoEntrega!='N' && this.tipoEntrega!='E' && this.tipoEntrega!=' ')
            return this.COD_ERRO_TIPO_ENTREGA;

        if (this.destino!='L' && this.destino!='F' && this.destino!=' ')
            return this.COD_ERRO_DESTINO;

        //sem erros nos dados, vamos processar
        double saida = 0;

        switch (this.tipoTransporte) {

            case 'a': //aereo
            case 'A':

                //pre�os saida em fun��o do peso
                if (this.peso <= this.PARAM_PRECO_MIN )
                    saida = PRECO_MIN_FIXO ;
                else if (this.peso <= this.PARAM_LIMITE_UNITARIO_A_B)
                    saida = this.peso * PRECO_UNITARIO_B;
                else saida = this.peso * PRECO_UNITARIO_A;

                break;

            case 'S':  //superficie
            case 's':

                switch (this.tipoEntrega){

                    case 'n':  //normal
                    case 'N': saida = this.peso * PRECO_UNITARIO_A; //sempre a mesma formula
                        break;
                    case 'E': //expressa
                    case 'e':

                        //verifica destino local ou fora local (Estado SP)
                        if (this.destino == 'L' || this.destino == 'l')
                            saida = this.peso * PRECO_UNITARIO_A; //sempre a mesma formula
                        else
                            //mas gera pre�o de sa�da em fun��o do peso
                            if (this.peso <= this.PARAM_LIMITE_UNITARIO_A_B)
                                saida = this.peso * PRECO_UNITARIO_B;
                            else saida = this.peso * PRECO_UNITARIO_A;
                        break;
                }//fim switch tipo-entrega

        }//fim switch tipo-transporte

        return (saida);

    }//fim do m�todo

    @Override
    public String toString() {
        return "Pacote{" +
                "PRECO_MIN_FIXO=" + PRECO_MIN_FIXO +
                ", PRECO_UNITARIO_A=" + PRECO_UNITARIO_A +
                ", PRECO_UNITARIO_B=" + PRECO_UNITARIO_B +
                ", PARAM_PRECO_MIN=" + PARAM_PRECO_MIN +
                ", PARAM_LIMITE_UNITARIO_A_B=" + PARAM_LIMITE_UNITARIO_A_B +
                ", COD_ERRO_PESO=" + COD_ERRO_PESO +
                ", COD_ERRO_DESTINO=" + COD_ERRO_DESTINO +
                ", COD_ERRO_TIPO_TRANSPORTE=" + COD_ERRO_TIPO_TRANSPORTE +
                ", COD_ERRO_TIPO_ENTREGA=" + COD_ERRO_TIPO_ENTREGA +
                ", destino=" + destino +
                ", tipoTransporte=" + tipoTransporte +
                ", tipoEntrega=" + tipoEntrega +
                ", peso=" + peso +
                ", valorFrete=" + valorFrete +
                '}';
    }
} //fim da classe