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
 * DbT7108ShujiiIkenshoHoshuTanakaJohoの項目定義クラスです
 *
 */
public class DbT7108ShujiiIkenshoHoshuTanakaJohoEntity extends DbTableEntityBase<DbT7108ShujiiIkenshoHoshuTanakaJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
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
     * getIshiKubunCode
     * @return ishiKubunCode
     */
    public Code getIshiKubunCode() {
        return ishiKubunCode;
    }

    /**
     * setIshiKubunCode
     * @param ishiKubunCode ishiKubunCode
     */
    public void setIshiKubunCode(Code ishiKubunCode) {
        this.ishiKubunCode = ishiKubunCode;
    }

    /**
     * getIkenshoSakuseiKaisu
     * @return ikenshoSakuseiKaisu
     */
    public int getIkenshoSakuseiKaisu() {
        return ikenshoSakuseiKaisu;
    }

    /**
     * setIkenshoSakuseiKaisu
     * @param ikenshoSakuseiKaisu ikenshoSakuseiKaisu
     */
    public void setIkenshoSakuseiKaisu(int ikenshoSakuseiKaisu) {
        this.ikenshoSakuseiKaisu = ikenshoSakuseiKaisu;
    }

    /**
     * getIkenshoSakuseiryoShubetsu
     * @return ikenshoSakuseiryoShubetsu
     */
    public RString getIkenshoSakuseiryoShubetsu() {
        return ikenshoSakuseiryoShubetsu;
    }

    /**
     * setIkenshoSakuseiryoShubetsu
     * @param ikenshoSakuseiryoShubetsu ikenshoSakuseiryoShubetsu
     */
    public void setIkenshoSakuseiryoShubetsu(RString ikenshoSakuseiryoShubetsu) {
        this.ikenshoSakuseiryoShubetsu = ikenshoSakuseiryoShubetsu;
    }

    /**
     * getShujiiIkenshoSakuseiryoTanka
     * @return shujiiIkenshoSakuseiryoTanka
     */
    public int getShujiiIkenshoSakuseiryoTanka() {
        return shujiiIkenshoSakuseiryoTanka;
    }

    /**
     * setShujiiIkenshoSakuseiryoTanka
     * @param shujiiIkenshoSakuseiryoTanka shujiiIkenshoSakuseiryoTanka
     */
    public void setShujiiIkenshoSakuseiryoTanka(int shujiiIkenshoSakuseiryoTanka) {
        this.shujiiIkenshoSakuseiryoTanka = shujiiIkenshoSakuseiryoTanka;
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
