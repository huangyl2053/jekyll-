package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * DbT5033ShinsakaiIinHoshuTankaの項目定義クラスです
 *
 */
public class DbT5033ShinsakaiIinHoshuTankaEntity extends DbTableEntityBase<DbT5033ShinsakaiIinHoshuTankaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5033ShinsakaiIinHoshuTanka");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private CodeShubetsu kaigoNinteiShinsaIinShubetsu;
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
     * getKaigoNinteiShinsaIinShubetsu
     * @return kaigoNinteiShinsaIinShubetsu
     */
    public CodeShubetsu getKaigoNinteiShinsaIinShubetsu() {
        return kaigoNinteiShinsaIinShubetsu;
    }

    /**
     * setKaigoNinteiShinsaIinShubetsu
     * @param kaigoNinteiShinsaIinShubetsu kaigoNinteiShinsaIinShubetsu
     */
    public void setKaigoNinteiShinsaIinShubetsu(CodeShubetsu kaigoNinteiShinsaIinShubetsu) {
        this.kaigoNinteiShinsaIinShubetsu = kaigoNinteiShinsaIinShubetsu;
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
     * このエンティティの主キーが他の{@literal DbT5033ShinsakaiIinHoshuTankaEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5033ShinsakaiIinHoshuTankaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5033ShinsakaiIinHoshuTankaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.kaigoNinteiShinsaIinShubetsu, other.kaigoNinteiShinsaIinShubetsu)) {
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
    public void shallowCopy(DbT5033ShinsakaiIinHoshuTankaEntity entity) {
        this.kaigoNinteiShinsaIinShubetsu = entity.kaigoNinteiShinsaIinShubetsu;
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
        return super.toMd5(kaigoNinteiShinsaIinShubetsu, kaishiYM, shuryoYM, tanka);
    }

// </editor-fold>



}
