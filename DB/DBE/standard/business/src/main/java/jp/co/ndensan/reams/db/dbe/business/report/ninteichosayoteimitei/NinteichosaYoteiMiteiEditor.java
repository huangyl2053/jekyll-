/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosayoteimitei;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosayoteimitei.NinteichosaYoteiMiteiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosayoteimitei.NinteichosaYoteiMiteiReportSource;
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
 * 認定調査予定未定者一覧表のEditorです。
 *
 * @reamsid_L DBE-1390-110 dongyabin
 */
public class NinteichosaYoteiMiteiEditor implements INinteichosaYoteiMiteiEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private final NinteichosaYoteiMiteiRelateEntity item;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param item NinteichosaIraiHenkoData
     * @param index 番号
     */
    protected NinteichosaYoteiMiteiEditor(NinteichosaYoteiMiteiRelateEntity item, int index) {
        this.item = item;
        this.index = index;
    }

    @Override
    public NinteichosaYoteiMiteiReportSource edit(NinteichosaYoteiMiteiReportSource source) {
        return editSource(source);
    }

    private NinteichosaYoteiMiteiReportSource editSource(NinteichosaYoteiMiteiReportSource source) {
        source.title = new RString("認定調査予定未定者一覧表");
        source.printTimeStamp = get作成年月日時();
        source.shichosonName = item.getDbT7051_shichosonMeisho();
        source.listChosaYoteimitei_1 = getNo(index);
        source.listChosaYoteimitei_2 = item.getDbT5101_shoKisaiHokenshaNo();
        source.listChosaYoteimitei_3 = item.getDbT7051_shichosonMeisho();
        source.listChosaYoteimitei_4 = item.getDbT5101_hihokenshaName() == null ? RString.EMPTY : item.getDbT5101_hihokenshaName().value();
        source.listChosaYoteimitei_5 = item.getDbT5101_hihokenshaNo();
        source.listChosaYoteimitei_6 = dateFormat(item.getDbT5101_ninteiShinseiYMD());
        source.listChosaYoteimitei_7 = item.getDbT5101_seibetsu() == null
                ? RString.EMPTY : RString.isNullOrEmpty(item.getDbT5101_seibetsu().value())
                ? RString.EMPTY : Seibetsu.toValue(item.getDbT5101_seibetsu().value()).get名称();
        source.listChosaYoteimitei_8 = dateFormat(item.getDbT5101_seinengappiYMD());
        source.listChosaYoteimitei_9 = item.getDbT5101_ninteiShinseiShinseijiKubunCode() == null
                ? RString.EMPTY : RString.isNullOrEmpty(item.getDbT5101_ninteiShinseiShinseijiKubunCode().value())
                ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(item.getDbT5101_ninteiShinseiShinseijiKubunCode().value()).get名称();
        source.listChosaYoteimitei_10 = item.getDbT5910_ZenZenkai_jigyoshaMeisho();
        source.listChosaYoteimitei_11 = item.getDbT5913_ZenZenkai_chosainShimei();
        source.listChosaYoteimitei_12 = item.getDbT5910_Zenkai_jigyoshaMeisho();
        source.listChosaYoteimitei_13 = item.getDbT5913_Zenkai_chosainShimei();
        source.listChosaYoteimitei_14 = item.getDbT5910_jigyoshaMeisho();
        source.listChosaYoteimitei_15 = item.getDbT5913_chosainShimei();
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        RString 保険者番号 = RString.EMPTY;
        RString 被保険者番号 = RString.EMPTY;
        if (!RString.isNullOrEmpty(item.getDbT5101_shoKisaiHokenshaNo())) {
            保険者番号 = item.getDbT5101_shoKisaiHokenshaNo();
            被保険者番号 = item.getDbT5101_hihokenshaNo();
        }
        source.hokenshaNo = new ExpandedInformation(new Code("100"), new RString("保険者番号"), 保険者番号);
        source.hihokenshaNo = new ExpandedInformation(new Code("100"), new RString("被保険者番号"), 被保険者番号);
        return source;
    }

    private RString dateFormat(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString getNo(int index_tmp) {
        if (index_tmp == -1) {
            return RString.EMPTY;
        }
        return new RString(String.valueOf(index_tmp + 1));
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
}
