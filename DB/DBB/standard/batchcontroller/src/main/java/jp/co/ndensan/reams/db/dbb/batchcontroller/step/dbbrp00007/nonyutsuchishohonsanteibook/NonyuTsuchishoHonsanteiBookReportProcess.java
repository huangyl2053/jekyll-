/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbrp00007.nonyutsuchishohonsanteibook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NofuShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.HenshuHaniKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.nonyutsuchishohonsanteibook.FuriKaeAriCoverToNofushoReportSource;
import jp.co.ndensan.reams.db.dbb.service.report.dbbrp00007.nonyutsuchishohonsanteibook.NonyuTsuchishoHonsanteiBookPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.service.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 保険料納入通知書（本算定）【ブックタイプ】の作成クラスです。
 */
public class NonyuTsuchishoHonsanteiBookReportProcess extends BatchProcessBase<RString> {

    /**
     * OutputParameter用キー outShinseishoKanriNoList
     */
    public static final RString OUT_SHINSEISHO_KANRINO_LIST;
    private static final ReportId REPORTID = new ReportId("DBB100055_DBB100020");
    @BatchWriter
    private BatchReportWriter<FuriKaeAriCoverToNofushoReportSource> batchWrite;
    private ReportSourceWriter<FuriKaeAriCoverToNofushoReportSource> reportSourceWriter;

    private HonSanteiNonyuTsuchiShoJoho bodyItem;
    private static final List<RString> LAYOUT_BREAK_KEY = Collections.unmodifiableList(Arrays.asList(new RString("layoutBreakItem")));

    static {
        OUT_SHINSEISHO_KANRINO_LIST = new RString("outShinseishoKanriNoList");
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(new RString("D:/test.txt"));
    }

    @Override
    protected void createWriter() {

        batchWrite = BatchReportFactory.createBatchReportWriter(REPORTID.value(), SubGyomuCode.DBB介護賦課)
                .addBreak(new BreakerCatalog<FuriKaeAriCoverToNofushoReportSource>().new SimpleLayoutBreaker(




                    LAYOUT_BREAK_KEY) {
                @Override
                    public ReportLineRecord<FuriKaeAriCoverToNofushoReportSource> occuredBreak(ReportLineRecord<FuriKaeAriCoverToNofushoReportSource> currentRecord,
                            ReportLineRecord<FuriKaeAriCoverToNofushoReportSource> nextRecord, ReportDynamicChart dynamicChart) {
                        int layout = currentRecord.getSource().layoutBreakItem;
                        currentRecord.setFormGroupIndex(layout);
                        if (nextRecord != null && nextRecord.getSource() != null) {
                            layout = nextRecord.getSource().layoutBreakItem;
                            nextRecord.setFormGroupIndex(layout);
                        }
                        return currentRecord;
                    }
                }).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(RString entity) {
        bodyItem = setBodyItem();
    }

    @Override
    protected void afterProcess() {

        HonSanteiNonyuTsuchiShoSeigyoJoho 本算定納入通知書制御情報 = new HonSanteiNonyuTsuchiShoSeigyoJoho();
        NonyuTsuchiShoSeigyoJoho 通知書制御情報 = new NonyuTsuchiShoSeigyoJoho();
        通知書制御情報.set当初出力_中期開始期(2);
        通知書制御情報.set当初出力_後期開始期(5);

        本算定納入通知書制御情報.set納入通知書制御情報(通知書制御情報);

        bodyItem.set本算定納入通知書制御情報(本算定納入通知書制御情報);
        bodyItem.set帳票ID(new ReportId("DBB100055"));
        bodyItem.set編集範囲区分(HenshuHaniKubun.全てのレイアウト);

//        bodyItem.get本算定納入通知書制御情報().get納入通知書制御情報().set当初出力_後期開始期(5);
        NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, REPORTID, new FlexibleDate(new RString("20160101")), reportSourceWriter);
//        IAtesaki 宛先 = new _Atesaki(new UaFt250FindAtesakiEntity());   // TODO PSM检索
//        SofubutsuAtesakiEditorBuilder editorBuilder = new SofubutsuAtesakiEditorBuilder(宛先);
//        ReportAtesakiEditor editor = editorBuilder.build();
//        SofubutsuAtesakiSourceBuilder sourceBuild = new SofubutsuAtesakiSourceBuilder(editor);
//        SofubutsuAtesakiSource atesaki = sourceBuild.buildSource();
//        NonyuTsuchishoHonsanteiBookReport report = new NonyuTsuchishoHonsanteiBookReport(bodyItem, ninshoshaSource);
//        report.writeBy(reportSourceWriter);

        NonyuTsuchishoHonsanteiBookPrintService service = new NonyuTsuchishoHonsanteiBookPrintService();
        service.print(bodyItem);

    }

