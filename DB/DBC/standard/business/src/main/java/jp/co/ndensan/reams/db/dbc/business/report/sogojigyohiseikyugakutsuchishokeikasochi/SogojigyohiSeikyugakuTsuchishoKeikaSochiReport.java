/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiseikyugakutsuchishokeikasochi;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.SogojigyohiSeiDoIchiranhyoSakusei.SogojigyohiSeikyugakuTsuchishoKeikaSochiSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 総合事業費（経過措置）請求額通知書一覧表帳票Report
 *
 * @reamsid_L DBC-2480-031 jiangxiaolong
 */
public class SogojigyohiSeikyugakuTsuchishoKeikaSochiReport extends Report<SogojigyohiSeikyugakuTsuchishoKeikaSochiSource> {

    private final List<DbWT1511SeikyugakuTsuchishoTempEntity> 帳票出力対象データリスト;
    private final RDateTime 作成日時;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データリスト List<DbWT1511SeikyugakuTsuchishoTempEntity>
     * @param 作成日時 RDateTime
     */
    public SogojigyohiSeikyugakuTsuchishoKeikaSochiReport(
            List<DbWT1511SeikyugakuTsuchishoTempEntity> 帳票出力対象データリスト,
            RDateTime 作成日時) {
        this.帳票出力対象データリスト = 帳票出力対象データリスト;
        this.作成日時 = 作成日時;
    }

    @Override
    public void writeBy(ReportSourceWriter<SogojigyohiSeikyugakuTsuchishoKeikaSochiSource> writer) {
        if (null == 帳票出力対象データリスト || 帳票出力対象データリスト.isEmpty()) {
            return;
        }
        for (int index = 0; index < 帳票出力対象データリスト.size(); index++) {
            writeLine(writer, 帳票出力対象データリスト.get(index));
        }

    }

    private void writeLine(ReportSourceWriter<SogojigyohiSeikyugakuTsuchishoKeikaSochiSource> writer,
            DbWT1511SeikyugakuTsuchishoTempEntity 帳票出力対象データ) {
        ISogojigyohiSeikyugakuTsuchishoKeikaSochiEditor headerEditor
                = new SogojigyohiSeikyugakuTsuchishoKeikaSochiHeaderEditor(
                        帳票出力対象データ, 作成日時);
        ISogojigyohiSeikyugakuTsuchishoKeikaSochiEditor bodyEditor
                = new SogojigyohiSeikyugakuTsuchishoKeikaSochiBodyEditor(帳票出力対象データ);
        ISogojigyohiSeikyugakuTsuchishoKeikaSochiBuilder builder
                = new SogojigyohiSeikyugakuTsuchishoKeikaSochiBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }

}
