package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT7050KaigoHokenshaの項目定義クラスです
 *
 */
public class DbT7050KaigoHokenshaEntity extends DbTableEntityBase<DbT7050KaigoHokenshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7050KaigoHokensha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private LasdecCode koikiHokenshaShichosonCode;
    private ShoKisaiHokenshaNo koikiHokenshaNo;

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
     * 広域保険者市町村コードのgetメソッドです。
     *
     * @return 広域保険者市町村コード
     */
    public LasdecCode getKoikiHokenshaShichosonCode() {
        return koikiHokenshaShichosonCode;
    }

    /**
     * 広域保険者市町村コードのsetメソッドです。
     *
     * @param koikiHokenshaShichosonCode 広域保険者市町村コード
     */
    public void setKoikiHokenshaShichosonCode(LasdecCode koikiHokenshaShichosonCode) {
        this.koikiHokenshaShichosonCode = koikiHokenshaShichosonCode;
    }

    /**
     * 広域保険者番号のgetメソッドです。
     *
     * @return 広域保険者番号
     */
    public ShoKisaiHokenshaNo getKoikiHokenshaNo() {
        return koikiHokenshaNo;
    }

    /**
     * 広域保険者番号のsetメソッドです。
     *
     * @param koikiHokenshaNo 広域保険者番号
     */
    public void setKoikiHokenshaNo(ShoKisaiHokenshaNo koikiHokenshaNo) {
        this.koikiHokenshaNo = koikiHokenshaNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7050KaigoHokenshaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT7050KaigoHokenshaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7050KaigoHokenshaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.koikiHokenshaShichosonCode, other.koikiHokenshaShichosonCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7050KaigoHokenshaEntity entity) {
        this.koikiHokenshaShichosonCode = entity.koikiHokenshaShichosonCode;
        this.koikiHokenshaNo = entity.koikiHokenshaNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(koikiHokenshaShichosonCode, koikiHokenshaNo);
    }

// </editor-fold>
}
