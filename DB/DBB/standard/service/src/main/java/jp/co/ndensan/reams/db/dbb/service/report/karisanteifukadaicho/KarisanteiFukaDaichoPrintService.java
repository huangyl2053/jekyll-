/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.karisanteifukadaicho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.EditedKariSanteiFukaDaichoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteifukadaicho.KarisanteiFukaDaichoItem;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteifukadaicho.KarisanteiFukaDaichoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteifukadaicho.KarisanteiFukaDaichoReport;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteifukadaicho.KarisanteiFukaDaichoSource;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 帳票設計_DBBRP00006_2_賦課台帳（仮算定）
 *
 * @reamsid_L DBB-9100-020 yangchenbing
 */
public class KarisanteiFukaDaichoPrintService {

    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM2 = 2;
    private static final int NUM3 = 3;
    private static final int NUM4 = 4;
    private static final int NUM5 = 5;
    private static final int NUM6 = 6;
    private static final int NUM7 = 7;
    private static final int PAGEBYNUM = 8;

    /**
     * printメソッド
     *
     * @param entities EditedKariSanteiFukaDaichoJoho
     * @param reportManager ReportManager
     */
    public void printSingle(EditedKariSanteiFukaDaichoJoho entities, ReportManager reportManager) {
        KarisanteiFukaDaichoProperty property = new KarisanteiFukaDaichoProperty();
        try (ReportAssembler<KarisanteiFukaDaichoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KarisanteiFukaDaichoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            List<KarisanteiFukaDaichoItem> targets = setItems(entities);
            new KarisanteiFukaDaichoReport(targets).writeBy(reportSourceWriter);
        }
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

    /**
     * printメソッド
     *
     * @param entities EditedKariSanteiFukaDaichoJoho
     * @return SourceDataCollection
     */
    public SourceDataCollection print(EditedKariSanteiFukaDaichoJoho entities) {
        KarisanteiFukaDaichoProperty property = new KarisanteiFukaDaichoProperty();
        List<KarisanteiFukaDaichoItem> targets = setItems(entities);
        return new Printer<KarisanteiFukaDaichoSource>().spool(property, toReports(targets));
    }

    /**
     * toReportsメソッド
     *
     * @param targets (List<KarisanteiFukaDaichoItem>
     * @return List<KarisanteiFukaDaichoReport>
     */
    private static List<KarisanteiFukaDaichoReport> toReports(List<KarisanteiFukaDaichoItem> targets) {
        List<KarisanteiFukaDaichoReport> reportList = new ArrayList<>();
        reportList.add(KarisanteiFukaDaichoReport.createFrom(targets));
        return reportList;
    }

    /**
     * setItemsメソッド
     *
     * @param entity EditedKariSanteiFukaDaichoJoho
     * @return List<KarisanteiFukaDaichoItem>
     */
    private List<KarisanteiFukaDaichoItem> setItems(EditedKariSanteiFukaDaichoJoho entity) {

        List<KarisanteiFukaDaichoItem> targets = new ArrayList<>();
        Integer pageAll = 1;
        if (entity == null) {
            KarisanteiFukaDaichoItem itemTemp = new KarisanteiFukaDaichoItem();
            targets.add(itemTemp);
            return targets;
        }
        KarisanteiFukaDaichoItem item1 = new KarisanteiFukaDaichoItem();
        if (entity.get世帯員情報リスト() != null) {
            pageAll = (entity.get世帯員情報リスト().size() - 1) / PAGEBYNUM + 1;
        }
        for (int pageNow = 1; pageNow <= pageAll; pageNow++) {
            if (pageNow <= 1) {
                listFutsuChoshu普通徴収更正前(item1, entity);
                listHonin1本人更正前(item1, entity);
                listUchiwakei仮算定内訳更正前(item1, entity);
                listTokuChoshu特別徴収更正前(item1, entity);
                KarisanteiFukaDaichoItem item2 = new KarisanteiFukaDaichoItem();
                listUchiwakei仮算定内訳更正後(item2, entity);
                listFutsuChoshu普通徴収更正後(item2, entity);
                listHonin1本人更正後(item2, entity);
                listTokuChoshu特別徴収更正後(item2, entity);
                KarisanteiFukaDaichoItem item3 = new KarisanteiFukaDaichoItem();
                listFutsuChoshu普通徴収増減額(item3, entity);
                listTokuChoshu特別徴収増減額(item3, entity);
                KarisanteiFukaDaichoItem item4 = new KarisanteiFukaDaichoItem();
                parttoentity(item4, entity);
                listFutsuChoshu普通徴収収入額(item4, entity);
                listFuchoKi普徴期(item1, entity);
                listFuchoTsuki普徴月(item1, entity);
                listFuchoZuiji普徴随時(item4, entity);
                listTokuChoshu特別徴収収入額(item4, entity);
                listTokuchoKi特徴期(item1, entity);
                listTokuchoTsuki特徴月(item1, entity);
                item4.setPrintTimeStamp(entity.get印刷日時());
                item4.setSetaiCode(entity.get世帯コード());
                item4.setTitle(entity.getタイトル());
                item4.setTsuchishoNo(entity.get通知書NO());
                item4.setZenNendoFuchoSaishukiHokenryo(entity.get前年度普通徴収最終期保険料());
                item4.setZenNendoTochoSaishukiHokenryo(entity.get前年度特別徴収最終期保険料());
                item4.setZenNendoHokenryoNengaku(entity.get前年度年額保険料());
                item4.setZenNendoHokenryoRitsu(entity.get前年度保険料率());
                item4.setZenNendoShotokuDankai(entity.get前年度取得段階());
                item4.setPageNo(new RString(Integer.valueOf(pageNow).toString()));
                item4.setPageNoAll(new RString(pageAll.toString()));
                if (entity.get世帯員情報リスト() != null && !(entity.get世帯員情報リスト().isEmpty())) {
                    set世帯員情報リストPart1(item1, entity, NUM0);
                    set世帯員情報リストPart2(item1, entity, NUM4);
                    set世帯員情報リストPart1(item2, entity, NUM1);
                    set世帯員情報リストPart2(item2, entity, NUM5);
                    set世帯員情報リストPart1(item3, entity, NUM2);
                    set世帯員情報リストPart2(item3, entity, NUM6);
                    set世帯員情報リストPart1(item4, entity, NUM3);
                    set世帯員情報リストPart2(item4, entity, NUM7);
                }
                targets.add(item1);
                targets.add(item2);
                targets.add(item3);
                targets.add(item4);
            } else {
                int start = (pageNow - 1) * PAGEBYNUM;
                int end = Math.min(entity.get世帯員情報リスト().size(), pageNow * PAGEBYNUM - 1);
                for (int i = start; i < end; i++) {
                    KarisanteiFukaDaichoItem itemTemp = new KarisanteiFukaDaichoItem();
                    itemTemp.setTitle(entity.getタイトル());
                    itemTemp.setChoteiNendo(entity.get調定年度());
                    itemTemp.setFukaNendo(entity.get賦課年度());
                    itemTemp.setPrintTimeStamp(entity.get印刷日時());
                    itemTemp.setPageNo(new RString(Integer.valueOf(pageNow).toString()));
                    itemTemp.setPageNoAll(new RString(pageAll.toString()));
                    itemTemp.setHokenshaNo(entity.get保険者番号());
                    itemTemp.setHokenshaName(entity.get保険者名称());
                    itemTemp.setTsuchishoNo(entity.get通知書NO());
                    itemTemp.setHihokenshaNo(entity.get被保険者番号());
                    itemTemp.setSetaiCode(entity.get世帯コード());
                    listSetaiin世帯員情報リスト(itemTemp, entity, i);
                    if (entity.get世帯員情報リスト().size() > ++i) {
                        listSetaiin1世帯員情報リスト(itemTemp, entity, i);
                    }
                    targets.add(itemTemp);
                }
            }
        }
        return targets;
    }

    /**
     * listFutsuChoshu普通徴収更正前
     *
     * @param item KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     */
    private void listFutsuChoshu普通徴収更正前(KarisanteiFukaDaichoItem item, EditedKariSanteiFukaDaichoJoho entity) {
        if (!(entity.get普通徴収更正前() == null)) {
            item.setListFutsuChoshu_1(entity.get普通徴収更正前().get普徴調定月());
            item.setListFutsuChoshu_10(entity.get普通徴収更正前().get普徴金額５());
            item.setListFutsuChoshu_11(entity.get普通徴収更正前().get普徴金額６());
            item.setListFutsuChoshu_12(entity.get普通徴収更正前().get普徴金額７());
            item.setListFutsuChoshu_13(entity.get普通徴収更正前().get普徴金額８());
            item.setListFutsuChoshu_14(entity.get普通徴収更正前().get普徴金額９());
            item.setListFutsuChoshu_15(entity.get普通徴収更正前().get普徴金額１０());
            item.setListFutsuChoshu_16(entity.get普通徴収更正前().get普徴金額１１());
            item.setListFutsuChoshu_17(entity.get普通徴収更正前().get普徴金額１２());
            item.setListFutsuChoshu_18(entity.get普通徴収更正前().get普徴金額１３());
            item.setListFutsuChoshu_19(entity.get普通徴収更正前().get普徴金額１４());
            item.setListFutsuChoshu_2(entity.get普通徴収更正前().get普徴調定月の期());
            item.setListFutsuChoshu_3(entity.get普通徴収更正前().get普徴仮算定保険料());
            item.setListFutsuChoshu_4(entity.get普通徴収更正前().get普徴納付済額());
            item.setListFutsuChoshu_5(entity.get普通徴収更正前().get普徴今後納付すべき額());
            item.setListFutsuChoshu_6(entity.get普通徴収更正前().get普徴金額１());
            item.setListFutsuChoshu_7(entity.get普通徴収更正前().get普徴金額２());
            item.setListFutsuChoshu_8(entity.get普通徴収更正前().get普徴金額３());
            item.setListFutsuChoshu_9(entity.get普通徴収更正前().get普徴金額４());
        }

    }

    /**
     * listHonin1本人更正前
     *
     * @param iten1 KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     */
    private void listHonin1本人更正前(KarisanteiFukaDaichoItem iten1, EditedKariSanteiFukaDaichoJoho entity) {
        if (!(entity.get本人更正前() == null)) {
            iten1.setListHonin1_1(entity.get本人更正前().get本人資格取得日());
            iten1.setListHonin1_2(entity.get本人更正前().get本人取得事由());
            iten1.setListHonin1_3(entity.get本人更正前().get本人資格喪失日());
            iten1.setListHonin1_4(entity.get本人更正前().get本人喪失事由());
            iten1.setListHonin1_5(entity.get本人更正前().get本人住所地特例());
            iten1.setListHonin1_6(entity.get本人更正前().get本人生活保護開始年月日());
            iten1.setListHonin1_7(entity.get本人更正前().get本人生活保護終了年月日());
            iten1.setListHonin1_8(entity.get本人更正前().get本人老齢年金開始年月日());
            iten1.setListHonin1_9(entity.get本人更正前().get本人老齢年金終了年月日());
            iten1.setListHonin2_1(entity.get本人更正前().get本人識別コード());
            iten1.setListHonin2_2(entity.get本人更正前().get本人氏名());
            iten1.setListHonin2_3(entity.get本人更正前().get本人性別());
            iten1.setListHonin2_4(entity.get本人更正前().get本人生年月日());
            iten1.setListHonin2_5(entity.get本人更正前().get本人続柄());
            iten1.setListHonin2_6(entity.get本人更正前().get本人合計取得金額());
            iten1.setListHonin2_7(entity.get本人更正前().get本人課税区分());
        }

    }

    /**
     * listUchiwakei仮算定内訳更正前
     *
     * @param iten1 KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     */
    private void listUchiwakei仮算定内訳更正前(KarisanteiFukaDaichoItem iten1, EditedKariSanteiFukaDaichoJoho entity) {
        if (!(entity.get仮算定内訳更正前() == null)) {
            iten1.setListUchiwakei_1(entity.get仮算定内訳更正前().get仮算定保険料額());
            iten1.setListUchiwakei_2(entity.get仮算定内訳更正前().get減免額());
            iten1.setListUchiwakei_3(entity.get仮算定内訳更正前().get仮算定確定保険料());
            iten1.setListUchiwakei_4(entity.get仮算定内訳更正前().get賦課基準日());
            iten1.setListUchiwakei_5(entity.get仮算定内訳更正前().get調定年月日());
        }

    }

    /**
     * listTokuChoshu特別徴収更正前
     *
     * @param iten1 KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     */
    private void listTokuChoshu特別徴収更正前(KarisanteiFukaDaichoItem iten1, EditedKariSanteiFukaDaichoJoho entity) {
        if (!(entity.get特別徴収更正前() == null)) {
            iten1.setListTokuChoshu_1(entity.get特別徴収更正前().get特徴調定月());
            iten1.setListTokuChoshu_10(entity.get特別徴収更正前().get特徴金額５());
            iten1.setListTokuChoshu_11(entity.get特別徴収更正前().get特徴金額６());
            iten1.setListTokuChoshu_12(entity.get特別徴収更正前().get特徴金額７());
            iten1.setListTokuChoshu_13(entity.get特別徴収更正前().get特徴金額８());
            iten1.setListTokuChoshu_14(entity.get特別徴収更正前().get特徴金額９());
            iten1.setListTokuChoshu_15(entity.get特別徴収更正前().get特徴金額１０());
            iten1.setListTokuChoshu_16(entity.get特別徴収更正前().get特徴金額１１());
            iten1.setListTokuChoshu_17(entity.get特別徴収更正前().get特徴金額１２());
            iten1.setListTokuChoshu_18(entity.get特別徴収更正前().get特徴金額１３());
            iten1.setListTokuChoshu_19(entity.get特別徴収更正前().get特徴金額１４());
            iten1.setListTokuChoshu_2(entity.get特別徴収更正前().get特徴調定月の期());
            iten1.setListTokuChoshu_3(entity.get特別徴収更正前().get特徴仮算定保険料());
            iten1.setListTokuChoshu_4(entity.get特別徴収更正前().get特徴納付済額());
            iten1.setListTokuChoshu_5(entity.get特別徴収更正前().get特徴今後納付すべき額());
            iten1.setListTokuChoshu_6(entity.get特別徴収更正前().get特徴金額１());
            iten1.setListTokuChoshu_7(entity.get特別徴収更正前().get特徴金額２());
            iten1.setListTokuChoshu_8(entity.get特別徴収更正前().get特徴金額３());
            iten1.setListTokuChoshu_9(entity.get特別徴収更正前().get特徴金額４());
        }

    }

    /**
     * listUchiwakei仮算定内訳更正後
     *
     * @param iten2 KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     */
    private void listUchiwakei仮算定内訳更正後(KarisanteiFukaDaichoItem iten2, EditedKariSanteiFukaDaichoJoho entity) {
        if (!(entity.get仮算定内訳更正後() == null)) {
            iten2.setListUchiwakei_1(entity.get仮算定内訳更正後().get仮算定保険料額());
            iten2.setListUchiwakei_2(entity.get仮算定内訳更正後().get減免額());
            iten2.setListUchiwakei_3(entity.get仮算定内訳更正後().get仮算定確定保険料());
            iten2.setListUchiwakei_4(entity.get仮算定内訳更正後().get賦課基準日());
            iten2.setListUchiwakei_5(entity.get仮算定内訳更正後().get調定年月日());
        }

    }

    /**
     * listFutsuChoshu普通徴収更正後
     *
     * @param iten2 KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     */
    private void listFutsuChoshu普通徴収更正後(KarisanteiFukaDaichoItem iten2, EditedKariSanteiFukaDaichoJoho entity) {
        if (!(entity.get普通徴収更正後() == null)) {
            iten2.setListFutsuChoshu_1(entity.get普通徴収更正後().get普徴調定月());
            iten2.setListFutsuChoshu_10(entity.get普通徴収更正後().get普徴金額５());
            iten2.setListFutsuChoshu_11(entity.get普通徴収更正後().get普徴金額６());
            iten2.setListFutsuChoshu_12(entity.get普通徴収更正後().get普徴金額７());
            iten2.setListFutsuChoshu_13(entity.get普通徴収更正後().get普徴金額８());
            iten2.setListFutsuChoshu_14(entity.get普通徴収更正後().get普徴金額９());
            iten2.setListFutsuChoshu_15(entity.get普通徴収更正後().get普徴金額１０());
            iten2.setListFutsuChoshu_16(entity.get普通徴収更正後().get普徴金額１１());
            iten2.setListFutsuChoshu_17(entity.get普通徴収更正後().get普徴金額１２());
            iten2.setListFutsuChoshu_18(entity.get普通徴収更正後().get普徴金額１３());
            iten2.setListFutsuChoshu_19(entity.get普通徴収更正後().get普徴金額１４());
            iten2.setListFutsuChoshu_2(entity.get普通徴収更正後().get普徴調定月の期());
            iten2.setListFutsuChoshu_3(entity.get普通徴収更正後().get普徴仮算定保険料());
            iten2.setListFutsuChoshu_4(entity.get普通徴収更正後().get普徴納付済額());
            iten2.setListFutsuChoshu_5(entity.get普通徴収更正後().get普徴今後納付すべき額());
            iten2.setListFutsuChoshu_6(entity.get普通徴収更正後().get普徴金額１());
            iten2.setListFutsuChoshu_7(entity.get普通徴収更正後().get普徴金額２());
            iten2.setListFutsuChoshu_8(entity.get普通徴収更正後().get普徴金額３());
            iten2.setListFutsuChoshu_9(entity.get普通徴収更正後().get普徴金額４());
        }

    }

    /**
     * listHonin1本人更正後
     *
     * @param iten2 KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     */
    private void listHonin1本人更正後(KarisanteiFukaDaichoItem iten2, EditedKariSanteiFukaDaichoJoho entity) {
        if (!(entity.get本人更正後() == null)) {
            iten2.setListHonin1_1(entity.get本人更正後().get本人資格取得日());
            iten2.setListHonin1_2(entity.get本人更正後().get本人取得事由());
            iten2.setListHonin1_3(entity.get本人更正後().get本人資格喪失日());
            iten2.setListHonin1_4(entity.get本人更正後().get本人喪失事由());
            iten2.setListHonin1_5(entity.get本人更正後().get本人住所地特例());
            iten2.setListHonin1_6(entity.get本人更正後().get本人生活保護開始年月日());
            iten2.setListHonin1_7(entity.get本人更正後().get本人生活保護終了年月日());
            iten2.setListHonin1_8(entity.get本人更正後().get本人老齢年金開始年月日());
            iten2.setListHonin1_9(entity.get本人更正後().get本人老齢年金終了年月日());
            iten2.setListHonin2_1(entity.get本人更正後().get本人識別コード());
            iten2.setListHonin2_2(entity.get本人更正後().get本人氏名());
            iten2.setListHonin2_3(entity.get本人更正後().get本人性別());
            iten2.setListHonin2_4(entity.get本人更正後().get本人生年月日());
            iten2.setListHonin2_5(entity.get本人更正後().get本人続柄());
            iten2.setListHonin2_6(entity.get本人更正後().get本人合計取得金額());
            iten2.setListHonin2_7(entity.get本人更正後().get本人課税区分());
        }

    }

    /**
     * listHonin1本人更正後
     *
     * @param iten2 KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     */
    private void listTokuChoshu特別徴収更正後(KarisanteiFukaDaichoItem iten2, EditedKariSanteiFukaDaichoJoho entity) {
        if (!(entity.get特別徴収更正後() == null)) {
            iten2.setListTokuChoshu_1(entity.get特別徴収更正後().get特徴調定月());
            iten2.setListTokuChoshu_10(entity.get特別徴収更正後().get特徴金額５());
            iten2.setListTokuChoshu_11(entity.get特別徴収更正後().get特徴金額６());
            iten2.setListTokuChoshu_12(entity.get特別徴収更正後().get特徴金額７());
            iten2.setListTokuChoshu_13(entity.get特別徴収更正後().get特徴金額８());
            iten2.setListTokuChoshu_14(entity.get特別徴収更正後().get特徴金額９());
            iten2.setListTokuChoshu_15(entity.get特別徴収更正後().get特徴金額１０());
            iten2.setListTokuChoshu_16(entity.get特別徴収更正後().get特徴金額１１());
            iten2.setListTokuChoshu_17(entity.get特別徴収更正後().get特徴金額１２());
            iten2.setListTokuChoshu_18(entity.get特別徴収更正後().get特徴金額１３());
            iten2.setListTokuChoshu_19(entity.get特別徴収更正後().get特徴金額１４());
            iten2.setListTokuChoshu_2(entity.get特別徴収更正後().get特徴調定月の期());
            iten2.setListTokuChoshu_3(entity.get特別徴収更正後().get特徴仮算定保険料());
            iten2.setListTokuChoshu_4(entity.get特別徴収更正後().get特徴納付済額());
            iten2.setListTokuChoshu_5(entity.get特別徴収更正後().get特徴今後納付すべき額());
            iten2.setListTokuChoshu_6(entity.get特別徴収更正後().get特徴金額１());
            iten2.setListTokuChoshu_7(entity.get特別徴収更正後().get特徴金額２());
            iten2.setListTokuChoshu_8(entity.get特別徴収更正後().get特徴金額３());
            iten2.setListTokuChoshu_9(entity.get特別徴収更正後().get特徴金額４());
        }

    }

    /**
     * listFutsuChoshu普通徴収増減額
     *
     * @param iten3 KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     */
    private void listFutsuChoshu普通徴収増減額(KarisanteiFukaDaichoItem iten3, EditedKariSanteiFukaDaichoJoho entity) {
        if (!(entity.get普通徴収増減額() == null)) {
            iten3.setListFutsuChoshu_1(entity.get普通徴収増減額().get普徴調定月());
            iten3.setListFutsuChoshu_10(entity.get普通徴収増減額().get普徴金額５());
            iten3.setListFutsuChoshu_11(entity.get普通徴収増減額().get普徴金額６());
            iten3.setListFutsuChoshu_12(entity.get普通徴収増減額().get普徴金額７());
            iten3.setListFutsuChoshu_13(entity.get普通徴収増減額().get普徴金額８());
            iten3.setListFutsuChoshu_14(entity.get普通徴収増減額().get普徴金額９());
            iten3.setListFutsuChoshu_15(entity.get普通徴収増減額().get普徴金額１０());
            iten3.setListFutsuChoshu_16(entity.get普通徴収増減額().get普徴金額１１());
            iten3.setListFutsuChoshu_17(entity.get普通徴収増減額().get普徴金額１２());
            iten3.setListFutsuChoshu_18(entity.get普通徴収増減額().get普徴金額１３());
            iten3.setListFutsuChoshu_19(entity.get普通徴収増減額().get普徴金額１４());
            iten3.setListFutsuChoshu_2(entity.get普通徴収増減額().get普徴調定月の期());
            iten3.setListFutsuChoshu_3(entity.get普通徴収増減額().get普徴仮算定保険料());
            iten3.setListFutsuChoshu_4(entity.get普通徴収増減額().get普徴納付済額());
            iten3.setListFutsuChoshu_5(entity.get普通徴収増減額().get普徴今後納付すべき額());
            iten3.setListFutsuChoshu_6(entity.get普通徴収増減額().get普徴金額１());
            iten3.setListFutsuChoshu_7(entity.get普通徴収増減額().get普徴金額２());
            iten3.setListFutsuChoshu_8(entity.get普通徴収増減額().get普徴金額３());
            iten3.setListFutsuChoshu_9(entity.get普通徴収増減額().get普徴金額４());
        }

    }

    /**
     * listTokuChoshu特別徴収増減額
     *
     * @param iten3 KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     */
    private void listTokuChoshu特別徴収増減額(KarisanteiFukaDaichoItem iten3, EditedKariSanteiFukaDaichoJoho entity) {
        if (!(entity.get特別徴収増減額() == null)) {
            iten3.setListTokuChoshu_1(entity.get特別徴収増減額().get特徴調定月());
            iten3.setListTokuChoshu_10(entity.get特別徴収増減額().get特徴金額５());
            iten3.setListTokuChoshu_11(entity.get特別徴収増減額().get特徴金額６());
            iten3.setListTokuChoshu_12(entity.get特別徴収増減額().get特徴金額７());
            iten3.setListTokuChoshu_13(entity.get特別徴収増減額().get特徴金額８());
            iten3.setListTokuChoshu_14(entity.get特別徴収増減額().get特徴金額９());
            iten3.setListTokuChoshu_15(entity.get特別徴収増減額().get特徴金額１０());
            iten3.setListTokuChoshu_16(entity.get特別徴収増減額().get特徴金額１１());
            iten3.setListTokuChoshu_17(entity.get特別徴収増減額().get特徴金額１２());
            iten3.setListTokuChoshu_18(entity.get特別徴収増減額().get特徴金額１３());
            iten3.setListTokuChoshu_19(entity.get特別徴収増減額().get特徴金額１４());
            iten3.setListTokuChoshu_2(entity.get特別徴収増減額().get特徴調定月の期());
            iten3.setListTokuChoshu_3(entity.get特別徴収増減額().get特徴仮算定保険料());
            iten3.setListTokuChoshu_4(entity.get特別徴収増減額().get特徴納付済額());
            iten3.setListTokuChoshu_5(entity.get特別徴収増減額().get特徴今後納付すべき額());
            iten3.setListTokuChoshu_6(entity.get特別徴収増減額().get特徴金額１());
            iten3.setListTokuChoshu_7(entity.get特別徴収増減額().get特徴金額２());
            iten3.setListTokuChoshu_8(entity.get特別徴収増減額().get特徴金額３());
            iten3.setListTokuChoshu_9(entity.get特別徴収増減額().get特徴金額４());
        }

    }

    /**
     * listFutsuChoshu普通徴収収入額
     *
     * @param iten4 KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     */
    private void listFutsuChoshu普通徴収収入額(KarisanteiFukaDaichoItem iten4, EditedKariSanteiFukaDaichoJoho entity) {
        if (!(entity.get普通徴収収入額() == null)) {
            iten4.setListFutsuChoshu_10(entity.get普通徴収収入額().get普徴金額５());
            iten4.setListFutsuChoshu_11(entity.get普通徴収収入額().get普徴金額６());
            iten4.setListFutsuChoshu_12(entity.get普通徴収収入額().get普徴金額７());
            iten4.setListFutsuChoshu_13(entity.get普通徴収収入額().get普徴金額８());
            iten4.setListFutsuChoshu_14(entity.get普通徴収収入額().get普徴金額９());
            iten4.setListFutsuChoshu_15(entity.get普通徴収収入額().get普徴金額１０());
            iten4.setListFutsuChoshu_16(entity.get普通徴収収入額().get普徴金額１１());
            iten4.setListFutsuChoshu_17(entity.get普通徴収収入額().get普徴金額１２());
            iten4.setListFutsuChoshu_18(entity.get普通徴収収入額().get普徴金額１３());
            iten4.setListFutsuChoshu_19(entity.get普通徴収収入額().get普徴金額１４());
            iten4.setListFutsuChoshu_3(entity.get普通徴収収入額().get普徴仮算定保険料());
            iten4.setListFutsuChoshu_4(entity.get普通徴収収入額().get普徴納付済額());
            iten4.setListFutsuChoshu_5(entity.get普通徴収収入額().get普徴今後納付すべき額());
            iten4.setListFutsuChoshu_6(entity.get普通徴収収入額().get普徴金額１());
            iten4.setListFutsuChoshu_7(entity.get普通徴収収入額().get普徴金額２());
            iten4.setListFutsuChoshu_8(entity.get普通徴収収入額().get普徴金額３());
            iten4.setListFutsuChoshu_9(entity.get普通徴収収入額().get普徴金額４());
        }

    }

    /**
     * listFuchoKi普徴期
     *
     * @param iten1 KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     */
    private void listFuchoKi普徴期(KarisanteiFukaDaichoItem iten1, EditedKariSanteiFukaDaichoJoho entity) {
        if (!(entity.get普徴期() == null)) {
            iten1.setListFuchoKi_1(entity.get普徴期().get普徴期１());
            iten1.setListFuchoKi_2(entity.get普徴期().get普徴期２());
            iten1.setListFuchoKi_3(entity.get普徴期().get普徴期３());
            iten1.setListFuchoKi_4(entity.get普徴期().get普徴期４());
            iten1.setListFuchoKi_5(entity.get普徴期().get普徴期５());
            iten1.setListFuchoKi_6(entity.get普徴期().get普徴期６());
            iten1.setListFuchoKi_7(entity.get普徴期().get普徴期７());
            iten1.setListFuchoKi_8(entity.get普徴期().get普徴期８());
            iten1.setListFuchoKi_9(entity.get普徴期().get普徴期９());
            iten1.setListFuchoKi_10(entity.get普徴期().get普徴期１０());
            iten1.setListFuchoKi_11(entity.get普徴期().get普徴期１１());
            iten1.setListFuchoKi_12(entity.get普徴期().get普徴期１２());
            iten1.setListFuchoKi_13(entity.get普徴期().get普徴期１３());
            iten1.setListFuchoKi_14(entity.get普徴期().get普徴期１４());
        }

    }

    /**
     * listFuchoTsuki普徴月
     *
     * @param iten1 KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     */
    private void listFuchoTsuki普徴月(KarisanteiFukaDaichoItem iten1, EditedKariSanteiFukaDaichoJoho entity) {
        if (!(entity.get普徴月() == null)) {
            iten1.setListFuchoTsuki_1(entity.get普徴月().get普徴月１());
            iten1.setListFuchoTsuki_2(entity.get普徴月().get普徴月２());
            iten1.setListFuchoTsuki_3(entity.get普徴月().get普徴月３());
            iten1.setListFuchoTsuki_4(entity.get普徴月().get普徴月４());
            iten1.setListFuchoTsuki_5(entity.get普徴月().get普徴月５());
            iten1.setListFuchoTsuki_6(entity.get普徴月().get普徴月６());
            iten1.setListFuchoTsuki_7(entity.get普徴月().get普徴月７());
            iten1.setListFuchoTsuki_8(entity.get普徴月().get普徴月８());
            iten1.setListFuchoTsuki_9(entity.get普徴月().get普徴月９());
            iten1.setListFuchoTsuki_10(entity.get普徴月().get普徴月１０());
            iten1.setListFuchoTsuki_11(entity.get普徴月().get普徴月１１());
            iten1.setListFuchoTsuki_12(entity.get普徴月().get普徴月１２());
            iten1.setListFuchoTsuki_13(entity.get普徴月().get普徴月１３());
            iten1.setListFuchoTsuki_14(entity.get普徴月().get普徴月１４());
        }

    }

    /**
     * listFuchoZuiji普徴随時
     *
     * @param iten4 KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     */
    private void listFuchoZuiji普徴随時(KarisanteiFukaDaichoItem iten4, EditedKariSanteiFukaDaichoJoho entity) {
        if (!(entity.get普徴随時() == null)) {
            iten4.setListFuchoZuiji_1(entity.get普徴随時().get普徴随時１());
            iten4.setListFuchoZuiji_2(entity.get普徴随時().get普徴随時２());
            iten4.setListFuchoZuiji_3(entity.get普徴随時().get普徴随時３());
            iten4.setListFuchoZuiji_4(entity.get普徴随時().get普徴随時４());
            iten4.setListFuchoZuiji_5(entity.get普徴随時().get普徴随時５());
            iten4.setListFuchoZuiji_6(entity.get普徴随時().get普徴随時６());
            iten4.setListFuchoZuiji_7(entity.get普徴随時().get普徴随時７());
            iten4.setListFuchoZuiji_8(entity.get普徴随時().get普徴随時８());
            iten4.setListFuchoZuiji_9(entity.get普徴随時().get普徴随時９());
            iten4.setListFuchoZuiji_10(entity.get普徴随時().get普徴随時１０());
            iten4.setListFuchoZuiji_11(entity.get普徴随時().get普徴随時１１());
            iten4.setListFuchoZuiji_12(entity.get普徴随時().get普徴随時１２());
            iten4.setListFuchoZuiji_13(entity.get普徴随時().get普徴随時１３());
            iten4.setListFuchoZuiji_14(entity.get普徴随時().get普徴随時１４());
        }

    }

    /**
     * listTokuChoshu特別徴収収入額
     *
     * @param iten4 KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     */
    private void listTokuChoshu特別徴収収入額(KarisanteiFukaDaichoItem iten4, EditedKariSanteiFukaDaichoJoho entity) {
        if (!(entity.get特別徴収収入額() == null)) {
            iten4.setListTokuChoshu_10(entity.get特別徴収収入額().get特徴金額５());
            iten4.setListTokuChoshu_11(entity.get特別徴収収入額().get特徴金額６());
            iten4.setListTokuChoshu_12(entity.get特別徴収収入額().get特徴金額７());
            iten4.setListTokuChoshu_13(entity.get特別徴収収入額().get特徴金額８());
            iten4.setListTokuChoshu_14(entity.get特別徴収収入額().get特徴金額９());
            iten4.setListTokuChoshu_15(entity.get特別徴収収入額().get特徴金額１０());
            iten4.setListTokuChoshu_16(entity.get特別徴収収入額().get特徴金額１１());
            iten4.setListTokuChoshu_17(entity.get特別徴収収入額().get特徴金額１２());
            iten4.setListTokuChoshu_18(entity.get特別徴収収入額().get特徴金額１３());
            iten4.setListTokuChoshu_19(entity.get特別徴収収入額().get特徴金額１４());
            iten4.setListTokuChoshu_3(entity.get特別徴収収入額().get特徴仮算定保険料());
            iten4.setListTokuChoshu_4(entity.get特別徴収収入額().get特徴納付済額());
            iten4.setListTokuChoshu_5(entity.get特別徴収収入額().get特徴今後納付すべき額());
            iten4.setListTokuChoshu_6(entity.get特別徴収収入額().get特徴金額１());
            iten4.setListTokuChoshu_7(entity.get特別徴収収入額().get特徴金額２());
            iten4.setListTokuChoshu_8(entity.get特別徴収収入額().get特徴金額３());
            iten4.setListTokuChoshu_9(entity.get特別徴収収入額().get特徴金額４());
        }

    }

    /**
     * listTokuchoKi特徴期
     *
     * @param iten1 KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     */
    private void listTokuchoKi特徴期(KarisanteiFukaDaichoItem iten1, EditedKariSanteiFukaDaichoJoho entity) {
        if (!(entity.get特徴期() == null)) {
            iten1.setListTokuchoKi_1(entity.get特徴期().get特徴期１());
            iten1.setListTokuchoKi_2(entity.get特徴期().get特徴期２());
            iten1.setListTokuchoKi_3(entity.get特徴期().get特徴期３());
            iten1.setListTokuchoKi_4(entity.get特徴期().get特徴期４());
            iten1.setListTokuchoKi_5(entity.get特徴期().get特徴期５());
            iten1.setListTokuchoKi_6(entity.get特徴期().get特徴期６());
            iten1.setListTokuchoKi_7(entity.get特徴期().get特徴期７());
            iten1.setListTokuchoKi_8(entity.get特徴期().get特徴期８());
            iten1.setListTokuchoKi_9(entity.get特徴期().get特徴期９());
            iten1.setListTokuchoKi_10(entity.get特徴期().get特徴期１０());
            iten1.setListTokuchoKi_11(entity.get特徴期().get特徴期１１());
            iten1.setListTokuchoKi_12(entity.get特徴期().get特徴期１２());
            iten1.setListTokuchoKi_13(entity.get特徴期().get特徴期１３());
            iten1.setListTokuchoKi_14(entity.get特徴期().get特徴期１４());
        }

    }

    /**
     * listTokuchoTsuki特徴月
     *
     * @param iten1 KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     */
    private void listTokuchoTsuki特徴月(KarisanteiFukaDaichoItem iten1, EditedKariSanteiFukaDaichoJoho entity) {
        if (!(entity.get特徴月() == null)) {
            iten1.setListTokuchoTsuki_1(entity.get特徴月().get特徴月１());
            iten1.setListTokuchoTsuki_2(entity.get特徴月().get特徴月２());
            iten1.setListTokuchoTsuki_3(entity.get特徴月().get特徴月３());
            iten1.setListTokuchoTsuki_4(entity.get特徴月().get特徴月４());
            iten1.setListTokuchoTsuki_5(entity.get特徴月().get特徴月５());
            iten1.setListTokuchoTsuki_6(entity.get特徴月().get特徴月６());
            iten1.setListTokuchoTsuki_7(entity.get特徴月().get特徴月７());
            iten1.setListTokuchoTsuki_8(entity.get特徴月().get特徴月８());
            iten1.setListTokuchoTsuki_9(entity.get特徴月().get特徴月９());
            iten1.setListTokuchoTsuki_10(entity.get特徴月().get特徴月１０());
            iten1.setListTokuchoTsuki_11(entity.get特徴月().get特徴月１１());
            iten1.setListTokuchoTsuki_12(entity.get特徴月().get特徴月１２());
            iten1.setListTokuchoTsuki_13(entity.get特徴月().get特徴月１３());
            iten1.setListTokuchoTsuki_14(entity.get特徴月().get特徴月１４());
        }

    }

    /**
     * listSetaiin世帯員情報リスト
     *
     * @param ite KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     */
    private void listSetaiin世帯員情報リスト(KarisanteiFukaDaichoItem ite, EditedKariSanteiFukaDaichoJoho entity,
            int i) {
        ite.setListSetaiin_1(entity.get世帯員情報リスト().get(i).get世帯員識別コード());
        ite.setListSetaiin_2(entity.get世帯員情報リスト().get(i).get世帯員氏名());
        ite.setListSetaiin_3(entity.get世帯員情報リスト().get(i).get世帯員性別());
        ite.setListSetaiin_4(entity.get世帯員情報リスト().get(i).get世帯員生年月日());
        ite.setListSetaiin_5(entity.get世帯員情報リスト().get(i).get世帯員続柄());
        ite.setListSetaiin_6(entity.get世帯員情報リスト().get(i).get世帯員合計取得金額());
        ite.setListSetaiin_7(RString.isNullOrEmpty(entity.get世帯員情報リスト().get(i).get世帯員課税区分())
                ? RString.EMPTY : KazeiKubun.toValue(entity.get世帯員情報リスト().get(i).get世帯員課税区分()).get名称());
    }

    /**
     * listSetaiin1世帯員情報リスト
     *
     * @param ite KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     */
    private void listSetaiin1世帯員情報リスト(KarisanteiFukaDaichoItem ite, EditedKariSanteiFukaDaichoJoho entity,
            int i) {
        ite.setListSetaiin_8(entity.get世帯員情報リスト().get(i).get世帯員識別コード());
        ite.setListSetaiin_9(entity.get世帯員情報リスト().get(i).get世帯員氏名());
        ite.setListSetaiin_10(entity.get世帯員情報リスト().get(i).get世帯員性別());
        ite.setListSetaiin_11(entity.get世帯員情報リスト().get(i).get世帯員生年月日());
        ite.setListSetaiin_12(entity.get世帯員情報リスト().get(i).get世帯員続柄());
        ite.setListSetaiin_13(entity.get世帯員情報リスト().get(i).get世帯員合計取得金額());
        ite.setListSetaiin_14(RString.isNullOrEmpty(entity.get世帯員情報リスト().get(i).get世帯員課税区分())
                ? RString.EMPTY : KazeiKubun.toValue(entity.get世帯員情報リスト().get(i).get世帯員課税区分()).get名称());
    }

    /**
     * parttoentity
     *
     * @param iten4 KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     */
    private void parttoentity(KarisanteiFukaDaichoItem iten4, EditedKariSanteiFukaDaichoJoho entity) {
        iten4.setKozaMeiginin(entity.get口座名義人());
        iten4.setBankName(entity.get金融機関名());
        iten4.setBankNo(entity.get金融機関番号());
        iten4.setChoteiJiyu1(entity.get調定事由1());
        iten4.setChoteiJiyu2(entity.get調定事由2());
        iten4.setChoteiJiyu3(entity.get調定事由3());
        iten4.setChoteiJiyu4(entity.get調定事由4());
        iten4.setChoteiNendo(entity.get調定年度());
        iten4.setDainoninJusho(entity.get代納人住所());
        iten4.setDainoninName(entity.get代納人名称());
        iten4.setDainoninNameKana(entity.get代納人名称カナ());
        iten4.setDainoninRenrakuSaki1(entity.get代納人連絡先１());
        iten4.setDainoninRenrakuSaki2(entity.get代納人連絡先２());
        iten4.setDainoninyubinNo(entity.get代納人郵便NO());
        iten4.setFukaNendo(entity.get賦課年度());
        iten4.setHenkoJiyu1(entity.get変更事由1());
        iten4.setHenkoJiyu2(entity.get変更事由2());
        iten4.setHenkoJiyu3(entity.get変更事由3());
        iten4.setHenkoJiyu4(entity.get変更事由4());
        iten4.setHihokenshaNo(entity.get被保険者番号());
        iten4.setHokenshaName(entity.get保険者名称());
        iten4.setHokenshaNo(entity.get保険者番号());
        iten4.setHoninBirthYMD(entity.get本人生年月日());
        iten4.setHoninJusho(entity.get本人住所());
        iten4.setHoninName(entity.get本人名称());
        iten4.setHoninNameKana(entity.get本人名称カナ());
        iten4.setHoninRenrakuSaki1(entity.get本人連絡先１());
        iten4.setHoninRenrakuSaki2(entity.get本人連絡先２());
        iten4.setHoninSeibetsu(entity.get本人性別());
        iten4.setHoninShotokuDankaiHenko(entity.get本人所得段階変更());
        iten4.setHoninTokuchoGimusha(entity.get本人特徴義務者());
        iten4.setHoninTokuchoTaishoNenkin(entity.get本人特徴対象年金());
        iten4.setHoninyubinNo(entity.get本人郵便番号());
        iten4.setHyojicode1(entity.get表示コード１());
        iten4.setHyojicode2(entity.get表示コード２());
        iten4.setHyojicode3(entity.get表示コード３());
        iten4.setHyojicodeName1(entity.get表示コード名称１());
        iten4.setHyojicodeName2(entity.get表示コード名称２());
        iten4.setHyojicodeName4(entity.get表示コード名称３());
        iten4.setJukyuJoho(entity.get受給情報());
        iten4.setKozaNo(entity.get口座NO());
        iten4.setKozaShurui(entity.get口座種類());
    }

    /**
     * set世帯員情報リストPart1
     *
     * @param item KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     * @param index int
     */
    private void set世帯員情報リストPart1(KarisanteiFukaDaichoItem item,
            EditedKariSanteiFukaDaichoJoho entity,
            int index) {
        if (entity.get世帯員情報リスト().size() > index) {
            item.setListSetaiin_1(entity.get世帯員情報リスト().get(index).get世帯員識別コード());
            item.setListSetaiin_2(entity.get世帯員情報リスト().get(index).get世帯員氏名());
            item.setListSetaiin_3(entity.get世帯員情報リスト().get(index).get世帯員性別());
            item.setListSetaiin_4(entity.get世帯員情報リスト().get(index).get世帯員生年月日());
            item.setListSetaiin_5(entity.get世帯員情報リスト().get(index).get世帯員続柄());
            item.setListSetaiin_6(entity.get世帯員情報リスト().get(index).get世帯員合計取得金額());
            item.setListSetaiin_7(RString.isNullOrEmpty(entity.get世帯員情報リスト().get(index).get世帯員課税区分())
                    ? RString.EMPTY : KazeiKubun.toValue(entity.get世帯員情報リスト().get(index).get世帯員課税区分()).get名称());
        }
    }

    /**
     * set世帯員情報リストPart2
     *
     * @param item KarisanteiFukaDaichoItem
     * @param entity EditedKariSanteiFukaDaichoJoho
     * @param index int
     */
    private void set世帯員情報リストPart2(KarisanteiFukaDaichoItem item,
            EditedKariSanteiFukaDaichoJoho entity,
            int index) {
        if (entity.get世帯員情報リスト().size() > index) {
            item.setListSetaiin_8(entity.get世帯員情報リスト().get(index).get世帯員識別コード());
            item.setListSetaiin_9(entity.get世帯員情報リスト().get(index).get世帯員氏名());
            item.setListSetaiin_10(entity.get世帯員情報リスト().get(index).get世帯員性別());
            item.setListSetaiin_11(entity.get世帯員情報リスト().get(index).get世帯員生年月日());
            item.setListSetaiin_12(entity.get世帯員情報リスト().get(index).get世帯員続柄());
            item.setListSetaiin_13(entity.get世帯員情報リスト().get(index).get世帯員合計取得金額());
            item.setListSetaiin_14(RString.isNullOrEmpty(entity.get世帯員情報リスト().get(index).get世帯員課税区分())
                    ? RString.EMPTY : KazeiKubun.toValue(entity.get世帯員情報リスト().get(index).get世帯員課税区分()).get名称());
        }
    }

}
