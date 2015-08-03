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
 * 要介護認定調査報酬単価情報テーブルのエンティティクラスです。
 */
public class DbT7106NinteichosaHoshuTankaJohoEntity extends DbTableEntityBase<DbT7106NinteichosaHoshuTankaJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7106NinteichosaHoshuTankaJoho");

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
    private Code ninteichosaKubunCode;
    @PrimaryKey
    private RString chosaJisshiBasho;
    private int chosaItakuRyoTanka;
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
     * 認定調査区分のgetメソッドです。
     * 
     * @return 認定調査区分
     */
    public Code getNinteichosaKubunCode() {
        return ninteichosaKubunCode;
    }

    /**
     * 認定調査区分のsetメソッドです。
     * 
     * @param ninteichosaKubunCode 認定調査区分
     */
    public void setNinteichosaKubunCode(Code ninteichosaKubunCode) {
        this.ninteichosaKubunCode = ninteichosaKubunCode;
    }

    /**
     * 認定調査実施場所のgetメソッドです。
     * 
     * @return 認定調査実施場所
     */
    public RString getChosaJisshiBasho() {
        return chosaJisshiBasho;
    }

    /**
     * 認定調査実施場所のsetメソッドです。
     * 
     * @param chosaJisshiBasho 認定調査実施場所
     */
    public void setChosaJisshiBasho(RString chosaJisshiBasho) {
        this.chosaJisshiBasho = chosaJisshiBasho;
    }

    /**
     * 認定調査委託料単価のgetメソッドです。
     * 
     * @return 認定調査委託料単価
     */
    public int getChosaItakuRyoTanka() {
        return chosaItakuRyoTanka;
    }

    /**
     * 認定調査委託料単価のsetメソッドです。
     * 
     * @param chosaItakuRyoTanka 認定調査委託料単価
     */
    public void setChosaItakuRyoTanka(int chosaItakuRyoTanka) {
        this.chosaItakuRyoTanka = chosaItakuRyoTanka;
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
     * このエンティティの主キーが他の{@literal DbT7106NinteichosaHoshuTankaJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7106NinteichosaHoshuTankaJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7106NinteichosaHoshuTankaJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hoshuTankaTekiyoKaishiYMD, other.hoshuTankaTekiyoKaishiYMD)) {
            return false;
        }
        if (!Objects.equals(this.hoshuTankaTekiyoShuryoYMD, other.hoshuTankaTekiyoShuryoYMD)) {
            return false;
        }
        if (!Objects.equals(this.ninteichosaKubunCode, other.ninteichosaKubunCode)) {
            return false;
        }
        if (!Objects.equals(this.chosaJisshiBasho, other.chosaJisshiBasho)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7106NinteichosaHoshuTankaJohoEntity entity) {
        this.hoshuTankaTekiyoKaishiYMD = entity.hoshuTankaTekiyoKaishiYMD;
        this.hoshuTankaTekiyoShuryoYMD = entity.hoshuTankaTekiyoShuryoYMD;
        this.ninteichosaKubunCode = entity.ninteichosaKubunCode;
        this.chosaJisshiBasho = entity.chosaJisshiBasho;
        this.chosaItakuRyoTanka = entity.chosaItakuRyoTanka;
        this.kazeiHikazeiKubun = entity.kazeiHikazeiKubun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hoshuTankaTekiyoKaishiYMD, hoshuTankaTekiyoShuryoYMD, ninteichosaKubunCode, chosaJisshiBasho, chosaItakuRyoTanka, kazeiHikazeiKubun);
    }

// </editor-fold>
}
