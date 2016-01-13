/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.idochecklist;

import jp.co.ndensan.reams.db.dba.entity.report.idochecklist.IdoCheckListReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 異動チェックリストBuilderクラスです
 */
class IdoCheckListBuilderImpl implements IIdoCheckListBuilder {

    private final IIdoCheckListEditor headerEditor;
    private final IIdoCheckListEditor hyojiBodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IIdoCheckListEditor}
     * @param hyojiBodyEditor {@link IIdoCheckListEditor}
     */

    public IdoCheckListBuilderImpl(IIdoCheckListEditor headerEditor, IIdoCheckListEditor hyojiBodyEditor) {
        this.headerEditor = headerEditor;
        this.hyojiBodyEditor = hyojiBodyEditor;
    }
    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link IdoCheckListReportSource}
     */

    @Override
    public IdoCheckListReportSource build() {

        return ReportEditorJoiner.from(new IdoCheckListReportSource()).join(headerEditor).join(hyojiBodyEditor).buildSource();

    }

}
