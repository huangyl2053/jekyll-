/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc120840;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120840.SogojigyohiKagoKetteiHokenshaChohyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc120840.SogojigyohiKagoKetteiTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200085_総合事業費過誤決定通知書情報取込一覧表帳票Report
 *
 * @reamsid_L DBC-2550-031 jiangxiaolong
 */
public class SogojigyohiKagoKetteiHokenshaInReport
        extends Report<SogojigyohiKagoKetteiTorikomiIchiranSource> {

    private final SogojigyohiKagoKetteiHokenshaChohyoEntity 帳票出力対象データ;
    private final Map<RString, RString> 出力順Map;
    private final FlexibleYearMonth 処理年月;
    private final RDateTime 作成日時;
    private final int no;
    private final boolean 集計Flag;

    /**
     *
     * @param 帳票出力対象データ SogojigyohiKagoKetteiHokenshaChohyoEntity
     * @param 出力順Map Map<RString, RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param no int
     * @param 集計Flag boolean
     */
    public SogojigyohiKagoKetteiHokenshaInReport(
            SogojigyohiKagoKetteiHokenshaChohyoEntity 帳票出力対象データ,
            Map<RString, RString> 出力順Map, FlexibleYearMonth 処理年月, RDateTime 作成日時, int no, boolean 集計Flag) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.出力順Map = 出力順Map;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
        this.no = no;
        this.集計Flag = 集計Flag;
    }

    @Override
    public void writeBy(ReportSourceWriter<SogojigyohiKagoKetteiTorikomiIchiranSource> writer) {
        writeLine(writer, 帳票出力対象データ, 集計Flag, no);
    }

    private void writeLine(ReportSourceWriter<SogojigyohiKagoKetteiTorikomiIchiranSource> writer,
            SogojigyohiKagoKetteiHokenshaChohyoEntity 帳票出力対象データ, boolean 集計Flag, int no) {
        SogojigyohiKagoKetteiHokenshaHeaderEditor headerEditor
                = new SogojigyohiKagoKetteiHokenshaHeaderEditor(帳票出力対象データ, 出力順Map, 処理年月, 作成日時);
        SogojigyohiKagoKetteiHokenshaBodyEditor bodyEditor
                = new SogojigyohiKagoKetteiHokenshaBodyEditor(帳票出力対象データ, 集計Flag, no);
        ISogojigyohiKagoKetteiHokenshaBunBuilder builder
                = new SogojigyohiKagoKetteiHokenshaBunBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }

}
