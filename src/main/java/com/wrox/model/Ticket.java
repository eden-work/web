package com.wrox.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 票据类
 */
public class Ticket {

    private String customerName; // 客户名称

    private String subject; // 票据主题

    private String body; // 票据内容

    private Map<String, Attachment> attachments = new LinkedHashMap<>(); // 票据附件

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    /**
     * 根据附件的名称获取当前票据的附件
     * @param name 附件名称
     * @return  附件
     */
    public Attachment getAttachment(String name)
    {
        return this.attachments.get(name);
    }

    /**
     * 获取当前票据的所有附件
     * @return 附件集合
     */
    public Collection<Attachment> getAttachments()
    {
        return this.attachments.values();
    }

    /**
     * 把指定的附件放入map中，key为附件的name，value为附件对象
     * @param attachment 指定的附件
     */
    public void addAttachment(Attachment attachment)
    {
        this.attachments.put(attachment.getName(), attachment);
    }

    /**
     * 获取当前票据的附件数量
     * @return 附件的数量
     */
    public int getNumberOfAttachments()
    {
        return this.attachments.size();
    }

}
