package jp.co.ndensan.reams.db.dbz.entity.basic;

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
 * DbT7026ShinKyuHihokenshaNoHenkanの項目定義クラスです
 *
 */
public class DbT7026ShinKyuHihokenshaNoHenkanEntity extends DbTableEntityBase<DbT7026ShinKyuHihokenshaNoHenkanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7026ShinKyuHihokenshaNoHenkan");

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
    private RString shinNo;
    @PrimaryKey
    private RString kyuNo;
    private LasdecCode kyuShichosonCode;
    private RString kyuNo2;

    /**
     * getInsertDantaiCd
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * setLastUpdateReamsLoginId
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getShichosonCode
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * getShinNo
     * @return shinNo
     */
    public RString getShinNo() {
        return shinNo;
    }

    /**
     * setShinNo
     * @param shinNo shinNo
     */
    public void setShinNo(RString shinNo) {
        this.shinNo = shinNo;
    }

    /**
     * getKyuNo
     * @return kyuNo
     */
    public RString getKyuNo() {
        return kyuNo;
    }

    /**
     * setKyuNo
     * @param kyuNo kyuNo
     */
    public void setKyuNo(RString kyuNo) {
        this.kyuNo = kyuNo;
    }

    /**
     * getKyuShichosonCode
     * @return kyuShichosonCode
     */
    public LasdecCode getKyuShichosonCode() {
        return kyuShichosonCode;
    }

    /**
     * setKyuShichosonCode
     * @param kyuShichosonCode kyuShichosonCode
     */
    public void setKyuShichosonCode(LasdecCode kyuShichosonCode) {
        this.kyuShichosonCode = kyuShichosonCode;
    }

    /**
     * getKyuNo2
     * @return kyuNo2
     */
    public RString getKyuNo2() {
        return kyuNo2;
    }

    /**
     * setKyuNo2
     * @param kyuNo2 kyuNo2
     */
    public void setKyuNo2(RString kyuNo2) {
        this.kyuNo2 = kyuNo2;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7026ShinKyuHihokenshaNoHenkanEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7026ShinKyuHihokenshaNoHenkanEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7026ShinKyuHihokenshaNoHenkanEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.kyuNo, other.kyuNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7026ShinKyuHihokenshaNoHenkanEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.shinNo = entity.shinNo;
        this.kyuNo = entity.kyuNo;
        this.kyuShichosonCode = entity.kyuShichosonCode;
        this.kyuNo2 = entity.kyuNo2;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, shinNo, kyuNo, kyuShichosonCode, kyuNo2);
    }

// </editor-fold>


}
