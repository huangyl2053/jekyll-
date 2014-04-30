/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.HihokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteiKekkaNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NyuryokuSeigyoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定結果入力画面の制御を行います。
 *
 * @author N1013 松本直樹
 */
public class NinteiKekkaNyuryoku {

    /**
     * 認定結果入力用Divの初期表示情報を編集します。
     *
     * @param ninteiKekkaNyuryokuDiv 認定結果入力Div
     * @return 認定結果入力Div編集結果情報
     */
    public ResponseData getOnloadData(NinteiKekkaNyuryokuDiv ninteiKekkaNyuryokuDiv) {
        ResponseData<NinteiKekkaNyuryokuDiv> response = new ResponseData<>();

//        ninteiKekkaNyuryokuDiv.getTxtShinseibi().setValue(new RDate("2014/04/01"));
//        ninteiKekkaNyuryokuDiv.getTxtShinseiKubunShinsei().setValue(new RString("更新"));
//        ninteiKekkaNyuryokuDiv.getTxtIchijiHanteiKekka().setValue(new RString("要支援２"));
//        ninteiKekkaNyuryokuDiv.getTxtNinteibi().setValue(RDate.getNowDate().toDateString());
//        ninteiKekkaNyuryokuDiv.getDdlNijiHanteiKekka().setSelectedItem(RString.EMPTY);
//        ninteiKekkaNyuryokuDiv.getTxtNinteiYukoKikanStart().setValue(new RString("2014/06/01"));
//        ninteiKekkaNyuryokuDiv.getTxtNinteiYukoKikanEnd().setValue(new RString("2016/05/31"));
        //       ninteiKekkaNyuryokuDiv.getDdlNinteiYukoTsukisu().setSelectedItem(new RString("２４ヶ月"));
//        ninteiKekkaNyuryokuDiv.getDdlNinteiYukoTsukisu().setSelectedItem(RString.EMPTY);
        response.data = ninteiKekkaNyuryokuDiv;
        return response;
    }

    /**
     * 要介護認定有効期間月数選択時、有効期間終了日の編集を行います。
     *
     * @param ninteiKekkaNyuryokuDiv 認定結果入力用Div
     * @return 認定結果入力Div編集結果
     */
    public ResponseData ddlNinteiYukoTsukisuSelect(NinteiKekkaNyuryokuDiv ninteiKekkaNyuryokuDiv) {
        ResponseData<NinteiKekkaNyuryokuDiv> response = new ResponseData<>();

        if (ninteiKekkaNyuryokuDiv.getDdlNinteiYukoTsukisu().getSelectedValue().equalsIgnoreCase("６ヶ月")) {
            ninteiKekkaNyuryokuDiv.getTxtNinteiYukoKikanEnd().setValue(new FlexibleDate("2014/12/31"));
        } else if (ninteiKekkaNyuryokuDiv.getDdlNinteiYukoTsukisu().getSelectedValue().equalsIgnoreCase("１２ヶ月")) {
            ninteiKekkaNyuryokuDiv.getTxtNinteiYukoKikanEnd().setValue(new FlexibleDate("2015/05/31"));
        } else if (ninteiKekkaNyuryokuDiv.getDdlNinteiYukoTsukisu().getSelectedValue().equalsIgnoreCase("２４ヶ月")) {
            ninteiKekkaNyuryokuDiv.getTxtNinteiYukoKikanEnd().setValue(new FlexibleDate("2016/05/31"));
        }

        response.data = ninteiKekkaNyuryokuDiv;
        return response;

    }

    public ResponseData ddlNinteiKubunSelect(NinteiKekkaNyuryokuDiv ninteiKekkaNyuryokuDiv) {
        ResponseData<NinteiKekkaNyuryokuDiv> response = new ResponseData<>();

        if (ninteiKekkaNyuryokuDiv.getDdlNinteiKubun().getSelectedValue().equalsIgnoreCase("再調査")) {
            ninteiKekkaNyuryokuDiv.getDdlNijiHanteiKekka().setDisabled(true);
        }

        response.data = ninteiKekkaNyuryokuDiv;
        return response;

    }

    public ResponseData ddlNijiHanteiKekkaSelect(NinteiKekkaNyuryokuDiv ninteiKekkaNyuryokuDiv) {
        ResponseData<NinteiKekkaNyuryokuDiv> response = new ResponseData<>();

        if (ninteiKekkaNyuryokuDiv.getDdlNijiHanteiKekka().getSelectedValue().equalsIgnoreCase(new RString("非該当"))) {
            ninteiKekkaNyuryokuDiv.getTxtNinteiYukoKikanStart().setValue(FlexibleDate.EMPTY);
            ninteiKekkaNyuryokuDiv.getTxtNinteiYukoKikanStart().setDisabled(true);
            ninteiKekkaNyuryokuDiv.getTxtNinteiYukoKikanEnd().setValue(FlexibleDate.EMPTY);
            response.data = ninteiKekkaNyuryokuDiv;
        } else {
            ninteiKekkaNyuryokuDiv.getTxtNinteiYukoKikanStart().setValue(new FlexibleDate("2014/06/01"));
            ninteiKekkaNyuryokuDiv.getTxtNinteiYukoKikanStart().setDisabled(false);
            ninteiKekkaNyuryokuDiv.getTxtNinteiYukoKikanEnd().setValue(new FlexibleDate("2016/05/31"));
            response = ddlNinteiYukoTsukisuSelect(ninteiKekkaNyuryokuDiv);
        }

        return response;

    }

}
