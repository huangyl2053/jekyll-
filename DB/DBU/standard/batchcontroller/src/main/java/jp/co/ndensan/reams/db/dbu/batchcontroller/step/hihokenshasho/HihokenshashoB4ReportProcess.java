/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashob4.HihokenshashoB4BodyItem;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashob4.HihokenshashoB4Report;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashob4.HihokenshashoB4ReportSource;
import jp.co.ndensan.reams.db.dbu.business.core.hihokenshasho.HihokenshashoBReportResult;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashochohyo.HihokenshashoChohyoParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.hihokenshasho.IkkatsuHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshasho.IkkatsuHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbu.service.core.hihokenshashochohyo.HihokenshashoChohyoFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票「介護保険被保険者証 （B4版）」の出力処理クラスです。
 *
 * @reamsid_L DBU-0420-020 duanzhanli
 *
 */
public class HihokenshashoB4ReportProcess extends BatchProcessBase<IkkatsuHakkoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hihokenshasho.IIkkatsuHakkoMapper.getHihokenshayo");
    private static final ReportId 帳票ID = ReportIdDBA.DBA100001.getReportId();
    private List<HihokenshashoChohyoParameter> 帳票用Pram;
    private IkkatsuHakkoProcessParameter processPrm;
    @BatchWriter
    private BatchReportWriter<HihokenshashoB4ReportSource> batchReportWriter;
    private ReportSourceWriter<HihokenshashoB4ReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        帳票用Pram = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processPrm.toIkkatsuHakkoMybatisParameter());

    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(IkkatsuHakkoRelateEntity entity) {
        AccessLogger.log(AccessLogType.照会, PersonalData.of(entity.getShikibetsuCode()));
        帳票用Pram.add(new HihokenshashoBReportResult().setHihokenshashoChohyoParameter(entity, processPrm.getKofuYMD()));
    }

    @Override
    protected void afterExecute() {
        List<HihokenshashoB4BodyItem> itemList = new HihokenshashoBReportResult().
                setB4ItemList(HihokenshashoChohyoFinder.createInstance().createHihokenshashoChohyo(帳票用Pram).records());
        if (itemList != null && !itemList.isEmpty()) {
            HihokenshashoB4Report report = HihokenshashoB4Report.createReport(itemList);
            report.writeBy(reportSourceWriter);
        }
    }
}
