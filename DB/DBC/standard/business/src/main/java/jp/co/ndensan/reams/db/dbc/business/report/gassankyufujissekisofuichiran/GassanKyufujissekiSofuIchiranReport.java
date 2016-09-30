/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassankyufujissekisofuichiran;

import jp.co.ndensan.reams.db.dbc.business.report.kogakugassan.KogakugassanKyufujissekiDoSofuReportEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassankyufujissekisofuichiran.GassanKyufujissekiSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200042_高額合算給付実績情報送付一覧表 のReportクラスです。
 *
 * @reamsid_L DBC-2710-040 qinzhen
 */
public class GassanKyufujissekiSofuIchiranReport extends Report<GassanKyufujissekiSofuIchiranSource> {

    private final KogakugassanKyufujissekiDoSofuReportEntity entity;

    /**
     * コンストラクタです
     *
     * @param entity KogakugassanKyufujissekiDoSofuReportEntity
     */
    public GassanKyufujissekiSofuIchiranReport(KogakugassanKyufujissekiDoSofuReportEntity entity) {
        this.entity = entity;

    }

    @Override
    public void writeBy(ReportSourceWriter<GassanKyufujissekiSofuIchiranSource> writer) {

        IGassanKyufujissekiSofuIchiranEditor editor = new GassanKyufujissekiSofuIchiranEditor(entity);

        IGassanKyufujissekiSofuIchiranBuilder builder = new GassanKyufujissekiSofuIchiranBuilder(editor);

        writer.writeLine(builder);

    }
}
