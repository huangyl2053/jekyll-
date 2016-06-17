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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kaigosofubutsuatesakisource.KaigoSofubutsuAtesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.gyosekukaku.IGyoseiKukaku;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.IJusho;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 介護保険料減免決定通知書PrintServiceクラスです。
 *
 * @reamsid_L DBB-0740-030 surun
 */
public class GenmenKetteiTsuchiShoPrintService {

    private static final RString 種別コード = NinshoshaDenshikoinshubetsuCode.保険者印.getコード();
    private static final RString 定数 = new RString("0");
    private static final CodeShubetsu コード種別 = new CodeShubetsu("0004");
    private static final RString RSTRING_1 = new RString("1");
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
    private static final int INDEX_FOURTEEN = 14;
    private static final int INDEX_FIFTEEN = 15;

    /**
     * printA4縦タイプメソッドします。
     *
     * @param 発行日 FlexibleDate
     * @param 文書番号 RString
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     * @param 通知書定型文 RString
     * @param 介護問合せ先ソースビルダー IKaigoToiawasesakiSourceBuilder
     * @param reportManager ReportManager
     */
    public void printA4縦タイプ(FlexibleDate 発行日, RString 文書番号, GenmenKetteiTsuchiShoJoho 減免決定通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー, ReportManager reportManager) {
        GenmenKetteiTsuchiShoTateProperty property = new GenmenKetteiTsuchiShoTateProperty();
        try (ReportAssembler<KaigoHokenryoGenmenKetteiTsuchishoTateSource> assembler = createAssembler(property, reportManager)) {
            if (減免決定通知書情報 != null) {
                Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険, 種別コード,
                        発行日 == null || 発行日.isEmpty() ? FlexibleDate.getNowDate() : 発行日);
                Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
                ChohyoSeigyoKyotsu 帳票制御共通 = 減免決定通知書情報.get帳票制御共通();
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
                int flag = INDEX_ONE;
                List<GenmenKetteiTsuchiShoItem> targets = setItems(文書番号, 減免決定通知書情報, 通知書定型文,
                        介護問合せ先ソースビルダー, sourceBuilder, flag);
                ReportSourceWriter<KaigoHokenryoGenmenKetteiTsuchishoTateSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                GenmenKetteiTsuchiShoTateReport.createForm(targets).writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * printB5横タイプメソッドします。
     *
     * @param 発行日 FlexibleDate
     * @param 文書番号 RString
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     * @param 通知書定型文 RString
     * @param 介護問合せ先ソースビルダー IKaigoToiawasesakiSourceBuilder
     * @param reportManager ReportManager
     */
    public void printB5横タイプ(FlexibleDate 発行日, RString 文書番号, GenmenKetteiTsuchiShoJoho 減免決定通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー, ReportManager reportManager) {
        GenmenKetteiTsuchiShoYokoProperty property = new GenmenKetteiTsuchiShoYokoProperty();
        try (ReportAssembler<KaigoHokenryoGenmenKetteiTsuchishoYokoSource> assembler = createAssembler(property, reportManager)) {
            if (減免決定通知書情報 != null) {
                Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険, 種別コード,
                        発行日 == null || 発行日.isEmpty() ? FlexibleDate.getNowDate() : 発行日);
                Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
                ChohyoSeigyoKyotsu 帳票制御共通 = 減免決定通知書情報.get帳票制御共通();
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
                int flag = INDEX_TWO;
                List<GenmenKetteiTsuchiShoItem> targets = setItems(文書番号, 減免決定通知書情報, 通知書定型文,
                        介護問合せ先ソースビルダー, sourceBuilder, flag);
                ReportSourceWriter<KaigoHokenryoGenmenKetteiTsuchishoYokoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                GenmenKetteiTsuchiShoYokoReport.createForm(targets).writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * setItemsメソッドします。
     *
     * @param 文書番号 RString
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     * @param 通知書定型文 RString
     * @param 介護問合せ先ソースビルダー IKaigoToiawasesakiSourceBuilder
     * @param sourceBuilder NinshoshaSource
     *
     * @return List<GenmenKetteiTsuchiShoItem>
     */
    private List<GenmenKetteiTsuchiShoItem> setItems(RString 文書番号, GenmenKetteiTsuchiShoJoho 減免決定通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー, NinshoshaSource sourceBuilder, int flag) {
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
            setBaseItem(item, 減免決定通知書情報, 文書番号, 通知書定型文, 介護問合せ先ソースビルダー, sourceBuilder, flag);
            items.add(item);
        }

        return items;
    }

    /**
     * setBaseItemします。
     *
     * @param item GenmenKetteiTsuchiShoItem
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     * @param 文書番号 RString
     * @param 通知書定型文
     * @param 介護問合せ先ソースビルダー IKaigoToiawasesakiSourceBuilder
     * @param sourceBuilder NinshoshaSource
     */
    private void setBaseItem(GenmenKetteiTsuchiShoItem item, GenmenKetteiTsuchiShoJoho 減免決定通知書情報, RString 文書番号,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー, NinshoshaSource sourceBuilder, int flag) {
        item.set文書番号(文書番号);
        if (減免決定通知書情報.get減免の情報更正後() != null) {
            FlexibleYear 調定年度 = 減免決定通知書情報.get減免の情報更正後().get調定年度();
            if (調定年度 != null) {
                item.set調定年度(調定年度.wareki().eraType(EraType.KANJI).toDateString());
            }
            FlexibleYear 賦課年度 = 減免決定通知書情報.get減免の情報更正後().get賦課年度();
            if (賦課年度 != null) {
                item.set賦課年度(賦課年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString());
            }
            item.set決定結果(減免決定通知書情報.get減免の情報更正後().get減免状態区分());
        }
        HyojiCodeResearcher researcher = new HyojiCodeResearcher();
        HyojiCodes 表示コード = null;
        if (isNotNull(減免決定通知書情報.get帳票制御共通())) {
            IGyoseiKukaku 行政区画 = null;
            IJusho 住所 = null;
            if (isNotNull(減免決定通知書情報.get宛名())) {
                行政区画 = 減免決定通知書情報.get宛名().get行政区画();
                住所 = 減免決定通知書情報.get宛名().get住所();
            }
            表示コード = researcher.create表示コード情報(減免決定通知書情報.get帳票制御共通().toEntity(),
                    住所 != null ? 住所.get町域コード().value() : RString.EMPTY,
                    行政区画 != null ? 行政区画.getGyoseiku().getコード().value() : RString.EMPTY,
                    行政区画 != null ? 行政区画.getChiku1().getコード().value() : RString.EMPTY,
                    行政区画 != null ? 行政区画.getChiku2().getコード().value() : RString.EMPTY,
                    行政区画 != null ? 行政区画.getChiku3().getコード().value() : RString.EMPTY,
                    減免決定通知書情報.get納組情報() != null
                    ? 減免決定通知書情報.get納組情報().getNokumi().getNokumiCode() : RString.EMPTY);
            if (isNotNull(表示コード)) {
                item.set表示コード名称１(表示コード.get表示コード名１());
                item.set表示コード名称２(表示コード.get表示コード名２());
                item.set表示コード名称３(表示コード.get表示コード名３());
                item.set表示コード１(表示コード.get表示コード１());
                item.set表示コード２(表示コード.get表示コード２());
                item.set表示コード３(表示コード.get表示コード３());
            }
        }
        set減免の情報(item, 減免決定通知書情報, flag);
        item.set備考Title(通知書定型文);
        item.set備考(通知書定型文);

        if (sourceBuilder != null) {
            item.set発行日(sourceBuilder.hakkoYMD);
            item.set電子公印(sourceBuilder.denshiKoin);
            item.set認証者役職名(sourceBuilder.ninshoshaYakushokuMei);
            item.set公印文字列(sourceBuilder.koinMojiretsu);
            item.set認証者氏名公印に掛けない(sourceBuilder.ninshoshaShimeiKakenai);
            item.set認証者氏名公印に掛ける(sourceBuilder.ninshoshaShimeiKakeru);
            item.set公印省略(sourceBuilder.koinShoryaku);
        }

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
        set送付物宛先ソース(item, 減免決定通知書情報);

        // TODO (QA655) 世帯主名 将来に追加する
        // TODO (QA655) 様方 将来に追加する
    }

    private void set減免の情報(GenmenKetteiTsuchiShoItem item, GenmenKetteiTsuchiShoJoho 減免決定通知書情報, int flag) {
        if (isNotNull(減免決定通知書情報.get減免の情報更正後()) && isNotNull(減免決定通知書情報.get賦課の情報更正前())) {
            TsuchishoNo 通知書番号 = 減免決定通知書情報.get減免の情報更正後().get通知書番号();
            item.set通知書番号(通知書番号 != null ? 通知書番号.value() : RString.EMPTY);
            SetaiCode 世帯コード = 減免決定通知書情報.get減免の情報更正後().get世帯コード();
            item.set世帯コード(世帯コード != null ? 世帯コード.value() : RString.EMPTY);
            HihokenshaNo 被保険者番号 = 減免決定通知書情報.get減免の情報更正後().get被保険者番号();
            item.set被保険者番号(被保険者番号 != null ? 被保険者番号.value() : RString.EMPTY);
            ShikibetsuCode 識別コード = 減免決定通知書情報.get減免の情報更正後().get識別コード();
            item.set識別コード(識別コード != null ? 識別コード.value() : RString.EMPTY);
            FlexibleDate 減免決定日 = 減免決定通知書情報.get減免の情報更正後().get減免決定日();
            if (減免決定日 != null) {
                item.set減免決定年月日(減免決定日.wareki().eraType(EraType.KANJI).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            }
            item.set減免額前(DecimalFormatter.toコンマ区切りRString(減免決定通知書情報
                    .get賦課の情報更正前().get減免額(), 0));
            item.set保険料算出額前(DecimalFormatter.toコンマ区切りRString(減免決定通知書情報
                    .get賦課の情報更正前().get減免前介護保険料_年額(), 0));
            item.set保険料額前(DecimalFormatter.toコンマ区切りRString(減免決定通知書情報
                    .get賦課の情報更正前().get確定介護保険料_年額(), 0));
            item.set減免額後(DecimalFormatter.toコンマ区切りRString(減免決定通知書情報
                    .get減免の情報更正後().get減免額(), 0));
            item.set保険料算出額後(DecimalFormatter.toコンマ区切りRString(減免決定通知書情報
                    .get減免の情報更正後().get減免前介護保険料_年額(), 0));
            item.set保険料額後(DecimalFormatter.toコンマ区切りRString(減免決定通知書情報
                    .get減免の情報更正後().get確定介護保険料_年額(), 0));
            Code 減免種類コード = 減免決定通知書情報.get減免の情報更正後().get減免種類コード();
            if (flag == INDEX_ONE && 減免種類コード != null) {
                item.set減免理由1(CodeMaster.getCodeMeisho(SubGyomuCode.DBB介護賦課, コード種別,
                        減免種類コード, FlexibleDate.getNowDate()));
            } else if (flag == INDEX_TWO && 減免種類コード != null) {
                item.set減免理由1(CodeMaster.getCodeMeisho(SubGyomuCode.DBB介護賦課, コード種別,
                        減免種類コード, FlexibleDate.getNowDate()));
            }
            item.set減免理由2(減免決定通知書情報.get減免の情報更正後().get減免事由());
        }
    }

    private void set送付物宛先ソース(GenmenKetteiTsuchiShoItem item, GenmenKetteiTsuchiShoJoho 減免決定通知書情報) {
        if (isNotNull(減免決定通知書情報.get宛先()) && isNotNull(減免決定通知書情報.get地方公共団体())
                && isNotNull(減免決定通知書情報.get帳票制御共通())) {
            JushoHenshu jushoHenshu = new JushoHenshu();
            EditedAtesaki 編集後宛先 = jushoHenshu.create編集後宛先(減免決定通知書情報.get宛先(),
                    減免決定通知書情報.get地方公共団体(),
                    減免決定通知書情報.get帳票制御共通());
            if (isNotNull(編集後宛先.getSofubutsuAtesakiSource())) {
                KaigoSofubutsuAtesakiSource source = 編集後宛先.getSofubutsuAtesakiSource();
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

    /**
     * 更正前後期割額リストを生成する。
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
        for (int index = INDEX_ONE; index <= INDEX_FOURTEEN; index++) {
            Kitsuki 期月特徴 = 特徴期月リスト.get期の最初月(index);
            Kitsuki 期月普徴 = 普徴期月リスト.get期の最初月(index);
            KoseiZengoKiwariGaku 更正前後期割額 = 更正前後期割額を生成(減免決定通知書情報, 期月特徴, 期月普徴);
            更正前後期割額リスト.add(更正前後期割額);
        }
        return 更正前後期割額リスト;
    }

    /**
     * 更正前後期割額を生成する。
     *
     * @param index int
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     * @param 期月特徴 Kitsuki
     * @param 期月普徴 Kitsuki
     * @return KoseiZengoKiwariGaku
     */
    private KoseiZengoKiwariGaku 更正前後期割額を生成(GenmenKetteiTsuchiShoJoho 減免決定通知書情報,
            Kitsuki 期月特徴, Kitsuki 期月普徴) {
        KoseiZengoKiwariGaku 更正前後期割額 = new KoseiZengoKiwariGaku();
        if (期月特徴.isPresent()) {
            if (期月特徴.get期().length() < 2) {
                更正前後期割額.set特徴期(期月特徴.get期().insert(INDEX_ZERO, 定数.toString()));
            } else {
                更正前後期割額.set特徴期(期月特徴.get期());
            }
            if (期月特徴.get月AsInt() < INDEX_TEN) {
                更正前後期割額.set特徴月(new RString(定数.toString() + 期月特徴.get月AsInt()));
            } else {
                更正前後期割額.set特徴月(new RString(String.valueOf(期月特徴.get月AsInt())));
            }
            Decimal 特徴期別金額更正前 = set特徴期別金額更正前(期月特徴.get期(), 減免決定通知書情報);
            if (特徴期別金額更正前 != null) {
                更正前後期割額.set特徴期別金額更正前(DecimalFormatter
                        .toコンマ区切りRString(特徴期別金額更正前, 0));
            } else {
                更正前後期割額.set特徴期別金額更正前(RString.EMPTY);
            }
            Decimal 特徴期別金額更正後 = set特徴期別金額更正後(期月特徴.get期(), 減免決定通知書情報);
            if (特徴期別金額更正後 != null) {
                更正前後期割額.set特徴期別金額更正後(DecimalFormatter
                        .toコンマ区切りRString(特徴期別金額更正後, 0));
            } else {
                更正前後期割額.set特徴期別金額更正後(RString.EMPTY);
            }
        } else {
            更正前後期割額.set特徴期(RString.EMPTY);
            更正前後期割額.set特徴月(RString.EMPTY);
            更正前後期割額.set特徴期別金額更正前(RString.EMPTY);
            更正前後期割額.set特徴期別金額更正後(RString.EMPTY);
        }
        if (期月普徴.isPresent()) {
            if (期月普徴.get期().length() < 2) {
                更正前後期割額.set普徴期(期月普徴.get期().insert(INDEX_ZERO, 定数.toString()));
            } else {
                更正前後期割額.set普徴期(期月普徴.get期());
            }
            if (期月普徴.get月AsInt() < INDEX_TEN) {
                更正前後期割額.set普徴月(new RString(定数.toString() + 期月普徴.get月AsInt()));
            } else {
                更正前後期割額.set普徴月(new RString(String.valueOf(期月普徴.get月AsInt())));
            }
            Decimal 普徴期別金額更正前 = set普徴期別金額更正前(期月普徴.get月AsInt(), 減免決定通知書情報);
            if (普徴期別金額更正前 != null) {
                更正前後期割額.set普徴期別金額更正前(DecimalFormatter
                        .toコンマ区切りRString(普徴期別金額更正前, 0));
            } else {
                更正前後期割額.set普徴期別金額更正前(RString.EMPTY);
            }
            Decimal 普徴期別金額更正後 = set普徴期別金額更正後(期月普徴.get月AsInt(), 減免決定通知書情報);
            if (普徴期別金額更正後 != null) {
                更正前後期割額.set普徴期別金額更正後(DecimalFormatter
                        .toコンマ区切りRString(普徴期別金額更正後, 0));
            } else {
                更正前後期割額.set普徴期別金額更正後(RString.EMPTY);
            }

        } else {
            更正前後期割額.set普徴月(RString.EMPTY);
            更正前後期割額.set普徴期(RString.EMPTY);
            更正前後期割額.set普徴期別金額更正前(RString.EMPTY);
            更正前後期割額.set普徴期別金額更正後(RString.EMPTY);
        }
        return 更正前後期割額;
    }

    /**
     * set特徴期別金額更正前します。
     *
     * @param 期 RString
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     * @return Decimal
     */
    private Decimal set特徴期別金額更正前(RString 期, GenmenKetteiTsuchiShoJoho 減免決定通知書情報) {
        int index = Integer.parseInt(期.toString());
        if (減免決定通知書情報.get賦課の情報更正前() == null) {
            return Decimal.ZERO;
        }
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
            case INDEX_SIX:
                return 減免決定通知書情報.get賦課の情報更正前().get特徴期別金額06();
            default:
                return null;
        }
    }

    /**
     * set特徴期別金額更正後します。
     *
     * @param 期 RString
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     * @return Decimal
     */
    private Decimal set特徴期別金額更正後(RString 期, GenmenKetteiTsuchiShoJoho 減免決定通知書情報) {
        int index = Integer.parseInt(期.toString());
        if (減免決定通知書情報.get減免の情報更正後() == null) {
            return Decimal.ZERO;
        }
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
            case INDEX_SIX:
                return 減免決定通知書情報.get減免の情報更正後().get特徴期別金額06();
            default:
                return null;
        }
    }

    /**
     * set普徴期別金額更正前します。
     *
     * @param index int
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     * @return Decimal
     */
    private Decimal set普徴期別金額更正前(int index, GenmenKetteiTsuchiShoJoho 減免決定通知書情報) {
        if (減免決定通知書情報.get賦課の情報更正前() == null) {
            return Decimal.ZERO;
        }
        switch (index) {
            case INDEX_FOUR:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額01();
            case INDEX_FIVE:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額02();
            case INDEX_SIX:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額03();
            case INDEX_SEVEN:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額04();
            case INDEX_EIGHT:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額05();
            case INDEX_NINE:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額06();
            case INDEX_TEN:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額07();
            case INDEX_ELEVEN:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額08();
            case INDEX_TWELVE:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額09();
            case INDEX_ONE:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額10();
            case INDEX_TWO:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額11();
            case INDEX_THREE:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額12();
            case INDEX_FOURTEEN:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額13();
            case INDEX_FIFTEEN:
                return 減免決定通知書情報.get賦課の情報更正前().get普徴期別金額14();
            default:
                return null;
        }
    }

    /**
     * set普徴期別金額更正後します。
     *
     * @param index int
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     * @return Decimal
     */
    private Decimal set普徴期別金額更正後(int index, GenmenKetteiTsuchiShoJoho 減免決定通知書情報) {
        if (減免決定通知書情報.get減免の情報更正後() == null) {
            return Decimal.ZERO;
        }
        switch (index) {
            case INDEX_FOUR:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額01();
            case INDEX_FIVE:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額02();
            case INDEX_SIX:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額03();
            case INDEX_SEVEN:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額04();
            case INDEX_EIGHT:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額05();
            case INDEX_NINE:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額06();
            case INDEX_TEN:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額07();
            case INDEX_ELEVEN:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額08();
            case INDEX_TWELVE:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額09();
            case INDEX_ONE:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額10();
            case INDEX_TWO:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額11();
            case INDEX_THREE:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額12();
            case INDEX_FOURTEEN:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額13();
            case INDEX_FIFTEEN:
                return 減免決定通知書情報.get減免の情報更正後().get普徴期別金額14();
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
