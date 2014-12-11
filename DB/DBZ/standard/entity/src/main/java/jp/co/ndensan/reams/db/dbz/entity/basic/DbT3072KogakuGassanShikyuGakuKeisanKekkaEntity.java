package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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
 * DbT3072KogakuGassanShikyuGakuKeisanKekkaの項目定義クラスです
 *
 */
public class DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity extends DbTableEntityBase<DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3072KogakuGassanShikyuGakuKeisanKekka");

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
    private YMDHMS shoriTimestamp;
    private RString hokenSeidoCode;
    private RString jikoFutanSeiriNo;
    private FlexibleDate taishoKeisanKaishiYMD;
    private FlexibleDate taishoKeisanShuryoYMD;
    private Decimal setaiFutanSogaku;
    private Decimal setaiGassanGaku;
    private Decimal over70_SetaiGassanGaku;
    private RString shotokuKubun;
    private RString over70_ShotokuKubun;
    private Decimal santeiKijunGaku;
    private Decimal over70_SanteiKijyunGaku;
    private Decimal setaiShikyuSogaku;
    private Decimal over70_SetaiShikyuSogaku;
    private Decimal honninShikyugaku;
    private Decimal over70_honninShikyugaku;
    private RString teiShotoku_1_SaiKeisanUmu;
    private RString biko;
    private YubinNo kekkaRenrakusakiYubinNo;
    private RString kekkaRenrakusakiJusho;
    private RString ketteRenrakusakiMeisho1;
    private RString kekkaRenrakusakiMeisho2;
    private FlexibleDate tsuchiYMD;
    private AtenaMeisho renrakuhyoHakkoshaMei;
    private YubinNo renrakuhyoHakkoshaYubinNo;
    private RString renrakuhyoHakkoshaJusho;
    private YubinNo toiawasesakiYobinNo;
    private RString toiawasesakiJusho;
    private RString toiawasesakiMeisho1;
    private RString toiawasesakiMeisho2;
    private TelNo toiawasesakiTelNo;
    private Decimal over70_FutangakuGokei;
    private Decimal over70_ShikyugakuGokei;
    private Decimal under70_FutangakuGokei;
    private Decimal futangakuGokei;
    private Decimal under70_ShikyugakuGokei;
    private Decimal shikyugakuGokei;
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
     * getTaishoKeisanKaishiYMD
     *
     * @return taishoKeisanKaishiYMD
     */
    public FlexibleDate getTaishoKeisanKaishiYMD() {
        return taishoKeisanKaishiYMD;
    }

    /**
     * setTaishoKeisanKaishiYMD
     *
     * @param taishoKeisanKaishiYMD taishoKeisanKaishiYMD
     */
    public void setTaishoKeisanKaishiYMD(FlexibleDate taishoKeisanKaishiYMD) {
        this.taishoKeisanKaishiYMD = taishoKeisanKaishiYMD;
    }

    /**
     * getTaishoKeisanShuryoYMD
     *
     * @return taishoKeisanShuryoYMD
     */
    public FlexibleDate getTaishoKeisanShuryoYMD() {
        return taishoKeisanShuryoYMD;
    }

    /**
     * setTaishoKeisanShuryoYMD
     *
     * @param taishoKeisanShuryoYMD taishoKeisanShuryoYMD
     */
    public void setTaishoKeisanShuryoYMD(FlexibleDate taishoKeisanShuryoYMD) {
        this.taishoKeisanShuryoYMD = taishoKeisanShuryoYMD;
    }

    /**
     * getSetaiFutanSogaku
     *
     * @return setaiFutanSogaku
     */
    public Decimal getSetaiFutanSogaku() {
        return setaiFutanSogaku;
    }

    /**
     * setSetaiFutanSogaku
     *
     * @param setaiFutanSogaku setaiFutanSogaku
     */
    public void setSetaiFutanSogaku(Decimal setaiFutanSogaku) {
        this.setaiFutanSogaku = setaiFutanSogaku;
    }

    /**
     * getSetaiGassanGaku
     *
     * @return setaiGassanGaku
     */
    public Decimal getSetaiGassanGaku() {
        return setaiGassanGaku;
    }

    /**
     * setSetaiGassanGaku
     *
     * @param setaiGassanGaku setaiGassanGaku
     */
    public void setSetaiGassanGaku(Decimal setaiGassanGaku) {
        this.setaiGassanGaku = setaiGassanGaku;
    }

    /**
     * getOver70_SetaiGassanGaku
     *
     * @return over70_SetaiGassanGaku
     */
    public Decimal getOver70_SetaiGassanGaku() {
        return over70_SetaiGassanGaku;
    }

    /**
     * setOver70_SetaiGassanGaku
     *
     * @param over70_SetaiGassanGaku over70_SetaiGassanGaku
     */
    public void setOver70_SetaiGassanGaku(Decimal over70_SetaiGassanGaku) {
        this.over70_SetaiGassanGaku = over70_SetaiGassanGaku;
    }

    /**
     * getShotokuKubun
     *
     * @return shotokuKubun
     */
    public RString getShotokuKubun() {
        return shotokuKubun;
    }

    /**
     * setShotokuKubun
     *
     * @param shotokuKubun shotokuKubun
     */
    public void setShotokuKubun(RString shotokuKubun) {
        this.shotokuKubun = shotokuKubun;
    }

    /**
     * getOver70_ShotokuKubun
     *
     * @return over70_ShotokuKubun
     */
    public RString getOver70_ShotokuKubun() {
        return over70_ShotokuKubun;
    }

    /**
     * setOver70_ShotokuKubun
     *
     * @param over70_ShotokuKubun over70_ShotokuKubun
     */
    public void setOver70_ShotokuKubun(RString over70_ShotokuKubun) {
        this.over70_ShotokuKubun = over70_ShotokuKubun;
    }

    /**
     * getSanteiKijunGaku
     *
     * @return santeiKijunGaku
     */
    public Decimal getSanteiKijunGaku() {
        return santeiKijunGaku;
    }

    /**
     * setSanteiKijunGaku
     *
     * @param santeiKijunGaku santeiKijunGaku
     */
    public void setSanteiKijunGaku(Decimal santeiKijunGaku) {
        this.santeiKijunGaku = santeiKijunGaku;
    }

    /**
     * getOver70_SanteiKijyunGaku
     *
     * @return over70_SanteiKijyunGaku
     */
    public Decimal getOver70_SanteiKijyunGaku() {
        return over70_SanteiKijyunGaku;
    }

    /**
     * setOver70_SanteiKijyunGaku
     *
     * @param over70_SanteiKijyunGaku over70_SanteiKijyunGaku
     */
    public void setOver70_SanteiKijyunGaku(Decimal over70_SanteiKijyunGaku) {
        this.over70_SanteiKijyunGaku = over70_SanteiKijyunGaku;
    }

    /**
     * getSetaiShikyuSogaku
     *
     * @return setaiShikyuSogaku
     */
    public Decimal getSetaiShikyuSogaku() {
        return setaiShikyuSogaku;
    }

    /**
     * setSetaiShikyuSogaku
     *
     * @param setaiShikyuSogaku setaiShikyuSogaku
     */
    public void setSetaiShikyuSogaku(Decimal setaiShikyuSogaku) {
        this.setaiShikyuSogaku = setaiShikyuSogaku;
    }

    /**
     * getOver70_SetaiShikyuSogaku
     *
     * @return over70_SetaiShikyuSogaku
     */
    public Decimal getOver70_SetaiShikyuSogaku() {
        return over70_SetaiShikyuSogaku;
    }

    /**
     * setOver70_SetaiShikyuSogaku
     *
     * @param over70_SetaiShikyuSogaku over70_SetaiShikyuSogaku
     */
    public void setOver70_SetaiShikyuSogaku(Decimal over70_SetaiShikyuSogaku) {
        this.over70_SetaiShikyuSogaku = over70_SetaiShikyuSogaku;
    }

    /**
     * getHonninShikyugaku
     *
     * @return honninShikyugaku
     */
    public Decimal getHonninShikyugaku() {
        return honninShikyugaku;
    }

    /**
     * setHonninShikyugaku
     *
     * @param honninShikyugaku honninShikyugaku
     */
    public void setHonninShikyugaku(Decimal honninShikyugaku) {
        this.honninShikyugaku = honninShikyugaku;
    }

    /**
     * getOver70_honninShikyugaku
     *
     * @return over70_honninShikyugaku
     */
    public Decimal getOver70_honninShikyugaku() {
        return over70_honninShikyugaku;
    }

    /**
     * setOver70_honninShikyugaku
     *
     * @param over70_honninShikyugaku over70_honninShikyugaku
     */
    public void setOver70_honninShikyugaku(Decimal over70_honninShikyugaku) {
        this.over70_honninShikyugaku = over70_honninShikyugaku;
    }

    /**
     * getTeiShotoku_1_SaiKeisanUmu
     *
     * @return teiShotoku_1_SaiKeisanUmu
     */
    public RString getTeiShotoku_1_SaiKeisanUmu() {
        return teiShotoku_1_SaiKeisanUmu;
    }

    /**
     * setTeiShotoku_1_SaiKeisanUmu
     *
     * @param teiShotoku_1_SaiKeisanUmu teiShotoku_1_SaiKeisanUmu
     */
    public void setTeiShotoku_1_SaiKeisanUmu(RString teiShotoku_1_SaiKeisanUmu) {
        this.teiShotoku_1_SaiKeisanUmu = teiShotoku_1_SaiKeisanUmu;
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
     * getKekkaRenrakusakiYubinNo
     *
     * @return kekkaRenrakusakiYubinNo
     */
    public YubinNo getKekkaRenrakusakiYubinNo() {
        return kekkaRenrakusakiYubinNo;
    }

    /**
     * setKekkaRenrakusakiYubinNo
     *
     * @param kekkaRenrakusakiYubinNo kekkaRenrakusakiYubinNo
     */
    public void setKekkaRenrakusakiYubinNo(YubinNo kekkaRenrakusakiYubinNo) {
        this.kekkaRenrakusakiYubinNo = kekkaRenrakusakiYubinNo;
    }

    /**
     * getKekkaRenrakusakiJusho
     *
     * @return kekkaRenrakusakiJusho
     */
    public RString getKekkaRenrakusakiJusho() {
        return kekkaRenrakusakiJusho;
    }

    /**
     * setKekkaRenrakusakiJusho
     *
     * @param kekkaRenrakusakiJusho kekkaRenrakusakiJusho
     */
    public void setKekkaRenrakusakiJusho(RString kekkaRenrakusakiJusho) {
        this.kekkaRenrakusakiJusho = kekkaRenrakusakiJusho;
    }

    /**
     * getKetteRenrakusakiMeisho1
     *
     * @return ketteRenrakusakiMeisho1
     */
    public RString getKetteRenrakusakiMeisho1() {
        return ketteRenrakusakiMeisho1;
    }

    /**
     * setKetteRenrakusakiMeisho1
     *
     * @param ketteRenrakusakiMeisho1 ketteRenrakusakiMeisho1
     */
    public void setKetteRenrakusakiMeisho1(RString ketteRenrakusakiMeisho1) {
        this.ketteRenrakusakiMeisho1 = ketteRenrakusakiMeisho1;
    }

    /**
     * getKekkaRenrakusakiMeisho2
     *
     * @return kekkaRenrakusakiMeisho2
     */
    public RString getKekkaRenrakusakiMeisho2() {
        return kekkaRenrakusakiMeisho2;
    }

    /**
     * setKekkaRenrakusakiMeisho2
     *
     * @param kekkaRenrakusakiMeisho2 kekkaRenrakusakiMeisho2
     */
    public void setKekkaRenrakusakiMeisho2(RString kekkaRenrakusakiMeisho2) {
        this.kekkaRenrakusakiMeisho2 = kekkaRenrakusakiMeisho2;
    }

    /**
     * getTsuchiYMD
     *
     * @return tsuchiYMD
     */
    public FlexibleDate getTsuchiYMD() {
        return tsuchiYMD;
    }

    /**
     * setTsuchiYMD
     *
     * @param tsuchiYMD tsuchiYMD
     */
    public void setTsuchiYMD(FlexibleDate tsuchiYMD) {
        this.tsuchiYMD = tsuchiYMD;
    }

    /**
     * getRenrakuhyoHakkoshaMei
     *
     * @return renrakuhyoHakkoshaMei
     */
    public AtenaMeisho getRenrakuhyoHakkoshaMei() {
        return renrakuhyoHakkoshaMei;
    }

    /**
     * setRenrakuhyoHakkoshaMei
     *
     * @param renrakuhyoHakkoshaMei renrakuhyoHakkoshaMei
     */
    public void setRenrakuhyoHakkoshaMei(AtenaMeisho renrakuhyoHakkoshaMei) {
        this.renrakuhyoHakkoshaMei = renrakuhyoHakkoshaMei;
    }

    /**
     * getRenrakuhyoHakkoshaYubinNo
     *
     * @return renrakuhyoHakkoshaYubinNo
     */
    public YubinNo getRenrakuhyoHakkoshaYubinNo() {
        return renrakuhyoHakkoshaYubinNo;
    }

    /**
     * setRenrakuhyoHakkoshaYubinNo
     *
     * @param renrakuhyoHakkoshaYubinNo renrakuhyoHakkoshaYubinNo
     */
    public void setRenrakuhyoHakkoshaYubinNo(YubinNo renrakuhyoHakkoshaYubinNo) {
        this.renrakuhyoHakkoshaYubinNo = renrakuhyoHakkoshaYubinNo;
    }

    /**
     * getRenrakuhyoHakkoshaJusho
     *
     * @return renrakuhyoHakkoshaJusho
     */
    public RString getRenrakuhyoHakkoshaJusho() {
        return renrakuhyoHakkoshaJusho;
    }

    /**
     * setRenrakuhyoHakkoshaJusho
     *
     * @param renrakuhyoHakkoshaJusho renrakuhyoHakkoshaJusho
     */
    public void setRenrakuhyoHakkoshaJusho(RString renrakuhyoHakkoshaJusho) {
        this.renrakuhyoHakkoshaJusho = renrakuhyoHakkoshaJusho;
    }

    /**
     * getToiawasesakiYobinNo
     *
     * @return toiawasesakiYobinNo
     */
    public YubinNo getToiawasesakiYobinNo() {
        return toiawasesakiYobinNo;
    }

    /**
     * setToiawasesakiYobinNo
     *
     * @param toiawasesakiYobinNo toiawasesakiYobinNo
     */
    public void setToiawasesakiYobinNo(YubinNo toiawasesakiYobinNo) {
        this.toiawasesakiYobinNo = toiawasesakiYobinNo;
    }

    /**
     * getToiawasesakiJusho
     *
     * @return toiawasesakiJusho
     */
    public RString getToiawasesakiJusho() {
        return toiawasesakiJusho;
    }

    /**
     * setToiawasesakiJusho
     *
     * @param toiawasesakiJusho toiawasesakiJusho
     */
    public void setToiawasesakiJusho(RString toiawasesakiJusho) {
        this.toiawasesakiJusho = toiawasesakiJusho;
    }

    /**
     * getToiawasesakiMeisho1
     *
     * @return toiawasesakiMeisho1
     */
    public RString getToiawasesakiMeisho1() {
        return toiawasesakiMeisho1;
    }

    /**
     * setToiawasesakiMeisho1
     *
     * @param toiawasesakiMeisho1 toiawasesakiMeisho1
     */
    public void setToiawasesakiMeisho1(RString toiawasesakiMeisho1) {
        this.toiawasesakiMeisho1 = toiawasesakiMeisho1;
    }

    /**
     * getToiawasesakiMeisho2
     *
     * @return toiawasesakiMeisho2
     */
    public RString getToiawasesakiMeisho2() {
        return toiawasesakiMeisho2;
    }

    /**
     * setToiawasesakiMeisho2
     *
     * @param toiawasesakiMeisho2 toiawasesakiMeisho2
     */
    public void setToiawasesakiMeisho2(RString toiawasesakiMeisho2) {
        this.toiawasesakiMeisho2 = toiawasesakiMeisho2;
    }

    /**
     * getToiawasesakiTelNo
     *
     * @return toiawasesakiTelNo
     */
    public TelNo getToiawasesakiTelNo() {
        return toiawasesakiTelNo;
    }

    /**
     * setToiawasesakiTelNo
     *
     * @param toiawasesakiTelNo toiawasesakiTelNo
     */
    public void setToiawasesakiTelNo(TelNo toiawasesakiTelNo) {
        this.toiawasesakiTelNo = toiawasesakiTelNo;
    }

    /**
     * getOver70_FutangakuGokei
     *
     * @return over70_FutangakuGokei
     */
    public Decimal getOver70_FutangakuGokei() {
        return over70_FutangakuGokei;
    }

    /**
     * setOver70_FutangakuGokei
     *
     * @param over70_FutangakuGokei over70_FutangakuGokei
     */
    public void setOver70_FutangakuGokei(Decimal over70_FutangakuGokei) {
        this.over70_FutangakuGokei = over70_FutangakuGokei;
    }

    /**
     * getOver70_ShikyugakuGokei
     *
     * @return over70_ShikyugakuGokei
     */
    public Decimal getOver70_ShikyugakuGokei() {
        return over70_ShikyugakuGokei;
    }

    /**
     * setOver70_ShikyugakuGokei
     *
     * @param over70_ShikyugakuGokei over70_ShikyugakuGokei
     */
    public void setOver70_ShikyugakuGokei(Decimal over70_ShikyugakuGokei) {
        this.over70_ShikyugakuGokei = over70_ShikyugakuGokei;
    }

    /**
     * getUnder70_FutangakuGokei
     *
     * @return under70_FutangakuGokei
     */
    public Decimal getUnder70_FutangakuGokei() {
        return under70_FutangakuGokei;
    }

    /**
     * setUnder70_FutangakuGokei
     *
     * @param under70_FutangakuGokei under70_FutangakuGokei
     */
    public void setUnder70_FutangakuGokei(Decimal under70_FutangakuGokei) {
        this.under70_FutangakuGokei = under70_FutangakuGokei;
    }

    /**
     * getFutangakuGokei
     *
     * @return futangakuGokei
     */
    public Decimal getFutangakuGokei() {
        return futangakuGokei;
    }

    /**
     * setFutangakuGokei
     *
     * @param futangakuGokei futangakuGokei
     */
    public void setFutangakuGokei(Decimal futangakuGokei) {
        this.futangakuGokei = futangakuGokei;
    }

    /**
     * getUnder70_ShikyugakuGokei
     *
     * @return under70_ShikyugakuGokei
     */
    public Decimal getUnder70_ShikyugakuGokei() {
        return under70_ShikyugakuGokei;
    }

    /**
     * setUnder70_ShikyugakuGokei
     *
     * @param under70_ShikyugakuGokei under70_ShikyugakuGokei
     */
    public void setUnder70_ShikyugakuGokei(Decimal under70_ShikyugakuGokei) {
        this.under70_ShikyugakuGokei = under70_ShikyugakuGokei;
    }

    /**
     * getShikyugakuGokei
     *
     * @return shikyugakuGokei
     */
    public Decimal getShikyugakuGokei() {
        return shikyugakuGokei;
    }

    /**
     * setShikyugakuGokei
     *
     * @param shikyugakuGokei shikyugakuGokei
     */
    public void setShikyugakuGokei(Decimal shikyugakuGokei) {
        this.shikyugakuGokei = shikyugakuGokei;
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
     * このエンティティの主キーが他の{@literal DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity other) {
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
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.taishoNendo = entity.taishoNendo;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shikyuShinseishoSeiriNo = entity.shikyuShinseishoSeiriNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.hokenSeidoCode = entity.hokenSeidoCode;
        this.jikoFutanSeiriNo = entity.jikoFutanSeiriNo;
        this.taishoKeisanKaishiYMD = entity.taishoKeisanKaishiYMD;
        this.taishoKeisanShuryoYMD = entity.taishoKeisanShuryoYMD;
        this.setaiFutanSogaku = entity.setaiFutanSogaku;
        this.setaiGassanGaku = entity.setaiGassanGaku;
        this.over70_SetaiGassanGaku = entity.over70_SetaiGassanGaku;
        this.shotokuKubun = entity.shotokuKubun;
        this.over70_ShotokuKubun = entity.over70_ShotokuKubun;
        this.santeiKijunGaku = entity.santeiKijunGaku;
        this.over70_SanteiKijyunGaku = entity.over70_SanteiKijyunGaku;
        this.setaiShikyuSogaku = entity.setaiShikyuSogaku;
        this.over70_SetaiShikyuSogaku = entity.over70_SetaiShikyuSogaku;
        this.honninShikyugaku = entity.honninShikyugaku;
        this.over70_honninShikyugaku = entity.over70_honninShikyugaku;
        this.teiShotoku_1_SaiKeisanUmu = entity.teiShotoku_1_SaiKeisanUmu;
        this.biko = entity.biko;
        this.kekkaRenrakusakiYubinNo = entity.kekkaRenrakusakiYubinNo;
        this.kekkaRenrakusakiJusho = entity.kekkaRenrakusakiJusho;
        this.ketteRenrakusakiMeisho1 = entity.ketteRenrakusakiMeisho1;
        this.kekkaRenrakusakiMeisho2 = entity.kekkaRenrakusakiMeisho2;
        this.tsuchiYMD = entity.tsuchiYMD;
        this.renrakuhyoHakkoshaMei = entity.renrakuhyoHakkoshaMei;
        this.renrakuhyoHakkoshaYubinNo = entity.renrakuhyoHakkoshaYubinNo;
        this.renrakuhyoHakkoshaJusho = entity.renrakuhyoHakkoshaJusho;
        this.toiawasesakiYobinNo = entity.toiawasesakiYobinNo;
        this.toiawasesakiJusho = entity.toiawasesakiJusho;
        this.toiawasesakiMeisho1 = entity.toiawasesakiMeisho1;
        this.toiawasesakiMeisho2 = entity.toiawasesakiMeisho2;
        this.toiawasesakiTelNo = entity.toiawasesakiTelNo;
        this.over70_FutangakuGokei = entity.over70_FutangakuGokei;
        this.over70_ShikyugakuGokei = entity.over70_ShikyugakuGokei;
        this.under70_FutangakuGokei = entity.under70_FutangakuGokei;
        this.futangakuGokei = entity.futangakuGokei;
        this.under70_ShikyugakuGokei = entity.under70_ShikyugakuGokei;
        this.shikyugakuGokei = entity.shikyugakuGokei;
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
        return super.toMd5(hihokenshaNo, taishoNendo, shoKisaiHokenshaNo, shikyuShinseishoSeiriNo, shoriTimestamp, hokenSeidoCode, jikoFutanSeiriNo, taishoKeisanKaishiYMD, taishoKeisanShuryoYMD, setaiFutanSogaku, setaiGassanGaku, over70_SetaiGassanGaku, shotokuKubun, over70_ShotokuKubun, santeiKijunGaku, over70_SanteiKijyunGaku, setaiShikyuSogaku, over70_SetaiShikyuSogaku, honninShikyugaku, over70_honninShikyugaku, teiShotoku_1_SaiKeisanUmu, biko, kekkaRenrakusakiYubinNo, kekkaRenrakusakiJusho, ketteRenrakusakiMeisho1, kekkaRenrakusakiMeisho2, tsuchiYMD, renrakuhyoHakkoshaMei, renrakuhyoHakkoshaYubinNo, renrakuhyoHakkoshaJusho, toiawasesakiYobinNo, toiawasesakiJusho, toiawasesakiMeisho1, toiawasesakiMeisho2, toiawasesakiTelNo, over70_FutangakuGokei, over70_ShikyugakuGokei, under70_FutangakuGokei, futangakuGokei, under70_ShikyugakuGokei, shikyugakuGokei, dataKubun, uketoriYM, sofuYM);
    }

// </editor-fold>
}
