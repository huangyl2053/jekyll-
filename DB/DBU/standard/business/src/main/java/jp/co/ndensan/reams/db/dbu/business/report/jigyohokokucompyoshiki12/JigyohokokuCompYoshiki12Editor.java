/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki12;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki12.JigyohokokuCompYoshiki12Data;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki12.JigyohokokuCompYoshiki12ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護事業状況報告月報・一般状況（様式1-2）のEditorです。
 *
 * @reamsid_L DBU-5530-050 dongyabin
 */
public class JigyohokokuCompYoshiki12Editor implements IJigyohokokuCompYoshiki12Editor {

    private static final int 年度 = 4;
    private final JigyohokokuCompYoshiki12Data item;

    /**
     * インスタンスを生成します。
     *
     * @param item NinteichosaIraiHenkoData
     */
    protected JigyohokokuCompYoshiki12Editor(JigyohokokuCompYoshiki12Data item) {
        this.item = item;
    }

    @Override
    public JigyohokokuCompYoshiki12ReportSource edit(JigyohokokuCompYoshiki12ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshiki12ReportSource editSource(JigyohokokuCompYoshiki12ReportSource source) {
        source.yoshiki = item.get様式();
        source.printTimeStamp = item.get作成日時();
        source.shukeiKubun = item.get集計区分();
        source.shuukeiHani = set集計範囲(item.get集計範囲());
        source.hokenshaNo = item.get保険者番号();
        source.hokenshaName = item.get保険者名();
        source.hyo1Title = item.get表1のタイトル();
        source.hyo2Title1 = item.get左下表2のタイトル1();
        source.hyo3Title = item.get右下表3のタイトル();
        source.hyo2Title2 = item.get左下表2のタイトル2();
        source.hyo1ShinseishaKensu1 = item.get介護老人福祉施設の申請件数();
        source.hyo1ShinseishaKensu2 = item.get介護老人保健施設の申請件数();
        source.hyo1ShinseishaKensu3 = item.get介護療養型医療施設の申請件数();
        source.hyo1ShinseishaKensu4 = item.get地域密着型介護老人福祉施設入居者生活介護の申請件数();
        source.hyo1ShinseishaKensu5 = item.getその他の申請件数();
        source.hyo1ShinseishaKensu6 = item.get合計の申請件数();
        source.hyo3ShinseishaKensu = item.get特定負担限度額の申請件数();
        return source;
    }

    private RString set集計範囲(RString 集計範囲) {
        if (RString.isNullOrEmpty(集計範囲)) {
            return RString.EMPTY;
        }
        RStringBuilder 集計範囲_SB = new RStringBuilder();
        集計範囲_SB.append(new RString("（"));
        FlexibleYear 集計範囲_年度 = new FlexibleYear(集計範囲.substring(0, 年度));
        FlexibleYearMonth 集計範囲_Tmp = new FlexibleYearMonth(集計範囲);
        集計範囲_SB.append(集計範囲_年度.wareki().eraType(EraType.KANJI).getYear());
        集計範囲_SB.append(new RString("年度"));
        集計範囲_SB.append(集計範囲_Tmp.wareki().separator(Separator.JAPANESE).fillType(FillType.ZERO).getMonth());
        集計範囲_SB.append(new RString("分）"));
        return 集計範囲_SB.toRString();
    }
}
