/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0610011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 福祉用具購入費支給申請審査 未審査支給申請一覧のパネルです。
 *
 * @author n8223 朴
 */
public class YoguKonyuhiShikyuShinseiMishinsaSearchPanel {

    private final int 却下 = 3;
    /*
     * 福祉用具購入費支給申請審査 申請一覧情報を表示する。
     */

    public ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> onLoad(YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv panel) {
        //初期表示はしない
//        setSearchCondition(panel);
        set審査日(panel);
        setMishinsaShikyuShinseiData(panel);

        return ResponseData.of(panel).respond();
    }

    /*
     * 福祉用具購入費支給申請審査 未審査支給申請一覧情報を表示する。
     */
    public ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> onClick_btnSearchMishinsa(
            YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv panel) {

        //panelは閉じているのでオンロード時にデータをセットしておくrequestSettingにセットしない
        set審査日(panel);
        setMishinsaShikyuShinseiData(panel);

        return ResponseData.of(panel).respond();
    }

    /*
     * 福祉用具購入費支給申請審査 選択された未審査支給申請一覧情報をもとに、
     * 支給申請内容を一括審査するボタンを押下後、審査結果の内容をセットされる。
     */
    public ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> onClick_btnIkkatsuShinsa(
            YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv panel) {
        List<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> selectedMishinsaShikyuShinsei = panel.getYoguKonyuhiShikyuShinseiMishinsaResultList()
                .getDgYoguKonyuhiShisaMishinsaShikyuShinseiList().getSelectedItems();

        //TO DO 2014.5.19 承認却下区分
        for (int i = 0; i < selectedMishinsaShikyuShinsei.size(); i++) {
            dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row mishinsaShikyuShinseiList_Row = selectedMishinsaShikyuShinsei.get(i);
            if (i == 却下) {
                mishinsaShikyuShinseiList_Row.getTxtShinsaResult().setValue(new RString("却下：種目重複"));
                mishinsaShikyuShinseiList_Row.getTxtShinsaResult().getValue();
            } else {
                mishinsaShikyuShinseiList_Row.getTxtShinsaResult().setValue(new RString("承認"));
            }
        }

        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnSave"), false);

        return ResponseData.of(panel).respond();
    }

    public ResponseData<YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv> onClick_btnModifyShinsei(
            YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv panel) {

        panel.getYoguKonyuhiShikyuShinseiMishinsaResultList().getDgYoguKonyuhiShisaMishinsaShikyuShinseiList()
                .getDataSource().get(却下).setRowState(RowState.Modified);
        panel.getYoguKonyuhiShikyuShinseiMishinsaResultList().getDgYoguKonyuhiShisaMishinsaShikyuShinseiList()
                .getDataSource().get(却下).getTxtShinsaResult().setValue(new RString("承認"));

        return ResponseData.of(panel).respond();
    }

    private void setSearchCondition(YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv panel) {

//        ControlGenerator cg = new ControlGenerator(targetSource.get(0));
//        panel.getYoguKonyuhiShikyuShinseiMishinsaSearchCondition().getTxtShikyuShinseiDateRange().setFromValue(cg.getAsRDate("検索開始日"));
//        panel.getYoguKonyuhiShikyuShinseiMishinsaSearchCondition().getTxtShikyuShinseiDateRange().setToValue(cg.getAsRDate("検索終了日"));
    }

    private void set審査日(YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv panel) {
        panel.getYoguKonyuhiShikyuShinseiMishinsaResultList().getTxtShinsaDate().setValue(RDate.getNowDate());
    }

    /**
     * 福祉用具購入費支給申請審査 未審査支給申請一覧情報を表示する。
     *
     * @param panel YoguKonyuhiShikyuShinseiMishinsaResultListDiv
     * @return PanelDivのResponseData
     */
    private void setMishinsaShikyuShinseiData(YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv panel) {
        panel.getYoguKonyuhiShikyuShinseiMishinsaResultList().getDgYoguKonyuhiShisaMishinsaShikyuShinseiList().setDataSource(getMishinsaShikyuShinseiData());
    }

    private List<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> getMishinsaShikyuShinseiData() {
        List<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> list = new ArrayList<>();
//        for (Map info : targetSource) {
//            list.add(toDgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row(info));
//        }
        return list;
    }

    private static dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row toDgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row(Map map) {
        ControlGenerator cg = new ControlGenerator(map);

        dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row row = new dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row(
                cg.getAsTextBoxDate("shikyuShinseiDate"),
                cg.getAsTextBoxDate("teikyoYM"),
                cg.getAsTextBoxCode("hihoNo"),
                cg.getAsTextBox("hihokenshaName"),
                cg.getAsTextBoxNum("hokenKyufuAmount"),
                cg.getAsTextBoxNum("riyoshaFutanAmount"),
                cg.getAsTextBoxNum("hiyoTotalAmount"),
                new TextBox(),
                cg.getAsTextBox("seiriNo"));
        return row;
    }
}
