/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.servicecodebetsuriyojokyo;

import jp.co.ndensan.reams.db.dbc.business.report.servicecoderiyojokyo.ServicecodeRiyojokyoReport;
import jp.co.ndensan.reams.db.dbc.entity.report.source.servicecodebetsuriyojokyo.ServiceCodeBetsuRiyoJokyoSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC300002_サービスコード別利用状況 のReportクラスです。
 *
 * @reamsid_L DBC-3340-040 qinzhen
 */
public class ServiceCodeBetsuRiyoJokyoReport extends Report<ServiceCodeBetsuRiyoJokyoSource> {

    private final RDateTime 作成日時;
    private final ServicecodeRiyojokyoReport entity;

    /**
     * コンストラクタです
     *
     * @param entity ServicecodeRiyojokyoReport
     * @param 作成日時 RDateTime
     */
    public ServiceCodeBetsuRiyoJokyoReport(ServicecodeRiyojokyoReport entity, RDateTime 作成日時) {
        this.entity = entity;
        this.作成日時 = 作成日時;
    }

    @Override
    public void writeBy(ReportSourceWriter<ServiceCodeBetsuRiyoJokyoSource> writer) {

        IServiceCodeBetsuRiyoJokyoEditor editor = new ServiceCodeBetsuRiyoJokyoEditor(entity, 作成日時);

        IServiceCodeBetsuRiyoJokyoBuilder builder = new ServiceCodeBetsuRiyoJokyoBuilder(editor);

        writer.writeLine(builder);

    }
}
