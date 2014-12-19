package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * DbT3066ShichosonTokubetuKyufuServiceの項目定義クラスです
 *
 */
public class DbT3066ShichosonTokubetuKyufuServiceEntity extends DbTableEntityBase<DbT3066ShichosonTokubetuKyufuServiceEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3066ShichosonTokubetuKyufuService");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString serviceCode;
    @PrimaryKey
    private FlexibleDate serviceYukoKikanKaishiYMD;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private RString serviceSeishikiName;
    private RString serviceRyakushoName;
    private FlexibleDate serviceYukoKikanShuryoYMD;
    private RString serviceKubun;
    private Decimal tanisuNissu;
    private Decimal shikyuGendoKijungaku;
    private boolean kyufuritsuHikisageAriFlag;
    private FlexibleDate torokuYMD;
    private FlexibleDate henkoYMD;

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
     * getServiceCode
     * @return serviceCode
     */
    public RString getServiceCode() {
        return serviceCode;
    }

    /**
     * setServiceCode
     * @param serviceCode serviceCode
     */
    public void setServiceCode(RString serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * getServiceYukoKikanKaishiYMD
     * @return serviceYukoKikanKaishiYMD
     */
    public FlexibleDate getServiceYukoKikanKaishiYMD() {
        return serviceYukoKikanKaishiYMD;
    }

    /**
     * setServiceYukoKikanKaishiYMD
     * @param serviceYukoKikanKaishiYMD serviceYukoKikanKaishiYMD
     */
    public void setServiceYukoKikanKaishiYMD(FlexibleDate serviceYukoKikanKaishiYMD) {
        this.serviceYukoKikanKaishiYMD = serviceYukoKikanKaishiYMD;
    }

    /**
     * getShoriTimestamp
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getServiceSeishikiName
     * @return serviceSeishikiName
     */
    public RString getServiceSeishikiName() {
        return serviceSeishikiName;
    }

    /**
     * setServiceSeishikiName
     * @param serviceSeishikiName serviceSeishikiName
     */
    public void setServiceSeishikiName(RString serviceSeishikiName) {
        this.serviceSeishikiName = serviceSeishikiName;
    }

    /**
     * getServiceRyakushoName
     * @return serviceRyakushoName
     */
    public RString getServiceRyakushoName() {
        return serviceRyakushoName;
    }

    /**
     * setServiceRyakushoName
     * @param serviceRyakushoName serviceRyakushoName
     */
    public void setServiceRyakushoName(RString serviceRyakushoName) {
        this.serviceRyakushoName = serviceRyakushoName;
    }

    /**
     * getServiceYukoKikanShuryoYMD
     * @return serviceYukoKikanShuryoYMD
     */
    public FlexibleDate getServiceYukoKikanShuryoYMD() {
        return serviceYukoKikanShuryoYMD;
    }

    /**
     * setServiceYukoKikanShuryoYMD
     * @param serviceYukoKikanShuryoYMD serviceYukoKikanShuryoYMD
     */
    public void setServiceYukoKikanShuryoYMD(FlexibleDate serviceYukoKikanShuryoYMD) {
        this.serviceYukoKikanShuryoYMD = serviceYukoKikanShuryoYMD;
    }

    /**
     * getServiceKubun
     * @return serviceKubun
     */
    public RString getServiceKubun() {
        return serviceKubun;
    }

    /**
     * setServiceKubun
     * @param serviceKubun serviceKubun
     */
    public void setServiceKubun(RString serviceKubun) {
        this.serviceKubun = serviceKubun;
    }

    /**
     * getTanisuNissu
     * @return tanisuNissu
     */
    public Decimal getTanisuNissu() {
        return tanisuNissu;
    }

    /**
     * setTanisuNissu
     * @param tanisuNissu tanisuNissu
     */
    public void setTanisuNissu(Decimal tanisuNissu) {
        this.tanisuNissu = tanisuNissu;
    }

    /**
     * getShikyuGendoKijungaku
     * @return shikyuGendoKijungaku
     */
    public Decimal getShikyuGendoKijungaku() {
        return shikyuGendoKijungaku;
    }

    /**
     * setShikyuGendoKijungaku
     * @param shikyuGendoKijungaku shikyuGendoKijungaku
     */
    public void setShikyuGendoKijungaku(Decimal shikyuGendoKijungaku) {
        this.shikyuGendoKijungaku = shikyuGendoKijungaku;
    }

    /**
     * getKyufuritsuHikisageAriFlag
     * @return kyufuritsuHikisageAriFlag
     */
    public boolean getKyufuritsuHikisageAriFlag() {
        return kyufuritsuHikisageAriFlag;
    }

    /**
     * setKyufuritsuHikisageAriFlag
     * @param kyufuritsuHikisageAriFlag kyufuritsuHikisageAriFlag
     */
    public void setKyufuritsuHikisageAriFlag(boolean kyufuritsuHikisageAriFlag) {
        this.kyufuritsuHikisageAriFlag = kyufuritsuHikisageAriFlag;
    }

    /**
     * getTorokuYMD
     * @return torokuYMD
     */
    public FlexibleDate getTorokuYMD() {
        return torokuYMD;
    }

    /**
     * setTorokuYMD
     * @param torokuYMD torokuYMD
     */
    public void setTorokuYMD(FlexibleDate torokuYMD) {
        this.torokuYMD = torokuYMD;
    }

    /**
     * getHenkoYMD
     * @return henkoYMD
     */
    public FlexibleDate getHenkoYMD() {
        return henkoYMD;
    }

    /**
     * setHenkoYMD
     * @param henkoYMD henkoYMD
     */
    public void setHenkoYMD(FlexibleDate henkoYMD) {
        this.henkoYMD = henkoYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3066ShichosonTokubetuKyufuServiceEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3066ShichosonTokubetuKyufuServiceEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3066ShichosonTokubetuKyufuServiceEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.serviceCode, other.serviceCode)) {
            return false;
        }
        if (!Objects.equals(this.serviceYukoKikanKaishiYMD, other.serviceYukoKikanKaishiYMD)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3066ShichosonTokubetuKyufuServiceEntity entity) {
        this.serviceCode = entity.serviceCode;
        this.serviceYukoKikanKaishiYMD = entity.serviceYukoKikanKaishiYMD;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.serviceSeishikiName = entity.serviceSeishikiName;
        this.serviceRyakushoName = entity.serviceRyakushoName;
        this.serviceYukoKikanShuryoYMD = entity.serviceYukoKikanShuryoYMD;
        this.serviceKubun = entity.serviceKubun;
        this.tanisuNissu = entity.tanisuNissu;
        this.shikyuGendoKijungaku = entity.shikyuGendoKijungaku;
        this.kyufuritsuHikisageAriFlag = entity.kyufuritsuHikisageAriFlag;
        this.torokuYMD = entity.torokuYMD;
        this.henkoYMD = entity.henkoYMD;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(serviceCode, serviceYukoKikanKaishiYMD, shoriTimestamp, serviceSeishikiName, serviceRyakushoName, serviceYukoKikanShuryoYMD, serviceKubun, tanisuNissu, shikyuGendoKijungaku, kyufuritsuHikisageAriFlag, torokuYMD, henkoYMD);
    }

// </editor-fold>

}
