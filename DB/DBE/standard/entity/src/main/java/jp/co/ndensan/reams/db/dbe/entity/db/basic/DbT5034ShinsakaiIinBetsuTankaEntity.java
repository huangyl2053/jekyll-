package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 介護認定審査会委員別単価テーブルのエンティティクラスです。
 */
public class DbT5034ShinsakaiIinBetsuTankaEntity extends DbTableEntityBase<DbT5034ShinsakaiIinBetsuTankaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5034ShinsakaiIinBetsuTanka");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString ShinsakaiIinCode;
    @PrimaryKey
    private FlexibleYearMonth kaishiYM;
    @PrimaryKey
    private FlexibleYearMonth shuryoYM;
    private Decimal tanka;
    private Decimal sonotatanka;

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
     * 介護認定審査会委員コードのgetメソッドです。
     *
     * @return 介護認定審査会委員コード
     */
    public RString getShinsakaiIinCode() {
        return ShinsakaiIinCode;
    }

    /**
     * 介護認定審査会委員コードのsetメソッドです。
     *
     * @param ShinsakaiIinCode 介護認定審査会委員コード
     */
    public void setShinsakaiIinCode(@Nonnull RString ShinsakaiIinCode) {
        this.ShinsakaiIinCode = ShinsakaiIinCode;
    }

    /**
     * 開始年月のgetメソッドです。
     *
     * @return 開始年月
     */
    public FlexibleYearMonth getKaishiYM() {
        return kaishiYM;
    }

    /**
     * 開始年月のsetメソッドです。
     *
     * @param kaishiYM 開始年月
     */
    public void setKaishiYM(@Nonnull FlexibleYearMonth kaishiYM) {
        this.kaishiYM = kaishiYM;
    }

    /**
     * 終了年月のgetメソッドです。
     *
     * @return 終了年月
     */
    public FlexibleYearMonth getShuryoYM() {
        return shuryoYM;
    }

    /**
     * 終了年月のsetメソッドです。
     *
     * @param shuryoYM 終了年月
     */
    public void setShuryoYM(@Nonnull FlexibleYearMonth shuryoYM) {
        this.shuryoYM = shuryoYM;
    }

    /**
     * 単価のgetメソッドです。
     *
     * @return 単価
     */
    @CheckForNull
    public Decimal getTanka() {
        return tanka;
    }

    /**
     * 単価のsetメソッドです。
     *
     * @param tanka 単価
     */
    public void setTanka(Decimal tanka) {
        this.tanka = tanka;
    }

    /**
     * その他単価のgetメソッドです。
     *
     * @return その他単価
     */
    @CheckForNull
    public Decimal getSonotatanka() {
        return sonotatanka;
    }

    /**
     * その他単価のsetメソッドです。
     *
     * @param sonotatanka その他単価
     */
    public void setSonotatanka(Decimal sonotatanka) {
        this.sonotatanka = sonotatanka;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5034ShinsakaiIinBetsuTankaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5034ShinsakaiIinBetsuTankaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5034ShinsakaiIinBetsuTankaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.ShinsakaiIinCode, other.ShinsakaiIinCode)) {
            return false;
        }
        if (!Objects.equals(this.kaishiYM, other.kaishiYM)) {
            return false;
        }
        if (!Objects.equals(this.shuryoYM, other.shuryoYM)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5034ShinsakaiIinBetsuTankaEntity entity) {
        this.ShinsakaiIinCode = entity.ShinsakaiIinCode;
        this.kaishiYM = entity.kaishiYM;
        this.shuryoYM = entity.shuryoYM;
        this.tanka = entity.tanka;
        this.sonotatanka = entity.sonotatanka;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(ShinsakaiIinCode, kaishiYM, shuryoYM, tanka, sonotatanka);
    }

// </editor-fold>
}
