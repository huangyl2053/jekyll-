/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyojikankanri;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosaschedulehyojikankanri.ChosaSchedulehyoJikankanriReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 *
 * 認定調査スケジュール表(時間管理)ヘッダEditorです。
 */
public class ChosaSchedulehyoJikankanriHeaderEditor implements IChosaSchedulehyoJikankanriEditor {

    private static final RString TITLE = new RString("認定調査スケジュール表");
    private final ChosaSchedulehyoJikankanriHeadItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosaSchedulehyoJikankanriHeadItem}
     */
    protected ChosaSchedulehyoJikankanriHeaderEditor(ChosaSchedulehyoJikankanriHeadItem item) {
        this.item = item;
    }

    /**
     *
     * @param source 認定調査スケジュール表(時間管理)Sourceクラスです
     * @return ChosaSchedulehyoJikankanriReportSource
     */
    @Override
    public ChosaSchedulehyoJikankanriReportSource edit(ChosaSchedulehyoJikankanriReportSource source) {
        return editHeader(source);
    }

    private ChosaSchedulehyoJikankanriReportSource editHeader(ChosaSchedulehyoJikankanriReportSource source) {
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
        source.title = TITLE;
        source.chosaItakusakiNo = item.getChosaItakusakiNo();
        source.chosaItakusakiName = item.getChosaItakusakiName();
        return source;
    }
}
