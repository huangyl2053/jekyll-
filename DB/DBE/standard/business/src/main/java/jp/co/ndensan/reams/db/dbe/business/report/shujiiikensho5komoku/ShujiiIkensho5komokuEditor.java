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
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09B;
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
    private final RString 記載あり = new RString("記載あり");
    private final RString 記載なし = new RString("記載なし");
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
                fillType(FillType.ZERO).toDateString());
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
            if (IkenshoKomokuMapping09A.認知症高齢者の日常生活自立度.getコード().equals(item.get意見書連番())) {
                source.listIkengokomoku_10 = get認知度(item.get意見項目());
            }
            if (IkenshoKomokuMapping09A.短期記憶.getコード().equals(item.get意見書連番())) {
                source.listIkengokomoku_11 = get短期記憶(item.get意見項目());
            }
            if (IkenshoKomokuMapping09A.認知能力.getコード().equals(item.get意見書連番())) {
                source.listIkengokomoku_12 = get意思決定(item.get意見項目());
            }
            if (IkenshoKomokuMapping09A.伝達能力.getコード().equals(item.get意見書連番())) {
                source.listIkengokomoku_13 = get伝達能力(item.get意見項目());
            }
            if (IkenshoKomokuMapping09A.食事行為.getコード().equals(item.get意見書連番())) {
                source.listIkengokomoku_14 = get食事行為(item.get意見項目());
            }
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(item.get厚労省IF識別コード())) {
            if (IkenshoKomokuMapping09B.認知症高齢者の日常生活自立度.getコード().equals(item.get意見書連番())) {
                source.listIkengokomoku_10 = get認知度(item.get意見項目());
            }
            if (IkenshoKomokuMapping09B.短期記憶.getコード().equals(item.get意見書連番())) {
                source.listIkengokomoku_11 = get短期記憶(item.get意見項目());
            }
            if (IkenshoKomokuMapping09B.認知能力.getコード().equals(item.get意見書連番())) {
                source.listIkengokomoku_12 = get意思決定(item.get意見項目());
            }
            if (IkenshoKomokuMapping09B.伝達能力.getコード().equals(item.get意見書連番())) {
                source.listIkengokomoku_13 = get伝達能力(item.get意見項目());
            }
            if (IkenshoKomokuMapping09B.食事行為.getコード().equals(item.get意見書連番())) {
                source.listIkengokomoku_14 = get食事行為(item.get意見項目());
            }
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(item.get厚労省IF識別コード())) {
            if (IkenshoKomokuMapping06A.認知症高齢者の日常生活自立度.getコード().equals(item.get意見書連番())) {
                source.listIkengokomoku_10 = get認知度(item.get意見項目());
            }
            if (IkenshoKomokuMapping06A.短期記憶.getコード().equals(item.get意見書連番())) {
                source.listIkengokomoku_11 = get短期記憶(item.get意見項目());
            }
            if (IkenshoKomokuMapping06A.認知能力.getコード().equals(item.get意見書連番())) {
                source.listIkengokomoku_12 = get意思決定(item.get意見項目());
            }
            if (IkenshoKomokuMapping06A.伝達能力.getコード().equals(item.get意見書連番())) {
                source.listIkengokomoku_13 = get伝達能力(item.get意見項目());
            }
            if (IkenshoKomokuMapping06A.食事行為.getコード().equals(item.get意見書連番())) {
                source.listIkengokomoku_14 = get食事行為(item.get意見項目());
            }
        }
        source.listIkengokomoku_15 = get記載有無(source);
        source.shikibetuCode = ShikibetsuCode.EMPTY;

        return edit2(source);
    }

    private ShujiiIkensho5komokuReportSource edit2(ShujiiIkensho5komokuReportSource source) {
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
        return date.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString get認知度(RString 意見項目) {
        RString 認知度 = RString.EMPTY;
        if (!RString.isNullOrEmpty(意見項目)) {
            認知度 = IkenKomoku03.toValue(意見項目).get名称();
        }
        return 認知度;
    }

    private RString get短期記憶(RString 意見項目) {
        RString 短期記憶 = RString.EMPTY;
        if (!RString.isNullOrEmpty(意見項目)) {
            短期記憶 = IkenKomoku04.toValue(意見項目).get名称();
        }
        return 短期記憶;
    }

    private RString get意思決定(RString 意見項目) {
        RString 意思決定 = RString.EMPTY;
        if (!RString.isNullOrEmpty(意見項目)) {
            意思決定 = IkenKomoku05.toValue(意見項目).get名称();
        }
        return 意思決定;
    }

    private RString get伝達能力(RString 意見項目) {
        RString 伝達能力 = RString.EMPTY;
        if (!RString.isNullOrEmpty(意見項目)) {
            伝達能力 = IkenKomoku06.toValue(意見項目).get名称();
        }
        return 伝達能力;
    }

    private RString get食事行為(RString 意見項目) {
        RString 食事行為 = RString.EMPTY;
        if (!RString.isNullOrEmpty(意見項目)) {
            食事行為 = IkenKomoku14.toValue(意見項目).get名称();
        }
        return 食事行為;
    }

    private RString get記載有無(ShujiiIkensho5komokuReportSource source) {
        RString 記載有無 = RString.EMPTY;
        if (記載あり.equals(source.listIkengokomoku_10) && 記載あり.equals(source.listIkengokomoku_11) && 記載あり.equals(source.listIkengokomoku_12)
                && 記載あり.equals(source.listIkengokomoku_13) && 記載あり.equals(source.listIkengokomoku_14)) {
            記載有無 = new RString("○");
        } else if (記載なし.equals(source.listIkengokomoku_10) || 記載なし.equals(source.listIkengokomoku_11)
                || 記載なし.equals(source.listIkengokomoku_12) || 記載なし.equals(source.listIkengokomoku_13)
                || 記載なし.equals(source.listIkengokomoku_14)) {
            記載有無 = new RString("△");
        } else if (記載なし.equals(source.listIkengokomoku_10) && 記載なし.equals(source.listIkengokomoku_11)
                && 記載なし.equals(source.listIkengokomoku_12) && 記載なし.equals(source.listIkengokomoku_13)
                && 記載なし.equals(source.listIkengokomoku_14)) {
            記載有無 = new RString("×");
        }
        return 記載有無;
    }
}
