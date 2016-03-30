package jp.co.ndensan.reams.db.dba.business.report.hihokenshadaichohakkoichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaichohakkoichiranhyo.HihokenshaDaichoHakkoIchiranhyoReportSource;

/**
 *
 * 被保険者台帳一覧表エディターのインターフェースクラスです。
 */
public class HihokenshaDaichoHakkoIchiranhyoHeaderEditor implements IHihokenshaDaichoHakkoIchiranhyoEditor {

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

        source.printTimeStamp = headerItem.getPrintTimeStamp();
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
}
