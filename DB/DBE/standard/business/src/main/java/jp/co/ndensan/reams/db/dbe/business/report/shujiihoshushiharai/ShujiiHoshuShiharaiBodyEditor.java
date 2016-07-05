/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiihoshushiharai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiihoshushiharai.ShujiiHoshuShiharaiBodyEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiihoshushiharai.ShujiiHoshuShiharaiReportSource;

/**
 * 帳票設計_DBE621002_主治医意見書作成報酬支払通知書のShujiiHoshuShiharaiBodyEditorです。
 *
 * @reamsid_L DBE-1980-040 xuyongchao
 */
public class ShujiiHoshuShiharaiBodyEditor implements IShujiiHoshuShiharaiBodyEditor {

    private final ShujiiHoshuShiharaiBodyEntity bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem bodyItem
     */
    protected ShujiiHoshuShiharaiBodyEditor(ShujiiHoshuShiharaiBodyEntity bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public ShujiiHoshuShiharaiReportSource edit(ShujiiHoshuShiharaiReportSource source) {
        source.listGokei_1 = bodyItem.getListGokei_1();
        source.listGokei_2 = bodyItem.getListGokei_2();
        source.listGokei_3 = bodyItem.getListGokei_3();
        return source;
    }
}
