/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.riyojokyotokeihyo;

import jp.co.ndensan.reams.db.dbc.entity.report.source.riyojokyotokeihyo.RiyoJokyoTokeihyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 利用状況統計表Builderのクラスです。
 *
 * @reamsid_L DBC-3500-050 jinjue
 */
public class RiyoJokyoTokeihyoBuilder implements IRiyoJokyoTokeihyoBuilder {

    private final IRiyoJokyoTokeihyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IRiyoJokyoTokeihyoEditor}
     */
    public RiyoJokyoTokeihyoBuilder(IRiyoJokyoTokeihyoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link RiyoJokyoTokeihyoReportSource}
     */
    @Override
    public RiyoJokyoTokeihyoReportSource build() {
        return ReportEditorJoiner.from(new RiyoJokyoTokeihyoReportSource()).join(editor).buildSource();
    }
}
