/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.gemmen;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.gemmen.GenmenKetteiTsuchiShoItem;
import jp.co.ndensan.reams.db.dbb.business.report.gemmen.GenmenKetteiTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.gemmen.GenmenKetteiTsuchiShoTateProperty;
import jp.co.ndensan.reams.db.dbb.business.report.gemmen.GenmenKetteiTsuchiShoTateReport;
import jp.co.ndensan.reams.db.dbb.business.report.gemmen.GenmenKetteiTsuchiShoYokoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.gemmen.GenmenKetteiTsuchiShoYokoReport;
import jp.co.ndensan.reams.db.dbb.business.report.gemmen.KoseiZengoKiwariGaku;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.entity.report.gemmen.KaigoHokenryoGenmenKetteiTsuchishoTateSource;
import jp.co.ndensan.reams.db.dbb.entity.report.gemmen.KaigoHokenryoGenmenKetteiTsuchishoYokoSource;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HyojiCodeResearcher;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.fucho.FuchokiJohoTsukiShoriKubun;
import jp.co.ndensan.reams.db.dbz.business.core.kaigosofubutsuatesakisource.KaigoSofubutsuAtesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha._NinshoshaManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護保険料減免決定通知書PrintService
 */
public class GenmenKetteiTsuchiShoPrintService {

    private static final RString 随時 = new RString("随時");
    private static final RString 種別コード = new RString("DBB100078");
    private static final RString 年度 = new RString("年度");
    private static final RString ZERO = new RString("0");
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
     * printA4縦タイプメソッド
     *
     * @param 発行日 FlexibleDate
     * @param 文書番号 RString
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     * @param 通知書定型文 RString
     * @param 介護問合せ先ソースビルダー IKaigoToiawasesakiSourceBuilder
     * @return SourceDataCollection
     */
    public SourceDataCollection printA4縦タイプ(FlexibleDate 発行日, RString 文書番号, GenmenKetteiTsuchiShoJoho 減免決定通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー) {
        GenmenKetteiTsuchiShoTateProperty property = new GenmenKetteiTsuchiShoTateProperty();
//        List<GenmenKetteiTsuchiShoItem> targets = setItemList();
        List<GenmenKetteiTsuchiShoItem> targets = setItems(発行日, 文書番号, 減免決定通知書情報, 通知書定型文, 介護問合せ先ソースビルダー);
        return new Printer<KaigoHokenryoGenmenKetteiTsuchishoTateSource>().spool(property, toReportsA4縦タイプ(targets));
    }

    /**
     * toReportsA4縦タイプメソッド
     *
     * @param targets List<GenmenKetteiTsuchiShoItem>
     * @return List<GenmenKetteiTsuchiShoTateReport>
     */
    private static List<GenmenKetteiTsuchiShoTateReport> toReportsA4縦タイプ(List<GenmenKetteiTsuchiShoItem> targets) {
        List<GenmenKetteiTsuchiShoTateReport> list = new ArrayList<>();
        list.add(GenmenKetteiTsuchiShoTateReport.createForm(targets));
        return list;
    }

    /**
     * printB5横タイプメソッド
     *
     * @param 発行日 FlexibleDate
     * @param 文書番号 RString
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     * @param 通知書定型文 RString
     * @param 介護問合せ先ソースビルダー IKaigoToiawasesakiSourceBuilder
     * @return SourceDataCollection
     */
    public SourceDataCollection printB5横タイプ(FlexibleDate 発行日, RString 文書番号,
            GenmenKetteiTsuchiShoJoho 減免決定通知書情報, RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー) {
        GenmenKetteiTsuchiShoYokoProperty property = new GenmenKetteiTsuchiShoYokoProperty();
        List<GenmenKetteiTsuchiShoItem> targets = setItems(発行日, 文書番号, 減免決定通知書情報, 通知書定型文, 介護問合せ先ソースビルダー);
        return new Printer<KaigoHokenryoGenmenKetteiTsuchishoYokoSource>().spool(property, toReportsB5横タイプ(targets));
    }

    /**
     * toReportsB5横タイプメソッド
     *
     * @param targets List<GenmenKetteiTsuchiShoItem>
     * @return List<GenmenKetteiTsuchiShoYokoReport>
     */
    private static List<GenmenKetteiTsuchiShoYokoReport> toReportsB5横タイプ(List<GenmenKetteiTsuchiShoItem> targets) {
        List<GenmenKetteiTsuchiShoYokoReport> list = new ArrayList<>();
        list.add(GenmenKetteiTsuchiShoYokoReport.createForm(targets));
        return list;
    }

