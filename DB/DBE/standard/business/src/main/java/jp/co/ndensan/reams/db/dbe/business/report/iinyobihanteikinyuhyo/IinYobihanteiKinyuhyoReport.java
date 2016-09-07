/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinyobihanteikinyuhyo;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.IinYobihanteiKinyuhyoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinyobihanteikinyuhyo.IinYobihanteiKinyuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用予備判定記入表のReportです。
 *
 * @reamsid_L DBE-0150-150 wangrenze
 */
public class IinYobihanteiKinyuhyoReport extends Report<IinYobihanteiKinyuhyoReportSource> {

    private final IinYobihanteiKinyuhyoBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business 委員用予備判定記入表
     * @return 委員用予備判定記入表のReport
     */
    public static IinYobihanteiKinyuhyoReport createFrom(IinYobihanteiKinyuhyoBusiness business) {

        return new IinYobihanteiKinyuhyoReport(business);
    }

    /**
     * インスタンスを生成します。
     *
     * @param business 委員用予備判定記入表
     */
    protected IinYobihanteiKinyuhyoReport(IinYobihanteiKinyuhyoBusiness business) {
        this.business = business;
    }

    @Override
    public void writeBy(ReportSourceWriter<IinYobihanteiKinyuhyoReportSource> reportSourceWriter) {

        IinYobihanteiKinyuhyoEditor editor = new IinYobihanteiKinyuhyoEditor(business);
        IinYobihanteiKinyuhyoBuilder builder = new IinYobihanteiKinyuhyoBuilder(editor);
        reportSourceWriter.writeLine(builder);

    }
}
