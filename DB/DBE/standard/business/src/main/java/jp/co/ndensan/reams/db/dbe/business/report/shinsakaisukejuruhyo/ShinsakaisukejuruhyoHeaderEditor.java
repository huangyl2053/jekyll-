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
 */
class ShinsakaisukejuruhyoHeaderEditor implements IShinsakaisukejuruhyoEditor {

    private static final RString タイトル後 = new RString("　審査会スケジュール");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString DATE_作成 = new RString("作成");
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
