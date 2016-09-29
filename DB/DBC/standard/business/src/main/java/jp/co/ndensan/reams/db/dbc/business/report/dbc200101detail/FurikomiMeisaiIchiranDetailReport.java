/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200101detail;

import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShihraiHohoShitei;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hurikomiitiran.meisaidata.MeisaiDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200101detail.FurikomiMeisaiIchiranDetailReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 振込明細一覧表（明細）のReportです。
 *
 * @reamsid_L DBC-2180-050 b_liuyang2
 */
public final class FurikomiMeisaiIchiranDetailReport extends Report<FurikomiMeisaiIchiranDetailReportSource> {

    private final MeisaiDataEntity 一覧表用データ;
    private final IOutputOrder 出力順;
    private final Furikomi_ShihraiHohoShitei 支払方法;
    private final RDateTime 作成日時;
    private final RString 設定値;

    /**
     * インスタンスを生成します。
     *
     * @param 一覧表用データ MeisaiDataEntity
     * @param 出力順 IOutputOrder
     * @param 支払方法 Furikomi_ShihraiHohoShitei
     * @param 作成日時 RDateTime
     * @param 設定値 RString
     */
    public FurikomiMeisaiIchiranDetailReport(MeisaiDataEntity 一覧表用データ, IOutputOrder 出力順,
            Furikomi_ShihraiHohoShitei 支払方法, RDateTime 作成日時, RString 設定値) {
        this.一覧表用データ = 一覧表用データ;
        this.出力順 = 出力順;
        this.支払方法 = 支払方法;
        this.作成日時 = 作成日時;
        this.設定値 = 設定値;
    }

    private static final int 連番空白 = 0;
    private static final int 様式連番_1 = 1;
    private static int 前件様式連番 = -1;

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<FurikomiMeisaiIchiranDetailReportSource> writer) {

        if (様式連番_1 == 一覧表用データ.get様式連番() && is様式連番_偶数(前件様式連番)) {
            前件様式連番 = 0;

            IFurikomiMeisaiIchiranDetailEditor bodyEditor
                    = new FurikomiMeisaiIchiranDetailEditor(一覧表用データ, 出力順, 支払方法, 作成日時, 設定値, true);
            IFurikomiMeisaiIchiranDetailBuilder builder = new FurikomiMeisaiIchiranDetailBuilder(bodyEditor);
            writer.writeLine(builder);
        }
        IFurikomiMeisaiIchiranDetailEditor bodyEditor
                = new FurikomiMeisaiIchiranDetailEditor(一覧表用データ, 出力順, 支払方法, 作成日時, 設定値, false);
        IFurikomiMeisaiIchiranDetailBuilder builder = new FurikomiMeisaiIchiranDetailBuilder(bodyEditor);
        writer.writeLine(builder);

        前件様式連番 = 一覧表用データ.get様式連番();
    }

    private boolean is様式連番_偶数(int 様式連番) {
        return 連番空白 == (様式連番 % 2);
    }
}
