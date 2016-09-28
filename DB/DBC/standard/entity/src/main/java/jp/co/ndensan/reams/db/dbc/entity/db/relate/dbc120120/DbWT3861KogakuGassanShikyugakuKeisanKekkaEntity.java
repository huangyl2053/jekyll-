/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 高額合算支給額計算結果一時TBL項目定義クラスです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
 */
public class DbWT3861KogakuGassanShikyugakuKeisanKekkaEntity extends DbTableEntityBase<DbWT3861KogakuGassanShikyugakuKeisanKekkaEntity>
        implements IDbAccessable {

    @PrimaryKey
    private int renban;
    @PrimaryKey
    private HihokenshaNo hihokenshaNoIn;
    @PrimaryKey
    private FlexibleYear taishoNendo;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private RString shikyuShinseishoSeiriNo;
    @PrimaryKey
    private int rirekiNo;
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
    private RString saisoFG;
    private FlexibleDate sikyugakuKeisanKekkaRenrakuhyoSakuseiYMD;
    private boolean kakuninListFlag;

    /**
     * 連番のgetメソッドです。
     *
     * @return 連番
     */
    public int getRenban() {
        return renban;
    }

    /**
     * 連番のsetメソッドです。
     *
     * @param renban 連番
     */
    public void setRenban(@Nonnull int renban) {
        this.renban = renban;
    }

    /**
     * 確認リスト出力フラグのgetメソッドです。
     *
     * @return 確認リスト出力フラグ
     */
    public boolean getKakuninListFlag() {
        return kakuninListFlag;
    }

    /**
     * 確認リスト出力フラグのsetメソッドです。
     *
     * @param kakuninListFlag 確認リスト出力フラグ
     */
    public void setKakuninListFlag(boolean kakuninListFlag) {
        this.kakuninListFlag = kakuninListFlag;
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNoIn() {
        return hihokenshaNoIn;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNoIn 被保険者番号
     */
    public void setHihokenshaNoIn(@Nonnull HihokenshaNo hihokenshaNoIn) {
        this.hihokenshaNoIn = hihokenshaNoIn;
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
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(@Nonnull HokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * 支給申請書整理番号のgetメソッドです。
     * <br/>
     * <br/>IF上は「連絡票整理番号」
     *
     * @return 支給申請書整理番号
     */
    public RString getShikyuShinseishoSeiriNo() {
        return shikyuShinseishoSeiriNo;
    }

    /**
     * 支給申請書整理番号のsetメソッドです。
     * <br/>
     * <br/>IF上は「連絡票整理番号」
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
     * <br/>
     * <br/>1:国保,2:後期,3:介護
     *
     * @return 保険制度コード
     */
    @CheckForNull
    public RString getHokenSeidoCode() {
        return hokenSeidoCode;
    }

    /**
     * 保険制度コードのsetメソッドです。
     * <br/>
     * <br/>1:国保,2:後期,3:介護
     *
     * @param hokenSeidoCode 保険制度コード
     */
    public void setHokenSeidoCode(RString hokenSeidoCode) {
        this.hokenSeidoCode = hokenSeidoCode;
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
     * 世帯負担総額のgetメソッドです。
     *
     * @return 世帯負担総額
     */
    @CheckForNull
    public Decimal getSetaiFutanSogaku() {
        return setaiFutanSogaku;
    }

    /**
     * 世帯負担総額のsetメソッドです。
     *
     * @param setaiFutanSogaku 世帯負担総額
     */
    public void setSetaiFutanSogaku(Decimal setaiFutanSogaku) {
        this.setaiFutanSogaku = setaiFutanSogaku;
    }

    /**
     * 介護等合算一部負担金等世帯合算額のgetメソッドです。
     *
     * @return 介護等合算一部負担金等世帯合算額
     */
    @CheckForNull
    public Decimal getSetaiGassanGaku() {
        return setaiGassanGaku;
    }

    /**
     * 介護等合算一部負担金等世帯合算額のsetメソッドです。
     *
     * @param setaiGassanGaku 介護等合算一部負担金等世帯合算額
     */
    public void setSetaiGassanGaku(Decimal setaiGassanGaku) {
        this.setaiGassanGaku = setaiGassanGaku;
    }

    /**
     * 70歳以上介護等合算一部負担金等世帯合算額のgetメソッドです。
     *
     * @return 70歳以上介護等合算一部負担金等世帯合算額
     */
    @CheckForNull
    public Decimal getOver70_SetaiGassanGaku() {
        return over70_SetaiGassanGaku;
    }

    /**
     * 70歳以上介護等合算一部負担金等世帯合算額のsetメソッドです。
     *
     * @param over70_SetaiGassanGaku 70歳以上介護等合算一部負担金等世帯合算額
     */
    public void setOver70_SetaiGassanGaku(Decimal over70_SetaiGassanGaku) {
        this.over70_SetaiGassanGaku = over70_SetaiGassanGaku;
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
     * 介護等合算算定基準額のgetメソッドです。
     *
     * @return 介護等合算算定基準額
     */
    @CheckForNull
    public Decimal getSanteiKijunGaku() {
        return santeiKijunGaku;
    }

    /**
     * 介護等合算算定基準額のsetメソッドです。
     *
     * @param santeiKijunGaku 介護等合算算定基準額
     */
    public void setSanteiKijunGaku(Decimal santeiKijunGaku) {
        this.santeiKijunGaku = santeiKijunGaku;
    }

    /**
     * 70歳以上介護等合算算定基準額のgetメソッドです。
     *
     * @return 70歳以上介護等合算算定基準額
     */
    @CheckForNull
    public Decimal getOver70_SanteiKijyunGaku() {
        return over70_SanteiKijyunGaku;
    }

    /**
     * 70歳以上介護等合算算定基準額のsetメソッドです。
     *
     * @param over70_SanteiKijyunGaku 70歳以上介護等合算算定基準額
     */
    public void setOver70_SanteiKijyunGaku(Decimal over70_SanteiKijyunGaku) {
        this.over70_SanteiKijyunGaku = over70_SanteiKijyunGaku;
    }

    /**
     * 世帯支給総額のgetメソッドです。
     *
     * @return 世帯支給総額
     */
    @CheckForNull
    public Decimal getSetaiShikyuSogaku() {
        return setaiShikyuSogaku;
    }

    /**
     * 世帯支給総額のsetメソッドです。
     *
     * @param setaiShikyuSogaku 世帯支給総額
     */
    public void setSetaiShikyuSogaku(Decimal setaiShikyuSogaku) {
        this.setaiShikyuSogaku = setaiShikyuSogaku;
    }

    /**
     * うち70歳以上分世帯支給総額のgetメソッドです。
     *
     * @return うち70歳以上分世帯支給総額
     */
    @CheckForNull
    public Decimal getOver70_SetaiShikyuSogaku() {
        return over70_SetaiShikyuSogaku;
    }

    /**
     * うち70歳以上分世帯支給総額のsetメソッドです。
     *
     * @param over70_SetaiShikyuSogaku うち70歳以上分世帯支給総額
     */
    public void setOver70_SetaiShikyuSogaku(Decimal over70_SetaiShikyuSogaku) {
        this.over70_SetaiShikyuSogaku = over70_SetaiShikyuSogaku;
    }

    /**
     * 按分後支給額のgetメソッドです。
     *
     * @return 按分後支給額
     */
    @CheckForNull
    public Decimal getHonninShikyugaku() {
        return honninShikyugaku;
    }

    /**
     * 按分後支給額のsetメソッドです。
     *
     * @param honninShikyugaku 按分後支給額
     */
    public void setHonninShikyugaku(Decimal honninShikyugaku) {
        this.honninShikyugaku = honninShikyugaku;
    }

    /**
     * うち70歳以上分按分後支給額のgetメソッドです。
     *
     * @return うち70歳以上分按分後支給額
     */
    @CheckForNull
    public Decimal getOver70_honninShikyugaku() {
        return over70_honninShikyugaku;
    }

    /**
     * うち70歳以上分按分後支給額のsetメソッドです。
     *
     * @param over70_honninShikyugaku うち70歳以上分按分後支給額
     */
    public void setOver70_honninShikyugaku(Decimal over70_honninShikyugaku) {
        this.over70_honninShikyugaku = over70_honninShikyugaku;
    }

    /**
     * 介護低所得者Ⅰ再計算実施の有無のgetメソッドです。
     *
     * @return 介護低所得者Ⅰ再計算実施の有無
     */
    @CheckForNull
    public RString getTeiShotoku_1_SaiKeisanUmu() {
        return teiShotoku_1_SaiKeisanUmu;
    }

    /**
     * 介護低所得者Ⅰ再計算実施の有無のsetメソッドです。
     *
     * @param teiShotoku_1_SaiKeisanUmu 介護低所得者Ⅰ再計算実施の有無
     */
    public void setTeiShotoku_1_SaiKeisanUmu(RString teiShotoku_1_SaiKeisanUmu) {
        this.teiShotoku_1_SaiKeisanUmu = teiShotoku_1_SaiKeisanUmu;
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
     * 支給額計算結果連絡先郵便番号のgetメソッドです。
     *
     * @return 支給額計算結果連絡先郵便番号
     */
    @CheckForNull
    public YubinNo getKekkaRenrakusakiYubinNo() {
        return kekkaRenrakusakiYubinNo;
    }

    /**
     * 支給額計算結果連絡先郵便番号のsetメソッドです。
     *
     * @param kekkaRenrakusakiYubinNo 支給額計算結果連絡先郵便番号
     */
    public void setKekkaRenrakusakiYubinNo(YubinNo kekkaRenrakusakiYubinNo) {
        this.kekkaRenrakusakiYubinNo = kekkaRenrakusakiYubinNo;
    }

    /**
     * 支給額計算結果連絡先住所のgetメソッドです。
     *
     * @return 支給額計算結果連絡先住所
     */
    @CheckForNull
    public RString getKekkaRenrakusakiJusho() {
        return kekkaRenrakusakiJusho;
    }

    /**
     * 支給額計算結果連絡先住所のsetメソッドです。
     *
     * @param kekkaRenrakusakiJusho 支給額計算結果連絡先住所
     */
    public void setKekkaRenrakusakiJusho(RString kekkaRenrakusakiJusho) {
        this.kekkaRenrakusakiJusho = kekkaRenrakusakiJusho;
    }

    /**
     * 支給額計算結果連絡先名称1のgetメソッドです。
     *
     * @return 支給額計算結果連絡先名称1
     */
    @CheckForNull
    public RString getKetteRenrakusakiMeisho1() {
        return ketteRenrakusakiMeisho1;
    }

    /**
     * 支給額計算結果連絡先名称1のsetメソッドです。
     *
     * @param ketteRenrakusakiMeisho1 支給額計算結果連絡先名称1
     */
    public void setKetteRenrakusakiMeisho1(RString ketteRenrakusakiMeisho1) {
        this.ketteRenrakusakiMeisho1 = ketteRenrakusakiMeisho1;
    }

    /**
     * 支給額計算結果連絡先名称2のgetメソッドです。
     *
     * @return 支給額計算結果連絡先名称2
     */
    @CheckForNull
    public RString getKekkaRenrakusakiMeisho2() {
        return kekkaRenrakusakiMeisho2;
    }

    /**
     * 支給額計算結果連絡先名称2のsetメソッドです。
     *
     * @param kekkaRenrakusakiMeisho2 支給額計算結果連絡先名称2
     */
    public void setKekkaRenrakusakiMeisho2(RString kekkaRenrakusakiMeisho2) {
        this.kekkaRenrakusakiMeisho2 = kekkaRenrakusakiMeisho2;
    }

    /**
     * 通知年月日のgetメソッドです。
     *
     * @return 通知年月日
     */
    @CheckForNull
    public FlexibleDate getTsuchiYMD() {
        return tsuchiYMD;
    }

    /**
     * 通知年月日のsetメソッドです。
     *
     * @param tsuchiYMD 通知年月日
     */
    public void setTsuchiYMD(FlexibleDate tsuchiYMD) {
        this.tsuchiYMD = tsuchiYMD;
    }

    /**
     * 連絡票発行者名のgetメソッドです。
     *
     * @return 連絡票発行者名
     */
    @CheckForNull
    public AtenaMeisho getRenrakuhyoHakkoshaMei() {
        return renrakuhyoHakkoshaMei;
    }

    /**
     * 連絡票発行者名のsetメソッドです。
     *
     * @param renrakuhyoHakkoshaMei 連絡票発行者名
     */
    public void setRenrakuhyoHakkoshaMei(AtenaMeisho renrakuhyoHakkoshaMei) {
        this.renrakuhyoHakkoshaMei = renrakuhyoHakkoshaMei;
    }

    /**
     * 連絡票発行者郵便番号のgetメソッドです。
     *
     * @return 連絡票発行者郵便番号
     */
    @CheckForNull
    public YubinNo getRenrakuhyoHakkoshaYubinNo() {
        return renrakuhyoHakkoshaYubinNo;
    }

    /**
     * 連絡票発行者郵便番号のsetメソッドです。
     *
     * @param renrakuhyoHakkoshaYubinNo 連絡票発行者郵便番号
     */
    public void setRenrakuhyoHakkoshaYubinNo(YubinNo renrakuhyoHakkoshaYubinNo) {
        this.renrakuhyoHakkoshaYubinNo = renrakuhyoHakkoshaYubinNo;
    }

    /**
     * 連絡票発行者住所のgetメソッドです。
     *
     * @return 連絡票発行者住所
     */
    @CheckForNull
    public RString getRenrakuhyoHakkoshaJusho() {
        return renrakuhyoHakkoshaJusho;
    }

    /**
     * 連絡票発行者住所のsetメソッドです。
     *
     * @param renrakuhyoHakkoshaJusho 連絡票発行者住所
     */
    public void setRenrakuhyoHakkoshaJusho(RString renrakuhyoHakkoshaJusho) {
        this.renrakuhyoHakkoshaJusho = renrakuhyoHakkoshaJusho;
    }

    /**
     * 問い合わせ先郵便番号のgetメソッドです。
     *
     * @return 問い合わせ先郵便番号
     */
    @CheckForNull
    public YubinNo getToiawasesakiYobinNo() {
        return toiawasesakiYobinNo;
    }

    /**
     * 問い合わせ先郵便番号のsetメソッドです。
     *
     * @param toiawasesakiYobinNo 問い合わせ先郵便番号
     */
    public void setToiawasesakiYobinNo(YubinNo toiawasesakiYobinNo) {
        this.toiawasesakiYobinNo = toiawasesakiYobinNo;
    }

    /**
     * 問い合わせ先住所のgetメソッドです。
     *
     * @return 問い合わせ先住所
     */
    @CheckForNull
    public RString getToiawasesakiJusho() {
        return toiawasesakiJusho;
    }

    /**
     * 問い合わせ先住所のsetメソッドです。
     *
     * @param toiawasesakiJusho 問い合わせ先住所
     */
    public void setToiawasesakiJusho(RString toiawasesakiJusho) {
        this.toiawasesakiJusho = toiawasesakiJusho;
    }

    /**
     * 問い合わせ先名称1のgetメソッドです。
     *
     * @return 問い合わせ先名称1
     */
    @CheckForNull
    public RString getToiawasesakiMeisho1() {
        return toiawasesakiMeisho1;
    }

    /**
     * 問い合わせ先名称1のsetメソッドです。
     *
     * @param toiawasesakiMeisho1 問い合わせ先名称1
     */
    public void setToiawasesakiMeisho1(RString toiawasesakiMeisho1) {
        this.toiawasesakiMeisho1 = toiawasesakiMeisho1;
    }

    /**
     * 問い合わせ先名称2のgetメソッドです。
     *
     * @return 問い合わせ先名称2
     */
    @CheckForNull
    public RString getToiawasesakiMeisho2() {
        return toiawasesakiMeisho2;
    }

    /**
     * 問い合わせ先名称2のsetメソッドです。
     *
     * @param toiawasesakiMeisho2 問い合わせ先名称2
     */
    public void setToiawasesakiMeisho2(RString toiawasesakiMeisho2) {
        this.toiawasesakiMeisho2 = toiawasesakiMeisho2;
    }

    /**
     * 問い合わせ先電話番号のgetメソッドです。
     *
     * @return 問い合わせ先電話番号
     */
    @CheckForNull
    public TelNo getToiawasesakiTelNo() {
        return toiawasesakiTelNo;
    }

    /**
     * 問い合わせ先電話番号のsetメソッドです。
     *
     * @param toiawasesakiTelNo 問い合わせ先電話番号
     */
    public void setToiawasesakiTelNo(TelNo toiawasesakiTelNo) {
        this.toiawasesakiTelNo = toiawasesakiTelNo;
    }

    /**
     * 70歳以上負担額合計のgetメソッドです。
     * <br/>
     * <br/>① 70歳以上負担額合計
     *
     * @return 70歳以上負担額合計
     */
    @CheckForNull
    public Decimal getOver70_FutangakuGokei() {
        return over70_FutangakuGokei;
    }

    /**
     * 70歳以上負担額合計のsetメソッドです。
     * <br/>
     * <br/>① 70歳以上負担額合計
     *
     * @param over70_FutangakuGokei 70歳以上負担額合計
     */
    public void setOver70_FutangakuGokei(Decimal over70_FutangakuGokei) {
        this.over70_FutangakuGokei = over70_FutangakuGokei;
    }

    /**
     * 70歳以上支給額合計のgetメソッドです。
     * <br/>
     * <br/>③ ①にかかる支給額合計
     *
     * @return 70歳以上支給額合計
     */
    @CheckForNull
    public Decimal getOver70_ShikyugakuGokei() {
        return over70_ShikyugakuGokei;
    }

    /**
     * 70歳以上支給額合計のsetメソッドです。
     * <br/>
     * <br/>③ ①にかかる支給額合計
     *
     * @param over70_ShikyugakuGokei 70歳以上支給額合計
     */
    public void setOver70_ShikyugakuGokei(Decimal over70_ShikyugakuGokei) {
        this.over70_ShikyugakuGokei = over70_ShikyugakuGokei;
    }

    /**
     * 70歳未満負担額合計のgetメソッドです。
     * <br/>
     * <br/>④ 70歳未満負担額合計
     *
     * @return 70歳未満負担額合計
     */
    @CheckForNull
    public Decimal getUnder70_FutangakuGokei() {
        return under70_FutangakuGokei;
    }

    /**
     * 70歳未満負担額合計のsetメソッドです。
     * <br/>
     * <br/>④ 70歳未満負担額合計
     *
     * @param under70_FutangakuGokei 70歳未満負担額合計
     */
    public void setUnder70_FutangakuGokei(Decimal under70_FutangakuGokei) {
        this.under70_FutangakuGokei = under70_FutangakuGokei;
    }

    /**
     * 負担額の合計額のgetメソッドです。
     * <br/>
     * <br/>⑤ ④＋（①－③）の合計額
     *
     * @return 負担額の合計額
     */
    @CheckForNull
    public Decimal getFutangakuGokei() {
        return futangakuGokei;
    }

    /**
     * 負担額の合計額のsetメソッドです。
     * <br/>
     * <br/>⑤ ④＋（①－③）の合計額
     *
     * @param futangakuGokei 負担額の合計額
     */
    public void setFutangakuGokei(Decimal futangakuGokei) {
        this.futangakuGokei = futangakuGokei;
    }

    /**
     * 70歳未満支給額合計のgetメソッドです。
     * <br/>
     * <br/>⑦ ⑤に係る支給額合計
     *
     * @return 70歳未満支給額合計
     */
    @CheckForNull
    public Decimal getUnder70_ShikyugakuGokei() {
        return under70_ShikyugakuGokei;
    }

    /**
     * 70歳未満支給額合計のsetメソッドです。
     * <br/>
     * <br/>⑦ ⑤に係る支給額合計
     *
     * @param under70_ShikyugakuGokei 70歳未満支給額合計
     */
    public void setUnder70_ShikyugakuGokei(Decimal under70_ShikyugakuGokei) {
        this.under70_ShikyugakuGokei = under70_ShikyugakuGokei;
    }

    /**
     * 支給額合計額のgetメソッドです。
     * <br/>
     * <br/>⑧ ③＋⑦の合計額
     *
     * @return 支給額合計額
     */
    @CheckForNull
    public Decimal getShikyugakuGokei() {
        return shikyugakuGokei;
    }

    /**
     * 支給額合計額のsetメソッドです。
     * <br/>
     * <br/>⑧ ③＋⑦の合計額
     *
     * @param shikyugakuGokei 支給額合計額
     */
    public void setShikyugakuGokei(Decimal shikyugakuGokei) {
        this.shikyugakuGokei = shikyugakuGokei;
    }

    /**
     * データ区分のgetメソッドです。
     *
     * @return データ区分
     */
    @CheckForNull
    public RString getDataKubun() {
        return dataKubun;
    }

    /**
     * データ区分のsetメソッドです。
     *
     * @param dataKubun データ区分
     */
    public void setDataKubun(RString dataKubun) {
        this.dataKubun = dataKubun;
    }

    /**
     * 受取年月のgetメソッドです。
     *
     * @return 受取年月
     */
    @CheckForNull
    public FlexibleYearMonth getUketoriYM() {
        return uketoriYM;
    }

    /**
     * 受取年月のsetメソッドです。
     *
     * @param uketoriYM 受取年月
     */
    public void setUketoriYM(FlexibleYearMonth uketoriYM) {
        this.uketoriYM = uketoriYM;
    }

    /**
     * 送付年月のgetメソッドです。
     *
     * @return 送付年月
     */
    @CheckForNull
    public FlexibleYearMonth getSofuYM() {
        return sofuYM;
    }

    /**
     * 送付年月のsetメソッドです。
     *
     * @param sofuYM 送付年月
     */
    public void setSofuYM(FlexibleYearMonth sofuYM) {
        this.sofuYM = sofuYM;
    }

    /**
     * 再送フラグのgetメソッドです。
     * <br/>
     * <br/>0：再送不要、1：再送要
     *
     * @return 再送フラグ
     */
    @CheckForNull
    public RString getSaisoFG() {
        return saisoFG;
    }

    /**
     * 再送フラグのsetメソッドです。
     * <br/>
     * <br/>0：再送不要、1：再送要
     *
     * @param saisoFG 再送フラグ
     */
    public void setSaisoFG(RString saisoFG) {
        this.saisoFG = saisoFG;
    }

    /**
     * 支給額計算結果連絡票作成年月日のgetメソッドです。
     *
     * @return 支給額計算結果連絡票作成年月日
     */
    @CheckForNull
    public FlexibleDate getSikyugakuKeisanKekkaRenrakuhyoSakuseiYMD() {
        return sikyugakuKeisanKekkaRenrakuhyoSakuseiYMD;
    }

    /**
     * 支給額計算結果連絡票作成年月日のsetメソッドです。
     *
     * @param sikyugakuKeisanKekkaRenrakuhyoSakuseiYMD 支給額計算結果連絡票作成年月日
     */
    public void setSikyugakuKeisanKekkaRenrakuhyoSakuseiYMD(FlexibleDate sikyugakuKeisanKekkaRenrakuhyoSakuseiYMD) {
        this.sikyugakuKeisanKekkaRenrakuhyoSakuseiYMD = sikyugakuKeisanKekkaRenrakuhyoSakuseiYMD;
    }

}
