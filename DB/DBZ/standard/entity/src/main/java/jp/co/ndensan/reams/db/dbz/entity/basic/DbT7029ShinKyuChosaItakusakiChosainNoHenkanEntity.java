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
 * DbT7029ShinKyuChosaItakusakiChosainNoHenkanの項目定義クラスです
 *
 */
public class DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity extends DbTableEntityBase<DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7029ShinKyuChosaItakusakiChosainNoHenkan");

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
    private RString shinChosaItakusakiNo;
    private RString shinChosainNo;
    @PrimaryKey
    private RString kyuChosaItakusakiNo;
    @PrimaryKey
    private RString kyuChosainNo;
    private LasdecCode shichosonCode2;
    private RString kyuChosaItakusakiNo2;
    private RString kyuChosainNo2;

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
     * getShinChosaItakusakiNo
     * @return shinChosaItakusakiNo
     */
    public RString getShinChosaItakusakiNo() {
        return shinChosaItakusakiNo;
    }

    /**
     * setShinChosaItakusakiNo
     * @param shinChosaItakusakiNo shinChosaItakusakiNo
     */
    public void setShinChosaItakusakiNo(RString shinChosaItakusakiNo) {
        this.shinChosaItakusakiNo = shinChosaItakusakiNo;
    }

    /**
     * getShinChosainNo
     * @return shinChosainNo
     */
    public RString getShinChosainNo() {
        return shinChosainNo;
    }

    /**
     * setShinChosainNo
     * @param shinChosainNo shinChosainNo
     */
    public void setShinChosainNo(RString shinChosainNo) {
        this.shinChosainNo = shinChosainNo;
    }

    /**
     * getKyuChosaItakusakiNo
     * @return kyuChosaItakusakiNo
     */
    public RString getKyuChosaItakusakiNo() {
        return kyuChosaItakusakiNo;
    }

    /**
     * setKyuChosaItakusakiNo
     * @param kyuChosaItakusakiNo kyuChosaItakusakiNo
     */
    public void setKyuChosaItakusakiNo(RString kyuChosaItakusakiNo) {
        this.kyuChosaItakusakiNo = kyuChosaItakusakiNo;
    }

    /**
     * getKyuChosainNo
     * @return kyuChosainNo
     */
    public RString getKyuChosainNo() {
        return kyuChosainNo;
    }

    /**
     * setKyuChosainNo
     * @param kyuChosainNo kyuChosainNo
     */
    public void setKyuChosainNo(RString kyuChosainNo) {
        this.kyuChosainNo = kyuChosainNo;
    }

    /**
     * getShichosonCode2
     * @return shichosonCode2
     */
    public LasdecCode getShichosonCode2() {
        return shichosonCode2;
    }

    /**
     * setShichosonCode2
     * @param shichosonCode2 shichosonCode2
     */
    public void setShichosonCode2(LasdecCode shichosonCode2) {
        this.shichosonCode2 = shichosonCode2;
    }

    /**
     * getKyuChosaItakusakiNo2
     * @return kyuChosaItakusakiNo2
     */
    public RString getKyuChosaItakusakiNo2() {
        return kyuChosaItakusakiNo2;
    }

    /**
     * setKyuChosaItakusakiNo2
     * @param kyuChosaItakusakiNo2 kyuChosaItakusakiNo2
     */
    public void setKyuChosaItakusakiNo2(RString kyuChosaItakusakiNo2) {
        this.kyuChosaItakusakiNo2 = kyuChosaItakusakiNo2;
    }

    /**
     * getKyuChosainNo2
     * @return kyuChosainNo2
     */
    public RString getKyuChosainNo2() {
        return kyuChosainNo2;
    }

    /**
     * setKyuChosainNo2
     * @param kyuChosainNo2 kyuChosainNo2
     */
    public void setKyuChosainNo2(RString kyuChosainNo2) {
        this.kyuChosainNo2 = kyuChosainNo2;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.kyuChosaItakusakiNo, other.kyuChosaItakusakiNo)) {
            return false;
        }
        if (!Objects.equals(this.kyuChosainNo, other.kyuChosainNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.shinChosaItakusakiNo = entity.shinChosaItakusakiNo;
        this.shinChosainNo = entity.shinChosainNo;
        this.kyuChosaItakusakiNo = entity.kyuChosaItakusakiNo;
        this.kyuChosainNo = entity.kyuChosainNo;
        this.shichosonCode2 = entity.shichosonCode2;
        this.kyuChosaItakusakiNo2 = entity.kyuChosaItakusakiNo2;
        this.kyuChosainNo2 = entity.kyuChosainNo2;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, shinChosaItakusakiNo, shinChosainNo, kyuChosaItakusakiNo, kyuChosainNo, shichosonCode2, kyuChosaItakusakiNo2, kyuChosainNo2);
    }

// </editor-fold>


}
