/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100013;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsuAfterCorrection;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsuBeforeCorrection;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalSignDeliveryInformation;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100013.KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.ur.urz.business.core.kingaku.IKingakuFormatter;
import jp.co.ndensan.reams.ur.urz.business.core.kingaku.KingakuFormatter;
import jp.co.ndensan.reams.ur.urz.definition.core.kingaku.KingakuUnit;
import jp.co.ndensan.reams.ur.urz.definition.core.kingaku.Sign;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特別徴収平準化【A4縦タイプ】のReportです。
 *
 * @reamsid_L DBB-0820-050 xuyue
 */
public class KarisanteiHenjunkaHenkoTsuchishoA4TateReport extends Report<KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource> {

    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;
    private final RString 文書番号;
    private final NinshoshaSource ninshoshaSource;
    private final CompKaigoToiawasesakiSource kaigoToiawasesakiSource;
    private final List<KarisanteiHenjunkaHenkoTsuchishoA4TateItem> outputItemList;
    private static final int NUM3 = 3;
    private static final int NUM4 = 4;
    private static final int NUM8 = 8;
    private static final int NUM12 = 12;
    private static final int NUM16 = 16;

    /**
     * コンストラクタです。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報Entity
     * @param 文書番号 文書番号
     * @param ninshoshaSource 雛形部品CompNinshosha
     * @param kaigoToiawasesakiSource 雛形部品CompKaigoToiawasesaki
     */
    public KarisanteiHenjunkaHenkoTsuchishoA4TateReport(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報,
            RString 文書番号, NinshoshaSource ninshoshaSource,
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
    public void writeBy(ReportSourceWriter<KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource> reportSourceWriter) {

        setOutputItemList();
        for (KarisanteiHenjunkaHenkoTsuchishoA4TateItem target : outputItemList) {
            IKarisanteiHenjunkaHenkoTsuchishoA4TateEditor hyojiBodyEditor = new KarisanteiHenjunkaHenkoTsuchishoA4TateEditor(target);
            IKarisanteiHenjunkaHenkoTsuchishoA4TateBuilder builder = new KarisanteiHenjunkaHenkoTsuchishoA4TateBuiderImpl(hyojiBodyEditor);
            reportSourceWriter.writeLine(builder);

        }
    }

    private void setOutputItemList() {

        KarisanteiHenjunkaHenkoTsuchishoA4TateItem item;

        EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報 = 仮算定納入通知書情報.get編集後仮算定通知書共通情報();

        List<Kitsuki> 特徴納期情報リスト = 編集後仮算定通知書共通情報.get特徴納期情報リスト();
        List<UniversalSignDeliveryInformation> 普徴納期情報リスト = 編集後仮算定通知書共通情報.get普徴納期情報リスト();

        int 行 = 1;
        if (特徴納期情報リスト != null && !特徴納期情報リスト.isEmpty()) {
            行 = 特徴納期情報リスト.size();
        }
        if (行 > NUM3) {
            行 = NUM3;
        }
        if (普徴納期情報リスト != null && 普徴納期情報リスト.size() > 行) {
            行 = 普徴納期情報リスト.size();
        }
        if (行 < NUM4) {
            行 = NUM4;
        } else if (行 > NUM4 && 行 < NUM8) {
            行 = NUM8;
        } else if (行 > NUM8 && 行 < NUM12) {
            行 = NUM12;
        } else if (行 > NUM12 && 行 < NUM16) {
            行 = NUM16;
        }

        for (int index = 0; index < 行; index++) {
            item = new KarisanteiHenjunkaHenkoTsuchishoA4TateItem();
            setLineData(index, item, 編集後仮算定通知書共通情報, 特徴納期情報リスト, 普徴納期情報リスト);
            outputItemList.add(item);
        }
    }

    private void setLineData(int index, KarisanteiHenjunkaHenkoTsuchishoA4TateItem item, EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報,
            List<Kitsuki> 特徴納期情報リスト, List<UniversalSignDeliveryInformation> 普徴納期情報リスト) {
        EditedKojin 編集後個人 = 編集後仮算定通知書共通情報.get編集後個人();

        item.setBunshoNo(文書番号);
        if (編集後仮算定通知書共通情報.get調定年度() != null) {
            item.setChoteiNendo(編集後仮算定通知書共通情報.get調定年度().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString());
        }

        EditedKariSanteiTsuchiShoKyotsuBeforeCorrection 更正前 = 編集後仮算定通知書共通情報.get更正前();
        if (更正前 == null) {
            更正前 = new EditedKariSanteiTsuchiShoKyotsuBeforeCorrection();
        }
        EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後 = 編集後仮算定通知書共通情報.get更正後();
        if (更正後 == null) {
            更正後 = new EditedKariSanteiTsuchiShoKyotsuAfterCorrection();
        }

        item.setHyojicode1(編集後仮算定通知書共通情報.get表示コード1());
        item.setHyojicode2(編集後仮算定通知書共通情報.get表示コード２());
        item.setHyojicode3(編集後仮算定通知書共通情報.get表示コード３());
        item.setHyojicodeName1(編集後仮算定通知書共通情報.get表示コード１名());
        item.setHyojicodeName2(編集後仮算定通知書共通情報.get表示コード２名());
        item.setHyojicodeName3(編集後仮算定通知書共通情報.get表示コード３名());
        item.setSetaiCode(編集後個人 != null && 編集後個人.get世帯コード() != null ? 編集後個人.get世帯コード().getColumnValue() : RString.EMPTY);
        item.setTsuchishoNo(編集後仮算定通知書共通情報.get通知書番号() != null ? 編集後仮算定通知書共通情報.get通知書番号().getColumnValue() : RString.EMPTY);
        item.setZanteiHokenryoGaku(更正後.get更正後介護保険料仮徴収額合計() != null ? new RString(更正後.get更正後介護保険料仮徴収額合計().toString()) : RString.EMPTY);
        item.setHihokenshaNo(編集後仮算定通知書共通情報.get被保険者番号() != null ? 編集後仮算定通知書共通情報.get被保険者番号().getColumnValue() : RString.EMPTY);
        item.setShikibetsuCode(編集後仮算定通知書共通情報.get識別コード() != null ? 編集後仮算定通知書共通情報.get識別コード().getColumnValue() : RString.EMPTY);

        set期間_自_至(item, 更正前, 更正後);
        item.setHokenryoGakuMae(更正前.get更正前介護保険料仮徴収額合計() != null ? new RString(更正前.get更正前介護保険料仮徴収額合計().toString()) : RString.EMPTY);
        item.setHokenryoGakuAto(更正後.get更正後介護保険料仮徴収額合計() != null ? new RString(更正後.get更正後介護保険料仮徴収額合計().toString()) : RString.EMPTY);

        if (編集後仮算定通知書共通情報.get増減額() != null) {
            IKingakuFormatter 増減額formatter = KingakuFormatter.create(編集後仮算定通知書共通情報.get増減額());
            RString zogenGaku = new RString(増減額formatter.format(KingakuUnit.円).setSignPattern(Sign.マイナス記号使用).setCommaSeparated().toString());
            item.setZogenGaku(zogenGaku);
        }

        item.setKoseigoHokenryoGaku(更正後.get更正後介護保険料仮徴収額合計() != null ? new RString(更正後.get更正後介護保険料仮徴収額合計().toString()) : RString.EMPTY);

        if (編集後仮算定通知書共通情報.get納付済額_未到来期含む() != null) {
            IKingakuFormatter 納付済額formatter = KingakuFormatter.create(編集後仮算定通知書共通情報.get納付済額_未到来期含む());
            RString nofuzumiGaku = new RString(納付済額formatter.format(KingakuUnit.円).setCommaSeparated().toString());
            item.setNofuzumiGaku(nofuzumiGaku);
        }

        if (編集後仮算定通知書共通情報.get今後納付すべき額_収入元に() != null) {
            IKingakuFormatter 今後納付すべき額formatter = KingakuFormatter.create(編集後仮算定通知書共通情報.get今後納付すべき額_収入元に());
            RString kongoNofuSubekiGaku = new RString(今後納付すべき額formatter.format(KingakuUnit.円).setCommaSeparated().toString());
            item.setKongoNofuSubekiGaku(kongoNofuSubekiGaku);
        }

        if (編集後仮算定通知書共通情報.get今後納付すべき額_調定元に() != null) {
            IKingakuFormatter 今後納付すべき額formatter = KingakuFormatter.create(編集後仮算定通知書共通情報.get今後納付すべき額_調定元に());
            RString kongoNofuSubekiGakuChotei = new RString(今後納付すべき額formatter.format(KingakuUnit.円).setCommaSeparated().toString());
            item.setKongoNofuSubekiGakuChotei(kongoNofuSubekiGakuChotei);
        }

        if (編集後仮算定通知書共通情報.get既に納付すべき額() != null) {
            IKingakuFormatter 既に納付すべき額formatter = KingakuFormatter.create(編集後仮算定通知書共通情報.get既に納付すべき額());
            RString nofuSubekiGaku = new RString(既に納付すべき額formatter.format(KingakuUnit.円).setCommaSeparated().toString());
            item.setNofuSubekiGaku(nofuSubekiGaku);
        }

        item.setKorekaraChoshuho(更正後.get更正後徴収方法());
        setListKibetsu(index, item, 特徴納期情報リスト, 普徴納期情報リスト, 編集後仮算定通知書共通情報);
        setLineData2(item, 編集後仮算定通知書共通情報, 更正後);
    }

    private void setLineData2(KarisanteiHenjunkaHenkoTsuchishoA4TateItem item,
            EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報, EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後) {

        if (編集後仮算定通知書共通情報.get編集後口座() != null) {
            item.setBankCode(編集後仮算定通知書共通情報.get編集後口座().get金融機関コードCombinedWith支店コード());

            if (編集後仮算定通知書共通情報.get編集後口座().isゆうちょ銀行()) {
                item.setBankName(RString.EMPTY);
                item.setKozaShurui(RString.EMPTY);
            } else if (!RString.isNullOrEmpty(編集後仮算定通知書共通情報.get編集後口座().get金融機関コード())
                    && !RString.isNullOrEmpty(編集後仮算定通知書共通情報.get編集後口座().get支店コード())) {
                item.setBankName(編集後仮算定通知書共通情報.get編集後口座().get金融機関名CombinedWith支店名());
                item.setKozaShurui(編集後仮算定通知書共通情報.get編集後口座().get口座種別略称());
            } else {
                item.setBankName(RString.EMPTY);
                item.setKozaShurui(RString.EMPTY);
            }
            item.setKozaNo(編集後仮算定通知書共通情報.get編集後口座().get番号名称());
            item.setKozaMeigi(編集後仮算定通知書共通情報.get編集後口座().get口座名義人優先());
        }

        item.setKorekaraTokuchoGimusha(更正後.get更正後特別徴収義務者());
        item.setKorekaraTokuchoTaishoNenkin(更正後.get更正後特別徴収対象年金());
        set調定事由(item, 編集後仮算定通知書共通情報);

        setCompSofubutsuAtesaki(item, 編集後仮算定通知書共通情報);
        setCompNinshosha(item);
        setCompKaigoToiawasesaki(item);
    }

    private void set期間_自_至(KarisanteiHenjunkaHenkoTsuchishoA4TateItem item,
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

    private void setListKibetsu(int 行, KarisanteiHenjunkaHenkoTsuchishoA4TateItem item, List<Kitsuki> 特徴納期情報リスト,
            List<UniversalSignDeliveryInformation> 普徴納期情報リスト, EditedKariSanteiTsuchiShoKyotsu 通知書共通情報) {
        EditedKariSanteiTsuchiShoKyotsuBeforeCorrection 更正前 = 通知書共通情報.get更正前();
        if (更正前 == null) {
            更正前 = new EditedKariSanteiTsuchiShoKyotsuBeforeCorrection();
        }
        EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後 = 通知書共通情報.get更正後();
        if (更正後 == null) {
            更正後 = new EditedKariSanteiTsuchiShoKyotsuAfterCorrection();
        }

        if (行 <= 2 && 特徴納期情報リスト != null && 特徴納期情報リスト.size() > 行) {
            Kitsuki kitsuki = 特徴納期情報リスト.get(行);
            item.setListKibetsu_6(kitsuki.get期());
            item.setListKibetsu_7(kitsuki.get月().getコード());
        } else {
            item.setListKibetsu_6(RString.EMPTY);
            item.setListKibetsu_7(RString.EMPTY);
        }
        if (行 == 0) {
            item.setListKibetsu_8(更正前.get更正前特徴期別金額01() != null ? new RString(更正前.get更正前特徴期別金額01().toString()) : RString.EMPTY);
            item.setListKibetsu_9(更正後.get更正後特徴期別金額01() != null ? new RString(更正後.get更正後特徴期別金額01().toString()) : RString.EMPTY);
        } else if (行 == 1) {
            item.setListKibetsu_8(更正前.get更正前特徴期別金額02() != null ? new RString(更正前.get更正前特徴期別金額02().toString()) : RString.EMPTY);
            item.setListKibetsu_9(更正後.get更正後特徴期別金額02() != null ? new RString(更正後.get更正後特徴期別金額02().toString()) : RString.EMPTY);
        } else if (行 == 2) {
            item.setListKibetsu_8(更正前.get更正前特徴期別金額03() != null ? new RString(更正前.get更正前特徴期別金額03().toString()) : RString.EMPTY);
            item.setListKibetsu_9(更正後.get更正後特徴期別金額03() != null ? new RString(更正後.get更正後特徴期別金額03().toString()) : RString.EMPTY);
        }

        set普徴(行, item, 普徴納期情報リスト, 更正前, 更正後);
    }

    private void set普徴(int 行, KarisanteiHenjunkaHenkoTsuchishoA4TateItem item, List<UniversalSignDeliveryInformation> 普徴納期情報リスト,
            EditedKariSanteiTsuchiShoKyotsuBeforeCorrection 更正前, EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後) {
        RString 期別 = RString.EMPTY;
        if (普徴納期情報リスト != null && 普徴納期情報リスト.size() > 行 && 普徴納期情報リスト.get(行) != null && 普徴納期情報リスト.get(行).get期月() != null) {
            期別 = 普徴納期情報リスト.get(行).get期月().get期();
            item.setListKibetsu_3(普徴納期情報リスト.get(行).get納期限());
            item.setListKibetsu_1(普徴納期情報リスト.get(行).get期月().get期());
            item.setListKibetsu_2(普徴納期情報リスト.get(行).get期月().get月() != null ? 普徴納期情報リスト.get(行).get期月().get月().getコード() : RString.EMPTY);
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

    private void set更正前と更正後の期別金額(KarisanteiHenjunkaHenkoTsuchishoA4TateItem item, Decimal 更正前期別金額, Decimal 更正後期別金額) {
        if ((更正前期別金額 == null || Decimal.ZERO.equals(更正前期別金額)) && (更正後期別金額 == null || Decimal.ZERO.equals(更正後期別金額))) {
            item.setListKibetsu_4(RString.EMPTY);
            item.setListKibetsu_5(RString.EMPTY);
        } else if ((更正前期別金額 == null || Decimal.ZERO.equals(更正前期別金額)) && (更正後期別金額 != null && !Decimal.ZERO.equals(更正後期別金額))) {
            item.setListKibetsu_4(new RString("0"));

            IKingakuFormatter 更正後期別金額formatter = KingakuFormatter.create(更正後期別金額);
            RString 更正後期別金額RStr = new RString(更正後期別金額formatter.format(KingakuUnit.円).setCommaSeparated().toString());
            item.setListKibetsu_5(更正後期別金額RStr);
        } else if ((更正前期別金額 != null && !Decimal.ZERO.equals(更正前期別金額)) && (更正後期別金額 == null || Decimal.ZERO.equals(更正後期別金額))) {

            IKingakuFormatter 更正前期別金額formatter = KingakuFormatter.create(更正前期別金額);
            RString 更正前期別金額RStr = new RString(更正前期別金額formatter.format(KingakuUnit.円).setCommaSeparated().toString());
            item.setListKibetsu_4(更正前期別金額RStr);
            item.setListKibetsu_5(new RString("0"));
        } else if (更正前期別金額 != null && !Decimal.ZERO.equals(更正前期別金額) && 更正後期別金額 != null && !Decimal.ZERO.equals(更正後期別金額)) {
            IKingakuFormatter 更正前期別金額formatter = KingakuFormatter.create(更正前期別金額);
            RString 更正前期別金額RStr = new RString(更正前期別金額formatter.format(KingakuUnit.円).setCommaSeparated().toString());
            item.setListKibetsu_4(更正前期別金額RStr);

            IKingakuFormatter 更正後期別金額formatter = KingakuFormatter.create(更正後期別金額);
            RString 更正後期別金額RStr = new RString(更正後期別金額formatter.format(KingakuUnit.円).setCommaSeparated().toString());
            item.setListKibetsu_5(更正後期別金額RStr);
        }
    }

    private void set調定事由(KarisanteiHenjunkaHenkoTsuchishoA4TateItem item, EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報) {
        item.setChoteiJiyu1(編集後仮算定通知書共通情報.get調定事由１() == null ? RString.EMPTY : 編集後仮算定通知書共通情報.get調定事由１());
        item.setChoteiJiyu2(編集後仮算定通知書共通情報.get調定事由２() == null ? RString.EMPTY : 編集後仮算定通知書共通情報.get調定事由２());
        item.setChoteiJiyu3(編集後仮算定通知書共通情報.get調定事由３() == null ? RString.EMPTY : 編集後仮算定通知書共通情報.get調定事由３());
        item.setChoteiJiyu4(編集後仮算定通知書共通情報.get調定事由４() == null ? RString.EMPTY : 編集後仮算定通知書共通情報.get調定事由４());
    }

    private void setCompSofubutsuAtesaki(KarisanteiHenjunkaHenkoTsuchishoA4TateItem item, EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報) {
        SofubutsuAtesakiSource sofubutsuAtesakiSource;
        try {
            sofubutsuAtesakiSource = 編集後仮算定通知書共通情報.get編集後宛先().getSofubutsuAtesakiSource().get送付物宛先ソース();
        } catch (Exception e) {
            sofubutsuAtesakiSource = new SofubutsuAtesakiSource();
        }

        item.setCustomerBarCode(sofubutsuAtesakiSource.customerBarCode);
        item.setDainoKubunMei(sofubutsuAtesakiSource.dainoKubunMei);
        item.setGyoseiku1(sofubutsuAtesakiSource.gyoseiku);
        item.setJusho1(sofubutsuAtesakiSource.jusho1);
        item.setJusho2(sofubutsuAtesakiSource.jusho2);
        item.setJusho3(sofubutsuAtesakiSource.jusho3);
        item.setJushoText(sofubutsuAtesakiSource.jushoText);
        item.setKakkoLeft1(sofubutsuAtesakiSource.kakkoLeft1);
        item.setKakkoLeft2(sofubutsuAtesakiSource.kakkoLeft2);
        item.setKakkoRight1(sofubutsuAtesakiSource.kakkoRight1);
        item.setKakkoRight2(sofubutsuAtesakiSource.kakkoRight2);
        item.setKatagaki1(sofubutsuAtesakiSource.katagaki1);
        item.setKatagaki2(sofubutsuAtesakiSource.katagaki2);
        item.setKatagakiSmall1(sofubutsuAtesakiSource.katagakiSmall1);
        item.setKatagakiSmall2(sofubutsuAtesakiSource.katagakiSmall2);
        item.setKatagakiText(sofubutsuAtesakiSource.katagakiText);
        item.setMeishoFuyo1(sofubutsuAtesakiSource.meishoFuyo1);
        item.setMeishoFuyo2(sofubutsuAtesakiSource.meishoFuyo2);
        item.setSamaBun1(sofubutsuAtesakiSource.samaBun1);
        item.setSamaBun2(sofubutsuAtesakiSource.samaBun2);
        item.setSamabunShimei1(sofubutsuAtesakiSource.samabunShimei1);
        item.setSamabunShimei2(sofubutsuAtesakiSource.samabunShimei2);
        item.setSamabunShimeiSmall1(sofubutsuAtesakiSource.samabunShimeiSmall1);
        item.setSamabunShimeiSmall2(sofubutsuAtesakiSource.samabunShimeiSmall2);
        item.setSamabunShimeiText(sofubutsuAtesakiSource.samabunShimeiText);
        item.setShimei1(sofubutsuAtesakiSource.shimei1);
        item.setShimei2(sofubutsuAtesakiSource.shimei2);
        item.setShimeiSmall1(sofubutsuAtesakiSource.samabunShimei1);
        item.setShimeiSmall2(sofubutsuAtesakiSource.samabunShimei2);
        item.setShimeiText(sofubutsuAtesakiSource.shimeiText);
        item.setYubinNo1(sofubutsuAtesakiSource.yubinNo);
        item.setSetainusimei(RString.EMPTY);
        item.setSamaKata(RString.EMPTY);
    }

    private void setCompNinshosha(KarisanteiHenjunkaHenkoTsuchishoA4TateItem item) {
        item.setDenshiKoin(ninshoshaSource.denshiKoin);
        item.setHakkoYMD(ninshoshaSource.hakkoYMD);
        item.setKoinMojiretsu(ninshoshaSource.koinMojiretsu);
        item.setKoinShoryaku(ninshoshaSource.koinShoryaku);
        item.setNinshoshaShimeiKakenai(ninshoshaSource.ninshoshaShimeiKakenai);
        item.setNinshoshaShimeiKakeru(ninshoshaSource.ninshoshaShimeiKakeru);
        item.setNinshoshaYakushokuMei(ninshoshaSource.ninshoshaYakushokuMei);
    }

    private void setCompKaigoToiawasesaki(KarisanteiHenjunkaHenkoTsuchishoA4TateItem item) {
        item.setChoshaBushoName(kaigoToiawasesakiSource.choshaBushoName);
        item.setNaisenLabel(kaigoToiawasesakiSource.naisenLabel);
        item.setNaisenNo(kaigoToiawasesakiSource.naisenNo);
        item.setShozaichi(kaigoToiawasesakiSource.shozaichi);
        item.setTantoName(kaigoToiawasesakiSource.tantoName);
        item.setTelNo(kaigoToiawasesakiSource.telNo);
        item.setYubinBango(kaigoToiawasesakiSource.yubinBango);
    }

}
