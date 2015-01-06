package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoの項目定義クラスです
 *
 */
public class DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity extends DbTableEntityBase<DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

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
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    @PrimaryKey
    private RString recodeShubetsuCode;
    @PrimaryKey
    private HokenshaNo shokisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private JigyoshaNo jigyoshoNo;
    @PrimaryKey
    private RString toshiNo;
    @PrimaryKey
    private RString recodeJunjiNo;
    private ServiceShuruiCode serviceSyuruiCode;
    private ServiceKomokuCode serviceKomokuCode;
    private int hiyoTanka;
    private int futanGendogaku;
    private int nissu;
    private int kohi1Nissu;
    private int kohi2Nissu;
    private int kohi3Nissu;
    private int hiyogaku;
    private int hokenbunSeikyugaku;
    private int kohi1Futangaku;
    private int kohi2Futangaku;
    private int kohi3Futangaku;
    private int riyoshaFutangaku;
    private int hiyogakuTotal;
    private int hokenbunSeikyugakuTotal;
    private int riyoshaFutangakuTotal;
    private int kohi1FutangakuTotal;
    private int kohi1Seikyugaku;
    private int kohi1HonninFutanGetsugaku;
    private int kohi2FutangakuTotal;
    private int kohi2Seikyugaku;
    private int kohi2HonninFutanGetsugaku;
    private int kohi3FutangakuTotal;
    private int kohi3Seikyugaku;
    private int kohi3HonninFutanGetsugaku;
    private int atoHiyoTanka;
    private int atoNissu;
    private int atoKohi1Nissu;
    private int atoKohi2Nissu;
    private int atoKohi3Nissu;
    private int atoHiyogaku;
    private int atoHokenbunSeikyugaku;
    private int atoKohi1Futangaku;
    private int atoKohi2Futangaku;
    private int atoKohi3Futangaku;
    private int atoRiyoshaFutangaku;
    private int atoHiyogakuTotal;
    private int atoHokenbunSeikyugakuTotal;
    private int atoRiyoshaFutangakuTotal;
    private int atoKohi1FutangakuTotal;
    private int atoKohi1Seikyugaku;
    private int atoKohi1HonninFutanGetsugaku;
    private int atoKohi2FutangakuTotal;
    private int atoKohi2Seikyugaku;
    private int atoKohi2HonninFutanGetsugaku;
    private int atoKohi3FutangakuTotal;
    private int atoKohi3Seikyugaku;
    private int atoKohi3HonninFutanGetsugaku;
    private int saishinsaKaisu;
    private int kagoKaisu;
    private FlexibleYearMonth shinsaYM;
    private RString seiriNo;
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
     * getKokanJohoShikibetsuNo
     *
     * @return kokanJohoShikibetsuNo
     */
    public KokanShikibetsuNo getKokanJohoShikibetsuNo() {
        return kokanJohoShikibetsuNo;
    }

    /**
     * setKokanJohoShikibetsuNo
     *
     * @param kokanJohoShikibetsuNo kokanJohoShikibetsuNo
     */
    public void setKokanJohoShikibetsuNo(KokanShikibetsuNo kokanJohoShikibetsuNo) {
        this.kokanJohoShikibetsuNo = kokanJohoShikibetsuNo;
    }

    /**
     * getInputShikibetsuNo
     *
     * @return inputShikibetsuNo
     */
    public NyuryokuShikibetsuNo getInputShikibetsuNo() {
        return inputShikibetsuNo;
    }

    /**
     * setInputShikibetsuNo
     *
     * @param inputShikibetsuNo inputShikibetsuNo
     */
    public void setInputShikibetsuNo(NyuryokuShikibetsuNo inputShikibetsuNo) {
        this.inputShikibetsuNo = inputShikibetsuNo;
    }

    /**
     * getRecodeShubetsuCode
     *
     * @return recodeShubetsuCode
     */
    public RString getRecodeShubetsuCode() {
        return recodeShubetsuCode;
    }

    /**
     * setRecodeShubetsuCode
     *
     * @param recodeShubetsuCode recodeShubetsuCode
     */
    public void setRecodeShubetsuCode(RString recodeShubetsuCode) {
        this.recodeShubetsuCode = recodeShubetsuCode;
    }

    /**
     * getShokisaiHokenshaNo
     *
     * @return shokisaiHokenshaNo
     */
    public HokenshaNo getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    /**
     * setShokisaiHokenshaNo
     *
     * @param shokisaiHokenshaNo shokisaiHokenshaNo
     */
    public void setShokisaiHokenshaNo(HokenshaNo shokisaiHokenshaNo) {
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
    }

    /**
     * getHiHokenshaNo
     *
     * @return hiHokenshaNo
     */
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * setHiHokenshaNo
     *
     * @param hiHokenshaNo hiHokenshaNo
     */
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
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
     * getJigyoshoNo
     *
     * @return jigyoshoNo
     */
    public JigyoshaNo getJigyoshoNo() {
        return jigyoshoNo;
    }

    /**
     * setJigyoshoNo
     *
     * @param jigyoshoNo jigyoshoNo
     */
    public void setJigyoshoNo(JigyoshaNo jigyoshoNo) {
        this.jigyoshoNo = jigyoshoNo;
    }

    /**
     * getToshiNo
     *
     * @return toshiNo
     */
    public RString getToshiNo() {
        return toshiNo;
    }

    /**
     * setToshiNo
     *
     * @param toshiNo toshiNo
     */
    public void setToshiNo(RString toshiNo) {
        this.toshiNo = toshiNo;
    }

    /**
     * getRecodeJunjiNo
     *
     * @return recodeJunjiNo
     */
    public RString getRecodeJunjiNo() {
        return recodeJunjiNo;
    }

    /**
     * setRecodeJunjiNo
     *
     * @param recodeJunjiNo recodeJunjiNo
     */
    public void setRecodeJunjiNo(RString recodeJunjiNo) {
        this.recodeJunjiNo = recodeJunjiNo;
    }

    /**
     * getServiceSyuruiCode
     *
     * @return serviceSyuruiCode
     */
    public ServiceShuruiCode getServiceSyuruiCode() {
        return serviceSyuruiCode;
    }

    /**
     * setServiceSyuruiCode
     *
     * @param serviceSyuruiCode serviceSyuruiCode
     */
    public void setServiceSyuruiCode(ServiceShuruiCode serviceSyuruiCode) {
        this.serviceSyuruiCode = serviceSyuruiCode;
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
     * getHiyoTanka
     *
     * @return hiyoTanka
     */
    public int getHiyoTanka() {
        return hiyoTanka;
    }

    /**
     * setHiyoTanka
     *
     * @param hiyoTanka hiyoTanka
     */
    public void setHiyoTanka(int hiyoTanka) {
        this.hiyoTanka = hiyoTanka;
    }

    /**
     * getFutanGendogaku
     *
     * @return futanGendogaku
     */
    public int getFutanGendogaku() {
        return futanGendogaku;
    }

    /**
     * setFutanGendogaku
     *
     * @param futanGendogaku futanGendogaku
     */
    public void setFutanGendogaku(int futanGendogaku) {
        this.futanGendogaku = futanGendogaku;
    }

    /**
     * getNissu
     *
     * @return nissu
     */
    public int getNissu() {
        return nissu;
    }

    /**
     * setNissu
     *
     * @param nissu nissu
     */
    public void setNissu(int nissu) {
        this.nissu = nissu;
    }

    /**
     * getKohi1Nissu
     *
     * @return kohi1Nissu
     */
    public int getKohi1Nissu() {
        return kohi1Nissu;
    }

    /**
     * setKohi1Nissu
     *
     * @param kohi1Nissu kohi1Nissu
     */
    public void setKohi1Nissu(int kohi1Nissu) {
        this.kohi1Nissu = kohi1Nissu;
    }

    /**
     * getKohi2Nissu
     *
     * @return kohi2Nissu
     */
    public int getKohi2Nissu() {
        return kohi2Nissu;
    }

    /**
     * setKohi2Nissu
     *
     * @param kohi2Nissu kohi2Nissu
     */
    public void setKohi2Nissu(int kohi2Nissu) {
        this.kohi2Nissu = kohi2Nissu;
    }

    /**
     * getKohi3Nissu
     *
     * @return kohi3Nissu
     */
    public int getKohi3Nissu() {
        return kohi3Nissu;
    }

    /**
     * setKohi3Nissu
     *
     * @param kohi3Nissu kohi3Nissu
     */
    public void setKohi3Nissu(int kohi3Nissu) {
        this.kohi3Nissu = kohi3Nissu;
    }

    /**
     * getHiyogaku
     *
     * @return hiyogaku
     */
    public int getHiyogaku() {
        return hiyogaku;
    }

    /**
     * setHiyogaku
     *
     * @param hiyogaku hiyogaku
     */
    public void setHiyogaku(int hiyogaku) {
        this.hiyogaku = hiyogaku;
    }

    /**
     * getHokenbunSeikyugaku
     *
     * @return hokenbunSeikyugaku
     */
    public int getHokenbunSeikyugaku() {
        return hokenbunSeikyugaku;
    }

    /**
     * setHokenbunSeikyugaku
     *
     * @param hokenbunSeikyugaku hokenbunSeikyugaku
     */
    public void setHokenbunSeikyugaku(int hokenbunSeikyugaku) {
        this.hokenbunSeikyugaku = hokenbunSeikyugaku;
    }

    /**
     * getKohi1Futangaku
     *
     * @return kohi1Futangaku
     */
    public int getKohi1Futangaku() {
        return kohi1Futangaku;
    }

    /**
     * setKohi1Futangaku
     *
     * @param kohi1Futangaku kohi1Futangaku
     */
    public void setKohi1Futangaku(int kohi1Futangaku) {
        this.kohi1Futangaku = kohi1Futangaku;
    }

    /**
     * getKohi2Futangaku
     *
     * @return kohi2Futangaku
     */
    public int getKohi2Futangaku() {
        return kohi2Futangaku;
    }

    /**
     * setKohi2Futangaku
     *
     * @param kohi2Futangaku kohi2Futangaku
     */
    public void setKohi2Futangaku(int kohi2Futangaku) {
        this.kohi2Futangaku = kohi2Futangaku;
    }

    /**
     * getKohi3Futangaku
     *
     * @return kohi3Futangaku
     */
    public int getKohi3Futangaku() {
        return kohi3Futangaku;
    }

    /**
     * setKohi3Futangaku
     *
     * @param kohi3Futangaku kohi3Futangaku
     */
    public void setKohi3Futangaku(int kohi3Futangaku) {
        this.kohi3Futangaku = kohi3Futangaku;
    }

    /**
     * getRiyoshaFutangaku
     *
     * @return riyoshaFutangaku
     */
    public int getRiyoshaFutangaku() {
        return riyoshaFutangaku;
    }

    /**
     * setRiyoshaFutangaku
     *
     * @param riyoshaFutangaku riyoshaFutangaku
     */
    public void setRiyoshaFutangaku(int riyoshaFutangaku) {
        this.riyoshaFutangaku = riyoshaFutangaku;
    }

    /**
     * getHiyogakuTotal
     *
     * @return hiyogakuTotal
     */
    public int getHiyogakuTotal() {
        return hiyogakuTotal;
    }

    /**
     * setHiyogakuTotal
     *
     * @param hiyogakuTotal hiyogakuTotal
     */
    public void setHiyogakuTotal(int hiyogakuTotal) {
        this.hiyogakuTotal = hiyogakuTotal;
    }

    /**
     * getHokenbunSeikyugakuTotal
     *
     * @return hokenbunSeikyugakuTotal
     */
    public int getHokenbunSeikyugakuTotal() {
        return hokenbunSeikyugakuTotal;
    }

    /**
     * setHokenbunSeikyugakuTotal
     *
     * @param hokenbunSeikyugakuTotal hokenbunSeikyugakuTotal
     */
    public void setHokenbunSeikyugakuTotal(int hokenbunSeikyugakuTotal) {
        this.hokenbunSeikyugakuTotal = hokenbunSeikyugakuTotal;
    }

    /**
     * getRiyoshaFutangakuTotal
     *
     * @return riyoshaFutangakuTotal
     */
    public int getRiyoshaFutangakuTotal() {
        return riyoshaFutangakuTotal;
    }

    /**
     * setRiyoshaFutangakuTotal
     *
     * @param riyoshaFutangakuTotal riyoshaFutangakuTotal
     */
    public void setRiyoshaFutangakuTotal(int riyoshaFutangakuTotal) {
        this.riyoshaFutangakuTotal = riyoshaFutangakuTotal;
    }

    /**
     * getKohi1FutangakuTotal
     *
     * @return kohi1FutangakuTotal
     */
    public int getKohi1FutangakuTotal() {
        return kohi1FutangakuTotal;
    }

    /**
     * setKohi1FutangakuTotal
     *
     * @param kohi1FutangakuTotal kohi1FutangakuTotal
     */
    public void setKohi1FutangakuTotal(int kohi1FutangakuTotal) {
        this.kohi1FutangakuTotal = kohi1FutangakuTotal;
    }

    /**
     * getKohi1Seikyugaku
     *
     * @return kohi1Seikyugaku
     */
    public int getKohi1Seikyugaku() {
        return kohi1Seikyugaku;
    }

    /**
     * setKohi1Seikyugaku
     *
     * @param kohi1Seikyugaku kohi1Seikyugaku
     */
    public void setKohi1Seikyugaku(int kohi1Seikyugaku) {
        this.kohi1Seikyugaku = kohi1Seikyugaku;
    }

    /**
     * getKohi1HonninFutanGetsugaku
     *
     * @return kohi1HonninFutanGetsugaku
     */
    public int getKohi1HonninFutanGetsugaku() {
        return kohi1HonninFutanGetsugaku;
    }

    /**
     * setKohi1HonninFutanGetsugaku
     *
     * @param kohi1HonninFutanGetsugaku kohi1HonninFutanGetsugaku
     */
    public void setKohi1HonninFutanGetsugaku(int kohi1HonninFutanGetsugaku) {
        this.kohi1HonninFutanGetsugaku = kohi1HonninFutanGetsugaku;
    }

    /**
     * getKohi2FutangakuTotal
     *
     * @return kohi2FutangakuTotal
     */
    public int getKohi2FutangakuTotal() {
        return kohi2FutangakuTotal;
    }

    /**
     * setKohi2FutangakuTotal
     *
     * @param kohi2FutangakuTotal kohi2FutangakuTotal
     */
    public void setKohi2FutangakuTotal(int kohi2FutangakuTotal) {
        this.kohi2FutangakuTotal = kohi2FutangakuTotal;
    }

    /**
     * getKohi2Seikyugaku
     *
     * @return kohi2Seikyugaku
     */
    public int getKohi2Seikyugaku() {
        return kohi2Seikyugaku;
    }

    /**
     * setKohi2Seikyugaku
     *
     * @param kohi2Seikyugaku kohi2Seikyugaku
     */
    public void setKohi2Seikyugaku(int kohi2Seikyugaku) {
        this.kohi2Seikyugaku = kohi2Seikyugaku;
    }

    /**
     * getKohi2HonninFutanGetsugaku
     *
     * @return kohi2HonninFutanGetsugaku
     */
    public int getKohi2HonninFutanGetsugaku() {
        return kohi2HonninFutanGetsugaku;
    }

    /**
     * setKohi2HonninFutanGetsugaku
     *
     * @param kohi2HonninFutanGetsugaku kohi2HonninFutanGetsugaku
     */
    public void setKohi2HonninFutanGetsugaku(int kohi2HonninFutanGetsugaku) {
        this.kohi2HonninFutanGetsugaku = kohi2HonninFutanGetsugaku;
    }

    /**
     * getKohi3FutangakuTotal
     *
     * @return kohi3FutangakuTotal
     */
    public int getKohi3FutangakuTotal() {
        return kohi3FutangakuTotal;
    }

    /**
     * setKohi3FutangakuTotal
     *
     * @param kohi3FutangakuTotal kohi3FutangakuTotal
     */
    public void setKohi3FutangakuTotal(int kohi3FutangakuTotal) {
        this.kohi3FutangakuTotal = kohi3FutangakuTotal;
    }

    /**
     * getKohi3Seikyugaku
     *
     * @return kohi3Seikyugaku
     */
    public int getKohi3Seikyugaku() {
        return kohi3Seikyugaku;
    }

    /**
     * setKohi3Seikyugaku
     *
     * @param kohi3Seikyugaku kohi3Seikyugaku
     */
    public void setKohi3Seikyugaku(int kohi3Seikyugaku) {
        this.kohi3Seikyugaku = kohi3Seikyugaku;
    }

    /**
     * getKohi3HonninFutanGetsugaku
     *
     * @return kohi3HonninFutanGetsugaku
     */
    public int getKohi3HonninFutanGetsugaku() {
        return kohi3HonninFutanGetsugaku;
    }

    /**
     * setKohi3HonninFutanGetsugaku
     *
     * @param kohi3HonninFutanGetsugaku kohi3HonninFutanGetsugaku
     */
    public void setKohi3HonninFutanGetsugaku(int kohi3HonninFutanGetsugaku) {
        this.kohi3HonninFutanGetsugaku = kohi3HonninFutanGetsugaku;
    }

    /**
     * getAtoHiyoTanka
     *
     * @return atoHiyoTanka
     */
    public int getAtoHiyoTanka() {
        return atoHiyoTanka;
    }

    /**
     * setAtoHiyoTanka
     *
     * @param atoHiyoTanka atoHiyoTanka
     */
    public void setAtoHiyoTanka(int atoHiyoTanka) {
        this.atoHiyoTanka = atoHiyoTanka;
    }

    /**
     * getAtoNissu
     *
     * @return atoNissu
     */
    public int getAtoNissu() {
        return atoNissu;
    }

    /**
     * setAtoNissu
     *
     * @param atoNissu atoNissu
     */
    public void setAtoNissu(int atoNissu) {
        this.atoNissu = atoNissu;
    }

    /**
     * getAtoKohi1Nissu
     *
     * @return atoKohi1Nissu
     */
    public int getAtoKohi1Nissu() {
        return atoKohi1Nissu;
    }

    /**
     * setAtoKohi1Nissu
     *
     * @param atoKohi1Nissu atoKohi1Nissu
     */
    public void setAtoKohi1Nissu(int atoKohi1Nissu) {
        this.atoKohi1Nissu = atoKohi1Nissu;
    }

    /**
     * getAtoKohi2Nissu
     *
     * @return atoKohi2Nissu
     */
    public int getAtoKohi2Nissu() {
        return atoKohi2Nissu;
    }

    /**
     * setAtoKohi2Nissu
     *
     * @param atoKohi2Nissu atoKohi2Nissu
     */
    public void setAtoKohi2Nissu(int atoKohi2Nissu) {
        this.atoKohi2Nissu = atoKohi2Nissu;
    }

    /**
     * getAtoKohi3Nissu
     *
     * @return atoKohi3Nissu
     */
    public int getAtoKohi3Nissu() {
        return atoKohi3Nissu;
    }

    /**
     * setAtoKohi3Nissu
     *
     * @param atoKohi3Nissu atoKohi3Nissu
     */
    public void setAtoKohi3Nissu(int atoKohi3Nissu) {
        this.atoKohi3Nissu = atoKohi3Nissu;
    }

    /**
     * getAtoHiyogaku
     *
     * @return atoHiyogaku
     */
    public int getAtoHiyogaku() {
        return atoHiyogaku;
    }

    /**
     * setAtoHiyogaku
     *
     * @param atoHiyogaku atoHiyogaku
     */
    public void setAtoHiyogaku(int atoHiyogaku) {
        this.atoHiyogaku = atoHiyogaku;
    }

    /**
     * getAtoHokenbunSeikyugaku
     *
     * @return atoHokenbunSeikyugaku
     */
    public int getAtoHokenbunSeikyugaku() {
        return atoHokenbunSeikyugaku;
    }

    /**
     * setAtoHokenbunSeikyugaku
     *
     * @param atoHokenbunSeikyugaku atoHokenbunSeikyugaku
     */
    public void setAtoHokenbunSeikyugaku(int atoHokenbunSeikyugaku) {
        this.atoHokenbunSeikyugaku = atoHokenbunSeikyugaku;
    }

    /**
     * getAtoKohi1Futangaku
     *
     * @return atoKohi1Futangaku
     */
    public int getAtoKohi1Futangaku() {
        return atoKohi1Futangaku;
    }

    /**
     * setAtoKohi1Futangaku
     *
     * @param atoKohi1Futangaku atoKohi1Futangaku
     */
    public void setAtoKohi1Futangaku(int atoKohi1Futangaku) {
        this.atoKohi1Futangaku = atoKohi1Futangaku;
    }

    /**
     * getAtoKohi2Futangaku
     *
     * @return atoKohi2Futangaku
     */
    public int getAtoKohi2Futangaku() {
        return atoKohi2Futangaku;
    }

    /**
     * setAtoKohi2Futangaku
     *
     * @param atoKohi2Futangaku atoKohi2Futangaku
     */
    public void setAtoKohi2Futangaku(int atoKohi2Futangaku) {
        this.atoKohi2Futangaku = atoKohi2Futangaku;
    }

    /**
     * getAtoKohi3Futangaku
     *
     * @return atoKohi3Futangaku
     */
    public int getAtoKohi3Futangaku() {
        return atoKohi3Futangaku;
    }

    /**
     * setAtoKohi3Futangaku
     *
     * @param atoKohi3Futangaku atoKohi3Futangaku
     */
    public void setAtoKohi3Futangaku(int atoKohi3Futangaku) {
        this.atoKohi3Futangaku = atoKohi3Futangaku;
    }

    /**
     * getAtoRiyoshaFutangaku
     *
     * @return atoRiyoshaFutangaku
     */
    public int getAtoRiyoshaFutangaku() {
        return atoRiyoshaFutangaku;
    }

    /**
     * setAtoRiyoshaFutangaku
     *
     * @param atoRiyoshaFutangaku atoRiyoshaFutangaku
     */
    public void setAtoRiyoshaFutangaku(int atoRiyoshaFutangaku) {
        this.atoRiyoshaFutangaku = atoRiyoshaFutangaku;
    }

    /**
     * getAtoHiyogakuTotal
     *
     * @return atoHiyogakuTotal
     */
    public int getAtoHiyogakuTotal() {
        return atoHiyogakuTotal;
    }

    /**
     * setAtoHiyogakuTotal
     *
     * @param atoHiyogakuTotal atoHiyogakuTotal
     */
    public void setAtoHiyogakuTotal(int atoHiyogakuTotal) {
        this.atoHiyogakuTotal = atoHiyogakuTotal;
    }

    /**
     * getAtoHokenbunSeikyugakuTotal
     *
     * @return atoHokenbunSeikyugakuTotal
     */
    public int getAtoHokenbunSeikyugakuTotal() {
        return atoHokenbunSeikyugakuTotal;
    }

    /**
     * setAtoHokenbunSeikyugakuTotal
     *
     * @param atoHokenbunSeikyugakuTotal atoHokenbunSeikyugakuTotal
     */
    public void setAtoHokenbunSeikyugakuTotal(int atoHokenbunSeikyugakuTotal) {
        this.atoHokenbunSeikyugakuTotal = atoHokenbunSeikyugakuTotal;
    }

    /**
     * getAtoRiyoshaFutangakuTotal
     *
     * @return atoRiyoshaFutangakuTotal
     */
    public int getAtoRiyoshaFutangakuTotal() {
        return atoRiyoshaFutangakuTotal;
    }

    /**
     * setAtoRiyoshaFutangakuTotal
     *
     * @param atoRiyoshaFutangakuTotal atoRiyoshaFutangakuTotal
     */
    public void setAtoRiyoshaFutangakuTotal(int atoRiyoshaFutangakuTotal) {
        this.atoRiyoshaFutangakuTotal = atoRiyoshaFutangakuTotal;
    }

    /**
     * getAtoKohi1FutangakuTotal
     *
     * @return atoKohi1FutangakuTotal
     */
    public int getAtoKohi1FutangakuTotal() {
        return atoKohi1FutangakuTotal;
    }

    /**
     * setAtoKohi1FutangakuTotal
     *
     * @param atoKohi1FutangakuTotal atoKohi1FutangakuTotal
     */
    public void setAtoKohi1FutangakuTotal(int atoKohi1FutangakuTotal) {
        this.atoKohi1FutangakuTotal = atoKohi1FutangakuTotal;
    }

    /**
     * getAtoKohi1Seikyugaku
     *
     * @return atoKohi1Seikyugaku
     */
    public int getAtoKohi1Seikyugaku() {
        return atoKohi1Seikyugaku;
    }

    /**
     * setAtoKohi1Seikyugaku
     *
     * @param atoKohi1Seikyugaku atoKohi1Seikyugaku
     */
    public void setAtoKohi1Seikyugaku(int atoKohi1Seikyugaku) {
        this.atoKohi1Seikyugaku = atoKohi1Seikyugaku;
    }

    /**
     * getAtoKohi1HonninFutanGetsugaku
     *
     * @return atoKohi1HonninFutanGetsugaku
     */
    public int getAtoKohi1HonninFutanGetsugaku() {
        return atoKohi1HonninFutanGetsugaku;
    }

    /**
     * setAtoKohi1HonninFutanGetsugaku
     *
     * @param atoKohi1HonninFutanGetsugaku atoKohi1HonninFutanGetsugaku
     */
    public void setAtoKohi1HonninFutanGetsugaku(int atoKohi1HonninFutanGetsugaku) {
        this.atoKohi1HonninFutanGetsugaku = atoKohi1HonninFutanGetsugaku;
    }

    /**
     * getAtoKohi2FutangakuTotal
     *
     * @return atoKohi2FutangakuTotal
     */
    public int getAtoKohi2FutangakuTotal() {
        return atoKohi2FutangakuTotal;
    }

    /**
     * setAtoKohi2FutangakuTotal
     *
     * @param atoKohi2FutangakuTotal atoKohi2FutangakuTotal
     */
    public void setAtoKohi2FutangakuTotal(int atoKohi2FutangakuTotal) {
        this.atoKohi2FutangakuTotal = atoKohi2FutangakuTotal;
    }

    /**
     * getAtoKohi2Seikyugaku
     *
     * @return atoKohi2Seikyugaku
     */
    public int getAtoKohi2Seikyugaku() {
        return atoKohi2Seikyugaku;
    }

    /**
     * setAtoKohi2Seikyugaku
     *
     * @param atoKohi2Seikyugaku atoKohi2Seikyugaku
     */
    public void setAtoKohi2Seikyugaku(int atoKohi2Seikyugaku) {
        this.atoKohi2Seikyugaku = atoKohi2Seikyugaku;
    }

    /**
     * getAtoKohi2HonninFutanGetsugaku
     *
     * @return atoKohi2HonninFutanGetsugaku
     */
    public int getAtoKohi2HonninFutanGetsugaku() {
        return atoKohi2HonninFutanGetsugaku;
    }

    /**
     * setAtoKohi2HonninFutanGetsugaku
     *
     * @param atoKohi2HonninFutanGetsugaku atoKohi2HonninFutanGetsugaku
     */
    public void setAtoKohi2HonninFutanGetsugaku(int atoKohi2HonninFutanGetsugaku) {
        this.atoKohi2HonninFutanGetsugaku = atoKohi2HonninFutanGetsugaku;
    }

    /**
     * getAtoKohi3FutangakuTotal
     *
     * @return atoKohi3FutangakuTotal
     */
    public int getAtoKohi3FutangakuTotal() {
        return atoKohi3FutangakuTotal;
    }

    /**
     * setAtoKohi3FutangakuTotal
     *
     * @param atoKohi3FutangakuTotal atoKohi3FutangakuTotal
     */
    public void setAtoKohi3FutangakuTotal(int atoKohi3FutangakuTotal) {
        this.atoKohi3FutangakuTotal = atoKohi3FutangakuTotal;
    }

    /**
     * getAtoKohi3Seikyugaku
     *
     * @return atoKohi3Seikyugaku
     */
    public int getAtoKohi3Seikyugaku() {
        return atoKohi3Seikyugaku;
    }

    /**
     * setAtoKohi3Seikyugaku
     *
     * @param atoKohi3Seikyugaku atoKohi3Seikyugaku
     */
    public void setAtoKohi3Seikyugaku(int atoKohi3Seikyugaku) {
        this.atoKohi3Seikyugaku = atoKohi3Seikyugaku;
    }

    /**
     * getAtoKohi3HonninFutanGetsugaku
     *
     * @return atoKohi3HonninFutanGetsugaku
     */
    public int getAtoKohi3HonninFutanGetsugaku() {
        return atoKohi3HonninFutanGetsugaku;
    }

    /**
     * setAtoKohi3HonninFutanGetsugaku
     *
     * @param atoKohi3HonninFutanGetsugaku atoKohi3HonninFutanGetsugaku
     */
    public void setAtoKohi3HonninFutanGetsugaku(int atoKohi3HonninFutanGetsugaku) {
        this.atoKohi3HonninFutanGetsugaku = atoKohi3HonninFutanGetsugaku;
    }

    /**
     * getSaishinsaKaisu
     *
     * @return saishinsaKaisu
     */
    public int getSaishinsaKaisu() {
        return saishinsaKaisu;
    }

    /**
     * setSaishinsaKaisu
     *
     * @param saishinsaKaisu saishinsaKaisu
     */
    public void setSaishinsaKaisu(int saishinsaKaisu) {
        this.saishinsaKaisu = saishinsaKaisu;
    }

    /**
     * getKagoKaisu
     *
     * @return kagoKaisu
     */
    public int getKagoKaisu() {
        return kagoKaisu;
    }

    /**
     * setKagoKaisu
     *
     * @param kagoKaisu kagoKaisu
     */
    public void setKagoKaisu(int kagoKaisu) {
        this.kagoKaisu = kagoKaisu;
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
     * getSeiriNo
     *
     * @return seiriNo
     */
    public RString getSeiriNo() {
        return seiriNo;
    }

    /**
     * setSeiriNo
     *
     * @param seiriNo seiriNo
     */
    public void setSeiriNo(RString seiriNo) {
        this.seiriNo = seiriNo;
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
     * このエンティティの主キーが他の{@literal DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity entity) {
        this.kokanJohoShikibetsuNo = entity.kokanJohoShikibetsuNo;
        this.inputShikibetsuNo = entity.inputShikibetsuNo;
        this.recodeShubetsuCode = entity.recodeShubetsuCode;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.toshiNo = entity.toshiNo;
        this.recodeJunjiNo = entity.recodeJunjiNo;
        this.serviceSyuruiCode = entity.serviceSyuruiCode;
        this.serviceKomokuCode = entity.serviceKomokuCode;
        this.hiyoTanka = entity.hiyoTanka;
        this.futanGendogaku = entity.futanGendogaku;
        this.nissu = entity.nissu;
        this.kohi1Nissu = entity.kohi1Nissu;
        this.kohi2Nissu = entity.kohi2Nissu;
        this.kohi3Nissu = entity.kohi3Nissu;
        this.hiyogaku = entity.hiyogaku;
        this.hokenbunSeikyugaku = entity.hokenbunSeikyugaku;
        this.kohi1Futangaku = entity.kohi1Futangaku;
        this.kohi2Futangaku = entity.kohi2Futangaku;
        this.kohi3Futangaku = entity.kohi3Futangaku;
        this.riyoshaFutangaku = entity.riyoshaFutangaku;
        this.hiyogakuTotal = entity.hiyogakuTotal;
        this.hokenbunSeikyugakuTotal = entity.hokenbunSeikyugakuTotal;
        this.riyoshaFutangakuTotal = entity.riyoshaFutangakuTotal;
        this.kohi1FutangakuTotal = entity.kohi1FutangakuTotal;
        this.kohi1Seikyugaku = entity.kohi1Seikyugaku;
        this.kohi1HonninFutanGetsugaku = entity.kohi1HonninFutanGetsugaku;
        this.kohi2FutangakuTotal = entity.kohi2FutangakuTotal;
        this.kohi2Seikyugaku = entity.kohi2Seikyugaku;
        this.kohi2HonninFutanGetsugaku = entity.kohi2HonninFutanGetsugaku;
        this.kohi3FutangakuTotal = entity.kohi3FutangakuTotal;
        this.kohi3Seikyugaku = entity.kohi3Seikyugaku;
        this.kohi3HonninFutanGetsugaku = entity.kohi3HonninFutanGetsugaku;
        this.atoHiyoTanka = entity.atoHiyoTanka;
        this.atoNissu = entity.atoNissu;
        this.atoKohi1Nissu = entity.atoKohi1Nissu;
        this.atoKohi2Nissu = entity.atoKohi2Nissu;
        this.atoKohi3Nissu = entity.atoKohi3Nissu;
        this.atoHiyogaku = entity.atoHiyogaku;
        this.atoHokenbunSeikyugaku = entity.atoHokenbunSeikyugaku;
        this.atoKohi1Futangaku = entity.atoKohi1Futangaku;
        this.atoKohi2Futangaku = entity.atoKohi2Futangaku;
        this.atoKohi3Futangaku = entity.atoKohi3Futangaku;
        this.atoRiyoshaFutangaku = entity.atoRiyoshaFutangaku;
        this.atoHiyogakuTotal = entity.atoHiyogakuTotal;
        this.atoHokenbunSeikyugakuTotal = entity.atoHokenbunSeikyugakuTotal;
        this.atoRiyoshaFutangakuTotal = entity.atoRiyoshaFutangakuTotal;
        this.atoKohi1FutangakuTotal = entity.atoKohi1FutangakuTotal;
        this.atoKohi1Seikyugaku = entity.atoKohi1Seikyugaku;
        this.atoKohi1HonninFutanGetsugaku = entity.atoKohi1HonninFutanGetsugaku;
        this.atoKohi2FutangakuTotal = entity.atoKohi2FutangakuTotal;
        this.atoKohi2Seikyugaku = entity.atoKohi2Seikyugaku;
        this.atoKohi2HonninFutanGetsugaku = entity.atoKohi2HonninFutanGetsugaku;
        this.atoKohi3FutangakuTotal = entity.atoKohi3FutangakuTotal;
        this.atoKohi3Seikyugaku = entity.atoKohi3Seikyugaku;
        this.atoKohi3HonninFutanGetsugaku = entity.atoKohi3HonninFutanGetsugaku;
        this.saishinsaKaisu = entity.saishinsaKaisu;
        this.kagoKaisu = entity.kagoKaisu;
        this.shinsaYM = entity.shinsaYM;
        this.seiriNo = entity.seiriNo;
        this.torikomiYM = entity.torikomiYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kokanJohoShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, jigyoshoNo, toshiNo, recodeJunjiNo, serviceSyuruiCode, serviceKomokuCode, hiyoTanka, futanGendogaku, nissu, kohi1Nissu, kohi2Nissu, kohi3Nissu, hiyogaku, hokenbunSeikyugaku, kohi1Futangaku, kohi2Futangaku, kohi3Futangaku, riyoshaFutangaku, hiyogakuTotal, hokenbunSeikyugakuTotal, riyoshaFutangakuTotal, kohi1FutangakuTotal, kohi1Seikyugaku, kohi1HonninFutanGetsugaku, kohi2FutangakuTotal, kohi2Seikyugaku, kohi2HonninFutanGetsugaku, kohi3FutangakuTotal, kohi3Seikyugaku, kohi3HonninFutanGetsugaku, atoHiyoTanka, atoNissu, atoKohi1Nissu, atoKohi2Nissu, atoKohi3Nissu, atoHiyogaku, atoHokenbunSeikyugaku, atoKohi1Futangaku, atoKohi2Futangaku, atoKohi3Futangaku, atoRiyoshaFutangaku, atoHiyogakuTotal, atoHokenbunSeikyugakuTotal, atoRiyoshaFutangakuTotal, atoKohi1FutangakuTotal, atoKohi1Seikyugaku, atoKohi1HonninFutanGetsugaku, atoKohi2FutangakuTotal, atoKohi2Seikyugaku, atoKohi2HonninFutanGetsugaku, atoKohi3FutangakuTotal, atoKohi3Seikyugaku, atoKohi3HonninFutanGetsugaku, saishinsaKaisu, kagoKaisu, shinsaYM, seiriNo, torikomiYM);
    }

// </editor-fold>
}
