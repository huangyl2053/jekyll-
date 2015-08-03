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
 * 新旧被保険者番号変換テーブルテーブルのエンティティクラスです。
 */
public class DbT7026ShinKyuHihokenshaNoHenkanEntity extends DbTableEntityBase<DbT7026ShinKyuHihokenshaNoHenkanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
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
     * 新番号のgetメソッドです。
     * 
     * @return 新番号
     */
    public RString getShinNo() {
        return shinNo;
    }

    /**
     * 新番号のsetメソッドです。
     * 
     * @param shinNo 新番号
     */
    public void setShinNo(RString shinNo) {
        this.shinNo = shinNo;
    }

    /**
     * 旧番号のgetメソッドです。
     * 
     * @return 旧番号
     */
    public RString getKyuNo() {
        return kyuNo;
    }

    /**
     * 旧番号のsetメソッドです。
     * 
     * @param kyuNo 旧番号
     */
    public void setKyuNo(RString kyuNo) {
        this.kyuNo = kyuNo;
    }

    /**
     * 旧市町村コード２のgetメソッドです。
     * 
     * @return 旧市町村コード２
     */
    public LasdecCode getKyuShichosonCode() {
        return kyuShichosonCode;
    }

    /**
     * 旧市町村コード２のsetメソッドです。
     * 
     * @param kyuShichosonCode 旧市町村コード２
     */
    public void setKyuShichosonCode(LasdecCode kyuShichosonCode) {
        this.kyuShichosonCode = kyuShichosonCode;
    }

    /**
     * 旧番号２のgetメソッドです。
     * 
     * @return 旧番号２
     */
    public RString getKyuNo2() {
        return kyuNo2;
    }

    /**
     * 旧番号２のsetメソッドです。
     * 
     * @param kyuNo2 旧番号２
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