    /**
     * setItemsメソッド
     *
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     * @return List<GenmenKetteiTsuchiShoItem>
     */
    private List<GenmenKetteiTsuchiShoItem> setItems(FlexibleDate 発行日, RString 文書番号,
            GenmenKetteiTsuchiShoJoho 減免決定通知書情報, RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー) {
        List<GenmenKetteiTsuchiShoItem> items = new ArrayList<>();
        List<KoseiZengoKiwariGaku> 更正前後期割額リスト = 更正前後期割額リストを生成(減免決定通知書情報);
        List<RString> 随時リスト = 随時リストを生成();
        for (int index = INDEX_ZERO; index < INDEX_FOURTEEN; index++) {
            GenmenKetteiTsuchiShoItem item = new GenmenKetteiTsuchiShoItem();
            item.set期別1(更正前後期割額リスト.get(index).get特徴期());
            item.set期別2(更正前後期割額リスト.get(index).get特徴月());
            item.set期別3(更正前後期割額リスト.get(index).get特徴期別金額更正前());
            item.set期別4(更正前後期割額リスト.get(index).get特徴期別金額更正後());
            item.set期別5(更正前後期割額リスト.get(index).get普徴期());
            item.set期別6(更正前後期割額リスト.get(index).get普徴月());
            item.set期別7(更正前後期割額リスト.get(index).get普徴期別金額更正前());
            item.set期別8(更正前後期割額リスト.get(index).get普徴期別金額更正後());
            item.set随時List(随時リスト.get(index));
            if (index == INDEX_THIRTEEN) {
                setBaseItem(item, 減免決定通知書情報, 文書番号, 通知書定型文, 発行日, 介護問合せ先ソースビルダー);
            }
            items.add(item);
        }

        return items;
    }

