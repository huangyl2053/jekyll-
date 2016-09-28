/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.riyojokyotokeihyo;

import jp.co.ndensan.reams.db.dbc.entity.report.riyojokyotokeihyo.RiyoJokyoTokeihyoShukeiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.riyojokyotokeihyo.RiyoJokyoTokeihyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 利用状況統計表のReportクラスです。
 *
 * @reamsid_L DBC-3500-050 jinjue
 */
public class RiyoJokyoTokeihyoReport extends Report<RiyoJokyoTokeihyoReportSource> {

    private final RiyoJokyoTokeihyoShukeiKekkaEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 認定調査報酬照会帳票のたEntity
     */
    public RiyoJokyoTokeihyoReport(RiyoJokyoTokeihyoShukeiKekkaEntity data) {
        this.data = data;
    }

    @Override
    protected void writeBy(ReportSourceWriter<RiyoJokyoTokeihyoReportSource> writer) {
        IRiyoJokyoTokeihyoEditor editor = new RiyoJokyoTokeihyoEditor(data);
        IRiyoJokyoTokeihyoBuilder builder = new RiyoJokyoTokeihyoBuilder(editor);
        writer.writeLine(builder);
    }
}
