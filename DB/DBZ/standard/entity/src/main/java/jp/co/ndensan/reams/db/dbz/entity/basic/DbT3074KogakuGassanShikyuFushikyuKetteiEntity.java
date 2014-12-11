package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3074KogakuGassanShikyuFushikyuKetteiの項目定義クラスです
 *
 */
public class DbT3074KogakuGassanShikyuFushikyuKetteiEntity extends DbTableEntityBase<DbT3074KogakuGassanShikyuFushikyuKetteiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3074KogakuGassanShikyuFushikyuKettei");

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
    private FlexibleYear taishoNendo;
    @PrimaryKey
    private HokenshaNo hokenshaNo;
    @PrimaryKey
    private RString shikyuSeiriNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private RString jikoFutanSeiriNo;
    private RString hokenSeidoCode;
    private RString kokuho_HihokenshaShoKigo;
    private FlexibleDate keisanKaishiYMD;
    private FlexibleDate keisanShuryoYMD;
    private FlexibleDate shinseiYMD;
    private FlexibleDate ketteiYMD;
    private Decimal jikoFutanSogaku;
    private RString shikyuKubunCode;
    private Decimal shikyugaku;
    private RString kyufuShurui;
    private RString fushikyuRiyu;
    private RString biko;
    private RString shiharaiHohoKubun;
    private RString shiharaiBasho;
    private FlexibleDate shiharaiKaishiYMD;
    private FlexibleDate shiharaiShuryoYMD;
    private RString heichoNaiyo;
    private RString shiharaiKaishiTime;
    private RString shiharaiShuryoTime;
    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate ketteiTsuchiSakuseiYMD;
    private FlexibleDate furikomiTsuchiSakuseiYMD;
    private FlexibleYearMonth uketoriYM;

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
     * getTaishoNendo
     *
     * @return taishoNendo
     */
    public FlexibleYear getTaishoNendo() {
        return taishoNendo;
    }

    /**
     * setTaishoNendo
     *
     * @param taishoNendo taishoNendo
     */
    public void setTaishoNendo(FlexibleYear taishoNendo) {
        this.taishoNendo = taishoNendo;
    }

    /**
     * getHokenshaNo
     *
     * @return hokenshaNo
     */
    public HokenshaNo getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * setHokenshaNo
     *
     * @param hokenshaNo hokenshaNo
     */
    public void setHokenshaNo(HokenshaNo hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
    }

    /**
     * getShikyuSeiriNo
     *
     * @return shikyuSeiriNo
     */
    public RString getShikyuSeiriNo() {
        return shikyuSeiriNo;
    }

    /**
     * setShikyuSeiriNo
     *
     * @param shikyuSeiriNo shikyuSeiriNo
     */
    public void setShikyuSeiriNo(RString shikyuSeiriNo) {
        this.shikyuSeiriNo = shikyuSeiriNo;
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
     * getJikoFutanSeiriNo
     *
     * @return jikoFutanSeiriNo
     */
    public RString getJikoFutanSeiriNo() {
        return jikoFutanSeiriNo;
    }

    /**
     * setJikoFutanSeiriNo
     *
     * @param jikoFutanSeiriNo jikoFutanSeiriNo
     */
    public void setJikoFutanSeiriNo(RString jikoFutanSeiriNo) {
        this.jikoFutanSeiriNo = jikoFutanSeiriNo;
    }

    /**
     * getHokenSeidoCode
     *
     * @return hokenSeidoCode
     */
    public RString getHokenSeidoCode() {
        return hokenSeidoCode;
    }

    /**
     * setHokenSeidoCode
     *
     * @param hokenSeidoCode hokenSeidoCode
     */
    public void setHokenSeidoCode(RString hokenSeidoCode) {
        this.hokenSeidoCode = hokenSeidoCode;
    }

    /**
     * getKokuho_HihokenshaShoKigo
     *
     * @return kokuho_HihokenshaShoKigo
     */
    public RString getKokuho_HihokenshaShoKigo() {
        return kokuho_HihokenshaShoKigo;
    }

    /**
     * setKokuho_HihokenshaShoKigo
     *
     * @param kokuho_HihokenshaShoKigo kokuho_HihokenshaShoKigo
     */
    public void setKokuho_HihokenshaShoKigo(RString kokuho_HihokenshaShoKigo) {
        this.kokuho_HihokenshaShoKigo = kokuho_HihokenshaShoKigo;
    }

    /**
     * getKeisanKaishiYMD
     *
     * @return keisanKaishiYMD
     */
    public FlexibleDate getKeisanKaishiYMD() {
        return keisanKaishiYMD;
    }

    /**
     * setKeisanKaishiYMD
     *
     * @param keisanKaishiYMD keisanKaishiYMD
     */
    public void setKeisanKaishiYMD(FlexibleDate keisanKaishiYMD) {
        this.keisanKaishiYMD = keisanKaishiYMD;
    }

    /**
     * getKeisanShuryoYMD
     *
     * @return keisanShuryoYMD
     */
    public FlexibleDate getKeisanShuryoYMD() {
        return keisanShuryoYMD;
    }

    /**
     * setKeisanShuryoYMD
     *
     * @param keisanShuryoYMD keisanShuryoYMD
     */
    public void setKeisanShuryoYMD(FlexibleDate keisanShuryoYMD) {
        this.keisanShuryoYMD = keisanShuryoYMD;
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
     * getJikoFutanSogaku
     *
     * @return jikoFutanSogaku
     */
    public Decimal getJikoFutanSogaku() {
        return jikoFutanSogaku;
    }

    /**
     * setJikoFutanSogaku
     *
     * @param jikoFutanSogaku jikoFutanSogaku
     */
    public void setJikoFutanSogaku(Decimal jikoFutanSogaku) {
        this.jikoFutanSogaku = jikoFutanSogaku;
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
     * getShikyugaku
     *
     * @return shikyugaku
     */
    public Decimal getShikyugaku() {
        return shikyugaku;
    }

    /**
     * setShikyugaku
     *
     * @param shikyugaku shikyugaku
     */
    public void setShikyugaku(Decimal shikyugaku) {
        this.shikyugaku = shikyugaku;
    }

    /**
     * getKyufuShurui
     *
     * @return kyufuShurui
     */
    public RString getKyufuShurui() {
        return kyufuShurui;
    }

    /**
     * setKyufuShurui
     *
     * @param kyufuShurui kyufuShurui
     */
    public void setKyufuShurui(RString kyufuShurui) {
        this.kyufuShurui = kyufuShurui;
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
     * getBiko
     *
     * @return biko
     */
    public RString getBiko() {
        return biko;
    }

    /**
     * setBiko
     *
     * @param biko biko
     */
    public void setBiko(RString biko) {
        this.biko = biko;
    }

    /**
     * getShiharaiHohoKubun
     *
     * @return shiharaiHohoKubun
     */
    public RString getShiharaiHohoKubun() {
        return shiharaiHohoKubun;
    }

    /**
     * setShiharaiHohoKubun
     *
     * @param shiharaiHohoKubun shiharaiHohoKubun
     */
    public void setShiharaiHohoKubun(RString shiharaiHohoKubun) {
        this.shiharaiHohoKubun = shiharaiHohoKubun;
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
     * getShikibetsuCode
     *
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * setShikibetsuCode
     *
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * getKetteiTsuchiSakuseiYMD
     *
     * @return ketteiTsuchiSakuseiYMD
     */
    public FlexibleDate getKetteiTsuchiSakuseiYMD() {
        return ketteiTsuchiSakuseiYMD;
    }

    /**
     * setKetteiTsuchiSakuseiYMD
     *
     * @param ketteiTsuchiSakuseiYMD ketteiTsuchiSakuseiYMD
     */
    public void setKetteiTsuchiSakuseiYMD(FlexibleDate ketteiTsuchiSakuseiYMD) {
        this.ketteiTsuchiSakuseiYMD = ketteiTsuchiSakuseiYMD;
    }

    /**
     * getFurikomiTsuchiSakuseiYMD
     *
     * @return furikomiTsuchiSakuseiYMD
     */
    public FlexibleDate getFurikomiTsuchiSakuseiYMD() {
        return furikomiTsuchiSakuseiYMD;
    }

    /**
     * setFurikomiTsuchiSakuseiYMD
     *
     * @param furikomiTsuchiSakuseiYMD furikomiTsuchiSakuseiYMD
     */
    public void setFurikomiTsuchiSakuseiYMD(FlexibleDate furikomiTsuchiSakuseiYMD) {
        this.furikomiTsuchiSakuseiYMD = furikomiTsuchiSakuseiYMD;
    }

    /**
     * getUketoriYM
     *
     * @return uketoriYM
     */
    public FlexibleYearMonth getUketoriYM() {
        return uketoriYM;
    }

    /**
     * setUketoriYM
     *
     * @param uketoriYM uketoriYM
     */
    public void setUketoriYM(FlexibleYearMonth uketoriYM) {
        this.uketoriYM = uketoriYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3074KogakuGassanShikyuFushikyuKetteiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3074KogakuGassanShikyuFushikyuKetteiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3074KogakuGassanShikyuFushikyuKetteiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.taishoNendo, other.taishoNendo)) {
            return false;
        }
        if (!Objects.equals(this.hokenshaNo, other.hokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shikyuSeiriNo, other.shikyuSeiriNo)) {
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
    public void shallowCopy(DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.taishoNendo = entity.taishoNendo;
        this.hokenshaNo = entity.hokenshaNo;
        this.shikyuSeiriNo = entity.shikyuSeiriNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.jikoFutanSeiriNo = entity.jikoFutanSeiriNo;
        this.hokenSeidoCode = entity.hokenSeidoCode;
        this.kokuho_HihokenshaShoKigo = entity.kokuho_HihokenshaShoKigo;
        this.keisanKaishiYMD = entity.keisanKaishiYMD;
        this.keisanShuryoYMD = entity.keisanShuryoYMD;
        this.shinseiYMD = entity.shinseiYMD;
        this.ketteiYMD = entity.ketteiYMD;
        this.jikoFutanSogaku = entity.jikoFutanSogaku;
        this.shikyuKubunCode = entity.shikyuKubunCode;
        this.shikyugaku = entity.shikyugaku;
        this.kyufuShurui = entity.kyufuShurui;
        this.fushikyuRiyu = entity.fushikyuRiyu;
        this.biko = entity.biko;
        this.shiharaiHohoKubun = entity.shiharaiHohoKubun;
        this.shiharaiBasho = entity.shiharaiBasho;
        this.shiharaiKaishiYMD = entity.shiharaiKaishiYMD;
        this.shiharaiShuryoYMD = entity.shiharaiShuryoYMD;
        this.heichoNaiyo = entity.heichoNaiyo;
        this.shiharaiKaishiTime = entity.shiharaiKaishiTime;
        this.shiharaiShuryoTime = entity.shiharaiShuryoTime;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.ketteiTsuchiSakuseiYMD = entity.ketteiTsuchiSakuseiYMD;
        this.furikomiTsuchiSakuseiYMD = entity.furikomiTsuchiSakuseiYMD;
        this.uketoriYM = entity.uketoriYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, taishoNendo, hokenshaNo, shikyuSeiriNo, shoriTimestamp, jikoFutanSeiriNo, hokenSeidoCode, kokuho_HihokenshaShoKigo, keisanKaishiYMD, keisanShuryoYMD, shinseiYMD, ketteiYMD, jikoFutanSogaku, shikyuKubunCode, shikyugaku, kyufuShurui, fushikyuRiyu, biko, shiharaiHohoKubun, shiharaiBasho, shiharaiKaishiYMD, shiharaiShuryoYMD, heichoNaiyo, shiharaiKaishiTime, shiharaiShuryoTime, shikibetsuCode, ketteiTsuchiSakuseiYMD, furikomiTsuchiSakuseiYMD, uketoriYM);
    }

// </editor-fold>
}
