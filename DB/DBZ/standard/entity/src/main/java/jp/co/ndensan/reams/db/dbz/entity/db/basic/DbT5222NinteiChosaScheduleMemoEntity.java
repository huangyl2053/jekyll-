package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 認定調査スケジュールメモ情報テーブルのエンティティクラスです。
 */
public class DbT5222NinteiChosaScheduleMemoEntity extends DbTableEntityBase<DbT5222NinteiChosaScheduleMemoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5222NinteiChosaScheduleMemo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleDate memoYMD;
    @PrimaryKey
    private Code chosachikucode;
    @PrimaryKey
    private Code memoKubun;
    @PrimaryKey
    private int remban;
    private Code memoShiteiChosaChikuCode;
    private RString sakuseisha;
    private Code memoPriority;
    private RString memoNaiyo;

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
     * メモ年月日のgetメソッドです。
     * 
     * @return メモ年月日
     */
    public FlexibleDate getMemoYMD() {
        return memoYMD;
    }

    /**
     * メモ年月日のsetメソッドです。
     * 
     * @param memoYMD メモ年月日
     */
    public void setMemoYMD(@Nonnull FlexibleDate memoYMD) {
        this.memoYMD = memoYMD;
    }

    /**
     * 調査地区コードのgetメソッドです。
     * 
     * @return 調査地区コード
     */
    public Code getChosachikucode() {
        return chosachikucode;
    }

    /**
     * 調査地区コードのsetメソッドです。
     * 
     * @param chosachikucode 調査地区コード
     */
    public void setChosachikucode(@Nonnull Code chosachikucode) {
        this.chosachikucode = chosachikucode;
    }

    /**
     * メモ区分のgetメソッドです。
     * 
     * @return メモ区分
     */
    public Code getMemoKubun() {
        return memoKubun;
    }

    /**
     * メモ区分のsetメソッドです。
     * 
     * @param memoKubun メモ区分
     */
    public void setMemoKubun(@Nonnull Code memoKubun) {
        this.memoKubun = memoKubun;
    }

    /**
     * 連番のgetメソッドです。
     * 
     * @return 連番
     */
    public int getRemban() {
        return remban;
    }

    /**
     * 連番のsetメソッドです。
     * 
     * @param remban 連番
     */
    public void setRemban(@Nonnull int remban) {
        this.remban = remban;
    }

    /**
     * メモ指定調査地区コードのgetメソッドです。
     * <br/>
     * <br/>Code（DBE：5002）
     * 
     * @return メモ指定調査地区コード
     */
    @CheckForNull
    public Code getMemoShiteiChosaChikuCode() {
        return memoShiteiChosaChikuCode;
    }

    /**
     * メモ指定調査地区コードのsetメソッドです。
     * <br/>
     * <br/>Code（DBE：5002）
     * 
     * @param memoShiteiChosaChikuCode メモ指定調査地区コード
     */
    public void setMemoShiteiChosaChikuCode(Code memoShiteiChosaChikuCode) {
        this.memoShiteiChosaChikuCode = memoShiteiChosaChikuCode;
    }

    /**
     * 作成者のgetメソッドです。
     * 
     * @return 作成者
     */
    @CheckForNull
    public RString getSakuseisha() {
        return sakuseisha;
    }

    /**
     * 作成者のsetメソッドです。
     * 
     * @param sakuseisha 作成者
     */
    public void setSakuseisha(RString sakuseisha) {
        this.sakuseisha = sakuseisha;
    }

    /**
     * memoPriorityのgetメソッドです。
     * 
     * @return memoPriority
     */
    public Code getMemoPriority() {
        return memoPriority;
    }

    /**
     * memoPriorityのsetメソッドです。
     * 
     * @param memoPriority memoPriority
     */
    public void setMemoPriority(@Nonnull Code memoPriority) {
        this.memoPriority = memoPriority;
    }

    /**
     * メモ内容のgetメソッドです。
     * 
     * @return メモ内容
     */
    @CheckForNull
    public RString getMemoNaiyo() {
        return memoNaiyo;
    }

    /**
     * メモ内容のsetメソッドです。
     * 
     * @param memoNaiyo メモ内容
     */
    public void setMemoNaiyo(RString memoNaiyo) {
        this.memoNaiyo = memoNaiyo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5222NinteiChosaScheduleMemoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5222NinteiChosaScheduleMemoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5222NinteiChosaScheduleMemoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.memoYMD, other.memoYMD)) {
            return false;
        }
        if (!Objects.equals(this.chosachikucode, other.chosachikucode)) {
            return false;
        }
        if (!Objects.equals(this.memoKubun, other.memoKubun)) {
            return false;
        }
        if (this.remban != other.remban) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5222NinteiChosaScheduleMemoEntity entity) {
        this.memoYMD = entity.memoYMD;
        this.chosachikucode = entity.chosachikucode;
        this.memoKubun = entity.memoKubun;
        this.remban = entity.remban;
        this.memoShiteiChosaChikuCode = entity.memoShiteiChosaChikuCode;
        this.sakuseisha = entity.sakuseisha;
        this.memoPriority = entity.memoPriority;
        this.memoNaiyo = entity.memoNaiyo;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(memoYMD, chosachikucode, memoKubun, remban, memoShiteiChosaChikuCode, sakuseisha, memoPriority, memoNaiyo);
    }

// </editor-fold>
}
