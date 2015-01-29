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
 * DbT7030ShinKyuIryoKikanShujiiNoHenkanの項目定義クラスです
 *
 */
public class DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity extends DbTableEntityBase<DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7030ShinKyuIryoKikanShujiiNoHenkan");

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
    private RString shinIryoKikanNo;
    private RString shinShujiiNo;
    @PrimaryKey
    private RString kyuIryoKikanNo;
    @PrimaryKey
    private RString kyuShujiiNo;
    private LasdecCode shichosonCode2;
    private RString kyuIryoKikanNo2;
    private RString kyuShujiiNo2;

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
     * getShinIryoKikanNo
     * @return shinIryoKikanNo
     */
    public RString getShinIryoKikanNo() {
        return shinIryoKikanNo;
    }

    /**
     * setShinIryoKikanNo
     * @param shinIryoKikanNo shinIryoKikanNo
     */
    public void setShinIryoKikanNo(RString shinIryoKikanNo) {
        this.shinIryoKikanNo = shinIryoKikanNo;
    }

    /**
     * getShinShujiiNo
     * @return shinShujiiNo
     */
    public RString getShinShujiiNo() {
        return shinShujiiNo;
    }

    /**
     * setShinShujiiNo
     * @param shinShujiiNo shinShujiiNo
     */
    public void setShinShujiiNo(RString shinShujiiNo) {
        this.shinShujiiNo = shinShujiiNo;
    }

    /**
     * getKyuIryoKikanNo
     * @return kyuIryoKikanNo
     */
    public RString getKyuIryoKikanNo() {
        return kyuIryoKikanNo;
    }

    /**
     * setKyuIryoKikanNo
     * @param kyuIryoKikanNo kyuIryoKikanNo
     */
    public void setKyuIryoKikanNo(RString kyuIryoKikanNo) {
        this.kyuIryoKikanNo = kyuIryoKikanNo;
    }

    /**
     * getKyuShujiiNo
     * @return kyuShujiiNo
     */
    public RString getKyuShujiiNo() {
        return kyuShujiiNo;
    }

    /**
     * setKyuShujiiNo
     * @param kyuShujiiNo kyuShujiiNo
     */
    public void setKyuShujiiNo(RString kyuShujiiNo) {
        this.kyuShujiiNo = kyuShujiiNo;
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
     * getKyuIryoKikanNo2
     * @return kyuIryoKikanNo2
     */
    public RString getKyuIryoKikanNo2() {
        return kyuIryoKikanNo2;
    }

    /**
     * setKyuIryoKikanNo2
     * @param kyuIryoKikanNo2 kyuIryoKikanNo2
     */
    public void setKyuIryoKikanNo2(RString kyuIryoKikanNo2) {
        this.kyuIryoKikanNo2 = kyuIryoKikanNo2;
    }

    /**
     * getKyuShujiiNo2
     * @return kyuShujiiNo2
     */
    public RString getKyuShujiiNo2() {
        return kyuShujiiNo2;
    }

    /**
     * setKyuShujiiNo2
     * @param kyuShujiiNo2 kyuShujiiNo2
     */
    public void setKyuShujiiNo2(RString kyuShujiiNo2) {
        this.kyuShujiiNo2 = kyuShujiiNo2;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.kyuIryoKikanNo, other.kyuIryoKikanNo)) {
            return false;
        }
        if (!Objects.equals(this.kyuShujiiNo, other.kyuShujiiNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.shinIryoKikanNo = entity.shinIryoKikanNo;
        this.shinShujiiNo = entity.shinShujiiNo;
        this.kyuIryoKikanNo = entity.kyuIryoKikanNo;
        this.kyuShujiiNo = entity.kyuShujiiNo;
        this.shichosonCode2 = entity.shichosonCode2;
        this.kyuIryoKikanNo2 = entity.kyuIryoKikanNo2;
        this.kyuShujiiNo2 = entity.kyuShujiiNo2;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, shinIryoKikanNo, shinShujiiNo, kyuIryoKikanNo, kyuShujiiNo, shichosonCode2, kyuIryoKikanNo2, kyuShujiiNo2);
    }

// </editor-fold>


}
