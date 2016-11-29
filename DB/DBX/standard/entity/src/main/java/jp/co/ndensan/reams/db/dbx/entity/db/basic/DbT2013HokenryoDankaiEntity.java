package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 保険料段階テーブルのエンティティクラスです。
 */
public class DbT2013HokenryoDankaiEntity extends DbTableEntityBase<DbT2013HokenryoDankaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

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
    private RString dankaiIndex;
    @PrimaryKey
    private RString rankuKubun;
    private RString dankaiKubun;
    private Decimal hokenryoRitsu;
    private RString tokureiHyoki;

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
     * 賦課年度のgetメソッドです。
     *
     * @return 賦課年度
     */
    public FlexibleYear getFukaNendo() {
        return fukaNendo;
    }

    /**
     * 賦課年度のsetメソッドです。
     *
     * @param fukaNendo 賦課年度
     */
    public void setFukaNendo(FlexibleYear fukaNendo) {
        this.fukaNendo = fukaNendo;
    }

    /**
     * 段階インデックスのgetメソッドです。
     *
     * @return 段階インデックス
     */
    public RString getDankaiIndex() {
        return dankaiIndex;
    }

    /**
     * 段階インデックスのsetメソッドです。
     *
     * @param dankaiIndex 段階インデックス
     */
    public void setDankaiIndex(RString dankaiIndex) {
        this.dankaiIndex = dankaiIndex;
    }

    /**
     * ランク区分のgetメソッドです。
     * <br/>
     * <br/>00：ランクなし　01～：ランク数分存在
     *
     * @return ランク区分
     */
    public RString getRankuKubun() {
        return rankuKubun;
    }

    /**
     * ランク区分のsetメソッドです。
     * <br/>
     * <br/>00：ランクなし　01～：ランク数分存在
     *
     * @param rankuKubun ランク区分
     */
    public void setRankuKubun(RString rankuKubun) {
        this.rankuKubun = rankuKubun;
    }

    /**
     * 段階区分のgetメソッドです。
     * <br/>
     * <br/>介護賦課マスタへの格納値
     *
     * @return 段階区分
     */
    public RString getDankaiKubun() {
        return dankaiKubun;
    }

    /**
     * 段階区分のsetメソッドです。
     * <br/>
     * <br/>介護賦課マスタへの格納値
     *
     * @param dankaiKubun 段階区分
     */
    public void setDankaiKubun(RString dankaiKubun) {
        this.dankaiKubun = dankaiKubun;
    }

    /**
     * 保険料率のgetメソッドです。
     *
     * @return 保険料率
     */
    public Decimal getHokenryoRitsu() {
        return hokenryoRitsu;
    }

    /**
     * 保険料率のsetメソッドです。
     *
     * @param hokenryoRitsu 保険料率
     */
    public void setHokenryoRitsu(Decimal hokenryoRitsu) {
        this.hokenryoRitsu = hokenryoRitsu;
    }

    /**
     * 特例表記のgetメソッドです。
     *
     * @return 特例表記
     */
    public RString getTokureiHyoki() {
        return tokureiHyoki;
    }

    /**
     * 特例表記のsetメソッドです。
     *
     * @param tokureiHyoki 特例表記
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
