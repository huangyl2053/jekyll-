/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshushiharai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahoshushiharai.ChosaHoshuShiharaiBodyEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshushiharai.ChosaHoshuShiharaiReportSource;

/**
 * 帳票設計_DBE621003_認定調査報酬支払通知書のChosaHoshuShiharaiBodyEditorです。
 *
 * @reamsid_L DBE-1980-041 xuyongchao
 */
public class ChosaHoshuShiharaiBodyEditor implements IChosaHoshuShiharaiBodyEditor {

    private final ChosaHoshuShiharaiBodyEntity bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem bodyItem
     */
    protected ChosaHoshuShiharaiBodyEditor(ChosaHoshuShiharaiBodyEntity bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public ChosaHoshuShiharaiReportSource edit(ChosaHoshuShiharaiReportSource source) {
        source.listGokei_1 = bodyItem.getListGokei_1();
        source.listGokei_2 = bodyItem.getListGokei_2();
        source.listGokei_3 = bodyItem.getListGokei_3();
        return source;
    }

}
