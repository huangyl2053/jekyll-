/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshomiteishutsu;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshomiteishutsu.ShujiiIkenshoMiteishutsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshomiteishutsu.ShujiiIkenshoMiteishutsuReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
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
 * 主治医意見書未提出者一覧表Editorです。
 *
 * @reamsid_L DBE-1390-150 suguangjun
 */
public class ShujiiIkenshoMiteishutsuEditor implements IShujiiIkenshoMiteishutsuEditor {

    private final RString title = new RString("主治医意見書未提出者一覧表");
    private final ShujiiIkenshoMiteishutsuEntity item;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShujiiIkenshoMiteishutsuEntity}
     * @param index 番号
     */
    protected ShujiiIkenshoMiteishutsuEditor(ShujiiIkenshoMiteishutsuEntity item, int index) {
        this.item = item;
        this.index = index;
    }

    @Override
    public ShujiiIkenshoMiteishutsuReportSource edit(ShujiiIkenshoMiteishutsuReportSource source) {
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
        source.listIkemmiteishutsu_1 = getNo(index);
        source.listIkemmiteishutsu_2 = item.get保険者番号();
        source.listIkemmiteishutsu_3 = item.get保険者名();
        source.listIkemmiteishutsu_4 = item.get氏名();
        source.listIkemmiteishutsu_5 = item.get被保険者番号();
        source.listIkemmiteishutsu_6 = dateFormat(item.get生年月日());
        source.listIkemmiteishutsu_7 = set性別(item.get性別());
        source.listIkemmiteishutsu_8 = dateFormat(item.get申請日());
        source.listIkemmiteishutsu_9 = set申請区分(item.get申請区分());
        source.listIkemmiteishutsu_10 = item.get医療機関();
        source.listIkemmiteishutsu_11 = item.get主治医();
        source.listIkemmiteishutsu_12 = dateFormat(item.get依頼日());
        source.listIkemmiteishutsu_13 = dateFormat(item.get入手予定日());
        source.listIkemmiteishutsu_14 = dateFormat(item.get直近督促日());
        source.listIkemmiteishutsu_15 = new RString(item.get督促回数());
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (item.get保険者番号() == null) {
            source.hokenshaNo = null;
        } else {
            source.hokenshaNo = new ExpandedInformation(new Code("100"), new RString("保険者番号"), item.get保険者番号());
        }
        if (item.get被保険者番号() == null) {
            source.hokenshaNo = null;
        } else {
            source.hihokenshaNo = new ExpandedInformation(new Code("100"), new RString("被保険者番号"), item.get被保険者番号());
        }
        return source;
    }

    private RString set性別(RString code) {
        return RString.isNullOrEmpty(code)
                ? RString.EMPTY : Seibetsu.toValue(code).get名称();
    }

    private RString set申請区分(RString code) {
        return RString.isNullOrEmpty(code)
                ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(code).get名称();
    }

    private RString getNo(int index_tmp) {
        if (index_tmp == -1) {
            return RString.EMPTY;
        }
        return new RString(String.valueOf(index_tmp + 1));
    }

    private RString dateFormat(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }
}
