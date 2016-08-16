/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.seikyugakutsuchishoin;

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

    private final DbWT1511SeikyugakuTsuchishoTempEntity 帳票出力対象データ;
    private final RDateTime 作成日時;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ DbWT1511SeikyugakuTsuchishoTempEntity
     * @param 作成日時 RDateTime
     */
    public SeikyugakuTsuchishoInReport(
            DbWT1511SeikyugakuTsuchishoTempEntity 帳票出力対象データ,
            RDateTime 作成日時) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.作成日時 = 作成日時;
    }

    @Override
    public void writeBy(ReportSourceWriter<SeikyugakuTsuchishoSource> reportSourceWriter) {
        ISeikyugakuTsuchishoInEditor headerEditor = new SeikyugakuTsuchishoInHeaderEditor(
                帳票出力対象データ, 作成日時);
        ISeikyugakuTsuchishoInEditor bodyEditor = new SeikyugakuTsuchishoInBodyEditor(帳票出力対象データ);
        ISeikyugakuTsuchishoInBuilder builder = new SeikyugakuTsuchishoInBuilder(headerEditor, bodyEditor);
        reportSourceWriter.writeLine(builder);
    }
}
