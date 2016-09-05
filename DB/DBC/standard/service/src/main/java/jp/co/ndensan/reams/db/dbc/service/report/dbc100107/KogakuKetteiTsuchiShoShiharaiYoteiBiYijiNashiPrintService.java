/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.dbc100107;

import jp.co.ndensan.reams.db.dbc.business.report.dbc100107.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiProperty;
import jp.co.ndensan.reams.db.dbc.business.report.dbc100107.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiReport;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicenokanribangourendou.JigyouKetteiTutisyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc100107.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 高額サービス等支給（不支給）決定通知書（単）帳票クラスです。
 *
 * @reamsid_L DBC-5160-050 donghj
 */
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiPrintService {

    /**
     * 帳票を出力
     *
     * @param reportManager ReportManager
     * @param 決定通知書Entity JigyouKetteiTutisyoEntity
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     */
    public void print(ReportManager reportManager, JigyouKetteiTutisyoEntity 決定通知書Entity, ChohyoSeigyoKyotsu 帳票制御共通) {
        KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiProperty property
                = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiProperty();
        try (ReportAssembler<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource> assembler
                = createAssembler(property, reportManager)) {
            ReportSourceWriter<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiReport report
                    = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiReport(決定通知書Entity, 帳票制御共通);
            report.writeBy(reportSourceWriter);
        }
    }

    private <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }

}
