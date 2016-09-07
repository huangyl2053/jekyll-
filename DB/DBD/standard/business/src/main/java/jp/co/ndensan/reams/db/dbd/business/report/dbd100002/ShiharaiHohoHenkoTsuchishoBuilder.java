/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100002;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100002.ShiharaiHohoHenkoTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 支払方法変更通知書Builderクラスです。
 *
 * @reamsid_L DBD-3640-090 b_liuyang2
 */
public class ShiharaiHohoHenkoTsuchishoBuilder implements IShiharaiHohoHenkoTsuchishoBuilder {

    private final IShiharaiHohoHenkoTsuchishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IShiharaiHohoHenkoTsuchishoEditor}
     */
    ShiharaiHohoHenkoTsuchishoBuilder(IShiharaiHohoHenkoTsuchishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShiharaiHohoHenkoTsuchishoReportSource}
     */
    @Override
    public ShiharaiHohoHenkoTsuchishoReportSource build() {
        return ReportEditorJoiner.from(new ShiharaiHohoHenkoTsuchishoReportSource()).join(bodyEditor).buildSource();
    }
}
