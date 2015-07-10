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
 * DbT7119ServiceCodeの項目定義クラスです
 *
 */
public class DbT7119ServiceCodeEntity extends DbTableEntityBase<DbT7119ServiceCodeEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7119ServiceCode");

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
    private RString gaibuServiceRiyogataKubun;
    private RString tokubetsuChiikiKasanFlag;
    private RString teiRitsu_TeiGakuKubun;
    private Decimal riyoshaFutanGaku;
    private HokenKyufuRitsu kyufuRitsu;

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
     * getGaibuServiceRiyogataKubun
     *
     * @return gaibuServiceRiyogataKubun
     */
    public RString getGaibuServiceRiyogataKubun() {
        return gaibuServiceRiyogataKubun;
    }

    /**
     * setGaibuServiceRiyogataKubun
     *
     * @param gaibuServiceRiyogataKubun gaibuServiceRiyogataKubun
     */
    public void setGaibuServiceRiyogataKubun(RString gaibuServiceRiyogataKubun) {
        this.gaibuServiceRiyogataKubun = gaibuServiceRiyogataKubun;
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
     * このエンティティの主キーが他の{@literal DbT7119ServiceCodeEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT7119ServiceCodeEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7119ServiceCodeEntity other) {
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
    public void shallowCopy(DbT7119ServiceCodeEntity entity) {
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.serviceKomokuCode = entity.serviceKomokuCode;
        this.tekiyoKaishiYM = entity.tekiyoKaishiYM;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.tekiyoShuryoYM = entity.tekiyoShuryoYM;
        this.serviceMeisho = entity.serviceMeisho;
        this.taniSu = entity.taniSu;
        this.gendoGakuTaishogaiFlag = entity.gendoGakuTaishogaiFlag;
        this.taniSuShikibetsuCode = entity.taniSuShikibetsuCode;
        this.gaibuServiceRiyogataKubun = entity.gaibuServiceRiyogataKubun;
        this.tokubetsuChiikiKasanFlag = entity.tokubetsuChiikiKasanFlag;
        this.teiRitsu_TeiGakuKubun = entity.teiRitsu_TeiGakuKubun;
        this.riyoshaFutanGaku = entity.riyoshaFutanGaku;
        this.kyufuRitsu = entity.kyufuRitsu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(serviceShuruiCode, serviceKomokuCode, tekiyoKaishiYM, shoriTimestamp, tekiyoShuryoYM, serviceMeisho, taniSu, gendoGakuTaishogaiFlag, taniSuShikibetsuCode, gaibuServiceRiyogataKubun, tokubetsuChiikiKasanFlag, teiRitsu_TeiGakuKubun, riyoshaFutanGaku, kyufuRitsu);
    }

// </editor-fold>
}
