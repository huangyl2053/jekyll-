package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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
 * DbT7003BemmeishaJohoの項目定義クラスです
 *
 */
public class DbT7003BemmeishaJohoEntity extends DbTableEntityBase<DbT7003BemmeishaJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7003BemmeishaJoho");

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
    private HihokenshaNo genshobunHihokenshaNo;
    @PrimaryKey
    private FlexibleDate shinsaseikyuTodokedeYMD;
    @PrimaryKey
    private FlexibleDate bemmeishoSakuseiYMD;
    @PrimaryKey
    private int bemmeishaEdaban;
    private LasdecCode shichosonCode;
    private RString bemmeisha;

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
     * 原処分被保険者番号のgetメソッドです。
     *
     * @return 原処分被保険者番号
     */
    public HihokenshaNo getGenshobunHihokenshaNo() {
        return genshobunHihokenshaNo;
    }

    /**
     * 原処分被保険者番号のsetメソッドです。
     *
     * @param genshobunHihokenshaNo 原処分被保険者番号
     */
    public void setGenshobunHihokenshaNo(@Nonnull HihokenshaNo genshobunHihokenshaNo) {
        this.genshobunHihokenshaNo = genshobunHihokenshaNo;
    }

    /**
     * 審査請求届出日のgetメソッドです。
     *
     * @return 審査請求届出日
     */
    public FlexibleDate getShinsaseikyuTodokedeYMD() {
        return shinsaseikyuTodokedeYMD;
    }

    /**
     * 審査請求届出日のsetメソッドです。
     *
     * @param shinsaseikyuTodokedeYMD 審査請求届出日
     */
    public void setShinsaseikyuTodokedeYMD(@Nonnull FlexibleDate shinsaseikyuTodokedeYMD) {
        this.shinsaseikyuTodokedeYMD = shinsaseikyuTodokedeYMD;
    }

    /**
     * 弁明書作成日のgetメソッドです。
     *
     * @return 弁明書作成日
     */
    public FlexibleDate getBemmeishoSakuseiYMD() {
        return bemmeishoSakuseiYMD;
    }

    /**
     * 弁明書作成日のsetメソッドです。
     *
     * @param bemmeishoSakuseiYMD 弁明書作成日
     */
    public void setBemmeishoSakuseiYMD(@Nonnull FlexibleDate bemmeishoSakuseiYMD) {
        this.bemmeishoSakuseiYMD = bemmeishoSakuseiYMD;
    }

    /**
     * 弁明者枝番のgetメソッドです。
     *
     * @return 弁明者枝番
     */
    public int getBemmeishaEdaban() {
        return bemmeishaEdaban;
    }

    /**
     * 弁明者枝番のsetメソッドです。
     *
     * @param bemmeishaEdaban 弁明者枝番
     */
    public void setBemmeishaEdaban(@Nonnull int bemmeishaEdaban) {
        this.bemmeishaEdaban = bemmeishaEdaban;
    }

    /**
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    @CheckForNull
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
     * 弁明者のgetメソッドです。
     *
     * @return 弁明者
     */
    @CheckForNull
    public RString getBemmeisha() {
        return bemmeisha;
    }

    /**
     * 弁明者のsetメソッドです。
     *
     * @param bemmeisha 弁明者
     */
    public void setBemmeisha(RString bemmeisha) {
        this.bemmeisha = bemmeisha;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7003BemmeishaJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal DbT7003BemmeishaJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7003BemmeishaJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.genshobunHihokenshaNo, other.genshobunHihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shinsaseikyuTodokedeYMD, other.shinsaseikyuTodokedeYMD)) {
            return false;
        }
        if (!Objects.equals(this.bemmeishoSakuseiYMD, other.bemmeishoSakuseiYMD)) {
            return false;
        }
        if (this.bemmeishaEdaban != other.bemmeishaEdaban) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7003BemmeishaJohoEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.genshobunHihokenshaNo = entity.genshobunHihokenshaNo;
        this.shinsaseikyuTodokedeYMD = entity.shinsaseikyuTodokedeYMD;
        this.bemmeishoSakuseiYMD = entity.bemmeishoSakuseiYMD;
        this.bemmeishaEdaban = entity.bemmeishaEdaban;
        this.shichosonCode = entity.shichosonCode;
        this.bemmeisha = entity.bemmeisha;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, genshobunHihokenshaNo, shinsaseikyuTodokedeYMD, bemmeishoSakuseiYMD, bemmeishaEdaban, shichosonCode, bemmeisha);
    }

// </editor-fold>
}
