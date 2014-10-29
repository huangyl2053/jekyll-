package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT7057KoikiShichosonSecurityの項目定義クラスです
 *
 */
public class DbT7057KoikiShichosonSecurityEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

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
    private ShichosonShikibetsuID shichosonShikibetsuID;
    private ShichosonCode shichosonCode;

    /**
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getGroupID
     *
     * @return groupID
     */
    public RString getGroupID() {
        return groupID;
    }

    /**
     * setGroupID
     *
     * @param groupID groupID
     */
    public void setGroupID(RString groupID) {
        this.groupID = groupID;
    }

    /**
     * getShichosonShikibetsuID
     *
     * @return shichosonShikibetsuID
     */
    public ShichosonShikibetsuID getShichosonShikibetsuID() {
        return shichosonShikibetsuID;
    }

    /**
     * setShichosonShikibetsuID
     *
     * @param shichosonShikibetsuID shichosonShikibetsuID
     */
    public void setShichosonShikibetsuID(ShichosonShikibetsuID shichosonShikibetsuID) {
        this.shichosonShikibetsuID = shichosonShikibetsuID;
    }

    /**
     * getShichosonCode
     *
     * @return shichosonCode
     */
    public ShichosonCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     *
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(ShichosonCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7057KoikiShichosonSecurityEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT7057KoikiShichosonSecurityEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT7057KoikiShichosonSecurityEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.groupID, other.groupID)) {
            return false;
        }
        return true;
    }

// </editor-fold>
}
