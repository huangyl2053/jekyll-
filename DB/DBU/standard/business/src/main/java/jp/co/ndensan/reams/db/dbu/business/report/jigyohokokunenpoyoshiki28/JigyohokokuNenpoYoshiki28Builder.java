/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokunenpoyoshiki28;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokunenpoyoshiki28.JigyohokokuNenpoYoshiki28ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事業状況報告年報（様式１・２　市町村特別給付）Builderクラスです。
 *
 * @reamsid_L DBU-5610-050 yaoyahui
 */
public class JigyohokokuNenpoYoshiki28Builder implements IJigyohokokuNenpoYoshiki28Builder {

    private final IJigyohokokuNenpoYoshiki28Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuNenpoYoshiki28Editor}
     */
    public JigyohokokuNenpoYoshiki28Builder(IJigyohokokuNenpoYoshiki28Editor editor) {
        this.editor = editor;
    }

    @Override
    public JigyohokokuNenpoYoshiki28ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuNenpoYoshiki28ReportSource()).join(editor).buildSource();
    }
}
