/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200018;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shakaifukushihojinkeigenhakkoichiran.ShakaiFukushiHojinKeigenHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200018.ShakaiFukushiHojinKeigenHakkoIchiranReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 社会福祉法人軽減確認証・決定通知書発行一覧表のReportです。
 *
 * @reamsid_L DBD-3981-070 b_liuyang2
 */
public final class ShakaiFukushiHojinKeigenHakkoIchiranReport extends Report<ShakaiFukushiHojinKeigenHakkoIchiranReportSource> {

    private final List<ShakaiFukushiHojinKeigenHakkoIchiranEntity> 帳票情報リスト;
    private final Association association;
    private final IOutputOrder iOutputOrder;
    private final IKojin 個人情報;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票情報リスト List<ShakaiFukushiHojinKeigenHakkoIchiranEntity>
     * @param association Association
     * @param iOutputOrder IOutputOrder
     * @param 個人情報 IKojin
     * @return 社会福祉法人軽減確認証・決定通知書発行一覧表
     */
    public static ShakaiFukushiHojinKeigenHakkoIchiranReport createReport(List<ShakaiFukushiHojinKeigenHakkoIchiranEntity> 帳票情報リスト,
            Association association, IOutputOrder iOutputOrder, IKojin 個人情報) {
        return new ShakaiFukushiHojinKeigenHakkoIchiranReport(帳票情報リスト, association, iOutputOrder, 個人情報);
    }

    private ShakaiFukushiHojinKeigenHakkoIchiranReport(List<ShakaiFukushiHojinKeigenHakkoIchiranEntity> 帳票情報リスト,
            Association association, IOutputOrder iOutputOrder, IKojin 個人情報) {
        this.帳票情報リスト = 帳票情報リスト;
        this.association = association;
        this.iOutputOrder = iOutputOrder;
        this.個人情報 = 個人情報;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<ShakaiFukushiHojinKeigenHakkoIchiranReportSource> writer) {
        for (int index = 0; index < 帳票情報リスト.size(); index++) {
            IShakaiFukushiHojinKeigenHakkoIchiranEditor bodyEditor = new ShakaiFukushiHojinKeigenHakkoIchiranEditor(
                    帳票情報リスト, association, iOutputOrder, index, 個人情報);
            IShakaiFukushiHojinKeigenHakkoIchiranBuilder builder = new ShakaiFukushiHojinKeigenHakkoIchiranBuilder(bodyEditor);
            writer.writeLine(builder);
        }

    }
}
