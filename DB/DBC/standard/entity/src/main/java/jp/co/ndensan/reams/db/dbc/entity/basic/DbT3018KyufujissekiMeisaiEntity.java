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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ToshiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceKomokuCode;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * DbT3018KyufujissekiMeisaiの項目定義クラスです
 *
 */
public class DbT3018KyufujissekiMeisaiEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3018KyufujissekiMeisai");

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
    private ServiceShuruiCode serviceShuruiCode;
    @PrimaryKey
    private ServiceKomokuCode serviceKomokuCode;
    private Decimal tanisu;
    private Integer nissuKaisu;
    private Integer kohi1TaishoNissuKaisu;
    private Integer kohi2TaishoNissuKaisu;
    private Integer kohi3TaishoNissuKaisu;
    private Decimal serviceTanisu;
    private Decimal kohi1TaishoServiceTanisu;
    private Decimal kohi2TaishoServiceTanisu;
    private Decimal kohi3TaishoServiceTanisu;
    private RString tekiyo;
    private Decimal atoTanisu;
    private Integer atoNissuKaisu;
    private Integer atoKohi1TaishoNissuKaisu;
    private Integer atoKohi2TaishoNissukaisu;
    private Integer atoKohi3TaishoNissuKaisu;
    private Decimal atoServiceTanisu;
    private Decimal atoKohi1TaishoServiceTanisu;
    private Decimal atoKohi2TaishoServiceTanisu;
    private Decimal atoKohi3TaishoServiceTanisu;
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
     * getServiceShuruiCode
     * @return serviceShuruiCode
     */
    public ServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * setServiceShuruiCode
     * @param serviceShuruiCode serviceShuruiCode
     */
    public void setServiceShuruiCode(ServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * getServiceKomokuCode
     * @return serviceKomokuCode
     */
    public ServiceKomokuCode getServiceKomokuCode() {
        return serviceKomokuCode;
    }

    /**
     * setServiceKomokuCode
     * @param serviceKomokuCode serviceKomokuCode
     */
    public void setServiceKomokuCode(ServiceKomokuCode serviceKomokuCode) {
        this.serviceKomokuCode = serviceKomokuCode;
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
     * getNissuKaisu
     * @return nissuKaisu
     */
    public Integer getNissuKaisu() {
        return nissuKaisu;
    }

    /**
     * setNissuKaisu
     * @param nissuKaisu nissuKaisu
     */
    public void setNissuKaisu(Integer nissuKaisu) {
        this.nissuKaisu = nissuKaisu;
    }

    /**
     * getKohi1TaishoNissuKaisu
     * @return kohi1TaishoNissuKaisu
     */
    public Integer getKohi1TaishoNissuKaisu() {
        return kohi1TaishoNissuKaisu;
    }

    /**
     * setKohi1TaishoNissuKaisu
     * @param kohi1TaishoNissuKaisu kohi1TaishoNissuKaisu
     */
    public void setKohi1TaishoNissuKaisu(Integer kohi1TaishoNissuKaisu) {
        this.kohi1TaishoNissuKaisu = kohi1TaishoNissuKaisu;
    }

    /**
     * getKohi2TaishoNissuKaisu
     * @return kohi2TaishoNissuKaisu
     */
    public Integer getKohi2TaishoNissuKaisu() {
        return kohi2TaishoNissuKaisu;
    }

    /**
     * setKohi2TaishoNissuKaisu
     * @param kohi2TaishoNissuKaisu kohi2TaishoNissuKaisu
     */
    public void setKohi2TaishoNissuKaisu(Integer kohi2TaishoNissuKaisu) {
        this.kohi2TaishoNissuKaisu = kohi2TaishoNissuKaisu;
    }

    /**
     * getKohi3TaishoNissuKaisu
     * @return kohi3TaishoNissuKaisu
     */
    public Integer getKohi3TaishoNissuKaisu() {
        return kohi3TaishoNissuKaisu;
    }

    /**
     * setKohi3TaishoNissuKaisu
     * @param kohi3TaishoNissuKaisu kohi3TaishoNissuKaisu
     */
    public void setKohi3TaishoNissuKaisu(Integer kohi3TaishoNissuKaisu) {
        this.kohi3TaishoNissuKaisu = kohi3TaishoNissuKaisu;
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
     * getKohi1TaishoServiceTanisu
     * @return kohi1TaishoServiceTanisu
     */
    public Decimal getKohi1TaishoServiceTanisu() {
        return kohi1TaishoServiceTanisu;
    }

    /**
     * setKohi1TaishoServiceTanisu
     * @param kohi1TaishoServiceTanisu kohi1TaishoServiceTanisu
     */
    public void setKohi1TaishoServiceTanisu(Decimal kohi1TaishoServiceTanisu) {
        this.kohi1TaishoServiceTanisu = kohi1TaishoServiceTanisu;
    }

    /**
     * getKohi2TaishoServiceTanisu
     * @return kohi2TaishoServiceTanisu
     */
    public Decimal getKohi2TaishoServiceTanisu() {
        return kohi2TaishoServiceTanisu;
    }

    /**
     * setKohi2TaishoServiceTanisu
     * @param kohi2TaishoServiceTanisu kohi2TaishoServiceTanisu
     */
    public void setKohi2TaishoServiceTanisu(Decimal kohi2TaishoServiceTanisu) {
        this.kohi2TaishoServiceTanisu = kohi2TaishoServiceTanisu;
    }

    /**
     * getKohi3TaishoServiceTanisu
     * @return kohi3TaishoServiceTanisu
     */
    public Decimal getKohi3TaishoServiceTanisu() {
        return kohi3TaishoServiceTanisu;
    }

    /**
     * setKohi3TaishoServiceTanisu
     * @param kohi3TaishoServiceTanisu kohi3TaishoServiceTanisu
     */
    public void setKohi3TaishoServiceTanisu(Decimal kohi3TaishoServiceTanisu) {
        this.kohi3TaishoServiceTanisu = kohi3TaishoServiceTanisu;
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
     * getAtoNissuKaisu
     * @return atoNissuKaisu
     */
    public Integer getAtoNissuKaisu() {
        return atoNissuKaisu;
    }

    /**
     * setAtoNissuKaisu
     * @param atoNissuKaisu atoNissuKaisu
     */
    public void setAtoNissuKaisu(Integer atoNissuKaisu) {
        this.atoNissuKaisu = atoNissuKaisu;
    }

    /**
     * getAtoKohi1TaishoNissuKaisu
     * @return atoKohi1TaishoNissuKaisu
     */
    public Integer getAtoKohi1TaishoNissuKaisu() {
        return atoKohi1TaishoNissuKaisu;
    }

    /**
     * setAtoKohi1TaishoNissuKaisu
     * @param atoKohi1TaishoNissuKaisu atoKohi1TaishoNissuKaisu
     */
    public void setAtoKohi1TaishoNissuKaisu(Integer atoKohi1TaishoNissuKaisu) {
        this.atoKohi1TaishoNissuKaisu = atoKohi1TaishoNissuKaisu;
    }

    /**
     * getAtoKohi2TaishoNissukaisu
     * @return atoKohi2TaishoNissukaisu
     */
    public Integer getAtoKohi2TaishoNissukaisu() {
        return atoKohi2TaishoNissukaisu;
    }

    /**
     * setAtoKohi2TaishoNissukaisu
     * @param atoKohi2TaishoNissukaisu atoKohi2TaishoNissukaisu
     */
    public void setAtoKohi2TaishoNissukaisu(Integer atoKohi2TaishoNissukaisu) {
        this.atoKohi2TaishoNissukaisu = atoKohi2TaishoNissukaisu;
    }

    /**
     * getAtoKohi3TaishoNissuKaisu
     * @return atoKohi3TaishoNissuKaisu
     */
    public Integer getAtoKohi3TaishoNissuKaisu() {
        return atoKohi3TaishoNissuKaisu;
    }

    /**
     * setAtoKohi3TaishoNissuKaisu
     * @param atoKohi3TaishoNissuKaisu atoKohi3TaishoNissuKaisu
     */
    public void setAtoKohi3TaishoNissuKaisu(Integer atoKohi3TaishoNissuKaisu) {
        this.atoKohi3TaishoNissuKaisu = atoKohi3TaishoNissuKaisu;
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
     * getAtoKohi1TaishoServiceTanisu
     * @return atoKohi1TaishoServiceTanisu
     */
    public Decimal getAtoKohi1TaishoServiceTanisu() {
        return atoKohi1TaishoServiceTanisu;
    }

    /**
     * setAtoKohi1TaishoServiceTanisu
     * @param atoKohi1TaishoServiceTanisu atoKohi1TaishoServiceTanisu
     */
    public void setAtoKohi1TaishoServiceTanisu(Decimal atoKohi1TaishoServiceTanisu) {
        this.atoKohi1TaishoServiceTanisu = atoKohi1TaishoServiceTanisu;
    }

    /**
     * getAtoKohi2TaishoServiceTanisu
     * @return atoKohi2TaishoServiceTanisu
     */
    public Decimal getAtoKohi2TaishoServiceTanisu() {
        return atoKohi2TaishoServiceTanisu;
    }

    /**
     * setAtoKohi2TaishoServiceTanisu
     * @param atoKohi2TaishoServiceTanisu atoKohi2TaishoServiceTanisu
     */
    public void setAtoKohi2TaishoServiceTanisu(Decimal atoKohi2TaishoServiceTanisu) {
        this.atoKohi2TaishoServiceTanisu = atoKohi2TaishoServiceTanisu;
    }

    /**
     * getAtoKohi3TaishoServiceTanisu
     * @return atoKohi3TaishoServiceTanisu
     */
    public Decimal getAtoKohi3TaishoServiceTanisu() {
        return atoKohi3TaishoServiceTanisu;
    }

    /**
     * setAtoKohi3TaishoServiceTanisu
     * @param atoKohi3TaishoServiceTanisu atoKohi3TaishoServiceTanisu
     */
    public void setAtoKohi3TaishoServiceTanisu(Decimal atoKohi3TaishoServiceTanisu) {
        this.atoKohi3TaishoServiceTanisu = atoKohi3TaishoServiceTanisu;
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
     * このエンティティの主キーが他の{@literal DbT3018KyufujissekiMeisaiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3018KyufujissekiMeisaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT3018KyufujissekiMeisaiEntity other) {
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
        if (!Objects.equals(this.serviceShuruiCode, other.serviceShuruiCode)) {
            return false;
        }
        if (!Objects.equals(this.serviceKomokuCode, other.serviceKomokuCode)) {
            return false;
        }
        return true;
    }

// </editor-fold>

}
