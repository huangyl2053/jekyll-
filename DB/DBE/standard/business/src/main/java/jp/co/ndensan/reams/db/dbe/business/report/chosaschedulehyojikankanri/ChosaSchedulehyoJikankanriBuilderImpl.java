/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyojikankanri;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosaschedulehyojikankanri.ChosaSchedulehyoJikankanriReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 認定調査スケジュール表(時間管理)Builderクラスです。
 */
class ChosaSchedulehyoJikankanriBuilderImpl implements IChosaSchedulehyoJikankanriBuilder {

    private final IChosaSchedulehyoJikankanriEditor headerEditor;
    private final IChosaSchedulehyoJikankanriEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IChosaSchedulehyoJikankanriEditor}
     * @param bodyEditor {@link IChosaSchedulehyoJikankanriEditor}
     */
    public ChosaSchedulehyoJikankanriBuilderImpl(
            IChosaSchedulehyoJikankanriEditor headerEditor, IChosaSchedulehyoJikankanriEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ChosaSchedulehyoJikankanriReportSource}
     */
    @Override
    public ChosaSchedulehyoJikankanriReportSource build() {
        return ReportEditorJoiner.from(new ChosaSchedulehyoJikankanriReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
