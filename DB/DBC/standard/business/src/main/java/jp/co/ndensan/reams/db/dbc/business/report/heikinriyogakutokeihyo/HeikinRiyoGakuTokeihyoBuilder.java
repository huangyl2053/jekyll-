/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.heikinriyogakutokeihyo;

import jp.co.ndensan.reams.db.dbc.entity.report.heikinriyogakutokeihyo.HeikinRiyoGakuTokeihyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 平均利用額統計表のBuilderです。
 *
 * @reamsid_L DBC-3490-040 sunhaidi
 */
public class HeikinRiyoGakuTokeihyoBuilder implements IHeikinRiyoGakuTokeihyoBuilder {

    private final IHeikinRiyoGakuTokeihyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IHeikinRiyoGakuTokeihyoEditor}
     */
    HeikinRiyoGakuTokeihyoBuilder(IHeikinRiyoGakuTokeihyoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link HeikinRiyoGakuTokeihyoReportSource}
     */
    @Override
    public HeikinRiyoGakuTokeihyoReportSource build() {
        return ReportEditorJoiner.from(new HeikinRiyoGakuTokeihyoReportSource()).join(editor).buildSource();
    }
}
