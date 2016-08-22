/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200004;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd200004.ShakaiFukushiHojinKeigenGaitoshaIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200004.ShakaiFukushiHojinReportSourse;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 社会福祉法人軽減認定者リストのReportです。
 *
 * @reamsid_L DBD-3830-060 tianyh
 */
public class ShakaiFukushiHojinKeigenReport extends Report<ShakaiFukushiHojinReportSourse> {

    private final ShakaiFukushiHojinKeigenGaitoshaIchiranEntity 帳票情報;
    private final Association association;
    private final IOutputOrder iOutputOrder;
    private final RString 帳票タイトル;
    private final YMDHMS 帳票作成日時;
    private static final int NUM_0 = 0;
    private static final int NUM_4 = 4;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票情報 ShakaiFukushiHojinKeigenGaitoshaIchiranEntity
     * @param 帳票タイトル RString
     * @param 帳票作成日時 YMDHMS
     * @param association Association
     * @param iOutputOrder IOutputOrder
     * @return 社会福祉法人軽減認定者発行一覧表
     */
    public static ShakaiFukushiHojinKeigenReport createReport(ShakaiFukushiHojinKeigenGaitoshaIchiranEntity 帳票情報, RString 帳票タイトル,
            YMDHMS 帳票作成日時, Association association, IOutputOrder iOutputOrder) {
        return new ShakaiFukushiHojinKeigenReport(帳票情報, 帳票タイトル, 帳票作成日時, association, iOutputOrder);
    }

    private ShakaiFukushiHojinKeigenReport(ShakaiFukushiHojinKeigenGaitoshaIchiranEntity 帳票情報, RString 帳票タイトル,
            YMDHMS 帳票作成日時, Association association, IOutputOrder iOutputOrder) {
        this.帳票情報 = 帳票情報;
        this.association = association;
        this.iOutputOrder = iOutputOrder;
        this.帳票タイトル = 帳票タイトル;
        this.帳票作成日時 = 帳票作成日時;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<ShakaiFukushiHojinReportSourse> writer) {
        int index = 0;
        if (帳票情報.get世帯員リスト().isEmpty()) {
            IShakaiFukushiHojinKeigenEditor bodyEditor = new ShakaiFukushiHojinKeigenEditor(帳票情報,
                    association, iOutputOrder, 帳票タイトル, 帳票作成日時, index);
            IShakaiFukushiHojinKeigenBuilder builder = new ShakaiFukushiHojinKeigenBuilder(bodyEditor);
            writer.writeLine(builder);
        } else {
            for (int i = NUM_0; i < 帳票情報.get世帯員リスト().size(); i += NUM_4) {
                IShakaiFukushiHojinKeigenEditor bodyEditor = new ShakaiFukushiHojinKeigenEditor(帳票情報,
                        association, iOutputOrder, 帳票タイトル, 帳票作成日時, index);
                IShakaiFukushiHojinKeigenBuilder builder = new ShakaiFukushiHojinKeigenBuilder(bodyEditor);
                writer.writeLine(builder);
                index += NUM_4;
            }
        }

    }
}
