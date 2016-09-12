/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaishorenchotate;

import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishokattokami.FutanWariaiShoKattokamiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishorenchotate.FutanWariaiShoRenchoTateSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC100066_負担割合証（連帳・縦）の Reportです。
 *
 * @reamsid_L DBC-4990-050 pengxingyi
 */
public class FutanWariaiShoRenchoTateReport extends Report<FutanWariaiShoRenchoTateSource> {

    private final FutanWariaiShoKattokamiEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link FutanWariaiShoKattokamiEntity}
     */
    public FutanWariaiShoRenchoTateReport(FutanWariaiShoKattokamiEntity entity) {
        this.entity = entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<FutanWariaiShoRenchoTateSource> reportSourceWriter) {
        IFutanWariaiShoRenchoTateEditor editor = new FutanWariaiShoRenchoTateEditor(entity);
        IFutanWariaiShoRenchoTateBuilder builder = new FutanWariaiShoRenchoTateBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
