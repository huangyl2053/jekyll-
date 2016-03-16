/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshosakuseiiraiichiranhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成依頼一覧Editorです。
 */
public class IkenshoSakuseiIraiIchiranhyoBodyEditor implements IkenshoSakuseiIraiIchiranhyoEditor {

    private final IkenshoSakuseiIraiIchiranhyoBodyItem item;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link IkenshoSakuseiIraiIchiranhyoHeadEditor}
     * @param index int
     */
    protected IkenshoSakuseiIraiIchiranhyoBodyEditor(IkenshoSakuseiIraiIchiranhyoBodyItem item, int index) {
        this.item = item;
        this.index = index;
    }

    @Override
    public IkenshoSakuseiIraiIchiranhyoReportSource edit(IkenshoSakuseiIraiIchiranhyoReportSource source) {
        return editSource(source);
    }

    private IkenshoSakuseiIraiIchiranhyoReportSource editSource(IkenshoSakuseiIraiIchiranhyoReportSource source) {
        source.listIchiranhyo_1 = new RString(String.valueOf(index));
        source.listIchiranhyo_2 = item.getListIchiranhyo_2();
        source.listIchiranhyo_3 = item.getListIchiranhyo_3();
        source.listIchiranhyo_4 = item.getListIchiranhyo_4();
        source.listIchiranhyo_5 = item.getListIchiranhyo_5();
        source.listIchiranhyo_6 = item.getListIchiranhyo_6();
        source.listIchiranhyo_7 = item.getListIchiranhyo_7();
        source.listIchiranhyo_8 = item.getListIchiranhyo_8();
        source.listIchiranhyo_9 = item.getListIchiranhyo_9();
        return source;
    }
}
