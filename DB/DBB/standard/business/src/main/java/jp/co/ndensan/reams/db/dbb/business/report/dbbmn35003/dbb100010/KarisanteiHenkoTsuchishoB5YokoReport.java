/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsuAfterCorrection;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsuBeforeCorrection;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalSignDeliveryInformation;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100010.KarisanteiHenkoTsuchishoB5YokoReportSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 仮算定額変更【B5横タイプ】のReportです。
 *
 * @reamsid_L DBB-0820-050 xuyue
 */
public class KarisanteiHenkoTsuchishoB5YokoReport extends Report<KarisanteiHenkoTsuchishoB5YokoReportSource> {

    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;
    private final RString 文書番号;
    private final NinshoshaSource ninshoshaSource;
    private final CompKaigoToiawasesakiSource kaigoToiawasesakiSource;
    private final List<KarisanteiHenkoTsuchishoB5YokoItem> outputItemList;
    private static final int NUM8 = 8;
    private static final int NUM16 = 16;
    private static final RString 特別徴収 = new RString("特別徴収");
    private static final RString 普通徴収 = new RString("普通徴収");
    private static final RString 年度 = new RString("年度");
    private static final RString 介護保険料仮徴収額変更通知書 = new RString("介護保険料仮徴収額変更通知書");

    /**
     * コンストラクタです。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報Entity
     * @param 文書番号 文書番号
     * @param ninshoshaSource 雛形部品CompNinshosha
     * @param kaigoToiawasesakiSource 雛形部品CompKaigoToiawasesaki
     */
    public KarisanteiHenkoTsuchishoB5YokoReport(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, RString 文書番号,
            NinshoshaSource ninshoshaSource,
            CompKaigoToiawasesakiSource kaigoToiawasesakiSource) {
        this.仮算定納入通知書情報 = 仮算定納入通知書情報;
        this.outputItemList = new ArrayList<>();
        this.文書番号 = 文書番号;
        this.ninshoshaSource = ninshoshaSource;
        this.kaigoToiawasesakiSource = kaigoToiawasesakiSource;
    }

