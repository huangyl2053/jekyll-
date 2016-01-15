package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 構成市町村支所マスタテーブルのエンティティクラスです。
 * <br/> 構成・単独市町村単位の支所を管理する
 */
public class DbT7052KoseiShichosonShishoMasterEntity extends DbTableEntityBase<DbT7052KoseiShichosonShishoMasterEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7052KoseiShichosonShishoMaster");
    private static final long serialVersionUID = -5543964898756859270L;

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
    private ShishoCode shishoCode;
    private RString shishoMei;

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
    public void setShichosonCode(@Nonnull LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 支所コードのgetメソッドです。
     *
     * @return 支所コード
     */
    public ShishoCode getShishoCode() {
        return shishoCode;
    }

    /**
     * 支所コードのsetメソッドです。
     *
     * @param shishoCode 支所コード
     */
    public void setShishoCode(@Nonnull ShishoCode shishoCode) {
        this.shishoCode = shishoCode;
    }

    /**
     * 支所名のgetメソッドです。
     *
     * @return 支所名
     */
    @CheckForNull
    public RString getShishoMei() {
        return shishoMei;
    }

    /**
     * 支所名のsetメソッドです。
     *
     * @param shishoMei 支所名
     */
    public void setShishoMei(RString shishoMei) {
        this.shishoMei = shishoMei;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7052KoseiShichosonShishoMasterEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7052KoseiShichosonShishoMasterEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7052KoseiShichosonShishoMasterEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.shishoCode, other.shishoCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public void shallowCopy(DbT7052KoseiShichosonShishoMasterEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.shishoCode = entity.shishoCode;
        this.shishoMei = entity.shishoMei;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, shishoCode, shishoMei);
    }

// </editor-fold>
}
