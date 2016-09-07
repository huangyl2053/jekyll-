/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshiharaiuchiwake;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshiharaiuchiwake.IkenShiharaiuchiwakeEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshiharaiuchiwake.IkenShiharaiuchiwakeReportSource;

/**
 * 帳票設計_DBE622004_主治医意見書作成料支払内訳確認書のIkenShiharaiuchiwakeDetailEditorです。
 *
 * @reamsid_L DBE-1980-047 xuyongchao
 */
public class IkenShiharaiuchiwakeDetailEditor implements IIkenShiharaiuchiwakeEditor {

    private final IkenShiharaiuchiwakeEntity detailItem;

    /**
     * インスタンスを生成します。
     *
     * @param detailItem {@link IkenShiharaiuchiwakeDetailEntity}
     */
    public IkenShiharaiuchiwakeDetailEditor(IkenShiharaiuchiwakeEntity detailItem) {
        this.detailItem = detailItem;
    }

    @Override
    public IkenShiharaiuchiwakeReportSource edit(IkenShiharaiuchiwakeReportSource source) {
        source.hakkoYMD = detailItem.get発行日();
        source.detail_listShiharaiuchiwake_1 = detailItem.get明細番号();
        source.detail_listShiharaiuchiwake_2 = detailItem.get被保険者番号();
        source.detail_listShiharaiuchiwake_3 = detailItem.get被保険者氏名();
        source.detail_listShiharaiuchiwake_4 = detailItem.get内訳住所();
        source.detail_listShiharaiuchiwake_5 = detailItem.get金額();
        return source;
    }
}
