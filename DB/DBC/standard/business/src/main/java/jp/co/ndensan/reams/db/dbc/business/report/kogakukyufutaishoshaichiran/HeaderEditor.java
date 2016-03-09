/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakukyufutaishoshaichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakukyufutaishoshaichiran.KogakuKyufuTaishoshaIchiranSource;

/**
 * 高額介護サービス費給付対象者一覧表帳票HeaderEditor
 */
public class HeaderEditor implements IKogakuKyufuTaishoshaIchiranEditor {

    private final KogakuKyufuTaishoshaIchiranItem item;

    /**
     * コンストラクタです
     *
     * @param item KogakuKyufuTaishoshaIchiranItem
     */
    public HeaderEditor(KogakuKyufuTaishoshaIchiranItem item) {
        this.item = item;
    }

    @Override
    public KogakuKyufuTaishoshaIchiranSource edit(KogakuKyufuTaishoshaIchiranSource source) {
        source.printTimeStamp = item.getPrintTimeStamp();
        source.kokuhorenName = item.getKokuhorenName();
        return source;
    }

}
