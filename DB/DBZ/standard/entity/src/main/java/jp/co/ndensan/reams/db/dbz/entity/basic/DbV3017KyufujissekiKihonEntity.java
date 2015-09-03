package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbV3017KyufujissekiKihonテーブルのエンティティクラスです。
 */
public class DbV3017KyufujissekiKihonEntity extends DbTableEntityBase<DbV3017KyufujissekiKihonEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbV3017KyufujissekiKihon");

    private ShikibetsuCode kokanShikibetsuNo;
    private ShikibetsuCode inputShikibetsuNo;
    private RString recodeShubetsuCode;
    private HokenshaNo hokenshaNo;
    private HihokenshaNo hiHokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private JigyoshaNo jigyoshoNo;
    private RString kyufuSakuseiKubunCode;
    private RString kyufuJissekiKubunCode;
    private RString toshiNo;

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
     * kyufuSakuseiKubunCodeのgetメソッドです。
     *
     * @return kyufuSakuseiKubunCode
     */
    public RString getKyufuSakuseiKubunCode() {
        return kyufuSakuseiKubunCode;
    }

    /**
     * kyufuSakuseiKubunCodeのsetメソッドです。
     *
     * @param kyufuSakuseiKubunCode kyufuSakuseiKubunCode
     */
    public void setKyufuSakuseiKubunCode(RString kyufuSakuseiKubunCode) {
        this.kyufuSakuseiKubunCode = kyufuSakuseiKubunCode;
    }

    /**
     * kyufuJissekiKubunCodeのgetメソッドです。
     *
     * @return kyufuJissekiKubunCode
     */
    public RString getKyufuJissekiKubunCode() {
        return kyufuJissekiKubunCode;
    }

    /**
     * kyufuJissekiKubunCodeのsetメソッドです。
     *
     * @param kyufuJissekiKubunCode kyufuJissekiKubunCode
     */
    public void setKyufuJissekiKubunCode(RString kyufuJissekiKubunCode) {
        this.kyufuJissekiKubunCode = kyufuJissekiKubunCode;
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
     * このエンティティの主キーが他の{@literal DbV3017KyufujissekiKihonEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbV3017KyufujissekiKihonEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV3017KyufujissekiKihonEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV3017KyufujissekiKihonEntity entity) {
        this.kokanShikibetsuNo = entity.kokanShikibetsuNo;
        this.inputShikibetsuNo = entity.inputShikibetsuNo;
        this.recodeShubetsuCode = entity.recodeShubetsuCode;
        this.hokenshaNo = entity.hokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.kyufuSakuseiKubunCode = entity.kyufuSakuseiKubunCode;
        this.kyufuJissekiKubunCode = entity.kyufuJissekiKubunCode;
        this.toshiNo = entity.toshiNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kokanShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, hokenshaNo, hiHokenshaNo, serviceTeikyoYM, jigyoshoNo, kyufuSakuseiKubunCode, kyufuJissekiKubunCode, toshiNo);
    }

// </editor-fold>
}
