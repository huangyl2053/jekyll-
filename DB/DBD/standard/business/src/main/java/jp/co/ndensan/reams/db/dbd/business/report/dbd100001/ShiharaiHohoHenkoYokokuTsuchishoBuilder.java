/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100001;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100001.ShiharaiHohoHenkoYokokuTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 支払方法変更予告通知書Builderクラスです。
 *
 * @reamsid_L DBD-3640-040 b_liuyang2
 */
public class ShiharaiHohoHenkoYokokuTsuchishoBuilder implements IShiharaiHohoHenkoYokokuTsuchishoBuilder {

    private final IShiharaiHohoHenkoYokokuTsuchishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IShiharaiHohoHenkoYokokuTsuchishoEditor}
     */
    ShiharaiHohoHenkoYokokuTsuchishoBuilder(IShiharaiHohoHenkoYokokuTsuchishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShiharaiHohoHenkoYokokuTsuchishoReportSource}
     */
    @Override
    public ShiharaiHohoHenkoYokokuTsuchishoReportSource build() {
        return ReportEditorJoiner.from(new ShiharaiHohoHenkoYokokuTsuchishoReportSource()).join(bodyEditor).buildSource();
    }
}
