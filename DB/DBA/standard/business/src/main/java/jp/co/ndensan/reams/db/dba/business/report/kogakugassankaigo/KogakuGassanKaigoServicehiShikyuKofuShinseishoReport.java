/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kogakugassankaigo;

import jp.co.ndensan.reams.db.dba.entity.report.kogakugassankaigo.KogakuGassanKaigoServicehiShikyuKofuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 高額医療合算介護（介護予防）サービス費支給兼自己負担額証明書交付申請書のReportです。
 */
public class KogakuGassanKaigoServicehiShikyuKofuShinseishoReport
        extends Report<KogakuGassanKaigoServicehiShikyuKofuShinseishoReportSource> {

    private final KogakuGassanKaigoServicehiShikyuKofuShinseishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 高額医療合算介護（介護予防）サービス費支給兼自己負担額証明書交付申請書のITEM
     * @return 高額医療合算介護（介護予防）サービス費支給兼自己負担額証明書交付申請書のReport
     */
    public static KogakuGassanKaigoServicehiShikyuKofuShinseishoReport createFrom(
            KogakuGassanKaigoServicehiShikyuKofuShinseishoItem item) {

        return new KogakuGassanKaigoServicehiShikyuKofuShinseishoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 高額医療合算介護（介護予防）サービス費支給兼自己負担額証明書交付申請書のITEM
     */
    protected KogakuGassanKaigoServicehiShikyuKofuShinseishoReport(
            KogakuGassanKaigoServicehiShikyuKofuShinseishoItem item) {

        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuGassanKaigoServicehiShikyuKofuShinseishoReportSource> reportSourceWriter) {
        IKogakuGassanKaigoServicehiShikyuKofuShinseishoEditor editor = new KogakuGassanKaigoServicehiShikyuKofuShinseishoItemEditor(item);
        IKogakuGassanKaigoServicehiShikyuKofuShinseishoBuilder builder = new KogakuGassanKaigoServicehiShikyuKofuShinseishoItemBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
