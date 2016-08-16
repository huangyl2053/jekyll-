/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohiSeikyugakuTsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.dbc120890.SogojigyohiSeikyugakuTsuchishoInSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 総合事業費等請求額通知書帳票Report
 *
 * @reamsid_L DBC-2480-032 sunqingzhu
 */
public class SogojigyohiSeikyugakuTsuchishoInReport extends Report<SogojigyohiSeikyugakuTsuchishoInSource> {

    private final DbWT1511SeikyugakuTsuchishoTempEntity 帳票出力対象データ;
    private final RDateTime 作成日時;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データリスト DbWT1511SeikyugakuTsuchishoTempEntity
     * @param 作成日時 RDateTime
     */
    public SogojigyohiSeikyugakuTsuchishoInReport(
            DbWT1511SeikyugakuTsuchishoTempEntity 帳票出力対象データ,
            RDateTime 作成日時) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.作成日時 = 作成日時;
    }

    @Override
    public void writeBy(ReportSourceWriter<SogojigyohiSeikyugakuTsuchishoInSource> reportSourceWriter) {

        ISogojigyohiSeikyugakuTsuchishoInEditor headerEditor
                = new SogojigyohiSeikyugakuTsuchishoInHeaderEditor(
                        帳票出力対象データ, 作成日時);
        ISogojigyohiSeikyugakuTsuchishoInEditor bodyEditor
                = new SogojigyohiSeikyugakuTsuchishoInBodyEditor(帳票出力対象データ);
        ISogojigyohiSeikyugakuTsuchishoInBuilder builder
                = new SogojigyohiSeikyugakuTsuchishoInBuilder(headerEditor, bodyEditor);
        reportSourceWriter.writeLine(builder);
    }

}
