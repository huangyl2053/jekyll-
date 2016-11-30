/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.gemmentorikesitsuchisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.gemmentorikesitsuchisho.GemmenTorikesiTsuchiShoA4TateProperty;
import jp.co.ndensan.reams.db.dbb.business.report.gemmentorikesitsuchisho.GemmenTorikesiTsuchiShoA4TateReport;
import jp.co.ndensan.reams.db.dbb.business.report.gemmentorikesitsuchisho.GemmenTorikesiTsuchiShoB5YokoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.gemmentorikesitsuchisho.GemmenTorikesiTsuchiShoB5YokoReport;
import jp.co.ndensan.reams.db.dbb.business.report.gemmentorikesitsuchisho.GemmenTorikesiTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.gemmentorikesitsuchisho.KoseiZengoKiwariGaku;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.entity.report.gemmentorikesitsuchisho.KaigoHokenHokenryoGenmenTorikeshiTsuchishoA4TateSource;
import jp.co.ndensan.reams.db.dbb.entity.report.gemmentorikesitsuchisho.KaigoHokenHokenryoGenmenTorikeshiTsuchishoB5YokoSource;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HyojiCodeResearcher;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KanendoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.fucho.FuchokiJohoTsukiShoriKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.kanendo.KanendoTsukiShoriKubun;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
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
 * 帳票設計_DBBRP12001_1_介護保険料減免取消通知書PrintServiceクラスです。
 *
 * @reamsid_L DBB-0740-060 chenaoqi
 */
public class GemmenTorikesiTsuchiShoPrintService {

    private static final RString 種別コード = NinshoshaDenshikoinshubetsuCode.保険者印.getコード();
    private static final RString RSTRING_0 = new RString("0");
    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_2 = new RString("-");
    private static final RString 負ゼロ = new RString("-0");
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
    private static final int INDEX_TEN = 10;
    private static final int INDEX_ELEVEN = 11;
    private static final int INDEX_TWELVE = 12;
    private static final int INDEX_THIRTEEN = 13;
    private static final int INDEX_FOURTEEN = 14;

