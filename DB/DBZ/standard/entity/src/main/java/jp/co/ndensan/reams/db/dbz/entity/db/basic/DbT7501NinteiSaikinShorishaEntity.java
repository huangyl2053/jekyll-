package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import java.util.Objects;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;

/**
 * DbT7051認定最近処理者テーブルのエンティティクラスです。
 */
public class DbT7501NinteiSaikinShorishaEntity extends DbTableEntityBase<DbT7501NinteiSaikinShorishaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7501NinteiSaikinShorisha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString reamsLoginId;
    @PrimaryKey
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private RString hihokenshaNo;
    private RString hihokenshaName;

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
     * ユーザーIDのgetメソッドです。
     *
     * @return ユーザーID
     */
    public RString getReamsLoginId() {
        return reamsLoginId;
    }

    /**
     * ユーザーIDのsetメソッドです。
     *
     * @param reamsLoginId ユーザーID
     */
    public void setReamsLoginId(@Nonnull RString reamsLoginId) {
        this.reamsLoginId = reamsLoginId;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(@Nonnull ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(@Nonnull RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 被保険者氏名のgetメソッドです。
     *
     * @return 被保険者氏名
     */
    public RString getHihokenshaName() {
        return hihokenshaName;
    }

    /**
     * 被保険者氏名のsetメソッドです。
     *
     * @param hihokenshaName 被保険者氏名
     */
    public void setHihokenshaName(@Nonnull RString hihokenshaName) {
        this.hihokenshaName = hihokenshaName;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7501NinteiSaikinShorishaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7501NinteiSaikinShorishaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7501NinteiSaikinShorishaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.reamsLoginId, other.reamsLoginId)) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7501NinteiSaikinShorishaEntity entity) {
        this.reamsLoginId = entity.reamsLoginId;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.hihokenshaName = entity.hihokenshaName;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(reamsLoginId, shoKisaiHokenshaNo, hihokenshaNo, hihokenshaName);
    }

// </editor-fold>
    public DbT7501NinteiSaikinShorishaEntity() {
    }

    public DbT7501NinteiSaikinShorishaEntity(RString reamsLoginId, ShoKisaiHokenshaNo shoKisaiHokenshaNo, RString hihokenshaNo, RString hihokenshaName) {
        this.reamsLoginId = reamsLoginId;
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaName = hihokenshaName;
    }

}
