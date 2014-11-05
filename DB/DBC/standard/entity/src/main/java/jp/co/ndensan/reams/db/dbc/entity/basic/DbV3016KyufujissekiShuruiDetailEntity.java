package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KokanShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ToshiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceCode;
import java.util.Objects;

/**
 * DbV3016KyufujissekiShuruiDetailの項目定義クラスです
 *
 */
public class DbV3016KyufujissekiShuruiDetailEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV3016KyufujissekiShuruiDetail");

    private KokanShikibetsuNo kokanShikibetsuNo;
    private RString inputShikibetsuNo;
    private RString recodeShubetsuCode;
    private ShoKisaiHokenshaNo hokenshaNo;
    private KaigoHihokenshaNo hiHokenshaNo;
    private ServiceTeikyoYM serviceTeikyoYM;
    private JigyoshaNo jigyoshoNo;
    private ToshiNo toshiNo;
    private ServiceShuruiCode serviceSyuruiCode;
    private Decimal hokenRiyoshaFutangaku;
    private Decimal atoHokenTanisuTotal;
    private Decimal atoHokenSeikyugaku;
    private Decimal atoHokenDekidakaTanisuTotal;
    private ServiceCode serviceCode;
    private Decimal atoServiceTanisuTotal;
    private Decimal atotanisu;

    /**
     * getKokanShikibetsuNo
     * @return kokanShikibetsuNo
     */
    public KokanShikibetsuNo getKokanShikibetsuNo() {
        return kokanShikibetsuNo;
    }

    /**
     * setKokanShikibetsuNo
     * @param kokanShikibetsuNo kokanShikibetsuNo
     */
    public void setKokanShikibetsuNo(KokanShikibetsuNo kokanShikibetsuNo) {
        this.kokanShikibetsuNo = kokanShikibetsuNo;
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
     * getHokenshaNo
     * @return hokenshaNo
     */
    public ShoKisaiHokenshaNo getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * setHokenshaNo
     * @param hokenshaNo hokenshaNo
     */
    public void setHokenshaNo(ShoKisaiHokenshaNo hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
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
    public ServiceTeikyoYM getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * setServiceTeikyoYM
     * @param serviceTeikyoYM serviceTeikyoYM
     */
    public void setServiceTeikyoYM(ServiceTeikyoYM serviceTeikyoYM) {
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
     * getAtotanisu
     * @return atotanisu
     */
    public Decimal getAtotanisu() {
        return atotanisu;
    }

    /**
     * setAtotanisu
     * @param atotanisu atotanisu
     */
    public void setAtotanisu(Decimal atotanisu) {
        this.atotanisu = atotanisu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV3016KyufujissekiShuruiDetailEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV3016KyufujissekiShuruiDetailEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbV3016KyufujissekiShuruiDetailEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

// </editor-fold>



}
