package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;

/**
 * DbT7107ShinsainHoshuTankaJohoの項目定義クラスです
 *
 */
public class DbT7107ShinsainHoshuTankaJohoEntity extends DbTableEntityBase<DbT7107ShinsainHoshuTankaJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7107ShinsainHoshuTankaJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleDate hoshuTankaTekiyoKaishiYMD;
    @PrimaryKey
    private FlexibleDate hoshuTankaTekiyoShuryoYMD;
    @PrimaryKey
    private Code gogitaiChoKubunCode;
    private int ninteiShinsaHoshuTanka;
    private RString kazeiHikazeiKubun;

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
     * getHoshuTankaTekiyoKaishiYMD
     * @return hoshuTankaTekiyoKaishiYMD
     */
    public FlexibleDate getHoshuTankaTekiyoKaishiYMD() {
        return hoshuTankaTekiyoKaishiYMD;
    }

    /**
     * setHoshuTankaTekiyoKaishiYMD
     * @param hoshuTankaTekiyoKaishiYMD hoshuTankaTekiyoKaishiYMD
     */
    public void setHoshuTankaTekiyoKaishiYMD(FlexibleDate hoshuTankaTekiyoKaishiYMD) {
        this.hoshuTankaTekiyoKaishiYMD = hoshuTankaTekiyoKaishiYMD;
    }

    /**
     * getHoshuTankaTekiyoShuryoYMD
     * @return hoshuTankaTekiyoShuryoYMD
     */
    public FlexibleDate getHoshuTankaTekiyoShuryoYMD() {
        return hoshuTankaTekiyoShuryoYMD;
    }

    /**
     * setHoshuTankaTekiyoShuryoYMD
     * @param hoshuTankaTekiyoShuryoYMD hoshuTankaTekiyoShuryoYMD
     */
    public void setHoshuTankaTekiyoShuryoYMD(FlexibleDate hoshuTankaTekiyoShuryoYMD) {
        this.hoshuTankaTekiyoShuryoYMD = hoshuTankaTekiyoShuryoYMD;
    }

    /**
     * getGogitaiChoKubunCode
     * @return gogitaiChoKubunCode
     */
    public Code getGogitaiChoKubunCode() {
        return gogitaiChoKubunCode;
    }

    /**
     * setGogitaiChoKubunCode
     * @param gogitaiChoKubunCode gogitaiChoKubunCode
     */
    public void setGogitaiChoKubunCode(Code gogitaiChoKubunCode) {
        this.gogitaiChoKubunCode = gogitaiChoKubunCode;
    }

    /**
     * getNinteiShinsaHoshuTanka
     * @return ninteiShinsaHoshuTanka
     */
    public int getNinteiShinsaHoshuTanka() {
        return ninteiShinsaHoshuTanka;
    }

    /**
     * setNinteiShinsaHoshuTanka
     * @param ninteiShinsaHoshuTanka ninteiShinsaHoshuTanka
     */
    public void setNinteiShinsaHoshuTanka(int ninteiShinsaHoshuTanka) {
        this.ninteiShinsaHoshuTanka = ninteiShinsaHoshuTanka;
    }

    /**
     * getKazeiHikazeiKubun
     * @return kazeiHikazeiKubun
     */
    public RString getKazeiHikazeiKubun() {
        return kazeiHikazeiKubun;
    }

    /**
     * setKazeiHikazeiKubun
     * @param kazeiHikazeiKubun kazeiHikazeiKubun
     */
    public void setKazeiHikazeiKubun(RString kazeiHikazeiKubun) {
        this.kazeiHikazeiKubun = kazeiHikazeiKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7107ShinsainHoshuTankaJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7107ShinsainHoshuTankaJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7107ShinsainHoshuTankaJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hoshuTankaTekiyoKaishiYMD, other.hoshuTankaTekiyoKaishiYMD)) {
            return false;
        }
        if (!Objects.equals(this.hoshuTankaTekiyoShuryoYMD, other.hoshuTankaTekiyoShuryoYMD)) {
            return false;
        }
        if (!Objects.equals(this.gogitaiChoKubunCode, other.gogitaiChoKubunCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7107ShinsainHoshuTankaJohoEntity entity) {
        this.hoshuTankaTekiyoKaishiYMD = entity.hoshuTankaTekiyoKaishiYMD;
        this.hoshuTankaTekiyoShuryoYMD = entity.hoshuTankaTekiyoShuryoYMD;
        this.gogitaiChoKubunCode = entity.gogitaiChoKubunCode;
        this.ninteiShinsaHoshuTanka = entity.ninteiShinsaHoshuTanka;
        this.kazeiHikazeiKubun = entity.kazeiHikazeiKubun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hoshuTankaTekiyoKaishiYMD, hoshuTankaTekiyoShuryoYMD, gogitaiChoKubunCode, ninteiShinsaHoshuTanka, kazeiHikazeiKubun);
    }

// </editor-fold>

}
