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
 * DbT5032ShujiiIkenshoHoshuTankaの項目定義クラスです
 *
 */
public class DbT5032ShujiiIkenshoHoshuTankaEntity extends DbTableEntityBase<DbT5032ShujiiIkenshoHoshuTankaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5032ShujiiIkenshoHoshuTanka");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private Code zaitakuShisetsuKubun;
    @PrimaryKey
    private Code ikenshoSakuseiKaisuKubun;
    @PrimaryKey
    private FlexibleYearMonth kaishiYM;
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
     * getZaitakuShisetsuKubun
     * @return zaitakuShisetsuKubun
     */
    public Code getZaitakuShisetsuKubun() {
        return zaitakuShisetsuKubun;
    }

    /**
     * setZaitakuShisetsuKubun
     * @param zaitakuShisetsuKubun zaitakuShisetsuKubun
     */
    public void setZaitakuShisetsuKubun(Code zaitakuShisetsuKubun) {
        this.zaitakuShisetsuKubun = zaitakuShisetsuKubun;
    }

    /**
     * getIkenshoSakuseiKaisuKubun
     * @return ikenshoSakuseiKaisuKubun
     */
    public Code getIkenshoSakuseiKaisuKubun() {
        return ikenshoSakuseiKaisuKubun;
    }

    /**
     * setIkenshoSakuseiKaisuKubun
     * @param ikenshoSakuseiKaisuKubun ikenshoSakuseiKaisuKubun
     */
    public void setIkenshoSakuseiKaisuKubun(Code ikenshoSakuseiKaisuKubun) {
        this.ikenshoSakuseiKaisuKubun = ikenshoSakuseiKaisuKubun;
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
     * このエンティティの主キーが他の{@literal DbT5032ShujiiIkenshoHoshuTankaEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5032ShujiiIkenshoHoshuTankaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5032ShujiiIkenshoHoshuTankaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.zaitakuShisetsuKubun, other.zaitakuShisetsuKubun)) {
            return false;
        }
        if (!Objects.equals(this.ikenshoSakuseiKaisuKubun, other.ikenshoSakuseiKaisuKubun)) {
            return false;
        }
        if (!Objects.equals(this.kaishiYM, other.kaishiYM)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5032ShujiiIkenshoHoshuTankaEntity entity) {
        this.zaitakuShisetsuKubun = entity.zaitakuShisetsuKubun;
        this.ikenshoSakuseiKaisuKubun = entity.ikenshoSakuseiKaisuKubun;
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
        return super.toMd5(zaitakuShisetsuKubun, ikenshoSakuseiKaisuKubun, kaishiYM, shuryoYM, tanka);
    }

// </editor-fold>

}
