/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranReportSource;

/**
 * 特別徴収平準化_仮算定額変更通知書_発行一覧表ボディEditorです。
 */
class TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranBodyEditor implements ITokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranEditor {

    private final TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranItem item;

    public TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranBodyEditor(TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranItem item) {

        this.item = item;
    }

    @Override
    public TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranReportSource edit(TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranReportSource source) {
        return editBody(source);
    }

    private TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranReportSource editBody(TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranReportSource source) {

        source.listUpper_1 = item.getListUpper_1();
        source.listUpper_2 = item.getListUpper_2();
        source.listUpper_3 = item.getListUpper_3();
        source.listUpper_4 = item.getListUpper_4();
        source.listUpper_5 = item.getListUpper_5();
        source.listUpper_6 = item.getListUpper_6();
        source.listUpper_7 = item.getListUpper_7();
        source.listUpper_8 = item.getListUpper_8();
        source.listUpper_9 = item.getListUpper_9();
        source.listLower_1 = item.getListLower_1();
        source.listLower_2 = item.getListLower_2();
        source.listLower_3 = item.getListLower_3();
        source.listLower_4 = item.getListLower_4();
        source.listLower_5 = item.getListLower_5();
        source.listLower_6 = item.getListLower_6();
        source.listLower_7 = item.getListLower_7();
        source.listLower_8 = item.getListLower_8();
        return source;
    }

}
