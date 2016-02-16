/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo;

import jp.co.ndensan.reams.db.dbb.entity.report.source.tsukibetsusuiihyo.TsukibetsuSuiihyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 境界層管理マスタリストBuilderクラスです。
 */
class TsukibetsuSuiihyoBuilderImpl implements ITsukibetsuSuiihyoBuilder {

    private final ITsukibetsuSuiihyoEditor headerEditor;
    private final ITsukibetsuSuiihyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link ITsukibetsuSuiihyoEditor}
     * @param bodyEditor {@link ITsukibetsuSuiihyoEditor}
     */
    public TsukibetsuSuiihyoBuilderImpl(ITsukibetsuSuiihyoEditor headerEditor, ITsukibetsuSuiihyoEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link TsukibetsuSuiihyoReportSource}
     */
    @Override
    public TsukibetsuSuiihyoReportSource build() {
        return ReportEditorJoiner.from(new TsukibetsuSuiihyoReportSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
