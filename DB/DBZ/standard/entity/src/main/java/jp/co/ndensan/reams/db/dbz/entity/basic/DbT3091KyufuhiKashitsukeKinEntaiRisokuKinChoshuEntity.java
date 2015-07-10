package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuの項目定義クラスです
 *
 */
public class DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity extends DbTableEntityBase<DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshu");

    private RString insertDantaiCd;
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
    private RString kashitsukeKanriNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private FlexibleDate entaiRisokuKinChoshuYMD;
    private Decimal entaiRisokuChoshuKingaku;

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
     * getKashitsukeKanriNo
     *
     * @return kashitsukeKanriNo
     */
    public RString getKashitsukeKanriNo() {
        return kashitsukeKanriNo;
    }

    /**
     * setKashitsukeKanriNo
     *
     * @param kashitsukeKanriNo kashitsukeKanriNo
     */
    public void setKashitsukeKanriNo(RString kashitsukeKanriNo) {
        this.kashitsukeKanriNo = kashitsukeKanriNo;
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
     * getEntaiRisokuKinChoshuYMD
     *
     * @return entaiRisokuKinChoshuYMD
     */
    public FlexibleDate getEntaiRisokuKinChoshuYMD() {
        return entaiRisokuKinChoshuYMD;
    }

    /**
     * setEntaiRisokuKinChoshuYMD
     *
     * @param entaiRisokuKinChoshuYMD entaiRisokuKinChoshuYMD
     */
    public void setEntaiRisokuKinChoshuYMD(FlexibleDate entaiRisokuKinChoshuYMD) {
        this.entaiRisokuKinChoshuYMD = entaiRisokuKinChoshuYMD;
    }

    /**
     * getEntaiRisokuChoshuKingaku
     *
     * @return entaiRisokuChoshuKingaku
     */
    public Decimal getEntaiRisokuChoshuKingaku() {
        return entaiRisokuChoshuKingaku;
    }

    /**
     * setEntaiRisokuChoshuKingaku
     *
     * @param entaiRisokuChoshuKingaku entaiRisokuChoshuKingaku
     */
    public void setEntaiRisokuChoshuKingaku(Decimal entaiRisokuChoshuKingaku) {
        this.entaiRisokuChoshuKingaku = entaiRisokuChoshuKingaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.kashitsukeKanriNo, other.kashitsukeKanriNo)) {
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
    public void shallowCopy(DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kashitsukeKanriNo = entity.kashitsukeKanriNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.entaiRisokuKinChoshuYMD = entity.entaiRisokuKinChoshuYMD;
        this.entaiRisokuChoshuKingaku = entity.entaiRisokuChoshuKingaku;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, kashitsukeKanriNo, shoriTimestamp, entaiRisokuKinChoshuYMD, entaiRisokuChoshuKingaku);
    }

// </editor-fold>
}
