package jp.co.ndensan.reams.db.dbx.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DbT3057KogakuShikyuHanteiKekkaの項目定義クラスです
 *
 * @author 自動生成
 * @jpName 高額支給判定結果エンティティ
 * @bizDomain 介護
 * @category 高額介護給付費
 * @subCategory
 * @mainClass
 * @reference
 * @author n8178 城間篤人
 * @jpName 高額支給判定結果エンティティ
 * @bizDomain 介護
 * @category 高額介護給付費
 * @subCategory
 * @mainClass
 * @reference
 */
public class DbT3057KogakuShikyuHanteiKekkaEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3057KogakuShikyuHanteiKekka");
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
    private RString hihokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private RString shoKisaiHokenshaNo;
    @PrimaryKey
    private RDateTime shoriTimestamp;
    private Decimal honninShiharaiGaku;
    private RString shiharaiKubunCode;
    private Decimal shiharaiKingaku;
    private RString shinsaKekkaHaneiKubun;

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
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(RString hihokenshaNo) {
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
     * getShoKisaiHokenshaNo
     *
     * @return shoKisaiHokenshaNo
     */
    public RString getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * setShoKisaiHokenshaNo
     *
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     */
    public void setShoKisaiHokenshaNo(RString shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
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
     * getHonninShiharaiGaku
     *
     * @return honninShiharaiGaku
     */
    public Decimal getHonninShiharaiGaku() {
        return honninShiharaiGaku;
    }

    /**
     * setHonninShiharaiGaku
     *
     * @param honninShiharaiGaku honninShiharaiGaku
     */
    public void setHonninShiharaiGaku(Decimal honninShiharaiGaku) {
        this.honninShiharaiGaku = honninShiharaiGaku;
    }

    /**
     * getShiharaiKubunCode
     *
     * @return shiharaiKubunCode
     */
    public RString getShiharaiKubunCode() {
        return shiharaiKubunCode;
    }

    /**
     * setShiharaiKubunCode
     *
     * @param shiharaiKubunCode shiharaiKubunCode
     */
    public void setShiharaiKubunCode(RString shiharaiKubunCode) {
        this.shiharaiKubunCode = shiharaiKubunCode;
    }

    /**
     * getShiharaiKingaku
     *
     * @return shiharaiKingaku
     */
    public Decimal getShiharaiKingaku() {
        return shiharaiKingaku;
    }

    /**
     * setShiharaiKingaku
     *
     * @param shiharaiKingaku shiharaiKingaku
     */
    public void setShiharaiKingaku(Decimal shiharaiKingaku) {
        this.shiharaiKingaku = shiharaiKingaku;
    }

    /**
     * getShinsaKekkaHaneiKubun
     *
     * @return shinsaKekkaHaneiKubun
     */
    public RString getShinsaKekkaHaneiKubun() {
        return shinsaKekkaHaneiKubun;
    }

    /**
     * setShinsaKekkaHaneiKubun
     *
     * @param shinsaKekkaHaneiKubun shinsaKekkaHaneiKubun
     */
    public void setShinsaKekkaHaneiKubun(RString shinsaKekkaHaneiKubun) {
        this.shinsaKekkaHaneiKubun = shinsaKekkaHaneiKubun;
    }
// </editor-fold>
}
