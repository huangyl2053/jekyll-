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
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;

/**
 * DbT7012ShujiiJohoの項目定義クラスです
 *
 */
public class DbT7012ShujiiJohoEntity extends DbTableEntityBase<DbT7012ShujiiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7012ShujiiJoho");

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
    @PrimaryKey
    private RString kaigoIshiCode;
    private RString iryokikanCode;
    private RString ishiShikibetsuNo;
    private RString shujiiJokyo;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private TelNo telNo;
    private TelNo faxNo;

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
     * getKaigoIshiCode
     * @return kaigoIshiCode
     */
    public RString getKaigoIshiCode() {
        return kaigoIshiCode;
    }

    /**
     * setKaigoIshiCode
     * @param kaigoIshiCode kaigoIshiCode
     */
    public void setKaigoIshiCode(RString kaigoIshiCode) {
        this.kaigoIshiCode = kaigoIshiCode;
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
     * getIshiShikibetsuNo
     * @return ishiShikibetsuNo
     */
    public RString getIshiShikibetsuNo() {
        return ishiShikibetsuNo;
    }

    /**
     * setIshiShikibetsuNo
     * @param ishiShikibetsuNo ishiShikibetsuNo
     */
    public void setIshiShikibetsuNo(RString ishiShikibetsuNo) {
        this.ishiShikibetsuNo = ishiShikibetsuNo;
    }

    /**
     * getShujiiJokyo
     * @return shujiiJokyo
     */
    public RString getShujiiJokyo() {
        return shujiiJokyo;
    }

    /**
     * setShujiiJokyo
     * @param shujiiJokyo shujiiJokyo
     */
    public void setShujiiJokyo(RString shujiiJokyo) {
        this.shujiiJokyo = shujiiJokyo;
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
    public AtenaJusho getJusho() {
        return jusho;
    }

    /**
     * setJusho
     * @param jusho jusho
     */
    public void setJusho(AtenaJusho jusho) {
        this.jusho = jusho;
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
     * getFaxNo
     * @return faxNo
     */
    public TelNo getFaxNo() {
        return faxNo;
    }

    /**
     * setFaxNo
     * @param faxNo faxNo
     */
    public void setFaxNo(TelNo faxNo) {
        this.faxNo = faxNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7012ShujiiJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7012ShujiiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7012ShujiiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.kaigoIryokikanCode, other.kaigoIryokikanCode)) {
            return false;
        }
        if (!Objects.equals(this.kaigoIshiCode, other.kaigoIshiCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7012ShujiiJohoEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.kaigoIryokikanCode = entity.kaigoIryokikanCode;
        this.kaigoIshiCode = entity.kaigoIshiCode;
        this.iryokikanCode = entity.iryokikanCode;
        this.ishiShikibetsuNo = entity.ishiShikibetsuNo;
        this.shujiiJokyo = entity.shujiiJokyo;
        this.yubinNo = entity.yubinNo;
        this.jusho = entity.jusho;
        this.telNo = entity.telNo;
        this.faxNo = entity.faxNo;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, kaigoIryokikanCode, kaigoIshiCode, iryokikanCode, ishiShikibetsuNo, shujiiJokyo, yubinNo, jusho, telNo, faxNo);
    }

// </editor-fold>


}
