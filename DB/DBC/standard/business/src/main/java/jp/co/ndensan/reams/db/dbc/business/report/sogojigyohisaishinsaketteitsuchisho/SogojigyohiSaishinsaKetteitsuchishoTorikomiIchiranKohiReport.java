/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohisaishinsaketteitsuchisho;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohisaishinsaketteitsuchisho.SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohisaishin.SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200081_総合事業費再審査決定通知書情報取込一覧表（公費）Reportのインターフェースクラスです。
 *
 * @reamsid_L DBC-4730-040 liuxiaoyu
 */
public class SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiReport
        extends Report<SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource> {

    private final SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity 帳票出力対象データ;
    private final Map<RString, RString> 出力順Map;
    private final FlexibleYearMonth 処理年月;
    private final RDateTime 作成日時;
    private final boolean 集計Flag;
    private boolean データFlag = false;
    private final int 連番;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票出力対象データ SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity
     * @param 出力順Map Map<RString, RString>
     * @param 処理年月 FlexibleDate
     * @param 作成日時 RDateTime
     * @param 集計Flag boolean
     * @param 連番 int
     * @param データFlag boolean
     */
    public SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiReport(
            SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEntity 帳票出力対象データ,
            Map<RString, RString> 出力順Map,
            FlexibleYearMonth 処理年月,
            RDateTime 作成日時,
            boolean 集計Flag,
            int 連番,
            boolean データFlag
    ) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.出力順Map = 出力順Map;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
        this.集計Flag = 集計Flag;
        this.連番 = 連番;
        this.データFlag = データFlag;
    }

    @Override
    public void writeBy(ReportSourceWriter<SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource> reportSourceWriter
    ) {

        ISogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEditor headerEditor = new SogojigyohiSaishinsaKetteitsuchishoHeaderEditor(
                帳票出力対象データ, 出力順Map, 処理年月, 作成日時);
        ISogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEditor bodyEditor = new SogojigyohiSaishinsaKetteitsuchishoBodyEditor(
                帳票出力対象データ, 集計Flag, 連番, データFlag);
        ISogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiBuilder builder = new SogojigyohiSaishinsaKetteitsuchishoBuilder(
                headerEditor, bodyEditor);
        reportSourceWriter.writeLine(builder);

    }
}
