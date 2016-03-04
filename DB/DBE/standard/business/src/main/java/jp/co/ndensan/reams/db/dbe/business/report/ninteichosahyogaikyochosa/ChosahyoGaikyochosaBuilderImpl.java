/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyogaikyochosa;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyogaikyochosa.ChosahyoGaikyochosaReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定調査票（概況調査）Builderのクラスです。
 */
public class ChosahyoGaikyochosaBuilderImpl implements IChosahyoGaikyochosaBuilder {

    private final IChosahyoGaikyochosaEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IChosahyoGaikyochosaEditor}
     */
    public ChosahyoGaikyochosaBuilderImpl(IChosahyoGaikyochosaEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ChosahyoGaikyochosaReportSource}
     */
    @Override
    public ChosahyoGaikyochosaReportSource build() {
        return ReportEditorJoiner.from(new ChosahyoGaikyochosaReportSource()).join(editor).buildSource();
    }

}
