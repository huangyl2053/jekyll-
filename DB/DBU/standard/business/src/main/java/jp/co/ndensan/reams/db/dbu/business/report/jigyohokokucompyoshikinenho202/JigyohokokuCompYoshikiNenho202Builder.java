/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshikinenho202;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshikinenho202.JigyohokokuCompYoshikiNenho202ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告年報（様式2）Builderのインターフェースクラスです。
 *
 * @reamsid_L DBU-5600-190 zhaoran
 */
public class JigyohokokuCompYoshikiNenho202Builder implements IJigyohokokuCompYoshikiNenho202Builder {

    private final IJigyohokokuCompYoshikiNenho202Editor editor;
    private final IJigyohokokuCompYoshikiNenho202Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshikiNenho202Editor}
     * @param bodyEditor {@link IJigyohokokuCompYoshikiNenho202Editor}
     */
    public JigyohokokuCompYoshikiNenho202Builder(IJigyohokokuCompYoshikiNenho202Editor editor,
            IJigyohokokuCompYoshikiNenho202Editor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshikiNenho202ReportSource}
     */
    @Override
    public JigyohokokuCompYoshikiNenho202ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshikiNenho202ReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
