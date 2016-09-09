/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200010.JukyushaIdorenrakuhyoSofuTaishoshachiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200010.JukyushaIdorenrakuhyoSofuTaishoshachiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMNF1001_1_受給者異動連絡票情報送付対象者リストReport
 *
 * @reamsid_L DBC-2720-040 jiangxiaolong
 */
public class JukyushaIdorenrakuhyoSofuTaishoshachiranReport
        extends Report<JukyushaIdorenrakuhyoSofuTaishoshachiranSource> {

    private final JukyushaIdorenrakuhyoSofuTaishoshachiranEntity 帳票出力対象データ;
    private final RString 市町村コード;
    private final RString 市町村名称;

    /**
     *
     * @param 帳票出力対象データ JukyushaIdorenrakuhyoSofuTaishoshachiranEntity
     * @param 市町村コード RString
     * @param 市町村名称 RString
     */
    public JukyushaIdorenrakuhyoSofuTaishoshachiranReport(
            JukyushaIdorenrakuhyoSofuTaishoshachiranEntity 帳票出力対象データ,
            RString 市町村コード, RString 市町村名称) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
    }

    @Override
    public void writeBy(ReportSourceWriter<JukyushaIdorenrakuhyoSofuTaishoshachiranSource> writer) {
        writeLine(writer, 帳票出力対象データ);
    }

    private void writeLine(ReportSourceWriter<JukyushaIdorenrakuhyoSofuTaishoshachiranSource> writer,
            JukyushaIdorenrakuhyoSofuTaishoshachiranEntity 帳票出力対象データ) {
        IJukyushaIdorenrakuhyoSofuTaishoshachiranEditor bodyEditor
                = new JukyushaIdorenrakuhyoSofuTaishoshachiranEditor(帳票出力対象データ, 市町村コード, 市町村名称);
        IJukyushaIdorenrakuhyoSofuTaishoshachiranBuilder builder
                = new JukyushaIdorenrakuhyoSofuTaishoshachiranBuilder(bodyEditor);
        writer.writeLine(builder);
    }
}
