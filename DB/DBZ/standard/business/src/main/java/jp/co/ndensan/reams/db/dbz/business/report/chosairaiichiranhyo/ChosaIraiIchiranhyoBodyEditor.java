/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.chosairaiichiranhyo;

import jp.co.ndensan.reams.db.dbz.entity.report.chosairaiichiranhyo.ChosaIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 認定調査依頼一覧表ボディEditorです。
 *
 * @reamsid_L DBE-0010-030 lishengli
 */
class ChosaIraiIchiranhyoBodyEditor implements IChosaIraiIchiranhyoEditor {

    private final ChosaIraiIchiranhyoBodyItem item;
    private final int index;
    private final int pageCount;
    private static final RString 非表示_事業者番号 = new RString("0000000000");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosaIraiIchiranhyoBodyItem}
     */
    protected ChosaIraiIchiranhyoBodyEditor(ChosaIraiIchiranhyoBodyItem item, int index, int pageCount) {
        this.item = item;
        this.index = index;
        this.pageCount = pageCount;
    }

    /**
     *
     * @param source 認定調査依頼一覧表Sourceクラス
     * @return ChosaIraiIchiranhyoReportSource 認定調査依頼一覧表Sourceクラス
     */
    @Override
    public ChosaIraiIchiranhyoReportSource edit(ChosaIraiIchiranhyoReportSource source) {
        return editBody(source);
    }

    private ChosaIraiIchiranhyoReportSource editBody(ChosaIraiIchiranhyoReportSource source) {
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
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
        source.hakkoYMD = item.getHakkoYMD();
        source.denshiKoin = item.getDenshiKoin();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.ninshoshaYakushokuMei2 = item.getNinshoshaYakushokuMei2();
        source.ninshoshaYakushokuMei1 = item.getNinshoshaYakushokuMei1();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.koinShoryaku = item.getKoinShoryaku();
        source.yubinNo1 = item.getYubinNo1();
        source.jushoText = item.getJushoText();
        source.kikanNameText = item.getKikanNameText();
        source.meishoFuyo = item.getMeishoFuyo();
        if (!item.getJigyoshaNo().isEmpty()) {
            if (!非表示_事業者番号.equals(item.getJigyoshaNo())) {
                source.lbl_jigyoshaNo = new RString("（事業者番号）");
                source.jigyoshaNo = item.getJigyoshaNo();
            }
        }
        source.title = item.getTitle();
        source.tsuchibun1 = item.getTsuchibun1();
        source.tsuchibun2 = item.getTsuchibun2();
        source.listIchiranhyo_1 = new RString(index);
        source.listIchiranhyo_2 = item.getListIchiranhyo_2();
        source.listIchiranhyo_3 = item.getListIchiranhyo_3();
        if (item.getListIchiranhyo_4() == null || item.getListIchiranhyo_4().isEmpty()) {
            source.listIchiranhyo_4 = RString.EMPTY;
        } else {
            source.listIchiranhyo_4 = to元号略称表記(new RDate(item.getListIchiranhyo_4().toString()));
        }
        source.listIchiranhyo_5 = item.getListIchiranhyo_5();
        source.listIchiranhyo_6 = item.getListIchiranhyo_6();
        source.listIchiranhyo_7 = item.getListIchiranhyo_7();
        source.listIchiranhyo_8 = item.getListIchiranhyo_8();
        if (item.getListIchiranhyo_9() == null || item.getListIchiranhyo_9().isEmpty()) {
            source.listIchiranhyo_9 = RString.EMPTY;
        } else {
            source.listIchiranhyo_9 = to元号略称表記(new RDate(item.getListIchiranhyo_9().toString()));
        }
        source.listIchiranhyo_10 = item.getListIchiranhyo_10();
        source.listIchiranhyo_11 = item.getListIchiranhyo_11();
        if (item.getListIchiranhyo_12() == null || item.getListIchiranhyo_12().isEmpty()) {
            source.listIchiranhyo_12 = RString.EMPTY;
        } else {
            source.listIchiranhyo_12 = to元号略称表記(new RDate(item.getListIchiranhyo_12().toString()));
        }
        source.shichosoncode = item.getShichosonCode();
        source.chosaitakusakicode = item.getChosaItakusakiCode();
        source.pageCountForItakusaki = new RString(pageCount);
        return source;
    }

    private RString to元号略称表記(RDate rDate) {
        return rDate.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).toDateString();
    }
}
