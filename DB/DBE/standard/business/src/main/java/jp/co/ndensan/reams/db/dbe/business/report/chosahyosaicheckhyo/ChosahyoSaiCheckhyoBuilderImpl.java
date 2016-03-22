/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahyosaicheckhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyosaicheckhyo.ChosahyoSaiCheckhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 前回認定調査結果との比較表Builderクラスです。
 */
class ChosahyoSaiCheckhyoBuilderImpl implements IChosahyoSaiCheckhyoBuilder {

    private final IChosahyoSaiCheckhyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param Editor {@link IChosahyoSaiCheckhyoEditor}
     */
    public ChosahyoSaiCheckhyoBuilderImpl(IChosahyoSaiCheckhyoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ChosahyoSaiCheckhyoReportSource}
     */
    @Override
    public ChosahyoSaiCheckhyoReportSource build() {
        return ReportEditorJoiner.from(new ChosahyoSaiCheckhyoReportSource()).join(editor).buildSource();
    }
}
