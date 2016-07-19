/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshohoshushokai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshushokai.IkenHoshuIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.ikenhoshuichiran.IkenHoshuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 主治医意見書作成報酬実績集計表のEditorです。
 *
 * @reamsid_L DBE-1930-010 chenxiangyu
 */
public class IkenHoshuIchiranHeadEditor implements IIkenHoshuIchiranEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 作成 = new RString("作成");
    private final IkenHoshuIchiranEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item 主治医意見書作成報酬Entity
     */
    protected IkenHoshuIchiranHeadEditor(IkenHoshuIchiranEntity item) {
        this.item = item;
    }

    @Override
    public IkenHoshuIchiranReportSource edit(IkenHoshuIchiranReportSource source) {
        return editSource(source);
    }

    private IkenHoshuIchiranReportSource editSource(IkenHoshuIchiranReportSource source) {
        source.printTimeStamp = get作成年月日時秒();
        source.title = new RString("主治医意見書作成料一覧");
        source.iryokikanNo = item.get医療機関番号();
        source.iryokikanName = item.get医療機関名();
        source.chushutsuKikan = item.get抽出期間();
        return source;
    }

    private RString get作成年月日時秒() {
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
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
