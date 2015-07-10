package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * DbT5031NinteiChosaHoshuTankaの項目定義クラスです
 *
 */
public class DbT5031NinteiChosaHoshuTankaEntity extends DbTableEntityBase<DbT5031NinteiChosaHoshuTankaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
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
     * getInsertDantaiCd
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * setLastUpdateReamsLoginId
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getChosaKubun
     * @return chosaKubun
     */
    public Code getChosaKubun() {
        return chosaKubun;
    }

    /**
     * setChosaKubun
     * @param chosaKubun chosaKubun
     */
    public void setChosaKubun(Code chosaKubun) {
        this.chosaKubun = chosaKubun;
    }

    /**
     * getHomonShubetsu
     * @return homonShubetsu
     */
    public Code getHomonShubetsu() {
        return homonShubetsu;
    }

    /**
     * setHomonShubetsu
     * @param homonShubetsu homonShubetsu
     */
    public void setHomonShubetsu(Code homonShubetsu) {
        this.homonShubetsu = homonShubetsu;
    }

    /**
     * getIkenshoNyushuPatern
     * @return ikenshoNyushuPatern
     */
    public Code getIkenshoNyushuPatern() {
        return ikenshoNyushuPatern;
    }

    /**
     * setIkenshoNyushuPatern
     * @param ikenshoNyushuPatern ikenshoNyushuPatern
     */
    public void setIkenshoNyushuPatern(Code ikenshoNyushuPatern) {
        this.ikenshoNyushuPatern = ikenshoNyushuPatern;
    }

    /**
     * getKaishiYM
     * @return kaishiYM
     */
    public FlexibleYearMonth getKaishiYM() {
        return kaishiYM;
    }

    /**
     * setKaishiYM
     * @param kaishiYM kaishiYM
     */
    public void setKaishiYM(FlexibleYearMonth kaishiYM) {
        this.kaishiYM = kaishiYM;
    }

    /**
     * getShuryoYM
     * @return shuryoYM
     */
    public FlexibleYearMonth getShuryoYM() {
        return shuryoYM;
    }

    /**
     * setShuryoYM
     * @param shuryoYM shuryoYM
     */
    public void setShuryoYM(FlexibleYearMonth shuryoYM) {
        this.shuryoYM = shuryoYM;
    }

    /**
     * getTanka
     * @return tanka
     */
    public Decimal getTanka() {
        return tanka;
    }

    /**
     * setTanka
     * @param tanka tanka
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
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(chosaKubun, homonShubetsu, ikenshoNyushuPatern, kaishiYM, shuryoYM, tanka);
    }

// </editor-fold>

}
