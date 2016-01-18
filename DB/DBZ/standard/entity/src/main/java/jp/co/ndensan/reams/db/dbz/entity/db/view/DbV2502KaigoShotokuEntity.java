package jp.co.ndensan.reams.db.dbz.entity.db.view;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import java.util.Objects;

/**
 * 介護所得テーブルのエンティティクラスです。
 */
public class DbV2502KaigoShotokuEntity extends DbTableEntityBase<DbV2502KaigoShotokuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbV2502KaigoShotoku");

    private FlexibleYear shotokuNendo;
    private ShikibetsuCode shikibetsuCode;
    private Decimal rirekino;
    private RString kazeiKubun;
    private RString kazeiKubunGemmenGo;
    private Decimal gokeiShotokuGaku;
    private Decimal nenkiniShunyuGaku;
    private Decimal nenkiniShotokuGaku;
    private Decimal kazeiShotokuGaku;
    private RString gekihenKanwaKubun;
    private RString yusebKubun;
    private YMDHMS shoriYMD;
    private int motoRirekiNo;
    private RString torokuGyomu;

    /**
     * shotokuNendoのgetメソッドです。
     *
     * @return shotokuNendo
     */
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
     * rirekinoのgetメソッドです。
     *
     * @return rirekino
     */
    public Decimal getRirekino() {
        return rirekino;
    }

    /**
     * rirekinoのsetメソッドです。
     *
     * @param rirekino rirekino
     */
    public void setRirekino(Decimal rirekino) {
        this.rirekino = rirekino;
    }

    /**
     * kazeiKubunのgetメソッドです。
     *
     * @return kazeiKubun
     */
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
     * yusebKubunのgetメソッドです。
     *
     * @return yusebKubun
     */
    public RString getYusebKubun() {
        return yusebKubun;
    }

    /**
     * yusebKubunのsetメソッドです。
     *
     * @param yusebKubun yusebKubun
     */
    public void setYusebKubun(RString yusebKubun) {
        this.yusebKubun = yusebKubun;
    }

    /**
     * shoriYMDのgetメソッドです。
     *
     * @return shoriYMD
     */
    public YMDHMS getShoriYMD() {
        return shoriYMD;
    }

    /**
     * shoriYMDのsetメソッドです。
     *
     * @param shoriYMD shoriYMD
     */
    public void setShoriYMD(YMDHMS shoriYMD) {
        this.shoriYMD = shoriYMD;
    }

    /**
     * motoRirekiNoのgetメソッドです。
     *
     * @return motoRirekiNo
     */
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
     * このエンティティの主キーが他の{@literal DbV2502KaigoShotokuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbV2502KaigoShotokuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV2502KaigoShotokuEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV2502KaigoShotokuEntity entity) {
        this.shotokuNendo = entity.shotokuNendo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.rirekino = entity.rirekino;
        this.kazeiKubun = entity.kazeiKubun;
        this.kazeiKubunGemmenGo = entity.kazeiKubunGemmenGo;
        this.gokeiShotokuGaku = entity.gokeiShotokuGaku;
        this.nenkiniShunyuGaku = entity.nenkiniShunyuGaku;
        this.nenkiniShotokuGaku = entity.nenkiniShotokuGaku;
        this.kazeiShotokuGaku = entity.kazeiShotokuGaku;
        this.gekihenKanwaKubun = entity.gekihenKanwaKubun;
        this.yusebKubun = entity.yusebKubun;
        this.shoriYMD = entity.shoriYMD;
        this.motoRirekiNo = entity.motoRirekiNo;
        this.torokuGyomu = entity.torokuGyomu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shotokuNendo, shikibetsuCode, rirekino, kazeiKubun, kazeiKubunGemmenGo, gokeiShotokuGaku, nenkiniShunyuGaku, nenkiniShotokuGaku, kazeiShotokuGaku, gekihenKanwaKubun, yusebKubun, shoriYMD, motoRirekiNo, torokuGyomu);
    }

// </editor-fold>
}
