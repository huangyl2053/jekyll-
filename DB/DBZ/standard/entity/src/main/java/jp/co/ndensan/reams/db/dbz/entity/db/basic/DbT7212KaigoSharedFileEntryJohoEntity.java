package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 介護共有ファイルエントリ情報テーブルのエンティティクラスです。
 */
public class DbT7212KaigoSharedFileEntryJohoEntity extends DbTableEntityBase<DbT7212KaigoSharedFileEntryJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7212KaigoSharedFileEntryJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString fileName;
    private RString entryJoho;
    private RDateTime sharedFileId;

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
     * ファイル名のgetメソッドです。
     * 
     * @return ファイル名
     */
    public RString getFileName() {
        return fileName;
    }

    /**
     * ファイル名のsetメソッドです。
     * 
     * @param fileName ファイル名
     */
    public void setFileName(@Nonnull RString fileName) {
        this.fileName = fileName;
    }

    /**
     * エントリ情報のgetメソッドです。
     * 
     * @return エントリ情報
     */
    @CheckForNull
    public RString getEntryJoho() {
        return entryJoho;
    }

    /**
     * エントリ情報のsetメソッドです。
     * 
     * @param entryJoho エントリ情報
     */
    public void setEntryJoho(RString entryJoho) {
        this.entryJoho = entryJoho;
    }

    /**
     * 共有ファイルIDのgetメソッドです。
     * 
     * @return 共有ファイルID
     */
    @CheckForNull
    public RDateTime getSharedFileId() {
        return sharedFileId;
    }

    /**
     * 共有ファイルIDのsetメソッドです。
     * 
     * @param sharedFileId 共有ファイルID
     */
    public void setSharedFileId(RDateTime sharedFileId) {
        this.sharedFileId = sharedFileId;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7212KaigoSharedFileEntryJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7212KaigoSharedFileEntryJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7212KaigoSharedFileEntryJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.fileName, other.fileName)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7212KaigoSharedFileEntryJohoEntity entity) {
        this.fileName = entity.fileName;
        this.entryJoho = entity.entryJoho;
        this.sharedFileId = entity.sharedFileId;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(fileName, entryJoho, sharedFileId);
    }

// </editor-fold>
}
