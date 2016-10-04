/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyutsuchishotorikomiichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikyufushikyu.ShikyuFushikyuChohyoParameter;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanshikyutsuchishotorikomiichiran.GassanShikyuTsuchishoTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200039_高額合算支給不支給決定通知書情報取込一覧表 のReportクラスです。
 *
 * @reamsid_L DBC-2690-030 qinzhen
 */
public class GassanShikyuTsuchishoTorikomiIchiranReport extends Report<GassanShikyuTsuchishoTorikomiIchiranSource> {

    private final ShikyuFushikyuChohyoParameter entity;

    /**
     * コンストラクタです
     *
     * @param entity ShikyuFushikyuChohyoParameter
     */
    public GassanShikyuTsuchishoTorikomiIchiranReport(ShikyuFushikyuChohyoParameter entity) {
        this.entity = entity;

    }

    @Override
    public void writeBy(ReportSourceWriter<GassanShikyuTsuchishoTorikomiIchiranSource> writer) {

        IGassanShikyuTsuchishoTorikomiIchiranEditor editor = new GassanShikyuTsuchishoTorikomiIchiranEditor(entity);

        IGassanShikyuTsuchishoTorikomiIchiranBuilder builder = new GassanShikyuTsuchishoTorikomiIchiranBuilder(editor);

        writer.writeLine(builder);

    }
}
