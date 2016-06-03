package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import java.util.Objects;
import javax.annotation.Nonnull;

/**
 * 申請書一括発行テーブルのエンティティクラスです。
 * <br/> 申請書の発行対象として画面で選択された被保険者の被保番号を保持する。
 */
public class DbT4032ShinseishoIkkatsuHakkoBatchEntity extends DbTableEntityBase<DbT4032ShinseishoIkkatsuHakkoBatchEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4032ShinseishoIkkatsuHakkoBatch");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private UUID hakkoShoriID;
    private UUID haakuShoriId;

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
     * 発行処理IDのgetメソッドです。
     * 
     * @return 発行処理ID
     */
    public UUID getHakkoShoriID() {
        return hakkoShoriID;
    }

    /**
     * 発行処理IDのsetメソッドです。
     * 
     * @param hakkoShoriID 発行処理ID
     */
    public void setHakkoShoriID(@Nonnull UUID hakkoShoriID) {
        this.hakkoShoriID = hakkoShoriID;
    }

    /**
     * 把握処理IDのgetメソッドです。
     * 
     * @return 把握処理ID
     */
    public UUID getHaakuShoriId() {
        return haakuShoriId;
    }

    /**
     * 把握処理IDのsetメソッドです。
     * 
     * @param haakuShoriId 把握処理ID
     */
    public void setHaakuShoriId(@Nonnull UUID haakuShoriId) {
        this.haakuShoriId = haakuShoriId;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4032ShinseishoIkkatsuHakkoBatchEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4032ShinseishoIkkatsuHakkoBatchEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4032ShinseishoIkkatsuHakkoBatchEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hakkoShoriID, other.hakkoShoriID)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT4032ShinseishoIkkatsuHakkoBatchEntity entity) {
        this.hakkoShoriID = entity.hakkoShoriID;
        this.haakuShoriId = entity.haakuShoriId;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hakkoShoriID, haakuShoriId);
    }

// </editor-fold>
}
