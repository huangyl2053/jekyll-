/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.shokanketteitsuchishoikkatsu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharai;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishohihokenshabun.ShokanKetteiTsuchiShoHihokenshabunItem;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishohihokenshabun.ShokanKetteiTsuchiShoHihokenshabunReport;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharaiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoHihokenshabunReportSource;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraiskkttcsrysmuke.ShokanBaraiShikyuKetteiTsuchishoRiyoshamuke;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * DBC100005_償還払支給（不支給）決定通知書（受領委任払い・被保険者用）を出力します。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
public class ShoHihokenshabunOutputProcess extends BatchProcessBase<ShokanKetteiTsuchiShoShiharaiRelateEntity> {

    private static final RString 帳票取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "shokanketteitsuchishoikkatsusakusei.IShokanKetteiTsuchiShoIkkatsuSakuseiMapper.get帳票データ");

    List<ShokanKetteiTsuchiShoShiharai> 帳票データリスト = new ArrayList<>();
    ShokanKetteiTsuchiShoSealerBatchParameter batchPram;
    @BatchWriter
    private BatchReportWriter<ShokanKetteiTsuchiShoHihokenshabunReportSource> batchWrite;
    private ReportSourceWriter<ShokanKetteiTsuchiShoHihokenshabunReportSource> reportSourceWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(帳票取得SQL);
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100005.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void process(ShokanKetteiTsuchiShoShiharaiRelateEntity entity) {
        帳票データリスト.add(new ShokanKetteiTsuchiShoShiharai(entity));
    }

    @Override
    protected void afterExecute() {
        if (帳票データリスト.isEmpty()) {
            return;
        }
        ShokanBaraiShikyuKetteiTsuchishoRiyoshamuke sbsktr = ShokanBaraiShikyuKetteiTsuchishoRiyoshamuke.createInstance();
        List<ShokanKetteiTsuchiShoHihokenshabunItem> itemList
                = sbsktr.shokanBaraiShikyuKetteiTsuchishoRiyoshamuke(帳票データリスト, batchPram, reportSourceWriter);
        ShokanKetteiTsuchiShoHihokenshabunReport report = ShokanKetteiTsuchiShoHihokenshabunReport.createFrom(itemList);
        report.writeBy(reportSourceWriter);
    }
}
