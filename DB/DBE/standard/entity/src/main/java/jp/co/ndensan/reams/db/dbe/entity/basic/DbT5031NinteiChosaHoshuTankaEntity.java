package jp.co.ndensan.reams.db.dbe.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT5031NinteiChosaHoshuTankaの項目定義クラスです
 *
 */
public class DbT5031NinteiChosaHoshuTankaEntity extends DbTableEntityBase<DbT5031NinteiChosaHoshuTankaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5031NinteiChosaHoshuTanka");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private Code chosaKubun;
    @PrimaryKey
    private Code homonShubetsu;
    @PrimaryKey
    private Code ikenshoNyushuPatern;
    @PrimaryKey
    private FlexibleYearMonth kaishiYM;
    @PrimaryKey
    private FlexibleYearMonth shuryoYM;
    private Decimal tanka;

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
     * 調査区分のgetメソッドです。
     *
     * @return 調査区分
     */
    public Code getChosaKubun() {
        return chosaKubun;
    }

    /**
     * 調査区分のsetメソッドです。
     *
     * @param chosaKubun 調査区分
     */
    public void setChosaKubun(Code chosaKubun) {
        this.chosaKubun = chosaKubun;
    }

    /**
     * 訪問種別のgetメソッドです。
     *
     * @return 訪問種別
     */
    public Code getHomonShubetsu() {
        return homonShubetsu;
    }

    /**
     * 訪問種別のsetメソッドです。
     *
     * @param homonShubetsu 訪問種別
     */
    public void setHomonShubetsu(Code homonShubetsu) {
        this.homonShubetsu = homonShubetsu;
    }

    /**
     * 意見書入手パターンのgetメソッドです。
     *
     * @return 意見書入手パターン
     */
    public Code getIkenshoNyushuPatern() {
        return ikenshoNyushuPatern;
    }

    /**
     * 意見書入手パターンのsetメソッドです。
     *
     * @param ikenshoNyushuPatern 意見書入手パターン
     */
    public void setIkenshoNyushuPatern(Code ikenshoNyushuPatern) {
        this.ikenshoNyushuPatern = ikenshoNyushuPatern;
    }

    /**
     * 開始年月のgetメソッドです。
     *
     * @return 開始年月
     */
    public FlexibleYearMonth getKaishiYM() {
        return kaishiYM;
    }

    /**
     * 開始年月のsetメソッドです。
     *
     * @param kaishiYM 開始年月
     */
    public void setKaishiYM(FlexibleYearMonth kaishiYM) {
        this.kaishiYM = kaishiYM;
    }

    /**
     * 終了年月のgetメソッドです。
     *
     * @return 終了年月
     */
    public FlexibleYearMonth getShuryoYM() {
        return shuryoYM;
    }

    /**
     * 終了年月のsetメソッドです。
     *
     * @param shuryoYM 終了年月
     */
    public void setShuryoYM(FlexibleYearMonth shuryoYM) {
        this.shuryoYM = shuryoYM;
    }

    /**
     * 単価のgetメソッドです。
     *
     * @return 単価
     */
    public Decimal getTanka() {
        return tanka;
    }

    /**
     * 単価のsetメソッドです。
     *
     * @param tanka 単価
     */
    public void setTanka(Decimal tanka) {
        this.tanka = tanka;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5031NinteiChosaHoshuTankaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5031NinteiChosaHoshuTankaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5031NinteiChosaHoshuTankaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.chosaKubun, other.chosaKubun)) {
            return false;
        }
        if (!Objects.equals(this.homonShubetsu, other.homonShubetsu)) {
            return false;
        }
        if (!Objects.equals(this.ikenshoNyushuPatern, other.ikenshoNyushuPatern)) {
            return false;
        }
        if (!Objects.equals(this.kaishiYM, other.kaishiYM)) {
            return false;
        }
        if (!Objects.equals(this.shuryoYM, other.shuryoYM)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5031NinteiChosaHoshuTankaEntity entity) {
        this.chosaKubun = entity.chosaKubun;
        this.homonShubetsu = entity.homonShubetsu;
        this.ikenshoNyushuPatern = entity.ikenshoNyushuPatern;
        this.kaishiYM = entity.kaishiYM;
        this.shuryoYM = entity.shuryoYM;
        this.tanka = entity.tanka;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(chosaKubun, homonShubetsu, ikenshoNyushuPatern, kaishiYM, shuryoYM, tanka);
    }

// </editor-fold>
}
