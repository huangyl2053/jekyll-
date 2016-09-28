/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushajyufujissekidaicho;

import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushajyufujissekidaicho.JukyushaKyufuJissekidaichoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 受給者給付実績台帳 Builderクラスです。
 *
 * @reamsid_L DBC-3080-040 dangjingjing
 */
public class JukyushaKyufuJissekidaichoBuilder implements IJukyushaKyufuJissekidaichoBuilder {

    private final IJukyushaKyufuJissekidaichoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJukyushaKyufuJissekidaichoEditor}
     */
    protected JukyushaKyufuJissekidaichoBuilder(IJukyushaKyufuJissekidaichoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JukyushaKyufuJissekidaichoReportSource}
     */
    @Override
    public JukyushaKyufuJissekidaichoReportSource build() {
        return ReportEditorJoiner.from(new JukyushaKyufuJissekidaichoReportSource()).join(editor).buildSource();
    }
}
