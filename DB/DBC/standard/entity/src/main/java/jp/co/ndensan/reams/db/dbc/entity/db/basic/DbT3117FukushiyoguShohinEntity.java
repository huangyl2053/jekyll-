package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 福祉用具商品テーブルのエンティティクラスです。
 */
@OnNextSchema("rgdb")
public class DbT3117FukushiyoguShohinEntity extends DbTableEntityBase<DbT3117FukushiyoguShohinEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3117FukushiyoguShohin");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString shohinNo;
    @PrimaryKey
    private FlexibleDate kanriKaishiYMD;
    private FlexibleDate kanriShuryoYMD;
    private RString shohinmei;
    private RString seizoJigyoshamei;
    private RString hinmokuCode;

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
     * 商品番号のgetメソッドです。
     *
     * @return 商品番号
     */
    public RString getShohinNo() {
        return shohinNo;
    }

    /**
     * 商品番号のsetメソッドです。
     *
     * @param shohinNo 商品番号
     */
    public void setShohinNo(@Nonnull RString shohinNo) {
        this.shohinNo = shohinNo;
    }

    /**
     * 管理開始年月日のgetメソッドです。
     *
     * @return 管理開始年月日
     */
    public FlexibleDate getKanriKaishiYMD() {
        return kanriKaishiYMD;
    }

    /**
     * 管理開始年月日のsetメソッドです。
     *
     * @param kanriKaishiYMD 管理開始年月日
     */
    public void setKanriKaishiYMD(@Nonnull FlexibleDate kanriKaishiYMD) {
        this.kanriKaishiYMD = kanriKaishiYMD;
    }

    /**
     * 管理終了年月日のgetメソッドです。
     *
     * @return 管理終了年月日
     */
    @CheckForNull
    public FlexibleDate getKanriShuryoYMD() {
        return kanriShuryoYMD;
    }

    /**
     * 管理終了年月日のsetメソッドです。
     *
     * @param kanriShuryoYMD 管理終了年月日
     */
    public void setKanriShuryoYMD(FlexibleDate kanriShuryoYMD) {
        this.kanriShuryoYMD = kanriShuryoYMD;
    }

    /**
     * 商品名のgetメソッドです。
     *
     * @return 商品名
     */
    public RString getShohinmei() {
        return shohinmei;
    }

    /**
     * 商品名のsetメソッドです。
     *
     * @param shohinmei 商品名
     */
    public void setShohinmei(@Nonnull RString shohinmei) {
        this.shohinmei = shohinmei;
    }

    /**
     * 製造事業者名のgetメソッドです。
     *
     * @return 製造事業者名
     */
    @CheckForNull
    public RString getSeizoJigyoshamei() {
        return seizoJigyoshamei;
    }

    /**
     * 製造事業者名のsetメソッドです。
     *
     * @param seizoJigyoshamei 製造事業者名
     */
    public void setSeizoJigyoshamei(RString seizoJigyoshamei) {
        this.seizoJigyoshamei = seizoJigyoshamei;
    }

    /**
     * 品目コードのgetメソッドです。
     *
     * @return 品目コード
     */
    @CheckForNull
    public RString getHinmokuCode() {
        return hinmokuCode;
    }

    /**
     * 品目コードのsetメソッドです。
     *
     * @param hinmokuCode 品目コード
     */
    public void setHinmokuCode(RString hinmokuCode) {
        this.hinmokuCode = hinmokuCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3117FukushiyoguShohinEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3117FukushiyoguShohinEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3117FukushiyoguShohinEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shohinNo, other.shohinNo)) {
            return false;
        }
        if (!Objects.equals(this.kanriKaishiYMD, other.kanriKaishiYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3117FukushiyoguShohinEntity entity) {
        this.shohinNo = entity.shohinNo;
        this.kanriKaishiYMD = entity.kanriKaishiYMD;
        this.kanriShuryoYMD = entity.kanriShuryoYMD;
        this.shohinmei = entity.shohinmei;
        this.seizoJigyoshamei = entity.seizoJigyoshamei;
        this.hinmokuCode = entity.hinmokuCode;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shohinNo, kanriKaishiYMD, kanriShuryoYMD, shohinmei, seizoJigyoshamei, hinmokuCode);
    }

// </editor-fold>
}
