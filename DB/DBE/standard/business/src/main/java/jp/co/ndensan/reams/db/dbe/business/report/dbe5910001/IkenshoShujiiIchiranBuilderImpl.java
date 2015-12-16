/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.dbe5910001;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ShujiiIryokikanShujiiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医医療機関・主治医一覧表Builderクラスです。
 */
class IkenshoShujiiIchiranBuilderImpl implements IkenshoShujiiIchiranBuilder {

    private final IkenshoShujiiIchiranEditor headerEditor;
    private final IkenshoShujiiIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IkenshoShujiiIchiranEditor}
     * @param hyojiIchiranEditor {@link IkenshoShujiiIchiranEditor}
     */
    public IkenshoShujiiIchiranBuilderImpl(IkenshoShujiiIchiranEditor headerEditor, IkenshoShujiiIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JuToGaishaKojinBangoKakuninListReportSource}
     */
    @Override
    public ShujiiIryokikanShujiiIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new ShujiiIryokikanShujiiIchiranhyoReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
