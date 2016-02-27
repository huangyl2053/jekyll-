/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.report.dbe521002;

import jp.co.ndensan.reams.db.dbe.entity.report.dbe521002.NiteiGyomuShinchokuJokyoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 *
 * 要介護認定業務進捗状況一覧表ヘッダEditorです。
 */
public class NiteiGyomuShinchokuJokyoIchiranhyoHeadEditor implements INiteiGyomuShinchokuJokyoIchiranhyoEditor {
    
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString DATE_作成 = new RString("作成");
    private static final RString 帳票名 = new RString("介護保険　認定業務進捗状況一覧表");

    
    /**
     * インスタンスを生成します。
     */
    protected NiteiGyomuShinchokuJokyoIchiranhyoHeadEditor() {
    }
    
    /**
     * 要介護認定業務進捗状況一覧表ヘッダEditorです。
     * @param source 要介護認定業務進捗状況一覧表Source
     * @return 要介護認定業務進捗状況一覧表Source
     */
    @Override
    public NiteiGyomuShinchokuJokyoIchiranhyoReportSource edit(NiteiGyomuShinchokuJokyoIchiranhyoReportSource source) {
        return editHeader(source);
    }
    
    private NiteiGyomuShinchokuJokyoIchiranhyoReportSource editHeader(NiteiGyomuShinchokuJokyoIchiranhyoReportSource source) {
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
        printTimeStampSb.append(DATE_作成);
        source.printTimeStamp = printTimeStampSb.toRString();
        source.title = 帳票名;
        return source;
    }
}
