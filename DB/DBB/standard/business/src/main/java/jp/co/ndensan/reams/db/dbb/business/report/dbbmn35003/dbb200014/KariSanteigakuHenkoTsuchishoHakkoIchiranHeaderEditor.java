/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200014;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200014.KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource;

/**
 * 仮算定額変更通知書発行一覧表ヘッダEditorです。
 *
 * @reamsid_L DBB-0820-060 xuyue
 */
class KariSanteigakuHenkoTsuchishoHakkoIchiranHeaderEditor implements IKariSanteigakuHenkoTsuchishoHakkoIchiranEditor {

    private final KariSanteigakuHenkoTsuchishoHakkoIchiranItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JukiRendoTorokuListItem}
     */
    public KariSanteigakuHenkoTsuchishoHakkoIchiranHeaderEditor(KariSanteigakuHenkoTsuchishoHakkoIchiranItem item) {
        this.item = item;
    }

    @Override
    public KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource edit(KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource source) {
        return editHeader(source);
    }

    private KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource editHeader(KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource source) {

        source.printTimeStamp = item.getPrintTimeStamp();
        source.nendo = item.getNendo();
        source.hokenshaNo = item.getHokenshaNo();
        source.hokenshaName = item.getHokenshaName();
        source.shutsuryokujun1 = item.getShutsuryokujun1();
        source.shutsuryokujun2 = item.getShutsuryokujun2();
        source.shutsuryokujun3 = item.getShutsuryokujun3();
        source.shutsuryokujun4 = item.getShutsuryokujun4();
        source.shutsuryokujun5 = item.getShutsuryokujun5();
        source.hyojicodeName1 = item.getHyojicodeName1();
        source.hyojicodeName2 = item.getHyojicodeName2();
        source.hyojicodeName3 = item.getHyojicodeName3();

        return source;
    }

}
