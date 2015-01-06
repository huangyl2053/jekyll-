package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
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
 * DbT3054KogakuKyufuTaishoshaMeisaiの項目定義クラスです
 *
 */
public class DbT3054KogakuKyufuTaishoshaMeisaiEntity extends DbTableEntityBase<DbT3054KogakuKyufuTaishoshaMeisaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3054KogakuKyufuTaishoshaMeisai");

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
    private JigyoshaNo jigyoshaNo;
    @PrimaryKey
    private ServiceShuruiCode serviceShuruiCode;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private Decimal serviceHiyoGokeiGaku;
    private Decimal riyoshaFutanGaku;
    private RString kogakuKyufuKonkyo;

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
     * getJigyoshaNo
     *
     * @return jigyoshaNo
     */
    public JigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * setJigyoshaNo
     *
     * @param jigyoshaNo jigyoshaNo
     */
    public void setJigyoshaNo(JigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * getServiceShuruiCode
     *
     * @return serviceShuruiCode
     */
    public ServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * setServiceShuruiCode
     *
     * @param serviceShuruiCode serviceShuruiCode
     */
    public void setServiceShuruiCode(ServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
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
     * getServiceHiyoGokeiGaku
     *
     * @return serviceHiyoGokeiGaku
     */
    public Decimal getServiceHiyoGokeiGaku() {
        return serviceHiyoGokeiGaku;
    }

    /**
     * setServiceHiyoGokeiGaku
     *
     * @param serviceHiyoGokeiGaku serviceHiyoGokeiGaku
     */
    public void setServiceHiyoGokeiGaku(Decimal serviceHiyoGokeiGaku) {
        this.serviceHiyoGokeiGaku = serviceHiyoGokeiGaku;
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
     * getKogakuKyufuKonkyo
     *
     * @return kogakuKyufuKonkyo
     */
    public RString getKogakuKyufuKonkyo() {
        return kogakuKyufuKonkyo;
    }

    /**
     * setKogakuKyufuKonkyo
     *
     * @param kogakuKyufuKonkyo kogakuKyufuKonkyo
     */
    public void setKogakuKyufuKonkyo(RString kogakuKyufuKonkyo) {
        this.kogakuKyufuKonkyo = kogakuKyufuKonkyo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3054KogakuKyufuTaishoshaMeisaiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3054KogakuKyufuTaishoshaMeisaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3054KogakuKyufuTaishoshaMeisaiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceShuruiCode, other.serviceShuruiCode)) {
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
    public void shallowCopy(DbT3054KogakuKyufuTaishoshaMeisaiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.serviceHiyoGokeiGaku = entity.serviceHiyoGokeiGaku;
        this.riyoshaFutanGaku = entity.riyoshaFutanGaku;
        this.kogakuKyufuKonkyo = entity.kogakuKyufuKonkyo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, serviceTeikyoYM, jigyoshaNo, serviceShuruiCode, shoriTimestamp, serviceHiyoGokeiGaku, riyoshaFutanGaku, kogakuKyufuKonkyo);
    }

// </editor-fold>
}
