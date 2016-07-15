/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ichosahyojissekiichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyojissekiichiran.ChosahyoJissekiIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.chosahyojissekiichiran.ChosahyoJissekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 帳票出力用認定調査実績集計表Builderクラスです。
 *
 * @reamsid_L DBE-1691-030 dangjingjing
 */
public class ChosahyoJissekiIchiranEditor implements IChosahyoJissekiIchiranEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 作成 = new RString("作成");
    private final ChosahyoJissekiIchiranEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item NinteichosaIraiHenkoData
     */
    protected ChosahyoJissekiIchiranEditor(ChosahyoJissekiIchiranEntity item) {
        this.item = item;
    }

    @Override
    public ChosahyoJissekiIchiranReportSource edit(ChosahyoJissekiIchiranReportSource source) {
        return editSource(source);
    }

    private ChosahyoJissekiIchiranReportSource editSource(ChosahyoJissekiIchiranReportSource source) {
        source.printTimeStamp = get作成年月日時();
        source.listChosaJissekiIchiran_1 = item.get調査機関コード();
        source.listChosaJissekiIchiran_2 = item.get調査機関名称();
        source.listChosaJissekiIchiran_3 = item.get調査員氏名();
        source.listChosaJissekiIchiran_4 = item.get被保険者番号();
        source.listChosaJissekiIchiran_5 = item.get申請者氏名();
        source.listChosaJissekiIchiran_6 = item.get調査実施日();
        source.listChosaJissekiIchiran_7 = item.get調査区分();
        source.listChosaJissekiIchiran_8 = item.get訪問の種類();
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
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(作成);
        return printTimeStampSb.toRString();
    }

}
