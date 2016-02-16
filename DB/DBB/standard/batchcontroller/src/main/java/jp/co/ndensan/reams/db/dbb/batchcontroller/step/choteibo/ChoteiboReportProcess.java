/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.choteibo;

import jp.co.ndensan.reams.db.dbb.definition.processprm.choteibo.ChoteiboProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo.ChoteiboChohyoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調定簿作成帳票用Processクラスです。
 */
public class ChoteiboReportProcess extends BatchProcessBase<ChoteiboChohyoEntity> {

    private static final ReportId ID = new ReportId("DBB300001_Choteibo");
    private static final RString MYBATIS_SELECT_ID = new RString("");
    private Boolean isEmpty = true;
//    @InjectSession
//    private List<ChoteiboItem> lists;
//    @BatchWriter
//    private BatchReportWriter<ChoteiboSource> batchReportWriter;
//    private ReportSourceWriter<ChoteiboSource> reportSourceWriter;
    private ChoteiboProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
//        batchReportWriter = BatchReportFactory.createBatchReportWriter(ID.value()).create();
//        reportSourceWriter = new reportSourceWriter<>(batchReportWriter);

    }

    @Override
    protected void process(ChoteiboChohyoEntity entity) {

//        ChoteiboItem item = new ChoteiboItem();
    }

    @Override
    protected void afterExecute() {
//        ChoteiboReport report = ChoteiboReport.createForm(lists);
//        report.writeBy(reportSourceWriter);
    }
}
