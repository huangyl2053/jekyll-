package jp.co.ndensan.reams.db.dba.business.report.hihokenshadaichohakkoichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaichohakkoichiranhyo.HihokenshaDaichoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 被保険者台帳一覧表エディターのインターフェースクラスです。
 *
 * @reamsid_L DBA-0510-070 wangxiaodong
 */
public class HihokenshaDaichoHakkoIchiranhyoHeaderEditor implements IHihokenshaDaichoHakkoIchiranhyoEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString DATE_作成 = new RString("作成");
    private final HihokenshaDaichoHakkoIchiranhyoHeaderItem headerItem;

    /**
     * インスタンスを生成します。
     *
     * @param headerItem 被保険者台帳一覧表ヘッダーItem
     */
    public HihokenshaDaichoHakkoIchiranhyoHeaderEditor(HihokenshaDaichoHakkoIchiranhyoHeaderItem headerItem) {
        this.headerItem = headerItem;
    }

    @Override
    public HihokenshaDaichoHakkoIchiranhyoReportSource edit(HihokenshaDaichoHakkoIchiranhyoReportSource source) {
        return editHeader(source);
    }

    private HihokenshaDaichoHakkoIchiranhyoReportSource editHeader(HihokenshaDaichoHakkoIchiranhyoReportSource source) {

        source.printTimeStamp = getNowDate();
        source.shichosonCode = headerItem.getShichosonCode();
        source.shichosonName = headerItem.getShichosonName();
        source.shutsuryokujun1 = headerItem.getShutsuryokujun1();
        source.shutsuryokujun2 = headerItem.getShutsuryokujun2();
        source.shutsuryokujun3 = headerItem.getShutsuryokujun3();
        source.shutsuryokujun4 = headerItem.getShutsuryokujun4();
        source.shutsuryokujun5 = headerItem.getShutsuryokujun5();
        source.kaipage1 = headerItem.getKaipage1();
        source.kaipage2 = headerItem.getKaipage2();
        source.kaipage3 = headerItem.getKaipage3();
        source.kaipage4 = headerItem.getKaipage4();
        source.kaipage5 = headerItem.getKaipage5();
        return source;
    }

    private RString getNowDate() {
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStamp = new RStringBuilder(printdate.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
        printTimeStamp.append(RString.HALF_SPACE);
        printTimeStamp.append(String.format("%02d", printdate.getHour()));
        printTimeStamp.append(DATE_時);
        printTimeStamp.append(String.format("%02d", printdate.getMinute()));
        printTimeStamp.append(DATE_分);
        printTimeStamp.append(String.format("%02d", printdate.getSecond()));
        printTimeStamp.append(DATE_秒);
        printTimeStamp.append(RString.HALF_SPACE);
        printTimeStamp.append(DATE_作成);

        return printTimeStamp.toRString();
    }
}
