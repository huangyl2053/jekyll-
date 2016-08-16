/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyushinseishoyucho;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyushinseishoyucho.KogakuShikyuShinseishoYuchoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 高額介護（予防）サービス費支給申請書（ゆうちょ）帳票Builderラクタです。
 *
 * @@reamsid_L DBC-4770-070 jiangxiaolong
 */
public class KogakuShikyuShinseishoYuchoBuilder implements IKogakuShikyuShinseishoYuchoBuilder {

    private final IKogakuShikyuShinseishoYuchoEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IKogakuShikyuShinseishoYuchoEditor
     */
    public KogakuShikyuShinseishoYuchoBuilder(
            IKogakuShikyuShinseishoYuchoEditor editor) {
        this.editor = editor;
    }

    @Override
    public KogakuShikyuShinseishoYuchoSource build() {
        return ReportEditorJoiner.from(new KogakuShikyuShinseishoYuchoSource()).join(editor).buildSource();
    }
}
