package jp.co.ndensan.reams.db.dbb.entity.basic;

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
 * 介護所得テーブルのエンティティクラスです。
 */
public class DbT2008ShotokuEntity extends DbTableEntityBase<DbT2008ShotokuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
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
     * 所得年度のgetメソッドです。
     * 
     * @return 所得年度
     */
    public FlexibleYear getShotokuNendo() {
        return shotokuNendo;
    }

    /**
     * 所得年度のsetメソッドです。
     * 
     * @param shotokuNendo 所得年度
     */
    public void setShotokuNendo(FlexibleYear shotokuNendo) {
        this.shotokuNendo = shotokuNendo;
    }

    /**
     * 識別コードのgetメソッドです。
     * 
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     * 
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
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
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 非課税区分（住民税減免前）のgetメソッドです。
     * <br/>
     * <br/>保険料賦課の際に参照する
     * 
     * @return 非課税区分（住民税減免前）
     */
    public RString getHiKazeiKubun() {
        return hiKazeiKubun;
    }

    /**
     * 非課税区分（住民税減免前）のsetメソッドです。
     * <br/>
     * <br/>保険料賦課の際に参照する
     * 
     * @param hiKazeiKubun 非課税区分（住民税減免前）
     */
    public void setHiKazeiKubun(RString hiKazeiKubun) {
        this.hiKazeiKubun = hiKazeiKubun;
    }

    /**
     * 非課税区分（住民税減免後）のgetメソッドです。
     * <br/>
     * <br/>給付（高額等）で参照する
     * 
     * @return 非課税区分（住民税減免後）
     */
    public RString getHiKazeiKubunGemmenGo() {
        return hiKazeiKubunGemmenGo;
    }

    /**
     * 非課税区分（住民税減免後）のsetメソッドです。
     * <br/>
     * <br/>給付（高額等）で参照する
     * 
     * @param hiKazeiKubunGemmenGo 非課税区分（住民税減免後）
     */
    public void setHiKazeiKubunGemmenGo(RString hiKazeiKubunGemmenGo) {
        this.hiKazeiKubunGemmenGo = hiKazeiKubunGemmenGo;
    }

    /**
     * 合計所得金額のgetメソッドです。
     * 
     * @return 合計所得金額
     */
    public Decimal getGokeiShotokuGaku() {
        return gokeiShotokuGaku;
    }

    /**
     * 合計所得金額のsetメソッドです。
     * 
     * @param gokeiShotokuGaku 合計所得金額
     */
    public void setGokeiShotokuGaku(Decimal gokeiShotokuGaku) {
        this.gokeiShotokuGaku = gokeiShotokuGaku;
    }

    /**
     * 公的年金収入額のgetメソッドです。
     * 
     * @return 公的年金収入額
     */
    public Decimal getNenkiniShunyuGaku() {
        return nenkiniShunyuGaku;
    }

    /**
     * 公的年金収入額のsetメソッドです。
     * 
     * @param nenkiniShunyuGaku 公的年金収入額
     */
    public void setNenkiniShunyuGaku(Decimal nenkiniShunyuGaku) {
        this.nenkiniShunyuGaku = nenkiniShunyuGaku;
    }

    /**
     * 激変緩和措置区分のgetメソッドです。
     * 
     * @return 激変緩和措置区分
     */
    public RString getGekihenKanwaKubun() {
        return gekihenKanwaKubun;
    }

    /**
     * 激変緩和措置区分のsetメソッドです。
     * 
     * @param gekihenKanwaKubun 激変緩和措置区分
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
