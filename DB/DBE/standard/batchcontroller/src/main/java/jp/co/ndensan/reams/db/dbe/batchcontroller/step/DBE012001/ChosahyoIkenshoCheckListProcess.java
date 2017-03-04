/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE012001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosahyoikenshochecklist.ChosahyoIkenshoCheckListData;
import jp.co.ndensan.reams.db.dbe.business.report.chosahyoikenshochecklist.ChosahyoIkenshoCheckListReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosayoteimitei.ChosahyoIkenshoCheckListProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyoikenshochecklist.ChosahyoIkenshoCheckListRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyoikenshochecklist.ChosahyoIkenshoCheckListReportEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyoikenshochecklist.ChosahyoIkenshoCheckListReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosairaihenko.NinteichosaIraiHenkoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.DbAccessLogger;
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
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 認定調査結果と主治医意見書のチェックリスト情報の取得バッチクラスです。
 *
 * @reamsid_L DBE-1390-080 dongyabin
 */
public class ChosahyoIkenshoCheckListProcess extends BatchKeyBreakBase<ChosahyoIkenshoCheckListRelateEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosayoteimitei."
                    + "INinteichosaYoteiMiteiMapper.getChosahyoIkenshoCheckList");
    private static final List<RString> PAGE_BREAK_KEYS = Collections
            .unmodifiableList(Arrays.asList(new RString(ChosahyoIkenshoCheckListReportSource.ReportSourceFields.hihokenshaNo.name())));
    private static final ReportId REPORT_ID = ReportIdDBE.DBE012003.getReportId();
    private static final RString MIDDLELINE = RString.EMPTY;
    private static final RString なし = new RString("無し");
    private ChosahyoIkenshoCheckListProcessParamter paramter;
    private DbAccessLogger accessLog;
    @BatchWriter
    private BatchReportWriter<ChosahyoIkenshoCheckListReportSource> batchWrite;
    private ReportSourceWriter<ChosahyoIkenshoCheckListReportSource> reportSourceWriter;
    private int index_tmp = 0;
    private RString 導入団体コード;
    private RString 市町村名;
    private ChosahyoIkenshoCheckListReportEntity reportData = new ChosahyoIkenshoCheckListReportEntity();
    private static final RString 全市町村 = new RString("全市町村");
    private static final RString 保険者タイトル = new RString("保険者：");

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        導入団体コード = 導入団体クラス.getLasdecCode_().value();
        市町村名 = 導入団体クラス.get市町村名();
        accessLog = new DbAccessLogger();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value())
                .addBreak(new BreakerCatalog<NinteichosaIraiHenkoReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void afterExecute() {
        if (index_tmp == 0) {
            ChosahyoIkenshoCheckListRelateEntity entity = new ChosahyoIkenshoCheckListRelateEntity();
            entity.setDbT5101_hihokenshaName(new AtenaMeisho("該当データがありません"));
            ChosahyoIkenshoCheckListData data = new ChosahyoIkenshoCheckListData(entity);
            reportData = data.get帳票データ(reportData);
            ChosahyoIkenshoCheckListReport report = new ChosahyoIkenshoCheckListReport(reportData);
            report.writeBy(reportSourceWriter);
        }
        if (!RString.isNullOrEmpty(reportData.getHihokenshaNo())) {
            ChosahyoIkenshoCheckListReport report = new ChosahyoIkenshoCheckListReport(reportData);
            report.writeBy(reportSourceWriter);
        }
        バッチ出力条件リストの出力();
        accessLog.flushBy(AccessLogType.照会);
    }

    @Override
    protected void usualProcess(ChosahyoIkenshoCheckListRelateEntity entity) {
        if (getBefore() != null && !hasBrek(getBefore(), entity)) {
            ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                    entity.getDbT5101_shinseishoKanriNo().value());
            accessLog.store(new ShoKisaiHokenshaNo(entity.getDbT5101_shoKisaiHokenshaNo()), entity.getDbT5101_hihokenshaNo(), expandedInfo);
            index_tmp++;
            ChosahyoIkenshoCheckListData data = new ChosahyoIkenshoCheckListData(entity);
            reportData = data.get帳票データ(reportData);
        }
    }

    @Override
    protected void keyBreakProcess(ChosahyoIkenshoCheckListRelateEntity current) {
        if (hasBrek(getBefore(), current)) {
            ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                    current.getDbT5101_shinseishoKanriNo().value());
            accessLog.store(new ShoKisaiHokenshaNo(current.getDbT5101_shoKisaiHokenshaNo()), current.getDbT5101_hihokenshaNo(), expandedInfo);
            ChosahyoIkenshoCheckListReport report = new ChosahyoIkenshoCheckListReport(reportData);
            report.writeBy(reportSourceWriter);
            ChosahyoIkenshoCheckListData data = new ChosahyoIkenshoCheckListData(current);
            reportData = new ChosahyoIkenshoCheckListReportEntity();
            reportData = data.get帳票データ(reportData);
            index_tmp++;
        }
    }

    private boolean hasBrek(ChosahyoIkenshoCheckListRelateEntity before, ChosahyoIkenshoCheckListRelateEntity current) {
        return !before.getDbT5101_shinseishoKanriNo().equals(current.getDbT5101_shinseishoKanriNo());
    }

    private void バッチ出力条件リストの出力() {
        RStringBuilder ジョブ番号_Tmp = new RStringBuilder();
        ジョブ番号_Tmp.append(JobContextHolder.getJobId());
        RString ジョブ番号 = ジョブ番号_Tmp.toRString();
        RString 帳票名 = ReportIdDBE.DBE012003.getReportName();
        RString 出力ページ数 = new RString(reportSourceWriter.pageCount().value());
        RString csv出力有無 = なし;
        RString csvファイル名 = MIDDLELINE;
        List<RString> 出力条件 = get出力条件();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE012003.getReportId().value(), 導入団体コード, 市町村名, ジョブ番号,
                帳票名, 出力ページ数, csv出力有無, csvファイル名, 出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
        printer.print();
    }

    private RString dateFormat(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        RDate dateTmp = new RDate(date.toString());
        return dateTmp.wareki().toDateString();
    }

    private List<RString> get出力条件() {
        List<RString> 出力条件 = new ArrayList<>();
        RString 作成条件 = new RString("作成条件：");
        RString 日付範囲 = new RString("日付範囲：");
        RString 審査日 = new RString("審査日：");
        RString 開催番号 = new RString("開催番号：");
        if (paramter.get市町村コード().equals(LasdecCode.EMPTY)) {
            出力条件.add(get保険者(全市町村));
        } else {
            出力条件.add(get保険者(paramter.get市町村名()));
        }
        if (new RString("1").equals(paramter.get作成条件())) {
            出力条件.add(作成条件.concat("未割当"));
        } else if (new RString("2").equals(paramter.get作成条件())) {
            出力条件.add(作成条件.concat("申請日の範囲を指定"));
            if (paramter.get認定調査結果と主治医意見書のチェックリスト申請日From() == null && paramter.get認定調査結果と主治医意見書のチェックリスト申請日To() == null) {
                出力条件.add(日付範囲.concat("指定なし"));

            } else {
                RString 申請日FROM = dateFormat(paramter.get認定調査結果と主治医意見書のチェックリスト申請日From());
                RString 申請日TO = dateFormat(paramter.get認定調査結果と主治医意見書のチェックリスト申請日To());
                出力条件.add(日付範囲.concat(申請日FROM).concat(new RString("～")).concat(申請日TO));
            }

        } else if (new RString("3").equals(paramter.get作成条件())) {
            出力条件.add(作成条件.concat("審査日を指定"));
            出力条件.add(審査日.concat(dateFormat(paramter.get認定調査結果と主治医意見書のチェックリスト審査日())));
        } else if (new RString("4").equals(paramter.get作成条件())) {
            出力条件.add(作成条件.concat("審査会の開催番号を指定"));
            出力条件.add(開催番号.concat(paramter.get認定調査結果と主治医意見書のチェックリスト審査会()));
        }
        return 出力条件;
    }

    private RString get保険者(RString 保険者) {
        return 保険者タイトル.concat(保険者);
    }
}
