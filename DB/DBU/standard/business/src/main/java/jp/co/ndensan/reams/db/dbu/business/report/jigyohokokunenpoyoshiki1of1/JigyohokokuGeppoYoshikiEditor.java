/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokunenpoyoshiki1of1;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki1of1.JigyohokokuGeppoYoshikiEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokunenpoyoshiki1of1.JigyohokokuNenpoYoshiki1of1ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 事業状況報告年報（様式１・２　被保険者数）のEditorです。
 *
 * @reamsid_L DBU-5610-040 sunhaidi
 */
public class JigyohokokuGeppoYoshikiEditor implements IJigyohokokuGeppoYoshikiEditor {

    private final JigyohokokuGeppoYoshikiEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JigyohokokuGeppoYoshikiEntity}
     */
    protected JigyohokokuGeppoYoshikiEditor(JigyohokokuGeppoYoshikiEntity item) {
        this.item = item;
    }

    @Override
    public JigyohokokuNenpoYoshiki1of1ReportSource edit(JigyohokokuNenpoYoshiki1of1ReportSource source) {
        source.printTimeStamp = get処理時間(item.get処理日時());
        RStringBuilder builder = new RStringBuilder();
        builder.append(new RString("("));
        builder.append(getパターン107(item.get集計年度()));
        builder.append(new RString("年度分）"));
        builder.append(getパターン62(item.get集計期間FROM()));
        builder.append(new RString("～"));
        builder.append(getパターン62(item.get集計期間TO()));
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

    private RString get処理時間(RDateTime 処理時間) {
        if (処理時間 == null) {
            return RString.EMPTY;
        }
        RStringBuilder systemDateTime = new RStringBuilder();
        systemDateTime.append(処理時間.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        systemDateTime.append(処理時間.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        systemDateTime.append(new RString("作成"));
        return systemDateTime.toRString();
    }

}
