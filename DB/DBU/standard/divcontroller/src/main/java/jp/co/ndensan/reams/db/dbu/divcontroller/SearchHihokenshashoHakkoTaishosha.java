/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011.SearchHihokenshashoHakkoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
//import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
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
     * @param panel SearchHihokenshashoHakkoDiv
     * @return ResponseData
     */
    public ResponseData<SearchHihokenshashoHakkoDiv> onLoad(
            SearchHihokenshashoHakkoDiv panel) {
        ResponseData<SearchHihokenshashoHakkoDiv> response = new ResponseData<>();

        setInitData(panel);

        response.data = panel;
        return response;

    }

    /**
     * 被保険者証発行画面-「該当者一覧に戻る」ボタン押下時の処理を表します。
     *
     * @param panel SearchHihokenshashoHakkoDiv
     * @return ResponseData
     */
    public ResponseData<SearchHihokenshashoHakkoDiv> onClick_btnToReSearch(
            SearchHihokenshashoHakkoDiv panel) {
        ResponseData<SearchHihokenshashoHakkoDiv> response = new ResponseData<>();

        //該当者一覧パネルをオープン
        panel.getCcdHihokenshashoHakkoTaishoGaitosha().setIsOpen(true);

        response.data = panel;
        return response;

    }

    /*
     *被保険者証発行対象者検索情報を設定します。
     */
    private void setInitData(SearchHihokenshashoHakkoDiv panel) {

        List<HashMap> hihokenshashoHakkoTaishoshaList = YamlLoader.DBU.loadAsList(
                new RString("dbu0410011/HihokenshashoHakkoTaishoshaList.yml"));

        HashMap hashMap = hihokenshashoHakkoTaishoshaList.get(0);
        ControlGenerator ymlData = new ControlGenerator(hashMap);

        //検索キー氏名の初期値設定
        panel.getCcdSearchHihokenshashoHakkoTaishosha().getSearchCriteriaOfKojin().getTxtShimei().
                setValue(ymlData.getAsRString("searchShimei"));

        //前方一致を初期選択とする
        panel.getCcdSearchHihokenshashoHakkoTaishosha().getSearchCriteriaOfKojin().getRadSearchPatternOfShimei().setSelectedItem(new RString("key0"));

//        //最近処理対象者の設定
//        List<KeyValueDataSource> dataSource = new ArrayList<>();
//        dataSource.add(new KeyValueDataSource(new RString("0"), RString.EMPTY));
//        for (int i = 1; i < hihokenshashoHakkoTaishoshaList.size(); i++) {
//            hashMap = hihokenshashoHakkoTaishoshaList.get(i);
//            ymlData = new ControlGenerator(hashMap);
//
//            dataSource.add(new KeyValueDataSource(new RString(String.valueOf(i)), ymlData.getAsRString("shimei")));
//        }
//
//        panel.getCcdSearchHihokenshashoHakkoTaishosha().getDdlSaikinShorisha().setDataSource(dataSource);
//        panel.getCcdSearchHihokenshashoHakkoTaishosha().getDdlSaikinShorisha().setSelectedItem(new RString("0"));
    }
}
