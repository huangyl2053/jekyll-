/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushaidorenrakuhyo;

import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushaidorenrakuhyo.JukyushaIdoRenrakuhyoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMN81001_受給者異動連絡票（紙媒体) Builder
 *
 * @reamsid_L DBC-2100-040 jiangzongyue
 */
public class JukyushaIdoRenrakuhyoBuilder implements IJukyushaIdoRenrakuhyoBuilder {

    private final IJukyushaIdoRenrakuhyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJukyushaIdoRenrakuhyoEditor}
     */
    JukyushaIdoRenrakuhyoBuilder(IJukyushaIdoRenrakuhyoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JukyushaIdoRenrakuhyoSource}
     */
    @Override
    public JukyushaIdoRenrakuhyoSource build() {
        return ReportEditorJoiner.from(new JukyushaIdoRenrakuhyoSource()).join(editor).buildSource();
    }
}
