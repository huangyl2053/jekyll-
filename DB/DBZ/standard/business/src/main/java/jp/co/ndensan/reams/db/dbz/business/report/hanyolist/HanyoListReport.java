/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.hanyolist;

import jp.co.ndensan.reams.db.dbz.entity.report.hanyolist.HanyoListReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 汎用リストのReportです。
 *
 * @reamsid_L DBZ-4570-020 jinge
 */
public class HanyoListReport extends Report<HanyoListReportSource> {

    private final RString 表題;
    private final RString データ種別;
    private final RString 項目見出し;
    private final RString 項目内容;
    private final Association 地方公共団体;
    private final IOutputOrder outputOrder;

    /**
     * インスタンスを生成します。
     *
     * @param 表題 表題
     * @param データ種別 データ種別
     * @param 項目見出し 項目見出し
     * @param 地方公共団体 Association
     * @param outputOrder IOutputOrder
     * @param 項目内容 項目内容
     * @return 汎用リスト
     */
    public static HanyoListReport createReport(RString 表題, RString データ種別, RString 項目見出し,
            RString 項目内容, Association 地方公共団体, IOutputOrder outputOrder) {
        return new HanyoListReport(表題, データ種別, 項目見出し,
                項目内容, 地方公共団体, outputOrder);
    }

    /**
     * インスタンスを生成します。
     *
     * @param 表題 表題
     * @param データ種別 データ種別
     * @param 項目見出し 項目見出し
     * @param 地方公共団体 Association
     * @param outputOrder IOutputOrder
     * @param 項目内容 項目内容
     */
    public HanyoListReport(RString 表題, RString データ種別, RString 項目見出し,
            RString 項目内容, Association 地方公共団体, IOutputOrder outputOrder) {
        this.表題 = 表題;
        this.データ種別 = データ種別;
        this.項目見出し = 項目見出し;
        this.項目内容 = 項目内容;
        this.地方公共団体 = 地方公共団体;
        this.outputOrder = outputOrder;
    }

    @Override
    public void writeBy(ReportSourceWriter<HanyoListReportSource> writer) {
        IHanyoListEditor editor = new HanyoListEditor(表題, データ種別,
                項目見出し, 項目内容, 地方公共団体, outputOrder);
        IHanyoListBuilder builder = new HanyoListBuilder(editor);
        writer.writeLine(builder);

    }
}
