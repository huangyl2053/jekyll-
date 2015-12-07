package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * DbT1008IryohokenKanyuJokyoの項目定義クラスです
 *
 */
public class DbT1008IryohokenKanyuJokyoEntity extends DbTableEntityBase<DbT1008IryohokenKanyuJokyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT1008IryohokenKanyuJokyo");

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
    private HihokenshaNo hihokenshaNo;
    private RString iryoHokenShubetsuCode;
    private RString iryoHokenshaNo;
    private RString iryoHokenshaMeisho;
    private RString iryoHokenKigoNo;
    private FlexibleDate iryoHokenKanyuYMD;
    private FlexibleDate iryoHokenDattaiYMD;

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
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    @CheckForNull
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
     * 医療保険種別コードのgetメソッドです。
     *
     * @return 医療保険種別コード
     */
    @CheckForNull
    public RString getIryoHokenShubetsuCode() {
        return iryoHokenShubetsuCode;
    }

    /**
     * 医療保険種別コードのsetメソッドです。
     *
     * @param iryoHokenShubetsuCode 医療保険種別コード
     */
    public void setIryoHokenShubetsuCode(RString iryoHokenShubetsuCode) {
        this.iryoHokenShubetsuCode = iryoHokenShubetsuCode;
    }

    /**
     * 医療保険者番号のgetメソッドです。
     *
     * @return 医療保険者番号
     */
    @CheckForNull
    public RString getIryoHokenshaNo() {
        return iryoHokenshaNo;
    }

    /**
     * 医療保険者番号のsetメソッドです。
     *
     * @param iryoHokenshaNo 医療保険者番号
     */
    public void setIryoHokenshaNo(RString iryoHokenshaNo) {
        this.iryoHokenshaNo = iryoHokenshaNo;
    }

    /**
     * 医療保険者名称のgetメソッドです。
     *
     * @return 医療保険者名称
     */
    @CheckForNull
    public RString getIryoHokenshaMeisho() {
        return iryoHokenshaMeisho;
    }

    /**
     * 医療保険者名称のsetメソッドです。
     *
     * @param iryoHokenshaMeisho 医療保険者名称
     */
    public void setIryoHokenshaMeisho(RString iryoHokenshaMeisho) {
        this.iryoHokenshaMeisho = iryoHokenshaMeisho;
    }

    /**
     * 医療保険記号番号のgetメソッドです。
     *
     * @return 医療保険記号番号
     */
    @CheckForNull
    public RString getIryoHokenKigoNo() {
        return iryoHokenKigoNo;
    }

    /**
     * 医療保険記号番号のsetメソッドです。
     *
     * @param iryoHokenKigoNo 医療保険記号番号
     */
    public void setIryoHokenKigoNo(RString iryoHokenKigoNo) {
        this.iryoHokenKigoNo = iryoHokenKigoNo;
    }

    /**
     * 医療保険加入年月日のgetメソッドです。
     *
     * @return 医療保険加入年月日
     */
    public FlexibleDate getIryoHokenKanyuYMD() {
        return iryoHokenKanyuYMD;
    }

    /**
     * 医療保険加入年月日のsetメソッドです。
     *
     * @param iryoHokenKanyuYMD 医療保険加入年月日
     */
    public void setIryoHokenKanyuYMD(@Nonnull FlexibleDate iryoHokenKanyuYMD) {
        this.iryoHokenKanyuYMD = iryoHokenKanyuYMD;
    }

    /**
     * 医療保険脱退年月日のgetメソッドです。
     *
     * @return 医療保険脱退年月日
     */
    @CheckForNull
    public FlexibleDate getIryoHokenDattaiYMD() {
        return iryoHokenDattaiYMD;
    }

    /**
     * 医療保険脱退年月日のsetメソッドです。
     *
     * @param iryoHokenDattaiYMD 医療保険脱退年月日
     */
    public void setIryoHokenDattaiYMD(FlexibleDate iryoHokenDattaiYMD) {
        this.iryoHokenDattaiYMD = iryoHokenDattaiYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1008IryohokenKanyuJokyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1008IryohokenKanyuJokyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1008IryohokenKanyuJokyoEntity other) {
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
    public void shallowCopy(DbT1008IryohokenKanyuJokyoEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.rirekiNo = entity.rirekiNo;
        this.shichosonCode = entity.shichosonCode;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.iryoHokenShubetsuCode = entity.iryoHokenShubetsuCode;
        this.iryoHokenshaNo = entity.iryoHokenshaNo;
        this.iryoHokenshaMeisho = entity.iryoHokenshaMeisho;
        this.iryoHokenKigoNo = entity.iryoHokenKigoNo;
        this.iryoHokenKanyuYMD = entity.iryoHokenKanyuYMD;
        this.iryoHokenDattaiYMD = entity.iryoHokenDattaiYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, rirekiNo, shichosonCode, hihokenshaNo, iryoHokenShubetsuCode, iryoHokenshaNo, iryoHokenshaMeisho, iryoHokenKigoNo, iryoHokenKanyuYMD, iryoHokenDattaiYMD);
    }

// </editor-fold>
}
