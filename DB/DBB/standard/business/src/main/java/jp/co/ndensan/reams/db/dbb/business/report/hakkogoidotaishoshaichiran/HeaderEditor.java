/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hakkogoidotaishoshaichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.hakkogoidotaishoshaichiran.HakkogoIdoTaishoshaIchiranSource;

/**
 * 通知書発行後異動把握帳票HeaderEditor
 */
public class HeaderEditor implements IHakkogoIdoTaishoshaIchiranEditor {

    private final HakkogoIdoTaishoshaIchiranItem item;

    /**
     * コンストラクタです
     *
     * @param item HakkogoIdoTaishoshaIchiranItem
     */
    public HeaderEditor(HakkogoIdoTaishoshaIchiranItem item) {
        this.item = item;
    }

    @Override
    public HakkogoIdoTaishoshaIchiranSource edit(HakkogoIdoTaishoshaIchiranSource source) {
        source.title = item.getTitle();
        source.hokenshaNo = item.getHokenshaNo();
        source.hokenshaName = item.getHokenshaName();
        source.printTimeStamp = item.getPrintTimeStamp();
        source.fukaNendo = item.getFukaNendo();
        source.tsuchishoName = item.getTsuchishoName();
        source.tsuchishoHakkoTimeStamp = item.getTsuchishoHakkoTimeStamp();
        source.lastCalculationTimeStamp = item.getLastCalculationTimeStamp();
        return source;
    }

}
