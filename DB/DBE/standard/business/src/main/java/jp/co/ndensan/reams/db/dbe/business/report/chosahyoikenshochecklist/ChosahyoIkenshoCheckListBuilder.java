/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahyoikenshochecklist;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyoikenshochecklist.ChosahyoIkenshoCheckListReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 認定調査結果と主治医意見書のチェックリストBuilderクラスです。
 *
 * @reamsid_L DBE-1390-190 dongyabin
 */
class ChosahyoIkenshoCheckListBuilder implements IChosahyoIkenshoCheckListBuilder {

    private final IChosahyoIkenshoCheckListEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IChosahyoIkenshoCheckListEditor}
     */
    public ChosahyoIkenshoCheckListBuilder(IChosahyoIkenshoCheckListEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ChosahyoIkenshoCheckListReportSource}
     */
    @Override
    public ChosahyoIkenshoCheckListReportSource build() {
        return ReportEditorJoiner.from(new ChosahyoIkenshoCheckListReportSource()).join(editor).buildSource();
    }
}
