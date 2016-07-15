/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.iinhoshushiharai;

import jp.co.ndensan.reams.db.dbe.business.core.iinhoshushiharai.IinhoshushiharaiBody;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinhoshushiharai.IinhoshushiharaiReportSource;

/**
 * 介護認定審査会委員報酬支払通知書のEditorです。
 *
 * @reamsid_L DBE-1980-030 suguangjun
 */
public class IinhoshushiharaiBodyEditor implements IIinhoshushiharaiBodyEditor {

    private final IinhoshushiharaiBody item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link IinhoshushiharaiBody}
     */
    protected IinhoshushiharaiBodyEditor(IinhoshushiharaiBody item) {
        this.item = item;
    }

    @Override
    public IinhoshushiharaiReportSource edit(IinhoshushiharaiReportSource source) {
        return editSource(source);
    }

    private IinhoshushiharaiReportSource editSource(IinhoshushiharaiReportSource source) {
        source.listHoshuhi_1 = item.getListHoshuhi_1();
        source.listGokei_1 = item.getListGokei_1();
        return source;
    }
}
