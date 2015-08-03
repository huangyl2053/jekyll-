package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * 介護予防・日常生活支援総合事業サービスコードテーブルのエンティティクラスです。
 */
public class DbT7122SogoJigyoServiceCodeEntity extends DbTableEntityBase<DbT7122SogoJigyoServiceCodeEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
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
    private DbUDD005ServiceShuruiCode serviceShuruiCode;
    @PrimaryKey
    private DbUDD006ServiceKomokuCode serviceKomokuCode;
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
    private DbUDD011HokenKyufuRitsu kyufuRitsu;
    private RString nijiYoboTaishosha_JissiKubun;
    private RString yoShien1_JisshiKubun;
    private RString yoShien2_JisshiKubun;

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
    public DbUDD005ServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * サービス種類コードのsetメソッドです。
     * 
     * @param serviceShuruiCode サービス種類コード
     */
    public void setServiceShuruiCode(DbUDD005ServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * サービス項目コードのgetメソッドです。
     * 
     * @return サービス項目コード
     */
    public DbUDD006ServiceKomokuCode getServiceKomokuCode() {
        return serviceKomokuCode;
    }

    /**
     * サービス項目コードのsetメソッドです。
     * 
     * @param serviceKomokuCode サービス項目コード
     */
    public void setServiceKomokuCode(DbUDD006ServiceKomokuCode serviceKomokuCode) {
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
    public void setTekiyoKaishiYM(FlexibleYearMonth tekiyoKaishiYM) {
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
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 適用終了年月のgetメソッドです。
     * 
     * @return 適用終了年月
     */
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
    public DbUDD011HokenKyufuRitsu getKyufuRitsu() {
        return kyufuRitsu;
    }

    /**
     * 給付率のsetメソッドです。
     * <br/>
     * <br/>利用者負担定率／定額区分が”1”（定率）時
     * 
     * @param kyufuRitsu 給付率
     */
    public void setKyufuRitsu(DbUDD011HokenKyufuRitsu kyufuRitsu) {
        this.kyufuRitsu = kyufuRitsu;
    }

    /**
     * 二次予防事業対象者実施区分のgetメソッドです。
     * 
     * @return 二次予防事業対象者実施区分
     */
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
     * このエンティティの主キーが他の{@literal DbT7122SogoJigyoServiceCodeEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
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
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(serviceShuruiCode, serviceKomokuCode, tekiyoKaishiYM, rirekiNo, tekiyoShuryoYM, serviceMeisho, taniSu, gendoGakuTaishogaiFlag, taniSuShikibetsuCode, gaibuServiceRiyoKubun, tokubetsuChiikiKasanFlag, teiRitsu_TeiGakuKubun, riyoshaFutanGaku, kyufuRitsu, nijiYoboTaishosha_JissiKubun, yoShien1_JisshiKubun, yoShien2_JisshiKubun);
    }

// </editor-fold>
}
