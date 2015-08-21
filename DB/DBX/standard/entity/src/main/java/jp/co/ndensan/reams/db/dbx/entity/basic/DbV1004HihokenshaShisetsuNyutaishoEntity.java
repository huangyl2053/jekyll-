package jp.co.ndensan.reams.db.dbx.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DbV1004HihokenshaShisetsuNyutaishoテーブルのエンティティクラスです。
 */
public class DbV1004HihokenshaShisetsuNyutaishoEntity extends DbTableEntityBase<DbV1004HihokenshaShisetsuNyutaishoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbV1004HihokenshaShisetsuNyutaisho");

    private ShikibetsuCode shikibetsuCode;
    private Decimal rirekiNo;
    private LasdecCode shichosonCode;
    private RString daichoShubetsu;
    private RString nyushoShisetsuShurui;
    private KaigoJigyoshaNo nyushoShisetsuCode;
    private FlexibleDate nyushoYMD;
    private FlexibleDate taishoYMD;

    /**
     * shikibetsuCodeのgetメソッドです。
     *
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * shikibetsuCodeのsetメソッドです。
     *
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * rirekiNoのgetメソッドです。
     *
     * @return rirekiNo
     */
    public Decimal getRirekiNo() {
        return rirekiNo;
    }

    /**
     * rirekiNoのsetメソッドです。
     *
     * @param rirekiNo rirekiNo
     */
    public void setRirekiNo(Decimal rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * shichosonCodeのgetメソッドです。
     *
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * shichosonCodeのsetメソッドです。
     *
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * daichoShubetsuのgetメソッドです。
     *
     * @return daichoShubetsu
     */
    public RString getDaichoShubetsu() {
        return daichoShubetsu;
    }

    /**
     * daichoShubetsuのsetメソッドです。
     *
     * @param daichoShubetsu daichoShubetsu
     */
    public void setDaichoShubetsu(RString daichoShubetsu) {
        this.daichoShubetsu = daichoShubetsu;
    }

    /**
     * nyushoShisetsuShuruiのgetメソッドです。
     *
     * @return nyushoShisetsuShurui
     */
    public RString getNyushoShisetsuShurui() {
        return nyushoShisetsuShurui;
    }

    /**
     * nyushoShisetsuShuruiのsetメソッドです。
     *
     * @param nyushoShisetsuShurui nyushoShisetsuShurui
     */
    public void setNyushoShisetsuShurui(RString nyushoShisetsuShurui) {
        this.nyushoShisetsuShurui = nyushoShisetsuShurui;
    }

    /**
     * nyushoShisetsuCodeのgetメソッドです。
     *
     * @return nyushoShisetsuCode
     */
    public KaigoJigyoshaNo getNyushoShisetsuCode() {
        return nyushoShisetsuCode;
    }

    /**
     * nyushoShisetsuCodeのsetメソッドです。
     *
     * @param nyushoShisetsuCode nyushoShisetsuCode
     */
    public void setNyushoShisetsuCode(KaigoJigyoshaNo nyushoShisetsuCode) {
        this.nyushoShisetsuCode = nyushoShisetsuCode;
    }

    /**
     * nyushoYMDのgetメソッドです。
     *
     * @return nyushoYMD
     */
    public FlexibleDate getNyushoYMD() {
        return nyushoYMD;
    }

    /**
     * nyushoYMDのsetメソッドです。
     *
     * @param nyushoYMD nyushoYMD
     */
    public void setNyushoYMD(FlexibleDate nyushoYMD) {
        this.nyushoYMD = nyushoYMD;
    }

    /**
     * taishoYMDのgetメソッドです。
     *
     * @return taishoYMD
     */
    public FlexibleDate getTaishoYMD() {
        return taishoYMD;
    }

    /**
     * taishoYMDのsetメソッドです。
     *
     * @param taishoYMD taishoYMD
     */
    public void setTaishoYMD(FlexibleDate taishoYMD) {
        this.taishoYMD = taishoYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV1004HihokenshaShisetsuNyutaishoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbV1004HihokenshaShisetsuNyutaishoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV1004HihokenshaShisetsuNyutaishoEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV1004HihokenshaShisetsuNyutaishoEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.rirekiNo = entity.rirekiNo;
        this.shichosonCode = entity.shichosonCode;
        this.daichoShubetsu = entity.daichoShubetsu;
        this.nyushoShisetsuShurui = entity.nyushoShisetsuShurui;
        this.nyushoShisetsuCode = entity.nyushoShisetsuCode;
        this.nyushoYMD = entity.nyushoYMD;
        this.taishoYMD = entity.taishoYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, rirekiNo, shichosonCode, daichoShubetsu, nyushoShisetsuShurui, nyushoShisetsuCode, nyushoYMD, taishoYMD);
    }

// </editor-fold>
}
