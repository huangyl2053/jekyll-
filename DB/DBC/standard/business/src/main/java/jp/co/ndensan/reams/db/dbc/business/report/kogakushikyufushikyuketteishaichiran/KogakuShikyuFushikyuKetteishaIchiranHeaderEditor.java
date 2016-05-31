/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteishaichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyufushikyuketteishaichiran.KogakuShikyuFushikyuKetteishaIchiranSource;

/**
 * 高額サービス費支給（不支給）決定者一覧表帳票HeaderEditor
 *
 * @reamsid_L DBC-0980-500 surun
 */
public class KogakuShikyuFushikyuKetteishaIchiranHeaderEditor implements IKogakuShikyuFushikyuKetteishaIchiranEditor {

    private final KogakuShikyuFushikyuKetteishaIchiranItem item;

    /**
     * コンストラクタです
     *
     * @param item KogakuShikyuFushikyuKetteishaIchiranItem
     */
    public KogakuShikyuFushikyuKetteishaIchiranHeaderEditor(KogakuShikyuFushikyuKetteishaIchiranItem item) {
        this.item = item;
    }

    @Override
    public KogakuShikyuFushikyuKetteishaIchiranSource edit(KogakuShikyuFushikyuKetteishaIchiranSource source) {
        source.printTimeStamp = item.get印刷日時();
        source.kokuhorenName = item.get国保連合会名();
        return source;
    }

}
