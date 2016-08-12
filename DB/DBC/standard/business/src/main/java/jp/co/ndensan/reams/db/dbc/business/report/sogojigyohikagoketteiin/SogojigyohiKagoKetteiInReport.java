/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteiin;

import java.util.List;
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
 * @reamsid_L DBC-2550-010 fzou
 */
public class SogojigyohiKagoKetteiInReport extends
        Report<SogojigyohiKagoKetteiInSource> {

    private final List<SogojigyohiKagoKetteiInEntity> 帳票出力対象データリスト;
    private final Map<RString, RString> 出力順Map;
    private final FlexibleYearMonth 処理年月;
    private final RDateTime 作成日時;

    public SogojigyohiKagoKetteiInReport(List<SogojigyohiKagoKetteiInEntity> 帳票出力対象データリスト,
            Map<RString, RString> 出力順Map, FlexibleYearMonth 処理年月, RDateTime 作成日時) {
        this.帳票出力対象データリスト = 帳票出力対象データリスト;
        this.出力順Map = 出力順Map;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
    }

    @Override
    public void writeBy(ReportSourceWriter<SogojigyohiKagoKetteiInSource> writer) {
        if (null == 帳票出力対象データリスト || 帳票出力対象データリスト.isEmpty()) {
            return;
        }
        for (int index = 0; index < 帳票出力対象データリスト.size(); index++) {
            boolean 集計Flag = false;
            if (RString.isNullOrEmpty(帳票出力対象データリスト.get(index).get証記載保険者番号().getColumnValue())) {
                集計Flag = true;
            }
            if (index == 帳票出力対象データリスト.size() - 1) {
                集計Flag = true;
            }
            writeLine(writer, 帳票出力対象データリスト.get(index), 集計Flag);
        }
    }

    private void writeLine(ReportSourceWriter<SogojigyohiKagoKetteiInSource> writer,
            SogojigyohiKagoKetteiInEntity 帳票出力対象データ, boolean 集計Flag) {
        SogojigyohiKagoKetteiInHeaderEditor headerEditor
                = new SogojigyohiKagoKetteiInHeaderEditor(帳票出力対象データ, 出力順Map, 処理年月, 作成日時);
        SogojigyohiKagoKetteiInBodyEditor bodyEditor
                = new SogojigyohiKagoKetteiInBodyEditor(帳票出力対象データ, 集計Flag);
        ISogojigyohiKagoKetteiInBuilder builder
                = new SogojigyohiKagoKetteiInBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }
}
