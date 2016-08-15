/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki26;

import jp.co.ndensan.reams.db.dbu.entity.report.JigyohokokuCompYoshiki26.JigyohokokuCompYoshiki26ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護事業状況報告月報（様式2-6）Builderのインターフェースクラスです。
 *
 * @reamsid_L DBU-5600-270 guoqilin
 */
public class JigyohokokuCompYoshiki26Builder implements IJigyohokokuCompYoshiki26Builder {

    private final IJigyohokokuCompYoshiki26Editor editor;
    private final IJigyohokokuCompYoshiki26Editor bodyeditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link JigyohokokuCompYoshiki26Editor}
     * @param bodyeditor {@link JigyohokokuCompYoshiki26BodyEditor}
     */
    public JigyohokokuCompYoshiki26Builder(IJigyohokokuCompYoshiki26Editor editor, IJigyohokokuCompYoshiki26Editor bodyeditor) {
        this.editor = editor;
        this.bodyeditor = bodyeditor;
    }

    @Override
    public JigyohokokuCompYoshiki26ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki26ReportSource()).join(editor).join(bodyeditor).buildSource();
    }
}
