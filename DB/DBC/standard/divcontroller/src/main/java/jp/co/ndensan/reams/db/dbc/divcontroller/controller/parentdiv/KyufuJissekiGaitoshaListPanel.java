/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1400011.KyufuJissekiGaitoshaListPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1400011.dgHihokenshaSearchGaitosha_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.SearchToKyufujissekiPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 *
 * @author n8223
 * @author n8223 ymldata, SearchToKyufujissekiPanelDiv 追加　2014.06.20 park
 */
public class KyufuJissekiGaitoshaListPanel {

//    private static final RString MESSAGE = new RString("該当するデータが0件です");
    /**
     * 介護給付費過誤申立書登録 給付実積該当一覧の内容をセットします。
     *
     * @param panel KyufuJissekiGaitoshaListPanelDiv
     * @param srchpanel
     * @return PanelDivのResponseData
     */
    public ResponseData<KyufuJissekiGaitoshaListPanelDiv> onClick_btnSearch(
            KyufuJissekiGaitoshaListPanelDiv panel, SearchToKyufujissekiPanelDiv srchpanel) {

        //給付実積該当一覧の内容を設定する。
        setKyufuJissekiGaitoshaList(panel, srchpanel);

        return ResponseData.of(panel).respond();
    }

    /*
     * 介護給付費過誤申立書登録 給付実積該当一覧のデータを設定する。
     */
    private void setKyufuJissekiGaitoshaList(
            KyufuJissekiGaitoshaListPanelDiv panel, SearchToKyufujissekiPanelDiv srchpanel) {
        List<dgHihokenshaSearchGaitosha_Row> arraydata = createRowKyufuJissekiGaitoshaTestData(srchpanel);

        DataGrid<dgHihokenshaSearchGaitosha_Row> grid = panel.getDgHihokenshaSearchGaitosha();
        grid.setDataSource(arraydata);
    }

    /*
     * 介護給付費過誤申立書登録 (YMLDATA)給付実積該当一覧のデータを設定する。
     */
    private List<dgHihokenshaSearchGaitosha_Row> createRowKyufuJissekiGaitoshaTestData(SearchToKyufujissekiPanelDiv srchpanel) {
        List<dgHihokenshaSearchGaitosha_Row> arrayData = new ArrayList<>();
        arrayData.add(new dgHihokenshaSearchGaitosha_Row());
        return arrayData;
    }

    /*
     *引数を元にデータグリッド内に挿入する個人データを作成します。
     */
//    private dgHihokenshaSearchGaitosha_Row createRowKyufuJissekiGaitoshaListData(
//            RString jigyoshaNo,
//            RString jigyoshaName,
//            RString hihoNo,
//            RString hihoName,
//            RString kagoForm,
//            RString teikyoYM,
//            RString kyufuJissekiSakuseiKubun,
//            RString kyufuKubun,
//            RString shinsaYM
//    ) {
//
//        dgHihokenshaSearchGaitosha_Row rowKyufuJissekiGaitoshaListData;
//        rowKyufuJissekiGaitoshaListData = new dgHihokenshaSearchGaitosha_Row(
//                new Button(),
//                Boolean.FALSE,
//                RString.EMPTY,
//                RString.EMPTY,
//                RString.EMPTY,
//                RString.EMPTY,
//                RString.EMPTY,
//                RString.EMPTY,
//                RString.EMPTY,
//                RString.EMPTY,
//                RString.EMPTY
//        );
//
//        rowKyufuJissekiGaitoshaListData.setTxtJigyoshaNo(jigyoshaNo);
//        rowKyufuJissekiGaitoshaListData.setTxtJigyoshaName(jigyoshaName);
//        rowKyufuJissekiGaitoshaListData.setTxtHihoNo(hihoNo);
//        rowKyufuJissekiGaitoshaListData.setTxtHihoName(hihoName);
//        rowKyufuJissekiGaitoshaListData.setTxtKagoForm(kagoForm);
//        rowKyufuJissekiGaitoshaListData.setTxtTeikyoYM(teikyoYM);
////        rowKyufuJissekiGaitoshaListData.setTxtTeikyoYM(setWareki(teikyoYM.toDateString()).substring(0, 6));
//        rowKyufuJissekiGaitoshaListData.setTxtKyufuJissekiSakuseiKubun(kyufuJissekiSakuseiKubun);
//        rowKyufuJissekiGaitoshaListData.setTxtKyufuKubun(kyufuKubun);
//        rowKyufuJissekiGaitoshaListData.setTxtShinsaYM(shinsaYM);
//
//        return rowKyufuJissekiGaitoshaListData;
//    }
    /**
     * 介護給付費過誤申立書登録 過誤申立書情報を確定するボタンを押下後、申立者作成の内容をチェック有り。
     *
     * @param panel KyufuJissekiGaitoshaListPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<KyufuJissekiGaitoshaListPanelDiv> onClick_btnSettle(
            KyufuJissekiGaitoshaListPanelDiv panel, SearchToKyufujissekiPanelDiv srchpanel) {
        ResponseData<KyufuJissekiGaitoshaListPanelDiv> response = new ResponseData<>();

        //給付実積該当一覧の内容を設定する。
        dgHihokenshaSearchGaitosha_Row clickRow = panel.getDgHihokenshaSearchGaitosha().getClickedItem();
        //チェックを設定する。
        clickRow.setChkCreateMoshitatesho(Boolean.TRUE);

        //2014.07.02 朴　追加  （保存ボタン）活性化する。
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("cbtSaveElement1"), false);

        response.data = panel;
        return response;
    }

    /**
     * 介護給付費過誤申立書登録 過誤申立書情報をやめるボタンを押下後、申立者作成の内容をチェックなし。
     *
     * @param panel KyufuJissekiGaitoshaListPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<KyufuJissekiGaitoshaListPanelDiv> onClick_btnCancel(
            KyufuJissekiGaitoshaListPanelDiv panel, SearchToKyufujissekiPanelDiv srchpanel) {
        ResponseData<KyufuJissekiGaitoshaListPanelDiv> response = new ResponseData<>();

        //給付実積該当一覧の内容を設定する。
        dgHihokenshaSearchGaitosha_Row clickRow = panel.getDgHihokenshaSearchGaitosha().getClickedItem();

        clickRow.setChkCreateMoshitatesho(Boolean.FALSE);

        response.data = panel;
        return response;
    }
}
