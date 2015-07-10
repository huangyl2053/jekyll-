package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3053ShokanShukeiの項目定義クラスです
 *
 */
public class DbT3053ShokanShukeiEntity extends DbTableEntityBase<DbT3053ShokanShukeiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3053ShokanShukei");

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
    private ServiceShuruiCode serviceShuruiCode;
    private int serviceJitsunissu;
    private int planTanisu;
    private int gendogakuKanriTaishoTanisu;
    private int gendogakuKanriTaishogaiTanisu;
    private int tankiNyushoPlanNissu;
    private int tankiNyushoJitsunissu;
    private int tanisuTotal;
    private Decimal tanisuTanka;
    private Decimal seikyugaku;
    private int riyoshaFutangaku;
    private int dekidakaIryohiTanisuTotal;
    private Decimal dekidakaIryohiSeikyugaku;
    private Decimal dekidakaIryohiRiyoshaFutangaku;
    private RString shinsaHohoKubunCode;
    private FlexibleYearMonth shinsaYM;
    private RString shikyuKubunCode;
    private int tensuKingaku;
    private int shikyuKingaku;
    private int zougenten;
    private int seikyugakuSagakuKingaku;
    private int dekidakaSeikyugakuSagaku;
    private RString zougenRiyu;
    private RString hushikyuRiyu;
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
     * getServiceShuruiCode
     *
     * @return serviceShuruiCode
     */
    public ServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * setServiceShuruiCode
     *
     * @param serviceShuruiCode serviceShuruiCode
     */
    public void setServiceShuruiCode(ServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * getServiceJitsunissu
     *
     * @return serviceJitsunissu
     */
    public int getServiceJitsunissu() {
        return serviceJitsunissu;
    }

    /**
     * setServiceJitsunissu
     *
     * @param serviceJitsunissu serviceJitsunissu
     */
    public void setServiceJitsunissu(int serviceJitsunissu) {
        this.serviceJitsunissu = serviceJitsunissu;
    }

    /**
     * getPlanTanisu
     *
     * @return planTanisu
     */
    public int getPlanTanisu() {
        return planTanisu;
    }

    /**
     * setPlanTanisu
     *
     * @param planTanisu planTanisu
     */
    public void setPlanTanisu(int planTanisu) {
        this.planTanisu = planTanisu;
    }

    /**
     * getGendogakuKanriTaishoTanisu
     *
     * @return gendogakuKanriTaishoTanisu
     */
    public int getGendogakuKanriTaishoTanisu() {
        return gendogakuKanriTaishoTanisu;
    }

    /**
     * setGendogakuKanriTaishoTanisu
     *
     * @param gendogakuKanriTaishoTanisu gendogakuKanriTaishoTanisu
     */
    public void setGendogakuKanriTaishoTanisu(int gendogakuKanriTaishoTanisu) {
        this.gendogakuKanriTaishoTanisu = gendogakuKanriTaishoTanisu;
    }

    /**
     * getGendogakuKanriTaishogaiTanisu
     *
     * @return gendogakuKanriTaishogaiTanisu
     */
    public int getGendogakuKanriTaishogaiTanisu() {
        return gendogakuKanriTaishogaiTanisu;
    }

    /**
     * setGendogakuKanriTaishogaiTanisu
     *
     * @param gendogakuKanriTaishogaiTanisu gendogakuKanriTaishogaiTanisu
     */
    public void setGendogakuKanriTaishogaiTanisu(int gendogakuKanriTaishogaiTanisu) {
        this.gendogakuKanriTaishogaiTanisu = gendogakuKanriTaishogaiTanisu;
    }

    /**
     * getTankiNyushoPlanNissu
     *
     * @return tankiNyushoPlanNissu
     */
    public int getTankiNyushoPlanNissu() {
        return tankiNyushoPlanNissu;
    }

    /**
     * setTankiNyushoPlanNissu
     *
     * @param tankiNyushoPlanNissu tankiNyushoPlanNissu
     */
    public void setTankiNyushoPlanNissu(int tankiNyushoPlanNissu) {
        this.tankiNyushoPlanNissu = tankiNyushoPlanNissu;
    }

    /**
     * getTankiNyushoJitsunissu
     *
     * @return tankiNyushoJitsunissu
     */
    public int getTankiNyushoJitsunissu() {
        return tankiNyushoJitsunissu;
    }

    /**
     * setTankiNyushoJitsunissu
     *
     * @param tankiNyushoJitsunissu tankiNyushoJitsunissu
     */
    public void setTankiNyushoJitsunissu(int tankiNyushoJitsunissu) {
        this.tankiNyushoJitsunissu = tankiNyushoJitsunissu;
    }

    /**
     * getTanisuTotal
     *
     * @return tanisuTotal
     */
    public int getTanisuTotal() {
        return tanisuTotal;
    }

    /**
     * setTanisuTotal
     *
     * @param tanisuTotal tanisuTotal
     */
    public void setTanisuTotal(int tanisuTotal) {
        this.tanisuTotal = tanisuTotal;
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
     * getSeikyugaku
     *
     * @return seikyugaku
     */
    public Decimal getSeikyugaku() {
        return seikyugaku;
    }

    /**
     * setSeikyugaku
     *
     * @param seikyugaku seikyugaku
     */
    public void setSeikyugaku(Decimal seikyugaku) {
        this.seikyugaku = seikyugaku;
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
     * getDekidakaIryohiTanisuTotal
     *
     * @return dekidakaIryohiTanisuTotal
     */
    public int getDekidakaIryohiTanisuTotal() {
        return dekidakaIryohiTanisuTotal;
    }

    /**
     * setDekidakaIryohiTanisuTotal
     *
     * @param dekidakaIryohiTanisuTotal dekidakaIryohiTanisuTotal
     */
    public void setDekidakaIryohiTanisuTotal(int dekidakaIryohiTanisuTotal) {
        this.dekidakaIryohiTanisuTotal = dekidakaIryohiTanisuTotal;
    }

    /**
     * getDekidakaIryohiSeikyugaku
     *
     * @return dekidakaIryohiSeikyugaku
     */
    public Decimal getDekidakaIryohiSeikyugaku() {
        return dekidakaIryohiSeikyugaku;
    }

    /**
     * setDekidakaIryohiSeikyugaku
     *
     * @param dekidakaIryohiSeikyugaku dekidakaIryohiSeikyugaku
     */
    public void setDekidakaIryohiSeikyugaku(Decimal dekidakaIryohiSeikyugaku) {
        this.dekidakaIryohiSeikyugaku = dekidakaIryohiSeikyugaku;
    }

    /**
     * getDekidakaIryohiRiyoshaFutangaku
     *
     * @return dekidakaIryohiRiyoshaFutangaku
     */
    public Decimal getDekidakaIryohiRiyoshaFutangaku() {
        return dekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * setDekidakaIryohiRiyoshaFutangaku
     *
     * @param dekidakaIryohiRiyoshaFutangaku dekidakaIryohiRiyoshaFutangaku
     */
    public void setDekidakaIryohiRiyoshaFutangaku(Decimal dekidakaIryohiRiyoshaFutangaku) {
        this.dekidakaIryohiRiyoshaFutangaku = dekidakaIryohiRiyoshaFutangaku;
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
     * getZougenten
     *
     * @return zougenten
     */
    public int getZougenten() {
        return zougenten;
    }

    /**
     * setZougenten
     *
     * @param zougenten zougenten
     */
    public void setZougenten(int zougenten) {
        this.zougenten = zougenten;
    }

    /**
     * getSeikyugakuSagakuKingaku
     *
     * @return seikyugakuSagakuKingaku
     */
    public int getSeikyugakuSagakuKingaku() {
        return seikyugakuSagakuKingaku;
    }

    /**
     * setSeikyugakuSagakuKingaku
     *
     * @param seikyugakuSagakuKingaku seikyugakuSagakuKingaku
     */
    public void setSeikyugakuSagakuKingaku(int seikyugakuSagakuKingaku) {
        this.seikyugakuSagakuKingaku = seikyugakuSagakuKingaku;
    }

    /**
     * getDekidakaSeikyugakuSagaku
     *
     * @return dekidakaSeikyugakuSagaku
     */
    public int getDekidakaSeikyugakuSagaku() {
        return dekidakaSeikyugakuSagaku;
    }

    /**
     * setDekidakaSeikyugakuSagaku
     *
     * @param dekidakaSeikyugakuSagaku dekidakaSeikyugakuSagaku
     */
    public void setDekidakaSeikyugakuSagaku(int dekidakaSeikyugakuSagaku) {
        this.dekidakaSeikyugakuSagaku = dekidakaSeikyugakuSagaku;
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
     * getHushikyuRiyu
     *
     * @return hushikyuRiyu
     */
    public RString getHushikyuRiyu() {
        return hushikyuRiyu;
    }

    /**
     * setHushikyuRiyu
     *
     * @param hushikyuRiyu hushikyuRiyu
     */
    public void setHushikyuRiyu(RString hushikyuRiyu) {
        this.hushikyuRiyu = hushikyuRiyu;
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
     * このエンティティの主キーが他の{@literal DbT3053ShokanShukeiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT3053ShokanShukeiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3053ShokanShukeiEntity other) {
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
    public void shallowCopy(DbT3053ShokanShukeiEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNo = entity.seiriNo;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yoshikiNo = entity.yoshikiNo;
        this.junjiNo = entity.junjiNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.serviceJitsunissu = entity.serviceJitsunissu;
        this.planTanisu = entity.planTanisu;
        this.gendogakuKanriTaishoTanisu = entity.gendogakuKanriTaishoTanisu;
        this.gendogakuKanriTaishogaiTanisu = entity.gendogakuKanriTaishogaiTanisu;
        this.tankiNyushoPlanNissu = entity.tankiNyushoPlanNissu;
        this.tankiNyushoJitsunissu = entity.tankiNyushoJitsunissu;
        this.tanisuTotal = entity.tanisuTotal;
        this.tanisuTanka = entity.tanisuTanka;
        this.seikyugaku = entity.seikyugaku;
        this.riyoshaFutangaku = entity.riyoshaFutangaku;
        this.dekidakaIryohiTanisuTotal = entity.dekidakaIryohiTanisuTotal;
        this.dekidakaIryohiSeikyugaku = entity.dekidakaIryohiSeikyugaku;
        this.dekidakaIryohiRiyoshaFutangaku = entity.dekidakaIryohiRiyoshaFutangaku;
        this.shinsaHohoKubunCode = entity.shinsaHohoKubunCode;
        this.shinsaYM = entity.shinsaYM;
        this.shikyuKubunCode = entity.shikyuKubunCode;
        this.tensuKingaku = entity.tensuKingaku;
        this.shikyuKingaku = entity.shikyuKingaku;
        this.zougenten = entity.zougenten;
        this.seikyugakuSagakuKingaku = entity.seikyugakuSagakuKingaku;
        this.dekidakaSeikyugakuSagaku = entity.dekidakaSeikyugakuSagaku;
        this.zougenRiyu = entity.zougenRiyu;
        this.hushikyuRiyu = entity.hushikyuRiyu;
        this.kounyuKaishuRireki = entity.kounyuKaishuRireki;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, jigyoshaNo, yoshikiNo, junjiNo, shoriTimestamp, serviceShuruiCode, serviceJitsunissu, planTanisu, gendogakuKanriTaishoTanisu, gendogakuKanriTaishogaiTanisu, tankiNyushoPlanNissu, tankiNyushoJitsunissu, tanisuTotal, tanisuTanka, seikyugaku, riyoshaFutangaku, dekidakaIryohiTanisuTotal, dekidakaIryohiSeikyugaku, dekidakaIryohiRiyoshaFutangaku, shinsaHohoKubunCode, shinsaYM, shikyuKubunCode, tensuKingaku, shikyuKingaku, zougenten, seikyugakuSagakuKingaku, dekidakaSeikyugakuSagaku, zougenRiyu, hushikyuRiyu, kounyuKaishuRireki);
    }

// </editor-fold>
}
