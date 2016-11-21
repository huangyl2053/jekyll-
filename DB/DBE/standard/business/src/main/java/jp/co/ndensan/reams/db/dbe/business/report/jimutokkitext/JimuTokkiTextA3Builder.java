/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimutokkitext;

import jp.co.ndensan.reams.db.dbe.entity.report.source.jimutokkitext.JimuTokkiTextA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事務局用一次判定+特記事項A3版Builderクラスです。
 *
 * @reamsid_L DBE-0150-320 lishengli
 */
public class JimuTokkiTextA3Builder implements IJimuTokkiTextA3Builder {

    private final IJimuTokkiTextA3Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJimuTokkiTextA3Editor}
     */
    public JimuTokkiTextA3Builder(IJimuTokkiTextA3Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JimuTokkiTextA3ReportSource}
     */
    @Override
    public JimuTokkiTextA3ReportSource build() {
        return ReportEditorJoiner.from(new JimuTokkiTextA3ReportSource()).join(editor).buildSource();
    }
}