    /**
     * setBaseItem
     *
     * @param item GenmenKetteiTsuchiShoItem
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     */
    private void setBaseItem(GenmenKetteiTsuchiShoItem item, GenmenKetteiTsuchiShoJoho 減免決定通知書情報,
            RString 文書番号, RString 通知書定型文, FlexibleDate 発行日, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー) {
        item.set文書番号(文書番号);
        item.set調定年度(減免決定通知書情報.get減免の情報更正後().get介護賦課().getChoteiNendo().wareki().eraType(EraType.KANJI).toDateString());
        item.set賦課年度(減免決定通知書情報.get減免の情報更正後().get介護賦課().getFukaNendo().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).toDateString().concat(年度));
        item.set決定結果(減免決定通知書情報.get減免の情報更正後().get介護賦課減免().getJotaiKubun());
        HyojiCodeResearcher researcher = new HyojiCodeResearcher();
        if (isNotNull(減免決定通知書情報.get帳票制御共通()) && isNotNull(減免決定通知書情報.get宛名()) && isNotNull(減免決定通知書情報.get納組情報())) {

            HyojiCodes 表示コード = researcher.create表示コード情報(減免決定通知書情報.get帳票制御共通().toEntity(),
                    減免決定通知書情報.get宛名().get住所().get町域コード().value(),
                    減免決定通知書情報.get宛名().get行政区画().getGyoseiku().getコード().value(), 減免決定通知書情報.get宛名().get行政区画().getChiku1().getコード().value(),
                    減免決定通知書情報.get宛名().get行政区画().getChiku2().getコード().value(), 減免決定通知書情報.get宛名().get行政区画().getChiku3().getコード().value(),
                    減免決定通知書情報.get納組情報().getNokumi().getNokumiCode());
            if (isNotNull(表示コード)) {
                item.set表示コード名称１(表示コード.get表示コード名１());
                item.set表示コード名称２(表示コード.get表示コード名２());
                item.set表示コード名称３(表示コード.get表示コード名３());
                item.set表示コード１(表示コード.get表示コード１());
                item.set表示コード２(表示コード.get表示コード２());
                item.set表示コード３(表示コード.get表示コード３());

            }
        }
        item.set通知書番号(減免決定通知書情報.get減免の情報更正後().get介護賦課().getTsuchishoNo().value());
        SetaiCode 世帯コード = 減免決定通知書情報.get減免の情報更正後().get介護賦課().getSetaiCode();
        if (世帯コード != null) {
            item.set世帯コード(世帯コード.value());
        }
        item.set被保険者番号(減免決定通知書情報.get減免の情報更正後().get介護賦課().getHihokenshaNo().value());
        ShikibetsuCode 識別コード = 減免決定通知書情報.get減免の情報更正後().get介護賦課().getShikibetsuCode();
        if (識別コード != null) {
            item.set識別コード(識別コード.value());
        }
        item.set減免決定年月日(減免決定通知書情報.get減免の情報更正後().get介護賦課減免().getKetteiYMD().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        item.set減免額前(DecimalFormatter.toコンマ区切りRString(減免決定通知書情報
                .get賦課の情報更正前().get介護賦課().getGemmenGaku(), 0));
        item.set保険料算出額前(DecimalFormatter.toコンマ区切りRString(減免決定通知書情報
                .get賦課の情報更正前().get介護賦課().getGemmenMaeHokenryo(), 0));
        item.set保険料額前(DecimalFormatter.toコンマ区切りRString(減免決定通知書情報
                .get賦課の情報更正前().get介護賦課().getKakuteiHokenryo(), 0));
        item.set減免額後(DecimalFormatter.toコンマ区切りRString(減免決定通知書情報
                .get減免の情報更正後().get介護賦課().getGemmenGaku(), 0));
        item.set保険料算出額後(DecimalFormatter.toコンマ区切りRString(減免決定通知書情報
                .get減免の情報更正後().get介護賦課().getGemmenMaeHokenryo(), 0));
        item.set保険料額後(DecimalFormatter.toコンマ区切りRString(減免決定通知書情報
                .get減免の情報更正後().get介護賦課().getKakuteiHokenryo(), 0));
        item.set減免理由1(減免決定通知書情報.get減免の情報更正後().get介護賦課減免().getGemmenJiyuCode().value());
        item.set減免理由2(減免決定通知書情報.get減免の情報更正後().get介護賦課減免().getGemmenJiyu());
        item.set備考Title(通知書定型文);
        item.set備考(通知書定型文);

        INinshoshaManager manager = new _NinshoshaManager();
        Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 種別コード);
        if (isNotNull(減免決定通知書情報)) {

            GenmenKetteiTsuchiShoTateProperty property = new GenmenKetteiTsuchiShoTateProperty();
            ReportManager reportManager = new ReportManager();
            ReportAssembler<KaigoHokenryoGenmenKetteiTsuchishoTateSource> assembler = createAssembler(property, reportManager);
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                    減免決定通知書情報.get地方公共団体(), assembler.getImageFolderPath(),
                    new RDate(発行日.toString())).buildSource();
            if (sourceBuilder != null) {
                item.set発行日(sourceBuilder.hakkoYMD);
                item.set電子公印(sourceBuilder.denshiKoin);
                item.set認証者役職名(sourceBuilder.ninshoshaYakushokuMei);
                item.set認証者役職名1(sourceBuilder.ninshoshaYakushokuMei1);
                item.set公印文字列(sourceBuilder.koinMojiretsu);
                item.set認証者役職名2(sourceBuilder.ninshoshaYakushokuMei2);
                item.set認証者氏名公印に掛けない(sourceBuilder.ninshoshaShimeiKakenai);
                item.set認証者氏名公印に掛ける(sourceBuilder.ninshoshaShimeiKakeru);
                item.set公印省略(sourceBuilder.koinShoryaku);

            }
        }
