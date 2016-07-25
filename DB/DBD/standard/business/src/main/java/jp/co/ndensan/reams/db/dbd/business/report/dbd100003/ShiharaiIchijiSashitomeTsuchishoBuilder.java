/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100003;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100003.ShiharaiIchijiSashitomeTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 支払一時差止通知書Builderクラスです。
 *
 * @reamsid_L DBD-3640-100 b_liuyang2
 */
public class ShiharaiIchijiSashitomeTsuchishoBuilder implements IShiharaiIchijiSashitomeTsuchishoBuilder {

    private final IShiharaiIchijiSashitomeTsuchishoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IShiharaiIchijiSashitomeTsuchishoEditor}
     */
    ShiharaiIchijiSashitomeTsuchishoBuilder(IShiharaiIchijiSashitomeTsuchishoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShiharaiIchijiSashitomeTsuchishoReportSource}
     */
    @Override
    public ShiharaiIchijiSashitomeTsuchishoReportSource build() {
        return ReportEditorJoiner.from(new ShiharaiIchijiSashitomeTsuchishoReportSource()).join(bodyEditor).buildSource();
    }

}
