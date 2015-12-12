package jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 介護期別徴収猶予テーブルのエンティティクラスです。
 */
public class DbT2007KibetsuChoshuYuyoEntity extends DbTableEntityBase<DbT2007KibetsuChoshuYuyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT2007KibetsuChoshuYuyo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYear choteiNendo;
    @PrimaryKey
    private FlexibleYear fukaNendo;
    @PrimaryKey
    private TsuchishoNo tsuchishoNo;
    @PrimaryKey
    private Decimal rirekiNo;
    @PrimaryKey
    private RString choshuHoho;
    @PrimaryKey
    private int ki;
    private FlexibleDate yuyoStartYMD;
    private FlexibleDate yuyoEndYMD;

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
     * 調定年度のgetメソッドです。
     *
     * @return 調定年度
     */
    public FlexibleYear getChoteiNendo() {
        return choteiNendo;
    }

    /**
     * 調定年度のsetメソッドです。
     *
     * @param choteiNendo 調定年度
     */
    public void setChoteiNendo(FlexibleYear choteiNendo) {
        this.choteiNendo = choteiNendo;
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
     * 通知書番号のgetメソッドです。
     *
     * @return 通知書番号
     */
    public TsuchishoNo getTsuchishoNo() {
        return tsuchishoNo;
    }

    /**
     * 通知書番号のsetメソッドです。
     *
     * @param tsuchishoNo 通知書番号
     */
    public void setTsuchishoNo(TsuchishoNo tsuchishoNo) {
        this.tsuchishoNo = tsuchishoNo;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public Decimal getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(Decimal rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 徴収方法のgetメソッドです。
     *
     * @return 徴収方法
     */
    public RString getChoshuHoho() {
        return choshuHoho;
    }

    /**
     * 徴収方法のsetメソッドです。
     *
     * @param choshuHoho 徴収方法
     */
    public void setChoshuHoho(RString choshuHoho) {
        this.choshuHoho = choshuHoho;
    }

    /**
     * 期のgetメソッドです。
     *
     * @return 期
     */
    public int getKi() {
        return ki;
    }

    /**
     * 期のsetメソッドです。
     *
     * @param ki 期
     */
    public void setKi(int ki) {
        this.ki = ki;
    }

    /**
     * 徴収猶予開始日のgetメソッドです。
     *
     * @return 徴収猶予開始日
     */
    public FlexibleDate getYuyoStartYMD() {
        return yuyoStartYMD;
    }

    /**
     * 徴収猶予開始日のsetメソッドです。
     *
     * @param yuyoStartYMD 徴収猶予開始日
     */
    public void setYuyoStartYMD(FlexibleDate yuyoStartYMD) {
        this.yuyoStartYMD = yuyoStartYMD;
    }

    /**
     * 徴収猶予終了日のgetメソッドです。
     *
     * @return 徴収猶予終了日
     */
    public FlexibleDate getYuyoEndYMD() {
        return yuyoEndYMD;
    }

    /**
     * 徴収猶予終了日のsetメソッドです。
     *
     * @param yuyoEndYMD 徴収猶予終了日
     */
    public void setYuyoEndYMD(FlexibleDate yuyoEndYMD) {
        this.yuyoEndYMD = yuyoEndYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2007KibetsuChoshuYuyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT2007KibetsuChoshuYuyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2007KibetsuChoshuYuyoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.choteiNendo, other.choteiNendo)) {
            return false;
        }
        if (!Objects.equals(this.fukaNendo, other.fukaNendo)) {
            return false;
        }
        if (!Objects.equals(this.tsuchishoNo, other.tsuchishoNo)) {
            return false;
        }
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        if (!Objects.equals(this.choshuHoho, other.choshuHoho)) {
            return false;
        }
        if (this.ki != other.ki) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT2007KibetsuChoshuYuyoEntity entity) {
        this.choteiNendo = entity.choteiNendo;
        this.fukaNendo = entity.fukaNendo;
        this.tsuchishoNo = entity.tsuchishoNo;
        this.rirekiNo = entity.rirekiNo;
        this.choshuHoho = entity.choshuHoho;
        this.ki = entity.ki;
        this.yuyoStartYMD = entity.yuyoStartYMD;
        this.yuyoEndYMD = entity.yuyoEndYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(choteiNendo, fukaNendo, tsuchishoNo, rirekiNo, choshuHoho, ki, yuyoStartYMD, yuyoEndYMD);
    }

// </editor-fold>
}
