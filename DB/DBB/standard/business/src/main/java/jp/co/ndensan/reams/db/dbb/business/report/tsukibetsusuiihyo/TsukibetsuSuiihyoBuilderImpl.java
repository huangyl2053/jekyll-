/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo;

import jp.co.ndensan.reams.db.dbb.entity.report.source.tsukibetsusuiihyo.TsukibetsuSuiihyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 月別推移表Builderクラスです。
 */
class TsukibetsuSuiihyoBuilderImpl implements ITsukibetsuSuiihyoBuilder {

    private final ITsukibetsuSuiihyoEditor headerEditor;
    private final ITsukibetsuSuiihyoEditor bodyTitleEditor;
    private final ITsukibetsuSuiihyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link ITsukibetsuSuiihyoEditor}
     * @param bodyEditor {@link ITsukibetsuSuiihyoEditor}
     * @param bodyEditor {@link ITsukibetsuSuiihyoEditor}
     */
    public TsukibetsuSuiihyoBuilderImpl(ITsukibetsuSuiihyoEditor headerEditor,
            ITsukibetsuSuiihyoEditor bodyTitleEditor,
            ITsukibetsuSuiihyoEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyTitleEditor = bodyTitleEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TsukibetsuSuiihyoReportSource}
     */
    @Override
    public TsukibetsuSuiihyoReportSource build() {
        if (bodyTitleEditor != null) {
            return ReportEditorJoiner.from(new TsukibetsuSuiihyoReportSource())
                    .join(headerEditor).join(bodyTitleEditor).join(bodyEditor).buildSource();
        }
        return ReportEditorJoiner.from(new TsukibetsuSuiihyoReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
