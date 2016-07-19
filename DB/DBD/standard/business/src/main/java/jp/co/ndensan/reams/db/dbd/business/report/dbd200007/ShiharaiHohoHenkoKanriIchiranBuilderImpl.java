/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200007;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd200007.ShiharaiHohoHenkoKanriIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 支払方法変更管理リストBuilderクラスです。
 *
 * @reamsid_L DBD-3630-050 liangbc
 */
class ShiharaiHohoHenkoKanriIchiranBuilderImpl implements IShiharaiHohoHenkoKanriIchiranBuilder {

    private final IShiharaiHohoHenkoKanriIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShiharaiHohoHenkoKanriIchiranEditor}
     */
    public ShiharaiHohoHenkoKanriIchiranBuilderImpl(
            IShiharaiHohoHenkoKanriIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShiharaiHohoHenkoKanriIchiranReportSource}
     */
    @Override
    public ShiharaiHohoHenkoKanriIchiranReportSource build() {
        return ReportEditorJoiner.from(
                new ShiharaiHohoHenkoKanriIchiranReportSource()).join(editor).buildSource();
    }
}
