package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT1008IryohokenKanyuJokyoの項目定義クラスです
 *
 */
public class DbT1008IryohokenKanyuJokyoEntity extends DbTableEntityBase<DbT1008IryohokenKanyuJokyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT1008IryohokenKanyuJokyo");

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
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private YMDHMS shoriTimeStamp;
    private HihokenshaNo hihokenshaNo;
    private RString iryoHokenShubetsuCode;
    private RString iryoHokenshaNo;
    private RString iryoHokenshaMeisho;
    private RString iryoHokenKigoNo;
    private FlexibleDate iryoHokenKanyuYMD;
    private FlexibleDate iryoHokenDattaiYMD;

    /**
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getShichosonCode
     *
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     *
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * getShikibetsuCode
     *
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * setShikibetsuCode
     *
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * getShoriTimeStamp
     *
     * @return shoriTimeStamp
     */
    public YMDHMS getShoriTimeStamp() {
        return shoriTimeStamp;
    }

    /**
     * setShoriTimeStamp
     *
     * @param shoriTimeStamp shoriTimeStamp
     */
    public void setShoriTimeStamp(YMDHMS shoriTimeStamp) {
        this.shoriTimeStamp = shoriTimeStamp;
    }

    /**
     * getHihokenshaNo
     *
     * @return hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * getIryoHokenShubetsuCode
     *
     * @return iryoHokenShubetsuCode
     */
    public RString getIryoHokenShubetsuCode() {
        return iryoHokenShubetsuCode;
    }

    /**
     * setIryoHokenShubetsuCode
     *
     * @param iryoHokenShubetsuCode iryoHokenShubetsuCode
     */
    public void setIryoHokenShubetsuCode(RString iryoHokenShubetsuCode) {
        this.iryoHokenShubetsuCode = iryoHokenShubetsuCode;
    }

    /**
     * getIryoHokenshaNo
     *
     * @return iryoHokenshaNo
     */
    public RString getIryoHokenshaNo() {
        return iryoHokenshaNo;
    }

    /**
     * setIryoHokenshaNo
     *
     * @param iryoHokenshaNo iryoHokenshaNo
     */
    public void setIryoHokenshaNo(RString iryoHokenshaNo) {
        this.iryoHokenshaNo = iryoHokenshaNo;
    }

    /**
     * getIryoHokenshaMeisho
     *
     * @return iryoHokenshaMeisho
     */
    public RString getIryoHokenshaMeisho() {
        return iryoHokenshaMeisho;
    }

    /**
     * setIryoHokenshaMeisho
     *
     * @param iryoHokenshaMeisho iryoHokenshaMeisho
     */
    public void setIryoHokenshaMeisho(RString iryoHokenshaMeisho) {
        this.iryoHokenshaMeisho = iryoHokenshaMeisho;
    }

    /**
     * getIryoHokenKigoNo
     *
     * @return iryoHokenKigoNo
     */
    public RString getIryoHokenKigoNo() {
        return iryoHokenKigoNo;
    }

    /**
     * setIryoHokenKigoNo
     *
     * @param iryoHokenKigoNo iryoHokenKigoNo
     */
    public void setIryoHokenKigoNo(RString iryoHokenKigoNo) {
        this.iryoHokenKigoNo = iryoHokenKigoNo;
    }

    /**
     * getIryoHokenKanyuYMD
     *
     * @return iryoHokenKanyuYMD
     */
    public FlexibleDate getIryoHokenKanyuYMD() {
        return iryoHokenKanyuYMD;
    }

    /**
     * setIryoHokenKanyuYMD
     *
     * @param iryoHokenKanyuYMD iryoHokenKanyuYMD
     */
    public void setIryoHokenKanyuYMD(FlexibleDate iryoHokenKanyuYMD) {
        this.iryoHokenKanyuYMD = iryoHokenKanyuYMD;
    }

    /**
     * getIryoHokenDattaiYMD
     *
     * @return iryoHokenDattaiYMD
     */
    public FlexibleDate getIryoHokenDattaiYMD() {
        return iryoHokenDattaiYMD;
    }

    /**
     * setIryoHokenDattaiYMD
     *
     * @param iryoHokenDattaiYMD iryoHokenDattaiYMD
     */
    public void setIryoHokenDattaiYMD(FlexibleDate iryoHokenDattaiYMD) {
        this.iryoHokenDattaiYMD = iryoHokenDattaiYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1008IryohokenKanyuJokyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1008IryohokenKanyuJokyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1008IryohokenKanyuJokyoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimeStamp, other.shoriTimeStamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT1008IryohokenKanyuJokyoEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.shoriTimeStamp = entity.shoriTimeStamp;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.iryoHokenShubetsuCode = entity.iryoHokenShubetsuCode;
        this.iryoHokenshaNo = entity.iryoHokenshaNo;
        this.iryoHokenshaMeisho = entity.iryoHokenshaMeisho;
        this.iryoHokenKigoNo = entity.iryoHokenKigoNo;
        this.iryoHokenKanyuYMD = entity.iryoHokenKanyuYMD;
        this.iryoHokenDattaiYMD = entity.iryoHokenDattaiYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, shikibetsuCode, shoriTimeStamp, hihokenshaNo, iryoHokenShubetsuCode, iryoHokenshaNo, iryoHokenshaMeisho, iryoHokenKigoNo, iryoHokenKanyuYMD, iryoHokenDattaiYMD);
    }

// </editor-fold>
}
