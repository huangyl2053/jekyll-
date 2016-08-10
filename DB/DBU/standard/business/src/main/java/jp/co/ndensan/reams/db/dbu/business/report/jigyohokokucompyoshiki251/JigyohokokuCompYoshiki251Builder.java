/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki251;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki251.JigyohokokuCompYoshiki251ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事業報告複合様式_05のBuilderクラスです。
 *
 * @reamsid_L DBU-5560-060 wanghuafeng
 */
public class JigyohokokuCompYoshiki251Builder implements IJigyohokokuCompYoshiki251Builder {

    private final IJigyohokokuCompYoshiki251Editor headEditor;
    private final IJigyohokokuCompYoshiki251Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headEditor IJigyohokokuCompYoshiki251Editor
     * @param bodyEditor IJigyohokokuCompYoshiki251Editor
     */
    public JigyohokokuCompYoshiki251Builder(IJigyohokokuCompYoshiki251Editor headEditor, IJigyohokokuCompYoshiki251Editor bodyEditor) {
        this.headEditor = headEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 事業報告月報様式_02のbuild
     *
     * @return {@link JigyohokokuCompYoshiki202ReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki251ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki251ReportSource()).join(headEditor).join(bodyEditor).buildSource();
    }

}
