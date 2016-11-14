/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.kaigohokenshindanmeireisho;

import jp.co.ndensan.reams.db.dbz.entity.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 介護保険診断命令書ヘッダEditorです。
 *
 * @reamsid_L DBE-0080-070 wangxiaodong
 */
public class KaigohokenShindanMeireishoHeaderEditor implements IKaigohokenShindanMeireishoEditor {

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

        source.title = item.getTitle();
        source.hakkoYMD = item.getHakkoYMD();
        source.denshiKoin = item.getDenshiKoin();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.ninshoshaYakushokuMei1 = item.getNinshoshaYakushokuMei1();
        source.ninshoshaYakushokuMei2 = item.getNinshoshaYakushokuMei2();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.koinShoryaku = item.getKoinShoryaku();
        source.yubinNo = item.getYubinNo();
        source.jushoText = item.getJushoText();
        source.hihokenshaName1 = item.getHihokenshaName();
        source.meishoFuyo = item.getMeishoFuyo();
        source.customerBarCode = item.getCustomerBarCode();
        source.sonota = item.getSonota();
        source.tsuchibun1 = item.getTsuchibun1();
        source.hihokenshaName2 = item.getHihokenshaName();
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
        source.iryokikanName = item.getIryokikanName();
        source.tantoIshiName = item.getTantoIshiName();
        source.iryokikanJusho = item.getIryokikanJusho();
        source.telNo = item.getTelNo();
        if (item.getJushinKikan() == null || item.getJushinKikan().isEmpty()) {
            source.jushinKikan = RString.EMPTY;
        } else {
            source.jushinKikan = new RString(item.getJushinKikan().toString());
        }
        source.jushinArea = item.getJushinArea();
        source.tsuchibun2 = item.getTsuchibun2();
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (!RString.isNullOrEmpty(item.getHihokenshaNo())) {
            source.hishokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                    item.getHihokenshaNo());
        }
        return source;
    }

    private RString パターン12(RDate rDate) {
        return rDate.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }
}
