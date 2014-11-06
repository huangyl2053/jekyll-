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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoの項目定義クラスです
 *
 */
public class DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyo");

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
    private RString recodeJunjiNo;
    private ServiceShuruiCode serviceSyuruiCode;
    private ServiceKomokuCode serviceKomokuCode;
    private Decimal hiyoTanka;
    private Decimal futanGendogaku;
    private Integer nissu;
    private Integer kohi1Nissu;
    private Integer kohi2Nissu;
    private Integer kohi3Nissu;
    private Decimal hiyogaku;
    private Decimal hokenbunSeikyugaku;
    private Decimal kohi1Futangaku;
    private Decimal kohi2Futangaku;
    private Decimal kohi3Futangaku;
    private Decimal riyoshaFutangaku;
    private Decimal hiyogakuTotal;
    private Decimal hokenbunSeikyugakuTotal;
    private Decimal riyoshaFutangakuTotal;
    private Decimal kohi1FutangakuTotal;
    private Decimal kohi1Seikyugaku;
    private Decimal kohi1HonninFutanGetsugaku;
    private Decimal kohi2FutangakuTotal;
    private Decimal kohi2Seikyugaku;
    private Decimal kohi2HonninFutanGetsugaku;
    private Decimal kohi3FutangakuTotal;
    private Decimal kohi3Seikyugaku;
    private Decimal kohi3HonninFutanGetsugaku;
    private Decimal atoHiyoTanka;
    private Integer atoNissu;
    private Integer atoKohi1Nissu;
    private Integer atoKohi2Nissu;
    private Integer atoKohi3Nissu;
    private Decimal atoHiyogaku;
    private Decimal atoHokenbunSeikyugaku;
    private Decimal atoKohi1Futangaku;
    private Decimal atoKohi2Futangaku;
    private Decimal atoKohi3Futangaku;
    private Decimal atoRiyoshaFutangaku;
    private Decimal atoHiyogakuTotal;
    private Decimal atoHokenbunSeikyugakuTotal;
    private Decimal atoRiyoshaFutangakuTotal;
    private Decimal atoKohi1FutangakuTotal;
    private Decimal atoKohi1Seikyugaku;
    private Decimal atoKohi1HonninFutanGetsugaku;
    private Decimal atoKohi2FutangakuTotal;
    private Decimal atoKohi2Seikyugaku;
    private Decimal atoKohi2HonninFutanGetsugaku;
    private Decimal atoKohi3FutangakuTotal;
    private Decimal atoKohi3Seikyugaku;
    private Decimal atoKohi3HonninFutanGetsugaku;
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
     * getRecodeJunjiNo
     * @return recodeJunjiNo
     */
    public RString getRecodeJunjiNo() {
        return recodeJunjiNo;
    }

    /**
     * setRecodeJunjiNo
     * @param recodeJunjiNo recodeJunjiNo
     */
    public void setRecodeJunjiNo(RString recodeJunjiNo) {
        this.recodeJunjiNo = recodeJunjiNo;
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
     * getHiyoTanka
     * @return hiyoTanka
     */
    public Decimal getHiyoTanka() {
        return hiyoTanka;
    }

    /**
     * setHiyoTanka
     * @param hiyoTanka hiyoTanka
     */
    public void setHiyoTanka(Decimal hiyoTanka) {
        this.hiyoTanka = hiyoTanka;
    }

    /**
     * getFutanGendogaku
     * @return futanGendogaku
     */
    public Decimal getFutanGendogaku() {
        return futanGendogaku;
    }

    /**
     * setFutanGendogaku
     * @param futanGendogaku futanGendogaku
     */
    public void setFutanGendogaku(Decimal futanGendogaku) {
        this.futanGendogaku = futanGendogaku;
    }

    /**
     * getNissu
     * @return nissu
     */
    public Integer getNissu() {
        return nissu;
    }

    /**
     * setNissu
     * @param nissu nissu
     */
    public void setNissu(Integer nissu) {
        this.nissu = nissu;
    }

    /**
     * getKohi1Nissu
     * @return kohi1Nissu
     */
    public Integer getKohi1Nissu() {
        return kohi1Nissu;
    }

    /**
     * setKohi1Nissu
     * @param kohi1Nissu kohi1Nissu
     */
    public void setKohi1Nissu(Integer kohi1Nissu) {
        this.kohi1Nissu = kohi1Nissu;
    }

    /**
     * getKohi2Nissu
     * @return kohi2Nissu
     */
    public Integer getKohi2Nissu() {
        return kohi2Nissu;
    }

    /**
     * setKohi2Nissu
     * @param kohi2Nissu kohi2Nissu
     */
    public void setKohi2Nissu(Integer kohi2Nissu) {
        this.kohi2Nissu = kohi2Nissu;
    }

    /**
     * getKohi3Nissu
     * @return kohi3Nissu
     */
    public Integer getKohi3Nissu() {
        return kohi3Nissu;
    }

    /**
     * setKohi3Nissu
     * @param kohi3Nissu kohi3Nissu
     */
    public void setKohi3Nissu(Integer kohi3Nissu) {
        this.kohi3Nissu = kohi3Nissu;
    }

    /**
     * getHiyogaku
     * @return hiyogaku
     */
    public Decimal getHiyogaku() {
        return hiyogaku;
    }

    /**
     * setHiyogaku
     * @param hiyogaku hiyogaku
     */
    public void setHiyogaku(Decimal hiyogaku) {
        this.hiyogaku = hiyogaku;
    }

    /**
     * getHokenbunSeikyugaku
     * @return hokenbunSeikyugaku
     */
    public Decimal getHokenbunSeikyugaku() {
        return hokenbunSeikyugaku;
    }

    /**
     * setHokenbunSeikyugaku
     * @param hokenbunSeikyugaku hokenbunSeikyugaku
     */
    public void setHokenbunSeikyugaku(Decimal hokenbunSeikyugaku) {
        this.hokenbunSeikyugaku = hokenbunSeikyugaku;
    }

    /**
     * getKohi1Futangaku
     * @return kohi1Futangaku
     */
    public Decimal getKohi1Futangaku() {
        return kohi1Futangaku;
    }

    /**
     * setKohi1Futangaku
     * @param kohi1Futangaku kohi1Futangaku
     */
    public void setKohi1Futangaku(Decimal kohi1Futangaku) {
        this.kohi1Futangaku = kohi1Futangaku;
    }

    /**
     * getKohi2Futangaku
     * @return kohi2Futangaku
     */
    public Decimal getKohi2Futangaku() {
        return kohi2Futangaku;
    }

    /**
     * setKohi2Futangaku
     * @param kohi2Futangaku kohi2Futangaku
     */
    public void setKohi2Futangaku(Decimal kohi2Futangaku) {
        this.kohi2Futangaku = kohi2Futangaku;
    }

    /**
     * getKohi3Futangaku
     * @return kohi3Futangaku
     */
    public Decimal getKohi3Futangaku() {
        return kohi3Futangaku;
    }

    /**
     * setKohi3Futangaku
     * @param kohi3Futangaku kohi3Futangaku
     */
    public void setKohi3Futangaku(Decimal kohi3Futangaku) {
        this.kohi3Futangaku = kohi3Futangaku;
    }

    /**
     * getRiyoshaFutangaku
     * @return riyoshaFutangaku
     */
    public Decimal getRiyoshaFutangaku() {
        return riyoshaFutangaku;
    }

    /**
     * setRiyoshaFutangaku
     * @param riyoshaFutangaku riyoshaFutangaku
     */
    public void setRiyoshaFutangaku(Decimal riyoshaFutangaku) {
        this.riyoshaFutangaku = riyoshaFutangaku;
    }

    /**
     * getHiyogakuTotal
     * @return hiyogakuTotal
     */
    public Decimal getHiyogakuTotal() {
        return hiyogakuTotal;
    }

    /**
     * setHiyogakuTotal
     * @param hiyogakuTotal hiyogakuTotal
     */
    public void setHiyogakuTotal(Decimal hiyogakuTotal) {
        this.hiyogakuTotal = hiyogakuTotal;
    }

    /**
     * getHokenbunSeikyugakuTotal
     * @return hokenbunSeikyugakuTotal
     */
    public Decimal getHokenbunSeikyugakuTotal() {
        return hokenbunSeikyugakuTotal;
    }

    /**
     * setHokenbunSeikyugakuTotal
     * @param hokenbunSeikyugakuTotal hokenbunSeikyugakuTotal
     */
    public void setHokenbunSeikyugakuTotal(Decimal hokenbunSeikyugakuTotal) {
        this.hokenbunSeikyugakuTotal = hokenbunSeikyugakuTotal;
    }

    /**
     * getRiyoshaFutangakuTotal
     * @return riyoshaFutangakuTotal
     */
    public Decimal getRiyoshaFutangakuTotal() {
        return riyoshaFutangakuTotal;
    }

    /**
     * setRiyoshaFutangakuTotal
     * @param riyoshaFutangakuTotal riyoshaFutangakuTotal
     */
    public void setRiyoshaFutangakuTotal(Decimal riyoshaFutangakuTotal) {
        this.riyoshaFutangakuTotal = riyoshaFutangakuTotal;
    }

    /**
     * getKohi1FutangakuTotal
     * @return kohi1FutangakuTotal
     */
    public Decimal getKohi1FutangakuTotal() {
        return kohi1FutangakuTotal;
    }

    /**
     * setKohi1FutangakuTotal
     * @param kohi1FutangakuTotal kohi1FutangakuTotal
     */
    public void setKohi1FutangakuTotal(Decimal kohi1FutangakuTotal) {
        this.kohi1FutangakuTotal = kohi1FutangakuTotal;
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
     * getKohi1HonninFutanGetsugaku
     * @return kohi1HonninFutanGetsugaku
     */
    public Decimal getKohi1HonninFutanGetsugaku() {
        return kohi1HonninFutanGetsugaku;
    }

    /**
     * setKohi1HonninFutanGetsugaku
     * @param kohi1HonninFutanGetsugaku kohi1HonninFutanGetsugaku
     */
    public void setKohi1HonninFutanGetsugaku(Decimal kohi1HonninFutanGetsugaku) {
        this.kohi1HonninFutanGetsugaku = kohi1HonninFutanGetsugaku;
    }

    /**
     * getKohi2FutangakuTotal
     * @return kohi2FutangakuTotal
     */
    public Decimal getKohi2FutangakuTotal() {
        return kohi2FutangakuTotal;
    }

    /**
     * setKohi2FutangakuTotal
     * @param kohi2FutangakuTotal kohi2FutangakuTotal
     */
    public void setKohi2FutangakuTotal(Decimal kohi2FutangakuTotal) {
        this.kohi2FutangakuTotal = kohi2FutangakuTotal;
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
     * getKohi2HonninFutanGetsugaku
     * @return kohi2HonninFutanGetsugaku
     */
    public Decimal getKohi2HonninFutanGetsugaku() {
        return kohi2HonninFutanGetsugaku;
    }

    /**
     * setKohi2HonninFutanGetsugaku
     * @param kohi2HonninFutanGetsugaku kohi2HonninFutanGetsugaku
     */
    public void setKohi2HonninFutanGetsugaku(Decimal kohi2HonninFutanGetsugaku) {
        this.kohi2HonninFutanGetsugaku = kohi2HonninFutanGetsugaku;
    }

    /**
     * getKohi3FutangakuTotal
     * @return kohi3FutangakuTotal
     */
    public Decimal getKohi3FutangakuTotal() {
        return kohi3FutangakuTotal;
    }

    /**
     * setKohi3FutangakuTotal
     * @param kohi3FutangakuTotal kohi3FutangakuTotal
     */
    public void setKohi3FutangakuTotal(Decimal kohi3FutangakuTotal) {
        this.kohi3FutangakuTotal = kohi3FutangakuTotal;
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
     * getKohi3HonninFutanGetsugaku
     * @return kohi3HonninFutanGetsugaku
     */
    public Decimal getKohi3HonninFutanGetsugaku() {
        return kohi3HonninFutanGetsugaku;
    }

    /**
     * setKohi3HonninFutanGetsugaku
     * @param kohi3HonninFutanGetsugaku kohi3HonninFutanGetsugaku
     */
    public void setKohi3HonninFutanGetsugaku(Decimal kohi3HonninFutanGetsugaku) {
        this.kohi3HonninFutanGetsugaku = kohi3HonninFutanGetsugaku;
    }

    /**
     * getAtoHiyoTanka
     * @return atoHiyoTanka
     */
    public Decimal getAtoHiyoTanka() {
        return atoHiyoTanka;
    }

    /**
     * setAtoHiyoTanka
     * @param atoHiyoTanka atoHiyoTanka
     */
    public void setAtoHiyoTanka(Decimal atoHiyoTanka) {
        this.atoHiyoTanka = atoHiyoTanka;
    }

    /**
     * getAtoNissu
     * @return atoNissu
     */
    public Integer getAtoNissu() {
        return atoNissu;
    }

    /**
     * setAtoNissu
     * @param atoNissu atoNissu
     */
    public void setAtoNissu(Integer atoNissu) {
        this.atoNissu = atoNissu;
    }

    /**
     * getAtoKohi1Nissu
     * @return atoKohi1Nissu
     */
    public Integer getAtoKohi1Nissu() {
        return atoKohi1Nissu;
    }

    /**
     * setAtoKohi1Nissu
     * @param atoKohi1Nissu atoKohi1Nissu
     */
    public void setAtoKohi1Nissu(Integer atoKohi1Nissu) {
        this.atoKohi1Nissu = atoKohi1Nissu;
    }

    /**
     * getAtoKohi2Nissu
     * @return atoKohi2Nissu
     */
    public Integer getAtoKohi2Nissu() {
        return atoKohi2Nissu;
    }

    /**
     * setAtoKohi2Nissu
     * @param atoKohi2Nissu atoKohi2Nissu
     */
    public void setAtoKohi2Nissu(Integer atoKohi2Nissu) {
        this.atoKohi2Nissu = atoKohi2Nissu;
    }

    /**
     * getAtoKohi3Nissu
     * @return atoKohi3Nissu
     */
    public Integer getAtoKohi3Nissu() {
        return atoKohi3Nissu;
    }

    /**
     * setAtoKohi3Nissu
     * @param atoKohi3Nissu atoKohi3Nissu
     */
    public void setAtoKohi3Nissu(Integer atoKohi3Nissu) {
        this.atoKohi3Nissu = atoKohi3Nissu;
    }

    /**
     * getAtoHiyogaku
     * @return atoHiyogaku
     */
    public Decimal getAtoHiyogaku() {
        return atoHiyogaku;
    }

    /**
     * setAtoHiyogaku
     * @param atoHiyogaku atoHiyogaku
     */
    public void setAtoHiyogaku(Decimal atoHiyogaku) {
        this.atoHiyogaku = atoHiyogaku;
    }

    /**
     * getAtoHokenbunSeikyugaku
     * @return atoHokenbunSeikyugaku
     */
    public Decimal getAtoHokenbunSeikyugaku() {
        return atoHokenbunSeikyugaku;
    }

    /**
     * setAtoHokenbunSeikyugaku
     * @param atoHokenbunSeikyugaku atoHokenbunSeikyugaku
     */
    public void setAtoHokenbunSeikyugaku(Decimal atoHokenbunSeikyugaku) {
        this.atoHokenbunSeikyugaku = atoHokenbunSeikyugaku;
    }

    /**
     * getAtoKohi1Futangaku
     * @return atoKohi1Futangaku
     */
    public Decimal getAtoKohi1Futangaku() {
        return atoKohi1Futangaku;
    }

    /**
     * setAtoKohi1Futangaku
     * @param atoKohi1Futangaku atoKohi1Futangaku
     */
    public void setAtoKohi1Futangaku(Decimal atoKohi1Futangaku) {
        this.atoKohi1Futangaku = atoKohi1Futangaku;
    }

    /**
     * getAtoKohi2Futangaku
     * @return atoKohi2Futangaku
     */
    public Decimal getAtoKohi2Futangaku() {
        return atoKohi2Futangaku;
    }

    /**
     * setAtoKohi2Futangaku
     * @param atoKohi2Futangaku atoKohi2Futangaku
     */
    public void setAtoKohi2Futangaku(Decimal atoKohi2Futangaku) {
        this.atoKohi2Futangaku = atoKohi2Futangaku;
    }

    /**
     * getAtoKohi3Futangaku
     * @return atoKohi3Futangaku
     */
    public Decimal getAtoKohi3Futangaku() {
        return atoKohi3Futangaku;
    }

    /**
     * setAtoKohi3Futangaku
     * @param atoKohi3Futangaku atoKohi3Futangaku
     */
    public void setAtoKohi3Futangaku(Decimal atoKohi3Futangaku) {
        this.atoKohi3Futangaku = atoKohi3Futangaku;
    }

    /**
     * getAtoRiyoshaFutangaku
     * @return atoRiyoshaFutangaku
     */
    public Decimal getAtoRiyoshaFutangaku() {
        return atoRiyoshaFutangaku;
    }

    /**
     * setAtoRiyoshaFutangaku
     * @param atoRiyoshaFutangaku atoRiyoshaFutangaku
     */
    public void setAtoRiyoshaFutangaku(Decimal atoRiyoshaFutangaku) {
        this.atoRiyoshaFutangaku = atoRiyoshaFutangaku;
    }

    /**
     * getAtoHiyogakuTotal
     * @return atoHiyogakuTotal
     */
    public Decimal getAtoHiyogakuTotal() {
        return atoHiyogakuTotal;
    }

    /**
     * setAtoHiyogakuTotal
     * @param atoHiyogakuTotal atoHiyogakuTotal
     */
    public void setAtoHiyogakuTotal(Decimal atoHiyogakuTotal) {
        this.atoHiyogakuTotal = atoHiyogakuTotal;
    }

    /**
     * getAtoHokenbunSeikyugakuTotal
     * @return atoHokenbunSeikyugakuTotal
     */
    public Decimal getAtoHokenbunSeikyugakuTotal() {
        return atoHokenbunSeikyugakuTotal;
    }

    /**
     * setAtoHokenbunSeikyugakuTotal
     * @param atoHokenbunSeikyugakuTotal atoHokenbunSeikyugakuTotal
     */
    public void setAtoHokenbunSeikyugakuTotal(Decimal atoHokenbunSeikyugakuTotal) {
        this.atoHokenbunSeikyugakuTotal = atoHokenbunSeikyugakuTotal;
    }

    /**
     * getAtoRiyoshaFutangakuTotal
     * @return atoRiyoshaFutangakuTotal
     */
    public Decimal getAtoRiyoshaFutangakuTotal() {
        return atoRiyoshaFutangakuTotal;
    }

    /**
     * setAtoRiyoshaFutangakuTotal
     * @param atoRiyoshaFutangakuTotal atoRiyoshaFutangakuTotal
     */
    public void setAtoRiyoshaFutangakuTotal(Decimal atoRiyoshaFutangakuTotal) {
        this.atoRiyoshaFutangakuTotal = atoRiyoshaFutangakuTotal;
    }

    /**
     * getAtoKohi1FutangakuTotal
     * @return atoKohi1FutangakuTotal
     */
    public Decimal getAtoKohi1FutangakuTotal() {
        return atoKohi1FutangakuTotal;
    }

    /**
     * setAtoKohi1FutangakuTotal
     * @param atoKohi1FutangakuTotal atoKohi1FutangakuTotal
     */
    public void setAtoKohi1FutangakuTotal(Decimal atoKohi1FutangakuTotal) {
        this.atoKohi1FutangakuTotal = atoKohi1FutangakuTotal;
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
     * getAtoKohi1HonninFutanGetsugaku
     * @return atoKohi1HonninFutanGetsugaku
     */
    public Decimal getAtoKohi1HonninFutanGetsugaku() {
        return atoKohi1HonninFutanGetsugaku;
    }

    /**
     * setAtoKohi1HonninFutanGetsugaku
     * @param atoKohi1HonninFutanGetsugaku atoKohi1HonninFutanGetsugaku
     */
    public void setAtoKohi1HonninFutanGetsugaku(Decimal atoKohi1HonninFutanGetsugaku) {
        this.atoKohi1HonninFutanGetsugaku = atoKohi1HonninFutanGetsugaku;
    }

    /**
     * getAtoKohi2FutangakuTotal
     * @return atoKohi2FutangakuTotal
     */
    public Decimal getAtoKohi2FutangakuTotal() {
        return atoKohi2FutangakuTotal;
    }

    /**
     * setAtoKohi2FutangakuTotal
     * @param atoKohi2FutangakuTotal atoKohi2FutangakuTotal
     */
    public void setAtoKohi2FutangakuTotal(Decimal atoKohi2FutangakuTotal) {
        this.atoKohi2FutangakuTotal = atoKohi2FutangakuTotal;
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
     * getAtoKohi2HonninFutanGetsugaku
     * @return atoKohi2HonninFutanGetsugaku
     */
    public Decimal getAtoKohi2HonninFutanGetsugaku() {
        return atoKohi2HonninFutanGetsugaku;
    }

    /**
     * setAtoKohi2HonninFutanGetsugaku
     * @param atoKohi2HonninFutanGetsugaku atoKohi2HonninFutanGetsugaku
     */
    public void setAtoKohi2HonninFutanGetsugaku(Decimal atoKohi2HonninFutanGetsugaku) {
        this.atoKohi2HonninFutanGetsugaku = atoKohi2HonninFutanGetsugaku;
    }

    /**
     * getAtoKohi3FutangakuTotal
     * @return atoKohi3FutangakuTotal
     */
    public Decimal getAtoKohi3FutangakuTotal() {
        return atoKohi3FutangakuTotal;
    }

    /**
     * setAtoKohi3FutangakuTotal
     * @param atoKohi3FutangakuTotal atoKohi3FutangakuTotal
     */
    public void setAtoKohi3FutangakuTotal(Decimal atoKohi3FutangakuTotal) {
        this.atoKohi3FutangakuTotal = atoKohi3FutangakuTotal;
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
     * getAtoKohi3HonninFutanGetsugaku
     * @return atoKohi3HonninFutanGetsugaku
     */
    public Decimal getAtoKohi3HonninFutanGetsugaku() {
        return atoKohi3HonninFutanGetsugaku;
    }

    /**
     * setAtoKohi3HonninFutanGetsugaku
     * @param atoKohi3HonninFutanGetsugaku atoKohi3HonninFutanGetsugaku
     */
    public void setAtoKohi3HonninFutanGetsugaku(Decimal atoKohi3HonninFutanGetsugaku) {
        this.atoKohi3HonninFutanGetsugaku = atoKohi3HonninFutanGetsugaku;
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
     * このエンティティの主キーが他の{@literal DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity other) {
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
        if (!Objects.equals(this.recodeJunjiNo, other.recodeJunjiNo)) {
            return false;
        }
        return true;
    }

// </editor-fold>




}
