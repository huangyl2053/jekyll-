package jp.co.ndensan.reams.db.dbb.entity.db.basic.rentainofugimusha;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 連帯納付義務者テーブルのエンティティクラスです。
 */
public class DbT2009RentaiGimushaEntity extends DbTableEntityBase<DbT2009RentaiGimushaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT2009RentaiGimusha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private Decimal rirekiNo;
    private ShikibetsuCode shikibetuCode;
    private FlexibleDate startYMD;
    private FlexibleDate endYMD;

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
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public Decimal getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(Decimal rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 識別コードのgetメソッドです。
     * <br/>
     * <br/>連帯納付義務者の識別コード
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetuCode() {
        return shikibetuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     * <br/>
     * <br/>連帯納付義務者の識別コード
     *
     * @param shikibetuCode 識別コード
     */
    public void setShikibetuCode(ShikibetsuCode shikibetuCode) {
        this.shikibetuCode = shikibetuCode;
    }

    /**
     * 開始年月日のgetメソッドです。
     *
     * @return 開始年月日
     */
    public FlexibleDate getStartYMD() {
        return startYMD;
    }

    /**
     * 開始年月日のsetメソッドです。
     *
     * @param startYMD 開始年月日
     */
    public void setStartYMD(FlexibleDate startYMD) {
        this.startYMD = startYMD;
    }

    /**
     * 終了年月日のgetメソッドです。
     *
     * @return 終了年月日
     */
    public FlexibleDate getEndYMD() {
        return endYMD;
    }

    /**
     * 終了年月日のsetメソッドです。
     *
     * @param endYMD 終了年月日
     */
    public void setEndYMD(FlexibleDate endYMD) {
        this.endYMD = endYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2009RentaiGimushaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT2009RentaiGimushaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2009RentaiGimushaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
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
    public void shallowCopy(DbT2009RentaiGimushaEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.shikibetuCode = entity.shikibetuCode;
        this.startYMD = entity.startYMD;
        this.endYMD = entity.endYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, rirekiNo, shikibetuCode, startYMD, endYMD);
    }

// </editor-fold>
}
