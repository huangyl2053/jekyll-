/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030;

import jp.co.ndensan.reams.db.dbu.business.core.ippangenbutsu.KyufuJissekiKonkyoBusiness;
import jp.co.ndensan.reams.db.dbu.business.report.shorikekkakakuninist.ShoriKekkaKakuninListReport;
import jp.co.ndensan.reams.db.dbu.definition.processprm.ippangenbutsu.JigyoHokokuGeppoIppanGenbutsuProcessParamter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippangenbutsu.JigyoHokokuIppanGenbutsuRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.shorikekkakakuninlist.ShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.shorikekkakakuninlist.ShoriKekkaKakuninListReportSource;
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
 * 事業報告月報_一般現物帳票出力のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5540-030 suguangjun
 *
 */
public class ShoriKekkaKakuninListProcess extends BatchProcessBase<JigyoHokokuIppanGenbutsuRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.ippangenbutsu."
            + "IJigyoHokokuGeppoIppanGenbutsuMapper.getResultKyufuJisseki");
    private JigyoHokokuGeppoIppanGenbutsuProcessParamter processParameter;
    private static final ReportId REPORTID = ReportIdDBU.DBU200002.getReportId();
    private KyufuJissekiKonkyoBusiness business;

    @BatchWriter
    private BatchReportWriter<ShoriKekkaKakuninListReportSource> batchWrite;
    private ReportSourceWriter<ShoriKekkaKakuninListReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        business = new KyufuJissekiKonkyoBusiness(processParameter);
        super.beforeExecute();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toDataMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORTID.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(JigyoHokokuIppanGenbutsuRelateEntity entity) {
        ShoriKekkaKakuninListEntity kuninListEntity = business.set処理結果確認リストEntity(entity);
        ShoriKekkaKakuninListReport report = new ShoriKekkaKakuninListReport(kuninListEntity);
        report.writeBy(reportSourceWriter);
    }
}
