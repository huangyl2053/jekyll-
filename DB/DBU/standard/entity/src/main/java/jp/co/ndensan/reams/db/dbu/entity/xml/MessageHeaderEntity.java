/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 特定個人情報提供状況の取得要求ファイルのメッセージヘッダ部のentityクラスです。
 *
 * @reamsid_L DBU-4880-100 dingyi
 */
@SuppressWarnings("checkstyle:illegaltype")
@XmlType(propOrder = {"msgId", "msgTypeId", "msgMode", "sourceSystemID", "destinationSystemID", "receptionNumber", "msgResult"})
public class MessageHeaderEntity {

    private String msgId;
    private String msgTypeId;
    private String msgMode;
    private String sourceSystemID;
    private String destinationSystemID;
    private String receptionNumber;
    private String msgResult;

    /**
     * 電文メッセージIDを取得します。
     *
     * @return 電文メッセージID
     */
    @XmlElement(name = "MSGID", nillable = true)
    public String getMsgId() {
        return msgId;
    }

    /**
     * 電文メッセージIDを設定します。
     *
     * @param msgId String
     */
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    /**
     * 電文種別IDを取得します。
     *
     * @return 電文種別ID
     */
    @XmlElement(name = "MSGTypeID", nillable = true)
    public String getMsgTypeId() {
        return msgTypeId;
    }

    /**
     * 電文種別IDを設定します。
     *
     * @param msgTypeId String
     */
    public void setMsgTypeId(String msgTypeId) {
        this.msgTypeId = msgTypeId;
    }

    /**
     * 電文実行モードを取得します。
     *
     * @return 電文実行モード
     */
    @XmlElement(name = "MSGMode", nillable = true)
    public String getMsgMode() {
        return msgMode;
    }

    /**
     * 電文実行モードを設定します。
     *
     * @param msgMode String
     */
    public void setMsgMode(String msgMode) {
        this.msgMode = msgMode;
    }

    /**
     * 送信元システム識別子を取得します。
     *
     * @return 送信元システム識別子
     */
    @XmlElement(name = "SourceSystemID", nillable = true)
    public String getSourceSystemID() {
        return sourceSystemID;
    }

    /**
     * 送信元システム識別子を設定します。
     *
     * @param sourceSystemID String
     */
    public void setSourceSystemID(String sourceSystemID) {
        this.sourceSystemID = sourceSystemID;
    }

    /**
     * 送信先システム識別子を取得します。
     *
     * @return 送信先システム識別子
     */
    @XmlElement(name = "DestinationSystemID", nillable = true)
    public String getDestinationSystemID() {
        return destinationSystemID;
    }

    /**
     * 送信先システム識別子を設定します。
     *
     * @param destinationSystemID String
     */
    public void setDestinationSystemID(String destinationSystemID) {
        this.destinationSystemID = destinationSystemID;
    }

    /**
     * 中間サーバー受付番号を取得します。
     *
     * @return 中間サーバー受付番号
     */
    @XmlElement(name = "ReceptionNumber", nillable = true)
    public String getReceptionNumber() {
        return receptionNumber;
    }

    /**
     * 送信先システム識別子を設定します。
     *
     * @param receptionNumber String
     */
    public void setReceptionNumber(String receptionNumber) {
        this.receptionNumber = receptionNumber;
    }

    /**
     * 電文結果コードを取得します。
     *
     * @return 電文結果コード
     */
    @XmlElement(name = "MSGResult", nillable = true)
    public String getMsgResult() {
        return msgResult;
    }

    /**
     * 電文結果コードを設定します。
     *
     * @param msgResult String
     */
    public void setMsgResult(String msgResult) {
        this.msgResult = msgResult;
    }

}
