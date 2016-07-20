/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsaiinjissekiichiran;

import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.ShinsakaiIinHoshukubun;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsShusseki;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護認定審査会委員報酬実績集計表のEditorです。
 *
 * @reamsid_L DBE-1700-040 wanghuafeng
 */
class ShinsaiinJissekiIchiranEditor implements IShinsaiinJissekiIchiranEditor {

    private final ShinsaiinJissekiIchiranRelateEntity item;
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 作成 = new RString("作成");

    /**
     * インスタンスを生成します。
     *
     * @param item NinteichosaIraiHenkoData
     */
    protected ShinsaiinJissekiIchiranEditor(ShinsaiinJissekiIchiranRelateEntity item) {
        this.item = item;
    }

    @Override
    public ShinsaiinJissekiIchiranReportSource edit(ShinsaiinJissekiIchiranReportSource source) {
        return editSource(source);
    }

    private ShinsaiinJissekiIchiranReportSource editSource(ShinsaiinJissekiIchiranReportSource source) {
        source.printTimeStamp = get作成年月日時();
        source.listShinsainJissekiIchiran_1 = item.getコード();
        source.listShinsainJissekiIchiran_2 = item.get氏名();
        source.listShinsainJissekiIchiran_3 = item.get所属機関();
        source.listShinsainJissekiIchiran_4 = item.get審査会地区();
        source.listShinsainJissekiIchiran_5 = item.get審査会番号();
        source.listShinsainJissekiIchiran_6 = dateFormat(item.get実施日());
        source.listShinsainJissekiIchiran_7 = set時刻(item.get開始());
        source.listShinsainJissekiIchiran_8 = set時刻(item.get終了());
        source.listShinsainJissekiIchiran_9 = ShinsakaiIinHoshukubun.toValue(item.get報酬区分()).get名称();
        source.listShinsainJissekiIchiran_10 = IsShusseki.toValue(item.is出欠()).get名称();
        return source;
    }

    private RString get作成年月日時() {
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", printdate.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", printdate.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", printdate.getSecond()));
        printTimeStampSb.append(DATE_秒);
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(作成);
        return printTimeStampSb.toRString();
    }

    private static RString set時刻(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        date.insert(2, ":");
        return date;

    }

    private static RString dateFormat(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        RDate date_tem = new RDate(date.toString());
        return date_tem.wareki().toDateString();
    }

}
