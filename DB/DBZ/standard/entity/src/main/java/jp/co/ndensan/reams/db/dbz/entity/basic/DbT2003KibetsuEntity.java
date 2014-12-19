package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT2003Kibetsuの項目定義クラスです
 *
 */
public class DbT2003KibetsuEntity extends DbTableEntityBase<DbT2003KibetsuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT2003Kibetsu");

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
    private Decimal choteiId;

    /**
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getChoteiNendo
     *
     * @return choteiNendo
     */
    public FlexibleYear getChoteiNendo() {
        return choteiNendo;
    }

    /**
     * setChoteiNendo
     *
     * @param choteiNendo choteiNendo
     */
    public void setChoteiNendo(FlexibleYear choteiNendo) {
        this.choteiNendo = choteiNendo;
    }

    /**
     * getFukaNendo
     *
     * @return fukaNendo
     */
    public FlexibleYear getFukaNendo() {
        return fukaNendo;
    }

    /**
     * setFukaNendo
     *
     * @param fukaNendo fukaNendo
     */
    public void setFukaNendo(FlexibleYear fukaNendo) {
        this.fukaNendo = fukaNendo;
    }

    /**
     * getTsuchishoNo
     *
     * @return tsuchishoNo
     */
    public TsuchishoNo getTsuchishoNo() {
        return tsuchishoNo;
    }

    /**
     * setTsuchishoNo
     *
     * @param tsuchishoNo tsuchishoNo
     */
    public void setTsuchishoNo(TsuchishoNo tsuchishoNo) {
        this.tsuchishoNo = tsuchishoNo;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public RDateTime getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(RDateTime shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getChoshuHoho
     *
     * @return choshuHoho
     */
    public RString getChoshuHoho() {
        return choshuHoho;
    }

    /**
     * setChoshuHoho
     *
     * @param choshuHoho choshuHoho
     */
    public void setChoshuHoho(RString choshuHoho) {
        this.choshuHoho = choshuHoho;
    }

    /**
     * getKi
     *
     * @return ki
     */
    public int getKi() {
        return ki;
    }

    /**
     * setKi
     *
     * @param ki ki
     */
    public void setKi(int ki) {
        this.ki = ki;
    }

    /**
     * getChoteiId
     *
     * @return choteiId
     */
    public Decimal getChoteiId() {
        return choteiId;
    }

    /**
     * setChoteiId
     *
     * @param choteiId choteiId
     */
    public void setChoteiId(Decimal choteiId) {
        this.choteiId = choteiId;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2003KibetsuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT2003KibetsuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2003KibetsuEntity other) {
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
    public void shallowCopy(DbT2003KibetsuEntity entity) {
        this.choteiNendo = entity.choteiNendo;
        this.fukaNendo = entity.fukaNendo;
        this.tsuchishoNo = entity.tsuchishoNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.choshuHoho = entity.choshuHoho;
        this.ki = entity.ki;
        this.choteiId = entity.choteiId;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(choteiNendo, fukaNendo, tsuchishoNo, shoriTimestamp, choshuHoho, ki, choteiId);
    }

// </editor-fold>
}
