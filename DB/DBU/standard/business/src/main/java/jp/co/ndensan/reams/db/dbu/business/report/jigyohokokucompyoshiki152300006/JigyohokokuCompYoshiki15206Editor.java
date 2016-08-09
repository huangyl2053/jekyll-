/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki152300006;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki152300006.JigyohokokuCompYoshiki15206Entity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki152300006.JigyohokokuCompYoshiki15206ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護事業状況報告年報・一般状況（様式1-5）のEditorです。
 *
 * @reamsid_L DBU-5600-160 wangrenze
 */
public class JigyohokokuCompYoshiki15206Editor implements IJigyohokokuCompYoshiki15206Editor {

    private final JigyohokokuCompYoshiki15206Entity item;
    private static final RString 給付集計区分が1 = new RString("1");
    private static final RString 給付集計区分が2 = new RString("2");
    private static final RString 給付集計区分が3 = new RString("3");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JigyohokokuCompYoshiki15206Entity}
     */
    protected JigyohokokuCompYoshiki15206Editor(JigyohokokuCompYoshiki15206Entity item) {
        this.item = item;
    }

    @Override
    public JigyohokokuCompYoshiki15206ReportSource edit(JigyohokokuCompYoshiki15206ReportSource source) {
        source.printTimeStamp = item.get作成日時();
        source.shukeiKubun = new RString("年報");
        RStringBuilder builder = new RStringBuilder();
        builder.append(new RString("("));
        builder.append(getパターン107(item.get集計年度()));
        builder.append(new RString("年度分）"));
        builder.append(getパターン62(item.get集計期間FROM()));
        builder.append(new RString("～"));
        builder.append(getパターン62(item.get集計期間TO()));
        if (給付集計区分が1.equals(item.get給付集計区分())) {
            source.shuukeiHani = builder.toRString();
            source.kyufuKubun = new RString("現物分");
        } else if (給付集計区分が2.equals(item.get給付集計区分())) {
            builder.append(new RString("(審査)"));
            source.shuukeiHani = builder.toRString();
            source.kyufuKubun = new RString("償還審査分");
        } else if (給付集計区分が3.equals(item.get給付集計区分())) {
            builder.append(new RString("(決定)"));
            source.shuukeiHani = builder.toRString();
            source.kyufuKubun = new RString("償還決定分");
        }
        source.hokenshaNo = item.get保険者番号();
        source.hokenshaName = item.get保険者名();
        return source;
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