//        GenmenKetteiTsuchiShoTateProperty property = new GenmenKetteiTsuchiShoTateProperty();
//        try (ReportManager reportManager = new ReportManager()) {
//            try (ReportAssembler<KaigoHokenryoGenmenKetteiTsuchishoTateSource> assembler = createAssembler(property, reportManager)) {
//                Ninshosha ninshosha = NinshoshaFinderFactory.createInstance().
//                        get帳票認証者(GyomuCode.DB介護保険, 種別コード);
//                NinshoshaSource ninshoshaSource = getNinshosha(assembler, ninshosha, new RDate(発行日.toString()));
//                if (ninshoshaSource != null) {
//                    item.set発行日(ninshoshaSource.hakkoYMD);
//                    item.set電子公印(ninshoshaSource.denshiKoin);
//                    item.set認証者役職名(ninshoshaSource.ninshoshaYakushokuMei);
//                    item.set認証者役職名1(ninshoshaSource.ninshoshaYakushokuMei1);
//                    item.set公印文字列(ninshoshaSource.koinMojiretsu);
//                    item.set認証者役職名2(ninshoshaSource.ninshoshaYakushokuMei2);
//                    item.set認証者氏名公印に掛けない(ninshoshaSource.ninshoshaShimeiKakenai);
//                    item.set認証者氏名公印に掛ける(ninshoshaSource.ninshoshaShimeiKakeru);
//                    item.set公印省略(ninshoshaSource.koinShoryaku);
//
//                }
//            }
//
//        }

        if (isNotNull(介護問合せ先ソースビルダー)) {

            CompKaigoToiawasesakiSource buildSource = 介護問合せ先ソースビルダー.buildSource();
            item.set郵便番号Bango(buildSource.yubinBango);
            item.set所在地(buildSource.shozaichi);
            item.set庁舎部署名(buildSource.choshaBushoName);
            item.set担当名(buildSource.tantoName);
            item.set電話番号(buildSource.telNo);
            item.set内線(buildSource.naisenLabel);
            item.set内線番号(buildSource.naisenNo);
        }
        if (isNotNull(減免決定通知書情報.get宛先()) && isNotNull(減免決定通知書情報.get地方公共団体()) && isNotNull(減免決定通知書情報.get帳票制御共通())) {
            EditedAtesaki 編集後宛先 = new EditedAtesaki(減免決定通知書情報.get宛先(),
                    減免決定通知書情報.get地方公共団体(),
                    減免決定通知書情報.get帳票制御共通(),
                    null, null, true, null, null, null, null);
            KaigoSofubutsuAtesakiSource source = 編集後宛先.getSofubutsuAtesakiSource();
            if (source != null) {
                item.set郵便番号No(source.get送付物宛先ソース().yubinNo);
                item.set行政区(source.get送付物宛先ソース().gyoseiku);
                item.set住所3(source.get送付物宛先ソース().jusho3);
                item.set住所(source.get送付物宛先ソース().jushoText);
                item.set住所1(source.get送付物宛先ソース().jusho1);

                item.set住所2(source.get送付物宛先ソース().jusho2);
                item.set方書(source.get送付物宛先ソース().katagakiText);
                item.set方書2(source.get送付物宛先ソース().katagaki2);
                item.set方書Small2(source.get送付物宛先ソース().katagakiSmall2);
                item.set方書1(source.get送付物宛先ソース().katagaki1);
                item.set方書Small1(source.get送付物宛先ソース().katagakiSmall1);
                item.set右括弧2(source.get送付物宛先ソース().kakkoRight2);
                item.set右括弧1(source.get送付物宛先ソース().kakkoRight1);
                item.set氏名2(source.get送付物宛先ソース().shimei2);
                item.set氏名Small2(source.get送付物宛先ソース().shimeiSmall2);
                item.set氏名(source.get送付物宛先ソース().shimeiText);
                item.set名称付与2(source.get送付物宛先ソース().meishoFuyo2);
                item.set氏名Small1(source.get送付物宛先ソース().shimeiSmall1);
                item.set代納区分名(source.get送付物宛先ソース().dainoKubunMei);
                item.set氏名1(source.get送付物宛先ソース().shimei1);
                item.set名称付与1(source.get送付物宛先ソース().meishoFuyo1);
                item.set様分氏名(source.get送付物宛先ソース().samabunShimeiText);
                item.set様分氏名Small2(source.get送付物宛先ソース().samabunShimeiSmall2);
                item.set様分2(source.get送付物宛先ソース().samaBun2);
                item.set左括弧2(source.get送付物宛先ソース().kakkoLeft2);
                item.set様分氏名2(source.get送付物宛先ソース().samabunShimei2);
                item.set左括弧1(source.get送付物宛先ソース().kakkoLeft1);
                item.set様分氏名1(source.get送付物宛先ソース().samabunShimei1);
                item.set様分1(source.get送付物宛先ソース().samaBun1);
                item.set様分氏名Small1(source.get送付物宛先ソース().samabunShimeiSmall1);
                item.setカスタマバーコード(source.get送付物宛先ソース().customerBarCode);

            }

        }
        // TODO 世帯主名
        // TODO 様方
    }

    /**
     * 随時リストを生成する
     *
     * @return List<RString>
     */
    private List<RString> 随時リストを生成() {
        List<RString> 随時リスト = new ArrayList<>();
        FuchoKiUtil fuchoKiUtil = new FuchoKiUtil();
        KitsukiList 普徴期月リスト = fuchoKiUtil.get期月リスト();
        for (int index = INDEX_ZERO; index < INDEX_FOURTEEN; index++) {
            Kitsuki 期月普徴 = 普徴期月リスト.get期の最初月(index);
            if (期月普徴.get月処理区分().getName().equals(FuchokiJohoTsukiShoriKubun.随時.getName())
                    || 期月普徴.get月処理区分().getName().equals(FuchokiJohoTsukiShoriKubun.現年随時.getName())) {
                随時リスト.add(随時);
            } else {
                随時リスト.add(RString.EMPTY);
            }
        }
        return 随時リスト;
    }

    /**
     * 更正前後期割額リストを生成
     *
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     * @return List<KoseiZengoKiwariGaku>
     */
    private List<KoseiZengoKiwariGaku> 更正前後期割額リストを生成(GenmenKetteiTsuchiShoJoho 減免決定通知書情報) {
        List<KoseiZengoKiwariGaku> 更正前後期割額リスト = new ArrayList<>();
        TokuchoKiUtil tokuchoKiUtil = new TokuchoKiUtil();
        KitsukiList 特徴期月リスト = tokuchoKiUtil.get期月リスト();
        FuchoKiUtil fuchoKiUtil = new FuchoKiUtil();
        KitsukiList 普徴期月リスト = fuchoKiUtil.get期月リスト();
        for (int index = INDEX_ZERO; index < INDEX_FOURTEEN; index++) {
            Kitsuki 期月特徴 = 特徴期月リスト.get期の最初月(index);
            Kitsuki 期月普徴 = 普徴期月リスト.get期の最初月(index);
            KoseiZengoKiwariGaku 更正前後期割額 = 更正前後期割額を生成(index, 減免決定通知書情報, 期月特徴, 期月普徴);
            更正前後期割額リスト.add(更正前後期割額);
        }
        return 更正前後期割額リスト;
    }

    /**
     * 更正前後期割額を生成
     *
     * @param index int
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     * @param 期月特徴 Kitsuki
     * @param 期月普徴 Kitsuki
     * @return KoseiZengoKiwariGaku
     */
    private KoseiZengoKiwariGaku 更正前後期割額を生成(int index, GenmenKetteiTsuchiShoJoho 減免決定通知書情報,
            Kitsuki 期月特徴, Kitsuki 期月普徴) {
        KoseiZengoKiwariGaku 更正前後期割額 = new KoseiZengoKiwariGaku();
        if (期月特徴.isPresent()) {
            更正前後期割額.set特徴期(期月特徴.get期().insert(INDEX_ZERO, ZERO.toString()));
            if (期月特徴.get月AsInt() < INDEX_TEN) {
                更正前後期割額.set特徴月(new RString(ZERO.toString() + 期月特徴.get月AsInt()));
            } else {
                更正前後期割額.set特徴月(new RString(String.valueOf(期月特徴.get月AsInt())));
            }
            更正前後期割額.set特徴期別金額更正前(DecimalFormatter
                    .toコンマ区切りRString(set特徴期別金額更正前(index, 減免決定通知書情報), 0));
            更正前後期割額.set特徴期別金額更正後(DecimalFormatter
                    .toコンマ区切りRString(set特徴期別金額更正後(index, 減免決定通知書情報), 0));
        } else {
            更正前後期割額.set特徴期(RString.EMPTY);
            更正前後期割額.set特徴月(RString.EMPTY);
            更正前後期割額.set特徴期別金額更正前(RString.EMPTY);
            更正前後期割額.set特徴期別金額更正後(RString.EMPTY);
        }
        if (期月普徴.isPresent()) {
            if (期月普徴.get期().length() < 2) {
                更正前後期割額.set普徴期(期月普徴.get期().insert(INDEX_ZERO, ZERO.toString()));
            } else {
                更正前後期割額.set普徴期(期月普徴.get期());
            }
            if (期月普徴.get月AsInt() < INDEX_TEN) {
                更正前後期割額.set普徴月(new RString(ZERO.toString() + 期月普徴.get月AsInt()));
            } else {
                更正前後期割額.set普徴月(new RString(String.valueOf(期月普徴.get月AsInt())));
            }
            更正前後期割額.set普徴期別金額更正前(DecimalFormatter
                    .toコンマ区切りRString(set普徴期別金額更正前(index, 減免決定通知書情報), 0));
            更正前後期割額.set普徴期別金額更正後(DecimalFormatter
                    .toコンマ区切りRString(set普徴期別金額更正後(index, 減免決定通知書情報), 0));

        } else {
            更正前後期割額.set普徴月(RString.EMPTY);
            更正前後期割額.set普徴期(RString.EMPTY);
            更正前後期割額.set普徴期別金額更正前(RString.EMPTY);
            更正前後期割額.set普徴期別金額更正後(RString.EMPTY);
        }
        return 更正前後期割額;
    }

    /**
     * set特徴期別金額更正前
     *
     * @param index int
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     * @return Decimal
     */
    private Decimal set特徴期別金額更正前(int index, GenmenKetteiTsuchiShoJoho 減免決定通知書情報) {
        switch (index) {
            case INDEX_ONE:
                return 減免決定通知書情報.get賦課の情報更正前().get特徴期別金額01();
            case INDEX_TWO:
                return 減免決定通知書情報.get賦課の情報更正前().get特徴期別金額02();
            case INDEX_THREE:
                return 減免決定通知書情報.get賦課の情報更正前().get特徴期別金額03();
            case INDEX_FOUR:
                return 減免決定通知書情報.get賦課の情報更正前().get特徴期別金額04();
            case INDEX_FIVE:
                return 減免決定通知書情報.get賦課の情報更正前().get特徴期別金額05();
            default:
                return 減免決定通知書情報.get賦課の情報更正前().get特徴期別金額06();
        }
    }

    /**
     * set特徴期別金額更正後
     *
     * @param index int
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     * @return Decimal
     */
    private Decimal set特徴期別金額更正後(int index, GenmenKetteiTsuchiShoJoho 減免決定通知書情報) {
        switch (index) {
            case INDEX_ONE:
                return 減免決定通知書情報.get減免の情報更正後().get特徴期別金額01();
            case INDEX_TWO:
                return 減免決定通知書情報.get減免の情報更正後().get特徴期別金額02();
            case INDEX_THREE:
                return 減免決定通知書情報.get減免の情報更正後().get特徴期別金額03();
            case INDEX_FOUR:
                return 減免決定通知書情報.get減免の情報更正後().get特徴期別金額04();
            case INDEX_FIVE:
                return 減免決定通知書情報.get減免の情報更正後().get特徴期別金額05();
            default:
                return 減免決定通知書情報.get減免の情報更正後().get特徴期別金額06();
        }
    }

    /**
     * set普徴期別金額更正前
     *
     * @param index int
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     * @return Decimal
     */
    private Decimal set普徴期別金額更正前(int index, GenmenKetteiTsuchiShoJoho 減免決定通知書情報) {
        switch (index) {
            case INDEX_ONE:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額01();
            case INDEX_TWO:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額02();
            case INDEX_THREE:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額03();
            case INDEX_FOUR:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額04();
            case INDEX_FIVE:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額05();
            case INDEX_SIX:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額06();
            case INDEX_SEVEN:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額07();
            case INDEX_EIGHT:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額08();
            case INDEX_NINE:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額09();
            case INDEX_TEN:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額10();
            case INDEX_ELEVEN:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額11();
            case INDEX_TWELVE:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額12();
            case INDEX_THIRTEEN:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額13();
            default:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額14();
        }
    }

    /**
     * set普徴期別金額更正後
     *
     * @param index int
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     * @return Decimal
     */
    private Decimal set普徴期別金額更正後(int index, GenmenKetteiTsuchiShoJoho 減免決定通知書情報) {
        switch (index) {
            case INDEX_ONE:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額01();
            case INDEX_TWO:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額02();
            case INDEX_THREE:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額03();
            case INDEX_FOUR:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額04();
            case INDEX_FIVE:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額05();
            case INDEX_SIX:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額06();
            case INDEX_SEVEN:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額07();
            case INDEX_EIGHT:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額08();
            case INDEX_NINE:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額09();
            case INDEX_TEN:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額10();
            case INDEX_ELEVEN:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額11();
            case INDEX_TWELVE:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額12();
            case INDEX_THIRTEEN:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額13();
            default:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額14();
        }
    }

    private boolean isNotNull(Object object) {

        return object != null;
    }

    private List<GenmenKetteiTsuchiShoItem> setItemList() {
        List<GenmenKetteiTsuchiShoItem> itemList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            GenmenKetteiTsuchiShoItem item = new GenmenKetteiTsuchiShoItem();
            item.set文書番号(new RString("1"));
            item.set調定年度(new RString("2"));
            item.set賦課年度(new RString("3"));
            item.set決定結果(new RString("4"));
            item.set表示コード名称１(new RString("5"));
            item.set表示コード名称２(new RString("6"));
            item.set表示コード名称３(new RString("7"));
            item.set表示コード１(new RString("8"));
            item.set表示コード２(new RString("9"));
            item.set表示コード３(new RString("10"));
            item.set通知書番号(new RString("11"));
            item.set世帯コード(new RString("81"));
            item.set被保険者番号(new RString("12"));
            item.set識別コード(new RString("13"));
            item.set減免決定年月日(new RString("14"));
            item.set減免額前(new RString("15"));
            item.set保険料算出額前(new RString("16"));
            item.set保険料額前(new RString("17"));
            item.set減免額後(new RString("18"));
            item.set保険料算出額後(new RString("19"));
            item.set保険料額後(new RString("20"));
            item.set減免理由1(new RString("21"));
            item.set減免理由2(new RString("22"));
            item.set期別1(new RString("23"));
            item.set期別2(new RString("24"));
            item.set期別3(new RString("25"));
            item.set期別4(new RString("26"));
            item.set期別5(new RString("27"));
            item.set期別6(new RString("28"));
            item.set期別7(new RString("29"));
            item.set期別8(new RString("30"));
            item.set随時List(new RString("31"));
            item.set備考Title(new RString("32"));
            item.set備考(new RString("33"));
            item.set発行日(new RString("34"));
            item.set電子公印(new RString("35"));
            item.set認証者役職名(new RString("36"));
            item.set認証者役職名1(new RString("37"));
            item.set公印文字列(new RString("38"));
            item.set認証者役職名2(new RString("39"));
            item.set認証者氏名公印に掛けない(new RString("40"));
            item.set認証者氏名公印に掛ける(new RString("41"));
            item.set公印省略(new RString("42"));
            item.set郵便番号Bango(new RString("43"));
            item.set所在地(new RString("44"));
            item.set庁舎部署名(new RString("45"));
            item.set担当名(new RString("46"));
            item.set電話番号(new RString("47"));
            item.set内線(new RString("48"));
            item.set内線番号(new RString("49"));
            item.set郵便番号No(new RString("50"));
            item.set行政区(new RString("51"));
            item.set住所3(new RString("52"));
            item.set住所(new RString("53"));
            item.set住所1(new RString("54"));
            item.set住所2(new RString("55"));
            item.set方書(new RString("56"));
            item.set方書2(new RString("57"));
            item.set方書Small2(new RString("58"));
            item.set方書1(new RString("59"));
            item.set方書Small1(new RString("60"));
            item.set右括弧2(new RString("61"));
            item.set右括弧1(new RString("62"));
            item.set氏名2(new RString("63"));
            item.set氏名Small2(new RString("64"));
            item.set氏名(new RString("65"));
            item.set名称付与2(new RString("66"));
            item.set氏名Small1(new RString("67"));
            item.set代納区分名(new RString("68"));
            item.set氏名1(new RString("69"));
            item.set名称付与1(new RString("70"));
            item.set様分氏名(new RString("71"));
            item.set様分氏名Small2(new RString("72"));
            item.set様分2(new RString("73"));
            item.set左括弧2(new RString("74"));
            item.set様分氏名2(new RString("75"));
            item.set左括弧1(new RString("76"));
            item.set様分氏名1(new RString("77"));
            item.set様分1(new RString("78"));
            item.set様分氏名Small1(new RString("79"));
            item.setカスタマバーコード(new RString("80"));

            itemList.add(item);
        }
        return itemList;
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

    private NinshoshaSource getNinshosha(
            ReportAssembler reportAssembler, Ninshosha ninshosha, RDate 発行日) {
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        INinshoshaSourceBuilder sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                ninshosha, association, reportAssembler.getImageFolderPath(), 発行日);
        return sourceBuilder.buildSource();
    }
}
