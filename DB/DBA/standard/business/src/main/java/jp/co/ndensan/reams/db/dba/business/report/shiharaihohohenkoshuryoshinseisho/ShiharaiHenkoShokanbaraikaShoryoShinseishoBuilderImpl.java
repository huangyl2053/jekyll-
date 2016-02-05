/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shiharaihohohenkoshuryoshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.shiharaihohohenkoshuryoshinseisho.ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 支払方法変更（償還払い化）終了申請書Builderクラスです。
 */
class ShiharaiHenkoShokanbaraikaShoryoShinseishoBuilderImpl implements IShiharaiHenkoShokanbaraikaShoryoShinseishoBuilder {

    private final IShiharaiHenkoShokanbaraikaShoryoShinseishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor
     * {@link IShiharaiHenkoShokanbaraikaShoryoShinseishoEditor}
     * @param bodyEditor
     * {@link IShiharaiHenkoShokanbaraikaShoryoShinseishoEditor}
     */
    public ShiharaiHenkoShokanbaraikaShoryoShinseishoBuilderImpl(
            IShiharaiHenkoShokanbaraikaShoryoShinseishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource}
     */
    @Override
    public ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource build() {
        return ReportEditorJoiner.from(
                new ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource()).join(editor).buildSource();
    }
}
