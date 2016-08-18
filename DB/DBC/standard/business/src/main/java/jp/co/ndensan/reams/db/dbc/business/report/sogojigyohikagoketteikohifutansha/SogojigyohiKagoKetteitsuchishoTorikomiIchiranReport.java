/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteikohifutansha;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagoketteikohifutansha.SogoKohifutanshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohikagoketteikohifutansha.SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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

    private final SogoKohifutanshaEntity 帳票出力対象データ;
    private final boolean 集計flag;
    private final Map<RString, RString> 出力順Map;
    private final RDateTime 作成日時;
    private final FlexibleYearMonth 処理年月;
    private int 連番;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource
     * @param 出力順Map Map<RString, RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 集計flag boolean
     * @param 連番 int
     */
    public SogojigyohiKagoKetteitsuchishoTorikomiIchiranReport(
            SogoKohifutanshaEntity 帳票出力対象データ, Map<RString, RString> 出力順Map, FlexibleYearMonth 処理年月, RDateTime 作成日時, boolean 集計flag, int 連番) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.出力順Map = 出力順Map;
        this.作成日時 = 作成日時;
        this.処理年月 = 処理年月;
        this.集計flag = 集計flag;
        this.連番 = 連番;
    }

    @Override
    public void writeBy(ReportSourceWriter<SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource> writer) {
        if (null == this.帳票出力対象データ) {
            return;
        }
        writeLine(writer, this.帳票出力対象データ);

    }

    /**
     *
     * @param writer
     * ReportSourceWriter<SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource>
     * @param 帳票出力対象データ SogoKohifutanshaEntity
     */
    private void writeLine(ReportSourceWriter<SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource> writer,
            SogoKohifutanshaEntity 帳票出力対象データ) {
        ISogojigyohiKagoKetteitsuchishoTorikomiEditor headerEditor
                = new SogojigyohiKagoKetteitsuchishoTorikomiHeaderEditor(
                        帳票出力対象データ, 出力順Map, 処理年月, 作成日時);
        ISogojigyohiKagoKetteitsuchishoTorikomiEditor bodyEditor
                = new SogojigyohiKagoKetteitsuchishoTorikomiBodyEditor(帳票出力対象データ, 集計flag, 連番);
        ISogojigyohiKagoKetteitsuchishoTorikomiBuilder builder
                = new SogojigyohiKagoKetteitsuchishoTorikomiBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }

}
