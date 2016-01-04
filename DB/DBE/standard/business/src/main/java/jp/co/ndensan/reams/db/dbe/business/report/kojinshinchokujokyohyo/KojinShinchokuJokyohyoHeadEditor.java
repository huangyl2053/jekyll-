/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.KojinShinchokuJokyohyo.KojinShinchokuJokyohyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Wareki;

/**
 * 要介護認定個人進捗状況票ヘッダEditorです。
 */
class KojinShinchokuJokyohyoHeadEditor implements KojinShinchokuJokyohyoEditor {

    private final KojinShinchokuJokyohyoHeadItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KojinShinchokuJokyohyoHeadItem}
     */
    protected KojinShinchokuJokyohyoHeadEditor(KojinShinchokuJokyohyoHeadItem item) {
        this.item = item;
    }

    @Override
    public KojinShinchokuJokyohyoReportSource edit(KojinShinchokuJokyohyoReportSource source) {
        return editHeader(source);
    }

    private KojinShinchokuJokyohyoReportSource editHeader(KojinShinchokuJokyohyoReportSource source) {
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
        source.title = new RString("個人進捗状況一覧表");
        source.hihokenshaNo1 = item.getHihokenshaNo().substring(0, 1);
        source.hihokenshaNo2 = item.getHihokenshaNo().substring(1, 2);
        source.hihokenshaNo3 = item.getHihokenshaNo().substring(2, 3);
        source.hihokenshaNo4 = item.getHihokenshaNo().substring(3, 4);
        source.hihokenshaNo5 = item.getHihokenshaNo().substring(4, 5);
        source.hihokenshaNo6 = item.getHihokenshaNo().substring(5, 6);
        source.hihokenshaNo7 = item.getHihokenshaNo().substring(6, 7);
        source.hihokenshaNo8 = item.getHihokenshaNo().substring(7, 8);
        source.hihokenshaNo9 = item.getHihokenshaNo().substring(8, 9);
        source.hihokenshaNo10 = item.getHihokenshaNo().substring(9, 10);
        source.shinseiKubun = item.getShinseiKubun();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        RStringBuilder shinseiYMD = new RStringBuilder();
        Wareki shinsei = new RDate(item.getShinseiYMD().toString()).wareki();
        shinseiYMD.append(shinsei.eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        source.shinseiYMD = shinseiYMD.toRString();
        source.seibetsu = item.getSeibetsu();
        source.hihokenshaName = item.getHihokenshaName();
        RStringBuilder birthYMD = new RStringBuilder();
        Wareki birth = new RDate(item.getBirthYMD().toString()).wareki();
        birthYMD.append(birth.eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        source.birthYMD = birthYMD.toRString();
        source.age = item.getAge();
        source.yubinNo1 = item.getYubinNo1();
        source.hihokenshaJusho = item.getHihokenshaJusho();
        source.telNo1 = item.getTelNo1();
        source.shinseiRiyu = item.getShinseiRiyu();
        source.shinseishaName = item.getShinseishaName();
        source.shinseiDaikoJigyoshaName = item.getShinseiDaikoJigyoshaName();
        source.shinseishaKankei = item.getShinseishaKankei();
        source.honninKankei = item.getHonninKankei();
        source.yubinNo2 = item.getYubinNo2();
        source.shinseishaJusho = item.getShinseishaJusho();
        source.telNo2 = item.getTelNo2();
        source.shisetsuName = item.getShisetsuName();
        source.shisetsujusho = item.getShisetsujusho();
        source.telNo3 = item.getTelNo3();
        return source;
    }
}
