/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.khcktb5yoko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.choshuyuyo.KibetsuChoshyuYuyoKikan;
import jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko.ChoshuYuyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateProperty;
import jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateReport;
import jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoReport;
import jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoItem;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource;
import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HyojiCodeResearcher;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.fucho.FuchokiJohoTsukiShoriKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.ur.urz.business.core.date.DateEditor;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護保険料徴収猶予決定通知書帳票PrintServiceです。
 *
 * @reamsid_L DBB-0740-040 sunhui
 */
public class KaigoHokenryoChoshuyuyoKetteiTsuchishoPrintService {

    private static final int ONE = 1;
    private static final int ZERO = 0;
    private static final int TEN = 10;
    private static final int END_NUMBER = 15;
    private static final RString RSTR_0 = new RString("　");
    private static final RString 期_1 = new RString("01");
    private static final RString 期_2 = new RString("02");
    private static final RString 期_3 = new RString("03");
    private static final RString 期_4 = new RString("04");
    private static final RString 期_5 = new RString("05");
    private static final RString 普徴期_4 = new RString("4");
    private static final RString 普徴期_5 = new RString("5");
    private static final RString 普徴期_6 = new RString("6");
    private static final RString 普徴期_7 = new RString("7");
    private static final RString 普徴期_8 = new RString("8");
    private static final RString 普徴期_9 = new RString("9");
    private static final RString 普徴期_10 = new RString("10");
    private static final RString 普徴期_11 = new RString("11");
    private static final RString 普徴期_12 = new RString("12");
    private static final RString 普徴期_1 = new RString("1");
    private static final RString 普徴期_2 = new RString("2");
    private static final RString 普徴期_3 = new RString("3");
    private static final RString 普徴期翌年度_4 = new RString("13");
    private static final RString 随時 = new RString("随時");
    private static final RString 波線 = new RString("～");
    private static final RString 種別コード = new RString("DBB100081_KaigoHokenHokenryoChoshuyoyoKetteiTsuchishoDaihyo");

    @BatchWriter
    private BatchReportWriter<KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource> batchWrite;
    private ReportSourceWriter<KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource> reportSourceWriter;

    /**
     * printメソッド
     *
     * @param 発行日 発行日
     * @param 文書番号 文書番号
     * @param 徴収猶予決定通知書情報 徴収猶予決定通知書情報
     * @param 通知書定型文 通知書定型文
     * @param 介護問合せ先ソースビルダー 介護問合せ先ソースビルダー
     * @return SourceDataCollection
     */
    public SourceDataCollection printB5横タイプ(RDate 発行日, RString 文書番号,
            KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー) {

        KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoProperty property
                = new KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoProperty();
        List<KaigoHokenryoChoshuyuyoKetteiTsuchishoItem> targets = setItems(
                発行日, 文書番号, 徴収猶予決定通知書情報, 通知書定型文, 介護問合せ先ソースビルダー);
        return new Printer<KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource>().spool(property, toReportsB5横タイプ(targets));

    }

    /**
     * toReportsメソッド
     *
     * @param targets List<KaigoHokenryoChoshuyuyoKetteiTsuchishoItem>
     * @return List<KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoReport>
     */
    private static List<KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoReport>
            toReportsB5横タイプ(List<KaigoHokenryoChoshuyuyoKetteiTsuchishoItem> targets) {
        List<KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoReport> list = new ArrayList<>();
        list.add(KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoReport.createForm(targets));
        return list;
    }

    /**
     * printメソッド
     *
     * @param 発行日 発行日
     * @param 文書番号 文書番号
     * @param 徴収猶予決定通知書情報 徴収猶予決定通知書情報
     * @param 通知書定型文 通知書定型文
     * @param 介護問合せ先ソースビルダー 介護問合せ先ソースビルダー
     * @return SourceDataCollection
     */
    public SourceDataCollection printA4縦タイプ(RDate 発行日, RString 文書番号,
            KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー) {

        KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateProperty property
                = new KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateProperty();
        List<KaigoHokenryoChoshuyuyoKetteiTsuchishoItem> targets = setItems(
                発行日, 文書番号, 徴収猶予決定通知書情報, 通知書定型文, 介護問合せ先ソースビルダー);
        return new Printer<KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource>().spool(property, toReportsA4縦タイプ(targets));

    }

