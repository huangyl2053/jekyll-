/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200019;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd200019.FutangakuNinteiHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 負担額認定証・決定通知書発行一覧表Builderクラスです。
 *
 * @reamsid_L DBD-3981-060 b_liuyang2
 */
public class FutangakuNinteiHakkoIchiranBuilder implements IFutangakuNinteiHakkoIchiranBuilder {

    private final IFutangakuNinteiHakkoIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IFutangakuNinteiHakkoIchiranEditor}
     */
    FutangakuNinteiHakkoIchiranBuilder(IFutangakuNinteiHakkoIchiranEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link FutangakuNinteiHakkoIchiranReportSource}
     */
    @Override
    public FutangakuNinteiHakkoIchiranReportSource build() {
        return ReportEditorJoiner.from(new FutangakuNinteiHakkoIchiranReportSource()).join(bodyEditor).buildSource();
    }
}
