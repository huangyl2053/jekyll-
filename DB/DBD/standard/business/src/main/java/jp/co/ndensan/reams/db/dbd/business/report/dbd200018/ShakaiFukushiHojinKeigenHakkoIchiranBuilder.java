/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200018;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd200018.ShakaiFukushiHojinKeigenHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 社会福祉法人軽減確認証・決定通知書発行一覧表Builderクラスです。
 *
 * @reamsid_L DBD-3981-070 b_liuyang2
 */
public class ShakaiFukushiHojinKeigenHakkoIchiranBuilder implements IShakaiFukushiHojinKeigenHakkoIchiranBuilder {

    private final IShakaiFukushiHojinKeigenHakkoIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IShakaiFukushiHojinKeigenHakkoIchiranEditor}
     */
    ShakaiFukushiHojinKeigenHakkoIchiranBuilder(IShakaiFukushiHojinKeigenHakkoIchiranEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShakaiFukushiHojinKeigenHakkoIchiranReportSource}
     */
    @Override
    public ShakaiFukushiHojinKeigenHakkoIchiranReportSource build() {
        return ReportEditorJoiner.from(new ShakaiFukushiHojinKeigenHakkoIchiranReportSource()).join(bodyEditor).buildSource();
    }
}
