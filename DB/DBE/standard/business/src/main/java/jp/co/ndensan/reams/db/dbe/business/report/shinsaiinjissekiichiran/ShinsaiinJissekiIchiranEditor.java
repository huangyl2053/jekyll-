/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsaiinjissekiichiran;

import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.ShinsakaiIinShubetsu;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsaiinjissekiichiran.ShisakaiIinJissekiIchiranShinsakaiTanka;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsaiinjissekiichiran.ShisakaiIinJissekiIchiranShozokuKikan;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsShusseki;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.KaigoninteiShinsakaiGichoKubunCode;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

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
    private static final RString 審査会単価パターン = DbBusinessConfig.get(ConfigNameDBE.審査員単価パターン, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
    private static final RString 審査会単価パターン_委員 = ShisakaiIinJissekiIchiranShinsakaiTanka.審査会単価パターン_委員.getコード();
    private static final RString 審査会単価パターン_医師 = ShisakaiIinJissekiIchiranShinsakaiTanka.審査会単価パターン_医師.getコード();
    RString 審査会委員実績照会_医師範囲_歯科医師 = DbBusinessConfig.get(ConfigNameDBE.審査会委員実績照会_医師範囲_歯科医師, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
    private static final RString 医師範囲に歯科医師含む = new RString("1");
    private static final RString 所属機関_医療機関 = ShisakaiIinJissekiIchiranShozokuKikan.医療機関.get名称();
    private static final RString 所属機関_調査委託先 = ShisakaiIinJissekiIchiranShozokuKikan.調査委託先.get名称();
    private static final RString 所属機関_その他機関 = ShisakaiIinJissekiIchiranShozokuKikan.その他機関.get名称();

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
        RString 所属機関種類 = get所属機関の種類(item);

        source.printTimeStamp = get作成年月日時();
        source.listShinsainJissekiIchiran_1 = item.getコード();
        source.listShinsainJissekiIchiran_2 = item.get氏名();
        source.listShinsainJissekiIchiran_3 = get審査員種別(item);
        source.listShinsainJissekiIchiran_4 = IsShusseki.toValue(item.is出欠()).get名称();
        source.listShinsainJissekiIchiran_5 = get所属機関コード(item, 所属機関種類);
        source.listShinsainJissekiIchiran_6 = get所属機関名称(item, 所属機関種類);
        source.listShinsainJissekiIchiran_7 = 所属機関種類;
        source.listShinsainJissekiIchiran_8 = item.get審査会地区();
        source.listShinsainJissekiIchiran_9 = item.get審査会番号();
        source.listShinsainJissekiIchiran_10 = dateFormat(item.get実施日());
        source.listShinsainJissekiIchiran_11 = set時刻(item.get開始());
        source.listShinsainJissekiIchiran_12 = set時刻(item.get終了());
        source.listShinsainJissekiIchiran_13 = get報酬単価(item);

        return source;
    }

    private RString get作成年月日時() {
        RDateTime printdate = RDateTime.now();
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
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(作成);
        return printTimeStampSb.toRString();
    }

    private RString get審査員種別(ShinsaiinJissekiIchiranRelateEntity item) {
        if (審査会単価パターン.equals(審査会単価パターン_委員)) {
            if (item.get議長区分コード().equals(KaigoninteiShinsakaiGichoKubunCode.議長.getコード())) {
                return ShinsakaiIinShubetsu.委員長.get名称();
            } else {
                return ShinsakaiIinShubetsu.委員.get名称();
            }
        }
        if (審査会単価パターン.equals(審査会単価パターン_医師)) {
            if (item.get審査員資格コード().equals(Sikaku.医師.getコード())) {
                return ShinsakaiIinShubetsu.医師.get名称();
            } else if (医師範囲に歯科医師含む.equals(審査会委員実績照会_医師範囲_歯科医師) && item.get審査員資格コード().equals(Sikaku.歯科医師.getコード())) {
                return ShinsakaiIinShubetsu.医師.get名称();
            } else {
                return ShinsakaiIinShubetsu.医師以外.get名称();
            }
        }
        return RString.EMPTY;
    }

    private RString get所属機関の種類(ShinsaiinJissekiIchiranRelateEntity item) {
        if (!RString.isNullOrEmpty(item.get医療機関コード())) {
            return 所属機関_医療機関;
        }
        if (!RString.isNullOrEmpty(item.get調査委託先コード())) {
            return 所属機関_調査委託先;
        }
        if (!RString.isNullOrEmpty(item.getその他機関コード())) {
            return 所属機関_その他機関;
        }
        return RString.EMPTY;
    }

    private RString get所属機関コード(ShinsaiinJissekiIchiranRelateEntity item, RString 所属機関種類) {
        if (所属機関種類.equals(所属機関_医療機関)) {
            return item.get医療機関コード();
        }
        if (所属機関種類.equals(所属機関_調査委託先)) {
            return item.get調査委託先コード();
        }
        if (所属機関種類.equals(所属機関_その他機関)) {
            return item.getその他機関コード();
        }
        return RString.EMPTY;
    }

    private RString get所属機関名称(ShinsaiinJissekiIchiranRelateEntity item, RString 所属機関種類) {
        if (所属機関種類.equals(所属機関_医療機関)) {
            return item.get医療機関名称();
        }
        if (所属機関種類.equals(所属機関_調査委託先)) {
            return item.get調査委託先名称();
        }
        if (所属機関種類.equals(所属機関_その他機関)) {
            return item.getその他機関名称();
        }
        return RString.EMPTY;
    }

    private RString get報酬単価(ShinsaiinJissekiIchiranRelateEntity item) {
        if (item.is出欠()) {
            if (審査会単価パターン.equals(審査会単価パターン_委員)) {
                return item.get単価_委員();
            }
            if (審査会単価パターン.equals(審査会単価パターン_医師)) {
                return item.get単価_医師();
            }
        }
        return new RString("0");
    }

    private RString set時刻(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        RTime datetime = new RTime(date);
        return datetime.toFormattedTimeString(DisplayTimeFormat.HH_mm);
    }

    private RString dateFormat(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        RDate date_tem = new RDate(date.toString());
        return date_tem.wareki().toDateString();
    }

}
