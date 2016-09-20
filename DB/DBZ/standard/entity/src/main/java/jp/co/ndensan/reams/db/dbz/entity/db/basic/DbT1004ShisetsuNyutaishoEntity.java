package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 介護保険施設入退所テーブルのエンティティクラスです。
 */
public class DbT1004ShisetsuNyutaishoEntity extends DbTableEntityBase<DbT1004ShisetsuNyutaishoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

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
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private int rirekiNo;
    private LasdecCode shichosonCode;
    private RString daichoShubetsu;
    private RString nyushoShisetsuShurui;
    private JigyoshaNo nyushoShisetsuCode;
    private FlexibleDate nyushoShoriYMD;
    private FlexibleDate nyushoYMD;
    private FlexibleDate taishoShoriYMD;
    private FlexibleDate taishoYMD;
    private RString roomKigoNo;
    private HokenshaNo hokenshaNo;

    /**
     * insertDantaiCdのgetメソッドです。
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * insertDantaiCdのsetメソッドです。
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * isDeletedのgetメソッドです。
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * isDeletedのsetメソッドです。
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * lastUpdateReamsLoginIdのsetメソッドです。
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     *
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(@Nonnull ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * 市町村コードのsetメソッドです。
     *
     * @param shichosonCode 市町村コード
     */
    public void setShichosonCode(@Nonnull LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 台帳種別のgetメソッドです。
     * <br/>
     * <br/>1:被保険者台帳,2:他市町村住所地特例者台帳、3:適用除外者台帳
     *
     * @return 台帳種別
     */
    public RString getDaichoShubetsu() {
        return daichoShubetsu;
    }

    /**
     * 台帳種別のsetメソッドです。
     * <br/>
     * <br/>1:被保険者台帳,2:他市町村住所地特例者台帳、3:適用除外者台帳
     *
     * @param daichoShubetsu 台帳種別
     */
    public void setDaichoShubetsu(@Nonnull RString daichoShubetsu) {
        this.daichoShubetsu = daichoShubetsu;
    }

    /**
     * 入所施設種類のgetメソッドです。
     * <br/>
     * <br/>11:介護保険施設、12:住所地特例対象施設、21:適用除外施設
     *
     * @return 入所施設種類
     */
    public RString getNyushoShisetsuShurui() {
        return nyushoShisetsuShurui;
    }

    /**
     * 入所施設種類のsetメソッドです。
     * <br/>
     * <br/>11:介護保険施設、12:住所地特例対象施設、21:適用除外施設
     *
     * @param nyushoShisetsuShurui 入所施設種類
     */
    public void setNyushoShisetsuShurui(@Nonnull RString nyushoShisetsuShurui) {
        this.nyushoShisetsuShurui = nyushoShisetsuShurui;
    }

    /**
     * 入所施設コードのgetメソッドです。
     *
     * @return 入所施設コード
     */
    public JigyoshaNo getNyushoShisetsuCode() {
        return nyushoShisetsuCode;
    }

    /**
     * 入所施設コードのsetメソッドです。
     *
     * @param nyushoShisetsuCode 入所施設コード
     */
    public void setNyushoShisetsuCode(@Nonnull JigyoshaNo nyushoShisetsuCode) {
        this.nyushoShisetsuCode = nyushoShisetsuCode;
    }

    /**
     * 入所処理年月日のgetメソッドです。
     *
     * @return 入所処理年月日
     */
    @CheckForNull
    public FlexibleDate getNyushoShoriYMD() {
        return nyushoShoriYMD;
    }

    /**
     * 入所処理年月日のsetメソッドです。
     *
     * @param nyushoShoriYMD 入所処理年月日
     */
    public void setNyushoShoriYMD(FlexibleDate nyushoShoriYMD) {
        this.nyushoShoriYMD = nyushoShoriYMD;
    }

    /**
     * 入所年月日のgetメソッドです。
     *
     * @return 入所年月日
     */
    public FlexibleDate getNyushoYMD() {
        return nyushoYMD;
    }

    /**
     * 入所年月日のsetメソッドです。
     *
     * @param nyushoYMD 入所年月日
     */
    public void setNyushoYMD(@Nonnull FlexibleDate nyushoYMD) {
        this.nyushoYMD = nyushoYMD;
    }

    /**
     * 退所処理年月日のgetメソッドです。
     *
     * @return 退所処理年月日
     */
    @CheckForNull
    public FlexibleDate getTaishoShoriYMD() {
        return taishoShoriYMD;
    }

    /**
     * 退所処理年月日のsetメソッドです。
     *
     * @param taishoShoriYMD 退所処理年月日
     */
    public void setTaishoShoriYMD(FlexibleDate taishoShoriYMD) {
        this.taishoShoriYMD = taishoShoriYMD;
    }

    /**
     * 退所年月日のgetメソッドです。
     *
     * @return 退所年月日
     */
    @CheckForNull
    public FlexibleDate getTaishoYMD() {
        return taishoYMD;
    }

    /**
     * 退所年月日のsetメソッドです。
     *
     * @param taishoYMD 退所年月日
     */
    public void setTaishoYMD(FlexibleDate taishoYMD) {
        this.taishoYMD = taishoYMD;
    }

    /**
     * 部屋記号番号のgetメソッドです。
     * <br/>
     * <br/>部屋の記号番号
     *
     * @return 部屋記号番号
     */
    @CheckForNull
    public RString getRoomKigoNo() {
        return roomKigoNo;
    }

    /**
     * 部屋記号番号のsetメソッドです。
     * <br/>
     * <br/>部屋の記号番号
     *
     * @param roomKigoNo 部屋記号番号
     */
    public void setRoomKigoNo(RString roomKigoNo) {
        this.roomKigoNo = roomKigoNo;
    }

    /**
     * 保険者番号のgetメソッドです。
     *
     * @return 保険者番号
     */
    @CheckForNull
    public HokenshaNo getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * 保険者番号のsetメソッドです。
     *
     * @param hokenshaNo 保険者番号
     */
    public void setHokenshaNo(HokenshaNo hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1004ShisetsuNyutaishoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1004ShisetsuNyutaishoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1004ShisetsuNyutaishoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT1004ShisetsuNyutaishoEntity entity) {
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
        this.hokenshaNo = entity.hokenshaNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, rirekiNo, shichosonCode, daichoShubetsu, nyushoShisetsuShurui, nyushoShisetsuCode, nyushoShoriYMD, nyushoYMD, taishoShoriYMD, taishoYMD, roomKigoNo, hokenshaNo);
    }

// </editor-fold>
}
