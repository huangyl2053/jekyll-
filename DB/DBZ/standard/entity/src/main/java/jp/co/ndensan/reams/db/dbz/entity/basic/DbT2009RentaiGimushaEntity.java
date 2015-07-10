package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT2009RentaiGimushaの項目定義クラスです
 *
 */
public class DbT2009RentaiGimushaEntity extends DbTableEntityBase<DbT2009RentaiGimushaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT2009RentaiGimusha");

    private RString insertDantaiCd;
    @PrimaryKey
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RDateTime shoriTimestamp;
    private int rirekiNo;
    private ShikibetsuCode shikibetuCode;
    private FlexibleDate startYMD;
    private FlexibleDate endYMD;

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
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public RDateTime getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(RDateTime shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getRirekiNo
     *
     * @return rirekiNo
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * setRirekiNo
     *
     * @param rirekiNo rirekiNo
     */
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * getShikibetuCode
     *
     * @return shikibetuCode
     */
    public ShikibetsuCode getShikibetuCode() {
        return shikibetuCode;
    }

    /**
     * setShikibetuCode
     *
     * @param shikibetuCode shikibetuCode
     */
    public void setShikibetuCode(ShikibetsuCode shikibetuCode) {
        this.shikibetuCode = shikibetuCode;
    }

    /**
     * getStartYMD
     *
     * @return startYMD
     */
    public FlexibleDate getStartYMD() {
        return startYMD;
    }

    /**
     * setStartYMD
     *
     * @param startYMD startYMD
     */
    public void setStartYMD(FlexibleDate startYMD) {
        this.startYMD = startYMD;
    }

    /**
     * getEndYMD
     *
     * @return endYMD
     */
    public FlexibleDate getEndYMD() {
        return endYMD;
    }

    /**
     * setEndYMD
     *
     * @param endYMD endYMD
     */
    public void setEndYMD(FlexibleDate endYMD) {
        this.endYMD = endYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2009RentaiGimushaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT2009RentaiGimushaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2009RentaiGimushaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.insertTimestamp, other.insertTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
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
    public void shallowCopy(DbT2009RentaiGimushaEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.rirekiNo = entity.rirekiNo;
        this.shikibetuCode = entity.shikibetuCode;
        this.startYMD = entity.startYMD;
        this.endYMD = entity.endYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, shoriTimestamp, rirekiNo, shikibetuCode, startYMD, endYMD);
    }

// </editor-fold>
}
