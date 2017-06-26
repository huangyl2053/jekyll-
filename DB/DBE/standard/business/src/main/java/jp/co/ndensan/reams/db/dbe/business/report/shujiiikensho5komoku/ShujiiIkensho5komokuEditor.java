/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho5komoku;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikensho5komoku.ShujiiIkensho5komokuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho5komoku.ShujiiIkensho5komokuReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku05;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku14;
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
 * 主治医意見書5項目確認一覧表Editorです。
 *
 * @reamsid_L DBE-1390-170 suguangjun
 */
public class ShujiiIkensho5komokuEditor implements IShujiiIkensho5komokuEditor {

    private final RString title = new RString("主治医意見書5項目確認一覧表");
    private final ShujiiIkensho5komokuEntity item;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShujiiIkensho5komokuEntity}
     * @param index 番号
     */
    protected ShujiiIkensho5komokuEditor(ShujiiIkensho5komokuEntity item, int index) {
        this.item = item;
        this.index = index;
    }

    @Override
    public ShujiiIkensho5komokuReportSource edit(ShujiiIkensho5komokuReportSource source) {
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
        source.listIkengokomoku_1 = getNo(index);
        source.listIkengokomoku_2 = item.get保険者番号();
        source.listIkengokomoku_3 = item.get保険者名();
        source.listIkengokomoku_4 = item.get氏名();
        source.listIkengokomoku_5 = item.get被保険者番号();
        source.listIkengokomoku_6 = dateFormat(item.get生年月日());
        source.listIkengokomoku_7 = set性別(item.get性別());
        source.listIkengokomoku_8 = dateFormat(item.get認定申請年月日());
        source.listIkengokomoku_9 = set申請区分(item.get認定申請区分申請時コード());
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(item.get厚労省IF識別コード())) {
            source.listIkengokomoku_10 = get認知度(item.get認知度());
            source.listIkengokomoku_11 = get短期記憶(item.get短期記憶());
            source.listIkengokomoku_12 = get意思決定(item.get意思決定());
            source.listIkengokomoku_13 = get伝達能力(item.get伝達能力());
            source.listIkengokomoku_14 = get食事行為(item.get食事行為());
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(item.get厚労省IF識別コード())) {
            source.listIkengokomoku_10 = get認知度(item.get認知度());
            source.listIkengokomoku_11 = get短期記憶(item.get短期記憶());
            source.listIkengokomoku_12 = get意思決定(item.get意思決定());
            source.listIkengokomoku_13 = get伝達能力(item.get伝達能力());
            source.listIkengokomoku_14 = get食事行為(item.get食事行為());
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(item.get厚労省IF識別コード())) {
            source.listIkengokomoku_10 = get認知度(item.get認知度());
            source.listIkengokomoku_11 = get短期記憶(item.get短期記憶());
            source.listIkengokomoku_12 = get意思決定(item.get意思決定());
            source.listIkengokomoku_13 = get伝達能力(item.get伝達能力());
            source.listIkengokomoku_14 = get食事行為(item.get食事行為());
        }
        source.listIkengokomoku_15 = get記載有無(source);
        if (!item.get氏名().equals(new RString("該当データがありません"))) {
            source.識別コード = new ShikibetsuCode(item.get保険者番号().substring(0, 5).concat(item.get被保険者番号()));
            source.拡張情報 = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), item.get申請書管理番号());
        }
        return source;
    }

    private RString set性別(RString code) {
        return RString.isNullOrEmpty(code)
                ? RString.EMPTY : Seibetsu.toValue(code).get名称();
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

    private RString get認知度(RString code) {
        return RString.isNullOrEmpty(code)
                ? RString.EMPTY : IkenKomoku03.toValue(code).get名称();
    }

    private RString get短期記憶(RString code) {
        return RString.isNullOrEmpty(code)
                ? RString.EMPTY : IkenKomoku04.toValue(code).get名称();
    }

    private RString get意思決定(RString code) {
        return RString.isNullOrEmpty(code)
                ? RString.EMPTY : IkenKomoku05.toValue(code).get名称();
    }

    private RString get伝達能力(RString code) {
        return RString.isNullOrEmpty(code)
                ? RString.EMPTY : IkenKomoku06.toValue(code).get名称();
    }

    private RString get食事行為(RString code) {
        return RString.isNullOrEmpty(code)
                ? RString.EMPTY : IkenKomoku14.toValue(code).get名称();
    }

    private RString get記載有無(ShujiiIkensho5komokuReportSource source) {
        RString 記載有無 = RString.EMPTY;
        if (!RString.isNullOrEmpty(source.listIkengokomoku_10) && !RString.isNullOrEmpty(source.listIkengokomoku_11)
                && !RString.isNullOrEmpty(source.listIkengokomoku_12) && !RString.isNullOrEmpty(source.listIkengokomoku_13)
                && !RString.isNullOrEmpty(source.listIkengokomoku_14)) {
            記載有無 = new RString("○");
        } else if (RString.isNullOrEmpty(source.listIkengokomoku_10) && RString.isNullOrEmpty(source.listIkengokomoku_11)
                && RString.isNullOrEmpty(source.listIkengokomoku_12) && RString.isNullOrEmpty(source.listIkengokomoku_13)
                && RString.isNullOrEmpty(source.listIkengokomoku_14)) {
            記載有無 = new RString("×");
        } else {
            記載有無 = new RString("△");
        }
        return 記載有無;
    }
}
