/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.gassanjigyobunketteitsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunketteitsuchisho.GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiProperty;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunketteitsuchisho.GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiReport;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjigyobunketteitsuchisho.GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjigyobunketteitsuchisho.KogakuGassanShikyuKetteiTsuchisho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * （高額合算支給（不支給）決定通知書）支払予定日なし PrintSevice
 *
 * @reamsid_L DBC-4850-030 dongqianjing
 */
public class GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiPrintService {

    private static final ReportId 帳票分類ID = new ReportId("DBC200201_GassanJigyobunKetteiTsuchisho");

    /**
     * printメソッド(単一帳票出力用)
     *
     * @param entity KogakuGassanShikyuKetteiTsuchisho
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(KogakuGassanShikyuKetteiTsuchisho entity) {
        try (ReportManager reportManager = new ReportManager()) {
            print(entity, reportManager);
            return reportManager.publish();
        }
    }

    /**
     * printメソッド(複数帳票出力用)
     *
     * @param tsuchisho KogakuGassanShikyuKetteiTsuchisho
     * @param reportManager ReportManager
     */
    public void print(KogakuGassanShikyuKetteiTsuchisho tsuchisho, ReportManager reportManager) {
        GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiProperty property = new GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiProperty();
        try (ReportAssembler<GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            ChohyoSeigyoHanyoManager manager = new ChohyoSeigyoHanyoManager();
            List<ChohyoSeigyoHanyo> 帳票制御汎用キー = manager.get帳票制御汎用一覧(SubGyomuCode.DBC介護給付, 帳票分類ID);
            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 帳票分類ID,
                    tsuchisho.get発行日(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiReport report
                    = new GassanJigyobunKetteiTsuchishoShiharaiYoteiBiYijiNashiReport(tsuchisho, ninshoshaSource, 帳票制御汎用キー);
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
