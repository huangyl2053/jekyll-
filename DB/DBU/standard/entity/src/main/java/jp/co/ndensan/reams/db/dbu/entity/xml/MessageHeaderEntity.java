/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定個人情報提供状況の取得要求ファイルのメッセージヘッダ部のentityクラスです。
 *
 * @reamsid_L DBU-4880-100 dingyi
 */
@XmlType(propOrder = {"msgId", "msgTypeId", "msgMode", "sourceSystemID", "destinationSystemID", "receptionNumber", "msgResult"})
public class MessageHeaderEntity {

    private RString msgId;
    private RString msgTypeId;
    private RString msgMode;
    private RString sourceSystemID;
    private RString destinationSystemID;
    private RString receptionNumber;
    private RString msgResult;

    /**
     * 電文メッセージIDを取得します。
     *
     * @return 電文メッセージID
     */
    @XmlElement(name = "MSGID", nillable = true)
    public RString getMsgId() {
        return msgId;
    }

    /**
     * 電文メッセージIDを設定します。
     *
     * @param msgId RString
     */
    public void setMsgId(RString msgId) {
        this.msgId = msgId;
    }

    /**
     * 電文種別IDを取得します。
     *
     * @return 電文種別ID
     */
    @XmlElement(name = "MSGTypeID", nillable = true)
    public RString getMsgTypeId() {
        return msgTypeId;
    }

    /**
     * 電文種別IDを設定します。
     *
     * @param msgTypeId RString
     */
    public void setMsgTypeId(RString msgTypeId) {
        this.msgTypeId = msgTypeId;
    }

    /**
     * 電文実行モードを取得します。
     *
     * @return 電文実行モード
     */
    @XmlElement(name = "MSGMode", nillable = true)
    public RString getMsgMode() {
        return msgMode;
    }

    /**
     * 電文実行モードを設定します。
     *
     * @param msgMode RString
     */
    public void setMsgMode(RString msgMode) {
        this.msgMode = msgMode;
    }

    /**
     * 送信元システム識別子を取得します。
     *
     * @return 送信元システム識別子
     */
    @XmlElement(name = "SourceSystemID", nillable = true)
    public RString getSourceSystemID() {
        return sourceSystemID;
    }

    /**
     * 送信元システム識別子を設定します。
     *
     * @param sourceSystemID RString
     */
    public void setSourceSystemID(RString sourceSystemID) {
        this.sourceSystemID = sourceSystemID;
    }

    /**
     * 送信先システム識別子を取得します。
     *
     * @return 送信先システム識別子
     */
    @XmlElement(name = "DestinationSystemID", nillable = true)
    public RString getDestinationSystemID() {
        return destinationSystemID;
    }

    /**
     * 送信先システム識別子を設定します。
     *
     * @param destinationSystemID RString
     */
    public void setDestinationSystemID(RString destinationSystemID) {
        this.destinationSystemID = destinationSystemID;
    }

    /**
     * 中間サーバー受付番号を取得します。
     *
     * @return 中間サーバー受付番号
     */
    @XmlElement(name = "ReceptionNumber", nillable = true)
    public RString getReceptionNumber() {
        return receptionNumber;
    }

    /**
     * 送信先システム識別子を設定します。
     *
     * @param receptionNumber RString
     */
    public void setReceptionNumber(RString receptionNumber) {
        this.receptionNumber = receptionNumber;
    }

    /**
     * 電文結果コードを取得します。
     *
     * @return 電文結果コード
     */
    @XmlElement(name = "MSGResult", nillable = true)
    public RString getMsgResult() {
        return msgResult;
    }

    /**
     * 電文結果コードを設定します。
     *
     * @param msgResult RString
     */
    public void setMsgResult(RString msgResult) {
        this.msgResult = msgResult;
    }

}
