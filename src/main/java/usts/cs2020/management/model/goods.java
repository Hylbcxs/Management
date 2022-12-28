package usts.cs2020.management.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "expenses")
public class goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private String data;
    private String amount;
    private String goodspicture;
    private String receipt;
    private String acceptor;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getGoodspicture() {
        return goodspicture;
    }

    public void setGoodspicture(String goodspicture) {
        this.goodspicture = goodspicture;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(String acceptor) {
        this.acceptor = acceptor;
    }

    @Override
    public String toString() {
        return "goods{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", data='" + data + '\'' +
                ", amount='" + amount + '\'' +
                ", goodspicture='" + goodspicture + '\'' +
                ", receipt='" + receipt + '\'' +
                ", acceptor='" + acceptor + '\'' +
                '}';
    }
}
