package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3033KyufujissekiShukeiの項目定義クラスです
 *
 */
public class DbT3033KyufujissekiShukeiEntity extends DbTableEntityBase<DbT3033KyufujissekiShukeiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

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
    private ServiceShuruiCode serviceSyuruiCode;
    private int serviceJitsunissu;
    private int planTanisu;
    private int gendogakuKanriTaishoTanisu;
    private int gendogakuKanritaishogaiTanisu;
    private int tankiNyushoPlanNissu;
    private int tankiNyushoJitsunissu;
    private int hokenTanisuTotal;
    private Decimal hokenTanisuTani;
    private RString hokenSeikyugaku;
    private int hokenRiyoshaFutangaku;
    private int kohi1TanisuTotal;
    private RString kohi1Seikyugaku;
    private int kohi1HonninFutangaku;
    private int kohi2TanisuTotal;
    private RString kohi2Seikyugaku;
    private int kohi2HonninFutangaku;
    private int kohi3TanisuTotal;
    private RString kohi3Seikyugaku;
    private int kohi3HonninFutangaku;
    private int hokenDekidakaTanisuTotal;
    private RString hokenDekidakaSeikyugaku;
    private int hokenDekidakaIryohiRiyoshaFutangaku;
    private int kohi1DekidakaTanisuTotal;
    private RString kohi1DekidakaSeikyugaku;
    private int kohi1DekidakaIryohiRiyoshaFutangaku;
    private int kohi2DekidakaTanisuTotal;
    private RString kohi2DekidakaSeikyugaku;
    private int kohi2DekidakaIryohiRiyoshaFutangaku;
    private int kohi3DekidakaTanisuTotal;
    private RString kohi3DekidakaSeikyugaku;
    private int kohi3DekidakaIryohiRiyoshaFutangaku;
    private int atoTankiNyushoJitsunissu;
    private int atoHokenTanisuTotal;
    private RString atoHokenSeikyugaku;
    private int atoKohi1TanisuTotal;
    private RString atoKohi1Seikyugaku;
    private int atoKohi2TanisuTotal;
    private RString atoKohi2Seikyugaku;
    private int atoKohi3TanisuTotal;
    private RString atoKohi3Seikyugaku;
    private int atoHokenDekidakaTanisuTotal;
    private RString atoHokenDekidakaSeikyugaku;
    private int atoKohi1DekidakaTanisuTotal;
    private RString atoKohi1DekidakaSeikyugaku;
    private int atoKohi2DekidakaTanisuTotal;
    private RString atoKohi2DekidakaSeikyugaku;
    private int atoKohi3DekidakaTanisuTotal;
    private RString atoKohi3DekidakaSeikyugaku;
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
     * getServiceJitsunissu
     *
     * @return serviceJitsunissu
     */
    public int getServiceJitsunissu() {
        return serviceJitsunissu;
    }

    /**
     * setServiceJitsunissu
     *
     * @param serviceJitsunissu serviceJitsunissu
     */
    public void setServiceJitsunissu(int serviceJitsunissu) {
        this.serviceJitsunissu = serviceJitsunissu;
    }

    /**
     * getPlanTanisu
     *
     * @return planTanisu
     */
    public int getPlanTanisu() {
        return planTanisu;
    }

    /**
     * setPlanTanisu
     *
     * @param planTanisu planTanisu
     */
    public void setPlanTanisu(int planTanisu) {
        this.planTanisu = planTanisu;
    }

    /**
     * getGendogakuKanriTaishoTanisu
     *
     * @return gendogakuKanriTaishoTanisu
     */
    public int getGendogakuKanriTaishoTanisu() {
        return gendogakuKanriTaishoTanisu;
    }

    /**
     * setGendogakuKanriTaishoTanisu
     *
     * @param gendogakuKanriTaishoTanisu gendogakuKanriTaishoTanisu
     */
    public void setGendogakuKanriTaishoTanisu(int gendogakuKanriTaishoTanisu) {
        this.gendogakuKanriTaishoTanisu = gendogakuKanriTaishoTanisu;
    }

    /**
     * getGendogakuKanritaishogaiTanisu
     *
     * @return gendogakuKanritaishogaiTanisu
     */
    public int getGendogakuKanritaishogaiTanisu() {
        return gendogakuKanritaishogaiTanisu;
    }

    /**
     * setGendogakuKanritaishogaiTanisu
     *
     * @param gendogakuKanritaishogaiTanisu gendogakuKanritaishogaiTanisu
     */
    public void setGendogakuKanritaishogaiTanisu(int gendogakuKanritaishogaiTanisu) {
        this.gendogakuKanritaishogaiTanisu = gendogakuKanritaishogaiTanisu;
    }

    /**
     * getTankiNyushoPlanNissu
     *
     * @return tankiNyushoPlanNissu
     */
    public int getTankiNyushoPlanNissu() {
        return tankiNyushoPlanNissu;
    }

    /**
     * setTankiNyushoPlanNissu
     *
     * @param tankiNyushoPlanNissu tankiNyushoPlanNissu
     */
    public void setTankiNyushoPlanNissu(int tankiNyushoPlanNissu) {
        this.tankiNyushoPlanNissu = tankiNyushoPlanNissu;
    }

    /**
     * getTankiNyushoJitsunissu
     *
     * @return tankiNyushoJitsunissu
     */
    public int getTankiNyushoJitsunissu() {
        return tankiNyushoJitsunissu;
    }

    /**
     * setTankiNyushoJitsunissu
     *
     * @param tankiNyushoJitsunissu tankiNyushoJitsunissu
     */
    public void setTankiNyushoJitsunissu(int tankiNyushoJitsunissu) {
        this.tankiNyushoJitsunissu = tankiNyushoJitsunissu;
    }

    /**
     * getHokenTanisuTotal
     *
     * @return hokenTanisuTotal
     */
    public int getHokenTanisuTotal() {
        return hokenTanisuTotal;
    }

    /**
     * setHokenTanisuTotal
     *
     * @param hokenTanisuTotal hokenTanisuTotal
     */
    public void setHokenTanisuTotal(int hokenTanisuTotal) {
        this.hokenTanisuTotal = hokenTanisuTotal;
    }

    /**
     * getHokenTanisuTani
     *
     * @return hokenTanisuTani
     */
    public Decimal getHokenTanisuTani() {
        return hokenTanisuTani;
    }

    /**
     * setHokenTanisuTani
     *
     * @param hokenTanisuTani hokenTanisuTani
     */
    public void setHokenTanisuTani(Decimal hokenTanisuTani) {
        this.hokenTanisuTani = hokenTanisuTani;
    }

    /**
     * getHokenSeikyugaku
     *
     * @return hokenSeikyugaku
     */
    public RString getHokenSeikyugaku() {
        return hokenSeikyugaku;
    }

    /**
     * setHokenSeikyugaku
     *
     * @param hokenSeikyugaku hokenSeikyugaku
     */
    public void setHokenSeikyugaku(RString hokenSeikyugaku) {
        this.hokenSeikyugaku = hokenSeikyugaku;
    }

    /**
     * getHokenRiyoshaFutangaku
     *
     * @return hokenRiyoshaFutangaku
     */
    public int getHokenRiyoshaFutangaku() {
        return hokenRiyoshaFutangaku;
    }

    /**
     * setHokenRiyoshaFutangaku
     *
     * @param hokenRiyoshaFutangaku hokenRiyoshaFutangaku
     */
    public void setHokenRiyoshaFutangaku(int hokenRiyoshaFutangaku) {
        this.hokenRiyoshaFutangaku = hokenRiyoshaFutangaku;
    }

    /**
     * getKohi1TanisuTotal
     *
     * @return kohi1TanisuTotal
     */
    public int getKohi1TanisuTotal() {
        return kohi1TanisuTotal;
    }

    /**
     * setKohi1TanisuTotal
     *
     * @param kohi1TanisuTotal kohi1TanisuTotal
     */
    public void setKohi1TanisuTotal(int kohi1TanisuTotal) {
        this.kohi1TanisuTotal = kohi1TanisuTotal;
    }

    /**
     * getKohi1Seikyugaku
     *
     * @return kohi1Seikyugaku
     */
    public RString getKohi1Seikyugaku() {
        return kohi1Seikyugaku;
    }

    /**
     * setKohi1Seikyugaku
     *
     * @param kohi1Seikyugaku kohi1Seikyugaku
     */
    public void setKohi1Seikyugaku(RString kohi1Seikyugaku) {
        this.kohi1Seikyugaku = kohi1Seikyugaku;
    }

    /**
     * getKohi1HonninFutangaku
     *
     * @return kohi1HonninFutangaku
     */
    public int getKohi1HonninFutangaku() {
        return kohi1HonninFutangaku;
    }

    /**
     * setKohi1HonninFutangaku
     *
     * @param kohi1HonninFutangaku kohi1HonninFutangaku
     */
    public void setKohi1HonninFutangaku(int kohi1HonninFutangaku) {
        this.kohi1HonninFutangaku = kohi1HonninFutangaku;
    }

    /**
     * getKohi2TanisuTotal
     *
     * @return kohi2TanisuTotal
     */
    public int getKohi2TanisuTotal() {
        return kohi2TanisuTotal;
    }

    /**
     * setKohi2TanisuTotal
     *
     * @param kohi2TanisuTotal kohi2TanisuTotal
     */
    public void setKohi2TanisuTotal(int kohi2TanisuTotal) {
        this.kohi2TanisuTotal = kohi2TanisuTotal;
    }

    /**
     * getKohi2Seikyugaku
     *
     * @return kohi2Seikyugaku
     */
    public RString getKohi2Seikyugaku() {
        return kohi2Seikyugaku;
    }

    /**
     * setKohi2Seikyugaku
     *
     * @param kohi2Seikyugaku kohi2Seikyugaku
     */
    public void setKohi2Seikyugaku(RString kohi2Seikyugaku) {
        this.kohi2Seikyugaku = kohi2Seikyugaku;
    }

    /**
     * getKohi2HonninFutangaku
     *
     * @return kohi2HonninFutangaku
     */
    public int getKohi2HonninFutangaku() {
        return kohi2HonninFutangaku;
    }

    /**
     * setKohi2HonninFutangaku
     *
     * @param kohi2HonninFutangaku kohi2HonninFutangaku
     */
    public void setKohi2HonninFutangaku(int kohi2HonninFutangaku) {
        this.kohi2HonninFutangaku = kohi2HonninFutangaku;
    }

    /**
     * getKohi3TanisuTotal
     *
     * @return kohi3TanisuTotal
     */
    public int getKohi3TanisuTotal() {
        return kohi3TanisuTotal;
    }

    /**
     * setKohi3TanisuTotal
     *
     * @param kohi3TanisuTotal kohi3TanisuTotal
     */
    public void setKohi3TanisuTotal(int kohi3TanisuTotal) {
        this.kohi3TanisuTotal = kohi3TanisuTotal;
    }

    /**
     * getKohi3Seikyugaku
     *
     * @return kohi3Seikyugaku
     */
    public RString getKohi3Seikyugaku() {
        return kohi3Seikyugaku;
    }

    /**
     * setKohi3Seikyugaku
     *
     * @param kohi3Seikyugaku kohi3Seikyugaku
     */
    public void setKohi3Seikyugaku(RString kohi3Seikyugaku) {
        this.kohi3Seikyugaku = kohi3Seikyugaku;
    }

    /**
     * getKohi3HonninFutangaku
     *
     * @return kohi3HonninFutangaku
     */
    public int getKohi3HonninFutangaku() {
        return kohi3HonninFutangaku;
    }

    /**
     * setKohi3HonninFutangaku
     *
     * @param kohi3HonninFutangaku kohi3HonninFutangaku
     */
    public void setKohi3HonninFutangaku(int kohi3HonninFutangaku) {
        this.kohi3HonninFutangaku = kohi3HonninFutangaku;
    }

    /**
     * getHokenDekidakaTanisuTotal
     *
     * @return hokenDekidakaTanisuTotal
     */
    public int getHokenDekidakaTanisuTotal() {
        return hokenDekidakaTanisuTotal;
    }

    /**
     * setHokenDekidakaTanisuTotal
     *
     * @param hokenDekidakaTanisuTotal hokenDekidakaTanisuTotal
     */
    public void setHokenDekidakaTanisuTotal(int hokenDekidakaTanisuTotal) {
        this.hokenDekidakaTanisuTotal = hokenDekidakaTanisuTotal;
    }

    /**
     * getHokenDekidakaSeikyugaku
     *
     * @return hokenDekidakaSeikyugaku
     */
    public RString getHokenDekidakaSeikyugaku() {
        return hokenDekidakaSeikyugaku;
    }

    /**
     * setHokenDekidakaSeikyugaku
     *
     * @param hokenDekidakaSeikyugaku hokenDekidakaSeikyugaku
     */
    public void setHokenDekidakaSeikyugaku(RString hokenDekidakaSeikyugaku) {
        this.hokenDekidakaSeikyugaku = hokenDekidakaSeikyugaku;
    }

    /**
     * getHokenDekidakaIryohiRiyoshaFutangaku
     *
     * @return hokenDekidakaIryohiRiyoshaFutangaku
     */
    public int getHokenDekidakaIryohiRiyoshaFutangaku() {
        return hokenDekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * setHokenDekidakaIryohiRiyoshaFutangaku
     *
     * @param hokenDekidakaIryohiRiyoshaFutangaku hokenDekidakaIryohiRiyoshaFutangaku
     */
    public void setHokenDekidakaIryohiRiyoshaFutangaku(int hokenDekidakaIryohiRiyoshaFutangaku) {
        this.hokenDekidakaIryohiRiyoshaFutangaku = hokenDekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * getKohi1DekidakaTanisuTotal
     *
     * @return kohi1DekidakaTanisuTotal
     */
    public int getKohi1DekidakaTanisuTotal() {
        return kohi1DekidakaTanisuTotal;
    }

    /**
     * setKohi1DekidakaTanisuTotal
     *
     * @param kohi1DekidakaTanisuTotal kohi1DekidakaTanisuTotal
     */
    public void setKohi1DekidakaTanisuTotal(int kohi1DekidakaTanisuTotal) {
        this.kohi1DekidakaTanisuTotal = kohi1DekidakaTanisuTotal;
    }

    /**
     * getKohi1DekidakaSeikyugaku
     *
     * @return kohi1DekidakaSeikyugaku
     */
    public RString getKohi1DekidakaSeikyugaku() {
        return kohi1DekidakaSeikyugaku;
    }

    /**
     * setKohi1DekidakaSeikyugaku
     *
     * @param kohi1DekidakaSeikyugaku kohi1DekidakaSeikyugaku
     */
    public void setKohi1DekidakaSeikyugaku(RString kohi1DekidakaSeikyugaku) {
        this.kohi1DekidakaSeikyugaku = kohi1DekidakaSeikyugaku;
    }

    /**
     * getKohi1DekidakaIryohiRiyoshaFutangaku
     *
     * @return kohi1DekidakaIryohiRiyoshaFutangaku
     */
    public int getKohi1DekidakaIryohiRiyoshaFutangaku() {
        return kohi1DekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * setKohi1DekidakaIryohiRiyoshaFutangaku
     *
     * @param kohi1DekidakaIryohiRiyoshaFutangaku kohi1DekidakaIryohiRiyoshaFutangaku
     */
    public void setKohi1DekidakaIryohiRiyoshaFutangaku(int kohi1DekidakaIryohiRiyoshaFutangaku) {
        this.kohi1DekidakaIryohiRiyoshaFutangaku = kohi1DekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * getKohi2DekidakaTanisuTotal
     *
     * @return kohi2DekidakaTanisuTotal
     */
    public int getKohi2DekidakaTanisuTotal() {
        return kohi2DekidakaTanisuTotal;
    }

    /**
     * setKohi2DekidakaTanisuTotal
     *
     * @param kohi2DekidakaTanisuTotal kohi2DekidakaTanisuTotal
     */
    public void setKohi2DekidakaTanisuTotal(int kohi2DekidakaTanisuTotal) {
        this.kohi2DekidakaTanisuTotal = kohi2DekidakaTanisuTotal;
    }

    /**
     * getKohi2DekidakaSeikyugaku
     *
     * @return kohi2DekidakaSeikyugaku
     */
    public RString getKohi2DekidakaSeikyugaku() {
        return kohi2DekidakaSeikyugaku;
    }

    /**
     * setKohi2DekidakaSeikyugaku
     *
     * @param kohi2DekidakaSeikyugaku kohi2DekidakaSeikyugaku
     */
    public void setKohi2DekidakaSeikyugaku(RString kohi2DekidakaSeikyugaku) {
        this.kohi2DekidakaSeikyugaku = kohi2DekidakaSeikyugaku;
    }

    /**
     * getKohi2DekidakaIryohiRiyoshaFutangaku
     *
     * @return kohi2DekidakaIryohiRiyoshaFutangaku
     */
    public int getKohi2DekidakaIryohiRiyoshaFutangaku() {
        return kohi2DekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * setKohi2DekidakaIryohiRiyoshaFutangaku
     *
     * @param kohi2DekidakaIryohiRiyoshaFutangaku kohi2DekidakaIryohiRiyoshaFutangaku
     */
    public void setKohi2DekidakaIryohiRiyoshaFutangaku(int kohi2DekidakaIryohiRiyoshaFutangaku) {
        this.kohi2DekidakaIryohiRiyoshaFutangaku = kohi2DekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * getKohi3DekidakaTanisuTotal
     *
     * @return kohi3DekidakaTanisuTotal
     */
    public int getKohi3DekidakaTanisuTotal() {
        return kohi3DekidakaTanisuTotal;
    }

    /**
     * setKohi3DekidakaTanisuTotal
     *
     * @param kohi3DekidakaTanisuTotal kohi3DekidakaTanisuTotal
     */
    public void setKohi3DekidakaTanisuTotal(int kohi3DekidakaTanisuTotal) {
        this.kohi3DekidakaTanisuTotal = kohi3DekidakaTanisuTotal;
    }

    /**
     * getKohi3DekidakaSeikyugaku
     *
     * @return kohi3DekidakaSeikyugaku
     */
    public RString getKohi3DekidakaSeikyugaku() {
        return kohi3DekidakaSeikyugaku;
    }

    /**
     * setKohi3DekidakaSeikyugaku
     *
     * @param kohi3DekidakaSeikyugaku kohi3DekidakaSeikyugaku
     */
    public void setKohi3DekidakaSeikyugaku(RString kohi3DekidakaSeikyugaku) {
        this.kohi3DekidakaSeikyugaku = kohi3DekidakaSeikyugaku;
    }

    /**
     * getKohi3DekidakaIryohiRiyoshaFutangaku
     *
     * @return kohi3DekidakaIryohiRiyoshaFutangaku
     */
    public int getKohi3DekidakaIryohiRiyoshaFutangaku() {
        return kohi3DekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * setKohi3DekidakaIryohiRiyoshaFutangaku
     *
     * @param kohi3DekidakaIryohiRiyoshaFutangaku kohi3DekidakaIryohiRiyoshaFutangaku
     */
    public void setKohi3DekidakaIryohiRiyoshaFutangaku(int kohi3DekidakaIryohiRiyoshaFutangaku) {
        this.kohi3DekidakaIryohiRiyoshaFutangaku = kohi3DekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * getAtoTankiNyushoJitsunissu
     *
     * @return atoTankiNyushoJitsunissu
     */
    public int getAtoTankiNyushoJitsunissu() {
        return atoTankiNyushoJitsunissu;
    }

    /**
     * setAtoTankiNyushoJitsunissu
     *
     * @param atoTankiNyushoJitsunissu atoTankiNyushoJitsunissu
     */
    public void setAtoTankiNyushoJitsunissu(int atoTankiNyushoJitsunissu) {
        this.atoTankiNyushoJitsunissu = atoTankiNyushoJitsunissu;
    }

    /**
     * getAtoHokenTanisuTotal
     *
     * @return atoHokenTanisuTotal
     */
    public int getAtoHokenTanisuTotal() {
        return atoHokenTanisuTotal;
    }

    /**
     * setAtoHokenTanisuTotal
     *
     * @param atoHokenTanisuTotal atoHokenTanisuTotal
     */
    public void setAtoHokenTanisuTotal(int atoHokenTanisuTotal) {
        this.atoHokenTanisuTotal = atoHokenTanisuTotal;
    }

    /**
     * getAtoHokenSeikyugaku
     *
     * @return atoHokenSeikyugaku
     */
    public RString getAtoHokenSeikyugaku() {
        return atoHokenSeikyugaku;
    }

    /**
     * setAtoHokenSeikyugaku
     *
     * @param atoHokenSeikyugaku atoHokenSeikyugaku
     */
    public void setAtoHokenSeikyugaku(RString atoHokenSeikyugaku) {
        this.atoHokenSeikyugaku = atoHokenSeikyugaku;
    }

    /**
     * getAtoKohi1TanisuTotal
     *
     * @return atoKohi1TanisuTotal
     */
    public int getAtoKohi1TanisuTotal() {
        return atoKohi1TanisuTotal;
    }

    /**
     * setAtoKohi1TanisuTotal
     *
     * @param atoKohi1TanisuTotal atoKohi1TanisuTotal
     */
    public void setAtoKohi1TanisuTotal(int atoKohi1TanisuTotal) {
        this.atoKohi1TanisuTotal = atoKohi1TanisuTotal;
    }

    /**
     * getAtoKohi1Seikyugaku
     *
     * @return atoKohi1Seikyugaku
     */
    public RString getAtoKohi1Seikyugaku() {
        return atoKohi1Seikyugaku;
    }

    /**
     * setAtoKohi1Seikyugaku
     *
     * @param atoKohi1Seikyugaku atoKohi1Seikyugaku
     */
    public void setAtoKohi1Seikyugaku(RString atoKohi1Seikyugaku) {
        this.atoKohi1Seikyugaku = atoKohi1Seikyugaku;
    }

    /**
     * getAtoKohi2TanisuTotal
     *
     * @return atoKohi2TanisuTotal
     */
    public int getAtoKohi2TanisuTotal() {
        return atoKohi2TanisuTotal;
    }

    /**
     * setAtoKohi2TanisuTotal
     *
     * @param atoKohi2TanisuTotal atoKohi2TanisuTotal
     */
    public void setAtoKohi2TanisuTotal(int atoKohi2TanisuTotal) {
        this.atoKohi2TanisuTotal = atoKohi2TanisuTotal;
    }

    /**
     * getAtoKohi2Seikyugaku
     *
     * @return atoKohi2Seikyugaku
     */
    public RString getAtoKohi2Seikyugaku() {
        return atoKohi2Seikyugaku;
    }

    /**
     * setAtoKohi2Seikyugaku
     *
     * @param atoKohi2Seikyugaku atoKohi2Seikyugaku
     */
    public void setAtoKohi2Seikyugaku(RString atoKohi2Seikyugaku) {
        this.atoKohi2Seikyugaku = atoKohi2Seikyugaku;
    }

    /**
     * getAtoKohi3TanisuTotal
     *
     * @return atoKohi3TanisuTotal
     */
    public int getAtoKohi3TanisuTotal() {
        return atoKohi3TanisuTotal;
    }

    /**
     * setAtoKohi3TanisuTotal
     *
     * @param atoKohi3TanisuTotal atoKohi3TanisuTotal
     */
    public void setAtoKohi3TanisuTotal(int atoKohi3TanisuTotal) {
        this.atoKohi3TanisuTotal = atoKohi3TanisuTotal;
    }

    /**
     * getAtoKohi3Seikyugaku
     *
     * @return atoKohi3Seikyugaku
     */
    public RString getAtoKohi3Seikyugaku() {
        return atoKohi3Seikyugaku;
    }

    /**
     * setAtoKohi3Seikyugaku
     *
     * @param atoKohi3Seikyugaku atoKohi3Seikyugaku
     */
    public void setAtoKohi3Seikyugaku(RString atoKohi3Seikyugaku) {
        this.atoKohi3Seikyugaku = atoKohi3Seikyugaku;
    }

    /**
     * getAtoHokenDekidakaTanisuTotal
     *
     * @return atoHokenDekidakaTanisuTotal
     */
    public int getAtoHokenDekidakaTanisuTotal() {
        return atoHokenDekidakaTanisuTotal;
    }

    /**
     * setAtoHokenDekidakaTanisuTotal
     *
     * @param atoHokenDekidakaTanisuTotal atoHokenDekidakaTanisuTotal
     */
    public void setAtoHokenDekidakaTanisuTotal(int atoHokenDekidakaTanisuTotal) {
        this.atoHokenDekidakaTanisuTotal = atoHokenDekidakaTanisuTotal;
    }

    /**
     * getAtoHokenDekidakaSeikyugaku
     *
     * @return atoHokenDekidakaSeikyugaku
     */
    public RString getAtoHokenDekidakaSeikyugaku() {
        return atoHokenDekidakaSeikyugaku;
    }

    /**
     * setAtoHokenDekidakaSeikyugaku
     *
     * @param atoHokenDekidakaSeikyugaku atoHokenDekidakaSeikyugaku
     */
    public void setAtoHokenDekidakaSeikyugaku(RString atoHokenDekidakaSeikyugaku) {
        this.atoHokenDekidakaSeikyugaku = atoHokenDekidakaSeikyugaku;
    }

    /**
     * getAtoKohi1DekidakaTanisuTotal
     *
     * @return atoKohi1DekidakaTanisuTotal
     */
    public int getAtoKohi1DekidakaTanisuTotal() {
        return atoKohi1DekidakaTanisuTotal;
    }

    /**
     * setAtoKohi1DekidakaTanisuTotal
     *
     * @param atoKohi1DekidakaTanisuTotal atoKohi1DekidakaTanisuTotal
     */
    public void setAtoKohi1DekidakaTanisuTotal(int atoKohi1DekidakaTanisuTotal) {
        this.atoKohi1DekidakaTanisuTotal = atoKohi1DekidakaTanisuTotal;
    }

    /**
     * getAtoKohi1DekidakaSeikyugaku
     *
     * @return atoKohi1DekidakaSeikyugaku
     */
    public RString getAtoKohi1DekidakaSeikyugaku() {
        return atoKohi1DekidakaSeikyugaku;
    }

    /**
     * setAtoKohi1DekidakaSeikyugaku
     *
     * @param atoKohi1DekidakaSeikyugaku atoKohi1DekidakaSeikyugaku
     */
    public void setAtoKohi1DekidakaSeikyugaku(RString atoKohi1DekidakaSeikyugaku) {
        this.atoKohi1DekidakaSeikyugaku = atoKohi1DekidakaSeikyugaku;
    }

    /**
     * getAtoKohi2DekidakaTanisuTotal
     *
     * @return atoKohi2DekidakaTanisuTotal
     */
    public int getAtoKohi2DekidakaTanisuTotal() {
        return atoKohi2DekidakaTanisuTotal;
    }

    /**
     * setAtoKohi2DekidakaTanisuTotal
     *
     * @param atoKohi2DekidakaTanisuTotal atoKohi2DekidakaTanisuTotal
     */
    public void setAtoKohi2DekidakaTanisuTotal(int atoKohi2DekidakaTanisuTotal) {
        this.atoKohi2DekidakaTanisuTotal = atoKohi2DekidakaTanisuTotal;
    }

    /**
     * getAtoKohi2DekidakaSeikyugaku
     *
     * @return atoKohi2DekidakaSeikyugaku
     */
    public RString getAtoKohi2DekidakaSeikyugaku() {
        return atoKohi2DekidakaSeikyugaku;
    }

    /**
     * setAtoKohi2DekidakaSeikyugaku
     *
     * @param atoKohi2DekidakaSeikyugaku atoKohi2DekidakaSeikyugaku
     */
    public void setAtoKohi2DekidakaSeikyugaku(RString atoKohi2DekidakaSeikyugaku) {
        this.atoKohi2DekidakaSeikyugaku = atoKohi2DekidakaSeikyugaku;
    }

    /**
     * getAtoKohi3DekidakaTanisuTotal
     *
     * @return atoKohi3DekidakaTanisuTotal
     */
    public int getAtoKohi3DekidakaTanisuTotal() {
        return atoKohi3DekidakaTanisuTotal;
    }

    /**
     * setAtoKohi3DekidakaTanisuTotal
     *
     * @param atoKohi3DekidakaTanisuTotal atoKohi3DekidakaTanisuTotal
     */
    public void setAtoKohi3DekidakaTanisuTotal(int atoKohi3DekidakaTanisuTotal) {
        this.atoKohi3DekidakaTanisuTotal = atoKohi3DekidakaTanisuTotal;
    }

    /**
     * getAtoKohi3DekidakaSeikyugaku
     *
     * @return atoKohi3DekidakaSeikyugaku
     */
    public RString getAtoKohi3DekidakaSeikyugaku() {
        return atoKohi3DekidakaSeikyugaku;
    }

    /**
     * setAtoKohi3DekidakaSeikyugaku
     *
     * @param atoKohi3DekidakaSeikyugaku atoKohi3DekidakaSeikyugaku
     */
    public void setAtoKohi3DekidakaSeikyugaku(RString atoKohi3DekidakaSeikyugaku) {
        this.atoKohi3DekidakaSeikyugaku = atoKohi3DekidakaSeikyugaku;
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
     * このエンティティの主キーが他の{@literal DbT3033KyufujissekiShukeiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT3033KyufujissekiShukeiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3033KyufujissekiShukeiEntity entity) {
        this.kokanJohoShikibetsuNo = entity.kokanJohoShikibetsuNo;
        this.inputShikibetsuNo = entity.inputShikibetsuNo;
        this.recodeShubetsuCode = entity.recodeShubetsuCode;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.toshiNo = entity.toshiNo;
        this.serviceSyuruiCode = entity.serviceSyuruiCode;
        this.serviceJitsunissu = entity.serviceJitsunissu;
        this.planTanisu = entity.planTanisu;
        this.gendogakuKanriTaishoTanisu = entity.gendogakuKanriTaishoTanisu;
        this.gendogakuKanritaishogaiTanisu = entity.gendogakuKanritaishogaiTanisu;
        this.tankiNyushoPlanNissu = entity.tankiNyushoPlanNissu;
        this.tankiNyushoJitsunissu = entity.tankiNyushoJitsunissu;
        this.hokenTanisuTotal = entity.hokenTanisuTotal;
        this.hokenTanisuTani = entity.hokenTanisuTani;
        this.hokenSeikyugaku = entity.hokenSeikyugaku;
        this.hokenRiyoshaFutangaku = entity.hokenRiyoshaFutangaku;
        this.kohi1TanisuTotal = entity.kohi1TanisuTotal;
        this.kohi1Seikyugaku = entity.kohi1Seikyugaku;
        this.kohi1HonninFutangaku = entity.kohi1HonninFutangaku;
        this.kohi2TanisuTotal = entity.kohi2TanisuTotal;
        this.kohi2Seikyugaku = entity.kohi2Seikyugaku;
        this.kohi2HonninFutangaku = entity.kohi2HonninFutangaku;
        this.kohi3TanisuTotal = entity.kohi3TanisuTotal;
        this.kohi3Seikyugaku = entity.kohi3Seikyugaku;
        this.kohi3HonninFutangaku = entity.kohi3HonninFutangaku;
        this.hokenDekidakaTanisuTotal = entity.hokenDekidakaTanisuTotal;
        this.hokenDekidakaSeikyugaku = entity.hokenDekidakaSeikyugaku;
        this.hokenDekidakaIryohiRiyoshaFutangaku = entity.hokenDekidakaIryohiRiyoshaFutangaku;
        this.kohi1DekidakaTanisuTotal = entity.kohi1DekidakaTanisuTotal;
        this.kohi1DekidakaSeikyugaku = entity.kohi1DekidakaSeikyugaku;
        this.kohi1DekidakaIryohiRiyoshaFutangaku = entity.kohi1DekidakaIryohiRiyoshaFutangaku;
        this.kohi2DekidakaTanisuTotal = entity.kohi2DekidakaTanisuTotal;
        this.kohi2DekidakaSeikyugaku = entity.kohi2DekidakaSeikyugaku;
        this.kohi2DekidakaIryohiRiyoshaFutangaku = entity.kohi2DekidakaIryohiRiyoshaFutangaku;
        this.kohi3DekidakaTanisuTotal = entity.kohi3DekidakaTanisuTotal;
        this.kohi3DekidakaSeikyugaku = entity.kohi3DekidakaSeikyugaku;
        this.kohi3DekidakaIryohiRiyoshaFutangaku = entity.kohi3DekidakaIryohiRiyoshaFutangaku;
        this.atoTankiNyushoJitsunissu = entity.atoTankiNyushoJitsunissu;
        this.atoHokenTanisuTotal = entity.atoHokenTanisuTotal;
        this.atoHokenSeikyugaku = entity.atoHokenSeikyugaku;
        this.atoKohi1TanisuTotal = entity.atoKohi1TanisuTotal;
        this.atoKohi1Seikyugaku = entity.atoKohi1Seikyugaku;
        this.atoKohi2TanisuTotal = entity.atoKohi2TanisuTotal;
        this.atoKohi2Seikyugaku = entity.atoKohi2Seikyugaku;
        this.atoKohi3TanisuTotal = entity.atoKohi3TanisuTotal;
        this.atoKohi3Seikyugaku = entity.atoKohi3Seikyugaku;
        this.atoHokenDekidakaTanisuTotal = entity.atoHokenDekidakaTanisuTotal;
        this.atoHokenDekidakaSeikyugaku = entity.atoHokenDekidakaSeikyugaku;
        this.atoKohi1DekidakaTanisuTotal = entity.atoKohi1DekidakaTanisuTotal;
        this.atoKohi1DekidakaSeikyugaku = entity.atoKohi1DekidakaSeikyugaku;
        this.atoKohi2DekidakaTanisuTotal = entity.atoKohi2DekidakaTanisuTotal;
        this.atoKohi2DekidakaSeikyugaku = entity.atoKohi2DekidakaSeikyugaku;
        this.atoKohi3DekidakaTanisuTotal = entity.atoKohi3DekidakaTanisuTotal;
        this.atoKohi3DekidakaSeikyugaku = entity.atoKohi3DekidakaSeikyugaku;
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
        return super.toMd5(kokanJohoShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, jigyoshoNo, toshiNo, serviceSyuruiCode, serviceJitsunissu, planTanisu, gendogakuKanriTaishoTanisu, gendogakuKanritaishogaiTanisu, tankiNyushoPlanNissu, tankiNyushoJitsunissu, hokenTanisuTotal, hokenTanisuTani, hokenSeikyugaku, hokenRiyoshaFutangaku, kohi1TanisuTotal, kohi1Seikyugaku, kohi1HonninFutangaku, kohi2TanisuTotal, kohi2Seikyugaku, kohi2HonninFutangaku, kohi3TanisuTotal, kohi3Seikyugaku, kohi3HonninFutangaku, hokenDekidakaTanisuTotal, hokenDekidakaSeikyugaku, hokenDekidakaIryohiRiyoshaFutangaku, kohi1DekidakaTanisuTotal, kohi1DekidakaSeikyugaku, kohi1DekidakaIryohiRiyoshaFutangaku, kohi2DekidakaTanisuTotal, kohi2DekidakaSeikyugaku, kohi2DekidakaIryohiRiyoshaFutangaku, kohi3DekidakaTanisuTotal, kohi3DekidakaSeikyugaku, kohi3DekidakaIryohiRiyoshaFutangaku, atoTankiNyushoJitsunissu, atoHokenTanisuTotal, atoHokenSeikyugaku, atoKohi1TanisuTotal, atoKohi1Seikyugaku, atoKohi2TanisuTotal, atoKohi2Seikyugaku, atoKohi3TanisuTotal, atoKohi3Seikyugaku, atoHokenDekidakaTanisuTotal, atoHokenDekidakaSeikyugaku, atoKohi1DekidakaTanisuTotal, atoKohi1DekidakaSeikyugaku, atoKohi2DekidakaTanisuTotal, atoKohi2DekidakaSeikyugaku, atoKohi3DekidakaTanisuTotal, atoKohi3DekidakaSeikyugaku, saishinsaKaisu, kagoKaisu, shinsaYM, seiriNo, torikomiYM);
    }

// </editor-fold>
}
