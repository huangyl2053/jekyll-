/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyo;

import jp.co.ndensan.reams.db.dbe.entity.report.chosaschedulehyo.ChosaSchedulehyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 認定調査スケジュール表(事務所)Builderクラスです。
 */
class ChosaSchedulehyoBuilderImpl implements IChosaSchedulehyoBuilder {

    private final IChosaSchedulehyoEditor headerEditor;
    private final IChosaSchedulehyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IChosaSchedulehyoEditor}
     * @param bodyEditor {@link IChosaSchedulehyoEditor}
     */
    public ChosaSchedulehyoBuilderImpl(IChosaSchedulehyoEditor headerEditor, IChosaSchedulehyoEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ChosaSchedulehyoReportSource}
     */
    @Override
    public ChosaSchedulehyoReportSource build() {
        return ReportEditorJoiner.from(new ChosaSchedulehyoReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
