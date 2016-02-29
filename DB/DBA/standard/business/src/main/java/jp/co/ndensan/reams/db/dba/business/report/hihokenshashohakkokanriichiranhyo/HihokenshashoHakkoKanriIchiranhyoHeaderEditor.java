/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.source.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoReportSource;
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
 * 被保険者証発行管理一覧表ヘッダEditorクラスです。
 */
public class HihokenshashoHakkoKanriIchiranhyoHeaderEditor implements IHihokenshashoHakkoKanriIchiranhyoEditor {

    private static final RString TITLE = new RString("介護保険　被保険者証発行管理一覧表");
    private final HihokenshashoHakkoKanriIchiranhyoHeadItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link HihokenshashoHakkoKanriIchiranhyoHeadItem}
     */
    protected HihokenshashoHakkoKanriIchiranhyoHeaderEditor(HihokenshashoHakkoKanriIchiranhyoHeadItem item) {
        this.item = item;
    }

    /**
     *
     * @param source 被保険者証発行管理一覧表のReportSourceクラス
     * @return HihokenshashoHakkoKanriIchiranhyoReportSource
     */
    @Override
    public HihokenshashoHakkoKanriIchiranhyoReportSource edit(HihokenshashoHakkoKanriIchiranhyoReportSource source) {
        return editHeader(source);
    }

    private HihokenshashoHakkoKanriIchiranhyoReportSource editHeader(HihokenshashoHakkoKanriIchiranhyoReportSource source) {
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
        source.shichosonCode = item.getShichosonCode();
        source.shichosonName = item.getShichosonName();
        source.kaipage1 = item.getKaipage1();
        source.kaipage2 = item.getKaipage2();
        source.kaipage3 = item.getKaipage3();
        source.kaipage4 = item.getKaipage4();
        source.kaipage5 = item.getKaipage5();
        source.shutsuryokujun1 = item.getShutsuryokujun1();
        source.shutsuryokujun2 = item.getShutsuryokujun2();
        source.shutsuryokujun3 = item.getShutsuryokujun3();
        source.shutsuryokujun4 = item.getShutsuryokujun4();
        source.shutsuryokujun5 = item.getShutsuryokujun5();
        return source;
    }
}
