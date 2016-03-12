/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaisukejuruhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaisukejuruhyo.ShinsakaisukejuruhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

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
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStamp = new RStringBuilder();
        printTimeStamp.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        printTimeStamp.append(RString.HALF_SPACE);
        printTimeStamp.append(String.format("%02d", printdate.getHour()));
        printTimeStamp.append(DATE_時);
        printTimeStamp.append(String.format("%02d", printdate.getMinute()));
        printTimeStamp.append(DATE_分);
        printTimeStamp.append(String.format("%02d", printdate.getSecond()));
        printTimeStamp.append(DATE_秒);
        printTimeStamp.append(RString.HALF_SPACE);
        printTimeStamp.append(DATE_作成);
        source.printTimeStamp = printTimeStamp.toRString();
        return source;
    }
}
