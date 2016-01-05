/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.dbe223001;

import jp.co.ndensan.reams.db.dbe.entity.report.dbe223001.NinteiChosaTokusokujoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定調査督促状Builderクラスです。
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
