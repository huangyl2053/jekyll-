/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteiin;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagoketteiin.SogojigyohiKagoKetteiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohikagoketteiin.SogojigyohiKagoKetteiInSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 総合事業費（経過措置）過誤決定通知書情報取込一覧表帳票Report
 *
 * @reamsid_L DBC-2550-030　jianglaishen
 */
public class SogojigyohiKagoKetteiInReport extends
        Report<SogojigyohiKagoKetteiInSource> {

    private final SogojigyohiKagoKetteiInEntity 帳票出力対象データ;
    private final Map<RString, RString> 出力順Map;
    private final FlexibleYearMonth 処理年月;
    private final RDateTime 作成日時;
    private final int no;
    private final boolean 集計Flag;

     /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ SogojigyohiKagoKetteiInEntity
     * @param 出力順Map Map<RString, RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param no int
     * @param 集計Flag boolean
     */
    public SogojigyohiKagoKetteiInReport(SogojigyohiKagoKetteiInEntity 帳票出力対象データ,
            Map<RString, RString> 出力順Map, FlexibleYearMonth 処理年月, RDateTime 作成日時, int no, boolean 集計Flag) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.出力順Map = 出力順Map;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
        this.no = no;
        this.集計Flag = 集計Flag;
    }

    @Override
    public void writeBy(ReportSourceWriter<SogojigyohiKagoKetteiInSource> writer) {
        writeLine(writer, 帳票出力対象データ, 集計Flag, no);
    }

    private void writeLine(ReportSourceWriter<SogojigyohiKagoKetteiInSource> writer,
            SogojigyohiKagoKetteiInEntity 帳票出力対象データ, boolean 集計Flag, int no) {
        SogojigyohiKagoKetteiInHeaderEditor headerEditor
                = new SogojigyohiKagoKetteiInHeaderEditor(帳票出力対象データ, 出力順Map, 処理年月, 作成日時);
        SogojigyohiKagoKetteiInBodyEditor bodyEditor
                = new SogojigyohiKagoKetteiInBodyEditor(帳票出力対象データ, 集計Flag, no);
        ISogojigyohiKagoKetteiInBuilder builder
                = new SogojigyohiKagoKetteiInBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }
}
