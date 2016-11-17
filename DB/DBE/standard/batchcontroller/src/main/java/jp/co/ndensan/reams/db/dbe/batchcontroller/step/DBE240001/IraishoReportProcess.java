/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko.HomonChosaIraishoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.HomonChosaIraishoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbz.business.report.chosairaisho.ChosaIraishoReport;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.report.chosairaisho.ChosaIraishoReportSource;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
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
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 帳票「DBE220001_認定調査依頼書」の処理クラスです。
 *
 * @reamsid_L DBE-0080-140 duanzhanli
 */
public class IraishoReportProcess extends BatchProcessBase<HomonChosaIraishoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper."
            + "relate.hakkoichiranhyo.IHomonChosaIraishoMapper.get訪問調査依頼書");
    private static final ReportId 帳票ID = ReportIdDBZ.DBE220001.getReportId();
    private HomonChosaIraishoBusiness business;
    private NinshoshaSource ninshoshaSource;
    private Map<Integer, RString> 通知文Map;
    private RString 文書番号;
    private HomonChosaIraishoProcessParamter processParamter;
    @BatchWriter
    private BatchReportWriter<ChosaIraishoReportSource> iraishoBatchReportWriter;
    private ReportSourceWriter<ChosaIraishoReportSource> iraishoReportSourceWriter;

    @Override
    protected void initialize() {
        business = new HomonChosaIraishoBusiness(processParamter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toHomonChosaIraishoMybitisParamter());
    }

    @Override
    protected void createWriter() {
        iraishoBatchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        iraishoReportSourceWriter = new ReportSourceWriter<>(iraishoBatchReportWriter);
    }

    @Override
    protected void beforeExecute() {
        ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援,
                帳票ID,
                new FlexibleDate(processParamter.getHakkobi()),
                NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), KenmeiFuyoKubunType.付与なし,
                iraishoReportSourceWriter);
        通知文Map = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, 帳票ID, KamokuCode.EMPTY, 1);
        文書番号 = ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, 帳票ID, FlexibleDate.getNowDate());
    }

    @Override
    protected void process(HomonChosaIraishoRelateEntity entity) {
        ChosaIraishoReport report = ChosaIraishoReport.createFrom(business.setChosaIraishoHeadItem(entity, 通知文Map, ninshoshaSource, 文書番号));
        report.writeBy(iraishoReportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.value(),
                導入団体クラス.getLasdecCode_().value(),
                導入団体クラス.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBZ.DBE220001.getReportName(),
                new RString(String.valueOf(iraishoReportSourceWriter.pageCount().value())),
                new RString("無し"),
                new RString("－"),
                business.set出力条件());
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }
}
