package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * 市町村特別給付サービス内容テーブルのエンティティクラスです。
 */
public class DbT3066ShichosonTokubetuKyufuServiceEntity extends DbTableEntityBase<DbT3066ShichosonTokubetuKyufuServiceEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
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
    private int rirekiNo;
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
     * 市町村特別給付用サービスコードのgetメソッドです。
     * 
     * @return 市町村特別給付用サービスコード
     */
    public RString getServiceCode() {
        return serviceCode;
    }

    /**
     * 市町村特別給付用サービスコードのsetメソッドです。
     * 
     * @param serviceCode 市町村特別給付用サービスコード
     */
    public void setServiceCode(RString serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * 市町村特別給付用サービス有効期間開始年月日のgetメソッドです。
     * 
     * @return 市町村特別給付用サービス有効期間開始年月日
     */
    public FlexibleDate getServiceYukoKikanKaishiYMD() {
        return serviceYukoKikanKaishiYMD;
    }

    /**
     * 市町村特別給付用サービス有効期間開始年月日のsetメソッドです。
     * 
     * @param serviceYukoKikanKaishiYMD 市町村特別給付用サービス有効期間開始年月日
     */
    public void setServiceYukoKikanKaishiYMD(FlexibleDate serviceYukoKikanKaishiYMD) {
        this.serviceYukoKikanKaishiYMD = serviceYukoKikanKaishiYMD;
    }

    /**
     * 履歴番号のgetメソッドです。
     * 
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     * 
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 市町村特別給付用サービス名（正式名称）のgetメソッドです。
     * 
     * @return 市町村特別給付用サービス名（正式名称）
     */
    public RString getServiceSeishikiName() {
        return serviceSeishikiName;
    }

    /**
     * 市町村特別給付用サービス名（正式名称）のsetメソッドです。
     * 
     * @param serviceSeishikiName 市町村特別給付用サービス名（正式名称）
     */
    public void setServiceSeishikiName(RString serviceSeishikiName) {
        this.serviceSeishikiName = serviceSeishikiName;
    }

    /**
     * 市町村特別給付用サービス名（略称）のgetメソッドです。
     * 
     * @return 市町村特別給付用サービス名（略称）
     */
    public RString getServiceRyakushoName() {
        return serviceRyakushoName;
    }

    /**
     * 市町村特別給付用サービス名（略称）のsetメソッドです。
     * 
     * @param serviceRyakushoName 市町村特別給付用サービス名（略称）
     */
    public void setServiceRyakushoName(RString serviceRyakushoName) {
        this.serviceRyakushoName = serviceRyakushoName;
    }

    /**
     * 市町村特別給付用サービス有効期間終了年月日のgetメソッドです。
     * 
     * @return 市町村特別給付用サービス有効期間終了年月日
     */
    public FlexibleDate getServiceYukoKikanShuryoYMD() {
        return serviceYukoKikanShuryoYMD;
    }

    /**
     * 市町村特別給付用サービス有効期間終了年月日のsetメソッドです。
     * 
     * @param serviceYukoKikanShuryoYMD 市町村特別給付用サービス有効期間終了年月日
     */
    public void setServiceYukoKikanShuryoYMD(FlexibleDate serviceYukoKikanShuryoYMD) {
        this.serviceYukoKikanShuryoYMD = serviceYukoKikanShuryoYMD;
    }

    /**
     * 市町村特別給付用サービス区分のgetメソッドです。
     * <br/>
     * <br/>単位、日数
     * 
     * @return 市町村特別給付用サービス区分
     */
    public RString getServiceKubun() {
        return serviceKubun;
    }

    /**
     * 市町村特別給付用サービス区分のsetメソッドです。
     * <br/>
     * <br/>単位、日数
     * 
     * @param serviceKubun 市町村特別給付用サービス区分
     */
    public void setServiceKubun(RString serviceKubun) {
        this.serviceKubun = serviceKubun;
    }

    /**
     * 市町村特別給付用単位・日数のgetメソッドです。
     * <br/>
     * <br/>サービスの1回あたりの単位数
     * 
     * @return 市町村特別給付用単位・日数
     */
    public Decimal getTanisuNissu() {
        return tanisuNissu;
    }

    /**
     * 市町村特別給付用単位・日数のsetメソッドです。
     * <br/>
     * <br/>サービスの1回あたりの単位数
     * 
     * @param tanisuNissu 市町村特別給付用単位・日数
     */
    public void setTanisuNissu(Decimal tanisuNissu) {
        this.tanisuNissu = tanisuNissu;
    }

    /**
     * 市町村特別給付用支給限度基準額のgetメソッドです。
     * <br/>
     * <br/>サービスの支給限度基準額（月あたり）
     * 
     * @return 市町村特別給付用支給限度基準額
     */
    public Decimal getShikyuGendoKijungaku() {
        return shikyuGendoKijungaku;
    }

    /**
     * 市町村特別給付用支給限度基準額のsetメソッドです。
     * <br/>
     * <br/>サービスの支給限度基準額（月あたり）
     * 
     * @param shikyuGendoKijungaku 市町村特別給付用支給限度基準額
     */
    public void setShikyuGendoKijungaku(Decimal shikyuGendoKijungaku) {
        this.shikyuGendoKijungaku = shikyuGendoKijungaku;
    }

    /**
     * 市町村特別給付用給付率引下有フラグのgetメソッドです。
     * 
     * @return 市町村特別給付用給付率引下有フラグ
     */
    public boolean getKyufuritsuHikisageAriFlag() {
        return kyufuritsuHikisageAriFlag;
    }

    /**
     * 市町村特別給付用給付率引下有フラグのsetメソッドです。
     * 
     * @param kyufuritsuHikisageAriFlag 市町村特別給付用給付率引下有フラグ
     */
    public void setKyufuritsuHikisageAriFlag(boolean kyufuritsuHikisageAriFlag) {
        this.kyufuritsuHikisageAriFlag = kyufuritsuHikisageAriFlag;
    }

    /**
     * 登録年月日のgetメソッドです。
     * 
     * @return 登録年月日
     */
    public FlexibleDate getTorokuYMD() {
        return torokuYMD;
    }

    /**
     * 登録年月日のsetメソッドです。
     * 
     * @param torokuYMD 登録年月日
     */
    public void setTorokuYMD(FlexibleDate torokuYMD) {
        this.torokuYMD = torokuYMD;
    }

    /**
     * 変更年月日のgetメソッドです。
     * 
     * @return 変更年月日
     */
    public FlexibleDate getHenkoYMD() {
        return henkoYMD;
    }

    /**
     * 変更年月日のsetメソッドです。
     * 
     * @param henkoYMD 変更年月日
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
        if (this.rirekiNo != other.rirekiNo) {
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
        this.rirekiNo = entity.rirekiNo;
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
        return super.toMd5(serviceCode, serviceYukoKikanKaishiYMD, rirekiNo, serviceSeishikiName, serviceRyakushoName, serviceYukoKikanShuryoYMD, serviceKubun, tanisuNissu, shikyuGendoKijungaku, kyufuritsuHikisageAriFlag, torokuYMD, henkoYMD);
    }

// </editor-fold>
}
