/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100025;

import jp.co.ndensan.reams.db.dbd.business.core.dbt4030011.NinteishoJohoBusiness;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100025.NinteishoJohoReportSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 障がい者控除対象者認定証のReportです。
 *
 * @reamsid_L DBD-3870-030 donghj
 */
public class ShogaishaKojoNinteishoReport extends Report<NinteishoJohoReportSource> {

    private final NinteishoJohoBusiness target;
    private final NinshoshaSource ninshoshaSource;

    /**
     * インスタンスを生成します。
     *
     * @param target NinteishoJohoBusiness
     * @param ninshoshaSource 認証者
     */
    public ShogaishaKojoNinteishoReport(NinteishoJohoBusiness target, NinshoshaSource ninshoshaSource) {
        this.target = target;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<NinteishoJohoReportSource> writer) {
        IShogaishaKojoNinteishoEditor editor = new ShogaishaKojoNinteishoEditorImpl(target, ninshoshaSource);
        IShogaishaKojoNinteishoBuilder builder = new ShogaishaKojoNinteishoBuilderImpl(editor);
        writer.writeLine(builder);

    }
}
