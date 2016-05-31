/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyotokkijiko;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyotokkijiko.ChosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定調査票（特記事項）のReportです。
 *
 * @reamsid_L DBE-0080-040 xuyannan
 */
public class ChosahyoTokkijikoReport extends Report<ChosahyoTokkijikoReportSource> {

    private final ChosahyoTokkijikoEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 要介護認定調査票（特記事項）のentity
     */
    public ChosahyoTokkijikoReport(ChosahyoTokkijikoEntity entity) {
        this.entity = entity;
    }

    /**
     * 帳票を作成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<ChosahyoTokkijikoReportSource> reportSourceWriter) {
        IChosahyoTokkijikoEditor editor = new ChosahyoTokkijikoEditorImpl(entity);
        IChosahyoTokkijikoBuilder builder = new ChosahyoTokkijikoBuilderImpl(editor);
        reportSourceWriter.writeLine(builder);
    }
}
