package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;

/**
 * DbT1004ShisetsuNyutaishoの項目定義クラスです
 *
 */
public class DbT1004ShisetsuNyutaishoEntity extends DbTableEntityBase<DbT1004ShisetsuNyutaishoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT1004ShisetsuNyutaisho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private LasdecCode shichosonCode;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private RString daichoShubetsu;
    private RString nyushoShisetsuShurui;
    private RString nyushoShisetsuCode;
    private FlexibleDate nyushoYMD;
    private FlexibleDate taishoYMD;
    private FlexibleDate nyushoShoriYMD;
    private FlexibleDate taishoShoriYMD;

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
     * getShichosonCode
     *
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     *
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * getShikibetsuCode
     *
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * setShikibetsuCode
     *
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getDaichoShubetsu
     *
     * @return daichoShubetsu
     */
    public RString getDaichoShubetsu() {
        return daichoShubetsu;
    }

    /**
     * setDaichoShubetsu
     *
     * @param daichoShubetsu daichoShubetsu
     */
    public void setDaichoShubetsu(RString daichoShubetsu) {
        this.daichoShubetsu = daichoShubetsu;
    }

    /**
     * getNyushoShisetsuShurui
     *
     * @return nyushoShisetsuShurui
     */
    public RString getNyushoShisetsuShurui() {
        return nyushoShisetsuShurui;
    }

    /**
     * setNyushoShisetsuShurui
     *
     * @param nyushoShisetsuShurui nyushoShisetsuShurui
     */
    public void setNyushoShisetsuShurui(RString nyushoShisetsuShurui) {
        this.nyushoShisetsuShurui = nyushoShisetsuShurui;
    }

    /**
     * getNyushoShisetsuCode
     *
     * @return nyushoShisetsuCode
     */
    public RString getNyushoShisetsuCode() {
        return nyushoShisetsuCode;
    }

    /**
     * setNyushoShisetsuCode
     *
     * @param nyushoShisetsuCode nyushoShisetsuCode
     */
    public void setNyushoShisetsuCode(RString nyushoShisetsuCode) {
        this.nyushoShisetsuCode = nyushoShisetsuCode;
    }

    /**
     * getNyushoYMD
     *
     * @return nyushoYMD
     */
    public FlexibleDate getNyushoYMD() {
        return nyushoYMD;
    }

    /**
     * setNyushoYMD
     *
     * @param nyushoYMD nyushoYMD
     */
    public void setNyushoYMD(FlexibleDate nyushoYMD) {
        this.nyushoYMD = nyushoYMD;
    }

    /**
     * getTaishoYMD
     *
     * @return taishoYMD
     */
    public FlexibleDate getTaishoYMD() {
        return taishoYMD;
    }

    /**
     * setTaishoYMD
     *
     * @param taishoYMD taishoYMD
     */
    public void setTaishoYMD(FlexibleDate taishoYMD) {
        this.taishoYMD = taishoYMD;
    }

    /**
     * getNyushoShoriYMD
     *
     * @return nyushoShoriYMD
     */
    public FlexibleDate getNyushoShoriYMD() {
        return nyushoShoriYMD;
    }

    /**
     * setNyushoShoriYMD
     *
     * @param nyushoShoriYMD nyushoShoriYMD
     */
    public void setNyushoShoriYMD(FlexibleDate nyushoShoriYMD) {
        this.nyushoShoriYMD = nyushoShoriYMD;
    }

    /**
     * getTaishoShoriYMD
     *
     * @return taishoShoriYMD
     */
    public FlexibleDate getTaishoShoriYMD() {
        return taishoShoriYMD;
    }

    /**
     * setTaishoShoriYMD
     *
     * @param taishoShoriYMD taishoShoriYMD
     */
    public void setTaishoShoriYMD(FlexibleDate taishoShoriYMD) {
        this.taishoShoriYMD = taishoShoriYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1004ShisetsuNyutaishoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1004ShisetsuNyutaishoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1004ShisetsuNyutaishoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT1004ShisetsuNyutaishoEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.daichoShubetsu = entity.daichoShubetsu;
        this.nyushoShisetsuShurui = entity.nyushoShisetsuShurui;
        this.nyushoShisetsuCode = entity.nyushoShisetsuCode;
        this.nyushoYMD = entity.nyushoYMD;
        this.taishoYMD = entity.taishoYMD;
        this.nyushoShoriYMD = entity.nyushoShoriYMD;
        this.taishoShoriYMD = entity.taishoShoriYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, shikibetsuCode, shoriTimestamp, daichoShubetsu, nyushoShisetsuShurui, nyushoShisetsuCode, nyushoYMD, taishoYMD, nyushoShoriYMD, taishoShoriYMD);
    }

// </editor-fold>
}
