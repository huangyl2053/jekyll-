/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hakkogoidotaishoshaichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.hakkogoidotaishoshaichiran.HakkogoIdoTaishoshaIchiranSource;

/**
 * 通知書発行後異動把握帳票BodyEditor
 */
public class BodyEditor implements IHakkogoIdoTaishoshaIchiranEditor {

    private final HakkogoIdoTaishoshaIchiranItem item;

    protected BodyEditor(HakkogoIdoTaishoshaIchiranItem item) {
        this.item = item;
    }

    @Override
    public HakkogoIdoTaishoshaIchiranSource edit(HakkogoIdoTaishoshaIchiranSource source) {
        source.listIdosha_1 = item.getListIdosha_1();
        source.listIdosha_2 = item.getListIdosha_2();
        source.listIdosha_3 = item.getListIdosha_3();
        source.listIdosha_4 = item.getListIdosha_4();
        source.listIdosha_5 = item.getListIdosha_5();
        source.listIdosha_6 = item.getListIdosha_6();
        source.listIdosha_7 = item.getListIdosha_7();
        return source;
    }
}
