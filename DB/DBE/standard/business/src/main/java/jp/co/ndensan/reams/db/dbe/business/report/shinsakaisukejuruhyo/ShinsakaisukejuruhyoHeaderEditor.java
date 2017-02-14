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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

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
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(String.format("%02d", datetime.getHour()));
        systemDateTime.append(new RString("時"));
        systemDateTime.append(String.format("%02d", datetime.getMinute()));
        systemDateTime.append(new RString("分"));
        systemDateTime.append(String.format("%02d", datetime.getSecond()));
        systemDateTime.append(new RString("秒"));
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(new RString("作成"));
        source.printTimeStamp = systemDateTime.toRString();

        return source;
    }
}
