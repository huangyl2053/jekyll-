/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyugakutorikomiichiran;

import jp.co.ndensan.reams.db.dbc.business.report.kogakugassan.KogakuGassanShikyugakuKeisanKekkaIn;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanshikyugakutorikomiichiran.GassanShikyugakuTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200037_高額合算支給額計算結果連絡票情報取込一覧表のReportクラスです。
 *
 * @reamsid_L DBC-2680-030 qinzhen
 */
public class GassanShikyugakuTorikomiIchiranReport extends Report<GassanShikyugakuTorikomiIchiranSource> {

    private final KogakuGassanShikyugakuKeisanKekkaIn entity;

    /**
     * コンストラクタです
     *
     * @param entity KogakuGassanShikyugakuKeisanKekkaIn
     */
    public GassanShikyugakuTorikomiIchiranReport(KogakuGassanShikyugakuKeisanKekkaIn entity) {
        this.entity = entity;

    }

    @Override
    public void writeBy(ReportSourceWriter<GassanShikyugakuTorikomiIchiranSource> writer) {

        IGassanShikyugakuTorikomiIchiranEditor editor = new GassanShikyugakuTorikomiIchiranEditor(entity);

        IGassanShikyugakuTorikomiIchiranBuilder builder = new GassanShikyugakuTorikomiIchiranBuilder(editor);

        writer.writeLine(builder);

    }
}
