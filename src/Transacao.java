import lombok.Getter;

import java.util.Date;


public class Transacao {

    @Getter private Date data;
    @Getter private String descricao;
    @Getter private double quantidade;

    public Transacao(Date data, String descricao, double quantidade) {
        this.data = data;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Data: " + data + ", Descrição: " + descricao + ", Quantia: " + quantidade;
    }
}
