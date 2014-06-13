/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0060000.KyufuKanrihyoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0060000.dgKyufuKanrihyoList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 給付管理票情報照会の検索Panelのコントロールクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyufuKanrihyoList {

    /**
     * KyufuKanrihyoSerachで検索ボタンが押された時の処理。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickSearch(KyufuKanrihyoListDiv panel) {
        ResponseData<KyufuKanrihyoListDiv> response = new ResponseData<>();
        setDemoData(panel);
        response.data = panel;
        return response;
    }

    /**
     * 再検索ボタン押下時の処理。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickResearch(KyufuKanrihyoListDiv panel) {
        ResponseData<KyufuKanrihyoListDiv> response = new ResponseData<>();
        List<dgKyufuKanrihyoList_Row> dgList = panel.getDgKyufuKanrihyoList().getDataSource();
        dgList.clear();
        panel.getDgKyufuKanrihyoList().setDataSource(dgList);
        response.data = panel;
        return response;
    }

    private void setDemoData(KyufuKanrihyoListDiv panel) {
        List<dgKyufuKanrihyoList_Row> dgList = panel.getDgKyufuKanrihyoList().getDataSource();
        List<HashMap> sourceList = YamlLoader.FOR_DBC.loadAsList(new RString("dbc0060000/KyufuKanrihyoList.yml"));
        dgList = bindYamlData(dgList, sourceList);
        Collections.sort(dgList, new DateComparator());
        panel.getDgKyufuKanrihyoList().setDataSource(dgList);
    }

    private List<dgKyufuKanrihyoList_Row> bindYamlData(List<dgKyufuKanrihyoList_Row> dgList, List<HashMap> sourceList) {
        dgList.clear();
        Button btn = new Button();
        for (HashMap source : sourceList) {
            dgList.add(create給付管理票(btn,
                    source.get("対象年月").toString(),
                    source.get("作成区分").toString(),
                    source.get("保険者番号").toString(),
                    source.get("保険者名").toString(),
                    source.get("事業者").toString(),
                    source.get("審査年月日").toString()));
        }
        return dgList;
    }

    private static class DateComparator implements Comparator<dgKyufuKanrihyoList_Row> {

        @Override
        public int compare(dgKyufuKanrihyoList_Row o1, dgKyufuKanrihyoList_Row o2) {
            return new FlexibleDate(o2.getTxtTaishoYM().replace(".", "").concat("01")).compareTo(new FlexibleDate(o1.getTxtTaishoYM().replace(".", "").concat("01")));
        }
    }

    private dgKyufuKanrihyoList_Row create給付管理票(
            Button btnSelect,
            String txtTaishoYM,
            String txtSakuseiKubun,
            String txtHihoNo,
            String txtHihokenshaName,
            String txtJigyosha,
            String txtShinsaYM
    ) {
        return new dgKyufuKanrihyoList_Row(
                btnSelect,
                new RString(txtTaishoYM),
                new RString(txtSakuseiKubun),
                new RString(txtHihoNo),
                new RString(txtHihokenshaName),
                new RString(txtJigyosha),
                new RString(txtShinsaYM)
        );
    }
}
