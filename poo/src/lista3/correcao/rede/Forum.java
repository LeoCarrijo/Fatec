package lista3.correcao.rede;

import java.util.List;

public class Forum {
    private int id;
    private String name, url;
    private List<Message> mensagens;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Message> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Message> mensagens) {
        this.mensagens = mensagens;
    }

    public Forum(int id, String name, String url, List<Message> mensagens) {
        this.setId(id);
        this.setName(name);
        this.setUrl(url);
        this.setMensagens(mensagens);
    }
}
