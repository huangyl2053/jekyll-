/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki2021;

import jp.co.ndensan.reams.db.dbu.entity.report.ｊigyohokokucompyoshiki202.JigyohokokuCompYoshiki202ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事業報告月報様式_02のBuilderです。
 *
 * @reamsid_L DBU-5560-050 wanghuafeng
 */
public class JigyohokokuCompYoshiki2021Builder implements IJigyohokokuCompYoshiki2021Builder {

    private final IJigyohokokuCompYoshiki2021Editor headEditor;
    private final IJigyohokokuCompYoshiki2021Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headEditor IJigyohokokuCompYoshiki2021Editor
     * @param bodyEditor IJigyohokokuCompYoshiki2021Editor
     */
    public JigyohokokuCompYoshiki2021Builder(IJigyohokokuCompYoshiki2021Editor headEditor, IJigyohokokuCompYoshiki2021Editor bodyEditor) {
        this.headEditor = headEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 事業報告月報様式_02のbuild
     *
     * @return {@link JigyohokokuCompYoshiki202ReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki202ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki202ReportSource()).join(headEditor).join(bodyEditor).buildSource();
    }

}
