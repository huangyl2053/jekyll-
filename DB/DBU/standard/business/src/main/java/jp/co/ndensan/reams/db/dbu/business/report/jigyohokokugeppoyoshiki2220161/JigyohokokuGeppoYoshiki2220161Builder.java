/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshiki2220161;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshiki2220161.JigyohokokuGeppoYoshiki2220161ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事業報告月報様式_04のBuilderのクラスです。
 *
 * @reamsid_L DBU-5560-080 wanghuafeng
 */
public class JigyohokokuGeppoYoshiki2220161Builder implements IJigyohokokuGeppoYoshiki2220161Builder {

    private final IJigyohokokuGeppoYoshiki2220161Editor headEditor;
    private final IJigyohokokuGeppoYoshiki2220161Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headEditor {@link IJigyohokokuGeppoYoshiki2220161Editor}
     * @param bodyEditor {@link IJigyohokokuGeppoYoshiki2220161Editor}
     */
    public JigyohokokuGeppoYoshiki2220161Builder(IJigyohokokuGeppoYoshiki2220161Editor headEditor, IJigyohokokuGeppoYoshiki2220161Editor bodyEditor) {
        this.headEditor = headEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 事業報告月報様式_04のbuild
     *
     * @return {@link JigyohokokuGeppoYoshiki2220161ReportSource}
     */
    @Override
    public JigyohokokuGeppoYoshiki2220161ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuGeppoYoshiki2220161ReportSource()).join(headEditor).join(bodyEditor).buildSource();
    }

}
