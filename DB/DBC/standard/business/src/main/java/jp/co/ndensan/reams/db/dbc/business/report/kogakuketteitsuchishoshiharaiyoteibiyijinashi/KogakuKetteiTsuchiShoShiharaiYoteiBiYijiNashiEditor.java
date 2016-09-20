/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishoshiharaiyoteibiyijinashi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijiari.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijinashi.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票設計_DBCMN43002_高額サービス等支給（不支給）決定通知書のEditorクラスです。
 *
 * @reamsid_L DBC-2000-050 zhengshenlei
 */
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor implements IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor {

    private final KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity 帳票情報;
    private final RString テスト印刷 = new RString("テスト印刷");
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_ONE = 1;
    private static final int INDEX_TWO = 2;
    private static final int INDEX_THREE = 3;
    private static final int INDEX_FOUR = 4;
    private static final int INDEX_FIVE = 5;
    private static final int INDEX_SIX = 6;
    private static final int INDEX_SEVEN = 7;
    private static final int INDEX_EIGHT = 8;
    private static final int INDEX_NINE = 9;
    private int 連番;
    private static final RString 設定値_0 = new RString("0");
    private static final RString 設定値_1 = new RString("1");
    private final RString 設定値;
    private static final RString 帳票タイトル = new RString("高額介護（予防）サービス費支給（不支給）決定通知書");
    private static final RString 帳票タイトル_調整用 = new RString("高額介護（予防）サービス費支給（不支給）決定通知書　調整用");
    private static final RString 高額介護予防サービス費 = new RString("高額介護（予防）サービス費");
    private static final RString 支給_不支給区分_1 = new RString("1");
    private static final RString 支給_不支給区分_2 = new RString("2");
    private static final RString 設定値_支給 = new RString("支給");
    private static final RString 設定値_不支給 = new RString("不支給");
    private static final RString 決定通知書 = new RString("決定通知書");
    private static final RString 決定通知書_調整用 = new RString("決定通知書　調整用");
    private final List<RString> 通知書定型文List;
    private static final RString 増減の理由 = new RString("増減の理由");
    private static final RString 不支給の理由 = new RString("不支給の理由");
    private static final RString 支給 = new RString("1");
    private static final RString 不支給 = new RString("2");
    private static final RString 窓口払い = new RString("1");
    private static final RString 半角アスタリスク = new RString("************");
    private static final RString 口座種別 = new RString("口座種別");
    private static final RString 通帳記号 = new RString("通帳記号");
    private static final RString 口座払いでゆうちょ = new RString("口座払いでゆうちょ");
    private static final RString 口座番号 = new RString("口座番号");
    private static final RString 通帳番号 = new RString("通帳番号");
    private final NinshoshaSource 認証者ソースデータ;

    /**
     * コンストラクタです。
     *
     * @param 帳票情報 KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity
     * @param 連番 int
     * @param 設定値 RString
     * @param 通知書定型文List List<RString>
     * @param 認証者ソースデータ NinshoshaSource
     */
    public KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiEditor(
            KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity 帳票情報,
            int 連番,
            RString 設定値,
            List<RString> 通知書定型文List,
            NinshoshaSource 認証者ソースデータ) {
        this.帳票情報 = 帳票情報;
        this.連番 = 連番;
        this.設定値 = 設定値;
        this.通知書定型文List = 通知書定型文List;
        this.認証者ソースデータ = 認証者ソースデータ;
    }

    @Override
    public KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource edit(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.bunshoNo = 帳票情報.get文書番号();
        if (帳票情報.isテスト出力フラグ()) {
            source.testPrint = テスト印刷;
        } else {
            source.testPrint = RString.EMPTY;
        }
        source.renban = new RString(連番);
        setタイトル(source);

        if (通知書定型文List.size() > INDEX_ONE) {
            source.tsuchibun1 = 通知書定型文List.get(INDEX_ONE);
            source.tsuchibun2 = 通知書定型文List.get(INDEX_ONE);
        } else {
            source.tsuchibun1 = RString.EMPTY;
            source.tsuchibun2 = RString.EMPTY;
        }
        source.hihokenshaName = 帳票情報.get被保険者氏名();

        if (帳票情報.get被保険者番号() != null) {
            List<RString> 被保険者番号List = new ArrayList<>();
            RString 保険者番号 = 帳票情報.get被保険者番号().value();
            for (int i = 0; i < 保険者番号.length(); i++) {
                被保険者番号List.add(保険者番号.substring(i, i + 1));
            }
            source.hihokenshaNo1 = set被保険者番号(被保険者番号List, INDEX_ZERO);
            source.hihokenshaNo2 = set被保険者番号(被保険者番号List, INDEX_ONE);
            source.hihokenshaNo3 = set被保険者番号(被保険者番号List, INDEX_TWO);
            source.hihokenshaNo4 = set被保険者番号(被保険者番号List, INDEX_THREE);
            source.hihokenshaNo5 = set被保険者番号(被保険者番号List, INDEX_FOUR);
            source.hihokenshaNo6 = set被保険者番号(被保険者番号List, INDEX_FIVE);
            source.hihokenshaNo7 = set被保険者番号(被保険者番号List, INDEX_SIX);
            source.hihokenshaNo8 = set被保険者番号(被保険者番号List, INDEX_SEVEN);
            source.hihokenshaNo9 = set被保険者番号(被保険者番号List, INDEX_EIGHT);
            source.hihokenshaNo10 = set被保険者番号(被保険者番号List, INDEX_NINE);
        }

        source.uketsukeYMD = get日付年月日(帳票情報.get受付年月日());
        source.ketteiYMD = get日付年月日(帳票情報.get決定年月日());
        source.honninShiharaiGaku = get金額(帳票情報.get本人支払額());
        source.taishoYM = get日付年月(帳票情報.get対象年月());
        source.kyufuShu1 = 帳票情報.get給付の種類();
        source.kyufuShu2 = 帳票情報.get給付の種類();
        source.kyufuShu3 = 帳票情報.get給付の種類();
        source.kekka = 帳票情報.get支給_不支給決定区分();
        source.ketteiGaku = get金額(帳票情報.get決定額());
        source.shikyuGaku = get金額(帳票情報.get支給金額());
        if (設定値_支給.equals(帳票情報.get支給_不支給区分())) {
            source.riyuTitle = 増減の理由;
        } else if (設定値_不支給.equals(帳票情報.get支給_不支給区分())) {
            source.riyuTitle = 不支給の理由;
        }
        source.riyu1 = 帳票情報.get不支給理由();
        source.riyu2 = 帳票情報.get不支給理由();
        source.riyu3 = 帳票情報.get不支給理由();
        source.torikeshi1 = 帳票情報.get窓口払();
        source.torikeshi2 = 帳票情報.get口座払();
        if (支給.equals(帳票情報.get支給_不支給区分()) && !窓口払い.equals(帳票情報.get支払方法区分())
                || 不支給.equals(帳票情報.get支給_不支給区分())) {
            source.torikeshiMochimono1 = 半角アスタリスク;
            source.torikeshiMochimono2 = 半角アスタリスク;
            source.torikeshiShiharaibasho = 半角アスタリスク;
            source.torikeshiShiharaikikan = 半角アスタリスク;
        }
        source.mochimono1 = 帳票情報.get持ちもの();
        source.mochimono2 = 帳票情報.get持ちもの();
        source.mochimono3 = 帳票情報.get持ちもの();
        source.shiharaiBasho = 帳票情報.get支払場所();

        if (帳票情報.get支払期間() != null) {
            source.shiharaiStartYMD = 帳票情報.get支払期間().toDateString();
            source.karaFugo = 帳票情報.get支払期間().toDateString();
            source.shiharaiEndYMD = 帳票情報.get支払期間().toDateString();
            source.shiharaiStartHMS = 帳票情報.get支払期間().toDateString();
            source.shiharaiEndHMS = 帳票情報.get支払期間().toDateString();
        }

        source.bankName = 帳票情報.get金融機関上段();
        source.branchBankName = 帳票情報.get金融機関下段();

        if (支給.equals(帳票情報.get支給_不支給区分())) {
            if (窓口払い.equals(帳票情報.get支払方法())) {
                source.shumokuTitle = 口座種別;
                source.bangoTitle = 口座番号;
            } else if (口座払いでゆうちょ.equals(帳票情報.get支払方法())) {
                source.shumokuTitle = 通帳記号;
                source.bangoTitle = 通帳番号;
            } else {
                source.shumokuTitle = 口座種別;
                source.bangoTitle = 口座番号;
            }
            if (帳票情報.get支給額() != null && 帳票情報.get支給額().compareTo(Decimal.ZERO) < 0
                    || 不支給.equals(帳票情報.get支給_不支給区分())) {
                source.shumokuTitle = 口座種別;
                source.bangoTitle = 口座番号;
            }
        }

        if (!帳票情報.isゆうちょ銀行フラグ()) {
            source.kouzaShu = 帳票情報.get口座種別();
            source.kouzaNo = 帳票情報.get口座番号();
        } else {
            source.kouzaShu = 帳票情報.get通帳記号();
            source.kouzaNo = 帳票情報.get通帳番号();
        }
        source.kouzaMeigi = 帳票情報.get口座名義人();
        source.tsuchino = 帳票情報.get決定通知書番号();
        source.tsuban = new RString(連番);
        set通知文２(source);
        set通知文Large(source);
        set通知文上段Small(source);
        set通知文下段Large(source);
        set通知文上段Small_2(source);
        set通知文下段Large_2(source);
        set雛形部品CompNinshosha(source);

        return source;
    }

    private RString set被保険者番号(List<RString> 被保険者番号List, int index) {
        return index < 被保険者番号List.size() ? 被保険者番号List.get(index) : RString.EMPTY;
    }

    private void setタイトル(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.title = fetchTitle();
        source.title2_1 = fetchTitle2_1();
        source.title2_2_1 = fetchTitle2_2_1();
        source.title2_2_2 = fetchTitle2_2_2();
        source.title2_3_1 = fetchTitle2_3_1();
        source.title2_3_2 = fetchTitle2_3_2();
        source.title2_4 = fetchTitle2_4();
        source.title3_1 = fetchTitle3_1();
        source.title3_2_1 = fetchTitle3_2_1();
        source.title3_2_2 = fetchTitle3_2_2();
        source.title3_3_1 = fetchTitle3_3_1();
        source.title3_3_2 = fetchTitle3_3_2();
        source.title3_4 = fetchTitle3_4();

    }

    private void set通知文２(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.tsuchibun3 = get通知書定型文(INDEX_TWO);
        source.tsuchibun4 = get通知書定型文(INDEX_TWO);
        source.tsuchibun5 = get通知書定型文(INDEX_TWO);
        source.tsuchibun6 = get通知書定型文(INDEX_TWO);
        source.tsuchibun7 = get通知書定型文(INDEX_TWO);
        source.tsuchibun8 = get通知書定型文(INDEX_TWO);
        source.tsuchibun9 = get通知書定型文(INDEX_TWO);
        source.tsuchibun10 = get通知書定型文(INDEX_TWO);
        source.tsuchibun11 = get通知書定型文(INDEX_TWO);
        source.tsuchibun12 = get通知書定型文(INDEX_TWO);
        source.tsuchibun13 = get通知書定型文(INDEX_TWO);
        source.tsuchibun14 = get通知書定型文(INDEX_TWO);
        source.tsuchibun15 = get通知書定型文(INDEX_TWO);
        source.tsuchibun16 = get通知書定型文(INDEX_TWO);
        source.tsuchibun17 = get通知書定型文(INDEX_TWO);
        source.tsuchibun18 = get通知書定型文(INDEX_TWO);
        source.tsuchibun19 = get通知書定型文(INDEX_TWO);
        source.tsuchibun20 = get通知書定型文(INDEX_TWO);
        source.tsuchibun21 = get通知書定型文(INDEX_TWO);
        source.tsuchibun22 = get通知書定型文(INDEX_TWO);
        source.tsuchibun23 = get通知書定型文(INDEX_TWO);
        source.tsuchibun24 = get通知書定型文(INDEX_TWO);
    }

    private void set通知文Large(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.tsuchibunLarge3 = get通知書定型文(INDEX_TWO);
        source.tsuchibunLarge4 = get通知書定型文(INDEX_TWO);
        source.tsuchibunLarge5 = get通知書定型文(INDEX_TWO);
        source.tsuchibunLarge6 = get通知書定型文(INDEX_TWO);
        source.tsuchibunLarge7 = get通知書定型文(INDEX_TWO);
        source.tsuchibunLarge8 = get通知書定型文(INDEX_TWO);
        source.tsuchibunLarge9 = get通知書定型文(INDEX_TWO);
        source.tsuchibunLarge10 = get通知書定型文(INDEX_TWO);
        source.tsuchibunLarge11 = get通知書定型文(INDEX_TWO);
        source.tsuchibunLarge12 = get通知書定型文(INDEX_TWO);
        source.tsuchibunLarge13 = get通知書定型文(INDEX_TWO);
        source.tsuchibunLarge14 = get通知書定型文(INDEX_TWO);
        source.tsuchibunLarge15 = get通知書定型文(INDEX_TWO);
        source.tsuchibunLarge16 = get通知書定型文(INDEX_TWO);
        source.tsuchibunLarge17 = get通知書定型文(INDEX_TWO);
        source.tsuchibunLarge18 = get通知書定型文(INDEX_TWO);
        source.tsuchibunLarge19 = get通知書定型文(INDEX_TWO);
    }

    private void set通知文上段Small(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.tsuchibunMix3 = get通知書定型文(INDEX_TWO);
        source.tsuchibunMix4 = get通知書定型文(INDEX_TWO);
        source.tsuchibunMix5 = get通知書定型文(INDEX_TWO);
        source.tsuchibunMix6 = get通知書定型文(INDEX_TWO);
        source.tsuchibunMix7 = get通知書定型文(INDEX_TWO);
        source.tsuchibunMix8 = get通知書定型文(INDEX_TWO);
        source.tsuchibunMix9 = get通知書定型文(INDEX_TWO);
        source.tsuchibunMix10 = get通知書定型文(INDEX_TWO);
        source.tsuchibunMix11 = get通知書定型文(INDEX_TWO);
        source.tsuchibunMix12 = get通知書定型文(INDEX_TWO);
        source.tsuchibunMix13 = get通知書定型文(INDEX_TWO);
        source.tsuchibunMix14 = get通知書定型文(INDEX_TWO);
        source.tsuchibunMix15 = get通知書定型文(INDEX_TWO);
    }

    private void set通知文下段Large(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.tsuchibunMix16 = get通知書定型文(INDEX_THREE);
        source.tsuchibunMix17 = get通知書定型文(INDEX_THREE);
        source.tsuchibunMix18 = get通知書定型文(INDEX_THREE);
        source.tsuchibunMix19 = get通知書定型文(INDEX_THREE);
        source.tsuchibunMix20 = get通知書定型文(INDEX_THREE);
        source.tsuchibunMix21 = get通知書定型文(INDEX_THREE);
        source.tsuchibunMix22 = get通知書定型文(INDEX_THREE);
    }

    private void set通知文上段Small_2(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.tsuchibunMixtwo3 = get通知書定型文(INDEX_TWO);
        source.tsuchibunMixtwo4 = get通知書定型文(INDEX_TWO);
        source.tsuchibunMixtwo5 = get通知書定型文(INDEX_TWO);
        source.tsuchibunMixtwo6 = get通知書定型文(INDEX_TWO);
        source.tsuchibunMixtwo7 = get通知書定型文(INDEX_TWO);
        source.tsuchibunMixtwo8 = get通知書定型文(INDEX_TWO);
        source.tsuchibunMixtwo9 = get通知書定型文(INDEX_TWO);

    }

    private void set通知文下段Large_2(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.tsuchibunMixtwo10 = get通知書定型文(INDEX_THREE);
        source.tsuchibunMixtwo11 = get通知書定型文(INDEX_THREE);
        source.tsuchibunMixtwo12 = get通知書定型文(INDEX_THREE);
        source.tsuchibunMixtwo13 = get通知書定型文(INDEX_THREE);
        source.tsuchibunMixtwo14 = get通知書定型文(INDEX_THREE);
        source.tsuchibunMixtwo15 = get通知書定型文(INDEX_THREE);
        source.tsuchibunMixtwo16 = get通知書定型文(INDEX_THREE);
        source.tsuchibunMixtwo17 = get通知書定型文(INDEX_THREE);
        source.tsuchibunMixtwo18 = get通知書定型文(INDEX_THREE);
        source.tsuchibunMixtwo19 = get通知書定型文(INDEX_THREE);
        source.tsuchibunMixtwo20 = get通知書定型文(INDEX_THREE);
        source.tsuchibunMixtwo21 = get通知書定型文(INDEX_THREE);
        source.tsuchibunMixtwo22 = get通知書定型文(INDEX_THREE);
    }

    private RString get通知書定型文(int index) {
        return index < 通知書定型文List.size() ? 通知書定型文List.get(index) : RString.EMPTY;
    }

    private RString fetchTitle() {
        if (設定値_0.equals(設定値) && 帳票情報.get支給額() != null && 帳票情報.get支給額().compareTo(Decimal.ZERO) >= 0) {
            return 帳票タイトル;
        } else if (設定値_0.equals(設定値) && 帳票情報.get支給額() != null && 帳票情報.get支給額().compareTo(Decimal.ZERO) < 0) {
            return 帳票タイトル_調整用;
        } else if (設定値_1.equals(設定値)) {
            return RString.EMPTY;
        }
        return RString.EMPTY;
    }

    private RString fetchTitle2_1() {
        if (設定値_0.equals(設定値)) {
            return RString.EMPTY;
        } else if (設定値_1.equals(設定値) && 帳票情報.get支給額() != null && 帳票情報.get支給額().compareTo(Decimal.ZERO) >= 0) {
            return 高額介護予防サービス費;
        }
        return RString.EMPTY;
    }

    private RString fetchTitle2_2_1() {
        if (設定値_0.equals(設定値)) {
            return RString.EMPTY;
        } else if (設定値_1.equals(設定値) && 帳票情報.get支給額() != null && 帳票情報.get支給額().compareTo(Decimal.ZERO) >= 0) {
            if (支給_不支給区分_1.equals(帳票情報.get支給_不支給区分())) {
                return 設定値_支給;
            } else if (支給_不支給区分_2.equals(帳票情報.get支給_不支給区分())) {
                return RString.EMPTY;
            }
        }
        return RString.EMPTY;
    }

    private RString fetchTitle2_2_2() {
        if (設定値_0.equals(設定値)) {
            return RString.EMPTY;
        } else if (設定値_1.equals(設定値) && 帳票情報.get支給額() != null && 帳票情報.get支給額().compareTo(Decimal.ZERO) >= 0) {
            if (支給_不支給区分_1.equals(帳票情報.get支給_不支給区分())) {
                return RString.EMPTY;
            } else if (支給_不支給区分_2.equals(帳票情報.get支給_不支給区分())) {
                return 設定値_支給;
            }
        }
        return RString.EMPTY;
    }

    private RString fetchTitle2_3_1() {
        if (設定値_0.equals(設定値)) {
            return RString.EMPTY;
        } else if (設定値_1.equals(設定値) && 帳票情報.get支給額() != null && 帳票情報.get支給額().compareTo(Decimal.ZERO) >= 0) {
            if (支給_不支給区分_1.equals(帳票情報.get支給_不支給区分())) {
                return RString.EMPTY;
            } else if (支給_不支給区分_2.equals(帳票情報.get支給_不支給区分())) {
                return 設定値_不支給;
            }
        }
        return RString.EMPTY;
    }

    private RString fetchTitle2_3_2() {
        if (設定値_0.equals(設定値)) {
            return RString.EMPTY;
        } else if (設定値_1.equals(設定値) && 帳票情報.get支給額() != null && 帳票情報.get支給額().compareTo(Decimal.ZERO) >= 0) {
            if (支給_不支給区分_1.equals(帳票情報.get支給_不支給区分())) {
                return 設定値_不支給;
            } else if (支給_不支給区分_2.equals(帳票情報.get支給_不支給区分())) {
                return RString.EMPTY;
            }
        }
        return RString.EMPTY;
    }

    private RString fetchTitle2_4() {
        if (設定値_0.equals(設定値)) {
            return RString.EMPTY;
        } else if (設定値_1.equals(設定値) && 帳票情報.get支給額() != null && 帳票情報.get支給額().compareTo(Decimal.ZERO) >= 0) {
            return 決定通知書;
        }
        return RString.EMPTY;
    }

    private RString fetchTitle3_1() {
        if (設定値_0.equals(設定値)) {
            return RString.EMPTY;
        } else if (設定値_1.equals(設定値) && 帳票情報.get支給額() != null && 帳票情報.get支給額().compareTo(Decimal.ZERO) < 0) {
            return 高額介護予防サービス費;
        }
        return RString.EMPTY;
    }

    private RString fetchTitle3_2_1() {
        if (設定値_0.equals(設定値)) {
            return RString.EMPTY;
        } else if (設定値_1.equals(設定値) && 帳票情報.get支給額() != null && 帳票情報.get支給額().compareTo(Decimal.ZERO) < 0) {
            if (支給_不支給区分_1.equals(帳票情報.get支給_不支給区分())) {
                return 設定値_支給;
            } else if (支給_不支給区分_2.equals(帳票情報.get支給_不支給区分())) {
                return RString.EMPTY;
            }
        }
        return RString.EMPTY;
    }

    private RString fetchTitle3_2_2() {
        if (設定値_0.equals(設定値)) {
            return RString.EMPTY;
        } else if (設定値_1.equals(設定値) && 帳票情報.get支給額() != null && 帳票情報.get支給額().compareTo(Decimal.ZERO) < 0) {
            if (支給_不支給区分_1.equals(帳票情報.get支給_不支給区分())) {
                return RString.EMPTY;
            } else if (支給_不支給区分_2.equals(帳票情報.get支給_不支給区分())) {
                return 設定値_支給;
            }
        }
        return RString.EMPTY;
    }

    private RString fetchTitle3_3_1() {
        if (設定値_0.equals(設定値)) {
            return RString.EMPTY;
        } else if (設定値_1.equals(設定値) && 帳票情報.get支給額() != null && 帳票情報.get支給額().compareTo(Decimal.ZERO) < 0) {
            if (支給_不支給区分_1.equals(帳票情報.get支給_不支給区分())) {
                return RString.EMPTY;
            } else if (支給_不支給区分_2.equals(帳票情報.get支給_不支給区分())) {
                return 設定値_不支給;
            }
        }
        return RString.EMPTY;
    }

    private RString fetchTitle3_3_2() {
        if (設定値_0.equals(設定値)) {
            return RString.EMPTY;
        } else if (設定値_1.equals(設定値) && 帳票情報.get支給額() != null && 帳票情報.get支給額().compareTo(Decimal.ZERO) < 0) {
            if (支給_不支給区分_1.equals(帳票情報.get支給_不支給区分())) {
                return 設定値_不支給;
            } else if (支給_不支給区分_2.equals(帳票情報.get支給_不支給区分())) {
                return RString.EMPTY;
            }
        }
        return RString.EMPTY;
    }

    private RString fetchTitle3_4() {
        if (設定値_0.equals(設定値)) {
            return RString.EMPTY;
        } else if (設定値_1.equals(設定値) && 帳票情報.get支給額() != null && 帳票情報.get支給額().compareTo(Decimal.ZERO) < 0) {
            return 決定通知書_調整用;
        }
        return RString.EMPTY;
    }

    private RString get日付年月日(RDate 年月日) {
        return 年月日 != null ? 年月日.toDateString() : RString.EMPTY;
    }

    private RString get日付年月(FlexibleYearMonth 年月) {
        return 年月 != null ? 年月.toDateString() : RString.EMPTY;
    }

    private RString get金額(Decimal 金額) {
        return 金額 != null ? new RString(金額.toString()) : RString.EMPTY;
    }

    private void set雛形部品CompNinshosha(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        if (認証者ソースデータ != null) {
            source.denshiKoin = 認証者ソースデータ.denshiKoin;
            source.hakkoYMD = 認証者ソースデータ.hakkoYMD;
            source.ninshoshaYakushokuMei = 認証者ソースデータ.ninshoshaYakushokuMei;
            source.ninshoshaYakushokuMei1 = 認証者ソースデータ.ninshoshaYakushokuMei1;
            source.koinMojiretsu = 認証者ソースデータ.koinMojiretsu;
            source.ninshoshaYakushokuMei2 = 認証者ソースデータ.ninshoshaYakushokuMei2;
            source.ninshoshaShimeiKakenai = 認証者ソースデータ.ninshoshaShimeiKakenai;
            source.ninshoshaShimeiKakeru = 認証者ソースデータ.ninshoshaShimeiKakeru;
            source.koinShoryaku = 認証者ソースデータ.koinShoryaku;
        }
    }
}
