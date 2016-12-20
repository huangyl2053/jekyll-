/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 認定調査依頼発行一覧表ヘッダEditorです。
 *
 * @reamsid_L DBE-0080-110 yaodongsheng
 */
class ChosaIraiHakkoIchiranhyoHeaderEditor implements IChosaIraiHakkoIchiranhyoEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 作成 = new RString("作成");
    private static final RString BUNKATSU = new RString("～");
    private static final RString 依頼日 = new RString("調査依頼日");
    private static final RString 調査員 = new RString("調査員登録者のみ");
    private static final RString FLG_1 = new RString("1");
    private static final RString FLG_2 = new RString("2");
    private static final RString 未印刷_1 = new RString("未印刷を出力する");
    private static final RString 印刷済_2 = new RString("印刷済を出力する");
    private final ChosaIraiHakkoIchiranhyoHeadItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosaIraiHakkoIchiranhyoHeadItem}
     */
    protected ChosaIraiHakkoIchiranhyoHeaderEditor(ChosaIraiHakkoIchiranhyoHeadItem item) {
        this.item = item;
    }

    @Override
    public ChosaIraiHakkoIchiranhyoReportSource edit(ChosaIraiHakkoIchiranhyoReportSource source) {
        return editHeader(source);
    }

    private ChosaIraiHakkoIchiranhyoReportSource editHeader(ChosaIraiHakkoIchiranhyoReportSource source) {

        RStringBuilder printTimeStampSb = new RStringBuilder();
        RDateTime printdate = RDateTime.now();
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
        printTimeStampSb.append(作成);
        source.printTimeStamp = printTimeStampSb.toRString();
        source.joken0 = 依頼日;
        RStringBuilder nichi = new RStringBuilder();
        if (item.get依頼日From() == null && item.get依頼日To() == null) {
            source.joken1 = RString.EMPTY;
        } else {
            source.joken1 = nichi.append(item.get依頼日From() == null ? RString.EMPTY : new FlexibleDate(
                    item.get依頼日From()).wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString()).append(BUNKATSU).append(
                            item.get依頼日To() == null ? RString.EMPTY : new FlexibleDate(
                                    item.get依頼日To()).wareki().eraType(EraType.KANJI)
                            .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                            .fillType(FillType.BLANK).toDateString()).toRString();
        }

        source.joken2 = 調査員;
        if (FLG_1.equals(item.get認定調査依頼書FLG())) {
            source.joken3 = 未印刷_1;
        } else if (FLG_2.equals(item.get認定調査依頼書FLG())) {
            source.joken3 = 印刷済_2;
        }
        return source;
    }
}
