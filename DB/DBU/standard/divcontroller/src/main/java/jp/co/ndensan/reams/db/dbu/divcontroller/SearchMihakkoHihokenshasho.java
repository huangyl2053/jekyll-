/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0400011.SearchMihakkoHihokenshashoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 被保険者証一括発行検索条件Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class SearchMihakkoHihokenshasho {

    /**
     * 未発行検索条件画面の初期処理を表します。
     *
     * @param panel SearchMihakkoHihokenshashoDiv
     * @return ResponseData
     */
    public ResponseData<SearchMihakkoHihokenshashoDiv> onLoad(SearchMihakkoHihokenshashoDiv panel) {
        ResponseData<SearchMihakkoHihokenshashoDiv> response = new ResponseData<>();

        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(new RString("nenreiTotatsu"), new RString("65歳年齢到達者")));
        dataSource.add(new KeyValueDataSource(new RString("jukiIdo"), new RString("住基異動対象者")));
        dataSource.add(new KeyValueDataSource(new RString("yokaigoNintei"), new RString("要介護認定者")));
        panel.getChkHakkoTaishoSearchCondition().setSelectedItems(dataSource);

        response.data = panel;
        return response;

    }

}
