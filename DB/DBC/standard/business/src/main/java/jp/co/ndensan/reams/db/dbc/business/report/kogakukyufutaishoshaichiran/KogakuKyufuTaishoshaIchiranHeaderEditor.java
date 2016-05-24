/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakukyufutaishoshaichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakukyufutaishoshaichiran.KogakuKyufuTaishoshaIchiranSource;

/**
 * 高額介護サービス費給付対象者一覧表帳票HeaderEditor
 *
 * @reamsid_L DBC-0980-490 surun
 */
public class KogakuKyufuTaishoshaIchiranHeaderEditor implements IKogakuKyufuTaishoshaIchiranEditor {

    private final KogakuKyufuTaishoshaIchiranItem item;

    /**
     * コンストラクタです
     *
     * @param item KogakuKyufuTaishoshaIchiranItem
     */
    public KogakuKyufuTaishoshaIchiranHeaderEditor(KogakuKyufuTaishoshaIchiranItem item) {
        this.item = item;
    }

    @Override
    public KogakuKyufuTaishoshaIchiranSource edit(KogakuKyufuTaishoshaIchiranSource source) {
        source.printTimeStamp = item.get作成日時();
        source.kokuhorenName = item.get送付元団体名();
        return source;
    }

}
