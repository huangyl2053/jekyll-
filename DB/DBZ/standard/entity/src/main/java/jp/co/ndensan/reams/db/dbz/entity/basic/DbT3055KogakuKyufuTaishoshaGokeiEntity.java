package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3055KogakuKyufuTaishoshaGokeiの項目定義クラスです
 *
 */
public class DbT3055KogakuKyufuTaishoshaGokeiEntity extends DbTableEntityBase<DbT3055KogakuKyufuTaishoshaGokeiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3055KogakuKyufuTaishoshaGokei");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private Decimal serviceHiyoGokeiGakuGokei;
    private Decimal riyoshaFutanGakuGokei;
    private Decimal santeiKijunGaku;
    private Decimal shiharaiSumiKingakuGokei;
    private Decimal KogakuShikyuGaku;
    private FlexibleYearMonth tashoshaUketoriYM;
    private FlexibleYearMonth taishoshaHanteiShinsaYM;
    private RString setaiShuyakuNo;
    private boolean kyokaisoTaishoshaFlag;
    private boolean hojinKeigenTaishoFlag;
    private boolean kogakuTaishoGaiFlag;
    private boolean jidoShokanTaishoFlag;

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
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getServiceHiyoGokeiGakuGokei
     *
     * @return serviceHiyoGokeiGakuGokei
     */
    public Decimal getServiceHiyoGokeiGakuGokei() {
        return serviceHiyoGokeiGakuGokei;
    }

    /**
     * setServiceHiyoGokeiGakuGokei
     *
     * @param serviceHiyoGokeiGakuGokei serviceHiyoGokeiGakuGokei
     */
    public void setServiceHiyoGokeiGakuGokei(Decimal serviceHiyoGokeiGakuGokei) {
        this.serviceHiyoGokeiGakuGokei = serviceHiyoGokeiGakuGokei;
    }

    /**
     * getRiyoshaFutanGakuGokei
     *
     * @return riyoshaFutanGakuGokei
     */
    public Decimal getRiyoshaFutanGakuGokei() {
        return riyoshaFutanGakuGokei;
    }

    /**
     * setRiyoshaFutanGakuGokei
     *
     * @param riyoshaFutanGakuGokei riyoshaFutanGakuGokei
     */
    public void setRiyoshaFutanGakuGokei(Decimal riyoshaFutanGakuGokei) {
        this.riyoshaFutanGakuGokei = riyoshaFutanGakuGokei;
    }

    /**
     * getSanteiKijunGaku
     *
     * @return santeiKijunGaku
     */
    public Decimal getSanteiKijunGaku() {
        return santeiKijunGaku;
    }

    /**
     * setSanteiKijunGaku
     *
     * @param santeiKijunGaku santeiKijunGaku
     */
    public void setSanteiKijunGaku(Decimal santeiKijunGaku) {
        this.santeiKijunGaku = santeiKijunGaku;
    }

    /**
     * getShiharaiSumiKingakuGokei
     *
     * @return shiharaiSumiKingakuGokei
     */
    public Decimal getShiharaiSumiKingakuGokei() {
        return shiharaiSumiKingakuGokei;
    }

    /**
     * setShiharaiSumiKingakuGokei
     *
     * @param shiharaiSumiKingakuGokei shiharaiSumiKingakuGokei
     */
    public void setShiharaiSumiKingakuGokei(Decimal shiharaiSumiKingakuGokei) {
        this.shiharaiSumiKingakuGokei = shiharaiSumiKingakuGokei;
    }

    /**
     * getKogakuShikyuGaku
     *
     * @return KogakuShikyuGaku
     */
    public Decimal getKogakuShikyuGaku() {
        return KogakuShikyuGaku;
    }

    /**
     * setKogakuShikyuGaku
     *
     * @param KogakuShikyuGaku KogakuShikyuGaku
     */
    public void setKogakuShikyuGaku(Decimal KogakuShikyuGaku) {
        this.KogakuShikyuGaku = KogakuShikyuGaku;
    }

    /**
     * getTashoshaUketoriYM
     *
     * @return tashoshaUketoriYM
     */
    public FlexibleYearMonth getTashoshaUketoriYM() {
        return tashoshaUketoriYM;
    }

    /**
     * setTashoshaUketoriYM
     *
     * @param tashoshaUketoriYM tashoshaUketoriYM
     */
    public void setTashoshaUketoriYM(FlexibleYearMonth tashoshaUketoriYM) {
        this.tashoshaUketoriYM = tashoshaUketoriYM;
    }

    /**
     * getTaishoshaHanteiShinsaYM
     *
     * @return taishoshaHanteiShinsaYM
     */
    public FlexibleYearMonth getTaishoshaHanteiShinsaYM() {
        return taishoshaHanteiShinsaYM;
    }

    /**
     * setTaishoshaHanteiShinsaYM
     *
     * @param taishoshaHanteiShinsaYM taishoshaHanteiShinsaYM
     */
    public void setTaishoshaHanteiShinsaYM(FlexibleYearMonth taishoshaHanteiShinsaYM) {
        this.taishoshaHanteiShinsaYM = taishoshaHanteiShinsaYM;
    }

    /**
     * getSetaiShuyakuNo
     *
     * @return setaiShuyakuNo
     */
    public RString getSetaiShuyakuNo() {
        return setaiShuyakuNo;
    }

    /**
     * setSetaiShuyakuNo
     *
     * @param setaiShuyakuNo setaiShuyakuNo
     */
    public void setSetaiShuyakuNo(RString setaiShuyakuNo) {
        this.setaiShuyakuNo = setaiShuyakuNo;
    }

    /**
     * getKyokaisoTaishoshaFlag
     *
     * @return kyokaisoTaishoshaFlag
     */
    public boolean getKyokaisoTaishoshaFlag() {
        return kyokaisoTaishoshaFlag;
    }

    /**
     * setKyokaisoTaishoshaFlag
     *
     * @param kyokaisoTaishoshaFlag kyokaisoTaishoshaFlag
     */
    public void setKyokaisoTaishoshaFlag(boolean kyokaisoTaishoshaFlag) {
        this.kyokaisoTaishoshaFlag = kyokaisoTaishoshaFlag;
    }

    /**
     * getHojinKeigenTaishoFlag
     *
     * @return hojinKeigenTaishoFlag
     */
    public boolean getHojinKeigenTaishoFlag() {
        return hojinKeigenTaishoFlag;
    }

    /**
     * setHojinKeigenTaishoFlag
     *
     * @param hojinKeigenTaishoFlag hojinKeigenTaishoFlag
     */
    public void setHojinKeigenTaishoFlag(boolean hojinKeigenTaishoFlag) {
        this.hojinKeigenTaishoFlag = hojinKeigenTaishoFlag;
    }

    /**
     * getKogakuTaishoGaiFlag
     *
     * @return kogakuTaishoGaiFlag
     */
    public boolean getKogakuTaishoGaiFlag() {
        return kogakuTaishoGaiFlag;
    }

    /**
     * setKogakuTaishoGaiFlag
     *
     * @param kogakuTaishoGaiFlag kogakuTaishoGaiFlag
     */
    public void setKogakuTaishoGaiFlag(boolean kogakuTaishoGaiFlag) {
        this.kogakuTaishoGaiFlag = kogakuTaishoGaiFlag;
    }

    /**
     * getJidoShokanTaishoFlag
     *
     * @return jidoShokanTaishoFlag
     */
    public boolean getJidoShokanTaishoFlag() {
        return jidoShokanTaishoFlag;
    }

    /**
     * setJidoShokanTaishoFlag
     *
     * @param jidoShokanTaishoFlag jidoShokanTaishoFlag
     */
    public void setJidoShokanTaishoFlag(boolean jidoShokanTaishoFlag) {
        this.jidoShokanTaishoFlag = jidoShokanTaishoFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3055KogakuKyufuTaishoshaGokeiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3055KogakuKyufuTaishoshaGokeiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3055KogakuKyufuTaishoshaGokeiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3055KogakuKyufuTaishoshaGokeiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.serviceHiyoGokeiGakuGokei = entity.serviceHiyoGokeiGakuGokei;
        this.riyoshaFutanGakuGokei = entity.riyoshaFutanGakuGokei;
        this.santeiKijunGaku = entity.santeiKijunGaku;
        this.shiharaiSumiKingakuGokei = entity.shiharaiSumiKingakuGokei;
        this.KogakuShikyuGaku = entity.KogakuShikyuGaku;
        this.tashoshaUketoriYM = entity.tashoshaUketoriYM;
        this.taishoshaHanteiShinsaYM = entity.taishoshaHanteiShinsaYM;
        this.setaiShuyakuNo = entity.setaiShuyakuNo;
        this.kyokaisoTaishoshaFlag = entity.kyokaisoTaishoshaFlag;
        this.hojinKeigenTaishoFlag = entity.hojinKeigenTaishoFlag;
        this.kogakuTaishoGaiFlag = entity.kogakuTaishoGaiFlag;
        this.jidoShokanTaishoFlag = entity.jidoShokanTaishoFlag;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, serviceTeikyoYM, shoriTimestamp, serviceHiyoGokeiGakuGokei, riyoshaFutanGakuGokei, santeiKijunGaku, shiharaiSumiKingakuGokei, KogakuShikyuGaku, tashoshaUketoriYM, taishoshaHanteiShinsaYM, setaiShuyakuNo, kyokaisoTaishoshaFlag, hojinKeigenTaishoFlag, kogakuTaishoGaiFlag, jidoShokanTaishoFlag);
    }

// </editor-fold>
}
