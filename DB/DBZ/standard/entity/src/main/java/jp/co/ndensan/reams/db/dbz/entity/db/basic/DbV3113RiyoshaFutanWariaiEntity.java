package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 利用者負担割合Newestテーブルのエンティティクラスです。
 */
public class DbV3113RiyoshaFutanWariaiEntity extends DbTableEntityBase<DbV3113RiyoshaFutanWariaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV3113RiyoshaFutanWariai");

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
     * このエンティティの主キーが他の{@literal DbV3113RiyoshaFutanWariaiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV3113RiyoshaFutanWariaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV3113RiyoshaFutanWariaiEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV3113RiyoshaFutanWariaiEntity entity) {
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
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(nendo, hihokenshaNo, rirekiNo, hakoFuyoFlag, shokenFlag, hanteiYMD, hanteiKubun, koseiJiyu, hakoKubun, hakoYMD, kofuYMD, logicalDeletedFlag);
    }

// </editor-fold>
}
