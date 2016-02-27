/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kaigohokenshindanmeireisho;

import jp.co.ndensan.reams.db.dbe.entity.report.source.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 *
 * 介護保険診断命令書ヘッダEditorです。
 */
public class KaigohokenShindanMeireishoHeaderEditor implements IKaigohokenShindanMeireishoEditor {

    private static final RString TITLE = new RString("介護保険診断命令書");
    private static final int 結束_位置3 = 3;
    private static final int 結束_位置4 = 4;
    private static final int 結束_位置5 = 5;
    private static final int 結束_位置6 = 6;
    private static final int 結束_位置7 = 7;
    private static final int 結束_位置8 = 8;
    private static final int 結束_位置9 = 9;
    private static final int 結束_位置10 = 10;
    private final KaigohokenShindanMeireishoHeaderItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosaSchedulehyoJikankanriHeadItem}
     */
    protected KaigohokenShindanMeireishoHeaderEditor(KaigohokenShindanMeireishoHeaderItem item) {
        this.item = item;
    }

    @Override
    public KaigohokenShindanMeireishoReportSource edit(KaigohokenShindanMeireishoReportSource source) {
        return editHeader(source);

    }

    private KaigohokenShindanMeireishoReportSource editHeader(KaigohokenShindanMeireishoReportSource source) {

        source.shomeiHakkoYMD = item.getShomeiHakkoYMD();
        source.shichosonMei = item.getShichosonMei();
        source.shuchoMei = item.getShuchoMei();
        source.koinShoryaku = item.getKoinShoryaku();
        source.denshiKoin = item.getDenshiKoin();
        source.bunshoNo = item.getBunshoNo();
        if (item.getHakkoYMD() == null || item.getHakkoYMD().isEmpty()) {
            source.hakkoYMD = RString.EMPTY;
        } else {
            source.hakkoYMD = パターン12(new RDate(item.getHakkoYMD().toString()));
        }
        source.title = TITLE;
        source.tsuchibun1 = item.getTsuchibun1();
        source.tsuchibun2 = item.getTsuchibun2();
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
        source.hihokenshaName = item.getHihokenshaName();
        source.iryokikanName = item.getIryokikanName();
        source.tantoIshiName = item.getTantoIshiName();
        source.iryokikanJusho = item.getIryokikanJusho();
        source.telNo = item.getTelNo();
        if (item.getJushinKikan() == null || item.getJushinKikan().isEmpty()) {
            source.jushinKikan = RString.EMPTY;
        } else {
            source.jushinKikan = パターン12(new RDate(item.getJushinKikan().toString()));
        }
        source.jushinArea = item.getJushinArea();
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
        source.remban = item.getRemban();
        return source;

    }

    private RString パターン12(RDate rDate) {
        return rDate.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }
}
