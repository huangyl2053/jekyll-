package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.RankKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT2011RankJohoの項目定義クラスです
 *
 */
public class DbT2011RankJohoEntity extends DbTableEntityBase<DbT2011RankJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT2011RankJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYear fukaNendo;
    @PrimaryKey
    private RankKubun rankKubun;
    private RString rankName;

    /**
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getFukaNendo
     *
     * @return fukaNendo
     */
    public FlexibleYear getFukaNendo() {
        return fukaNendo;
    }

    /**
     * setFukaNendo
     *
     * @param fukaNendo fukaNendo
     */
    public void setFukaNendo(FlexibleYear fukaNendo) {
        this.fukaNendo = fukaNendo;
    }

    /**
     * getRankKubun
     *
     * @return rankKubun
     */
    public RankKubun getRankKubun() {
        return rankKubun;
    }

    /**
     * setRankKubun
     *
     * @param rankKubun rankKubun
     */
    public void setRankKubun(RankKubun rankKubun) {
        this.rankKubun = rankKubun;
    }

    /**
     * getRankName
     *
     * @return rankName
     */
    public RString getRankName() {
        return rankName;
    }

    /**
     * setRankName
     *
     * @param rankName rankName
     */
    public void setRankName(RString rankName) {
        this.rankName = rankName;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2011RankJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT2011RankJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2011RankJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.fukaNendo, other.fukaNendo)) {
            return false;
        }
        if (!Objects.equals(this.rankKubun, other.rankKubun)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT2011RankJohoEntity entity) {
        this.fukaNendo = entity.fukaNendo;
        this.rankKubun = entity.rankKubun;
        this.rankName = entity.rankName;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(fukaNendo, rankKubun, rankName);
    }

// </editor-fold>
}
