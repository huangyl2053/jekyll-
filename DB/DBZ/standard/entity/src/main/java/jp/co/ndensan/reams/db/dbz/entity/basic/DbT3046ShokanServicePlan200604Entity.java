package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
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
 * DbT3046ShokanServicePlan200604の項目定義クラスです
 *
 */
public class DbT3046ShokanServicePlan200604Entity extends DbTableEntityBase<DbT3046ShokanServicePlan200604Entity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3046ShokanServicePlan200604");

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
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private RString seiriNp;
    @PrimaryKey
    private JigyoshaNo jigyoshaNo;
    @PrimaryKey
    private RString yoshikiNo;
    @PrimaryKey
    private RDateTime shoriTimestamp;
    private RString shiteiKijunGaitoJigyoshaKubunCode;
    private FlexibleDate kyotakuServiceSakuseiIraiYMD;
    private ServiceCode serviceCode;
    private int tanisu;
    private Decimal tanisuTanka;
    private int seikyuKingaku;
    private RString tantokangoshienSemmoninNo;
    private RString tekiyo;
    private RString shinsaHohoKubunCode;
    private FlexibleYearMonth shinsaYM;
    private RString shikyuKubunCode;
    private int tensuKingaku;
    private int shikyuKingaku;
    private int zougenTen;
    private int sagakuKingaku;
    private RString zougenRiyu;
    private RString fushikyuRiyu;
    private RString kounyuKaishuRireki;

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
     * getSeiriNp
     *
     * @return seiriNp
     */
    public RString getSeiriNp() {
        return seiriNp;
    }

    /**
     * setSeiriNp
     *
     * @param seiriNp seiriNp
     */
    public void setSeiriNp(RString seiriNp) {
        this.seiriNp = seiriNp;
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
     * getShiteiKijunGaitoJigyoshaKubunCode
     *
     * @return shiteiKijunGaitoJigyoshaKubunCode
     */
    public RString getShiteiKijunGaitoJigyoshaKubunCode() {
        return shiteiKijunGaitoJigyoshaKubunCode;
    }

    /**
     * setShiteiKijunGaitoJigyoshaKubunCode
     *
     * @param shiteiKijunGaitoJigyoshaKubunCode shiteiKijunGaitoJigyoshaKubunCode
     */
    public void setShiteiKijunGaitoJigyoshaKubunCode(RString shiteiKijunGaitoJigyoshaKubunCode) {
        this.shiteiKijunGaitoJigyoshaKubunCode = shiteiKijunGaitoJigyoshaKubunCode;
    }

    /**
     * getKyotakuServiceSakuseiIraiYMD
     *
     * @return kyotakuServiceSakuseiIraiYMD
     */
    public FlexibleDate getKyotakuServiceSakuseiIraiYMD() {
        return kyotakuServiceSakuseiIraiYMD;
    }

    /**
     * setKyotakuServiceSakuseiIraiYMD
     *
     * @param kyotakuServiceSakuseiIraiYMD kyotakuServiceSakuseiIraiYMD
     */
    public void setKyotakuServiceSakuseiIraiYMD(FlexibleDate kyotakuServiceSakuseiIraiYMD) {
        this.kyotakuServiceSakuseiIraiYMD = kyotakuServiceSakuseiIraiYMD;
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
     * getTanisu
     *
     * @return tanisu
     */
    public int getTanisu() {
        return tanisu;
    }

    /**
     * setTanisu
     *
     * @param tanisu tanisu
     */
    public void setTanisu(int tanisu) {
        this.tanisu = tanisu;
    }

    /**
     * getTanisuTanka
     *
     * @return tanisuTanka
     */
    public Decimal getTanisuTanka() {
        return tanisuTanka;
    }

    /**
     * setTanisuTanka
     *
     * @param tanisuTanka tanisuTanka
     */
    public void setTanisuTanka(Decimal tanisuTanka) {
        this.tanisuTanka = tanisuTanka;
    }

    /**
     * getSeikyuKingaku
     *
     * @return seikyuKingaku
     */
    public int getSeikyuKingaku() {
        return seikyuKingaku;
    }

    /**
     * setSeikyuKingaku
     *
     * @param seikyuKingaku seikyuKingaku
     */
    public void setSeikyuKingaku(int seikyuKingaku) {
        this.seikyuKingaku = seikyuKingaku;
    }

    /**
     * getTantokangoshienSemmoninNo
     *
     * @return tantokangoshienSemmoninNo
     */
    public RString getTantokangoshienSemmoninNo() {
        return tantokangoshienSemmoninNo;
    }

    /**
     * setTantokangoshienSemmoninNo
     *
     * @param tantokangoshienSemmoninNo tantokangoshienSemmoninNo
     */
    public void setTantokangoshienSemmoninNo(RString tantokangoshienSemmoninNo) {
        this.tantokangoshienSemmoninNo = tantokangoshienSemmoninNo;
    }

    /**
     * getTekiyo
     *
     * @return tekiyo
     */
    public RString getTekiyo() {
        return tekiyo;
    }

    /**
     * setTekiyo
     *
     * @param tekiyo tekiyo
     */
    public void setTekiyo(RString tekiyo) {
        this.tekiyo = tekiyo;
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
     * getShinsaYM
     *
     * @return shinsaYM
     */
    public FlexibleYearMonth getShinsaYM() {
        return shinsaYM;
    }

    /**
     * setShinsaYM
     *
     * @param shinsaYM shinsaYM
     */
    public void setShinsaYM(FlexibleYearMonth shinsaYM) {
        this.shinsaYM = shinsaYM;
    }

    /**
     * getShikyuKubunCode
     *
     * @return shikyuKubunCode
     */
    public RString getShikyuKubunCode() {
        return shikyuKubunCode;
    }

    /**
     * setShikyuKubunCode
     *
     * @param shikyuKubunCode shikyuKubunCode
     */
    public void setShikyuKubunCode(RString shikyuKubunCode) {
        this.shikyuKubunCode = shikyuKubunCode;
    }

    /**
     * getTensuKingaku
     *
     * @return tensuKingaku
     */
    public int getTensuKingaku() {
        return tensuKingaku;
    }

    /**
     * setTensuKingaku
     *
     * @param tensuKingaku tensuKingaku
     */
    public void setTensuKingaku(int tensuKingaku) {
        this.tensuKingaku = tensuKingaku;
    }

    /**
     * getShikyuKingaku
     *
     * @return shikyuKingaku
     */
    public int getShikyuKingaku() {
        return shikyuKingaku;
    }

    /**
     * setShikyuKingaku
     *
     * @param shikyuKingaku shikyuKingaku
     */
    public void setShikyuKingaku(int shikyuKingaku) {
        this.shikyuKingaku = shikyuKingaku;
    }

    /**
     * getZougenTen
     *
     * @return zougenTen
     */
    public int getZougenTen() {
        return zougenTen;
    }

    /**
     * setZougenTen
     *
     * @param zougenTen zougenTen
     */
    public void setZougenTen(int zougenTen) {
        this.zougenTen = zougenTen;
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
     * getZougenRiyu
     *
     * @return zougenRiyu
     */
    public RString getZougenRiyu() {
        return zougenRiyu;
    }

    /**
     * setZougenRiyu
     *
     * @param zougenRiyu zougenRiyu
     */
    public void setZougenRiyu(RString zougenRiyu) {
        this.zougenRiyu = zougenRiyu;
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
     * getKounyuKaishuRireki
     *
     * @return kounyuKaishuRireki
     */
    public RString getKounyuKaishuRireki() {
        return kounyuKaishuRireki;
    }

    /**
     * setKounyuKaishuRireki
     *
     * @param kounyuKaishuRireki kounyuKaishuRireki
     */
    public void setKounyuKaishuRireki(RString kounyuKaishuRireki) {
        this.kounyuKaishuRireki = kounyuKaishuRireki;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3046ShokanServicePlan200604Entity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3046ShokanServicePlan200604Entity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3046ShokanServicePlan200604Entity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.insertTimestamp, other.insertTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.seiriNp, other.seiriNp)) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.yoshikiNo, other.yoshikiNo)) {
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
    public void shallowCopy(DbT3046ShokanServicePlan200604Entity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNp = entity.seiriNp;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yoshikiNo = entity.yoshikiNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.shiteiKijunGaitoJigyoshaKubunCode = entity.shiteiKijunGaitoJigyoshaKubunCode;
        this.kyotakuServiceSakuseiIraiYMD = entity.kyotakuServiceSakuseiIraiYMD;
        this.serviceCode = entity.serviceCode;
        this.tanisu = entity.tanisu;
        this.tanisuTanka = entity.tanisuTanka;
        this.seikyuKingaku = entity.seikyuKingaku;
        this.tantokangoshienSemmoninNo = entity.tantokangoshienSemmoninNo;
        this.tekiyo = entity.tekiyo;
        this.shinsaHohoKubunCode = entity.shinsaHohoKubunCode;
        this.shinsaYM = entity.shinsaYM;
        this.shikyuKubunCode = entity.shikyuKubunCode;
        this.tensuKingaku = entity.tensuKingaku;
        this.shikyuKingaku = entity.shikyuKingaku;
        this.zougenTen = entity.zougenTen;
        this.sagakuKingaku = entity.sagakuKingaku;
        this.zougenRiyu = entity.zougenRiyu;
        this.fushikyuRiyu = entity.fushikyuRiyu;
        this.kounyuKaishuRireki = entity.kounyuKaishuRireki;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNp, jigyoshaNo, yoshikiNo, shoriTimestamp, shiteiKijunGaitoJigyoshaKubunCode, kyotakuServiceSakuseiIraiYMD, serviceCode, tanisu, tanisuTanka, seikyuKingaku, tantokangoshienSemmoninNo, tekiyo, shinsaHohoKubunCode, shinsaYM, shikyuKubunCode, tensuKingaku, shikyuKingaku, zougenTen, sagakuKingaku, zougenRiyu, fushikyuRiyu, kounyuKaishuRireki);
    }

// </editor-fold>
}
