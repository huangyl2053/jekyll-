/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaisho;

import jp.co.ndensan.reams.db.dbc.entity.report.source.futanwariaisho.FutanWariaiShoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.futanwariaisho.FutanWariaiShoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC100065_負担割合証Report
 *
 * @reamsid_L DBC-5010-030 surun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanWariaiShoReport extends
        Report<FutanWariaiShoSource> {

    private final FutanWariaiShoEntity entity;
    private final NinshoshaSource sourceBuilder;

    /**
     * コンストラクタです。
     *
     * @param entity FutanWariaiShoEntity
     * @param sourceBuilder NinshoshaSource
     */
    public FutanWariaiShoReport(FutanWariaiShoEntity entity, NinshoshaSource sourceBuilder) {
        this.entity = entity;
        this.sourceBuilder = sourceBuilder;
    }

    @Override
    public void writeBy(ReportSourceWriter<FutanWariaiShoSource> writer) {
        IFutanWariaiShoEditor editor = new FutanWariaiShoEditor(entity, sourceBuilder);
        IFutanWariaiShoBuilder builder = new FutanWariaiShoBuilder(editor);
        writer.writeLine(builder);
    }

}
