/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.kojinshinchokujokyohyo.KojinShinchokuJokyohyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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
 *
 * @reamsid_L DBE-0200-040 zhangzhiming
 */
class KojinShinchokuJokyohyoHeadEditor implements IKojinShinchokuJokyohyoEditor {

    private final KojinShinchokuJokyohyoHeadItem item;
    private static final int 結束_位置3 = 3;
    private static final int 結束_位置4 = 4;
    private static final int 結束_位置5 = 5;
    private static final int 結束_位置6 = 6;
    private static final int 結束_位置7 = 7;
    private static final int 結束_位置8 = 8;
    private static final int 結束_位置9 = 9;
    private static final int 結束_位置10 = 10;

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
        RString hihokenshaNo = item.getHihokenshaNo();
        if (hihokenshaNo == null) {
            hihokenshaNo = RString.EMPTY;
        }
        if (hihokenshaNo.length() < 結束_位置10) {
            hihokenshaNo = hihokenshaNo.padRight(RString.HALF_SPACE, 結束_位置10);
        }
        source.hihokenshaNo1 = hihokenshaNo.substring(0, 1);
        source.hihokenshaNo2 = hihokenshaNo.substring(1, 2);
        source.hihokenshaNo3 = hihokenshaNo.substring(2, 結束_位置3);
        source.hihokenshaNo4 = hihokenshaNo.substring(結束_位置3, 結束_位置4);
        source.hihokenshaNo5 = hihokenshaNo.substring(結束_位置4, 結束_位置5);
        source.hihokenshaNo6 = hihokenshaNo.substring(結束_位置5, 結束_位置6);
        source.hihokenshaNo7 = hihokenshaNo.substring(結束_位置6, 結束_位置7);
        source.hihokenshaNo8 = hihokenshaNo.substring(結束_位置7, 結束_位置8);
        source.hihokenshaNo9 = hihokenshaNo.substring(結束_位置8, 結束_位置9);
        source.hihokenshaNo10 = hihokenshaNo.substring(結束_位置9, 結束_位置10);
        source.shinseiKubun = item.getShinseiKubun();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        RStringBuilder shinseiYMD = new RStringBuilder();
        if (RString.isNullOrEmpty(item.getShinseiYMD())) {
            source.shinseiYMD = RString.EMPTY;
        } else {
            Wareki shinsei = new RDate(item.getShinseiYMD().toString()).wareki();
            shinseiYMD.append(shinsei.eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).
                    fillType(FillType.ZERO).toDateString());
            source.shinseiYMD = shinseiYMD.toRString();
        }
        source.seibetsu = item.getSeibetsu();
        source.hihokenshaName = item.getHihokenshaName();
        RStringBuilder birthYMD = new RStringBuilder();
        if (RString.isNullOrEmpty(item.getBirthYMD())) {
            source.birthYMD = RString.EMPTY;
        } else {
            Wareki birth = new RDate(item.getBirthYMD().toString()).wareki();
            birthYMD.append(birth.eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).
                    fillType(FillType.ZERO).toDateString());
            source.birthYMD = birthYMD.toRString();
        }
        source.age = item.getAge();
        source.yubinNo1 = editedYubinNo(item.getYubinNo1());
        source.hihokenshaJusho = item.getHihokenshaJusho();
        source.telNo1 = item.getTelNo1();
        source.shinseiRiyu = item.getShinseiRiyu();
        source.shinseishaName = item.getShinseishaName();
        source.shinseiDaikoJigyoshaName = item.getShinseiDaikoJigyoshaName();
        source.shinseishaKankei = item.getShinseishaKankei();
        source.honninKankei = item.getHonninKankei();
        source.yubinNo2 = editedYubinNo(item.getYubinNo2());
        source.shinseishaJusho = item.getShinseishaJusho();
        source.telNo2 = item.getTelNo2();
        source.shisetsuName = item.getShisetsuName();
        source.shisetsujusho = item.getShisetsujusho();
        source.telNo3 = item.getTelNo3();
        return source;
    }

    private RString editedYubinNo(RString yubinNo) {
        return yubinNo == null ? RString.EMPTY : new YubinNo(yubinNo).getEditedYubinNo();
    }
}
