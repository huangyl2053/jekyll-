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
 * DbT7014KaigoSetaiの項目定義クラスです
 *
 */
public class DbT7014KaigoSetaiEntity extends DbTableEntityBase<DbT7014KaigoSetaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7014KaigoSetai");

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
    private FlexibleDate setaiKijunYMD;
    @PrimaryKey
    private int renban;
    @PrimaryKey
    private RDateTime shoriTimestamp;
    private ShikibetsuCode setaiInshikibetsuCode;

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
     * getSetaiKijunYMD
     *
     * @return setaiKijunYMD
     */
    public FlexibleDate getSetaiKijunYMD() {
        return setaiKijunYMD;
    }

    /**
     * setSetaiKijunYMD
     *
     * @param setaiKijunYMD setaiKijunYMD
     */
    public void setSetaiKijunYMD(FlexibleDate setaiKijunYMD) {
        this.setaiKijunYMD = setaiKijunYMD;
    }

    /**
     * getRenban
     *
     * @return renban
     */
    public int getRenban() {
        return renban;
    }

    /**
     * setRenban
     *
     * @param renban renban
     */
    public void setRenban(int renban) {
        this.renban = renban;
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
     * getSetaiInshikibetsuCode
     *
     * @return setaiInshikibetsuCode
     */
    public ShikibetsuCode getSetaiInshikibetsuCode() {
        return setaiInshikibetsuCode;
    }

    /**
     * setSetaiInshikibetsuCode
     *
     * @param setaiInshikibetsuCode setaiInshikibetsuCode
     */
    public void setSetaiInshikibetsuCode(ShikibetsuCode setaiInshikibetsuCode) {
        this.setaiInshikibetsuCode = setaiInshikibetsuCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7014KaigoSetaiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT7014KaigoSetaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7014KaigoSetaiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.insertTimestamp, other.insertTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.setaiKijunYMD, other.setaiKijunYMD)) {
            return false;
        }
        if (this.renban != other.renban) {
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
    public void shallowCopy(DbT7014KaigoSetaiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.setaiKijunYMD = entity.setaiKijunYMD;
        this.renban = entity.renban;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.setaiInshikibetsuCode = entity.setaiInshikibetsuCode;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, setaiKijunYMD, renban, shoriTimestamp, setaiInshikibetsuCode);
    }

// </editor-fold>
}
