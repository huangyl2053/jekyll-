package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
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
 * DbT1009ShikakuShutokuJogaishaの項目定義クラスです
 *
 */
public class DbT1009ShikakuShutokuJogaishaEntity extends DbTableEntityBase<DbT1009ShikakuShutokuJogaishaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT1009ShikakuShutokuJogaisha");

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
    private RString shikakuShutokuJogaiRiyu;
    private FlexibleDate shikakuShutokuJogaiYMD;
    private FlexibleDate shikakuShutokuJogaiKaijoYMD;

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
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
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
    public void setRirekiNo(int rirekiNo) {
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
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 資格取得除外理由のgetメソッドです。
     *
     * @return 資格取得除外理由
     */
    public RString getShikakuShutokuJogaiRiyu() {
        return shikakuShutokuJogaiRiyu;
    }

    /**
     * 資格取得除外理由のsetメソッドです。
     *
     * @param shikakuShutokuJogaiRiyu 資格取得除外理由
     */
    public void setShikakuShutokuJogaiRiyu(RString shikakuShutokuJogaiRiyu) {
        this.shikakuShutokuJogaiRiyu = shikakuShutokuJogaiRiyu;
    }

    /**
     * 資格取得除外年月日のgetメソッドです。
     *
     * @return 資格取得除外年月日
     */
    public FlexibleDate getShikakuShutokuJogaiYMD() {
        return shikakuShutokuJogaiYMD;
    }

    /**
     * 資格取得除外年月日のsetメソッドです。
     *
     * @param shikakuShutokuJogaiYMD 資格取得除外年月日
     */
    public void setShikakuShutokuJogaiYMD(FlexibleDate shikakuShutokuJogaiYMD) {
        this.shikakuShutokuJogaiYMD = shikakuShutokuJogaiYMD;
    }

    /**
     * 資格取得除外解除年月日のgetメソッドです。
     *
     * @return 資格取得除外解除年月日
     */
    public FlexibleDate getShikakuShutokuJogaiKaijoYMD() {
        return shikakuShutokuJogaiKaijoYMD;
    }

    /**
     * 資格取得除外解除年月日のsetメソッドです。
     *
     * @param shikakuShutokuJogaiKaijoYMD 資格取得除外解除年月日
     */
    public void setShikakuShutokuJogaiKaijoYMD(FlexibleDate shikakuShutokuJogaiKaijoYMD) {
        this.shikakuShutokuJogaiKaijoYMD = shikakuShutokuJogaiKaijoYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1009ShikakuShutokuJogaishaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1009ShikakuShutokuJogaishaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1009ShikakuShutokuJogaishaEntity other) {
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
    public void shallowCopy(DbT1009ShikakuShutokuJogaishaEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.rirekiNo = entity.rirekiNo;
        this.shichosonCode = entity.shichosonCode;
        this.shikakuShutokuJogaiRiyu = entity.shikakuShutokuJogaiRiyu;
        this.shikakuShutokuJogaiYMD = entity.shikakuShutokuJogaiYMD;
        this.shikakuShutokuJogaiKaijoYMD = entity.shikakuShutokuJogaiKaijoYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, rirekiNo, shichosonCode, shikakuShutokuJogaiRiyu, shikakuShutokuJogaiYMD, shikakuShutokuJogaiKaijoYMD);
    }

// </editor-fold>
}
