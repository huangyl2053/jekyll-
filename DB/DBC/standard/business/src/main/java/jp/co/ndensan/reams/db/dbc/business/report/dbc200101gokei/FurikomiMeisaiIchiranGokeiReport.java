/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200101gokei;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.hurikomiitiran.gokeidata.GokeiDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200101gokei.FurikomiMeisaiIchiranGokeiReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 振込明細一覧表（合計）のReportです。
 *
 * @reamsid_L DBC-2180-040 b_liuyang2
 */
public final class FurikomiMeisaiIchiranGokeiReport extends Report<FurikomiMeisaiIchiranGokeiReportSource> {

    private final GokeiDataEntity 合計データリスト;
    private final IOutputOrder 出力順;
    private final RString 設定値;
    private final RDateTime 作成日時;

    /**
     * インスタンスを生成します。
     *
     * @param 合計データリスト GokeiDataEntity
     * @param 出力順 IOutputOrder
     * @param 設定値 RString
     * @param 作成日時 RDateTime
     */
    public FurikomiMeisaiIchiranGokeiReport(GokeiDataEntity 合計データリスト, IOutputOrder 出力順,
            RString 設定値, RDateTime 作成日時) {
        this.合計データリスト = 合計データリスト;
        this.出力順 = 出力順;
        this.設定値 = 設定値;
        this.作成日時 = 作成日時;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<FurikomiMeisaiIchiranGokeiReportSource> writer) {
        IFurikomiMeisaiIchiranGokeiEditor bodyEditor = new FurikomiMeisaiIchiranGokeiEditor(合計データリスト, 出力順, 設定値, 作成日時);
        IFurikomiMeisaiIchiranGokeiBuilder builder = new FurikomiMeisaiIchiranGokeiBuilder(bodyEditor);
        writer.writeLine(builder);
    }

}
