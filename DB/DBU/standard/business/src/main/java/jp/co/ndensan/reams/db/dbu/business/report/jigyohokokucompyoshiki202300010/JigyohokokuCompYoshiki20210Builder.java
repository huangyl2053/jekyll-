/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki202300010;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki202300010.JigyohokokuCompYoshiki20210ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護事業状況報告年報（様式2-3）Builderクラスです。
 *
 * @reamsid_L DBU-5600-230 wangrenze
 */
public class JigyohokokuCompYoshiki20210Builder implements IJigyohokokuCompYoshiki20210Builder {

    private final IJigyohokokuCompYoshiki20210Editor editor;
    private final IJigyohokokuCompYoshiki20210Editor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJigyohokokuCompYoshiki20210Editor}
     * @param bodyEditor {@link IJigyohokokuCompYoshiki20210Editor}
     */
    public JigyohokokuCompYoshiki20210Builder(IJigyohokokuCompYoshiki20210Editor editor, IJigyohokokuCompYoshiki20210Editor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuCompYoshiki20210ReportSource}
     */
    @Override
    public JigyohokokuCompYoshiki20210ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuCompYoshiki20210ReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
