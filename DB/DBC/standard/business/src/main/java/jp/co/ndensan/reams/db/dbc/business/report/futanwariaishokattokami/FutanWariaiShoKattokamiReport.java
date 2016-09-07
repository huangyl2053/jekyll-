/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaishokattokami;

import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishokattokami.FutanWariaiShoKattokamiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishokattokami.FutanWariaiShoKattokamiSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC100065_負担割合証（カット紙）の Reportです。
 *
 * @reamsid_L DBC-4990-040 pengxingyi
 */
public class FutanWariaiShoKattokamiReport extends Report<FutanWariaiShoKattokamiSource> {

    private final FutanWariaiShoKattokamiEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link FutanWariaiShoKattokamiEntity}
     */
    public FutanWariaiShoKattokamiReport(FutanWariaiShoKattokamiEntity entity) {
        this.entity = entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<FutanWariaiShoKattokamiSource> reportSourceWriter) {
        IFutanWariaiShoKattokamiEditor editor = new FutanWariaiShoKattokamiEditor(entity);
        IFutanWariaiShoKattokamiBuilder builder = new FutanWariaiShoKattokamiBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