    private HonSanteiNonyuTsuchiShoJoho setBodyItem() {

        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = new ArrayList<>();

        RDate time = new RDate("20160303");
        Decimal decimal = new Decimal(123);
        Map<Integer, RString> OCR = new HashMap<>();
        OCR.put(0, new RString("OCR1"));
        OCR.put(1, new RString("OCR2"));
        OCR.put(2, new RString("OCR3"));

        NonyuTsuchiShoKiJoho 納入通知書期情報1 = new NonyuTsuchiShoKiJoho();
        納入通知書期情報1.set銀振印字位置(0);
        納入通知書期情報1.setコンビニ連帳印字位置(0);
        納入通知書期情報1.setコンビニカット印字位置(0);
        納入通知書期情報1.setブック開始位置(3); //
        納入通知書期情報1.set期(1); //
        納入通知書期情報1.set月(null); //
        納入通知書期情報1.set期表記(new RString("1"));
        納入通知書期情報1.set月表記(new RString("月"));
        納入通知書期情報1.set随時表記(new RString("記"));
        納入通知書期情報1.set科目名称(new RString("科目"));
        納入通知書期情報1.set納期開始日(time);
        納入通知書期情報1.set納期開始日表記(new RString("記"));
        納入通知書期情報1.set納期終了日(time);
        納入通知書期情報1.set納期終了日表記(new RString("表記"));
        納入通知書期情報1.set納期限(time);
        納入通知書期情報1.set納期限表記(new RString("記1"));
        納入通知書期情報1.set納付額(decimal);
        納入通知書期情報1.set納付額表記(new RString("記1"));
        納入通知書期情報1.set調定額(decimal);
        納入通知書期情報1.set調定額表記(new RString("記1"));
        納入通知書期情報1.set収入額(decimal);
        納入通知書期情報1.set収入額表記(new RString("収1"));
        納入通知書期情報1.set差額(decimal);
        納入通知書期情報1.set差額表記(new RString("差額"));
        納入通知書期情報1.set収納機関番号表示用(new RString("収納"));
        納入通知書期情報1.set納付番号(new RString("納付1"));
        納入通知書期情報1.set確認番号(new RString("確認1"));
        納入通知書期情報1.set納付区分(new RString("納付"));
        納入通知書期情報1.setOcrid(new RString("OCRID_1"));
        納入通知書期情報1.setOcr(OCR);
        納入通知書期情報1.setバーコード情報(new RString("バー1"));
        納入通知書期情報1.setバーコード情報上段(new RString("上1"));
        納入通知書期情報1.setバーコード情報下段(new RString("下1"));
        納入通知書期情報1.setコンビニ支払期限(time);
        納入通知書期情報1.set領収証書納付額欄(new RString("領"));
        納入通知書期情報1.set納付書納付額欄(new RString("額1"));
        納入通知書期情報1.set領収証書領収印欄(new RString("印1"));
        納入通知書期情報1.set納付書領収印欄(new RString("収印欄1"));
        納入通知書期情報1.set領収日付印欄(new RString("11"));
        納入通知書期情報1.set領収日付欄(new RString("22"));
        納入通知書期情報1.set領収書日付欄期月(new RString("期月"));

        NonyuTsuchiShoKiJoho 納入通知書期情報2 = new NonyuTsuchiShoKiJoho();
        納入通知書期情報2.set銀振印字位置(0);
        納入通知書期情報2.setコンビニ連帳印字位置(0);
        納入通知書期情報2.setコンビニカット印字位置(0);
        納入通知書期情報2.setブック開始位置(2);  //
        納入通知書期情報2.set期(2); //
        納入通知書期情報2.set月(null); //
        納入通知書期情報2.set期表記(new RString("2"));
        納入通知書期情報2.set月表記(new RString("記2"));
        納入通知書期情報2.set随時表記(new RString("随2"));
        納入通知書期情報2.set科目名称(new RString("科2"));
        納入通知書期情報2.set納期開始日(time);
        納入通知書期情報2.set納期開始日表記(new RString("表2"));
        納入通知書期情報2.set納期終了日(time);
        納入通知書期情報2.set納期終了日表記(new RString("表2"));
        納入通知書期情報2.set納期限(time);
        納入通知書期情報2.set納期限表記(new RString("納2"));
        納入通知書期情報2.set納付額(decimal);
        納入通知書期情報2.set納付額表記(new RString("納2"));
        納入通知書期情報2.set調定額(decimal);
        納入通知書期情報2.set調定額表記(new RString("調2"));
        納入通知書期情報2.set収入額(decimal);
        納入通知書期情報2.set収入額表記(new RString("収2"));
        納入通知書期情報2.set差額(decimal);
        納入通知書期情報2.set差額表記(new RString("差2"));
        納入通知書期情報2.set収納機関番号表示用(new RString("用2"));
        納入通知書期情報2.set納付番号(new RString("納付"));
        納入通知書期情報2.set確認番号(new RString("確認"));
        納入通知書期情報2.set納付区分(new RString("納付"));
        納入通知書期情報2.setOcrid(new RString("OCRID_2"));
        納入通知書期情報2.setOcr(OCR);
        納入通知書期情報2.setバーコード情報(new RString("バ2"));
        納入通知書期情報2.setバーコード情報上段(new RString("上"));
        納入通知書期情報2.setバーコード情報下段(new RString("下"));
        納入通知書期情報2.setコンビニ支払期限(time);
        納入通知書期情報2.set領収証書納付額欄(new RString("欄2"));
        納入通知書期情報2.set納付書納付額欄(new RString("納2"));
        納入通知書期情報2.set領収証書領収印欄(new RString("領2"));
        納入通知書期情報2.set納付書領収印欄(new RString("納2"));
        納入通知書期情報2.set領収日付印欄(new RString("領2"));
        納入通知書期情報2.set領収日付欄(new RString("領2"));
        納入通知書期情報2.set領収書日付欄期月(new RString("領2"));

        NonyuTsuchiShoKiJoho 納入通知書期情報3 = new NonyuTsuchiShoKiJoho();
        納入通知書期情報3.set銀振印字位置(0);
        納入通知書期情報3.setコンビニ連帳印字位置(0);
        納入通知書期情報3.setコンビニカット印字位置(0);
        納入通知書期情報3.setブック開始位置(3); //
        納入通知書期情報3.set期(3); //
        納入通知書期情報3.set月(null); //
        納入通知書期情報3.set期表記(new RString("3"));
        納入通知書期情報3.set月表記(new RString("記3"));
        納入通知書期情報3.set随時表記(new RString("随2"));
        納入通知書期情報3.set科目名称(new RString("科2"));
        納入通知書期情報3.set納期開始日(time);
        納入通知書期情報3.set納期開始日表記(new RString("表2"));
        納入通知書期情報3.set納期終了日(time);
        納入通知書期情報3.set納期終了日表記(new RString("表2"));
        納入通知書期情報3.set納期限(time);
        納入通知書期情報3.set納期限表記(new RString("納記2"));
        納入通知書期情報3.set納付額(decimal);
        納入通知書期情報3.set納付額表記(new RString("納2"));
        納入通知書期情報3.set調定額(decimal);
        納入通知書期情報3.set調定額表記(new RString("調2"));
        納入通知書期情報3.set収入額(decimal);
        納入通知書期情報3.set収入額表記(new RString("収2"));
        納入通知書期情報3.set差額(decimal);
        納入通知書期情報3.set差額表記(new RString("差2"));
        納入通知書期情報3.set収納機関番号表示用(new RString("用2"));
        納入通知書期情報3.set納付番号(new RString("納付"));
        納入通知書期情報3.set確認番号(new RString("確認"));
        納入通知書期情報3.set納付区分(new RString("納付"));
        納入通知書期情報3.setOcrid(new RString("OCRID_2"));
        納入通知書期情報3.setOcr(OCR);
        納入通知書期情報3.setバーコード情報(new RString("バ2"));
        納入通知書期情報3.setバーコード情報上段(new RString("上段"));
        納入通知書期情報3.setバーコード情報下段(new RString("下段"));
        納入通知書期情報3.setコンビニ支払期限(time);
        納入通知書期情報3.set領収証書納付額欄(new RString("欄2"));
        納入通知書期情報3.set納付書納付額欄(new RString("納2"));
        納入通知書期情報3.set領収証書領収印欄(new RString("33"));
        納入通知書期情報3.set納付書領収印欄(new RString("納2"));
        納入通知書期情報3.set領収日付印欄(new RString("44"));
        納入通知書期情報3.set領収日付欄(new RString("55"));
        納入通知書期情報3.set領収書日付欄期月(new RString("66"));

        NonyuTsuchiShoKiJoho 納入通知書期情報4 = new NonyuTsuchiShoKiJoho();
        納入通知書期情報4.set銀振印字位置(0);
        納入通知書期情報4.setコンビニ連帳印字位置(0);
        納入通知書期情報4.setコンビニカット印字位置(0);
        納入通知書期情報4.setブック開始位置(3);  //
        納入通知書期情報4.set期(4);  //
        納入通知書期情報4.set月(null);  //
        納入通知書期情報4.set期表記(new RString("4"));
        納入通知書期情報4.set月表記(new RString("記4"));
        納入通知書期情報4.set随時表記(new RString("随4"));
        納入通知書期情報4.set科目名称(new RString("科4"));
        納入通知書期情報4.set納期開始日(time);
        納入通知書期情報4.set納期開始日表記(new RString("表4"));
        納入通知書期情報4.set納期終了日(time);
        納入通知書期情報4.set納期終了日表記(new RString("表記4"));
        納入通知書期情報4.set納期限(time);
        納入通知書期情報4.set納期限表記(new RString("納4"));
        納入通知書期情報4.set納付額(decimal);
        納入通知書期情報4.set納付額表記(new RString("納4"));
        納入通知書期情報4.set調定額(decimal);
        納入通知書期情報4.set調定額表記(new RString("調4"));
        納入通知書期情報4.set収入額(decimal);
        納入通知書期情報4.set収入額表記(new RString("収4"));
        納入通知書期情報4.set差額(decimal);
        納入通知書期情報4.set差額表記(new RString("差4"));
        納入通知書期情報4.set収納機関番号表示用(new RString("用4"));
        納入通知書期情報4.set納付番号(new RString("納付"));
        納入通知書期情報4.set確認番号(new RString("確認"));
        納入通知書期情報4.set納付区分(new RString("納付"));
        納入通知書期情報4.setOcrid(new RString("OCRID_4"));
        納入通知書期情報4.setOcr(OCR);
        納入通知書期情報4.setバーコード情報(new RString("バ4"));
        納入通知書期情報4.setバーコード情報上段(new RString("上段"));
        納入通知書期情報4.setバーコード情報下段(new RString("下段"));
        納入通知書期情報4.setコンビニ支払期限(time);
        納入通知書期情報4.set領収証書納付額欄(new RString("欄4"));
        納入通知書期情報4.set納付書納付額欄(new RString("納4"));
        納入通知書期情報4.set領収証書領収印欄(new RString("77"));
        納入通知書期情報4.set納付書領収印欄(new RString("納4"));
        納入通知書期情報4.set領収日付印欄(new RString("88"));
        納入通知書期情報4.set領収日付欄(new RString("99"));
        納入通知書期情報4.set領収書日付欄期月(new RString("00"));

        NonyuTsuchiShoKiJoho 納入通知書期情報5 = new NonyuTsuchiShoKiJoho();
        納入通知書期情報5.set銀振印字位置(0);
        納入通知書期情報5.setコンビニ連帳印字位置(0);
        納入通知書期情報5.setコンビニカット印字位置(0);
        納入通知書期情報5.setブック開始位置(5);
        納入通知書期情報5.set期(5);
        納入通知書期情報5.set月(null);
        納入通知書期情報5.set期表記(new RString("5"));
        納入通知書期情報5.set月表記(new RString("5"));
        納入通知書期情報5.set随時表記(new RString("5"));
        納入通知書期情報5.set科目名称(new RString("科5"));
        納入通知書期情報5.set納期開始日(time);
        納入通知書期情報5.set納期開始日表記(new RString("表5"));
        納入通知書期情報5.set納期終了日(time);
        納入通知書期情報5.set納期終了日表記(new RString("表5"));
        納入通知書期情報5.set納期限(time);
        納入通知書期情報5.set納期限表記(new RString("納5"));
        納入通知書期情報5.set納付額(decimal);
        納入通知書期情報5.set納付額表記(new RString("納5"));
        納入通知書期情報5.set調定額(decimal);
        納入通知書期情報5.set調定額表記(new RString("調5"));
        納入通知書期情報5.set収入額(decimal);
        納入通知書期情報5.set収入額表記(new RString("収5"));
        納入通知書期情報5.set差額(decimal);
        納入通知書期情報5.set差額表記(new RString("差5"));
        納入通知書期情報5.set収納機関番号表示用(new RString("用5"));
        納入通知書期情報5.set納付番号(new RString("納付"));
        納入通知書期情報5.set確認番号(new RString("確認"));
        納入通知書期情報5.set納付区分(new RString("納付"));
        納入通知書期情報5.setOcrid(new RString("OCRID_2"));
        納入通知書期情報5.setOcr(OCR);
        納入通知書期情報5.setバーコード情報(new RString("バ2"));
        納入通知書期情報5.setバーコード情報上段(new RString("上段"));
        納入通知書期情報5.setバーコード情報下段(new RString("下段"));
        納入通知書期情報5.setコンビニ支払期限(time);
        納入通知書期情報5.set領収証書納付額欄(new RString("欄2"));
        納入通知書期情報5.set納付書納付額欄(new RString("納2"));
        納入通知書期情報5.set領収証書領収印欄(new RString("aa"));
        納入通知書期情報5.set納付書領収印欄(new RString("納2"));
        納入通知書期情報5.set領収日付印欄(new RString("bb"));
        納入通知書期情報5.set領収日付欄(new RString("cc"));
        納入通知書期情報5.set領収書日付欄期月(new RString("dd"));

        納入通知書期情報リスト.add(納入通知書期情報1);
        納入通知書期情報リスト.add(納入通知書期情報2);
        納入通知書期情報リスト.add(納入通知書期情報3);
        納入通知書期情報リスト.add(納入通知書期情報4);
        納入通知書期情報リスト.add(納入通知書期情報5);

        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = new EditedHonSanteiTsuchiShoKyotsu();
        HyojiCodes 表示コード = new HyojiCodes();
        表示コード.set表示コード名１(new RString("表１"));
        表示コード.set表示コード名２(new RString("表２"));
        表示コード.set表示コード名３(new RString("表３"));

//        UaFt200FindShikibetsuTaishoEntity entity;
//        IKojin 個人 = new _Kojin(new _ShikibetsuTaishoEntityHolder());
//        EditedKojin 編集後個人 = new EditedKojin(個人);
//        IKoza 口座 = new Koza(new KozaRelateEntity());
//        EditedKoza 編集後口座 = new EditedKoza(口座, new ChohyoSeigyoKyotsu(SubGyomuCode.DBB介護賦課, REPORTID));
        EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正後 = new EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection();
        更正後.set普通徴収額合計(decimal);
        更正後.set保険料率(new Decimal(1.3));
        更正後.set減免前保険料_年額(new Decimal(2));
        更正後.set減免額(new Decimal(3));
        更正後.set特別徴収額合計(new Decimal(4));
        更正後.set普通徴収額合計(new Decimal(5));
        更正後.set月数_ケ月(new RString("3"));
        更正後.set確定保険料_年額(new Decimal(100));

        編集後本算定通知書共通情報.set調定年度_年度なし(new RString("調定年度"));
        編集後本算定通知書共通情報.set表示コード(表示コード);
//        編集後本算定通知書共通情報.set編集後個人(編集後個人);
//        編集後本算定通知書共通情報.set編集後口座(編集後口座);
        編集後本算定通知書共通情報.set更正後(更正後);
        編集後本算定通知書共通情報.set通知書番号(TsuchishoNo.EMPTY);
        編集後本算定通知書共通情報.set識別コード(new ShikibetsuCode(new RString("201647")));

        NofuShoKyotsu 納付書共通 = new NofuShoKyotsu();
        納付書共通.set調定年度(FlexibleYear.EMPTY);
        納付書共通.set調定年度表記(RString.EMPTY);
        納付書共通.set賦課年度(FlexibleYear.EMPTY);
        納付書共通.set賦課年度表記(RString.EMPTY);
        納付書共通.set年度年分表記(RString.EMPTY);
        納付書共通.set通知書番号(new TsuchishoNo(new RString("123-1")));
        納付書共通.set世帯コード(new SetaiCode(new RString("111")));
        納付書共通.set表示コード(new HyojiCodes());
        納付書共通.set科目名称(RString.EMPTY);
        納付書共通.set発行日(RDate.MAX);
        納付書共通.set発行日表記(RString.EMPTY);
        納付書共通.set住所(RString.EMPTY);
        納付書共通.set郵便番号(RString.EMPTY);
        納付書共通.set行政区名(RString.EMPTY);
        納付書共通.set方書(RString.EMPTY);
        納付書共通.set代納人氏名(new AtenaMeisho(new RString("xy")));
        納付書共通.set被保険者氏名(new AtenaMeisho(new RString("xy2")));
        納付書共通.set納付者氏名(RString.EMPTY);
        納付書共通.set被代納人氏名(RString.EMPTY);
        納付書共通.set被代納人敬称(RString.EMPTY);
        納付書共通.set納付書市町村名(RString.EMPTY);

        HonSanteiNonyuTsuchiShoJoho joho = new HonSanteiNonyuTsuchiShoJoho();
        joho.set納入通知書期情報リスト(納入通知書期情報リスト);
        joho.set編集後本算定通知書共通情報(編集後本算定通知書共通情報);
        joho.set帳票ID(new ReportId("DBB100055"));
        joho.set編集範囲区分(HenshuHaniKubun.全てのレイアウト);
        joho.set処理区分(ShoriKubun.リアル);
        joho.set納付書共通(納付書共通);

        return joho;
    }

}
