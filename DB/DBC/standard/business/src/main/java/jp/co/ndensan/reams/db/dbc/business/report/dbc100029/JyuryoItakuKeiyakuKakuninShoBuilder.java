/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc100029;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc100029.JyuryoItakuKeiyakuKakuninShoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMN32002_介護保険受領委任契約承認（不承認）確認書（利用者向け）Builder
 *
 * @reamsid_L DBC-1910-050 jiangxiaolong
 */
public class JyuryoItakuKeiyakuKakuninShoBuilder
        implements IJyuryoItakuKeiyakuKakuninShoBuilder {

    private final IJyuryoItakuKeiyakuKakuninShoEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param bodyEditor BodyEditor
     */
    public JyuryoItakuKeiyakuKakuninShoBuilder(
            IJyuryoItakuKeiyakuKakuninShoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    @Override
    public JyuryoItakuKeiyakuKakuninShoSource build() {
        return ReportEditorJoiner.from(new JyuryoItakuKeiyakuKakuninShoSource())
                .join(bodyEditor).buildSource();
    }

}
