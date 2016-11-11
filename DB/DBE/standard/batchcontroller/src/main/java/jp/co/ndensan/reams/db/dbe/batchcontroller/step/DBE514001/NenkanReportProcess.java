/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE514001;

import jp.co.ndensan.reams.db.dbe.business.core.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.shinsaschedulehyo.ShinsaschedulehyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kaigoninteishinsakaischedule.ScheduleNenkanRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsaschedulehyo.ShinsaschedulehyoReportSource;
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
 * 介護認定審査会スケジュール表_年間の処理クラスです
 *
 * @reamsid_L DBE-0130-090 duanzhanli
 */
public class NenkanReportProcess extends BatchProcessBase<KaigoNinteiShinsakaiScheduleRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.kaigoninteishinsakaischedule."
            + "IKaigoNinteiShinsakaiScheduleMapper.get年間");
    private static final ReportId REPORT_ID = ReportIdDBE.DBE514003.getReportId();
    private KaigoNinteiShinsakaiScheduleProcessParamter processParamter;
    private KaigoNinteiShinsakaiScheduleBusiness business;
    @BatchWriter
    private BatchReportWriter<ShinsaschedulehyoReportSource> batchWriter;
    private ReportSourceWriter<ShinsaschedulehyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        business = new KaigoNinteiShinsakaiScheduleBusiness(processParamter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toKaigoNinteiShinsakaiScheduleMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(REPORT_ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(KaigoNinteiShinsakaiScheduleRelateEntity entity) {
        business.get合議体Map(entity);
    }

    @Override
    protected void afterExecute() {
        ScheduleNenkanRelateEntity nenkanEntity = business.getScheduleNenkanRelateEntity();
        if (nenkanEntity.getGogitaiList() != null && !nenkanEntity.getGogitaiList().isEmpty()) {
            ShinsaschedulehyoReport report = new ShinsaschedulehyoReport(nenkanEntity);
            report.writeBy(reportSourceWriter);
        }
    }
}
