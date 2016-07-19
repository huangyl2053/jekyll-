/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd800006;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd800006.ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 社会福祉法人等利用者負担軽減対象確認申請書のReportです。
 *
 * @reamsid_L DBA-0540-698 zhangguopeng
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
