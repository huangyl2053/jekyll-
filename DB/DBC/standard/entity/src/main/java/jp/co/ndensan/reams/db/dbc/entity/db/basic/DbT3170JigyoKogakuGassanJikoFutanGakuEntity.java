package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;

/**
 * 事業高額合算自己負担額テーブルのエンティティクラスです。
 */
public class DbT3170JigyoKogakuGassanJikoFutanGakuEntity extends DbTableEntityBase<DbT3170JigyoKogakuGassanJikoFutanGakuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3170JigyoKogakuGassanJikoFutanGaku");

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
    private int rirekiNo;
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
    private RString jikoFutangakuShomeishoRealHakkoFlag;
    private FlexibleDate batchHoseiJissiYMD;
    private FlexibleDate realHoseiJissiYMD;
    private RString shoumeishoyouDataKubun;

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
    public void setHihokenshaNo(@Nonnull HihokenshaNo hihokenshaNo) {
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
    public void setTaishoNendo(@Nonnull FlexibleYear taishoNendo) {
        this.taishoNendo = taishoNendo;
    }

    /**
     * 保険者番号のgetメソッドです。
     * <br/>
     * <br/>証記載保険者番号
     * 
     * @return 保険者番号
     */
    public HokenshaNo getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * 保険者番号のsetメソッドです。
     * <br/>
     * <br/>証記載保険者番号
     * 
     * @param hokenshaNo 保険者番号
     */
    public void setHokenshaNo(@Nonnull HokenshaNo hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
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
    public void setShikyuShinseishoSeiriNo(@Nonnull RString shikyuShinseishoSeiriNo) {
        this.shikyuShinseishoSeiriNo = shikyuShinseishoSeiriNo;
    }

    /**
     * 履歴番号のgetメソッドです。
     * 
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     * 
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 保険制度コードのgetメソッドです。
     * 
     * @return 保険制度コード
     */
    @CheckForNull
    public RString getHokenSeidoCode() {
        return hokenSeidoCode;
    }

    /**
     * 保険制度コードのsetメソッドです。
     * 
     * @param hokenSeidoCode 保険制度コード
     */
    public void setHokenSeidoCode(RString hokenSeidoCode) {
        this.hokenSeidoCode = hokenSeidoCode;
    }

    /**
     * 保険者名のgetメソッドです。
     * 
     * @return 保険者名
     */
    @CheckForNull
    public RString getHokenshaMei() {
        return hokenshaMei;
    }

    /**
     * 保険者名のsetメソッドです。
     * 
     * @param hokenshaMei 保険者名
     */
    public void setHokenshaMei(RString hokenshaMei) {
        this.hokenshaMei = hokenshaMei;
    }

    /**
     * 国保被保険者証記号のgetメソッドです。
     * 
     * @return 国保被保険者証記号
     */
    @CheckForNull
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
     * 被保険者氏名カナのgetメソッドです。
     * 
     * @return 被保険者氏名カナ
     */
    @CheckForNull
    public AtenaKanaMeisho getHihokenshaShimeiKana() {
        return hihokenshaShimeiKana;
    }

    /**
     * 被保険者氏名カナのsetメソッドです。
     * 
     * @param hihokenshaShimeiKana 被保険者氏名カナ
     */
    public void setHihokenshaShimeiKana(AtenaKanaMeisho hihokenshaShimeiKana) {
        this.hihokenshaShimeiKana = hihokenshaShimeiKana;
    }

    /**
     * 被保険者氏名のgetメソッドです。
     * 
     * @return 被保険者氏名
     */
    @CheckForNull
    public AtenaMeisho getHihokenshaShimei() {
        return hihokenshaShimei;
    }

    /**
     * 被保険者氏名のsetメソッドです。
     * 
     * @param hihokenshaShimei 被保険者氏名
     */
    public void setHihokenshaShimei(AtenaMeisho hihokenshaShimei) {
        this.hihokenshaShimei = hihokenshaShimei;
    }

    /**
     * 生年月日のgetメソッドです。
     * 
     * @return 生年月日
     */
    @CheckForNull
    public FlexibleDate getUmareYMD() {
        return umareYMD;
    }

    /**
     * 生年月日のsetメソッドです。
     * 
     * @param umareYMD 生年月日
     */
    public void setUmareYMD(FlexibleDate umareYMD) {
        this.umareYMD = umareYMD;
    }

    /**
     * 性別のgetメソッドです。
     * 
     * @return 性別
     */
    @CheckForNull
    public Code getSeibetsuCode() {
        return seibetsuCode;
    }

    /**
     * 性別のsetメソッドです。
     * 
     * @param seibetsuCode 性別
     */
    public void setSeibetsuCode(Code seibetsuCode) {
        this.seibetsuCode = seibetsuCode;
    }

    /**
     * 所得区分のgetメソッドです。
     * 
     * @return 所得区分
     */
    @CheckForNull
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
    @CheckForNull
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
     * 自己負担額証明書整理番号のgetメソッドです。
     * 
     * @return 自己負担額証明書整理番号
     */
    @CheckForNull
    public RString getJikoFutanSeiriNo() {
        return jikoFutanSeiriNo;
    }

    /**
     * 自己負担額証明書整理番号のsetメソッドです。
     * 
     * @param jikoFutanSeiriNo 自己負担額証明書整理番号
     */
    public void setJikoFutanSeiriNo(RString jikoFutanSeiriNo) {
        this.jikoFutanSeiriNo = jikoFutanSeiriNo;
    }

    /**
     * 後期保険者番号のgetメソッドです。
     * 
     * @return 後期保険者番号
     */
    @CheckForNull
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
     * 後期被保険者番号のgetメソッドです。
     * 
     * @return 後期被保険者番号
     */
    @CheckForNull
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
     * 国保保険者番号のgetメソッドです。
     * 
     * @return 国保保険者番号
     */
    @CheckForNull
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
     * 国保被保険者証番号のgetメソッドです。
     * 
     * @return 国保被保険者証番号
     */
    @CheckForNull
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
     * 国保個人番号のgetメソッドです。
     * 
     * @return 国保個人番号
     */
    @CheckForNull
    public RString getKokuho_KojinNo() {
        return kokuho_KojinNo;
    }

    /**
     * 国保個人番号のsetメソッドです。
     * 
     * @param kokuho_KojinNo 国保個人番号
     */
    public void setKokuho_KojinNo(RString kokuho_KojinNo) {
        this.kokuho_KojinNo = kokuho_KojinNo;
    }

    /**
     * 異動区分のgetメソッドです。
     * 
     * @return 異動区分
     */
    @CheckForNull
    public RString getIdoKubun() {
        return idoKubun;
    }

    /**
     * 異動区分のsetメソッドです。
     * 
     * @param idoKubun 異動区分
     */
    public void setIdoKubun(RString idoKubun) {
        this.idoKubun = idoKubun;
    }

    /**
     * 補正済自己負担額送付区分のgetメソッドです。
     * 
     * @return 補正済自己負担額送付区分
     */
    @CheckForNull
    public RString getHoseiZumiSofuKubun() {
        return hoseiZumiSofuKubun;
    }

    /**
     * 補正済自己負担額送付区分のsetメソッドです。
     * 
     * @param hoseiZumiSofuKubun 補正済自己負担額送付区分
     */
    public void setHoseiZumiSofuKubun(RString hoseiZumiSofuKubun) {
        this.hoseiZumiSofuKubun = hoseiZumiSofuKubun;
    }

    /**
     * 対象計算期間開始年月日のgetメソッドです。
     * 
     * @return 対象計算期間開始年月日
     */
    @CheckForNull
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
    @CheckForNull
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
     * 被保険者期間開始年月日のgetメソッドです。
     * 
     * @return 被保険者期間開始年月日
     */
    @CheckForNull
    public FlexibleDate getHihokenshaKaishiYMD() {
        return hihokenshaKaishiYMD;
    }

    /**
     * 被保険者期間開始年月日のsetメソッドです。
     * 
     * @param hihokenshaKaishiYMD 被保険者期間開始年月日
     */
    public void setHihokenshaKaishiYMD(FlexibleDate hihokenshaKaishiYMD) {
        this.hihokenshaKaishiYMD = hihokenshaKaishiYMD;
    }

    /**
     * 被保険者期間終了年月日のgetメソッドです。
     * 
     * @return 被保険者期間終了年月日
     */
    @CheckForNull
    public FlexibleDate getHihokenshaShuryoYMD() {
        return hihokenshaShuryoYMD;
    }

    /**
     * 被保険者期間終了年月日のsetメソッドです。
     * 
     * @param hihokenshaShuryoYMD 被保険者期間終了年月日
     */
    public void setHihokenshaShuryoYMD(FlexibleDate hihokenshaShuryoYMD) {
        this.hihokenshaShuryoYMD = hihokenshaShuryoYMD;
    }

    /**
     * 申請年月日のgetメソッドです。
     * 
     * @return 申請年月日
     */
    @CheckForNull
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
     * 合計・自己負担額のgetメソッドです。
     * 
     * @return 合計・自己負担額
     */
    @CheckForNull
    public Decimal getGokei_JikoFutanGaku() {
        return gokei_JikoFutanGaku;
    }

    /**
     * 合計・自己負担額のsetメソッドです。
     * 
     * @param gokei_JikoFutanGaku 合計・自己負担額
     */
    public void setGokei_JikoFutanGaku(Decimal gokei_JikoFutanGaku) {
        this.gokei_JikoFutanGaku = gokei_JikoFutanGaku;
    }

    /**
     * 合計・70-74自己負担額（内訳）のgetメソッドです。
     * 
     * @return 合計・70-74自己負担額（内訳）
     */
    @CheckForNull
    public Decimal getGokei_70_74JikoFutanGaku() {
        return gokei_70_74JikoFutanGaku;
    }

    /**
     * 合計・70-74自己負担額（内訳）のsetメソッドです。
     * 
     * @param gokei_70_74JikoFutanGaku 合計・70-74自己負担額（内訳）
     */
    public void setGokei_70_74JikoFutanGaku(Decimal gokei_70_74JikoFutanGaku) {
        this.gokei_70_74JikoFutanGaku = gokei_70_74JikoFutanGaku;
    }

    /**
     * 合計・70未満高額支給額のgetメソッドです。
     * 
     * @return 合計・70未満高額支給額
     */
    @CheckForNull
    public Decimal getGokei_Under70KogakuShikyuGaku() {
        return gokei_Under70KogakuShikyuGaku;
    }

    /**
     * 合計・70未満高額支給額のsetメソッドです。
     * 
     * @param gokei_Under70KogakuShikyuGaku 合計・70未満高額支給額
     */
    public void setGokei_Under70KogakuShikyuGaku(Decimal gokei_Under70KogakuShikyuGaku) {
        this.gokei_Under70KogakuShikyuGaku = gokei_Under70KogakuShikyuGaku;
    }

    /**
     * 合計・70-74高額支給額のgetメソッドです。
     * 
     * @return 合計・70-74高額支給額
     */
    @CheckForNull
    public Decimal getGokei_70_74KogakuShikyuGaku() {
        return gokei_70_74KogakuShikyuGaku;
    }

    /**
     * 合計・70-74高額支給額のsetメソッドです。
     * 
     * @param gokei_70_74KogakuShikyuGaku 合計・70-74高額支給額
     */
    public void setGokei_70_74KogakuShikyuGaku(Decimal gokei_70_74KogakuShikyuGaku) {
        this.gokei_70_74KogakuShikyuGaku = gokei_70_74KogakuShikyuGaku;
    }

    /**
     * 補正済・合計・自己負担額のgetメソッドです。
     * 
     * @return 補正済・合計・自己負担額
     */
    @CheckForNull
    public Decimal getSumi_Gokei_JikoFutanGaku() {
        return sumi_Gokei_JikoFutanGaku;
    }

    /**
     * 補正済・合計・自己負担額のsetメソッドです。
     * 
     * @param sumi_Gokei_JikoFutanGaku 補正済・合計・自己負担額
     */
    public void setSumi_Gokei_JikoFutanGaku(Decimal sumi_Gokei_JikoFutanGaku) {
        this.sumi_Gokei_JikoFutanGaku = sumi_Gokei_JikoFutanGaku;
    }

    /**
     * 補正済・合計・70-74自己負担額（内訳）のgetメソッドです。
     * 
     * @return 補正済・合計・70-74自己負担額（内訳）
     */
    @CheckForNull
    public Decimal getSumi_Gokei_70_74JikoFutanGaku() {
        return sumi_Gokei_70_74JikoFutanGaku;
    }

    /**
     * 補正済・合計・70-74自己負担額（内訳）のsetメソッドです。
     * 
     * @param sumi_Gokei_70_74JikoFutanGaku 補正済・合計・70-74自己負担額（内訳）
     */
    public void setSumi_Gokei_70_74JikoFutanGaku(Decimal sumi_Gokei_70_74JikoFutanGaku) {
        this.sumi_Gokei_70_74JikoFutanGaku = sumi_Gokei_70_74JikoFutanGaku;
    }

    /**
     * 補正済・合計・70未満高額支給額のgetメソッドです。
     * 
     * @return 補正済・合計・70未満高額支給額
     */
    @CheckForNull
    public Decimal getSumi_Gokei_Under70KogakuShikyuGaku() {
        return sumi_Gokei_Under70KogakuShikyuGaku;
    }

    /**
     * 補正済・合計・70未満高額支給額のsetメソッドです。
     * 
     * @param sumi_Gokei_Under70KogakuShikyuGaku 補正済・合計・70未満高額支給額
     */
    public void setSumi_Gokei_Under70KogakuShikyuGaku(Decimal sumi_Gokei_Under70KogakuShikyuGaku) {
        this.sumi_Gokei_Under70KogakuShikyuGaku = sumi_Gokei_Under70KogakuShikyuGaku;
    }

    /**
     * 補正済・合計・70-74高額支給額のgetメソッドです。
     * 
     * @return 補正済・合計・70-74高額支給額
     */
    @CheckForNull
    public Decimal getSumi_Gokei_70_74KogakuShikyuGaku() {
        return sumi_Gokei_70_74KogakuShikyuGaku;
    }

    /**
     * 補正済・合計・70-74高額支給額のsetメソッドです。
     * 
     * @param sumi_Gokei_70_74KogakuShikyuGaku 補正済・合計・70-74高額支給額
     */
    public void setSumi_Gokei_70_74KogakuShikyuGaku(Decimal sumi_Gokei_70_74KogakuShikyuGaku) {
        this.sumi_Gokei_70_74KogakuShikyuGaku = sumi_Gokei_70_74KogakuShikyuGaku;
    }

    /**
     * 宛先氏名のgetメソッドです。
     * 
     * @return 宛先氏名
     */
    @CheckForNull
    public AtenaMeisho getAtesakiShimei() {
        return atesakiShimei;
    }

    /**
     * 宛先氏名のsetメソッドです。
     * 
     * @param atesakiShimei 宛先氏名
     */
    public void setAtesakiShimei(AtenaMeisho atesakiShimei) {
        this.atesakiShimei = atesakiShimei;
    }

    /**
     * 宛先郵便番号のgetメソッドです。
     * 
     * @return 宛先郵便番号
     */
    @CheckForNull
    public YubinNo getAtesakiYubinNo() {
        return atesakiYubinNo;
    }

    /**
     * 宛先郵便番号のsetメソッドです。
     * 
     * @param atesakiYubinNo 宛先郵便番号
     */
    public void setAtesakiYubinNo(YubinNo atesakiYubinNo) {
        this.atesakiYubinNo = atesakiYubinNo;
    }

    /**
     * 宛先住所のgetメソッドです。
     * 
     * @return 宛先住所
     */
    @CheckForNull
    public RString getAtesakiJusho() {
        return atesakiJusho;
    }

    /**
     * 宛先住所のsetメソッドです。
     * 
     * @param atesakiJusho 宛先住所
     */
    public void setAtesakiJusho(RString atesakiJusho) {
        this.atesakiJusho = atesakiJusho;
    }

    /**
     * 窓口払対象者判定コードのgetメソッドです。
     * 
     * @return 窓口払対象者判定コード
     */
    @CheckForNull
    public RString getMadoguchi_TaishoshaHanteiCode() {
        return madoguchi_TaishoshaHanteiCode;
    }

    /**
     * 窓口払対象者判定コードのsetメソッドです。
     * 
     * @param madoguchi_TaishoshaHanteiCode 窓口払対象者判定コード
     */
    public void setMadoguchi_TaishoshaHanteiCode(RString madoguchi_TaishoshaHanteiCode) {
        this.madoguchi_TaishoshaHanteiCode = madoguchi_TaishoshaHanteiCode;
    }

    /**
     * 支払場所のgetメソッドです。
     * 
     * @return 支払場所
     */
    @CheckForNull
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
    @CheckForNull
    public FlexibleDate getShikaraiKaishiYMD() {
        return shikaraiKaishiYMD;
    }

    /**
     * 支払期間開始年月日のsetメソッドです。
     * 
     * @param shikaraiKaishiYMD 支払期間開始年月日
     */
    public void setShikaraiKaishiYMD(FlexibleDate shikaraiKaishiYMD) {
        this.shikaraiKaishiYMD = shikaraiKaishiYMD;
    }

    /**
     * 支払期間終了年月日のgetメソッドです。
     * 
     * @return 支払期間終了年月日
     */
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
     * 備考のgetメソッドです。
     * 
     * @return 備考
     */
    @CheckForNull
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
     * データ作成区分のgetメソッドです。
     * 
     * @return データ作成区分
     */
    @CheckForNull
    public RString getDataSakuseiKubun() {
        return dataSakuseiKubun;
    }

    /**
     * データ作成区分のsetメソッドです。
     * 
     * @param dataSakuseiKubun データ作成区分
     */
    public void setDataSakuseiKubun(RString dataSakuseiKubun) {
        this.dataSakuseiKubun = dataSakuseiKubun;
    }

    /**
     * 自己負担額確認情報受取年月のgetメソッドです。
     * 
     * @return 自己負担額確認情報受取年月
     */
    @CheckForNull
    public FlexibleYearMonth getKakunin_UketoriYM() {
        return kakunin_UketoriYM;
    }

    /**
     * 自己負担額確認情報受取年月のsetメソッドです。
     * 
     * @param kakunin_UketoriYM 自己負担額確認情報受取年月
     */
    public void setKakunin_UketoriYM(FlexibleYearMonth kakunin_UketoriYM) {
        this.kakunin_UketoriYM = kakunin_UketoriYM;
    }

    /**
     * 補正済自己負担額情報送付年月のgetメソッドです。
     * 
     * @return 補正済自己負担額情報送付年月
     */
    @CheckForNull
    public FlexibleYearMonth getHoseiZumi_SofuYM() {
        return hoseiZumi_SofuYM;
    }

    /**
     * 補正済自己負担額情報送付年月のsetメソッドです。
     * 
     * @param hoseiZumi_SofuYM 補正済自己負担額情報送付年月
     */
    public void setHoseiZumi_SofuYM(FlexibleYearMonth hoseiZumi_SofuYM) {
        this.hoseiZumi_SofuYM = hoseiZumi_SofuYM;
    }

    /**
     * 自己負担額証明書情報受取年月のgetメソッドです。
     * 
     * @return 自己負担額証明書情報受取年月
     */
    @CheckForNull
    public FlexibleYearMonth getShomeisho_UketoriYM() {
        return shomeisho_UketoriYM;
    }

    /**
     * 自己負担額証明書情報受取年月のsetメソッドです。
     * 
     * @param shomeisho_UketoriYM 自己負担額証明書情報受取年月
     */
    public void setShomeisho_UketoriYM(FlexibleYearMonth shomeisho_UketoriYM) {
        this.shomeisho_UketoriYM = shomeisho_UketoriYM;
    }

    /**
     * 再送フラグのgetメソッドです。
     * 
     * @return 再送フラグ
     */
    @CheckForNull
    public RString getSaisoFlag() {
        return saisoFlag;
    }

    /**
     * 再送フラグのsetメソッドです。
     * 
     * @param saisoFlag 再送フラグ
     */
    public void setSaisoFlag(RString saisoFlag) {
        this.saisoFlag = saisoFlag;
    }

    /**
     * 送付対象外フラグのgetメソッドです。
     * 
     * @return 送付対象外フラグ
     */
    @CheckForNull
    public RString getSofuTaishoGaiFlag() {
        return sofuTaishoGaiFlag;
    }

    /**
     * 送付対象外フラグのsetメソッドです。
     * 
     * @param sofuTaishoGaiFlag 送付対象外フラグ
     */
    public void setSofuTaishoGaiFlag(RString sofuTaishoGaiFlag) {
        this.sofuTaishoGaiFlag = sofuTaishoGaiFlag;
    }

    /**
     * 自己負担額計算年月日のgetメソッドです。
     * 
     * @return 自己負担額計算年月日
     */
    @CheckForNull
    public FlexibleDate getJikoFutanKeisanYMD() {
        return jikoFutanKeisanYMD;
    }

    /**
     * 自己負担額計算年月日のsetメソッドです。
     * 
     * @param jikoFutanKeisanYMD 自己負担額計算年月日
     */
    public void setJikoFutanKeisanYMD(FlexibleDate jikoFutanKeisanYMD) {
        this.jikoFutanKeisanYMD = jikoFutanKeisanYMD;
    }

    /**
     * 自己負担額証明書作成年月日のgetメソッドです。
     * 
     * @return 自己負担額証明書作成年月日
     */
    @CheckForNull
    public FlexibleDate getShomeiShoSakuseiYMD() {
        return shomeiShoSakuseiYMD;
    }

    /**
     * 自己負担額証明書作成年月日のsetメソッドです。
     * 
     * @param shomeiShoSakuseiYMD 自己負担額証明書作成年月日
     */
    public void setShomeiShoSakuseiYMD(FlexibleDate shomeiShoSakuseiYMD) {
        this.shomeiShoSakuseiYMD = shomeiShoSakuseiYMD;
    }

    /**
     * 後期・国保処理区分のgetメソッドです。
     * 
     * @return 後期・国保処理区分
     */
    @CheckForNull
    public RString getKoki_KokuhoShoriKubun() {
        return koki_KokuhoShoriKubun;
    }

    /**
     * 後期・国保処理区分のsetメソッドです。
     * 
     * @param koki_KokuhoShoriKubun 後期・国保処理区分
     */
    public void setKoki_KokuhoShoriKubun(RString koki_KokuhoShoriKubun) {
        this.koki_KokuhoShoriKubun = koki_KokuhoShoriKubun;
    }

    /**
     * 自己負担額証明書リアル発行フラグのgetメソッドです。
     * 
     * @return 自己負担額証明書リアル発行フラグ
     */
    @CheckForNull
    public RString getJikoFutangakuShomeishoRealHakkoFlag() {
        return jikoFutangakuShomeishoRealHakkoFlag;
    }

    /**
     * 自己負担額証明書リアル発行フラグのsetメソッドです。
     * 
     * @param jikoFutangakuShomeishoRealHakkoFlag 自己負担額証明書リアル発行フラグ
     */
    public void setJikoFutangakuShomeishoRealHakkoFlag(RString jikoFutangakuShomeishoRealHakkoFlag) {
        this.jikoFutangakuShomeishoRealHakkoFlag = jikoFutangakuShomeishoRealHakkoFlag;
    }

    /**
     * バッチ補正実施年月日のgetメソッドです。
     * 
     * @return バッチ補正実施年月日
     */
    @CheckForNull
    public FlexibleDate getBatchHoseiJissiYMD() {
        return batchHoseiJissiYMD;
    }

    /**
     * バッチ補正実施年月日のsetメソッドです。
     * 
     * @param batchHoseiJissiYMD バッチ補正実施年月日
     */
    public void setBatchHoseiJissiYMD(FlexibleDate batchHoseiJissiYMD) {
        this.batchHoseiJissiYMD = batchHoseiJissiYMD;
    }

    /**
     * リアル補正実施年月日のgetメソッドです。
     * 
     * @return リアル補正実施年月日
     */
    @CheckForNull
    public FlexibleDate getRealHoseiJissiYMD() {
        return realHoseiJissiYMD;
    }

    /**
     * リアル補正実施年月日のsetメソッドです。
     * 
     * @param realHoseiJissiYMD リアル補正実施年月日
     */
    public void setRealHoseiJissiYMD(FlexibleDate realHoseiJissiYMD) {
        this.realHoseiJissiYMD = realHoseiJissiYMD;
    }

    /**
     * 証明書用データ区分のgetメソッドです。
     * 
     * @return 証明書用データ区分
     */
    @CheckForNull
    public RString getShoumeishoyouDataKubun() {
        return shoumeishoyouDataKubun;
    }

    /**
     * 証明書用データ区分のsetメソッドです。
     * 
     * @param shoumeishoyouDataKubun 証明書用データ区分
     */
    public void setShoumeishoyouDataKubun(RString shoumeishoyouDataKubun) {
        this.shoumeishoyouDataKubun = shoumeishoyouDataKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3170JigyoKogakuGassanJikoFutanGakuEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3170JigyoKogakuGassanJikoFutanGakuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3170JigyoKogakuGassanJikoFutanGakuEntity other) {
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
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3170JigyoKogakuGassanJikoFutanGakuEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.taishoNendo = entity.taishoNendo;
        this.hokenshaNo = entity.hokenshaNo;
        this.shikyuShinseishoSeiriNo = entity.shikyuShinseishoSeiriNo;
        this.rirekiNo = entity.rirekiNo;
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
        this.jikoFutangakuShomeishoRealHakkoFlag = entity.jikoFutangakuShomeishoRealHakkoFlag;
        this.batchHoseiJissiYMD = entity.batchHoseiJissiYMD;
        this.realHoseiJissiYMD = entity.realHoseiJissiYMD;
        this.shoumeishoyouDataKubun = entity.shoumeishoyouDataKubun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, taishoNendo, hokenshaNo, shikyuShinseishoSeiriNo, rirekiNo, hokenSeidoCode, hokenshaMei, kokuho_HihokenshaShoKigo, hihokenshaShimeiKana, hihokenshaShimei, umareYMD, seibetsuCode, shotokuKubun, over70_ShotokuKubun, jikoFutanSeiriNo, koki_HokenshaNo, koki_HihokenshaNo, kokuho_HokenshaNo, kokuho_HihokenshaShoNo, kokuho_KojinNo, idoKubun, hoseiZumiSofuKubun, taishoKeisanKaishiYMD, taishoKeisanShuryoYMD, hihokenshaKaishiYMD, hihokenshaShuryoYMD, shinseiYMD, gokei_JikoFutanGaku, gokei_70_74JikoFutanGaku, gokei_Under70KogakuShikyuGaku, gokei_70_74KogakuShikyuGaku, sumi_Gokei_JikoFutanGaku, sumi_Gokei_70_74JikoFutanGaku, sumi_Gokei_Under70KogakuShikyuGaku, sumi_Gokei_70_74KogakuShikyuGaku, atesakiShimei, atesakiYubinNo, atesakiJusho, madoguchi_TaishoshaHanteiCode, shiharaiBasho, shikaraiKaishiYMD, shiharaiShuryoYMD, heichoNaiyo, shiharaiKaishiTime, shiharaiShuryoTime, biko, dataSakuseiKubun, kakunin_UketoriYM, hoseiZumi_SofuYM, shomeisho_UketoriYM, saisoFlag, sofuTaishoGaiFlag, jikoFutanKeisanYMD, shomeiShoSakuseiYMD, koki_KokuhoShoriKubun, jikoFutangakuShomeishoRealHakkoFlag, batchHoseiJissiYMD, realHoseiJissiYMD, shoumeishoyouDataKubun);
    }

// </editor-fold>
}
