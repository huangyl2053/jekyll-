package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ToshiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * DbT3033KyufujissekiShukeiの項目定義クラスです
 *
 */
public class DbT3033KyufujissekiShukeiEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3033KyufujissekiShukei");

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
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private JigyoshaNo jigyoshoNo;
    @PrimaryKey
    private ToshiNo toshiNo;
    @PrimaryKey
    private ServiceShuruiCode serviceSyuruiCode;
    private Integer serviceJitsunissu;
    private Decimal planTanisu;
    private Decimal gendogakuKanriTaishoTanisu;
    private Decimal gendogakuKanritaishogaiTanisu;
    private Integer tankiNyushoPlanNissu;
    private Integer tankiNyushoJitsunissu;
    private Decimal hokenTanisuTotal;
    private Decimal hokenTanisuTani;
    private Decimal hokenSeikyugaku;
    private Decimal hokenRiyoshaFutangaku;
    private Decimal kohi1TanisuTotal;
    private Decimal kohi1Seikyugaku;
    private Decimal kohi1HonninFutangaku;
    private Decimal kohi2TanisuTotal;
    private Decimal kohi2Seikyugaku;
    private Decimal kohi2HonninFutangaku;
    private Decimal kohi3TanisuTotal;
    private Decimal kohi3Seikyugaku;
    private Decimal kohi3HonninFutangaku;
    private Decimal hokenDekidakaTanisuTotal;
    private Decimal hokenDekidakaSeikyugaku;
    private Decimal hokenDekidakaIryohiRiyoshaFutangaku;
    private Decimal kohi1DekidakaTanisuTotal;
    private Decimal kohi1DekidakaSeikyugaku;
    private Decimal kohi1DekidakaIryohiRiyoshaFutangaku;
    private Decimal kohi2DekidakaTanisuTotal;
    private Decimal kohi2DekidakaSeikyugaku;
    private Decimal kohi2DekidakaIryohiRiyoshaFutangaku;
    private Decimal kohi3DekidakaTanisuTotal;
    private Decimal kohi3DekidakaSeikyugaku;
    private Decimal kohi3DekidakaIryohiRiyoshaFutangaku;
    private Integer atoTankiNyushoJitsunissu;
    private Decimal atoHokenTanisuTotal;
    private Decimal atoHokenSeikyugaku;
    private Decimal atoKohi1TanisuTotal;
    private Decimal atoKohi1Seikyugaku;
    private Decimal atoKohi2TanisuTotal;
    private Decimal atoKohi2Seikyugaku;
    private Decimal atoKohi3TanisuTotal;
    private Decimal atoKohi3Seikyugaku;
    private Decimal atoHokenDekidakaTanisuTotal;
    private Decimal atoHokenDekidakaSeikyugaku;
    private Decimal atoKohi1DekidakaTanisuTotal;
    private Decimal atoKohi1DekidakaSeikyugaku;
    private Decimal atoKohi2DekidakaTanisuTotal;
    private Decimal atoKohi2DekidakaSeikyugaku;
    private Decimal atoKohi3DekidakaTanisuTotal;
    private Decimal atoKohi3DekidakaSeikyugaku;
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
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * setHiHokenshaNo
     * @param hiHokenshaNo hiHokenshaNo
     */
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
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
     * getServiceSyuruiCode
     * @return serviceSyuruiCode
     */
    public ServiceShuruiCode getServiceSyuruiCode() {
        return serviceSyuruiCode;
    }

    /**
     * setServiceSyuruiCode
     * @param serviceSyuruiCode serviceSyuruiCode
     */
    public void setServiceSyuruiCode(ServiceShuruiCode serviceSyuruiCode) {
        this.serviceSyuruiCode = serviceSyuruiCode;
    }

    /**
     * getServiceJitsunissu
     * @return serviceJitsunissu
     */
    public Integer getServiceJitsunissu() {
        return serviceJitsunissu;
    }

    /**
     * setServiceJitsunissu
     * @param serviceJitsunissu serviceJitsunissu
     */
    public void setServiceJitsunissu(Integer serviceJitsunissu) {
        this.serviceJitsunissu = serviceJitsunissu;
    }

    /**
     * getPlanTanisu
     * @return planTanisu
     */
    public Decimal getPlanTanisu() {
        return planTanisu;
    }

    /**
     * setPlanTanisu
     * @param planTanisu planTanisu
     */
    public void setPlanTanisu(Decimal planTanisu) {
        this.planTanisu = planTanisu;
    }

    /**
     * getGendogakuKanriTaishoTanisu
     * @return gendogakuKanriTaishoTanisu
     */
    public Decimal getGendogakuKanriTaishoTanisu() {
        return gendogakuKanriTaishoTanisu;
    }

    /**
     * setGendogakuKanriTaishoTanisu
     * @param gendogakuKanriTaishoTanisu gendogakuKanriTaishoTanisu
     */
    public void setGendogakuKanriTaishoTanisu(Decimal gendogakuKanriTaishoTanisu) {
        this.gendogakuKanriTaishoTanisu = gendogakuKanriTaishoTanisu;
    }

    /**
     * getGendogakuKanritaishogaiTanisu
     * @return gendogakuKanritaishogaiTanisu
     */
    public Decimal getGendogakuKanritaishogaiTanisu() {
        return gendogakuKanritaishogaiTanisu;
    }

    /**
     * setGendogakuKanritaishogaiTanisu
     * @param gendogakuKanritaishogaiTanisu gendogakuKanritaishogaiTanisu
     */
    public void setGendogakuKanritaishogaiTanisu(Decimal gendogakuKanritaishogaiTanisu) {
        this.gendogakuKanritaishogaiTanisu = gendogakuKanritaishogaiTanisu;
    }

    /**
     * getTankiNyushoPlanNissu
     * @return tankiNyushoPlanNissu
     */
    public Integer getTankiNyushoPlanNissu() {
        return tankiNyushoPlanNissu;
    }

    /**
     * setTankiNyushoPlanNissu
     * @param tankiNyushoPlanNissu tankiNyushoPlanNissu
     */
    public void setTankiNyushoPlanNissu(Integer tankiNyushoPlanNissu) {
        this.tankiNyushoPlanNissu = tankiNyushoPlanNissu;
    }

    /**
     * getTankiNyushoJitsunissu
     * @return tankiNyushoJitsunissu
     */
    public Integer getTankiNyushoJitsunissu() {
        return tankiNyushoJitsunissu;
    }

    /**
     * setTankiNyushoJitsunissu
     * @param tankiNyushoJitsunissu tankiNyushoJitsunissu
     */
    public void setTankiNyushoJitsunissu(Integer tankiNyushoJitsunissu) {
        this.tankiNyushoJitsunissu = tankiNyushoJitsunissu;
    }

    /**
     * getHokenTanisuTotal
     * @return hokenTanisuTotal
     */
    public Decimal getHokenTanisuTotal() {
        return hokenTanisuTotal;
    }

    /**
     * setHokenTanisuTotal
     * @param hokenTanisuTotal hokenTanisuTotal
     */
    public void setHokenTanisuTotal(Decimal hokenTanisuTotal) {
        this.hokenTanisuTotal = hokenTanisuTotal;
    }

    /**
     * getHokenTanisuTani
     * @return hokenTanisuTani
     */
    public Decimal getHokenTanisuTani() {
        return hokenTanisuTani;
    }

    /**
     * setHokenTanisuTani
     * @param hokenTanisuTani hokenTanisuTani
     */
    public void setHokenTanisuTani(Decimal hokenTanisuTani) {
        this.hokenTanisuTani = hokenTanisuTani;
    }

    /**
     * getHokenSeikyugaku
     * @return hokenSeikyugaku
     */
    public Decimal getHokenSeikyugaku() {
        return hokenSeikyugaku;
    }

    /**
     * setHokenSeikyugaku
     * @param hokenSeikyugaku hokenSeikyugaku
     */
    public void setHokenSeikyugaku(Decimal hokenSeikyugaku) {
        this.hokenSeikyugaku = hokenSeikyugaku;
    }

    /**
     * getHokenRiyoshaFutangaku
     * @return hokenRiyoshaFutangaku
     */
    public Decimal getHokenRiyoshaFutangaku() {
        return hokenRiyoshaFutangaku;
    }

    /**
     * setHokenRiyoshaFutangaku
     * @param hokenRiyoshaFutangaku hokenRiyoshaFutangaku
     */
    public void setHokenRiyoshaFutangaku(Decimal hokenRiyoshaFutangaku) {
        this.hokenRiyoshaFutangaku = hokenRiyoshaFutangaku;
    }

    /**
     * getKohi1TanisuTotal
     * @return kohi1TanisuTotal
     */
    public Decimal getKohi1TanisuTotal() {
        return kohi1TanisuTotal;
    }

    /**
     * setKohi1TanisuTotal
     * @param kohi1TanisuTotal kohi1TanisuTotal
     */
    public void setKohi1TanisuTotal(Decimal kohi1TanisuTotal) {
        this.kohi1TanisuTotal = kohi1TanisuTotal;
    }

    /**
     * getKohi1Seikyugaku
     * @return kohi1Seikyugaku
     */
    public Decimal getKohi1Seikyugaku() {
        return kohi1Seikyugaku;
    }

    /**
     * setKohi1Seikyugaku
     * @param kohi1Seikyugaku kohi1Seikyugaku
     */
    public void setKohi1Seikyugaku(Decimal kohi1Seikyugaku) {
        this.kohi1Seikyugaku = kohi1Seikyugaku;
    }

    /**
     * getKohi1HonninFutangaku
     * @return kohi1HonninFutangaku
     */
    public Decimal getKohi1HonninFutangaku() {
        return kohi1HonninFutangaku;
    }

    /**
     * setKohi1HonninFutangaku
     * @param kohi1HonninFutangaku kohi1HonninFutangaku
     */
    public void setKohi1HonninFutangaku(Decimal kohi1HonninFutangaku) {
        this.kohi1HonninFutangaku = kohi1HonninFutangaku;
    }

    /**
     * getKohi2TanisuTotal
     * @return kohi2TanisuTotal
     */
    public Decimal getKohi2TanisuTotal() {
        return kohi2TanisuTotal;
    }

    /**
     * setKohi2TanisuTotal
     * @param kohi2TanisuTotal kohi2TanisuTotal
     */
    public void setKohi2TanisuTotal(Decimal kohi2TanisuTotal) {
        this.kohi2TanisuTotal = kohi2TanisuTotal;
    }

    /**
     * getKohi2Seikyugaku
     * @return kohi2Seikyugaku
     */
    public Decimal getKohi2Seikyugaku() {
        return kohi2Seikyugaku;
    }

    /**
     * setKohi2Seikyugaku
     * @param kohi2Seikyugaku kohi2Seikyugaku
     */
    public void setKohi2Seikyugaku(Decimal kohi2Seikyugaku) {
        this.kohi2Seikyugaku = kohi2Seikyugaku;
    }

    /**
     * getKohi2HonninFutangaku
     * @return kohi2HonninFutangaku
     */
    public Decimal getKohi2HonninFutangaku() {
        return kohi2HonninFutangaku;
    }

    /**
     * setKohi2HonninFutangaku
     * @param kohi2HonninFutangaku kohi2HonninFutangaku
     */
    public void setKohi2HonninFutangaku(Decimal kohi2HonninFutangaku) {
        this.kohi2HonninFutangaku = kohi2HonninFutangaku;
    }

    /**
     * getKohi3TanisuTotal
     * @return kohi3TanisuTotal
     */
    public Decimal getKohi3TanisuTotal() {
        return kohi3TanisuTotal;
    }

    /**
     * setKohi3TanisuTotal
     * @param kohi3TanisuTotal kohi3TanisuTotal
     */
    public void setKohi3TanisuTotal(Decimal kohi3TanisuTotal) {
        this.kohi3TanisuTotal = kohi3TanisuTotal;
    }

    /**
     * getKohi3Seikyugaku
     * @return kohi3Seikyugaku
     */
    public Decimal getKohi3Seikyugaku() {
        return kohi3Seikyugaku;
    }

    /**
     * setKohi3Seikyugaku
     * @param kohi3Seikyugaku kohi3Seikyugaku
     */
    public void setKohi3Seikyugaku(Decimal kohi3Seikyugaku) {
        this.kohi3Seikyugaku = kohi3Seikyugaku;
    }

    /**
     * getKohi3HonninFutangaku
     * @return kohi3HonninFutangaku
     */
    public Decimal getKohi3HonninFutangaku() {
        return kohi3HonninFutangaku;
    }

    /**
     * setKohi3HonninFutangaku
     * @param kohi3HonninFutangaku kohi3HonninFutangaku
     */
    public void setKohi3HonninFutangaku(Decimal kohi3HonninFutangaku) {
        this.kohi3HonninFutangaku = kohi3HonninFutangaku;
    }

    /**
     * getHokenDekidakaTanisuTotal
     * @return hokenDekidakaTanisuTotal
     */
    public Decimal getHokenDekidakaTanisuTotal() {
        return hokenDekidakaTanisuTotal;
    }

    /**
     * setHokenDekidakaTanisuTotal
     * @param hokenDekidakaTanisuTotal hokenDekidakaTanisuTotal
     */
    public void setHokenDekidakaTanisuTotal(Decimal hokenDekidakaTanisuTotal) {
        this.hokenDekidakaTanisuTotal = hokenDekidakaTanisuTotal;
    }

    /**
     * getHokenDekidakaSeikyugaku
     * @return hokenDekidakaSeikyugaku
     */
    public Decimal getHokenDekidakaSeikyugaku() {
        return hokenDekidakaSeikyugaku;
    }

    /**
     * setHokenDekidakaSeikyugaku
     * @param hokenDekidakaSeikyugaku hokenDekidakaSeikyugaku
     */
    public void setHokenDekidakaSeikyugaku(Decimal hokenDekidakaSeikyugaku) {
        this.hokenDekidakaSeikyugaku = hokenDekidakaSeikyugaku;
    }

    /**
     * getHokenDekidakaIryohiRiyoshaFutangaku
     * @return hokenDekidakaIryohiRiyoshaFutangaku
     */
    public Decimal getHokenDekidakaIryohiRiyoshaFutangaku() {
        return hokenDekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * setHokenDekidakaIryohiRiyoshaFutangaku
     * @param hokenDekidakaIryohiRiyoshaFutangaku hokenDekidakaIryohiRiyoshaFutangaku
     */
    public void setHokenDekidakaIryohiRiyoshaFutangaku(Decimal hokenDekidakaIryohiRiyoshaFutangaku) {
        this.hokenDekidakaIryohiRiyoshaFutangaku = hokenDekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * getKohi1DekidakaTanisuTotal
     * @return kohi1DekidakaTanisuTotal
     */
    public Decimal getKohi1DekidakaTanisuTotal() {
        return kohi1DekidakaTanisuTotal;
    }

    /**
     * setKohi1DekidakaTanisuTotal
     * @param kohi1DekidakaTanisuTotal kohi1DekidakaTanisuTotal
     */
    public void setKohi1DekidakaTanisuTotal(Decimal kohi1DekidakaTanisuTotal) {
        this.kohi1DekidakaTanisuTotal = kohi1DekidakaTanisuTotal;
    }

    /**
     * getKohi1DekidakaSeikyugaku
     * @return kohi1DekidakaSeikyugaku
     */
    public Decimal getKohi1DekidakaSeikyugaku() {
        return kohi1DekidakaSeikyugaku;
    }

    /**
     * setKohi1DekidakaSeikyugaku
     * @param kohi1DekidakaSeikyugaku kohi1DekidakaSeikyugaku
     */
    public void setKohi1DekidakaSeikyugaku(Decimal kohi1DekidakaSeikyugaku) {
        this.kohi1DekidakaSeikyugaku = kohi1DekidakaSeikyugaku;
    }

    /**
     * getKohi1DekidakaIryohiRiyoshaFutangaku
     * @return kohi1DekidakaIryohiRiyoshaFutangaku
     */
    public Decimal getKohi1DekidakaIryohiRiyoshaFutangaku() {
        return kohi1DekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * setKohi1DekidakaIryohiRiyoshaFutangaku
     * @param kohi1DekidakaIryohiRiyoshaFutangaku kohi1DekidakaIryohiRiyoshaFutangaku
     */
    public void setKohi1DekidakaIryohiRiyoshaFutangaku(Decimal kohi1DekidakaIryohiRiyoshaFutangaku) {
        this.kohi1DekidakaIryohiRiyoshaFutangaku = kohi1DekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * getKohi2DekidakaTanisuTotal
     * @return kohi2DekidakaTanisuTotal
     */
    public Decimal getKohi2DekidakaTanisuTotal() {
        return kohi2DekidakaTanisuTotal;
    }

    /**
     * setKohi2DekidakaTanisuTotal
     * @param kohi2DekidakaTanisuTotal kohi2DekidakaTanisuTotal
     */
    public void setKohi2DekidakaTanisuTotal(Decimal kohi2DekidakaTanisuTotal) {
        this.kohi2DekidakaTanisuTotal = kohi2DekidakaTanisuTotal;
    }

    /**
     * getKohi2DekidakaSeikyugaku
     * @return kohi2DekidakaSeikyugaku
     */
    public Decimal getKohi2DekidakaSeikyugaku() {
        return kohi2DekidakaSeikyugaku;
    }

    /**
     * setKohi2DekidakaSeikyugaku
     * @param kohi2DekidakaSeikyugaku kohi2DekidakaSeikyugaku
     */
    public void setKohi2DekidakaSeikyugaku(Decimal kohi2DekidakaSeikyugaku) {
        this.kohi2DekidakaSeikyugaku = kohi2DekidakaSeikyugaku;
    }

    /**
     * getKohi2DekidakaIryohiRiyoshaFutangaku
     * @return kohi2DekidakaIryohiRiyoshaFutangaku
     */
    public Decimal getKohi2DekidakaIryohiRiyoshaFutangaku() {
        return kohi2DekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * setKohi2DekidakaIryohiRiyoshaFutangaku
     * @param kohi2DekidakaIryohiRiyoshaFutangaku kohi2DekidakaIryohiRiyoshaFutangaku
     */
    public void setKohi2DekidakaIryohiRiyoshaFutangaku(Decimal kohi2DekidakaIryohiRiyoshaFutangaku) {
        this.kohi2DekidakaIryohiRiyoshaFutangaku = kohi2DekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * getKohi3DekidakaTanisuTotal
     * @return kohi3DekidakaTanisuTotal
     */
    public Decimal getKohi3DekidakaTanisuTotal() {
        return kohi3DekidakaTanisuTotal;
    }

    /**
     * setKohi3DekidakaTanisuTotal
     * @param kohi3DekidakaTanisuTotal kohi3DekidakaTanisuTotal
     */
    public void setKohi3DekidakaTanisuTotal(Decimal kohi3DekidakaTanisuTotal) {
        this.kohi3DekidakaTanisuTotal = kohi3DekidakaTanisuTotal;
    }

    /**
     * getKohi3DekidakaSeikyugaku
     * @return kohi3DekidakaSeikyugaku
     */
    public Decimal getKohi3DekidakaSeikyugaku() {
        return kohi3DekidakaSeikyugaku;
    }

    /**
     * setKohi3DekidakaSeikyugaku
     * @param kohi3DekidakaSeikyugaku kohi3DekidakaSeikyugaku
     */
    public void setKohi3DekidakaSeikyugaku(Decimal kohi3DekidakaSeikyugaku) {
        this.kohi3DekidakaSeikyugaku = kohi3DekidakaSeikyugaku;
    }

    /**
     * getKohi3DekidakaIryohiRiyoshaFutangaku
     * @return kohi3DekidakaIryohiRiyoshaFutangaku
     */
    public Decimal getKohi3DekidakaIryohiRiyoshaFutangaku() {
        return kohi3DekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * setKohi3DekidakaIryohiRiyoshaFutangaku
     * @param kohi3DekidakaIryohiRiyoshaFutangaku kohi3DekidakaIryohiRiyoshaFutangaku
     */
    public void setKohi3DekidakaIryohiRiyoshaFutangaku(Decimal kohi3DekidakaIryohiRiyoshaFutangaku) {
        this.kohi3DekidakaIryohiRiyoshaFutangaku = kohi3DekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * getAtoTankiNyushoJitsunissu
     * @return atoTankiNyushoJitsunissu
     */
    public Integer getAtoTankiNyushoJitsunissu() {
        return atoTankiNyushoJitsunissu;
    }

    /**
     * setAtoTankiNyushoJitsunissu
     * @param atoTankiNyushoJitsunissu atoTankiNyushoJitsunissu
     */
    public void setAtoTankiNyushoJitsunissu(Integer atoTankiNyushoJitsunissu) {
        this.atoTankiNyushoJitsunissu = atoTankiNyushoJitsunissu;
    }

    /**
     * getAtoHokenTanisuTotal
     * @return atoHokenTanisuTotal
     */
    public Decimal getAtoHokenTanisuTotal() {
        return atoHokenTanisuTotal;
    }

    /**
     * setAtoHokenTanisuTotal
     * @param atoHokenTanisuTotal atoHokenTanisuTotal
     */
    public void setAtoHokenTanisuTotal(Decimal atoHokenTanisuTotal) {
        this.atoHokenTanisuTotal = atoHokenTanisuTotal;
    }

    /**
     * getAtoHokenSeikyugaku
     * @return atoHokenSeikyugaku
     */
    public Decimal getAtoHokenSeikyugaku() {
        return atoHokenSeikyugaku;
    }

    /**
     * setAtoHokenSeikyugaku
     * @param atoHokenSeikyugaku atoHokenSeikyugaku
     */
    public void setAtoHokenSeikyugaku(Decimal atoHokenSeikyugaku) {
        this.atoHokenSeikyugaku = atoHokenSeikyugaku;
    }

    /**
     * getAtoKohi1TanisuTotal
     * @return atoKohi1TanisuTotal
     */
    public Decimal getAtoKohi1TanisuTotal() {
        return atoKohi1TanisuTotal;
    }

    /**
     * setAtoKohi1TanisuTotal
     * @param atoKohi1TanisuTotal atoKohi1TanisuTotal
     */
    public void setAtoKohi1TanisuTotal(Decimal atoKohi1TanisuTotal) {
        this.atoKohi1TanisuTotal = atoKohi1TanisuTotal;
    }

    /**
     * getAtoKohi1Seikyugaku
     * @return atoKohi1Seikyugaku
     */
    public Decimal getAtoKohi1Seikyugaku() {
        return atoKohi1Seikyugaku;
    }

    /**
     * setAtoKohi1Seikyugaku
     * @param atoKohi1Seikyugaku atoKohi1Seikyugaku
     */
    public void setAtoKohi1Seikyugaku(Decimal atoKohi1Seikyugaku) {
        this.atoKohi1Seikyugaku = atoKohi1Seikyugaku;
    }

    /**
     * getAtoKohi2TanisuTotal
     * @return atoKohi2TanisuTotal
     */
    public Decimal getAtoKohi2TanisuTotal() {
        return atoKohi2TanisuTotal;
    }

    /**
     * setAtoKohi2TanisuTotal
     * @param atoKohi2TanisuTotal atoKohi2TanisuTotal
     */
    public void setAtoKohi2TanisuTotal(Decimal atoKohi2TanisuTotal) {
        this.atoKohi2TanisuTotal = atoKohi2TanisuTotal;
    }

    /**
     * getAtoKohi2Seikyugaku
     * @return atoKohi2Seikyugaku
     */
    public Decimal getAtoKohi2Seikyugaku() {
        return atoKohi2Seikyugaku;
    }

    /**
     * setAtoKohi2Seikyugaku
     * @param atoKohi2Seikyugaku atoKohi2Seikyugaku
     */
    public void setAtoKohi2Seikyugaku(Decimal atoKohi2Seikyugaku) {
        this.atoKohi2Seikyugaku = atoKohi2Seikyugaku;
    }

    /**
     * getAtoKohi3TanisuTotal
     * @return atoKohi3TanisuTotal
     */
    public Decimal getAtoKohi3TanisuTotal() {
        return atoKohi3TanisuTotal;
    }

    /**
     * setAtoKohi3TanisuTotal
     * @param atoKohi3TanisuTotal atoKohi3TanisuTotal
     */
    public void setAtoKohi3TanisuTotal(Decimal atoKohi3TanisuTotal) {
        this.atoKohi3TanisuTotal = atoKohi3TanisuTotal;
    }

    /**
     * getAtoKohi3Seikyugaku
     * @return atoKohi3Seikyugaku
     */
    public Decimal getAtoKohi3Seikyugaku() {
        return atoKohi3Seikyugaku;
    }

    /**
     * setAtoKohi3Seikyugaku
     * @param atoKohi3Seikyugaku atoKohi3Seikyugaku
     */
    public void setAtoKohi3Seikyugaku(Decimal atoKohi3Seikyugaku) {
        this.atoKohi3Seikyugaku = atoKohi3Seikyugaku;
    }

    /**
     * getAtoHokenDekidakaTanisuTotal
     * @return atoHokenDekidakaTanisuTotal
     */
    public Decimal getAtoHokenDekidakaTanisuTotal() {
        return atoHokenDekidakaTanisuTotal;
    }

    /**
     * setAtoHokenDekidakaTanisuTotal
     * @param atoHokenDekidakaTanisuTotal atoHokenDekidakaTanisuTotal
     */
    public void setAtoHokenDekidakaTanisuTotal(Decimal atoHokenDekidakaTanisuTotal) {
        this.atoHokenDekidakaTanisuTotal = atoHokenDekidakaTanisuTotal;
    }

    /**
     * getAtoHokenDekidakaSeikyugaku
     * @return atoHokenDekidakaSeikyugaku
     */
    public Decimal getAtoHokenDekidakaSeikyugaku() {
        return atoHokenDekidakaSeikyugaku;
    }

    /**
     * setAtoHokenDekidakaSeikyugaku
     * @param atoHokenDekidakaSeikyugaku atoHokenDekidakaSeikyugaku
     */
    public void setAtoHokenDekidakaSeikyugaku(Decimal atoHokenDekidakaSeikyugaku) {
        this.atoHokenDekidakaSeikyugaku = atoHokenDekidakaSeikyugaku;
    }

    /**
     * getAtoKohi1DekidakaTanisuTotal
     * @return atoKohi1DekidakaTanisuTotal
     */
    public Decimal getAtoKohi1DekidakaTanisuTotal() {
        return atoKohi1DekidakaTanisuTotal;
    }

    /**
     * setAtoKohi1DekidakaTanisuTotal
     * @param atoKohi1DekidakaTanisuTotal atoKohi1DekidakaTanisuTotal
     */
    public void setAtoKohi1DekidakaTanisuTotal(Decimal atoKohi1DekidakaTanisuTotal) {
        this.atoKohi1DekidakaTanisuTotal = atoKohi1DekidakaTanisuTotal;
    }

    /**
     * getAtoKohi1DekidakaSeikyugaku
     * @return atoKohi1DekidakaSeikyugaku
     */
    public Decimal getAtoKohi1DekidakaSeikyugaku() {
        return atoKohi1DekidakaSeikyugaku;
    }

    /**
     * setAtoKohi1DekidakaSeikyugaku
     * @param atoKohi1DekidakaSeikyugaku atoKohi1DekidakaSeikyugaku
     */
    public void setAtoKohi1DekidakaSeikyugaku(Decimal atoKohi1DekidakaSeikyugaku) {
        this.atoKohi1DekidakaSeikyugaku = atoKohi1DekidakaSeikyugaku;
    }

    /**
     * getAtoKohi2DekidakaTanisuTotal
     * @return atoKohi2DekidakaTanisuTotal
     */
    public Decimal getAtoKohi2DekidakaTanisuTotal() {
        return atoKohi2DekidakaTanisuTotal;
    }

    /**
     * setAtoKohi2DekidakaTanisuTotal
     * @param atoKohi2DekidakaTanisuTotal atoKohi2DekidakaTanisuTotal
     */
    public void setAtoKohi2DekidakaTanisuTotal(Decimal atoKohi2DekidakaTanisuTotal) {
        this.atoKohi2DekidakaTanisuTotal = atoKohi2DekidakaTanisuTotal;
    }

    /**
     * getAtoKohi2DekidakaSeikyugaku
     * @return atoKohi2DekidakaSeikyugaku
     */
    public Decimal getAtoKohi2DekidakaSeikyugaku() {
        return atoKohi2DekidakaSeikyugaku;
    }

    /**
     * setAtoKohi2DekidakaSeikyugaku
     * @param atoKohi2DekidakaSeikyugaku atoKohi2DekidakaSeikyugaku
     */
    public void setAtoKohi2DekidakaSeikyugaku(Decimal atoKohi2DekidakaSeikyugaku) {
        this.atoKohi2DekidakaSeikyugaku = atoKohi2DekidakaSeikyugaku;
    }

    /**
     * getAtoKohi3DekidakaTanisuTotal
     * @return atoKohi3DekidakaTanisuTotal
     */
    public Decimal getAtoKohi3DekidakaTanisuTotal() {
        return atoKohi3DekidakaTanisuTotal;
    }

    /**
     * setAtoKohi3DekidakaTanisuTotal
     * @param atoKohi3DekidakaTanisuTotal atoKohi3DekidakaTanisuTotal
     */
    public void setAtoKohi3DekidakaTanisuTotal(Decimal atoKohi3DekidakaTanisuTotal) {
        this.atoKohi3DekidakaTanisuTotal = atoKohi3DekidakaTanisuTotal;
    }

    /**
     * getAtoKohi3DekidakaSeikyugaku
     * @return atoKohi3DekidakaSeikyugaku
     */
    public Decimal getAtoKohi3DekidakaSeikyugaku() {
        return atoKohi3DekidakaSeikyugaku;
    }

    /**
     * setAtoKohi3DekidakaSeikyugaku
     * @param atoKohi3DekidakaSeikyugaku atoKohi3DekidakaSeikyugaku
     */
    public void setAtoKohi3DekidakaSeikyugaku(Decimal atoKohi3DekidakaSeikyugaku) {
        this.atoKohi3DekidakaSeikyugaku = atoKohi3DekidakaSeikyugaku;
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
     * このエンティティの主キーが他の{@literal DbT3033KyufujissekiShukeiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3033KyufujissekiShukeiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT3033KyufujissekiShukeiEntity other) {
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
        if (!Objects.equals(this.serviceSyuruiCode, other.serviceSyuruiCode)) {
            return false;
        }
        return true;
    }

// </editor-fold>

}
