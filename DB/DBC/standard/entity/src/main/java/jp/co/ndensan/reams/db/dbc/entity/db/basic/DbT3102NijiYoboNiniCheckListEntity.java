package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 二次予防任意チェックリストテーブルのエンティティクラスです。
 */
public class DbT3102NijiYoboNiniCheckListEntity extends DbTableEntityBase<DbT3102NijiYoboNiniCheckListEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3102NijiYoboNiniCheckList");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleDate uketsukeYMD;
    @PrimaryKey
    private int niniShitsumonNo;
    @PrimaryKey
    private int rirekiNo;
    private int niniShitsumonJiko;

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
     * 被保険者番号のgetメソッドです。
     * 
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     * 
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(@Nonnull HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 受付年月日のgetメソッドです。
     * 
     * @return 受付年月日
     */
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * 受付年月日のsetメソッドです。
     * 
     * @param uketsukeYMD 受付年月日
     */
    public void setUketsukeYMD(@Nonnull FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
    }

    /**
     * 任意質問番号のgetメソッドです。
     * 
     * @return 任意質問番号
     */
    public int getNiniShitsumonNo() {
        return niniShitsumonNo;
    }

    /**
     * 任意質問番号のsetメソッドです。
     * 
     * @param niniShitsumonNo 任意質問番号
     */
    public void setNiniShitsumonNo(@Nonnull int niniShitsumonNo) {
        this.niniShitsumonNo = niniShitsumonNo;
    }

    /**
     * 履歴番号のgetメソッドです。
     * 
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     * 
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 任意質問事項のgetメソッドです。
     * 
     * @return 任意質問事項
     */
    @CheckForNull
    public int getNiniShitsumonJiko() {
        return niniShitsumonJiko;
    }

    /**
     * 任意質問事項のsetメソッドです。
     * 
     * @param niniShitsumonJiko 任意質問事項
     */
    public void setNiniShitsumonJiko(int niniShitsumonJiko) {
        this.niniShitsumonJiko = niniShitsumonJiko;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3102NijiYoboNiniCheckListEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3102NijiYoboNiniCheckListEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3102NijiYoboNiniCheckListEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.uketsukeYMD, other.uketsukeYMD)) {
            return false;
        }
        if (this.niniShitsumonNo != other.niniShitsumonNo) {
            return false;
        }
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3102NijiYoboNiniCheckListEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.niniShitsumonNo = entity.niniShitsumonNo;
        this.rirekiNo = entity.rirekiNo;
        this.niniShitsumonJiko = entity.niniShitsumonJiko;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, uketsukeYMD, niniShitsumonNo, rirekiNo, niniShitsumonJiko);
    }

// </editor-fold>

}
