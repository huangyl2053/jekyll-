/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshiharaiuchiwake;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshiharaiuchiwake.IkenShiharaiuchiwakeBodyEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshiharaiuchiwake.IkenShiharaiuchiwakeReportSource;

/**
 * 帳票設計_DBE622004_主治医意見書作成料支払内訳確認書のIkenShiharaiuchiwakeBodyEditorです。
 *
 * @reamsid_L DBE-1980-047 xuyongchao
 */
public class IkenShiharaiuchiwakeBodyEditor implements IIkenShiharaiuchiwakeBodyEditor {

    private final IkenShiharaiuchiwakeBodyEntity bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param bodyItem bodyItem
     */
    protected IkenShiharaiuchiwakeBodyEditor(IkenShiharaiuchiwakeBodyEntity bodyItem) {
        this.bodyItem = bodyItem;
    }

    @Override
    public IkenShiharaiuchiwakeReportSource edit(IkenShiharaiuchiwakeReportSource source) {
        source.listShiharaiuchiwake_1 = bodyItem.getListShiharaiuchiwake_1();
        source.listShiharaiuchiwake_2 = bodyItem.getListShiharaiuchiwake_2();
        source.listShiharaiuchiwake_3 = bodyItem.getListShiharaiuchiwake_3();
        source.listShiharaiuchiwake_4 = bodyItem.getListShiharaiuchiwake_4();
        source.listShiharaiuchiwake_5 = bodyItem.getListShiharaiuchiwake_5();
        return source;
    }
}