    /**
     * 帳票を出力します。
     *
     * @param reportSourceWriter reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<KarisanteiHenkoTsuchishoB5YokoReportSource> reportSourceWriter) {

        setOutputItemList();
        for (KarisanteiHenkoTsuchishoB5YokoItem target : outputItemList) {
            IKarisanteiHenkoTsuchishoB5YokoEditor hyojiBodyEditor = new KarisanteiHenkoTsuchishoB5YokoEditor(target);
            IKarisanteiHenkoTsuchishoB5YokoBuilder builder = new KarisanteiHenkoTsuchishoB5YokoBuilderImpl(hyojiBodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private void setOutputItemList() {
        KarisanteiHenkoTsuchishoB5YokoItem item;

        EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報 = 仮算定納入通知書情報.get編集後仮算定通知書共通情報();

        List<Kitsuki> 特徴納期情報リスト = 編集後仮算定通知書共通情報.get特徴納期情報リスト();
        List<UniversalSignDeliveryInformation> 普徴納期情報リスト = 編集後仮算定通知書共通情報.get普徴納期情報リスト();

        int 行 = 0;
        if (特徴納期情報リスト != null && !特徴納期情報リスト.isEmpty() && !is普徴のみ(編集後仮算定通知書共通情報)) {
            行 = 特徴納期情報リスト.size();
        }
        if (普徴納期情報リスト != null && 普徴納期情報リスト.size() > 行 && !is特徴のみ(編集後仮算定通知書共通情報)) {
            行 = 普徴納期情報リスト.size();
        }
        if (行 < NUM8) {
            行 = NUM8;
        } else if (行 > NUM8 && 行 < NUM16) {
            行 = NUM16;
        }

        for (int index = 0; index < 行; index++) {
            item = new KarisanteiHenkoTsuchishoB5YokoItem();
            setLineData(index, item, 編集後仮算定通知書共通情報, 特徴納期情報リスト, 普徴納期情報リスト);
            item.setTitle3(介護保険料仮徴収額変更通知書);
            outputItemList.add(item);
        }
    }

    private void setLineData(int index, KarisanteiHenkoTsuchishoB5YokoItem item, EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報,
            List<Kitsuki> 特徴納期情報リスト, List<UniversalSignDeliveryInformation> 普徴納期情報リスト) {

        item.setBunshoNo(文書番号);
        set生年月日と性別と世帯コード(item, 編集後仮算定通知書共通情報);
        item.setHyojicode1(編集後仮算定通知書共通情報.get表示コード1());
        item.setHyojicode2(編集後仮算定通知書共通情報.get表示コード２());
        item.setHyojicode3(編集後仮算定通知書共通情報.get表示コード３());
        item.setHyojicodeName1(編集後仮算定通知書共通情報.get表示コード１名());
        item.setHyojicodeName2(編集後仮算定通知書共通情報.get表示コード２名());
        item.setHyojicodeName3(編集後仮算定通知書共通情報.get表示コード３名());
        item.setTsuchishoNo(編集後仮算定通知書共通情報.get通知書番号() != null ? 編集後仮算定通知書共通情報.get通知書番号().getColumnValue() : RString.EMPTY);

        if (編集後仮算定通知書共通情報.get今後納付すべき額() != null) {
            RString kongoNofuSubekiGaku = DecimalFormatter.toコンマ区切りRString(編集後仮算定通知書共通情報.get今後納付すべき額(), 0);
            item.setKongoNofuSubekiGaku(kongoNofuSubekiGaku);
        }

        Decimal 納付済額_未到来期含む = 編集後仮算定通知書共通情報.get納付済額_未到来期含む() != null ? 編集後仮算定通知書共通情報.get納付済額_未到来期含む() : Decimal.ZERO;
        Decimal 納付済額_未到来期含まない = 編集後仮算定通知書共通情報.get納付済額_未到来期含まない() != null ? 編集後仮算定通知書共通情報.get納付済額_未到来期含まない() : Decimal.ZERO;
        if (編集後仮算定通知書共通情報.get納付済額_未到来期含む() != null && 編集後仮算定通知書共通情報.get納付済額_未到来期含まない() != null) {
            RString mitoraikiNofuzumiGaku = DecimalFormatter.toコンマ区切りRString(納付済額_未到来期含む.subtract(納付済額_未到来期含まない), 0);
            item.setMitoraikiNofuzumiGaku(mitoraikiNofuzumiGaku);
        }

        EditedKariSanteiTsuchiShoKyotsuBeforeCorrection 更正前 = 編集後仮算定通知書共通情報.get更正前();
        if (更正前 == null) {
            更正前 = new EditedKariSanteiTsuchiShoKyotsuBeforeCorrection();
        }
        EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後 = 編集後仮算定通知書共通情報.get更正後();
        if (更正後 == null) {
            更正後 = new EditedKariSanteiTsuchiShoKyotsuAfterCorrection();
        }

        item.setHihokenshaNo(編集後仮算定通知書共通情報.get被保険者番号() != null ? 編集後仮算定通知書共通情報.get被保険者番号().getColumnValue() : RString.EMPTY);
        item.setShikibetsuCode(編集後仮算定通知書共通情報.get識別コード() != null ? 編集後仮算定通知書共通情報.get識別コード().getColumnValue() : RString.EMPTY);

        set期間_自_至(item, 更正前, 更正後);

        if (編集後仮算定通知書共通情報.get調定年度() != null) {
            item.setChoteiNendo(編集後仮算定通知書共通情報.get調定年度().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString().concat(年度));
        }
        if (編集後仮算定通知書共通情報.get編集後口座() != null) {
            item.setBankCode(編集後仮算定通知書共通情報.get編集後口座().get金融機関コードCombinedWith支店コード());
            item.setBankName(編集後仮算定通知書共通情報.get編集後口座().get金融機関名CombinedWith支店名());
            item.setKozaMeigi(編集後仮算定通知書共通情報.get編集後口座().get口座名義人優先());
            item.setKozaNo(編集後仮算定通知書共通情報.get編集後口座().get番号名称());
            item.setKozaShurui(編集後仮算定通知書共通情報.get編集後口座().get口座種別略称());
        }

        item.setHokenryoGakuMae(更正前.get更正前介護保険料仮徴収額合計() != null
                ? DecimalFormatter.toコンマ区切りRString(更正前.get更正前介護保険料仮徴収額合計(), 0) : RString.EMPTY);
        item.setHokenryoGakuAto(更正後.get更正後介護保険料仮徴収額合計() != null
                ? DecimalFormatter.toコンマ区切りRString(更正後.get更正後介護保険料仮徴収額合計(), 0) : RString.EMPTY);

        if (編集後仮算定通知書共通情報.get増減額() != null) {
            RString zogenGaku = DecimalFormatter.toコンマ区切りRString(編集後仮算定通知書共通情報.get増減額(), 0);
            item.setZogenGaku(zogenGaku);
        }

        if (編集後仮算定通知書共通情報.get納付済額_未到来期含む() != null) {
            RString nofuzumiGaku = DecimalFormatter.toコンマ区切りRString(編集後仮算定通知書共通情報.get納付済額_未到来期含む(), 0);
            item.setNofuzumiGaku(nofuzumiGaku);
        }

        item.setKoremadeChoshuho(更正前.get更正前徴収方法());
        item.setKoremadeTokuchoGimusha(更正前.get更正前特別徴収義務者());
        item.setKoremadeTokuchoTaishoNenkin(更正前.get更正前特別徴収対象年金());
        item.setKorekaraChoshuho(更正後.get更正後徴収方法());
        item.setKorekaraTokuchoGimusha(更正後.get更正後特別徴収義務者());
        item.setKorekaraTokuchoTaishoNenkin(更正後.get更正後特別徴収対象年金());
        item.setZanteiHokenryoGaku(更正後.get更正後介護保険料仮徴収額合計() != null ? new RString(更正後.get更正後介護保険料仮徴収額合計().toString()) : RString.EMPTY);
        set調定事由(item, 編集後仮算定通知書共通情報);

        setListKibetsu(index, item, 特徴納期情報リスト, 普徴納期情報リスト, 編集後仮算定通知書共通情報);

        setCompSofubutsuAtesaki(item, 編集後仮算定通知書共通情報);
        setCompNinshosha(item);
        setCompKaigoToiawasesaki(item);
    }

    private void set生年月日と性別と世帯コード(KarisanteiHenkoTsuchishoB5YokoItem item, EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報) {
        EditedKojin 編集後個人 = 編集後仮算定通知書共通情報.get編集後個人();
        item.setBirthYMD(編集後個人 != null ? 編集後個人.get生年月日() : RString.EMPTY);
        item.setSeibetsu(編集後個人 != null ? 編集後個人.get性別() : RString.EMPTY);
        item.setSetaiCode(編集後個人 != null && 編集後個人.get世帯コード() != null ? 編集後個人.get世帯コード().getColumnValue() : RString.EMPTY);
    }

    private void setListKibetsu(int 行, KarisanteiHenkoTsuchishoB5YokoItem item, List<Kitsuki> 特徴納期情報リスト,
            List<UniversalSignDeliveryInformation> 普徴納期情報リスト, EditedKariSanteiTsuchiShoKyotsu 通知書共通情報) {

        EditedKariSanteiTsuchiShoKyotsuBeforeCorrection 更正前 = 通知書共通情報.get更正前();
        if (更正前 == null) {
            更正前 = new EditedKariSanteiTsuchiShoKyotsuBeforeCorrection();
        }
        EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後 = 通知書共通情報.get更正後();
        if (更正後 == null) {
            更正後 = new EditedKariSanteiTsuchiShoKyotsuAfterCorrection();
        }
        if (!is普徴のみ(通知書共通情報)) {
            if (行 <= 2 && 特徴納期情報リスト != null && 特徴納期情報リスト.size() > 行) {
                Kitsuki kitsuki = 特徴納期情報リスト.get(行);
                item.setListKibetsu_1(kitsuki.get期());
                item.setListKibetsu_2(kitsuki.get月().getコード());
            } else {
                item.setListKibetsu_1(RString.EMPTY);
                item.setListKibetsu_2(RString.EMPTY);
            }
            if (行 == 0) {
                item.setListKibetsu_3(更正前.get更正前特徴期別金額01() != null
                        ? DecimalFormatter.toコンマ区切りRString(更正前.get更正前特徴期別金額01(), 0) : RString.EMPTY);
                item.setListKibetsu_4(更正後.get更正後特徴期別金額01() != null
                        ? DecimalFormatter.toコンマ区切りRString(更正後.get更正後特徴期別金額01(), 0) : RString.EMPTY);
            } else if (行 == 1) {
                item.setListKibetsu_3(更正前.get更正前特徴期別金額02() != null
                        ? DecimalFormatter.toコンマ区切りRString(更正前.get更正前特徴期別金額02(), 0) : RString.EMPTY);
                item.setListKibetsu_4(更正後.get更正後特徴期別金額02() != null
                        ? DecimalFormatter.toコンマ区切りRString(更正後.get更正後特徴期別金額02(), 0) : RString.EMPTY);
            } else if (行 == 2) {
                item.setListKibetsu_3(更正前.get更正前特徴期別金額03() != null
                        ? DecimalFormatter.toコンマ区切りRString(更正前.get更正前特徴期別金額03(), 0) : RString.EMPTY);
                item.setListKibetsu_4(更正後.get更正後特徴期別金額03() != null
                        ? DecimalFormatter.toコンマ区切りRString(更正後.get更正後特徴期別金額03(), 0) : RString.EMPTY);
            }
        }
        if (!is特徴のみ(通知書共通情報)) {
            set普徴(行, item, 普徴納期情報リスト, 更正前, 更正後);
        }
    }

    private boolean is普徴のみ(EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報) {
        return !編集後仮算定通知書共通情報.get更正後().get更正後徴収方法().contains(特別徴収);
    }

    private boolean is特徴のみ(EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報) {
        return !編集後仮算定通知書共通情報.get更正後().get更正後徴収方法().contains(普通徴収);
    }

    private void set普徴(int 行, KarisanteiHenkoTsuchishoB5YokoItem item, List<UniversalSignDeliveryInformation> 普徴納期情報リスト,
            EditedKariSanteiTsuchiShoKyotsuBeforeCorrection 更正前, EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後) {
        RString 期別 = RString.EMPTY;
        if (普徴納期情報リスト != null && 普徴納期情報リスト.size() > 行 && 普徴納期情報リスト.get(行) != null && 普徴納期情報リスト.get(行).get期月() != null) {
            期別 = 普徴納期情報リスト.get(行).get期月().get期();
            item.setListKibetsu_5(普徴納期情報リスト.get(行).get期月().get期());
            item.setListKibetsu_6(普徴納期情報リスト.get(行).get期月().get月() != null ? 普徴納期情報リスト.get(行).get期月().get月().getコード() : RString.EMPTY);
        }

        Decimal 更正前期別金額 = null;
        Decimal 更正後期別金額 = null;
        List<UniversalPhase> 更正前普徴期別金額リスト = 更正前.get更正前普徴期別金額リスト();
        if (更正前普徴期別金額リスト == null) {
            更正前普徴期別金額リスト = new ArrayList<>();
        }
        List<UniversalPhase> 更正後普徴期別金額リスト = 更正後.get更正後普徴期別金額リスト();
        if (更正後普徴期別金額リスト == null) {
            更正後普徴期別金額リスト = new ArrayList<>();
        }
        for (UniversalPhase 期別金額 : 更正前普徴期別金額リスト) {
            if (new RString(期別金額.get期()).padZeroToLeft(2).equals(期別.padZeroToLeft(2))) {
                更正前期別金額 = 期別金額.get金額();
            }
        }
        for (UniversalPhase 期別金額 : 更正後普徴期別金額リスト) {
            if (new RString(期別金額.get期()).padZeroToLeft(2).equals(期別.padZeroToLeft(2))) {
                更正後期別金額 = 期別金額.get金額();
            }
        }
        set更正前と更正後の期別金額(item, 更正前期別金額, 更正後期別金額);
    }

    private void set更正前と更正後の期別金額(KarisanteiHenkoTsuchishoB5YokoItem item, Decimal 更正前期別金額, Decimal 更正後期別金額) {
        if ((更正前期別金額 == null || Decimal.ZERO.equals(更正前期別金額)) && (更正後期別金額 == null || Decimal.ZERO.equals(更正後期別金額))) {
            item.setListKibetsu_7(RString.EMPTY);
            item.setListKibetsu_8(RString.EMPTY);
        } else if ((更正前期別金額 == null || Decimal.ZERO.equals(更正前期別金額)) && (更正後期別金額 != null && !Decimal.ZERO.equals(更正後期別金額))) {
            item.setListKibetsu_7(new RString("0"));

            RString 更正後期別金額RStr = DecimalFormatter.toコンマ区切りRString(更正後期別金額, 0);
            item.setListKibetsu_8(更正後期別金額RStr);
        } else if ((更正前期別金額 != null && !Decimal.ZERO.equals(更正前期別金額)) && (更正後期別金額 == null || Decimal.ZERO.equals(更正後期別金額))) {

            RString 更正前期別金額RStr = DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0);
            item.setListKibetsu_7(更正前期別金額RStr);
            item.setListKibetsu_8(new RString("0"));
        } else if (更正前期別金額 != null && !Decimal.ZERO.equals(更正前期別金額) && 更正後期別金額 != null && !Decimal.ZERO.equals(更正後期別金額)) {
            RString 更正前期別金額RStr = DecimalFormatter.toコンマ区切りRString(更正前期別金額, 0);
            item.setListKibetsu_7(更正前期別金額RStr);

            RString 更正後期別金額RStr = DecimalFormatter.toコンマ区切りRString(更正後期別金額, 0);
            item.setListKibetsu_8(更正後期別金額RStr);
        }
    }

    private void set調定事由(KarisanteiHenkoTsuchishoB5YokoItem item, EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報) {
        item.setChoteiJiyu1(編集後仮算定通知書共通情報.get調定事由１() == null ? RString.EMPTY : 編集後仮算定通知書共通情報.get調定事由１());
        item.setChoteiJiyu2(編集後仮算定通知書共通情報.get調定事由２() == null ? RString.EMPTY : 編集後仮算定通知書共通情報.get調定事由２());
        item.setChoteiJiyu3(編集後仮算定通知書共通情報.get調定事由３() == null ? RString.EMPTY : 編集後仮算定通知書共通情報.get調定事由３());
        item.setChoteiJiyu4(編集後仮算定通知書共通情報.get調定事由４() == null ? RString.EMPTY : 編集後仮算定通知書共通情報.get調定事由４());
    }

    private void set期間_自_至(KarisanteiHenkoTsuchishoB5YokoItem item,
            EditedKariSanteiTsuchiShoKyotsuBeforeCorrection 更正前, EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後) {

        if (更正前.get期間_自() != null) {
            item.setShutokuYmdMae(更正前.get期間_自());
        }
        if (更正後.get期間_自() != null) {
            item.setShutokuYmdAto(更正後.get期間_自());
        }
        if (更正前.get期間_至() != null) {
            item.setSoshitsuYmdMae(更正前.get期間_至());
        }
        if (更正後.get期間_至() != null) {
            item.setSoshitsuYmdAto(更正後.get期間_至());
        }
    }

    private void setCompSofubutsuAtesaki(KarisanteiHenkoTsuchishoB5YokoItem item, EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報) {
        SofubutsuAtesakiSource sofubutsuAtesakiSource;
        try {
            sofubutsuAtesakiSource = 編集後仮算定通知書共通情報.get編集後宛先().getSofubutsuAtesakiSource().get送付物宛先ソース();
        } catch (Exception e) {
            sofubutsuAtesakiSource = new SofubutsuAtesakiSource();
        }

        item.setCustomerBarCode(sofubutsuAtesakiSource.customerBarCode);
        item.setYubinNo1(sofubutsuAtesakiSource.yubinNo);
        item.setGyoseiku1(sofubutsuAtesakiSource.gyoseiku);
        item.setJusho1(sofubutsuAtesakiSource.jusho1);
        item.setJusho2(sofubutsuAtesakiSource.jusho2);
        item.setJusho3(sofubutsuAtesakiSource.jusho3);
        item.setJushoText(sofubutsuAtesakiSource.jushoText);
        item.setKatagaki1(sofubutsuAtesakiSource.katagaki1);
        item.setKatagaki2(sofubutsuAtesakiSource.katagaki2);
        item.setKatagakiSmall1(sofubutsuAtesakiSource.katagakiSmall1);
        item.setKatagakiSmall2(sofubutsuAtesakiSource.katagakiSmall2);
        item.setKatagakiText(sofubutsuAtesakiSource.katagakiText);
        item.setShimei1(sofubutsuAtesakiSource.shimei1);
        item.setShimei2(sofubutsuAtesakiSource.shimei2);
        item.setShimeiSmall1(sofubutsuAtesakiSource.samabunShimei1);
        item.setShimeiSmall2(sofubutsuAtesakiSource.samabunShimei2);
        item.setShimeiText(sofubutsuAtesakiSource.shimeiText);
        item.setMeishoFuyo1(sofubutsuAtesakiSource.meishoFuyo1);
        item.setMeishoFuyo2(sofubutsuAtesakiSource.meishoFuyo2);
        item.setDainoKubunMei(sofubutsuAtesakiSource.dainoKubunMei);
        item.setSamaBun1(sofubutsuAtesakiSource.samaBun1);
        item.setSamaBun2(sofubutsuAtesakiSource.samaBun2);
        item.setSamabunShimei1(sofubutsuAtesakiSource.samabunShimei1);
        item.setSamabunShimei2(sofubutsuAtesakiSource.samabunShimei2);
        item.setSamabunShimeiSmall1(sofubutsuAtesakiSource.samabunShimeiSmall1);
        item.setSamabunShimeiSmall2(sofubutsuAtesakiSource.samabunShimeiSmall2);
        item.setSamabunShimeiText(sofubutsuAtesakiSource.samabunShimeiText);
        item.setKakkoLeft1(sofubutsuAtesakiSource.kakkoLeft1);
        item.setKakkoLeft2(sofubutsuAtesakiSource.kakkoLeft2);
        item.setKakkoRight1(sofubutsuAtesakiSource.kakkoRight1);
        item.setKakkoRight2(sofubutsuAtesakiSource.kakkoRight2);
        item.setSetainusimei(RString.EMPTY);
        item.setSamaKata(RString.EMPTY);
    }

    private void setCompNinshosha(KarisanteiHenkoTsuchishoB5YokoItem item) {
        item.setDenshiKoin(ninshoshaSource.denshiKoin);
        item.setHakkoYMD(ninshoshaSource.hakkoYMD);
        item.setKoinMojiretsu(ninshoshaSource.koinMojiretsu);
        item.setKoinShoryaku(ninshoshaSource.koinShoryaku);
        item.setNinshoshaShimeiKakenai(ninshoshaSource.ninshoshaShimeiKakenai);
        item.setNinshoshaShimeiKakeru(ninshoshaSource.ninshoshaShimeiKakeru);
        item.setNinshoshaYakushokuMei(ninshoshaSource.ninshoshaYakushokuMei);
    }

    private void setCompKaigoToiawasesaki(KarisanteiHenkoTsuchishoB5YokoItem item) {
        item.setChoshaBushoName(kaigoToiawasesakiSource.choshaBushoName);
        item.setNaisenLabel(kaigoToiawasesakiSource.naisenLabel);
        item.setNaisenNo(kaigoToiawasesakiSource.naisenNo);
        item.setShozaichi(kaigoToiawasesakiSource.shozaichi);
        item.setTantoName(kaigoToiawasesakiSource.tantoName);
        item.setTelNo(kaigoToiawasesakiSource.telNo);
        item.setYubinBango(kaigoToiawasesakiSource.yubinBango);
    }
}
