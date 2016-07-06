/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshuseikyu;

import jp.co.ndensan.reams.db.dbe.business.core.chosahoshuseikyu.ChosahoshuseikyuBody;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshuseikyu.ChosahoshuseikyuReportSource;

/**
 * 認定調査報酬請求書のEditorです。
 *
 * @reamsid_L DBE-1980-043 suguangjun
 */
public class ChosahoshuseikyuBodyEditor implements IChosahoshuseikyuBodyEditor {

    private final ChosahoshuseikyuBody item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosahoshuseikyuBody}
     */
    protected ChosahoshuseikyuBodyEditor(ChosahoshuseikyuBody item) {
        this.item = item;
    }

    @Override
    public ChosahoshuseikyuReportSource edit(ChosahoshuseikyuReportSource source) {
        return editSource(source);
    }

    private ChosahoshuseikyuReportSource editSource(ChosahoshuseikyuReportSource source) {
        source.listGokei_1 = item.getListGokei_1();
        source.listGokei_2 = item.getListGokei_2();
        source.listGokei_3 = item.getListGokei_3();
        return source;
    }
}
