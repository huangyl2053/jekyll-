/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.henkokenchushitsuchisho.a4tate;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoBusiness;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.CharacteristicsPhase;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiKetteiTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.entity.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * 介護保険料額変更兼特別徴収中止通知書のA4縦タイプのEditorです。
 *
 * @reamsid_L DBB-9080-020 sunhaidi
 */
public class KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateEditor implements IKaigoHokenryogakuHenkoKenChushiTsuchishoA4TateEditor {

    private static final int SIZE_3 = 3;
    private static final RString 更正内容 = new RString("年額保険料で");
    private static final RString 文字 = new RString("T");
    private final KaigoHokenryogakuHenkoKenChushiTsuchishoBusiness item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KaigoHokenryogakuHenkoKenChushiTsuchishoBusiness}
     */
    protected KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateEditor(KaigoHokenryogakuHenkoKenChushiTsuchishoBusiness item) {
        this.item = item;
    }

    @Override
    public KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource edit(KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource reportSource) {
        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = item.get本算定決定通知書情報().get編集後本算定通知書共通情報();
        EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正後 = 編集後本算定通知書共通情報.get更正後();
        EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正前 = 編集後本算定通知書共通情報.get更正前();
        reportSource.bankCode = 編集後本算定通知書共通情報.get編集後口座().get金融機関コードCombinedWith支店コード();
        reportSource.bankName = 編集後本算定通知書共通情報.get編集後口座().get金融機関名CombinedWith支店名();
        reportSource.bunshoNo = item.get文書番号();
        List<RString> 調定事由リスト = item.get調定事由リスト();
        if (調定事由リスト != null && !調定事由リスト.isEmpty()) {
            reportSource.choteiJiyu1 = 調定事由リスト.get(0);
            if (1 < 調定事由リスト.size()) {
                reportSource.choteiJiyu2 = 調定事由リスト.get(1);
            }
            if (2 < 調定事由リスト.size()) {
                reportSource.choteiJiyu3 = 調定事由リスト.get(2);
            }
            if (SIZE_3 < 調定事由リスト.size()) {
                reportSource.choteiJiyu4 = 調定事由リスト.get(SIZE_3);
            }

        } else {
            reportSource.choteiJiyu1 = 編集後本算定通知書共通情報.get調定事由１();
            reportSource.choteiJiyu2 = 編集後本算定通知書共通情報.get調定事由２();
            reportSource.choteiJiyu3 = 編集後本算定通知書共通情報.get調定事由３();
            reportSource.choteiJiyu4 = 編集後本算定通知書共通情報.get調定事由４();
        }

        reportSource.genmenAto = DecimalFormatter.toコンマ区切りRString(更正後.get減免額(), 0);
        reportSource.hihokenshaNo = 編集後本算定通知書共通情報.get被保険者番号().value();
        reportSource.hokenGakuAto = DecimalFormatter.toコンマ区切りRString(更正後.get確定保険料_年額(), 0);
        reportSource.hokenRitsuAto = DecimalFormatter.toコンマ区切りRString(更正後.get保険料率(), 0);
        reportSource.hokenSanshutsuAto = DecimalFormatter.toコンマ区切りRString(更正後.get減免前保険料_年額(), 0);

        HyojiCodes 表示コード = 編集後本算定通知書共通情報.get表示コード();
        reportSource.hyojicode1 = 表示コード.get表示コード１();
        reportSource.hyojicode2 = 表示コード.get表示コード２();
        reportSource.hyojicode3 = 表示コード.get表示コード３();
        reportSource.hyojicodeName1 = 表示コード.get表示コード名１();
        reportSource.hyojicodeName2 = 表示コード.get表示コード名２();
        reportSource.hyojicodeName3 = 表示コード.get表示コード名３();
        reportSource.korekaraChoshuho = 更正後.get徴収方法();
        edit更正内容(reportSource, 編集後本算定通知書共通情報);

        EditedKoza 口座情報 = 編集後本算定通知書共通情報.get編集後口座();
        reportSource.kozaMeigi = 口座情報.get口座名義人優先();
        reportSource.kozaNo = 口座情報.get口座番号Or通帳記号番号();
        reportSource.kozaShurui = 口座情報.get口座種別略称();
        reportSource.nofuzumiGaku = decimalToRString(編集後本算定通知書共通情報.get納付済額_未到来期含む());
        reportSource.setaiCode = 編集後本算定通知書共通情報.get編集後個人().get世帯コード().value();
        reportSource.shikibetsuCode = 編集後本算定通知書共通情報.get識別コード().value();
        reportSource.shotokuKbnAto = 更正後.get保険料段階();
        reportSource.shutokuYmdAto = 更正後.get期間_自();
        reportSource.soshitsuYmdAto = 更正後.get期間_至();

        set調定年度_タイトル_通知文1(reportSource, item.get本算定決定通知書情報());
        set通知文1と通知区分(reportSource, 編集後本算定通知書共通情報);
        reportSource.tsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().value();
        reportSource.tsukisuAto = 更正後.get月数_ケ月();

        reportSource.zogenGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get増減額(), 0);
        reportSource.koseigoHokenryoGaku = DecimalFormatter.toコンマ区切りRString(更正後.get確定保険料_年額(), 0);
        reportSource.tokuchoGimusha = 更正後.get特別徴収義務者();
        reportSource.tokuchoTaishoNenkin = 更正後.get特別徴収対象年金();

        if (更正前 != null) {
            reportSource.genmenMae = DecimalFormatter.toコンマ区切りRString(更正前.get減免額(), 0);
            reportSource.hokenGakuMae = DecimalFormatter.toコンマ区切りRString(更正前.get確定保険料_年額(), 0);
            reportSource.hokenRitsuMae = DecimalFormatter.toコンマ区切りRString(更正前.get保険料率(), 0);
            reportSource.hokenSanshutsuMae = DecimalFormatter.toコンマ区切りRString(更正前.get減免前保険料_年額(), 0);
            reportSource.shotokuKbnMae = 更正前.get保険料段階();
            reportSource.shutokuYmdMae = 更正前.get期間_自();
            reportSource.soshitsuYmdMae = 更正前.get期間_至();
            reportSource.tsukisuMae = 更正前.get月数_ケ月();
        }
        return reportSource;
    }

    private void edit更正内容(KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource reportSource,
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報) {

        Decimal 増減額 = 編集後本算定通知書共通情報.get増減額();
        if (0 < Decimal.ZERO.compareTo(増減額)) {
            reportSource.koseiNaiyo = 更正内容;
            reportSource.kakuteiHokenryoGaku = DecimalFormatter.toコンマ区切りRString(増減額, 0);
            reportSource.koseiRiyu = new RString("円の増額です。");
        } else if (Decimal.ZERO.compareTo(増減額) < 0) {
            reportSource.koseiNaiyo = 更正内容;
            reportSource.kakuteiHokenryoGaku = DecimalFormatter.toコンマ区切りRString(増減額.multiply(-1), 0);
            reportSource.koseiRiyu = new RString("円の減額です。");
        } else if (is期別金額変更(編集後本算定通知書共通情報)) {
            reportSource.koseiNaiyo2 = new RString("期別納付額が変更になりました。");
        }

    }

    private boolean is期別金額変更(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報) {
        boolean is変更 = false;
        if (編集後本算定通知書共通情報.get更正前() != null) {
            List<UniversalPhase> 更正前普徴期別金額リスト = 編集後本算定通知書共通情報.get更正前().get普徴期別金額リスト();
            List<UniversalPhase> 更正後普徴期別金額リスト = 編集後本算定通知書共通情報.get更正後().get普徴期別金額リスト();

            for (UniversalPhase 更正前 : 更正前普徴期別金額リスト) {
                for (UniversalPhase 更正後 : 更正後普徴期別金額リスト) {
                    if (更正前.get期() == 更正後.get期() && !更正前.get金額().equals(更正後.get金額())) {
                        is変更 = true;
                    }
                }
            }

            List<CharacteristicsPhase> 更正前特徴期別金額リスト = 編集後本算定通知書共通情報.get更正前().get特徴期別金額リスト();
            List<CharacteristicsPhase> 更正後特徴期別金額リスト = 編集後本算定通知書共通情報.get更正後().get特徴期別金額リスト();

            for (CharacteristicsPhase 更正前 : 更正前特徴期別金額リスト) {
                for (CharacteristicsPhase 更正後 : 更正後特徴期別金額リスト) {

                    if (更正前.get期() == 更正後.get期() && !更正前.get金額().equals(更正後.get金額())) {
                        is変更 = true;
                    }
                }
            }
        }
        return is変更;
    }

    private void set通知文1と通知区分(KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource reportSource,
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報) {
        if (GennenKanen.過年度.equals(item.get本算定決定通知書情報().get現年度_過年度区分())) {
            RStringBuilder tsuchibun1 = new RStringBuilder();
            tsuchibun1.append(編集後本算定通知書共通情報.get賦課年度().toDateString());
            tsuchibun1.append(new RString("以前にさかのぼって資格取得・更正した分"));
            reportSource.tsuchibun1 = tsuchibun1.toRString();
            reportSource.tsuchibun3 = new RString("（過年度）");
        }
    }

    private boolean is特別徴収停止(HonSanteiKetteiTsuchiShoJoho 本算定決定通知書情報) {
        boolean is特別徴収停止 = false;
        if (GennenKanen.過年度.equals(本算定決定通知書情報.get現年度_過年度区分())) {
            is特別徴収停止 = true;
        }
        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報
                = 本算定決定通知書情報.get編集後本算定通知書共通情報();

        RString 調定事由１ = 編集後本算定通知書共通情報.get調定事由１();
        RString 調定事由２ = 編集後本算定通知書共通情報.get調定事由２();
        RString 調定事由３ = 編集後本算定通知書共通情報.get調定事由３();
        RString 調定事由４ = 編集後本算定通知書共通情報.get調定事由４();
        if ((!RString.isNullOrEmpty(調定事由１) && !調定事由１.startsWith(文字))
                && (!RString.isNullOrEmpty(調定事由２) && !調定事由２.startsWith(文字))
                && (!RString.isNullOrEmpty(調定事由３) && !調定事由３.startsWith(文字))
                && (!RString.isNullOrEmpty(調定事由４) && !調定事由４.startsWith(文字))) {
            is特別徴収停止 = true;
        }

        return is特別徴収停止;
    }

    private void set調定年度_タイトル_通知文1(KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource reportSource,
            HonSanteiKetteiTsuchiShoJoho 本算定決定通知書情報) {
        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報
                = 本算定決定通知書情報.get編集後本算定通知書共通情報();
        if (is特別徴収停止(本算定決定通知書情報)) {
            RString 調定年度 = 編集後本算定通知書共通情報.get調定年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .fillType(FillType.BLANK).toDateString();
            RStringBuilder 調定年度SB = new RStringBuilder();
            調定年度SB.append(調定年度);
            調定年度SB.append(new RString("年度"));
            reportSource.choteiNendo = 調定年度SB.toRString();
            reportSource.title1 = RString.EMPTY;
            reportSource.title2 = RString.EMPTY;
            reportSource.title3 = new RString("介護保険料額変更通知書");
            RStringBuilder 通知文1 = new RStringBuilder();
            通知文1.append(編集後本算定通知書共通情報.get賦課年度().toDateString());
            通知文1.append(new RString("年度分の介護保険料額を以下のとおり変更しましたので通知します。"));
            reportSource.tsuchibun1 = 通知文1.toRString();
        } else {
            reportSource.choteiNendo = RString.EMPTY;
            reportSource.title1 = 編集後本算定通知書共通情報.get調定年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .fillType(FillType.BLANK).toDateString();
            reportSource.title2 = new RString("介護保険料額変更通知書兼特別徴収中止通知書");
            reportSource.title3 = RString.EMPTY;
            RStringBuilder 通知文1 = new RStringBuilder();
            通知文1.append(編集後本算定通知書共通情報.get賦課年度().toDateString());
            通知文1.append(new RString("年度分の介護保険料額の特別徴収を中止し、以下のとおり普通徴収することとしましたので通知します。"));
            reportSource.tsuchibun1 = 通知文1.toRString();
        }
    }

    private RString decimalToRString(Decimal number) {
        if (number != null) {
            return new RString(number.toString());
        }
        return RString.EMPTY;
    }
}
