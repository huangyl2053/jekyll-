/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoseikyuichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshoseikyuichiran.ShujiiIkenshoSeikyuIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoseikyuichiran.ShujiiIkenshoSeikyuIchiranReportSource;
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
 * 主治医意見書作成料請求一覧表Editorです。
 *
 * @reamsid_L DBE-1390-180 suguangjun
 */
public class ShujiiIkenshoSeikyuIchiranEditor implements IShujiiIkenshoSeikyuIchiranEditor {

    private final RString title = new RString("主治医意見書作成料請求一覧表");
    private final ShujiiIkenshoSeikyuIchiranEntity item;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShujiiIkenshoSeikyuIchiranEntity}
     * @param index 番号
     */
    protected ShujiiIkenshoSeikyuIchiranEditor(ShujiiIkenshoSeikyuIchiranEntity item, int index) {
        this.item = item;
        this.index = index;
    }

    @Override
    public ShujiiIkenshoSeikyuIchiranReportSource edit(ShujiiIkenshoSeikyuIchiranReportSource source) {
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
        source.listIkeniraimishori_1 = getNo(index);
        source.listIkeniraimishori_2 = item.get保険者番号();
        source.listIkeniraimishori_3 = item.get保険者名();
        source.listIkeniraimishori_4 = item.get氏名();
        source.listIkeniraimishori_5 = item.get被保険者番号();
        source.listIkeniraimishori_6 = dateFormat(item.get生年月日());
        source.listIkeniraimishori_7 = set性別(item.get性別());
        source.listIkeniraimishori_8 = dateFormat(item.get認定申請年月日());
        source.listIkeniraimishori_9 = set申請区分(item.get認定申請区分申請時コード());
        source.listIkeniraimishori_10 = item.get医療機関();
        source.listIkeniraimishori_11 = dateFormat(item.get主治医意見書記入年月日());
        source.listIkeniraimishori_12 = dateFormat(item.get主治医意見書読取年月日());
        source.listIkeniraimishori_13 = item.get主治医意見書作成料();
        source.listIkeniraimishori_14 = item.get主治医意見書別途診療費();
        source.listIkeniraimishori_15 = dateFormat(item.get報酬支払年月日());
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
            申請区分 = NinteiShinseiShinseijiKubunCode.toValue(item.get認定申請区分申請時コード()).get名称();
        }
        return 申請区分;
    }

    private RString dateFormat(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI_RYAKU).toDateString();
    }
}
