/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001;

import jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko.NinteiChosaBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.chosairairirekiichiran.ChosairairirekiIchiranBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.chosairairirekiichiran.ChosairairirekiIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.NinteiChosaProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.chosairairirekiichiran.ChosairairirekiIchiranReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票「DBE220004_認定調査依頼履歴一覧」の出力処理クラスです。
 *
 * @reamsid_L DBE-0080-140 xuyannan
 */
public class ChosairairirekiIchiran_DBE220004Process extends BatchProcessBase<HomonChosaIraishoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper."
            + "relate.hakkoichiranhyo.IHomonChosaIraishoMapper.get認定調査依頼履歴一覧");
    private static final ReportId 帳票ID = ReportIdDBE.DBE220004.getReportId();
    private NinteiChosaProcessParamter processParamter;
    private NinteiChosaBusiness business;

    @BatchWriter
    private BatchReportWriter<ChosairairirekiIchiranReportSource> batchWriter;
    private ReportSourceWriter<ChosairairirekiIchiranReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        business = new NinteiChosaBusiness(processParamter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toNinteiChosaMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(HomonChosaIraishoRelateEntity entity) {
        RString 認定調査依頼年月日;
        RString 認定申請区分;
        if (entity.get認定調査依頼年月日() == null || entity.get認定調査依頼年月日().isEmpty()) {
            認定調査依頼年月日 = RString.EMPTY;
        } else {
            認定調査依頼年月日 = entity.get認定調査依頼年月日().wareki().toDateString();
        }
        if (RString.isNullOrEmpty(entity.get認定申請区分_申請時_コード())) {
            認定申請区分 = RString.EMPTY;
        } else {
            認定申請区分 = NinteiShinseiShinseijiKubunCode.toValue(entity.get認定申請区分_申請時_コード()).get略称();
        }
        ChosairairirekiIchiranBusiness rirekiBusiness = new ChosairairirekiIchiranBusiness(entity.get直近区分(),
                entity.get被保険者番号(), entity.get被保険者氏名(), entity.get被保険者氏名カナ(), entity.get住所(), entity.get事業者名称(),
                entity.get調査員氏名(), 認定調査依頼年月日, 認定申請区分);
        if (!RString.isNullOrEmpty(entity.get被保険者番号())) {
            rirekiBusiness.set識別コード(new ShikibetsuCode(entity.get証記載保険者番号().substring(0, 5).concat(entity.get被保険者番号())));
            rirekiBusiness.set拡張情報(new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), entity.get申請書管理番号()));
        }
        ChosairairirekiIchiranReport report = new ChosairairirekiIchiranReport(rirekiBusiness);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.value(),
                導入団体クラス.getLasdecCode_().value(),
                導入団体クラス.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBE.DBE220004.getReportName(),
                new RString(String.valueOf(reportSourceWriter.pageCount().value())),
                new RString("無し"),
                new RString("－"),
                business.set出力条件());
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }
}
