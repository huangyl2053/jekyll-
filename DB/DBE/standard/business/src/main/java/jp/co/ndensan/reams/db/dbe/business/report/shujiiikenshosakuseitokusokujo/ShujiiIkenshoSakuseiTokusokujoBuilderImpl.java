/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 主治医意見書提出督促状Builderのインターフェースクラスです。
 *
 */
class ShujiiIkenshoSakuseiTokusokujoBuilderImpl implements IShujiiIkenshoSakuseiTokusokujoBuilder {

    private final IShujiiIkenshoSakuseiTokusokujoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShujiiIkenshoSakuseiTokusokujoEditor}
     */
    public ShujiiIkenshoSakuseiTokusokujoBuilderImpl(IShujiiIkenshoSakuseiTokusokujoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShujiiIkenshoSakuseiTokusokujoReportSource}
     */
    @Override
    public ShujiiIkenshoSakuseiTokusokujoReportSource build() {
        return ReportEditorJoiner.from(new ShujiiIkenshoSakuseiTokusokujoReportSource()).join(editor).buildSource();
    }
}
