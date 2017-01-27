/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE525002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.kaigokekkataishouichiran.KaigoKekkaTaishouIchiranBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.kaigokekkataishouichiran.KaigoKekkaTaishouIchiranHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.kaigokekkataishouichiran.KaigoKekkaTaishouIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hanteikekkajohoshutsuryoku.HanteiKekkaJohoShutsuryokuMybitisParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hanteikekkajohoshutsuryoku.HanteiKekkaJohoShutsuryokuProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkajohoshutsuryoku.HanteiKekkaJohoShutsuryokuRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.KekkatsuchiTaishoshaIchiranReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 判定結果情報出力(保険者)_バッチ処理クラスです
 *
 * @reamsid_L DBE-0190-030 duanzhanli
 */
public class HanteiKekkaJohoShutsuryokuProcess extends BatchKeyBreakBase<HanteiKekkaJohoShutsuryokuRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hanteikekkajohoshutsuryoku."
            + "IHanteiKekkaJohoShutsuryokuMapper.get出力対象者明細一覧");
    private static final ReportId REPORT_ID = ReportIdDBE.DBE525005.getReportId();
    private static final RString 改ページ = new RString("shichosonName");
    private static final RString なし = new RString("なし");
    private static final RString 検索条件_進捗情報コード = new RString("0");
    private static final RString 検索条件_結果情報コード = new RString("1");
    private static final RString 検索条件_進捗情報 = new RString("進捗情報");
    private static final RString 検索条件_結果情報 = new RString("結果情報");
    private static final int 被保険者番号_改行個数 = 16;
    private List<RString> page_break_keys;
    private KaigoKekkaTaishouIchiranHeadItem headItem;
    private KaigoKekkaTaishouIchiranBodyItem bodyItem;
    private HanteiKekkaJohoShutsuryokuProcessParamter processPrm;
    private HanteiKekkaJohoShutsuryokuMybitisParamter mybatisPrm;
    private int index;
    private RString 導入団体コード;
    private RString 市町村名;
    @BatchWriter
    private BatchReportWriter<KekkatsuchiTaishoshaIchiranReportSource> batchWrite;
    private ReportSourceWriter<KekkatsuchiTaishoshaIchiranReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        mybatisPrm = processPrm.toHanteiKekkaJohoShutsuryokuMybitisParamter();
        page_break_keys = Collections.unmodifiableList(Arrays.asList(改ページ));
        index = 1;
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        導入団体コード = 導入団体クラス.getLasdecCode_().value();
        市町村名 = 導入団体クラス.get市町村名();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisPrm);
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value())
                .addBreak(new BreakerCatalog<KekkatsuchiTaishoshaIchiranReportSource>().simplePageBreaker(page_break_keys)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void usualProcess(HanteiKekkaJohoShutsuryokuRelateEntity entity) {
        bodyItem = setBodyItem(entity, index);

        headItem = KaigoKekkaTaishouIchiranHeadItem.creataKaigoKekkaTaishouIchiranHeadItem(
                entity.getShichosonMeisho(),
                processPrm.getChushutsuHoho(),
                processPrm.getChushutsuFromDate(),
                processPrm.getChushutsuToDate(),
                RDate.getNowDate().toDateString(),
                index);
        KaigoKekkaTaishouIchiranReport report = KaigoKekkaTaishouIchiranReport.createFrom(headItem, bodyItem);
        report.writeBy(reportSourceWriter);
        index = index + 1;
    }

    private KaigoKekkaTaishouIchiranBodyItem setBodyItem(HanteiKekkaJohoShutsuryokuRelateEntity entity, int index) {
        return new KaigoKekkaTaishouIchiranBodyItem(
                entity.getShinsakaiKaisaiNo(),
                entity.getShinsakaiKaisaiYMD(),
                entity.getNinteiShinseiYMD(),
                entity.getHihokenshaNo(),
                entity.getHihokenshaName(),
                entity.getHihokenshaKana(),
                entity.getSeinengappiYMD(),
                Seibetsu.toValue(entity.getSeibetsu()).get名称(),
                YokaigoJotaiKubun09.toValue(entity.getNijiHanteiKekka()).get名称(),
                index);
    }

    @Override
    protected void keyBreakProcess(HanteiKekkaJohoShutsuryokuRelateEntity current) {
        if (!getBefore().getShoKisaiHokenshaNo().value().equals(current.getShoKisaiHokenshaNo().value())) {
            index = 1;
        }
    }

    @Override
    protected void afterExecute() {
        帳票バッチ出力条件リストの出力();
    }

    private void 帳票バッチ出力条件リストの出力() {
        RStringBuilder ジョブ番号_Tmp = new RStringBuilder();
        ジョブ番号_Tmp.append(JobContextHolder.getJobId());
        RString ジョブ番号 = ジョブ番号_Tmp.toRString();
        RString 帳票名 = ReportIdDBE.DBE525005.getReportName();
        RString 出力ページ数 = new RString(reportSourceWriter.pageCount().value());
        RString csv出力有無 = なし;
        RString csvファイル名 = なし;
        List<RString> 出力条件 = get出力条件();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE525005.getReportId().value(), 導入団体コード, 市町村名, ジョブ番号,
                帳票名, 出力ページ数, csv出力有無, csvファイル名, 出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
        printer.print();
    }

    private List<RString> get出力条件() {
        RStringBuilder jokenBuilder;
        List<RString> 出力条件List = new ArrayList<>();
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("ファイル区分："));
        if (processPrm.getFayirukuben().equals(検索条件_進捗情報コード)) {
            jokenBuilder.append(検索条件_進捗情報);
        } else if (processPrm.getFayirukuben().equals(検索条件_結果情報コード)) {
            jokenBuilder.append(検索条件_結果情報);
        }
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("保険者："));
        jokenBuilder.append(processPrm.getHokensha());
        jokenBuilder.append(new RString(" "));
        jokenBuilder.append(processPrm.getHokenshaName());
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("抽出方法："));
        jokenBuilder.append(processPrm.getChushutsuHoho());
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("抽出期間："));
        jokenBuilder.append(dateFormat(processPrm.getChushutsuFromDate()));
        jokenBuilder.append(new RString("　～　"));
        jokenBuilder.append(dateFormat(processPrm.getChushutsuToDate()));
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("被保険者番号："));
        jokenBuilder.append(processPrm.getHihokenshaNo());
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("データ出力有無："));
        jokenBuilder.append(processPrm.getDataShutsuryokuUmu());
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("【被保険者番号リスト】"));
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        int count = 0;
        for (RString hihokenshaNo : processPrm.getShinseishoKanriNoList()) {
            jokenBuilder.append(hihokenshaNo);
            jokenBuilder.append(new RString(","));
            count++;
            if (被保険者番号_改行個数 == count) {
                出力条件List.add(jokenBuilder.toRString());
                jokenBuilder = new RStringBuilder();
                count = 0;
            }
        }
        jokenBuilder.delete(jokenBuilder.length() - 1, jokenBuilder.length());
        出力条件List.add(jokenBuilder.toRString());
        return 出力条件List;
    }
    
    private RString dateFormat(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        RDate date_tem = new RDate(date.toString());
        return date_tem.wareki().toDateString();
    }
}
