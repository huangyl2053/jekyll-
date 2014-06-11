/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011.SearchHihokenshashoHakkoTaishoshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証発行対象者検索Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class SearchHihokenshashoHakkoTaishosha {

    /**
     * 被保険者証発行対象者検索条件画面-初期処理を表します。
     *
     * @param panel SearchHihokenshashoHakkoTaishoshaDiv
     * @return ResponseData
     */
    public ResponseData<SearchHihokenshashoHakkoTaishoshaDiv> onLoad(
            SearchHihokenshashoHakkoTaishoshaDiv panel) {
        ResponseData<SearchHihokenshashoHakkoTaishoshaDiv> response = new ResponseData<>();

        setInitData(panel);

        response.data = panel;
        return response;

    }

    /*
     *被保険者証発行対象者検索情報を設定します。
     */
    private void setInitData(SearchHihokenshashoHakkoTaishoshaDiv panel) {

        List<HashMap> hihokenshashoHakkoTaishoshaList = YamlLoader.FOR_DBU.loadAsList(
                new RString("dbu0410011/HihokenshashoHakkoTaishoshaList.yml"));

        HashMap hashMap = hihokenshashoHakkoTaishoshaList.get(0);
        ControlGenerator ymlData = new ControlGenerator(hashMap);
        panel.getSearchHihokenshashoHakkoTaishoshaCommonJoho().getTxtSearchShimei().
                setValue(ymlData.getAsRString("searchShimei"));

        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(new RString("0"), RString.EMPTY));
        for (int i = 1; i < hihokenshashoHakkoTaishoshaList.size(); i++) {
            hashMap = hihokenshashoHakkoTaishoshaList.get(i);
            ymlData = new ControlGenerator(hashMap);

            dataSource.add(new KeyValueDataSource(new RString(String.valueOf(i)), ymlData.getAsRString("shimei")));
        }

        panel.getSearchHihokenshashoHakkoTaishoshaMaeShorisha().getDdlMaeShirishaRireki().
                setDataSource(dataSource);
        panel.getSearchHihokenshashoHakkoTaishoshaMaeShorisha().getDdlMaeShirishaRireki().
                setSelectedItem(new RString(("0")));
    }
}
