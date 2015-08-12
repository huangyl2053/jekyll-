package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbV3104KokuhorenTorikomiJohoの項目定義クラスです
 *
 */
public class DbV3104KokuhorenTorikomiJohoEntity extends DbTableEntityBase<DbV3104KokuhorenTorikomiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbV3104KokuhorenTorikomiJoho");

    private FlexibleYearMonth shoriYM;
    private RString kokanShikibetsuNo;
    private RString shoriJotaiKubun;
    private RString zen_shorijotaikubun;
    private RString zenzen_shorijotaikubun;
    private YMDHMS tougetsushoridate;
    private boolean saiShoriKahiKubun;

    /**
     * shoriYMのgetメソッドです。
     *
     * @return shoriYM
     */
    public FlexibleYearMonth getShoriYM() {
        return shoriYM;
    }

    /**
     * shoriYMのsetメソッドです。
     *
     * @param shoriYM shoriYM
     */
    public void setShoriYM(FlexibleYearMonth shoriYM) {
        this.shoriYM = shoriYM;
    }

    /**
     * kokanShikibetsuNoのgetメソッドです。
     *
     * @return kokanShikibetsuNo
     */
    public RString getKokanShikibetsuNo() {
        return kokanShikibetsuNo;
    }

    /**
     * kokanShikibetsuNoのsetメソッドです。
     *
     * @param kokanShikibetsuNo kokanShikibetsuNo
     */
    public void setKokanShikibetsuNo(RString kokanShikibetsuNo) {
        this.kokanShikibetsuNo = kokanShikibetsuNo;
    }

    /**
     * shoriJotaiKubunのgetメソッドです。
     *
     * @return shoriJotaiKubun
     */
    public RString getShoriJotaiKubun() {
        return shoriJotaiKubun;
    }

    /**
     * shoriJotaiKubunのsetメソッドです。
     *
     * @param shoriJotaiKubun shoriJotaiKubun
     */
    public void setShoriJotaiKubun(RString shoriJotaiKubun) {
        this.shoriJotaiKubun = shoriJotaiKubun;
    }

    /**
     * zen_shorijotaikubunのgetメソッドです。
     *
     * @return zen_shorijotaikubun
     */
    public RString getZen_shorijotaikubun() {
        return zen_shorijotaikubun;
    }

    /**
     * zen_shorijotaikubunのsetメソッドです。
     *
     * @param zen_shorijotaikubun zen_shorijotaikubun
     */
    public void setZen_shorijotaikubun(RString zen_shorijotaikubun) {
        this.zen_shorijotaikubun = zen_shorijotaikubun;
    }

    /**
     * zenzen_shorijotaikubunのgetメソッドです。
     *
     * @return zenzen_shorijotaikubun
     */
    public RString getZenzen_shorijotaikubun() {
        return zenzen_shorijotaikubun;
    }

    /**
     * zenzen_shorijotaikubunのsetメソッドです。
     *
     * @param zenzen_shorijotaikubun zenzen_shorijotaikubun
     */
    public void setZenzen_shorijotaikubun(RString zenzen_shorijotaikubun) {
        this.zenzen_shorijotaikubun = zenzen_shorijotaikubun;
    }

    /**
     * tougetsushoridateのgetメソッドです。
     *
     * @return tougetsushoridate
     */
    public YMDHMS getTougetsushoridate() {
        return tougetsushoridate;
    }

    /**
     * tougetsushoridateのsetメソッドです。
     *
     * @param tougetsushoridate tougetsushoridate
     */
    public void setTougetsushoridate(YMDHMS tougetsushoridate) {
        this.tougetsushoridate = tougetsushoridate;
    }

    /**
     * saiShoriKahiKubunのgetメソッドです。
     *
     * @return saiShoriKahiKubun
     */
    public boolean getSaiShoriKahiKubun() {
        return saiShoriKahiKubun;
    }

    /**
     * saiShoriKahiKubunのsetメソッドです。
     *
     * @param saiShoriKahiKubun saiShoriKahiKubun
     */
    public void setSaiShoriKahiKubun(boolean saiShoriKahiKubun) {
        this.saiShoriKahiKubun = saiShoriKahiKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV3104KokuhorenTorikomiJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbV3104KokuhorenTorikomiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV3104KokuhorenTorikomiJohoEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV3104KokuhorenTorikomiJohoEntity entity) {
        this.shoriYM = entity.shoriYM;
        this.kokanShikibetsuNo = entity.kokanShikibetsuNo;
        this.shoriJotaiKubun = entity.shoriJotaiKubun;
        this.zen_shorijotaikubun = entity.zen_shorijotaikubun;
        this.zenzen_shorijotaikubun = entity.zenzen_shorijotaikubun;
        this.tougetsushoridate = entity.tougetsushoridate;
        this.saiShoriKahiKubun = entity.saiShoriKahiKubun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoriYM, kokanShikibetsuNo, shoriJotaiKubun, zen_shorijotaikubun, zenzen_shorijotaikubun, tougetsushoridate, saiShoriKahiKubun);
    }

// </editor-fold>
}
