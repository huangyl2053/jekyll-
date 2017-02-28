/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsaiinjissekiichiran;

import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.ShinsakaiIinShubetsu;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsaiinjissekiichiran.ShisakaiIinJissekiIchiranShinsakaiTanka;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsaiinjissekiichiran.ShisakaiIinJissekiIchiranShozokuKikan;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsShusseki;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.KaigoninteiShinsakaiGichoKubunCode;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会委員報酬実績集計表のCsvのEntityを作成。
 *
 * @reamsid_L DBE-1700-020 wanghuafeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsaiinJissekiIchiranEntity implements IShinsaiinJissekiIchiranCsvEucEntity {

    private static final RString 審査会単価パターン = DbBusinessConfig.get(ConfigNameDBE.審査員単価パターン, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
    private static final RString 審査会単価パターン_委員 = ShisakaiIinJissekiIchiranShinsakaiTanka.審査会単価パターン_委員.getコード();
    private static final RString 審査会単価パターン_医師 = ShisakaiIinJissekiIchiranShinsakaiTanka.審査会単価パターン_医師.getコード();
    private static final RString 所属機関_医療機関 = ShisakaiIinJissekiIchiranShozokuKikan.医療機関.get名称();
    private static final RString 所属機関_調査委託先 = ShisakaiIinJissekiIchiranShozokuKikan.調査委託先.get名称();
    private static final RString 所属機関_その他機関 = ShisakaiIinJissekiIchiranShozokuKikan.その他機関.get名称();

    @CsvField(order = 1, name = "審査員コード")
    private final RString コード;
    @CsvField(order = 2, name = "審査員名")
    private final RString 氏名;
    @CsvField(order = 3, name = "審査員種別コード")
    private final RString 審査員種別コード;
    @CsvField(order = 4, name = "審査員種別")
    private final RString 審査員種別;
    @CsvField(order = 5, name = "出欠")
    private final RString 出欠;
    @CsvField(order = 6, name = "所属機関コード")
    private final RString 所属機関コード;
    @CsvField(order = 7, name = "所属機関")
    private final RString 所属機関;
    @CsvField(order = 8, name = "所属機関の種類")
    private final RString 所属機関の種類;
    @CsvField(order = 9, name = "審査会地区コード")
    private final RString 審査会地区コード;
    @CsvField(order = 10, name = "審査会地区")
    private final RString 審査会地区;
    @CsvField(order = 11, name = "審査会番号")
    private final RString 審査会番号;
    @CsvField(order = 12, name = "審査会実施日")
    private final RString 実施日;
    @CsvField(order = 13, name = "開始時刻")
    private final RString 開始;
    @CsvField(order = 14, name = "終了時刻")
    private final RString 終了;
    @CsvField(order = 15, name = "報酬単価")
    private final RString 報酬単価;

    /**
     * コンストラクタです。
     *
     * @param relateEntity ShinsaiinJissekiIchiranRelateEntity
     */
    public ShinsaiinJissekiIchiranEntity(ShinsaiinJissekiIchiranRelateEntity relateEntity) {
        RString 所属機関種類 = get所属機関の種類(relateEntity);

        this.コード = relateEntity.getコード();
        this.氏名 = relateEntity.get氏名();
        this.審査員種別コード = get審査員種別コード(relateEntity);
        this.審査員種別 = get審査員種別(relateEntity);
        this.出欠 = IsShusseki.toValue(relateEntity.is出欠()).get名称();
        this.所属機関コード = get所属機関コード(relateEntity, 所属機関種類);
        this.所属機関 = get所属機関名称(relateEntity, 所属機関種類);
        this.所属機関の種類 = 所属機関種類;
        this.審査会地区コード = relateEntity.get審査会地区コード();
        this.審査会地区 = relateEntity.get審査会地区();
        this.審査会番号 = relateEntity.get審査会番号();
        this.実施日 = dateFormat(relateEntity.get実施日());
        this.開始 = set時刻(relateEntity.get開始());
        this.終了 = set時刻(relateEntity.get終了());
        this.報酬単価 = get報酬単価(relateEntity);

    }

    private RString get審査員種別コード(ShinsaiinJissekiIchiranRelateEntity relateEntity) {
        if (審査会単価パターン.equals(審査会単価パターン_委員)) {
            if (relateEntity.get議長区分コード().equals(KaigoninteiShinsakaiGichoKubunCode.議長.getコード())) {
                return ShinsakaiIinShubetsu.委員長.getコード();
            } else {
                return ShinsakaiIinShubetsu.委員.getコード();
            }
        }
        if (審査会単価パターン.equals(審査会単価パターン_医師)) {
            if (relateEntity.get審査員資格コード().equals(Sikaku.医師.getコード()) || relateEntity.get審査員資格コード().equals(Sikaku.歯科医師.getコード())) {
                return ShinsakaiIinShubetsu.医師.getコード();
            } else {
                return ShinsakaiIinShubetsu.医師以外.getコード();
            }
        }
        return RString.EMPTY;
    }

    private RString get審査員種別(ShinsaiinJissekiIchiranRelateEntity relateEntity) {
        if (審査会単価パターン.equals(審査会単価パターン_委員)) {
            if (relateEntity.get議長区分コード().equals(KaigoninteiShinsakaiGichoKubunCode.議長.getコード())) {
                return ShinsakaiIinShubetsu.委員長.get名称();
            } else {
                return ShinsakaiIinShubetsu.委員.get名称();
            }
        }
        if (審査会単価パターン.equals(審査会単価パターン_医師)) {
            if (relateEntity.get審査員資格コード().equals(Sikaku.医師.getコード()) || relateEntity.get審査員資格コード().equals(Sikaku.歯科医師.getコード())) {
                return ShinsakaiIinShubetsu.医師.get名称();
            } else {
                return ShinsakaiIinShubetsu.医師以外.get名称();
            }
        }
        return RString.EMPTY;
    }

    private RString get所属機関の種類(ShinsaiinJissekiIchiranRelateEntity relateEntity) {
        if (!RString.isNullOrEmpty(relateEntity.get医療機関コード())) {
            return 所属機関_医療機関;
        }
        if (!RString.isNullOrEmpty(relateEntity.get調査委託先コード())) {
            return 所属機関_調査委託先;
        }
        if (!RString.isNullOrEmpty(relateEntity.getその他機関コード())) {
            return 所属機関_その他機関;
        }
        return RString.EMPTY;
    }

    private RString get所属機関コード(ShinsaiinJissekiIchiranRelateEntity relateEntity, RString 所属機関種類) {
        if (所属機関種類.equals(所属機関_医療機関)) {
            return relateEntity.get医療機関コード();
        }
        if (所属機関種類.equals(所属機関_調査委託先)) {
            return relateEntity.get調査委託先コード();
        }
        if (所属機関種類.equals(所属機関_その他機関)) {
            return relateEntity.getその他機関コード();
        }
        return RString.EMPTY;
    }

    private RString get所属機関名称(ShinsaiinJissekiIchiranRelateEntity relateEntity, RString 所属機関種類) {
        if (所属機関種類.equals(所属機関_医療機関)) {
            return relateEntity.get医療機関名称();
        }
        if (所属機関種類.equals(所属機関_調査委託先)) {
            return relateEntity.get調査委託先名称();
        }
        if (所属機関種類.equals(所属機関_その他機関)) {
            return relateEntity.getその他機関名称();
        }
        return RString.EMPTY;
    }

    private RString get報酬単価(ShinsaiinJissekiIchiranRelateEntity relateEntity) {
        if (relateEntity.is出欠()) {
            if (審査会単価パターン.equals(審査会単価パターン_委員)) {
                return relateEntity.get単価_委員();
            }
            if (審査会単価パターン.equals(審査会単価パターン_医師)) {
                return relateEntity.get単価_医師();
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
        return date_tem.seireki().separator(Separator.SLASH).toDateString();
    }
}
