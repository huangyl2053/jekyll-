/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyo;

import jp.co.ndensan.reams.db.dbe.entity.report.chosaschedulehyo.ChosaSchedulehyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 認定調査スケジュール表(事務所)ヘッダEditorです。
 */
class ChosaSchedulehyoHeaderEditor implements ChosaSchedulehyoEditor {

    private final ChosaSchedulehyoHeadItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosaSchedulehyoItem}
     */
    protected ChosaSchedulehyoHeaderEditor(ChosaSchedulehyoHeadItem item) {
        this.item = item;
    }

    @Override
    public ChosaSchedulehyoReportSource edit(ChosaSchedulehyoReportSource source) {
        return editHeader(source);
    }

    private ChosaSchedulehyoReportSource editHeader(ChosaSchedulehyoReportSource source) {

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
        // TODO QA:761 張国朋 印刷日時の編集方法修正待ち。2016/02/24まで
        source.printTimeStamp = systemDateTime.toRString();
        source.title = item.getTitle();
        source.chosaItakusakiNo = item.getChosaItakusakiNo();
        source.chosaItakusakiName = item.getChosaItakusakiName();
        // TODO QA:761 張国朋 QA待ち。　2016/02/24まで
        source.chosaTaishoYY = new RDate(item.getChosaTaishoYY().toString()).wareki().eraType(EraType.KANJI_RYAKU).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString();
        source.chosaTaishoMM = new RDate(item.getChosaTaishoMM().toString()).wareki().eraType(EraType.KANJI_RYAKU).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString();
        return source;
    }
}
