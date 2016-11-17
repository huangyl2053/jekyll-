/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200014;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200014.KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource;

/**
 * 仮算定額変更通知書発行一覧表ボディEditorです。
 *
 * @reamsid_L DBB-0820-060 xuyue
 */
class KariSanteigakuHenkoTsuchishoHakkoIchiranBodyEditor implements IKariSanteigakuHenkoTsuchishoHakkoIchiranEditor {

    private final KariSanteigakuHenkoTsuchishoHakkoIchiranItem item;

    /**
     * コンストラクタです。
     *
     * @param item {@link KariSanteigakuHenkoTsuchishoHakkoIchiranItem}
     */
    public KariSanteigakuHenkoTsuchishoHakkoIchiranBodyEditor(KariSanteigakuHenkoTsuchishoHakkoIchiranItem item) {
        this.item = item;
    }

    @Override
    public KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource edit(KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource source) {
        return editBody(source);
    }

    private KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource editBody(KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource source) {

        source.listLower_1 = item.getListLower_1();
        source.listLower_2 = item.getListLower_2();
        source.listLower_3 = item.getListLower_3();
        source.listLower_4 = item.getListLower_4();
        source.listLower_5 = item.getListLower_5();
        source.listLower_6 = item.getListLower_6();
        source.listUpper_1 = item.getListUpper_1();
        source.listUpper_2 = item.getListUpper_2();
        source.listUpper_3 = item.getListUpper_3();
        source.listUpper_4 = item.getListUpper_4();
        source.listUpper_5 = item.getListUpper_5();
        source.listUpper_6 = item.getListUpper_6();
        source.listUpper_7 = item.getListUpper_7();
        source.listUpper_8 = item.getListUpper_8();
        source.listUpper_9 = item.getListUpper_9();
        source.listUpper_10 = item.getListUpper_10();
        source.listUpper_11 = item.getListUpper_11();

        set改頁(source);

        return source;
    }

    private void set改頁(KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource source) {
        source.banchiCode = item.getBanchiCode();
        source.choikiCode = item.getChoikiCode();
        source.gyoseikuCode = item.getGyoseikuCode();
        source.chikuCode1 = item.getChikuCode1();
        source.chikuCode2 = item.getChikuCode2();
        source.chikuCode3 = item.getChikuCode3();
        source.shikibetsuCode = item.getShikibetsuCode();
        source.kanaMeisho = item.getKanaMeisho();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.nenkinCode = item.getNenkinCode();
        source.nokumiCode = item.getNokumiCode();
        source.seihoFlag = item.getSeihoFlag();
        source.seinengappiYMD = item.getSeinengappiYMD();
        source.seibetsuCode = item.getSeibetsuCode();
    }

}
