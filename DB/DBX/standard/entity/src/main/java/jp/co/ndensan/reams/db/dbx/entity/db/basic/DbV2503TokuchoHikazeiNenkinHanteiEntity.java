package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 特徴非課税年金判定テーブルのエンティティクラスです。
 */
public class DbV2503TokuchoHikazeiNenkinHanteiEntity extends DbTableEntityBase<DbV2503TokuchoHikazeiNenkinHanteiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV2503TokuchoHikazeiNenkinHantei");

    private TsuchishoNo tsuchishoNo;
    private FlexibleYear choteiNendo;
    private FlexibleYear kazeiNendo;
    private int ki;
    private boolean isHikazeiNenkin;

    /**
     * tsuchishoNoのgetメソッドです。
     * 
     * @return tsuchishoNo
     */
    @CheckForNull
    public TsuchishoNo getTsuchishoNo() {
        return tsuchishoNo;
    }

    /**
     * tsuchishoNoのsetメソッドです。
     * 
     * @param tsuchishoNo tsuchishoNo
     */
    public void setTsuchishoNo(TsuchishoNo tsuchishoNo) {
        this.tsuchishoNo = tsuchishoNo;
    }

    /**
     * choteiNendoのgetメソッドです。
     * 
     * @return choteiNendo
     */
    @CheckForNull
    public FlexibleYear getChoteiNendo() {
        return choteiNendo;
    }

    /**
     * choteiNendoのsetメソッドです。
     * 
     * @param choteiNendo choteiNendo
     */
    public void setChoteiNendo(FlexibleYear choteiNendo) {
        this.choteiNendo = choteiNendo;
    }

    /**
     * kazeiNendoのgetメソッドです。
     * 
     * @return kazeiNendo
     */
    @CheckForNull
    public FlexibleYear getKazeiNendo() {
        return kazeiNendo;
    }

    /**
     * kazeiNendoのsetメソッドです。
     * 
     * @param kazeiNendo kazeiNendo
     */
    public void setKazeiNendo(FlexibleYear kazeiNendo) {
        this.kazeiNendo = kazeiNendo;
    }

    /**
     * kiのgetメソッドです。
     * 
     * @return ki
     */
    @CheckForNull
    public int getKi() {
        return ki;
    }

    /**
     * kiのsetメソッドです。
     * 
     * @param ki ki
     */
    public void setKi(int ki) {
        this.ki = ki;
    }

    /**
     * isHikazeiNenkinのgetメソッドです。
     * 
     * @return isHikazeiNenkin
     */
    @CheckForNull
    public boolean getIsHikazeiNenkin() {
        return isHikazeiNenkin;
    }

    /**
     * isHikazeiNenkinのsetメソッドです。
     * 
     * @param isHikazeiNenkin isHikazeiNenkin
     */
    public void setIsHikazeiNenkin(boolean isHikazeiNenkin) {
        this.isHikazeiNenkin = isHikazeiNenkin;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV2503TokuchoHikazeiNenkinHanteiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV2503TokuchoHikazeiNenkinHanteiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV2503TokuchoHikazeiNenkinHanteiEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV2503TokuchoHikazeiNenkinHanteiEntity entity) {
        this.tsuchishoNo = entity.tsuchishoNo;
        this.choteiNendo = entity.choteiNendo;
        this.kazeiNendo = entity.kazeiNendo;
        this.ki = entity.ki;
        this.isHikazeiNenkin = entity.isHikazeiNenkin;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(tsuchishoNo, choteiNendo, kazeiNendo, ki, isHikazeiNenkin);
    }

// </editor-fold>
}
