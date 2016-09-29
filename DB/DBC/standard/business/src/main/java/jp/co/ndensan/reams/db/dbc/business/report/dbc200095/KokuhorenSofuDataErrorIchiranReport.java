/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200095;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200095.KokuhorenSofuDataErrorIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200095.KokuhorenSofuDataErrorIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMNF1001_1_国保連送付データエラーリストReport
 *
 * @reamsid_L DBC-2720-060 jiangxiaolong
 */
public class KokuhorenSofuDataErrorIchiranReport
        extends Report<KokuhorenSofuDataErrorIchiranSource> {

    private final KokuhorenSofuDataErrorIchiranEntity 帳票出力対象データ;
    private final RString 市町村コード;
    private final RString 市町村名称;
    private final int 連番;

    /**
     *
     * @param 帳票出力対象データ KokuhorenSofuDataErrorIchiranEntity
     * @param 市町村コード RString
     * @param 市町村名称 RString
     * @param 連番 int
     */
    public KokuhorenSofuDataErrorIchiranReport(
            KokuhorenSofuDataErrorIchiranEntity 帳票出力対象データ, RString 市町村コード, RString 市町村名称, int 連番) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.連番 = 連番;
    }

    @Override
    public void writeBy(ReportSourceWriter<KokuhorenSofuDataErrorIchiranSource> writer) {
        writeLine(writer, 帳票出力対象データ);
    }

    private void writeLine(ReportSourceWriter<KokuhorenSofuDataErrorIchiranSource> writer,
            KokuhorenSofuDataErrorIchiranEntity 帳票出力対象データ) {
        IKokuhorenSofuDataErrorIchiranEditor bodyEditor
                = new KokuhorenSofuDataErrorIchiranEditor(帳票出力対象データ, 市町村コード, 市町村名称, 連番);
        IKokuhorenSofuDataErrorIchiranBuilder builder
                = new KokuhorenSofuDataErrorIchiranBuilder(bodyEditor);
        writer.writeLine(builder);
    }
}
