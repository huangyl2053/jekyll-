/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki201300009;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki201300009.JigyohokokuCompYoshiki20109ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告年報（様式2-3）Builderクラスです。
 *
 * @reamsid_L DBU-5600-220 wangrenze
 */
public class JigyohokokuCompYoshiki20109Builder implements IJigyohokokuCompYoshiki20109Builder {

    private final IJigyohokokuCompYoshiki20109Editor editor;
    private final IJigyohokokuCompYoshiki20109Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshiki20109Editor}
     * @param bodyEditor {@link IJigyohokokuCompYoshiki20109Editor}
     */
    public JigyohokokuCompYoshiki20109Builder(IJigyohokokuCompYoshiki20109Editor editor, IJigyohokokuCompYoshiki20109Editor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshiki20109ReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki20109ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki20109ReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
