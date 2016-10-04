/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc120110;

import jp.co.ndensan.reams.db.dbc.entity.report.source.dbc120110.GassanJikofutangakuKakuninSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 高額合算自己負担額確認情報取込一覧表Builder
 *
 * @reamsid_L DBC-2650-030 chenjie
 */
public class GassanJikofutangakuKakunBuilder implements IGassanJikofutangakuKakunBuilder {

    private final IGassanJikofutangakuKakunEditor headerEditor;
    private final IGassanJikofutangakuKakunEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor IGassanJikofutangakuKakunEditor
     * @param bodyEditor IGassanJikofutangakuKakunEditor
     */
    public GassanJikofutangakuKakunBuilder(
            IGassanJikofutangakuKakunEditor headerEditor,
            IGassanJikofutangakuKakunEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public GassanJikofutangakuKakuninSource build() {
        return ReportEditorJoiner.from(new GassanJikofutangakuKakuninSource())
                .join(headerEditor).join(bodyEditor).buildSource();
    }

}
