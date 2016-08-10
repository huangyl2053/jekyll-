/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki272;

import jp.co.ndensan.reams.db.dbu.entity.report.ｊigyohokokucompyoshiki272.JigyohokokuCompYoshiki272ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2-7） のBuilderです。
 *
 * @reamsid_L DBU-5590-050 wanghuafeng
 */
public class JigyohokokuCompYoshiki272Builder implements IJigyohokokuCompYoshiki272Builder {

    private final IJigyohokokuCompYoshiki272Editor headeditor;
    private final IJigyohokokuCompYoshiki272Editor bodyeditor;

    /**
     * インスタンスを生成します。
     *
     * @param headeditor {@link IJigyohokokuCompYoshiki272Editor}
     * @param bodyeditor {@link IJigyohokokuCompYoshiki272Editor}
     */
    public JigyohokokuCompYoshiki272Builder(IJigyohokokuCompYoshiki272Editor headeditor, IJigyohokokuCompYoshiki272Editor bodyeditor) {
        this.headeditor = headeditor;
        this.bodyeditor = bodyeditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshiki272ReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki272ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki272ReportSource()).join(headeditor).join(bodyeditor).buildSource();
    }

}
