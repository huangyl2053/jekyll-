package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3034ShokanShinseiの項目定義クラスです
 *
 */
public class DbT3034ShokanShinseiEntity extends DbTableEntityBase<DbT3034ShokanShinseiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3034ShokanShinsei");

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
    private YMDHMS shoriTimestamp;
    private HokenshaNo shoKisaiHokenshaNo;
    private FlexibleDate uketsukeYMD;
    private FlexibleDate shinseiYMD;
    private RString shinseiRiyu;
    private RString shinseishaKubun;
    private RString shinseishaNameKanji;
    private RString shinseishaNameKana;
    private RString shinseishaAddress;
    private RString shinseishaTelNo;
    private RString shinseiJigyoshaCode;
    private Decimal shiharaiKingakuTotal;
    private int hokenKyufuritsu;
    private int riyoshaFutangaku;
    private RString shikyuShinseiShinsaKubun;
    private RString shinsaHohoKubun;
    private FlexibleYearMonth sofuYM;

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
     * getUketsukeYMD
     *
     * @return uketsukeYMD
     */
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * setUketsukeYMD
     *
     * @param uketsukeYMD uketsukeYMD
     */
    public void setUketsukeYMD(FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
    }

    /**
     * getShinseiYMD
     *
     * @return shinseiYMD
     */
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * setShinseiYMD
     *
     * @param shinseiYMD shinseiYMD
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * getShinseiRiyu
     *
     * @return shinseiRiyu
     */
    public RString getShinseiRiyu() {
        return shinseiRiyu;
    }

    /**
     * setShinseiRiyu
     *
     * @param shinseiRiyu shinseiRiyu
     */
    public void setShinseiRiyu(RString shinseiRiyu) {
        this.shinseiRiyu = shinseiRiyu;
    }

    /**
     * getShinseishaKubun
     *
     * @return shinseishaKubun
     */
    public RString getShinseishaKubun() {
        return shinseishaKubun;
    }

    /**
     * setShinseishaKubun
     *
     * @param shinseishaKubun shinseishaKubun
     */
    public void setShinseishaKubun(RString shinseishaKubun) {
        this.shinseishaKubun = shinseishaKubun;
    }

    /**
     * getShinseishaNameKanji
     *
     * @return shinseishaNameKanji
     */
    public RString getShinseishaNameKanji() {
        return shinseishaNameKanji;
    }

    /**
     * setShinseishaNameKanji
     *
     * @param shinseishaNameKanji shinseishaNameKanji
     */
    public void setShinseishaNameKanji(RString shinseishaNameKanji) {
        this.shinseishaNameKanji = shinseishaNameKanji;
    }

    /**
     * getShinseishaNameKana
     *
     * @return shinseishaNameKana
     */
    public RString getShinseishaNameKana() {
        return shinseishaNameKana;
    }

    /**
     * setShinseishaNameKana
     *
     * @param shinseishaNameKana shinseishaNameKana
     */
    public void setShinseishaNameKana(RString shinseishaNameKana) {
        this.shinseishaNameKana = shinseishaNameKana;
    }

    /**
     * getShinseishaAddress
     *
     * @return shinseishaAddress
     */
    public RString getShinseishaAddress() {
        return shinseishaAddress;
    }

    /**
     * setShinseishaAddress
     *
     * @param shinseishaAddress shinseishaAddress
     */
    public void setShinseishaAddress(RString shinseishaAddress) {
        this.shinseishaAddress = shinseishaAddress;
    }

    /**
     * getShinseishaTelNo
     *
     * @return shinseishaTelNo
     */
    public RString getShinseishaTelNo() {
        return shinseishaTelNo;
    }

    /**
     * setShinseishaTelNo
     *
     * @param shinseishaTelNo shinseishaTelNo
     */
    public void setShinseishaTelNo(RString shinseishaTelNo) {
        this.shinseishaTelNo = shinseishaTelNo;
    }

    /**
     * getShinseiJigyoshaCode
     *
     * @return shinseiJigyoshaCode
     */
    public RString getShinseiJigyoshaCode() {
        return shinseiJigyoshaCode;
    }

    /**
     * setShinseiJigyoshaCode
     *
     * @param shinseiJigyoshaCode shinseiJigyoshaCode
     */
    public void setShinseiJigyoshaCode(RString shinseiJigyoshaCode) {
        this.shinseiJigyoshaCode = shinseiJigyoshaCode;
    }

    /**
     * getShiharaiKingakuTotal
     *
     * @return shiharaiKingakuTotal
     */
    public Decimal getShiharaiKingakuTotal() {
        return shiharaiKingakuTotal;
    }

    /**
     * setShiharaiKingakuTotal
     *
     * @param shiharaiKingakuTotal shiharaiKingakuTotal
     */
    public void setShiharaiKingakuTotal(Decimal shiharaiKingakuTotal) {
        this.shiharaiKingakuTotal = shiharaiKingakuTotal;
    }

    /**
     * getHokenKyufuritsu
     *
     * @return hokenKyufuritsu
     */
    public int getHokenKyufuritsu() {
        return hokenKyufuritsu;
    }

    /**
     * setHokenKyufuritsu
     *
     * @param hokenKyufuritsu hokenKyufuritsu
     */
    public void setHokenKyufuritsu(int hokenKyufuritsu) {
        this.hokenKyufuritsu = hokenKyufuritsu;
    }

    /**
     * getRiyoshaFutangaku
     *
     * @return riyoshaFutangaku
     */
    public int getRiyoshaFutangaku() {
        return riyoshaFutangaku;
    }

    /**
     * setRiyoshaFutangaku
     *
     * @param riyoshaFutangaku riyoshaFutangaku
     */
    public void setRiyoshaFutangaku(int riyoshaFutangaku) {
        this.riyoshaFutangaku = riyoshaFutangaku;
    }

    /**
     * getShikyuShinseiShinsaKubun
     *
     * @return shikyuShinseiShinsaKubun
     */
    public RString getShikyuShinseiShinsaKubun() {
        return shikyuShinseiShinsaKubun;
    }

    /**
     * setShikyuShinseiShinsaKubun
     *
     * @param shikyuShinseiShinsaKubun shikyuShinseiShinsaKubun
     */
    public void setShikyuShinseiShinsaKubun(RString shikyuShinseiShinsaKubun) {
        this.shikyuShinseiShinsaKubun = shikyuShinseiShinsaKubun;
    }

    /**
     * getShinsaHohoKubun
     *
     * @return shinsaHohoKubun
     */
    public RString getShinsaHohoKubun() {
        return shinsaHohoKubun;
    }

    /**
     * setShinsaHohoKubun
     *
     * @param shinsaHohoKubun shinsaHohoKubun
     */
    public void setShinsaHohoKubun(RString shinsaHohoKubun) {
        this.shinsaHohoKubun = shinsaHohoKubun;
    }

    /**
     * getSofuYM
     *
     * @return sofuYM
     */
    public FlexibleYearMonth getSofuYM() {
        return sofuYM;
    }

    /**
     * setSofuYM
     *
     * @param sofuYM sofuYM
     */
    public void setSofuYM(FlexibleYearMonth sofuYM) {
        this.sofuYM = sofuYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3034ShokanShinseiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT3034ShokanShinseiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3034ShokanShinseiEntity other) {
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
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3034ShokanShinseiEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNo = entity.seiriNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.shinseiYMD = entity.shinseiYMD;
        this.shinseiRiyu = entity.shinseiRiyu;
        this.shinseishaKubun = entity.shinseishaKubun;
        this.shinseishaNameKanji = entity.shinseishaNameKanji;
        this.shinseishaNameKana = entity.shinseishaNameKana;
        this.shinseishaAddress = entity.shinseishaAddress;
        this.shinseishaTelNo = entity.shinseishaTelNo;
        this.shinseiJigyoshaCode = entity.shinseiJigyoshaCode;
        this.shiharaiKingakuTotal = entity.shiharaiKingakuTotal;
        this.hokenKyufuritsu = entity.hokenKyufuritsu;
        this.riyoshaFutangaku = entity.riyoshaFutangaku;
        this.shikyuShinseiShinsaKubun = entity.shikyuShinseiShinsaKubun;
        this.shinsaHohoKubun = entity.shinsaHohoKubun;
        this.sofuYM = entity.sofuYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, shoriTimestamp, shoKisaiHokenshaNo, uketsukeYMD, shinseiYMD, shinseiRiyu, shinseishaKubun, shinseishaNameKanji, shinseishaNameKana, shinseishaAddress, shinseishaTelNo, shinseiJigyoshaCode, shiharaiKingakuTotal, hokenKyufuritsu, riyoshaFutangaku, shikyuShinseiShinsaKubun, shinsaHohoKubun, sofuYM);
    }

// </editor-fold>
}
