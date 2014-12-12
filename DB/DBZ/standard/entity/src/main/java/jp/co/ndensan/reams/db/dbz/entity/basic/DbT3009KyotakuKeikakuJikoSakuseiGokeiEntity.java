package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * DbT3009KyotakuKeikakuJikoSakuseiGokeiの項目定義クラスです
 *
 */
public class DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity extends DbTableEntityBase<DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3009KyotakuKeikakuJikoSakuseiGokei");

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
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private ShikibetsuCode shikibetsuNo;
    @PrimaryKey
    private FlexibleYearMonth taishoYM;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private RString kyotakuServiceKubun;
    private JigyoshaNo serviceTeikyoJigyoshaNo;
    private ServiceShuruiCode serviceShuruiCode;
    private Decimal kyufuKeikakuTaniSu;

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
     * getShikibetsuNo
     *
     * @return shikibetsuNo
     */
    public ShikibetsuCode getShikibetsuNo() {
        return shikibetsuNo;
    }

    /**
     * setShikibetsuNo
     *
     * @param shikibetsuNo shikibetsuNo
     */
    public void setShikibetsuNo(ShikibetsuCode shikibetsuNo) {
        this.shikibetsuNo = shikibetsuNo;
    }

    /**
     * getTaishoYM
     *
     * @return taishoYM
     */
    public FlexibleYearMonth getTaishoYM() {
        return taishoYM;
    }

    /**
     * setTaishoYM
     *
     * @param taishoYM taishoYM
     */
    public void setTaishoYM(FlexibleYearMonth taishoYM) {
        this.taishoYM = taishoYM;
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
     * getKyotakuServiceKubun
     *
     * @return kyotakuServiceKubun
     */
    public RString getKyotakuServiceKubun() {
        return kyotakuServiceKubun;
    }

    /**
     * setKyotakuServiceKubun
     *
     * @param kyotakuServiceKubun kyotakuServiceKubun
     */
    public void setKyotakuServiceKubun(RString kyotakuServiceKubun) {
        this.kyotakuServiceKubun = kyotakuServiceKubun;
    }

    /**
     * getServiceTeikyoJigyoshaNo
     *
     * @return serviceTeikyoJigyoshaNo
     */
    public JigyoshaNo getServiceTeikyoJigyoshaNo() {
        return serviceTeikyoJigyoshaNo;
    }

    /**
     * setServiceTeikyoJigyoshaNo
     *
     * @param serviceTeikyoJigyoshaNo serviceTeikyoJigyoshaNo
     */
    public void setServiceTeikyoJigyoshaNo(JigyoshaNo serviceTeikyoJigyoshaNo) {
        this.serviceTeikyoJigyoshaNo = serviceTeikyoJigyoshaNo;
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
     * getKyufuKeikakuTaniSu
     *
     * @return kyufuKeikakuTaniSu
     */
    public Decimal getKyufuKeikakuTaniSu() {
        return kyufuKeikakuTaniSu;
    }

    /**
     * setKyufuKeikakuTaniSu
     *
     * @param kyufuKeikakuTaniSu kyufuKeikakuTaniSu
     */
    public void setKyufuKeikakuTaniSu(Decimal kyufuKeikakuTaniSu) {
        this.kyufuKeikakuTaniSu = kyufuKeikakuTaniSu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuNo, other.shikibetsuNo)) {
            return false;
        }
        if (!Objects.equals(this.taishoYM, other.taishoYM)) {
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
    public void shallowCopy(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shikibetsuNo = entity.shikibetsuNo;
        this.taishoYM = entity.taishoYM;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.kyotakuServiceKubun = entity.kyotakuServiceKubun;
        this.serviceTeikyoJigyoshaNo = entity.serviceTeikyoJigyoshaNo;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.kyufuKeikakuTaniSu = entity.kyufuKeikakuTaniSu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, shoKisaiHokenshaNo, shikibetsuNo, taishoYM, shoriTimestamp, kyotakuServiceKubun, serviceTeikyoJigyoshaNo, serviceShuruiCode, kyufuKeikakuTaniSu);
    }

// </editor-fold>
}
