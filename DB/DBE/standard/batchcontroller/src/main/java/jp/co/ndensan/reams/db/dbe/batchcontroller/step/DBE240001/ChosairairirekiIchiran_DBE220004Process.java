/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001;

import jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko.HomonChosaIraishoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.chosairairirekiichiran.ChosairairirekiIchiranBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.chosairairirekiichiran.ChosairairirekiIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.HomonChosaIraishoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.chosairairirekiichiran.ChosairairirekiIchiranReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private HomonChosaIraishoProcessParamter processParamter;

    @BatchWriter
    private BatchReportWriter<ChosairairirekiIchiranReportSource> batchWriter;
    private ReportSourceWriter<ChosairairirekiIchiranReportSource> reportSourceWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
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
        ChosairairirekiIchiranReport report = new ChosairairirekiIchiranReport(
                new ChosairairirekiIchiranBusiness(entity.get直近区分(),
                        entity.get被保険者番号(), entity.get被保険者氏名(), entity.get被保険者氏名カナ(), entity.get住所(), entity.get事業者名称(),
                        entity.get調査員氏名(), 認定調査依頼年月日, 認定申請区分));
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 導入団体クラス.getLasdecCode_().value();
        RString 市町村名 = 導入団体クラス.get市町村名();
        RString 出力ページ数 = new RString(String.valueOf(reportSourceWriter.pageCount().value()));
        RString csv出力有無 = new RString("無し");
        RString csvファイル名 = new RString("－");
        RString ジョブ番号 = new RString("56");
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.value(),
                導入団体コード,
                市町村名,
                ジョブ番号,
                ReportIdDBE.DBE220004.getReportName(),
                出力ページ数,
                csv出力有無,
                csvファイル名,
                new HomonChosaIraishoBusiness(processParamter).set出力条件());
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }
}
