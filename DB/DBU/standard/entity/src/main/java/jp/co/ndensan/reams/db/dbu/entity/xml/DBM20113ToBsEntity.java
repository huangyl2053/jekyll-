/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 特定個人情報ファイルのentityクラスです。
 *
 * @reamsid_L DBU-4880-100 dingyi
 */
@XmlRootElement(name = "IF_DBM_20113_R01")
public class DBM20113ToBsEntity {

    private MessageHeaderEntity messageHeader;

    private DBM20113ToBsBeanEntity messageBody;

    /**
     * messageHeaderプロパティの値を取得します。
     *
     * @return possible object is {@link MessageHeaderEntity }
     *
     */
    @XmlElement(name = "MessageHeader")
    public MessageHeaderEntity getMessageHeader() {
        return messageHeader;
    }

    /**
     * messageHeaderプロパティの値を設定します。
     *
     * @param value allowed object is {@link MessageHeaderEntity }
     *
     */
    public void setMessageHeader(MessageHeaderEntity value) {
        this.messageHeader = value;
    }

    /**
     * messageBodyプロパティの値を取得します。
     *
     * @return possible object is {@link DBM20113ToBsBeanEntity }
     *
     */
    @XmlElement(name = "MessageBody")
    public DBM20113ToBsBeanEntity getMessageBody() {
        return messageBody;
    }

    /**
     * messageBodyプロパティの値を設定します。
     *
     * @param value allowed object is {@link DBM20113ToBsBeanEntity }
     *
     */
    public void setMessageBody(DBM20113ToBsBeanEntity value) {
        this.messageBody = value;
    }

}
