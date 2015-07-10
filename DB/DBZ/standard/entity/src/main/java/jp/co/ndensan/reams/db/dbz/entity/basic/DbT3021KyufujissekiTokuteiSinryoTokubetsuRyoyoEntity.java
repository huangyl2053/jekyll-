package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoの項目定義クラスです
 *
 */
public class DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity extends DbTableEntityBase<DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyo");

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
    private RString shobyoName;
    private RString shikibetsuNo;
    private int tanisu;
    private int hokenKaisu;
    private int hokenServiceTanisu;
    private int hokenTotalTanisu;
    private int kohi1Kaisu;
    private int kohi1ServiceTanisu;
    private int kohi1TotalTanisu;
    private int kohi2Kaisu;
    private int kohi2ServiceTanisu;
    private int kohi2TotalTanisu;
    private int kohi3Kaisu;
    private int kohi3ServiceTanisu;
    private int kohi3TotalTanisu;
    private RString tekiyo;
    private int atoTanisu;
    private int atoHokenKaisu;
    private int atoHokenServiceTanisu;
    private int atoHokenTotalTanisu;
    private int atoKohi1Kaisu;
    private int atoKohi1ServiceTanisu;
    private int atoKohi1TotalTanisu;
    private int atoKohi2Kaisu;
    private int atoKohi2ServiceTanisu;
    private int atoKohi2TotalTanisu;
    private int atoKohi3Kaisu;
    private int atoKohi3ServiceTanisu;
    private int atoKohi3TotalTanisu;
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
     * getShobyoName
     *
     * @return shobyoName
     */
    public RString getShobyoName() {
        return shobyoName;
    }

    /**
     * setShobyoName
     *
     * @param shobyoName shobyoName
     */
    public void setShobyoName(RString shobyoName) {
        this.shobyoName = shobyoName;
    }

    /**
     * getShikibetsuNo
     *
     * @return shikibetsuNo
     */
    public RString getShikibetsuNo() {
        return shikibetsuNo;
    }

    /**
     * setShikibetsuNo
     *
     * @param shikibetsuNo shikibetsuNo
     */
    public void setShikibetsuNo(RString shikibetsuNo) {
        this.shikibetsuNo = shikibetsuNo;
    }

    /**
     * getTanisu
     *
     * @return tanisu
     */
    public int getTanisu() {
        return tanisu;
    }

    /**
     * setTanisu
     *
     * @param tanisu tanisu
     */
    public void setTanisu(int tanisu) {
        this.tanisu = tanisu;
    }

    /**
     * getHokenKaisu
     *
     * @return hokenKaisu
     */
    public int getHokenKaisu() {
        return hokenKaisu;
    }

    /**
     * setHokenKaisu
     *
     * @param hokenKaisu hokenKaisu
     */
    public void setHokenKaisu(int hokenKaisu) {
        this.hokenKaisu = hokenKaisu;
    }

    /**
     * getHokenServiceTanisu
     *
     * @return hokenServiceTanisu
     */
    public int getHokenServiceTanisu() {
        return hokenServiceTanisu;
    }

    /**
     * setHokenServiceTanisu
     *
     * @param hokenServiceTanisu hokenServiceTanisu
     */
    public void setHokenServiceTanisu(int hokenServiceTanisu) {
        this.hokenServiceTanisu = hokenServiceTanisu;
    }

    /**
     * getHokenTotalTanisu
     *
     * @return hokenTotalTanisu
     */
    public int getHokenTotalTanisu() {
        return hokenTotalTanisu;
    }

    /**
     * setHokenTotalTanisu
     *
     * @param hokenTotalTanisu hokenTotalTanisu
     */
    public void setHokenTotalTanisu(int hokenTotalTanisu) {
        this.hokenTotalTanisu = hokenTotalTanisu;
    }

    /**
     * getKohi1Kaisu
     *
     * @return kohi1Kaisu
     */
    public int getKohi1Kaisu() {
        return kohi1Kaisu;
    }

    /**
     * setKohi1Kaisu
     *
     * @param kohi1Kaisu kohi1Kaisu
     */
    public void setKohi1Kaisu(int kohi1Kaisu) {
        this.kohi1Kaisu = kohi1Kaisu;
    }

    /**
     * getKohi1ServiceTanisu
     *
     * @return kohi1ServiceTanisu
     */
    public int getKohi1ServiceTanisu() {
        return kohi1ServiceTanisu;
    }

    /**
     * setKohi1ServiceTanisu
     *
     * @param kohi1ServiceTanisu kohi1ServiceTanisu
     */
    public void setKohi1ServiceTanisu(int kohi1ServiceTanisu) {
        this.kohi1ServiceTanisu = kohi1ServiceTanisu;
    }

    /**
     * getKohi1TotalTanisu
     *
     * @return kohi1TotalTanisu
     */
    public int getKohi1TotalTanisu() {
        return kohi1TotalTanisu;
    }

    /**
     * setKohi1TotalTanisu
     *
     * @param kohi1TotalTanisu kohi1TotalTanisu
     */
    public void setKohi1TotalTanisu(int kohi1TotalTanisu) {
        this.kohi1TotalTanisu = kohi1TotalTanisu;
    }

    /**
     * getKohi2Kaisu
     *
     * @return kohi2Kaisu
     */
    public int getKohi2Kaisu() {
        return kohi2Kaisu;
    }

    /**
     * setKohi2Kaisu
     *
     * @param kohi2Kaisu kohi2Kaisu
     */
    public void setKohi2Kaisu(int kohi2Kaisu) {
        this.kohi2Kaisu = kohi2Kaisu;
    }

    /**
     * getKohi2ServiceTanisu
     *
     * @return kohi2ServiceTanisu
     */
    public int getKohi2ServiceTanisu() {
        return kohi2ServiceTanisu;
    }

    /**
     * setKohi2ServiceTanisu
     *
     * @param kohi2ServiceTanisu kohi2ServiceTanisu
     */
    public void setKohi2ServiceTanisu(int kohi2ServiceTanisu) {
        this.kohi2ServiceTanisu = kohi2ServiceTanisu;
    }

    /**
     * getKohi2TotalTanisu
     *
     * @return kohi2TotalTanisu
     */
    public int getKohi2TotalTanisu() {
        return kohi2TotalTanisu;
    }

    /**
     * setKohi2TotalTanisu
     *
     * @param kohi2TotalTanisu kohi2TotalTanisu
     */
    public void setKohi2TotalTanisu(int kohi2TotalTanisu) {
        this.kohi2TotalTanisu = kohi2TotalTanisu;
    }

    /**
     * getKohi3Kaisu
     *
     * @return kohi3Kaisu
     */
    public int getKohi3Kaisu() {
        return kohi3Kaisu;
    }

    /**
     * setKohi3Kaisu
     *
     * @param kohi3Kaisu kohi3Kaisu
     */
    public void setKohi3Kaisu(int kohi3Kaisu) {
        this.kohi3Kaisu = kohi3Kaisu;
    }

    /**
     * getKohi3ServiceTanisu
     *
     * @return kohi3ServiceTanisu
     */
    public int getKohi3ServiceTanisu() {
        return kohi3ServiceTanisu;
    }

    /**
     * setKohi3ServiceTanisu
     *
     * @param kohi3ServiceTanisu kohi3ServiceTanisu
     */
    public void setKohi3ServiceTanisu(int kohi3ServiceTanisu) {
        this.kohi3ServiceTanisu = kohi3ServiceTanisu;
    }

    /**
     * getKohi3TotalTanisu
     *
     * @return kohi3TotalTanisu
     */
    public int getKohi3TotalTanisu() {
        return kohi3TotalTanisu;
    }

    /**
     * setKohi3TotalTanisu
     *
     * @param kohi3TotalTanisu kohi3TotalTanisu
     */
    public void setKohi3TotalTanisu(int kohi3TotalTanisu) {
        this.kohi3TotalTanisu = kohi3TotalTanisu;
    }

    /**
     * getTekiyo
     *
     * @return tekiyo
     */
    public RString getTekiyo() {
        return tekiyo;
    }

    /**
     * setTekiyo
     *
     * @param tekiyo tekiyo
     */
    public void setTekiyo(RString tekiyo) {
        this.tekiyo = tekiyo;
    }

    /**
     * getAtoTanisu
     *
     * @return atoTanisu
     */
    public int getAtoTanisu() {
        return atoTanisu;
    }

    /**
     * setAtoTanisu
     *
     * @param atoTanisu atoTanisu
     */
    public void setAtoTanisu(int atoTanisu) {
        this.atoTanisu = atoTanisu;
    }

    /**
     * getAtoHokenKaisu
     *
     * @return atoHokenKaisu
     */
    public int getAtoHokenKaisu() {
        return atoHokenKaisu;
    }

    /**
     * setAtoHokenKaisu
     *
     * @param atoHokenKaisu atoHokenKaisu
     */
    public void setAtoHokenKaisu(int atoHokenKaisu) {
        this.atoHokenKaisu = atoHokenKaisu;
    }

    /**
     * getAtoHokenServiceTanisu
     *
     * @return atoHokenServiceTanisu
     */
    public int getAtoHokenServiceTanisu() {
        return atoHokenServiceTanisu;
    }

    /**
     * setAtoHokenServiceTanisu
     *
     * @param atoHokenServiceTanisu atoHokenServiceTanisu
     */
    public void setAtoHokenServiceTanisu(int atoHokenServiceTanisu) {
        this.atoHokenServiceTanisu = atoHokenServiceTanisu;
    }

    /**
     * getAtoHokenTotalTanisu
     *
     * @return atoHokenTotalTanisu
     */
    public int getAtoHokenTotalTanisu() {
        return atoHokenTotalTanisu;
    }

    /**
     * setAtoHokenTotalTanisu
     *
     * @param atoHokenTotalTanisu atoHokenTotalTanisu
     */
    public void setAtoHokenTotalTanisu(int atoHokenTotalTanisu) {
        this.atoHokenTotalTanisu = atoHokenTotalTanisu;
    }

    /**
     * getAtoKohi1Kaisu
     *
     * @return atoKohi1Kaisu
     */
    public int getAtoKohi1Kaisu() {
        return atoKohi1Kaisu;
    }

    /**
     * setAtoKohi1Kaisu
     *
     * @param atoKohi1Kaisu atoKohi1Kaisu
     */
    public void setAtoKohi1Kaisu(int atoKohi1Kaisu) {
        this.atoKohi1Kaisu = atoKohi1Kaisu;
    }

    /**
     * getAtoKohi1ServiceTanisu
     *
     * @return atoKohi1ServiceTanisu
     */
    public int getAtoKohi1ServiceTanisu() {
        return atoKohi1ServiceTanisu;
    }

    /**
     * setAtoKohi1ServiceTanisu
     *
     * @param atoKohi1ServiceTanisu atoKohi1ServiceTanisu
     */
    public void setAtoKohi1ServiceTanisu(int atoKohi1ServiceTanisu) {
        this.atoKohi1ServiceTanisu = atoKohi1ServiceTanisu;
    }

    /**
     * getAtoKohi1TotalTanisu
     *
     * @return atoKohi1TotalTanisu
     */
    public int getAtoKohi1TotalTanisu() {
        return atoKohi1TotalTanisu;
    }

    /**
     * setAtoKohi1TotalTanisu
     *
     * @param atoKohi1TotalTanisu atoKohi1TotalTanisu
     */
    public void setAtoKohi1TotalTanisu(int atoKohi1TotalTanisu) {
        this.atoKohi1TotalTanisu = atoKohi1TotalTanisu;
    }

    /**
     * getAtoKohi2Kaisu
     *
     * @return atoKohi2Kaisu
     */
    public int getAtoKohi2Kaisu() {
        return atoKohi2Kaisu;
    }

    /**
     * setAtoKohi2Kaisu
     *
     * @param atoKohi2Kaisu atoKohi2Kaisu
     */
    public void setAtoKohi2Kaisu(int atoKohi2Kaisu) {
        this.atoKohi2Kaisu = atoKohi2Kaisu;
    }

    /**
     * getAtoKohi2ServiceTanisu
     *
     * @return atoKohi2ServiceTanisu
     */
    public int getAtoKohi2ServiceTanisu() {
        return atoKohi2ServiceTanisu;
    }

    /**
     * setAtoKohi2ServiceTanisu
     *
     * @param atoKohi2ServiceTanisu atoKohi2ServiceTanisu
     */
    public void setAtoKohi2ServiceTanisu(int atoKohi2ServiceTanisu) {
        this.atoKohi2ServiceTanisu = atoKohi2ServiceTanisu;
    }

    /**
     * getAtoKohi2TotalTanisu
     *
     * @return atoKohi2TotalTanisu
     */
    public int getAtoKohi2TotalTanisu() {
        return atoKohi2TotalTanisu;
    }

    /**
     * setAtoKohi2TotalTanisu
     *
     * @param atoKohi2TotalTanisu atoKohi2TotalTanisu
     */
    public void setAtoKohi2TotalTanisu(int atoKohi2TotalTanisu) {
        this.atoKohi2TotalTanisu = atoKohi2TotalTanisu;
    }

    /**
     * getAtoKohi3Kaisu
     *
     * @return atoKohi3Kaisu
     */
    public int getAtoKohi3Kaisu() {
        return atoKohi3Kaisu;
    }

    /**
     * setAtoKohi3Kaisu
     *
     * @param atoKohi3Kaisu atoKohi3Kaisu
     */
    public void setAtoKohi3Kaisu(int atoKohi3Kaisu) {
        this.atoKohi3Kaisu = atoKohi3Kaisu;
    }

    /**
     * getAtoKohi3ServiceTanisu
     *
     * @return atoKohi3ServiceTanisu
     */
    public int getAtoKohi3ServiceTanisu() {
        return atoKohi3ServiceTanisu;
    }

    /**
     * setAtoKohi3ServiceTanisu
     *
     * @param atoKohi3ServiceTanisu atoKohi3ServiceTanisu
     */
    public void setAtoKohi3ServiceTanisu(int atoKohi3ServiceTanisu) {
        this.atoKohi3ServiceTanisu = atoKohi3ServiceTanisu;
    }

    /**
     * getAtoKohi3TotalTanisu
     *
     * @return atoKohi3TotalTanisu
     */
    public int getAtoKohi3TotalTanisu() {
        return atoKohi3TotalTanisu;
    }

    /**
     * setAtoKohi3TotalTanisu
     *
     * @param atoKohi3TotalTanisu atoKohi3TotalTanisu
     */
    public void setAtoKohi3TotalTanisu(int atoKohi3TotalTanisu) {
        this.atoKohi3TotalTanisu = atoKohi3TotalTanisu;
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
     * このエンティティの主キーが他の{@literal DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity other) {
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
    public void shallowCopy(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity) {
        this.kokanJohoShikibetsuNo = entity.kokanJohoShikibetsuNo;
        this.inputShikibetsuNo = entity.inputShikibetsuNo;
        this.recodeShubetsuCode = entity.recodeShubetsuCode;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.toshiNo = entity.toshiNo;
        this.recodeJunjiNo = entity.recodeJunjiNo;
        this.shobyoName = entity.shobyoName;
        this.shikibetsuNo = entity.shikibetsuNo;
        this.tanisu = entity.tanisu;
        this.hokenKaisu = entity.hokenKaisu;
        this.hokenServiceTanisu = entity.hokenServiceTanisu;
        this.hokenTotalTanisu = entity.hokenTotalTanisu;
        this.kohi1Kaisu = entity.kohi1Kaisu;
        this.kohi1ServiceTanisu = entity.kohi1ServiceTanisu;
        this.kohi1TotalTanisu = entity.kohi1TotalTanisu;
        this.kohi2Kaisu = entity.kohi2Kaisu;
        this.kohi2ServiceTanisu = entity.kohi2ServiceTanisu;
        this.kohi2TotalTanisu = entity.kohi2TotalTanisu;
        this.kohi3Kaisu = entity.kohi3Kaisu;
        this.kohi3ServiceTanisu = entity.kohi3ServiceTanisu;
        this.kohi3TotalTanisu = entity.kohi3TotalTanisu;
        this.tekiyo = entity.tekiyo;
        this.atoTanisu = entity.atoTanisu;
        this.atoHokenKaisu = entity.atoHokenKaisu;
        this.atoHokenServiceTanisu = entity.atoHokenServiceTanisu;
        this.atoHokenTotalTanisu = entity.atoHokenTotalTanisu;
        this.atoKohi1Kaisu = entity.atoKohi1Kaisu;
        this.atoKohi1ServiceTanisu = entity.atoKohi1ServiceTanisu;
        this.atoKohi1TotalTanisu = entity.atoKohi1TotalTanisu;
        this.atoKohi2Kaisu = entity.atoKohi2Kaisu;
        this.atoKohi2ServiceTanisu = entity.atoKohi2ServiceTanisu;
        this.atoKohi2TotalTanisu = entity.atoKohi2TotalTanisu;
        this.atoKohi3Kaisu = entity.atoKohi3Kaisu;
        this.atoKohi3ServiceTanisu = entity.atoKohi3ServiceTanisu;
        this.atoKohi3TotalTanisu = entity.atoKohi3TotalTanisu;
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
        return super.toMd5(kokanJohoShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, jigyoshoNo, toshiNo, recodeJunjiNo, shobyoName, shikibetsuNo, tanisu, hokenKaisu, hokenServiceTanisu, hokenTotalTanisu, kohi1Kaisu, kohi1ServiceTanisu, kohi1TotalTanisu, kohi2Kaisu, kohi2ServiceTanisu, kohi2TotalTanisu, kohi3Kaisu, kohi3ServiceTanisu, kohi3TotalTanisu, tekiyo, atoTanisu, atoHokenKaisu, atoHokenServiceTanisu, atoHokenTotalTanisu, atoKohi1Kaisu, atoKohi1ServiceTanisu, atoKohi1TotalTanisu, atoKohi2Kaisu, atoKohi2ServiceTanisu, atoKohi2TotalTanisu, atoKohi3Kaisu, atoKohi3ServiceTanisu, atoKohi3TotalTanisu, saishinsaKaisu, kagoKaisu, shinsaYM, seiriNo, torikomiYM);
    }

// </editor-fold>
}
