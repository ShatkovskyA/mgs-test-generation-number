package test.mgs.controller;



import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import org.springframework.stereotype.Controller;


import org.springframework.web.util.HtmlUtils;
import test.mgs.models.OrderByNumbers;
import test.mgs.models.RequestMessage;
import test.mgs.models.ResponseMessage;


/**
 * test from "MGS.BET"
 * контроллер для отправки и получения сообщений
 *
 * @author Anton Shatkovskiy
 * created 01.08.2022
 */

@Controller
public class WSController {

    private OrderByNumbers orderByNumbers;

    @MessageMapping("/hello")
    @SendTo("/topic/hello")
    public ResponseMessage hello(RequestMessage requestMessage) {
        System.out.println ("Полученное сообщение:" + requestMessage);
        orderByNumbers = new OrderByNumbers(Integer.parseInt(requestMessage.getSize()));
        return new ResponseMessage (HtmlUtils.htmlEscape("Последовательность сгенерирована"));
    }

    @MessageMapping("/generate")
    @SendTo("/topic/result")
    public ResponseMessage generate() {
        return new ResponseMessage(HtmlUtils.htmlEscape(orderByNumbers.getGeneratedOrderByListOf(6).toString()));
    }

}
