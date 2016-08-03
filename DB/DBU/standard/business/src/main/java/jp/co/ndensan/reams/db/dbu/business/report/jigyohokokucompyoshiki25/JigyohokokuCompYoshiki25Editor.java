/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki25;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki25.JigyohokokuCompYoshiki25;
import jp.co.ndensan.reams.db.dbu.entity.report.JigyohokokuCompYoshiki25.JigyohokokuCompYoshikiReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 *
 * 介護事業状況報告月報（様式2-5）のEditorです。
 *
 * @reamsid_L DBU-5600-260 guoqilin
 */
public class JigyohokokuCompYoshiki25Editor implements IJigyohokokuCompYoshiki25Editor {

    private static final RString 現物分 = new RString("02");
    private static final RString 償還審査分 = new RString("04");
    private static final RString 償還決定分 = new RString("06");
    private static final RString 月報 = new RString("1");
    private static final RString 年報 = new RString("2");
    private final JigyohokokuCompYoshiki25 item;

    /**
     * インスタンスを生成します。
     *
     * @param item JigyohokokuCompYoshiki25
     */
    protected JigyohokokuCompYoshiki25Editor(JigyohokokuCompYoshiki25 item) {
        this.item = item;
    }

    @Override
    public JigyohokokuCompYoshikiReportSource edit(JigyohokokuCompYoshikiReportSource source) {
        return editSource(source);
    }

    private JigyohokokuCompYoshikiReportSource editSource(JigyohokokuCompYoshikiReportSource source) {
        source.yoshiki = item.get様式();
        source.printTimeStamp = item.get処理日時();
        source.shukeiKubun = item.get年報月報区分();
        source.shuukeiHani = get集計範囲();
        source.hokenshaNo = item.get保険者番号();
        source.hokenshaName = item.get保険者名();
        source.hyoTitle = item.getタイトル1();
        source.hyoSubTitle = item.getタイトル2();
        return source;
    }

    private RString get集計範囲() {
        RStringBuilder 集計範囲_SB = new RStringBuilder();
        集計範囲_SB.append(new RString("（"));
        集計範囲_SB.append(getパターン107(item.get集計年度()));
        集計範囲_SB.append(new RString("年度分）"));
        集計範囲_SB.append(getパターン62(item.get集計期間FROM()));
        集計範囲_SB.append(new RString("～"));
        集計範囲_SB.append(getパターン62(item.get集計期間TO()));
        if (現物分.equals(item.get給付集計区分())) {
            集計範囲_SB.append(RString.EMPTY);
        } else if (償還審査分.equals(item.get給付集計区分())) {
            集計範囲_SB.append(new RString("(審査)"));
        } else if (償還決定分.equals(item.get給付集計区分())) {
            集計範囲_SB.append(new RString("(決定)"));
        }
        return 集計範囲_SB.toRString();
    }

    private RString getパターン62(FlexibleYearMonth 年月) {
        if (年月 == null || 年月.isEmpty()) {
            return RString.EMPTY;
        }
        return 年月.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString getパターン107(FlexibleYear 集計年度) {
        if (集計年度 == null || 集計年度.isEmpty()) {
            return RString.EMPTY;
        }
        return 集計年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .fillType(FillType.BLANK).toDateString();
    }
}
