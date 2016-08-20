/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.tashichosonjushochitokureisharenrakuhyo;

import jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochitokureisharenrakuhyo.TashichosonJushochitokureishaRenrakuhyoItem;
import jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochitokureisharenrakuhyo.TashichosonJushochitokureishaRenrakuhyoProperty;
import jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochitokureisharenrakuhyo.TashichosonJushochitokureishaRenrakuhyoReport;
import jp.co.ndensan.reams.db.dba.entity.report.tashichosonjushochitokureisharenrakuhyo.TashichosonJushochitokureishaRenrakuhyoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * 介護保険他市町村住所地特例者連絡票Printerです。
 *
 * @reamsid_L DBA-0380-080 duanzhanli
 *
 */
public class TashichosonJushochitokureishaRenrakuhyoPrintService {

    private final ReportManager reportManager;

    /**
     * コンストラクタです。
     *
     * @param reportManager ReportManager
     */
    public TashichosonJushochitokureishaRenrakuhyoPrintService(ReportManager reportManager) {
        this.reportManager = reportManager;
    }

    /**
     * 介護保険他市町村住所地特例者連絡票を印刷します。
     *
     * @param item 介護保険他市町村住所地特例者連絡票_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(TashichosonJushochitokureishaRenrakuhyoItem item) {
        TashichosonJushochitokureishaRenrakuhyoProperty property = new TashichosonJushochitokureishaRenrakuhyoProperty();
        try (ReportAssembler<TashichosonJushochitokureishaRenrakuhyoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<TashichosonJushochitokureishaRenrakuhyoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(property.subGyomuCode(),
                    property.reportId(),
                    FlexibleDate.getNowDate(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                    KenmeiFuyoKubunType.付与なし,
                    reportSourceWriter);
            item.setDenshiKoin(ninshoshaSource.denshiKoin);
            item.setShomeiHakkoYMD(ninshoshaSource.hakkoYMD);
            item.setShuchoMei(ninshoshaSource.ninshoshaYakushokuMei);
            item.setShichosonMei(ninshoshaSource.ninshoshaYakushokuMei2);
            item.setKoinShoryaku(ninshoshaSource.koinShoryaku);
            TashichosonJushochitokureishaRenrakuhyoReport report = TashichosonJushochitokureishaRenrakuhyoReport.createFrom(item);
            report.writeBy(reportSourceWriter);
        }
        return reportManager.publish();
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(
            IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }
}
