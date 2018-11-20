package com.lyj.web.async;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @auther lyj
 * @date 2018/11/20 0020 下午 16:01
 */
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    private Logger logger= LoggerFactory.getLogger(getClass());
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        new Thread(()->{
            while (true){
                if(StringUtils.isNotBlank(mockQueue.getCompleteOrder())){
                    String orderNumber =mockQueue.getCompleteOrder();
                    logger.info("返回订单处理结果集："+orderNumber);
                    deferredResultHolder.getMap().get(orderNumber).setResult("place order success");
                    mockQueue.setCompleteOrder(null);
                }else
                    try{


                        Thread.sleep(100);
                    }catch (Exception e){

                    }
            }

        }).start();

    }

}
