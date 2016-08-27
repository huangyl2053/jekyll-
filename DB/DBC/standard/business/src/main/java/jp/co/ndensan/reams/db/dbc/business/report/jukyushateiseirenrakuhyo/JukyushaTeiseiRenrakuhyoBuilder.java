/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushateiseirenrakuhyo;

import jp.co.ndensan.reams.db.dbc.entity.report.jukyushateiseirenrakuhyo.JukyushaTeiseiRenrakuhyoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMN81002_受給者訂正連絡票（紙媒体）Builderするクラスです。
 *
 * @reamsid_L DBC-2101-060 lijian
 */
public class JukyushaTeiseiRenrakuhyoBuilder implements IJukyushaTeiseiRenrakuhyoBuilder {

    private final IJukyushaTeiseiRenrakuhyoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor IJukyushaTeiseiRenrakuhyoEditor
     */
    public JukyushaTeiseiRenrakuhyoBuilder(IJukyushaTeiseiRenrakuhyoEditor editor) {
        this.editor = editor;
    }

    @Override
    public JukyushaTeiseiRenrakuhyoSource build() {
        return ReportEditorJoiner.from(new JukyushaTeiseiRenrakuhyoSource()).join(editor).buildSource();
    }

}
