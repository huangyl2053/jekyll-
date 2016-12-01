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

        reportSource.genmenAto = decimalToRString(更正後.get減免額());
        reportSource.hihokenshaNo = 編集後本算定通知書共通情報.get被保険者番号().value();
        reportSource.hokenGakuAto = decimalToRString(更正後.get確定保険料_年額());
        reportSource.hokenRitsuAto = decimalToRString(更正後.get保険料率());
        reportSource.hokenSanshutsuAto = decimalToRString(更正後.get減免前保険料_年額());

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
        reportSource.kongoNofusubekiGaku = decimalToRString(編集後本算定通知書共通情報.get今後納付すべき額_収入元に());
        reportSource.nofuzumiGaku = decimalToRString(編集後本算定通知書共通情報.get納付済額_未到来期含む());
        reportSource.setaiCode = 編集後本算定通知書共通情報.get編集後個人().get世帯コード().value();
        reportSource.shikibetsuCode = 編集後本算定通知書共通情報.get識別コード().value();
        reportSource.shotokuKbnAto = 更正後.get保険料段階();
        reportSource.shutokuYmdAto = 更正後.get期間_自();
        reportSource.soshitsuYmdAto = 更正後.get期間_至();

        set調定年度_タイトル_通知文1(reportSource, item.get本算定決定通知書情報());
        set通知文と通知区分(reportSource, 編集後本算定通知書共通情報);
        reportSource.tsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().value();
        reportSource.tsukisuAto = 更正後.get月数_ケ月();

        reportSource.zogenGaku = decimalToRString(編集後本算定通知書共通情報.get増減額());
        reportSource.koseigoHokenryoGaku = decimalToRString(更正後.get確定保険料_年額());
        reportSource.tokuchoGimusha = 更正後.get特別徴収義務者();
        reportSource.tokuchoTaishoNenkin = 更正後.get特別徴収対象年金();

        if (更正前 != null && item.get本算定決定通知書情報().isHas更正前()) {
            reportSource.genmenMae = decimalToRString(更正前.get減免額());
            reportSource.hokenGakuMae = decimalToRString(更正前.get確定保険料_年額());
            reportSource.hokenRitsuMae = decimalToRString(更正前.get保険料率());
            reportSource.hokenSanshutsuMae = decimalToRString(更正前.get減免前保険料_年額());
            reportSource.shotokuKbnMae = 更正前.get保険料段階();
            reportSource.shutokuYmdMae = 更正前.get期間_自();
            reportSource.soshitsuYmdMae = 更正前.get期間_至();
            reportSource.tsukisuMae = 更正前.get月数_ケ月();
            reportSource.honninKazeiKubunMae = 更正前.get市町村民税課税区分_本人();
            reportSource.setaiKazeiKubunMae = 更正前.get市町村民税課税区分_世帯();
            reportSource.kotekiNenkinShunyuGakuMae = edit金額(更正前.get公的年金収入額());
            reportSource.gokeiShotokuKingakuMae = edit金額(更正前.get合計所得金額());
            reportSource.seikatsuHogoFujoShuruiMae = 更正前.get生活保護扶助種類();
            reportSource.seihoHaishiYmdMae = 更正前.get生保廃止日();
            reportSource.seihoKaishiYmdMae = 更正前.get生保開始日();
            reportSource.roreiHaishiYmdMae = 更正前.get老齢廃止日();
            reportSource.roreiKaishiYmdMae = 更正前.get老齢開始日();

        }
        reportSource.honninKazeiKubunAto = 更正後.get市町村民税課税区分_本人();
        reportSource.setaiKazeiKubunAto = 更正後.get市町村民税課税区分_世帯();
        reportSource.kotekiNenkinShunyuGakuAto = edit金額(更正後.get公的年金収入額());
        reportSource.gokeiShotokuKingakuAto = edit金額(更正後.get合計所得金額());
        reportSource.seikatsuHogoFujoShuruiAto = 更正後.get生活保護扶助種類();
        reportSource.seihoHaishiYmdAto = 更正後.get生保廃止日();
        reportSource.seihoKaishiYmdAto = 更正後.get生保開始日();
        reportSource.roreiHaishiYmdAto = 更正後.get老齢廃止日();
        reportSource.roreiKaishiYmdAto = 更正後.get老齢開始日();
        reportSource.nofuzumiGakuMiToraiKi = edit金額(編集後本算定通知書共通情報.get未到来期の納付済額());
        reportSource.nofuzumiGakuToraiKi = edit金額(編集後本算定通知書共通情報.get納付済額_未到来期含まない());
        reportSource.fuchoNofuzumiGaku = edit金額(編集後本算定通知書共通情報.get普徴納付済額_未到来期含む());
        reportSource.tokuchoNofuzumiGaku = edit金額(編集後本算定通知書共通情報.get特徴納付済額_未到来期含む());
        reportSource.tokuchoNofuzumiGakuToraiKi = edit金額(編集後本算定通知書共通情報.get特徴納付済額_未到来期含まない());
        reportSource.fuchoNofuzumiGakuToraiKi = edit金額(編集後本算定通知書共通情報.get普徴納付済額_未到来期含まない());
        reportSource.nofuzumiGakuSanshutsuYmd = 編集後本算定通知書共通情報.get納付済額算出年月日();
        reportSource.sudeniNofuSubekiGaku = edit金額(編集後本算定通知書共通情報.get既に納付すべき額());
        reportSource.tokuchoSudeniNofuSubekiGaku = edit金額(編集後本算定通知書共通情報.get特徴既に納付すべき額());
        reportSource.fuchoSudeniNofuSubekiGaku = edit金額(編集後本算定通知書共通情報.get普徴既に納付すべき額());
        reportSource.fuchoKongoNofuSubekiGakuShunyu = edit金額(編集後本算定通知書共通情報.get普徴今後納付すべき額_収入元に());
        reportSource.fuchoKongoNofuSubekiGakuChotei = edit金額(編集後本算定通知書共通情報.get普徴今後納付すべき額_調定元に());
        reportSource.tokuchoKongoNofuSubekiGakuShunyu = edit金額(編集後本算定通知書共通情報.get特徴今後納付すべき額_収入元に());
        reportSource.tokuchoKongoNofuSubekiGakuChotei = edit金額(編集後本算定通知書共通情報.get特徴今後納付すべき額_調定元に());
        reportSource.kongoNofuSubekiGakuChotei = edit金額(編集後本算定通知書共通情報.get今後納付すべき額_調定元に());
        return reportSource;
    }

    private void edit更正内容(KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource reportSource,
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報) {

        Decimal 増減額 = 編集後本算定通知書共通情報.get増減額();
        if (Decimal.ZERO.compareTo(増減額) < 0) {
            reportSource.koseiNaiyo = 更正内容;
            reportSource.kakuteiHokenryoGaku = decimalToRString(増減額);
            reportSource.koseiRiyu = new RString("円の増額です。");
        } else if (0 < Decimal.ZERO.compareTo(増減額)) {
            reportSource.koseiNaiyo = 更正内容;
            reportSource.kakuteiHokenryoGaku = decimalToRString(増減額.multiply(-1));
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
                    if (更正前.get期() == 更正後.get期() && !nullToZero(更正前.get金額()).equals(nullToZero(更正後.get金額()))) {
                        is変更 = true;
                    }
                }
            }

            List<CharacteristicsPhase> 更正前特徴期別金額リスト = 編集後本算定通知書共通情報.get更正前().get特徴期別金額リスト();
            List<CharacteristicsPhase> 更正後特徴期別金額リスト = 編集後本算定通知書共通情報.get更正後().get特徴期別金額リスト();

            for (CharacteristicsPhase 更正前 : 更正前特徴期別金額リスト) {
                for (CharacteristicsPhase 更正後 : 更正後特徴期別金額リスト) {

                    if (更正前.get期() == 更正後.get期() && !nullToZero(更正前.get金額()).equals(nullToZero(更正後.get金額()))) {
                        is変更 = true;
                    }
                }
            }
        }
        return is変更;
    }

    private Decimal nullToZero(Decimal decimal) {
        return decimal == null ? Decimal.ZERO : decimal;
    }

    private void set通知文と通知区分(KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource reportSource,
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報) {
        if (GennenKanen.過年度.equals(item.get本算定決定通知書情報().get現年度_過年度区分())) {

            RStringBuilder tsuchibun2 = new RStringBuilder();
            tsuchibun2.append(編集後本算定通知書共通情報.get賦課年度_年度なし());
            tsuchibun2.append(new RString("以前にさかのぼって資格取得・更正した分"));
            reportSource.tsuchibun2 = tsuchibun2.toRString();
            reportSource.tsuchibun3 = new RString("（過年度）");
        }
    }

    private boolean is特別徴収停止(HonSanteiKetteiTsuchiShoJoho 本算定決定通知書情報) {
        boolean flag = false;
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
            flag = true;
        }

        return !(GennenKanen.過年度.equals(本算定決定通知書情報.get現年度_過年度区分()) || flag);
    }

    private void set調定年度_タイトル_通知文1(KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateReportSource reportSource,
            HonSanteiKetteiTsuchiShoJoho 本算定決定通知書情報) {
        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報
                = 本算定決定通知書情報.get編集後本算定通知書共通情報();
        if (!is特別徴収停止(本算定決定通知書情報)) {
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
            通知文1.append(編集後本算定通知書共通情報.get賦課年度_年度なし());
            通知文1.append(new RString("年度分の介護保険料額を以下のとおり変更しましたので通知します。"));
            reportSource.tsuchibun1 = 通知文1.toRString();
        } else {
            reportSource.choteiNendo = RString.EMPTY;
            reportSource.title1 = 編集後本算定通知書共通情報.get調定年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .fillType(FillType.BLANK).toDateString();
            reportSource.title2 = new RString("介護保険料額変更通知書兼特別徴収中止通知書");
            reportSource.title3 = RString.EMPTY;
            RStringBuilder 通知文1 = new RStringBuilder();
            通知文1.append(編集後本算定通知書共通情報.get賦課年度_年度なし());
            通知文1.append(new RString("年度分の介護保険料額の特別徴収を中止し、以下のとおり普通徴収することとしましたので通知します。"));
            reportSource.tsuchibun1 = 通知文1.toRString();
        }
    }

    private RString decimalToRString(Decimal number) {
        if (number != null) {
            return DecimalFormatter.toコンマ区切りRString(number, 0);
        }
        return RString.EMPTY;
    }

    private RString edit金額(Decimal 金額) {
        if (金額 == null || Decimal.ZERO.compareTo(金額) == 0) {
            return RString.HALF_SPACE;
        } else {
            return DecimalFormatter.toコンマ区切りRString(金額, 0);
        }
    }
}
