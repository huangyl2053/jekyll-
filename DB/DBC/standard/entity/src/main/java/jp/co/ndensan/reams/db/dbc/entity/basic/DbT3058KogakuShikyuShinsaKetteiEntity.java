package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;

/**
 * 高額介護サービス費支給審査決定テーブルのエンティティクラスです。
 */
public class DbT3058KogakuShikyuShinsaKetteiEntity extends DbTableEntityBase<DbT3058KogakuShikyuShinsaKetteiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
     * 決定者受取年月のgetメソッドです。
     *
     * @return 決定者受取年月
     */
    public FlexibleYearMonth getKetteishaUketoriYM() {
        return ketteishaUketoriYM;
    }

    /**
     * 決定者受取年月のsetメソッドです。
     *
     * @param ketteishaUketoriYM 決定者受取年月
     */
    public void setKetteishaUketoriYM(FlexibleYearMonth ketteishaUketoriYM) {
        this.ketteishaUketoriYM = ketteishaUketoriYM;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(HokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * サービス提供年月のgetメソッドです。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * サービス提供年月のsetメソッドです。
     *
     * @param serviceTeikyoYM サービス提供年月
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * 通知書番号のgetメソッドです。
     *
     * @return 通知書番号
     */
    public RString getTsuchishoNo() {
        return tsuchishoNo;
    }

    /**
     * 通知書番号のsetメソッドです。
     *
     * @param tsuchishoNo 通知書番号
     */
    public void setTsuchishoNo(RString tsuchishoNo) {
        this.tsuchishoNo = tsuchishoNo;
    }

    /**
     * 利用者負担額のgetメソッドです。
     *
     * @return 利用者負担額
     */
    public Decimal getRiyoshaFutanGaku() {
        return riyoshaFutanGaku;
    }

    /**
     * 利用者負担額のsetメソッドです。
     *
     * @param riyoshaFutanGaku 利用者負担額
     */
    public void setRiyoshaFutanGaku(Decimal riyoshaFutanGaku) {
        this.riyoshaFutanGaku = riyoshaFutanGaku;
    }

    /**
     * 支給区分コードのgetメソッドです。
     * <br/>
     * <br/>1:支給,2:不支給
     *
     * @return 支給区分コード
     */
    public RString getShikyuKubunCode() {
        return shikyuKubunCode;
    }

    /**
     * 支給区分コードのsetメソッドです。
     * <br/>
     * <br/>1:支給,2:不支給
     *
     * @param shikyuKubunCode 支給区分コード
     */
    public void setShikyuKubunCode(RString shikyuKubunCode) {
        this.shikyuKubunCode = shikyuKubunCode;
    }

    /**
     * 決定年月のgetメソッドです。
     *
     * @return 決定年月
     */
    public FlexibleYearMonth getKetteiYM() {
        return ketteiYM;
    }

    /**
     * 決定年月のsetメソッドです。
     *
     * @param ketteiYM 決定年月
     */
    public void setKetteiYM(FlexibleYearMonth ketteiYM) {
        this.ketteiYM = ketteiYM;
    }

    /**
     * 高額支給額のgetメソッドです。
     *
     * @return 高額支給額
     */
    public Decimal getKogakuShikyuGaku() {
        return kogakuShikyuGaku;
    }

    /**
     * 高額支給額のsetメソッドです。
     *
     * @param kogakuShikyuGaku 高額支給額
     */
    public void setKogakuShikyuGaku(Decimal kogakuShikyuGaku) {
        this.kogakuShikyuGaku = kogakuShikyuGaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3058KogakuShikyuShinsaKetteiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
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
