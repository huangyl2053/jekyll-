/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.choshuyuyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.choshuyuyojoho.ChoshuYuyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.kibetsuchochuyuyo.KibetsuChoshuYuyo;
import jp.co.ndensan.reams.db.dbb.business.report.choshuyuyo.ChoshuYuyoTorikesiTsuchiShoA4TateProperty;
import jp.co.ndensan.reams.db.dbb.business.report.choshuyuyo.ChoshuYuyoTorikesiTsuchiShoA4TateReport;
import jp.co.ndensan.reams.db.dbb.business.report.choshuyuyo.ChoshuYuyoTorikesiTsuchiShoB5YokoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.choshuyuyo.ChoshuYuyoTorikesiTsuchiShoB5YokoReport;
import jp.co.ndensan.reams.db.dbb.business.report.choshuyuyo.ChoshuYuyoTorikesiTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.choshuyuyo.KibetsuChoshyuYuyoKikan;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.entity.report.choshuyuyo.KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoA4TateSource;
import jp.co.ndensan.reams.db.dbb.entity.report.choshuyuyo.KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoB5YokoSource;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HyojiCodeResearcher;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.fucho.FuchokiJohoTsukiShoriKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.gyosekukaku.IGyoseiKukaku;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.IJusho;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護保険料徴収猶予取消通知書 PrintServiceするクラスです。
 *
 * @reamsid_L DBB-0740-070 chenaoqi
 */
public class ChoshuYuyoTorikesiTsuchiShoPrintService {

    private static final RString 種別コード = NinshoshaDenshikoinshubetsuCode.保険者印.getコード();
    private static final RString RSTRING_1 = new RString("1");
    private static final int 定数_ONE = 1;
    private static final int 定数_ZERO = 0;
    private static final int 定数_TEN = 10;
    private static final RString RSTR_0 = new RString("　");
    private static final RString 波線 = new RString("～");
    private static final RString 期_1 = new RString("01");
    private static final RString 期_2 = new RString("02");
    private static final RString 期_3 = new RString("03");
    private static final RString 期_4 = new RString("04");
    private static final RString 期_5 = new RString("05");
    private static final RString 期_6 = new RString("06");
    private static final RString 普徴期_4 = new RString("_4月");
    private static final RString 普徴期_5 = new RString("_5月");
    private static final RString 普徴期_6 = new RString("_6月");
    private static final RString 普徴期_7 = new RString("_7月");
    private static final RString 普徴期_8 = new RString("_8月");
    private static final RString 普徴期_9 = new RString("_9月");
    private static final RString 普徴期_10 = new RString("_10月");
    private static final RString 普徴期_11 = new RString("_11月");
    private static final RString 普徴期_12 = new RString("_12月");
    private static final RString 普徴期_1 = new RString("_1月");
    private static final RString 普徴期_2 = new RString("_2月");
    private static final RString 普徴期_3 = new RString("_3月");
    private static final RString 普徴期翌年度_4 = new RString("翌年度4月");
    private static final RString 普徴期翌年度_5 = new RString("翌年度5月");
    private static final int INDEX_ONE = 1;
    private static final int INDEX_FOURTEEN = 14;

