/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshojissekiichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshojissekiichiran.IkenshoJissekiIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.ikenshojissekiichiran.IkenshoJissekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 主治医意見書作成実績集計表のEditorです。
 *
 * @reamsid_L DBE-1690-040 dongyabin
 */
public class IkenshoJissekiIchiranEditor implements IIkenshoJissekiIchiranEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 作成 = new RString("作成");
    private final IkenshoJissekiIchiranEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item NinteichosaIraiHenkoData
     */
    protected IkenshoJissekiIchiranEditor(IkenshoJissekiIchiranEntity item) {
        this.item = item;
    }

    @Override
    public IkenshoJissekiIchiranReportSource edit(IkenshoJissekiIchiranReportSource source) {
        return editSource(source);
    }

    private IkenshoJissekiIchiranReportSource editSource(IkenshoJissekiIchiranReportSource source) {
        source.printTimeStamp = get作成年月日時();
        source.listIkenshoJissekiIchiran_1 = item.get保険者番号();
        source.listIkenshoJissekiIchiran_2 = item.get医療機関コード();
        source.listIkenshoJissekiIchiran_3 = item.get医療機関名称();
        source.listIkenshoJissekiIchiran_4 = item.get主治医氏名();
        source.listIkenshoJissekiIchiran_5 = item.get被保険者番号();
        source.listIkenshoJissekiIchiran_6 = item.get申請者氏名();
        source.listIkenshoJissekiIchiran_7 = item.get記入日();
        source.listIkenshoJissekiIchiran_8 = item.get入手日();
        source.listIkenshoJissekiIchiran_9 = item.get入手パターン_在新();
        source.listIkenshoJissekiIchiran_10 = item.get入手パターン_在継();
        source.listIkenshoJissekiIchiran_11 = item.get入手パターン_施新();
        source.listIkenshoJissekiIchiran_12 = item.get入手パターン_施継();
        source.listIkenshoJissekiIchiran_13 = item.get医師区分();
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
