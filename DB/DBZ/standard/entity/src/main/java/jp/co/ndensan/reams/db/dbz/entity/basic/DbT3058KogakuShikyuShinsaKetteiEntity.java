package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3058KogakuShikyuShinsaKetteiの項目定義クラスです
 *
 */
public class DbT3058KogakuShikyuShinsaKetteiEntity extends DbTableEntityBase<DbT3058KogakuShikyuShinsaKetteiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3058KogakuShikyuShinsaKettei");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYearMonth ketteishaUketoriYM;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private RString tsuchishoNo;
    private Decimal riyoshaFutanGaku;
    private RString shikyuKubunCode;
    private FlexibleYearMonth ketteiYM;
    private Decimal kogakuShikyuGaku;

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
     * getKetteishaUketoriYM
     *
     * @return ketteishaUketoriYM
     */
    public FlexibleYearMonth getKetteishaUketoriYM() {
        return ketteishaUketoriYM;
    }

    /**
     * setKetteishaUketoriYM
     *
     * @param ketteishaUketoriYM ketteishaUketoriYM
     */
    public void setKetteishaUketoriYM(FlexibleYearMonth ketteishaUketoriYM) {
        this.ketteishaUketoriYM = ketteishaUketoriYM;
    }

    /**
     * getShoKisaiHokenshaNo
     *
     * @return shoKisaiHokenshaNo
     */
    public HokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * setShoKisaiHokenshaNo
     *
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     */
    public void setShoKisaiHokenshaNo(HokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * getHihokenshaNo
     *
     * @return hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * getServiceTeikyoYM
     *
     * @return serviceTeikyoYM
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * setServiceTeikyoYM
     *
     * @param serviceTeikyoYM serviceTeikyoYM
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * getTsuchishoNo
     *
     * @return tsuchishoNo
     */
    public RString getTsuchishoNo() {
        return tsuchishoNo;
    }

    /**
     * setTsuchishoNo
     *
     * @param tsuchishoNo tsuchishoNo
     */
    public void setTsuchishoNo(RString tsuchishoNo) {
        this.tsuchishoNo = tsuchishoNo;
    }

    /**
     * getRiyoshaFutanGaku
     *
     * @return riyoshaFutanGaku
     */
    public Decimal getRiyoshaFutanGaku() {
        return riyoshaFutanGaku;
    }

    /**
     * setRiyoshaFutanGaku
     *
     * @param riyoshaFutanGaku riyoshaFutanGaku
     */
    public void setRiyoshaFutanGaku(Decimal riyoshaFutanGaku) {
        this.riyoshaFutanGaku = riyoshaFutanGaku;
    }

    /**
     * getShikyuKubunCode
     *
     * @return shikyuKubunCode
     */
    public RString getShikyuKubunCode() {
        return shikyuKubunCode;
    }

    /**
     * setShikyuKubunCode
     *
     * @param shikyuKubunCode shikyuKubunCode
     */
    public void setShikyuKubunCode(RString shikyuKubunCode) {
        this.shikyuKubunCode = shikyuKubunCode;
    }

    /**
     * getKetteiYM
     *
     * @return ketteiYM
     */
    public FlexibleYearMonth getKetteiYM() {
        return ketteiYM;
    }

    /**
     * setKetteiYM
     *
     * @param ketteiYM ketteiYM
     */
    public void setKetteiYM(FlexibleYearMonth ketteiYM) {
        this.ketteiYM = ketteiYM;
    }

    /**
     * getKogakuShikyuGaku
     *
     * @return kogakuShikyuGaku
     */
    public Decimal getKogakuShikyuGaku() {
        return kogakuShikyuGaku;
    }

    /**
     * setKogakuShikyuGaku
     *
     * @param kogakuShikyuGaku kogakuShikyuGaku
     */
    public void setKogakuShikyuGaku(Decimal kogakuShikyuGaku) {
        this.kogakuShikyuGaku = kogakuShikyuGaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3058KogakuShikyuShinsaKetteiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3058KogakuShikyuShinsaKetteiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3058KogakuShikyuShinsaKetteiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.ketteishaUketoriYM, other.ketteishaUketoriYM)) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.tsuchishoNo, other.tsuchishoNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3058KogakuShikyuShinsaKetteiEntity entity) {
        this.ketteishaUketoriYM = entity.ketteishaUketoriYM;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.tsuchishoNo = entity.tsuchishoNo;
        this.riyoshaFutanGaku = entity.riyoshaFutanGaku;
        this.shikyuKubunCode = entity.shikyuKubunCode;
        this.ketteiYM = entity.ketteiYM;
        this.kogakuShikyuGaku = entity.kogakuShikyuGaku;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(ketteishaUketoriYM, shoKisaiHokenshaNo, hihokenshaNo, serviceTeikyoYM, tsuchishoNo, riyoshaFutanGaku, shikyuKubunCode, ketteiYM, kogakuShikyuGaku);
    }

// </editor-fold>
}
