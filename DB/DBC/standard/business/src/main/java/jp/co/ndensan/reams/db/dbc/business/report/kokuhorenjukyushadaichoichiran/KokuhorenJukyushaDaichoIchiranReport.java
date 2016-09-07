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

    private final DbWT0001DbWT5331Entity 帳票出力対象データ;
    private final Map<RString, RString> 出力順Map;
    private final RDateTime 作成日時;
    private final RString 住所;
    private final List<RString> 改頁リスト;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ DbWT0001DbWT5331Entity
     * @param 出力順Map Map<RString, RString>
     * @param 作成日時 RDateTime
     * @param 住所 RString
     * @param 改頁リスト List<RString>
     */
    public KokuhorenJukyushaDaichoIchiranReport(
            DbWT0001DbWT5331Entity 帳票出力対象データ,
            Map<RString, RString> 出力順Map, RDateTime 作成日時, RString 住所, List<RString> 改頁リスト) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.出力順Map = 出力順Map;
        this.作成日時 = 作成日時;
        this.住所 = 住所;
        this.改頁リスト = 改頁リスト;
    }

    @Override
    public void writeBy(ReportSourceWriter<JukyushaKoshinkekkaIchiranSource> reportSourceWriter) {
        IKokuhoernJukyushaDaichoIchiranEditor headerEditor
                = new KokuhorenJukyushaDaichoIchiranHeaderEditor(帳票出力対象データ,
                        出力順Map, 改頁リスト, 作成日時);

        IKokuhoernJukyushaDaichoIchiranEditor bodyEditor
                = new KokuhorenJukyushaDaichoIchiranBodyEditor(帳票出力対象データ, 住所);
        IKokuhorenJukyushaDaichoIchiranBuilder builder
                = new KokuhorenJukyushaDaichoIchiranBuilder(headerEditor, bodyEditor);
        reportSourceWriter.writeLine(builder);

    }
}
