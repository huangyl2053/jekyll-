/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsainshiharaimeisaisho;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsainshiharaimeisaisho.ShinsainShiharaimeisaishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護認定審査会委員報酬支払明細書Builderクラスです。
 *
 * @reamsid_L DBE-1980-046 suguangjun
 */
class ShinsainShiharaimeisaishoBuilder implements IShinsainShiharaimeisaishoBuilder {

    private final IShinsainShiharaimeisaishoEditor editor;
    private final IShinsainShiharaimeisaishoBodyEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShinsainShiharaimeisaishoEditor}
     */
    public ShinsainShiharaimeisaishoBuilder(IShinsainShiharaimeisaishoEditor editor,
            IShinsainShiharaimeisaishoBodyEditor bodyEditor) {
        this.editor = editor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShinsainShiharaimeisaishoReportSource}
     */
    @Override
    public ShinsainShiharaimeisaishoReportSource build() {
        return ReportEditorJoiner.from(new ShinsainShiharaimeisaishoReportSource()).join(editor).join(bodyEditor).buildSource();
    }
}
