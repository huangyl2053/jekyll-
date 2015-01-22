package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
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
 * DbT3102NijiYoboNiniCheckListの項目定義クラスです
 *
 */
public class DbT3102NijiYoboNiniCheckListEntity extends DbTableEntityBase<DbT3102NijiYoboNiniCheckListEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3102NijiYoboNiniCheckList");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleDate uketsukeYMD;
    @PrimaryKey
    private int niniShitsumonNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private int niniShitsumonJiko;

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
     * getUketsukeYMD
     *
     * @return uketsukeYMD
     */
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * setUketsukeYMD
     *
     * @param uketsukeYMD uketsukeYMD
     */
    public void setUketsukeYMD(FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
    }

    /**
     * getNiniShitsumonNo
     *
     * @return niniShitsumonNo
     */
    public int getNiniShitsumonNo() {
        return niniShitsumonNo;
    }

    /**
     * setNiniShitsumonNo
     *
     * @param niniShitsumonNo niniShitsumonNo
     */
    public void setNiniShitsumonNo(int niniShitsumonNo) {
        this.niniShitsumonNo = niniShitsumonNo;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getNiniShitsumonJiko
     *
     * @return niniShitsumonJiko
     */
    public int getNiniShitsumonJiko() {
        return niniShitsumonJiko;
    }

    /**
     * setNiniShitsumonJiko
     *
     * @param niniShitsumonJiko niniShitsumonJiko
     */
    public void setNiniShitsumonJiko(int niniShitsumonJiko) {
        this.niniShitsumonJiko = niniShitsumonJiko;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3102NijiYoboNiniCheckListEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3102NijiYoboNiniCheckListEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3102NijiYoboNiniCheckListEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.uketsukeYMD, other.uketsukeYMD)) {
            return false;
        }
        if (this.niniShitsumonNo != other.niniShitsumonNo) {
            return false;
        }
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3102NijiYoboNiniCheckListEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.niniShitsumonNo = entity.niniShitsumonNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.niniShitsumonJiko = entity.niniShitsumonJiko;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, hihokenshaNo, uketsukeYMD, niniShitsumonNo, shoriTimestamp, niniShitsumonJiko);
    }

// </editor-fold>
}
