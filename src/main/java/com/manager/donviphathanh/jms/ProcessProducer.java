package com.manager.donviphathanh.jms;

import com.manager.donviphathanh.service.dto.TienTrinhXuLyDTO;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProcessProducer {
    private static Logger log = LoggerFactory.getLogger(ProcessProducer.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void updateProcessing(TienTrinhXuLyDTO tienTrinhXuLyDTO) {
        //jmsTemplate.convertAndSend(queueName, demo);
        jmsTemplate.convertAndSend(new ActiveMQTopic(String.format("VirtualTopic.%s","PROCESS.UPDATED")), tienTrinhXuLyDTO);
    }
}
