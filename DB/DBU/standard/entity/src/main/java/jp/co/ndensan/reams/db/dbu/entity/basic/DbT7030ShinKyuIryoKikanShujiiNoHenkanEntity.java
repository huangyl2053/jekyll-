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
 * 新旧医療機関主治医番号変換テーブルテーブルのエンティティクラスです。
 */
public class DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity extends DbTableEntityBase<DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
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
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 新医療機関番号のgetメソッドです。
     * 
     * @return 新医療機関番号
     */
    public RString getShinIryoKikanNo() {
        return shinIryoKikanNo;
    }

    /**
     * 新医療機関番号のsetメソッドです。
     * 
     * @param shinIryoKikanNo 新医療機関番号
     */
    public void setShinIryoKikanNo(RString shinIryoKikanNo) {
        this.shinIryoKikanNo = shinIryoKikanNo;
    }

    /**
     * 新主治医番号のgetメソッドです。
     * 
     * @return 新主治医番号
     */
    public RString getShinShujiiNo() {
        return shinShujiiNo;
    }

    /**
     * 新主治医番号のsetメソッドです。
     * 
     * @param shinShujiiNo 新主治医番号
     */
    public void setShinShujiiNo(RString shinShujiiNo) {
        this.shinShujiiNo = shinShujiiNo;
    }

    /**
     * 旧医療機関番号のgetメソッドです。
     * 
     * @return 旧医療機関番号
     */
    public RString getKyuIryoKikanNo() {
        return kyuIryoKikanNo;
    }

    /**
     * 旧医療機関番号のsetメソッドです。
     * 
     * @param kyuIryoKikanNo 旧医療機関番号
     */
    public void setKyuIryoKikanNo(RString kyuIryoKikanNo) {
        this.kyuIryoKikanNo = kyuIryoKikanNo;
    }

    /**
     * 旧主治医番号のgetメソッドです。
     * 
     * @return 旧主治医番号
     */
    public RString getKyuShujiiNo() {
        return kyuShujiiNo;
    }

    /**
     * 旧主治医番号のsetメソッドです。
     * 
     * @param kyuShujiiNo 旧主治医番号
     */
    public void setKyuShujiiNo(RString kyuShujiiNo) {
        this.kyuShujiiNo = kyuShujiiNo;
    }

    /**
     * 市町村コード２のgetメソッドです。
     * 
     * @return 市町村コード２
     */
    public LasdecCode getShichosonCode2() {
        return shichosonCode2;
    }

    /**
     * 市町村コード２のsetメソッドです。
     * 
     * @param shichosonCode2 市町村コード２
     */
    public void setShichosonCode2(LasdecCode shichosonCode2) {
        this.shichosonCode2 = shichosonCode2;
    }

    /**
     * 旧医療機関番号２のgetメソッドです。
     * 
     * @return 旧医療機関番号２
     */
    public RString getKyuIryoKikanNo2() {
        return kyuIryoKikanNo2;
    }

    /**
     * 旧医療機関番号２のsetメソッドです。
     * 
     * @param kyuIryoKikanNo2 旧医療機関番号２
     */
    public void setKyuIryoKikanNo2(RString kyuIryoKikanNo2) {
        this.kyuIryoKikanNo2 = kyuIryoKikanNo2;
    }

    /**
     * 旧主治医番号２のgetメソッドです。
     * 
     * @return 旧主治医番号２
     */
    public RString getKyuShujiiNo2() {
        return kyuShujiiNo2;
    }

    /**
     * 旧主治医番号２のsetメソッドです。
     * 
     * @param kyuShujiiNo2 旧主治医番号２
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
