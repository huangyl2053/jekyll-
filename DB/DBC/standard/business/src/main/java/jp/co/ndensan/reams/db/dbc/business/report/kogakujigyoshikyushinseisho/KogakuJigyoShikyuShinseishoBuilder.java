/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshikyushinseisho;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakujigyoshikyushinseisho.KogakuJigyoShikyuShinseishoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC100070_介護保険高額総合事業サービス費支給申請書Builder
 *
 * @reamsid_L DBC-4770-080 jianglaisheng
 */
public class KogakuJigyoShikyuShinseishoBuilder implements IKogakuJigyoShikyuShinseishoBuilder {

    private final IKogakuJigyoShikyuShinseishoEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IKogakuJigyoShikyuShinseishoEditor
     */
    public KogakuJigyoShikyuShinseishoBuilder(
            IKogakuJigyoShikyuShinseishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KogakuJigyoShikyuShinseishoSource}
     */
    @Override
    public KogakuJigyoShikyuShinseishoSource build() {
        return ReportEditorJoiner.from(new KogakuJigyoShikyuShinseishoSource()).join(editor).buildSource();
    }

}
