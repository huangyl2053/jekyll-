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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import java.util.Objects;

/**
 * DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuの項目定義クラスです
 *
 */
public class DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3030KyufuJissekiShakaiFukushiHojinKeigengaku");

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
    private Decimal keigenritsu;
    @PrimaryKey
    private ServiceShuruiCode serviceSyuruiCode;
    private Decimal riyoshaFutanTotal;
    private Decimal keigengaku;
    private Decimal keigengoRiyoshaFutangaku;
    private RString biko;
    private Decimal atoRiyoshaFutanTotal;
    private Decimal atoKeigengaku;
    private Decimal atoKeigengoRiyoshaFutangaku;
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
     * getKeigenritsu
     * @return keigenritsu
     */
    public Decimal getKeigenritsu() {
        return keigenritsu;
    }

    /**
     * setKeigenritsu
     * @param keigenritsu keigenritsu
     */
    public void setKeigenritsu(Decimal keigenritsu) {
        this.keigenritsu = keigenritsu;
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
     * getRiyoshaFutanTotal
     * @return riyoshaFutanTotal
     */
    public Decimal getRiyoshaFutanTotal() {
        return riyoshaFutanTotal;
    }

    /**
     * setRiyoshaFutanTotal
     * @param riyoshaFutanTotal riyoshaFutanTotal
     */
    public void setRiyoshaFutanTotal(Decimal riyoshaFutanTotal) {
        this.riyoshaFutanTotal = riyoshaFutanTotal;
    }

    /**
     * getKeigengaku
     * @return keigengaku
     */
    public Decimal getKeigengaku() {
        return keigengaku;
    }

    /**
     * setKeigengaku
     * @param keigengaku keigengaku
     */
    public void setKeigengaku(Decimal keigengaku) {
        this.keigengaku = keigengaku;
    }

    /**
     * getKeigengoRiyoshaFutangaku
     * @return keigengoRiyoshaFutangaku
     */
    public Decimal getKeigengoRiyoshaFutangaku() {
        return keigengoRiyoshaFutangaku;
    }

    /**
     * setKeigengoRiyoshaFutangaku
     * @param keigengoRiyoshaFutangaku keigengoRiyoshaFutangaku
     */
    public void setKeigengoRiyoshaFutangaku(Decimal keigengoRiyoshaFutangaku) {
        this.keigengoRiyoshaFutangaku = keigengoRiyoshaFutangaku;
    }

    /**
     * getBiko
     * @return biko
     */
    public RString getBiko() {
        return biko;
    }

    /**
     * setBiko
     * @param biko biko
     */
    public void setBiko(RString biko) {
        this.biko = biko;
    }

    /**
     * getAtoRiyoshaFutanTotal
     * @return atoRiyoshaFutanTotal
     */
    public Decimal getAtoRiyoshaFutanTotal() {
        return atoRiyoshaFutanTotal;
    }

    /**
     * setAtoRiyoshaFutanTotal
     * @param atoRiyoshaFutanTotal atoRiyoshaFutanTotal
     */
    public void setAtoRiyoshaFutanTotal(Decimal atoRiyoshaFutanTotal) {
        this.atoRiyoshaFutanTotal = atoRiyoshaFutanTotal;
    }

    /**
     * getAtoKeigengaku
     * @return atoKeigengaku
     */
    public Decimal getAtoKeigengaku() {
        return atoKeigengaku;
    }

    /**
     * setAtoKeigengaku
     * @param atoKeigengaku atoKeigengaku
     */
    public void setAtoKeigengaku(Decimal atoKeigengaku) {
        this.atoKeigengaku = atoKeigengaku;
    }

    /**
     * getAtoKeigengoRiyoshaFutangaku
     * @return atoKeigengoRiyoshaFutangaku
     */
    public Decimal getAtoKeigengoRiyoshaFutangaku() {
        return atoKeigengoRiyoshaFutangaku;
    }

    /**
     * setAtoKeigengoRiyoshaFutangaku
     * @param atoKeigengoRiyoshaFutangaku atoKeigengoRiyoshaFutangaku
     */
    public void setAtoKeigengoRiyoshaFutangaku(Decimal atoKeigengoRiyoshaFutangaku) {
        this.atoKeigengoRiyoshaFutangaku = atoKeigengoRiyoshaFutangaku;
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
     * このエンティティの主キーが他の{@literal DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity other) {
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