    /**
     * 介護保険料徴収猶予取消通知書B5横タイプ(単一帳票出力用)
     *
     * @param 発行日 FlexibleDate
     * @param 文書番号 RString
     * @param 徴収猶予取消通知書情報 ChoshuYuyoTorikesiTsuchiShoJoho
     * @param 通知書定型文 RString
     * @param 介護問合せ先ソースビルダー IKaigoToiawasesakiSourceBuilder
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingleA4縦タイプ(FlexibleDate 発行日, RString 文書番号,
            ChoshuYuyoTorikesiTsuchiShoJoho 徴収猶予取消通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            printA4縦タイプ(発行日, 文書番号, 徴収猶予取消通知書情報,
                    通知書定型文, 介護問合せ先ソースビルダー, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 介護保険料徴収猶予取消通知書B5横タイプ(単一帳票出力用)
     *
     * @param 発行日 FlexibleDate
     * @param 文書番号 RString
     * @param 徴収猶予取消通知書情報 ChoshuYuyoTorikesiTsuchiShoJoho
     * @param 通知書定型文 RString
     * @param 介護問合せ先ソースビルダー IKaigoToiawasesakiSourceBuilder
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingleB5横タイプ(FlexibleDate 発行日, RString 文書番号,
            ChoshuYuyoTorikesiTsuchiShoJoho 徴収猶予取消通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            printB5横タイプ(発行日, 文書番号, 徴収猶予取消通知書情報,
                    通知書定型文, 介護問合せ先ソースビルダー, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * printA4縦タイプメソッドします。
     *
     * @param 発行日 FlexibleDate
     * @param 文書番号 RString
     * @param 徴収猶予取消通知書情報 ChoshuYuyoTorikesiTsuchiShoJoho
     * @param 通知書定型文 RString
     * @param 介護問合せ先ソースビルダー IKaigoToiawasesakiSourceBuilder
     * @param reportManager ReportManager
     */
    public void printA4縦タイプ(FlexibleDate 発行日, RString 文書番号, ChoshuYuyoTorikesiTsuchiShoJoho 徴収猶予取消通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー, ReportManager reportManager) {
        ChoshuYuyoTorikesiTsuchiShoA4TateProperty property = new ChoshuYuyoTorikesiTsuchiShoA4TateProperty();
        try (ReportAssembler<KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoA4TateSource> assembler = createAssembler(property, reportManager)) {
            if (徴収猶予取消通知書情報 != null) {
                Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険, 種別コード,
                        発行日 == null || 発行日.isEmpty() ? FlexibleDate.getNowDate() : 発行日);
                Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
                ChohyoSeigyoKyotsu 帳票制御共通 = 徴収猶予取消通知書情報.get帳票制御共通();
                boolean is公印に掛ける = false;
                if (帳票制御共通.get首長名印字位置() != null && RSTRING_1.equals(帳票制御共通.get首長名印字位置())) {
                    is公印に掛ける = true;
                }
                boolean is公印を省略 = false;
                if (!帳票制御共通.is電子公印印字有無()) {
                    is公印を省略 = true;
                }
                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                        地方公共団体,
                        assembler.getImageFolderPath(),
                        発行日 == null || 発行日.isEmpty() ? RDate.getNowDate() : new RDate(発行日.toString()),
                        is公印に掛ける,
                        is公印を省略,
                        KenmeiFuyoKubunType.付与なし).buildSource();
                HyojiCodes 表示コード = get表示コード(徴収猶予取消通知書情報);
                List<KibetsuChoshyuYuyoKikan> 期別徴収猶予期間リスト = 期別徴収猶予期間リストを生成(徴収猶予取消通知書情報);
                List<RString> 期別納期リスト = get期別納期リスト();
                List<RString> 随時リスト = 随時リストを生成();
                EditedAtesaki 編集後宛先 = get編集後宛先(徴収猶予取消通知書情報);
                ReportSourceWriter<KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoA4TateSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new ChoshuYuyoTorikesiTsuchiShoA4TateReport(文書番号, 徴収猶予取消通知書情報,
                        通知書定型文, 介護問合せ先ソースビルダー, sourceBuilder, 表示コード, 期別徴収猶予期間リスト,
                        期別納期リスト, 随時リスト, 編集後宛先).writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * printA4縦タイプメソッドします。
     *
     * @param 発行日 FlexibleDate
     * @param 文書番号 RString
     * @param 徴収猶予取消通知書情報 ChoshuYuyoTorikesiTsuchiShoJoho
     * @param 通知書定型文 RString
     * @param 介護問合せ先ソースビルダー IKaigoToiawasesakiSourceBuilder
     * @param reportManager ReportManager
     */
    public void printB5横タイプ(FlexibleDate 発行日, RString 文書番号, ChoshuYuyoTorikesiTsuchiShoJoho 徴収猶予取消通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー, ReportManager reportManager) {
        ChoshuYuyoTorikesiTsuchiShoB5YokoProperty property = new ChoshuYuyoTorikesiTsuchiShoB5YokoProperty();
        try (ReportAssembler<KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoB5YokoSource> assembler = createAssembler(property, reportManager)) {
            if (徴収猶予取消通知書情報 != null) {
                Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険, 種別コード,
                        発行日 == null || 発行日.isEmpty() ? FlexibleDate.getNowDate() : 発行日);
                Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
                ChohyoSeigyoKyotsu 帳票制御共通 = 徴収猶予取消通知書情報.get帳票制御共通();
                boolean is公印に掛ける = false;
                if (帳票制御共通.get首長名印字位置() != null && RSTRING_1.equals(帳票制御共通.get首長名印字位置())) {
                    is公印に掛ける = true;
                }
                boolean is公印を省略 = false;
                if (!帳票制御共通.is電子公印印字有無()) {
                    is公印を省略 = true;
                }
                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                        地方公共団体,
                        assembler.getImageFolderPath(),
                        発行日 == null || 発行日.isEmpty() ? RDate.getNowDate() : new RDate(発行日.toString()),
                        is公印に掛ける,
                        is公印を省略,
                        KenmeiFuyoKubunType.付与なし).buildSource();
                HyojiCodes 表示コード = get表示コード(徴収猶予取消通知書情報);
                List<KibetsuChoshyuYuyoKikan> 期別徴収猶予期間リスト = 期別徴収猶予期間リストを生成(徴収猶予取消通知書情報);
                List<RString> 期別納期リスト = get期別納期リスト();
                List<RString> 随時リスト = 随時リストを生成();
                EditedAtesaki 編集後宛先 = get編集後宛先(徴収猶予取消通知書情報);
                ReportSourceWriter<KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoB5YokoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new ChoshuYuyoTorikesiTsuchiShoB5YokoReport(文書番号, 徴収猶予取消通知書情報,
                        通知書定型文, 介護問合せ先ソースビルダー, sourceBuilder, 表示コード, 期別徴収猶予期間リスト,
                        期別納期リスト, 随時リスト, 編集後宛先).writeBy(reportSourceWriter);
            }
        }
    }

    private EditedAtesaki get編集後宛先(ChoshuYuyoTorikesiTsuchiShoJoho 徴収猶予取消通知書情報) {
        EditedAtesaki 編集後宛先 = null;
        if (isNotNull(徴収猶予取消通知書情報.get宛先()) && isNotNull(徴収猶予取消通知書情報.get地方公共団体())
                && isNotNull(徴収猶予取消通知書情報.get宛先())) {
            JushoHenshu jushoHenshu = JushoHenshu.createInstance();
            編集後宛先 = jushoHenshu.create編集後宛先(徴収猶予取消通知書情報.get宛先(),
                    徴収猶予取消通知書情報.get地方公共団体(), 徴収猶予取消通知書情報.get帳票制御共通());
        }
        return 編集後宛先;
    }

    private HyojiCodes get表示コード(ChoshuYuyoTorikesiTsuchiShoJoho 徴収猶予取消通知書情報) {
        HyojiCodes 表示コード = null;
        HyojiCodeResearcher researcher = new HyojiCodeResearcher();
        if (isNotNull(徴収猶予取消通知書情報.get帳票制御共通()) && isNotNull(徴収猶予取消通知書情報.get宛名())
                && isNotNull(徴収猶予取消通知書情報.get納組情報())) {
            IGyoseiKukaku 行政区画 = 徴収猶予取消通知書情報.get宛名().get行政区画();
            IJusho 住所 = 徴収猶予取消通知書情報.get宛名().get住所();
            表示コード = researcher.create表示コード情報(徴収猶予取消通知書情報.get帳票制御共通().toEntity(),
                    住所 != null ? 住所.get町域コード().value() : RString.EMPTY,
                    行政区画 != null ? 行政区画.getGyoseiku().getコード().value() : RString.EMPTY,
                    行政区画 != null ? 行政区画.getChiku1().getコード().value() : RString.EMPTY,
                    行政区画 != null ? 行政区画.getChiku2().getコード().value() : RString.EMPTY,
                    行政区画 != null ? 行政区画.getChiku3().getコード().value() : RString.EMPTY,
                    徴収猶予取消通知書情報.get納組情報().getNokumi().getNokumiCode());
        }
        return 表示コード;
    }

    private List<KibetsuChoshyuYuyoKikan> 期別徴収猶予期間リストを生成(ChoshuYuyoTorikesiTsuchiShoJoho 徴収猶予取消通知書情報) {
        List<KibetsuChoshyuYuyoKikan> 期別徴収猶予期間リスト = new ArrayList<>();
        KitsukiList 期月リスト_特徴;
        KitsukiList 期月リスト_普徴;
        TokuchoKiUtil 月期対応取得_特徴 = new TokuchoKiUtil();
        期月リスト_特徴 = 月期対応取得_特徴.get期月リスト();
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        for (int index = INDEX_ONE; index <= INDEX_FOURTEEN; index++) {
            KibetsuChoshyuYuyoKikan 期別徴収猶予期間 = new KibetsuChoshyuYuyoKikan();
            Kitsuki 特徴期月 = 期月リスト_特徴.get期の最初月(index);
            Kitsuki 普徴期月 = 期月リスト_普徴.get期の最初月(index);
            if (特徴期月.isPresent()) {
                期別徴収猶予期間.set特徴期(edit2桁文字列(特徴期月.get期()));
                期別徴収猶予期間.set特徴月(editInt2桁文字列(特徴期月.get月AsInt()));
                期別徴収猶予期間.set特徴期別金額(DecimalFormatter
                        .toコンマ区切りRString(get期と特徴期別金額の対応(徴収猶予取消通知書情報, 特徴期月.get期()), 0));
            } else {
                期別徴収猶予期間.set特徴期(RString.EMPTY);
                期別徴収猶予期間.set特徴月(RString.EMPTY);
                期別徴収猶予期間.set特徴期別金額(RString.EMPTY);
            }

            if (普徴期月.isPresent()) {
                期別徴収猶予期間.set普徴期(edit2桁文字列(普徴期月.get期()));
                期別徴収猶予期間.set普徴月(editInt2桁文字列(普徴期月.get月AsInt()));
                期別徴収猶予期間.set普徴期別金額(DecimalFormatter
                        .toコンマ区切りRString(get月と普徴期別金額の対応(徴収猶予取消通知書情報, 普徴期月.get月()), 0));
                期別徴収猶予期間.set徴収猶予期間(get徴収猶予期間(徴収猶予取消通知書情報, 普徴期月));
            } else {
                期別徴収猶予期間.set普徴期(RString.EMPTY);
                期別徴収猶予期間.set普徴月(RString.EMPTY);
                期別徴収猶予期間.set普徴期別金額(RString.EMPTY);
                期別徴収猶予期間.set徴収猶予期間(RString.EMPTY);
            }
            期別徴収猶予期間リスト.add(期別徴収猶予期間);
        }
        return 期別徴収猶予期間リスト;

    }

    /**
     * 随時リストを生成する。
     *
     * @return List<RString>
     */
    private List<RString> 随時リストを生成() {
        List<RString> 随時リスト = new ArrayList<>();
        FuchoKiUtil fuchoKiUtil = new FuchoKiUtil();
        KitsukiList 普徴期月リスト = fuchoKiUtil.get期月リスト();
        for (int index = INDEX_ONE; index <= INDEX_FOURTEEN; index++) {
            Kitsuki 期月普徴 = 普徴期月リスト.get期の最初月(index);
            if (FuchokiJohoTsukiShoriKubun.随時.getName().equals(期月普徴.get月処理区分().getName())
                    || FuchokiJohoTsukiShoriKubun.現年随時.getName().equals(期月普徴.get月処理区分().getName())) {
                随時リスト.add(FuchokiJohoTsukiShoriKubun.随時.getName());
            } else {
                随時リスト.add(RString.EMPTY);
            }
        }
        return 随時リスト;
    }

    private List<RString> get期別納期リスト() {
        List<RString> 期別納期リスト = new ArrayList<>();
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        List<Kitsuki> 期月リスト = new ArrayList<>();
        FukaNokiResearcher 賦課納期取得 = FukaNokiResearcher.createInstance();
        List<Noki> 賦課納期list = 賦課納期取得.get普徴納期ALL();
        if (期月リスト_普徴 != null) {
            期月リスト = 期月リスト_普徴.toList();
        }
        if (期月リスト.isEmpty() || 賦課納期list == null || 賦課納期list.isEmpty()) {
            return 期別納期リスト;
        }
        RDate 納期開始日 = null;
        RDate 納期終了日 = null;
        RString 期別納期期間 = RString.EMPTY;
        for (Kitsuki 期月 : 期月リスト) {
            for (Noki 賦課納期 : 賦課納期list) {
                if (Integer.parseInt(期月.get期().toString()) == 賦課納期.get期別()) {
                    納期開始日 = 賦課納期.get納期開始日();
                    納期終了日 = 賦課納期.get納期終了日();
                    if (納期開始日 != null && 納期終了日 != null) {
                        期別納期期間 = 納期開始日.wareki().toDateString().concat(波線)
                                .concat(納期終了日.wareki().toDateString());
                        期別納期リスト.add(期別納期期間);
                    } else if (納期開始日 == null && 納期終了日 != null) {
                        期別納期期間 = RString.EMPTY.concat(波線)
                                .concat(納期終了日.wareki().toDateString());
                        期別納期リスト.add(期別納期期間);

                    } else if (納期開始日 != null && 納期終了日 == null) {
                        期別納期期間 = 納期開始日.wareki().toDateString().concat(波線);
                        期別納期リスト.add(期別納期期間);
                    } else {
                        期別納期リスト.add(RString.EMPTY);
                    }
                }
            }

        }

        return 期別納期リスト;
    }

    private RString edit2桁文字列(RString 期) {
        if (定数_ONE == 期.length()) {
            期 = new RString(RSTR_0 + 期.toString());
        }
        return 期;
    }

    private RString editInt2桁文字列(int 月) {
        RString 月AsInt = new RString(String.valueOf(月));
        if (月 < 定数_TEN && 月 >= 定数_ZERO) {
            月AsInt = new RString(RSTR_0 + String.valueOf(月));
        }
        return 月AsInt;
    }

    private Decimal get期と特徴期別金額の対応(
            ChoshuYuyoTorikesiTsuchiShoJoho 徴収猶予取消通知書情報, RString 期) {
        if (徴収猶予取消通知書情報.get徴収猶予の情報() == null) {
            return Decimal.ZERO;
        }
        if (期_1.equals(期)) {
            return 徴収猶予取消通知書情報.get徴収猶予の情報().get特徴期別金額01();
        } else if (期_2.equals(期)) {
            return 徴収猶予取消通知書情報.get徴収猶予の情報().get特徴期別金額02();
        } else if (期_3.equals(期)) {
            return 徴収猶予取消通知書情報.get徴収猶予の情報().get特徴期別金額03();
        } else if (期_4.equals(期)) {
            return 徴収猶予取消通知書情報.get徴収猶予の情報().get特徴期別金額04();
        } else if (期_5.equals(期)) {
            return 徴収猶予取消通知書情報.get徴収猶予の情報().get特徴期別金額05();
        } else if (期_6.equals(期)) {
            return 徴収猶予取消通知書情報.get徴収猶予の情報().get特徴期別金額06();
        } else {
            return Decimal.ZERO;
        }
    }

    private Decimal get月と普徴期別金額の対応(
            ChoshuYuyoTorikesiTsuchiShoJoho 徴収猶予取消通知書情報, Tsuki 月) {
        if (徴収猶予取消通知書情報.get徴収猶予の情報() == null) {
            return Decimal.ZERO;
        }
        RString 普徴月 = new RString(月.toString());
        if (普徴期_4.equals(普徴月)) {
            return 徴収猶予取消通知書情報.get徴収猶予の情報().get普徴期別金額01();
        } else if (普徴期_5.equals(普徴月)) {
            return 徴収猶予取消通知書情報.get徴収猶予の情報().get普徴期別金額02();
        } else if (普徴期_6.equals(普徴月)) {
            return 徴収猶予取消通知書情報.get徴収猶予の情報().get普徴期別金額03();
        } else if (普徴期_7.equals(普徴月)) {
            return 徴収猶予取消通知書情報.get徴収猶予の情報().get普徴期別金額04();
        } else if (普徴期_8.equals(普徴月)) {
            return 徴収猶予取消通知書情報.get徴収猶予の情報().get普徴期別金額05();
        } else if (普徴期_9.equals(普徴月)) {
            return 徴収猶予取消通知書情報.get徴収猶予の情報().get普徴期別金額06();
        } else if (普徴期_10.equals(普徴月)) {
            return 徴収猶予取消通知書情報.get徴収猶予の情報().get普徴期別金額07();
        } else if (普徴期_11.equals(普徴月)) {
            return 徴収猶予取消通知書情報.get徴収猶予の情報().get普徴期別金額08();
        } else if (普徴期_12.equals(普徴月)) {
            return 徴収猶予取消通知書情報.get徴収猶予の情報().get普徴期別金額09();
        } else if (普徴期_1.equals(普徴月)) {
            return 徴収猶予取消通知書情報.get徴収猶予の情報().get普徴期別金額10();
        } else if (普徴期_2.equals(普徴月)) {
            return 徴収猶予取消通知書情報.get徴収猶予の情報().get普徴期別金額11();
        } else if (普徴期_3.equals(普徴月)) {
            return 徴収猶予取消通知書情報.get徴収猶予の情報().get普徴期別金額12();
        } else if (普徴期翌年度_4.equals(普徴月)) {
            return 徴収猶予取消通知書情報.get徴収猶予の情報().get普徴期別金額13();
        } else if (普徴期翌年度_5.equals(普徴月)) {
            return 徴収猶予取消通知書情報.get徴収猶予の情報().get普徴期別金額14();
        } else {
            return Decimal.ZERO;
        }
    }

    private RString get徴収猶予期間(ChoshuYuyoTorikesiTsuchiShoJoho 徴収猶予取消通知書情報, Kitsuki 普徴期月) {

        RString 徴収猶予期間 = RString.EMPTY;
        ChoshuYuyoJoho choshuYuyoJoho = 徴収猶予取消通知書情報.get徴収猶予の情報();
        if (choshuYuyoJoho == null) {
            return 徴収猶予期間;
        }
        List<KibetsuChoshuYuyo> 介護期別徴収猶予List = choshuYuyoJoho.get介護期別徴収猶予();
        if (介護期別徴収猶予List == null || 介護期別徴収猶予List.isEmpty()) {
            return 徴収猶予期間;
        }
        FlexibleDate 徴収猶予開始日 = FlexibleDate.EMPTY;
        FlexibleDate 徴収猶予終了日 = FlexibleDate.EMPTY;
        for (KibetsuChoshuYuyo 介護期別徴収猶予 : 介護期別徴収猶予List) {
            RString 徴収方法 = 介護期別徴収猶予.get徴収方法();
            int 期 = Integer.parseInt(普徴期月.get期().toString());
            if (ChoshuHohoKibetsu.普通徴収.code().equals(徴収方法) && 期 == 介護期別徴収猶予.get期()) {
                徴収猶予開始日 = 介護期別徴収猶予.get徴収猶予開始日();
                徴収猶予終了日 = 介護期別徴収猶予.get徴収猶予終了日();
                if (徴収猶予開始日 != null && 徴収猶予終了日 != null) {
                    徴収猶予期間 = 徴収猶予開始日.wareki().toDateString().concat(波線)
                            .concat(徴収猶予終了日.wareki().toDateString());
                } else if (徴収猶予開始日 == null && 徴収猶予終了日 != null) {
                    徴収猶予期間 = RString.EMPTY.concat(波線)
                            .concat(徴収猶予終了日.wareki().toDateString());
                } else if (徴収猶予開始日 != null && 徴収猶予終了日 == null) {
                    徴収猶予期間 = 徴収猶予開始日.wareki().toDateString().concat(波線);
                } else {
                    徴収猶予期間 = RString.EMPTY;
                }
            }
        }
        return 徴収猶予期間;
    }

    /**
     * 判断をnull対象 します。
     *
     * @param object Object
     * @return boolean
     */
    private boolean isNotNull(Object object) {
        return object != null;
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(
            IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }
}
