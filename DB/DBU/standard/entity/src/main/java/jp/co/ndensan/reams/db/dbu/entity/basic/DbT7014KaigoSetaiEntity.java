package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import java.util.Objects;

/**
 * 介護世帯テーブルのエンティティクラスです。
 */
public class DbT7014KaigoSetaiEntity extends DbTableEntityBase<DbT7014KaigoSetaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7014KaigoSetai");

    private RString insertDantaiCd;
    @PrimaryKey
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private DbUDD002HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleDate setaiKijunYMD;
    @PrimaryKey
    private int renban;
    @PrimaryKey
    private RDateTime shoriTimestamp;
    private ShikibetsuCode setaiInshikibetsuCode;

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
    public DbUDD002HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     * 
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(DbUDD002HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 世帯基準年月日のgetメソッドです。
     * 
     * @return 世帯基準年月日
     */
    public FlexibleDate getSetaiKijunYMD() {
        return setaiKijunYMD;
    }

    /**
     * 世帯基準年月日のsetメソッドです。
     * 
     * @param setaiKijunYMD 世帯基準年月日
     */
    public void setSetaiKijunYMD(FlexibleDate setaiKijunYMD) {
        this.setaiKijunYMD = setaiKijunYMD;
    }

    /**
     * 連番のgetメソッドです。
     * 
     * @return 連番
     */
    public int getRenban() {
        return renban;
    }

    /**
     * 連番のsetメソッドです。
     * 
     * @param renban 連番
     */
    public void setRenban(int renban) {
        this.renban = renban;
    }

    /**
     * 処理日時のgetメソッドです。
     * 
     * @return 処理日時
     */
    public RDateTime getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * 処理日時のsetメソッドです。
     * 
     * @param shoriTimestamp 処理日時
     */
    public void setShoriTimestamp(RDateTime shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * 世帯員識別コードのgetメソッドです。
     * 
     * @return 世帯員識別コード
     */
    public ShikibetsuCode getSetaiInshikibetsuCode() {
        return setaiInshikibetsuCode;
    }

    /**
     * 世帯員識別コードのsetメソッドです。
     * 
     * @param setaiInshikibetsuCode 世帯員識別コード
     */
    public void setSetaiInshikibetsuCode(ShikibetsuCode setaiInshikibetsuCode) {
        this.setaiInshikibetsuCode = setaiInshikibetsuCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7014KaigoSetaiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7014KaigoSetaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7014KaigoSetaiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.insertTimestamp, other.insertTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.setaiKijunYMD, other.setaiKijunYMD)) {
            return false;
        }
        if (this.renban != other.renban) {
            return false;
        }
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7014KaigoSetaiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.setaiKijunYMD = entity.setaiKijunYMD;
        this.renban = entity.renban;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.setaiInshikibetsuCode = entity.setaiInshikibetsuCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, setaiKijunYMD, renban, shoriTimestamp, setaiInshikibetsuCode);
    }

// </editor-fold>
}
