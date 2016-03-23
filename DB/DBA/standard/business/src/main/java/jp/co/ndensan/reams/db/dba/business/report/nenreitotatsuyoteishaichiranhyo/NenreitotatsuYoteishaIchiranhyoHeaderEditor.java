/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.nenreitotatsuyoteishaichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.nenreitotatsuyoteishaichiranhyo.NenreitotatsuYoteishaIchiranhyoReportSource;

/**
 * 年齢到達予定者一覧表ヘッダEditorです。
 */
class NenreitotatsuYoteishaIchiranhyoHeaderEditor implements INenreitotatsuYoteishaIchiranhyoEditor {

    private final NenreitotatsuYoteishaIchiranhyoHeadItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link NenreitotatsuYoteishaIchiranhyoHeadItem}
     */
    protected NenreitotatsuYoteishaIchiranhyoHeaderEditor(NenreitotatsuYoteishaIchiranhyoHeadItem item) {
        this.item = item;
    }

    @Override
    public NenreitotatsuYoteishaIchiranhyoReportSource edit(NenreitotatsuYoteishaIchiranhyoReportSource source) {
        return editHeader(source);
    }

    private NenreitotatsuYoteishaIchiranhyoReportSource editHeader(NenreitotatsuYoteishaIchiranhyoReportSource source) {
        source.printTimeStamp = item.getPrintTimeStamp();
        source.shichosonCode = item.getShichosonCode();
        source.shichosonName = item.getShichosonName();
        source.shutsuryokujun1 = item.getShutsuryokujun1();
        source.shutsuryokujun2 = item.getShutsuryokujun2();
        source.shutsuryokujun3 = item.getShutsuryokujun3();
        source.shutsuryokujun4 = item.getShutsuryokujun4();
        source.shutsuryokujun5 = item.getShutsuryokujun5();
        source.kaipage1 = item.getKaipage1();
        source.kaipage2 = item.getKaipage2();
        source.kaipage3 = item.getKaipage3();
        source.kaipage4 = item.getKaipage4();
        source.kaipage5 = item.getKaipage5();
        return source;
    }
}
