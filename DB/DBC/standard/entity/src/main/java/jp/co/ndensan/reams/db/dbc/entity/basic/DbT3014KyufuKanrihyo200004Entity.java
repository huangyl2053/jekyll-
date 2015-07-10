package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import java.util.UUID;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DbT3014KyufuKanrihyo200004の項目定義クラスです
 *
 */
public class DbT3014KyufuKanrihyo200004Entity extends DbTableEntityBase<DbT3014KyufuKanrihyo200004Entity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3014KyufuKanrihyo200004");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYearMonth shinsaYM;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private RString shokisaiHokenshaNo;
    @PrimaryKey
    private RString kyotakushienJigyoshoNo;
    @PrimaryKey
    private RString kyufuKanrihyoSakuseiKubunCode;
    @PrimaryKey
    private FlexibleDate kyufuKanrihyoSakuseiYMD;
    @PrimaryKey
    private RString kyufuKanrihyoShubetsuKubunCode;
    @PrimaryKey
    private RString kyufuKanrihyoMeisaiLineNo;
    private RString hokenshaNo;
    private RString hiHokenshaNo;
    private FlexibleDate hiHokenshaUmareYMD;
    private RString seibetsuCode;
    private RString yoKaigoJotaiKubunCode;
    private FlexibleYearMonth gendogakuTekiyoKaishiYM;
    private FlexibleYearMonth gendogakuTekiyoShuryoYM;
    private Decimal kyotakuKaigoYoboShikyuGendogaku;
    private RString kyotakuServicePlanSakuseiKubunCode;
    private RString serviceJigyoshoNo;
    private RString shiteiKijungaitoChiikimitchakuServiceShikibetsuCode;
    private RString serviceShuruiCode;
    private Decimal kyufuKeikakuTanisuNissu;
    private Decimal kyufuKeikakuNissu;
    private Decimal shiteiServiceSubTotal;
    private Decimal kijyunGaitoServiceSubTotal;
    private Decimal kyufuKeikakuTotalTanisuNissu;
    private FlexibleDate toshoTorokuYMD;
    private FlexibleYearMonth torikomiYM;

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
     * getShinsaYM
     *
     * @return shinsaYM
     */
    public FlexibleYearMonth getShinsaYM() {
        return shinsaYM;
    }

    /**
     * setShinsaYM
     *
     * @param shinsaYM shinsaYM
     */
    public void setShinsaYM(FlexibleYearMonth shinsaYM) {
        this.shinsaYM = shinsaYM;
    }

    /**
     * getServiceTeikyoYM
     *
     * @return serviceTeikyoYM
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * setServiceTeikyoYM
     *
     * @param serviceTeikyoYM serviceTeikyoYM
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * getShokisaiHokenshaNo
     *
     * @return shokisaiHokenshaNo
     */
    public RString getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    /**
     * setShokisaiHokenshaNo
     *
     * @param shokisaiHokenshaNo shokisaiHokenshaNo
     */
    public void setShokisaiHokenshaNo(RString shokisaiHokenshaNo) {
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
    }

    /**
     * getKyotakushienJigyoshoNo
     *
     * @return kyotakushienJigyoshoNo
     */
    public RString getKyotakushienJigyoshoNo() {
        return kyotakushienJigyoshoNo;
    }

    /**
     * setKyotakushienJigyoshoNo
     *
     * @param kyotakushienJigyoshoNo kyotakushienJigyoshoNo
     */
    public void setKyotakushienJigyoshoNo(RString kyotakushienJigyoshoNo) {
        this.kyotakushienJigyoshoNo = kyotakushienJigyoshoNo;
    }

    /**
     * getKyufuKanrihyoSakuseiKubunCode
     *
     * @return kyufuKanrihyoSakuseiKubunCode
     */
    public RString getKyufuKanrihyoSakuseiKubunCode() {
        return kyufuKanrihyoSakuseiKubunCode;
    }

    /**
     * setKyufuKanrihyoSakuseiKubunCode
     *
     * @param kyufuKanrihyoSakuseiKubunCode kyufuKanrihyoSakuseiKubunCode
     */
    public void setKyufuKanrihyoSakuseiKubunCode(RString kyufuKanrihyoSakuseiKubunCode) {
        this.kyufuKanrihyoSakuseiKubunCode = kyufuKanrihyoSakuseiKubunCode;
    }

    /**
     * getKyufuKanrihyoSakuseiYMD
     *
     * @return kyufuKanrihyoSakuseiYMD
     */
    public FlexibleDate getKyufuKanrihyoSakuseiYMD() {
        return kyufuKanrihyoSakuseiYMD;
    }

    /**
     * setKyufuKanrihyoSakuseiYMD
     *
     * @param kyufuKanrihyoSakuseiYMD kyufuKanrihyoSakuseiYMD
     */
    public void setKyufuKanrihyoSakuseiYMD(FlexibleDate kyufuKanrihyoSakuseiYMD) {
        this.kyufuKanrihyoSakuseiYMD = kyufuKanrihyoSakuseiYMD;
    }

    /**
     * getKyufuKanrihyoShubetsuKubunCode
     *
     * @return kyufuKanrihyoShubetsuKubunCode
     */
    public RString getKyufuKanrihyoShubetsuKubunCode() {
        return kyufuKanrihyoShubetsuKubunCode;
    }

    /**
     * setKyufuKanrihyoShubetsuKubunCode
     *
     * @param kyufuKanrihyoShubetsuKubunCode kyufuKanrihyoShubetsuKubunCode
     */
    public void setKyufuKanrihyoShubetsuKubunCode(RString kyufuKanrihyoShubetsuKubunCode) {
        this.kyufuKanrihyoShubetsuKubunCode = kyufuKanrihyoShubetsuKubunCode;
    }

    /**
     * getKyufuKanrihyoMeisaiLineNo
     *
     * @return kyufuKanrihyoMeisaiLineNo
     */
    public RString getKyufuKanrihyoMeisaiLineNo() {
        return kyufuKanrihyoMeisaiLineNo;
    }

    /**
     * setKyufuKanrihyoMeisaiLineNo
     *
     * @param kyufuKanrihyoMeisaiLineNo kyufuKanrihyoMeisaiLineNo
     */
    public void setKyufuKanrihyoMeisaiLineNo(RString kyufuKanrihyoMeisaiLineNo) {
        this.kyufuKanrihyoMeisaiLineNo = kyufuKanrihyoMeisaiLineNo;
    }

    /**
     * getHokenshaNo
     *
     * @return hokenshaNo
     */
    public RString getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * setHokenshaNo
     *
     * @param hokenshaNo hokenshaNo
     */
    public void setHokenshaNo(RString hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
    }

    /**
     * getHiHokenshaNo
     *
     * @return hiHokenshaNo
     */
    public RString getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * setHiHokenshaNo
     *
     * @param hiHokenshaNo hiHokenshaNo
     */
    public void setHiHokenshaNo(RString hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * getHiHokenshaUmareYMD
     *
     * @return hiHokenshaUmareYMD
     */
    public FlexibleDate getHiHokenshaUmareYMD() {
        return hiHokenshaUmareYMD;
    }

    /**
     * setHiHokenshaUmareYMD
     *
     * @param hiHokenshaUmareYMD hiHokenshaUmareYMD
     */
    public void setHiHokenshaUmareYMD(FlexibleDate hiHokenshaUmareYMD) {
        this.hiHokenshaUmareYMD = hiHokenshaUmareYMD;
    }

    /**
     * getSeibetsuCode
     *
     * @return seibetsuCode
     */
    public RString getSeibetsuCode() {
        return seibetsuCode;
    }

    /**
     * setSeibetsuCode
     *
     * @param seibetsuCode seibetsuCode
     */
    public void setSeibetsuCode(RString seibetsuCode) {
        this.seibetsuCode = seibetsuCode;
    }

    /**
     * getYoKaigoJotaiKubunCode
     *
     * @return yoKaigoJotaiKubunCode
     */
    public RString getYoKaigoJotaiKubunCode() {
        return yoKaigoJotaiKubunCode;
    }

    /**
     * setYoKaigoJotaiKubunCode
     *
     * @param yoKaigoJotaiKubunCode yoKaigoJotaiKubunCode
     */
    public void setYoKaigoJotaiKubunCode(RString yoKaigoJotaiKubunCode) {
        this.yoKaigoJotaiKubunCode = yoKaigoJotaiKubunCode;
    }

    /**
     * getGendogakuTekiyoKaishiYM
     *
     * @return gendogakuTekiyoKaishiYM
     */
    public FlexibleYearMonth getGendogakuTekiyoKaishiYM() {
        return gendogakuTekiyoKaishiYM;
    }

    /**
     * setGendogakuTekiyoKaishiYM
     *
     * @param gendogakuTekiyoKaishiYM gendogakuTekiyoKaishiYM
     */
    public void setGendogakuTekiyoKaishiYM(FlexibleYearMonth gendogakuTekiyoKaishiYM) {
        this.gendogakuTekiyoKaishiYM = gendogakuTekiyoKaishiYM;
    }

    /**
     * getGendogakuTekiyoShuryoYM
     *
     * @return gendogakuTekiyoShuryoYM
     */
    public FlexibleYearMonth getGendogakuTekiyoShuryoYM() {
        return gendogakuTekiyoShuryoYM;
    }

    /**
     * setGendogakuTekiyoShuryoYM
     *
     * @param gendogakuTekiyoShuryoYM gendogakuTekiyoShuryoYM
     */
    public void setGendogakuTekiyoShuryoYM(FlexibleYearMonth gendogakuTekiyoShuryoYM) {
        this.gendogakuTekiyoShuryoYM = gendogakuTekiyoShuryoYM;
    }

    /**
     * getKyotakuKaigoYoboShikyuGendogaku
     *
     * @return kyotakuKaigoYoboShikyuGendogaku
     */
    public Decimal getKyotakuKaigoYoboShikyuGendogaku() {
        return kyotakuKaigoYoboShikyuGendogaku;
    }

    /**
     * setKyotakuKaigoYoboShikyuGendogaku
     *
     * @param kyotakuKaigoYoboShikyuGendogaku kyotakuKaigoYoboShikyuGendogaku
     */
    public void setKyotakuKaigoYoboShikyuGendogaku(Decimal kyotakuKaigoYoboShikyuGendogaku) {
        this.kyotakuKaigoYoboShikyuGendogaku = kyotakuKaigoYoboShikyuGendogaku;
    }

    /**
     * getKyotakuServicePlanSakuseiKubunCode
     *
     * @return kyotakuServicePlanSakuseiKubunCode
     */
    public RString getKyotakuServicePlanSakuseiKubunCode() {
        return kyotakuServicePlanSakuseiKubunCode;
    }

    /**
     * setKyotakuServicePlanSakuseiKubunCode
     *
     * @param kyotakuServicePlanSakuseiKubunCode
     * kyotakuServicePlanSakuseiKubunCode
     */
    public void setKyotakuServicePlanSakuseiKubunCode(RString kyotakuServicePlanSakuseiKubunCode) {
        this.kyotakuServicePlanSakuseiKubunCode = kyotakuServicePlanSakuseiKubunCode;
    }

    /**
     * getServiceJigyoshoNo
     *
     * @return serviceJigyoshoNo
     */
    public RString getServiceJigyoshoNo() {
        return serviceJigyoshoNo;
    }

    /**
     * setServiceJigyoshoNo
     *
     * @param serviceJigyoshoNo serviceJigyoshoNo
     */
    public void setServiceJigyoshoNo(RString serviceJigyoshoNo) {
        this.serviceJigyoshoNo = serviceJigyoshoNo;
    }

    /**
     * getShiteiKijungaitoChiikimitchakuServiceShikibetsuCode
     *
     * @return shiteiKijungaitoChiikimitchakuServiceShikibetsuCode
     */
    public RString getShiteiKijungaitoChiikimitchakuServiceShikibetsuCode() {
        return shiteiKijungaitoChiikimitchakuServiceShikibetsuCode;
    }

    /**
     * setShiteiKijungaitoChiikimitchakuServiceShikibetsuCode
     *
     * @param shiteiKijungaitoChiikimitchakuServiceShikibetsuCode
     * shiteiKijungaitoChiikimitchakuServiceShikibetsuCode
     */
    public void setShiteiKijungaitoChiikimitchakuServiceShikibetsuCode(RString shiteiKijungaitoChiikimitchakuServiceShikibetsuCode) {
        this.shiteiKijungaitoChiikimitchakuServiceShikibetsuCode = shiteiKijungaitoChiikimitchakuServiceShikibetsuCode;
    }

    /**
     * getServiceShuruiCode
     *
     * @return serviceShuruiCode
     */
    public RString getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * setServiceShuruiCode
     *
     * @param serviceShuruiCode serviceShuruiCode
     */
    public void setServiceShuruiCode(RString serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * getKyufuKeikakuTanisuNissu
     *
     * @return kyufuKeikakuTanisuNissu
     */
    public Decimal getKyufuKeikakuTanisuNissu() {
        return kyufuKeikakuTanisuNissu;
    }

    /**
     * setKyufuKeikakuTanisuNissu
     *
     * @param kyufuKeikakuTanisuNissu kyufuKeikakuTanisuNissu
     */
    public void setKyufuKeikakuTanisuNissu(Decimal kyufuKeikakuTanisuNissu) {
        this.kyufuKeikakuTanisuNissu = kyufuKeikakuTanisuNissu;
    }

    /**
     * getKyufuKeikakuNissu
     *
     * @return kyufuKeikakuNissu
     */
    public Decimal getKyufuKeikakuNissu() {
        return kyufuKeikakuNissu;
    }

    /**
     * setKyufuKeikakuNissu
     *
     * @param kyufuKeikakuNissu kyufuKeikakuNissu
     */
    public void setKyufuKeikakuNissu(Decimal kyufuKeikakuNissu) {
        this.kyufuKeikakuNissu = kyufuKeikakuNissu;
    }

    /**
     * getShiteiServiceSubTotal
     *
     * @return shiteiServiceSubTotal
     */
    public Decimal getShiteiServiceSubTotal() {
        return shiteiServiceSubTotal;
    }

    /**
     * setShiteiServiceSubTotal
     *
     * @param shiteiServiceSubTotal shiteiServiceSubTotal
     */
    public void setShiteiServiceSubTotal(Decimal shiteiServiceSubTotal) {
        this.shiteiServiceSubTotal = shiteiServiceSubTotal;
    }

    /**
     * getKijyunGaitoServiceSubTotal
     *
     * @return kijyunGaitoServiceSubTotal
     */
    public Decimal getKijyunGaitoServiceSubTotal() {
        return kijyunGaitoServiceSubTotal;
    }

    /**
     * setKijyunGaitoServiceSubTotal
     *
     * @param kijyunGaitoServiceSubTotal kijyunGaitoServiceSubTotal
     */
    public void setKijyunGaitoServiceSubTotal(Decimal kijyunGaitoServiceSubTotal) {
        this.kijyunGaitoServiceSubTotal = kijyunGaitoServiceSubTotal;
    }

    /**
     * getKyufuKeikakuTotalTanisuNissu
     *
     * @return kyufuKeikakuTotalTanisuNissu
     */
    public Decimal getKyufuKeikakuTotalTanisuNissu() {
        return kyufuKeikakuTotalTanisuNissu;
    }

    /**
     * setKyufuKeikakuTotalTanisuNissu
     *
     * @param kyufuKeikakuTotalTanisuNissu kyufuKeikakuTotalTanisuNissu
     */
    public void setKyufuKeikakuTotalTanisuNissu(Decimal kyufuKeikakuTotalTanisuNissu) {
        this.kyufuKeikakuTotalTanisuNissu = kyufuKeikakuTotalTanisuNissu;
    }

    /**
     * getToshoTorokuYMD
     *
     * @return toshoTorokuYMD
     */
    public FlexibleDate getToshoTorokuYMD() {
        return toshoTorokuYMD;
    }

    /**
     * setToshoTorokuYMD
     *
     * @param toshoTorokuYMD toshoTorokuYMD
     */
    public void setToshoTorokuYMD(FlexibleDate toshoTorokuYMD) {
        this.toshoTorokuYMD = toshoTorokuYMD;
    }

    /**
     * getTorikomiYM
     *
     * @return torikomiYM
     */
    public FlexibleYearMonth getTorikomiYM() {
        return torikomiYM;
    }

    /**
     * setTorikomiYM
     *
     * @param torikomiYM torikomiYM
     */
    public void setTorikomiYM(FlexibleYearMonth torikomiYM) {
        this.torikomiYM = torikomiYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3014KyufuKanrihyo200004Entity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3014KyufuKanrihyo200004Entity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3014KyufuKanrihyo200004Entity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinsaYM, other.shinsaYM)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.shokisaiHokenshaNo, other.shokisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.kyotakushienJigyoshoNo, other.kyotakushienJigyoshoNo)) {
            return false;
        }
        if (!Objects.equals(this.kyufuKanrihyoSakuseiKubunCode, other.kyufuKanrihyoSakuseiKubunCode)) {
            return false;
        }
        if (!Objects.equals(this.kyufuKanrihyoSakuseiYMD, other.kyufuKanrihyoSakuseiYMD)) {
            return false;
        }
        if (!Objects.equals(this.kyufuKanrihyoShubetsuKubunCode, other.kyufuKanrihyoShubetsuKubunCode)) {
            return false;
        }
        if (!Objects.equals(this.kyufuKanrihyoMeisaiLineNo, other.kyufuKanrihyoMeisaiLineNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3014KyufuKanrihyo200004Entity entity) {
        this.shinsaYM = entity.shinsaYM;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.kyotakushienJigyoshoNo = entity.kyotakushienJigyoshoNo;
        this.kyufuKanrihyoSakuseiKubunCode = entity.kyufuKanrihyoSakuseiKubunCode;
        this.kyufuKanrihyoSakuseiYMD = entity.kyufuKanrihyoSakuseiYMD;
        this.kyufuKanrihyoShubetsuKubunCode = entity.kyufuKanrihyoShubetsuKubunCode;
        this.kyufuKanrihyoMeisaiLineNo = entity.kyufuKanrihyoMeisaiLineNo;
        this.hokenshaNo = entity.hokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.hiHokenshaUmareYMD = entity.hiHokenshaUmareYMD;
        this.seibetsuCode = entity.seibetsuCode;
        this.yoKaigoJotaiKubunCode = entity.yoKaigoJotaiKubunCode;
        this.gendogakuTekiyoKaishiYM = entity.gendogakuTekiyoKaishiYM;
        this.gendogakuTekiyoShuryoYM = entity.gendogakuTekiyoShuryoYM;
        this.kyotakuKaigoYoboShikyuGendogaku = entity.kyotakuKaigoYoboShikyuGendogaku;
        this.kyotakuServicePlanSakuseiKubunCode = entity.kyotakuServicePlanSakuseiKubunCode;
        this.serviceJigyoshoNo = entity.serviceJigyoshoNo;
        this.shiteiKijungaitoChiikimitchakuServiceShikibetsuCode = entity.shiteiKijungaitoChiikimitchakuServiceShikibetsuCode;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.kyufuKeikakuTanisuNissu = entity.kyufuKeikakuTanisuNissu;
        this.kyufuKeikakuNissu = entity.kyufuKeikakuNissu;
        this.shiteiServiceSubTotal = entity.shiteiServiceSubTotal;
        this.kijyunGaitoServiceSubTotal = entity.kijyunGaitoServiceSubTotal;
        this.kyufuKeikakuTotalTanisuNissu = entity.kyufuKeikakuTotalTanisuNissu;
        this.toshoTorokuYMD = entity.toshoTorokuYMD;
        this.torikomiYM = entity.torikomiYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinsaYM, serviceTeikyoYM, shokisaiHokenshaNo, kyotakushienJigyoshoNo, kyufuKanrihyoSakuseiKubunCode, kyufuKanrihyoSakuseiYMD, kyufuKanrihyoShubetsuKubunCode, kyufuKanrihyoMeisaiLineNo, hokenshaNo, hiHokenshaNo, hiHokenshaUmareYMD, seibetsuCode, yoKaigoJotaiKubunCode, gendogakuTekiyoKaishiYM, gendogakuTekiyoShuryoYM, kyotakuKaigoYoboShikyuGendogaku, kyotakuServicePlanSakuseiKubunCode, serviceJigyoshoNo, shiteiKijungaitoChiikimitchakuServiceShikibetsuCode, serviceShuruiCode, kyufuKeikakuTanisuNissu, kyufuKeikakuNissu, shiteiServiceSubTotal, kijyunGaitoServiceSubTotal, kyufuKeikakuTotalTanisuNissu, toshoTorokuYMD, torikomiYM);
    }

// </editor-fold>
}
