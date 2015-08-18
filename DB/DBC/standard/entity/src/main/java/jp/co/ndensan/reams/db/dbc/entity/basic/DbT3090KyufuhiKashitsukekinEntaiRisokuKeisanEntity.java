package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * 給付費貸付金延滞利息計算テーブルのエンティティクラスです。
 */
public class DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity extends DbTableEntityBase<DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3090KyufuhiKashitsukekinEntaiRisokuKeisan");

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
    private RString entaiNissu;
    private Decimal entaiRisokuKingaku;

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
     * 貸付金延滞日数のgetメソッドです。
     *
     * @return 貸付金延滞日数
     */
    public RString getEntaiNissu() {
        return entaiNissu;
    }

    /**
     * 貸付金延滞日数のsetメソッドです。
     *
     * @param entaiNissu 貸付金延滞日数
     */
    public void setEntaiNissu(RString entaiNissu) {
        this.entaiNissu = entaiNissu;
    }

    /**
     * 貸付金延滞利息金額のgetメソッドです。
     *
     * @return 貸付金延滞利息金額
     */
    public Decimal getEntaiRisokuKingaku() {
        return entaiRisokuKingaku;
    }

    /**
     * 貸付金延滞利息金額のsetメソッドです。
     *
     * @param entaiRisokuKingaku 貸付金延滞利息金額
     */
    public void setEntaiRisokuKingaku(Decimal entaiRisokuKingaku) {
        this.entaiRisokuKingaku = entaiRisokuKingaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity other) {
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
    public void shallowCopy(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kashitsukeKanriNo = entity.kashitsukeKanriNo;
        this.rirekiNo = entity.rirekiNo;
        this.entaiNissu = entity.entaiNissu;
        this.entaiRisokuKingaku = entity.entaiRisokuKingaku;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, kashitsukeKanriNo, rirekiNo, entaiNissu, entaiRisokuKingaku);
    }

// </editor-fold>
}
