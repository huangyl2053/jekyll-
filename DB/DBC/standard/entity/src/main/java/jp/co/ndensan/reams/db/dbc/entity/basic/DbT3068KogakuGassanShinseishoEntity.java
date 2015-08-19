package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額合算申請書テーブルのエンティティクラスです。
 */
public class DbT3068KogakuGassanShinseishoEntity extends DbTableEntityBase<DbT3068KogakuGassanShinseishoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
    private Decimal rirekiNo;
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
    private long kozaID;
    private RString biko;
    private FlexibleYearMonth shikyuShinseisho_SofuYM;
    private RString saiSofuFlag;
    private FlexibleYearMonth jikoFutan_KeisanYM;
    private RString saiKeisanKubun;

    /**
     * insertDantaiCdのgetメソッドです。
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * insertDantaiCdのsetメソッドです。
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * isDeletedのgetメソッドです。
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * isDeletedのsetメソッドです。
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * lastUpdateReamsLoginIdのsetメソッドです。
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 対象年度のgetメソッドです。
     *
     * @return 対象年度
     */
    public FlexibleYear getTaishoNendo() {
        return taishoNendo;
    }

    /**
     * 対象年度のsetメソッドです。
     *
     * @param taishoNendo 対象年度
     */
    public void setTaishoNendo(FlexibleYear taishoNendo) {
        this.taishoNendo = taishoNendo;
    }

    /**
     * 保険者番号のgetメソッドです。
     * <br/>
     * <br/>証記載保険者番号では無い
     *
     * @return 保険者番号
     */
    public HokenshaNo getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * 保険者番号のsetメソッドです。
     * <br/>
     * <br/>証記載保険者番号では無い
     *
     * @param hokenshaNo 保険者番号
     */
    public void setHokenshaNo(HokenshaNo hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
    }

    /**
     * 整理番号のgetメソッドです。
     * <br/>
     * <br/>年度単位で”000001”からの連番
     *
     * @return 整理番号
     */
    public RString getSeiriNo() {
        return seiriNo;
    }

    /**
     * 整理番号のsetメソッドです。
     * <br/>
     * <br/>年度単位で”000001”からの連番
     *
     * @param seiriNo 整理番号
     */
    public void setSeiriNo(RString seiriNo) {
        this.seiriNo = seiriNo;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public Decimal getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(Decimal rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 申請状況区分のgetメソッドです。
     *
     * @return 申請状況区分
     */
    public RString getShinseiJokyoKubun() {
        return shinseiJokyoKubun;
    }

    /**
     * 申請状況区分のsetメソッドです。
     *
     * @param shinseiJokyoKubun 申請状況区分
     */
    public void setShinseiJokyoKubun(RString shinseiJokyoKubun) {
        this.shinseiJokyoKubun = shinseiJokyoKubun;
    }

    /**
     * 申請年月日のgetメソッドです。
     *
     * @return 申請年月日
     */
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * 申請年月日のsetメソッドです。
     *
     * @param shinseiYMD 申請年月日
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * 支給申請書整理番号のgetメソッドです。
     *
     * @return 支給申請書整理番号
     */
    public RString getShikyuShinseishoSeiriNo() {
        return shikyuShinseishoSeiriNo;
    }

    /**
     * 支給申請書整理番号のsetメソッドです。
     *
     * @param shikyuShinseishoSeiriNo 支給申請書整理番号
     */
    public void setShikyuShinseishoSeiriNo(RString shikyuShinseishoSeiriNo) {
        this.shikyuShinseishoSeiriNo = shikyuShinseishoSeiriNo;
    }

    /**
     * 国保支給申請書整理番号のgetメソッドです。
     *
     * @return 国保支給申請書整理番号
     */
    public RString getKokuhoShikyuShinseishoSeiriNo() {
        return kokuhoShikyuShinseishoSeiriNo;
    }

    /**
     * 国保支給申請書整理番号のsetメソッドです。
     *
     * @param kokuhoShikyuShinseishoSeiriNo 国保支給申請書整理番号
     */
    public void setKokuhoShikyuShinseishoSeiriNo(RString kokuhoShikyuShinseishoSeiriNo) {
        this.kokuhoShikyuShinseishoSeiriNo = kokuhoShikyuShinseishoSeiriNo;
    }

    /**
     * 支給申請区分のgetメソッドです。
     *
     * @return 支給申請区分
     */
    public RString getShikyuShinseiKubun() {
        return shikyuShinseiKubun;
    }

    /**
     * 支給申請区分のsetメソッドです。
     *
     * @param shikyuShinseiKubun 支給申請区分
     */
    public void setShikyuShinseiKubun(RString shikyuShinseiKubun) {
        this.shikyuShinseiKubun = shikyuShinseiKubun;
    }

    /**
     * 対象計算期間開始年月日のgetメソッドです。
     *
     * @return 対象計算期間開始年月日
     */
    public FlexibleDate getTaishoKeisanKaishiYMD() {
        return taishoKeisanKaishiYMD;
    }

    /**
     * 対象計算期間開始年月日のsetメソッドです。
     *
     * @param taishoKeisanKaishiYMD 対象計算期間開始年月日
     */
    public void setTaishoKeisanKaishiYMD(FlexibleDate taishoKeisanKaishiYMD) {
        this.taishoKeisanKaishiYMD = taishoKeisanKaishiYMD;
    }

    /**
     * 対象計算期間終了年月日のgetメソッドです。
     *
     * @return 対象計算期間終了年月日
     */
    public FlexibleDate getTaishoKeisanShuryoYMD() {
        return taishoKeisanShuryoYMD;
    }

    /**
     * 対象計算期間終了年月日のsetメソッドです。
     *
     * @param taishoKeisanShuryoYMD 対象計算期間終了年月日
     */
    public void setTaishoKeisanShuryoYMD(FlexibleDate taishoKeisanShuryoYMD) {
        this.taishoKeisanShuryoYMD = taishoKeisanShuryoYMD;
    }

    /**
     * 支給申請形態のgetメソッドです。
     *
     * @return 支給申請形態
     */
    public RString getShikyuShinseiKeitai() {
        return shikyuShinseiKeitai;
    }

    /**
     * 支給申請形態のsetメソッドです。
     *
     * @param shikyuShinseiKeitai 支給申請形態
     */
    public void setShikyuShinseiKeitai(RString shikyuShinseiKeitai) {
        this.shikyuShinseiKeitai = shikyuShinseiKeitai;
    }

    /**
     * 自己負担額証明書交付申請の有無のgetメソッドです。
     *
     * @return 自己負担額証明書交付申請の有無
     */
    public RString getJikoFutanKofuUmu() {
        return jikoFutanKofuUmu;
    }

    /**
     * 自己負担額証明書交付申請の有無のsetメソッドです。
     *
     * @param jikoFutanKofuUmu 自己負担額証明書交付申請の有無
     */
    public void setJikoFutanKofuUmu(RString jikoFutanKofuUmu) {
        this.jikoFutanKofuUmu = jikoFutanKofuUmu;
    }

    /**
     * 申請代表者氏名のgetメソッドです。
     *
     * @return 申請代表者氏名
     */
    public AtenaMeisho getShinseiDaihyoshaShimei() {
        return shinseiDaihyoshaShimei;
    }

    /**
     * 申請代表者氏名のsetメソッドです。
     *
     * @param shinseiDaihyoshaShimei 申請代表者氏名
     */
    public void setShinseiDaihyoshaShimei(AtenaMeisho shinseiDaihyoshaShimei) {
        this.shinseiDaihyoshaShimei = shinseiDaihyoshaShimei;
    }

    /**
     * 申請代表者郵便番号のgetメソッドです。
     *
     * @return 申請代表者郵便番号
     */
    public YubinNo getShinseiDaihyoshaYubinNo() {
        return shinseiDaihyoshaYubinNo;
    }

    /**
     * 申請代表者郵便番号のsetメソッドです。
     *
     * @param shinseiDaihyoshaYubinNo 申請代表者郵便番号
     */
    public void setShinseiDaihyoshaYubinNo(YubinNo shinseiDaihyoshaYubinNo) {
        this.shinseiDaihyoshaYubinNo = shinseiDaihyoshaYubinNo;
    }

    /**
     * 申請代表者住所のgetメソッドです。
     *
     * @return 申請代表者住所
     */
    public RString getShinseiDaihyoshaJusho() {
        return shinseiDaihyoshaJusho;
    }

    /**
     * 申請代表者住所のsetメソッドです。
     *
     * @param shinseiDaihyoshaJusho 申請代表者住所
     */
    public void setShinseiDaihyoshaJusho(RString shinseiDaihyoshaJusho) {
        this.shinseiDaihyoshaJusho = shinseiDaihyoshaJusho;
    }

    /**
     * 申請代表者電話番号のgetメソッドです。
     *
     * @return 申請代表者電話番号
     */
    public TelNo getShinseiDaihyoshaTelNo() {
        return shinseiDaihyoshaTelNo;
    }

    /**
     * 申請代表者電話番号のsetメソッドです。
     *
     * @param shinseiDaihyoshaTelNo 申請代表者電話番号
     */
    public void setShinseiDaihyoshaTelNo(TelNo shinseiDaihyoshaTelNo) {
        this.shinseiDaihyoshaTelNo = shinseiDaihyoshaTelNo;
    }

    /**
     * 所得区分のgetメソッドです。
     *
     * @return 所得区分
     */
    public RString getShotokuKubun() {
        return shotokuKubun;
    }

    /**
     * 所得区分のsetメソッドです。
     *
     * @param shotokuKubun 所得区分
     */
    public void setShotokuKubun(RString shotokuKubun) {
        this.shotokuKubun = shotokuKubun;
    }

    /**
     * 70歳以上の者に係る所得区分のgetメソッドです。
     *
     * @return 70歳以上の者に係る所得区分
     */
    public RString getOver70_ShotokuKubun() {
        return over70_ShotokuKubun;
    }

    /**
     * 70歳以上の者に係る所得区分のsetメソッドです。
     *
     * @param over70_ShotokuKubun 70歳以上の者に係る所得区分
     */
    public void setOver70_ShotokuKubun(RString over70_ShotokuKubun) {
        this.over70_ShotokuKubun = over70_ShotokuKubun;
    }

    /**
     * 資格喪失年月日のgetメソッドです。
     *
     * @return 資格喪失年月日
     */
    public FlexibleDate getShikakuSoshitsuYMD() {
        return shikakuSoshitsuYMD;
    }

    /**
     * 資格喪失年月日のsetメソッドです。
     *
     * @param shikakuSoshitsuYMD 資格喪失年月日
     */
    public void setShikakuSoshitsuYMD(FlexibleDate shikakuSoshitsuYMD) {
        this.shikakuSoshitsuYMD = shikakuSoshitsuYMD;
    }

    /**
     * 資格喪失事由のgetメソッドです。
     *
     * @return 資格喪失事由
     */
    public RString getShikakuSoshitsuJiyu() {
        return shikakuSoshitsuJiyu;
    }

    /**
     * 資格喪失事由のsetメソッドです。
     *
     * @param shikakuSoshitsuJiyu 資格喪失事由
     */
    public void setShikakuSoshitsuJiyu(RString shikakuSoshitsuJiyu) {
        this.shikakuSoshitsuJiyu = shikakuSoshitsuJiyu;
    }

    /**
     * 加入期間開始年月日のgetメソッドです。
     *
     * @return 加入期間開始年月日
     */
    public FlexibleDate getKanyuKaishiYMD() {
        return kanyuKaishiYMD;
    }

    /**
     * 加入期間開始年月日のsetメソッドです。
     *
     * @param kanyuKaishiYMD 加入期間開始年月日
     */
    public void setKanyuKaishiYMD(FlexibleDate kanyuKaishiYMD) {
        this.kanyuKaishiYMD = kanyuKaishiYMD;
    }

    /**
     * 加入期間終了年月日のgetメソッドです。
     *
     * @return 加入期間終了年月日
     */
    public FlexibleDate getKanyuShuryoYMD() {
        return kanyuShuryoYMD;
    }

    /**
     * 加入期間終了年月日のsetメソッドです。
     *
     * @param kanyuShuryoYMD 加入期間終了年月日
     */
    public void setKanyuShuryoYMD(FlexibleDate kanyuShuryoYMD) {
        this.kanyuShuryoYMD = kanyuShuryoYMD;
    }

    /**
     * 国保保険者番号のgetメソッドです。
     *
     * @return 国保保険者番号
     */
    public RString getKokuho_HokenshaNo() {
        return kokuho_HokenshaNo;
    }

    /**
     * 国保保険者番号のsetメソッドです。
     *
     * @param kokuho_HokenshaNo 国保保険者番号
     */
    public void setKokuho_HokenshaNo(RString kokuho_HokenshaNo) {
        this.kokuho_HokenshaNo = kokuho_HokenshaNo;
    }

    /**
     * 国保保険者名称のgetメソッドです。
     *
     * @return 国保保険者名称
     */
    public RString getKokuho_HokenshaMeisho() {
        return kokuho_HokenshaMeisho;
    }

    /**
     * 国保保険者名称のsetメソッドです。
     *
     * @param kokuho_HokenshaMeisho 国保保険者名称
     */
    public void setKokuho_HokenshaMeisho(RString kokuho_HokenshaMeisho) {
        this.kokuho_HokenshaMeisho = kokuho_HokenshaMeisho;
    }

    /**
     * 国保被保険者証記号のgetメソッドです。
     *
     * @return 国保被保険者証記号
     */
    public RString getKokuho_HihokenshaShoKigo() {
        return kokuho_HihokenshaShoKigo;
    }

    /**
     * 国保被保険者証記号のsetメソッドです。
     *
     * @param kokuho_HihokenshaShoKigo 国保被保険者証記号
     */
    public void setKokuho_HihokenshaShoKigo(RString kokuho_HihokenshaShoKigo) {
        this.kokuho_HihokenshaShoKigo = kokuho_HihokenshaShoKigo;
    }

    /**
     * 国保被保険者証番号のgetメソッドです。
     *
     * @return 国保被保険者証番号
     */
    public RString getKokuho_HihokenshaShoNo() {
        return kokuho_HihokenshaShoNo;
    }

    /**
     * 国保被保険者証番号のsetメソッドです。
     *
     * @param kokuho_HihokenshaShoNo 国保被保険者証番号
     */
    public void setKokuho_HihokenshaShoNo(RString kokuho_HihokenshaShoNo) {
        this.kokuho_HihokenshaShoNo = kokuho_HihokenshaShoNo;
    }

    /**
     * 国保世帯番号のgetメソッドです。
     *
     * @return 国保世帯番号
     */
    public RString getKokuho_SetaiNo() {
        return kokuho_SetaiNo;
    }

    /**
     * 国保世帯番号のsetメソッドです。
     *
     * @param kokuho_SetaiNo 国保世帯番号
     */
    public void setKokuho_SetaiNo(RString kokuho_SetaiNo) {
        this.kokuho_SetaiNo = kokuho_SetaiNo;
    }

    /**
     * 国保続柄のgetメソッドです。
     *
     * @return 国保続柄
     */
    public RString getKokuho_Zokugara() {
        return kokuho_Zokugara;
    }

    /**
     * 国保続柄のsetメソッドです。
     *
     * @param kokuho_Zokugara 国保続柄
     */
    public void setKokuho_Zokugara(RString kokuho_Zokugara) {
        this.kokuho_Zokugara = kokuho_Zokugara;
    }

    /**
     * 国保加入期間開始年月日のgetメソッドです。
     *
     * @return 国保加入期間開始年月日
     */
    public FlexibleDate getKokuho_KanyuKaishiYMD() {
        return kokuho_KanyuKaishiYMD;
    }

    /**
     * 国保加入期間開始年月日のsetメソッドです。
     *
     * @param kokuho_KanyuKaishiYMD 国保加入期間開始年月日
     */
    public void setKokuho_KanyuKaishiYMD(FlexibleDate kokuho_KanyuKaishiYMD) {
        this.kokuho_KanyuKaishiYMD = kokuho_KanyuKaishiYMD;
    }

    /**
     * 国保加入期間終了年月日のgetメソッドです。
     *
     * @return 国保加入期間終了年月日
     */
    public FlexibleDate getKokuho_KanyuShuryoYMD() {
        return kokuho_KanyuShuryoYMD;
    }

    /**
     * 国保加入期間終了年月日のsetメソッドです。
     *
     * @param kokuho_KanyuShuryoYMD 国保加入期間終了年月日
     */
    public void setKokuho_KanyuShuryoYMD(FlexibleDate kokuho_KanyuShuryoYMD) {
        this.kokuho_KanyuShuryoYMD = kokuho_KanyuShuryoYMD;
    }

    /**
     * 後期保険者番号のgetメソッドです。
     *
     * @return 後期保険者番号
     */
    public RString getKoki_HokenshaNo() {
        return koki_HokenshaNo;
    }

    /**
     * 後期保険者番号のsetメソッドです。
     *
     * @param koki_HokenshaNo 後期保険者番号
     */
    public void setKoki_HokenshaNo(RString koki_HokenshaNo) {
        this.koki_HokenshaNo = koki_HokenshaNo;
    }

    /**
     * 後期広域連合名称のgetメソッドです。
     *
     * @return 後期広域連合名称
     */
    public RString getKoki_KoikiRengoMeisho() {
        return koki_KoikiRengoMeisho;
    }

    /**
     * 後期広域連合名称のsetメソッドです。
     *
     * @param koki_KoikiRengoMeisho 後期広域連合名称
     */
    public void setKoki_KoikiRengoMeisho(RString koki_KoikiRengoMeisho) {
        this.koki_KoikiRengoMeisho = koki_KoikiRengoMeisho;
    }

    /**
     * 後期被保険者番号のgetメソッドです。
     *
     * @return 後期被保険者番号
     */
    public RString getKoki_HihokenshaNo() {
        return koki_HihokenshaNo;
    }

    /**
     * 後期被保険者番号のsetメソッドです。
     *
     * @param koki_HihokenshaNo 後期被保険者番号
     */
    public void setKoki_HihokenshaNo(RString koki_HihokenshaNo) {
        this.koki_HihokenshaNo = koki_HihokenshaNo;
    }

    /**
     * 後期加入期間開始年月日のgetメソッドです。
     *
     * @return 後期加入期間開始年月日
     */
    public FlexibleDate getKoki_KanyuKaishiYMD() {
        return koki_KanyuKaishiYMD;
    }

    /**
     * 後期加入期間開始年月日のsetメソッドです。
     *
     * @param koki_KanyuKaishiYMD 後期加入期間開始年月日
     */
    public void setKoki_KanyuKaishiYMD(FlexibleDate koki_KanyuKaishiYMD) {
        this.koki_KanyuKaishiYMD = koki_KanyuKaishiYMD;
    }

    /**
     * 後期加入期間終了年月日のgetメソッドです。
     *
     * @return 後期加入期間終了年月日
     */
    public FlexibleDate getKoki_KanyuShuryoYMD() {
        return koki_KanyuShuryoYMD;
    }

    /**
     * 後期加入期間終了年月日のsetメソッドです。
     *
     * @param koki_KanyuShuryoYMD 後期加入期間終了年月日
     */
    public void setKoki_KanyuShuryoYMD(FlexibleDate koki_KanyuShuryoYMD) {
        this.koki_KanyuShuryoYMD = koki_KanyuShuryoYMD;
    }

    /**
     * 支払方法区分のgetメソッドです。
     *
     * @return 支払方法区分
     */
    public RString getShiharaiHohoKubun() {
        return shiharaiHohoKubun;
    }

    /**
     * 支払方法区分のsetメソッドです。
     *
     * @param shiharaiHohoKubun 支払方法区分
     */
    public void setShiharaiHohoKubun(RString shiharaiHohoKubun) {
        this.shiharaiHohoKubun = shiharaiHohoKubun;
    }

    /**
     * 支払場所のgetメソッドです。
     *
     * @return 支払場所
     */
    public RString getShiharaiBasho() {
        return shiharaiBasho;
    }

    /**
     * 支払場所のsetメソッドです。
     *
     * @param shiharaiBasho 支払場所
     */
    public void setShiharaiBasho(RString shiharaiBasho) {
        this.shiharaiBasho = shiharaiBasho;
    }

    /**
     * 支払期間開始年月日のgetメソッドです。
     *
     * @return 支払期間開始年月日
     */
    public FlexibleDate getShiharaiKaishiYMD() {
        return shiharaiKaishiYMD;
    }

    /**
     * 支払期間開始年月日のsetメソッドです。
     *
     * @param shiharaiKaishiYMD 支払期間開始年月日
     */
    public void setShiharaiKaishiYMD(FlexibleDate shiharaiKaishiYMD) {
        this.shiharaiKaishiYMD = shiharaiKaishiYMD;
    }

    /**
     * 支払期間終了年月日のgetメソッドです。
     *
     * @return 支払期間終了年月日
     */
    public FlexibleDate getShiharaiShuryoYMD() {
        return shiharaiShuryoYMD;
    }

    /**
     * 支払期間終了年月日のsetメソッドです。
     *
     * @param shiharaiShuryoYMD 支払期間終了年月日
     */
    public void setShiharaiShuryoYMD(FlexibleDate shiharaiShuryoYMD) {
        this.shiharaiShuryoYMD = shiharaiShuryoYMD;
    }

    /**
     * 閉庁内容のgetメソッドです。
     *
     * @return 閉庁内容
     */
    public RString getHeichoNaiyo() {
        return heichoNaiyo;
    }

    /**
     * 閉庁内容のsetメソッドです。
     *
     * @param heichoNaiyo 閉庁内容
     */
    public void setHeichoNaiyo(RString heichoNaiyo) {
        this.heichoNaiyo = heichoNaiyo;
    }

    /**
     * 支払期間開始時間のgetメソッドです。
     *
     * @return 支払期間開始時間
     */
    public RString getShiharaiKaishiTime() {
        return shiharaiKaishiTime;
    }

    /**
     * 支払期間開始時間のsetメソッドです。
     *
     * @param shiharaiKaishiTime 支払期間開始時間
     */
    public void setShiharaiKaishiTime(RString shiharaiKaishiTime) {
        this.shiharaiKaishiTime = shiharaiKaishiTime;
    }

    /**
     * 支払期間終了時間のgetメソッドです。
     *
     * @return 支払期間終了時間
     */
    public RString getShiharaiShuryoTime() {
        return shiharaiShuryoTime;
    }

    /**
     * 支払期間終了時間のsetメソッドです。
     *
     * @param shiharaiShuryoTime 支払期間終了時間
     */
    public void setShiharaiShuryoTime(RString shiharaiShuryoTime) {
        this.shiharaiShuryoTime = shiharaiShuryoTime;
    }

    /**
     * 口座IDのgetメソッドです。
     * <br/>
     * <br/>口座テーブルとのリンクキー
     *
     * @return 口座ID
     */
    public long getKozaID() {
        return kozaID;
    }

    /**
     * 口座IDのsetメソッドです。
     * <br/>
     * <br/>口座テーブルとのリンクキー
     *
     * @param kozaID 口座ID
     */
    public void setKozaID(long kozaID) {
        this.kozaID = kozaID;
    }

    /**
     * 備考のgetメソッドです。
     *
     * @return 備考
     */
    public RString getBiko() {
        return biko;
    }

    /**
     * 備考のsetメソッドです。
     *
     * @param biko 備考
     */
    public void setBiko(RString biko) {
        this.biko = biko;
    }

    /**
     * 支給申請書情報送付年月のgetメソッドです。
     *
     * @return 支給申請書情報送付年月
     */
    public FlexibleYearMonth getShikyuShinseisho_SofuYM() {
        return shikyuShinseisho_SofuYM;
    }

    /**
     * 支給申請書情報送付年月のsetメソッドです。
     *
     * @param shikyuShinseisho_SofuYM 支給申請書情報送付年月
     */
    public void setShikyuShinseisho_SofuYM(FlexibleYearMonth shikyuShinseisho_SofuYM) {
        this.shikyuShinseisho_SofuYM = shikyuShinseisho_SofuYM;
    }

    /**
     * 再送フラグのgetメソッドです。
     *
     * @return 再送フラグ
     */
    public RString getSaiSofuFlag() {
        return saiSofuFlag;
    }

    /**
     * 再送フラグのsetメソッドです。
     *
     * @param saiSofuFlag 再送フラグ
     */
    public void setSaiSofuFlag(RString saiSofuFlag) {
        this.saiSofuFlag = saiSofuFlag;
    }

    /**
     * 自己負担額計算年月のgetメソッドです。
     *
     * @return 自己負担額計算年月
     */
    public FlexibleYearMonth getJikoFutan_KeisanYM() {
        return jikoFutan_KeisanYM;
    }

    /**
     * 自己負担額計算年月のsetメソッドです。
     *
     * @param jikoFutan_KeisanYM 自己負担額計算年月
     */
    public void setJikoFutan_KeisanYM(FlexibleYearMonth jikoFutan_KeisanYM) {
        this.jikoFutan_KeisanYM = jikoFutan_KeisanYM;
    }

    /**
     * 再計算区分のgetメソッドです。
     *
     * @return 再計算区分
     */
    public RString getSaiKeisanKubun() {
        return saiKeisanKubun;
    }

    /**
     * 再計算区分のsetメソッドです。
     *
     * @param saiKeisanKubun 再計算区分
     */
    public void setSaiKeisanKubun(RString saiKeisanKubun) {
        this.saiKeisanKubun = saiKeisanKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3068KogakuGassanShinseishoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
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
        if (this.rirekiNo != other.rirekiNo) {
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
        this.rirekiNo = entity.rirekiNo;
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
        this.kozaID = entity.kozaID;
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
        return super.toMd5(hihokenshaNo, taishoNendo, hokenshaNo, seiriNo, rirekiNo, shinseiJokyoKubun, shinseiYMD, shikyuShinseishoSeiriNo, kokuhoShikyuShinseishoSeiriNo, shikyuShinseiKubun, taishoKeisanKaishiYMD, taishoKeisanShuryoYMD, shikyuShinseiKeitai, jikoFutanKofuUmu, shinseiDaihyoshaShimei, shinseiDaihyoshaYubinNo, shinseiDaihyoshaJusho, shinseiDaihyoshaTelNo, shotokuKubun, over70_ShotokuKubun, shikakuSoshitsuYMD, shikakuSoshitsuJiyu, kanyuKaishiYMD, kanyuShuryoYMD, kokuho_HokenshaNo, kokuho_HokenshaMeisho, kokuho_HihokenshaShoKigo, kokuho_HihokenshaShoNo, kokuho_SetaiNo, kokuho_Zokugara, kokuho_KanyuKaishiYMD, kokuho_KanyuShuryoYMD, koki_HokenshaNo, koki_KoikiRengoMeisho, koki_HihokenshaNo, koki_KanyuKaishiYMD, koki_KanyuShuryoYMD, shiharaiHohoKubun, shiharaiBasho, shiharaiKaishiYMD, shiharaiShuryoYMD, heichoNaiyo, shiharaiKaishiTime, shiharaiShuryoTime, kozaID, biko, shikyuShinseisho_SofuYM, saiSofuFlag, jikoFutan_KeisanYM, saiKeisanKubun);
    }

// </editor-fold>
}
