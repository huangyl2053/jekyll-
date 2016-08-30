/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikohijukyusha;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 総合事業費公費受給者別一覧表帳票Report。
 *
 * @reamsid_L DBC-4710-040 chenjie
 */
public class SogojigyohiKohiJukyushaReport extends
        Report<SogojigyohiKohiJukyushaSource> {

    private final SogojigyohiKohiJukyushaEntity 帳票出力対象データ;
    private final boolean 集計Flag;
    private final RDateTime 作成日時;
    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁リスト;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ SogojigyohiKagoKetteiInEntity
     * @param 集計Flag boolean
     * @param 作成日時 RDateTime
     * @param 出力順Map Map<RString, RString>
     * @param 改頁リスト List<RString>
     */
    public SogojigyohiKohiJukyushaReport(SogojigyohiKohiJukyushaEntity 帳票出力対象データ,
            boolean 集計Flag, RDateTime 作成日時, Map<RString, RString> 出力順Map, List<RString> 改頁リスト) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.集計Flag = 集計Flag;
        this.作成日時 = 作成日時;
        this.出力順Map = 出力順Map;
        this.改頁リスト = 改頁リスト;
    }

    @Override
    public void writeBy(ReportSourceWriter<SogojigyohiKohiJukyushaSource> writer) {
        writeLine(writer);
    }

    private void writeLine(ReportSourceWriter<SogojigyohiKohiJukyushaSource> writer) {
        ISogojigyohiKohiJukyushaEditor headerEditor
                = new SogojigyohiKohiJukyushaHeadEditor(帳票出力対象データ, 出力順Map, 作成日時, 改頁リスト);
        ISogojigyohiKohiJukyushaEditor bodyEditor
                = new SogojigyohiKohiJukyushaBodyEditor(帳票出力対象データ, 集計Flag);
        ISogojigyohiKohiJukyushaBuilder builder
                = new SogojigyohiKohiJukyushaBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }
}
