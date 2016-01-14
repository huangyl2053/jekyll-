/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaiichiranhyo.ChosaIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 *
 * 認定調査依頼一覧表ヘッダEditorです。
 */
class ChosaIraiIchiranhyoHeaderEditor implements IChosaIraiIchiranhyoEditor {

    private final ChosaIraiIchiranhyoHeadItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosaIraiIchiranhyoHeadItem}
     */
    protected ChosaIraiIchiranhyoHeaderEditor(ChosaIraiIchiranhyoHeadItem item) {
        this.item = item;
    }

    @Override
    public ChosaIraiIchiranhyoReportSource edit(ChosaIraiIchiranhyoReportSource source) {
        return editHeader(source);
    }

    private ChosaIraiIchiranhyoReportSource editHeader(ChosaIraiIchiranhyoReportSource source) {
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = item.getPrintTimeStamp();
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
        source.shomeiHakkoYMD = item.getShomeiHakkoYMD();
        source.yubinNo = item.getYubinNo();
        source.shichosonMei = RString.EMPTY;
        source.shuchoMei = item.getShuchoMei();
        source.jigyoshaJusho = item.getJigyoshaJusho();
        source.koinShoryaku = item.getKoinShoryaku();
        source.denshiKoin = item.getDenshiKoin();
        source.jigyoshaName = item.getJigyoshaName();
        source.jigyoshaNo = item.getJigyoshaNo();
        source.tsuchibun1 = item.getTsuchibun1();
        source.tsuchibun2 = item.getTsuchibun2();
        source.tsuchibun3 = item.getTsuchibun3();
        source.tsuchibun4 = item.getTsuchibun4();
        source.tsuchibun5 = item.getTsuchibun5();
        source.tsuchibun6 = item.getTsuchibun6();
        source.tsuchibun7 = item.getTsuchibun7();
        source.tsuchibun8 = item.getTsuchibun8();
        source.tsuchibun9 = item.getTsuchibun9();
        source.tsuchibun10 = item.getTsuchibun10();
        source.tsuchibun11 = item.getTsuchibun11();
        source.tsuchibun12 = item.getTsuchibun12();
        source.tsuchibun13 = item.getTsuchibun13();
        source.tsuchibun14 = item.getTsuchibun14();
        source.tsuchibun15 = item.getTsuchibun15();
        source.tsuchibun16 = item.getTsuchibun16();
        source.tsuchibun17 = item.getTsuchibun17();
        source.tsuchibun18 = item.getTsuchibun18();
        return source;
    }

}
