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
 * DbT3015KyufuKanrihyo200604の項目定義クラスです
 *
 */
public class DbT3015KyufuKanrihyo200604Entity extends DbTableEntityBase<DbT3015KyufuKanrihyo200604Entity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3015KyufuKanrihyo200604");

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
    private RString kyufuSakuseiKubunCode;
    @PrimaryKey
    private FlexibleDate kyufuSakuseiYMD;
    @PrimaryKey
    private RString kyufuShubetsuKubunCode;
    @PrimaryKey
    private RString kyufuMeisaiLineNo;
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
    private int kyufuKeikakuTanisuNissu;
    private int kyufuKeikakuNissu;
    private int shiteiServiceSubTotal;
    private int kijyunGaitoServiceSubTotal;
    private int kyufuKeikakuTotalTanisuNissu;
    private RString tantoKaigoShienSemmoninNo;
    private RString kaigoShienJigyoshaNo;
    private RString itakusakiTantoKaigoShienSemmoninNo;
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
     * getKyufuSakuseiKubunCode
     *
     * @return kyufuSakuseiKubunCode
     */
    public RString getKyufuSakuseiKubunCode() {
        return kyufuSakuseiKubunCode;
    }

    /**
     * setKyufuSakuseiKubunCode
     *
     * @param kyufuSakuseiKubunCode kyufuSakuseiKubunCode
     */
    public void setKyufuSakuseiKubunCode(RString kyufuSakuseiKubunCode) {
        this.kyufuSakuseiKubunCode = kyufuSakuseiKubunCode;
    }

    /**
     * getKyufuSakuseiYMD
     *
     * @return kyufuSakuseiYMD
     */
    public FlexibleDate getKyufuSakuseiYMD() {
        return kyufuSakuseiYMD;
    }

    /**
     * setKyufuSakuseiYMD
     *
     * @param kyufuSakuseiYMD kyufuSakuseiYMD
     */
    public void setKyufuSakuseiYMD(FlexibleDate kyufuSakuseiYMD) {
        this.kyufuSakuseiYMD = kyufuSakuseiYMD;
    }

    /**
     * getKyufuShubetsuKubunCode
     *
     * @return kyufuShubetsuKubunCode
     */
    public RString getKyufuShubetsuKubunCode() {
        return kyufuShubetsuKubunCode;
    }

    /**
     * setKyufuShubetsuKubunCode
     *
     * @param kyufuShubetsuKubunCode kyufuShubetsuKubunCode
     */
    public void setKyufuShubetsuKubunCode(RString kyufuShubetsuKubunCode) {
        this.kyufuShubetsuKubunCode = kyufuShubetsuKubunCode;
    }

    /**
     * getKyufuMeisaiLineNo
     *
     * @return kyufuMeisaiLineNo
     */
    public RString getKyufuMeisaiLineNo() {
        return kyufuMeisaiLineNo;
    }

    /**
     * setKyufuMeisaiLineNo
     *
     * @param kyufuMeisaiLineNo kyufuMeisaiLineNo
     */
    public void setKyufuMeisaiLineNo(RString kyufuMeisaiLineNo) {
        this.kyufuMeisaiLineNo = kyufuMeisaiLineNo;
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
    public int getKyufuKeikakuTanisuNissu() {
        return kyufuKeikakuTanisuNissu;
    }

    /**
     * setKyufuKeikakuTanisuNissu
     *
     * @param kyufuKeikakuTanisuNissu kyufuKeikakuTanisuNissu
     */
    public void setKyufuKeikakuTanisuNissu(int kyufuKeikakuTanisuNissu) {
        this.kyufuKeikakuTanisuNissu = kyufuKeikakuTanisuNissu;
    }

    /**
     * getKyufuKeikakuNissu
     *
     * @return kyufuKeikakuNissu
     */
    public int getKyufuKeikakuNissu() {
        return kyufuKeikakuNissu;
    }

    /**
     * setKyufuKeikakuNissu
     *
     * @param kyufuKeikakuNissu kyufuKeikakuNissu
     */
    public void setKyufuKeikakuNissu(int kyufuKeikakuNissu) {
        this.kyufuKeikakuNissu = kyufuKeikakuNissu;
    }

    /**
     * getShiteiServiceSubTotal
     *
     * @return shiteiServiceSubTotal
     */
    public int getShiteiServiceSubTotal() {
        return shiteiServiceSubTotal;
    }

    /**
     * setShiteiServiceSubTotal
     *
     * @param shiteiServiceSubTotal shiteiServiceSubTotal
     */
    public void setShiteiServiceSubTotal(int shiteiServiceSubTotal) {
        this.shiteiServiceSubTotal = shiteiServiceSubTotal;
    }

    /**
     * getKijyunGaitoServiceSubTotal
     *
     * @return kijyunGaitoServiceSubTotal
     */
    public int getKijyunGaitoServiceSubTotal() {
        return kijyunGaitoServiceSubTotal;
    }

    /**
     * setKijyunGaitoServiceSubTotal
     *
     * @param kijyunGaitoServiceSubTotal kijyunGaitoServiceSubTotal
     */
    public void setKijyunGaitoServiceSubTotal(int kijyunGaitoServiceSubTotal) {
        this.kijyunGaitoServiceSubTotal = kijyunGaitoServiceSubTotal;
    }

    /**
     * getKyufuKeikakuTotalTanisuNissu
     *
     * @return kyufuKeikakuTotalTanisuNissu
     */
    public int getKyufuKeikakuTotalTanisuNissu() {
        return kyufuKeikakuTotalTanisuNissu;
    }

    /**
     * setKyufuKeikakuTotalTanisuNissu
     *
     * @param kyufuKeikakuTotalTanisuNissu kyufuKeikakuTotalTanisuNissu
     */
    public void setKyufuKeikakuTotalTanisuNissu(int kyufuKeikakuTotalTanisuNissu) {
        this.kyufuKeikakuTotalTanisuNissu = kyufuKeikakuTotalTanisuNissu;
    }

    /**
     * getTantoKaigoShienSemmoninNo
     *
     * @return tantoKaigoShienSemmoninNo
     */
    public RString getTantoKaigoShienSemmoninNo() {
        return tantoKaigoShienSemmoninNo;
    }

    /**
     * setTantoKaigoShienSemmoninNo
     *
     * @param tantoKaigoShienSemmoninNo tantoKaigoShienSemmoninNo
     */
    public void setTantoKaigoShienSemmoninNo(RString tantoKaigoShienSemmoninNo) {
        this.tantoKaigoShienSemmoninNo = tantoKaigoShienSemmoninNo;
    }

    /**
     * getKaigoShienJigyoshaNo
     *
     * @return kaigoShienJigyoshaNo
     */
    public RString getKaigoShienJigyoshaNo() {
        return kaigoShienJigyoshaNo;
    }

    /**
     * setKaigoShienJigyoshaNo
     *
     * @param kaigoShienJigyoshaNo kaigoShienJigyoshaNo
     */
    public void setKaigoShienJigyoshaNo(RString kaigoShienJigyoshaNo) {
        this.kaigoShienJigyoshaNo = kaigoShienJigyoshaNo;
    }

    /**
     * getItakusakiTantoKaigoShienSemmoninNo
     *
     * @return itakusakiTantoKaigoShienSemmoninNo
     */
    public RString getItakusakiTantoKaigoShienSemmoninNo() {
        return itakusakiTantoKaigoShienSemmoninNo;
    }

    /**
     * setItakusakiTantoKaigoShienSemmoninNo
     *
     * @param itakusakiTantoKaigoShienSemmoninNo
     * itakusakiTantoKaigoShienSemmoninNo
     */
    public void setItakusakiTantoKaigoShienSemmoninNo(RString itakusakiTantoKaigoShienSemmoninNo) {
        this.itakusakiTantoKaigoShienSemmoninNo = itakusakiTantoKaigoShienSemmoninNo;
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
     * このエンティティの主キーが他の{@literal DbT3015KyufuKanrihyo200604Entity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3015KyufuKanrihyo200604Entity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3015KyufuKanrihyo200604Entity other) {
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
        if (!Objects.equals(this.kyufuSakuseiKubunCode, other.kyufuSakuseiKubunCode)) {
            return false;
        }
        if (!Objects.equals(this.kyufuSakuseiYMD, other.kyufuSakuseiYMD)) {
            return false;
        }
        if (!Objects.equals(this.kyufuShubetsuKubunCode, other.kyufuShubetsuKubunCode)) {
            return false;
        }
        if (!Objects.equals(this.kyufuMeisaiLineNo, other.kyufuMeisaiLineNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3015KyufuKanrihyo200604Entity entity) {
        this.shinsaYM = entity.shinsaYM;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.kyotakushienJigyoshoNo = entity.kyotakushienJigyoshoNo;
        this.kyufuSakuseiKubunCode = entity.kyufuSakuseiKubunCode;
        this.kyufuSakuseiYMD = entity.kyufuSakuseiYMD;
        this.kyufuShubetsuKubunCode = entity.kyufuShubetsuKubunCode;
        this.kyufuMeisaiLineNo = entity.kyufuMeisaiLineNo;
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
        this.tantoKaigoShienSemmoninNo = entity.tantoKaigoShienSemmoninNo;
        this.kaigoShienJigyoshaNo = entity.kaigoShienJigyoshaNo;
        this.itakusakiTantoKaigoShienSemmoninNo = entity.itakusakiTantoKaigoShienSemmoninNo;
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
        return super.toMd5(shinsaYM, serviceTeikyoYM, shokisaiHokenshaNo, kyotakushienJigyoshoNo, kyufuSakuseiKubunCode, kyufuSakuseiYMD, kyufuShubetsuKubunCode, kyufuMeisaiLineNo, hokenshaNo, hiHokenshaNo, hiHokenshaUmareYMD, seibetsuCode, yoKaigoJotaiKubunCode, gendogakuTekiyoKaishiYM, gendogakuTekiyoShuryoYM, kyotakuKaigoYoboShikyuGendogaku, kyotakuServicePlanSakuseiKubunCode, serviceJigyoshoNo, shiteiKijungaitoChiikimitchakuServiceShikibetsuCode, serviceShuruiCode, kyufuKeikakuTanisuNissu, kyufuKeikakuNissu, shiteiServiceSubTotal, kijyunGaitoServiceSubTotal, kyufuKeikakuTotalTanisuNissu, tantoKaigoShienSemmoninNo, kaigoShienJigyoshaNo, itakusakiTantoKaigoShienSemmoninNo, toshoTorokuYMD, torikomiYM);
    }

// </editor-fold>
}
