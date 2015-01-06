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
 * DbT1012Minashi2GoshaDaichoの項目定義クラスです
 *
 */
public class DbT1012Minashi2GoshaDaichoEntity extends DbTableEntityBase<DbT1012Minashi2GoshaDaichoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT1012Minashi2GoshaDaicho");

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
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private ShikibetsuCode shikibetsuCode;
    private RString hihokenshaKubunCode;
    private FlexibleDate minashi2GoshaTorokuYMD;
    private FlexibleDate minashi2GoshaKaijoYMD;
    private HihokenshaNo fukushiHihokenshaNo;

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
     * getHihokenshaKubunCode
     *
     * @return hihokenshaKubunCode
     */
    public RString getHihokenshaKubunCode() {
        return hihokenshaKubunCode;
    }

    /**
     * setHihokenshaKubunCode
     *
     * @param hihokenshaKubunCode hihokenshaKubunCode
     */
    public void setHihokenshaKubunCode(RString hihokenshaKubunCode) {
        this.hihokenshaKubunCode = hihokenshaKubunCode;
    }

    /**
     * getMinashi2GoshaTorokuYMD
     *
     * @return minashi2GoshaTorokuYMD
     */
    public FlexibleDate getMinashi2GoshaTorokuYMD() {
        return minashi2GoshaTorokuYMD;
    }

    /**
     * setMinashi2GoshaTorokuYMD
     *
     * @param minashi2GoshaTorokuYMD minashi2GoshaTorokuYMD
     */
    public void setMinashi2GoshaTorokuYMD(FlexibleDate minashi2GoshaTorokuYMD) {
        this.minashi2GoshaTorokuYMD = minashi2GoshaTorokuYMD;
    }

    /**
     * getMinashi2GoshaKaijoYMD
     *
     * @return minashi2GoshaKaijoYMD
     */
    public FlexibleDate getMinashi2GoshaKaijoYMD() {
        return minashi2GoshaKaijoYMD;
    }

    /**
     * setMinashi2GoshaKaijoYMD
     *
     * @param minashi2GoshaKaijoYMD minashi2GoshaKaijoYMD
     */
    public void setMinashi2GoshaKaijoYMD(FlexibleDate minashi2GoshaKaijoYMD) {
        this.minashi2GoshaKaijoYMD = minashi2GoshaKaijoYMD;
    }

    /**
     * getFukushiHihokenshaNo
     *
     * @return fukushiHihokenshaNo
     */
    public HihokenshaNo getFukushiHihokenshaNo() {
        return fukushiHihokenshaNo;
    }

    /**
     * setFukushiHihokenshaNo
     *
     * @param fukushiHihokenshaNo fukushiHihokenshaNo
     */
    public void setFukushiHihokenshaNo(HihokenshaNo fukushiHihokenshaNo) {
        this.fukushiHihokenshaNo = fukushiHihokenshaNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1012Minashi2GoshaDaichoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1012Minashi2GoshaDaichoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1012Minashi2GoshaDaichoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
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
    public void shallowCopy(DbT1012Minashi2GoshaDaichoEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.hihokenshaKubunCode = entity.hihokenshaKubunCode;
        this.minashi2GoshaTorokuYMD = entity.minashi2GoshaTorokuYMD;
        this.minashi2GoshaKaijoYMD = entity.minashi2GoshaKaijoYMD;
        this.fukushiHihokenshaNo = entity.fukushiHihokenshaNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, hihokenshaNo, shoriTimestamp, shikibetsuCode, hihokenshaKubunCode, minashi2GoshaTorokuYMD, minashi2GoshaKaijoYMD, fukushiHihokenshaNo);
    }

// </editor-fold>
}
