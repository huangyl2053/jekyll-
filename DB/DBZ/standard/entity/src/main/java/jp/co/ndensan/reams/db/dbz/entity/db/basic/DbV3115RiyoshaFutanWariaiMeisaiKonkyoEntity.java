package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 利用者負担割合明細根拠Newestテーブルのエンティティクラスです。
 */
public class DbV3115RiyoshaFutanWariaiMeisaiKonkyoEntity extends DbTableEntityBase<DbV3115RiyoshaFutanWariaiMeisaiKonkyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV3115RiyoshaFutanWariaiMeisaiKonkyo");

    private FlexibleYear nendo;
    private HihokenshaNo hihokenshaNo;
    private int rirekiNo;
    private boolean hakoFuyoFlag;
    private boolean shokenFlag;
    private FlexibleDate hanteiYMD;
    private RString hanteiKubun;
    private Code koseiJiyu;
    private RString hakoKubun;
    private FlexibleDate hakoYMD;
    private FlexibleDate kofuYMD;
    private boolean logicalDeletedFlag;
    private int edaNo;
    private RString shikakuKubun;
    private RString futanWariaiKubun;
    private FlexibleDate yukoKaishiYMD;
    private FlexibleDate yukoShuryoYMD;
    private Decimal honninGoukeiShotokuGaku;
    private int setaiIchigouHihokenshaSu;
    private Decimal nenkinShunyuGoukei;
    private Decimal sonotanoGoukeiShotokuKingakuGoukei;
    private RString koseiRiyu;
    private SetaiCode setaiCd;
    private boolean meisailogicalDeletedFlag;
    private HihokenshaNo setaiinHihokenshaNo;
    private int setaiinShotokuRirekiNo;

    /**
     * nendoのgetメソッドです。
     * 
     * @return nendo
     */
    @CheckForNull
    public FlexibleYear getNendo() {
        return nendo;
    }

    /**
     * nendoのsetメソッドです。
     * 
     * @param nendo nendo
     */
    public void setNendo(FlexibleYear nendo) {
        this.nendo = nendo;
    }

    /**
     * hihokenshaNoのgetメソッドです。
     * 
     * @return hihokenshaNo
     */
    @CheckForNull
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * hihokenshaNoのsetメソッドです。
     * 
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * rirekiNoのgetメソッドです。
     * 
     * @return rirekiNo
     */
    @CheckForNull
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * rirekiNoのsetメソッドです。
     * 
     * @param rirekiNo rirekiNo
     */
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * hakoFuyoFlagのgetメソッドです。
     * 
     * @return hakoFuyoFlag
     */
    @CheckForNull
    public boolean getHakoFuyoFlag() {
        return hakoFuyoFlag;
    }

    /**
     * hakoFuyoFlagのsetメソッドです。
     * 
     * @param hakoFuyoFlag hakoFuyoFlag
     */
    public void setHakoFuyoFlag(boolean hakoFuyoFlag) {
        this.hakoFuyoFlag = hakoFuyoFlag;
    }

    /**
     * shokenFlagのgetメソッドです。
     * 
     * @return shokenFlag
     */
    @CheckForNull
    public boolean getShokenFlag() {
        return shokenFlag;
    }

    /**
     * shokenFlagのsetメソッドです。
     * 
     * @param shokenFlag shokenFlag
     */
    public void setShokenFlag(boolean shokenFlag) {
        this.shokenFlag = shokenFlag;
    }

    /**
     * hanteiYMDのgetメソッドです。
     * 
     * @return hanteiYMD
     */
    @CheckForNull
    public FlexibleDate getHanteiYMD() {
        return hanteiYMD;
    }

    /**
     * hanteiYMDのsetメソッドです。
     * 
     * @param hanteiYMD hanteiYMD
     */
    public void setHanteiYMD(FlexibleDate hanteiYMD) {
        this.hanteiYMD = hanteiYMD;
    }

    /**
     * hanteiKubunのgetメソッドです。
     * 
     * @return hanteiKubun
     */
    @CheckForNull
    public RString getHanteiKubun() {
        return hanteiKubun;
    }

    /**
     * hanteiKubunのsetメソッドです。
     * 
     * @param hanteiKubun hanteiKubun
     */
    public void setHanteiKubun(RString hanteiKubun) {
        this.hanteiKubun = hanteiKubun;
    }

    /**
     * koseiJiyuのgetメソッドです。
     * 
     * @return koseiJiyu
     */
    @CheckForNull
    public Code getKoseiJiyu() {
        return koseiJiyu;
    }

    /**
     * koseiJiyuのsetメソッドです。
     * 
     * @param koseiJiyu koseiJiyu
     */
    public void setKoseiJiyu(Code koseiJiyu) {
        this.koseiJiyu = koseiJiyu;
    }

    /**
     * hakoKubunのgetメソッドです。
     * 
     * @return hakoKubun
     */
    @CheckForNull
    public RString getHakoKubun() {
        return hakoKubun;
    }

    /**
     * hakoKubunのsetメソッドです。
     * 
     * @param hakoKubun hakoKubun
     */
    public void setHakoKubun(RString hakoKubun) {
        this.hakoKubun = hakoKubun;
    }

    /**
     * hakoYMDのgetメソッドです。
     * 
     * @return hakoYMD
     */
    @CheckForNull
    public FlexibleDate getHakoYMD() {
        return hakoYMD;
    }

    /**
     * hakoYMDのsetメソッドです。
     * 
     * @param hakoYMD hakoYMD
     */
    public void setHakoYMD(FlexibleDate hakoYMD) {
        this.hakoYMD = hakoYMD;
    }

    /**
     * kofuYMDのgetメソッドです。
     * 
     * @return kofuYMD
     */
    @CheckForNull
    public FlexibleDate getKofuYMD() {
        return kofuYMD;
    }

    /**
     * kofuYMDのsetメソッドです。
     * 
     * @param kofuYMD kofuYMD
     */
    public void setKofuYMD(FlexibleDate kofuYMD) {
        this.kofuYMD = kofuYMD;
    }

    /**
     * logicalDeletedFlagのgetメソッドです。
     * 
     * @return logicalDeletedFlag
     */
    @CheckForNull
    public boolean getLogicalDeletedFlag() {
        return logicalDeletedFlag;
    }

    /**
     * logicalDeletedFlagのsetメソッドです。
     * 
     * @param logicalDeletedFlag logicalDeletedFlag
     */
    public void setLogicalDeletedFlag(boolean logicalDeletedFlag) {
        this.logicalDeletedFlag = logicalDeletedFlag;
    }

    /**
     * edaNoのgetメソッドです。
     * 
     * @return edaNo
     */
    @CheckForNull
    public int getEdaNo() {
        return edaNo;
    }

    /**
     * edaNoのsetメソッドです。
     * 
     * @param edaNo edaNo
     */
    public void setEdaNo(int edaNo) {
        this.edaNo = edaNo;
    }

    /**
     * shikakuKubunのgetメソッドです。
     * 
     * @return shikakuKubun
     */
    @CheckForNull
    public RString getShikakuKubun() {
        return shikakuKubun;
    }

    /**
     * shikakuKubunのsetメソッドです。
     * 
     * @param shikakuKubun shikakuKubun
     */
    public void setShikakuKubun(RString shikakuKubun) {
        this.shikakuKubun = shikakuKubun;
    }

    /**
     * futanWariaiKubunのgetメソッドです。
     * 
     * @return futanWariaiKubun
     */
    @CheckForNull
    public RString getFutanWariaiKubun() {
        return futanWariaiKubun;
    }

    /**
     * futanWariaiKubunのsetメソッドです。
     * 
     * @param futanWariaiKubun futanWariaiKubun
     */
    public void setFutanWariaiKubun(RString futanWariaiKubun) {
        this.futanWariaiKubun = futanWariaiKubun;
    }

    /**
     * yukoKaishiYMDのgetメソッドです。
     * 
     * @return yukoKaishiYMD
     */
    @CheckForNull
    public FlexibleDate getYukoKaishiYMD() {
        return yukoKaishiYMD;
    }

    /**
     * yukoKaishiYMDのsetメソッドです。
     * 
     * @param yukoKaishiYMD yukoKaishiYMD
     */
    public void setYukoKaishiYMD(FlexibleDate yukoKaishiYMD) {
        this.yukoKaishiYMD = yukoKaishiYMD;
    }

    /**
     * yukoShuryoYMDのgetメソッドです。
     * 
     * @return yukoShuryoYMD
     */
    @CheckForNull
    public FlexibleDate getYukoShuryoYMD() {
        return yukoShuryoYMD;
    }

    /**
     * yukoShuryoYMDのsetメソッドです。
     * 
     * @param yukoShuryoYMD yukoShuryoYMD
     */
    public void setYukoShuryoYMD(FlexibleDate yukoShuryoYMD) {
        this.yukoShuryoYMD = yukoShuryoYMD;
    }

    /**
     * honninGoukeiShotokuGakuのgetメソッドです。
     * 
     * @return honninGoukeiShotokuGaku
     */
    @CheckForNull
    public Decimal getHonninGoukeiShotokuGaku() {
        return honninGoukeiShotokuGaku;
    }

    /**
     * honninGoukeiShotokuGakuのsetメソッドです。
     * 
     * @param honninGoukeiShotokuGaku honninGoukeiShotokuGaku
     */
    public void setHonninGoukeiShotokuGaku(Decimal honninGoukeiShotokuGaku) {
        this.honninGoukeiShotokuGaku = honninGoukeiShotokuGaku;
    }

    /**
     * setaiIchigouHihokenshaSuのgetメソッドです。
     * 
     * @return setaiIchigouHihokenshaSu
     */
    @CheckForNull
    public int getSetaiIchigouHihokenshaSu() {
        return setaiIchigouHihokenshaSu;
    }

    /**
     * setaiIchigouHihokenshaSuのsetメソッドです。
     * 
     * @param setaiIchigouHihokenshaSu setaiIchigouHihokenshaSu
     */
    public void setSetaiIchigouHihokenshaSu(int setaiIchigouHihokenshaSu) {
        this.setaiIchigouHihokenshaSu = setaiIchigouHihokenshaSu;
    }

    /**
     * nenkinShunyuGoukeiのgetメソッドです。
     * 
     * @return nenkinShunyuGoukei
     */
    @CheckForNull
    public Decimal getNenkinShunyuGoukei() {
        return nenkinShunyuGoukei;
    }

    /**
     * nenkinShunyuGoukeiのsetメソッドです。
     * 
     * @param nenkinShunyuGoukei nenkinShunyuGoukei
     */
    public void setNenkinShunyuGoukei(Decimal nenkinShunyuGoukei) {
        this.nenkinShunyuGoukei = nenkinShunyuGoukei;
    }

    /**
     * sonotanoGoukeiShotokuKingakuGoukeiのgetメソッドです。
     * 
     * @return sonotanoGoukeiShotokuKingakuGoukei
     */
    @CheckForNull
    public Decimal getSonotanoGoukeiShotokuKingakuGoukei() {
        return sonotanoGoukeiShotokuKingakuGoukei;
    }

    /**
     * sonotanoGoukeiShotokuKingakuGoukeiのsetメソッドです。
     * 
     * @param sonotanoGoukeiShotokuKingakuGoukei sonotanoGoukeiShotokuKingakuGoukei
     */
    public void setSonotanoGoukeiShotokuKingakuGoukei(Decimal sonotanoGoukeiShotokuKingakuGoukei) {
        this.sonotanoGoukeiShotokuKingakuGoukei = sonotanoGoukeiShotokuKingakuGoukei;
    }

    /**
     * koseiRiyuのgetメソッドです。
     * 
     * @return koseiRiyu
     */
    @CheckForNull
    public RString getKoseiRiyu() {
        return koseiRiyu;
    }

    /**
     * koseiRiyuのsetメソッドです。
     * 
     * @param koseiRiyu koseiRiyu
     */
    public void setKoseiRiyu(RString koseiRiyu) {
        this.koseiRiyu = koseiRiyu;
    }

    /**
     * setaiCdのgetメソッドです。
     * 
     * @return setaiCd
     */
    @CheckForNull
    public SetaiCode getSetaiCd() {
        return setaiCd;
    }

    /**
     * setaiCdのsetメソッドです。
     * 
     * @param setaiCd setaiCd
     */
    public void setSetaiCd(SetaiCode setaiCd) {
        this.setaiCd = setaiCd;
    }

    /**
     * meisailogicalDeletedFlagのgetメソッドです。
     * 
     * @return meisailogicalDeletedFlag
     */
    @CheckForNull
    public boolean getMeisailogicalDeletedFlag() {
        return meisailogicalDeletedFlag;
    }

    /**
     * meisailogicalDeletedFlagのsetメソッドです。
     * 
     * @param meisailogicalDeletedFlag meisailogicalDeletedFlag
     */
    public void setMeisailogicalDeletedFlag(boolean meisailogicalDeletedFlag) {
        this.meisailogicalDeletedFlag = meisailogicalDeletedFlag;
    }

    /**
     * setaiinHihokenshaNoのgetメソッドです。
     * 
     * @return setaiinHihokenshaNo
     */
    @CheckForNull
    public HihokenshaNo getSetaiinHihokenshaNo() {
        return setaiinHihokenshaNo;
    }

    /**
     * setaiinHihokenshaNoのsetメソッドです。
     * 
     * @param setaiinHihokenshaNo setaiinHihokenshaNo
     */
    public void setSetaiinHihokenshaNo(HihokenshaNo setaiinHihokenshaNo) {
        this.setaiinHihokenshaNo = setaiinHihokenshaNo;
    }

    /**
     * setaiinShotokuRirekiNoのgetメソッドです。
     * 
     * @return setaiinShotokuRirekiNo
     */
    @CheckForNull
    public int getSetaiinShotokuRirekiNo() {
        return setaiinShotokuRirekiNo;
    }

    /**
     * setaiinShotokuRirekiNoのsetメソッドです。
     * 
     * @param setaiinShotokuRirekiNo setaiinShotokuRirekiNo
     */
    public void setSetaiinShotokuRirekiNo(int setaiinShotokuRirekiNo) {
        this.setaiinShotokuRirekiNo = setaiinShotokuRirekiNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV3115RiyoshaFutanWariaiMeisaiKonkyoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV3115RiyoshaFutanWariaiMeisaiKonkyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV3115RiyoshaFutanWariaiMeisaiKonkyoEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV3115RiyoshaFutanWariaiMeisaiKonkyoEntity entity) {
        this.nendo = entity.nendo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.hakoFuyoFlag = entity.hakoFuyoFlag;
        this.shokenFlag = entity.shokenFlag;
        this.hanteiYMD = entity.hanteiYMD;
        this.hanteiKubun = entity.hanteiKubun;
        this.koseiJiyu = entity.koseiJiyu;
        this.hakoKubun = entity.hakoKubun;
        this.hakoYMD = entity.hakoYMD;
        this.kofuYMD = entity.kofuYMD;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
        this.edaNo = entity.edaNo;
        this.shikakuKubun = entity.shikakuKubun;
        this.futanWariaiKubun = entity.futanWariaiKubun;
        this.yukoKaishiYMD = entity.yukoKaishiYMD;
        this.yukoShuryoYMD = entity.yukoShuryoYMD;
        this.honninGoukeiShotokuGaku = entity.honninGoukeiShotokuGaku;
        this.setaiIchigouHihokenshaSu = entity.setaiIchigouHihokenshaSu;
        this.nenkinShunyuGoukei = entity.nenkinShunyuGoukei;
        this.sonotanoGoukeiShotokuKingakuGoukei = entity.sonotanoGoukeiShotokuKingakuGoukei;
        this.koseiRiyu = entity.koseiRiyu;
        this.setaiCd = entity.setaiCd;
        this.meisailogicalDeletedFlag = entity.meisailogicalDeletedFlag;
        this.setaiinHihokenshaNo = entity.setaiinHihokenshaNo;
        this.setaiinShotokuRirekiNo = entity.setaiinShotokuRirekiNo;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(nendo, hihokenshaNo, rirekiNo, hakoFuyoFlag, shokenFlag, hanteiYMD, hanteiKubun, koseiJiyu, hakoKubun, hakoYMD, kofuYMD, logicalDeletedFlag, edaNo, shikakuKubun, futanWariaiKubun, yukoKaishiYMD, yukoShuryoYMD, honninGoukeiShotokuGaku, setaiIchigouHihokenshaSu, nenkinShunyuGoukei, sonotanoGoukeiShotokuKingakuGoukei, koseiRiyu, setaiCd, meisailogicalDeletedFlag, setaiinHihokenshaNo, setaiinShotokuRirekiNo);
    }

// </editor-fold>
}
