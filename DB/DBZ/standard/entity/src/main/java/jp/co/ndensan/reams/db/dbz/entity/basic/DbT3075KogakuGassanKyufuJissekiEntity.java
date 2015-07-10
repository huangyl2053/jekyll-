package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
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
 * DbT3075KogakuGassanKyufuJissekiの項目定義クラスです
 *
 */
public class DbT3075KogakuGassanKyufuJissekiEntity extends DbTableEntityBase<DbT3075KogakuGassanKyufuJissekiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3075KogakuGassanKyufuJisseki");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private KokanShikibetsuNo kokanJohoShikibetsuNo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RString shikyuShinseiSeiriNo;
    @PrimaryKey
    private RString seiriNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private RString jikoFutanSeiriNo;
    private RString hokenSeidoCode;
    private RString kyufuJissekiSakuseiKubunCode;
    private HokenshaNo shoKisaiHokenshaNo;
    private RString kokuho_HihokenshaShoKigo;
    private FlexibleDate shinseiYMD;
    private FlexibleDate ketteiYMD;
    private Decimal jikoFutanSogaku;
    private Decimal shikyuGaku;
    private FlexibleYearMonth shoriYM;
    private FlexibleYearMonth uketoriYM;
    private FlexibleYearMonth sofuYM;
    private RString dataKubun;

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
     * getKokanJohoShikibetsuNo
     *
     * @return kokanJohoShikibetsuNo
     */
    public KokanShikibetsuNo getKokanJohoShikibetsuNo() {
        return kokanJohoShikibetsuNo;
    }

    /**
     * setKokanJohoShikibetsuNo
     *
     * @param kokanJohoShikibetsuNo kokanJohoShikibetsuNo
     */
    public void setKokanJohoShikibetsuNo(KokanShikibetsuNo kokanJohoShikibetsuNo) {
        this.kokanJohoShikibetsuNo = kokanJohoShikibetsuNo;
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
     * getShikyuShinseiSeiriNo
     *
     * @return shikyuShinseiSeiriNo
     */
    public RString getShikyuShinseiSeiriNo() {
        return shikyuShinseiSeiriNo;
    }

    /**
     * setShikyuShinseiSeiriNo
     *
     * @param shikyuShinseiSeiriNo shikyuShinseiSeiriNo
     */
    public void setShikyuShinseiSeiriNo(RString shikyuShinseiSeiriNo) {
        this.shikyuShinseiSeiriNo = shikyuShinseiSeiriNo;
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
     * getKyufuJissekiSakuseiKubunCode
     *
     * @return kyufuJissekiSakuseiKubunCode
     */
    public RString getKyufuJissekiSakuseiKubunCode() {
        return kyufuJissekiSakuseiKubunCode;
    }

    /**
     * setKyufuJissekiSakuseiKubunCode
     *
     * @param kyufuJissekiSakuseiKubunCode kyufuJissekiSakuseiKubunCode
     */
    public void setKyufuJissekiSakuseiKubunCode(RString kyufuJissekiSakuseiKubunCode) {
        this.kyufuJissekiSakuseiKubunCode = kyufuJissekiSakuseiKubunCode;
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
     * getShikyuGaku
     *
     * @return shikyuGaku
     */
    public Decimal getShikyuGaku() {
        return shikyuGaku;
    }

    /**
     * setShikyuGaku
     *
     * @param shikyuGaku shikyuGaku
     */
    public void setShikyuGaku(Decimal shikyuGaku) {
        this.shikyuGaku = shikyuGaku;
    }

    /**
     * getShoriYM
     *
     * @return shoriYM
     */
    public FlexibleYearMonth getShoriYM() {
        return shoriYM;
    }

    /**
     * setShoriYM
     *
     * @param shoriYM shoriYM
     */
    public void setShoriYM(FlexibleYearMonth shoriYM) {
        this.shoriYM = shoriYM;
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
     * getDataKubun
     *
     * @return dataKubun
     */
    public RString getDataKubun() {
        return dataKubun;
    }

    /**
     * setDataKubun
     *
     * @param dataKubun dataKubun
     */
    public void setDataKubun(RString dataKubun) {
        this.dataKubun = dataKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3075KogakuGassanKyufuJissekiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3075KogakuGassanKyufuJissekiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3075KogakuGassanKyufuJissekiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.kokanJohoShikibetsuNo, other.kokanJohoShikibetsuNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shikyuShinseiSeiriNo, other.shikyuShinseiSeiriNo)) {
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
    public void shallowCopy(DbT3075KogakuGassanKyufuJissekiEntity entity) {
        this.kokanJohoShikibetsuNo = entity.kokanJohoShikibetsuNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shikyuShinseiSeiriNo = entity.shikyuShinseiSeiriNo;
        this.seiriNo = entity.seiriNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.jikoFutanSeiriNo = entity.jikoFutanSeiriNo;
        this.hokenSeidoCode = entity.hokenSeidoCode;
        this.kyufuJissekiSakuseiKubunCode = entity.kyufuJissekiSakuseiKubunCode;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.kokuho_HihokenshaShoKigo = entity.kokuho_HihokenshaShoKigo;
        this.shinseiYMD = entity.shinseiYMD;
        this.ketteiYMD = entity.ketteiYMD;
        this.jikoFutanSogaku = entity.jikoFutanSogaku;
        this.shikyuGaku = entity.shikyuGaku;
        this.shoriYM = entity.shoriYM;
        this.uketoriYM = entity.uketoriYM;
        this.sofuYM = entity.sofuYM;
        this.dataKubun = entity.dataKubun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kokanJohoShikibetsuNo, hihokenshaNo, shikyuShinseiSeiriNo, seiriNo, shoriTimestamp, jikoFutanSeiriNo, hokenSeidoCode, kyufuJissekiSakuseiKubunCode, shoKisaiHokenshaNo, kokuho_HihokenshaShoKigo, shinseiYMD, ketteiYMD, jikoFutanSogaku, shikyuGaku, shoriYM, uketoriYM, sofuYM, dataKubun);
    }

// </editor-fold>
}
