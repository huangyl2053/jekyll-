package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;

/**
 * DbT7011ShujiiIryoKikanJohoの項目定義クラスです
 *
 */
public class DbT7011ShujiiIryoKikanJohoEntity extends DbTableEntityBase<DbT7011ShujiiIryoKikanJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7011ShujiiIryoKikanJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private LasdecCode shichosonCode;
    @PrimaryKey
    private RString kaigoIryokikanCode;
    private RString iryokikanCode;
    private RString iryokikanJokyo;
    private RString iryoKikanMeisho;
    private RString iryoKikanMeishoKana;
    private YubinNo yubinNo;
    private RString jusho;
    private RString jushoKana;
    private TelNo telNo;
    private KinyuKikanCode ginkoCode;
    private KinyuKikanShitenCode shitenCode;
    private Code kozaShubetsu;
    private Code kozaNo;
    private RString kozaMeiginin;
    private RString kozaMeigininKana;
    private Code kikanKubunCode;

    /**
     * getInsertDantaiCd
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * setLastUpdateReamsLoginId
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getShichosonCode
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * getKaigoIryokikanCode
     * @return kaigoIryokikanCode
     */
    public RString getKaigoIryokikanCode() {
        return kaigoIryokikanCode;
    }

    /**
     * setKaigoIryokikanCode
     * @param kaigoIryokikanCode kaigoIryokikanCode
     */
    public void setKaigoIryokikanCode(RString kaigoIryokikanCode) {
        this.kaigoIryokikanCode = kaigoIryokikanCode;
    }

    /**
     * getIryokikanCode
     * @return iryokikanCode
     */
    public RString getIryokikanCode() {
        return iryokikanCode;
    }

    /**
     * setIryokikanCode
     * @param iryokikanCode iryokikanCode
     */
    public void setIryokikanCode(RString iryokikanCode) {
        this.iryokikanCode = iryokikanCode;
    }

    /**
     * getIryokikanJokyo
     * @return iryokikanJokyo
     */
    public RString getIryokikanJokyo() {
        return iryokikanJokyo;
    }

    /**
     * setIryokikanJokyo
     * @param iryokikanJokyo iryokikanJokyo
     */
    public void setIryokikanJokyo(RString iryokikanJokyo) {
        this.iryokikanJokyo = iryokikanJokyo;
    }

    /**
     * getIryoKikanMeisho
     * @return iryoKikanMeisho
     */
    public RString getIryoKikanMeisho() {
        return iryoKikanMeisho;
    }

    /**
     * setIryoKikanMeisho
     * @param iryoKikanMeisho iryoKikanMeisho
     */
    public void setIryoKikanMeisho(RString iryoKikanMeisho) {
        this.iryoKikanMeisho = iryoKikanMeisho;
    }

    /**
     * getIryoKikanMeishoKana
     * @return iryoKikanMeishoKana
     */
    public RString getIryoKikanMeishoKana() {
        return iryoKikanMeishoKana;
    }

    /**
     * setIryoKikanMeishoKana
     * @param iryoKikanMeishoKana iryoKikanMeishoKana
     */
    public void setIryoKikanMeishoKana(RString iryoKikanMeishoKana) {
        this.iryoKikanMeishoKana = iryoKikanMeishoKana;
    }

    /**
     * getYubinNo
     * @return yubinNo
     */
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * setYubinNo
     * @param yubinNo yubinNo
     */
    public void setYubinNo(YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    /**
     * getJusho
     * @return jusho
     */
    public RString getJusho() {
        return jusho;
    }

    /**
     * setJusho
     * @param jusho jusho
     */
    public void setJusho(RString jusho) {
        this.jusho = jusho;
    }

    /**
     * getJushoKana
     * @return jushoKana
     */
    public RString getJushoKana() {
        return jushoKana;
    }

    /**
     * setJushoKana
     * @param jushoKana jushoKana
     */
    public void setJushoKana(RString jushoKana) {
        this.jushoKana = jushoKana;
    }

    /**
     * getTelNo
     * @return telNo
     */
    public TelNo getTelNo() {
        return telNo;
    }

    /**
     * setTelNo
     * @param telNo telNo
     */
    public void setTelNo(TelNo telNo) {
        this.telNo = telNo;
    }

    /**
     * getGinkoCode
     * @return ginkoCode
     */
    public KinyuKikanCode getGinkoCode() {
        return ginkoCode;
    }

    /**
     * setGinkoCode
     * @param ginkoCode ginkoCode
     */
    public void setGinkoCode(KinyuKikanCode ginkoCode) {
        this.ginkoCode = ginkoCode;
    }

    /**
     * getShitenCode
     * @return shitenCode
     */
    public KinyuKikanShitenCode getShitenCode() {
        return shitenCode;
    }

    /**
     * setShitenCode
     * @param shitenCode shitenCode
     */
    public void setShitenCode(KinyuKikanShitenCode shitenCode) {
        this.shitenCode = shitenCode;
    }

    /**
     * getKozaShubetsu
     * @return kozaShubetsu
     */
    public Code getKozaShubetsu() {
        return kozaShubetsu;
    }

    /**
     * setKozaShubetsu
     * @param kozaShubetsu kozaShubetsu
     */
    public void setKozaShubetsu(Code kozaShubetsu) {
        this.kozaShubetsu = kozaShubetsu;
    }

    /**
     * getKozaNo
     * @return kozaNo
     */
    public Code getKozaNo() {
        return kozaNo;
    }

    /**
     * setKozaNo
     * @param kozaNo kozaNo
     */
    public void setKozaNo(Code kozaNo) {
        this.kozaNo = kozaNo;
    }

    /**
     * getKozaMeiginin
     * @return kozaMeiginin
     */
    public RString getKozaMeiginin() {
        return kozaMeiginin;
    }

    /**
     * setKozaMeiginin
     * @param kozaMeiginin kozaMeiginin
     */
    public void setKozaMeiginin(RString kozaMeiginin) {
        this.kozaMeiginin = kozaMeiginin;
    }

    /**
     * getKozaMeigininKana
     * @return kozaMeigininKana
     */
    public RString getKozaMeigininKana() {
        return kozaMeigininKana;
    }

    /**
     * setKozaMeigininKana
     * @param kozaMeigininKana kozaMeigininKana
     */
    public void setKozaMeigininKana(RString kozaMeigininKana) {
        this.kozaMeigininKana = kozaMeigininKana;
    }

    /**
     * getKikanKubunCode
     * @return kikanKubunCode
     */
    public Code getKikanKubunCode() {
        return kikanKubunCode;
    }

    /**
     * setKikanKubunCode
     * @param kikanKubunCode kikanKubunCode
     */
    public void setKikanKubunCode(Code kikanKubunCode) {
        this.kikanKubunCode = kikanKubunCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7011ShujiiIryoKikanJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7011ShujiiIryoKikanJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7011ShujiiIryoKikanJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.kaigoIryokikanCode, other.kaigoIryokikanCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7011ShujiiIryoKikanJohoEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.kaigoIryokikanCode = entity.kaigoIryokikanCode;
        this.iryokikanCode = entity.iryokikanCode;
        this.iryokikanJokyo = entity.iryokikanJokyo;
        this.iryoKikanMeisho = entity.iryoKikanMeisho;
        this.iryoKikanMeishoKana = entity.iryoKikanMeishoKana;
        this.yubinNo = entity.yubinNo;
        this.jusho = entity.jusho;
        this.jushoKana = entity.jushoKana;
        this.telNo = entity.telNo;
        this.ginkoCode = entity.ginkoCode;
        this.shitenCode = entity.shitenCode;
        this.kozaShubetsu = entity.kozaShubetsu;
        this.kozaNo = entity.kozaNo;
        this.kozaMeiginin = entity.kozaMeiginin;
        this.kozaMeigininKana = entity.kozaMeigininKana;
        this.kikanKubunCode = entity.kikanKubunCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, kaigoIryokikanCode, iryokikanCode, iryokikanJokyo, iryoKikanMeisho, iryoKikanMeishoKana, yubinNo, jusho, jushoKana, telNo, ginkoCode, shitenCode, kozaShubetsu, kozaNo, kozaMeiginin, kozaMeigininKana, kikanKubunCode);
    }

// </editor-fold>


}
