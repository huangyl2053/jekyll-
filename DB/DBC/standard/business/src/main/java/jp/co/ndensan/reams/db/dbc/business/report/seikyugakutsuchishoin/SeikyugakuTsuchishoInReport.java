/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.seikyugakutsuchishoin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyugakutsuchishoin.SeikyugakuTsuchishoSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護給付費等請求額通知書一覧表帳票Report
 *
 * @reamsid_L DBC-2480-030 jiangwenkai
 */
public class SeikyugakuTsuchishoInReport extends Report<SeikyugakuTsuchishoSource> {

    private final List<DbWT1511SeikyugakuTsuchishoTempEntity> 帳票出力対象データリスト;
    private final RDateTime 作成日時;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データリスト List<SeikyugakuTsuchishoSource>
     * @param 作成日時 RDateTime
     */
    public SeikyugakuTsuchishoInReport(
            List<DbWT1511SeikyugakuTsuchishoTempEntity> 帳票出力対象データリスト,
            RDateTime 作成日時) {
        this.帳票出力対象データリスト = 帳票出力対象データリスト;
        this.作成日時 = 作成日時;
    }

    @Override
    public void writeBy(ReportSourceWriter<SeikyugakuTsuchishoSource> writer) {
        if (null == 帳票出力対象データリスト || 帳票出力対象データリスト.isEmpty()) {
            return;
        }
        for (int index = 0; index < 帳票出力対象データリスト.size(); index++) {
            writeLine(writer, 帳票出力対象データリスト.get(index));

        }

    }

    private void writeLine(ReportSourceWriter<SeikyugakuTsuchishoSource> writer,
            DbWT1511SeikyugakuTsuchishoTempEntity 帳票出力対象データ) {
        ISeikyugakuTsuchishoInEditor headerEditor
                = new SeikyugakuTsuchishoInHeaderEditor(
                        帳票出力対象データ, 作成日時);
        ISeikyugakuTsuchishoInEditor bodyEditor
                = new SeikyugakuTsuchishoInBodyEditor(帳票出力対象データ);
        ISeikyugakuTsuchishoInBuilder builder
                = new SeikyugakuTsuchishoInBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }

}
