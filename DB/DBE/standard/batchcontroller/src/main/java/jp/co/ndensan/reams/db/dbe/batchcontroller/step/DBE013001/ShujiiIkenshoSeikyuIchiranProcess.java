/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE013001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshojohoprint.IkenshoJohoPrintBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoseikyuichiran.ShujiiIkenshoSeikyuIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ikenshojohoprint.IkenshoJohoPrintProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshojohoprint.IkenshoJohoPrintRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshoseikyuichiran.ShujiiIkenshoSeikyuIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoseikyuichiran.ShujiiIkenshoSeikyuIchiranReportSource;
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
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書作成料請求一覧表のプロセス処理の帳票出力のプロセスクラスです。
 *
 * @reamsid_L DBE-1390-090 lijia
 */
public class ShujiiIkenshoSeikyuIchiranProcess extends BatchProcessBase<IkenshoJohoPrintRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikenshojohoprint.IIkenshoJohoPrintMapper.get主治医意見書作成料請求情報");
    private static final ReportId REPORT_ID = ReportIdDBE.DBE013006.getReportId();
    private static final List<RString> PAGE_BREAK_KEYS = Collections
            .unmodifiableList(Arrays.asList(new RString(ShujiiIkenshoSeikyuIchiranReportSource.ReportSourceFields.shichosonName.name())));
    private static final RString MIDDLELINE = RString.EMPTY;
    private static final RString なし = new RString("無し");
    private static final RString 処理日 = new RString("1");
    private static final RString 受領日 = new RString("2");
    private IkenshoJohoPrintProcessParameter processParameter;
    private final IkenshoJohoPrintBusiness business = new IkenshoJohoPrintBusiness();

    @BatchWriter
    private BatchReportWriter<ShujiiIkenshoSeikyuIchiranReportSource> batchWrite;
    private ReportSourceWriter<ShujiiIkenshoSeikyuIchiranReportSource> reportSourceWriter;
    private int index_tmp = 0;
    private RString 導入団体コード;
    private RString 市町村名;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        導入団体コード = 導入団体クラス.getLasdecCode_().value();
        市町村名 = 導入団体クラス.get市町村名();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toSinsakaiHanteiJyokyoMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value())
                .addBreak(new BreakerCatalog<ShujiiIkenshoSeikyuIchiranReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void process(IkenshoJohoPrintRelateEntity relateEntity) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(relateEntity));
        ShujiiIkenshoSeikyuIchiranEntity entity = business.toShujiiIkenshoSeikyuIchiranEntity(relateEntity);
        ShujiiIkenshoSeikyuIchiranReport report = new ShujiiIkenshoSeikyuIchiranReport(entity, index_tmp);
        report.writeBy(reportSourceWriter);
        index_tmp++;
    }

    @Override
    protected void afterExecute() {
        if (index_tmp == 0) {
            ShujiiIkenshoSeikyuIchiranEntity entity = new ShujiiIkenshoSeikyuIchiranEntity();
            entity.set氏名(new RString("該当データがありません"));
            ShujiiIkenshoSeikyuIchiranReport report = new ShujiiIkenshoSeikyuIchiranReport(entity, -1);
            report.writeBy(reportSourceWriter);
        }
        バッチ出力条件リストの出力();
    }

    private PersonalData toPersonalData(IkenshoJohoPrintRelateEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0001")), new RString("申請書管理番号"),
                entity.getShinseishoKanriNo().value());
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    private void バッチ出力条件リストの出力() {
        RStringBuilder ジョブ番号_Tmp = new RStringBuilder();
        ジョブ番号_Tmp.append(JobContextHolder.getJobId());
        RString ジョブ番号 = ジョブ番号_Tmp.toRString();
        RString 帳票名 = ReportIdDBE.DBE013006.getReportName();
        RString 出力ページ数 = new RString(reportSourceWriter.pageCount().value());
        RString csv出力有無 = なし;
        RString csvファイル名 = MIDDLELINE;
        List<RString> 出力条件 = new ArrayList<>();
        if (処理日.equals(processParameter.get主治医意見書作成料請求一覧表作成条件())) {
            出力条件.add(new RString("処理日の範囲を指定"));
            if (processParameter.get主治医意見書作成料請求一覧表処理日From() == null && processParameter.get主治医意見書作成料請求一覧表処理日To() == null) {
                出力条件.add(new RString("指定なし"));
            } else {
                RString 処理日FROM = dateFormat(processParameter.get主治医意見書作成料請求一覧表処理日From());
                RString 処理日TO = dateFormat(processParameter.get主治医意見書作成料請求一覧表処理日To());
                出力条件.add(処理日FROM.concat(new RString("～")).concat(処理日TO));
            }
        } else if (受領日.equals(processParameter.get主治医意見書作成料請求一覧表作成条件())) {
            出力条件.add(new RString("受領日の範囲を指定"));
            if (processParameter.get主治医意見書作成料請求一覧表受領日From() == null && processParameter.get主治医意見書作成料請求一覧表受領日To() == null) {
                出力条件.add(new RString("指定なし"));
            } else {
                RString 受領日FROM = dateFormat(processParameter.get主治医意見書作成料請求一覧表受領日From());
                RString 受領日TO = dateFormat(processParameter.get主治医意見書作成料請求一覧表受領日To());
                出力条件.add(受領日FROM.concat(new RString("～")).concat(受領日TO));
            }

        }

        出力条件.add(set主治医意見書依頼未処理者一覧表作成条件(processParameter.get主治医意見書作成料請求一覧表作成条件()));
        出力条件.add(dateFormat(processParameter.get主治医意見書作成料請求一覧表処理日From()));
        出力条件.add(dateFormat(processParameter.get主治医意見書作成料請求一覧表処理日To()));
        出力条件.add(dateFormat(processParameter.get主治医意見書作成料請求一覧表受領日From()));
        出力条件.add(dateFormat(processParameter.get主治医意見書作成料請求一覧表受領日To()));
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE013006.getReportId().value(), 導入団体コード, 市町村名, ジョブ番号,
                帳票名, 出力ページ数, csv出力有無, csvファイル名, 出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
        printer.print();
    }

    private RString dateFormat(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().toDateString();
    }

    private RString set主治医意見書依頼未処理者一覧表作成条件(RString 作成条件) {
        RString 一覧作成条件 = RString.EMPTY;
        if (処理日.equals(作成条件)) {
            一覧作成条件 = new RString("処理日");
        } else if (受領日.equals(作成条件)) {
            一覧作成条件 = new RString("受領日");
        }
        return 一覧作成条件;
    }
}
