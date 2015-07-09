package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import java.util.Objects;

/**
 * 定型文テーブルのエンティティクラスです。
 */
public class DbT7231TeikeibunEntity extends DbTableEntityBase<DbT7231TeikeibunEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7231Teikeibun");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString teikeibunCode;
    private RString teikeibun;

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
     * 定型文コードのgetメソッドです。
     * 
     * @return 定型文コード
     */
    public RString getTeikeibunCode() {
        return teikeibunCode;
    }

    /**
     * 定型文コードのsetメソッドです。
     * 
     * @param teikeibunCode 定型文コード
     */
    public void setTeikeibunCode(RString teikeibunCode) {
        this.teikeibunCode = teikeibunCode;
    }

    /**
     * 定型文のgetメソッドです。
     * 
     * @return 定型文
     */
    public RString getTeikeibun() {
        return teikeibun;
    }

    /**
     * 定型文のsetメソッドです。
     * 
     * @param teikeibun 定型文
     */
    public void setTeikeibun(RString teikeibun) {
        this.teikeibun = teikeibun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7231TeikeibunEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7231TeikeibunEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7231TeikeibunEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.teikeibunCode, other.teikeibunCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7231TeikeibunEntity entity) {
        this.teikeibunCode = entity.teikeibunCode;
        this.teikeibun = entity.teikeibun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(teikeibunCode, teikeibun);
    }

// </editor-fold>
}
