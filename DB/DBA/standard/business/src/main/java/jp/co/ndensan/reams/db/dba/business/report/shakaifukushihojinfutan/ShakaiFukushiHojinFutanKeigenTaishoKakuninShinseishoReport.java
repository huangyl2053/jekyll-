/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shakaifukushihojinfutan;

import jp.co.ndensan.reams.db.dba.entity.report.shakaifukushihojinfutan.ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 社会福祉法人等利用者負担軽減対象確認申請書のReportです。
 */
public class ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoReport extends
        Report<ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoReportSource> {

    private final ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 社会福祉法人等利用者負担軽減対象確認申請書ヘッダのITEM
     * @return 社会福祉法人等利用者負担軽減対象確認申請書のReport
     */
    public static ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoReport createReport(
            ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoItem item) {

        return new ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoReport(
                item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 社会福祉法人等利用者負担軽減対象確認申請書ヘッダのITEM
     */
    protected ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoReport(
            ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoItem item) {
        this.item = item;
    }

    /**
     *
     * @param reportSourceWriter 社会福祉法人等利用者負担軽減対象確認申請書情報
     */
    @Override
    public void writeBy(ReportSourceWriter<ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoReportSource> reportSourceWriter) {
        ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoEditorImpl editor
                = new ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoEditorImpl(item);
        IShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoBuilder builder
                = new ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoBuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }
}
