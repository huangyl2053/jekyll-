/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200040;

import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteitsuchisho.KogakugassanShikyuKetteiTsuchiIchiran;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200040.GassanShikyuFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額合算支給決定者一覧表Report
 *
 * @reamsid_L DBC-2300-045 jiangxiaolong
 */
public class GassanShikyuFushikyuKetteishaIchiranReport
        extends Report<GassanShikyuFushikyuKetteishaIchiranSource> {

    private final KogakugassanShikyuKetteiTsuchiIchiran 帳票出力対象データ;
    private final YMDHMS 作成日時;
    private final boolean 集計Flag;
    private final GassanShikyuFushikyuKetteishaIchiranParameter paramter;
    private final RString 内部帳票文字切れ制御;
    private static final int INT_14 = 14;

    /**
     *
     * @param 帳票出力対象データ KogakugassanShikyuKetteiTsuchiIchiran
     * @param 作成日時 YMDHMS
     * @param 集計Flag boolean
     * @param paramter GassanShikyuFushikyuKetteishaIchiranParameter
     * @param 内部帳票文字切れ制御 RString
     */
    public GassanShikyuFushikyuKetteishaIchiranReport(
            KogakugassanShikyuKetteiTsuchiIchiran 帳票出力対象データ,
            YMDHMS 作成日時, boolean 集計Flag, GassanShikyuFushikyuKetteishaIchiranParameter paramter,
            RString 内部帳票文字切れ制御) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.作成日時 = 作成日時;
        this.集計Flag = 集計Flag;
        this.paramter = paramter;
        this.内部帳票文字切れ制御 = 内部帳票文字切れ制御;
    }

    @Override
    public void writeBy(ReportSourceWriter<GassanShikyuFushikyuKetteishaIchiranSource> writer) {
        if (集計Flag) {
            if (帳票出力対象データ.get履歴番号() == INT_14) {
                writeLine(writer, null, true);
            }
            writeLine(writer, null, true);
            writeLine(writer, 帳票出力対象データ, true);
        } else {
            writeLine(writer, 帳票出力対象データ, false);
        }
    }

    private void writeLine(ReportSourceWriter<GassanShikyuFushikyuKetteishaIchiranSource> writer,
            KogakugassanShikyuKetteiTsuchiIchiran 帳票出力対象データ, boolean 集計Flag) {
        IGassanShikyuFushikyuKetteishaIchiranEditor headerEditor
                = new GassanShikyuFushikyuKetteishaIchiranHeaderEditor(帳票出力対象データ, 作成日時, paramter);
        IGassanShikyuFushikyuKetteishaIchiranEditor bodyEditor
                = new GassanShikyuFushikyuKetteishaIchiranBodyEditor(帳票出力対象データ, 集計Flag, paramter, 内部帳票文字切れ制御);
        IGassanShikyuFushikyuKetteishaIchiranBuilder builder
                = new GassanShikyuFushikyuKetteishaIchiranBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }

}
