/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyushinseisho;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyushinseisho.KogakuShikyuShinseishoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 高額介護（予防）サービス費支給申請書帳票Builderラクタです。
 *
 * @@reamsid_L DBC-4770-060 jiangxiaolong
 */
public class KogakuShikyuShinseishoBuilder implements IKogakuShikyuShinseishoBuilder {

    private final IKogakuShikyuShinseishoEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IKogakuShikyuShinseishoEditor
     */
    public KogakuShikyuShinseishoBuilder(
            IKogakuShikyuShinseishoEditor editor) {
        this.editor = editor;
    }

    @Override
    public KogakuShikyuShinseishoSource build() {
        return ReportEditorJoiner.from(new KogakuShikyuShinseishoSource()).join(editor).buildSource();
    }
}
