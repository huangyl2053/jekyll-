/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource;

/**
 * 特別徴収平準化_仮算定額変更通知書_発行一覧表ヘッダEditorです。
 *
 * @reamsid_L DBB-0820-060 xuyue
 */
class TokuChoHeijunkaKariSanteigakuHakkoIchiranHeaderEditor implements ITokuChoHeijunkaKariSanteigakuHakkoIchiranEditor {

    private final TokuChoHeijunkaKariSanteigakuHakkoIchiranItem item;

    protected TokuChoHeijunkaKariSanteigakuHakkoIchiranHeaderEditor(TokuChoHeijunkaKariSanteigakuHakkoIchiranItem item) {
        this.item = item;

    }

    @Override
    public TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource edit(TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource source) {
        return editHeader(source);
    }

    private TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource editHeader(TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource source) {

        source.printTimeStamp = item.getPrintTimeStamp();
        source.nendo = item.getNendo();
        source.hokenshaNo = item.getHokenshaNo();
        source.hokenshaName = item.getHokenshaName();
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
