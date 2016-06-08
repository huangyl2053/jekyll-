/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaisukejuruhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaisukejuruhyo.ShinsakaisukejuruhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 介護認定審査会スケジュール表ヘッダEditorです。
 *
 * @reamsid_L DBE-0130-070 yaodongsheng
 */
class ShinsakaisukejuruhyoHeaderEditor implements IShinsakaisukejuruhyoEditor {

    private static final RString タイトル後 = new RString("　審査会スケジュール");
    private final ShinsakaisukejuruhyoHeadItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShinsakaisukejuruhyoHeadItem}
     */
    protected ShinsakaisukejuruhyoHeaderEditor(ShinsakaisukejuruhyoHeadItem item) {
        this.item = item;
    }

    @Override
    public ShinsakaisukejuruhyoReportSource edit(ShinsakaisukejuruhyoReportSource source) {
        return editHeader(source);
    }

    private ShinsakaisukejuruhyoReportSource editHeader(ShinsakaisukejuruhyoReportSource source) {
        RStringBuilder title = new RStringBuilder();
        source.title = title.append(item.get年度()).append(タイトル後).toRString();
        source.hokenshaName = item.get広域連合();
        source.printTimeStamp = item.get作成年月日();
        return source;
    }
}
