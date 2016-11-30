/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinseimonitor;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseimonitor.ShinseiMonitorEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinseimonitor.ShinseiMonitorReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 要介護認定申請モニタリストEditorです。
 *
 * @reamsid_L DBE-1390-100 suguangjun
 */
public class ShinseiMonitorEditor implements IShinseiMonitorEditor {

    private final RString title = new RString("要介護認定申請モニタリスト");
    private final ShinseiMonitorEntity item;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShinseiMonitorEntity}
     * @param index 番号
     */
    protected ShinseiMonitorEditor(ShinseiMonitorEntity item, int index) {
        this.item = item;
        this.index = index;
    }

    @Override
    public ShinseiMonitorReportSource edit(ShinseiMonitorReportSource source) {
        RDateTime dateTime = RDateTime.now();
        RStringBuilder hakkoYMD = new RStringBuilder();
        hakkoYMD.append(dateTime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        hakkoYMD.append(RString.HALF_SPACE);
        hakkoYMD.append(dateTime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        source.title = title;
        source.shichosonName = item.get保険者名();
        source.printTimeStamp = hakkoYMD.toRString();
        source.listShinseimonita_1 = getNo(index);
        source.listShinseimonita_2 = item.get保険者番号();
        source.listShinseimonita_3 = item.get保険者名();
        source.listShinseimonita_4 = item.get氏名();
        source.listShinseimonita_5 = item.get被保険者番号();
        source.listShinseimonita_6 = dateFormat(item.get生年月日());
        source.listShinseimonita_7 = set性別(item.get性別());
        source.listShinseimonita_8 = set申請区分(item.get前回申請区分());
        source.listShinseimonita_9 = set前回二次判定結果();
        source.listShinseimonita_10 = item.get前回月数() == 0 ? RString.EMPTY : new RString(item.get前回月数());
        source.listShinseimonita_11 = dateFormat(item.get前回認定有効期間開始日());
        source.listShinseimonita_12 = dateFormat(item.get前回認定有効期間終了日());
        source.listShinseimonita_13 = dateFormat(item.get前回認定申請年月日());
        source.listShinseimonita_14 = item.get住民状態コード();
        source.listShinseimonita_15 = dateFormat(item.get消除異動年月日());
        source.listShinseimonita_16 = RString.EMPTY;
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (!RString.isNullOrEmpty(item.get保険者番号())) {
            source.hokenshaNo = new ExpandedInformation(new Code("100"), new RString("保険者番号"), item.get保険者番号());
        }
        if (!RString.isNullOrEmpty(item.get被保険者番号())) {
            source.hihokenshaNo = new ExpandedInformation(new Code("100"), new RString("被保険者番号"), item.get被保険者番号());
        }
        return source;
    }

    private RString set性別(RString 性別コード) {
        RString 性別 = RString.EMPTY;
        if (!RString.isNullOrEmpty(性別コード)) {
            性別 = Seibetsu.toValue(item.get性別()).get名称();
        }
        return 性別;
    }

    private RString getNo(int index_tmp) {
        if (index_tmp == -1) {
            return RString.EMPTY;
        }
        return new RString(String.valueOf(index_tmp + 1));
    }

    private RString set申請区分(RString 申請区分申請時コード) {
        RString 申請区分 = RString.EMPTY;
        if (!RString.isNullOrEmpty(申請区分申請時コード)) {
            申請区分 = NinteiShinseiShinseijiKubunCode.toValue(item.get前回申請区分()).get名称();
        }
        return 申請区分;
    }

    private RString dateFormat(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString set前回二次判定結果() {
        RString 前回二次判定結果 = RString.EMPTY;
        if (item.get前回二次判定結果コード() != null && !item.get前回二次判定結果コード().isEmpty()) {
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(item.get厚労省認定ソフトバージョン())) {
                前回二次判定結果 = YokaigoJotaiKubun99.toValue(item.get前回二次判定結果コード()).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(item.get厚労省認定ソフトバージョン())) {
                前回二次判定結果 = YokaigoJotaiKubun02.toValue(item.get前回二次判定結果コード()).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(item.get厚労省認定ソフトバージョン())) {
                前回二次判定結果 = YokaigoJotaiKubun06.toValue(item.get前回二次判定結果コード()).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(item.get厚労省認定ソフトバージョン())
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(item.get厚労省認定ソフトバージョン())) {
                前回二次判定結果 = YokaigoJotaiKubun09.toValue(item.get前回二次判定結果コード()).get名称();
            }
        }
        return 前回二次判定結果;
    }
}
