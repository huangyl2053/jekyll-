/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200074;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200074.JukyushaIdoRirekiTeiseiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200074.JukyushaIdoRirekiTeiseiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMNF1001_1_国保連受給者異動情報履歴訂正リストReport
 *
 * @reamsid_L DBC-2720-050 jiangxiaolong
 */
public class JukyushaIdoRirekiTeiseiIchiranReport
        extends Report<JukyushaIdoRirekiTeiseiIchiranSource> {

    private final JukyushaIdoRirekiTeiseiIchiranEntity 帳票出力対象データ;
    private final RString 市町村コード;
    private final RString 市町村名称;

    /**
     *
     * @param 帳票出力対象データ JukyushaIdoRirekiTeiseiIchiranEntity
     * @param 市町村コード RString
     * @param 市町村名称 RString
     */
    public JukyushaIdoRirekiTeiseiIchiranReport(
            JukyushaIdoRirekiTeiseiIchiranEntity 帳票出力対象データ,
            RString 市町村コード, RString 市町村名称) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
    }

    @Override
    public void writeBy(ReportSourceWriter<JukyushaIdoRirekiTeiseiIchiranSource> writer) {
        writeLine(writer, 帳票出力対象データ);
    }

    private void writeLine(ReportSourceWriter<JukyushaIdoRirekiTeiseiIchiranSource> writer,
            JukyushaIdoRirekiTeiseiIchiranEntity 帳票出力対象データ) {
        IJukyushaIdoRirekiTeiseiIchiranEditor bodyEditor
                = new JukyushaIdoRirekiTeiseiIchiranEditor(帳票出力対象データ, 市町村コード, 市町村名称);
        IJukyushaIdoRirekiTeiseiIchiranBuilder builder
                = new JukyushaIdoRirekiTeiseiIchiranBuilder(bodyEditor);
        writer.writeLine(builder);
    }
}
