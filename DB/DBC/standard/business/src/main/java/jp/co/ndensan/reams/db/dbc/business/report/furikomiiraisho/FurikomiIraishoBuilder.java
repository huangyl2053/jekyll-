/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.furikomiiraisho;

import jp.co.ndensan.reams.db.dbc.entity.report.furikomiiraisho.FurikomiIraishoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC100059_事業合算・事業分振込明細書作成（一括） Builderクラスです。
 *
 * @reamsid_L DBC-4870-040 lijian
 */
public class FurikomiIraishoBuilder implements IFurikomiIraishoBuilder {

    private final IFurikomiIraishoEditor headerEditor;
    private final IFurikomiIraishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor IFurikomiIraishoEditor
     * @param bodyEditor IFurikomiIraishoEditor
     */
    public FurikomiIraishoBuilder(
            IFurikomiIraishoEditor headerEditor,
            IFurikomiIraishoEditor bodyEditor) {

        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link FurikomiIraishoSource}
     */
    @Override
    public FurikomiIraishoSource build() {
        return ReportEditorJoiner.from(new FurikomiIraishoSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
