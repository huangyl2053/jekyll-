package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT7122SogoJigyoServiceCodeの項目定義クラスです
 *
 */
public class DbT7122SogoJigyoServiceCodeEntity extends DbTableEntityBase<DbT7122SogoJigyoServiceCodeEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

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
    private YMDHMS shoriTimestamp;
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

    /**
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getServiceShuruiCode
     *
     * @return serviceShuruiCode
     */
    public ServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * setServiceShuruiCode
     *
     * @param serviceShuruiCode serviceShuruiCode
     */
    public void setServiceShuruiCode(ServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * getServiceKomokuCode
     *
     * @return serviceKomokuCode
     */
    public ServiceKomokuCode getServiceKomokuCode() {
        return serviceKomokuCode;
    }

    /**
     * setServiceKomokuCode
     *
     * @param serviceKomokuCode serviceKomokuCode
     */
    public void setServiceKomokuCode(ServiceKomokuCode serviceKomokuCode) {
        this.serviceKomokuCode = serviceKomokuCode;
    }

    /**
     * getTekiyoKaishiYM
     *
     * @return tekiyoKaishiYM
     */
    public FlexibleYearMonth getTekiyoKaishiYM() {
        return tekiyoKaishiYM;
    }

    /**
     * setTekiyoKaishiYM
     *
     * @param tekiyoKaishiYM tekiyoKaishiYM
     */
    public void setTekiyoKaishiYM(FlexibleYearMonth tekiyoKaishiYM) {
        this.tekiyoKaishiYM = tekiyoKaishiYM;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getTekiyoShuryoYM
     *
     * @return tekiyoShuryoYM
     */
    public FlexibleYearMonth getTekiyoShuryoYM() {
        return tekiyoShuryoYM;
    }

    /**
     * setTekiyoShuryoYM
     *
     * @param tekiyoShuryoYM tekiyoShuryoYM
     */
    public void setTekiyoShuryoYM(FlexibleYearMonth tekiyoShuryoYM) {
        this.tekiyoShuryoYM = tekiyoShuryoYM;
    }

    /**
     * getServiceMeisho
     *
     * @return serviceMeisho
     */
    public RString getServiceMeisho() {
        return serviceMeisho;
    }

    /**
     * setServiceMeisho
     *
     * @param serviceMeisho serviceMeisho
     */
    public void setServiceMeisho(RString serviceMeisho) {
        this.serviceMeisho = serviceMeisho;
    }

    /**
     * getTaniSu
     *
     * @return taniSu
     */
    public Decimal getTaniSu() {
        return taniSu;
    }

    /**
     * setTaniSu
     *
     * @param taniSu taniSu
     */
    public void setTaniSu(Decimal taniSu) {
        this.taniSu = taniSu;
    }

    /**
     * getGendoGakuTaishogaiFlag
     *
     * @return gendoGakuTaishogaiFlag
     */
    public RString getGendoGakuTaishogaiFlag() {
        return gendoGakuTaishogaiFlag;
    }

    /**
     * setGendoGakuTaishogaiFlag
     *
     * @param gendoGakuTaishogaiFlag gendoGakuTaishogaiFlag
     */
    public void setGendoGakuTaishogaiFlag(RString gendoGakuTaishogaiFlag) {
        this.gendoGakuTaishogaiFlag = gendoGakuTaishogaiFlag;
    }

    /**
     * getTaniSuShikibetsuCode
     *
     * @return taniSuShikibetsuCode
     */
    public RString getTaniSuShikibetsuCode() {
        return taniSuShikibetsuCode;
    }

    /**
     * setTaniSuShikibetsuCode
     *
     * @param taniSuShikibetsuCode taniSuShikibetsuCode
     */
    public void setTaniSuShikibetsuCode(RString taniSuShikibetsuCode) {
        this.taniSuShikibetsuCode = taniSuShikibetsuCode;
    }

    /**
     * getGaibuServiceRiyoKubun
     *
     * @return gaibuServiceRiyoKubun
     */
    public RString getGaibuServiceRiyoKubun() {
        return gaibuServiceRiyoKubun;
    }

    /**
     * setGaibuServiceRiyoKubun
     *
     * @param gaibuServiceRiyoKubun gaibuServiceRiyoKubun
     */
    public void setGaibuServiceRiyoKubun(RString gaibuServiceRiyoKubun) {
        this.gaibuServiceRiyoKubun = gaibuServiceRiyoKubun;
    }

    /**
     * getTokubetsuChiikiKasanFlag
     *
     * @return tokubetsuChiikiKasanFlag
     */
    public RString getTokubetsuChiikiKasanFlag() {
        return tokubetsuChiikiKasanFlag;
    }

    /**
     * setTokubetsuChiikiKasanFlag
     *
     * @param tokubetsuChiikiKasanFlag tokubetsuChiikiKasanFlag
     */
    public void setTokubetsuChiikiKasanFlag(RString tokubetsuChiikiKasanFlag) {
        this.tokubetsuChiikiKasanFlag = tokubetsuChiikiKasanFlag;
    }

    /**
     * getTeiRitsu_TeiGakuKubun
     *
     * @return teiRitsu_TeiGakuKubun
     */
    public RString getTeiRitsu_TeiGakuKubun() {
        return teiRitsu_TeiGakuKubun;
    }

    /**
     * setTeiRitsu_TeiGakuKubun
     *
     * @param teiRitsu_TeiGakuKubun teiRitsu_TeiGakuKubun
     */
    public void setTeiRitsu_TeiGakuKubun(RString teiRitsu_TeiGakuKubun) {
        this.teiRitsu_TeiGakuKubun = teiRitsu_TeiGakuKubun;
    }

    /**
     * getRiyoshaFutanGaku
     *
     * @return riyoshaFutanGaku
     */
    public Decimal getRiyoshaFutanGaku() {
        return riyoshaFutanGaku;
    }

    /**
     * setRiyoshaFutanGaku
     *
     * @param riyoshaFutanGaku riyoshaFutanGaku
     */
    public void setRiyoshaFutanGaku(Decimal riyoshaFutanGaku) {
        this.riyoshaFutanGaku = riyoshaFutanGaku;
    }

    /**
     * getKyufuRitsu
     *
     * @return kyufuRitsu
     */
    public HokenKyufuRitsu getKyufuRitsu() {
        return kyufuRitsu;
    }

    /**
     * setKyufuRitsu
     *
     * @param kyufuRitsu kyufuRitsu
     */
    public void setKyufuRitsu(HokenKyufuRitsu kyufuRitsu) {
        this.kyufuRitsu = kyufuRitsu;
    }

    /**
     * getNijiYoboTaishosha_JissiKubun
     *
     * @return nijiYoboTaishosha_JissiKubun
     */
    public RString getNijiYoboTaishosha_JissiKubun() {
        return nijiYoboTaishosha_JissiKubun;
    }

    /**
     * setNijiYoboTaishosha_JissiKubun
     *
     * @param nijiYoboTaishosha_JissiKubun nijiYoboTaishosha_JissiKubun
     */
    public void setNijiYoboTaishosha_JissiKubun(RString nijiYoboTaishosha_JissiKubun) {
        this.nijiYoboTaishosha_JissiKubun = nijiYoboTaishosha_JissiKubun;
    }

    /**
     * getYoShien1_JisshiKubun
     *
     * @return yoShien1_JisshiKubun
     */
    public RString getYoShien1_JisshiKubun() {
        return yoShien1_JisshiKubun;
    }

    /**
     * setYoShien1_JisshiKubun
     *
     * @param yoShien1_JisshiKubun yoShien1_JisshiKubun
     */
    public void setYoShien1_JisshiKubun(RString yoShien1_JisshiKubun) {
        this.yoShien1_JisshiKubun = yoShien1_JisshiKubun;
    }

    /**
     * getYoShien2_JisshiKubun
     *
     * @return yoShien2_JisshiKubun
     */
    public RString getYoShien2_JisshiKubun() {
        return yoShien2_JisshiKubun;
    }

    /**
     * setYoShien2_JisshiKubun
     *
     * @param yoShien2_JisshiKubun yoShien2_JisshiKubun
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
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
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
        this.shoriTimestamp = entity.shoriTimestamp;
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
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(serviceShuruiCode, serviceKomokuCode, tekiyoKaishiYM, shoriTimestamp, tekiyoShuryoYM, serviceMeisho, taniSu, gendoGakuTaishogaiFlag, taniSuShikibetsuCode, gaibuServiceRiyoKubun, tokubetsuChiikiKasanFlag, teiRitsu_TeiGakuKubun, riyoshaFutanGaku, kyufuRitsu, nijiYoboTaishosha_JissiKubun, yoShien1_JisshiKubun, yoShien2_JisshiKubun);
    }

// </editor-fold>
}
