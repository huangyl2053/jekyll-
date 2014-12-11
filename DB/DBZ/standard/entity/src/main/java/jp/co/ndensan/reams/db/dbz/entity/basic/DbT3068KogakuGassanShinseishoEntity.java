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
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3068KogakuGassanShinseishoの項目定義クラスです
 *
 */
public class DbT3068KogakuGassanShinseishoEntity extends DbTableEntityBase<DbT3068KogakuGassanShinseishoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3068KogakuGassanShinseisho");

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
    private RString seiriNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private RString shinseiJokyoKubun;
    private FlexibleDate shinseiYMD;
    private RString shikyuShinseishoSeiriNo;
    private RString kokuhoShikyuShinseishoSeiriNo;
    private RString shikyuShinseiKubun;
    private FlexibleDate taishoKeisanKaishiYMD;
    private FlexibleDate taishoKeisanShuryoYMD;
    private RString shikyuShinseiKeitai;
    private RString jikoFutanKofuUmu;
    private AtenaMeisho shinseiDaihyoshaShimei;
    private YubinNo shinseiDaihyoshaYubinNo;
    private RString shinseiDaihyoshaJusho;
    private TelNo shinseiDaihyoshaTelNo;
    private RString shotokuKubun;
    private RString over70_ShotokuKubun;
    private FlexibleDate shikakuSoshitsuYMD;
    private RString shikakuSoshitsuJiyu;
    private FlexibleDate kanyuKaishiYMD;
    private FlexibleDate kanyuShuryoYMD;
    private RString kokuho_HokenshaNo;
    private RString kokuho_HokenshaMeisho;
    private RString kokuho_HihokenshaShoKigo;
    private RString kokuho_HihokenshaShoNo;
    private RString kokuho_SetaiNo;
    private RString kokuho_Zokugara;
    private FlexibleDate kokuho_KanyuKaishiYMD;
    private FlexibleDate kokuho_KanyuShuryoYMD;
    private RString koki_HokenshaNo;
    private RString koki_KoikiRengoMeisho;
    private RString koki_HihokenshaNo;
    private FlexibleDate koki_KanyuKaishiYMD;
    private FlexibleDate koki_KanyuShuryoYMD;
    private RString shiharaiHohoKubun;
    private RString shiharaiBasho;
    private FlexibleDate shiharaiKaishiYMD;
    private FlexibleDate shiharaiShuryoYMD;
    private RString heichoNaiyo;
    private RString shiharaiKaishiTime;
    private RString shiharaiShuryoTime;
    private RString biko;
    private FlexibleYearMonth shikyuShinseisho_SofuYM;
    private RString saiSofuFlag;
    private FlexibleYearMonth jikoFutan_KeisanYM;
    private RString saiKeisanKubun;

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
     * getShinseiJokyoKubun
     *
     * @return shinseiJokyoKubun
     */
    public RString getShinseiJokyoKubun() {
        return shinseiJokyoKubun;
    }

    /**
     * setShinseiJokyoKubun
     *
     * @param shinseiJokyoKubun shinseiJokyoKubun
     */
    public void setShinseiJokyoKubun(RString shinseiJokyoKubun) {
        this.shinseiJokyoKubun = shinseiJokyoKubun;
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
     * getKokuhoShikyuShinseishoSeiriNo
     *
     * @return kokuhoShikyuShinseishoSeiriNo
     */
    public RString getKokuhoShikyuShinseishoSeiriNo() {
        return kokuhoShikyuShinseishoSeiriNo;
    }

    /**
     * setKokuhoShikyuShinseishoSeiriNo
     *
     * @param kokuhoShikyuShinseishoSeiriNo kokuhoShikyuShinseishoSeiriNo
     */
    public void setKokuhoShikyuShinseishoSeiriNo(RString kokuhoShikyuShinseishoSeiriNo) {
        this.kokuhoShikyuShinseishoSeiriNo = kokuhoShikyuShinseishoSeiriNo;
    }

    /**
     * getShikyuShinseiKubun
     *
     * @return shikyuShinseiKubun
     */
    public RString getShikyuShinseiKubun() {
        return shikyuShinseiKubun;
    }

    /**
     * setShikyuShinseiKubun
     *
     * @param shikyuShinseiKubun shikyuShinseiKubun
     */
    public void setShikyuShinseiKubun(RString shikyuShinseiKubun) {
        this.shikyuShinseiKubun = shikyuShinseiKubun;
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
     * getShikyuShinseiKeitai
     *
     * @return shikyuShinseiKeitai
     */
    public RString getShikyuShinseiKeitai() {
        return shikyuShinseiKeitai;
    }

    /**
     * setShikyuShinseiKeitai
     *
     * @param shikyuShinseiKeitai shikyuShinseiKeitai
     */
    public void setShikyuShinseiKeitai(RString shikyuShinseiKeitai) {
        this.shikyuShinseiKeitai = shikyuShinseiKeitai;
    }

    /**
     * getJikoFutanKofuUmu
     *
     * @return jikoFutanKofuUmu
     */
    public RString getJikoFutanKofuUmu() {
        return jikoFutanKofuUmu;
    }

    /**
     * setJikoFutanKofuUmu
     *
     * @param jikoFutanKofuUmu jikoFutanKofuUmu
     */
    public void setJikoFutanKofuUmu(RString jikoFutanKofuUmu) {
        this.jikoFutanKofuUmu = jikoFutanKofuUmu;
    }

    /**
     * getShinseiDaihyoshaShimei
     *
     * @return shinseiDaihyoshaShimei
     */
    public AtenaMeisho getShinseiDaihyoshaShimei() {
        return shinseiDaihyoshaShimei;
    }

    /**
     * setShinseiDaihyoshaShimei
     *
     * @param shinseiDaihyoshaShimei shinseiDaihyoshaShimei
     */
    public void setShinseiDaihyoshaShimei(AtenaMeisho shinseiDaihyoshaShimei) {
        this.shinseiDaihyoshaShimei = shinseiDaihyoshaShimei;
    }

    /**
     * getShinseiDaihyoshaYubinNo
     *
     * @return shinseiDaihyoshaYubinNo
     */
    public YubinNo getShinseiDaihyoshaYubinNo() {
        return shinseiDaihyoshaYubinNo;
    }

    /**
     * setShinseiDaihyoshaYubinNo
     *
     * @param shinseiDaihyoshaYubinNo shinseiDaihyoshaYubinNo
     */
    public void setShinseiDaihyoshaYubinNo(YubinNo shinseiDaihyoshaYubinNo) {
        this.shinseiDaihyoshaYubinNo = shinseiDaihyoshaYubinNo;
    }

    /**
     * getShinseiDaihyoshaJusho
     *
     * @return shinseiDaihyoshaJusho
     */
    public RString getShinseiDaihyoshaJusho() {
        return shinseiDaihyoshaJusho;
    }

    /**
     * setShinseiDaihyoshaJusho
     *
     * @param shinseiDaihyoshaJusho shinseiDaihyoshaJusho
     */
    public void setShinseiDaihyoshaJusho(RString shinseiDaihyoshaJusho) {
        this.shinseiDaihyoshaJusho = shinseiDaihyoshaJusho;
    }

    /**
     * getShinseiDaihyoshaTelNo
     *
     * @return shinseiDaihyoshaTelNo
     */
    public TelNo getShinseiDaihyoshaTelNo() {
        return shinseiDaihyoshaTelNo;
    }

    /**
     * setShinseiDaihyoshaTelNo
     *
     * @param shinseiDaihyoshaTelNo shinseiDaihyoshaTelNo
     */
    public void setShinseiDaihyoshaTelNo(TelNo shinseiDaihyoshaTelNo) {
        this.shinseiDaihyoshaTelNo = shinseiDaihyoshaTelNo;
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
     * getShikakuSoshitsuYMD
     *
     * @return shikakuSoshitsuYMD
     */
    public FlexibleDate getShikakuSoshitsuYMD() {
        return shikakuSoshitsuYMD;
    }

    /**
     * setShikakuSoshitsuYMD
     *
     * @param shikakuSoshitsuYMD shikakuSoshitsuYMD
     */
    public void setShikakuSoshitsuYMD(FlexibleDate shikakuSoshitsuYMD) {
        this.shikakuSoshitsuYMD = shikakuSoshitsuYMD;
    }

    /**
     * getShikakuSoshitsuJiyu
     *
     * @return shikakuSoshitsuJiyu
     */
    public RString getShikakuSoshitsuJiyu() {
        return shikakuSoshitsuJiyu;
    }

    /**
     * setShikakuSoshitsuJiyu
     *
     * @param shikakuSoshitsuJiyu shikakuSoshitsuJiyu
     */
    public void setShikakuSoshitsuJiyu(RString shikakuSoshitsuJiyu) {
        this.shikakuSoshitsuJiyu = shikakuSoshitsuJiyu;
    }

    /**
     * getKanyuKaishiYMD
     *
     * @return kanyuKaishiYMD
     */
    public FlexibleDate getKanyuKaishiYMD() {
        return kanyuKaishiYMD;
    }

    /**
     * setKanyuKaishiYMD
     *
     * @param kanyuKaishiYMD kanyuKaishiYMD
     */
    public void setKanyuKaishiYMD(FlexibleDate kanyuKaishiYMD) {
        this.kanyuKaishiYMD = kanyuKaishiYMD;
    }

    /**
     * getKanyuShuryoYMD
     *
     * @return kanyuShuryoYMD
     */
    public FlexibleDate getKanyuShuryoYMD() {
        return kanyuShuryoYMD;
    }

    /**
     * setKanyuShuryoYMD
     *
     * @param kanyuShuryoYMD kanyuShuryoYMD
     */
    public void setKanyuShuryoYMD(FlexibleDate kanyuShuryoYMD) {
        this.kanyuShuryoYMD = kanyuShuryoYMD;
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
     * getKokuho_HokenshaMeisho
     *
     * @return kokuho_HokenshaMeisho
     */
    public RString getKokuho_HokenshaMeisho() {
        return kokuho_HokenshaMeisho;
    }

    /**
     * setKokuho_HokenshaMeisho
     *
     * @param kokuho_HokenshaMeisho kokuho_HokenshaMeisho
     */
    public void setKokuho_HokenshaMeisho(RString kokuho_HokenshaMeisho) {
        this.kokuho_HokenshaMeisho = kokuho_HokenshaMeisho;
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
     * getKokuho_SetaiNo
     *
     * @return kokuho_SetaiNo
     */
    public RString getKokuho_SetaiNo() {
        return kokuho_SetaiNo;
    }

    /**
     * setKokuho_SetaiNo
     *
     * @param kokuho_SetaiNo kokuho_SetaiNo
     */
    public void setKokuho_SetaiNo(RString kokuho_SetaiNo) {
        this.kokuho_SetaiNo = kokuho_SetaiNo;
    }

    /**
     * getKokuho_Zokugara
     *
     * @return kokuho_Zokugara
     */
    public RString getKokuho_Zokugara() {
        return kokuho_Zokugara;
    }

    /**
     * setKokuho_Zokugara
     *
     * @param kokuho_Zokugara kokuho_Zokugara
     */
    public void setKokuho_Zokugara(RString kokuho_Zokugara) {
        this.kokuho_Zokugara = kokuho_Zokugara;
    }

    /**
     * getKokuho_KanyuKaishiYMD
     *
     * @return kokuho_KanyuKaishiYMD
     */
    public FlexibleDate getKokuho_KanyuKaishiYMD() {
        return kokuho_KanyuKaishiYMD;
    }

    /**
     * setKokuho_KanyuKaishiYMD
     *
     * @param kokuho_KanyuKaishiYMD kokuho_KanyuKaishiYMD
     */
    public void setKokuho_KanyuKaishiYMD(FlexibleDate kokuho_KanyuKaishiYMD) {
        this.kokuho_KanyuKaishiYMD = kokuho_KanyuKaishiYMD;
    }

    /**
     * getKokuho_KanyuShuryoYMD
     *
     * @return kokuho_KanyuShuryoYMD
     */
    public FlexibleDate getKokuho_KanyuShuryoYMD() {
        return kokuho_KanyuShuryoYMD;
    }

    /**
     * setKokuho_KanyuShuryoYMD
     *
     * @param kokuho_KanyuShuryoYMD kokuho_KanyuShuryoYMD
     */
    public void setKokuho_KanyuShuryoYMD(FlexibleDate kokuho_KanyuShuryoYMD) {
        this.kokuho_KanyuShuryoYMD = kokuho_KanyuShuryoYMD;
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
     * getKoki_KoikiRengoMeisho
     *
     * @return koki_KoikiRengoMeisho
     */
    public RString getKoki_KoikiRengoMeisho() {
        return koki_KoikiRengoMeisho;
    }

    /**
     * setKoki_KoikiRengoMeisho
     *
     * @param koki_KoikiRengoMeisho koki_KoikiRengoMeisho
     */
    public void setKoki_KoikiRengoMeisho(RString koki_KoikiRengoMeisho) {
        this.koki_KoikiRengoMeisho = koki_KoikiRengoMeisho;
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
     * getKoki_KanyuKaishiYMD
     *
     * @return koki_KanyuKaishiYMD
     */
    public FlexibleDate getKoki_KanyuKaishiYMD() {
        return koki_KanyuKaishiYMD;
    }

    /**
     * setKoki_KanyuKaishiYMD
     *
     * @param koki_KanyuKaishiYMD koki_KanyuKaishiYMD
     */
    public void setKoki_KanyuKaishiYMD(FlexibleDate koki_KanyuKaishiYMD) {
        this.koki_KanyuKaishiYMD = koki_KanyuKaishiYMD;
    }

    /**
     * getKoki_KanyuShuryoYMD
     *
     * @return koki_KanyuShuryoYMD
     */
    public FlexibleDate getKoki_KanyuShuryoYMD() {
        return koki_KanyuShuryoYMD;
    }

    /**
     * setKoki_KanyuShuryoYMD
     *
     * @param koki_KanyuShuryoYMD koki_KanyuShuryoYMD
     */
    public void setKoki_KanyuShuryoYMD(FlexibleDate koki_KanyuShuryoYMD) {
        this.koki_KanyuShuryoYMD = koki_KanyuShuryoYMD;
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
     * getShikyuShinseisho_SofuYM
     *
     * @return shikyuShinseisho_SofuYM
     */
    public FlexibleYearMonth getShikyuShinseisho_SofuYM() {
        return shikyuShinseisho_SofuYM;
    }

    /**
     * setShikyuShinseisho_SofuYM
     *
     * @param shikyuShinseisho_SofuYM shikyuShinseisho_SofuYM
     */
    public void setShikyuShinseisho_SofuYM(FlexibleYearMonth shikyuShinseisho_SofuYM) {
        this.shikyuShinseisho_SofuYM = shikyuShinseisho_SofuYM;
    }

    /**
     * getSaiSofuFlag
     *
     * @return saiSofuFlag
     */
    public RString getSaiSofuFlag() {
        return saiSofuFlag;
    }

    /**
     * setSaiSofuFlag
     *
     * @param saiSofuFlag saiSofuFlag
     */
    public void setSaiSofuFlag(RString saiSofuFlag) {
        this.saiSofuFlag = saiSofuFlag;
    }

    /**
     * getJikoFutan_KeisanYM
     *
     * @return jikoFutan_KeisanYM
     */
    public FlexibleYearMonth getJikoFutan_KeisanYM() {
        return jikoFutan_KeisanYM;
    }

    /**
     * setJikoFutan_KeisanYM
     *
     * @param jikoFutan_KeisanYM jikoFutan_KeisanYM
     */
    public void setJikoFutan_KeisanYM(FlexibleYearMonth jikoFutan_KeisanYM) {
        this.jikoFutan_KeisanYM = jikoFutan_KeisanYM;
    }

    /**
     * getSaiKeisanKubun
     *
     * @return saiKeisanKubun
     */
    public RString getSaiKeisanKubun() {
        return saiKeisanKubun;
    }

    /**
     * setSaiKeisanKubun
     *
     * @param saiKeisanKubun saiKeisanKubun
     */
    public void setSaiKeisanKubun(RString saiKeisanKubun) {
        this.saiKeisanKubun = saiKeisanKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3068KogakuGassanShinseishoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3068KogakuGassanShinseishoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3068KogakuGassanShinseishoEntity other) {
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
    public void shallowCopy(DbT3068KogakuGassanShinseishoEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.taishoNendo = entity.taishoNendo;
        this.hokenshaNo = entity.hokenshaNo;
        this.seiriNo = entity.seiriNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.shinseiJokyoKubun = entity.shinseiJokyoKubun;
        this.shinseiYMD = entity.shinseiYMD;
        this.shikyuShinseishoSeiriNo = entity.shikyuShinseishoSeiriNo;
        this.kokuhoShikyuShinseishoSeiriNo = entity.kokuhoShikyuShinseishoSeiriNo;
        this.shikyuShinseiKubun = entity.shikyuShinseiKubun;
        this.taishoKeisanKaishiYMD = entity.taishoKeisanKaishiYMD;
        this.taishoKeisanShuryoYMD = entity.taishoKeisanShuryoYMD;
        this.shikyuShinseiKeitai = entity.shikyuShinseiKeitai;
        this.jikoFutanKofuUmu = entity.jikoFutanKofuUmu;
        this.shinseiDaihyoshaShimei = entity.shinseiDaihyoshaShimei;
        this.shinseiDaihyoshaYubinNo = entity.shinseiDaihyoshaYubinNo;
        this.shinseiDaihyoshaJusho = entity.shinseiDaihyoshaJusho;
        this.shinseiDaihyoshaTelNo = entity.shinseiDaihyoshaTelNo;
        this.shotokuKubun = entity.shotokuKubun;
        this.over70_ShotokuKubun = entity.over70_ShotokuKubun;
        this.shikakuSoshitsuYMD = entity.shikakuSoshitsuYMD;
        this.shikakuSoshitsuJiyu = entity.shikakuSoshitsuJiyu;
        this.kanyuKaishiYMD = entity.kanyuKaishiYMD;
        this.kanyuShuryoYMD = entity.kanyuShuryoYMD;
        this.kokuho_HokenshaNo = entity.kokuho_HokenshaNo;
        this.kokuho_HokenshaMeisho = entity.kokuho_HokenshaMeisho;
        this.kokuho_HihokenshaShoKigo = entity.kokuho_HihokenshaShoKigo;
        this.kokuho_HihokenshaShoNo = entity.kokuho_HihokenshaShoNo;
        this.kokuho_SetaiNo = entity.kokuho_SetaiNo;
        this.kokuho_Zokugara = entity.kokuho_Zokugara;
        this.kokuho_KanyuKaishiYMD = entity.kokuho_KanyuKaishiYMD;
        this.kokuho_KanyuShuryoYMD = entity.kokuho_KanyuShuryoYMD;
        this.koki_HokenshaNo = entity.koki_HokenshaNo;
        this.koki_KoikiRengoMeisho = entity.koki_KoikiRengoMeisho;
        this.koki_HihokenshaNo = entity.koki_HihokenshaNo;
        this.koki_KanyuKaishiYMD = entity.koki_KanyuKaishiYMD;
        this.koki_KanyuShuryoYMD = entity.koki_KanyuShuryoYMD;
        this.shiharaiHohoKubun = entity.shiharaiHohoKubun;
        this.shiharaiBasho = entity.shiharaiBasho;
        this.shiharaiKaishiYMD = entity.shiharaiKaishiYMD;
        this.shiharaiShuryoYMD = entity.shiharaiShuryoYMD;
        this.heichoNaiyo = entity.heichoNaiyo;
        this.shiharaiKaishiTime = entity.shiharaiKaishiTime;
        this.shiharaiShuryoTime = entity.shiharaiShuryoTime;
        this.biko = entity.biko;
        this.shikyuShinseisho_SofuYM = entity.shikyuShinseisho_SofuYM;
        this.saiSofuFlag = entity.saiSofuFlag;
        this.jikoFutan_KeisanYM = entity.jikoFutan_KeisanYM;
        this.saiKeisanKubun = entity.saiKeisanKubun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, taishoNendo, hokenshaNo, seiriNo, shoriTimestamp, shinseiJokyoKubun, shinseiYMD, shikyuShinseishoSeiriNo, kokuhoShikyuShinseishoSeiriNo, shikyuShinseiKubun, taishoKeisanKaishiYMD, taishoKeisanShuryoYMD, shikyuShinseiKeitai, jikoFutanKofuUmu, shinseiDaihyoshaShimei, shinseiDaihyoshaYubinNo, shinseiDaihyoshaJusho, shinseiDaihyoshaTelNo, shotokuKubun, over70_ShotokuKubun, shikakuSoshitsuYMD, shikakuSoshitsuJiyu, kanyuKaishiYMD, kanyuShuryoYMD, kokuho_HokenshaNo, kokuho_HokenshaMeisho, kokuho_HihokenshaShoKigo, kokuho_HihokenshaShoNo, kokuho_SetaiNo, kokuho_Zokugara, kokuho_KanyuKaishiYMD, kokuho_KanyuShuryoYMD, koki_HokenshaNo, koki_KoikiRengoMeisho, koki_HihokenshaNo, koki_KanyuKaishiYMD, koki_KanyuShuryoYMD, shiharaiHohoKubun, shiharaiBasho, shiharaiKaishiYMD, shiharaiShuryoYMD, heichoNaiyo, shiharaiKaishiTime, shiharaiShuryoTime, biko, shikyuShinseisho_SofuYM, saiSofuFlag, jikoFutan_KeisanYM, saiKeisanKubun);
    }

// </editor-fold>
}
