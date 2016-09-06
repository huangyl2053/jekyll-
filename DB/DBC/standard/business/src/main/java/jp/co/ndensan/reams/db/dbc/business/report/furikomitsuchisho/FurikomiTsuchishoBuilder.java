/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.furikomitsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.report.furikomitsuchisho.FurikomiTsuchishoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC100060_事業合算・事業分振込明細書作成（一括） Builderクラスです。
 *
 * @reamsid_L DBC-4870-050 lijian
 */
public class FurikomiTsuchishoBuilder implements IFurikomiTsuchishoBuilder {

    private final IFurikomiTsuchishoEditor headerEditor;
    private final IFurikomiTsuchishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor IFurikomiTsuchishoEditor
     * @param bodyEditor IFurikomiTsuchishoEditor
     */
    public FurikomiTsuchishoBuilder(
            IFurikomiTsuchishoEditor headerEditor,
            IFurikomiTsuchishoEditor bodyEditor) {

        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link FurikomiTsuchishoSource}
     */
    @Override
    public FurikomiTsuchishoSource build() {
        return ReportEditorJoiner.from(new FurikomiTsuchishoSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
