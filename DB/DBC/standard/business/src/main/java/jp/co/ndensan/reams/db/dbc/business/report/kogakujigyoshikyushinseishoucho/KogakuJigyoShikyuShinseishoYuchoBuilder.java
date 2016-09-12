/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshikyushinseishoucho;

import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyoshikyushinseishoyuchosource.KogakuJigyoShikyuShinseishoYuchoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC100071_介護保険高額総合事業サービス費支給申請書（ゆうちょ銀行）Builder
 *
 * @reamsid_L DBC-4770-090 jianglaisheng
 */
public class KogakuJigyoShikyuShinseishoYuchoBuilder implements IKogakuJigyoShikyuShinseishoYuchoBuilder {

    private final IKogakuJigyoShikyuShinseishoYuchoEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IKogakuJigyoShikyuShinseishoYuchoEditor
     */
    public KogakuJigyoShikyuShinseishoYuchoBuilder(
            IKogakuJigyoShikyuShinseishoYuchoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KogakuJigyoShikyuShinseishoYuchoSource}
     */
    @Override
    public KogakuJigyoShikyuShinseishoYuchoSource build() {
        return ReportEditorJoiner.from(new KogakuJigyoShikyuShinseishoYuchoSource()).join(editor).buildSource();
    }

}
