/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.xml;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 特定個人情報ファイルのentityクラスです。
 *
 * @reamsid_L DBU-4880-100 dingyi
 */
@XmlRootElement(name = "SPIRegistrationDeleteList")
public class DBM20113AttachToBsEntity {

    private List<DBM20113AttachToBsBeanEntity> spiRegistrationDeleteList;

    private String segmentOfRegistrationDelete;

    /**
     * 特定個人情報登録削除情報の値を取得します。
     *
     * @return 特定個人情報登録削除情報
     *
     */
    public List<DBM20113AttachToBsBeanEntity> getInformationOfSPIRegistrationDelete() {
        return spiRegistrationDeleteList;
    }

    /**
     * 特定個人情報登録削除情報の値を設定します。
     *
     * @param spiRegistrationDeleteList 特定個人情報登録削除情報
     *
     */
    @XmlElement(name = "InformationOfSPIRegistrationDelete")
    public void setInformationOfSPIRegistrationDelete(List<DBM20113AttachToBsBeanEntity> spiRegistrationDeleteList) {
        this.spiRegistrationDeleteList = spiRegistrationDeleteList;
    }

    /**
     * 登録削除区分の値を取得します。
     *
     * @return 登録削除区分
     *
     */
    public String getSegmentOfRegistrationDelete() {
        return segmentOfRegistrationDelete;
    }

    /**
     * 登録削除区分の値を設定します。
     *
     * @param segmentOfRegistrationDelete 登録削除区分
     *
     */
    @XmlElement(name = "SegmentOfRegistrationDelete", nillable = true)
    public void setSegmentOfRegistrationDelete(String segmentOfRegistrationDelete) {
        this.segmentOfRegistrationDelete = segmentOfRegistrationDelete;
    }
}
