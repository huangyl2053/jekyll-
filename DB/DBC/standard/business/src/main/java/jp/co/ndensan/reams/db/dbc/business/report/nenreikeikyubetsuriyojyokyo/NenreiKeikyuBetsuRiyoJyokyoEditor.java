/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.nenreikeikyubetsuriyojyokyo;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikeikyubetsuriyojyokyo.NenreiKeikyuBetsuRiyoJyokyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.nenreikeikyubetsuriyojyokyo.NenreiKeikyuBetsuRiyoJyokyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 年齢階級別利用状況作成 Editorクラスです。
 *
 * @reamsid_L DBE-3470-040 dongyabin
 */
public class NenreiKeikyuBetsuRiyoJyokyoEditor implements INenreiKeikyuBetsuRiyoJyokyoEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private final NenreiKeikyuBetsuRiyoJyokyoEntity data;

    /**
     * コンストラクタです。
     *
     * @param data 給付費通知減免補正一覧表パラメータ
     */
    public NenreiKeikyuBetsuRiyoJyokyoEditor(NenreiKeikyuBetsuRiyoJyokyoEntity data) {
        this.data = data;
    }

    /**
     * 年齢階級別利用状況作成の項目編集です
     *
     * @param source NenreiKeikyuBetsuRiyoJyokyoSource
     * @return NenreiKeikyuBetsuRiyoJyokyoSource
     */
    @Override
    public NenreiKeikyuBetsuRiyoJyokyoReportSource edit(NenreiKeikyuBetsuRiyoJyokyoReportSource source) {
        source.printTimeStamp = get印刷日時(data.get印刷日時());
        source.hokenshaNo = data.get保険者番号();
        source.hokenshaName = data.get保険者名();
        source.pageCount1 = data.getページ数();
        source.joken1 = dateFormat(data.get条件1());
        source.joken2 = data.get条件2();
        source.serviceMei1 = data.getサービス種類名称1();
        source.list1_1 = data.get区分_1();
        source.list1_2 = kinngakuFormat(data.get非該当_1());
        source.list1_3 = kinngakuFormat(data.get要支援１_1());
        source.list1_4 = kinngakuFormat(data.get要支援２_1());
        source.list1_5 = kinngakuFormat(data.get経過的要支援_1());
        source.list1_6 = kinngakuFormat(data.get要介護１_1());
        source.list1_7 = kinngakuFormat(data.get要介護２_1());
        source.list1_8 = kinngakuFormat(data.get要介護３_1());
        source.list1_9 = kinngakuFormat(data.get要介護４_1());
        source.list1_10 = kinngakuFormat(data.get要介護５_1());
        source.list1_11 = kinngakuFormat(data.get合計_1());
        // TODO QA
//        source.list1_12 = data.get備考_1();
        source.serviceMei2 = data.getサービス種類名称2();
        source.list2_1 = data.get区分_2();
        source.list2_2 = kinngakuFormat(data.get非該当_2());
        source.list2_3 = kinngakuFormat(data.get要支援１_2());
        source.list2_4 = kinngakuFormat(data.get要支援２_2());
        source.list2_5 = kinngakuFormat(data.get経過的要支援_2());
        source.list2_6 = kinngakuFormat(data.get要介護１_2());
        source.list2_7 = kinngakuFormat(data.get要介護２_2());
        source.list2_8 = kinngakuFormat(data.get要介護３_2());
        source.list2_9 = kinngakuFormat(data.get要介護４_2());
        source.list2_10 = kinngakuFormat(data.get要介護５_2());
        source.list2_11 = kinngakuFormat(data.get合計_2());
//        source.list2_12 = data.get備考_2();

        return source;
    }

    private RString get印刷日時(RDateTime printdate) {
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
        return printTimeStampSb.toRString();
    }

    private RString kinngakuFormat(RString date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(new Decimal(date.toString()), 0);
    }

    private RString dateFormat(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        return new RDate(date.toString()).wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

}
