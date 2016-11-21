/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iintokkitext;

import jp.co.ndensan.reams.db.dbe.entity.report.source.iintokkitext.IinTokkiTextA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 委員用特記事項A3版Builderクラスです。
 *
 * @reamsid_L DBE-0150-330 lishengli
 */
public class IinTokkiTextA3Builder implements IIinTokkiTextA3Builder {

    private final IIinTokkiTextA3Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IIinTokkiTextA3Editor}
     */
    public IinTokkiTextA3Builder(IIinTokkiTextA3Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link IinTokkiTextA3ReportSource}
     */
    @Override
    public IinTokkiTextA3ReportSource build() {
        return ReportEditorJoiner.from(new IinTokkiTextA3ReportSource()).join(editor).buildSource();
    }
}
