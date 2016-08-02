package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import javax.annotation.CheckForNull;

/**
 * 介護所得Newestテーブルのエンティティクラスです。
 */
public class DbV2512KaigoShotokuNewestEntity extends DbTableEntityBase<DbV2512KaigoShotokuNewestEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV2512KaigoShotokuNewest");

    private FlexibleYear shotokuNendo;
    private ShikibetsuCode shikibetsuCode;
    private long rirekiNo;
    private RString kazeiKubun;
    private RString kazeiKubunGemmenGo;
    private Decimal gokeiShotokuGaku;
    private Decimal nenkiniShunyuGaku;
    private Decimal nenkiniShotokuGaku;
    private Decimal kazeiShotokuGaku;
    private RString gekihenKanwaKubun;
    private RString yusenKubun;
    private YMDHMS shoriTimeStamp;
    private int motoRirekiNo;
    private RString torokuGyomu;

    /**
     * shotokuNendoのgetメソッドです。
     * 
     * @return shotokuNendo
     */
    @CheckForNull
    public FlexibleYear getShotokuNendo() {
        return shotokuNendo;
    }

    /**
     * shotokuNendoのsetメソッドです。
     * 
     * @param shotokuNendo shotokuNendo
     */
    public void setShotokuNendo(FlexibleYear shotokuNendo) {
        this.shotokuNendo = shotokuNendo;
    }

    /**
     * shikibetsuCodeのgetメソッドです。
     * 
     * @return shikibetsuCode
     */
    @CheckForNull
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * shikibetsuCodeのsetメソッドです。
     * 
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * rirekiNoのgetメソッドです。
     * 
     * @return rirekiNo
     */
    @CheckForNull
    public long getRirekiNo() {
        return rirekiNo;
    }

    /**
     * rirekiNoのsetメソッドです。
     * 
     * @param rirekiNo rirekiNo
     */
    public void setRirekiNo(long rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * kazeiKubunのgetメソッドです。
     * 
     * @return kazeiKubun
     */
    @CheckForNull
    public RString getKazeiKubun() {
        return kazeiKubun;
    }

    /**
     * kazeiKubunのsetメソッドです。
     * 
     * @param kazeiKubun kazeiKubun
     */
    public void setKazeiKubun(RString kazeiKubun) {
        this.kazeiKubun = kazeiKubun;
    }

    /**
     * kazeiKubunGemmenGoのgetメソッドです。
     * 
     * @return kazeiKubunGemmenGo
     */
    @CheckForNull
    public RString getKazeiKubunGemmenGo() {
        return kazeiKubunGemmenGo;
    }

    /**
     * kazeiKubunGemmenGoのsetメソッドです。
     * 
     * @param kazeiKubunGemmenGo kazeiKubunGemmenGo
     */
    public void setKazeiKubunGemmenGo(RString kazeiKubunGemmenGo) {
        this.kazeiKubunGemmenGo = kazeiKubunGemmenGo;
    }

    /**
     * gokeiShotokuGakuのgetメソッドです。
     * 
     * @return gokeiShotokuGaku
     */
    @CheckForNull
    public Decimal getGokeiShotokuGaku() {
        return gokeiShotokuGaku;
    }

    /**
     * gokeiShotokuGakuのsetメソッドです。
     * 
     * @param gokeiShotokuGaku gokeiShotokuGaku
     */
    public void setGokeiShotokuGaku(Decimal gokeiShotokuGaku) {
        this.gokeiShotokuGaku = gokeiShotokuGaku;
    }

    /**
     * nenkiniShunyuGakuのgetメソッドです。
     * 
     * @return nenkiniShunyuGaku
     */
    @CheckForNull
    public Decimal getNenkiniShunyuGaku() {
        return nenkiniShunyuGaku;
    }

    /**
     * nenkiniShunyuGakuのsetメソッドです。
     * 
     * @param nenkiniShunyuGaku nenkiniShunyuGaku
     */
    public void setNenkiniShunyuGaku(Decimal nenkiniShunyuGaku) {
        this.nenkiniShunyuGaku = nenkiniShunyuGaku;
    }

    /**
     * nenkiniShotokuGakuのgetメソッドです。
     * 
     * @return nenkiniShotokuGaku
     */
    @CheckForNull
    public Decimal getNenkiniShotokuGaku() {
        return nenkiniShotokuGaku;
    }

    /**
     * nenkiniShotokuGakuのsetメソッドです。
     * 
     * @param nenkiniShotokuGaku nenkiniShotokuGaku
     */
    public void setNenkiniShotokuGaku(Decimal nenkiniShotokuGaku) {
        this.nenkiniShotokuGaku = nenkiniShotokuGaku;
    }

    /**
     * kazeiShotokuGakuのgetメソッドです。
     * 
     * @return kazeiShotokuGaku
     */
    @CheckForNull
    public Decimal getKazeiShotokuGaku() {
        return kazeiShotokuGaku;
    }

    /**
     * kazeiShotokuGakuのsetメソッドです。
     * 
     * @param kazeiShotokuGaku kazeiShotokuGaku
     */
    public void setKazeiShotokuGaku(Decimal kazeiShotokuGaku) {
        this.kazeiShotokuGaku = kazeiShotokuGaku;
    }

    /**
     * gekihenKanwaKubunのgetメソッドです。
     * 
     * @return gekihenKanwaKubun
     */
    @CheckForNull
    public RString getGekihenKanwaKubun() {
        return gekihenKanwaKubun;
    }

    /**
     * gekihenKanwaKubunのsetメソッドです。
     * 
     * @param gekihenKanwaKubun gekihenKanwaKubun
     */
    public void setGekihenKanwaKubun(RString gekihenKanwaKubun) {
        this.gekihenKanwaKubun = gekihenKanwaKubun;
    }

    /**
     * yusenKubunのgetメソッドです。
     * 
     * @return yusenKubun
     */
    @CheckForNull
    public RString getYusenKubun() {
        return yusenKubun;
    }

    /**
     * yusenKubunのsetメソッドです。
     * 
     * @param yusenKubun yusenKubun
     */
    public void setYusenKubun(RString yusenKubun) {
        this.yusenKubun = yusenKubun;
    }

    /**
     * shoriTimeStampのgetメソッドです。
     * 
     * @return shoriTimeStamp
     */
    @CheckForNull
    public YMDHMS getShoriTimeStamp() {
        return shoriTimeStamp;
    }

    /**
     * shoriTimeStampのsetメソッドです。
     * 
     * @param shoriTimeStamp shoriTimeStamp
     */
    public void setShoriTimeStamp(YMDHMS shoriTimeStamp) {
        this.shoriTimeStamp = shoriTimeStamp;
    }

    /**
     * motoRirekiNoのgetメソッドです。
     * 
     * @return motoRirekiNo
     */
    @CheckForNull
    public int getMotoRirekiNo() {
        return motoRirekiNo;
    }

    /**
     * motoRirekiNoのsetメソッドです。
     * 
     * @param motoRirekiNo motoRirekiNo
     */
    public void setMotoRirekiNo(int motoRirekiNo) {
        this.motoRirekiNo = motoRirekiNo;
    }

    /**
     * torokuGyomuのgetメソッドです。
     * 
     * @return torokuGyomu
     */
    @CheckForNull
    public RString getTorokuGyomu() {
        return torokuGyomu;
    }

    /**
     * torokuGyomuのsetメソッドです。
     * 
     * @param torokuGyomu torokuGyomu
     */
    public void setTorokuGyomu(RString torokuGyomu) {
        this.torokuGyomu = torokuGyomu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV2512KaigoShotokuNewestEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV2512KaigoShotokuNewestEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV2512KaigoShotokuNewestEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV2512KaigoShotokuNewestEntity entity) {
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
        this.yusenKubun = entity.yusenKubun;
        this.shoriTimeStamp = entity.shoriTimeStamp;
        this.motoRirekiNo = entity.motoRirekiNo;
        this.torokuGyomu = entity.torokuGyomu;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shotokuNendo, shikibetsuCode, rirekiNo, kazeiKubun, kazeiKubunGemmenGo, gokeiShotokuGaku, nenkiniShunyuGaku, nenkiniShotokuGaku, kazeiShotokuGaku, gekihenKanwaKubun, yusenKubun, shoriTimeStamp, motoRirekiNo, torokuGyomu);
    }

// </editor-fold>
}
