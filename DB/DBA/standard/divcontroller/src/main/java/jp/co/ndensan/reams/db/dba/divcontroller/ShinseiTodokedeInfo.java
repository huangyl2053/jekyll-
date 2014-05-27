/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dgHihokenshaSearchGaitosha_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.HihokenshaSearchGaitoshaPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.ShinseiTodokedeInfoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dgShinseishoTodokede_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8178 城間篤人
 */
public class ShinseiTodokedeInfo {
    //TODO n8178 城間篤人 当DIVは、後日共有子DIV化を予定。 2014年5月

    /**
     * Divに対して値を設定します。
     *
     * @param detailPanel 被保険者詳細パネル
     * @param gaitoshaPanel 被保険者検索該当者パネル
     * @return response
     */
    public ResponseData<ShinseiTodokedeInfoDiv> getOnLoadDivData(ShinseiTodokedeInfoDiv detailPanel, HihokenshaSearchGaitoshaPanelDiv gaitoshaPanel) {
        ResponseData<ShinseiTodokedeInfoDiv> response = new ResponseData<>();

        RString 名称 = get該当者情報(gaitoshaPanel).getShimei();
        setShinseiJohoGrid(detailPanel, 名称);

        response.data = detailPanel;
        return response;
    }

    /**
     * 申請情報タブパネル内のグリッドに表示するデータを作成して、引数から渡したタブにセットします。
     *
     * @param tab タブ
     * @param 名称　名称
     */
    private void setShinseiJohoGrid(ShinseiTodokedeInfoDiv detailPanel, RString 名称) {
        List<dgShinseishoTodokede_Row> list = createShinseiJohoList(名称);
        detailPanel.getDgShinseishoTodokede().setDataSource(list);
        detailPanel.setVisible(!list.isEmpty());
    }

    private List<dgShinseishoTodokede_Row> createShinseiJohoList(RString 名称) {
        List<dgShinseishoTodokede_Row> list = new ArrayList<>();
        dgShinseishoTodokede_Row item;

        if (名称.equals(new RString("電算太郎"))) {
            item = createShinseiJohoData("20100808", "140012", "介護");
            list.add(item);
        } else if (名称.equals(new RString("喜屋武三郎"))) {
            item = createShinseiJohoData("20080123", "122890", "介護");
            list.add(item);
            item = createShinseiJohoData("20071104", "112010", "介護");
            list.add(item);
        }

        return list;
    }

    private dgShinseishoTodokede_Row createShinseiJohoData(String 届出日, String 申請書管理番号, String 届出種別) {
        dgShinseishoTodokede_Row row = new dgShinseishoTodokede_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY);
        row.setTodokedeYMD(new RString(届出日));
        row.setShinseishoKanriNo(new RString(申請書管理番号));
        row.setTodokedeShubetsu(new RString(届出種別));
        return row;
    }

    private dgHihokenshaSearchGaitosha_Row get該当者情報(HihokenshaSearchGaitoshaPanelDiv gaitoshaPanel) {
        dgHihokenshaSearchGaitosha_Row gaitoshaGrid;
        if (check未選択(gaitoshaPanel)) {
            gaitoshaGrid = gaitoshaPanel.getDgHihokenshaSearchGaitosha().getDataSource().get(0);
        } else {
            gaitoshaGrid = gaitoshaPanel.getDgHihokenshaSearchGaitosha().getSelectedItems().get(0);
        }
        return gaitoshaGrid;
    }

    private boolean check未選択(HihokenshaSearchGaitoshaPanelDiv gaitoshaPanel) {
        return gaitoshaPanel.getDgHihokenshaSearchGaitosha().getSelectedItems().isEmpty();
    }

}
