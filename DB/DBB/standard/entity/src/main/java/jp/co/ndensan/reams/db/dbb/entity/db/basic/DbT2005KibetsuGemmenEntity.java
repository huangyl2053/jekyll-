package jp.co.ndensan.reams.db.dbb.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;

/**
 * 介護期別減免テーブルのエンティティクラスです。
 */
public class DbT2005KibetsuGemmenEntity extends DbTableEntityBase<DbT2005KibetsuGemmenEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT2005KibetsuGemmen");

    private RString insertDantaiCd;
    @PrimaryKey
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
    private RDateTime shoriTimestamp;
    @PrimaryKey
    private RString choshuHoho;
    @PrimaryKey
    private int ki;
    private Decimal gemmenMaeKibetsuGaku;
    private Decimal KibetsugemmenGaku;

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
     * 処理日時のgetメソッドです。
     *
     * @return 処理日時
     */
    public RDateTime getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * 処理日時のsetメソッドです。
     *
     * @param shoriTimestamp 処理日時
     */
    public void setShoriTimestamp(RDateTime shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
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
     * 減免前期別介護保険料のgetメソッドです。
     *
     * @return 減免前期別介護保険料
     */
    public Decimal getGemmenMaeKibetsuGaku() {
        return gemmenMaeKibetsuGaku;
    }

    /**
     * 減免前期別介護保険料のsetメソッドです。
     *
     * @param gemmenMaeKibetsuGaku 減免前期別介護保険料
     */
    public void setGemmenMaeKibetsuGaku(Decimal gemmenMaeKibetsuGaku) {
        this.gemmenMaeKibetsuGaku = gemmenMaeKibetsuGaku;
    }

    /**
     * 期別減免額のgetメソッドです。
     *
     * @return 期別減免額
     */
    public Decimal getKibetsugemmenGaku() {
        return KibetsugemmenGaku;
    }

    /**
     * 期別減免額のsetメソッドです。
     *
     * @param KibetsugemmenGaku 期別減免額
     */
    public void setKibetsugemmenGaku(Decimal KibetsugemmenGaku) {
        this.KibetsugemmenGaku = KibetsugemmenGaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2005KibetsuGemmenEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT2005KibetsuGemmenEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2005KibetsuGemmenEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.insertTimestamp, other.insertTimestamp)) {
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
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
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
    public void shallowCopy(DbT2005KibetsuGemmenEntity entity) {
        this.choteiNendo = entity.choteiNendo;
        this.fukaNendo = entity.fukaNendo;
        this.tsuchishoNo = entity.tsuchishoNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.choshuHoho = entity.choshuHoho;
        this.ki = entity.ki;
        this.gemmenMaeKibetsuGaku = entity.gemmenMaeKibetsuGaku;
        this.KibetsugemmenGaku = entity.KibetsugemmenGaku;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(choteiNendo, fukaNendo, tsuchishoNo, shoriTimestamp, choshuHoho, ki, gemmenMaeKibetsuGaku, KibetsugemmenGaku);
    }

// </editor-fold>
}