    /**
     * 介護保険料減免取消通知書A4縦タイプ(単一帳票出力用)
     *
     * @param 発行日 FlexibleDate
     * @param 文書番号 RString
     * @param 減免取消通知書情報 GemmenTorikesiTsuchiShoJoho
     * @param 通知書定型文 RString
     * @param 介護問合せ先ソースビルダー IKaigoToiawasesakiSourceBuilder
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingleA4縦タイプ(FlexibleDate 発行日, RString 文書番号,
            GemmenTorikesiTsuchiShoJoho 減免取消通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            printA4縦タイプ(発行日, 文書番号, 減免取消通知書情報,
                    通知書定型文, 介護問合せ先ソースビルダー, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 介護保険料減免取消通知書B5横タイプ(単一帳票出力用)
     *
     * @param 発行日 FlexibleDate
     * @param 文書番号 RString
     * @param 減免取消通知書情報 GemmenTorikesiTsuchiShoJoho
     * @param 通知書定型文 RString
     * @param 介護問合せ先ソースビルダー IKaigoToiawasesakiSourceBuilder
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingleB5横タイプ(FlexibleDate 発行日, RString 文書番号,
            GemmenTorikesiTsuchiShoJoho 減免取消通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            printB5横タイプ(発行日, 文書番号, 減免取消通知書情報,
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
     * @param 減免取消通知書情報 GemmenTorikesiTsuchiShoJoho
     * @param 通知書定型文 RString
     * @param 介護問合せ先ソースビルダー IKaigoToiawasesakiSourceBuilder
     * @param reportManager ReportManager
     */
    public void printA4縦タイプ(FlexibleDate 発行日, RString 文書番号, GemmenTorikesiTsuchiShoJoho 減免取消通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー, ReportManager reportManager) {
        GemmenTorikesiTsuchiShoA4TateProperty property = new GemmenTorikesiTsuchiShoA4TateProperty();
        try (ReportAssembler<KaigoHokenHokenryoGenmenTorikeshiTsuchishoA4TateSource> assembler = createAssembler(property, reportManager)) {
            if (減免取消通知書情報 != null) {
                Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険, 種別コード,
                        発行日 == null || 発行日.isEmpty() ? FlexibleDate.getNowDate() : 発行日);
                Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
                ChohyoSeigyoKyotsu 帳票制御共通 = 減免取消通知書情報.get帳票制御共通();
                boolean is公印に掛ける = false;
                if (帳票制御共通 != null && RSTRING_1.equals(帳票制御共通.get首長名印字位置())) {
                    is公印に掛ける = true;
                }
                boolean is公印を省略 = false;
                if (帳票制御共通 != null && !帳票制御共通.is電子公印印字有無()) {
                    is公印を省略 = true;
                }
                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                        地方公共団体,
                        assembler.getImageFolderPath(),
                        発行日 == null || 発行日.isEmpty() ? RDate.getNowDate() : new RDate(発行日.toString()),
                        is公印に掛ける,
                        is公印を省略,
                        KenmeiFuyoKubunType.付与なし).buildSource();
                HyojiCodes 表示コード = get表示コード(減免取消通知書情報);
                List<KoseiZengoKiwariGaku> 更正前後期割額リスト = 更正前後期割額リストを生成(減免取消通知書情報);
                List<RString> 随時リスト = 随時リストを生成(減免取消通知書情報);
                EditedAtesaki 編集後宛先 = get編集後宛先(減免取消通知書情報);
                ReportSourceWriter<KaigoHokenHokenryoGenmenTorikeshiTsuchishoA4TateSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new GemmenTorikesiTsuchiShoA4TateReport(文書番号, 減免取消通知書情報,
                        通知書定型文, 介護問合せ先ソースビルダー, sourceBuilder, 表示コード, 更正前後期割額リスト,
                        随時リスト, 編集後宛先).writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * printA4縦タイプメソッドします。
     *
     * @param 発行日 FlexibleDate
     * @param 文書番号 RString
     * @param 減免取消通知書情報 GemmenTorikesiTsuchiShoJoho
     * @param 通知書定型文 RString
     * @param 介護問合せ先ソースビルダー IKaigoToiawasesakiSourceBuilder
     * @param reportManager ReportManager
     */
    public void printB5横タイプ(FlexibleDate 発行日, RString 文書番号, GemmenTorikesiTsuchiShoJoho 減免取消通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー, ReportManager reportManager) {
        GemmenTorikesiTsuchiShoB5YokoProperty property = new GemmenTorikesiTsuchiShoB5YokoProperty();
        try (ReportAssembler<KaigoHokenHokenryoGenmenTorikeshiTsuchishoB5YokoSource> assembler = createAssembler(property, reportManager)) {
            if (減免取消通知書情報 != null) {
                Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険, 種別コード,
                        発行日 == null || 発行日.isEmpty() ? FlexibleDate.getNowDate() : 発行日);
                Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
                ChohyoSeigyoKyotsu 帳票制御共通 = 減免取消通知書情報.get帳票制御共通();
                boolean is公印に掛ける = true;
                if (帳票制御共通 != null && RSTRING_1.equals(帳票制御共通.get首長名印字位置())) {
                    is公印に掛ける = true;
                }
                boolean is公印を省略 = false;
                if (帳票制御共通 != null && !帳票制御共通.is電子公印印字有無()) {
                    is公印を省略 = false;
                }
                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                        地方公共団体,
                        assembler.getImageFolderPath(),
                        発行日 == null || 発行日.isEmpty() ? RDate.getNowDate() : new RDate(発行日.toString()),
                        is公印に掛ける,
                        is公印を省略,
                        KenmeiFuyoKubunType.付与なし).buildSource();
                HyojiCodes 表示コード = get表示コード(減免取消通知書情報);
                List<KoseiZengoKiwariGaku> 更正前後期割額リスト = 更正前後期割額リストを生成(減免取消通知書情報);
                List<RString> 随時リスト = 随時リストを生成(減免取消通知書情報);
                EditedAtesaki 編集後宛先 = get編集後宛先(減免取消通知書情報);
                ReportSourceWriter<KaigoHokenHokenryoGenmenTorikeshiTsuchishoB5YokoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new GemmenTorikesiTsuchiShoB5YokoReport(文書番号, 減免取消通知書情報,
                        通知書定型文, 介護問合せ先ソースビルダー, sourceBuilder, 表示コード, 更正前後期割額リスト,
                        随時リスト, 編集後宛先).writeBy(reportSourceWriter);
            }
        }
    }

    private EditedAtesaki get編集後宛先(GemmenTorikesiTsuchiShoJoho 減免取消通知書情報) {
        EditedAtesaki 編集後宛先 = null;
        if (isNotNull(減免取消通知書情報.get宛先()) && isNotNull(減免取消通知書情報.get地方公共団体())
                && isNotNull(減免取消通知書情報.get宛先())) {
            編集後宛先 = JushoHenshu.create編集後宛先(減免取消通知書情報.get宛先(),
                    減免取消通知書情報.get地方公共団体(), 減免取消通知書情報.get帳票制御共通());
        }
        return 編集後宛先;
    }

    private HyojiCodes get表示コード(GemmenTorikesiTsuchiShoJoho 減免取消通知書情報) {
        HyojiCodes 表示コード = null;
        HyojiCodeResearcher researcher = new HyojiCodeResearcher();
        if (isNotNull(減免取消通知書情報.get帳票制御共通())) {
            IGyoseiKukaku 行政区画 = null;
            IJusho 住所 = null;
            if (isNotNull(減免取消通知書情報.get宛名())) {
                行政区画 = 減免取消通知書情報.get宛名().get行政区画();
                住所 = 減免取消通知書情報.get宛名().get住所();
            }

            表示コード = researcher.create表示コード情報(減免取消通知書情報.get帳票制御共通().toEntity(),
                    (住所 != null && 住所.get町域コード() != null) ? 住所.get町域コード().value() : RString.EMPTY,
                    (行政区画 != null && 行政区画.getGyoseiku() != null) ? 行政区画.getGyoseiku().getコード().value() : RString.EMPTY,
                    (行政区画 != null && 行政区画.getChiku1() != null) ? 行政区画.getChiku1().getコード().value() : RString.EMPTY,
                    (行政区画 != null && 行政区画.getChiku2() != null) ? 行政区画.getChiku2().getコード().value() : RString.EMPTY,
                    (行政区画 != null && 行政区画.getChiku3() != null) ? 行政区画.getChiku3().getコード().value() : RString.EMPTY,
                    (減免取消通知書情報.get納組情報() != null && 減免取消通知書情報.get納組情報().getNokumi() != null)
                            ? 減免取消通知書情報.get納組情報().getNokumi().getNokumiCode() : RString.EMPTY);
        }
        return 表示コード;
    }

    /**
     * 随時リストを生成する。
     *
     * @param 減免取消通知書情報 GemmenTorikesiTsuchiShoJoho
     * @return List<RString>
     */
    private List<RString> 随時リストを生成(GemmenTorikesiTsuchiShoJoho 減免取消通知書情報) {
        List<RString> 随時リスト = new ArrayList<>();
        KitsukiList 普徴期月リスト;
        if (減免取消通知書情報.get年度区分() == GennenKanen.現年度) {
            FuchoKiUtil fuchoKiUtil = new FuchoKiUtil();
            普徴期月リスト = fuchoKiUtil.get期月リスト();
        } else {
            KanendoKiUtil kanendoKiUtil = new KanendoKiUtil();
            普徴期月リスト = kanendoKiUtil.get期月リスト();
        }
        for (int index = INDEX_ONE; index <= INDEX_FOURTEEN; index++) {
            Kitsuki 期月普徴 = 普徴期月リスト.get期の最初月(index);
            if (期月普徴.get月処理区分() != null) {
                if (FuchokiJohoTsukiShoriKubun.随時.getName().equals(期月普徴.get月処理区分().getName())
                        || FuchokiJohoTsukiShoriKubun.現年随時.getName().equals(期月普徴.get月処理区分().getName())
                        || KanendoTsukiShoriKubun.随時 == 期月普徴.get月処理区分()) {
                    随時リスト.add(FuchokiJohoTsukiShoriKubun.随時.getName());
                } else {
                    随時リスト.add(RString.EMPTY);
                }
            }
        }
        return 随時リスト;
    }

    /**
     * 更正前後期割額リストを生成する。
     *
     * @param 減免取消通知書情報 GemmenTorikesiTsuchiShoJoho
     * @return List<KoseiZengoKiwariGaku>
     */
    private List<KoseiZengoKiwariGaku> 更正前後期割額リストを生成(GemmenTorikesiTsuchiShoJoho 減免取消通知書情報) {
        List<KoseiZengoKiwariGaku> 更正前後期割額リスト = new ArrayList<>();
        TokuchoKiUtil tokuchoKiUtil = new TokuchoKiUtil();
        KitsukiList 特徴期月リスト = tokuchoKiUtil.get期月リスト();
        KitsukiList 普徴期月リスト;
        if (減免取消通知書情報.get年度区分() == GennenKanen.現年度) {
            FuchoKiUtil fuchoKiUtil = new FuchoKiUtil();
            普徴期月リスト = fuchoKiUtil.get期月リスト();
        } else {
            KanendoKiUtil kanendoKiUtil = new KanendoKiUtil();
            普徴期月リスト = kanendoKiUtil.get期月リスト();
        }
        for (int index = INDEX_ONE; index <= INDEX_FOURTEEN; index++) {
            Kitsuki 期月特徴 = 特徴期月リスト.get期の最初月(index);
            Kitsuki 期月普徴 = 普徴期月リスト.get期の最初月(index);
            KoseiZengoKiwariGaku 更正前後期割額 = 更正前後期割額を生成(減免取消通知書情報, 期月特徴, 期月普徴);
            更正前後期割額リスト.add(更正前後期割額);
        }
        if (!has特別徴収(更正前後期割額リスト)) {
            clear特別徴収(更正前後期割額リスト);
        }
        if (!has普通徴収(更正前後期割額リスト)) {
            clear普通徴収(更正前後期割額リスト);
        }

        return 更正前後期割額リスト;
    }

    /**
     * 更正前後期割額を生成する。
     *
     * @param index int
     * @param 減免取消通知書情報 GemmenTorikesiTsuchiShoJoho
     * @param 期月特徴 Kitsuki
     * @param 期月普徴 Kitsuki
     * @return KoseiZengoKiwariGaku
     */
    private KoseiZengoKiwariGaku 更正前後期割額を生成(GemmenTorikesiTsuchiShoJoho 減免取消通知書情報,
            Kitsuki 期月特徴, Kitsuki 期月普徴) {
        KoseiZengoKiwariGaku 更正前後期割額 = new KoseiZengoKiwariGaku();
        if (期月特徴.isPresent()) {
            if (期月特徴.get期().length() < 2) {
                更正前後期割額.set特徴期(format月と期(期月特徴.get期().insert(INDEX_ZERO, RSTRING_0.toString())));
            } else {
                更正前後期割額.set特徴期(format月と期(期月特徴.get期()));
            }
            更正前後期割額.set特徴月(format月と期(get月(期月特徴)));
            Decimal 特徴期別金額取消前 = set特徴期別金額取消前(期月特徴.get期(), 減免取消通知書情報);
            if (特徴期別金額取消前 != null) {
                更正前後期割額.set特徴期別金額取消前(DecimalFormatter
                        .toコンマ区切りRString(特徴期別金額取消前, 0));
            } else {
                更正前後期割額.set特徴期別金額取消前(RSTRING_0);
            }
            Decimal 特徴期別金額取消後 = set特徴期別金額取消後(期月特徴.get期(), 減免取消通知書情報);
            if (特徴期別金額取消後 != null) {
                更正前後期割額.set特徴期別金額取消後(DecimalFormatter
                        .toコンマ区切りRString(特徴期別金額取消後, 0));
            } else {
                更正前後期割額.set特徴期別金額取消後(RSTRING_0);
            }
            if (特徴期別金額取消前 != null && 特徴期別金額取消後 != null) {
                更正前後期割額.set特徴減免取消額(get減免取消額(特徴期別金額取消後, 特徴期別金額取消前));
            } else if (特徴期別金額取消後 != null && 特徴期別金額取消前 == null) {
                更正前後期割額.set特徴減免取消額(DecimalFormatter
                        .toコンマ区切りRString(特徴期別金額取消後, 0));
            } else if (特徴期別金額取消後 == null && 特徴期別金額取消前 != null) {
                更正前後期割額.set特徴減免取消額(RSTRING_2.concat(DecimalFormatter
                        .toコンマ区切りRString(特徴期別金額取消前, 0)));
            } else {
                更正前後期割額.set特徴減免取消額(RSTRING_0);
            }
        } else {
            更正前後期割額.set特徴期(RString.EMPTY);
            更正前後期割額.set特徴月(RString.EMPTY);
            更正前後期割額.set特徴期別金額取消前(RString.EMPTY);
            更正前後期割額.set特徴減免取消額(RString.EMPTY);
            更正前後期割額.set特徴期別金額取消後(RString.EMPTY);
        }
        if (isZeroOrEmpty(更正前後期割額.get特徴期別金額取消前())
                && isZeroOrEmpty(更正前後期割額.get特徴減免取消額())
                && isZeroOrEmpty(更正前後期割額.get特徴期別金額取消後())) {
            更正前後期割額.set特徴期別金額取消前(RString.EMPTY);
            更正前後期割額.set特徴減免取消額(RString.EMPTY);
            更正前後期割額.set特徴期別金額取消後(RString.EMPTY);
        }
        get期月普徴情報(更正前後期割額, 減免取消通知書情報, 期月普徴);
        return 更正前後期割額;
    }

    private RString format月と期(RString value) {
        if (value.isEmpty()) {
            return value;
        }
        return new RString(Integer.valueOf(value.trim().toString())).padLeft(RString.HALF_SPACE, 2);
    }

    private void get期月普徴情報(KoseiZengoKiwariGaku 更正前後期割額,
            GemmenTorikesiTsuchiShoJoho 減免取消通知書情報,
            Kitsuki 期月普徴) {
        if (期月普徴.isPresent()) {
            if (期月普徴.get期().length() < 2) {
                更正前後期割額.set普徴期(format月と期(期月普徴.get期().insert(INDEX_ZERO, RSTRING_0.toString())));
            } else {
                更正前後期割額.set普徴期(format月と期(期月普徴.get期()));
            }
            更正前後期割額.set普徴月(format月と期(get月(期月普徴)));
            Decimal 普徴期別金額取消前 = set普徴期別金額取消前(期月普徴.get期(), 減免取消通知書情報);
            if (普徴期別金額取消前 != null) {
                更正前後期割額.set普徴期別金額取消前(DecimalFormatter
                        .toコンマ区切りRString(普徴期別金額取消前, 0));
            } else {
                更正前後期割額.set普徴期別金額取消前(RSTRING_0);
            }
            Decimal 普徴期別金額取消後 = set普徴期別金額取消後(期月普徴.get期(), 減免取消通知書情報);
            if (普徴期別金額取消後 != null) {
                更正前後期割額.set普徴期別金額取消後(DecimalFormatter
                        .toコンマ区切りRString(普徴期別金額取消後, 0));
            } else {
                更正前後期割額.set普徴期別金額取消後(RSTRING_0);
            }
            if (普徴期別金額取消後 != null && 普徴期別金額取消前 != null) {
                更正前後期割額.set普徴減免取消額(get減免取消額(普徴期別金額取消後, 普徴期別金額取消前));
            } else if (普徴期別金額取消後 != null && 普徴期別金額取消前 == null) {
                更正前後期割額.set普徴減免取消額(DecimalFormatter
                        .toコンマ区切りRString(普徴期別金額取消後, 0));
            } else if (普徴期別金額取消後 == null && 普徴期別金額取消前 != null) {
                更正前後期割額.set普徴減免取消額(RSTRING_2.concat(DecimalFormatter
                        .toコンマ区切りRString(普徴期別金額取消前, 0)));
            } else {
                更正前後期割額.set普徴減免取消額(RSTRING_0);
            }
        } else {
            更正前後期割額.set普徴月(RString.EMPTY);
            更正前後期割額.set普徴期(RString.EMPTY);
            更正前後期割額.set普徴期別金額取消前(RString.EMPTY);
            更正前後期割額.set普徴減免取消額(RString.EMPTY);
            更正前後期割額.set普徴期別金額取消後(RString.EMPTY);
        }
        if (isZeroOrEmpty(更正前後期割額.get普徴期別金額取消前())
                && isZeroOrEmpty(更正前後期割額.get普徴減免取消額())
                && isZeroOrEmpty(更正前後期割額.get普徴期別金額取消後())) {
            更正前後期割額.set普徴期別金額取消前(RString.EMPTY);
            更正前後期割額.set普徴減免取消額(RString.EMPTY);
            更正前後期割額.set普徴期別金額取消後(RString.EMPTY);
        }
    }

    private RString get減免取消額(Decimal 普徴期別金額取消後, Decimal 普徴期別金額取消前) {
        if (普徴期別金額取消後.equals(普徴期別金額取消前)) {
            return RSTRING_0;
        } else {
            return DecimalFormatter.toコンマ区切りRString(普徴期別金額取消後.subtract(普徴期別金額取消前), 0);
        }
    }

    private RString get月(Kitsuki 期月) {
        if (期月.get月().equals(Tsuki.翌年度4月)) {
            return Tsuki._4月.getコード();
        }
        if (期月.get月().equals(Tsuki.翌年度5月)) {
            return Tsuki._5月.getコード();
        }
        return 期月.get月().getコード();
    }

    private boolean has特別徴収(List<KoseiZengoKiwariGaku> 更正前後期割額リスト) {
        for (KoseiZengoKiwariGaku 更正前後期割額 : 更正前後期割額リスト) {
            if (!isZeroOrEmpty(更正前後期割額.get特徴期別金額取消前())
                    || !isZeroOrEmpty(更正前後期割額.get特徴期別金額取消後())
                    || !isZeroOrEmpty(更正前後期割額.get特徴減免取消額())) {
                return true;
            }
        }
        return false;
    }

    private boolean has普通徴収(List<KoseiZengoKiwariGaku> 更正前後期割額リスト) {
        for (KoseiZengoKiwariGaku 更正前後期割額 : 更正前後期割額リスト) {
            if (!isZeroOrEmpty(更正前後期割額.get普徴期別金額取消前())
                    || !isZeroOrEmpty(更正前後期割額.get普徴期別金額取消後())
                    || !isZeroOrEmpty(更正前後期割額.get普徴減免取消額())) {
                return true;
            }
        }
        return false;
    }

    private void clear普通徴収(List<KoseiZengoKiwariGaku> 更正前後期割額リスト) {
        for (KoseiZengoKiwariGaku 更正前後期割額 : 更正前後期割額リスト) {
            更正前後期割額.set普徴期別金額取消前(RString.EMPTY);
            更正前後期割額.set普徴減免取消額(RString.EMPTY);
            更正前後期割額.set普徴期別金額取消後(RString.EMPTY);
        }
    }

    private void clear特別徴収(List<KoseiZengoKiwariGaku> 更正前後期割額リスト) {
        for (KoseiZengoKiwariGaku 更正前後期割額 : 更正前後期割額リスト) {
            更正前後期割額.set特徴期別金額取消前(RString.EMPTY);
            更正前後期割額.set特徴減免取消額(RString.EMPTY);
            更正前後期割額.set特徴期別金額取消後(RString.EMPTY);
        }
    }

    private boolean isZeroOrEmpty(RString 割額) {
        return RString.isNullOrEmpty(割額) || RSTRING_0.equals(割額) || 負ゼロ.equals(割額);
    }

    /**
     * set特徴期別金額更正前します。
     *
     * @param 期 RString
     * @param 減免取消通知書情報 GemmenTorikesiTsuchiShoJoho
     * @return Decimal
     */
    private Decimal set特徴期別金額取消前(RString 期, GemmenTorikesiTsuchiShoJoho 減免取消通知書情報) {
        int index = Integer.parseInt(期.toString());
        if (減免取消通知書情報.get賦課の情報更正前() == null) {
            return Decimal.ZERO;
        }
        switch (index) {
            case INDEX_ONE:
                return 減免取消通知書情報.get賦課の情報更正前().get特徴期別金額01();
            case INDEX_TWO:
                return 減免取消通知書情報.get賦課の情報更正前().get特徴期別金額02();
            case INDEX_THREE:
                return 減免取消通知書情報.get賦課の情報更正前().get特徴期別金額03();
            case INDEX_FOUR:
                return 減免取消通知書情報.get賦課の情報更正前().get特徴期別金額04();
            case INDEX_FIVE:
                return 減免取消通知書情報.get賦課の情報更正前().get特徴期別金額05();
            case INDEX_SIX:
                return 減免取消通知書情報.get賦課の情報更正前().get特徴期別金額06();
            default:
                return null;
        }
    }

    /**
     * set特徴期別金額更正後します。
     *
     * @param 期 RString
     * @param 減免取消通知書情報 GemmenTorikesiTsuchiShoJoho
     * @return Decimal
     */
    private Decimal set特徴期別金額取消後(RString 期, GemmenTorikesiTsuchiShoJoho 減免取消通知書情報) {
        int index = Integer.parseInt(期.toString());
        if (減免取消通知書情報.get減免の情報更正後() == null) {
            return Decimal.ZERO;
        }
        switch (index) {
            case INDEX_ONE:
                return 減免取消通知書情報.get減免の情報更正後().get特徴期別金額01();
            case INDEX_TWO:
                return 減免取消通知書情報.get減免の情報更正後().get特徴期別金額02();
            case INDEX_THREE:
                return 減免取消通知書情報.get減免の情報更正後().get特徴期別金額03();
            case INDEX_FOUR:
                return 減免取消通知書情報.get減免の情報更正後().get特徴期別金額04();
            case INDEX_FIVE:
                return 減免取消通知書情報.get減免の情報更正後().get特徴期別金額05();
            case INDEX_SIX:
                return 減免取消通知書情報.get減免の情報更正後().get特徴期別金額06();
            default:
                return null;
        }
    }

    /**
     * set普徴期別金額更正前します。
     *
     * @param 期 期
     * @param 減免取消通知書情報 GemmenTorikesiTsuchiShoJoho
     * @return Decimal
     */
    private Decimal set普徴期別金額取消前(RString 期, GemmenTorikesiTsuchiShoJoho 減免取消通知書情報) {
        int index = Integer.parseInt(期.toString());
        if (減免取消通知書情報.get賦課の情報更正前() == null) {
            return Decimal.ZERO;
        }
        switch (index) {
            case INDEX_ONE:
                return 減免取消通知書情報.get賦課の情報更正前().get普徴期別金額01();
            case INDEX_TWO:
                return 減免取消通知書情報.get賦課の情報更正前().get普徴期別金額02();
            case INDEX_THREE:
                return 減免取消通知書情報.get賦課の情報更正前().get普徴期別金額03();
            case INDEX_FOUR:
                return 減免取消通知書情報.get賦課の情報更正前().get普徴期別金額04();
            case INDEX_FIVE:
                return 減免取消通知書情報.get賦課の情報更正前().get普徴期別金額05();
            case INDEX_SIX:
                return 減免取消通知書情報.get賦課の情報更正前().get普徴期別金額06();
            case INDEX_SEVEN:
                return 減免取消通知書情報.get賦課の情報更正前().get普徴期別金額07();
            case INDEX_EIGHT:
                return 減免取消通知書情報.get賦課の情報更正前().get普徴期別金額08();
            case INDEX_NINE:
                return 減免取消通知書情報.get賦課の情報更正前().get普徴期別金額09();
            case INDEX_TEN:
                return 減免取消通知書情報.get賦課の情報更正前().get普徴期別金額10();
            case INDEX_ELEVEN:
                return 減免取消通知書情報.get賦課の情報更正前().get普徴期別金額11();
            case INDEX_TWELVE:
                return 減免取消通知書情報.get賦課の情報更正前().get普徴期別金額12();
            case INDEX_THIRTEEN:
                return 減免取消通知書情報.get賦課の情報更正前().get普徴期別金額13();
            case INDEX_FOURTEEN:
                return 減免取消通知書情報.get賦課の情報更正前().get普徴期別金額14();
            default:
                return null;
        }
    }

    /**
     * set普徴期別金額更正後します。
     *
     * @param 期 期
     * @param 減免取消通知書情報 GemmenTorikesiTsuchiShoJoho
     * @return Decimal
     */
    private Decimal set普徴期別金額取消後(RString 期, GemmenTorikesiTsuchiShoJoho 減免取消通知書情報) {
        int index = Integer.parseInt(期.toString());
        if (減免取消通知書情報.get減免の情報更正後() == null) {
            return Decimal.ZERO;
        }
        switch (index) {
            case INDEX_ONE:
                return 減免取消通知書情報.get減免の情報更正後().get普徴期別金額01();
            case INDEX_TWO:
                return 減免取消通知書情報.get減免の情報更正後().get普徴期別金額02();
            case INDEX_THREE:
                return 減免取消通知書情報.get減免の情報更正後().get普徴期別金額03();
            case INDEX_FOUR:
                return 減免取消通知書情報.get減免の情報更正後().get普徴期別金額04();
            case INDEX_FIVE:
                return 減免取消通知書情報.get減免の情報更正後().get普徴期別金額05();
            case INDEX_SIX:
                return 減免取消通知書情報.get減免の情報更正後().get普徴期別金額06();
            case INDEX_SEVEN:
                return 減免取消通知書情報.get減免の情報更正後().get普徴期別金額07();
            case INDEX_EIGHT:
                return 減免取消通知書情報.get減免の情報更正後().get普徴期別金額08();
            case INDEX_NINE:
                return 減免取消通知書情報.get減免の情報更正後().get普徴期別金額09();
            case INDEX_TEN:
                return 減免取消通知書情報.get減免の情報更正後().get普徴期別金額10();
            case INDEX_ELEVEN:
                return 減免取消通知書情報.get減免の情報更正後().get普徴期別金額11();
            case INDEX_TWELVE:
                return 減免取消通知書情報.get減免の情報更正後().get普徴期別金額12();
            case INDEX_THIRTEEN:
                return 減免取消通知書情報.get減免の情報更正後().get普徴期別金額13();
            case INDEX_FOURTEEN:
                return 減免取消通知書情報.get減免の情報更正後().get普徴期別金額14();
            default:
                return null;
        }
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
