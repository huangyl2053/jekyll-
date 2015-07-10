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
 * DbT3049ShokanJutakuKaishuの項目定義クラスです
 *
 */
public class DbT3049ShokanJutakuKaishuEntity extends DbTableEntityBase<DbT3049ShokanJutakuKaishuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3049ShokanJutakuKaishu");

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
    private FlexibleDate jutakuKaishuChakkoYMD;
    private RString jutakuKaishuJigyoshaName;
    private RString jutakuKaishuJutakuAddress;
    private int kaishuKingaku;
    private RString shinsaHohoKubunCode;
    private FlexibleDate jutakuKaishuKanseiYMD;
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
     * getJutakuKaishuChakkoYMD
     *
     * @return jutakuKaishuChakkoYMD
     */
    public FlexibleDate getJutakuKaishuChakkoYMD() {
        return jutakuKaishuChakkoYMD;
    }

    /**
     * setJutakuKaishuChakkoYMD
     *
     * @param jutakuKaishuChakkoYMD jutakuKaishuChakkoYMD
     */
    public void setJutakuKaishuChakkoYMD(FlexibleDate jutakuKaishuChakkoYMD) {
        this.jutakuKaishuChakkoYMD = jutakuKaishuChakkoYMD;
    }

    /**
     * getJutakuKaishuJigyoshaName
     *
     * @return jutakuKaishuJigyoshaName
     */
    public RString getJutakuKaishuJigyoshaName() {
        return jutakuKaishuJigyoshaName;
    }

    /**
     * setJutakuKaishuJigyoshaName
     *
     * @param jutakuKaishuJigyoshaName jutakuKaishuJigyoshaName
     */
    public void setJutakuKaishuJigyoshaName(RString jutakuKaishuJigyoshaName) {
        this.jutakuKaishuJigyoshaName = jutakuKaishuJigyoshaName;
    }

    /**
     * getJutakuKaishuJutakuAddress
     *
     * @return jutakuKaishuJutakuAddress
     */
    public RString getJutakuKaishuJutakuAddress() {
        return jutakuKaishuJutakuAddress;
    }

    /**
     * setJutakuKaishuJutakuAddress
     *
     * @param jutakuKaishuJutakuAddress jutakuKaishuJutakuAddress
     */
    public void setJutakuKaishuJutakuAddress(RString jutakuKaishuJutakuAddress) {
        this.jutakuKaishuJutakuAddress = jutakuKaishuJutakuAddress;
    }

    /**
     * getKaishuKingaku
     *
     * @return kaishuKingaku
     */
    public int getKaishuKingaku() {
        return kaishuKingaku;
    }

    /**
     * setKaishuKingaku
     *
     * @param kaishuKingaku kaishuKingaku
     */
    public void setKaishuKingaku(int kaishuKingaku) {
        this.kaishuKingaku = kaishuKingaku;
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
     * getJutakuKaishuKanseiYMD
     *
     * @return jutakuKaishuKanseiYMD
     */
    public FlexibleDate getJutakuKaishuKanseiYMD() {
        return jutakuKaishuKanseiYMD;
    }

    /**
     * setJutakuKaishuKanseiYMD
     *
     * @param jutakuKaishuKanseiYMD jutakuKaishuKanseiYMD
     */
    public void setJutakuKaishuKanseiYMD(FlexibleDate jutakuKaishuKanseiYMD) {
        this.jutakuKaishuKanseiYMD = jutakuKaishuKanseiYMD;
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
     * このエンティティの主キーが他の{@literal DbT3049ShokanJutakuKaishuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT3049ShokanJutakuKaishuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3049ShokanJutakuKaishuEntity other) {
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
    public void shallowCopy(DbT3049ShokanJutakuKaishuEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNo = entity.seiriNo;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yoshikiNo = entity.yoshikiNo;
        this.junjiNo = entity.junjiNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.serviceCode = entity.serviceCode;
        this.jutakuKaishuChakkoYMD = entity.jutakuKaishuChakkoYMD;
        this.jutakuKaishuJigyoshaName = entity.jutakuKaishuJigyoshaName;
        this.jutakuKaishuJutakuAddress = entity.jutakuKaishuJutakuAddress;
        this.kaishuKingaku = entity.kaishuKingaku;
        this.shinsaHohoKubunCode = entity.shinsaHohoKubunCode;
        this.jutakuKaishuKanseiYMD = entity.jutakuKaishuKanseiYMD;
        this.sagakuKingaku = entity.sagakuKingaku;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, jigyoshaNo, yoshikiNo, junjiNo, shoriTimestamp, serviceCode, jutakuKaishuChakkoYMD, jutakuKaishuJigyoshaName, jutakuKaishuJutakuAddress, kaishuKingaku, shinsaHohoKubunCode, jutakuKaishuKanseiYMD, sagakuKingaku);
    }

// </editor-fold>
}
