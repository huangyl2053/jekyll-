/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki201;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki201.JigyohokokuCompYoshiki201ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事業報告月報様式_01のBuilderクラスです。
 *
 * @reamsid_L DBU-5560-040 xuyannan
 */
public class JigyohokokuCompYoshiki201Builder implements IJigyohokokuCompYoshiki201Builder {

    private final IJigyohokokuCompYoshiki201Editor headEditor;
    private final IJigyohokokuCompYoshiki201Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headEditor {@link IJigyohokokuCompYoshiki201Editor}
     * @param bodyEditor {@link IJigyohokokuCompYoshiki201Editor}
     */
    public JigyohokokuCompYoshiki201Builder(IJigyohokokuCompYoshiki201Editor headEditor, IJigyohokokuCompYoshiki201Editor bodyEditor) {
        this.headEditor = headEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshiki201ReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki201ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki201ReportSource()).join(headEditor).join(bodyEditor).buildSource();
    }
}
