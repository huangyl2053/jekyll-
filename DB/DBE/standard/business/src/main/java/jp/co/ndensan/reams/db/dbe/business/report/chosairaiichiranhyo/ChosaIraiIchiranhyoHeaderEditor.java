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

    private static final int INT_0 = 0;
    private static final int INT_45 = 45;
    private static final int INT_90 = 90;
    private static final int INT_135 = 135;
    private static final int INT_180 = 180;
    private static final int INT_225 = 225;
    private static final int INT_270 = 270;
    private static final int INT_315 = 315;
    private static final int INT_360 = 360;
    private static final int INT_405 = 405;
    private static final int INT_450 = 450;
    private static final int INT_495 = 495;
    private static final int INT_540 = 540;
    private static final int INT_585 = 585;
    private static final int INT_630 = 630;
    private static final int INT_675 = 675;
    private static final int INT_720 = 720;
    private static final int INT_765 = 765;
    private static final int INT_810 = 810;
    private final ChosaIraiIchiranhyoHeadItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosaIraiIchiranhyoHeadItem}
     */
    protected ChosaIraiIchiranhyoHeaderEditor(ChosaIraiIchiranhyoHeadItem item) {
        this.item = item;
    }

    /**
     *
     * @param source 認定調査依頼一覧表Sourceクラスです
     * @return ChosaIraiIchiranhyoReportSource 認定調査依頼一覧表Sourceクラスです
     */
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
        if (item.getTsuchibun().length() <= INT_45) {
            source.tsuchibun1 = item.getTsuchibun();
        }
        if (item.getTsuchibun().length() >= INT_45) {
            source.tsuchibun1 = item.getTsuchibun().substring(INT_0, INT_45);
        }
        if (item.getTsuchibun().length() >= INT_90) {
            source.tsuchibun2 = item.getTsuchibun().substring(INT_45, INT_90);
        }
        if (item.getTsuchibun().length() >= INT_135) {
            source.tsuchibun3 = item.getTsuchibun().substring(INT_90, INT_135);
        }
        if (item.getTsuchibun().length() >= INT_180) {
            source.tsuchibun4 = item.getTsuchibun().substring(INT_135, INT_180);
        }
        if (item.getTsuchibun().length() >= INT_225) {
            source.tsuchibun5 = item.getTsuchibun().substring(INT_180, INT_225);
        }
        if (item.getTsuchibun().length() >= INT_270) {
            source.tsuchibun6 = item.getTsuchibun().substring(INT_225, INT_270);
        }
        if (item.getTsuchibun().length() >= INT_315) {
            source.tsuchibun7 = item.getTsuchibun().substring(INT_270, INT_315);
        }
        if (item.getTsuchibun().length() >= INT_360) {
            source.tsuchibun8 = item.getTsuchibun().substring(INT_315, INT_360);
        }
        if (item.getTsuchibun().length() >= INT_405) {
            source.tsuchibun9 = item.getTsuchibun().substring(INT_360, INT_405);
        }
        if (item.getTsuchibun().length() >= INT_450) {
            source.tsuchibun10 = item.getTsuchibun().substring(INT_405, INT_450);
        }
        if (item.getTsuchibun().length() >= INT_495) {
            source.tsuchibun11 = item.getTsuchibun().substring(INT_450, INT_495);
        }
        if (item.getTsuchibun().length() >= INT_540) {
            source.tsuchibun12 = item.getTsuchibun().substring(INT_495, INT_540);
        }
        if (item.getTsuchibun().length() >= INT_585) {
            source.tsuchibun13 = item.getTsuchibun().substring(INT_540, INT_585);
        }
        if (item.getTsuchibun().length() >= INT_630) {
            source.tsuchibun14 = item.getTsuchibun().substring(INT_585, INT_630);
        }
        if (item.getTsuchibun().length() >= INT_675) {
            source.tsuchibun15 = item.getTsuchibun().substring(INT_630, INT_675);
        }
        if (item.getTsuchibun().length() >= INT_720) {
            source.tsuchibun16 = item.getTsuchibun().substring(INT_675, INT_720);
        }
        if (item.getTsuchibun().length() >= INT_765) {
            source.tsuchibun17 = item.getTsuchibun().substring(INT_720, INT_765);
        }
        if (item.getTsuchibun().length() >= INT_810) {
            source.tsuchibun18 = item.getTsuchibun().substring(INT_765, INT_810);
        }
        return source;
    }

}
