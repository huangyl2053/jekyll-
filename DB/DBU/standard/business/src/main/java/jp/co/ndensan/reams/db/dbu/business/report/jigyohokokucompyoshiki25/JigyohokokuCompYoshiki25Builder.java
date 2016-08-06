/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki25;

import jp.co.ndensan.reams.db.dbu.entity.report.JigyohokokuCompYoshiki25.JigyohokokuCompYoshiki25ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護事業状況報告月報（様式2-5）Builderのインターフェースクラスです。
 *
 * @reamsid_L DBU-5600-260 guoqilin
 */
public class JigyohokokuCompYoshiki25Builder implements IJigyohokokuCompYoshiki25Builder {

    private final IJigyohokokuCompYoshiki25Editor editor;
    private final IJigyohokokuCompYoshiki25Editor bodyeditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link JigyohokokuCompYoshikiEditor}
     * @param bodyeditor {@link JigyohokokuCompYoshikiBodyEditor}
     */
    public JigyohokokuCompYoshiki25Builder(IJigyohokokuCompYoshiki25Editor editor, IJigyohokokuCompYoshiki25Editor bodyeditor) {
        this.editor = editor;
        this.bodyeditor = bodyeditor;
    }

    @Override
    public JigyohokokuCompYoshiki25ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki25ReportSource()).join(editor).join(bodyeditor).buildSource();
    }
}
