/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shijiiikenshoiraihenko;

import jp.co.ndensan.reams.db.dbe.business.core.shijiiikenshoiraihen.ShijiiIkenshoIraiHenko;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shijiiikenshoiraihenko.ShijiiIkenshoIraiHenkoReportSource;
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
 * 主治医意見書作成依頼変更者一覧表Editorです。
 *
 * @reamsid_L DBE-1390-140 suguangjun
 */
public class ShijiiIkenshoIraiHenkoEditor implements IShijiiIkenshoIraiHenkoEditor {

    private final RString title = new RString("主治医意見書依頼変更者一覧表");
    private final ShijiiIkenshoIraiHenko item;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShijiiIkenshoIraiHenko}
     * @param index 番号
     */
    protected ShijiiIkenshoIraiHenkoEditor(ShijiiIkenshoIraiHenko item, int index) {
        this.item = item;
        this.index = index;
    }

    @Override
    public ShijiiIkenshoIraiHenkoReportSource edit(ShijiiIkenshoIraiHenkoReportSource source) {
        RDateTime dateTime = RDateTime.now();
        RStringBuilder hakkoYMD = new RStringBuilder();
        hakkoYMD.append(dateTime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        hakkoYMD.append(RString.HALF_SPACE);
        hakkoYMD.append(dateTime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        source.title = title;
        source.shichosonName = item.get保険者名();
        source.printTimeStamp = hakkoYMD.toRString();
        source.listIkenshohenko_1 = getNo(index);
        source.listIkenshohenko_2 = item.get保険者番号();
        source.listIkenshohenko_3 = item.get保険者名();
        source.listIkenshohenko_4 = item.get氏名();
        source.listIkenshohenko_5 = item.get被保険者番号();
        source.listIkenshohenko_6 = dateFormat(item.get生年月日());
        source.listIkenshohenko_7 = set性別(item.get性別());
        source.listIkenshohenko_8 = dateFormat(item.get認定申請年月日());
        source.listIkenshohenko_9 = set申請区分(item.get認定申請区分申請時コード());
        source.listIkenshohenko_10 = item.get変更回数();
        source.listIkenshohenko_11 = item.get変更前医療機関();
        source.listIkenshohenko_12 = item.get変更前主治医();
        source.listIkenshohenko_13 = item.get変更後医療機関();
        source.listIkenshohenko_14 = item.get変更後主治医();
        source.listIkenshohenko_15 = dateFormat(item.get変更日());
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

    private RString set性別(RString 性別コード) {
        return RString.isNullOrEmpty(性別コード)
                ? RString.EMPTY : Seibetsu.toValue(性別コード).get名称();
    }

    private RString getNo(int index_tmp) {
        if (index_tmp == -1) {
            return RString.EMPTY;
        }
        return new RString(String.valueOf(index_tmp + 1));
    }

    private RString set申請区分(RString code) {
        return RString.isNullOrEmpty(code)
                ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(code).get名称();
    }

    private RString dateFormat(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString();
    }
}
