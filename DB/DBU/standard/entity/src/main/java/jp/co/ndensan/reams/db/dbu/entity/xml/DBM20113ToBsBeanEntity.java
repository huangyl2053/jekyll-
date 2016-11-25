/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * 特定個人情報ファイルのentityクラスです。
 *
 * @reamsid_L DBU-4880-100 dingyi
 */
public class DBM20113ToBsBeanEntity {

    private String requestSourceUnitCode;

    private String requestSourceUserID;

    private String attachedFileName;

    private String attachmentID;

    /**
     * requestSourceUnitCodeプロパティの値を取得します。
     *
     * @return possible object is {@link String }
     *
     */
    @XmlElement(name = "RequestSourceUnitCode", required = true, nillable = true)
    public String getRequestSourceUnitCode() {
        return requestSourceUnitCode;
    }

    /**
     * requestSourceUnitCodeプロパティの値を設定します。
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setRequestSourceUnitCode(String value) {
        this.requestSourceUnitCode = value;
    }

    /**
     * requestSourceUserIDプロパティの値を取得します。
     *
     * @return possible object is {@link String }
     *
     */
    @XmlElement(name = "RequestSourceUserID", required = true, nillable = true)
    public String getRequestSourceUserID() {
        return requestSourceUserID;
    }

    /**
     * requestSourceUserIDプロパティの値を設定します。
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setRequestSourceUserID(String value) {
        this.requestSourceUserID = value;
    }

    /**
     * attachedFileNameプロパティの値を取得します。
     *
     * @return possible object is {@link String }
     *
     */
    @XmlElement(name = "AttachedFileName", nillable = true)
    public String getAttachedFileName() {
        return attachedFileName;
    }

    /**
     * attachedFileNameプロパティの値を設定します。
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setAttachedFileName(String value) {
        this.attachedFileName = value;
    }

    /**
     * attachmentIDプロパティの値を取得します。
     *
     * @return possible object is {@link String }
     *
     */
    @XmlElement(name = "AttachmentID", nillable = true)
    public String getAttachmentID() {
        return attachmentID;
    }

    /**
     * attachmentIDプロパティの値を設定します。
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setAttachmentID(String value) {
        this.attachmentID = value;
    }
}
