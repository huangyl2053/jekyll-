/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokujyo;

import jp.co.ndensan.reams.db.dbe.entity.report.ninteichosatokusokujyo.NinteiChosaTokusokujoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定調査督促状Builderクラスです。
 *
 * @reamsid_L DBE-0030-020 xuyue
 */
class NinteiChosaTokusokujoBuilderImpl implements INinteiChosaTokusokujoBuilder {

    private final INinteiChosaTokusokujoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IkenshoShujiiIchiranEditor}
     * @param hyojiIchiranEditor {@link IkenshoShujiiIchiranEditor}
     */
    public NinteiChosaTokusokujoBuilderImpl(INinteiChosaTokusokujoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JuToGaishaKojinBangoKakuninListReportSource}
     */
    @Override
    public NinteiChosaTokusokujoReportSource build() {
        return ReportEditorJoiner.from(new NinteiChosaTokusokujoReportSource()).join(bodyEditor).buildSource();
    }
}
