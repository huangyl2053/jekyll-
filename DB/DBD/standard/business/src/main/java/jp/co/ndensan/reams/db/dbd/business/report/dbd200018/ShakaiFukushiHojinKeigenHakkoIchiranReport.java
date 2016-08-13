/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200018;

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

    private final ShakaiFukushiHojinKeigenHakkoIchiranEntity 帳票情報;
    private final Association association;
    private final IOutputOrder iOutputOrder;
    private final IKojin 個人情報;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票情報 ShakaiFukushiHojinKeigenHakkoIchiranEntity
     * @param association Association
     * @param iOutputOrder IOutputOrder
     * @param 個人情報 IKojin
     * @param index int
     * @return 社会福祉法人軽減確認証・決定通知書発行一覧表
     */
    public static ShakaiFukushiHojinKeigenHakkoIchiranReport createReport(ShakaiFukushiHojinKeigenHakkoIchiranEntity 帳票情報,
            Association association, IOutputOrder iOutputOrder, IKojin 個人情報, int index) {
        return new ShakaiFukushiHojinKeigenHakkoIchiranReport(帳票情報, association, iOutputOrder, 個人情報, index);
    }

    private ShakaiFukushiHojinKeigenHakkoIchiranReport(ShakaiFukushiHojinKeigenHakkoIchiranEntity 帳票情報,
            Association association, IOutputOrder iOutputOrder, IKojin 個人情報, int index) {
        this.帳票情報 = 帳票情報;
        this.association = association;
        this.iOutputOrder = iOutputOrder;
        this.個人情報 = 個人情報;
        this.index = index;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<ShakaiFukushiHojinKeigenHakkoIchiranReportSource> writer) {
        IShakaiFukushiHojinKeigenHakkoIchiranEditor bodyEditor = new ShakaiFukushiHojinKeigenHakkoIchiranEditor(
                帳票情報, association, iOutputOrder, 個人情報, index);
        IShakaiFukushiHojinKeigenHakkoIchiranBuilder builder = new ShakaiFukushiHojinKeigenHakkoIchiranBuilder(bodyEditor);
        writer.writeLine(builder);
    }

}
