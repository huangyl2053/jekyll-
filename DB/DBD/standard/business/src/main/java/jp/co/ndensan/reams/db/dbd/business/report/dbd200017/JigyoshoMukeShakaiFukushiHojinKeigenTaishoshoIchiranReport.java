/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200017;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd206010.ShafukugemmenTaishoshaJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200017.JigyoshoMukeShakaiFukushiHojinKeigenReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事業所向け社会福祉法人軽減対象者一覧表のReportです。
 *
 * @reamsid_L DBD-3810-040 donghj
 */
public final class JigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiranReport extends
        Report<JigyoshoMukeShakaiFukushiHojinKeigenReportSource> {

    private final ShafukugemmenTaishoshaJohoEntity 社福減免対象者情報;
    private final Association 地方公共団体;
    private final Association association;
    private final IOutputOrder iOutputOrder;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param 社福減免対象者情報 ShafukugemmenTaishoshaJohoEntity
     * @param 地方公共団体 Association
     * @param association Association
     * @param iOutputOrder IOutputOrder
     * @param index int
     */
    public JigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiranReport(
            ShafukugemmenTaishoshaJohoEntity 社福減免対象者情報,
            Association 地方公共団体,
            Association association,
            IOutputOrder iOutputOrder,
            int index) {
        this.社福減免対象者情報 = 社福減免対象者情報;
        this.地方公共団体 = 地方公共団体;
        this.association = association;
        this.iOutputOrder = iOutputOrder;
        this.index = index;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyoshoMukeShakaiFukushiHojinKeigenReportSource> writer) {
        IJigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiranEditor editor
                = new JigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiranEditor(
                        社福減免対象者情報, 地方公共団体, association, iOutputOrder, index);
        IJigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiranBuilder builder
                = new JigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiranBuilder(editor);
        writer.writeLine(builder);
    }

}
