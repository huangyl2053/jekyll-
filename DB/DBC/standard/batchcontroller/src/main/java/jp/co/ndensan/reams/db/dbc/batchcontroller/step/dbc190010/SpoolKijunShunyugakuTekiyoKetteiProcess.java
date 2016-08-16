/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc190010;

import java.util.ArrayList;
import java.util.List;
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
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
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
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibun;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 基準収入額決定通知書発行processクラスです。
 *
 * @reamsid_L DBC-4610-030 xuhao
 */
public class SpoolKijunShunyugakuTekiyoKetteiProcess extends BatchKeyBreakBase<KijunShunyugakuTekiyoKetteiEntity> {

    private SpoolKijunShunyugakuTekiyoKetteiProcessParameter parameter;
    private IOutputOrder 並び順;
    private List<RString> 改頁項目リスト;
    private List<RString> 出力順リスト;
    private List<RString> 改頁List;
    private TsuchishoTeikeibunFinder finder;
    List<TsuchishoTeikeibun> teikeibunList;
    private ITextHenkanRule rule;
    private List<KijunShunyugakuTekiyoKetteiEntity> 基準収入額適用管理List;
    private KijunShunyugakuTekiyoKanriManager 基準収入額適用管理manager;
    private int 通番;
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
    private static final int 文字切れ対象文字列長 = 40;

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunshunyugakutekiyokettei."
            + "IKijunShunyugakuTekiyoKetteiMapper.select基準収入額適用管理");

    @BatchWriter
    private IBatchReportWriterWithCheckList<KijunShunyugakuTekiyoKetteiTsuchishoSource> batchReportWriter_通知書_文字切れ;
    private ReportSourceWriter<KijunShunyugakuTekiyoKetteiTsuchishoSource> reportSourceWriter_通知書_文字切れ;
    private BatchReportWriter<KijunShunyugakuTekiyoKetteiTsuchishoSource> batchReportWriter_通知書;
    private ReportSourceWriter<KijunShunyugakuTekiyoKetteiTsuchishoSource> reportSourceWriter_通知書;
    private BatchReportWriter<KijunShunyugakuTekiyoKetteiTsuchiIchiranSource> batchReportWriter_一覧表;
    private ReportSourceWriter<KijunShunyugakuTekiyoKetteiTsuchiIchiranSource> reportSourceWriter_一覧表;

    @Override
    protected void initialize() {
        super.initialize();
        通番 = INT_1;
        改頁項目リスト = new ArrayList<>();
        出力順リスト = new ArrayList<>();
        finder = new TsuchishoTeikeibunFinder();
        teikeibunList = finder.get通知書定型文パターン(SubGyomuCode.DBC介護給付, 帳票ID_通知書);
        rule = KaigoTextHenkanRuleCreator.createRule(SubGyomuCode.DBC介護給付, 帳票ID_通知書);
        基準収入額適用管理List = new ArrayList<>();
        基準収入額適用管理manager = new KijunShunyugakuTekiyoKanriManager();
        並び順 = get並び順(帳票ID_通知書, parameter.get帳票出力順ID());
    }

    @Override
    protected void beforeExecute() {
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
            基準収入額適用管理の取得Parameter.setTemp_出力順(MyBatisOrderByClauseCreator.create(
                    KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder.class, 並び順).replace(ORDER_BY, RString.EMPTY));
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
        batchReportWriter_通知書 = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC100074.getReportId().value(), SubGyomuCode.DBC介護給付).create();
        reportSourceWriter_通知書 = new ReportSourceWriter<>(batchReportWriter_通知書);
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
        if (改頁Flag) {
            通番 = INT_1;
        }
        KijunShunyugakuTekiyoKetteiTsuchiIchiran 基準収入額決定通知一覧表パラメータ = get基準収入額決定通知一覧表パラメータ(entity);
        KijunShunyugakuTekiyoKetteiTsuchiIchiranReport 一覧表report
                = new KijunShunyugakuTekiyoKetteiTsuchiIchiranReport(基準収入額決定通知一覧表パラメータ);
        一覧表report.writeBy(reportSourceWriter_一覧表);
        if (getBefore() == null || getBefore().get世帯コード().equals(entity.get世帯コード())) {
            基準収入額適用管理List.add(entity);
        } else {
            KijunShunyugakuTekiyoKetteiTsuchisho 基準収入額適用決定通知書Parameter = get基準収入額適用決定通知書パラメータ();
            KijunShunyugakuTekiyoKetteiTsuchishoReport 通知書report = new KijunShunyugakuTekiyoKetteiTsuchishoReport(基準収入額適用決定通知書Parameter);
            if (基準収入額適用決定通知書Parameter.isFlag()) {
                通知書report.writeBy(reportSourceWriter_通知書_文字切れ);
            } else {
                通知書report.writeBy(reportSourceWriter_通知書);
            }
            基準収入額適用管理List = new ArrayList<>();
            基準収入額適用管理List.add(entity);
        }
        基準収入額適用管理manager.update決定通知書発行日(entity.get世帯コード(), entity.get年度(),
                entity.get履歴番号(), entity.get被保険者番号(), parameter.get作成日());
        通番 = 通番 + INT_1;
    }

    @Override
    protected void afterExecute() {
        KijunShunyugakuTekiyoKetteiTsuchisho 基準収入額適用決定通知書Parameter = get基準収入額適用決定通知書パラメータ();
        KijunShunyugakuTekiyoKetteiTsuchishoReport 通知書report = new KijunShunyugakuTekiyoKetteiTsuchishoReport(基準収入額適用決定通知書Parameter);
        if (基準収入額適用決定通知書Parameter.isFlag()) {
            通知書report.writeBy(reportSourceWriter_通知書_文字切れ);
        } else {
            通知書report.writeBy(reportSourceWriter_通知書);
        }
        ShoriDateKanriManager 処理日付管理マスタmanager = new ShoriDateKanriManager();
        処理日付管理マスタmanager.update対象開始日時AND対象終了日時(SubGyomuCode.DBC介護給付, parameter.get市町村コード(), タイトル,
                parameter.get抽出期間(), parameter.get開始日(), parameter.get終了日());
        batchReportWriter_一覧表.close();
        batchReportWriter_通知書.close();
    }

    private IOutputOrder get並び順(ReportId 帳票分類ID, RString 出力順ID) {

        if (RString.isNullOrEmpty(出力順ID)) {
            return null;
        }
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBC介護給付, 帳票分類ID, Long.parseLong(出力順ID.toString()));
        return outputOrder;
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
        if (基準収入額適用決定通知書Parameter.isFlag()) {
            NinshoshaSource compNinshoshaソース = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 帳票ID_通知書,
                    parameter.get作成日(), NinshoshaDenshikoinshubetsuCode.保険者印, reportSourceWriter_通知書_文字切れ);
            基準収入額適用決定通知書Parameter.setCompNinshoshaソース(compNinshoshaソース);
        } else {
            NinshoshaSource compNinshoshaソース = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 帳票ID_通知書,
                    parameter.get作成日(), NinshoshaDenshikoinshubetsuCode.保険者印, reportSourceWriter_通知書);
            基準収入額適用決定通知書Parameter.setCompNinshoshaソース(compNinshoshaソース);
        }
        set通知文(基準収入額適用決定通知書Parameter);
        return 基準収入額適用決定通知書Parameter;
    }

    private void set通知文(KijunShunyugakuTekiyoKetteiTsuchisho 基準収入額適用決定通知書Parameter) {
        for (TsuchishoTeikeibun teikeibun : teikeibunList) {
            set通知文１(teikeibun, 基準収入額適用決定通知書Parameter, rule);
            set通知文２(teikeibun, 基準収入額適用決定通知書Parameter, rule);
            set通知文３_大(teikeibun, 基準収入額適用決定通知書Parameter, rule);
            if (teikeibun.getパターン番号() == INT_3 && teikeibun.get項目番号() == INT_2 && teikeibun.get文章() != null) {
                基準収入額適用決定通知書Parameter.set通知文4_上小(rule.editText(teikeibun.get文章()));
            }
            if (teikeibun.getパターン番号() == INT_3 && teikeibun.get項目番号() == INT_3 && teikeibun.get文章() != null) {
                基準収入額適用決定通知書Parameter.set通知文5_下大(rule.editText(teikeibun.get文章()));
            }
            if (teikeibun.getパターン番号() == INT_4 && teikeibun.get項目番号() == INT_2 && teikeibun.get文章() != null) {
                基準収入額適用決定通知書Parameter.set通知文6_上大(rule.editText(teikeibun.get文章()));
            }
            if (teikeibun.getパターン番号() == INT_4 && teikeibun.get項目番号() == INT_3 && teikeibun.get文章() != null) {
                基準収入額適用決定通知書Parameter.set通知文7_下小(rule.editText(teikeibun.get文章()));
            }
        }
    }

    private void set通知文３_大(TsuchishoTeikeibun teikeibun, KijunShunyugakuTekiyoKetteiTsuchisho 基準収入額適用決定通知書Parameter,
            ITextHenkanRule rule) {
        if (teikeibun.getパターン番号() == INT_2 && teikeibun.get項目番号() == INT_2 && teikeibun.get文章() != null) {
            基準収入額適用決定通知書Parameter.set通知文３_大(rule.editText(teikeibun.get文章()));
        }
    }

    private void set通知文２(TsuchishoTeikeibun teikeibun, KijunShunyugakuTekiyoKetteiTsuchisho 基準収入額適用決定通知書Parameter,
            ITextHenkanRule rule) {
        if (teikeibun.getパターン番号() == INT_1 && teikeibun.get項目番号() == INT_2 && teikeibun.get文章() != null) {
            基準収入額適用決定通知書Parameter.set通知文２(rule.editText(teikeibun.get文章()));
        }
    }

    private void set通知文１(TsuchishoTeikeibun teikeibun, KijunShunyugakuTekiyoKetteiTsuchisho 基準収入額適用決定通知書Parameter,
            ITextHenkanRule rule) {
        if (teikeibun.getパターン番号() == INT_1 && teikeibun.get項目番号() == INT_1 && teikeibun.get文章() != null) {
            基準収入額適用決定通知書Parameter.set通知文１(rule.editText(teikeibun.get文章()));
        }
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

    private KijunShunyugakuTekiyoKetteiTsuchiIchiran get基準収入額決定通知一覧表パラメータ(KijunShunyugakuTekiyoKetteiEntity entity) {
        KijunShunyugakuTekiyoKetteiTsuchiIchiran 基準収入額決定通知一覧表パラメータ = new KijunShunyugakuTekiyoKetteiTsuchiIchiran();
        基準収入額決定通知一覧表パラメータ.set市町村番号(parameter.get市町村コード());
        基準収入額決定通知一覧表パラメータ.set市町村名(parameter.get市町村名());
        基準収入額決定通知一覧表パラメータ.set出力順１(出力順リスト.get(INT_0));
        基準収入額決定通知一覧表パラメータ.set出力順２(出力順リスト.get(INT_1));
        基準収入額決定通知一覧表パラメータ.set出力順３(出力順リスト.get(INT_2));
        基準収入額決定通知一覧表パラメータ.set出力順４(出力順リスト.get(INT_3));
        基準収入額決定通知一覧表パラメータ.set出力順５(出力順リスト.get(INT_4));
        基準収入額決定通知一覧表パラメータ.set改頁１(改頁List.get(INT_0));
        基準収入額決定通知一覧表パラメータ.set改頁２(改頁List.get(INT_1));
        基準収入額決定通知一覧表パラメータ.set改頁３(改頁List.get(INT_2));
        基準収入額決定通知一覧表パラメータ.set改頁４(改頁List.get(INT_3));
        基準収入額決定通知一覧表パラメータ.set改頁５(改頁List.get(INT_4));
        基準収入額決定通知一覧表パラメータ.set通番(通番);
        基準収入額決定通知一覧表パラメータ.set世帯コード(entity.get世帯コード());
        基準収入額決定通知一覧表パラメータ.set年度(entity.get年度());
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
