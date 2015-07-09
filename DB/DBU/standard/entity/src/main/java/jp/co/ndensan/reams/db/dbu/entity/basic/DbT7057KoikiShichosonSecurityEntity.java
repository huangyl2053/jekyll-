package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import java.util.Objects;

/**
 * 広域市町村セキュリティテーブルのエンティティクラスです。
 */
public class DbT7057KoikiShichosonSecurityEntity extends DbTableEntityBase<DbT7057KoikiShichosonSecurityEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7057KoikiShichosonSecurity");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString groupID;
    private RString shichosonShikibetsuID;
    private LasdecCode shichosonCode;

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
     * グループIDのgetメソッドです。
     * 
     * @return グループID
     */
    public RString getGroupID() {
        return groupID;
    }

    /**
     * グループIDのsetメソッドです。
     * 
     * @param groupID グループID
     */
    public void setGroupID(RString groupID) {
        this.groupID = groupID;
    }

    /**
     * 市町村識別IDのgetメソッドです。
     * 
     * @return 市町村識別ID
     */
    public RString getShichosonShikibetsuID() {
        return shichosonShikibetsuID;
    }

    /**
     * 市町村識別IDのsetメソッドです。
     * 
     * @param shichosonShikibetsuID 市町村識別ID
     */
    public void setShichosonShikibetsuID(RString shichosonShikibetsuID) {
        this.shichosonShikibetsuID = shichosonShikibetsuID;
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
     * このエンティティの主キーが他の{@literal DbT7057KoikiShichosonSecurityEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7057KoikiShichosonSecurityEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7057KoikiShichosonSecurityEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.groupID, other.groupID)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7057KoikiShichosonSecurityEntity entity) {
        this.groupID = entity.groupID;
        this.shichosonShikibetsuID = entity.shichosonShikibetsuID;
        this.shichosonCode = entity.shichosonCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(groupID, shichosonShikibetsuID, shichosonCode);
    }

// </editor-fold>
}
