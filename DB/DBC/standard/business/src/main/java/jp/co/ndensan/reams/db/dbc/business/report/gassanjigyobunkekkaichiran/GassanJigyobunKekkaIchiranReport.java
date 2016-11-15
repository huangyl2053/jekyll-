/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunkekkaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.jigyobunshikyugakurenrakuhyo.JigyobunShikyugakuRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanjigyobunkekkaichiran.GassanJigyobunKekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMNN1004_事業分支給額計算 のReportクラスです。
 *
 * @reamsid_L DBC-4830-040 qinzhen
 */
public class GassanJigyobunKekkaIchiranReport
        extends Report<GassanJigyobunKekkaIchiranSource> {

    private final JigyobunShikyugakuRenrakuhyo entity;
    private final IOutputOrder 出力順情報;
    private final RString 自市町村コード;
    private final List<RString> breakItemIds;

    /**
     * コンストラクタです
     *
     * @param entity KogakuGassanDataEntity
     * @param 出力順情報 IOutputOrder
     * @param 自市町村コード RString
     * @param breakItemIds List<RString>
     */
    public GassanJigyobunKekkaIchiranReport(JigyobunShikyugakuRenrakuhyo entity, IOutputOrder 出力順情報, RString 自市町村コード,
            List<RString> breakItemIds) {
        this.entity = entity;
        this.出力順情報 = 出力順情報;
        this.自市町村コード = 自市町村コード;
        this.breakItemIds = breakItemIds;
    }

    @Override
    public void writeBy(ReportSourceWriter<GassanJigyobunKekkaIchiranSource> writer) {

        IGassanJigyobunKekkaIchiranEditor editor = new GassanJigyobunKekkaIchiranEditor(entity, 出力順情報, 自市町村コード, breakItemIds);

        IGassanJigyobunKekkaIchiranBuilder builder = new GassanJigyobunKekkaIchiranBuilder(editor);

        writer.writeLine(builder);

    }
}
