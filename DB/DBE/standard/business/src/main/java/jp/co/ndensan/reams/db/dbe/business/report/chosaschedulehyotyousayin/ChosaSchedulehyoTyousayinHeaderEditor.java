/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyotyousayin;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosaschedulehyotyousayin.ChosaSchedulehyoTyousayinReportSource;
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
 * 認定調査スケジュール表(調査員)ヘッダEditorです。
 */
class ChosaSchedulehyoTyousayinHeaderEditor implements IChosaSchedulehyoTyousayinEditor {

    private final ChosaSchedulehyoTyousayinHeadItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosaSchedulehyoTyousayinHeadItem}
     */
    protected ChosaSchedulehyoTyousayinHeaderEditor(ChosaSchedulehyoTyousayinHeadItem item) {
        this.item = item;
    }

    /**
     *
     * @param source 認定調査スケジュール表(調査員)Sourceクラス
     * @return ChosaSchedulehyoTyousayinReportSource 認定調査スケジュール表(調査員)Sourceクラス
     */
    @Override
    public ChosaSchedulehyoTyousayinReportSource edit(ChosaSchedulehyoTyousayinReportSource source) {
        return editHeader(source);
    }

    private ChosaSchedulehyoTyousayinReportSource editHeader(ChosaSchedulehyoTyousayinReportSource source) {
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
        source.title = new RString("認定調査スケジュール表");
        source.chosaItakusakiName = item.getChosaItakusakiName();
        source.chosaItakusakiNo = item.getChosaItakusakiNo();
        return source;
    }
}
