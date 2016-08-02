package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 介護予防・日常生活支援総合事業サービスコードテーブルのエンティティクラスです。
 */
public class DbT7122SogoJigyoServiceCodeEntity extends DbTableEntityBase<DbT7122SogoJigyoServiceCodeEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7122SogoJigyoServiceCode");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ServiceShuruiCode serviceShuruiCode;
    @PrimaryKey
    private ServiceKomokuCode serviceKomokuCode;
    @PrimaryKey
    private FlexibleYearMonth tekiyoKaishiYM;
    @PrimaryKey
    private int rirekiNo;
    private FlexibleYearMonth tekiyoShuryoYM;
    private RString serviceMeisho;
    private Decimal taniSu;
    private RString gendoGakuTaishogaiFlag;
    private RString taniSuShikibetsuCode;
    private RString gaibuServiceRiyoKubun;
    private RString tokubetsuChiikiKasanFlag;
    private RString teiRitsu_TeiGakuKubun;
    private Decimal riyoshaFutanGaku;
    private HokenKyufuRitsu kyufuRitsu;
    private RString nijiYoboTaishosha_JissiKubun;
    private RString yoShien1_JisshiKubun;
    private RString yoShien2_JisshiKubun;
    private RString taishoJigyosha_JisshiKubun;
    private RString santeiTaniKubun;
    private int seigenNissuKaisu;
    private RString santeiKaisuSeigenKikanKubun;
    private RString sofuKubun;
    private FlexibleYearMonth sofuYM;
    private FlexibleDate shinkiHenkoIdoYMD;
    private FlexibleDate shuryoIdoYMD;

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
    public ServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * サービス種類コードのsetメソッドです。
     * 
     * @param serviceShuruiCode サービス種類コード
     */
    public void setServiceShuruiCode(@Nonnull ServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * サービス項目コードのgetメソッドです。
     * 
     * @return サービス項目コード
     */
    public ServiceKomokuCode getServiceKomokuCode() {
        return serviceKomokuCode;
    }

    /**
     * サービス項目コードのsetメソッドです。
     * 
     * @param serviceKomokuCode サービス項目コード
     */
    public void setServiceKomokuCode(@Nonnull ServiceKomokuCode serviceKomokuCode) {
        this.serviceKomokuCode = serviceKomokuCode;
    }

    /**
     * 適用開始年月のgetメソッドです。
     * 
     * @return 適用開始年月
     */
    public FlexibleYearMonth getTekiyoKaishiYM() {
        return tekiyoKaishiYM;
    }

    /**
     * 適用開始年月のsetメソッドです。
     * 
     * @param tekiyoKaishiYM 適用開始年月
     */
    public void setTekiyoKaishiYM(@Nonnull FlexibleYearMonth tekiyoKaishiYM) {
        this.tekiyoKaishiYM = tekiyoKaishiYM;
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
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 適用終了年月のgetメソッドです。
     * 
     * @return 適用終了年月
     */
    @CheckForNull
    public FlexibleYearMonth getTekiyoShuryoYM() {
        return tekiyoShuryoYM;
    }

    /**
     * 適用終了年月のsetメソッドです。
     * 
     * @param tekiyoShuryoYM 適用終了年月
     */
    public void setTekiyoShuryoYM(FlexibleYearMonth tekiyoShuryoYM) {
        this.tekiyoShuryoYM = tekiyoShuryoYM;
    }

    /**
     * サービス名称のgetメソッドです。
     * 
     * @return サービス名称
     */
    @CheckForNull
    public RString getServiceMeisho() {
        return serviceMeisho;
    }

    /**
     * サービス名称のsetメソッドです。
     * 
     * @param serviceMeisho サービス名称
     */
    public void setServiceMeisho(RString serviceMeisho) {
        this.serviceMeisho = serviceMeisho;
    }

    /**
     * 単位数のgetメソッドです。
     * 
     * @return 単位数
     */
    @CheckForNull
    public Decimal getTaniSu() {
        return taniSu;
    }

    /**
     * 単位数のsetメソッドです。
     * 
     * @param taniSu 単位数
     */
    public void setTaniSu(Decimal taniSu) {
        this.taniSu = taniSu;
    }

    /**
     * 限度額対象外フラグのgetメソッドです。
     * 
     * @return 限度額対象外フラグ
     */
    @CheckForNull
    public RString getGendoGakuTaishogaiFlag() {
        return gendoGakuTaishogaiFlag;
    }

    /**
     * 限度額対象外フラグのsetメソッドです。
     * 
     * @param gendoGakuTaishogaiFlag 限度額対象外フラグ
     */
    public void setGendoGakuTaishogaiFlag(RString gendoGakuTaishogaiFlag) {
        this.gendoGakuTaishogaiFlag = gendoGakuTaishogaiFlag;
    }

    /**
     * 単位数識別コードのgetメソッドです。
     * 
     * @return 単位数識別コード
     */
    @CheckForNull
    public RString getTaniSuShikibetsuCode() {
        return taniSuShikibetsuCode;
    }

    /**
     * 単位数識別コードのsetメソッドです。
     * 
     * @param taniSuShikibetsuCode 単位数識別コード
     */
    public void setTaniSuShikibetsuCode(RString taniSuShikibetsuCode) {
        this.taniSuShikibetsuCode = taniSuShikibetsuCode;
    }

    /**
     * 外部サービス利用型区分のgetメソッドです。
     * 
     * @return 外部サービス利用型区分
     */
    @CheckForNull
    public RString getGaibuServiceRiyoKubun() {
        return gaibuServiceRiyoKubun;
    }

    /**
     * 外部サービス利用型区分のsetメソッドです。
     * 
     * @param gaibuServiceRiyoKubun 外部サービス利用型区分
     */
    public void setGaibuServiceRiyoKubun(RString gaibuServiceRiyoKubun) {
        this.gaibuServiceRiyoKubun = gaibuServiceRiyoKubun;
    }

    /**
     * 特別地域加算フラグのgetメソッドです。
     * 
     * @return 特別地域加算フラグ
     */
    @CheckForNull
    public RString getTokubetsuChiikiKasanFlag() {
        return tokubetsuChiikiKasanFlag;
    }

    /**
     * 特別地域加算フラグのsetメソッドです。
     * 
     * @param tokubetsuChiikiKasanFlag 特別地域加算フラグ
     */
    public void setTokubetsuChiikiKasanFlag(RString tokubetsuChiikiKasanFlag) {
        this.tokubetsuChiikiKasanFlag = tokubetsuChiikiKasanFlag;
    }

    /**
     * 利用者負担定率／定額区分のgetメソッドです。
     * 
     * @return 利用者負担定率／定額区分
     */
    @CheckForNull
    public RString getTeiRitsu_TeiGakuKubun() {
        return teiRitsu_TeiGakuKubun;
    }

    /**
     * 利用者負担定率／定額区分のsetメソッドです。
     * 
     * @param teiRitsu_TeiGakuKubun 利用者負担定率／定額区分
     */
    public void setTeiRitsu_TeiGakuKubun(RString teiRitsu_TeiGakuKubun) {
        this.teiRitsu_TeiGakuKubun = teiRitsu_TeiGakuKubun;
    }

    /**
     * 利用者負担額のgetメソッドです。
     * <br/>
     * <br/>利用者負担定率／定額区分が”2”（定額）時
     * 
     * @return 利用者負担額
     */
    @CheckForNull
    public Decimal getRiyoshaFutanGaku() {
        return riyoshaFutanGaku;
    }

    /**
     * 利用者負担額のsetメソッドです。
     * <br/>
     * <br/>利用者負担定率／定額区分が”2”（定額）時
     * 
     * @param riyoshaFutanGaku 利用者負担額
     */
    public void setRiyoshaFutanGaku(Decimal riyoshaFutanGaku) {
        this.riyoshaFutanGaku = riyoshaFutanGaku;
    }

    /**
     * 給付率のgetメソッドです。
     * <br/>
     * <br/>利用者負担定率／定額区分が”1”（定率）時
     * 
     * @return 給付率
     */
    @CheckForNull
    public HokenKyufuRitsu getKyufuRitsu() {
        return kyufuRitsu;
    }

    /**
     * 給付率のsetメソッドです。
     * <br/>
     * <br/>利用者負担定率／定額区分が”1”（定率）時
     * 
     * @param kyufuRitsu 給付率
     */
    public void setKyufuRitsu(HokenKyufuRitsu kyufuRitsu) {
        this.kyufuRitsu = kyufuRitsu;
    }

    /**
     * 二次予防事業対象者実施区分のgetメソッドです。
     * 
     * @return 二次予防事業対象者実施区分
     */
    @CheckForNull
    public RString getNijiYoboTaishosha_JissiKubun() {
        return nijiYoboTaishosha_JissiKubun;
    }

    /**
     * 二次予防事業対象者実施区分のsetメソッドです。
     * 
     * @param nijiYoboTaishosha_JissiKubun 二次予防事業対象者実施区分
     */
    public void setNijiYoboTaishosha_JissiKubun(RString nijiYoboTaishosha_JissiKubun) {
        this.nijiYoboTaishosha_JissiKubun = nijiYoboTaishosha_JissiKubun;
    }

    /**
     * 要支援１受給者実施区分のgetメソッドです。
     * 
     * @return 要支援１受給者実施区分
     */
    @CheckForNull
    public RString getYoShien1_JisshiKubun() {
        return yoShien1_JisshiKubun;
    }

    /**
     * 要支援１受給者実施区分のsetメソッドです。
     * 
     * @param yoShien1_JisshiKubun 要支援１受給者実施区分
     */
    public void setYoShien1_JisshiKubun(RString yoShien1_JisshiKubun) {
        this.yoShien1_JisshiKubun = yoShien1_JisshiKubun;
    }

    /**
     * 要支援２受給者実施区分のgetメソッドです。
     * 
     * @return 要支援２受給者実施区分
     */
    @CheckForNull
    public RString getYoShien2_JisshiKubun() {
        return yoShien2_JisshiKubun;
    }

    /**
     * 要支援２受給者実施区分のsetメソッドです。
     * 
     * @param yoShien2_JisshiKubun 要支援２受給者実施区分
     */
    public void setYoShien2_JisshiKubun(RString yoShien2_JisshiKubun) {
        this.yoShien2_JisshiKubun = yoShien2_JisshiKubun;
    }

    /**
     * 対象事業者実施区分のgetメソッドです。
     * 
     * @return 対象事業者実施区分
     */
    @CheckForNull
    public RString getTaishoJigyosha_JisshiKubun() {
        return taishoJigyosha_JisshiKubun;
    }

    /**
     * 対象事業者実施区分のsetメソッドです。
     * 
     * @param taishoJigyosha_JisshiKubun 対象事業者実施区分
     */
    public void setTaishoJigyosha_JisshiKubun(RString taishoJigyosha_JisshiKubun) {
        this.taishoJigyosha_JisshiKubun = taishoJigyosha_JisshiKubun;
    }

    /**
     * 算定単位区分のgetメソッドです。
     * <br/>
     * <br/>01：1回につき、02：1日につき、03：1月につき、05：1週間につき
     * 
     * @return 算定単位区分
     */
    @CheckForNull
    public RString getSanteiTaniKubun() {
        return santeiTaniKubun;
    }

    /**
     * 算定単位区分のsetメソッドです。
     * <br/>
     * <br/>01：1回につき、02：1日につき、03：1月につき、05：1週間につき
     * 
     * @param santeiTaniKubun 算定単位区分
     */
    public void setSanteiTaniKubun(RString santeiTaniKubun) {
        this.santeiTaniKubun = santeiTaniKubun;
    }

    /**
     * 制限日数・回数のgetメソッドです。
     * 
     * @return 制限日数・回数
     */
    @CheckForNull
    public int getSeigenNissuKaisu() {
        return seigenNissuKaisu;
    }

    /**
     * 制限日数・回数のsetメソッドです。
     * 
     * @param seigenNissuKaisu 制限日数・回数
     */
    public void setSeigenNissuKaisu(int seigenNissuKaisu) {
        this.seigenNissuKaisu = seigenNissuKaisu;
    }

    /**
     * 算定回数制限期間区分のgetメソッドです。
     * <br/>
     * <br/>01：1月につき、08：1日につき
     * 
     * @return 算定回数制限期間区分
     */
    @CheckForNull
    public RString getSanteiKaisuSeigenKikanKubun() {
        return santeiKaisuSeigenKikanKubun;
    }

    /**
     * 算定回数制限期間区分のsetメソッドです。
     * <br/>
     * <br/>01：1月につき、08：1日につき
     * 
     * @param santeiKaisuSeigenKikanKubun 算定回数制限期間区分
     */
    public void setSanteiKaisuSeigenKikanKubun(RString santeiKaisuSeigenKikanKubun) {
        this.santeiKaisuSeigenKikanKubun = santeiKaisuSeigenKikanKubun;
    }

    /**
     * 送付区分のgetメソッドです。
     * <br/>
     * <br/>サービスコード異動連絡票の送付区分（1：送付不要、2：送付対象、3：送付済み）
     * 
     * @return 送付区分
     */
    @CheckForNull
    public RString getSofuKubun() {
        return sofuKubun;
    }

    /**
     * 送付区分のsetメソッドです。
     * <br/>
     * <br/>サービスコード異動連絡票の送付区分（1：送付不要、2：送付対象、3：送付済み）
     * 
     * @param sofuKubun 送付区分
     */
    public void setSofuKubun(RString sofuKubun) {
        this.sofuKubun = sofuKubun;
    }

    /**
     * 送付年月のgetメソッドです。
     * 
     * @return 送付年月
     */
    @CheckForNull
    public FlexibleYearMonth getSofuYM() {
        return sofuYM;
    }

    /**
     * 送付年月のsetメソッドです。
     * 
     * @param sofuYM 送付年月
     */
    public void setSofuYM(FlexibleYearMonth sofuYM) {
        this.sofuYM = sofuYM;
    }

    /**
     * 新規・変更異動年月日のgetメソッドです。
     * 
     * @return 新規・変更異動年月日
     */
    @CheckForNull
    public FlexibleDate getShinkiHenkoIdoYMD() {
        return shinkiHenkoIdoYMD;
    }

    /**
     * 新規・変更異動年月日のsetメソッドです。
     * 
     * @param shinkiHenkoIdoYMD 新規・変更異動年月日
     */
    public void setShinkiHenkoIdoYMD(FlexibleDate shinkiHenkoIdoYMD) {
        this.shinkiHenkoIdoYMD = shinkiHenkoIdoYMD;
    }

    /**
     * 終了・異動年月日のgetメソッドです。
     * 
     * @return 終了・異動年月日
     */
    @CheckForNull
    public FlexibleDate getShuryoIdoYMD() {
        return shuryoIdoYMD;
    }

    /**
     * 終了・異動年月日のsetメソッドです。
     * 
     * @param shuryoIdoYMD 終了・異動年月日
     */
    public void setShuryoIdoYMD(FlexibleDate shuryoIdoYMD) {
        this.shuryoIdoYMD = shuryoIdoYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7122SogoJigyoServiceCodeEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7122SogoJigyoServiceCodeEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7122SogoJigyoServiceCodeEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.serviceShuruiCode, other.serviceShuruiCode)) {
            return false;
        }
        if (!Objects.equals(this.serviceKomokuCode, other.serviceKomokuCode)) {
            return false;
        }
        if (!Objects.equals(this.tekiyoKaishiYM, other.tekiyoKaishiYM)) {
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
    public void shallowCopy(DbT7122SogoJigyoServiceCodeEntity entity) {
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.serviceKomokuCode = entity.serviceKomokuCode;
        this.tekiyoKaishiYM = entity.tekiyoKaishiYM;
        this.rirekiNo = entity.rirekiNo;
        this.tekiyoShuryoYM = entity.tekiyoShuryoYM;
        this.serviceMeisho = entity.serviceMeisho;
        this.taniSu = entity.taniSu;
        this.gendoGakuTaishogaiFlag = entity.gendoGakuTaishogaiFlag;
        this.taniSuShikibetsuCode = entity.taniSuShikibetsuCode;
        this.gaibuServiceRiyoKubun = entity.gaibuServiceRiyoKubun;
        this.tokubetsuChiikiKasanFlag = entity.tokubetsuChiikiKasanFlag;
        this.teiRitsu_TeiGakuKubun = entity.teiRitsu_TeiGakuKubun;
        this.riyoshaFutanGaku = entity.riyoshaFutanGaku;
        this.kyufuRitsu = entity.kyufuRitsu;
        this.nijiYoboTaishosha_JissiKubun = entity.nijiYoboTaishosha_JissiKubun;
        this.yoShien1_JisshiKubun = entity.yoShien1_JisshiKubun;
        this.yoShien2_JisshiKubun = entity.yoShien2_JisshiKubun;
        this.taishoJigyosha_JisshiKubun = entity.taishoJigyosha_JisshiKubun;
        this.santeiTaniKubun = entity.santeiTaniKubun;
        this.seigenNissuKaisu = entity.seigenNissuKaisu;
        this.santeiKaisuSeigenKikanKubun = entity.santeiKaisuSeigenKikanKubun;
        this.sofuKubun = entity.sofuKubun;
        this.sofuYM = entity.sofuYM;
        this.shinkiHenkoIdoYMD = entity.shinkiHenkoIdoYMD;
        this.shuryoIdoYMD = entity.shuryoIdoYMD;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(serviceShuruiCode, serviceKomokuCode, tekiyoKaishiYM, rirekiNo, tekiyoShuryoYM, serviceMeisho, taniSu, gendoGakuTaishogaiFlag, taniSuShikibetsuCode, gaibuServiceRiyoKubun, tokubetsuChiikiKasanFlag, teiRitsu_TeiGakuKubun, riyoshaFutanGaku, kyufuRitsu, nijiYoboTaishosha_JissiKubun, yoShien1_JisshiKubun, yoShien2_JisshiKubun, taishoJigyosha_JisshiKubun, santeiTaniKubun, seigenNissuKaisu, santeiKaisuSeigenKikanKubun, sofuKubun, sofuYM, shinkiHenkoIdoYMD, shuryoIdoYMD);
    }

// </editor-fold>

}
