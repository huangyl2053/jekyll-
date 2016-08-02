package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 介護保険施設入退所・福祉Viewテーブルのエンティティクラスです。
 */
public class DbV7504ShisetsuNyutaishoFukushiEntity extends DbTableEntityBase<DbV7504ShisetsuNyutaishoFukushiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV7504ShisetsuNyutaishoFukushi");

    private ShikibetsuCode shikibetsuCode;
    private int rirekiNo;
    private LasdecCode shichosonCode;
    private RString daichoShubetsu;
    private RString nyushoShisetsuShurui;
    private DbUDD004JigyoshaNo nyushoShisetsuCode;
    private FlexibleDate nyushoShoriYMD;
    private FlexibleDate nyushoYMD;
    private FlexibleDate taishoShoriYMD;
    private FlexibleDate taishoYMD;
    private RString roomKigoNo;

    /**
     * shikibetsuCodeのgetメソッドです。
     * 
     * @return shikibetsuCode
     */
    @CheckForNull
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
    @CheckForNull
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * rirekiNoのsetメソッドです。
     * 
     * @param rirekiNo rirekiNo
     */
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * shichosonCodeのgetメソッドです。
     * 
     * @return shichosonCode
     */
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
    public DbUDD004JigyoshaNo getNyushoShisetsuCode() {
        return nyushoShisetsuCode;
    }

    /**
     * nyushoShisetsuCodeのsetメソッドです。
     * 
     * @param nyushoShisetsuCode nyushoShisetsuCode
     */
    public void setNyushoShisetsuCode(DbUDD004JigyoshaNo nyushoShisetsuCode) {
        this.nyushoShisetsuCode = nyushoShisetsuCode;
    }

    /**
     * nyushoShoriYMDのgetメソッドです。
     * 
     * @return nyushoShoriYMD
     */
    @CheckForNull
    public FlexibleDate getNyushoShoriYMD() {
        return nyushoShoriYMD;
    }

    /**
     * nyushoShoriYMDのsetメソッドです。
     * 
     * @param nyushoShoriYMD nyushoShoriYMD
     */
    public void setNyushoShoriYMD(FlexibleDate nyushoShoriYMD) {
        this.nyushoShoriYMD = nyushoShoriYMD;
    }

    /**
     * nyushoYMDのgetメソッドです。
     * 
     * @return nyushoYMD
     */
    @CheckForNull
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
     * taishoShoriYMDのgetメソッドです。
     * 
     * @return taishoShoriYMD
     */
    @CheckForNull
    public FlexibleDate getTaishoShoriYMD() {
        return taishoShoriYMD;
    }

    /**
     * taishoShoriYMDのsetメソッドです。
     * 
     * @param taishoShoriYMD taishoShoriYMD
     */
    public void setTaishoShoriYMD(FlexibleDate taishoShoriYMD) {
        this.taishoShoriYMD = taishoShoriYMD;
    }

    /**
     * taishoYMDのgetメソッドです。
     * 
     * @return taishoYMD
     */
    @CheckForNull
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
     * roomKigoNoのgetメソッドです。
     * 
     * @return roomKigoNo
     */
    @CheckForNull
    public RString getRoomKigoNo() {
        return roomKigoNo;
    }

    /**
     * roomKigoNoのsetメソッドです。
     * 
     * @param roomKigoNo roomKigoNo
     */
    public void setRoomKigoNo(RString roomKigoNo) {
        this.roomKigoNo = roomKigoNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV7504ShisetsuNyutaishoFukushiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV7504ShisetsuNyutaishoFukushiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV7504ShisetsuNyutaishoFukushiEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV7504ShisetsuNyutaishoFukushiEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.rirekiNo = entity.rirekiNo;
        this.shichosonCode = entity.shichosonCode;
        this.daichoShubetsu = entity.daichoShubetsu;
        this.nyushoShisetsuShurui = entity.nyushoShisetsuShurui;
        this.nyushoShisetsuCode = entity.nyushoShisetsuCode;
        this.nyushoShoriYMD = entity.nyushoShoriYMD;
        this.nyushoYMD = entity.nyushoYMD;
        this.taishoShoriYMD = entity.taishoShoriYMD;
        this.taishoYMD = entity.taishoYMD;
        this.roomKigoNo = entity.roomKigoNo;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, rirekiNo, shichosonCode, daichoShubetsu, nyushoShisetsuShurui, nyushoShisetsuCode, nyushoShoriYMD, nyushoYMD, taishoShoriYMD, taishoYMD, roomKigoNo);
    }

// </editor-fold>
}
