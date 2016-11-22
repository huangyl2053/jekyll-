/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.xml;

import javax.xml.bind.annotation.XmlElement;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBM20113AttachToBsBeanエンティティです。
 *
 * @reamsid_L DBU-4880-100 dingyi
 */
public class DBM20113AttachToBsBeanEntity {

    private RString recordIdentificationNumber;

    private RString integratedAddressNumber;

    private RString systemShikibetsuCode;

    private RString shikibetsuCode;

    private RString kojinNo;

    private RString specificPersonalInformationCode;

    private RString dataSetIdentificationItemCode;

    private RString dataSetRecordKey;

    private RString spiMajorVersion;

    private RString parentDataSetRecordKey;

    private RString publicationDate;

    private RString publishedEndDate;

    private RString administrativeRegionCode;

    private RString duplicateCopyData;

    /**
     * システム識別コードの値を取得します。
     *
     * @return システム識別コード
     *
     */
    public RString getSystemShikibetsuCode() {
        return systemShikibetsuCode;
    }

    /**
     * システム識別コードの値を設定します。
     *
     * @param systemShikibetsuCode システム識別コード
     *
     */
    @XmlElement(name = "SystemShikibetsuCode", nillable = true)
    public void setSystemShikibetsuCode(RString systemShikibetsuCode) {
        this.systemShikibetsuCode = systemShikibetsuCode;
    }

