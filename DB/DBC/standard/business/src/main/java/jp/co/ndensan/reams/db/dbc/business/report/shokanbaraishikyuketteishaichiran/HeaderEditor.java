/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyuketteishaichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanbaraishikyuketteishaichiran.ShokanbaraiShikyuKetteishaIchiranSource;

/**
 * 償還払支給決定者一覧表帳票HeaderEditor
 */
public class HeaderEditor implements IShokanbaraiShikyuKetteishaIchiranEditor {

    private final ShokanbaraiShikyuKetteishaIchiranItem item;

    /**
     * コンストラクタです
     *
     * @param item ShokanbaraiShikyuKetteishaIchiranItem
     */
    public HeaderEditor(ShokanbaraiShikyuKetteishaIchiranItem item) {
        this.item = item;
    }

    @Override
    public ShokanbaraiShikyuKetteishaIchiranSource edit(ShokanbaraiShikyuKetteishaIchiranSource source) {
        source.printTimeStamp = item.getPrintTimeStamp();
        source.kokuhorenName = item.getKokuhorenName();
        return source;
    }

}
