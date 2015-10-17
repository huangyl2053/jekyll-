package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * 給付費貸付金延滞利息金徴収テーブルのエンティティクラスです。
 */
public class DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity extends DbTableEntityBase<DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
    private Decimal rirekiNo;
    private FlexibleDate entaiRisokuKinChoshuYMD;
    private Decimal entaiRisokuChoshuKingaku;

    /**
     * insertDantaiCdのgetメソッドです。
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * insertDantaiCdのsetメソッドです。
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * isDeletedのgetメソッドです。
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * isDeletedのsetメソッドです。
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * lastUpdateReamsLoginIdのsetメソッドです。
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 貸付管理番号のgetメソッドです。
     *
     * @return 貸付管理番号
     */
    public RString getKashitsukeKanriNo() {
        return kashitsukeKanriNo;
    }

    /**
     * 貸付管理番号のsetメソッドです。
     *
     * @param kashitsukeKanriNo 貸付管理番号
     */
    public void setKashitsukeKanriNo(RString kashitsukeKanriNo) {
        this.kashitsukeKanriNo = kashitsukeKanriNo;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public Decimal getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(Decimal rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 延滞利息金徴収年月日のgetメソッドです。
     *
     * @return 延滞利息金徴収年月日
     */
    public FlexibleDate getEntaiRisokuKinChoshuYMD() {
        return entaiRisokuKinChoshuYMD;
    }

    /**
     * 延滞利息金徴収年月日のsetメソッドです。
     *
     * @param entaiRisokuKinChoshuYMD 延滞利息金徴収年月日
     */
    public void setEntaiRisokuKinChoshuYMD(FlexibleDate entaiRisokuKinChoshuYMD) {
        this.entaiRisokuKinChoshuYMD = entaiRisokuKinChoshuYMD;
    }

    /**
     * 延滞利息徴収金額のgetメソッドです。
     *
     * @return 延滞利息徴収金額
     */
    public Decimal getEntaiRisokuChoshuKingaku() {
        return entaiRisokuChoshuKingaku;
    }

    /**
     * 延滞利息徴収金額のsetメソッドです。
     *
     * @param entaiRisokuChoshuKingaku 延滞利息徴収金額
     */
    public void setEntaiRisokuChoshuKingaku(Decimal entaiRisokuChoshuKingaku) {
        this.entaiRisokuChoshuKingaku = entaiRisokuChoshuKingaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
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
        if (this.rirekiNo != other.rirekiNo) {
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
        this.rirekiNo = entity.rirekiNo;
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
        return super.toMd5(hihokenshaNo, kashitsukeKanriNo, rirekiNo, entaiRisokuKinChoshuYMD, entaiRisokuChoshuKingaku);
    }

// </editor-fold>
}
