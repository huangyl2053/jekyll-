/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyokyotakuyobosogojigyo;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyokyotakuyobosogojigyo.KyufuKanrihyoKyotakuYoboSogoJigyoServiceEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufukanrihyokyotakuyobosogojigyo.KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 給付管理票のReportクラスです。
 *
 * @reamsid_L DBC-2840-040 sunhaidi
 */
public class KyufuKanrihyoKyotakuYoboSogoJigyoServiceReport extends Report<KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource> {

    private final KyufuKanrihyoKyotakuYoboSogoJigyoServiceEntity 帳票出力対象データ;
    private final FlexibleYearMonth 処理年月;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ KyufuKanrihyoKyotakuYoboSogoJigyoServiceEntity
     * @param 処理年月 FlexibleYearMonth
     */
    public KyufuKanrihyoKyotakuYoboSogoJigyoServiceReport(
            KyufuKanrihyoKyotakuYoboSogoJigyoServiceEntity 帳票出力対象データ,
            FlexibleYearMonth 処理年月) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.処理年月 = 処理年月;
    }

    @Override
    public void writeBy(ReportSourceWriter<KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource> reportSourceWriter) {
        IKyufuKanrihyoKyotakuYoboSogoJigyoServiceEditor editor = new KyufuKanrihyoKyotakuYoboSogoJigyoServiceEditor(
                帳票出力対象データ, 処理年月);
        IKyufuKanrihyoKyotakuYoboSogoJigyoServiceBuilder builder = new KyufuKanrihyoKyotakuYoboSogoJigyoServiceBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
