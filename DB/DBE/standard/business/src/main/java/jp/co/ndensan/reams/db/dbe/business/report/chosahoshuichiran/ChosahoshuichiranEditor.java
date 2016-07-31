/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshuichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahoshushokai.NinteiChosaHoshuShokaiCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshuichiran.ChosahoshuichiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 認定調査報酬一覧表のEditorです。
 *
 * @reamsid_L DBE-1940-030 jinjue
 */
public class ChosahoshuichiranEditor implements IChosahoshuichiranEditor {

    private final NinteiChosaHoshuShokaiCsvEntity item;
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");

    /**
     * NinteiChosaHoshuShokaiCsvEntity インスタンスを生成します。
     *
     * @param item NinteiChosaHoshuShokaiFlowBusiness
     */
    protected ChosahoshuichiranEditor(NinteiChosaHoshuShokaiCsvEntity item) {
        this.item = item;
    }

    /**
     * 認定調査報酬一覧表の帳票を編集します。
     *
     * @param source ChosahoshuichiranReportSource
     * @return ChosahoshuichiranReportSource
     */
    @Override
    public ChosahoshuichiranReportSource edit(ChosahoshuichiranReportSource source) {
        return editSource(source);
    }

    private ChosahoshuichiranReportSource editSource(ChosahoshuichiranReportSource source) {
        source.chosaHoshuSakuseiYM = RDate.getNowDate().wareki()
                .eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
        if (0 < item.get在宅_初合計()) {
            source.listGokei_1 = new RString(item.get在宅_初合計());
            source.listGokei_2 = new RString(item.get在宅_再合計());
            source.listGokei_3 = new RString(item.get施設_初合計());
            source.listGokei_4 = new RString(item.get施設_再合計());
            source.listGokei_5 = new RString(item.get認定調査委託料()).concat("円");
        }
        source.listchosasakuseiryo_1 = new RString(Integer.toString(item.get番号()));
        source.listchosasakuseiryo_2 = item.get調査員_コード();
        source.listchosasakuseiryo_3 = item.get調査員_氏名();
        source.listchosasakuseiryo_4 = item.get依頼日().wareki().toDateString();
        source.listchosasakuseiryo_5 = item.get調査日().wareki().toDateString();
        source.listchosasakuseiryo_6 = item.get入手日().wareki().toDateString();
        source.listchosasakuseiryo_7 = item.get調査_再();
        source.listchosasakuseiryo_8 = item.get保険者();
        source.listchosasakuseiryo_9 = item.get申請者_被保険者番号();
        source.listchosasakuseiryo_10 = item.get申請者_氏名();
        source.listchosasakuseiryo_11 = item.get在宅_初();
        source.listchosasakuseiryo_12 = item.get在宅_再();
        source.listchosasakuseiryo_13 = item.get施設_初();
        source.listchosasakuseiryo_14 = item.get施設_再();
        source.listchosasakuseiryo_15 = item.get委託料();
        source.chosaItakusakiNo = item.get調査機関コード();
        source.chosaItakusakiName = item.get調査機関名();
        source.chushutsuKikan = new RStringBuilder(item.get調査依頼日開始()).append("～").append(item.get調査依頼日終了()).toRString();
        source.printTimeStamp = new RStringBuilder(get作成年月日時()).append(RString.HALF_SPACE).append("作成").toRString();
        return source;
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
