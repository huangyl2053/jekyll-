/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601005;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahoshushokai.NinteiChosaHoshuShokaiChange;
import jp.co.ndensan.reams.db.dbe.business.report.chosahoshuichiran.ChosahoshuichiranReport;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601005.NinteiChosaHoshuShokaiProcessParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahoshushokai.NinteiChosaHoshuShokaiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshuichiran.ChosahoshuichiranReportSource;
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
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定調査報酬照会csvの作成クラスです。
 *
 * @reamsid_L DBE-1940-020 jinjue
 *
 */
public class NinteichosaHoshuProcess extends BatchProcessBase<NinteiChosaHoshuShokaiRelateEntity> {

    private NinteiChosaHoshuShokaiProcessParameter parameter;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosahoshushokai."
            + "INinteiChosaHoshuShokaiRelateMapper.get報酬実績データ情報");
    private static final ReportId REPORT_ID = ReportIdDBE.DBE601006.getReportId();
    private static final RString なし = new RString("なし");
    private RString 導入団体コード;
    private RString 市町村名;
    private int count = 0;
    private RString ninteichosaItakusakiCode = RString.EMPTY;
    private static final List<RString> PAGE_BREAK_KEYS = Collections
            .unmodifiableList(Arrays.asList(new RString(ChosahoshuichiranReportSource.ReportSourceFields.chosaItakusakiNo.name())));
    @BatchWriter
    private BatchReportWriter<ChosahoshuichiranReportSource> batchWrite;
    private ReportSourceWriter<ChosahoshuichiranReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
    }

    @Override
    protected void process(NinteiChosaHoshuShokaiRelateEntity relateEntity) {

        if (!ninteichosaItakusakiCode.equals(relateEntity.get認定調査委託先コード())) {
            count = 1;
        } else {
            count = count + 1;
        }
        ninteichosaItakusakiCode = relateEntity.get認定調査委託先コード();
        ChosahoshuichiranReport report = new ChosahoshuichiranReport(NinteiChosaHoshuShokaiChange.createShokaiData(relateEntity,
                parameter, count, reportSourceWriter.pageCount().value()));
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value())
                .addBreak(new BreakerCatalog<ChosahoshuichiranReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    private void 帳票バッチ出力条件リストの出力() {
        RStringBuilder ジョブ番号_Tmp = new RStringBuilder();
        ジョブ番号_Tmp.append(JobContextHolder.getJobId());
        RString ジョブ番号 = ジョブ番号_Tmp.toRString();
        RString 帳票名 = ReportIdDBE.DBE601006.getReportName();
        RString 出力ページ数 = new RString(reportSourceWriter.pageCount().value());
        RString csv出力有無 = なし;
        RString csvファイル名 = なし;
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 調査依頼日FROM = new RStringBuilder("【調査依頼日（From）】");
        調査依頼日FROM.append(toWareki(parameter.get調査依頼日開始()));
        RStringBuilder 調査依頼日To = new RStringBuilder("【調査依頼日（To）】");
        調査依頼日To.append(toWareki(parameter.get調査依頼日終了()));
        RStringBuilder 保険者_SB = new RStringBuilder(new RString("【保険者】"));
        保険者_SB.append(parameter.get保険者());
        出力条件.add(調査依頼日FROM.toRString());
        出力条件.add(調査依頼日To.toRString());
        出力条件.add(保険者_SB.toRString());
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE601006.getReportId().value(), 導入団体コード, 市町村名, ジョブ番号,
                帳票名, 出力ページ数, csv出力有無, csvファイル名, 出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
        printer.print();
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        導入団体コード = 導入団体クラス.getLasdecCode_().value();
        市町村名 = 導入団体クラス.get市町村名();
    }

    @Override
    protected void afterExecute() {
        帳票バッチ出力条件リストの出力();
    }

    private RString toWareki(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        return new FlexibleDate(date).wareki().toDateString();
    }
}