    /**
     * 識別コードの値を取得します。
     *
     * @return 識別コード
     *
     */
    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードの値を設定します。
     *
     * @param shikibetsuCode 識別コード
     *
     */
    @XmlElement(name = "ShikibetsuCode", nillable = true)
    public void setShikibetsuCode(RString shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 個人番号の値を取得します。
     *
     * @return 個人番号
     *
     */
    public RString getKojinNo() {
        return kojinNo;
    }

    /**
     * 個人番号の値を設定します。
     *
     * @param kojinNo 個人番号
     *
     */
    @XmlElement(name = "KojinNo", nillable = true)
    public void setKojinNo(RString kojinNo) {
        this.kojinNo = kojinNo;
    }

    /**
     * レコード識別番号の値を取得します。
     *
     * @return レコード識別番号
     *
     */
    public RString getRecordIdentificationNumber() {
        return recordIdentificationNumber;
    }

    /**
     * レコード識別番号の値を設定します。
     *
     * @param recordIdentificationNumber レコード識別番号
     *
     */
    @XmlElement(name = "RecordIdentificationNumber", required = true, nillable = true)
    public void setRecordIdentificationNumber(RString recordIdentificationNumber) {
        this.recordIdentificationNumber = recordIdentificationNumber;
    }

    /**
     * 団体内統合宛名番号の値を取得します。
     *
     * @return 団体内統合宛名番号
     *
     */
    public RString getIntegratedAddressNumber() {
        return integratedAddressNumber;
    }

    /**
     * 団体内統合宛名番号の値を設定します。
     *
     * @param integratedAddressNumber 団体内統合宛名番号
     *
     */
    @XmlElement(name = "IntegratedAddressNumber", required = true, nillable = true)
    public void setIntegratedAddressNumber(RString integratedAddressNumber) {
        this.integratedAddressNumber = integratedAddressNumber;
    }

    /**
     * 特定個人情報名コードの値を取得します。
     *
     * @return 特定個人情報名コード
     *
     */
    public RString getSpecificPersonalInformationCode() {
        return specificPersonalInformationCode;
    }

    /**
     * 特定個人情報名コードの値を設定します。
     *
     * @param specificPersonalInformationCode 特定個人情報名コード
     *
     */
    @XmlElement(name = "SpecificPersonalInformationCode", required = true, nillable = true)
    public void setSpecificPersonalInformationCode(RString specificPersonalInformationCode) {
        this.specificPersonalInformationCode = specificPersonalInformationCode;
    }

    /**
     * データセットの識別項目コードの値を取得します。
     *
     * @return データセットの識別項目コード
     *
     */
    public RString getDataSetIdentificationItemCode() {
        return dataSetIdentificationItemCode;
    }

    /**
     * データセットの識別項目コードの値を設定します。
     *
     * @param dataSetIdentificationItemCode データセットの識別項目コード
     *
     */
    @XmlElement(name = "DataSetIdentificationItemCode", required = true, nillable = true)
    public void setDataSetIdentificationItemCode(RString dataSetIdentificationItemCode) {
        this.dataSetIdentificationItemCode = dataSetIdentificationItemCode;
    }

    /**
     * データセットレコードのキーの値を取得します。
     *
     * @return データセットレコードのキー
     *
     */
    public RString getDataSetRecordKey() {
        return dataSetRecordKey;
    }

    /**
     * データセットレコードのキーの値を設定します。
     *
     * @param dataSetRecordKey データセットレコードのキー
     *
     */
    @XmlElement(name = "DataSetRecordKey", nillable = true)
    public void setDataSetRecordKey(RString dataSetRecordKey) {
        this.dataSetRecordKey = dataSetRecordKey;
    }

    /**
     * 特定個人情報の版番号の値を取得します。
     *
     * @return 特定個人情報の版番号
     *
     */
    public RString getSPIMajorVersion() {
        return spiMajorVersion;
    }

    /**
     * 特定個人情報の版番号の値を設定します。
     *
     * @param spiMajorVersion 特定個人情報の版番号
     *
     */
    @XmlElement(name = "SPIMajorVersion", required = true, nillable = true)
    public void setSPIMajorVersion(RString spiMajorVersion) {
        this.spiMajorVersion = spiMajorVersion;
    }

    /**
     * 親データセットのレコードキーを取得します。
     *
     * @return 親データセットのレコードキー
     *
     */
    public RString getParentDataSetRecordKey() {
        return parentDataSetRecordKey;
    }

    /**
     * 親データセットのレコードキーを設定します。
     *
     * @param parentDataSetRecordKey 親データセットのレコードキー
     *
     */
    @XmlElement(name = "ParentDataSetRecordKey", nillable = true)
    public void setParentDataSetRecordKey(RString parentDataSetRecordKey) {
        this.parentDataSetRecordKey = parentDataSetRecordKey;
    }

    /**
     * 公開開始日の値を取得します。
     *
     * @return 公開開始日
     *
     */
    public RString getPublicationDate() {
        return publicationDate;
    }

    /**
     * 公開開始日の値を設定します。
     *
     * @param publicationDate 公開開始日
     *
     */
    @XmlElement(name = "PublicationDate", nillable = true)
    public void setPublicationDate(RString publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     * 公開終了日の値を取得します。
     *
     * @return 公開終了日
     *
     */
    public RString getPublishedEndDate() {
        return publishedEndDate;
    }

    /**
     * 公開終了日の値を設定します。
     *
     * @param publishedEndDate 公開終了日
     *
     */
    @XmlElement(name = "PublishedEndDate", nillable = true)
    public void setPublishedEndDate(RString publishedEndDate) {
        this.publishedEndDate = publishedEndDate;
    }

    /**
     * 行政区コードの値を取得します。
     *
     * @return 行政区コード
     *
     */
    public RString getAdministrativeRegionCode() {
        return administrativeRegionCode;
    }

    /**
     * 行政区コードの値を設定します。
     *
     * @param administrativeRegionCode 行政区コード
     *
     */
    @XmlElement(name = "AdministrativeRegionCode", nillable = true)
    public void setAdministrativeRegionCode(RString administrativeRegionCode) {
        this.administrativeRegionCode = administrativeRegionCode;
    }

    /**
     * 副本データの値を取得します。
     *
     * @return 副本データ
     *
     */
    public RString getDuplicateCopyData() {
        return duplicateCopyData;
    }

    /**
     * 副本データの値を設定します。
     *
     * @param duplicateCopyData 副本データ
     *
     */
    @XmlElement(name = "DuplicateCopyData", nillable = true)
    public void setDuplicateCopyData(RString duplicateCopyData) {
        this.duplicateCopyData = duplicateCopyData;
    }
}
