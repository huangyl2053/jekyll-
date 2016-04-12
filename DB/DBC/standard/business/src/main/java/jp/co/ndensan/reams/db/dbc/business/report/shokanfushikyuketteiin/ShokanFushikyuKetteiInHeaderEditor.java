/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanfushikyuketteiin;

import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanfushikyuketteiin.ShokanbaraiFushikyuKetteishaIchiranSource;

/**
 * 帳票設計_DBC200022_償還払不支給決定者一覧表 ShokanFushikyuKetteiInHeaderEditor
 *
 * @reamsid_L DBC-2590-040 xuhao
 */
public class ShokanFushikyuKetteiInHeaderEditor implements IShokanFushikyuKetteiInEditor {

    private final ShokanFushikyuKetteiInItem item;

    /**
     * コンストラクタです
     *
     * @param item ShokanFushikyuKetteiInItem
     */
    protected ShokanFushikyuKetteiInHeaderEditor(ShokanFushikyuKetteiInItem item) {
        this.item = item;
    }

    @Override
    public ShokanbaraiFushikyuKetteishaIchiranSource edit(ShokanbaraiFushikyuKetteishaIchiranSource source) {
        source.printTimeStamp = item.get印刷日時();
        source.kokuhorenName = item.get国保連合会名();
        source.hokenshaNo = item.get保険者番号();
        source.hokenshaName = item.get保険者名称();
        source.shutsuryokujun1 = item.get並び順１();
        source.shutsuryokujun2 = item.get並び順２();
        source.shutsuryokujun3 = item.get並び順３();
        source.shutsuryokujun4 = item.get並び順４();
        source.shutsuryokujun5 = item.get並び順５();
        source.kaipage1 = item.get改頁１();
        source.kaipage2 = item.get改頁２();
        source.kaipage3 = item.get改頁３();
        source.kaipage4 = item.get改頁４();
        source.kaipage5 = item.get改頁５();
        return source;
    }

}
