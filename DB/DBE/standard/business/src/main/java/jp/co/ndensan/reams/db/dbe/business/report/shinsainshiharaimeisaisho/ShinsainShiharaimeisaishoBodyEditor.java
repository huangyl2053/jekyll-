/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsainshiharaimeisaisho;

import jp.co.ndensan.reams.db.dbe.business.core.shinsainshiharaimeisaisho.ShinsainShiharaimeisaishoBody;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsainshiharaimeisaisho.ShinsainShiharaimeisaishoReportSource;

/**
 * 介護認定審査会委員報酬支払明細書のEditorです。
 *
 * @reamsid_L DBE-1980-046 suguangjun
 */
public class ShinsainShiharaimeisaishoBodyEditor implements IShinsainShiharaimeisaishoBodyEditor {

    private final ShinsainShiharaimeisaishoBody item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShinsainShiharaimeisaishoBody}
     */
    protected ShinsainShiharaimeisaishoBodyEditor(ShinsainShiharaimeisaishoBody item) {
        this.item = item;
    }

    @Override
    public ShinsainShiharaimeisaishoReportSource edit(ShinsainShiharaimeisaishoReportSource source) {
        return editSource(source);
    }

    private ShinsainShiharaimeisaishoReportSource editSource(ShinsainShiharaimeisaishoReportSource source) {
        source.listChosaSakusei_1 = item.getListChosaSakusei_1();
        source.listChosaSakusei_2 = item.getListChosaSakusei_2();
        source.listChosaSakusei_3 = item.getListChosaSakusei_3();
        source.listChosaSakusei_4 = item.getListChosaSakusei_4();
        source.listChosaSakusei_5 = item.getListChosaSakusei_5();
        source.listChosaSakusei_6 = item.getListChosaSakusei_6();
        source.listChosaSakusei_7 = item.getListChosaSakusei_7();
        source.listChosaSakusei_8 = item.getListChosaSakusei_8();
        source.listChosaSakusei_9 = item.getListChosaSakusei_9();
        source.listGokeiKingaku_1 = item.getListGokeiKingaku_1();
        return source;
    }
}
