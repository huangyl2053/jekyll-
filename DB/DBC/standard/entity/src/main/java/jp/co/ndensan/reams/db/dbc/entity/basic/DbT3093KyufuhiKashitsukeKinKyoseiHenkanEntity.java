package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;

/**
 * 給付費貸付金強制返還テーブルのエンティティクラスです。
 */
public class DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity extends DbTableEntityBase<DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3093KyufuhiKashitsukeKinKyoseiHenkan");

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
    private RString henkanKinKubun;
    private Decimal henkanKingaku;
    private FlexibleDate henkanKigenYMD;
    private RString henkanRiyu;

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
     * 返還金区分のgetメソッドです。
     *
     * @return 返還金区分
     */
    public RString getHenkanKinKubun() {
        return henkanKinKubun;
    }

    /**
     * 返還金区分のsetメソッドです。
     *
     * @param henkanKinKubun 返還金区分
     */
    public void setHenkanKinKubun(RString henkanKinKubun) {
        this.henkanKinKubun = henkanKinKubun;
    }

    /**
     * 返還金額のgetメソッドです。
     *
     * @return 返還金額
     */
    public Decimal getHenkanKingaku() {
        return henkanKingaku;
    }

    /**
     * 返還金額のsetメソッドです。
     *
     * @param henkanKingaku 返還金額
     */
    public void setHenkanKingaku(Decimal henkanKingaku) {
        this.henkanKingaku = henkanKingaku;
    }

    /**
     * 返還期限のgetメソッドです。
     *
     * @return 返還期限
     */
    public FlexibleDate getHenkanKigenYMD() {
        return henkanKigenYMD;
    }

    /**
     * 返還期限のsetメソッドです。
     *
     * @param henkanKigenYMD 返還期限
     */
    public void setHenkanKigenYMD(FlexibleDate henkanKigenYMD) {
        this.henkanKigenYMD = henkanKigenYMD;
    }

    /**
     * 返還理由のgetメソッドです。
     *
     * @return 返還理由
     */
    public RString getHenkanRiyu() {
        return henkanRiyu;
    }

    /**
     * 返還理由のsetメソッドです。
     *
     * @param henkanRiyu 返還理由
     */
    public void setHenkanRiyu(RString henkanRiyu) {
        this.henkanRiyu = henkanRiyu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity other) {
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
    public void shallowCopy(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kashitsukeKanriNo = entity.kashitsukeKanriNo;
        this.rirekiNo = entity.rirekiNo;
        this.henkanKinKubun = entity.henkanKinKubun;
        this.henkanKingaku = entity.henkanKingaku;
        this.henkanKigenYMD = entity.henkanKigenYMD;
        this.henkanRiyu = entity.henkanRiyu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, kashitsukeKanriNo, rirekiNo, henkanKinKubun, henkanKingaku, henkanKigenYMD, henkanRiyu);
    }

// </editor-fold>
}
