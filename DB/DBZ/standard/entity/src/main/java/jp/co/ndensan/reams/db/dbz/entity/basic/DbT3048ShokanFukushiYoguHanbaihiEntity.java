package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3048ShokanFukushiYoguHanbaihiの項目定義クラスです
 *
 */
public class DbT3048ShokanFukushiYoguHanbaihiEntity extends DbTableEntityBase<DbT3048ShokanFukushiYoguHanbaihiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3048ShokanFukushiYoguHanbaihi");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private RString seiriNo;
    @PrimaryKey
    private JigyoshaNo jigyoshaNo;
    @PrimaryKey
    private RString yoshikiNo;
    @PrimaryKey
    private RString junjiNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private ServiceCode serviceCode;
    private FlexibleDate fukushiYoguHanbaiYMD;
    private RString fukushiYoguShohinName;
    private RString fukushiYoguShumokuCode;
    private RString fukushiYoguSeizoJigyoshaName;
    private RString fukushiYoguHanbaiJigyoshaName;
    private int kounyuKingaku;
    private RString hinmokuCode;
    private RString shinsaHohoKubunCode;
    private int sagakuKingaku;

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
     * getHiHokenshaNo
     *
     * @return hiHokenshaNo
     */
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * setHiHokenshaNo
     *
     * @param hiHokenshaNo hiHokenshaNo
     */
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
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
     * getSeiriNo
     *
     * @return seiriNo
     */
    public RString getSeiriNo() {
        return seiriNo;
    }

    /**
     * setSeiriNo
     *
     * @param seiriNo seiriNo
     */
    public void setSeiriNo(RString seiriNo) {
        this.seiriNo = seiriNo;
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
     * getYoshikiNo
     *
     * @return yoshikiNo
     */
    public RString getYoshikiNo() {
        return yoshikiNo;
    }

    /**
     * setYoshikiNo
     *
     * @param yoshikiNo yoshikiNo
     */
    public void setYoshikiNo(RString yoshikiNo) {
        this.yoshikiNo = yoshikiNo;
    }

    /**
     * getJunjiNo
     *
     * @return junjiNo
     */
    public RString getJunjiNo() {
        return junjiNo;
    }

    /**
     * setJunjiNo
     *
     * @param junjiNo junjiNo
     */
    public void setJunjiNo(RString junjiNo) {
        this.junjiNo = junjiNo;
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
     * getServiceCode
     *
     * @return serviceCode
     */
    public ServiceCode getServiceCode() {
        return serviceCode;
    }

    /**
     * setServiceCode
     *
     * @param serviceCode serviceCode
     */
    public void setServiceCode(ServiceCode serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * getFukushiYoguHanbaiYMD
     *
     * @return fukushiYoguHanbaiYMD
     */
    public FlexibleDate getFukushiYoguHanbaiYMD() {
        return fukushiYoguHanbaiYMD;
    }

    /**
     * setFukushiYoguHanbaiYMD
     *
     * @param fukushiYoguHanbaiYMD fukushiYoguHanbaiYMD
     */
    public void setFukushiYoguHanbaiYMD(FlexibleDate fukushiYoguHanbaiYMD) {
        this.fukushiYoguHanbaiYMD = fukushiYoguHanbaiYMD;
    }

    /**
     * getFukushiYoguShohinName
     *
     * @return fukushiYoguShohinName
     */
    public RString getFukushiYoguShohinName() {
        return fukushiYoguShohinName;
    }

    /**
     * setFukushiYoguShohinName
     *
     * @param fukushiYoguShohinName fukushiYoguShohinName
     */
    public void setFukushiYoguShohinName(RString fukushiYoguShohinName) {
        this.fukushiYoguShohinName = fukushiYoguShohinName;
    }

    /**
     * getFukushiYoguShumokuCode
     *
     * @return fukushiYoguShumokuCode
     */
    public RString getFukushiYoguShumokuCode() {
        return fukushiYoguShumokuCode;
    }

    /**
     * setFukushiYoguShumokuCode
     *
     * @param fukushiYoguShumokuCode fukushiYoguShumokuCode
     */
    public void setFukushiYoguShumokuCode(RString fukushiYoguShumokuCode) {
        this.fukushiYoguShumokuCode = fukushiYoguShumokuCode;
    }

    /**
     * getFukushiYoguSeizoJigyoshaName
     *
     * @return fukushiYoguSeizoJigyoshaName
     */
    public RString getFukushiYoguSeizoJigyoshaName() {
        return fukushiYoguSeizoJigyoshaName;
    }

    /**
     * setFukushiYoguSeizoJigyoshaName
     *
     * @param fukushiYoguSeizoJigyoshaName fukushiYoguSeizoJigyoshaName
     */
    public void setFukushiYoguSeizoJigyoshaName(RString fukushiYoguSeizoJigyoshaName) {
        this.fukushiYoguSeizoJigyoshaName = fukushiYoguSeizoJigyoshaName;
    }

    /**
     * getFukushiYoguHanbaiJigyoshaName
     *
     * @return fukushiYoguHanbaiJigyoshaName
     */
    public RString getFukushiYoguHanbaiJigyoshaName() {
        return fukushiYoguHanbaiJigyoshaName;
    }

    /**
     * setFukushiYoguHanbaiJigyoshaName
     *
     * @param fukushiYoguHanbaiJigyoshaName fukushiYoguHanbaiJigyoshaName
     */
    public void setFukushiYoguHanbaiJigyoshaName(RString fukushiYoguHanbaiJigyoshaName) {
        this.fukushiYoguHanbaiJigyoshaName = fukushiYoguHanbaiJigyoshaName;
    }

    /**
     * getKounyuKingaku
     *
     * @return kounyuKingaku
     */
    public int getKounyuKingaku() {
        return kounyuKingaku;
    }

    /**
     * setKounyuKingaku
     *
     * @param kounyuKingaku kounyuKingaku
     */
    public void setKounyuKingaku(int kounyuKingaku) {
        this.kounyuKingaku = kounyuKingaku;
    }

    /**
     * getHinmokuCode
     *
     * @return hinmokuCode
     */
    public RString getHinmokuCode() {
        return hinmokuCode;
    }

    /**
     * setHinmokuCode
     *
     * @param hinmokuCode hinmokuCode
     */
    public void setHinmokuCode(RString hinmokuCode) {
        this.hinmokuCode = hinmokuCode;
    }

    /**
     * getShinsaHohoKubunCode
     *
     * @return shinsaHohoKubunCode
     */
    public RString getShinsaHohoKubunCode() {
        return shinsaHohoKubunCode;
    }

    /**
     * setShinsaHohoKubunCode
     *
     * @param shinsaHohoKubunCode shinsaHohoKubunCode
     */
    public void setShinsaHohoKubunCode(RString shinsaHohoKubunCode) {
        this.shinsaHohoKubunCode = shinsaHohoKubunCode;
    }

    /**
     * getSagakuKingaku
     *
     * @return sagakuKingaku
     */
    public int getSagakuKingaku() {
        return sagakuKingaku;
    }

    /**
     * setSagakuKingaku
     *
     * @param sagakuKingaku sagakuKingaku
     */
    public void setSagakuKingaku(int sagakuKingaku) {
        this.sagakuKingaku = sagakuKingaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3048ShokanFukushiYoguHanbaihiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3048ShokanFukushiYoguHanbaihiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3048ShokanFukushiYoguHanbaihiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.seiriNo, other.seiriNo)) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.yoshikiNo, other.yoshikiNo)) {
            return false;
        }
        if (!Objects.equals(this.junjiNo, other.junjiNo)) {
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
    public void shallowCopy(DbT3048ShokanFukushiYoguHanbaihiEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNo = entity.seiriNo;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yoshikiNo = entity.yoshikiNo;
        this.junjiNo = entity.junjiNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.serviceCode = entity.serviceCode;
        this.fukushiYoguHanbaiYMD = entity.fukushiYoguHanbaiYMD;
        this.fukushiYoguShohinName = entity.fukushiYoguShohinName;
        this.fukushiYoguShumokuCode = entity.fukushiYoguShumokuCode;
        this.fukushiYoguSeizoJigyoshaName = entity.fukushiYoguSeizoJigyoshaName;
        this.fukushiYoguHanbaiJigyoshaName = entity.fukushiYoguHanbaiJigyoshaName;
        this.kounyuKingaku = entity.kounyuKingaku;
        this.hinmokuCode = entity.hinmokuCode;
        this.shinsaHohoKubunCode = entity.shinsaHohoKubunCode;
        this.sagakuKingaku = entity.sagakuKingaku;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, jigyoshaNo, yoshikiNo, junjiNo, shoriTimestamp, serviceCode, fukushiYoguHanbaiYMD, fukushiYoguShohinName, fukushiYoguShumokuCode, fukushiYoguSeizoJigyoshaName, fukushiYoguHanbaiJigyoshaName, kounyuKingaku, hinmokuCode, shinsaHohoKubunCode, sagakuKingaku);
    }

// </editor-fold>
}
