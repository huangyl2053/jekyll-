package jp.co.ndensan.reams.db.dbx.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.OnRshareSchema;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DbV3057KogakuShikyuHanteiKekkaの項目定義クラスです
 *
 * @author 自動生成
 * @jpName 高額支給判定結果ビューエンティティ
 * @bizDomain 介護
 * @category 高額介護給付費
 * @subCategory
 * @mainClass
 * @reference
 * @author n8178 城間篤人
 * @jpName 高額支給判定結果ビューエンティティ
 * @bizDomain 介護
 * @category 高額介護給付費
 * @subCategory
 * @mainClass
 * @reference
 */
@OnRshareSchema
public class DbV3057KogakuShikyuHanteiKekkaEntity extends DbTableEntityBase<DbV3057KogakuShikyuHanteiKekkaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">

    @TableName
    public static final RString TABLE_NAME = new RString("DbV3057KogakuShikyuHanteiKekka");

    private RString hihokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private RString shoKisaiHokenshaNo;
    private RDateTime shoriTimestamp;
    private Decimal honninShiharaiGaku;
    private RString shiharaiKubunCode;
    private Decimal shiharaiKingaku;
    private RString shinsaKekkaHaneiKubun;

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

    /**
     * このエンティティの主キーが他の{@literal DbV3057KogakuShikyuHanteiKekkaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbV3057KogakuShikyuHanteiKekkaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV3057KogakuShikyuHanteiKekkaEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV3057KogakuShikyuHanteiKekkaEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.honninShiharaiGaku = entity.honninShiharaiGaku;
        this.shiharaiKubunCode = entity.shiharaiKubunCode;
        this.shiharaiKingaku = entity.shiharaiKingaku;
        this.shinsaKekkaHaneiKubun = entity.shinsaKekkaHaneiKubun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, serviceTeikyoYM, shoKisaiHokenshaNo, shoriTimestamp, honninShiharaiGaku, shiharaiKubunCode, shiharaiKingaku, shinsaKekkaHaneiKubun);
    }

// </editor-fold>
}
