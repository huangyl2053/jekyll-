/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.shokanketteitsuchishoikkatsu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharai;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishoshiharaiyoteibiyijiari.ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishoshiharaiyoteibiyijiari.ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriReport;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharaiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriRepotSource;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraishikyuketteitsuchishojuryouininshamuke.ShokanBaraiShikyuKetteiTsuchishoJuryoIninshaMuke;
import jp.co.ndensan.reams.db.dbc.service.report.shokanbaraishikyufushikyuketteitsuhchishochohyo.ShokanBaraiShikyuFushikyuKetteiTsuchishoBatch;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票DBC100002_償還払い支給（不支給）決定通知書を出力します。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
public class ShoShiharaiYoteiBiYijiAriOutputProcess extends BatchProcessBase<ShokanKetteiTsuchiShoShiharaiRelateEntity> {

    private static final RString 帳票取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "shokanketteitsuchishoikkatsusakusei.IShokanKetteiTsuchiShoIkkatsuSakuseiMapper.get帳票データ");
    private static final RString FLAG_FALSE = new RString("0");
    List<ShokanKetteiTsuchiShoShiharai> 帳票データリスト = new ArrayList<>();
    ShokanKetteiTsuchiShoSealerBatchParameter batchPram;
    @BatchWriter
    private BatchReportWriter<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriRepotSource> batchWrite;
    private ReportSourceWriter<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriRepotSource> reportSourceWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(帳票取得SQL);
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100003.getReportId().value()).create();
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
        List<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem> itemList;
        if (FLAG_FALSE.equals(batchPram.get受領委任者向け決定通知書フラグ())) {
            ShokanBaraiShikyuKetteiTsuchishoJuryoIninshaMuke ichiranhyo = new ShokanBaraiShikyuKetteiTsuchishoJuryoIninshaMuke();
            itemList = ichiranhyo.getShokanBaraiShikyuKetteiTsuchishoJuryoIninshaMukeData(帳票データリスト, batchPram, reportSourceWriter);
        } else {
            ShokanBaraiShikyuFushikyuKetteiTsuchishoBatch sbsfktb = new ShokanBaraiShikyuFushikyuKetteiTsuchishoBatch();
            itemList = sbsfktb.getShokanHaraiShikyuFushikyuKetteiTsuhchishoChohyoData(帳票データリスト, batchPram, reportSourceWriter);
        }
        ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriReport report
                = ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriReport.createFrom(itemList);
        report.writeBy(reportSourceWriter);
    }
}
