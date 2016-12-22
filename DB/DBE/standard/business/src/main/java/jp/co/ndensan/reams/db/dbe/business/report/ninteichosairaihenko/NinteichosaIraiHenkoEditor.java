/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosairaihenko;

import jp.co.ndensan.reams.db.dbe.business.core.ninteichosairaihenko.NinteichosaIraiHenkoData;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosairaihenko.NinteichosaIraiHenkoReportSource;
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

/**
 * 認定調査依頼先変更者一覧表のEditorです。
 *
 * @reamsid_L DBE-1390-120 dongyabin
 */
public class NinteichosaIraiHenkoEditor implements INinteichosaIraiHenkoEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private final NinteichosaIraiHenkoData item;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param item NinteichosaIraiHenkoData
     * @param index 番号
     */
    protected NinteichosaIraiHenkoEditor(NinteichosaIraiHenkoData item, int index) {
        this.item = item;
        this.index = index;
    }

    @Override
    public NinteichosaIraiHenkoReportSource edit(NinteichosaIraiHenkoReportSource source) {
        return editSource(source);
    }

    private NinteichosaIraiHenkoReportSource editSource(NinteichosaIraiHenkoReportSource source) {
        source.title = new RString("認定調査依頼先変更者一覧表");
        source.shichosonName = item.get保険者名();
        source.listChosaIraihenko_1 = getNo(index);
        source.listChosaIraihenko_2 = item.get保険者番号();
        source.listChosaIraihenko_3 = item.get保険者名();
        source.listChosaIraihenko_4 = item.get氏名() == null ? RString.EMPTY : item.get氏名().value();
        source.listChosaIraihenko_5 = item.get被保険者番号();
        source.listChosaIraihenko_6 = dateFormat(item.get生年月日());
        source.listChosaIraihenko_7 = item.get性別() == null ? RString.EMPTY
                : RString.isNullOrEmpty(item.get性別().value())
                ? RString.EMPTY : Seibetsu.toValue(item.get性別().value()).get名称();
        source.listChosaIraihenko_8 = dateFormat(item.get認定申請年月日());
        source.listChosaIraihenko_9 = item.get認定申請区分_申請時_コード() == null ? RString.EMPTY
                : RString.isNullOrEmpty(item.get認定申請区分_申請時_コード().value())
                ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.
                toValue(item.get認定申請区分_申請時_コード().value()).get名称();
        source.listChosaIraihenko_10 = item.get変更回数();
        source.listChosaIraihenko_11 = item.get変更前調査事業所();
        source.listChosaIraihenko_12 = item.get変更前調査員();
        source.listChosaIraihenko_13 = item.get変更後調査事業所();
        source.listChosaIraihenko_14 = item.get変更後調査員();
        source.listChosaIraihenko_15 = dateFormat(item.get変更日());
        source.printTimeStamp = get作成年月日時();
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        source.hokenshaNo = new ExpandedInformation(new Code("100"), new RString("保険者番号"), item.get保険者番号());
        source.hihokenshaNo = new ExpandedInformation(new Code("100"), new RString("被保険者番号"), item.get被保険者番号());
        return source;
    }

    private RString dateFormat(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
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
        return printTimeStampSb.toRString();
    }

    private RString getNo(int index_tmp) {
        if (index_tmp == -1) {
            return RString.EMPTY;
        }
        return new RString(String.valueOf(index_tmp + 1));
    }
}
