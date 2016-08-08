/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki202;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki202.JigyohokokuCompYoshiki202ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告年報（様式2-4）Builderのインターフェースクラスです。
 *
 * @reamsid_L DBU-5600-250 guoqilin
 */
public class JigyohokokuCompYoshiki202Builder implements IJigyohokokuCompYoshiki202Builder {

    private final IJigyohokokuCompYoshiki202Editor editor;
    private final IJigyohokokuCompYoshiki202Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshiki202Editor}
     * @param bodyEditor {@link IJigyohokokuCompYoshiki202Editor}
     */
    public JigyohokokuCompYoshiki202Builder(IJigyohokokuCompYoshiki202Editor editor,
            IJigyohokokuCompYoshiki202Editor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshiki202ReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki202ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki202ReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
