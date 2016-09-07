/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokunenpoyoshiki1of1;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokunenpoyoshiki1of1.JigyohokokuNenpoYoshiki1of1ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事業状況報告年報（様式１・２　被保険者数）Builderクラスです。
 *
 * @reamsid_L DBU-5610-040 sunhaidi
 */
public class JigyohokokuGeppoYoshikiBuilder implements IJigyohokokuGeppoYoshikiBuilder {

    private final IJigyohokokuGeppoYoshikiEditor editor;
    private final IJigyohokokuGeppoYoshikiEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuGeppoYoshikiEditor}
     * @param bodyEditor {@link IJigyohokokuGeppoYoshikiEditor}
     */
    public JigyohokokuGeppoYoshikiBuilder(IJigyohokokuGeppoYoshikiEditor editor, IJigyohokokuGeppoYoshikiEditor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuNenpoYoshiki1of1ReportSource}
     */
    @Override
    public JigyohokokuNenpoYoshiki1of1ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuNenpoYoshiki1of1ReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
