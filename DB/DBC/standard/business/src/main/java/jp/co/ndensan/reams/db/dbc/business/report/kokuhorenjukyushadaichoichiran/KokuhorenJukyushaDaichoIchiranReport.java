/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kokuhorenjukyushadaichoichiran;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain.DbWT0001DbWT5331Entity;
import jp.co.ndensan.reams.db.dbc.entity.report.jukyushakoshinkekkaichiran.JukyushaKoshinkekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票設計_DBC200006_受給者台帳（一覧表）Reportのインターフェースクラスです。
 *
 * @reamsid_L DBC-2740-010 fuyanling
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokuhorenJukyushaDaichoIchiranReport extends Report<JukyushaKoshinkekkaIchiranSource> {

    private final List<DbWT0001DbWT5331Entity> 帳票出力対象データリスト;
    private final Map<RString, RString> 出力順Map;
    private final RDateTime 作成日時;
    private final List<RString> 住所List;
    private final List<RString> 改頁リスト;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データリスト List<DbWT0001DbWT5331Entity>
     * @param 出力順Map Map<RString, RString>
     * @param 作成日時 RDateTime
     * @param 住所List List<RString>
     * @param 改頁リスト List<RString>
     */
    public KokuhorenJukyushaDaichoIchiranReport(
            List<DbWT0001DbWT5331Entity> 帳票出力対象データリスト,
            Map<RString, RString> 出力順Map, RDateTime 作成日時, List<RString> 住所List, List<RString> 改頁リスト) {
        this.帳票出力対象データリスト = 帳票出力対象データリスト;
        this.出力順Map = 出力順Map;
        this.作成日時 = 作成日時;
        this.住所List = 住所List;
        this.改頁リスト = 改頁リスト;
    }

    @Override
    public void writeBy(ReportSourceWriter<JukyushaKoshinkekkaIchiranSource> reportSourceWriter) {
        IKokuhoernJukyushaDaichoIchiranEditor headerEditor = null;
        if (null != 帳票出力対象データリスト && 帳票出力対象データリスト.size() > 0) {
            headerEditor
                    = new KokuhorenJukyushaDaichoIchiranHeaderEditor(帳票出力対象データリスト.get(0),
                            出力順Map, 改頁リスト, 作成日時);
        }
        for (int i = 0; i < 帳票出力対象データリスト.size(); i++) {
            IKokuhoernJukyushaDaichoIchiranEditor bodyEditor
                    = new KokuhorenJukyushaDaichoIchiranBodyEditor(帳票出力対象データリスト.get(i), 住所List.get(i));
            IKokuhorenJukyushaDaichoIchiranBuilder builder
                    = new KokuhorenJukyushaDaichoIchiranBuilder(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
