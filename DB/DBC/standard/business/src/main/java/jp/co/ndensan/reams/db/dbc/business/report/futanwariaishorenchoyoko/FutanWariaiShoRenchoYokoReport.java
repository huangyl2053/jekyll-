/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaishorenchoyoko;

import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishokattokami.FutanWariaiShoKattokamiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishorenchoyoko.FutanWariaiShoRenchoYokoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC100067_負担割合証（連帳・横）の Reportです。
 *
 * @reamsid_L DBC-4990-060 pengxingyi
 */
public class FutanWariaiShoRenchoYokoReport extends Report<FutanWariaiShoRenchoYokoSource> {

    private final FutanWariaiShoKattokamiEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link FutanWariaiShoKattokamiEntity}
     */
    public FutanWariaiShoRenchoYokoReport(FutanWariaiShoKattokamiEntity entity) {
        this.entity = entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<FutanWariaiShoRenchoYokoSource> reportSourceWriter) {
        IFutanWariaiShoRenchoYokoEditor editor = new FutanWariaiShoRenchoYokoEditor(entity);
        IFutanWariaiShoRenchoYokoBuilder builder = new FutanWariaiShoRenchoYokoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