    /**
     * toReportsメソッド
     *
     * @param targets List<KaigoHokenryoChoshuyuyoKetteiTsuchishoItem>
     * @return List<KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateReport>
     */
    private static List<KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateReport>
            toReportsA4縦タイプ(List<KaigoHokenryoChoshuyuyoKetteiTsuchishoItem> targets) {
        List<KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateReport> list = new ArrayList<>();
        list.add(KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateReport.createForm(targets));
        return list;
    }

    /**
     * setItemsメソッド
     *
     * @param 発行日 発行日
     * @param 文書番号 文書番号
     * @param 徴収猶予決定通知書情報 徴収猶予決定通知書情報
     * @param 通知書定型文 通知書定型文
     * @param 介護問合せ先 介護問合せ先
     * @return List<KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoItem>
     */
    private List<KaigoHokenryoChoshuyuyoKetteiTsuchishoItem> setItems(RDate 発行日,
            RString 文書番号, KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー) {

        KitsukiList 期月リスト_特徴;
        KitsukiList 期月リスト_普徴;
        List<RString> 随時リスト = new ArrayList<>();
        List<KaigoHokenryoChoshuyuyoKetteiTsuchishoItem> itemList = new ArrayList<>();
        KaigoHokenryoChoshuyuyoKetteiTsuchishoItem item = new KaigoHokenryoChoshuyuyoKetteiTsuchishoItem();
        List<KibetsuChoshyuYuyoKikan> 期別徴収猶予期間List = new ArrayList<>();

        HyojiCodeResearcher hyojiCodeResearcher = new HyojiCodeResearcher();
        HyojiCodes 表示コード = hyojiCodeResearcher.create表示コード情報(
                徴収猶予決定通知書情報.get帳票制御共通().toEntity(),
                new RString(徴収猶予決定通知書情報.get宛名().get住所().get町域コード().toString()),
                new RString(徴収猶予決定通知書情報.get宛名().get行政区画().getGyoseiku().getコード().toString()),
                new RString(徴収猶予決定通知書情報.get宛名().get行政区画().getChiku1().getコード().toString()),
                new RString(徴収猶予決定通知書情報.get宛名().get行政区画().getChiku2().getコード().toString()),
                new RString(徴収猶予決定通知書情報.get宛名().get行政区画().getChiku3().getコード().toString()),
                new RString(徴収猶予決定通知書情報.get納組情報().getNokumi().getNokumiCode().toString()));

        editItem表示コード(表示コード, item, 文書番号, 徴収猶予決定通知書情報, 通知書定型文);

        TokuchoKiUtil 月期対応取得_特徴 = new TokuchoKiUtil();
        期月リスト_特徴 = 月期対応取得_特徴.get期月リスト();
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();

        for (int index = ONE; index < END_NUMBER; index++) {
            期別徴収猶予期間List = get期別徴収猶予期間リストを生成する(期別徴収猶予期間List,
                    徴収猶予決定通知書情報, 期月リスト_特徴, 期月リスト_普徴, index);
            随時リスト = get随時リストを生成する(随時リスト, 期月リスト_普徴, index);
            edit期別と随時リスト(item, 期別徴収猶予期間List, 随時リスト, index);
        }

        EditedAtesaki 編集後宛先 = new EditedAtesaki(徴収猶予決定通知書情報.get宛先(),
                徴収猶予決定通知書情報.get地方公共団体(), 徴収猶予決定通知書情報.get帳票制御共通(), null,
                null, true, null, null, null, null);
        editCompSofubutsuAtesakiItem(item, 編集後宛先);
        INinshoshaManager iNinshoshaManager = NinshoshaFinderFactory.createInstance();
        Ninshosha ninshosha = iNinshoshaManager.get帳票認証者(GyomuCode.DB介護保険, 種別コード);

        batchWrite = BatchReportFactory.createBatchReportWriter(種別コード).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
        RString イメージファイルパス = reportSourceWriter.getImageFolderPath();
        NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                ninshosha, 徴収猶予決定通知書情報.get地方公共団体(), イメージファイルパス, 発行日).buildSource();
        editCompNinshoshaItem(item, sourceBuilder);

