/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteikohifutansha;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushajoho.JukyushaHihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohikagoketteikohifutansha.SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 総合事業費過誤決定通知書情報取込（公費負担者分）一覧表帳票Report
 *
 * @reamsid_L DBC-2810-030 chenjie
 */
public class SogojigyohiKagoKetteitsuchishoTorikomiIchiranReport extends Report<SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource> {

    private final JukyushaHihokenshaEntity 帳票出力対象データ;
    private final RString 住所;
    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁リスト;
    private final RDateTime 作成日時;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource
     * @param 住所 RString
     * @param 出力順Map Map<RString, RString>
     * @param 改頁リスト List<RString>
     * @param 作成日時 RDateTime
     */
    public SogojigyohiKagoKetteitsuchishoTorikomiIchiranReport(
            JukyushaHihokenshaEntity 帳票出力対象データ, RString 住所,
            Map<RString, RString> 出力順Map, List<RString> 改頁リスト, RDateTime 作成日時) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.住所 = 住所; 
        this.出力順Map = 出力順Map;
        this.改頁リスト = 改頁リスト;
        this.作成日時 = 作成日時;
    }

    @Override
    public void writeBy(ReportSourceWriter<SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource> writer) {
        if (null == this.帳票出力対象データ) {
            return;
        }
        writeLine(writer, this.帳票出力対象データ, this.住所);

    }

    /**
     * 
     * @param writer ReportSourceWriter<SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource>
     * @param 帳票出力対象データ JukyushaHihokenshaEntity
     * @param 住所情報 RString
     */
    private void writeLine(ReportSourceWriter<SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource> writer,
            JukyushaHihokenshaEntity 帳票出力対象データ, RString 住所情報) {
//        ISogojigyohiKagoKetteiKohifutanshaInEditor headerEditor
//                = new SogojigyohiKagoKetteiInHeaderEditor(
//                        帳票出力対象データ, 出力順Map, 改頁リスト, 作成日時);
//        ISogojigyohiKagoKetteiKohifutanshaInEditor bodyEditor
//                = new SogojigyohiKagoKetteiInBodyEditor(帳票出力対象データ, 住所情報);
//        ISogojigyohiKagoKetteiKohifutanshaInEditor builder
//                = new SogojigyohiKagoKetteiInBuilder(headerEditor, bodyEditor);
//        writer.writeLine(builder);
    }

}
