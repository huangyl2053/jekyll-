package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * DbT2008Shotokuの項目定義クラスです
 *
 */
public class DbT2008ShotokuEntity extends DbTableEntityBase<DbT2008ShotokuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT2008Shotoku");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYear shotokuNendo;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private int rirekiNo;
    private RString hiKazeiKubun;
    private RString hiKazeiKubunGemmenGo;
    private Decimal gokeiShotokuGaku;
    private Decimal nenkiniShunyuGaku;
    private RString gekihenKanwaKubun;

    /**
     * getInsertDantaiCd
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * setLastUpdateReamsLoginId
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getShotokuNendo
     * @return shotokuNendo
     */
    public FlexibleYear getShotokuNendo() {
        return shotokuNendo;
    }

    /**
     * setShotokuNendo
     * @param shotokuNendo shotokuNendo
     */
    public void setShotokuNendo(FlexibleYear shotokuNendo) {
        this.shotokuNendo = shotokuNendo;
    }

    /**
     * getShikibetsuCode
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * setShikibetsuCode
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * getRirekiNo
     * @return rirekiNo
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * setRirekiNo
     * @param rirekiNo rirekiNo
     */
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * getHiKazeiKubun
     * @return hiKazeiKubun
     */
    public RString getHiKazeiKubun() {
        return hiKazeiKubun;
    }

    /**
     * setHiKazeiKubun
     * @param hiKazeiKubun hiKazeiKubun
     */
    public void setHiKazeiKubun(RString hiKazeiKubun) {
        this.hiKazeiKubun = hiKazeiKubun;
    }

    /**
     * getHiKazeiKubunGemmenGo
     * @return hiKazeiKubunGemmenGo
     */
    public RString getHiKazeiKubunGemmenGo() {
        return hiKazeiKubunGemmenGo;
    }

    /**
     * setHiKazeiKubunGemmenGo
     * @param hiKazeiKubunGemmenGo hiKazeiKubunGemmenGo
     */
    public void setHiKazeiKubunGemmenGo(RString hiKazeiKubunGemmenGo) {
        this.hiKazeiKubunGemmenGo = hiKazeiKubunGemmenGo;
    }

    /**
     * getGokeiShotokuGaku
     * @return gokeiShotokuGaku
     */
    public Decimal getGokeiShotokuGaku() {
        return gokeiShotokuGaku;
    }

    /**
     * setGokeiShotokuGaku
     * @param gokeiShotokuGaku gokeiShotokuGaku
     */
    public void setGokeiShotokuGaku(Decimal gokeiShotokuGaku) {
        this.gokeiShotokuGaku = gokeiShotokuGaku;
    }

    /**
     * getNenkiniShunyuGaku
     * @return nenkiniShunyuGaku
     */
    public Decimal getNenkiniShunyuGaku() {
        return nenkiniShunyuGaku;
    }

    /**
     * setNenkiniShunyuGaku
     * @param nenkiniShunyuGaku nenkiniShunyuGaku
     */
    public void setNenkiniShunyuGaku(Decimal nenkiniShunyuGaku) {
        this.nenkiniShunyuGaku = nenkiniShunyuGaku;
    }

    /**
     * getGekihenKanwaKubun
     * @return gekihenKanwaKubun
     */
    public RString getGekihenKanwaKubun() {
        return gekihenKanwaKubun;
    }

    /**
     * setGekihenKanwaKubun
     * @param gekihenKanwaKubun gekihenKanwaKubun
     */
    public void setGekihenKanwaKubun(RString gekihenKanwaKubun) {
        this.gekihenKanwaKubun = gekihenKanwaKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2008ShotokuEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT2008ShotokuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2008ShotokuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shotokuNendo, other.shotokuNendo)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
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
    public void shallowCopy(DbT2008ShotokuEntity entity) {
        this.shotokuNendo = entity.shotokuNendo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.rirekiNo = entity.rirekiNo;
        this.hiKazeiKubun = entity.hiKazeiKubun;
        this.hiKazeiKubunGemmenGo = entity.hiKazeiKubunGemmenGo;
        this.gokeiShotokuGaku = entity.gokeiShotokuGaku;
        this.nenkiniShunyuGaku = entity.nenkiniShunyuGaku;
        this.gekihenKanwaKubun = entity.gekihenKanwaKubun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shotokuNendo, shikibetsuCode, rirekiNo, hiKazeiKubun, hiKazeiKubunGemmenGo, gokeiShotokuGaku, nenkiniShunyuGaku, gekihenKanwaKubun);
    }

// </editor-fold>

}
