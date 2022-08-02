package test.mgs.models;

/**
 * test from "MGS.BET"
 * класс-сущность формирования ответов-сообщений
 *
 * @author Anton Shatkovskiy
 * created 02.08.2022
 */
public class ResponseMessage {
    private String content;

    public ResponseMessage(){}

    public ResponseMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
