/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.hiyobenshotoshiharaimeisaisho;

import jp.co.ndensan.reams.db.dbe.entity.report.source.hiyobenshotoshiharaimeisaisho.HiyobenshotoShiharaimeisaishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護認定審査委員報酬・費用弁償等支払明細書Builderクラスです。
 *
 * @reamsid_L DBE-1980-048 suguangjun
 */
class HiyobenshotoShiharaimeisaishoBuilder implements IHiyobenshotoShiharaimeisaishoBuilder {

    private final IHiyobenshotoShiharaimeisaishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IHiyobenshotoShiharaimeisaishoEditor}
     */
    public HiyobenshotoShiharaimeisaishoBuilder(IHiyobenshotoShiharaimeisaishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link HiyobenshotoShiharaimeisaishoReportSource}
     */
    @Override
    public HiyobenshotoShiharaimeisaishoReportSource build() {
        return ReportEditorJoiner.from(new HiyobenshotoShiharaimeisaishoReportSource()).join(editor).buildSource();
    }
}
