package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * 高額介護サービス費給付対象者合計テーブルのエンティティクラスです。
 */
public class DbT3055KogakuKyufuTaishoshaGokeiEntity extends DbTableEntityBase<DbT3055KogakuKyufuTaishoshaGokeiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
    private Decimal rirekiNo;
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
     * サービス費用合計額合計のgetメソッドです。
     *
     * @return サービス費用合計額合計
     */
    public Decimal getServiceHiyoGokeiGakuGokei() {
        return serviceHiyoGokeiGakuGokei;
    }

    /**
     * サービス費用合計額合計のsetメソッドです。
     *
     * @param serviceHiyoGokeiGakuGokei サービス費用合計額合計
     */
    public void setServiceHiyoGokeiGakuGokei(Decimal serviceHiyoGokeiGakuGokei) {
        this.serviceHiyoGokeiGakuGokei = serviceHiyoGokeiGakuGokei;
    }

    /**
     * 利用者負担額合計のgetメソッドです。
     *
     * @return 利用者負担額合計
     */
    public Decimal getRiyoshaFutanGakuGokei() {
        return riyoshaFutanGakuGokei;
    }

    /**
     * 利用者負担額合計のsetメソッドです。
     *
     * @param riyoshaFutanGakuGokei 利用者負担額合計
     */
    public void setRiyoshaFutanGakuGokei(Decimal riyoshaFutanGakuGokei) {
        this.riyoshaFutanGakuGokei = riyoshaFutanGakuGokei;
    }

    /**
     * 算定基準額のgetメソッドです。
     *
     * @return 算定基準額
     */
    public Decimal getSanteiKijunGaku() {
        return santeiKijunGaku;
    }

    /**
     * 算定基準額のsetメソッドです。
     *
     * @param santeiKijunGaku 算定基準額
     */
    public void setSanteiKijunGaku(Decimal santeiKijunGaku) {
        this.santeiKijunGaku = santeiKijunGaku;
    }

    /**
     * 支払済金額合計のgetメソッドです。
     *
     * @return 支払済金額合計
     */
    public Decimal getShiharaiSumiKingakuGokei() {
        return shiharaiSumiKingakuGokei;
    }

    /**
     * 支払済金額合計のsetメソッドです。
     *
     * @param shiharaiSumiKingakuGokei 支払済金額合計
     */
    public void setShiharaiSumiKingakuGokei(Decimal shiharaiSumiKingakuGokei) {
        this.shiharaiSumiKingakuGokei = shiharaiSumiKingakuGokei;
    }

    /**
     * 高額支給額のgetメソッドです。
     *
     * @return 高額支給額
     */
    public Decimal getKogakuShikyuGaku() {
        return KogakuShikyuGaku;
    }

    /**
     * 高額支給額のsetメソッドです。
     *
     * @param KogakuShikyuGaku 高額支給額
     */
    public void setKogakuShikyuGaku(Decimal KogakuShikyuGaku) {
        this.KogakuShikyuGaku = KogakuShikyuGaku;
    }

    /**
     * 対象者受取年月のgetメソッドです。
     *
     * @return 対象者受取年月
     */
    public FlexibleYearMonth getTashoshaUketoriYM() {
        return tashoshaUketoriYM;
    }

    /**
     * 対象者受取年月のsetメソッドです。
     *
     * @param tashoshaUketoriYM 対象者受取年月
     */
    public void setTashoshaUketoriYM(FlexibleYearMonth tashoshaUketoriYM) {
        this.tashoshaUketoriYM = tashoshaUketoriYM;
    }

    /**
     * 対象者判定審査年月のgetメソッドです。
     *
     * @return 対象者判定審査年月
     */
    public FlexibleYearMonth getTaishoshaHanteiShinsaYM() {
        return taishoshaHanteiShinsaYM;
    }

    /**
     * 対象者判定審査年月のsetメソッドです。
     *
     * @param taishoshaHanteiShinsaYM 対象者判定審査年月
     */
    public void setTaishoshaHanteiShinsaYM(FlexibleYearMonth taishoshaHanteiShinsaYM) {
        this.taishoshaHanteiShinsaYM = taishoshaHanteiShinsaYM;
    }

    /**
     * 世帯集約番号のgetメソッドです。
     *
     * @return 世帯集約番号
     */
    public RString getSetaiShuyakuNo() {
        return setaiShuyakuNo;
    }

    /**
     * 世帯集約番号のsetメソッドです。
     *
     * @param setaiShuyakuNo 世帯集約番号
     */
    public void setSetaiShuyakuNo(RString setaiShuyakuNo) {
        this.setaiShuyakuNo = setaiShuyakuNo;
    }

    /**
     * 境界層対象者フラグのgetメソッドです。
     * <br/>
     * <br/>True:対象,False:対象外
     *
     * @return 境界層対象者フラグ
     */
    public boolean getKyokaisoTaishoshaFlag() {
        return kyokaisoTaishoshaFlag;
    }

    /**
     * 境界層対象者フラグのsetメソッドです。
     * <br/>
     * <br/>True:対象,False:対象外
     *
     * @param kyokaisoTaishoshaFlag 境界層対象者フラグ
     */
    public void setKyokaisoTaishoshaFlag(boolean kyokaisoTaishoshaFlag) {
        this.kyokaisoTaishoshaFlag = kyokaisoTaishoshaFlag;
    }

    /**
     * 社会福祉法人軽減対象フラグのgetメソッドです。
     * <br/>
     * <br/>True:対象,False:対象外
     *
     * @return 社会福祉法人軽減対象フラグ
     */
    public boolean getHojinKeigenTaishoFlag() {
        return hojinKeigenTaishoFlag;
    }

    /**
     * 社会福祉法人軽減対象フラグのsetメソッドです。
     * <br/>
     * <br/>True:対象,False:対象外
     *
     * @param hojinKeigenTaishoFlag 社会福祉法人軽減対象フラグ
     */
    public void setHojinKeigenTaishoFlag(boolean hojinKeigenTaishoFlag) {
        this.hojinKeigenTaishoFlag = hojinKeigenTaishoFlag;
    }

    /**
     * 高額対象外フラグのgetメソッドです。
     * <br/>
     * <br/>True:対象外,False:対象
     *
     * @return 高額対象外フラグ
     */
    public boolean getKogakuTaishoGaiFlag() {
        return kogakuTaishoGaiFlag;
    }

    /**
     * 高額対象外フラグのsetメソッドです。
     * <br/>
     * <br/>True:対象外,False:対象
     *
     * @param kogakuTaishoGaiFlag 高額対象外フラグ
     */
    public void setKogakuTaishoGaiFlag(boolean kogakuTaishoGaiFlag) {
        this.kogakuTaishoGaiFlag = kogakuTaishoGaiFlag;
    }

    /**
     * 自動償還対象フラグのgetメソッドです。
     * <br/>
     * <br/>True:対象,False:対象外
     *
     * @return 自動償還対象フラグ
     */
    public boolean getJidoShokanTaishoFlag() {
        return jidoShokanTaishoFlag;
    }

    /**
     * 自動償還対象フラグのsetメソッドです。
     * <br/>
     * <br/>True:対象,False:対象外
     *
     * @param jidoShokanTaishoFlag 自動償還対象フラグ
     */
    public void setJidoShokanTaishoFlag(boolean jidoShokanTaishoFlag) {
        this.jidoShokanTaishoFlag = jidoShokanTaishoFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3055KogakuKyufuTaishoshaGokeiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
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
        if (this.rirekiNo != other.rirekiNo) {
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
        this.rirekiNo = entity.rirekiNo;
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
        return super.toMd5(hihokenshaNo, serviceTeikyoYM, rirekiNo, serviceHiyoGokeiGakuGokei, riyoshaFutanGakuGokei, santeiKijunGaku, shiharaiSumiKingakuGokei, KogakuShikyuGaku, tashoshaUketoriYM, taishoshaHanteiShinsaYM, setaiShuyakuNo, kyokaisoTaishoshaFlag, hojinKeigenTaishoFlag, kogakuTaishoGaiFlag, jidoShokanTaishoFlag);
    }

// </editor-fold>
}
