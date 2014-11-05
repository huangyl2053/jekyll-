package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ToshiNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * DbT3026KyufujissekiFukushiYoguHanbaihiの項目定義クラスです
 *
 */
public class DbT3026KyufujissekiFukushiYoguHanbaihiEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3026KyufujissekiFukushiYoguHanbaihi");

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
    private RString meisaiNo;
    private RString serviceCode;
    private FlexibleDate fukushiyoguHanbaiYMD;
    private RString fukushiyoguShohinName;
    private RString fukushiyoguSyumokuCode;
    private RString fukushiyoguSeizoJigyoshaName;
    private RString fukushiyoguHanbaiJigyoshaName;
    private Decimal hanbaiKingaku;
    private RString tekiyo;
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
     * getMeisaiNo
     * @return meisaiNo
     */
    public RString getMeisaiNo() {
        return meisaiNo;
    }

    /**
     * setMeisaiNo
     * @param meisaiNo meisaiNo
     */
    public void setMeisaiNo(RString meisaiNo) {
        this.meisaiNo = meisaiNo;
    }

    /**
     * getServiceCode
     * @return serviceCode
     */
    public RString getServiceCode() {
        return serviceCode;
    }

    /**
     * setServiceCode
     * @param serviceCode serviceCode
     */
    public void setServiceCode(RString serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * getFukushiyoguHanbaiYMD
     * @return fukushiyoguHanbaiYMD
     */
    public FlexibleDate getFukushiyoguHanbaiYMD() {
        return fukushiyoguHanbaiYMD;
    }

    /**
     * setFukushiyoguHanbaiYMD
     * @param fukushiyoguHanbaiYMD fukushiyoguHanbaiYMD
     */
    public void setFukushiyoguHanbaiYMD(FlexibleDate fukushiyoguHanbaiYMD) {
        this.fukushiyoguHanbaiYMD = fukushiyoguHanbaiYMD;
    }

    /**
     * getFukushiyoguShohinName
     * @return fukushiyoguShohinName
     */
    public RString getFukushiyoguShohinName() {
        return fukushiyoguShohinName;
    }

    /**
     * setFukushiyoguShohinName
     * @param fukushiyoguShohinName fukushiyoguShohinName
     */
    public void setFukushiyoguShohinName(RString fukushiyoguShohinName) {
        this.fukushiyoguShohinName = fukushiyoguShohinName;
    }

    /**
     * getFukushiyoguSyumokuCode
     * @return fukushiyoguSyumokuCode
     */
    public RString getFukushiyoguSyumokuCode() {
        return fukushiyoguSyumokuCode;
    }

    /**
     * setFukushiyoguSyumokuCode
     * @param fukushiyoguSyumokuCode fukushiyoguSyumokuCode
     */
    public void setFukushiyoguSyumokuCode(RString fukushiyoguSyumokuCode) {
        this.fukushiyoguSyumokuCode = fukushiyoguSyumokuCode;
    }

    /**
     * getFukushiyoguSeizoJigyoshaName
     * @return fukushiyoguSeizoJigyoshaName
     */
    public RString getFukushiyoguSeizoJigyoshaName() {
        return fukushiyoguSeizoJigyoshaName;
    }

    /**
     * setFukushiyoguSeizoJigyoshaName
     * @param fukushiyoguSeizoJigyoshaName fukushiyoguSeizoJigyoshaName
     */
    public void setFukushiyoguSeizoJigyoshaName(RString fukushiyoguSeizoJigyoshaName) {
        this.fukushiyoguSeizoJigyoshaName = fukushiyoguSeizoJigyoshaName;
    }

    /**
     * getFukushiyoguHanbaiJigyoshaName
     * @return fukushiyoguHanbaiJigyoshaName
     */
    public RString getFukushiyoguHanbaiJigyoshaName() {
        return fukushiyoguHanbaiJigyoshaName;
    }

    /**
     * setFukushiyoguHanbaiJigyoshaName
     * @param fukushiyoguHanbaiJigyoshaName fukushiyoguHanbaiJigyoshaName
     */
    public void setFukushiyoguHanbaiJigyoshaName(RString fukushiyoguHanbaiJigyoshaName) {
        this.fukushiyoguHanbaiJigyoshaName = fukushiyoguHanbaiJigyoshaName;
    }

    /**
     * getHanbaiKingaku
     * @return hanbaiKingaku
     */
    public Decimal getHanbaiKingaku() {
        return hanbaiKingaku;
    }

    /**
     * setHanbaiKingaku
     * @param hanbaiKingaku hanbaiKingaku
     */
    public void setHanbaiKingaku(Decimal hanbaiKingaku) {
        this.hanbaiKingaku = hanbaiKingaku;
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
     * このエンティティの主キーが他の{@literal DbT3026KyufujissekiFukushiYoguHanbaihiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3026KyufujissekiFukushiYoguHanbaihiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT3026KyufujissekiFukushiYoguHanbaihiEntity other) {
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
        if (!Objects.equals(this.meisaiNo, other.meisaiNo)) {
            return false;
        }
        return true;
    }

// </editor-fold>


}
