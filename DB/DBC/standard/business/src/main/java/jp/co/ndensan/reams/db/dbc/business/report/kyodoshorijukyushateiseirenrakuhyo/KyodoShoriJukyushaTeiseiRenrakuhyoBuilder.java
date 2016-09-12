/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyodoshorijukyushateiseirenrakuhyo;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kyodoshorijukyushateiseirenrakuhyo.KyodoShoriJukyushaTeiseiRenrakuhyoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMN81004_共同処理用受給者訂正連絡票（紙媒体）Builderのインターフェースクラスです。
 *
 * @reamsid_L DBC-1951-060 chenaoqi
 */
public class KyodoShoriJukyushaTeiseiRenrakuhyoBuilder implements IKyodoShoriJukyushaTeiseiRenrakuhyoBuilder {

    private final IKyodoShoriJukyushaTeiseiRenrakuhyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKyodoShoriJukyushaTeiseiRenrakuhyoEditor}
     */
    public KyodoShoriJukyushaTeiseiRenrakuhyoBuilder(IKyodoShoriJukyushaTeiseiRenrakuhyoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KyodoShoriJukyushaTeiseiRenrakuhyoSource}
     */
    @Override
    public KyodoShoriJukyushaTeiseiRenrakuhyoSource build() {
        return ReportEditorJoiner.from(new KyodoShoriJukyushaTeiseiRenrakuhyoSource()).join(editor).buildSource();
    }
}