        editCompKaigoToiawasesakiItem(item, 介護問合せ先ソースビルダー);

        itemList.add(item);
        return itemList;
    }

    private List<KibetsuChoshyuYuyoKikan> get期別徴収猶予期間リストを生成する(
            List<KibetsuChoshyuYuyoKikan> 期別徴収猶予期間List,
            KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報,
            KitsukiList 期月リスト_特徴, KitsukiList 期月リスト_普徴, int index) {

        KibetsuChoshyuYuyoKikan 期別徴収猶予期間 = new KibetsuChoshyuYuyoKikan();
        Kitsuki 特徴期月 = 期月リスト_特徴.get期の最初月(index);
        Kitsuki 普徴期月 = 期月リスト_普徴.get期の最初月(index);
        if (特徴期月.isPresent()) {
            期別徴収猶予期間.set特徴期(edit2桁文字列(特徴期月.get期()));
            期別徴収猶予期間.set特徴月(editInt2桁文字列(特徴期月.get月AsInt()));
            期別徴収猶予期間.set特徴期別金額(DecimalFormatter
                    .toコンマ区切りRString(get期と特徴期別金額の対応(徴収猶予決定通知書情報, 特徴期月.get期()), 0));
        } else {
            期別徴収猶予期間.set特徴期(RString.EMPTY);
            期別徴収猶予期間.set特徴月(RString.EMPTY);
            期別徴収猶予期間.set特徴期別金額(RString.EMPTY);
        }

        if (普徴期月.isPresent()) {
            期別徴収猶予期間.set普徴期(edit2桁文字列(普徴期月.get期()));
            期別徴収猶予期間.set普徴月(editInt2桁文字列(普徴期月.get月AsInt()));
            期別徴収猶予期間.set普徴期別金額(DecimalFormatter
                    .toコンマ区切りRString(get月と普徴期別金額の対応(徴収猶予決定通知書情報, 普徴期月.get月()), 0));
            期別徴収猶予期間.set徴収猶予期間(get徴収猶予期間(徴収猶予決定通知書情報, 普徴期月));
        } else {
            期別徴収猶予期間.set普徴期(RString.EMPTY);
            期別徴収猶予期間.set普徴月(RString.EMPTY);
            期別徴収猶予期間.set普徴期別金額(RString.EMPTY);
            期別徴収猶予期間.set徴収猶予期間(RString.EMPTY);
        }
        期別徴収猶予期間List.add(期別徴収猶予期間);
        return 期別徴収猶予期間List;
    }

    private List<RString> get随時リストを生成する(List<RString> 随時リスト, KitsukiList 期月リスト_普徴, int index) {

        Kitsuki 普徴期月 = 期月リスト_普徴.get期の最初月(index);
        if (FuchokiJohoTsukiShoriKubun.随時.equals(普徴期月.get月処理区分())
                || FuchokiJohoTsukiShoriKubun.現年随時.equals(普徴期月.get月処理区分())) {
            随時リスト.add(随時);
        } else {
            随時リスト.add(RString.EMPTY);
        }
        return 随時リスト;
    }

    private RString edit2桁文字列(RString 期) {
        if (ONE == 期.length()) {
            期 = new RString(RSTR_0 + 期.toString());
        }
        return 期;
    }

    private RString editInt2桁文字列(int 月) {
        RString 月AsInt = new RString(String.valueOf(月));
        if (月 < TEN && 月 >= ZERO) {
            月AsInt = new RString(RSTR_0 + String.valueOf(月));
        }
        return 月AsInt;
    }

    private Decimal get期と特徴期別金額の対応(
            KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報, RString 期) {

        if (期_1.equals(期)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get特徴期別金額01();
        } else if (期_2.equals(期)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get特徴期別金額02();
        } else if (期_3.equals(期)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get特徴期別金額03();
        } else if (期_4.equals(期)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get特徴期別金額04();
        } else if (期_5.equals(期)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get特徴期別金額05();
        } else {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get特徴期別金額06();
        }
    }

    private Decimal get月と普徴期別金額の対応(
            KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報, Tsuki 月) {

        RString 普徴月 = new RString(月.toString());
        if (普徴期_4.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額01();
        } else if (普徴期_5.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額02();
        } else if (普徴期_6.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額03();
        } else if (普徴期_7.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額04();
        } else if (普徴期_8.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額05();
        } else if (普徴期_9.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額06();
        } else if (普徴期_10.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額07();
        } else if (普徴期_11.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額08();
        } else if (普徴期_12.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額09();
        } else if (普徴期_1.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額10();
        } else if (普徴期_2.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額11();
        } else if (普徴期_3.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額12();
        } else if (普徴期翌年度_4.equals(普徴月)) {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額13();
        } else {
            return 徴収猶予決定通知書情報.get徴収猶予の情報().get普徴期別金額14();
        }
    }

    private RString get徴収猶予期間(KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報, Kitsuki 普徴期月) {

        RString 徴収猶予期間;
        ChoshuYuyoJoho choshuYuyoJoho = 徴収猶予決定通知書情報.get徴収猶予の情報();
        RString 徴収方法 = choshuYuyoJoho.get介護期別徴収猶予().getChoshuHoho();
        RString 期 = new RString(String.valueOf(choshuYuyoJoho.get介護期別徴収猶予().getKi()));
        if (ChoshuHohoKibetsu.普通徴収.code().equals(徴収方法) && 普徴期月.get期().equals(期)) {
            徴収猶予期間 = new RString(DateEditor.to西暦(choshuYuyoJoho.get介護期別徴収猶予().getYuyoStartYMD()).toString()
                    + 波線.toString() + DateEditor.to西暦(choshuYuyoJoho.get介護期別徴収猶予().getYuyoEndYMD()).toString());
        } else {
            徴収猶予期間 = RString.EMPTY;
        }
        return 徴収猶予期間;
    }

    private void editItem表示コード(HyojiCodes 表示コード, KaigoHokenryoChoshuyuyoKetteiTsuchishoItem item,
            RString 文書番号, KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報, RString 通知書定型文) {

        item.setBunshoNo(文書番号);
        item.setChoteiNendo(徴収猶予決定通知書情報.get徴収猶予の情報().get調定年度());
        item.setFukaNendo(徴収猶予決定通知書情報.get徴収猶予の情報().get調定年度());
        item.setKetteiKekka(徴収猶予決定通知書情報.get徴収猶予の情報().get徴収猶予状態区分());
        item.setHyojicodeName1(表示コード.get表示コード名１());
        item.setHyojicodeName2(表示コード.get表示コード名２());
        item.setHyojicodeName3(表示コード.get表示コード名３());
        item.setHyojicode1(表示コード.get表示コード１());
        item.setHyojicode2(表示コード.get表示コード２());
        item.setHyojicode3(表示コード.get表示コード３());
        item.setTsuchishoNo(徴収猶予決定通知書情報.get徴収猶予の情報().get通知書番号());
        item.setSetaiCode(徴収猶予決定通知書情報.get徴収猶予の情報().get世帯コード());
        item.setHihokenshaNo(徴収猶予決定通知書情報.get徴収猶予の情報().get被保険者番号());
        item.setShikibetsucode(徴収猶予決定通知書情報.get徴収猶予の情報().get識別コード());
        item.setKetteiYMD(徴収猶予決定通知書情報.get徴収猶予の情報().get徴収猶予決定日());
        item.setKetteiRiyu1(徴収猶予決定通知書情報.get徴収猶予の情報().get徴収猶予種類());
        item.setKetteiRiyu2(徴収猶予決定通知書情報.get徴収猶予の情報().get徴収猶予取消事由());
        item.setBikoTitle(通知書定型文);
        item.setBiko(通知書定型文);
    }

    private void edit期別と随時リスト(KaigoHokenryoChoshuyuyoKetteiTsuchishoItem item,
            List<KibetsuChoshyuYuyoKikan> 期別徴収猶予期間List, List<RString> 随時リスト, int index) {

        item.setListKibetsu_1(期別徴収猶予期間List.get(index - 1).get特徴期());
        item.setListKibetsu_2(期別徴収猶予期間List.get(index - 1).get特徴月());
        item.setListKibetsu_3(期別徴収猶予期間List.get(index - 1).get特徴期別金額());
        item.setListKibetsu_4(期別徴収猶予期間List.get(index - 1).get普徴期());
        item.setListKibetsu_5(期別徴収猶予期間List.get(index - 1).get普徴月());
        item.setListKibetsu_6(期別徴収猶予期間List.get(index - 1).get普徴期別金額());
        item.setListKibetsu_7(期別徴収猶予期間List.get(index - 1).get徴収猶予期間());
        item.setListZuiji_1(随時リスト.get(index - 1));
    }

    private void editCompNinshoshaItem(
            KaigoHokenryoChoshuyuyoKetteiTsuchishoItem item, NinshoshaSource sourceBuilder) {

        item.setHakkoYMD(sourceBuilder.hakkoYMD);
        item.setDenshiKoin(sourceBuilder.denshiKoin);
        item.setNinshoshaYakushokuMei(sourceBuilder.ninshoshaYakushokuMei);
        item.setKoinMojiretsu(sourceBuilder.koinMojiretsu);
        item.setNinshoshaShimeiKakenai(sourceBuilder.ninshoshaShimeiKakenai);
        item.setNinshoshaShimeiKakeru(sourceBuilder.ninshoshaShimeiKakeru);
        item.setKoinShoryaku(sourceBuilder.koinShoryaku);
    }

    private void editCompKaigoToiawasesakiItem(
            KaigoHokenryoChoshuyuyoKetteiTsuchishoItem item,
            IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー) {

        CompKaigoToiawasesakiSource buildSource = 介護問合せ先ソースビルダー.buildSource();
        item.setYubinBango(buildSource.yubinBango);
        item.setShozaichi(buildSource.shozaichi);
        item.setChoshaBushoName(buildSource.choshaBushoName);
        item.setTantoName(buildSource.tantoName);
        item.setTelNo(buildSource.telNo);
        item.setNaisenLabel(buildSource.naisenLabel);
        item.setNaisenNo(buildSource.naisenNo);
    }

    private void editCompSofubutsuAtesakiItem(KaigoHokenryoChoshuyuyoKetteiTsuchishoItem item, EditedAtesaki 編集後宛先) {
        SofubutsuAtesakiSource source = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();
        item.setYubinNo(source.yubinNo);
        item.setGyoseiku(source.gyoseiku);
        item.setJusho3(source.jusho3);
        item.setJushoText(source.jushoText);
        item.setJusho1(source.jusho1);
        item.setJusho2(source.jusho2);
        item.setKatagakiText(source.katagakiText);
        item.setKatagaki2(source.katagaki2);
        item.setKatagakiSmall2(source.katagakiSmall2);
        item.setKatagaki1(source.katagaki1);
        item.setKatagakiSmall1(source.katagakiSmall1);
        item.setKakkoRight2(source.kakkoRight2);
        item.setKakkoRight1(source.kakkoRight1);
        item.setShimei2(source.shimei2);
        item.setShimeiSmall2(source.shimeiSmall2);
        item.setShimeiText(source.shimeiText);
        item.setMeishoFuyo2(source.meishoFuyo2);
        item.setShimeiSmall1(source.shimeiSmall1);
        item.setDainoKubunMei(source.dainoKubunMei);
        item.setShimei1(source.shimei1);
        item.setMeishoFuyo1(source.meishoFuyo1);
        item.setSamabunShimeiText(source.samabunShimeiText);
        item.setSamabunShimeiSmall2(source.samabunShimeiSmall2);
        item.setSamaBun2(source.samaBun2);
        item.setKakkoLeft2(source.kakkoLeft2);
        item.setSamabunShimei2(source.samabunShimei2);
        item.setKakkoLeft1(source.kakkoLeft1);
        item.setSamabunShimei1(source.samabunShimei1);
        item.setSamaBun1(source.samaBun1);
        item.setSamabunShimeiSmall1(source.samabunShimeiSmall1);
        item.setCustomerBarCode(source.customerBarCode);
        // TODO QA:581
//        item.setSetainusimei(source.setainusimei);
//        item.setSamaKata(source.samaKata);
    }
}
