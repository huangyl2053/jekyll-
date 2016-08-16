/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushakoshinkekkaichiran;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushajoho.JukyushaHihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushakoshinkekkaichiran.JukyushaKoshinKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 受給者情報更新結果情報取込一覧表帳票Report
 *
 * @reamsid_L DBC-2730-030 chenjie
 */
public class JukyushaKoshinKekkaIchiranReport extends Report<JukyushaKoshinKekkaIchiranSource> {

    private final JukyushaHihokenshaEntity 帳票出力対象データ;
    private final RString 住所;
    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁リスト;
    private final RDateTime 作成日時;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ JukyushaKoshinKekkaIchiranSource
     * @param 住所 RString
     * @param 出力順Map Map<RString, RString>
     * @param 改頁リスト List<RString>
     * @param 作成日時 RDateTime
     */
    public JukyushaKoshinKekkaIchiranReport(
            JukyushaHihokenshaEntity 帳票出力対象データ, RString 住所,
            Map<RString, RString> 出力順Map, List<RString> 改頁リスト, RDateTime 作成日時) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.住所 = 住所; 
        this.出力順Map = 出力順Map;
        this.改頁リスト = 改頁リスト;
        this.作成日時 = 作成日時;
    }

    @Override
    public void writeBy(ReportSourceWriter<JukyushaKoshinKekkaIchiranSource> writer) {
        if (null == this.帳票出力対象データ) {
            return;
        }
        writeLine(writer, this.帳票出力対象データ, this.住所);

    }

    /**
     * 
     * @param writer ReportSourceWriter<JukyushaKoshinKekkaIchiranSource>
     * @param 帳票出力対象データ JukyushaHihokenshaEntity
     * @param 住所情報 RString
     */
    private void writeLine(ReportSourceWriter<JukyushaKoshinKekkaIchiranSource> writer,
            JukyushaHihokenshaEntity 帳票出力対象データ, RString 住所情報) {
        IJukyushaKoshinKekkaIchiranEditor headerEditor
                = new JukyushaKoshinKekkaIchiranHeaderEditor(
                        帳票出力対象データ, 出力順Map, 改頁リスト, 作成日時);
        IJukyushaKoshinKekkaIchiranEditor bodyEditor
                = new JukyushaKoshinKekkaIchiranBodyEditor(帳票出力対象データ, 住所情報);
        IJukyushaKoshinKekkaIchiranBuilder builder
                = new JukyushaKoshinKekkaIchiranBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }

}
