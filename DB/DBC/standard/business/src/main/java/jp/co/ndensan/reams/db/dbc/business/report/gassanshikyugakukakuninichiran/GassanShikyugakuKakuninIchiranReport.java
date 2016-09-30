/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyugakukakuninichiran;

import jp.co.ndensan.reams.db.dbc.business.report.kogakugassan.KogakuGassanShikyugakuKeisanKekkaIn;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanshikyugakukakuninichiran.GassanShikyugakuKakuninIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額合算支給額計算結果連絡票情報確認リストのReportクラスです。
 *
 * @reamsid_L DBC-2680-031 qinzhen
 */
public class GassanShikyugakuKakuninIchiranReport extends Report<GassanShikyugakuKakuninIchiranSource> {

    private final KogakuGassanShikyugakuKeisanKekkaIn entity;

    /**
     * コンストラクタです
     *
     * @param entity KogakuGassanShikyugakuKeisanKekkaIn
     */
    public GassanShikyugakuKakuninIchiranReport(KogakuGassanShikyugakuKeisanKekkaIn entity) {
        this.entity = entity;

    }

    @Override
    public void writeBy(ReportSourceWriter<GassanShikyugakuKakuninIchiranSource> writer) {

        IGassanShikyugakuKakuninIchiranEditor editor = new GassanShikyugakuKakuninIchiranEditor(entity);

        IGassanShikyugakuKakuninIchiranBuilder builder = new GassanShikyugakuKakuninIchiranBuilder(editor);

        writer.writeLine(builder);

    }
}
