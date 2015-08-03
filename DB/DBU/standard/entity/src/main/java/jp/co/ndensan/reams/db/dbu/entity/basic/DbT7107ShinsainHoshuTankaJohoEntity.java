package jp.co.ndensan.reams.db.dbu.entity.basic;

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
 * 要介護認定審査員報酬単価情報テーブルのエンティティクラスです。
 */
public class DbT7107ShinsainHoshuTankaJohoEntity extends DbTableEntityBase<DbT7107ShinsainHoshuTankaJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
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
     * 報酬単価適用開始年月日のgetメソッドです。
     * 
     * @return 報酬単価適用開始年月日
     */
    public FlexibleDate getHoshuTankaTekiyoKaishiYMD() {
        return hoshuTankaTekiyoKaishiYMD;
    }

    /**
     * 報酬単価適用開始年月日のsetメソッドです。
     * 
     * @param hoshuTankaTekiyoKaishiYMD 報酬単価適用開始年月日
     */
    public void setHoshuTankaTekiyoKaishiYMD(FlexibleDate hoshuTankaTekiyoKaishiYMD) {
        this.hoshuTankaTekiyoKaishiYMD = hoshuTankaTekiyoKaishiYMD;
    }

    /**
     * 報酬単価適用終了年月日のgetメソッドです。
     * 
     * @return 報酬単価適用終了年月日
     */
    public FlexibleDate getHoshuTankaTekiyoShuryoYMD() {
        return hoshuTankaTekiyoShuryoYMD;
    }

    /**
     * 報酬単価適用終了年月日のsetメソッドです。
     * 
     * @param hoshuTankaTekiyoShuryoYMD 報酬単価適用終了年月日
     */
    public void setHoshuTankaTekiyoShuryoYMD(FlexibleDate hoshuTankaTekiyoShuryoYMD) {
        this.hoshuTankaTekiyoShuryoYMD = hoshuTankaTekiyoShuryoYMD;
    }

    /**
     * 合議体長区分のgetメソッドです。
     * 
     * @return 合議体長区分
     */
    public Code getGogitaiChoKubunCode() {
        return gogitaiChoKubunCode;
    }

    /**
     * 合議体長区分のsetメソッドです。
     * 
     * @param gogitaiChoKubunCode 合議体長区分
     */
    public void setGogitaiChoKubunCode(Code gogitaiChoKubunCode) {
        this.gogitaiChoKubunCode = gogitaiChoKubunCode;
    }

    /**
     * 介護認定審査報酬単価のgetメソッドです。
     * 
     * @return 介護認定審査報酬単価
     */
    public int getNinteiShinsaHoshuTanka() {
        return ninteiShinsaHoshuTanka;
    }

    /**
     * 介護認定審査報酬単価のsetメソッドです。
     * 
     * @param ninteiShinsaHoshuTanka 介護認定審査報酬単価
     */
    public void setNinteiShinsaHoshuTanka(int ninteiShinsaHoshuTanka) {
        this.ninteiShinsaHoshuTanka = ninteiShinsaHoshuTanka;
    }

    /**
     * 課税非課税区分のgetメソッドです。
     * 
     * @return 課税非課税区分
     */
    public RString getKazeiHikazeiKubun() {
        return kazeiHikazeiKubun;
    }

    /**
     * 課税非課税区分のsetメソッドです。
     * 
     * @param kazeiHikazeiKubun 課税非課税区分
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
