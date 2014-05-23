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
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuKanrihyoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgKyufuKanrihyoList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;

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
        List<HashMap> sourceList = YamlLoader.FOR_DBC.loadAsList(new RString("KyufuKanrihyoList.yml"));
        dgList = bindYamlData(dgList, sourceList);
        Collections.sort(dgList, new DateComparator());
        panel.getDgKyufuKanrihyoList().setDataSource(dgList);
    }

    private List<dgKyufuKanrihyoList_Row> bindYamlData(List<dgKyufuKanrihyoList_Row> dgList, List<HashMap> sourceList) {
        dgList.clear();
        Button btn = new Button();
        for (HashMap source : sourceList) {
            String taishoYMInvisible = source.get("対象年月Invisible").toString();
            String taishoYM = source.get("対象年月").toString();
            String sakuseiKubun = source.get("作成区分").toString();
            String hokenshaNo = source.get("保険者番号").toString();
            String hokenshaName = source.get("保険者名").toString();
            String jigyosha = source.get("事業者").toString();
            String shinsaYMD = source.get("審査年月日").toString();
            dgList.add(create給付管理票(btn, taishoYMInvisible, taishoYM, sakuseiKubun, hokenshaNo, hokenshaName, jigyosha, shinsaYMD));
        }
        return dgList;
    }

    private class DateComparator implements Comparator<dgKyufuKanrihyoList_Row> {

        @Override
        public int compare(dgKyufuKanrihyoList_Row o1, dgKyufuKanrihyoList_Row o2) {
            return o2.getTxtTaishoYMInvisible().getValue().compareTo(o1.getTxtTaishoYMInvisible().getValue());
        }
    }

    private dgKyufuKanrihyoList_Row create給付管理票(
            Button btnSelect,
            String txtTaishoYMInvisible,
            String txtTaishoYM,
            String txtSakuseiKubun,
            String txtHihoNo,
            String txtHihokenshaName,
            String txtJigyosha,
            String txtShinsaYM
    ) {
        TextBoxDate txtBoxDate = new TextBoxDate();
        txtBoxDate.setValue(new RDate(txtTaishoYMInvisible));

        return new dgKyufuKanrihyoList_Row(
                btnSelect,
                txtBoxDate,
                new RString(txtTaishoYM),
                new RString(txtSakuseiKubun),
                new RString(txtHihoNo),
                new RString(txtHihokenshaName),
                new RString(txtJigyosha),
                new RString(txtShinsaYM)
        );
    }
}
