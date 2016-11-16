/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190010;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoketteitsuchiichiran.KijunShunyugakuTekiyoKetteiTsuchiIchiran;
import jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoketteitsuchiichiran.KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder;
import jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoketteitsuchiichiran.KijunShunyugakuTekiyoKetteiTsuchiIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoketteitsuchiichiran.KijunShunyugakuTekiyoKetteiTsuchiIchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoketteitsuchisho.KijunShunyugakuTekiyoKetteiTsuchisho;
import jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoketteitsuchisho.KijunShunyugakuTekiyoKetteiTsuchishoReport;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kijunshunyugakutekiyokettei.KijunShunyugakuTekiyoKetteiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kijunshunyugakutekiyokettei.SpoolKijunShunyugakuTekiyoKetteiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kijunshunyugakutekiyokettei.KijunShunyugakuTekiyoKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoketteitsuchiichiran.KijunShunyugakuTekiyoKetteiTsuchiIchiranSource;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoketteitsuchisho.KijunShunyugakuTekiyoKetteiTsuchishoSource;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KijunShunyugakuTekiyoKanriManager;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.db.dbz.service.core.teikeibunhenkan.KaigoTextHenkanRuleCreator;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiEditorBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiSourceBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.util.atesaki.ReportAtesakiEditor;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.IBatchReportWriterWithCheckList;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.core.teikeibunhenkan.ITextHenkanRule;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListInfoFactory;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListLineItemSet;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckShubetsu;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckListInfo;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckTarget;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ISpecificKey;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 基準収入額決定通知書発行processクラスです。
 *
 * @reamsid_L DBC-4610-030 xuhao
 */
public class SpoolKijunShunyugakuTekiyoKetteiProcess extends BatchKeyBreakBase<KijunShunyugakuTekiyoKetteiEntity> {

