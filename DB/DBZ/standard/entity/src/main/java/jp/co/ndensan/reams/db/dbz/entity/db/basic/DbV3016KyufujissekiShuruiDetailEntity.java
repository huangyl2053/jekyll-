package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbV3016KyufujissekiShuruiDetailテーブルのエンティティクラスです。
 */
public class DbV3016KyufujissekiShuruiDetailEntity extends DbTableEntityBase<DbV3016KyufujissekiShuruiDetailEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbV3016KyufujissekiShuruiDetail");

    private ShikibetsuCode kokanShikibetsuNo;
    private ShikibetsuCode inputShikibetsuNo;
    private RString recodeShubetsuCode;
    private HokenshaNo hokenshaNo;
    private HihokenshaNo hiHokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private JigyoshaNo jigyoshoNo;
    private RString toshiNo;
    private ServiceShuruiCode serviceSyuruiCode;
    private int hokenRiyoshaFutangaku;
    private int atoHokenTanisuTotal;
    private RString atoHokenSeikyugaku;
    private int atoHokenDekidakaTanisuTotal;
    private ServiceCode serviceCode;
    private int atoServiceTanisuTotal;
    private int atotanisu;

    /**
     * kokanShikibetsuNoのgetメソッドです。
     *
     * @return kokanShikibetsuNo
     */
    public ShikibetsuCode getKokanShikibetsuNo() {
        return kokanShikibetsuNo;
    }

    /**
     * kokanShikibetsuNoのsetメソッドです。
     *
     * @param kokanShikibetsuNo kokanShikibetsuNo
     */
    public void setKokanShikibetsuNo(ShikibetsuCode kokanShikibetsuNo) {
        this.kokanShikibetsuNo = kokanShikibetsuNo;
    }

    /**
     * inputShikibetsuNoのgetメソッドです。
     *
     * @return inputShikibetsuNo
     */
    public ShikibetsuCode getInputShikibetsuNo() {
        return inputShikibetsuNo;
    }

    /**
     * inputShikibetsuNoのsetメソッドです。
     *
     * @param inputShikibetsuNo inputShikibetsuNo
     */
    public void setInputShikibetsuNo(ShikibetsuCode inputShikibetsuNo) {
        this.inputShikibetsuNo = inputShikibetsuNo;
    }

    /**
     * recodeShubetsuCodeのgetメソッドです。
     *
     * @return recodeShubetsuCode
     */
    public RString getRecodeShubetsuCode() {
        return recodeShubetsuCode;
    }

    /**
     * recodeShubetsuCodeのsetメソッドです。
     *
     * @param recodeShubetsuCode recodeShubetsuCode
     */
    public void setRecodeShubetsuCode(RString recodeShubetsuCode) {
        this.recodeShubetsuCode = recodeShubetsuCode;
    }

    /**
     * hokenshaNoのgetメソッドです。
     *
     * @return hokenshaNo
     */
    public HokenshaNo getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * hokenshaNoのsetメソッドです。
     *
     * @param hokenshaNo hokenshaNo
     */
    public void setHokenshaNo(HokenshaNo hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
    }

    /**
     * hiHokenshaNoのgetメソッドです。
     *
     * @return hiHokenshaNo
     */
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * hiHokenshaNoのsetメソッドです。
     *
     * @param hiHokenshaNo hiHokenshaNo
     */
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * serviceTeikyoYMのgetメソッドです。
     *
     * @return serviceTeikyoYM
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * serviceTeikyoYMのsetメソッドです。
     *
     * @param serviceTeikyoYM serviceTeikyoYM
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * jigyoshoNoのgetメソッドです。
     *
     * @return jigyoshoNo
     */
    public JigyoshaNo getJigyoshoNo() {
        return jigyoshoNo;
    }

    /**
     * jigyoshoNoのsetメソッドです。
     *
     * @param jigyoshoNo jigyoshoNo
     */
    public void setJigyoshoNo(JigyoshaNo jigyoshoNo) {
        this.jigyoshoNo = jigyoshoNo;
    }

    /**
     * toshiNoのgetメソッドです。
     *
     * @return toshiNo
     */
    public RString getToshiNo() {
        return toshiNo;
    }

    /**
     * toshiNoのsetメソッドです。
     *
     * @param toshiNo toshiNo
     */
    public void setToshiNo(RString toshiNo) {
        this.toshiNo = toshiNo;
    }

    /**
     * serviceSyuruiCodeのgetメソッドです。
     *
     * @return serviceSyuruiCode
     */
    public ServiceShuruiCode getServiceSyuruiCode() {
        return serviceSyuruiCode;
    }

    /**
     * serviceSyuruiCodeのsetメソッドです。
     *
     * @param serviceSyuruiCode serviceSyuruiCode
     */
    public void setServiceSyuruiCode(ServiceShuruiCode serviceSyuruiCode) {
        this.serviceSyuruiCode = serviceSyuruiCode;
    }

    /**
     * hokenRiyoshaFutangakuのgetメソッドです。
     *
     * @return hokenRiyoshaFutangaku
     */
    public int getHokenRiyoshaFutangaku() {
        return hokenRiyoshaFutangaku;
    }

    /**
     * hokenRiyoshaFutangakuのsetメソッドです。
     *
     * @param hokenRiyoshaFutangaku hokenRiyoshaFutangaku
     */
    public void setHokenRiyoshaFutangaku(int hokenRiyoshaFutangaku) {
        this.hokenRiyoshaFutangaku = hokenRiyoshaFutangaku;
    }

    /**
     * atoHokenTanisuTotalのgetメソッドです。
     *
     * @return atoHokenTanisuTotal
     */
    public int getAtoHokenTanisuTotal() {
        return atoHokenTanisuTotal;
    }

    /**
     * atoHokenTanisuTotalのsetメソッドです。
     *
     * @param atoHokenTanisuTotal atoHokenTanisuTotal
     */
    public void setAtoHokenTanisuTotal(int atoHokenTanisuTotal) {
        this.atoHokenTanisuTotal = atoHokenTanisuTotal;
    }

    /**
     * atoHokenSeikyugakuのgetメソッドです。
     *
     * @return atoHokenSeikyugaku
     */
    public RString getAtoHokenSeikyugaku() {
        return atoHokenSeikyugaku;
    }

    /**
     * atoHokenSeikyugakuのsetメソッドです。
     *
     * @param atoHokenSeikyugaku atoHokenSeikyugaku
     */
    public void setAtoHokenSeikyugaku(RString atoHokenSeikyugaku) {
        this.atoHokenSeikyugaku = atoHokenSeikyugaku;
    }

    /**
     * atoHokenDekidakaTanisuTotalのgetメソッドです。
     *
     * @return atoHokenDekidakaTanisuTotal
     */
    public int getAtoHokenDekidakaTanisuTotal() {
        return atoHokenDekidakaTanisuTotal;
    }

    /**
     * atoHokenDekidakaTanisuTotalのsetメソッドです。
     *
     * @param atoHokenDekidakaTanisuTotal atoHokenDekidakaTanisuTotal
     */
    public void setAtoHokenDekidakaTanisuTotal(int atoHokenDekidakaTanisuTotal) {
        this.atoHokenDekidakaTanisuTotal = atoHokenDekidakaTanisuTotal;
    }

    /**
     * serviceCodeのgetメソッドです。
     *
     * @return serviceCode
     */
    public ServiceCode getServiceCode() {
        return serviceCode;
    }

    /**
     * serviceCodeのsetメソッドです。
     *
     * @param serviceCode serviceCode
     */
    public void setServiceCode(ServiceCode serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * atoServiceTanisuTotalのgetメソッドです。
     *
     * @return atoServiceTanisuTotal
     */
    public int getAtoServiceTanisuTotal() {
        return atoServiceTanisuTotal;
    }

    /**
     * atoServiceTanisuTotalのsetメソッドです。
     *
     * @param atoServiceTanisuTotal atoServiceTanisuTotal
     */
    public void setAtoServiceTanisuTotal(int atoServiceTanisuTotal) {
        this.atoServiceTanisuTotal = atoServiceTanisuTotal;
    }

    /**
     * atotanisuのgetメソッドです。
     *
     * @return atotanisu
     */
    public int getAtotanisu() {
        return atotanisu;
    }

    /**
     * atotanisuのsetメソッドです。
     *
     * @param atotanisu atotanisu
     */
    public void setAtotanisu(int atotanisu) {
        this.atotanisu = atotanisu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV3016KyufujissekiShuruiDetailEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbV3016KyufujissekiShuruiDetailEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV3016KyufujissekiShuruiDetailEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV3016KyufujissekiShuruiDetailEntity entity) {
        this.kokanShikibetsuNo = entity.kokanShikibetsuNo;
        this.inputShikibetsuNo = entity.inputShikibetsuNo;
        this.recodeShubetsuCode = entity.recodeShubetsuCode;
        this.hokenshaNo = entity.hokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.toshiNo = entity.toshiNo;
        this.serviceSyuruiCode = entity.serviceSyuruiCode;
        this.hokenRiyoshaFutangaku = entity.hokenRiyoshaFutangaku;
        this.atoHokenTanisuTotal = entity.atoHokenTanisuTotal;
        this.atoHokenSeikyugaku = entity.atoHokenSeikyugaku;
        this.atoHokenDekidakaTanisuTotal = entity.atoHokenDekidakaTanisuTotal;
        this.serviceCode = entity.serviceCode;
        this.atoServiceTanisuTotal = entity.atoServiceTanisuTotal;
        this.atotanisu = entity.atotanisu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kokanShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, hokenshaNo, hiHokenshaNo, serviceTeikyoYM, jigyoshoNo, toshiNo, serviceSyuruiCode, hokenRiyoshaFutangaku, atoHokenTanisuTotal, atoHokenSeikyugaku, atoHokenDekidakaTanisuTotal, serviceCode, atoServiceTanisuTotal, atotanisu);
    }

// </editor-fold>
}
