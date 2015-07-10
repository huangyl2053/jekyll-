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
 * DbT3018KyufujissekiMeisaiの項目定義クラスです
 *
 */
public class DbT3018KyufujissekiMeisaiEntity extends DbTableEntityBase<DbT3018KyufujissekiMeisaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

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
    private ServiceShuruiCode serviceShuruiCode;
    @PrimaryKey
    private ServiceKomokuCode serviceKomokuCode;
    private int tanisu;
    private int nissuKaisu;
    private int kohi1TaishoNissuKaisu;
    private int kohi2TaishoNissuKaisu;
    private int kohi3TaishoNissuKaisu;
    private int serviceTanisu;
    private int kohi1TaishoServiceTanisu;
    private int kohi2TaishoServiceTanisu;
    private int kohi3TaishoServiceTanisu;
    private RString tekiyo;
    private int atoTanisu;
    private int atoNissuKaisu;
    private int atoKohi1TaishoNissuKaisu;
    private int atoKohi2TaishoNissukaisu;
    private int atoKohi3TaishoNissuKaisu;
    private int atoServiceTanisu;
    private int atoKohi1TaishoServiceTanisu;
    private int atoKohi2TaishoServiceTanisu;
    private int atoKohi3TaishoServiceTanisu;
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
     * getNissuKaisu
     *
     * @return nissuKaisu
     */
    public int getNissuKaisu() {
        return nissuKaisu;
    }

    /**
     * setNissuKaisu
     *
     * @param nissuKaisu nissuKaisu
     */
    public void setNissuKaisu(int nissuKaisu) {
        this.nissuKaisu = nissuKaisu;
    }

    /**
     * getKohi1TaishoNissuKaisu
     *
     * @return kohi1TaishoNissuKaisu
     */
    public int getKohi1TaishoNissuKaisu() {
        return kohi1TaishoNissuKaisu;
    }

    /**
     * setKohi1TaishoNissuKaisu
     *
     * @param kohi1TaishoNissuKaisu kohi1TaishoNissuKaisu
     */
    public void setKohi1TaishoNissuKaisu(int kohi1TaishoNissuKaisu) {
        this.kohi1TaishoNissuKaisu = kohi1TaishoNissuKaisu;
    }

    /**
     * getKohi2TaishoNissuKaisu
     *
     * @return kohi2TaishoNissuKaisu
     */
    public int getKohi2TaishoNissuKaisu() {
        return kohi2TaishoNissuKaisu;
    }

    /**
     * setKohi2TaishoNissuKaisu
     *
     * @param kohi2TaishoNissuKaisu kohi2TaishoNissuKaisu
     */
    public void setKohi2TaishoNissuKaisu(int kohi2TaishoNissuKaisu) {
        this.kohi2TaishoNissuKaisu = kohi2TaishoNissuKaisu;
    }

    /**
     * getKohi3TaishoNissuKaisu
     *
     * @return kohi3TaishoNissuKaisu
     */
    public int getKohi3TaishoNissuKaisu() {
        return kohi3TaishoNissuKaisu;
    }

    /**
     * setKohi3TaishoNissuKaisu
     *
     * @param kohi3TaishoNissuKaisu kohi3TaishoNissuKaisu
     */
    public void setKohi3TaishoNissuKaisu(int kohi3TaishoNissuKaisu) {
        this.kohi3TaishoNissuKaisu = kohi3TaishoNissuKaisu;
    }

    /**
     * getServiceTanisu
     *
     * @return serviceTanisu
     */
    public int getServiceTanisu() {
        return serviceTanisu;
    }

    /**
     * setServiceTanisu
     *
     * @param serviceTanisu serviceTanisu
     */
    public void setServiceTanisu(int serviceTanisu) {
        this.serviceTanisu = serviceTanisu;
    }

    /**
     * getKohi1TaishoServiceTanisu
     *
     * @return kohi1TaishoServiceTanisu
     */
    public int getKohi1TaishoServiceTanisu() {
        return kohi1TaishoServiceTanisu;
    }

    /**
     * setKohi1TaishoServiceTanisu
     *
     * @param kohi1TaishoServiceTanisu kohi1TaishoServiceTanisu
     */
    public void setKohi1TaishoServiceTanisu(int kohi1TaishoServiceTanisu) {
        this.kohi1TaishoServiceTanisu = kohi1TaishoServiceTanisu;
    }

    /**
     * getKohi2TaishoServiceTanisu
     *
     * @return kohi2TaishoServiceTanisu
     */
    public int getKohi2TaishoServiceTanisu() {
        return kohi2TaishoServiceTanisu;
    }

    /**
     * setKohi2TaishoServiceTanisu
     *
     * @param kohi2TaishoServiceTanisu kohi2TaishoServiceTanisu
     */
    public void setKohi2TaishoServiceTanisu(int kohi2TaishoServiceTanisu) {
        this.kohi2TaishoServiceTanisu = kohi2TaishoServiceTanisu;
    }

    /**
     * getKohi3TaishoServiceTanisu
     *
     * @return kohi3TaishoServiceTanisu
     */
    public int getKohi3TaishoServiceTanisu() {
        return kohi3TaishoServiceTanisu;
    }

    /**
     * setKohi3TaishoServiceTanisu
     *
     * @param kohi3TaishoServiceTanisu kohi3TaishoServiceTanisu
     */
    public void setKohi3TaishoServiceTanisu(int kohi3TaishoServiceTanisu) {
        this.kohi3TaishoServiceTanisu = kohi3TaishoServiceTanisu;
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
     * getAtoNissuKaisu
     *
     * @return atoNissuKaisu
     */
    public int getAtoNissuKaisu() {
        return atoNissuKaisu;
    }

    /**
     * setAtoNissuKaisu
     *
     * @param atoNissuKaisu atoNissuKaisu
     */
    public void setAtoNissuKaisu(int atoNissuKaisu) {
        this.atoNissuKaisu = atoNissuKaisu;
    }

    /**
     * getAtoKohi1TaishoNissuKaisu
     *
     * @return atoKohi1TaishoNissuKaisu
     */
    public int getAtoKohi1TaishoNissuKaisu() {
        return atoKohi1TaishoNissuKaisu;
    }

    /**
     * setAtoKohi1TaishoNissuKaisu
     *
     * @param atoKohi1TaishoNissuKaisu atoKohi1TaishoNissuKaisu
     */
    public void setAtoKohi1TaishoNissuKaisu(int atoKohi1TaishoNissuKaisu) {
        this.atoKohi1TaishoNissuKaisu = atoKohi1TaishoNissuKaisu;
    }

    /**
     * getAtoKohi2TaishoNissukaisu
     *
     * @return atoKohi2TaishoNissukaisu
     */
    public int getAtoKohi2TaishoNissukaisu() {
        return atoKohi2TaishoNissukaisu;
    }

    /**
     * setAtoKohi2TaishoNissukaisu
     *
     * @param atoKohi2TaishoNissukaisu atoKohi2TaishoNissukaisu
     */
    public void setAtoKohi2TaishoNissukaisu(int atoKohi2TaishoNissukaisu) {
        this.atoKohi2TaishoNissukaisu = atoKohi2TaishoNissukaisu;
    }

    /**
     * getAtoKohi3TaishoNissuKaisu
     *
     * @return atoKohi3TaishoNissuKaisu
     */
    public int getAtoKohi3TaishoNissuKaisu() {
        return atoKohi3TaishoNissuKaisu;
    }

    /**
     * setAtoKohi3TaishoNissuKaisu
     *
     * @param atoKohi3TaishoNissuKaisu atoKohi3TaishoNissuKaisu
     */
    public void setAtoKohi3TaishoNissuKaisu(int atoKohi3TaishoNissuKaisu) {
        this.atoKohi3TaishoNissuKaisu = atoKohi3TaishoNissuKaisu;
    }

    /**
     * getAtoServiceTanisu
     *
     * @return atoServiceTanisu
     */
    public int getAtoServiceTanisu() {
        return atoServiceTanisu;
    }

    /**
     * setAtoServiceTanisu
     *
     * @param atoServiceTanisu atoServiceTanisu
     */
    public void setAtoServiceTanisu(int atoServiceTanisu) {
        this.atoServiceTanisu = atoServiceTanisu;
    }

    /**
     * getAtoKohi1TaishoServiceTanisu
     *
     * @return atoKohi1TaishoServiceTanisu
     */
    public int getAtoKohi1TaishoServiceTanisu() {
        return atoKohi1TaishoServiceTanisu;
    }

    /**
     * setAtoKohi1TaishoServiceTanisu
     *
     * @param atoKohi1TaishoServiceTanisu atoKohi1TaishoServiceTanisu
     */
    public void setAtoKohi1TaishoServiceTanisu(int atoKohi1TaishoServiceTanisu) {
        this.atoKohi1TaishoServiceTanisu = atoKohi1TaishoServiceTanisu;
    }

    /**
     * getAtoKohi2TaishoServiceTanisu
     *
     * @return atoKohi2TaishoServiceTanisu
     */
    public int getAtoKohi2TaishoServiceTanisu() {
        return atoKohi2TaishoServiceTanisu;
    }

    /**
     * setAtoKohi2TaishoServiceTanisu
     *
     * @param atoKohi2TaishoServiceTanisu atoKohi2TaishoServiceTanisu
     */
    public void setAtoKohi2TaishoServiceTanisu(int atoKohi2TaishoServiceTanisu) {
        this.atoKohi2TaishoServiceTanisu = atoKohi2TaishoServiceTanisu;
    }

    /**
     * getAtoKohi3TaishoServiceTanisu
     *
     * @return atoKohi3TaishoServiceTanisu
     */
    public int getAtoKohi3TaishoServiceTanisu() {
        return atoKohi3TaishoServiceTanisu;
    }

    /**
     * setAtoKohi3TaishoServiceTanisu
     *
     * @param atoKohi3TaishoServiceTanisu atoKohi3TaishoServiceTanisu
     */
    public void setAtoKohi3TaishoServiceTanisu(int atoKohi3TaishoServiceTanisu) {
        this.atoKohi3TaishoServiceTanisu = atoKohi3TaishoServiceTanisu;
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
     * このエンティティの主キーが他の{@literal DbT3018KyufujissekiMeisaiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT3018KyufujissekiMeisaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3018KyufujissekiMeisaiEntity entity) {
        this.kokanJohoShikibetsuNo = entity.kokanJohoShikibetsuNo;
        this.inputShikibetsuNo = entity.inputShikibetsuNo;
        this.recodeShubetsuCode = entity.recodeShubetsuCode;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.toshiNo = entity.toshiNo;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.serviceKomokuCode = entity.serviceKomokuCode;
        this.tanisu = entity.tanisu;
        this.nissuKaisu = entity.nissuKaisu;
        this.kohi1TaishoNissuKaisu = entity.kohi1TaishoNissuKaisu;
        this.kohi2TaishoNissuKaisu = entity.kohi2TaishoNissuKaisu;
        this.kohi3TaishoNissuKaisu = entity.kohi3TaishoNissuKaisu;
        this.serviceTanisu = entity.serviceTanisu;
        this.kohi1TaishoServiceTanisu = entity.kohi1TaishoServiceTanisu;
        this.kohi2TaishoServiceTanisu = entity.kohi2TaishoServiceTanisu;
        this.kohi3TaishoServiceTanisu = entity.kohi3TaishoServiceTanisu;
        this.tekiyo = entity.tekiyo;
        this.atoTanisu = entity.atoTanisu;
        this.atoNissuKaisu = entity.atoNissuKaisu;
        this.atoKohi1TaishoNissuKaisu = entity.atoKohi1TaishoNissuKaisu;
        this.atoKohi2TaishoNissukaisu = entity.atoKohi2TaishoNissukaisu;
        this.atoKohi3TaishoNissuKaisu = entity.atoKohi3TaishoNissuKaisu;
        this.atoServiceTanisu = entity.atoServiceTanisu;
        this.atoKohi1TaishoServiceTanisu = entity.atoKohi1TaishoServiceTanisu;
        this.atoKohi2TaishoServiceTanisu = entity.atoKohi2TaishoServiceTanisu;
        this.atoKohi3TaishoServiceTanisu = entity.atoKohi3TaishoServiceTanisu;
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
        return super.toMd5(kokanJohoShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, jigyoshoNo, toshiNo, serviceShuruiCode, serviceKomokuCode, tanisu, nissuKaisu, kohi1TaishoNissuKaisu, kohi2TaishoNissuKaisu, kohi3TaishoNissuKaisu, serviceTanisu, kohi1TaishoServiceTanisu, kohi2TaishoServiceTanisu, kohi3TaishoServiceTanisu, tekiyo, atoTanisu, atoNissuKaisu, atoKohi1TaishoNissuKaisu, atoKohi2TaishoNissukaisu, atoKohi3TaishoNissuKaisu, atoServiceTanisu, atoKohi1TaishoServiceTanisu, atoKohi2TaishoServiceTanisu, atoKohi3TaishoServiceTanisu, saishinsaKaisu, kagoKaisu, shinsaYM, seiriNo, torikomiYM);
    }

// </editor-fold>
}
