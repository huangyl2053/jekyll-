/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiseikyugakutsuchishokeikasochi;

import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohiseidoichiranhyosakusei.SogojigyohiSeikyugakuTsuchishoKeikaSochiSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 総合事業費（経過措置）請求額通知書一覧表帳票Reportクラスです。
 *
 * @reamsid_L DBC-2480-031 jiangxiaolong
 */
public class SogojigyohiSeikyugakuTsuchishoKeikaSochiReport extends Report<SogojigyohiSeikyugakuTsuchishoKeikaSochiSource> {

    private final DbWT1511SeikyugakuTsuchishoTempEntity 帳票出力対象;
    private final RDateTime 作成日時;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象 DbWT1511SeikyugakuTsuchishoTempEntity
     * @param 作成日時 RDateTime
     */
    public SogojigyohiSeikyugakuTsuchishoKeikaSochiReport(
            DbWT1511SeikyugakuTsuchishoTempEntity 帳票出力対象,
            RDateTime 作成日時) {
        this.帳票出力対象 = 帳票出力対象;
        this.作成日時 = 作成日時;
    }

    @Override
    public void writeBy(ReportSourceWriter<SogojigyohiSeikyugakuTsuchishoKeikaSochiSource> writer) {
        ISogojigyohiSeikyugakuTsuchishoKeikaSochiEditor headerEditor
                = new SogojigyohiSeikyugakuTsuchishoKeikaSochiHeaderEditor(
                        帳票出力対象, 作成日時);
        ISogojigyohiSeikyugakuTsuchishoKeikaSochiEditor bodyEditor
                = new SogojigyohiSeikyugakuTsuchishoKeikaSochiBodyEditor(帳票出力対象);
        ISogojigyohiSeikyugakuTsuchishoKeikaSochiBuilder builder
                = new SogojigyohiSeikyugakuTsuchishoKeikaSochiBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }

}
