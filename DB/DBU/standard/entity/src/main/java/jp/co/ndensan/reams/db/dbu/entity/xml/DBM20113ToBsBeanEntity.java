/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.xml;

import javax.xml.bind.annotation.XmlElement;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定個人情報ファイルのentityクラスです。
 *
 * @reamsid_L DBU-4880-100 dingyi
 */
public class DBM20113ToBsBeanEntity {

    private RString requestSourceUnitCode;

    private RString requestSourceUserID;

    private RString attachedFileName;

    private RString attachmentID;

    /**
     * requestSourceUnitCodeプロパティの値を取得します。
     *
     * @return possible object is {@link RString }
     *
     */
    @XmlElement(name = "RequestSourceUnitCode", required = true, nillable = true)
    public RString getRequestSourceUnitCode() {
        return requestSourceUnitCode;
    }

    /**
     * requestSourceUnitCodeプロパティの値を設定します。
     *
     * @param value allowed object is {@link RString }
     *
     */
    public void setRequestSourceUnitCode(RString value) {
        this.requestSourceUnitCode = value;
    }

    /**
     * requestSourceUserIDプロパティの値を取得します。
     *
     * @return possible object is {@link RString }
     *
     */
    @XmlElement(name = "RequestSourceUserID", required = true, nillable = true)
    public RString getRequestSourceUserID() {
        return requestSourceUserID;
    }

    /**
     * requestSourceUserIDプロパティの値を設定します。
     *
     * @param value allowed object is {@link RString }
     *
     */
    public void setRequestSourceUserID(RString value) {
        this.requestSourceUserID = value;
    }

    /**
     * attachedFileNameプロパティの値を取得します。
     *
     * @return possible object is {@link RString }
     *
     */
    @XmlElement(name = "AttachedFileName", nillable = true)
    public RString getAttachedFileName() {
        return attachedFileName;
    }

    /**
     * attachedFileNameプロパティの値を設定します。
     *
     * @param value allowed object is {@link RString }
     *
     */
    public void setAttachedFileName(RString value) {
        this.attachedFileName = value;
    }

    /**
     * attachmentIDプロパティの値を取得します。
     *
     * @return possible object is {@link RString }
     *
     */
    @XmlElement(name = "AttachmentID", nillable = true)
    public RString getAttachmentID() {
        return attachmentID;
    }

    /**
     * attachmentIDプロパティの値を設定します。
     *
     * @param value allowed object is {@link RString }
     *
     */
    public void setAttachmentID(RString value) {
        this.attachmentID = value;
    }
}
