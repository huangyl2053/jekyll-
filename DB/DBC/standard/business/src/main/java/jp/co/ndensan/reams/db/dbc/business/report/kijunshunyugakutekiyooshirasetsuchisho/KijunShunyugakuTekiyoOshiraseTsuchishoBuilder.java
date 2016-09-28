/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyooshirasetsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyooshirasetsuchisho.KijunShunyugakuTekiyoOshiraseTsuchishoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC100063_基準収入額適用お知らせ通知書 Builderするクラスです。
 *
 * @reamsid_L DBC-2101-060 lijian
 */
public class KijunShunyugakuTekiyoOshiraseTsuchishoBuilder implements IKijunShunyugakuTekiyoOshiraseTsuchishoBuilder {

    private final IKijunShunyugakuTekiyoOshiraseTsuchishoEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor IKijunShunyugakuTekiyoOshiraseTsuchishoEditor
     */
    public KijunShunyugakuTekiyoOshiraseTsuchishoBuilder(IKijunShunyugakuTekiyoOshiraseTsuchishoEditor editor) {
        this.editor = editor;
    }

    @Override
    public KijunShunyugakuTekiyoOshiraseTsuchishoSource build() {
        return ReportEditorJoiner.from(new KijunShunyugakuTekiyoOshiraseTsuchishoSource()).join(editor).buildSource();
    }
}
