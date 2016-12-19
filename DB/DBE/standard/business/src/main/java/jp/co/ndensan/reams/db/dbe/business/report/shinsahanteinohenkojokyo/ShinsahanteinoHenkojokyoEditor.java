/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsahanteinohenkojokyo;

import jp.co.ndensan.reams.db.dbe.business.core.shinsahanteinohenkojokyo.ShinsahanteinoHenkojokyo;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsahanteinohenkojokyo.ShinsahanteinoHenkojokyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 審査判定の変更状況のEditorです。
 *
 * @reamsid_L DBE-1450-060 dongyabin
 */
public class ShinsahanteinoHenkojokyoEditor implements IShinsahanteinoHenkojokyoEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private final ShinsahanteinoHenkojokyo item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JohoTeikyoShiryoItem}
     */
    protected ShinsahanteinoHenkojokyoEditor(ShinsahanteinoHenkojokyo item) {
        this.item = item;
    }

    @Override
    public ShinsahanteinoHenkojokyoReportSource edit(ShinsahanteinoHenkojokyoReportSource source) {
        return editSource(source);
    }

    private ShinsahanteinoHenkojokyoReportSource editSource(ShinsahanteinoHenkojokyoReportSource source) {
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
        source.shinsakaiStartYMD = item.get審査会開始年月日();
        source.shinsakaiEndYMD = item.get審査会終了年月日();
        source.shinsakaiKaisaiKaisu = item.get開催回数();
        source.shichosonNo = item.get市町村コード();
        source.shichosonName = item.get市町村名();
        return source;
    }

}
