/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shisetsuhenkotsuchisho;

import jp.co.ndensan.reams.db.dba.entity.report.source.shisetsuhenkotsuchisho.ShisetsuHenkoTsuchishoReportSource;

/**
 * 介護保険住所地特例施設変更通知書Editorです。
 */
class ShisetsuHenkoTsuchishoEditor implements IShisetsuHenkoTsuchishoEditor {

    private final ShisetsuHenkoTsuchishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShisetsuHenkoTsuchishoItem}
     */
    protected ShisetsuHenkoTsuchishoEditor(ShisetsuHenkoTsuchishoItem item) {
        this.item = item;
    }

    @Override
    public ShisetsuHenkoTsuchishoReportSource edit(ShisetsuHenkoTsuchishoReportSource source) {

        return source;
    }
}
