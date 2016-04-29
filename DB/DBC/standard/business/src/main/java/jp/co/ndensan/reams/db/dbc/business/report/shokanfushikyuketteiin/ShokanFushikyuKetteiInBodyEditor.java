/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanfushikyuketteiin;

import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanfushikyuketteiin.ShokanbaraiFushikyuKetteishaIchiranSource;

/**
 * 帳票設計_DBC200022_償還払不支給決定者一覧表 ShokanFushikyuKetteiInBodyEditor
 *
 * @reamsid_L DBC-2590-040 xuhao
 */
public class ShokanFushikyuKetteiInBodyEditor implements IShokanFushikyuKetteiInEditor {

    private final ShokanFushikyuKetteiInItem item;

    /**
     * コンストラクタです
     *
     * @param item ShokanFushikyuKetteiInItem
     */
    protected ShokanFushikyuKetteiInBodyEditor(ShokanFushikyuKetteiInItem item) {
        this.item = item;
    }

    @Override
    public ShokanbaraiFushikyuKetteishaIchiranSource edit(ShokanbaraiFushikyuKetteishaIchiranSource source) {
        source.listUpper_1 = item.get通知書番号();
        source.listUpper_2 = item.get被保険者番号();
        source.listUpper_3 = item.get被保険者氏名();
        source.listUpper_4 = item.get事業者番号();
        source.listUpper_5 = item.get事業者名();
        source.listUpper_6 = item.getサービス提供年月();
        source.listUpper_7 = item.get単位数();
        source.listUpper_8 = item.get喪失事由();
        source.listUpper_9 = item.get備考１();
        source.listLower_1 = item.get整理番号();
        source.listLower_2 = item.get住所コード();
        source.listLower_3 = item.get住所();
        source.listLower_4 = item.get行政区コード();
        source.listLower_5 = item.get行政区();
        source.listLower_6 = item.getサービス種類();
        source.listLower_7 = item.get喪失年月日();
        source.listLower_8 = item.get備考２();
        source.listDBKoshinUmu_1 = item.get更新DB無();
        return source;
    }
}
