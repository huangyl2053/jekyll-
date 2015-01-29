package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.DankaiIndex;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.RankKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT2013HokenryoDankaiの項目定義クラスです
 *
 */
public class DbT2013HokenryoDankaiEntity extends DbTableEntityBase<DbT2013HokenryoDankaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT2013HokenryoDankai");

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
    private DankaiIndex dankaiIndex;
    @PrimaryKey
    private RankKubun rankuKubun;
    private RString dankaiKubun;
    private Decimal hokenryoRitsu;
    private RString tokureiHyoki;

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
     * getDankaiIndex
     *
     * @return dankaiIndex
     */
    public DankaiIndex getDankaiIndex() {
        return dankaiIndex;
    }

    /**
     * setDankaiIndex
     *
     * @param dankaiIndex dankaiIndex
     */
    public void setDankaiIndex(DankaiIndex dankaiIndex) {
        this.dankaiIndex = dankaiIndex;
    }

    /**
     * getRankuKubun
     *
     * @return rankuKubun
     */
    public RankKubun getRankuKubun() {
        return rankuKubun;
    }

    /**
     * setRankuKubun
     *
     * @param rankuKubun rankuKubun
     */
    public void setRankuKubun(RankKubun rankuKubun) {
        this.rankuKubun = rankuKubun;
    }

    /**
     * getDankaiKubun
     *
     * @return dankaiKubun
     */
    public RString getDankaiKubun() {
        return dankaiKubun;
    }

    /**
     * setDankaiKubun
     *
     * @param dankaiKubun dankaiKubun
     */
    public void setDankaiKubun(RString dankaiKubun) {
        this.dankaiKubun = dankaiKubun;
    }

    /**
     * getHokenryoRitsu
     *
     * @return hokenryoRitsu
     */
    public Decimal getHokenryoRitsu() {
        return hokenryoRitsu;
    }

    /**
     * setHokenryoRitsu
     *
     * @param hokenryoRitsu hokenryoRitsu
     */
    public void setHokenryoRitsu(Decimal hokenryoRitsu) {
        this.hokenryoRitsu = hokenryoRitsu;
    }

    /**
     * getTokureiHyoki
     *
     * @return tokureiHyoki
     */
    public RString getTokureiHyoki() {
        return tokureiHyoki;
    }

    /**
     * setTokureiHyoki
     *
     * @param tokureiHyoki tokureiHyoki
     */
    public void setTokureiHyoki(RString tokureiHyoki) {
        this.tokureiHyoki = tokureiHyoki;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2013HokenryoDankaiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT2013HokenryoDankaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2013HokenryoDankaiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.fukaNendo, other.fukaNendo)) {
            return false;
        }
        if (!Objects.equals(this.dankaiIndex, other.dankaiIndex)) {
            return false;
        }
        if (!Objects.equals(this.rankuKubun, other.rankuKubun)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT2013HokenryoDankaiEntity entity) {
        this.fukaNendo = entity.fukaNendo;
        this.dankaiIndex = entity.dankaiIndex;
        this.rankuKubun = entity.rankuKubun;
        this.dankaiKubun = entity.dankaiKubun;
        this.hokenryoRitsu = entity.hokenryoRitsu;
        this.tokureiHyoki = entity.tokureiHyoki;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(fukaNendo, dankaiIndex, rankuKubun, dankaiKubun, hokenryoRitsu, tokureiHyoki);
    }

// </editor-fold>
}
