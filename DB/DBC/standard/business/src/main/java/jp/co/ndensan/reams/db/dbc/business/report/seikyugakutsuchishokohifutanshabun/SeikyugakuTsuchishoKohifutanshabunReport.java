/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.seikyugakutsuchishokohifutanshabun;

import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.seikyugakutsuchishokohifutanshabun.SeikyugakuTsuchishoKohifutanshabunSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200067_介護給付費等請求額通知書（公費負担者分）Reportクラスです。
 *
 * @reamsid_L DBC-2790-030 lijian
 */
public class SeikyugakuTsuchishoKohifutanshabunReport extends Report<SeikyugakuTsuchishoKohifutanshabunSource> {

    private final DbWT1511SeikyugakuTsuchishoTempEntity 請求額通知書帳票用データ;
    private final RDateTime 作成日時;

    /**
     * コンストラクタです。
     *
     * @param 請求額通知書帳票用データ DbWT1511SeikyugakuTsuchishoTempEntity
     * @param 作成日時 RDateTime
     */
    public SeikyugakuTsuchishoKohifutanshabunReport(
            DbWT1511SeikyugakuTsuchishoTempEntity 請求額通知書帳票用データ,
            RDateTime 作成日時) {
        this.請求額通知書帳票用データ = 請求額通知書帳票用データ;
        this.作成日時 = 作成日時;
    }

    @Override
    public void writeBy(ReportSourceWriter<SeikyugakuTsuchishoKohifutanshabunSource> writer) {

        writeLine(writer, 請求額通知書帳票用データ);
    }

    private void writeLine(ReportSourceWriter<SeikyugakuTsuchishoKohifutanshabunSource> writer,
            DbWT1511SeikyugakuTsuchishoTempEntity 請求額通知書帳票用データ) {

        ISeikyugakuTsuchishoKohifutanshabunEditor editor = new SeikyugakuTsuchishoKohifutanshabunEditor(
                請求額通知書帳票用データ,
                作成日時);
        ISeikyugakuTsuchishoKohifutanshabunBuilder builder = new SeikyugakuTsuchishoKohifutanshabunBuilder(editor);
        writer.writeLine(builder);
    }
}
