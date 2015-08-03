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
 * 要介護認定主治医意見書報酬単価情報テーブルのエンティティクラスです。
 */
public class DbT7108ShujiiIkenshoHoshuTanakaJohoEntity extends DbTableEntityBase<DbT7108ShujiiIkenshoHoshuTanakaJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7108ShujiiIkenshoHoshuTanakaJoho");

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
    private Code ishiKubunCode;
    @PrimaryKey
    private int ikenshoSakuseiKaisu;
    @PrimaryKey
    private RString ikenshoSakuseiryoShubetsu;
    private int shujiiIkenshoSakuseiryoTanka;
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
     * 医師区分のgetメソッドです。
     * 
     * @return 医師区分
     */
    public Code getIshiKubunCode() {
        return ishiKubunCode;
    }

    /**
     * 医師区分のsetメソッドです。
     * 
     * @param ishiKubunCode 医師区分
     */
    public void setIshiKubunCode(Code ishiKubunCode) {
        this.ishiKubunCode = ishiKubunCode;
    }

    /**
     * 意見書作成回数のgetメソッドです。
     * 
     * @return 意見書作成回数
     */
    public int getIkenshoSakuseiKaisu() {
        return ikenshoSakuseiKaisu;
    }

    /**
     * 意見書作成回数のsetメソッドです。
     * 
     * @param ikenshoSakuseiKaisu 意見書作成回数
     */
    public void setIkenshoSakuseiKaisu(int ikenshoSakuseiKaisu) {
        this.ikenshoSakuseiKaisu = ikenshoSakuseiKaisu;
    }

    /**
     * 意見書作成料種別のgetメソッドです。
     * 
     * @return 意見書作成料種別
     */
    public RString getIkenshoSakuseiryoShubetsu() {
        return ikenshoSakuseiryoShubetsu;
    }

    /**
     * 意見書作成料種別のsetメソッドです。
     * 
     * @param ikenshoSakuseiryoShubetsu 意見書作成料種別
     */
    public void setIkenshoSakuseiryoShubetsu(RString ikenshoSakuseiryoShubetsu) {
        this.ikenshoSakuseiryoShubetsu = ikenshoSakuseiryoShubetsu;
    }

    /**
     * 主治医意見書作成料単価のgetメソッドです。
     * 
     * @return 主治医意見書作成料単価
     */
    public int getShujiiIkenshoSakuseiryoTanka() {
        return shujiiIkenshoSakuseiryoTanka;
    }

    /**
     * 主治医意見書作成料単価のsetメソッドです。
     * 
     * @param shujiiIkenshoSakuseiryoTanka 主治医意見書作成料単価
     */
    public void setShujiiIkenshoSakuseiryoTanka(int shujiiIkenshoSakuseiryoTanka) {
        this.shujiiIkenshoSakuseiryoTanka = shujiiIkenshoSakuseiryoTanka;
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
     * このエンティティの主キーが他の{@literal DbT7108ShujiiIkenshoHoshuTanakaJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7108ShujiiIkenshoHoshuTanakaJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7108ShujiiIkenshoHoshuTanakaJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hoshuTankaTekiyoKaishiYMD, other.hoshuTankaTekiyoKaishiYMD)) {
            return false;
        }
        if (!Objects.equals(this.hoshuTankaTekiyoShuryoYMD, other.hoshuTankaTekiyoShuryoYMD)) {
            return false;
        }
        if (!Objects.equals(this.ishiKubunCode, other.ishiKubunCode)) {
            return false;
        }
        if (this.ikenshoSakuseiKaisu != other.ikenshoSakuseiKaisu) {
            return false;
        }
        if (!Objects.equals(this.ikenshoSakuseiryoShubetsu, other.ikenshoSakuseiryoShubetsu)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7108ShujiiIkenshoHoshuTanakaJohoEntity entity) {
        this.hoshuTankaTekiyoKaishiYMD = entity.hoshuTankaTekiyoKaishiYMD;
        this.hoshuTankaTekiyoShuryoYMD = entity.hoshuTankaTekiyoShuryoYMD;
        this.ishiKubunCode = entity.ishiKubunCode;
        this.ikenshoSakuseiKaisu = entity.ikenshoSakuseiKaisu;
        this.ikenshoSakuseiryoShubetsu = entity.ikenshoSakuseiryoShubetsu;
        this.shujiiIkenshoSakuseiryoTanka = entity.shujiiIkenshoSakuseiryoTanka;
        this.kazeiHikazeiKubun = entity.kazeiHikazeiKubun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hoshuTankaTekiyoKaishiYMD, hoshuTankaTekiyoShuryoYMD, ishiKubunCode, ikenshoSakuseiKaisu, ikenshoSakuseiryoShubetsu, shujiiIkenshoSakuseiryoTanka, kazeiHikazeiKubun);
    }

// </editor-fold>
}
