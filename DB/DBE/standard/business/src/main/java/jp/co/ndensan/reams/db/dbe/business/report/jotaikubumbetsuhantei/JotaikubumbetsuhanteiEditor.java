/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jotaikubumbetsuhantei;

import jp.co.ndensan.reams.db.dbe.business.core.jotaikubumbetsuhantei.Jotaikubumbetsuhantei;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jotaikubumbetsuhantei.JotaikubumbetsuhanteiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 要介護状態区分別判定件数のEditorです。
 *
 * @reamsid_L DBE-1450-050 dongyabin
 */
public class JotaikubumbetsuhanteiEditor implements IJotaikubumbetsuhanteiEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private final Jotaikubumbetsuhantei item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JohoTeikyoShiryoItem}
     */
    protected JotaikubumbetsuhanteiEditor(Jotaikubumbetsuhantei item) {
        this.item = item;
    }

    @Override
    public JotaikubumbetsuhanteiReportSource edit(JotaikubumbetsuhanteiReportSource source) {
        return editSource(source);
    }

    private JotaikubumbetsuhanteiReportSource editSource(JotaikubumbetsuhanteiReportSource source) {
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        source.hokenshaNo = new ExpandedInformation(new Code("100"), new RString("市町村番号"), item.get市町村番号());
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
        source.gogitaiName = item.get合議体名称();
        source.shinsakaiStartYMD = dateFormat(item.get開催開始年月日());
        source.shinsakaiEndYMD = dateFormat(item.get開催終了年月日());
        source.shinsakaiKaisaiKaisu = item.get開催回数();
        source.shichosonNo = item.get市町村番号();
        source.shichosonName = item.get市町村名();
        source.henkosha = item.get変更者();
        source.keido = item.get軽度();
        source.judo = item.get重度();
        return source;
    }

    private RString dateFormat(RString date) {
        return RString.isNullOrEmpty(date) ? RString.EMPTY : new FlexibleDate(date).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }
}
