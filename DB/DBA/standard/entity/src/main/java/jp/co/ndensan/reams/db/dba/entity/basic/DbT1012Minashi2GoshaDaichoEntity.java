package jp.co.ndensan.reams.db.dba.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * みなし2号者台帳テーブルのエンティティクラスです。
 */
public class DbT1012Minashi2GoshaDaichoEntity extends DbTableEntityBase<DbT1012Minashi2GoshaDaichoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT1012Minashi2GoshaDaicho");

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
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private ShikibetsuCode shikibetsuCode;
    private RString hihokenshaKubunCode;
    private FlexibleDate minashi2GoshaTorokuYMD;
    private FlexibleDate minashi2GoshaKaijoYMD;
    private HihokenshaNo fukushiHihokenshaNo;

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
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * 市町村コードのsetメソッドです。
     *
     * @param shichosonCode 市町村コード
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
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
     * 処理日時のgetメソッドです。
     *
     * @return 処理日時
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * 処理日時のsetメソッドです。
     *
     * @param shoriTimestamp 処理日時
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
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
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 被保険者区分コードのgetメソッドです。
     *
     * @return 被保険者区分コード
     */
    public RString getHihokenshaKubunCode() {
        return hihokenshaKubunCode;
    }

    /**
     * 被保険者区分コードのsetメソッドです。
     *
     * @param hihokenshaKubunCode 被保険者区分コード
     */
    public void setHihokenshaKubunCode(RString hihokenshaKubunCode) {
        this.hihokenshaKubunCode = hihokenshaKubunCode;
    }

    /**
     * 登録年月日のgetメソッドです。
     *
     * @return 登録年月日
     */
    public FlexibleDate getMinashi2GoshaTorokuYMD() {
        return minashi2GoshaTorokuYMD;
    }

    /**
     * 登録年月日のsetメソッドです。
     *
     * @param minashi2GoshaTorokuYMD 登録年月日
     */
    public void setMinashi2GoshaTorokuYMD(FlexibleDate minashi2GoshaTorokuYMD) {
        this.minashi2GoshaTorokuYMD = minashi2GoshaTorokuYMD;
    }

    /**
     * 解除年月日のgetメソッドです。
     *
     * @return 解除年月日
     */
    public FlexibleDate getMinashi2GoshaKaijoYMD() {
        return minashi2GoshaKaijoYMD;
    }

    /**
     * 解除年月日のsetメソッドです。
     *
     * @param minashi2GoshaKaijoYMD 解除年月日
     */
    public void setMinashi2GoshaKaijoYMD(FlexibleDate minashi2GoshaKaijoYMD) {
        this.minashi2GoshaKaijoYMD = minashi2GoshaKaijoYMD;
    }

    /**
     * 福祉被保険者番号のgetメソッドです。
     *
     * @return 福祉被保険者番号
     */
    public HihokenshaNo getFukushiHihokenshaNo() {
        return fukushiHihokenshaNo;
    }

    /**
     * 福祉被保険者番号のsetメソッドです。
     *
     * @param fukushiHihokenshaNo 福祉被保険者番号
     */
    public void setFukushiHihokenshaNo(HihokenshaNo fukushiHihokenshaNo) {
        this.fukushiHihokenshaNo = fukushiHihokenshaNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1012Minashi2GoshaDaichoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1012Minashi2GoshaDaichoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1012Minashi2GoshaDaichoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
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
    public void shallowCopy(DbT1012Minashi2GoshaDaichoEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.hihokenshaKubunCode = entity.hihokenshaKubunCode;
        this.minashi2GoshaTorokuYMD = entity.minashi2GoshaTorokuYMD;
        this.minashi2GoshaKaijoYMD = entity.minashi2GoshaKaijoYMD;
        this.fukushiHihokenshaNo = entity.fukushiHihokenshaNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, hihokenshaNo, shoriTimestamp, shikibetsuCode, hihokenshaKubunCode, minashi2GoshaTorokuYMD, minashi2GoshaKaijoYMD, fukushiHihokenshaNo);
    }

// </editor-fold>
}
