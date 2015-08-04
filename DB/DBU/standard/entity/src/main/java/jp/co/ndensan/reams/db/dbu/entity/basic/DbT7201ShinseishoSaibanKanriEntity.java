package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShichosonCode;

/**
 * 申請書採番管理テーブルのエンティティクラスです。
 */
public class DbT7201ShinseishoSaibanKanriEntity extends DbTableEntityBase<DbT7201ShinseishoSaibanKanriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7201ShinseishoSaibanKanri");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShichosonCode shichosonCode;
    @PrimaryKey
    private FlexibleYearMonth nengetsu;
    private int currentNumber;
    private int minNumber;
    private int maxNumber;
    private int increment;

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
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    public ShichosonCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * 市町村コードのsetメソッドです。
     *
     * @param shichosonCode 市町村コード
     */
    public void setShichosonCode(ShichosonCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 年月のgetメソッドです。
     *
     * @return 年月
     */
    public FlexibleYearMonth getNengetsu() {
        return nengetsu;
    }

    /**
     * 年月のsetメソッドです。
     *
     * @param nengetsu 年月
     */
    public void setNengetsu(FlexibleYearMonth nengetsu) {
        this.nengetsu = nengetsu;
    }

    /**
     * 現在の番号のgetメソッドです。
     *
     * @return 現在の番号
     */
    public int getCurrentNumber() {
        return currentNumber;
    }

    /**
     * 現在の番号のsetメソッドです。
     *
     * @param currentNumber 現在の番号
     */
    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    /**
     * 開始番号のgetメソッドです。
     *
     * @return 開始番号
     */
    public int getMinNumber() {
        return minNumber;
    }

    /**
     * 開始番号のsetメソッドです。
     *
     * @param minNumber 開始番号
     */
    public void setMinNumber(int minNumber) {
        this.minNumber = minNumber;
    }

    /**
     * 終了番号のgetメソッドです。
     *
     * @return 終了番号
     */
    public int getMaxNumber() {
        return maxNumber;
    }

    /**
     * 終了番号のsetメソッドです。
     *
     * @param maxNumber 終了番号
     */
    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    /**
     * 増分値のgetメソッドです。
     *
     * @return 増分値
     */
    public int getIncrement() {
        return increment;
    }

    /**
     * 増分値のsetメソッドです。
     *
     * @param increment 増分値
     */
    public void setIncrement(int increment) {
        this.increment = increment;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7201ShinseishoSaibanKanriEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7201ShinseishoSaibanKanriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7201ShinseishoSaibanKanriEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.nengetsu, other.nengetsu)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7201ShinseishoSaibanKanriEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.nengetsu = entity.nengetsu;
        this.currentNumber = entity.currentNumber;
        this.minNumber = entity.minNumber;
        this.maxNumber = entity.maxNumber;
        this.increment = entity.increment;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, nengetsu, currentNumber, minNumber, maxNumber, increment);
    }

// </editor-fold>
}
