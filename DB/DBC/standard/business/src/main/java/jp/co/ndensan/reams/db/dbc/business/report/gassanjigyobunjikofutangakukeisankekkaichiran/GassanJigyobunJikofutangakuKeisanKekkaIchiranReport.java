/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunjikofutangakukeisankekkaichiran;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanjigyobunjikofutangakukeisankekkaichiran.GassanJigyobunJikofutangakuKeisanKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanjigyobunjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 事業高額合算・事業分自己負担額計算結果一覧表帳票Reportクラスです
 *
 * @reamsid_L DBC-4790-040 jiangwenkai
 */
public class GassanJigyobunJikofutangakuKeisanKekkaIchiranReport extends Report<GassanJigyobunJikofutangakuKeisanKekkaIchiranSource> {

    private final GassanJikofutangakuKeisanKekkaIchiranEntity 帳票出力対象データ;
    private final Map<RString, RString> 出力順Map;
    private final Map<RString, RString> 改頁Map;
    private final RDateTime 作成日時;
    private final RString 市町村コード;
    private final RString 市町村名称;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ GassanJikofutangakuKeisanKekkaIchiranEntity
     * @param 出力順Map Map<RString, RString>
     * @param 改頁Map Map<RString, RString>
     * @param 作成日時 RDateTime
     * @param 市町村コード RString
     * @param 市町村名称 RString
     */
    public GassanJigyobunJikofutangakuKeisanKekkaIchiranReport(
            GassanJikofutangakuKeisanKekkaIchiranEntity 帳票出力対象データ,
            Map<RString, RString> 出力順Map,
            Map<RString, RString> 改頁Map,
            RDateTime 作成日時,
            RString 市町村コード,
            RString 市町村名称) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.出力順Map = 出力順Map;
        this.改頁Map = 改頁Map;
        this.作成日時 = 作成日時;
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
    }

    @Override
    public void writeBy(ReportSourceWriter<GassanJigyobunJikofutangakuKeisanKekkaIchiranSource> reportSourceWriter) {
        IGassanJigyobunJikofutangakuKeisanKekkaIchiranEditor headerEditor
                = new GassanJigyobunJikofutangakuKeisanKekkaIchiranHeaderEditor(出力順Map, 改頁Map, 作成日時, 市町村コード, 市町村名称);
        IGassanJigyobunJikofutangakuKeisanKekkaIchiranEditor bodyEditor = new GassanJigyobunJikofutangakuKeisanKekkaIchiranBodyEditor(帳票出力対象データ);
        IGassanJigyobunJikofutangakuKeisanKekkaIchiranBuilder builder
                = new GassanJigyobunJikofutangakuKeisanKekkaIchiranBuilder(headerEditor, bodyEditor);
        reportSourceWriter.writeLine(builder);
    }
}
