/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jigyojokyohokoku;

import jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku.JigyoJokyoHokoku;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jigyojokyohokoku.JigyoJokyoHokokuReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FillTypeFormatted;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 要介護認定事業状況報告のEditorです。
 *
 * @reamsid_L DBE-1450-100 dongyabin
 */
public class JigyoJokyoHokokuEditor implements IJigyoJokyoHokokuEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private final JigyoJokyoHokoku item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JohoTeikyoShiryoItem}
     */
    protected JigyoJokyoHokokuEditor(JigyoJokyoHokoku item) {
        this.item = item;
    }

    @Override
    public JigyoJokyoHokokuReportSource edit(JigyoJokyoHokokuReportSource source) {
        return editSource(source);
    }

    private JigyoJokyoHokokuReportSource editSource(JigyoJokyoHokokuReportSource source) {
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        source.hishokenshaNo = new ExpandedInformation(new Code("100"), new RString("被保険者番号"), item.get保険者番号());
        source.title = item.getタイトル();
        RDateTime printdate = item.get発行日時();
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", printdate.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", printdate.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", printdate.getSecond()));
        printTimeStampSb.append(DATE_秒);
        source.printTimeStamp = printTimeStampSb.toRString();
        source.hokenshaNo = item.get保険者番号();
        source.hokenshaName = item.get保険者名();
        source.jigyoTaishoYM = dateFormat(item.get事業対象年月());
        return source;
    }

    private RString dateFormat(RString date) {
        RString dateRString = RString.EMPTY;
        if (!RString.isNullOrEmpty(date)) {
            RStringBuilder dateSb = new RStringBuilder();
            FillTypeFormatted dateFormat = new FlexibleDate(date).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK);
            dateSb.append(dateFormat.getYear());
            dateSb.append(dateFormat.getMonth());
            dateRString = dateSb.toRString();
        }
        return dateRString;
    }
}
