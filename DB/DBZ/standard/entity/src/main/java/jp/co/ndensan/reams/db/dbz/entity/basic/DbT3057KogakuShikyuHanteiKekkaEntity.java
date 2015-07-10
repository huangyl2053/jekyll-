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
 * DbT3057KogakuShikyuHanteiKekkaの項目定義クラスです
 *
 */
public class DbT3057KogakuShikyuHanteiKekkaEntity extends DbTableEntityBase<DbT3057KogakuShikyuHanteiKekkaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

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
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private FlexibleDate ketteiYMD;
    private Decimal honninShiharaiGaku;
    private RString shiharaiKubunCode;
    private Decimal shiharaiKingaku;
    private RString fushikyuRiyu;
    private RString shiharaiHohoKubunCode;
    private RString shiharaiBasho;
    private FlexibleDate shiharaiKaishiYMD;
    private FlexibleDate shiharaiShuryoYMD;
    private RString heichoNaiyo;
    private RString shiharaiKaishiTime;
    private RString shiharaiShuryoTime;
    private RString juryoIninKeiyakuNo;
    private RString shinsaHohoKubun;
    private FlexibleYearMonth hanteiKekkaSofuYM;
    private boolean saiSofuFlag;
    private boolean hanteiKekkaSofuFuyoFlag;
    private RString shinsaKekkaHaneiKubun;
    private FlexibleDate ketteiTsuchishoSakuseiYMD;
    private FlexibleDate furikomiMeisaishoSakuseiYMD;

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
     * getKetteiYMD
     *
     * @return ketteiYMD
     */
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * setKetteiYMD
     *
     * @param ketteiYMD ketteiYMD
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
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
     * getFushikyuRiyu
     *
     * @return fushikyuRiyu
     */
    public RString getFushikyuRiyu() {
        return fushikyuRiyu;
    }

    /**
     * setFushikyuRiyu
     *
     * @param fushikyuRiyu fushikyuRiyu
     */
    public void setFushikyuRiyu(RString fushikyuRiyu) {
        this.fushikyuRiyu = fushikyuRiyu;
    }

    /**
     * getShiharaiHohoKubunCode
     *
     * @return shiharaiHohoKubunCode
     */
    public RString getShiharaiHohoKubunCode() {
        return shiharaiHohoKubunCode;
    }

    /**
     * setShiharaiHohoKubunCode
     *
     * @param shiharaiHohoKubunCode shiharaiHohoKubunCode
     */
    public void setShiharaiHohoKubunCode(RString shiharaiHohoKubunCode) {
        this.shiharaiHohoKubunCode = shiharaiHohoKubunCode;
    }

    /**
     * getShiharaiBasho
     *
     * @return shiharaiBasho
     */
    public RString getShiharaiBasho() {
        return shiharaiBasho;
    }

    /**
     * setShiharaiBasho
     *
     * @param shiharaiBasho shiharaiBasho
     */
    public void setShiharaiBasho(RString shiharaiBasho) {
        this.shiharaiBasho = shiharaiBasho;
    }

    /**
     * getShiharaiKaishiYMD
     *
     * @return shiharaiKaishiYMD
     */
    public FlexibleDate getShiharaiKaishiYMD() {
        return shiharaiKaishiYMD;
    }

    /**
     * setShiharaiKaishiYMD
     *
     * @param shiharaiKaishiYMD shiharaiKaishiYMD
     */
    public void setShiharaiKaishiYMD(FlexibleDate shiharaiKaishiYMD) {
        this.shiharaiKaishiYMD = shiharaiKaishiYMD;
    }

    /**
     * getShiharaiShuryoYMD
     *
     * @return shiharaiShuryoYMD
     */
    public FlexibleDate getShiharaiShuryoYMD() {
        return shiharaiShuryoYMD;
    }

    /**
     * setShiharaiShuryoYMD
     *
     * @param shiharaiShuryoYMD shiharaiShuryoYMD
     */
    public void setShiharaiShuryoYMD(FlexibleDate shiharaiShuryoYMD) {
        this.shiharaiShuryoYMD = shiharaiShuryoYMD;
    }

    /**
     * getHeichoNaiyo
     *
     * @return heichoNaiyo
     */
    public RString getHeichoNaiyo() {
        return heichoNaiyo;
    }

    /**
     * setHeichoNaiyo
     *
     * @param heichoNaiyo heichoNaiyo
     */
    public void setHeichoNaiyo(RString heichoNaiyo) {
        this.heichoNaiyo = heichoNaiyo;
    }

    /**
     * getShiharaiKaishiTime
     *
     * @return shiharaiKaishiTime
     */
    public RString getShiharaiKaishiTime() {
        return shiharaiKaishiTime;
    }

    /**
     * setShiharaiKaishiTime
     *
     * @param shiharaiKaishiTime shiharaiKaishiTime
     */
    public void setShiharaiKaishiTime(RString shiharaiKaishiTime) {
        this.shiharaiKaishiTime = shiharaiKaishiTime;
    }

    /**
     * getShiharaiShuryoTime
     *
     * @return shiharaiShuryoTime
     */
    public RString getShiharaiShuryoTime() {
        return shiharaiShuryoTime;
    }

    /**
     * setShiharaiShuryoTime
     *
     * @param shiharaiShuryoTime shiharaiShuryoTime
     */
    public void setShiharaiShuryoTime(RString shiharaiShuryoTime) {
        this.shiharaiShuryoTime = shiharaiShuryoTime;
    }

    /**
     * getJuryoIninKeiyakuNo
     *
     * @return juryoIninKeiyakuNo
     */
    public RString getJuryoIninKeiyakuNo() {
        return juryoIninKeiyakuNo;
    }

    /**
     * setJuryoIninKeiyakuNo
     *
     * @param juryoIninKeiyakuNo juryoIninKeiyakuNo
     */
    public void setJuryoIninKeiyakuNo(RString juryoIninKeiyakuNo) {
        this.juryoIninKeiyakuNo = juryoIninKeiyakuNo;
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
     * getHanteiKekkaSofuYM
     *
     * @return hanteiKekkaSofuYM
     */
    public FlexibleYearMonth getHanteiKekkaSofuYM() {
        return hanteiKekkaSofuYM;
    }

    /**
     * setHanteiKekkaSofuYM
     *
     * @param hanteiKekkaSofuYM hanteiKekkaSofuYM
     */
    public void setHanteiKekkaSofuYM(FlexibleYearMonth hanteiKekkaSofuYM) {
        this.hanteiKekkaSofuYM = hanteiKekkaSofuYM;
    }

    /**
     * getSaiSofuFlag
     *
     * @return saiSofuFlag
     */
    public boolean getSaiSofuFlag() {
        return saiSofuFlag;
    }

    /**
     * setSaiSofuFlag
     *
     * @param saiSofuFlag saiSofuFlag
     */
    public void setSaiSofuFlag(boolean saiSofuFlag) {
        this.saiSofuFlag = saiSofuFlag;
    }

    /**
     * getHanteiKekkaSofuFuyoFlag
     *
     * @return hanteiKekkaSofuFuyoFlag
     */
    public boolean getHanteiKekkaSofuFuyoFlag() {
        return hanteiKekkaSofuFuyoFlag;
    }

    /**
     * setHanteiKekkaSofuFuyoFlag
     *
     * @param hanteiKekkaSofuFuyoFlag hanteiKekkaSofuFuyoFlag
     */
    public void setHanteiKekkaSofuFuyoFlag(boolean hanteiKekkaSofuFuyoFlag) {
        this.hanteiKekkaSofuFuyoFlag = hanteiKekkaSofuFuyoFlag;
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
     * getKetteiTsuchishoSakuseiYMD
     *
     * @return ketteiTsuchishoSakuseiYMD
     */
    public FlexibleDate getKetteiTsuchishoSakuseiYMD() {
        return ketteiTsuchishoSakuseiYMD;
    }

    /**
     * setKetteiTsuchishoSakuseiYMD
     *
     * @param ketteiTsuchishoSakuseiYMD ketteiTsuchishoSakuseiYMD
     */
    public void setKetteiTsuchishoSakuseiYMD(FlexibleDate ketteiTsuchishoSakuseiYMD) {
        this.ketteiTsuchishoSakuseiYMD = ketteiTsuchishoSakuseiYMD;
    }

    /**
     * getFurikomiMeisaishoSakuseiYMD
     *
     * @return furikomiMeisaishoSakuseiYMD
     */
    public FlexibleDate getFurikomiMeisaishoSakuseiYMD() {
        return furikomiMeisaishoSakuseiYMD;
    }

    /**
     * setFurikomiMeisaishoSakuseiYMD
     *
     * @param furikomiMeisaishoSakuseiYMD furikomiMeisaishoSakuseiYMD
     */
    public void setFurikomiMeisaishoSakuseiYMD(FlexibleDate furikomiMeisaishoSakuseiYMD) {
        this.furikomiMeisaishoSakuseiYMD = furikomiMeisaishoSakuseiYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3057KogakuShikyuHanteiKekkaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3057KogakuShikyuHanteiKekkaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3057KogakuShikyuHanteiKekkaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.insertTimestamp, other.insertTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
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
    public void shallowCopy(DbT3057KogakuShikyuHanteiKekkaEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.ketteiYMD = entity.ketteiYMD;
        this.honninShiharaiGaku = entity.honninShiharaiGaku;
        this.shiharaiKubunCode = entity.shiharaiKubunCode;
        this.shiharaiKingaku = entity.shiharaiKingaku;
        this.fushikyuRiyu = entity.fushikyuRiyu;
        this.shiharaiHohoKubunCode = entity.shiharaiHohoKubunCode;
        this.shiharaiBasho = entity.shiharaiBasho;
        this.shiharaiKaishiYMD = entity.shiharaiKaishiYMD;
        this.shiharaiShuryoYMD = entity.shiharaiShuryoYMD;
        this.heichoNaiyo = entity.heichoNaiyo;
        this.shiharaiKaishiTime = entity.shiharaiKaishiTime;
        this.shiharaiShuryoTime = entity.shiharaiShuryoTime;
        this.juryoIninKeiyakuNo = entity.juryoIninKeiyakuNo;
        this.shinsaHohoKubun = entity.shinsaHohoKubun;
        this.hanteiKekkaSofuYM = entity.hanteiKekkaSofuYM;
        this.saiSofuFlag = entity.saiSofuFlag;
        this.hanteiKekkaSofuFuyoFlag = entity.hanteiKekkaSofuFuyoFlag;
        this.shinsaKekkaHaneiKubun = entity.shinsaKekkaHaneiKubun;
        this.ketteiTsuchishoSakuseiYMD = entity.ketteiTsuchishoSakuseiYMD;
        this.furikomiMeisaishoSakuseiYMD = entity.furikomiMeisaishoSakuseiYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, serviceTeikyoYM, shoKisaiHokenshaNo, shoriTimestamp, ketteiYMD, honninShiharaiGaku, shiharaiKubunCode, shiharaiKingaku, fushikyuRiyu, shiharaiHohoKubunCode, shiharaiBasho, shiharaiKaishiYMD, shiharaiShuryoYMD, heichoNaiyo, shiharaiKaishiTime, shiharaiShuryoTime, juryoIninKeiyakuNo, shinsaHohoKubun, hanteiKekkaSofuYM, saiSofuFlag, hanteiKekkaSofuFuyoFlag, shinsaKekkaHaneiKubun, ketteiTsuchishoSakuseiYMD, furikomiMeisaishoSakuseiYMD);
    }

// </editor-fold>
}
