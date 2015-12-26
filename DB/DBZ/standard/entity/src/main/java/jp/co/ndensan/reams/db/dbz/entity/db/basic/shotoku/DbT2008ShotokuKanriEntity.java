package jp.co.ndensan.reams.db.dbz.entity.db.basic.shotoku;

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
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 介護所得管理テーブルのエンティティクラスです。
 * <br/> 住民税課税対象者以外の所得情報を管理します。
 */
public class DbT2008ShotokuKanriEntity extends DbTableEntityBase<DbT2008ShotokuKanriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT2008ShotokuKanri");

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
    private RString kazeiKubun;
    private RString kazeiKubunGemmenGo;
    private Decimal gokeiShotokuGaku;
    private Decimal nenkiniShunyuGaku;
    private Decimal nenkiniShotokuGaku;
    private Decimal kazeiShotokuGaku;
    private RString gekihenKanwaKubun;
    private RString yusebKubun;
    private YMDHMS shoriYMD;

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
    public void setShotokuNendo(@Nonnull FlexibleYear shotokuNendo) {
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
    public void setShikibetsuCode(@Nonnull ShikibetsuCode shikibetsuCode) {
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
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 課税区分（住民税減免前）のgetメソッドです。
     * <br/>
     * <br/>1：課税　2：非課税　3：未申告　4：調査中　5：課税取消　
     * <br/>※保険料賦課の際に参照する
     * 
     * @return 課税区分（住民税減免前）
     */
    public RString getKazeiKubun() {
        return kazeiKubun;
    }

    /**
     * 課税区分（住民税減免前）のsetメソッドです。
     * <br/>
     * <br/>1：課税　2：非課税　3：未申告　4：調査中　5：課税取消　
     * <br/>※保険料賦課の際に参照する
     * 
     * @param kazeiKubun 課税区分（住民税減免前）
     */
    public void setKazeiKubun(@Nonnull RString kazeiKubun) {
        this.kazeiKubun = kazeiKubun;
    }

    /**
     * 課税区分（住民税減免後）のgetメソッドです。
     * <br/>
     * <br/>1：課税　2：非課税　3：未申告　4：調査中　5：課税取消　
     * <br/>※給付（高額等）で参照する
     * 
     * @return 課税区分（住民税減免後）
     */
    public RString getKazeiKubunGemmenGo() {
        return kazeiKubunGemmenGo;
    }

    /**
     * 課税区分（住民税減免後）のsetメソッドです。
     * <br/>
     * <br/>1：課税　2：非課税　3：未申告　4：調査中　5：課税取消　
     * <br/>※給付（高額等）で参照する
     * 
     * @param kazeiKubunGemmenGo 課税区分（住民税減免後）
     */
    public void setKazeiKubunGemmenGo(@Nonnull RString kazeiKubunGemmenGo) {
        this.kazeiKubunGemmenGo = kazeiKubunGemmenGo;
    }

    /**
     * 合計所得金額のgetメソッドです。
     * 
     * @return 合計所得金額
     */
    @CheckForNull
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
    @CheckForNull
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
     * 公的年金所得額のgetメソッドです。
     * 
     * @return 公的年金所得額
     */
    @CheckForNull
    public Decimal getNenkiniShotokuGaku() {
        return nenkiniShotokuGaku;
    }

    /**
     * 公的年金所得額のsetメソッドです。
     * 
     * @param nenkiniShotokuGaku 公的年金所得額
     */
    public void setNenkiniShotokuGaku(Decimal nenkiniShotokuGaku) {
        this.nenkiniShotokuGaku = nenkiniShotokuGaku;
    }

    /**
     * 課税所得額のgetメソッドです。
     * 
     * @return 課税所得額
     */
    @CheckForNull
    public Decimal getKazeiShotokuGaku() {
        return kazeiShotokuGaku;
    }

    /**
     * 課税所得額のsetメソッドです。
     * 
     * @param kazeiShotokuGaku 課税所得額
     */
    public void setKazeiShotokuGaku(Decimal kazeiShotokuGaku) {
        this.kazeiShotokuGaku = kazeiShotokuGaku;
    }

    /**
     * 激変緩和措置区分のgetメソッドです。
     * 
     * @return 激変緩和措置区分
     */
    @CheckForNull
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
     * 優先区分のgetメソッドです。
     * 
     * @return 優先区分
     */
    @CheckForNull
    public RString getYusebKubun() {
        return yusebKubun;
    }

    /**
     * 優先区分のsetメソッドです。
     * 
     * @param yusebKubun 優先区分
     */
    public void setYusebKubun(RString yusebKubun) {
        this.yusebKubun = yusebKubun;
    }

    /**
     * 処理日のgetメソッドです。
     * 
     * @return 処理日
     */
    public YMDHMS getShoriYMD() {
        return shoriYMD;
    }

    /**
     * 処理日のsetメソッドです。
     * 
     * @param shoriYMD 処理日
     */
    public void setShoriYMD(@Nonnull YMDHMS shoriYMD) {
        this.shoriYMD = shoriYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2008ShotokuKanriEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT2008ShotokuKanriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2008ShotokuKanriEntity other) {
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
    public void shallowCopy(DbT2008ShotokuKanriEntity entity) {
        this.shotokuNendo = entity.shotokuNendo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.rirekiNo = entity.rirekiNo;
        this.kazeiKubun = entity.kazeiKubun;
        this.kazeiKubunGemmenGo = entity.kazeiKubunGemmenGo;
        this.gokeiShotokuGaku = entity.gokeiShotokuGaku;
        this.nenkiniShunyuGaku = entity.nenkiniShunyuGaku;
        this.nenkiniShotokuGaku = entity.nenkiniShotokuGaku;
        this.kazeiShotokuGaku = entity.kazeiShotokuGaku;
        this.gekihenKanwaKubun = entity.gekihenKanwaKubun;
        this.yusebKubun = entity.yusebKubun;
        this.shoriYMD = entity.shoriYMD;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shotokuNendo, shikibetsuCode, rirekiNo, kazeiKubun, kazeiKubunGemmenGo, gokeiShotokuGaku, nenkiniShunyuGaku, nenkiniShotokuGaku, kazeiShotokuGaku, gekihenKanwaKubun, yusebKubun, shoriYMD);
    }

// </editor-fold>
}
