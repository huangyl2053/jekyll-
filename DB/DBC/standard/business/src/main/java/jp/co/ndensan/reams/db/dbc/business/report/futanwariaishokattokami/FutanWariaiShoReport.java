/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaishokattokami;

import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishokattokami.FutanWariaiShoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishokattokami.FutanWariaiShoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC100065_負担割合証（カット紙）の Reportです。
 *
 * @reamsid_L DBC-4990-040 pengxingyi
 */
public class FutanWariaiShoReport extends Report<FutanWariaiShoSource> {

    private final FutanWariaiShoEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link FutanWariaiShoEntity}
     */
    public FutanWariaiShoReport(FutanWariaiShoEntity entity) {
        this.entity = entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<FutanWariaiShoSource> reportSourceWriter) {
        IFutanWariaiShoEditor editor = new FutanWariaiShoEditor(entity);
        IFutanWariaiShoBuilder builder = new FutanWariaiShoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
