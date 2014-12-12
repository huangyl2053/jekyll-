package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiの項目定義クラスです
 *
 */
public class DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity extends DbTableEntityBase<DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3073KogakuGassanShikyugakuKeisanKekkaMeisai");

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
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private RString shikyuShinseishoSeiriNo;
    @PrimaryKey
    private RString meisanNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private RString hokenSeidoCode;
    private RString uchiwakeHokenshaNo;
    private RString kokuho_HihokenshaShoKigo;
    private RString hiHokenshaShoNo;
    private RString uchiwakeHokenshaMei;
    private RString jikoFutanSeiriNo;
    private RString taishoshaShimei;
    private RString over70_Futangaku;
    private RString over70_AmbunRitsu;
    private RString over70_Shikyugaku;
    private RString under70_Futangaku;
    private RString futangaku;
    private RString ambunRitsu;
    private RString under70_Shikyugaku;
    private RString shikyugaku;
    private RString over70_Biko;
    private RString under70_Biko;
    private RString dataKubun;
    private FlexibleYearMonth uketoriYM;
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
     * getShikyuShinseishoSeiriNo
     *
     * @return shikyuShinseishoSeiriNo
     */
    public RString getShikyuShinseishoSeiriNo() {
        return shikyuShinseishoSeiriNo;
    }

    /**
     * setShikyuShinseishoSeiriNo
     *
     * @param shikyuShinseishoSeiriNo shikyuShinseishoSeiriNo
     */
    public void setShikyuShinseishoSeiriNo(RString shikyuShinseishoSeiriNo) {
        this.shikyuShinseishoSeiriNo = shikyuShinseishoSeiriNo;
    }

    /**
     * getMeisanNo
     *
     * @return meisanNo
     */
    public RString getMeisanNo() {
        return meisanNo;
    }

    /**
     * setMeisanNo
     *
     * @param meisanNo meisanNo
     */
    public void setMeisanNo(RString meisanNo) {
        this.meisanNo = meisanNo;
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
     * getUchiwakeHokenshaNo
     *
     * @return uchiwakeHokenshaNo
     */
    public RString getUchiwakeHokenshaNo() {
        return uchiwakeHokenshaNo;
    }

    /**
     * setUchiwakeHokenshaNo
     *
     * @param uchiwakeHokenshaNo uchiwakeHokenshaNo
     */
    public void setUchiwakeHokenshaNo(RString uchiwakeHokenshaNo) {
        this.uchiwakeHokenshaNo = uchiwakeHokenshaNo;
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
     * getHiHokenshaShoNo
     *
     * @return hiHokenshaShoNo
     */
    public RString getHiHokenshaShoNo() {
        return hiHokenshaShoNo;
    }

    /**
     * setHiHokenshaShoNo
     *
     * @param hiHokenshaShoNo hiHokenshaShoNo
     */
    public void setHiHokenshaShoNo(RString hiHokenshaShoNo) {
        this.hiHokenshaShoNo = hiHokenshaShoNo;
    }

    /**
     * getUchiwakeHokenshaMei
     *
     * @return uchiwakeHokenshaMei
     */
    public RString getUchiwakeHokenshaMei() {
        return uchiwakeHokenshaMei;
    }

    /**
     * setUchiwakeHokenshaMei
     *
     * @param uchiwakeHokenshaMei uchiwakeHokenshaMei
     */
    public void setUchiwakeHokenshaMei(RString uchiwakeHokenshaMei) {
        this.uchiwakeHokenshaMei = uchiwakeHokenshaMei;
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
     * getTaishoshaShimei
     *
     * @return taishoshaShimei
     */
    public RString getTaishoshaShimei() {
        return taishoshaShimei;
    }

    /**
     * setTaishoshaShimei
     *
     * @param taishoshaShimei taishoshaShimei
     */
    public void setTaishoshaShimei(RString taishoshaShimei) {
        this.taishoshaShimei = taishoshaShimei;
    }

    /**
     * getOver70_Futangaku
     *
     * @return over70_Futangaku
     */
    public RString getOver70_Futangaku() {
        return over70_Futangaku;
    }

    /**
     * setOver70_Futangaku
     *
     * @param over70_Futangaku over70_Futangaku
     */
    public void setOver70_Futangaku(RString over70_Futangaku) {
        this.over70_Futangaku = over70_Futangaku;
    }

    /**
     * getOver70_AmbunRitsu
     *
     * @return over70_AmbunRitsu
     */
    public RString getOver70_AmbunRitsu() {
        return over70_AmbunRitsu;
    }

    /**
     * setOver70_AmbunRitsu
     *
     * @param over70_AmbunRitsu over70_AmbunRitsu
     */
    public void setOver70_AmbunRitsu(RString over70_AmbunRitsu) {
        this.over70_AmbunRitsu = over70_AmbunRitsu;
    }

    /**
     * getOver70_Shikyugaku
     *
     * @return over70_Shikyugaku
     */
    public RString getOver70_Shikyugaku() {
        return over70_Shikyugaku;
    }

    /**
     * setOver70_Shikyugaku
     *
     * @param over70_Shikyugaku over70_Shikyugaku
     */
    public void setOver70_Shikyugaku(RString over70_Shikyugaku) {
        this.over70_Shikyugaku = over70_Shikyugaku;
    }

    /**
     * getUnder70_Futangaku
     *
     * @return under70_Futangaku
     */
    public RString getUnder70_Futangaku() {
        return under70_Futangaku;
    }

    /**
     * setUnder70_Futangaku
     *
     * @param under70_Futangaku under70_Futangaku
     */
    public void setUnder70_Futangaku(RString under70_Futangaku) {
        this.under70_Futangaku = under70_Futangaku;
    }

    /**
     * getFutangaku
     *
     * @return futangaku
     */
    public RString getFutangaku() {
        return futangaku;
    }

    /**
     * setFutangaku
     *
     * @param futangaku futangaku
     */
    public void setFutangaku(RString futangaku) {
        this.futangaku = futangaku;
    }

    /**
     * getAmbunRitsu
     *
     * @return ambunRitsu
     */
    public RString getAmbunRitsu() {
        return ambunRitsu;
    }

    /**
     * setAmbunRitsu
     *
     * @param ambunRitsu ambunRitsu
     */
    public void setAmbunRitsu(RString ambunRitsu) {
        this.ambunRitsu = ambunRitsu;
    }

    /**
     * getUnder70_Shikyugaku
     *
     * @return under70_Shikyugaku
     */
    public RString getUnder70_Shikyugaku() {
        return under70_Shikyugaku;
    }

    /**
     * setUnder70_Shikyugaku
     *
     * @param under70_Shikyugaku under70_Shikyugaku
     */
    public void setUnder70_Shikyugaku(RString under70_Shikyugaku) {
        this.under70_Shikyugaku = under70_Shikyugaku;
    }

    /**
     * getShikyugaku
     *
     * @return shikyugaku
     */
    public RString getShikyugaku() {
        return shikyugaku;
    }

    /**
     * setShikyugaku
     *
     * @param shikyugaku shikyugaku
     */
    public void setShikyugaku(RString shikyugaku) {
        this.shikyugaku = shikyugaku;
    }

    /**
     * getOver70_Biko
     *
     * @return over70_Biko
     */
    public RString getOver70_Biko() {
        return over70_Biko;
    }

    /**
     * setOver70_Biko
     *
     * @param over70_Biko over70_Biko
     */
    public void setOver70_Biko(RString over70_Biko) {
        this.over70_Biko = over70_Biko;
    }

    /**
     * getUnder70_Biko
     *
     * @return under70_Biko
     */
    public RString getUnder70_Biko() {
        return under70_Biko;
    }

    /**
     * setUnder70_Biko
     *
     * @param under70_Biko under70_Biko
     */
    public void setUnder70_Biko(RString under70_Biko) {
        this.under70_Biko = under70_Biko;
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
     * このエンティティの主キーが他の{@literal DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.taishoNendo, other.taishoNendo)) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shikyuShinseishoSeiriNo, other.shikyuShinseishoSeiriNo)) {
            return false;
        }
        if (!Objects.equals(this.meisanNo, other.meisanNo)) {
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
    public void shallowCopy(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.taishoNendo = entity.taishoNendo;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shikyuShinseishoSeiriNo = entity.shikyuShinseishoSeiriNo;
        this.meisanNo = entity.meisanNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.hokenSeidoCode = entity.hokenSeidoCode;
        this.uchiwakeHokenshaNo = entity.uchiwakeHokenshaNo;
        this.kokuho_HihokenshaShoKigo = entity.kokuho_HihokenshaShoKigo;
        this.hiHokenshaShoNo = entity.hiHokenshaShoNo;
        this.uchiwakeHokenshaMei = entity.uchiwakeHokenshaMei;
        this.jikoFutanSeiriNo = entity.jikoFutanSeiriNo;
        this.taishoshaShimei = entity.taishoshaShimei;
        this.over70_Futangaku = entity.over70_Futangaku;
        this.over70_AmbunRitsu = entity.over70_AmbunRitsu;
        this.over70_Shikyugaku = entity.over70_Shikyugaku;
        this.under70_Futangaku = entity.under70_Futangaku;
        this.futangaku = entity.futangaku;
        this.ambunRitsu = entity.ambunRitsu;
        this.under70_Shikyugaku = entity.under70_Shikyugaku;
        this.shikyugaku = entity.shikyugaku;
        this.over70_Biko = entity.over70_Biko;
        this.under70_Biko = entity.under70_Biko;
        this.dataKubun = entity.dataKubun;
        this.uketoriYM = entity.uketoriYM;
        this.sofuYM = entity.sofuYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, taishoNendo, shoKisaiHokenshaNo, shikyuShinseishoSeiriNo, meisanNo, shoriTimestamp, hokenSeidoCode, uchiwakeHokenshaNo, kokuho_HihokenshaShoKigo, hiHokenshaShoNo, uchiwakeHokenshaMei, jikoFutanSeiriNo, taishoshaShimei, over70_Futangaku, over70_AmbunRitsu, over70_Shikyugaku, under70_Futangaku, futangaku, ambunRitsu, under70_Shikyugaku, shikyugaku, over70_Biko, under70_Biko, dataKubun, uketoriYM, sofuYM);
    }

// </editor-fold>
}
