/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshiki2120161;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshiki2120161.JigyohokokuGeppoYoshiki2120161ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事業報告月報様式_03のBuilderのクラスです。
 *
 * @reamsid_L DBU-5560-070 wanghuafeng
 */
public class JigyohokokuGeppoYoshiki2120161Builder implements IJigyohokokuGeppoYoshiki2120161Builder {

    private final IJigyohokokuGeppoYoshiki2120161Editor headEditor;
    private final IJigyohokokuGeppoYoshiki2120161Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headEditor {@link IJigyohokokuGeppoYoshiki2120161Editor}
     * @param bodyEditor {@link IJigyohokokuGeppoYoshiki2120161Editor}
     */
    public JigyohokokuGeppoYoshiki2120161Builder(IJigyohokokuGeppoYoshiki2120161Editor headEditor, IJigyohokokuGeppoYoshiki2120161Editor bodyEditor) {
        this.headEditor = headEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuGeppoYoshiki2120161ReportSource}
     */
    @Override
    public JigyohokokuGeppoYoshiki2120161ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuGeppoYoshiki2120161ReportSource()).join(headEditor).join(bodyEditor).buildSource();
    }

}
