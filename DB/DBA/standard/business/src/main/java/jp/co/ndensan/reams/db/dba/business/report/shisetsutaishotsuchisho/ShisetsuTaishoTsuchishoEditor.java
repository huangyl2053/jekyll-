/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shisetsutaishotsuchisho;

import jp.co.ndensan.reams.db.dba.entity.report.source.shisetsutaishotsuchisho.ShisetsuTaishoTsuchishoReportSource;

/**
 * 介護保険住所地特例施設退所通知書Editorです。
 */
class ShisetsuTaishoTsuchishoEditor implements IShisetsuTaishoTsuchishoEditor {

    private final ShisetsuTaishoTsuchishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShisetsuTaishoTsuchishoItem}
     */
    protected ShisetsuTaishoTsuchishoEditor(ShisetsuTaishoTsuchishoItem item) {
        this.item = item;
    }

    @Override
    public ShisetsuTaishoTsuchishoReportSource edit(ShisetsuTaishoTsuchishoReportSource source) {

        return source;
    }
}