    private SpoolKijunShunyugakuTekiyoKetteiProcessParameter parameter;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private IOutputOrder 並び順;
    private int count;
    private RString 出力順;
    private List<RString> 改頁項目リスト;
    private List<RString> 出力順リスト;
    private List<RString> 改頁List;
    private ITextHenkanRule rule;
    private List<KijunShunyugakuTekiyoKetteiEntity> 基準収入額適用管理List;
    private KijunShunyugakuTekiyoKanriManager 基準収入額適用管理manager;
    private int 一覧表_通番;
    private boolean is検索結果データあり;
    private SetaiCode 一覧表_世帯コード;
    private FlexibleYear 一覧表_年度;
    private static final ReportId 帳票ID_通知書 = new ReportId("DBC100074_KijunShunyugakuTekiyoKetteiTsuchisho");
    private static final RString ORDER_BY = new RString("order by");
    private static final RString タイトル = new RString("基準収入額適用決定通知書");
    private static final RString 定数_その他 = new RString("その他 ");
    private static final RString 定数_人 = new RString("人");
    private static final RString 定数_被保険者名1 = new RString("被保険者名カナ１");
    private static final RString 定数_被保険者名2 = new RString("被保険者名カナ２");
    private static final RString 定数_被保険者名3 = new RString("被保険者名カナ３");
    private static final RString チェック項目名1 = new RString("hihokenshaNameKana1");
    private static final RString チェック項目名2 = new RString("hihokenshaNameKana2");
    private static final RString チェック項目名3 = new RString("hihokenshaNameKana3");
    private static final RString 定数_被保険者番号 = new RString("被保険者番号");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_31 = 31;
    private static final int 文字切れ対象文字列長 = 40;
    private static final RString なし = new RString("なし");

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunshunyugakutekiyokettei."
            + "IKijunShunyugakuTekiyoKetteiMapper.select基準収入額適用管理");

    @BatchWriter
    private IBatchReportWriterWithCheckList<KijunShunyugakuTekiyoKetteiTsuchishoSource> batchReportWriter_通知書_文字切れ;
    private ReportSourceWriter<KijunShunyugakuTekiyoKetteiTsuchishoSource> reportSourceWriter_通知書_文字切れ;
    private BatchReportWriter<KijunShunyugakuTekiyoKetteiTsuchiIchiranSource> batchReportWriter_一覧表;
    private ReportSourceWriter<KijunShunyugakuTekiyoKetteiTsuchiIchiranSource> reportSourceWriter_一覧表;

    @Override
    protected void initialize() {
        is検索結果データあり = false;
        一覧表_通番 = INT_0;
        count = INT_0;
        改頁項目リスト = new ArrayList<>();
        出力順リスト = new ArrayList<>();
        rule = KaigoTextHenkanRuleCreator.createRule(SubGyomuCode.DBC介護給付, 帳票ID_通知書);
        基準収入額適用管理List = new ArrayList<>();
        基準収入額適用管理manager = new KijunShunyugakuTekiyoKanriManager();
        帳票制御共通 = new ChohyoSeigyoKyotsuManager()
                .get帳票制御共通(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100074.getReportId());
        並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBC介護給付, 帳票ID_通知書, Long.parseLong(parameter.get帳票出力順ID().toString()));
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁項目リスト.add(item.get項目名());
                }
            }
        }
        改頁List = get改頁List();
        出力順リスト = get出力順List();
    }

    @Override
    protected IBatchReader createReader() {
        KijunShunyugakuTekiyoKetteiMybatisParameter 基準収入額適用管理の取得Parameter = new KijunShunyugakuTekiyoKetteiMybatisParameter();
        基準収入額適用管理の取得Parameter.set抽出期間(parameter.get抽出期間());
        基準収入額適用管理の取得Parameter.set開始日(parameter.get開始日());
        基準収入額適用管理の取得Parameter.set終了日(parameter.get終了日());
        基準収入額適用管理の取得Parameter.set印書(parameter.get印書());
        if (並び順 != null) {
            出力順 = MyBatisOrderByClauseCreator.create(
                    KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.class, 並び順).replace(ORDER_BY, RString.EMPTY);
            基準収入額適用管理の取得Parameter.setTemp_出力順(出力順);
        } else {
            基準収入額適用管理の取得Parameter.setTemp_出力順(null);
        }
        return new BatchDbReader(READ_DATA_ID, 基準収入額適用管理の取得Parameter);
    }

    @Override
    protected void createWriter() {
        ICheckListInfo info = CheckListInfoFactory.createInstance(SubGyomuCode.DBC介護給付,
                parameter.get市町村コード(), parameter.get市町村名());
        CheckListLineItemSet pairs = CheckListLineItemSet.of(特定項目.class, チェック項目.class);
        batchReportWriter_通知書_文字切れ = BatchWriters
                .batchReportWriterWithCheckList(KijunShunyugakuTekiyoKetteiTsuchishoSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(帳票ID_通知書)
                .build();
        reportSourceWriter_通知書_文字切れ = new ReportSourceWriter<>(batchReportWriter_通知書_文字切れ);
        PageBreaker<KijunShunyugakuTekiyoKetteiTsuchiIchiranSource> breaker = new KijunShunyugakuTekiyoKetteiTsuchiIchiranPageBreak(改頁項目リスト);
        batchReportWriter_一覧表 = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC200092.getReportId().value(), SubGyomuCode.DBC介護給付).addBreak(breaker).create();
        reportSourceWriter_一覧表 = new ReportSourceWriter<>(batchReportWriter_一覧表);
    }

    @Override
    protected void keyBreakProcess(KijunShunyugakuTekiyoKetteiEntity entity) {
    }

    @Override
    protected void usualProcess(KijunShunyugakuTekiyoKetteiEntity entity) {
        KijunShunyugakuTekiyoKetteiEntity beforeEntity = getBefore();
        if (beforeEntity == null) {
            beforeEntity = entity;
        }
        boolean 改頁Flag = new KijunShunyugakuTekiyoKetteiTsuchiIchiranPageBreak(改頁項目リスト).is改頁(entity, beforeEntity);
        KijunShunyugakuTekiyoKetteiTsuchiIchiran 基準収入額決定通知一覧表パラメータ = get基準収入額決定通知一覧表パラメータ();
        基準収入額決定通知一覧表パラメータ = get基準収入額決定通知一覧表パラメータ2(entity, 改頁Flag, 基準収入額決定通知一覧表パラメータ);
        KijunShunyugakuTekiyoKetteiTsuchiIchiranReport 一覧表report
                = new KijunShunyugakuTekiyoKetteiTsuchiIchiranReport(基準収入額決定通知一覧表パラメータ);
        一覧表report.writeBy(reportSourceWriter_一覧表);
        一覧表_世帯コード = entity.get世帯コード();
        一覧表_年度 = entity.get年度();
        if (getBefore() == null || (getBefore().get世帯コード().equals(entity.get世帯コード())
                && getBefore().get適用開始年月().equals(entity.get適用開始年月()))) {
            基準収入額適用管理List.add(entity);
        } else {
            KijunShunyugakuTekiyoKetteiTsuchisho 基準収入額適用決定通知書Parameter = get基準収入額適用決定通知書パラメータ();
            KijunShunyugakuTekiyoKetteiTsuchishoReport 通知書report
                    = new KijunShunyugakuTekiyoKetteiTsuchishoReport(基準収入額適用決定通知書Parameter, 帳票制御共通);
            通知書report.writeBy(reportSourceWriter_通知書_文字切れ);
            基準収入額適用管理List = new ArrayList<>();
            基準収入額適用管理List.add(entity);
        }
        基準収入額適用管理manager.update決定通知書発行日(entity.get世帯コード(), entity.get年度(),
                entity.get履歴番号(), entity.get被保険者番号(), parameter.get作成日());
    }

    @Override
    protected void afterExecute() {
        if (一覧表_通番 == 0) {
            KijunShunyugakuTekiyoKetteiTsuchiIchiran 基準収入額決定通知一覧表パラメータ = get基準収入額決定通知一覧表パラメータ();
            KijunShunyugakuTekiyoKetteiTsuchiIchiranReport 一覧表report
                    = new KijunShunyugakuTekiyoKetteiTsuchiIchiranReport(基準収入額決定通知一覧表パラメータ);
            一覧表report.writeBy(reportSourceWriter_一覧表);
        }
        if (!基準収入額適用管理List.isEmpty()) {
            KijunShunyugakuTekiyoKetteiTsuchisho 基準収入額適用決定通知書Parameter = get基準収入額適用決定通知書パラメータ();
            KijunShunyugakuTekiyoKetteiTsuchishoReport 通知書report
                    = new KijunShunyugakuTekiyoKetteiTsuchishoReport(基準収入額適用決定通知書Parameter, 帳票制御共通);
            通知書report.writeBy(reportSourceWriter_通知書_文字切れ);
        }
        ShoriDateKanriManager 処理日付管理マスタmanager = new ShoriDateKanriManager();
        処理日付管理マスタmanager.update対象開始日時AND対象終了日時(SubGyomuCode.DBC介護給付, parameter.get市町村コード(), タイトル,
                parameter.get抽出期間(), parameter.get開始日(), parameter.get終了日());
        バッチ出力条件リストの出力();
        batchReportWriter_一覧表.close();
    }

    private void バッチ出力条件リストの出力() {
        RString ジョブ番号 = new RString(JobContextHolder.getJobId());
        RString 帳票名 = ReportIdDBC.DBC100074.getReportName();
        RString 出力ページ数 = new RString(String.valueOf(reportSourceWriter_通知書_文字切れ.pageCount().value()));
        RString csv出力有無 = なし;
        RString csvファイル名 = new RString("設定なし");
        RString 市町村コード = new RString(parameter.get市町村コード().toString());
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(new RString("【抽出条件】"));
        出力条件.add(new RString("申請年月日:").concat(parameter.get開始日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString())
                .concat(new RString(" ～ ")).concat(parameter.get終了日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString()));
        if (new RString("1").equals(parameter.get印書())) {
            出力条件.add(new RString("印書:発行済みも含める"));
        } else {
            出力条件.add(new RString("印書:未発行分のみ"));
        }
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                帳票ID_通知書.value(), 市町村コード, parameter.get市町村名(), ジョブ番号,
                帳票名, 出力ページ数, csv出力有無, csvファイル名, 出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
        printer.print();
    }

    private KijunShunyugakuTekiyoKetteiTsuchisho get基準収入額適用決定通知書パラメータ() {
        KijunShunyugakuTekiyoKetteiTsuchisho 基準収入額適用決定通知書Parameter = new KijunShunyugakuTekiyoKetteiTsuchisho();
        for (KijunShunyugakuTekiyoKetteiEntity entity : 基準収入額適用管理List) {
            if (entity.is宛先印字対象者フラグ() && entity.get宛先Entity() != null) {
                IAtesaki atesaki = AtesakiFactory.createInstance(entity.get宛先Entity());
                ReportAtesakiEditor editor = new SofubutsuAtesakiEditorBuilder(atesaki).build();
                SofubutsuAtesakiSource compSofubutsuAtesakiソース = new SofubutsuAtesakiSourceBuilder(editor).buildSource();
                基準収入額適用決定通知書Parameter.setCompSofubutsuAtesakiソース(compSofubutsuAtesakiソース);
                break;
            }
        }
        基準収入額適用決定通知書Parameter.set文書番号(parameter.get文書番号());
        基準収入額適用決定通知書Parameter.setタイトル(タイトル);
        if (INT_0 < 基準収入額適用管理List.size()) {
            基準収入額適用決定通知書Parameter.set申請年月日(基準収入額適用管理List.get(INT_0).get申請日());
            基準収入額適用決定通知書Parameter.set決定年月日(基準収入額適用管理List.get(INT_0).get決定日());
            基準収入額適用決定通知書Parameter.set適用開始年月(基準収入額適用管理List.get(INT_0).get適用開始年月());
            基準収入額適用決定通知書Parameter.set被保険者番号１(基準収入額適用管理List.get(INT_0).get被保険者番号());
            基準収入額適用決定通知書Parameter.set算定基準額(基準収入額適用管理List.get(INT_0).get算定基準額());
            set宛名識別対象情報_1件目(基準収入額適用決定通知書Parameter);
            基準収入額適用決定通知書Parameter.set識別コード１(基準収入額適用管理List.get(INT_0).get識別コード());
        }
        if (INT_1 < 基準収入額適用管理List.size()) {
            基準収入額適用決定通知書Parameter.set被保険者番号２(基準収入額適用管理List.get(INT_1).get被保険者番号());
            set宛名識別対象情報_2件目(基準収入額適用決定通知書Parameter);
            基準収入額適用決定通知書Parameter.set識別コード２(基準収入額適用管理List.get(INT_1).get識別コード());
        }
        if (INT_2 < 基準収入額適用管理List.size()) {
            基準収入額適用決定通知書Parameter.set被保険者番号３(基準収入額適用管理List.get(INT_2).get被保険者番号());
            set宛名識別対象情報_3件目(基準収入額適用決定通知書Parameter);
            基準収入額適用決定通知書Parameter.set識別コード３(基準収入額適用管理List.get(INT_2).get識別コード());
        }
        if (INT_3 < 基準収入額適用管理List.size()) {
            int その他の人 = 基準収入額適用管理List.size() - INT_3;
            基準収入額適用決定通知書Parameter.setその他被保険者(定数_その他.concat(String.valueOf(その他の人)).concat(定数_人));
        }
        基準収入額適用決定通知書Parameter.setFlag(false);
        is文字切れ(基準収入額適用決定通知書Parameter);
        NinshoshaSource compNinshoshaソース = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 帳票ID_通知書,
                parameter.get作成日(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                KenmeiFuyoKubunType.付与なし, reportSourceWriter_通知書_文字切れ);
        基準収入額適用決定通知書Parameter.setCompNinshoshaソース(compNinshoshaソース);
        set通知文(基準収入額適用決定通知書Parameter);
        return 基準収入額適用決定通知書Parameter;
    }

    private void set通知文(KijunShunyugakuTekiyoKetteiTsuchisho 基準収入額適用決定通知書Parameter) {
        Map<Integer, RString> 通知文_1;
        Map<Integer, RString> 通知文_2;
        Map<Integer, RString> 通知文_3;
        Map<Integer, RString> 通知文_4;
        通知文_1 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 帳票ID_通知書, KamokuCode.EMPTY, INT_1);
        通知文_2 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 帳票ID_通知書, KamokuCode.EMPTY, INT_2);
        通知文_3 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 帳票ID_通知書, KamokuCode.EMPTY, INT_3);
        通知文_4 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, 帳票ID_通知書, KamokuCode.EMPTY, INT_4);

        if (通知文_1 != null && !通知文_1.isEmpty()) {
            基準収入額適用決定通知書Parameter.set通知文１(rule.editText(checkNull(通知文_1.get(INT_1))));
        }
        if (通知文_1 != null && !通知文_1.isEmpty()) {
            基準収入額適用決定通知書Parameter.set通知文２(rule.editText(checkNull(通知文_1.get(INT_2))));
        }
        if (通知文_2 != null && !通知文_2.isEmpty()) {
            基準収入額適用決定通知書Parameter.set通知文３_大(rule.editText(checkNull(通知文_2.get(INT_2))));
        }
        if (通知文_3 != null && !通知文_3.isEmpty()) {
            基準収入額適用決定通知書Parameter.set通知文4_上小(rule.editText(checkNull(通知文_3.get(INT_2))));
        }
        if (通知文_3 != null && !通知文_3.isEmpty()) {
            基準収入額適用決定通知書Parameter.set通知文5_下大(rule.editText(checkNull(通知文_3.get(INT_3))));
        }
        if (通知文_4 != null && !通知文_4.isEmpty()) {
            基準収入額適用決定通知書Parameter.set通知文6_上大(rule.editText(checkNull(通知文_4.get(INT_2))));
        }
        if (通知文_4 != null && !通知文_4.isEmpty()) {
            基準収入額適用決定通知書Parameter.set通知文7_下小(rule.editText(checkNull(通知文_4.get(INT_3))));
        }
    }

    private RString checkNull(RString rstring) {
        return rstring == null ? RString.EMPTY : rstring;
    }

    private void set宛名識別対象情報_3件目(KijunShunyugakuTekiyoKetteiTsuchisho 基準収入額適用決定通知書Parameter) throws ClassCastException {
        IShikibetsuTaisho 宛名識別対象情報_3件目 = null;
        if (基準収入額適用管理List.get(INT_2).get宛名Entity() != null) {
            宛名識別対象情報_3件目 = ShikibetsuTaishoFactory.createShikibetsuTaisho(基準収入額適用管理List.get(INT_2).get宛名Entity());
        }
        if (宛名識別対象情報_3件目 != null && 宛名識別対象情報_3件目.to個人() != null) {
            if (宛名識別対象情報_3件目.to個人().is日本人()) {
                基準収入額適用決定通知書Parameter.set被保険者名カナ３(宛名識別対象情報_3件目.to個人().get日本人氏名().getKana());
                基準収入額適用決定通知書Parameter.set被保険者氏名３(宛名識別対象情報_3件目.to個人().get日本人氏名().getName());
            }
            if (宛名識別対象情報_3件目.to個人().is外国人()) {
                基準収入額適用決定通知書Parameter.set被保険者名カナ３(宛名識別対象情報_3件目.to個人().get外国人氏名().getKana());
                基準収入額適用決定通知書Parameter.set被保険者氏名３(宛名識別対象情報_3件目.to個人().get外国人氏名().getName());
            }
        }
    }

    private void set宛名識別対象情報_2件目(KijunShunyugakuTekiyoKetteiTsuchisho 基準収入額適用決定通知書Parameter) throws ClassCastException {
        IShikibetsuTaisho 宛名識別対象情報_2件目 = null;
        if (基準収入額適用管理List.get(INT_1).get宛名Entity() != null) {
            宛名識別対象情報_2件目 = ShikibetsuTaishoFactory.createShikibetsuTaisho(基準収入額適用管理List.get(INT_1).get宛名Entity());
        }
        if (宛名識別対象情報_2件目 != null && 宛名識別対象情報_2件目.to個人() != null) {
            if (宛名識別対象情報_2件目.to個人().is日本人()) {
                基準収入額適用決定通知書Parameter.set被保険者名カナ２(宛名識別対象情報_2件目.to個人().get日本人氏名().getKana());
                基準収入額適用決定通知書Parameter.set被保険者氏名２(宛名識別対象情報_2件目.to個人().get日本人氏名().getName());
            }
            if (宛名識別対象情報_2件目.to個人().is外国人()) {
                基準収入額適用決定通知書Parameter.set被保険者名カナ２(宛名識別対象情報_2件目.to個人().get外国人氏名().getKana());
                基準収入額適用決定通知書Parameter.set被保険者氏名２(宛名識別対象情報_2件目.to個人().get外国人氏名().getName());
            }
        }
    }

    private void set宛名識別対象情報_1件目(KijunShunyugakuTekiyoKetteiTsuchisho 基準収入額適用決定通知書Parameter) throws ClassCastException {
        IShikibetsuTaisho 宛名識別対象情報_1件目 = null;
        if (基準収入額適用管理List.get(INT_0).get宛名Entity() != null) {
            宛名識別対象情報_1件目 = ShikibetsuTaishoFactory.createShikibetsuTaisho(基準収入額適用管理List.get(INT_0).get宛名Entity());
        }
        if (宛名識別対象情報_1件目 != null && 宛名識別対象情報_1件目.to個人() != null) {
            if (宛名識別対象情報_1件目.to個人().is日本人()) {
                基準収入額適用決定通知書Parameter.set被保険者名カナ１(宛名識別対象情報_1件目.to個人().get日本人氏名().getKana());
                基準収入額適用決定通知書Parameter.set被保険者氏名１(宛名識別対象情報_1件目.to個人().get日本人氏名().getName());
            }
            if (宛名識別対象情報_1件目.to個人().is外国人()) {
                基準収入額適用決定通知書Parameter.set被保険者名カナ１(宛名識別対象情報_1件目.to個人().get外国人氏名().getKana());
                基準収入額適用決定通知書Parameter.set被保険者氏名１(宛名識別対象情報_1件目.to個人().get外国人氏名().getName());
            }
        }
    }

    private void is文字切れ(KijunShunyugakuTekiyoKetteiTsuchisho 基準収入額適用決定通知書Parameter) {
        AtenaKanaMeisho 被保険者名カナ１ = 基準収入額適用決定通知書Parameter.get被保険者名カナ１();
        if (被保険者名カナ１ != null && !被保険者名カナ１.isEmpty() && 文字切れ対象文字列長 < 被保険者名カナ１.value().length()) {
            基準収入額適用決定通知書Parameter.setFlag(true);
        }
        AtenaKanaMeisho 被保険者名カナ２ = 基準収入額適用決定通知書Parameter.get被保険者名カナ２();
        if (被保険者名カナ２ != null && !被保険者名カナ２.isEmpty() && 文字切れ対象文字列長 < 被保険者名カナ２.value().length()) {
            基準収入額適用決定通知書Parameter.setFlag(true);
        }
        AtenaKanaMeisho 被保険者名カナ３ = 基準収入額適用決定通知書Parameter.get被保険者名カナ３();
        if (被保険者名カナ３ != null && !被保険者名カナ３.isEmpty() && 文字切れ対象文字列長 < 被保険者名カナ３.value().length()) {
            基準収入額適用決定通知書Parameter.setFlag(true);
        }
    }

    private enum 特定項目 implements ISpecificKey {

        key1(KijunShunyugakuTekiyoKetteiTsuchishoSource.ITEM_HIHOKENSHANO1, 定数_被保険者番号.toString());

        private final RString itemName;

        private final RString printName;

        private 特定項目(String itemName, String printName) {
            this.itemName = new RString(itemName);
            this.printName = new RString(printName);
        }

        @Override
        public RString getItemName() {
            return this.itemName;
        }

        @Override
        public RString getPrintName() {
            return this.printName;
        }
    }

    private enum チェック項目 implements ICheckTarget {

        target1(チェック項目名1.toString(), 定数_被保険者名1.toString(), CheckShubetsu.文字切れ),
        target2(チェック項目名2.toString(), 定数_被保険者名2.toString(), CheckShubetsu.文字切れ),
        target3(チェック項目名3.toString(), 定数_被保険者名3.toString(), CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目(String itemName, String printName, CheckShubetsu checkShubetsu) {
            this.itemName = new RString(itemName);
            this.printName = new RString(printName);
            this.checkShubetsu = checkShubetsu;
        }

        @Override
        public RString getItemName() {
            return this.itemName;
        }

        @Override
        public RString getPrintName() {
            return this.printName;
        }

        @Override
        public CheckShubetsu getCheckShubetsu() {
            return this.checkShubetsu;
        }
    }

    private KijunShunyugakuTekiyoKetteiTsuchiIchiran get基準収入額決定通知一覧表パラメータ() {
        KijunShunyugakuTekiyoKetteiTsuchiIchiran 基準収入額決定通知一覧表パラメータ = new KijunShunyugakuTekiyoKetteiTsuchiIchiran();
        基準収入額決定通知一覧表パラメータ.set市町村番号(parameter.get市町村コード());
        基準収入額決定通知一覧表パラメータ.set市町村名(parameter.get市町村名());
        基準収入額決定通知一覧表パラメータ.set氏名(new AtenaMeisho("該当データがありません"));
        for (int i = 出力順リスト.size() - 1; 0 <= i; i--) {
            if (出力順リスト.get(i) == null || 出力順リスト.get(i).isEmpty()) {
                出力順リスト.remove(i);
            }
        }
        for (int i = 改頁List.size() - 1; i >= 0; i--) {
            if (改頁List.get(i) == null || 改頁List.get(i).isEmpty()) {
                改頁List.remove(i);
            }
        }
        if (INT_0 < 出力順リスト.size()) {
            基準収入額決定通知一覧表パラメータ.set出力順１(出力順リスト.get(INT_0));
        }
        if (INT_1 < 出力順リスト.size()) {
            基準収入額決定通知一覧表パラメータ.set出力順２(出力順リスト.get(INT_1));
        }
        if (INT_2 < 出力順リスト.size()) {
            基準収入額決定通知一覧表パラメータ.set出力順３(出力順リスト.get(INT_2));
        }
        if (INT_3 < 出力順リスト.size()) {
            基準収入額決定通知一覧表パラメータ.set出力順４(出力順リスト.get(INT_3));
        }
        if (INT_4 < 出力順リスト.size()) {
            基準収入額決定通知一覧表パラメータ.set出力順５(出力順リスト.get(INT_4));
        }
        if (INT_0 < 改頁List.size()) {
            基準収入額決定通知一覧表パラメータ.set改頁１(改頁List.get(INT_0));
        }
        if (INT_1 < 改頁List.size()) {
            基準収入額決定通知一覧表パラメータ.set改頁２(改頁List.get(INT_1));
        }
        if (INT_2 < 改頁List.size()) {
            基準収入額決定通知一覧表パラメータ.set改頁３(改頁List.get(INT_2));
        }
        if (INT_3 < 改頁List.size()) {
            基準収入額決定通知一覧表パラメータ.set改頁４(改頁List.get(INT_3));
        }
        if (INT_4 < 改頁List.size()) {
            基準収入額決定通知一覧表パラメータ.set改頁５(改頁List.get(INT_4));
        }
        基準収入額決定通知一覧表パラメータ.set出力順情報(出力順);
        return 基準収入額決定通知一覧表パラメータ;
    }

    private KijunShunyugakuTekiyoKetteiTsuchiIchiran get基準収入額決定通知一覧表パラメータ2(KijunShunyugakuTekiyoKetteiEntity entity,
            boolean 改頁Flag, KijunShunyugakuTekiyoKetteiTsuchiIchiran 基準収入額決定通知一覧表パラメータ) {
        count++;
        if (改頁Flag || 一覧表_世帯コード == null || !一覧表_世帯コード.equals(entity.get世帯コード()) || count == INT_31) {
            一覧表_通番 = 一覧表_通番 + INT_1;
            基準収入額決定通知一覧表パラメータ.set通番(new RString(一覧表_通番));
            基準収入額決定通知一覧表パラメータ.set出力世帯コード(entity.get世帯コード());
        }
        if (改頁Flag || 一覧表_年度 == null || !一覧表_年度.equals(entity.get年度()) || count == INT_31) {
            基準収入額決定通知一覧表パラメータ.set年度(entity.get年度());
        }

        if (count == INT_31 || 改頁Flag) {
            count = INT_1;
        }

        基準収入額決定通知一覧表パラメータ.set被保険者番号(entity.get被保険者番号());
        UaFt200FindShikibetsuTaishoEntity 宛名 = entity.get宛名Entity();
        if (宛名 != null) {
            基準収入額決定通知一覧表パラメータ.set氏名(宛名.getKanjiShimei());
        }

        基準収入額決定通知一覧表パラメータ.set識別コード(entity.get識別コード());
        基準収入額決定通知一覧表パラメータ.set申請年月日(entity.get申請日());
        基準収入額決定通知一覧表パラメータ.set決定年月日(entity.get決定日());
        基準収入額決定通知一覧表パラメータ.set適用開始年月(entity.get適用開始年月());
        基準収入額決定通知一覧表パラメータ.set算定基準額(entity.get算定基準額());
        if (entity.get郵便番号() != null) {
            基準収入額決定通知一覧表パラメータ.set郵便番号(entity.get郵便番号().getColumnValue());
        }

        if (entity.get町域コード() != null) {
            基準収入額決定通知一覧表パラメータ.set町域コード(entity.get町域コード().getColumnValue());
        }

        if (entity.get行政区コード() != null) {
            基準収入額決定通知一覧表パラメータ.set行政区コード(entity.get行政区コード().getColumnValue());
        }

        基準収入額決定通知一覧表パラメータ.set世帯コード(entity.get世帯コード());
        if (entity.get市町村コード() != null) {
            基準収入額決定通知一覧表パラメータ.set市町村コード(entity.get市町村コード().getColumnValue());
        }
        return 基準収入額決定通知一覧表パラメータ;
    }

    private List<RString> get改頁List() {
        List<RString> 改頁ArrayList = new ArrayList<>();
        int i = 0;
        RString 改頁1 = RString.EMPTY;
        RString 改頁2 = RString.EMPTY;
        RString 改頁3 = RString.EMPTY;
        RString 改頁4 = RString.EMPTY;
        RString 改頁5 = RString.EMPTY;
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (i == INT_0 && item.is改頁項目()) {
                    改頁1 = item.get項目名();
                } else if (i == INT_1 && item.is改頁項目()) {
                    改頁2 = item.get項目名();
                } else if (i == INT_2 && item.is改頁項目()) {
                    改頁3 = item.get項目名();
                } else if (i == INT_3 && item.is改頁項目()) {
                    改頁4 = item.get項目名();
                } else if (i == INT_4 && item.is改頁項目()) {
                    改頁5 = item.get項目名();
                }
                i = i + 1;
            }
        }
        改頁ArrayList.add(改頁1);
        改頁ArrayList.add(改頁2);
        改頁ArrayList.add(改頁3);
        改頁ArrayList.add(改頁4);
        改頁ArrayList.add(改頁5);
        return 改頁ArrayList;
    }

    private List<RString> get出力順List() {
        List<RString> 出力順ArrayList = new ArrayList<>();
        int i = 0;
        RString 出力順1 = RString.EMPTY;
        RString 出力順2 = RString.EMPTY;
        RString 出力順3 = RString.EMPTY;
        RString 出力順4 = RString.EMPTY;
        RString 出力順5 = RString.EMPTY;
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (i == INT_0) {
                    出力順1 = item.get項目名();
                } else if (i == INT_1) {
                    出力順2 = item.get項目名();
                } else if (i == INT_2) {
                    出力順3 = item.get項目名();
                } else if (i == INT_3) {
                    出力順4 = item.get項目名();
                } else if (i == INT_4) {
                    出力順5 = item.get項目名();
                }
                i = i + 1;
            }
        }
        出力順ArrayList.add(出力順1);
        出力順ArrayList.add(出力順2);
        出力順ArrayList.add(出力順3);
        出力順ArrayList.add(出力順4);
        出力順ArrayList.add(出力順5);
        return 出力順ArrayList;
    }
}
