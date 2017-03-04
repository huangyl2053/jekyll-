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
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosayoteimitei.NinteichosaYoteiMiteiReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosayoteimitei.NinteichosaYoteiMiteiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosayoteimitei.NinteichosaYoteiMiteiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosayoteimitei.NinteichosaYoteiMiteiReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.DbAccessLogger;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
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
 * 認定調査予定未定者一覧表情報の取得バッチクラスです。
 *
 * @reamsid_L DBE-1390-080 dongyabin
 */
public class NinteichosaYoteiMiteiProcess extends BatchProcessBase<NinteichosaYoteiMiteiRelateEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosayoteimitei."
                    + "INinteichosaYoteiMiteiMapper.getNinteichosaScheduleInput");
    private static final ReportId REPORT_ID = ReportIdDBE.DBE012001.getReportId();
    private static final List<RString> PAGE_BREAK_KEYS = Collections
            .unmodifiableList(Arrays.asList(new RString(NinteichosaYoteiMiteiReportSource.ReportSourceFields.shichosonName.name())));
    private static final RString MIDDLELINE = RString.EMPTY;
    private static final RString なし = new RString("無し");
    private NinteichosaYoteiMiteiProcessParamter paramter;
    @BatchWriter
    private BatchReportWriter<NinteichosaYoteiMiteiReportSource> batchWrite;
    private ReportSourceWriter<NinteichosaYoteiMiteiReportSource> reportSourceWriter;
    private int index_tmp = 0;
    private RString 導入団体コード;
    private RString 市町村名;
    private static final RString 全市町村 = new RString("全市町村");
    private static final RString 保険者タイトル = new RString("保険者：");
    private DbAccessLogger accessLog;

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
                .addBreak(new BreakerCatalog<NinteichosaYoteiMiteiReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void afterExecute() {
        if (index_tmp == 0) {
            NinteichosaYoteiMiteiRelateEntity entity = new NinteichosaYoteiMiteiRelateEntity();
            entity.setDbT5101_hihokenshaName(new AtenaMeisho("該当データがありません"));
            NinteichosaYoteiMiteiReport report = new NinteichosaYoteiMiteiReport(entity, -1);
            report.writeBy(reportSourceWriter);
        }
        バッチ出力条件リストの出力();
        accessLog.flushBy(AccessLogType.照会);
    }

    @Override
    protected void process(NinteichosaYoteiMiteiRelateEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                entity.getDbT5101_shinseishoKanriNo().value());
        accessLog.store(new ShoKisaiHokenshaNo(entity.getDbT5101_shoKisaiHokenshaNo()), entity.getDbT5101_hihokenshaNo(), expandedInfo);
        NinteichosaYoteiMiteiReport report = new NinteichosaYoteiMiteiReport(entity, index_tmp);
        report.writeBy(reportSourceWriter);
        index_tmp++;
    }

    private void バッチ出力条件リストの出力() {
        RStringBuilder ジョブ番号_Tmp = new RStringBuilder();
        ジョブ番号_Tmp.append(JobContextHolder.getJobId());
        RString ジョブ番号 = ジョブ番号_Tmp.toRString();
        RString 帳票名 = ReportIdDBE.DBE012001.getReportName();
        RString 出力ページ数 = new RString(reportSourceWriter.pageCount().value());
        RString csv出力有無 = なし;
        RString csvファイル名 = MIDDLELINE;
        List<RString> 出力条件 = get出力条件();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE012001.getReportId().value(), 導入団体コード, 市町村名, ジョブ番号,
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
        if (paramter.get市町村コード().equals(LasdecCode.EMPTY)) {
            出力条件.add(get保険者(全市町村));
        } else {
            出力条件.add(get保険者(paramter.get市町村名()));
        }
        if (new RString("1").equals(paramter.get認定調査予定未定者一覧作成条件())) {
            出力条件.add(作成条件.concat("全件出力"));
        } else if (new RString("2").equals(paramter.get認定調査予定未定者一覧作成条件())) {
            出力条件.add(作成条件.concat("申請日の範囲を指定"));
            if (paramter.get認定調査予定未定者一覧申請日From() == null && paramter.get認定調査予定未定者一覧申請日To() == null) {
                出力条件.add(日付範囲.concat("指定なし"));
            } else {
                RString 申請日FROM = dateFormat(paramter.get認定調査予定未定者一覧申請日From());
                RString 申請日TO = dateFormat(paramter.get認定調査予定未定者一覧申請日To());
                出力条件.add(日付範囲.concat(申請日FROM).concat(new RString("～")).concat(申請日TO));
            }
        }
        return 出力条件;
    }

    private RString get保険者(RString 保険者) {
        return 保険者タイトル.concat(保険者);
    }
}
