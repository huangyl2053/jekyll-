/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.dbe223001;

import jp.co.ndensan.reams.db.dbe.entity.report.dbe223001.NinteiChosaTokusokuTaishoshaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 認定調査督促対象者一覧表Builderクラスです。
 */                                                                       
class NinteiChosaTokusokuTaishoshaIchiranhyoBuilderImpl implements INinteiChosaTokusokuTaishoshaIchiranhyoBuilder {

    private final INinteiChosaTokusokuTaishoshaIchiranhyoEditor headerEditor;
    private final INinteiChosaTokusokuTaishoshaIchiranhyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IkenshoShujiiIchiranEditor}
     * @param hyojiIchiranEditor {@link IkenshoShujiiIchiranEditor}
     */
    public NinteiChosaTokusokuTaishoshaIchiranhyoBuilderImpl(INinteiChosaTokusokuTaishoshaIchiranhyoEditor headerEditor,
            INinteiChosaTokusokuTaishoshaIchiranhyoEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JuToGaishaKojinBangoKakuninListReportSource}
     */
    @Override
    public NinteiChosaTokusokuTaishoshaIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new NinteiChosaTokusokuTaishoshaIchiranhyoReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
