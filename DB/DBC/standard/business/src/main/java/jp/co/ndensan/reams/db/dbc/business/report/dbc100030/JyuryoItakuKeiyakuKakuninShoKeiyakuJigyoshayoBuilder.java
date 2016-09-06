/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc100030;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc100030.JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMN32002_介護保険受領委任契約承認（不承認）確認書（事業者用）Builder
 *
 * @reamsid_L DBC-1910-040 jiangxiaolong
 */
public class JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoBuilder
        implements IJyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoBuilder {

    private final IJyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param bodyEditor BodyEditor
     */
    public JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoBuilder(
            IJyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    @Override
    public JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource build() {
        return ReportEditorJoiner.from(new JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource())
                .join(bodyEditor).buildSource();
    }

}
