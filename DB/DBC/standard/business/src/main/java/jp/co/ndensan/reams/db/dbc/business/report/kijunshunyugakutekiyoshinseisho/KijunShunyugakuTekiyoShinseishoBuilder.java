/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseisho;

import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoshinseisho.KijunShunyugakuTekiyoShinseishoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC100064_基準収入額適用申請書 Builderするクラスです。
 *
 * @reamsid_L DBC-4640-040 lijian
 */
public class KijunShunyugakuTekiyoShinseishoBuilder implements IKijunShunyugakuTekiyoShinseishoBuilder {

    private final IKijunShunyugakuTekiyoShinseishoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor IKijunShunyugakuTekiyoShinseishoEditor
     */
    public KijunShunyugakuTekiyoShinseishoBuilder(IKijunShunyugakuTekiyoShinseishoEditor editor) {
        this.editor = editor;
    }

    @Override
    public KijunShunyugakuTekiyoShinseishoSource build() {
        return ReportEditorJoiner.from(new KijunShunyugakuTekiyoShinseishoSource()).join(editor).buildSource();
    }

}
