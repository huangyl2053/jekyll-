package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
 * DbT3070KogakuGassanJikoFutanGakuの項目定義クラスです
 *
 */
public class DbT3070KogakuGassanJikoFutanGakuEntity extends DbTableEntityBase<DbT3070KogakuGassanJikoFutanGakuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3070KogakuGassanJikoFutanGaku");

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
    private RString shikyuShinseishoSeiriNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private RString hokenSeidoCode;
    private RString hokenshaMei;
    private RString kokuho_HihokenshaShoKigo;
    private AtenaKanaMeisho hihokenshaShimeiKana;
    private AtenaMeisho hihokenshaShimei;
    private FlexibleDate umareYMD;
    private Code seibetsuCode;
    private RString shotokuKubun;
    private RString over70_ShotokuKubun;
    private RString jikoFutanSeiriNo;
    private RString koki_HokenshaNo;
    private RString koki_HihokenshaNo;
    private RString kokuho_HokenshaNo;
    private RString kokuho_HihokenshaShoNo;
    private RString kokuho_KojinNo;
    private RString idoKubun;
    private RString hoseiZumiSofuKubun;
    private FlexibleDate taishoKeisanKaishiYMD;
    private FlexibleDate taishoKeisanShuryoYMD;
    private FlexibleDate hihokenshaKaishiYMD;
    private FlexibleDate hihokenshaShuryoYMD;
    private FlexibleDate shinseiYMD;
    private Decimal gokei_JikoFutanGaku;
    private Decimal gokei_70_74JikoFutanGaku;
    private Decimal gokei_Under70KogakuShikyuGaku;
    private Decimal gokei_70_74KogakuShikyuGaku;
    private Decimal sumi_Gokei_JikoFutanGaku;
    private Decimal sumi_Gokei_70_74JikoFutanGaku;
    private Decimal sumi_Gokei_Under70KogakuShikyuGaku;
    private Decimal sumi_Gokei_70_74KogakuShikyuGaku;
    private AtenaMeisho atesakiShimei;
    private YubinNo atesakiYubinNo;
    private RString atesakiJusho;
    private RString madoguchi_TaishoshaHanteiCode;
    private RString shiharaiBasho;
    private FlexibleDate shikaraiKaishiYMD;
    private FlexibleDate shiharaiShuryoYMD;
    private RString heichoNaiyo;
    private RString shiharaiKaishiTime;
    private RString shiharaiShuryoTime;
    private RString biko;
    private RString dataSakuseiKubun;
    private FlexibleYearMonth kakunin_UketoriYM;
    private FlexibleYearMonth hoseiZumi_SofuYM;
    private FlexibleYearMonth shomeisho_UketoriYM;
    private RString saisoFlag;
    private RString sofuTaishoGaiFlag;
    private FlexibleDate jikoFutanKeisanYMD;
    private FlexibleDate shomeiShoSakuseiYMD;
    private RString koki_KokuhoShoriKubun;

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
     * getHokenshaMei
     *
     * @return hokenshaMei
     */
    public RString getHokenshaMei() {
        return hokenshaMei;
    }

    /**
     * setHokenshaMei
     *
     * @param hokenshaMei hokenshaMei
     */
    public void setHokenshaMei(RString hokenshaMei) {
        this.hokenshaMei = hokenshaMei;
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
     * getHihokenshaShimeiKana
     *
     * @return hihokenshaShimeiKana
     */
    public AtenaKanaMeisho getHihokenshaShimeiKana() {
        return hihokenshaShimeiKana;
    }

    /**
     * setHihokenshaShimeiKana
     *
     * @param hihokenshaShimeiKana hihokenshaShimeiKana
     */
    public void setHihokenshaShimeiKana(AtenaKanaMeisho hihokenshaShimeiKana) {
        this.hihokenshaShimeiKana = hihokenshaShimeiKana;
    }

    /**
     * getHihokenshaShimei
     *
     * @return hihokenshaShimei
     */
    public AtenaMeisho getHihokenshaShimei() {
        return hihokenshaShimei;
    }

    /**
     * setHihokenshaShimei
     *
     * @param hihokenshaShimei hihokenshaShimei
     */
    public void setHihokenshaShimei(AtenaMeisho hihokenshaShimei) {
        this.hihokenshaShimei = hihokenshaShimei;
    }

    /**
     * getUmareYMD
     *
     * @return umareYMD
     */
    public FlexibleDate getUmareYMD() {
        return umareYMD;
    }

    /**
     * setUmareYMD
     *
     * @param umareYMD umareYMD
     */
    public void setUmareYMD(FlexibleDate umareYMD) {
        this.umareYMD = umareYMD;
    }

    /**
     * getSeibetsuCode
     *
     * @return seibetsuCode
     */
    public Code getSeibetsuCode() {
        return seibetsuCode;
    }

    /**
     * setSeibetsuCode
     *
     * @param seibetsuCode seibetsuCode
     */
    public void setSeibetsuCode(Code seibetsuCode) {
        this.seibetsuCode = seibetsuCode;
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
     * getKoki_HokenshaNo
     *
     * @return koki_HokenshaNo
     */
    public RString getKoki_HokenshaNo() {
        return koki_HokenshaNo;
    }

    /**
     * setKoki_HokenshaNo
     *
     * @param koki_HokenshaNo koki_HokenshaNo
     */
    public void setKoki_HokenshaNo(RString koki_HokenshaNo) {
        this.koki_HokenshaNo = koki_HokenshaNo;
    }

    /**
     * getKoki_HihokenshaNo
     *
     * @return koki_HihokenshaNo
     */
    public RString getKoki_HihokenshaNo() {
        return koki_HihokenshaNo;
    }

    /**
     * setKoki_HihokenshaNo
     *
     * @param koki_HihokenshaNo koki_HihokenshaNo
     */
    public void setKoki_HihokenshaNo(RString koki_HihokenshaNo) {
        this.koki_HihokenshaNo = koki_HihokenshaNo;
    }

    /**
     * getKokuho_HokenshaNo
     *
     * @return kokuho_HokenshaNo
     */
    public RString getKokuho_HokenshaNo() {
        return kokuho_HokenshaNo;
    }

    /**
     * setKokuho_HokenshaNo
     *
     * @param kokuho_HokenshaNo kokuho_HokenshaNo
     */
    public void setKokuho_HokenshaNo(RString kokuho_HokenshaNo) {
        this.kokuho_HokenshaNo = kokuho_HokenshaNo;
    }

    /**
     * getKokuho_HihokenshaShoNo
     *
     * @return kokuho_HihokenshaShoNo
     */
    public RString getKokuho_HihokenshaShoNo() {
        return kokuho_HihokenshaShoNo;
    }

    /**
     * setKokuho_HihokenshaShoNo
     *
     * @param kokuho_HihokenshaShoNo kokuho_HihokenshaShoNo
     */
    public void setKokuho_HihokenshaShoNo(RString kokuho_HihokenshaShoNo) {
        this.kokuho_HihokenshaShoNo = kokuho_HihokenshaShoNo;
    }

    /**
     * getKokuho_KojinNo
     *
     * @return kokuho_KojinNo
     */
    public RString getKokuho_KojinNo() {
        return kokuho_KojinNo;
    }

    /**
     * setKokuho_KojinNo
     *
     * @param kokuho_KojinNo kokuho_KojinNo
     */
    public void setKokuho_KojinNo(RString kokuho_KojinNo) {
        this.kokuho_KojinNo = kokuho_KojinNo;
    }

    /**
     * getIdoKubun
     *
     * @return idoKubun
     */
    public RString getIdoKubun() {
        return idoKubun;
    }

    /**
     * setIdoKubun
     *
     * @param idoKubun idoKubun
     */
    public void setIdoKubun(RString idoKubun) {
        this.idoKubun = idoKubun;
    }

    /**
     * getHoseiZumiSofuKubun
     *
     * @return hoseiZumiSofuKubun
     */
    public RString getHoseiZumiSofuKubun() {
        return hoseiZumiSofuKubun;
    }

    /**
     * setHoseiZumiSofuKubun
     *
     * @param hoseiZumiSofuKubun hoseiZumiSofuKubun
     */
    public void setHoseiZumiSofuKubun(RString hoseiZumiSofuKubun) {
        this.hoseiZumiSofuKubun = hoseiZumiSofuKubun;
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
     * getHihokenshaKaishiYMD
     *
     * @return hihokenshaKaishiYMD
     */
    public FlexibleDate getHihokenshaKaishiYMD() {
        return hihokenshaKaishiYMD;
    }

    /**
     * setHihokenshaKaishiYMD
     *
     * @param hihokenshaKaishiYMD hihokenshaKaishiYMD
     */
    public void setHihokenshaKaishiYMD(FlexibleDate hihokenshaKaishiYMD) {
        this.hihokenshaKaishiYMD = hihokenshaKaishiYMD;
    }

    /**
     * getHihokenshaShuryoYMD
     *
     * @return hihokenshaShuryoYMD
     */
    public FlexibleDate getHihokenshaShuryoYMD() {
        return hihokenshaShuryoYMD;
    }

    /**
     * setHihokenshaShuryoYMD
     *
     * @param hihokenshaShuryoYMD hihokenshaShuryoYMD
     */
    public void setHihokenshaShuryoYMD(FlexibleDate hihokenshaShuryoYMD) {
        this.hihokenshaShuryoYMD = hihokenshaShuryoYMD;
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
     * getGokei_JikoFutanGaku
     *
     * @return gokei_JikoFutanGaku
     */
    public Decimal getGokei_JikoFutanGaku() {
        return gokei_JikoFutanGaku;
    }

    /**
     * setGokei_JikoFutanGaku
     *
     * @param gokei_JikoFutanGaku gokei_JikoFutanGaku
     */
    public void setGokei_JikoFutanGaku(Decimal gokei_JikoFutanGaku) {
        this.gokei_JikoFutanGaku = gokei_JikoFutanGaku;
    }

    /**
     * getGokei_70_74JikoFutanGaku
     *
     * @return gokei_70_74JikoFutanGaku
     */
    public Decimal getGokei_70_74JikoFutanGaku() {
        return gokei_70_74JikoFutanGaku;
    }

    /**
     * setGokei_70_74JikoFutanGaku
     *
     * @param gokei_70_74JikoFutanGaku gokei_70_74JikoFutanGaku
     */
    public void setGokei_70_74JikoFutanGaku(Decimal gokei_70_74JikoFutanGaku) {
        this.gokei_70_74JikoFutanGaku = gokei_70_74JikoFutanGaku;
    }

    /**
     * getGokei_Under70KogakuShikyuGaku
     *
     * @return gokei_Under70KogakuShikyuGaku
     */
    public Decimal getGokei_Under70KogakuShikyuGaku() {
        return gokei_Under70KogakuShikyuGaku;
    }

    /**
     * setGokei_Under70KogakuShikyuGaku
     *
     * @param gokei_Under70KogakuShikyuGaku gokei_Under70KogakuShikyuGaku
     */
    public void setGokei_Under70KogakuShikyuGaku(Decimal gokei_Under70KogakuShikyuGaku) {
        this.gokei_Under70KogakuShikyuGaku = gokei_Under70KogakuShikyuGaku;
    }

    /**
     * getGokei_70_74KogakuShikyuGaku
     *
     * @return gokei_70_74KogakuShikyuGaku
     */
    public Decimal getGokei_70_74KogakuShikyuGaku() {
        return gokei_70_74KogakuShikyuGaku;
    }

    /**
     * setGokei_70_74KogakuShikyuGaku
     *
     * @param gokei_70_74KogakuShikyuGaku gokei_70_74KogakuShikyuGaku
     */
    public void setGokei_70_74KogakuShikyuGaku(Decimal gokei_70_74KogakuShikyuGaku) {
        this.gokei_70_74KogakuShikyuGaku = gokei_70_74KogakuShikyuGaku;
    }

    /**
     * getSumi_Gokei_JikoFutanGaku
     *
     * @return sumi_Gokei_JikoFutanGaku
     */
    public Decimal getSumi_Gokei_JikoFutanGaku() {
        return sumi_Gokei_JikoFutanGaku;
    }

    /**
     * setSumi_Gokei_JikoFutanGaku
     *
     * @param sumi_Gokei_JikoFutanGaku sumi_Gokei_JikoFutanGaku
     */
    public void setSumi_Gokei_JikoFutanGaku(Decimal sumi_Gokei_JikoFutanGaku) {
        this.sumi_Gokei_JikoFutanGaku = sumi_Gokei_JikoFutanGaku;
    }

    /**
     * getSumi_Gokei_70_74JikoFutanGaku
     *
     * @return sumi_Gokei_70_74JikoFutanGaku
     */
    public Decimal getSumi_Gokei_70_74JikoFutanGaku() {
        return sumi_Gokei_70_74JikoFutanGaku;
    }

    /**
     * setSumi_Gokei_70_74JikoFutanGaku
     *
     * @param sumi_Gokei_70_74JikoFutanGaku sumi_Gokei_70_74JikoFutanGaku
     */
    public void setSumi_Gokei_70_74JikoFutanGaku(Decimal sumi_Gokei_70_74JikoFutanGaku) {
        this.sumi_Gokei_70_74JikoFutanGaku = sumi_Gokei_70_74JikoFutanGaku;
    }

    /**
     * getSumi_Gokei_Under70KogakuShikyuGaku
     *
     * @return sumi_Gokei_Under70KogakuShikyuGaku
     */
    public Decimal getSumi_Gokei_Under70KogakuShikyuGaku() {
        return sumi_Gokei_Under70KogakuShikyuGaku;
    }

    /**
     * setSumi_Gokei_Under70KogakuShikyuGaku
     *
     * @param sumi_Gokei_Under70KogakuShikyuGaku sumi_Gokei_Under70KogakuShikyuGaku
     */
    public void setSumi_Gokei_Under70KogakuShikyuGaku(Decimal sumi_Gokei_Under70KogakuShikyuGaku) {
        this.sumi_Gokei_Under70KogakuShikyuGaku = sumi_Gokei_Under70KogakuShikyuGaku;
    }

    /**
     * getSumi_Gokei_70_74KogakuShikyuGaku
     *
     * @return sumi_Gokei_70_74KogakuShikyuGaku
     */
    public Decimal getSumi_Gokei_70_74KogakuShikyuGaku() {
        return sumi_Gokei_70_74KogakuShikyuGaku;
    }

    /**
     * setSumi_Gokei_70_74KogakuShikyuGaku
     *
     * @param sumi_Gokei_70_74KogakuShikyuGaku sumi_Gokei_70_74KogakuShikyuGaku
     */
    public void setSumi_Gokei_70_74KogakuShikyuGaku(Decimal sumi_Gokei_70_74KogakuShikyuGaku) {
        this.sumi_Gokei_70_74KogakuShikyuGaku = sumi_Gokei_70_74KogakuShikyuGaku;
    }

    /**
     * getAtesakiShimei
     *
     * @return atesakiShimei
     */
    public AtenaMeisho getAtesakiShimei() {
        return atesakiShimei;
    }

    /**
     * setAtesakiShimei
     *
     * @param atesakiShimei atesakiShimei
     */
    public void setAtesakiShimei(AtenaMeisho atesakiShimei) {
        this.atesakiShimei = atesakiShimei;
    }

    /**
     * getAtesakiYubinNo
     *
     * @return atesakiYubinNo
     */
    public YubinNo getAtesakiYubinNo() {
        return atesakiYubinNo;
    }

    /**
     * setAtesakiYubinNo
     *
     * @param atesakiYubinNo atesakiYubinNo
     */
    public void setAtesakiYubinNo(YubinNo atesakiYubinNo) {
        this.atesakiYubinNo = atesakiYubinNo;
    }

    /**
     * getAtesakiJusho
     *
     * @return atesakiJusho
     */
    public RString getAtesakiJusho() {
        return atesakiJusho;
    }

    /**
     * setAtesakiJusho
     *
     * @param atesakiJusho atesakiJusho
     */
    public void setAtesakiJusho(RString atesakiJusho) {
        this.atesakiJusho = atesakiJusho;
    }

    /**
     * getMadoguchi_TaishoshaHanteiCode
     *
     * @return madoguchi_TaishoshaHanteiCode
     */
    public RString getMadoguchi_TaishoshaHanteiCode() {
        return madoguchi_TaishoshaHanteiCode;
    }

    /**
     * setMadoguchi_TaishoshaHanteiCode
     *
     * @param madoguchi_TaishoshaHanteiCode madoguchi_TaishoshaHanteiCode
     */
    public void setMadoguchi_TaishoshaHanteiCode(RString madoguchi_TaishoshaHanteiCode) {
        this.madoguchi_TaishoshaHanteiCode = madoguchi_TaishoshaHanteiCode;
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
     * getShikaraiKaishiYMD
     *
     * @return shikaraiKaishiYMD
     */
    public FlexibleDate getShikaraiKaishiYMD() {
        return shikaraiKaishiYMD;
    }

    /**
     * setShikaraiKaishiYMD
     *
     * @param shikaraiKaishiYMD shikaraiKaishiYMD
     */
    public void setShikaraiKaishiYMD(FlexibleDate shikaraiKaishiYMD) {
        this.shikaraiKaishiYMD = shikaraiKaishiYMD;
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
     * getDataSakuseiKubun
     *
     * @return dataSakuseiKubun
     */
    public RString getDataSakuseiKubun() {
        return dataSakuseiKubun;
    }

    /**
     * setDataSakuseiKubun
     *
     * @param dataSakuseiKubun dataSakuseiKubun
     */
    public void setDataSakuseiKubun(RString dataSakuseiKubun) {
        this.dataSakuseiKubun = dataSakuseiKubun;
    }

    /**
     * getKakunin_UketoriYM
     *
     * @return kakunin_UketoriYM
     */
    public FlexibleYearMonth getKakunin_UketoriYM() {
        return kakunin_UketoriYM;
    }

    /**
     * setKakunin_UketoriYM
     *
     * @param kakunin_UketoriYM kakunin_UketoriYM
     */
    public void setKakunin_UketoriYM(FlexibleYearMonth kakunin_UketoriYM) {
        this.kakunin_UketoriYM = kakunin_UketoriYM;
    }

    /**
     * getHoseiZumi_SofuYM
     *
     * @return hoseiZumi_SofuYM
     */
    public FlexibleYearMonth getHoseiZumi_SofuYM() {
        return hoseiZumi_SofuYM;
    }

    /**
     * setHoseiZumi_SofuYM
     *
     * @param hoseiZumi_SofuYM hoseiZumi_SofuYM
     */
    public void setHoseiZumi_SofuYM(FlexibleYearMonth hoseiZumi_SofuYM) {
        this.hoseiZumi_SofuYM = hoseiZumi_SofuYM;
    }

    /**
     * getShomeisho_UketoriYM
     *
     * @return shomeisho_UketoriYM
     */
    public FlexibleYearMonth getShomeisho_UketoriYM() {
        return shomeisho_UketoriYM;
    }

    /**
     * setShomeisho_UketoriYM
     *
     * @param shomeisho_UketoriYM shomeisho_UketoriYM
     */
    public void setShomeisho_UketoriYM(FlexibleYearMonth shomeisho_UketoriYM) {
        this.shomeisho_UketoriYM = shomeisho_UketoriYM;
    }

    /**
     * getSaisoFlag
     *
     * @return saisoFlag
     */
    public RString getSaisoFlag() {
        return saisoFlag;
    }

    /**
     * setSaisoFlag
     *
     * @param saisoFlag saisoFlag
     */
    public void setSaisoFlag(RString saisoFlag) {
        this.saisoFlag = saisoFlag;
    }

    /**
     * getSofuTaishoGaiFlag
     *
     * @return sofuTaishoGaiFlag
     */
    public RString getSofuTaishoGaiFlag() {
        return sofuTaishoGaiFlag;
    }

    /**
     * setSofuTaishoGaiFlag
     *
     * @param sofuTaishoGaiFlag sofuTaishoGaiFlag
     */
    public void setSofuTaishoGaiFlag(RString sofuTaishoGaiFlag) {
        this.sofuTaishoGaiFlag = sofuTaishoGaiFlag;
    }

    /**
     * getJikoFutanKeisanYMD
     *
     * @return jikoFutanKeisanYMD
     */
    public FlexibleDate getJikoFutanKeisanYMD() {
        return jikoFutanKeisanYMD;
    }

    /**
     * setJikoFutanKeisanYMD
     *
     * @param jikoFutanKeisanYMD jikoFutanKeisanYMD
     */
    public void setJikoFutanKeisanYMD(FlexibleDate jikoFutanKeisanYMD) {
        this.jikoFutanKeisanYMD = jikoFutanKeisanYMD;
    }

    /**
     * getShomeiShoSakuseiYMD
     *
     * @return shomeiShoSakuseiYMD
     */
    public FlexibleDate getShomeiShoSakuseiYMD() {
        return shomeiShoSakuseiYMD;
    }

    /**
     * setShomeiShoSakuseiYMD
     *
     * @param shomeiShoSakuseiYMD shomeiShoSakuseiYMD
     */
    public void setShomeiShoSakuseiYMD(FlexibleDate shomeiShoSakuseiYMD) {
        this.shomeiShoSakuseiYMD = shomeiShoSakuseiYMD;
    }

    /**
     * getKoki_KokuhoShoriKubun
     *
     * @return koki_KokuhoShoriKubun
     */
    public RString getKoki_KokuhoShoriKubun() {
        return koki_KokuhoShoriKubun;
    }

    /**
     * setKoki_KokuhoShoriKubun
     *
     * @param koki_KokuhoShoriKubun koki_KokuhoShoriKubun
     */
    public void setKoki_KokuhoShoriKubun(RString koki_KokuhoShoriKubun) {
        this.koki_KokuhoShoriKubun = koki_KokuhoShoriKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3070KogakuGassanJikoFutanGakuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3070KogakuGassanJikoFutanGakuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3070KogakuGassanJikoFutanGakuEntity other) {
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
    public void shallowCopy(DbT3070KogakuGassanJikoFutanGakuEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.taishoNendo = entity.taishoNendo;
        this.hokenshaNo = entity.hokenshaNo;
        this.shikyuShinseishoSeiriNo = entity.shikyuShinseishoSeiriNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.hokenSeidoCode = entity.hokenSeidoCode;
        this.hokenshaMei = entity.hokenshaMei;
        this.kokuho_HihokenshaShoKigo = entity.kokuho_HihokenshaShoKigo;
        this.hihokenshaShimeiKana = entity.hihokenshaShimeiKana;
        this.hihokenshaShimei = entity.hihokenshaShimei;
        this.umareYMD = entity.umareYMD;
        this.seibetsuCode = entity.seibetsuCode;
        this.shotokuKubun = entity.shotokuKubun;
        this.over70_ShotokuKubun = entity.over70_ShotokuKubun;
        this.jikoFutanSeiriNo = entity.jikoFutanSeiriNo;
        this.koki_HokenshaNo = entity.koki_HokenshaNo;
        this.koki_HihokenshaNo = entity.koki_HihokenshaNo;
        this.kokuho_HokenshaNo = entity.kokuho_HokenshaNo;
        this.kokuho_HihokenshaShoNo = entity.kokuho_HihokenshaShoNo;
        this.kokuho_KojinNo = entity.kokuho_KojinNo;
        this.idoKubun = entity.idoKubun;
        this.hoseiZumiSofuKubun = entity.hoseiZumiSofuKubun;
        this.taishoKeisanKaishiYMD = entity.taishoKeisanKaishiYMD;
        this.taishoKeisanShuryoYMD = entity.taishoKeisanShuryoYMD;
        this.hihokenshaKaishiYMD = entity.hihokenshaKaishiYMD;
        this.hihokenshaShuryoYMD = entity.hihokenshaShuryoYMD;
        this.shinseiYMD = entity.shinseiYMD;
        this.gokei_JikoFutanGaku = entity.gokei_JikoFutanGaku;
        this.gokei_70_74JikoFutanGaku = entity.gokei_70_74JikoFutanGaku;
        this.gokei_Under70KogakuShikyuGaku = entity.gokei_Under70KogakuShikyuGaku;
        this.gokei_70_74KogakuShikyuGaku = entity.gokei_70_74KogakuShikyuGaku;
        this.sumi_Gokei_JikoFutanGaku = entity.sumi_Gokei_JikoFutanGaku;
        this.sumi_Gokei_70_74JikoFutanGaku = entity.sumi_Gokei_70_74JikoFutanGaku;
        this.sumi_Gokei_Under70KogakuShikyuGaku = entity.sumi_Gokei_Under70KogakuShikyuGaku;
        this.sumi_Gokei_70_74KogakuShikyuGaku = entity.sumi_Gokei_70_74KogakuShikyuGaku;
        this.atesakiShimei = entity.atesakiShimei;
        this.atesakiYubinNo = entity.atesakiYubinNo;
        this.atesakiJusho = entity.atesakiJusho;
        this.madoguchi_TaishoshaHanteiCode = entity.madoguchi_TaishoshaHanteiCode;
        this.shiharaiBasho = entity.shiharaiBasho;
        this.shikaraiKaishiYMD = entity.shikaraiKaishiYMD;
        this.shiharaiShuryoYMD = entity.shiharaiShuryoYMD;
        this.heichoNaiyo = entity.heichoNaiyo;
        this.shiharaiKaishiTime = entity.shiharaiKaishiTime;
        this.shiharaiShuryoTime = entity.shiharaiShuryoTime;
        this.biko = entity.biko;
        this.dataSakuseiKubun = entity.dataSakuseiKubun;
        this.kakunin_UketoriYM = entity.kakunin_UketoriYM;
        this.hoseiZumi_SofuYM = entity.hoseiZumi_SofuYM;
        this.shomeisho_UketoriYM = entity.shomeisho_UketoriYM;
        this.saisoFlag = entity.saisoFlag;
        this.sofuTaishoGaiFlag = entity.sofuTaishoGaiFlag;
        this.jikoFutanKeisanYMD = entity.jikoFutanKeisanYMD;
        this.shomeiShoSakuseiYMD = entity.shomeiShoSakuseiYMD;
        this.koki_KokuhoShoriKubun = entity.koki_KokuhoShoriKubun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, taishoNendo, hokenshaNo, shikyuShinseishoSeiriNo, shoriTimestamp, hokenSeidoCode, hokenshaMei, kokuho_HihokenshaShoKigo, hihokenshaShimeiKana, hihokenshaShimei, umareYMD, seibetsuCode, shotokuKubun, over70_ShotokuKubun, jikoFutanSeiriNo, koki_HokenshaNo, koki_HihokenshaNo, kokuho_HokenshaNo, kokuho_HihokenshaShoNo, kokuho_KojinNo, idoKubun, hoseiZumiSofuKubun, taishoKeisanKaishiYMD, taishoKeisanShuryoYMD, hihokenshaKaishiYMD, hihokenshaShuryoYMD, shinseiYMD, gokei_JikoFutanGaku, gokei_70_74JikoFutanGaku, gokei_Under70KogakuShikyuGaku, gokei_70_74KogakuShikyuGaku, sumi_Gokei_JikoFutanGaku, sumi_Gokei_70_74JikoFutanGaku, sumi_Gokei_Under70KogakuShikyuGaku, sumi_Gokei_70_74KogakuShikyuGaku, atesakiShimei, atesakiYubinNo, atesakiJusho, madoguchi_TaishoshaHanteiCode, shiharaiBasho, shikaraiKaishiYMD, shiharaiShuryoYMD, heichoNaiyo, shiharaiKaishiTime, shiharaiShuryoTime, biko, dataSakuseiKubun, kakunin_UketoriYM, hoseiZumi_SofuYM, shomeisho_UketoriYM, saisoFlag, sofuTaishoGaiFlag, jikoFutanKeisanYMD, shomeiShoSakuseiYMD, koki_KokuhoShoriKubun);
    }

// </editor-fold>
}
