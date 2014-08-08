package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ToshiNo;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceCode;
import java.util.Objects;

/**
 * DbT3025KyufujissekiKyotakuServiceの項目定義クラスです
 *
 */
public class DbT3025KyufujissekiKyotakuServiceEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3025KyufujissekiKyotakuService");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private KokanShikibetsuNo kokanJohoShikibetsuNo;
    @PrimaryKey
    private RString inputShikibetsuNo;
    @PrimaryKey
    private RString recodeShubetsuCode;
    @PrimaryKey
    private ShoKisaiHokenshaNo shokisaiHokenshaNo;
    @PrimaryKey
    private KaigoHihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private JigyoshaNo jigyoshoNo;
    @PrimaryKey
    private ToshiNo toshiNo;
    @PrimaryKey
    private RString servicePlanhiMeisaiLineNo;
    private RString shiteiKijunGaitoJigyoshaKubunCode;
    private Decimal tanisuTanka;
    private FlexibleDate kyotakuServiceSakuseiIraiYMD;
    private ServiceCode serviceCode;
    private Decimal tanisu;
    private Integer kaisu;
    private Decimal serviceTanisu;
    private Decimal serviceTanisuTotal;
    private Decimal seikyuKingaku;
    private RString tantouKaigoShienSemmoninNo;
    private RString tekiyo;
    private Decimal atoTanisu;
    private Integer atoKaisu;
    private Decimal atoServiceTanisu;
    private Decimal atoServiceTanisuTotal;
    private Decimal atoSeikyuKingaku;
    private Integer saishinsaKaisu;
    private Integer kagoKaisu;
    private FlexibleYearMonth shinsaYM;
    private RString seiriNo;
    private FlexibleYearMonth torikomiYM;

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
     * getKokanJohoShikibetsuNo
     * @return kokanJohoShikibetsuNo
     */
    public KokanShikibetsuNo getKokanJohoShikibetsuNo() {
        return kokanJohoShikibetsuNo;
    }

    /**
     * setKokanJohoShikibetsuNo
     * @param kokanJohoShikibetsuNo kokanJohoShikibetsuNo
     */
    public void setKokanJohoShikibetsuNo(KokanShikibetsuNo kokanJohoShikibetsuNo) {
        this.kokanJohoShikibetsuNo = kokanJohoShikibetsuNo;
    }

    /**
     * getInputShikibetsuNo
     * @return inputShikibetsuNo
     */
    public RString getInputShikibetsuNo() {
        return inputShikibetsuNo;
    }

    /**
     * setInputShikibetsuNo
     * @param inputShikibetsuNo inputShikibetsuNo
     */
    public void setInputShikibetsuNo(RString inputShikibetsuNo) {
        this.inputShikibetsuNo = inputShikibetsuNo;
    }

    /**
     * getRecodeShubetsuCode
     * @return recodeShubetsuCode
     */
    public RString getRecodeShubetsuCode() {
        return recodeShubetsuCode;
    }

    /**
     * setRecodeShubetsuCode
     * @param recodeShubetsuCode recodeShubetsuCode
     */
    public void setRecodeShubetsuCode(RString recodeShubetsuCode) {
        this.recodeShubetsuCode = recodeShubetsuCode;
    }

    /**
     * getShokisaiHokenshaNo
     * @return shokisaiHokenshaNo
     */
    public ShoKisaiHokenshaNo getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    /**
     * setShokisaiHokenshaNo
     * @param shokisaiHokenshaNo shokisaiHokenshaNo
     */
    public void setShokisaiHokenshaNo(ShoKisaiHokenshaNo shokisaiHokenshaNo) {
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
    }

    /**
     * getHiHokenshaNo
     * @return hiHokenshaNo
     */
    public KaigoHihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * setHiHokenshaNo
     * @param hiHokenshaNo hiHokenshaNo
     */
    public void setHiHokenshaNo(KaigoHihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * getServiceTeikyoYM
     * @return serviceTeikyoYM
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * setServiceTeikyoYM
     * @param serviceTeikyoYM serviceTeikyoYM
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * getJigyoshoNo
     * @return jigyoshoNo
     */
    public JigyoshaNo getJigyoshoNo() {
        return jigyoshoNo;
    }

    /**
     * setJigyoshoNo
     * @param jigyoshoNo jigyoshoNo
     */
    public void setJigyoshoNo(JigyoshaNo jigyoshoNo) {
        this.jigyoshoNo = jigyoshoNo;
    }

    /**
     * getToshiNo
     * @return toshiNo
     */
    public ToshiNo getToshiNo() {
        return toshiNo;
    }

    /**
     * setToshiNo
     * @param toshiNo toshiNo
     */
    public void setToshiNo(ToshiNo toshiNo) {
        this.toshiNo = toshiNo;
    }

    /**
     * getServicePlanhiMeisaiLineNo
     * @return servicePlanhiMeisaiLineNo
     */
    public RString getServicePlanhiMeisaiLineNo() {
        return servicePlanhiMeisaiLineNo;
    }

    /**
     * setServicePlanhiMeisaiLineNo
     * @param servicePlanhiMeisaiLineNo servicePlanhiMeisaiLineNo
     */
    public void setServicePlanhiMeisaiLineNo(RString servicePlanhiMeisaiLineNo) {
        this.servicePlanhiMeisaiLineNo = servicePlanhiMeisaiLineNo;
    }

    /**
     * getShiteiKijunGaitoJigyoshaKubunCode
     * @return shiteiKijunGaitoJigyoshaKubunCode
     */
    public RString getShiteiKijunGaitoJigyoshaKubunCode() {
        return shiteiKijunGaitoJigyoshaKubunCode;
    }

    /**
     * setShiteiKijunGaitoJigyoshaKubunCode
     * @param shiteiKijunGaitoJigyoshaKubunCode shiteiKijunGaitoJigyoshaKubunCode
     */
    public void setShiteiKijunGaitoJigyoshaKubunCode(RString shiteiKijunGaitoJigyoshaKubunCode) {
        this.shiteiKijunGaitoJigyoshaKubunCode = shiteiKijunGaitoJigyoshaKubunCode;
    }

    /**
     * getTanisuTanka
     * @return tanisuTanka
     */
    public Decimal getTanisuTanka() {
        return tanisuTanka;
    }

    /**
     * setTanisuTanka
     * @param tanisuTanka tanisuTanka
     */
    public void setTanisuTanka(Decimal tanisuTanka) {
        this.tanisuTanka = tanisuTanka;
    }

    /**
     * getKyotakuServiceSakuseiIraiYMD
     * @return kyotakuServiceSakuseiIraiYMD
     */
    public FlexibleDate getKyotakuServiceSakuseiIraiYMD() {
        return kyotakuServiceSakuseiIraiYMD;
    }

    /**
     * setKyotakuServiceSakuseiIraiYMD
     * @param kyotakuServiceSakuseiIraiYMD kyotakuServiceSakuseiIraiYMD
     */
    public void setKyotakuServiceSakuseiIraiYMD(FlexibleDate kyotakuServiceSakuseiIraiYMD) {
        this.kyotakuServiceSakuseiIraiYMD = kyotakuServiceSakuseiIraiYMD;
    }

    /**
     * getServiceCode
     * @return serviceCode
     */
    public ServiceCode getServiceCode() {
        return serviceCode;
    }

    /**
     * setServiceCode
     * @param serviceCode serviceCode
     */
    public void setServiceCode(ServiceCode serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * getTanisu
     * @return tanisu
     */
    public Decimal getTanisu() {
        return tanisu;
    }

    /**
     * setTanisu
     * @param tanisu tanisu
     */
    public void setTanisu(Decimal tanisu) {
        this.tanisu = tanisu;
    }

    /**
     * getKaisu
     * @return kaisu
     */
    public Integer getKaisu() {
        return kaisu;
    }

    /**
     * setKaisu
     * @param kaisu kaisu
     */
    public void setKaisu(Integer kaisu) {
        this.kaisu = kaisu;
    }

    /**
     * getServiceTanisu
     * @return serviceTanisu
     */
    public Decimal getServiceTanisu() {
        return serviceTanisu;
    }

    /**
     * setServiceTanisu
     * @param serviceTanisu serviceTanisu
     */
    public void setServiceTanisu(Decimal serviceTanisu) {
        this.serviceTanisu = serviceTanisu;
    }

    /**
     * getServiceTanisuTotal
     * @return serviceTanisuTotal
     */
    public Decimal getServiceTanisuTotal() {
        return serviceTanisuTotal;
    }

    /**
     * setServiceTanisuTotal
     * @param serviceTanisuTotal serviceTanisuTotal
     */
    public void setServiceTanisuTotal(Decimal serviceTanisuTotal) {
        this.serviceTanisuTotal = serviceTanisuTotal;
    }

    /**
     * getSeikyuKingaku
     * @return seikyuKingaku
     */
    public Decimal getSeikyuKingaku() {
        return seikyuKingaku;
    }

    /**
     * setSeikyuKingaku
     * @param seikyuKingaku seikyuKingaku
     */
    public void setSeikyuKingaku(Decimal seikyuKingaku) {
        this.seikyuKingaku = seikyuKingaku;
    }

    /**
     * getTantouKaigoShienSemmoninNo
     * @return tantouKaigoShienSemmoninNo
     */
    public RString getTantouKaigoShienSemmoninNo() {
        return tantouKaigoShienSemmoninNo;
    }

    /**
     * setTantouKaigoShienSemmoninNo
     * @param tantouKaigoShienSemmoninNo tantouKaigoShienSemmoninNo
     */
    public void setTantouKaigoShienSemmoninNo(RString tantouKaigoShienSemmoninNo) {
        this.tantouKaigoShienSemmoninNo = tantouKaigoShienSemmoninNo;
    }

    /**
     * getTekiyo
     * @return tekiyo
     */
    public RString getTekiyo() {
        return tekiyo;
    }

    /**
     * setTekiyo
     * @param tekiyo tekiyo
     */
    public void setTekiyo(RString tekiyo) {
        this.tekiyo = tekiyo;
    }

    /**
     * getAtoTanisu
     * @return atoTanisu
     */
    public Decimal getAtoTanisu() {
        return atoTanisu;
    }

    /**
     * setAtoTanisu
     * @param atoTanisu atoTanisu
     */
    public void setAtoTanisu(Decimal atoTanisu) {
        this.atoTanisu = atoTanisu;
    }

    /**
     * getAtoKaisu
     * @return atoKaisu
     */
    public Integer getAtoKaisu() {
        return atoKaisu;
    }

    /**
     * setAtoKaisu
     * @param atoKaisu atoKaisu
     */
    public void setAtoKaisu(Integer atoKaisu) {
        this.atoKaisu = atoKaisu;
    }

    /**
     * getAtoServiceTanisu
     * @return atoServiceTanisu
     */
    public Decimal getAtoServiceTanisu() {
        return atoServiceTanisu;
    }

    /**
     * setAtoServiceTanisu
     * @param atoServiceTanisu atoServiceTanisu
     */
    public void setAtoServiceTanisu(Decimal atoServiceTanisu) {
        this.atoServiceTanisu = atoServiceTanisu;
    }

    /**
     * getAtoServiceTanisuTotal
     * @return atoServiceTanisuTotal
     */
    public Decimal getAtoServiceTanisuTotal() {
        return atoServiceTanisuTotal;
    }

    /**
     * setAtoServiceTanisuTotal
     * @param atoServiceTanisuTotal atoServiceTanisuTotal
     */
    public void setAtoServiceTanisuTotal(Decimal atoServiceTanisuTotal) {
        this.atoServiceTanisuTotal = atoServiceTanisuTotal;
    }

    /**
     * getAtoSeikyuKingaku
     * @return atoSeikyuKingaku
     */
    public Decimal getAtoSeikyuKingaku() {
        return atoSeikyuKingaku;
    }

    /**
     * setAtoSeikyuKingaku
     * @param atoSeikyuKingaku atoSeikyuKingaku
     */
    public void setAtoSeikyuKingaku(Decimal atoSeikyuKingaku) {
        this.atoSeikyuKingaku = atoSeikyuKingaku;
    }

    /**
     * getSaishinsaKaisu
     * @return saishinsaKaisu
     */
    public Integer getSaishinsaKaisu() {
        return saishinsaKaisu;
    }

    /**
     * setSaishinsaKaisu
     * @param saishinsaKaisu saishinsaKaisu
     */
    public void setSaishinsaKaisu(Integer saishinsaKaisu) {
        this.saishinsaKaisu = saishinsaKaisu;
    }

    /**
     * getKagoKaisu
     * @return kagoKaisu
     */
    public Integer getKagoKaisu() {
        return kagoKaisu;
    }

    /**
     * setKagoKaisu
     * @param kagoKaisu kagoKaisu
     */
    public void setKagoKaisu(Integer kagoKaisu) {
        this.kagoKaisu = kagoKaisu;
    }

    /**
     * getShinsaYM
     * @return shinsaYM
     */
    public FlexibleYearMonth getShinsaYM() {
        return shinsaYM;
    }

    /**
     * setShinsaYM
     * @param shinsaYM shinsaYM
     */
    public void setShinsaYM(FlexibleYearMonth shinsaYM) {
        this.shinsaYM = shinsaYM;
    }

    /**
     * getSeiriNo
     * @return seiriNo
     */
    public RString getSeiriNo() {
        return seiriNo;
    }

    /**
     * setSeiriNo
     * @param seiriNo seiriNo
     */
    public void setSeiriNo(RString seiriNo) {
        this.seiriNo = seiriNo;
    }

    /**
     * getTorikomiYM
     * @return torikomiYM
     */
    public FlexibleYearMonth getTorikomiYM() {
        return torikomiYM;
    }

    /**
     * setTorikomiYM
     * @param torikomiYM torikomiYM
     */
    public void setTorikomiYM(FlexibleYearMonth torikomiYM) {
        this.torikomiYM = torikomiYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3025KyufujissekiKyotakuServiceEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3025KyufujissekiKyotakuServiceEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT3025KyufujissekiKyotakuServiceEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.kokanJohoShikibetsuNo, other.kokanJohoShikibetsuNo)) {
            return false;
        }
        if (!Objects.equals(this.inputShikibetsuNo, other.inputShikibetsuNo)) {
            return false;
        }
        if (!Objects.equals(this.recodeShubetsuCode, other.recodeShubetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.shokisaiHokenshaNo, other.shokisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.jigyoshoNo, other.jigyoshoNo)) {
            return false;
        }
        if (!Objects.equals(this.toshiNo, other.toshiNo)) {
            return false;
        }
        if (!Objects.equals(this.servicePlanhiMeisaiLineNo, other.servicePlanhiMeisaiLineNo)) {
            return false;
        }
        return true;
    }

// </editor-fold>




}
