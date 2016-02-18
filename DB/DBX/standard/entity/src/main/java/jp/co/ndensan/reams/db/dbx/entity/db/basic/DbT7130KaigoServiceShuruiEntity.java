package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;

/**
 * 介護サービス種類テーブルのエンティティクラスです。
 * <br/> 介護サービス種類を管理します
 */
public class DbT7130KaigoServiceShuruiEntity extends DbTableEntityBase<DbT7130KaigoServiceShuruiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7130KaigoServiceShurui");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ServiceShuruiCode serviceShuruiCd;
    @PrimaryKey
    private FlexibleYearMonth teikyoKaishiYM;
    private FlexibleYearMonth teikyoshuryoYM;
    private RString serviceShuruiMeisho;
    private RString serviceShuruiRyakusho;
    private Code serviceBunrruicode;
    private ServiceShuruiCode serviceShuruiNaibuCd;
    private RString gendogakuKubun;
    private RString yusenJuni;
    private RString kyotakuServiceKubun;
    private RString shiteiServiceKubun;
    private RString kijunGaitoServiceKubun;
    private RString minashiKubun;
    private RString gamenHyojiKubun;
    private RString shien1InKahiKubun;
    private RString shien2InKahiKubun;
    private RString nijiyoboInKahiKubun;
    private RString serviceShoBunrui;

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
     * サービス種類コードのgetメソッドです。
     * 
     * @return サービス種類コード
     */
    public ServiceShuruiCode getServiceShuruiCd() {
        return serviceShuruiCd;
    }

    /**
     * サービス種類コードのsetメソッドです。
     * 
     * @param serviceShuruiCd サービス種類コード
     */
    public void setServiceShuruiCd(@Nonnull ServiceShuruiCode serviceShuruiCd) {
        this.serviceShuruiCd = serviceShuruiCd;
    }

    /**
     * 提供開始年月のgetメソッドです。
     * 
     * @return 提供開始年月
     */
    public FlexibleYearMonth getTeikyoKaishiYM() {
        return teikyoKaishiYM;
    }

    /**
     * 提供開始年月のsetメソッドです。
     * 
     * @param teikyoKaishiYM 提供開始年月
     */
    public void setTeikyoKaishiYM(@Nonnull FlexibleYearMonth teikyoKaishiYM) {
        this.teikyoKaishiYM = teikyoKaishiYM;
    }

    /**
     * 提供終了年月のgetメソッドです。
     * 
     * @return 提供終了年月
     */
    @CheckForNull
    public FlexibleYearMonth getTeikyoshuryoYM() {
        return teikyoshuryoYM;
    }

    /**
     * 提供終了年月のsetメソッドです。
     * 
     * @param teikyoshuryoYM 提供終了年月
     */
    public void setTeikyoshuryoYM(FlexibleYearMonth teikyoshuryoYM) {
        this.teikyoshuryoYM = teikyoshuryoYM;
    }

    /**
     * サービス種類名称のgetメソッドです。
     * 
     * @return サービス種類名称
     */
    public RString getServiceShuruiMeisho() {
        return serviceShuruiMeisho;
    }

    /**
     * サービス種類名称のsetメソッドです。
     * 
     * @param serviceShuruiMeisho サービス種類名称
     */
    public void setServiceShuruiMeisho(@Nonnull RString serviceShuruiMeisho) {
        this.serviceShuruiMeisho = serviceShuruiMeisho;
    }

    /**
     * サービス種類略称のgetメソッドです。
     * 
     * @return サービス種類略称
     */
    @CheckForNull
    public RString getServiceShuruiRyakusho() {
        return serviceShuruiRyakusho;
    }

    /**
     * サービス種類略称のsetメソッドです。
     * 
     * @param serviceShuruiRyakusho サービス種類略称
     */
    public void setServiceShuruiRyakusho(RString serviceShuruiRyakusho) {
        this.serviceShuruiRyakusho = serviceShuruiRyakusho;
    }

    /**
     * サービス分類コードのgetメソッドです。
     * <br/>
     * <br/>共通コード＜サブ業務：DBZ、種別：0020＞
     * 
     * @return サービス分類コード
     */
    public Code getServiceBunrruicode() {
        return serviceBunrruicode;
    }

    /**
     * サービス分類コードのsetメソッドです。
     * <br/>
     * <br/>共通コード＜サブ業務：DBZ、種別：0020＞
     * 
     * @param serviceBunrruicode サービス分類コード
     */
    public void setServiceBunrruicode(@Nonnull Code serviceBunrruicode) {
        this.serviceBunrruicode = serviceBunrruicode;
    }

    /**
     * サービス種類内部コードのgetメソッドです。
     * 
     * @return サービス種類内部コード
     */
    @CheckForNull
    public ServiceShuruiCode getServiceShuruiNaibuCd() {
        return serviceShuruiNaibuCd;
    }

    /**
     * サービス種類内部コードのsetメソッドです。
     * 
     * @param serviceShuruiNaibuCd サービス種類内部コード
     */
    public void setServiceShuruiNaibuCd(ServiceShuruiCode serviceShuruiNaibuCd) {
        this.serviceShuruiNaibuCd = serviceShuruiNaibuCd;
    }

    /**
     * 限度額区分のgetメソッドです。
     * <br/>
     * <br/>1：種類支給限度額認定可能対象、0：種類支給限度額認定可能対象外
     * 
     * @return 限度額区分
     */
    public RString getGendogakuKubun() {
        return gendogakuKubun;
    }

    /**
     * 限度額区分のsetメソッドです。
     * <br/>
     * <br/>1：種類支給限度額認定可能対象、0：種類支給限度額認定可能対象外
     * 
     * @param gendogakuKubun 限度額区分
     */
    public void setGendogakuKubun(@Nonnull RString gendogakuKubun) {
        this.gendogakuKubun = gendogakuKubun;
    }

    /**
     * 優先順位のgetメソッドです。
     * 
     * @return 優先順位
     */
    @CheckForNull
    public RString getYusenJuni() {
        return yusenJuni;
    }

    /**
     * 優先順位のsetメソッドです。
     * 
     * @param yusenJuni 優先順位
     */
    public void setYusenJuni(RString yusenJuni) {
        this.yusenJuni = yusenJuni;
    }

    /**
     * 居宅サービス区分のgetメソッドです。
     * <br/>
     * <br/>0：区分支給限度額対象外、1：訪問通所系区分限度額対象、2：短期入所系区分限度額対象
     * 
     * @return 居宅サービス区分
     */
    public RString getKyotakuServiceKubun() {
        return kyotakuServiceKubun;
    }

    /**
     * 居宅サービス区分のsetメソッドです。
     * <br/>
     * <br/>0：区分支給限度額対象外、1：訪問通所系区分限度額対象、2：短期入所系区分限度額対象
     * 
     * @param kyotakuServiceKubun 居宅サービス区分
     */
    public void setKyotakuServiceKubun(@Nonnull RString kyotakuServiceKubun) {
        this.kyotakuServiceKubun = kyotakuServiceKubun;
    }

    /**
     * 指定サービス区分のgetメソッドです。
     * <br/>
     * <br/>1：事業所指定対象サービス該当、0：事業所指定対象サービス非該当
     * 
     * @return 指定サービス区分
     */
    public RString getShiteiServiceKubun() {
        return shiteiServiceKubun;
    }

    /**
     * 指定サービス区分のsetメソッドです。
     * <br/>
     * <br/>1：事業所指定対象サービス該当、0：事業所指定対象サービス非該当
     * 
     * @param shiteiServiceKubun 指定サービス区分
     */
    public void setShiteiServiceKubun(@Nonnull RString shiteiServiceKubun) {
        this.shiteiServiceKubun = shiteiServiceKubun;
    }

    /**
     * 基準該当サービス区分のgetメソッドです。
     * <br/>
     * <br/>1：基準該当対象サービス該当、0：基準該当対象サービス非該当
     * 
     * @return 基準該当サービス区分
     */
    public RString getKijunGaitoServiceKubun() {
        return kijunGaitoServiceKubun;
    }

    /**
     * 基準該当サービス区分のsetメソッドです。
     * <br/>
     * <br/>1：基準該当対象サービス該当、0：基準該当対象サービス非該当
     * 
     * @param kijunGaitoServiceKubun 基準該当サービス区分
     */
    public void setKijunGaitoServiceKubun(@Nonnull RString kijunGaitoServiceKubun) {
        this.kijunGaitoServiceKubun = kijunGaitoServiceKubun;
    }

    /**
     * みなし区分のgetメソッドです。
     * <br/>
     * <br/>1:（地域密着型サービスの）みなし指定、0:みなし指定なし
     * 
     * @return みなし区分
     */
    @CheckForNull
    public RString getMinashiKubun() {
        return minashiKubun;
    }

    /**
     * みなし区分のsetメソッドです。
     * <br/>
     * <br/>1:（地域密着型サービスの）みなし指定、0:みなし指定なし
     * 
     * @param minashiKubun みなし区分
     */
    public void setMinashiKubun(RString minashiKubun) {
        this.minashiKubun = minashiKubun;
    }

    /**
     * 画面表示区分のgetメソッドです。
     * <br/>
     * <br/>0:表示しない、1:表示する
     * 
     * @return 画面表示区分
     */
    @CheckForNull
    public RString getGamenHyojiKubun() {
        return gamenHyojiKubun;
    }

    /**
     * 画面表示区分のsetメソッドです。
     * <br/>
     * <br/>0:表示しない、1:表示する
     * 
     * @param gamenHyojiKubun 画面表示区分
     */
    public void setGamenHyojiKubun(RString gamenHyojiKubun) {
        this.gamenHyojiKubun = gamenHyojiKubun;
    }

    /**
     * 要支援１入力可否区分のgetメソッドです。
     * <br/>
     * <br/>1：入力可、0：入力不可
     * 
     * @return 要支援１入力可否区分
     */
    @CheckForNull
    public RString getShien1InKahiKubun() {
        return shien1InKahiKubun;
    }

    /**
     * 要支援１入力可否区分のsetメソッドです。
     * <br/>
     * <br/>1：入力可、0：入力不可
     * 
     * @param shien1InKahiKubun 要支援１入力可否区分
     */
    public void setShien1InKahiKubun(RString shien1InKahiKubun) {
        this.shien1InKahiKubun = shien1InKahiKubun;
    }

    /**
     * 要支援２入力可否区分のgetメソッドです。
     * <br/>
     * <br/>1：入力可、0：入力不可
     * 
     * @return 要支援２入力可否区分
     */
    @CheckForNull
    public RString getShien2InKahiKubun() {
        return shien2InKahiKubun;
    }

    /**
     * 要支援２入力可否区分のsetメソッドです。
     * <br/>
     * <br/>1：入力可、0：入力不可
     * 
     * @param shien2InKahiKubun 要支援２入力可否区分
     */
    public void setShien2InKahiKubun(RString shien2InKahiKubun) {
        this.shien2InKahiKubun = shien2InKahiKubun;
    }

    /**
     * 二次予防入力可否区分のgetメソッドです。
     * <br/>
     * <br/>1：入力可、0：入力不可
     * 
     * @return 二次予防入力可否区分
     */
    @CheckForNull
    public RString getNijiyoboInKahiKubun() {
        return nijiyoboInKahiKubun;
    }

    /**
     * 二次予防入力可否区分のsetメソッドです。
     * <br/>
     * <br/>1：入力可、0：入力不可
     * 
     * @param nijiyoboInKahiKubun 二次予防入力可否区分
     */
    public void setNijiyoboInKahiKubun(RString nijiyoboInKahiKubun) {
        this.nijiyoboInKahiKubun = nijiyoboInKahiKubun;
    }

    /**
     * サービス小分類のgetメソッドです。
     * <br/>
     * <br/>0：みなしサービス（サービス種類：A1、A5）、1：保険者独自サービス（サービス種類：A2、A6、AF）、2：保険者独自（定率）サービス（サービス種類：A3、A7、A9、AB、AD）、3：保険者独自（定額）サービス
     * 
     * @return サービス小分類
     */
    @CheckForNull
    public RString getServiceShoBunrui() {
        return serviceShoBunrui;
    }

    /**
     * サービス小分類のsetメソッドです。
     * <br/>
     * <br/>0：みなしサービス（サービス種類：A1、A5）、1：保険者独自サービス（サービス種類：A2、A6、AF）、2：保険者独自（定率）サービス（サービス種類：A3、A7、A9、AB、AD）、3：保険者独自（定額）サービス
     * 
     * @param serviceShoBunrui サービス小分類
     */
    public void setServiceShoBunrui(RString serviceShoBunrui) {
        this.serviceShoBunrui = serviceShoBunrui;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7130KaigoServiceShuruiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7130KaigoServiceShuruiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7130KaigoServiceShuruiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.serviceShuruiCd, other.serviceShuruiCd)) {
            return false;
        }
        if (!Objects.equals(this.teikyoKaishiYM, other.teikyoKaishiYM)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7130KaigoServiceShuruiEntity entity) {
        this.serviceShuruiCd = entity.serviceShuruiCd;
        this.teikyoKaishiYM = entity.teikyoKaishiYM;
        this.teikyoshuryoYM = entity.teikyoshuryoYM;
        this.serviceShuruiMeisho = entity.serviceShuruiMeisho;
        this.serviceShuruiRyakusho = entity.serviceShuruiRyakusho;
        this.serviceBunrruicode = entity.serviceBunrruicode;
        this.serviceShuruiNaibuCd = entity.serviceShuruiNaibuCd;
        this.gendogakuKubun = entity.gendogakuKubun;
        this.yusenJuni = entity.yusenJuni;
        this.kyotakuServiceKubun = entity.kyotakuServiceKubun;
        this.shiteiServiceKubun = entity.shiteiServiceKubun;
        this.kijunGaitoServiceKubun = entity.kijunGaitoServiceKubun;
        this.minashiKubun = entity.minashiKubun;
        this.gamenHyojiKubun = entity.gamenHyojiKubun;
        this.shien1InKahiKubun = entity.shien1InKahiKubun;
        this.shien2InKahiKubun = entity.shien2InKahiKubun;
        this.nijiyoboInKahiKubun = entity.nijiyoboInKahiKubun;
        this.serviceShoBunrui = entity.serviceShoBunrui;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(serviceShuruiCd, teikyoKaishiYM, teikyoshuryoYM, serviceShuruiMeisho, serviceShuruiRyakusho, serviceBunrruicode, serviceShuruiNaibuCd, gendogakuKubun, yusenJuni, kyotakuServiceKubun, shiteiServiceKubun, kijunGaitoServiceKubun, minashiKubun, gamenHyojiKubun, shien1InKahiKubun, shien2InKahiKubun, nijiyoboInKahiKubun, serviceShoBunrui);
    }

// </editor-fold>

}
